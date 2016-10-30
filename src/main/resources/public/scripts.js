tic = {
    currentPlayer: "X",
    init: function() {
        tic.resetGame();
        tic.bind();
    },
    bind: function() {
        // Bind click on tic-cell.
        $(".tic-cell").click(function(e) {
            if (!$(this).hasClass('checked') && !$(".tic-board").hasClass("disabled")) {
                tic.handleMove($(this).attr('data-value'));
                if (tic.currentPlayer == "X") {
                    $(this).addClass('cross checked');
                } else {
                    $(this).addClass('circle checked');
                }
                $(".tic-board").addClass("disabled");
            }
        });
        $("#tic-reset").click(function() {
            tic.resetGame();
        });
    },
    handleMove: function(cell) {
        // Handle cell clicked
        $.ajax({
            type: 'post',
            url: '/handleMove',
            data: 'cell=' + cell
        }).done(function(result) {
            if (result != "") {
                $("#tic-status").html(result);
            } else {
                tic.currentPlayer = tic.currentPlayer == "X" ? "O" : "X";
                tic.updateCurrentPlayerStatus();
                $(".tic-board").removeClass("disabled");
            }
        }).fail(function() {
            $("#tic-status").html("Error!").addClass("alert alert-danger");
        });
    },
    updateCurrentPlayerStatus: function() {
        // Update the current player
        $("#tic-status").html("It's your turn, " + tic.currentPlayer + "!");
    },
    resetGame: function() {
        $.ajax({
            type: 'post',
            url: '/resetGame'
        }).done(function(result) {
            $(".tic-cell").removeClass('cross circle checked');
            $(".tic-board").removeClass("disabled");
        }).fail(function() {
            $("#tic-status").html("Error!").addClass("alert alert-danger");
        });

        tic.currentPlayer = "X";
        tic.updateCurrentPlayerStatus();
    }
};

$(document).ready(function() {
    tic.init();
});