package com.tencent.turingfd.sdk.ams.ad;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Haw extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f10704a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ ITuringDeviceInfoProvider c;
    public final /* synthetic */ Object d;

    public Haw(Herbaceous herbaceous, AtomicBoolean atomicBoolean, HashMap map, ITuringDeviceInfoProvider iTuringDeviceInfoProvider, long j, Object obj) {
        this.f10704a = atomicBoolean;
        this.b = map;
        this.c = iTuringDeviceInfoProvider;
        this.d = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (this.f10704a.get()) {
            return;
        }
        try {
            HashMap map = this.b;
            String imei = this.c.getImei();
            if (imei == null) {
                imei = "";
            }
            map.put("274", imei);
            HashMap map2 = this.b;
            String imsi = this.c.getImsi();
            if (imsi == null) {
                imsi = "";
            }
            map2.put("276", imsi);
            HashMap map3 = this.b;
            String androidId = this.c.getAndroidId();
            if (androidId == null) {
                androidId = "";
            }
            map3.put("275", androidId);
        } catch (Throwable unused) {
            Log.w("Turing", "invoke info impl exception");
        }
        synchronized (this.d) {
            this.d.notify();
        }
    }
}
