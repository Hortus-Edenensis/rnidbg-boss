'use strict';

(function () {
  var installed = false;
  var invoked = false;

  function log(msg) {
    console.log('[probe-in-app] ' + msg);
  }

  function safeString(v) {
    if (v === null || v === undefined) return 'null';
    try {
      return String(v);
    } catch (_) {
      return '<unprintable>';
    }
  }

  function packageNameOf(app) {
    try {
      return safeString(app.getPackageName());
    } catch (_) {
      return null;
    }
  }

  function loaderHandleOf(loader) {
    try {
      if (loader && loader.__jptr !== undefined) {
        return loader.__jptr;
      }
    } catch (_) {}
    try {
      if (loader && loader.ptr !== undefined) {
        return loader.ptr;
      }
    } catch (_) {}
    return loader;
  }

  function invokeHelperWithApp(app, reason) {
    if (invoked) {
      log('invoke skipped, already invoked, reason=' + reason);
      return;
    }
    invoked = true;
    try {
      log('step1 begin invoke reason=' + reason + ' pkg=' + packageNameOf(app));
      var File = Java.use('java.io.File');
      var DexClassLoader = Java.use('dalvik.system.DexClassLoader');
      var dexPath = '/data/local/tmp/palmchat_probe2.jar';
      var codeCacheDir = app.getCodeCacheDir().getAbsolutePath().toString();
      var parentLoader = app.getClassLoader();
      log('step2 resolved classes codeCacheDir=' + safeString(codeCacheDir));

      try {
        var outFile = File.$new('/data/local/tmp/palmchat_probe_java.out');
        if (outFile.exists()) outFile.delete();
        var errFile = File.$new('/data/local/tmp/palmchat_probe_java.err');
        if (errFile.exists()) errFile.delete();
        log('step3 cleaned old output files');
      } catch (e0) {
        log('delete old files warn=' + safeString(e0));
      }

      var loader = DexClassLoader.$new(dexPath, codeCacheDir, null, parentLoader);
      var loaderHandle = loaderHandleOf(loader);
      log('step4 created DexClassLoader handle=' + safeString(loaderHandle));
      Java.setClassLoader(loaderHandle);
      log('step5 set classloader');
      var Probe = Java.use('com.codex.palmchat.PalmchatProbe');
      log('step6 resolved Probe class');
      var url = 'https://short.lianxinapp.com/one/ax/auth.login.by.sendsms?requestId=1h201774931889680&deviceId=3El51774707713791';
      log('step7 built url loader=' + safeString(loader) + ' handle=' + safeString(loaderHandle));
      Probe.run(url);
      log('step8 helper finished reason=' + reason);
    } catch (e) {
      invoked = false;
      log('invokeHelper error reason=' + reason + ' err=' + safeString(e));
    }
  }

  Java.ready(function () {
    try {
      if (installed) {
        log('hook already installed');
        return;
      }
      installed = true;

      var ActivityThread = Java.use('android.app.ActivityThread');
      var currentApp = null;
      try {
        currentApp = ActivityThread.currentApplication();
      } catch (e0) {
        log('currentApplication check err=' + safeString(e0));
      }
      if (currentApp !== null) {
        log('currentApplication already ready pkg=' + packageNameOf(currentApp));
        invokeHelperWithApp(currentApp, 'currentApplication');
        return;
      }

      var Instrumentation = Java.use('android.app.Instrumentation');
      var ov = Instrumentation.callApplicationOnCreate.overload('android.app.Application');
      ov.impl = function (ctx) {
        var app = ctx.args[0];
        var pkg = packageNameOf(app);
        log('callApplicationOnCreate pkg=' + pkg);
        var ret = ctx.orig();
        if (pkg === 'com.zenmen.palmchat') {
          invokeHelperWithApp(app, 'callApplicationOnCreate');
        }
        return ret;
      };
      log('hooked Instrumentation.callApplicationOnCreate');
    } catch (e) {
      log('Java.ready install error=' + safeString(e));
    }
  });
})();
