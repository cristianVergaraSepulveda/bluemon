function loginSucess(wleft, wtop) {
     
    var w = jq('$loginWin'), b = jq('$initBtn');
    //Minimize from the login Window
    jq('<div class="minimize" />').appendTo("body").css({
        left : wleft,
        top : wtop,
        width : w.width(),
        height : w.height()
    });
    //Minimize to the init Button
    p = b.offset();
    jq('.minimize').animate({
        left : p.left + b.width() / 2,
        top : p.top + b.height() / 2,
        width : 0,
        height : 0
    }, function() {
        jq(this).remove();
    });
}
function loginFaild() { //Shake the window
    var l = jq("$loginWin").position().left;
    jq("$loginWin").animate({
        left : l - 25
    }, 50).animate({
        backgroundColor : "red"
    }, 50).animate({
        left : l
    }, 50).animate({
        left : l + 25
    }, 50).animate({
        left : l
    }, 50).animate({
        backgroundColor : "white"
    }, 50);
    jq("$loginWin").css('background-color','transparent');
}