$(document).ready(function () {
    function listItem() {
        top_bar_item.each(function () {
            $(this).mouseover(function () {
                $(this).css("background-color","#2B3135");
            });
            $(this).mouseleave(function () {
                $(this).css("background-color","#373d41");
            })
        })
    }

    function showOutline() {
        input.mouseover(function () {
            $(".common-search-outline").css("opacity",1);
        });
        input.mouseleave(function () {
            $(".common-search-outline").css("opacity",0);
        })
    }


    var input = $(".common-search-input-elem");
    var top_bar_item =$(".list-item");
    showOutline();
    listItem();

});
