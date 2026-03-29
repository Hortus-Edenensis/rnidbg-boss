package com.tencent.turingfd.sdk.ams.ad;

import com.tencent.turingfd.sdk.ams.ad.CanisMinor;
import com.tencent.turingfd.sdk.ams.ad.Csynchronized;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Longan {
    public static final Longan b = new Longan();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Flat f10715a;

    public Mango a(int i, byte[] bArr, int i2, int i3, CanisMajor canisMajor) {
        CanisMinor canisMinor = this.f10715a.f10695a;
        if (canisMinor == null) {
            return Mango.a(-20000);
        }
        try {
            System.currentTimeMillis();
            CanisMinor.Cdo cdoA = ((Csynchronized.Cdo) canisMinor).a(bArr);
            int i4 = cdoA.f10671a;
            return i4 != 0 ? Mango.a(i4 - 20000) : Mango.a(cdoA.b);
        } catch (Throwable unused) {
            return Mango.a(-20000);
        }
    }
}
