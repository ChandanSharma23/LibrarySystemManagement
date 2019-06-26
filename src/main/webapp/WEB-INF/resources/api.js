(function (window) {
    window.api = {
        contextPath: contextPath,
        // Wraps an ajax request and provides an abort method
        wrap: function (conf) {
            var xhr = new window.XMLHttpRequest();
            conf.xhr = function () {
                return xhr;
            };
            var obj = $.ajax(conf);
            obj.abort = function () {
                xhr.abort();
            };
            return obj;
        },
        post: function (uri, data) {
            var request = {
                method: "post",
                contentType: "application/json",
                dataType: "json"
            };
            if(uri.constructor === String){
                request.url =  contextPath + uri
            }else {
                request = $.extend({}, request, uri);
            }
            if(data instanceof FormData){
                request.contentType = false;
                request.processData = false;
                request.data = data;
            }else{
                request.data= JSON.stringify(data)
            }
            return api.wrap(request);
        },
        get: function (uri, data) {
            return api.wrap({
                method: "get",
                url: contextPath + uri,
                dataType: "json",
                data: data
            });
        },
        getWithoutCache: function (uri, data) {
            return api.wrap({
                cache: false,
                method: "get",
                url: contextPath + uri,
                dataType: "json",
                data: data
            });
        },
        blob: function(uri, blobCompleteHandler, extra) {
            var xhr = new XMLHttpRequest();
            xhr.responseType = 'blob';
            xhr.onreadystatechange = function() {
                if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
                    blobCompleteHandler(xhr, extra);
                }
                // blob failure?
            };
            xhr.open('GET', uri, true);
            xhr.send();
        }
    };
})(window);
