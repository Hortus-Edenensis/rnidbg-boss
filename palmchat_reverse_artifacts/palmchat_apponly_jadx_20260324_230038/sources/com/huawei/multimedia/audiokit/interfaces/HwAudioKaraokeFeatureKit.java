package com.huawei.multimedia.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.dm2;
import defpackage.i63;
import defpackage.rj;
import defpackage.rt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class HwAudioKaraokeFeatureKit extends rj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6905a;
    public rt1 b;
    public dm2 d;
    public boolean c = false;
    public IBinder e = null;
    public ServiceConnection f = new a();
    public IBinder.DeathRecipient g = new b();

    /* JADX INFO: compiled from: SearchBox */
    public enum ParameName {
        CMD_SET_AUDIO_EFFECT_MODE_BASE("Karaoke_reverb_mode="),
        CMD_SET_VOCAL_VOLUME_BASE("Karaoke_volume="),
        CMD_SET_VOCAL_EQUALIZER_MODE("Karaoke_eq_mode=");

        private String mParameName;

        ParameName(String str) {
            this.mParameName = str;
        }

        public String getParameName() {
            return this.mParameName;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceConnected");
            HwAudioKaraokeFeatureKit.this.d = dm2.a.g(iBinder);
            if (HwAudioKaraokeFeatureKit.this.d != null) {
                HwAudioKaraokeFeatureKit.this.c = true;
                HwAudioKaraokeFeatureKit.this.b.f(1000);
                HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = HwAudioKaraokeFeatureKit.this;
                hwAudioKaraokeFeatureKit.q(hwAudioKaraokeFeatureKit.f6905a.getPackageName());
                HwAudioKaraokeFeatureKit.this.r(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceDisconnected");
            HwAudioKaraokeFeatureKit.this.c = false;
            if (HwAudioKaraokeFeatureKit.this.b != null) {
                HwAudioKaraokeFeatureKit.this.b.f(1001);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements IBinder.DeathRecipient {
        public b() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            i63.a("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
            HwAudioKaraokeFeatureKit.this.e.unlinkToDeath(HwAudioKaraokeFeatureKit.this.g, 0);
            HwAudioKaraokeFeatureKit.this.b.f(1003);
            HwAudioKaraokeFeatureKit.this.e = null;
        }
    }

    public HwAudioKaraokeFeatureKit(Context context) {
        this.b = null;
        this.b = rt1.d();
        this.f6905a = context;
    }

    public final void k(Context context) {
        i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "bindService");
        rt1 rt1Var = this.b;
        if (rt1Var == null || this.c) {
            return;
        }
        rt1Var.a(context, this.f, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
    }

    public void l() {
        i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "destroy, mIsServiceConnected = " + this.c);
        if (this.c) {
            this.c = false;
            this.b.h(this.f6905a, this.f);
        }
    }

    public int m(boolean z) {
        i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature, enable = " + z);
        try {
            dm2 dm2Var = this.d;
            if (dm2Var == null || !this.c) {
                return -2;
            }
            return dm2Var.e(z);
        } catch (RemoteException e) {
            i63.a("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : " + e.getMessage());
            return -2;
        }
    }

    public int n() {
        i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "getKaraokeLatency");
        try {
            dm2 dm2Var = this.d;
            if (dm2Var == null || !this.c) {
                return -1;
            }
            return dm2Var.K();
        } catch (RemoteException e) {
            i63.a("HwAudioKit.HwAudioKaraokeFeatureKit", "getKaraokeLatency,RemoteException ex : " + e.getMessage());
            return -1;
        }
    }

    public void o(Context context) {
        i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize");
        if (context == null) {
            i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, context is null");
        } else if (this.b.e(context)) {
            k(context);
        } else {
            this.b.f(2);
            i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, not install AudioEngine");
        }
    }

    public boolean p() {
        i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "isKaraokeFeatureSupport");
        try {
            dm2 dm2Var = this.d;
            if (dm2Var == null || !this.c) {
                return false;
            }
            return dm2Var.L();
        } catch (RemoteException e) {
            i63.a("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex :" + e.getMessage());
            return false;
        }
    }

    public final void q(String str) {
        try {
            dm2 dm2Var = this.d;
            if (dm2Var == null || !this.c) {
                return;
            }
            dm2Var.init(str);
        } catch (RemoteException e) {
            i63.a("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex :" + e.getMessage());
        }
    }

    public final void r(IBinder iBinder) {
        this.e = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.g, 0);
            } catch (RemoteException unused) {
                this.b.f(1002);
                i63.a("HwAudioKit.HwAudioKaraokeFeatureKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }

    public int s(ParameName parameName, int i) {
        if (parameName == null) {
            return 1807;
        }
        try {
            i63.b("HwAudioKit.HwAudioKaraokeFeatureKit", "parameValue =" + i + ", parame.getParameName() =" + parameName.getParameName());
            dm2 dm2Var = this.d;
            if (dm2Var == null || !this.c) {
                return -2;
            }
            return dm2Var.f(parameName.getParameName(), i);
        } catch (RemoteException e) {
            i63.a("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : " + e.getMessage());
            return -2;
        }
    }
}
