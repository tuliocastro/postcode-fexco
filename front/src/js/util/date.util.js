Date.prototype.toString = function () {

    return ("" + lpad(this.getDate(), "0", 2) + "/" + (lpad(this.getMonth() + 1, "0", 2)) + "/" + this.getFullYear() + " " + this.getHours() + ":" + lpad(this.getMinutes(), "0", 2));

};

function lpad(str, padString, length) {
    str = str.toString();
    while (str.length < length) str = padString + str;
    return str;
}