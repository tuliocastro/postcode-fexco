;
(function () {

    angular.module(CONSTANTS.APP).factory('LookupServiceExecutor', Factory);

    function Factory(IEService) {

        var instances = [
            {
                name: 'Irish Reverse geocode coordinates',
                fields: [
                    {label: "Latitude", value: '', required: true, grid: 'col-xs-6'},
                    {label: "Longitude", value: '', required: false, grid: 'col-xs-6'}
                ],
                params: [{}],
                execute: function () {

                    var latitude = this.fields[0].value;
                    var longitude = this.fields[1].value;

                    return IEService.findReverseGeo(latitude, longitude, this.params);
                }
            }
        ];

        return {

            list: function () {
                return instances;
            }
        };

    }

})();