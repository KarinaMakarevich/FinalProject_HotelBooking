const minDate = (function () {
    let arrivalDate = document.querySelector('#date-arriving-input');
    let leavingDate = document.querySelector('#date-living-input');
    let date = new Date();
    const init = () => {
        let day = date.getDate();
        if (day < 10) {
            day = "0" + day;
        }
        arrivalDate.min = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + day;
        leavingDate.min = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + day;

    };
    return {
        setMinDate: init
    };

}());
