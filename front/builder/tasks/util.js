const gutil = require('gulp-util');

module.exports = {

    errorHandler: function (title) {
        'use strict';

        return function (error) {
            gutil.log(gutil.colors.red('[' + title + ']'), error.toString());
            this.emit('end');
        };

    }

};