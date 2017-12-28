document.addEventListener('DOMContentLoaded', startApp);

function startApp() {
    sliderController.createInstance();
    checkboxController.createInstance();
    dateController.createInstance();
    minDate.setMinDate();
    //itemsRenderer.createInstance();

    //pagination.createInstance();
}
