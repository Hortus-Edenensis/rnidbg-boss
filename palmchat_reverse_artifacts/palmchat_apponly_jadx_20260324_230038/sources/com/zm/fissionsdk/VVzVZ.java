package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.WfSlot;
import com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager;
import com.zm.fissionsdk.VZV2Z;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VVzVZ implements IWfLoadManager {
    public static final String c = "SHELL_LM";
    public static VVzVZ d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWfLoadManager f16724a;
    public AtomicBoolean b = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SearchBox */
    public class ZV2Zz implements VZV2Z.zZZ2W {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f16725a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ WfSlot c;
        public final /* synthetic */ IWfLoadManager.WfLoadListener d;

        public ZV2Zz(AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, WfSlot wfSlot, IWfLoadManager.WfLoadListener wfLoadListener) {
            this.f16725a = atomicBoolean;
            this.b = atomicBoolean2;
            this.c = wfSlot;
            this.d = wfLoadListener;
        }

        @Override // com.zm.fissionsdk.VZV2Z.zZZ2W
        public void onFailed(int i, String str) {
            boolean z = this.f16725a.get();
            WVVzW.a(VVzVZ.c, "waitInitAndLoad init success waitTimeout", String.valueOf(z));
            if (z) {
                return;
            }
            this.b.set(true);
            VVzVZ.this.a(i, str, this.d);
        }

        @Override // com.zm.fissionsdk.VZV2Z.zZZ2W
        public void onSuccess() {
            boolean z = this.f16725a.get();
            WVVzW.a(VVzVZ.c, "waitInitAndLoad init success waitTimeout", String.valueOf(z));
            if (z) {
                return;
            }
            this.b.set(true);
            VVzVZ.this.a(this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements VZV2Z.zZZ2W {
        public zZZ2W() {
        }

        @Override // com.zm.fissionsdk.VZV2Z.zZZ2W
        public void onFailed(int i, String str) {
            VVzVZ.this.b.set(true);
        }

        @Override // com.zm.fissionsdk.VZV2Z.zZZ2W
        public void onSuccess() {
            VVzVZ.this.b.set(true);
        }
    }

    public VVzVZ() {
        a();
        if (this.f16724a == null) {
            W2zz2.a().a(new zZZ2W());
        }
    }

    public final void b(final WfSlot wfSlot, final IWfLoadManager.WfLoadListener wfLoadListener) {
        WVVzW.a(c, "waitInitAndLoad");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        int iMax = Math.max(3000, (wfSlot == null || wfSlot.getTimeout() <= 0) ? 5000 : wfSlot.getTimeout());
        WVVzW.a(c, "waitInitAndLoad timeout", String.valueOf(iMax));
        zzZVz.a().a(new Runnable() { // from class: d96
            @Override // java.lang.Runnable
            public final void run() {
                this.f17001a.a(atomicBoolean, atomicBoolean2, wfSlot, wfLoadListener);
            }
        }, iMax);
        W2zz2.a().a(new ZV2Zz(atomicBoolean2, atomicBoolean, wfSlot, wfLoadListener));
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager
    public void loadCache(WfSlot wfSlot, IWfLoadManager.WfLoadListener wfLoadListener) {
        WVVzW.a(c, "loadCache");
        a();
        IWfLoadManager iWfLoadManager = this.f16724a;
        if (iWfLoadManager != null) {
            iWfLoadManager.loadCache(wfSlot, wfLoadListener);
        } else if (this.b.get()) {
            a(0, "loadManager is null", wfLoadListener);
        } else {
            b(wfSlot, wfLoadListener);
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager
    public void loadInterstitial(WfSlot wfSlot, IWfLoadManager.InterstitialLoadListener interstitialLoadListener) {
        WVVzW.a(c, "loadInterstitial");
        a();
        IWfLoadManager iWfLoadManager = this.f16724a;
        if (iWfLoadManager != null) {
            iWfLoadManager.loadInterstitial(wfSlot, interstitialLoadListener);
        } else if (this.b.get()) {
            a(0, "loadManager is null", interstitialLoadListener);
        } else {
            b(wfSlot, interstitialLoadListener);
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager
    public void loadNative(WfSlot wfSlot, IWfLoadManager.NativeLoadListener nativeLoadListener) {
        WVVzW.a(c, "loadNative");
        a();
        IWfLoadManager iWfLoadManager = this.f16724a;
        if (iWfLoadManager != null) {
            iWfLoadManager.loadNative(wfSlot, nativeLoadListener);
        } else if (this.b.get()) {
            a(0, "loadManager is null", nativeLoadListener);
        } else {
            b(wfSlot, nativeLoadListener);
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager
    public void loadReward(WfSlot wfSlot, IWfLoadManager.RewardLoadListener rewardLoadListener) {
        WVVzW.a(c, "loadReward");
        a();
        IWfLoadManager iWfLoadManager = this.f16724a;
        if (iWfLoadManager != null) {
            iWfLoadManager.loadReward(wfSlot, rewardLoadListener);
        } else if (this.b.get()) {
            a(0, "loadManager is null", rewardLoadListener);
        } else {
            b(wfSlot, rewardLoadListener);
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager
    public void loadSplash(WfSlot wfSlot, IWfLoadManager.SplashLoadListener splashLoadListener) {
        WVVzW.a(c, "loadSplash");
        a();
        IWfLoadManager iWfLoadManager = this.f16724a;
        if (iWfLoadManager != null) {
            iWfLoadManager.loadSplash(wfSlot, splashLoadListener);
        } else if (this.b.get()) {
            a(0, "loadManager is null", splashLoadListener);
        } else {
            b(wfSlot, splashLoadListener);
        }
    }

    public final void a(int i, String str, IWfLoadManager.WfLoadListener wfLoadListener) {
        if (wfLoadListener != null) {
            wfLoadListener.onError(i, str);
        }
    }

    public final void a() {
        if (this.f16724a == null) {
            this.f16724a = WW2VZ.b().getWfLoadManager();
        }
    }

    public final /* synthetic */ void a(AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, WfSlot wfSlot, IWfLoadManager.WfLoadListener wfLoadListener) {
        boolean z = atomicBoolean.get();
        WVVzW.a(c, "waitInitAndLoad is timeout isInit", String.valueOf(z));
        if (z) {
            return;
        }
        atomicBoolean2.set(true);
        a(wfSlot, wfLoadListener);
    }

    public static VVzVZ b() {
        if (d == null) {
            synchronized (VVzVZ.class) {
                if (d == null) {
                    d = new VVzVZ();
                }
            }
        }
        return d;
    }

    public final void a(WfSlot wfSlot, IWfLoadManager.WfLoadListener wfLoadListener) {
        a();
        IWfLoadManager iWfLoadManager = this.f16724a;
        if (iWfLoadManager == null) {
            a(0, "loadManager is null", wfLoadListener);
            return;
        }
        if (wfLoadListener instanceof IWfLoadManager.SplashLoadListener) {
            iWfLoadManager.loadSplash(wfSlot, (IWfLoadManager.SplashLoadListener) wfLoadListener);
            return;
        }
        if (wfLoadListener instanceof IWfLoadManager.NativeLoadListener) {
            iWfLoadManager.loadNative(wfSlot, (IWfLoadManager.NativeLoadListener) wfLoadListener);
            return;
        }
        if (wfLoadListener instanceof IWfLoadManager.InterstitialLoadListener) {
            iWfLoadManager.loadInterstitial(wfSlot, (IWfLoadManager.InterstitialLoadListener) wfLoadListener);
        } else if (wfLoadListener instanceof IWfLoadManager.RewardLoadListener) {
            iWfLoadManager.loadReward(wfSlot, (IWfLoadManager.RewardLoadListener) wfLoadListener);
        } else {
            iWfLoadManager.loadCache(wfSlot, wfLoadListener);
        }
    }
}
