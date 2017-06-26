(function () {

    angular.module(CONSTANTS.APP).controller('PostcoderAPICtrl', Controller);

    function Controller($window, _lookups) {

        var ctrl = this;

        ctrl.lookups = _lookups;
        ctrl.selectedLookup = null;
        ctrl.params = {
            page: 0,
            lines: null,
            distance: null,
            format: 'json'
        };
        ctrl.addresses = null;
        ctrl.pagination = null;

        ctrl.filter = filter;
        ctrl.nextPage = nextPage;
        ctrl.previousPage = previousPage;
        ctrl.reset = reset;

        function filter() {

            reset();

            findAddresses();

        }

        function reset() {

            ctrl.params.page = 0;

        }

        function nextPage() {

            ctrl.params.page += 1;

            findAddresses();

        }

        function previousPage() {

            ctrl.params.page -= 1;

            findAddresses();

        }

        function findAddresses() {

            $window.scrollTo(0, 0);

            delete ctrl.addresses;

            ctrl.selectedLookup.execute(ctrl.params).then(function (res) {

                console.log(res);
                ctrl.addresses = res.data;

                setPagination();

            }, function (err) {

            });
        }

        function setPagination() {

            delete ctrl.pagination;

            var lastResult = ctrl.addresses.last() || {};

            if (!lastResult || !lastResult.morevalues) {
                return;
            }

            ctrl.pagination = {
                morevalues: lastResult.morevalues,
                nextpage: lastResult.nextPage,
                totalresults: lastResult.totalresults
            };

            //Remove Pagination attributes from row result
            delete lastResult.morevalues;
            delete lastResult.nextpage;
            delete  lastResult.totalresults;

        }

    }

})();