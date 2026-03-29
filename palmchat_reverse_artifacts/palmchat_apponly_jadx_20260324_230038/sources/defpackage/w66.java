package defpackage;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.util.Log;
import com.zenmen.media.roomchat.RTCParameters;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class w66 {
    public static w66 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kr f21631a;

    public w66() {
        this.f21631a = null;
        if (cc1.b().equals("OPPO")) {
            this.f21631a = c54.b();
        }
    }

    public static boolean a(Context context, int i) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class.forName(appOpsManager.getClass().getName());
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            int iIntValue = ((Integer) cls.getDeclaredMethod("checkOp", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue();
            Log.e("399", " property: " + iIntValue);
            return iIntValue == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static w66 b() {
        if (b == null) {
            b = new w66();
        }
        return b;
    }

    public static boolean c(Context context) {
        return a(context, 24);
    }

    public boolean d() {
        if (this.f21631a == null) {
            return false;
        }
        if (c(RTCParameters.c())) {
            return true;
        }
        try {
            return this.f21631a.a();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
