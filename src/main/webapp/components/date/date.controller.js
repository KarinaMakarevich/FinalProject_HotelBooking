const dateController = (function () {
    const dateGroupContainer = document.querySelector('.date-group-container');
    let dates;

    const init = () => {
        dates = new Array(2).fill("");
        const dateInputs = document.querySelectorAll('.date-item');
        for (let [idx, dateInput] of dateInputs.entries()) {
            createDateInputBySelectorName('.' + dateInput.classList[1]);
        }

        dateGroupContainer.addEventListener('update', (event) => {
            dates[event.target.dataset.id] = event.detail.value;
        }, true);
    };

    const createDateInputBySelectorName = (selector) => {
        const dateInputContainer = document.querySelector(selector);
        const dateInput = document.querySelector(selector + ' input');

        dateInput.addEventListener('change', () => dateInputContainer.dispatchEvent(new CustomEvent('update', {
            detail: {
                value: dateInput.value
            }
        })));
    };

    const getDates = () => {
        return dates;
    };

    return {
        createInstance: init,
        getDates: getDates
    };
}());
