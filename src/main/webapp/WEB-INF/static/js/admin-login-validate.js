function validateNewPwd() {
    return longEnough("new-pwd");
}
function validateConfPwd(){
    return isSame("conf-pwd");
}

function validate() {
    return  validateNewPwd() && validateConfPwd();
}