;
(function () {

    angular.module(CONSTANTS.APP).factory('LookupServiceExecutor', Factory);

    function Factory(IEService, UKService) {

        var instances = [
            {
                name: 'Irish Address',
                fields: [
                    {label: "Eircode / Address Fragment", value: '', required: true, grid: 'col-xs-12'}
                ],
                execute: function (params) {

                    var query = this.fields[0].value;

                    return IEService.findAddress(query, params);
                }
            },

            {
                name: 'Irish Address and Coordinate',
                fields: [
                    {label: "Eircode / Address Fragment", value: '', required: true, grid: 'col-xs-12'}
                ],
                execute: function (params) {

                    var query = this.fields[0].value;

                    return IEService.findAddressGeo(query, params);
                }
            },

            {
                name: 'Irish Coordinate',
                fields: [
                    {label: "Eircode", value: '', required: true, grid: 'col-xs-12'}
                ],
                execute: function (params) {

                    var query = this.fields[0].value;

                    return IEService.findPosition(query, params);
                }
            },

            {
                name: 'Irish Reverse geocode coordinates',
                fields: [
                    {label: "Latitude", value: '53.332067', required: true, grid: 'col-xs-6'},
                    {label: "Longitude", value: '-6.255492', required: false, grid: 'col-xs-6'}
                ],
                execute: function (params) {

                    var latitude = this.fields[0].value;
                    var longitude = this.fields[1].value;

                    return IEService.findReverseGeo(latitude, longitude, params);
                }
            },


            {
                name: 'UK Address',
                fields: [
                    {label: "Postcode / Address Fragment", value: '', required: true, grid: 'col-xs-12'}
                ],
                execute: function (params) {

                    var query = this.fields[0].value;

                    return UKService.findAddress(query, params);
                }

            },

        ];

        return {

            list: function () {
                return instances;
            }
        };

    }

})();