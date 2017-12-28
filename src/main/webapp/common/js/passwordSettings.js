let incorrectPassword;
let incorrectRepeatPassword;
document.addEventListener('DOMContentLoaded', func);
function func() {
    incorrectPassword = document.querySelector('#incorrect-password');
    incorrectRepeatPassword = document.querySelector('#incorrect-repeat-password');
    incorrectPassword.style.display = "none";
    incorrectRepeatPassword.style.display = "none";
    document.querySelector('.button').style.display = "block";
};
function validatePassword() {
    let elements = document.querySelectorAll('.wrong-info');
    let i;
    for (i = 0; i < elements.length; i++) {
        elements.item(i).style.display = "none";
    }
    const wordReqExp = /([A-Za-z]|[А-Яа-я]){2,25}/;
    const password = document.querySelector('#newPassword').value;
    const repeatPassword = document.querySelector('#repeat-password').value;
    let isValidInfo = true;
    if (!checkPassword()) {
        isValidInfo = false;
    }
    if (!checkPasswordEquality()) {
        isValidInfo = false;
    }
    if (!isValidInfo) {
        return event.preventDefault();
    }
    else {
        document.querySelector('.button').style.display = "none";
        document.querySelector('.button').setAttribute("disabled", true);
    }
    function checkPassword() {
        incorrectPassword.style.display = "none";
        let isValidPassword = false;
        let hasUpperCase = /[A-ZА-Я]/.test(password);
        let hasLowerCase = /[a-zа-я]/.test(password);
        let hasNumbers = /\d/.test(password);
        let hasValidLength = (password.length <= 25 && password.length >= 6);
        if (hasUpperCase && hasLowerCase && hasNumbers && hasValidLength) {
            isValidPassword = true;
        }
        else {
            incorrectPassword.style.display = "block";
        }
        return isValidPassword;
    }

    function checkPasswordEquality() {
        incorrectRepeatPassword.style.display = "none";
        let isEquals = false;
        if (password == repeatPassword) {
            isEquals = true;
        }
        else {
            incorrectRepeatPassword.style.display = "block";
        }
        return isEquals;
    }
};
