const
    config = require('../config.json'),
    gulp = require('gulp'),
    // livereload = require('gulp-livereload'),
    appRoot = require('app-root-path'),
    path = require('path'),
    runSequence = require('run-sequence');

gulp.task('watch', function () {
    // livereload.listen();

    gulp.watch('**/***.scss', {cwd: path.join(config.src.style)}, ['assets:style']);
    gulp.watch('**/***.js', {cwd: path.join(config.src.js)}, ['assets:js']);
    gulp.watch('**/***.**', {cwd: path.join(config.src.img)}, ['assets:img']);
    gulp.watch('**/***.pug', {cwd: path.join(config.src.view)}, ['assets:pug']);
});
