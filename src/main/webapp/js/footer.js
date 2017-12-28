function changeLanguage(element) {
    let language = element.value.toLowerCase();
    let data = "locale=" + element.value + "&command=change_locale";
    $.ajax({
        type: "GET",
        url: "/ajaxController",
        data: data,
        dataType: "json",

        success: function (data, textStatus, jqXHR) {
           window.location.reload();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error in changing locale" + textStatus);
        },
        beforeSend: function (jqXHR, settings) {
        },
        complete: function (jqXHR, textStatus) {
        }
    });
}

