(function () {

    angular.module(CONSTANTS.APP).controller('ConfigurationCtrl', Controller);

    function Controller($state, APIKeySession) {

        const INITIAL_ROUTE = "postcoder.api";

        var ctrl = this;

        ctrl.apiKey = APIKeySession.get() || '';

        ctrl.save = save;
        ctrl.reset = reset;

        /**
         * Functions
         */
        function save() {

            APIKeySession.store(ctrl.apiKey);

            $state.go(INITIAL_ROUTE);

        }

        function reset() {

            delete ctrl.apiKey;
        }

    }

})();