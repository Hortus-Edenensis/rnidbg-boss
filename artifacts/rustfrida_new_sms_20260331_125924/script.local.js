setImmediate(function () {
  Java.perform(function () {
    console.log("[probe-in-app] start");
    var File = Java.use('java.io.File');
    function deleteIfExists(path) {
      try {
        var f = File.$new(path);
        if (f.exists()) {
          f.delete();
        }
      } catch (e) {
        console.log("[probe-in-app] delete warn " + path + " " + String(e));
      }
    }

    deleteIfExists('/data/local/tmp/palmchat_probe_java.out');
    deleteIfExists('/data/local/tmp/palmchat_probe_java.err');

    Java.openClassFile('/data/local/tmp/palmchat_probe2.jar').load();
    var Probe = Java.use('com.codex.palmchat.PalmchatProbe');
    var args = Java.array('java.lang.String', [
      'https://short.lianxinapp.com/one/ax/auth.login.by.sendsms?requestId=1h201774931889680&deviceId=3El51774707713791'
    ]);
    Probe.main(args);
    console.log("[probe-in-app] done");
  });
});
