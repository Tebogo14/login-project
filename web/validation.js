function setMsg(id, text, type) {
  const el = document.getElementById(id);
  if (!el) return;
  el.textContent = text;
  el.className = "field-msg " + (type || "");
}

function validateRequired(fieldId, msgId, message) {
  const val = document.getElementById(fieldId).value.trim();
  if (!val) { setMsg(msgId, message, "error"); return false; }
  setMsg(msgId, "", "");
  return true;
}

function validateUsername(username) {
  if (!username.includes("_") || username.length > 5) {
    setMsg("usernameMsg",
      "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
      "error");
    return false;
  }
  setMsg("usernameMsg", "Username successfully captured.", "success");
  return true;
}

function validatePassword(password) {
  const hasUpper   = /[A-Z]/.test(password);
  const hasDigit   = /[0-9]/.test(password);
  const hasSpecial = /[^A-Za-z0-9]/.test(password);

  if (password.length < 8 || !hasUpper || !hasDigit || !hasSpecial) {
    setMsg("passwordMsg",
      "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
      "error");
    return false;
  }
  setMsg("passwordMsg", "Password successfully captured.", "success");
  return true;
}

function validateCellPhone(cellPhone) {
  // International country code followed by up to 10-digit number
  // Reference: https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s03.html
  const regex = /^\+[0-9]{1,3}[0-9]{1,10}$/;
  if (!regex.test(cellPhone)) {
    setMsg("cellPhoneMsg",
      "Cell phone number incorrectly formatted or does not contain international code.",
      "error");
    return false;
  }
  setMsg("cellPhoneMsg", "Cell phone number successfully added.", "success");
  return true;
}

function togglePassword(fieldId, btn) {
  const input = document.getElementById(fieldId);
  if (input.type === "password") {
    input.type = "text";
    btn.textContent = "Hide";
  } else {
    input.type = "password";
    btn.textContent = "Show";
  }
}
