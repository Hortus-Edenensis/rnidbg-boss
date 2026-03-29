package com.huawei.multimedia.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.cm2;
import defpackage.i63;
import defpackage.kk2;
import defpackage.rj;
import defpackage.rt1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class HwAudioKit {
    public static final List<Integer> h = new ArrayList(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6908a;
    public rt1 d;
    public cm2 b = null;
    public boolean c = false;
    public IBinder e = null;
    public ServiceConnection f = new a();
    public IBinder.DeathRecipient g = new b();

    /* JADX INFO: compiled from: SearchBox */
    public enum FeatureType {
        HWAUDIO_FEATURE_KARAOKE(1);

        private int mFeatureType;

        FeatureType(int i) {
            this.mFeatureType = i;
        }

        public int getFeatureType() {
            return this.mFeatureType;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HwAudioKit.this.b = cm2.a.g(iBinder);
            i63.b("HwAudioKit.HwAudioKit", "onServiceConnected");
            if (HwAudioKit.this.b != null) {
                HwAudioKit.this.c = true;
                i63.b("HwAudioKit.HwAudioKit", "onServiceConnected, mIHwAudioEngine is not null");
                HwAudioKit.this.d.f(0);
                HwAudioKit hwAudioKit = HwAudioKit.this;
                hwAudioKit.o(hwAudioKit.f6908a.getPackageName(), "1.0.3");
                HwAudioKit.this.p(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            i63.b("HwAudioKit.HwAudioKit", "onServiceDisconnected");
            HwAudioKit.this.b = null;
            HwAudioKit.this.c = false;
            HwAudioKit.this.d.f(4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements IBinder.DeathRecipient {
        public b() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            HwAudioKit.this.e.unlinkToDeath(HwAudioKit.this.g, 0);
            HwAudioKit.this.d.f(6);
            i63.a("HwAudioKit.HwAudioKit", "service binder died");
            HwAudioKit.this.e = null;
        }
    }

    public HwAudioKit(Context context, kk2 kk2Var) {
        this.f6908a = null;
        rt1 rt1VarD = rt1.d();
        this.d = rt1VarD;
        rt1VarD.g(kk2Var);
        this.f6908a = context;
    }

    public final void k(Context context) {
        i63.b("HwAudioKit.HwAudioKit", "bindService, mIsServiceConnected = " + this.c);
        rt1 rt1Var = this.d;
        if (rt1Var == null || this.c) {
            return;
        }
        rt1Var.a(context, this.f, "com.huawei.multimedia.audioengine.HwAudioEngineService");
    }

    public <T extends rj> T l(FeatureType featureType) {
        rt1 rt1Var = this.d;
        if (rt1Var == null || featureType == null) {
            return null;
        }
        return (T) rt1Var.b(featureType.getFeatureType(), this.f6908a);
    }

    public void m() {
        i63.b("HwAudioKit.HwAudioKit", "destroy, mIsServiceConnected = " + this.c);
        if (this.c) {
            this.c = false;
            this.d.h(this.f6908a, this.f);
        }
    }

    public void n() {
        i63.b("HwAudioKit.HwAudioKit", "initialize");
        Context context = this.f6908a;
        if (context == null) {
            i63.b("HwAudioKit.HwAudioKit", "mContext is null");
            this.d.f(7);
        } else if (this.d.e(context)) {
            k(this.f6908a);
        } else {
            i63.b("HwAudioKit.HwAudioKit", "not install AudioKitEngine");
            this.d.f(2);
        }
    }

    public final void o(String str, String str2) {
        i63.b("HwAudioKit.HwAudioKit", "serviceInit");
        try {
            cm2 cm2Var = this.b;
            if (cm2Var == null || !this.c) {
                return;
            }
            cm2Var.d(str, str2);
        } catch (RemoteException e) {
            i63.a("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex :" + e.getMessage());
        }
    }

    public final void p(IBinder iBinder) {
        this.e = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.g, 0);
            } catch (RemoteException unused) {
                this.d.f(5);
                i63.a("HwAudioKit.HwAudioKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }
}
