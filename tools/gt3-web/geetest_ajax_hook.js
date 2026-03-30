'use strict';

Java.perform(function () {
  function safeString(value) {
    try {
      return String(value);
    } catch (_err) {
      return '';
    }
  }

  function sendPayload(type, payload) {
    try {
      send(Object.assign({ type: type }, payload || {}));
    } catch (_err) {}
  }

  try {
    var CookieManager = Java.use('android.webkit.CookieManager');
    var WebViewClient = Java.use('android.webkit.WebViewClient');
    WebViewClient.shouldInterceptRequest.overload(
      'android.webkit.WebView',
      'android.webkit.WebResourceRequest'
    ).implementation = function (wv, req) {
      var url = safeString(req.getUrl());
      if (url.indexOf('ajax.php') >= 0 || url.indexOf('get.php') >= 0) {
        var cookies = '';
        var ua = '';
        try {
          cookies = safeString(CookieManager.getInstance().getCookie(url));
        } catch (_err) {}
        try {
          ua = safeString(wv.getSettings().getUserAgentString());
        } catch (_err) {}
        sendPayload('gt_webview_url', {
          url: url,
          cookies: cookies,
          ua: ua,
        });
      }
      return this.shouldInterceptRequest(wv, req);
    };
  } catch (_err) {}

  try {
    var GT3Listener = Java.use('com.geetest.sdk.GT3Listener');
    GT3Listener.onDialogResult.overload('java.lang.String').implementation = function (result) {
      sendPayload('gt_dialog_result', { result: safeString(result) });
      return this.onDialogResult(result);
    };
  } catch (_err) {}
});
