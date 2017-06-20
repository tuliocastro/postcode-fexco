(function () {

    angular.module(CONSTANTS.APP).factory('ConfigurationSession', Factory);

    function Factory(localStorageService) {

        var KEY_PCW_KEY = '___POSTPCWKEY';

        return {

            store: function (data) {

                var btoed = btoa(data);

                localStorageService.set(KEY_PCW_KEY, btoed);
            },

            get: function () {
                var btoed = localStorageService.get(KEY_PCW_KEY);
                return atob(btoed);
            },

            clear: function () {
                localStorageService.remove(KEY_PCW_KEY);
            }

        };

    }

})();