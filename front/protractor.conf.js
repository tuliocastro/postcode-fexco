exports.config = {

    allScriptsTimeout: 11000,

    specs: [
        'test/e2e/**/*.js'
    ],

    capabilities: {
        'browserName': 'chrome'
    },

    baseUrl: 'http://localhost:8081/', //TODO Recover from package.json

    framework: 'jasmine2',

    jasmineNodeOpts: {
        defaultTimeoutInterval: 30000
    }

};