;
(function () {

    angular.module(CONSTANTS.APP).constant('GlobalConstants', {
        API_BASE_ENDPOINT: 'http://localhost:8080',
        // API_BASE_ENDPOINT: 'http://192.168.6.203:9000',
        REQUEST_CONTENT_TYPE: 'application/x-www-form-urlencoded;charset=utf-8',
        EMPTY_TEMPLATE: '<div ui-view />',
        APP_NAME: "Postcoder - front consumer",

    });

})();