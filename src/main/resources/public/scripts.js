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


};

$(document).ready(function() {
    tic.init();
});