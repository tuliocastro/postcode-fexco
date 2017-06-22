(function () {

    angular.module(CONSTANTS.APP).controller('PostcoderAPICtrl', Controller);

    function Controller(_lookups) {

        var ctrl = this;

        ctrl.lookups = _lookups;
        ctrl.selectedLookup = null;
        ctrl.params = {
            page: 0,
            lines: null,
            distance: null
        };
        ctrl.addresses = null;
        ctrl.pagination = null;

        ctrl.filter = filter;
        ctrl.nextPage = nextPage;
        ctrl.previousPage = previousPage;

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

            ctrl.selectedLookup.execute(ctrl.params).then(function (res) {

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
            //TODO Transformar em filter
            delete lastResult.morevalues;
            delete lastResult.nextpage;
            delete  lastResult.totalresults;

        }

    }

})();