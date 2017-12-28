let incorrectBalance;
document.addEventListener('DOMContentLoaded', func);
function func() {
    incorrectBalance = document.querySelector('#incorrect-balance');
    incorrectBalance.style.display = "none";
    document.querySelector('.button').style.display = "block";
};
function validateBalance() {
    let elements = document.querySelectorAll('.wrong-info');
    let i;
    for (i = 0; i < elements.length; i++) {
        elements.item(i).style.display = "none";
    }
    const balance = Number(document.querySelector('#balance').value);
    if (!checkBalance()) {
        return event.preventDefault();
    }
    else {
        document.querySelector('.button').style.display = "none";
        document.querySelector('.button').setAttribute("disabled", true);
    }

    function checkBalance() {
        incorrectBalance.style.display = "none";
        let isValidBalance = false;
        if (!isNaN(balance) && (parseInt(balance) == balance) && balance >= 0 && balance <= 1000) {
            isValidBalance = true;
        }
        else {
            incorrectBalance.style.display = "block";
        }
        return isValidBalance;
    }
}