const
    config = require('../config.json'),
    del = require('del'),
    gulp = require('gulp'),
    path = require('path'),
    appRoot = require('app-root-path');

gulp.task('clean', function () {

    return del.sync(path.join(appRoot.path, config.src.build), {force:true});
});
