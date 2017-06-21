(function () {

    angular.module(CONSTANTS.APP).controller('AddressIECtrl', Controller);

    function Controller($state, IEService) {

        var ctrl = this;

        ctrl.query = 'NR147P';
        ctrl.params = null;
        ctrl.addresses = null;

        ctrl.filter = filter;

        function filter() {

            IEService.findAddress(ctrl.query, ctrl.params).then(function (res) {

                console.log(res.data);
                ctrl.addresses = res.data;

            }, function (err) {

            });
        }

        filter();

    }

})();