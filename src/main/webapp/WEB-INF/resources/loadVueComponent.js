function loadVueComponent(name, location, jsName) {
    location = location || name;
    jsName = jsName || name;

    // We may have already loaded this
    if (window[jsName] && window[jsName].constructor === Object) return;
    window[jsName] = function (resolve) {
        if (window[jsName] && window[jsName].constructor === Object) {
            resolve(window[jsName]);
        } else {
            jQuery.get(contextPath + "resources/vue/" + location + ".vue.html").then(function (content) {
            	debugger
                var $content = $(content);
                var template = '';
                var $style = $("head");
                $.each($content, function (k, v) {
                    var $el = $(v);
                    if ($el.is('style')) {
                        $style.prepend($el);
                    } else if ($el.is("script")) {
                        eval($el.text());
                    } else if (v.outerHTML) {
                        if (template) console.error("Vue component " + name + " should wrap it's template in one element");
                        template = v.outerHTML;
                    }
                });
                if (!template) console.error("Vue component " + name + " should wrap it's template in one element");
                debugger;
                if (window[jsName].processTemplate) template = window[jsName].processTemplate(template);
                window[jsName].template = template;
                window[jsName].name = name;
                resolve(window[jsName]);
            });
        }
    };
    Vue.component(name, window[jsName]);
    return window[jsName];
}