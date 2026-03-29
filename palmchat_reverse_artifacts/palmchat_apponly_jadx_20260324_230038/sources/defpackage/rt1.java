package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class rt1 {
    public static final Object b = new Object();
    public static final Object c = new Object();
    public static final Object d = new Object();
    public static final Object e = new Object();
    public static rt1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kk2 f20565a = null;

    public static rt1 d() {
        rt1 rt1Var;
        synchronized (c) {
            if (f == null) {
                f = new rt1();
            }
            rt1Var = f;
        }
        return rt1Var;
    }

    public void a(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (d) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.huawei.multimedia.audioengine", str);
            try {
                i63.b("HwAudioKit.FeatureKitManager", "bindService");
                context.bindService(intent, serviceConnection, 1);
            } catch (SecurityException e2) {
                i63.a("HwAudioKit.FeatureKitManager", "bindService, SecurityException, " + e2.getMessage());
            }
        }
    }

    public <T extends rj> T b(int i, Context context) {
        i63.b("HwAudioKit.FeatureKitManager", "createFeatureKit, type =" + i);
        if (context == null) {
            return null;
        }
        if (i != 1) {
            i63.b("HwAudioKit.FeatureKitManager", "createFeatureKit, type error");
            return null;
        }
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = new HwAudioKaraokeFeatureKit(context);
        hwAudioKaraokeFeatureKit.o(context);
        return hwAudioKaraokeFeatureKit;
    }

    public kk2 c() {
        return this.f20565a;
    }

    public boolean e(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return true;
        }
        try {
            if (packageManager.getPackageInfo("com.huawei.multimedia.audioengine", 0) != null) {
                return true;
            }
            i63.b("HwAudioKit.FeatureKitManager", "packageInfo is null");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            i63.a("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
            return false;
        }
    }

    public void f(int i) {
        i63.b("HwAudioKit.FeatureKitManager", "onCallBack, result =" + i);
        synchronized (b) {
            if (c() != null) {
                c().onResult(i);
            }
        }
    }

    public void g(kk2 kk2Var) {
        this.f20565a = kk2Var;
    }

    public void h(Context context, ServiceConnection serviceConnection) {
        i63.b("HwAudioKit.FeatureKitManager", "unbindService");
        synchronized (e) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }
}
