package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Build;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ir extends it {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2916a = 13;
    public static int b = 6;
    private Context e;

    public ir(Context context, it itVar) {
        super(itVar);
        this.e = context;
    }

    @Override // com.amap.api.col.p0002sl.it
    public final byte[] a(byte[] bArr) {
        byte[] bArrA = a(this.e);
        byte[] bArr2 = new byte[bArrA.length + bArr.length];
        System.arraycopy(bArrA, 0, bArr2, 0, bArrA.length);
        System.arraycopy(bArr, 0, bArr2, bArrA.length, bArr.length);
        return bArr2;
    }

    private static byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = new byte[0];
        try {
            try {
                ge.a(byteArrayOutputStream, "1.2." + f2916a + "." + b);
                ge.a(byteArrayOutputStream, AnalyticsConstants.SDK_TYPE);
                ge.a(byteArrayOutputStream, fv.k());
                ge.a(byteArrayOutputStream, fv.h());
                ge.a(byteArrayOutputStream, fv.f(context));
                ge.a(byteArrayOutputStream, Build.MANUFACTURER);
                ge.a(byteArrayOutputStream, Build.MODEL);
                ge.a(byteArrayOutputStream, Build.DEVICE);
                ge.a(byteArrayOutputStream, fv.n());
                ge.a(byteArrayOutputStream, fr.c(context));
                ge.a(byteArrayOutputStream, fr.d(context));
                ge.a(byteArrayOutputStream, fr.f(context));
                byteArrayOutputStream.write(new byte[]{0});
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                hd.c(th2, "sm", "gh");
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                throw th3;
            }
        }
        return byteArray;
    }
}
