function setApprove() {
    let elements = document.querySelectorAll('.command');
    for (let i = 0; i < elements.length; i++) {
        elements[i].value = "Approve_Order";
    }
}
function setRevoke() {
    let elements = document.querySelectorAll('.command');
    for (let i = 0; i < elements.length; i++) {
        elements[i].value = "Revoke_Order";
    }
}

function setUnblock() {
    let elements = document.querySelectorAll('.command');
    for (let i = 0; i < elements.length; i++) {
        elements[i].value = "Unblock_User";
    }
}

function setBlock() {
    let elements = document.querySelectorAll('.command');
    for (let i = 0; i < elements.length; i++) {
        elements[i].value = "Block_User";
    }
}

function disableButtons() {
    let buttons = document.querySelectorAll('.button');
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].style.display = "none";
        buttons[i].setAttribute('disabled', true);
    }
}

