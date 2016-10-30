board = {
    currentPlayer: "X",
    init: function() {
        board.resetGame();
        board.bind();
    },
    bind: function() {
        // Bind click on board-cell.
        $(".board-cell").click(function(e) {
            if (!$(this).hasClass('checked') && !$(".board-board").hasClass("disabled")) {
                board.handleMove($(this).attr('data-value'));
                if (board.currentPlayer == "X") {
                    $(this).addClass('cross checked');
                } else {
                    $(this).addClass('circle checked');
                }
                $(".board-board").addClass("disabled");
            }
        });
        $("#board-reset").click(function() {
            board.resetGame();
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
                $("#board-status").html(result);
            } else {
                board.currentPlayer = board.currentPlayer == "X" ? "O" : "X";
                board.updateCurrentPlayerStatus();
                $(".board-board").removeClass("disabled");
            }
        }).fail(function() {
            $("#board-status").html("Error!").addClass("alert alert-danger");
        });
    },
    updateCurrentPlayerStatus: function() {
        // Update the current player
        $("#board-status").html("It's your turn, " + board.currentPlayer + "!");
    },
    resetGame: function() {
        $.ajax({
            type: 'post',
            url: '/resetGame'
        }).done(function(result) {
            $(".board-cell").removeClass('cross circle checked');
            $(".board-board").removeClass("disabled");
        }).fail(function() {
            $("#board-status").html("Error!").addClass("alert alert-danger");
        });

        board.currentPlayer = "X";
        board.updateCurrentPlayerStatus();
    }
};

$(document).ready(function() {
    board.init();
});

