/**
 * Fastest way to get the last element from array
 */
if (!Array.prototype.last) {
    Array.prototype.last = function () {
        return this[this.length - 1];
    };
}

/**
 * Remove an object from array using splice method
 */
if (!Array.prototype.remove) {
    Array.prototype.remove = function (o) {
        var index = this.indexOf(o);
        if (index >= 0) {
            this.splice(index, 1);
        }
    };
}