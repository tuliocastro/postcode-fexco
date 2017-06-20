(function () {

    angular.module(CONSTANTS.APP).controller('ConfigurationCtrl', Controller);

    function Controller($state, ConfigurationSession) {

        const INITIAL_ROUTE = "ie.address.list";

        var ctrl = this;
        ctrl.pcw = ConfigurationSession.get() || '';

        ctrl.enter = enter;

        /**
         * Functions
         */
        function enter() {

            ConfigurationSession.storage(ctrl.pcw);

            $state.go(INITIAL_ROUTE);

        }

    }

})();