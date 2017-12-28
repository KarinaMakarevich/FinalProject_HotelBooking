let incorrectAge;
let incorrectName;
let incorrectSurname;
let incorrectCountry;
let incorrectEmail;
let incorrectLogin;
let incorrectPassword;
let incorrectRepeatPassword;
document.addEventListener('DOMContentLoaded', func);
function func() {
    incorrectAge = document.querySelector('#incorrect-age');
    incorrectName = document.querySelector('#incorrect-name');
    incorrectSurname = document.querySelector('#incorrect-surname');
    incorrectCountry = document.querySelector('#incorrect-country');
    incorrectEmail = document.querySelector('#incorrect-email');
    incorrectLogin = document.querySelector('#incorrect-login');
    incorrectPassword = document.querySelector('#incorrect-password');
    incorrectRepeatPassword = document.querySelector('#incorrect-repeat-password');
    incorrectAge.style.display = "none";
    incorrectName.style.display = "none";
    incorrectSurname.style.display = "none";
    incorrectCountry.style.display = "none";
    incorrectEmail.style.display = "none";
    incorrectLogin.style.display = "none";
    incorrectPassword.style.display = "none";
    incorrectRepeatPassword.style.display = "none";
    document.querySelector('.button').style.display = "block";
};
function validateForm() {
    let elements = document.querySelectorAll('.wrong-info');
    let i;
    for (i = 0; i < elements.length; i++) {
        elements.item(i).style.display = "none";
    }
    const wordReqExp = /([A-Za-z]|[А-Яа-я]){2,25}/;
    const emailReqExp = /[\w-]+[.\w-]*@[\w-]+[.\w-]+[a-zA-z]{2,}/;
    const loginReqExp = /\w{2,25}/;
    const age = Number(document.querySelector('#age').value);
    const name = document.querySelector('#name').value;
    const surname = document.querySelector('#surname').value;
    const country = document.querySelector('#country').value;
    const email = document.querySelector('#mail').value;
    const login = document.querySelector('#login').value;
    const password = document.querySelector('#password').value;
    const repeatPassword = document.querySelector('#repeat-password').value;
    let isValidInfo = true;
    if (!checkAge()) {
        isValidInfo = false;
    }
    if (!checkWord(name, incorrectName, wordReqExp)) {
        isValidInfo = false;
    }
    if (!checkWord(surname, incorrectSurname, wordReqExp)) {
        isValidInfo = false;
    }
    if (!checkWord(country, incorrectCountry, wordReqExp)) {
        isValidInfo = false;
    }
    if (!checkWord(email, incorrectEmail, emailReqExp)) {
        isValidInfo = false;
    }
    if (!checkWord(login, incorrectLogin, loginReqExp)) {
        isValidInfo = false;
    }
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
    function checkAge() {
        incorrectAge.style.display = "none";
        let isValidAge = false;
        if (!isNaN(age) && (parseInt(age) == age) && age >= 18 && age <= 100) {
            isValidAge = true;
        }
        else {
            incorrectAge.style.display = "block";
        }
        return isValidAge;
    }

    function checkWord(word, element, reqExp) {
        element.style.display = "none";
        let isValidWord = false;
        let isWord = reqExp.test(word);
        if (word && isWord) {
            isValidWord = true;
        }
        else {
            element.style.display = "block";
        }
        return isValidWord;
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
