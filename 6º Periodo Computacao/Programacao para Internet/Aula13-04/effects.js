$("document").ready(function() {

    var segunda = true;

    $("#primeira").hide(1000);
    $("#segunda").hide();

    // $("#segunda").show(1000);
    // $("#primeira").show(1000);

    // $("#segunda").fadeOut(2000);

    // $("#segunda").fadeIn(1000);

    $("#primeira").fadeIn(2000, function() {
        $("#segunda").fadeIn(2000);
    });

    $("#primeira").click(function() {
        if (segunda) {
            $("#segunda").fadeOut(2000);
            segunda = false;
        }
        else{
            $("#segunda").fadeIn(2000);
            segunda = true;
        }
    });

    $("#segunda").click(function() {
        if (segunda) {
            $("#primeira").fadeOut(2000);
            segunda = false;
        }
        else{
            $("#primeira").fadeIn(2000);
            segunda = true;
        }
    });
});
