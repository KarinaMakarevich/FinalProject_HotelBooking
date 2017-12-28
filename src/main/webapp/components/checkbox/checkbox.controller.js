const checkboxController = (function () {
    let state;

    const init = () => {
        state = false;
        const checkbox = document.querySelector('.checkbox-wifi input');

        checkbox.addEventListener('click', (event) => {
            state = event.currentTarget.checked;
        });
    };

    const getState = () => {
        return state;
    };

    return {
        createInstance: init,
        getState: getState
    };
}());
