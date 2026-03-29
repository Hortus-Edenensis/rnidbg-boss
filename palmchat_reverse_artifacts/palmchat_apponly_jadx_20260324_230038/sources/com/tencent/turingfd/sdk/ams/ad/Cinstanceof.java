package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.ad.Bagasse;
import com.tencent.turingfd.sdk.ams.ad.Csynchronized;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.instanceof, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cinstanceof implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10764a;
    public final /* synthetic */ Csynchronized.Cdo b;

    public Cinstanceof(Csynchronized.Cdo cdo, int i) {
        this.b = cdo;
        this.f10764a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        if (!Sagittarius.c(context)) {
            return;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.b.f10775a;
            if (i >= strArr.length) {
                return;
            }
            try {
                Bagasse.Cdo cdo = new Bagasse.Cdo(strArr[i]);
                int i2 = this.f10764a;
                if (i2 > 0) {
                    cdo.d = i2;
                }
                if (i2 > 0) {
                    cdo.e = i2;
                }
                Bagasse bagasse = new Bagasse(cdo);
                Andromeda.a(bagasse, bagasse.b, bagasse.d);
                this.b.b = i;
                return;
            } catch (Throwable unused) {
                i++;
            }
        }
    }
}
