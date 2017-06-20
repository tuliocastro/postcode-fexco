const
    config = require('../config.json'),
    util = require('./util'),
    del = require('del'),
    path = require('path'),
    gulp = require('gulp'),
    pug = require('gulp-pug'),
    run = require('gulp-run'),
    sass = require('gulp-sass'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    series = require('stream-series'),
    appRoot = require('app-root-path'),
    minify = require('gulp-minify-css'),
    livereload = require('gulp-livereload'),
    sourcemaps = require('gulp-sourcemaps'),
    ngAnnotate = require('gulp-ng-annotate');

gulp.task('assets:style', function () {

    var src = path.join(appRoot.path, config.src.style, '/**/*.scss');

    var dest = path.join(appRoot.path, config.src.build, 'css');

    return gulp
        .src(src)
        .pipe(sass().on('error', util.errorHandler('sass')))
        .pipe(minify().on('error', util.errorHandler('minify')))
        .pipe(concat({path: config.project.name + '.assets.min.css'}))
        .pipe(gulp.dest(dest))
        .pipe(livereload());

});


gulp.task('assets:js', function () {

    var src = path.join(appRoot.path, config.src.js, '/**/*.js');

    var dest = path.join(appRoot.path, config.src.build, 'js');

    return gulp
        .src(src)
        .pipe(sourcemaps.init())
        .pipe(concat(config.project.name + '.assets.min.js'))
        .pipe(ngAnnotate({add: true}).on('error', util.errorHandler('ngAnnotate')))
        .pipe(uglify({mangle: false}).on('error', util.errorHandler('uglify')))
        .pipe(sourcemaps.write('./'))
        .pipe(gulp.dest(dest))
        .pipe(livereload());

});

gulp.task('assets:pug', function () {

    var src = path.join(appRoot.path, config.src.view, '/**/*.pug');

    var dest = path.join(appRoot.path, config.src.build);

    return gulp
        .src(src)
        .pipe(pug({}).on('error', util.errorHandler('pug')))
        .pipe(gulp.dest(dest))
        .pipe(livereload());

});


gulp.task('assets:img', function () {

    var src = path.join(appRoot.path, config.src.img, '**/*');

    var dest = path.join(appRoot.path, config.src.build, 'img');

    return gulp
        .src(src)
        .pipe(gulp.dest(dest));

});


gulp.task('assets:fonts', function () {

    var src = path.join(appRoot.path, config.src.font, '**/*');

    var dest = path.join(appRoot.path, config.src.build, 'fonts');

    return gulp
        .src(src)
        .pipe(gulp.dest(dest));

});

gulp.task('assets:resources', ['assets:js', 'assets:style', 'assets:pug', 'assets:img', 'assets:fonts']);