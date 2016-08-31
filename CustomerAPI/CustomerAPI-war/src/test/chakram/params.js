
envEnum = {
    DEV : 0,
    UAT : 1
}

var env = envEnum.DEV;

var devHost = "http://127.0.0.1:10210";
var uatHost = "http://jbossbackdev:19102";

var basePath = "/customerRep/v1";

if (env == envEnum.DEV) {
    exports.baseUrl = devHost + basePath;
} else if (env == envEnum.UAT) {
    exports.baseUrl = uatHost + basePath;
}
