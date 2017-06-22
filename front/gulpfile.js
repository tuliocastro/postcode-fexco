const requireDir = require('require-dir'),
    gulp = require('gulp');

requireDir('builder', {recurse: true});

gulp.task('default', ['build']);