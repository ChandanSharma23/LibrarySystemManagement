var Vuetils = {
  install: function (Vue, options) {
    var logs = {};
    var $vuetils = new Vue({
      data: {
        loading: false,
        loadingMessage: false
      }
    });

    Vue.directive(
        'uppercase', {
          update: function (el) {
            el.value = el.value.toUpperCase()
          }
        }
    );

    Vue.mixin({
      computed: {
        $locale: function () {
          if (navigator.languages) {
            return navigator.languages[0];
          } else if (navigator.language) {
            return navigator.language;
          } else {
            return navigator.browserLanguage;
          }
        },
        $loading: function () {
          return $vuetils.loading;
        },
        $loadingMessage: function () {
          return $vuetils.loadingMessage;
        },
        $log: function () {
          var component = this.$options.name;
          if (logs) {
            if (logs[component]) {
              return logs[component];
            } else {
              return logs[component] = log(component);
            }
          }
        }
      },
      methods: {
        $messageForError: function (error) {
          var message = "Unknown error";
          if (!error) {
            return message;
          }

          if (error.globalErrors) {
            for (var i = 0; i < error.globalErrors.length; i++) {
              var globalError = error.globalErrors[i];
              var globalMessage = globalError.message;
              if (globalMessage) {
                return globalMessage;
              } else if (globalError.code == "java.lang.NullPointerException") {
                return globalError.code;
              }
            }
          }
          if (error.fieldErrors) {
            for (var key in error.fieldErrors) {
              if (!error.fieldErrors.hasOwnProperty(key)) {
                continue;
              }
              var fieldErrors = error.fieldErrors[key];
              for (var i = 0; i < fieldErrors.length; i++) {
                message = fieldErrors[i].message;
                if (message) {
                  return message;
                }
              }
            }
          }
          return message;
        },
        $api: function (opts) {
          if (!opts.method || opts.method === "post") {
            var post = api.post(opts.url, opts.data);
            if (opts.success) {
              opts.success = opts.success.bind(this)
            }
            if (opts.error) {
              opts.error = opts.error.bind(this)
            }
            if (opts.errorMessage) {
              opts.error = this.$reportError(opts.errorMessage, opts.error);
            }
            if (opts.success || opts.error) {
              post = post.then(opts.success, opts.error);
            }
            if (opts.always) {
              opts.always = opts.always.bind(this);
              post = post.always(opts.always);
            }
            if (opts.progress) {
              $vuetils.loadingMessage = opts.progress;
            }
            $vuetils.loading = true;
            return post.always(function () {
              $vuetils.loading = false;
              $vuetils.loadingMessage = null;
            });
          } else if (opts.method === "blob") {
            api.blob(opts.url, opts.blobCompleteHandler, opts.extra);
            return;
          }else {
            this.$reportError(
                "Unknown $api method: " + opts.method
                + ", supported methods are: 'post'");
          }
        },
        $formatCurrency: function (number, opts) {
          if (number !== null && number !== undefined) {
            return new Intl.NumberFormat(this.$locale,
                {style: 'currency', currency: 'USD'}).format(number);
          } else {
            return null;
          }
        },
        $formatDate: function (date, opts) {
          if (!date) {
            return "N/A";
          }
          if (opts == 'shortdate') {
            opts =
                {month: 'numeric', day: 'numeric', year: 'numeric'}
          }

          if (opts == 'shortdatetime') {
            opts =
                {
                  month: 'numeric',
                  day: 'numeric',
                  year: 'numeric',
                  hour: 'numeric',
                  minute: 'numeric',
                  second: 'numeric'
                }
          }
          return new Date(date).toLocaleDateString(this.$locale, opts);
        },
        $reportError: function (message, then) {
          return function (er) {
            var args = Array.prototype.slice.call(arguments);
            if (er) {
              var error = null;
              if (er.responseJSON) {
                error = args[0] = er.responseJSON;
              } else if (er.statusText && er.statusText != 'ok') {
                message += ': ' + er.statusText;
              }
            }
            if (then) {
              return then.apply(this, args)
            }
            args.unshift(message);
            this.$log.error.apply(log, args);
            this.$notify({
              message: message,
              error: error,
              details: {title: "Error details"},
              type: 'danger'
            });
            return args[1];
          }.bind(this);

        },
        $notify: function (message) {
          console.log("Implementor should override this with it's own mixin...",
              message);
        }
      }
    });
  }
};

Vue.use(Vuetils);