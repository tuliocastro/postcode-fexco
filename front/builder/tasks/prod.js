const
    gulp = require('gulp'),
    runSequence = require('run-sequence');

gulp.task('build', function (callback) {
    runSequence(['clean'], ['assets:resources', 'vendor:resources'], callback);
});