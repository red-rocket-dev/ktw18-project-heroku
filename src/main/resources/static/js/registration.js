$(document).ready(function () {
    $("#register").click(function () {
        var name = $("#name").val();

        $.post("/rest/product", {
            name: name
        });
    });
});