let incorrectLogin;
document.addEventListener('DOMContentLoaded', func);
function func() {
    incorrectLogin = document.querySelector('#incorrect-login');
    incorrectLogin.style.display = "none";
    document.querySelector('.button').style.display = "block";
};
function validateLogin() {
    ;
    let elements = document.querySelectorAll('.wrong-info');
    let i;
    for (i = 0; i < elements.length; i++) {
        elements.item(i).style.display = "none";
    }
    const loginReqExp = /\w{2,25}/;
    const login = document.querySelector('#login').value;
    if (!checkWord(login, incorrectLogin, loginReqExp)) {
        return event.preventDefault();
    }
    else {
        document.querySelector('.button').style.display = "none";
        document.querySelector('.button').setAttribute("disabled", true);
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
}
