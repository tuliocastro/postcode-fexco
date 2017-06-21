const
    config = require('../config.json'),
    path = require('path'),
    del = require('del'),
    gulp = require('gulp'),
    run = require('gulp-run'),
    sass = require('gulp-sass'),
    minify = require('gulp-minify-css'),
    vendor = require('gulp-concat-vendor'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    sourcemaps = require('gulp-sourcemaps'),
    ngAnnotate = require('gulp-ng-annotate'),
    series = require('stream-series'),
    appRoot = require('app-root-path');

gulp.task('vendor:fonts', function () {

    var dest = path.join(appRoot.path, config.src.build, 'fonts');

    var realPaths = [];

    for (var i = 0; i < config.deps.fonts.length; i++) {

        var dependency = config.deps.fonts[i];
        var file = path.join(appRoot.path, config.src.vendor, dependency);

        realPaths.push(file)

    }

    return gulp
        .src(realPaths)
        .pipe(gulp.dest(dest));

});

gulp.task('vendor:css', function () {

    var dest = path.join(appRoot.path, config.src.build, 'css');

    var realPaths = [];

    for (var i = 0; i < config.deps.css.length; i++) {

        var dependency = config.deps.css[i];
        var file = path.join(appRoot.path, config.src.vendor, dependency);
        realPaths.push(file)

    }

    return gulp
        .src(realPaths)
        .pipe(sass().on('error', sass.logError))
        .pipe(minify())
        .pipe(concat({path: config.project.name + '.vendor.min.css'}))
        .pipe(gulp.dest(dest));

});

gulp.task('vendor:js', function () {

    var dest = path.join(appRoot.path, config.src.build, 'js');

    var realPaths = [];

    //NPM repository - libs
    for (var i = 0; i < config.deps.js.length; i++) {

        var dependency = config.deps.js[i];
        var file = path.join(appRoot.path, config.src.vendor, dependency);
        realPaths.push(file)

    }

    return gulp
        .src(realPaths)
        .pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(concat({path: config.project.name + '.vendor.min.js'}))
        .pipe(gulp.dest(dest));

});


gulp.task('vendor:resources', ['vendor:js', 'vendor:css', 'vendor:fonts']);
