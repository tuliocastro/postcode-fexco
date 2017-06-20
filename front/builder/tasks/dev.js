const
    gulp = require('gulp'),
    runSequence = require('run-sequence');

gulp.task('dev', function (callback) {
    runSequence('assets:resources', 'watch', callback);
});