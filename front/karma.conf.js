module.exports = function (config) {
    config.set({

        basePath: '',

        files: [

            "node_modules/jquery/dist/jquery.min.js",
            "node_modules/bootstrap/dist/js/bootstrap.min.js",
            "node_modules/angular/angular.min.js",
            "node_modules/angular-ui-router/release/angular-ui-router.min.js",
            "node_modules/angular-local-storage/dist/angular-local-storage.js",
            "node_modules/ngsticky/dist/sticky.min.js",
            "node_modules/angular-growl-v2/build/angular-growl.js",
            'node_modules/angular-mocks/angular-mocks.js',
            'src/js/main.js',
            'src/js/**/*.js',
            'test/unit/**/*.js'
        ],

        autoWatch: true,

        frameworks: ['mocha', 'chai'],

        browsers: ['PhantomJS'],

        // web server port
        port: 9876,

        reporters: ['progress', 'coverage'],
        preprocessors: { 'src/js/**/*.js': ['coverage'] }

    });
};