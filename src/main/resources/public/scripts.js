board = {
    currentPlayer: "X",
    init: function() {
        board.bind();
        board.resetGame();
    },
    bind: function() {
        // Bind click on board-cell.
        $(".board-cell").click(function(e) {
            if (!$(this).hasClass('checked') && !$(".board-board").hasClass("disabled")) {
                // Don't allow another move until the previous one has been handled.
                $(".board-board").addClass("disabled");

                if (board.currentPlayer == "X") {
                    $(this).addClass('cross checked');
                } else {
                    $(this).addClass('circle checked');
                }

                board.handleMove($(this).attr('data-value'));
            }
        });

        // Bind the reset game button click..
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
                $status = $("#board-status");
                if (result == "X has won!") {
                    $status.html(result).addClass('xwon');
                } else if (result == "O has won!") {
                    $status.html(result).addClass('owon');
                } else {
                    $status.html(result).addClass('tie');
                }
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
        $status = $("#board-status");
        $status.removeClass("xwon owon tie");
        $status.removeClass("alert alert-danger");

        $.ajax({
            type: 'post',
            url: '/resetGame'
        }).done(function() {
            $(".board-cell").removeClass('cross circle checked');
            $(".board-board").removeClass("disabled");
            board.currentPlayer = "X";
            board.updateCurrentPlayerStatus();
        }).fail(function() {
            $status.html("Error!").addClass("alert alert-danger");
        });
    }
};

$(document).ready(function() {
    board.init();
});