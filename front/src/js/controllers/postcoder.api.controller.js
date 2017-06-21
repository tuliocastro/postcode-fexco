(function () {

    angular.module(CONSTANTS.APP).controller('PostcoderAPICtrl', Controller);

    function Controller($state, IEService, _lookups) {

        var ctrl = this;

        ctrl.lookups = _lookups;
        ctrl.selectedLookup = null;
        ctrl.params = [{}];
        ctrl.addresses = null;
        ctrl.page = 0;
        ctrl.pagination = null;

        ctrl.filter = filter;
        ctrl.nextPage = nextPage;
        ctrl.previousPage = previousPage;
        ctrl.addParameter = addParameter;
        ctrl.removeParameter = removeParameter;

        function filter() {

            reset();

            findAddresses();

        }

        function reset() {

            ctrl.page = 0;

        }

        function nextPage() {

            ctrl.page += 1;

            findAddresses();

        }

        function previousPage() {

            ctrl.page -= 1;

            findAddresses();

        }

        function findAddresses() {

            ctrl.selectedLookup.params.page = ctrl.page;

            ctrl.selectedLookup.execute().then(function (res) {

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

        function addParameter() {

            var emptyParameter = {};
            ctrl.selectedLookup.params.push(emptyParameter);

        }

        function removeParameter(param) {

            ctrl.params.remove(param);
        }

    }

})();