package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import com.lantern.auth.app.FunDC;
import com.ss.android.ttvecamera.TECameraUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class wm {
    public static wm f = new wm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21748a;
    public int b;
    public int c;
    public int d;
    public boolean e = false;

    public static wm c() {
        return f;
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    public final void d(Context context) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                this.c = ((Integer) bundle.get("design_width")).intValue();
                this.d = ((Integer) applicationInfo.metaData.get("design_height")).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.c = FunDC.ID_AUTH_1080;
            this.d = TECameraUtils.CAPTURE_NORMAL;
        }
        Log.i("AutoLayoutConfig", "mDesignWidth:" + this.c + ",mDesignHeight:" + this.d);
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.f21748a;
    }

    public void g(Context context) {
        d(context);
        this.f21748a = me1.g();
        this.b = me1.f();
        Log.i("AutoLayoutConfig", "mScreenWidth:" + this.f21748a + ",mScreenHeight:" + this.b);
    }
}
