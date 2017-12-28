function validateSignIn() {
    let elements = document.querySelectorAll('.wrong-info');
    let i;
    for (i = 0; i < elements.length; i++) {
        elements.item(i).style.display = "none";
    }
    document.querySelector('.button').style.display = "none";
    document.querySelector('.button').setAttribute("disabled", true);
}
/*function openMailInput() {
    document.querySelector('#hidden-field-to-res-pass').style.display = "none";
    document.querySelector('#hidden-field').style.display = "block";
    document.querySelector('.card').style.display = "none";
    document.querySelector('#res-pass').style.display = "none";
}
function openMailInputToResetPassword() {
    document.querySelector('#hidden-field').style.display = "none";
    document.querySelector('#hidden-field-to-res-pass').style.display = "block";
    document.querySelector('.card').style.display = "none";
    document.querySelector('#auth').style.display = "none";
}*/