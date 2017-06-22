if (typeof String.prototype.startsWith != 'function') {
    // see below for better implementation!
    String.prototype.startsWith = function (str) {
        return this.indexOf(str) === 0;
    };
}

if (!String.prototype.endsWith) {
    String.prototype.endsWith = function (searchString, position) {
        var subjectString = this.toString();
        if (position === undefined || position > subjectString.length) {
            position = subjectString.length;
        }
        position -= searchString.length;
        var lastIndex = subjectString.indexOf(searchString, position);
        return lastIndex !== -1 && lastIndex === position;
    };
}

if (!String.prototype.format) {
    String.prototype.format = function () {
        var args = arguments;
        return this.replace(/{(\d+)}/g, function (match, number) {
            return typeof args[number] != 'undefined'
                ? args[number]
                : match
                ;
        });
    };
}

if (!String.prototype.contains) {
    String.prototype.contains = function (str, ignoreCase) {
        return (ignoreCase ? this.toUpperCase() : this)
                .indexOf(ignoreCase ? str.toUpperCase() : str) >= 0;
    };
}

/**
 * Converte um buffer para uma string
 */
if (!String.prototype.fromBuffer) {
    String.prototype.fromBuffer = function () {
        var string = this.toString();
        var joined = string.split(/(\r?\n)/g).join("");
        return joined;
    };
}


/**
 * Converte string para JSON
 */
if (!String.prototype.toJSON) {
    String.prototype.toJSON = function () {

        var json = '{}';
        if (this && this != '') {
            json = JSON.parse(this);
        }

        return json;

    };
}

function decodeUtf8(arrayBuffer) {

    var decoded = '';

    arrayBuffer.forEach(function (char) {
        decoded += String.fromCharCode(char);
    });

    return decoded;
}

function pad(input, amount, character) {
    character = character || '0';
    input = input + '';
    return input.length >= amount ? input : new Array(amount - input.length + 1).join(character) + input;
}