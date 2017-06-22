const
    config = require('../config.json'),
    del = require('del')
path = require('path'),
    gulp = require('gulp'),
    runSequence = require('run-sequence'),
    appRoot = require('app-root-path');


gulp.task('dist:clean', function () {

    return del.sync(path.join(appRoot.path, config.src.dist), {force: true});

});


gulp.task('dist:copy', function () {

    var buildedFolder = path.join(appRoot.path, config.src.build, '/**/*');

    var dest = path.join(appRoot.path, config.src.dist);

    return gulp
        .src([buildedFolder])
        .pipe(gulp.dest(dest));

});

gulp.task('dist', function (callback) {
    runSequence(['clean'], ['build'], ['dist:clean'], ['dist:copy'], callback);
});