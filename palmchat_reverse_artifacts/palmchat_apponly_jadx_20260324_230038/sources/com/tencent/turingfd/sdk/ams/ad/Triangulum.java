package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Triangulum {
    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean a() {
        Context context;
        int i = Build.VERSION.SDK_INT;
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        if (a(context, g.i) != 0) {
            return false;
        }
        if (i >= 29) {
            return Environment.isExternalStorageLegacy();
        }
        return true;
    }
}
