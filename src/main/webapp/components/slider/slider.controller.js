const sliderController = (function () {
    const sliderThumbWidth = 15;
    let values;

    const init = () => {
        values = new Array(3).fill(1);
        values[2] = 500;
        const sliders = document.querySelectorAll('.slider-item');
        for (let [idx, slider] of sliders.entries()) {
            createSliderBySelectorName('.' + slider.classList[1]);
        }

        const slidersContainer = document.querySelector('.slider-group-container');
        slidersContainer.addEventListener('update', (event) => {
            values[event.target.dataset.id] = Number(event.detail.value);
        }, true);
    };

    const createSliderBySelectorName = (selector) => {
        const sliderContainer = document.querySelector(selector);
        const slider = document.querySelector(selector + ' input');
        const output = document.querySelector(selector + ' output');

        slider.addEventListener('input', () => setOutput(sliderContainer, slider, output));

        setOutput(sliderContainer, slider, output);
    };

    const setOutput = (sliderContainer, slider, output) => {
        output.innerHTML =  `${slider.value}`;
        sliderContainer.dispatchEvent(new CustomEvent('update', {
            detail: {
                value: slider.value
            }
        }));
    };

    const getValues = () => {
        return values;
    };

    return {
        createInstance: init,
        getValues: getValues
    };
}());
