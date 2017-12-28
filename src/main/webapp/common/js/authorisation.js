let incorrectEmail;
document.addEventListener('DOMContentLoaded', func);
function func() {
    incorrectEmail = document.querySelector('#incorrect-email');
    incorrectEmail.style.display = "none";
    document.querySelector('.button').style.display = "block";
}
;
function validateEmail() {
    let elements = document.querySelectorAll('.wrong-info');
    let i;
    for (i = 0; i < elements.length; i++) {
        elements.item(i).style.display = "none";
    }
    const emailReqExp = /[\w-]+[.\w-]*@[\w-]+[.\w-]+[a-zA-z]{2,}/;
    const email = document.querySelector('#mail').value;
    if (!checkWord(email, incorrectEmail, emailReqExp)) {
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
};
