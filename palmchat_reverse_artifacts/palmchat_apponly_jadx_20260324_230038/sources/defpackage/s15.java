package defpackage;

import android.app.Activity;
import android.util.Log;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class s15 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Log.i("SafeChecker", "exit!!!!!");
            System.exit(0);
        }
    }

    public static void a(Activity activity) {
        long jB = ir5.b();
        boolean zA = ha5.a(activity);
        boolean zA2 = j42.a(activity);
        Log.i("SafeChecker", "isSign=" + zA + " isFridaOk=" + zA2 + " past=" + ir5.e(jB));
        if (zA && zA2) {
            return;
        }
        if (!activity.isFinishing()) {
            activity.finish();
        }
        HashMap map = new HashMap();
        map.put("isSignOk", Boolean.valueOf(zA));
        map.put("isFridaOk", Boolean.valueOf(zA2));
        LogUtil.uploadInfoImmediate("SafeChecker_fail", map);
        u93.b(1000, new a());
    }
}
