'use strict';

(function () {
  function log(msg) {
    console.log('[probe-in-app] ' + msg);
  }

  function safeString(v) {
    if (v === null || v === undefined) return 'null';
    try { return String(v); } catch (_) { return '<unprintable>'; }
  }

  Java.perform(function () {
    var attempts = 0;
    var maxAttempts = 20;
    var intervalMs = 1000;

    function runOnce() {
      attempts += 1;
      try {
        var ActivityThread = Java.use('android.app.ActivityThread');
        var app = ActivityThread.currentApplication();
        if (app === null) {
          log('currentApplication not ready, attempt=' + attempts);
          return false;
        }

        var File = Java.use('java.io.File');
        var DexClassLoader = Java.use('dalvik.system.DexClassLoader');
        var dexPath = '/data/local/tmp/palmchat_probe2.jar';
        var codeCacheDir = app.getCodeCacheDir().getAbsolutePath().toString();
        var parentLoader = app.getClassLoader();

        try {
          var outFile = File.$new('/data/local/tmp/palmchat_probe_java.out');
          if (outFile.exists()) outFile.delete();
          var errFile = File.$new('/data/local/tmp/palmchat_probe_java.err');
          if (errFile.exists()) errFile.delete();
        } catch (e0) {
          log('delete old files warn=' + safeString(e0));
        }

        var loader = DexClassLoader.$new(dexPath, codeCacheDir, null, parentLoader);
        Java.classFactory.loader = loader;
        var Probe = Java.use('com.codex.palmchat.PalmchatProbe');
        var args = Java.array('java.lang.String', [
          'https://short.lianxinapp.com/one/ax/auth.login.by.sendsms?requestId=1h201774931889680&deviceId=3El51774707713791'
        ]);
        log('invoking helper, attempt=' + attempts);
        Probe.main(args);
        log('helper finished');
        return true;
      } catch (e) {
        log('runOnce error=' + safeString(e));
        return false;
      }
    }

    if (runOnce()) {
      return;
    }

    var timer = setInterval(function () {
      Java.perform(function () {
        if (runOnce() || attempts >= maxAttempts) {
          clearInterval(timer);
          log('stop polling attempts=' + attempts);
        }
      });
    }, intervalMs);
  });
})();
