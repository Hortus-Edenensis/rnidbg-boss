package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class p {
    private static final String B = "com.huawei.software.features.mobiletv";
    private static final String C = "com.huawei.software.features.watch";
    private static final String Code = "DeviceTypeUtil";
    private static final String D = "com.hihonor.software.features.pad";
    private static final String F = "com.hihonor.software.features.handset";
    private static final String I = "com.huawei.software.features.pad";
    private static final String L = "com.hihonor.software.features.tv";
    private static final String S = "com.huawei.software.features.kidwatch";
    private static final String V = "com.huawei.software.features.handset";
    private static final String Z = "com.huawei.software.features.tv";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6960a = "com.hihonor.software.features.mobiletv";
    private static final String b = "com.hihonor.software.features.watch";
    private static final String c = "com.hihonor.software.features.kidwatch";
    private static final String d = "default";
    private static final String e = "tablet";
    private static final String f = "tv";
    private static p g;
    private static final byte[] h = new byte[0];
    private Context i;
    private String j = "0";

    private p(Context context) {
        this.i = context.getApplicationContext();
        Z();
    }

    public static p Code(Context context) {
        return V(context);
    }

    private static p V(Context context) {
        p pVar;
        synchronized (h) {
            if (g == null) {
                g = new p(context);
            }
            pVar = g;
        }
        return pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d6 A[Catch: all -> 0x00fa, TryCatch #0 {all -> 0x00fa, blocks: (B:6:0x0010, B:8:0x001d, B:10:0x0027, B:11:0x0042, B:12:0x0045, B:15:0x004f, B:18:0x0059, B:21:0x0063, B:24:0x006d, B:26:0x0075, B:29:0x007f, B:32:0x0089, B:35:0x0092, B:37:0x009a, B:40:0x00a3, B:42:0x00ab, B:45:0x00b4, B:48:0x00d9, B:51:0x00e4, B:55:0x00f1, B:53:0x00ec, B:50:0x00e1, B:47:0x00d6), top: B:63:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1 A[Catch: all -> 0x00fa, TryCatch #0 {all -> 0x00fa, blocks: (B:6:0x0010, B:8:0x001d, B:10:0x0027, B:11:0x0042, B:12:0x0045, B:15:0x004f, B:18:0x0059, B:21:0x0063, B:24:0x006d, B:26:0x0075, B:29:0x007f, B:32:0x0089, B:35:0x0092, B:37:0x009a, B:40:0x00a3, B:42:0x00ab, B:45:0x00b4, B:48:0x00d9, B:51:0x00e4, B:55:0x00f1, B:53:0x00ec, B:50:0x00e1, B:47:0x00d6), top: B:63:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ec A[Catch: all -> 0x00fa, TryCatch #0 {all -> 0x00fa, blocks: (B:6:0x0010, B:8:0x001d, B:10:0x0027, B:11:0x0042, B:12:0x0045, B:15:0x004f, B:18:0x0059, B:21:0x0063, B:24:0x006d, B:26:0x0075, B:29:0x007f, B:32:0x0089, B:35:0x0092, B:37:0x009a, B:40:0x00a3, B:42:0x00ab, B:45:0x00b4, B:48:0x00d9, B:51:0x00e4, B:55:0x00f1, B:53:0x00ec, B:50:0x00e1, B:47:0x00d6), top: B:63:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Z() {
        String str;
        PackageManager packageManager = this.i.getPackageManager();
        if (packageManager == null) {
            fh.Z(Code, "packageManager is null.");
            return;
        }
        try {
            FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
            HashSet hashSet = new HashSet();
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (!TextUtils.isEmpty(featureInfo.name)) {
                    fh.Code(Code, "add feature:" + featureInfo.name);
                    hashSet.add(featureInfo.name);
                }
            }
            if (hashSet.contains(V) || hashSet.contains(F)) {
                this.j = "0";
            } else if (hashSet.contains(I) || hashSet.contains(D)) {
                this.j = "1";
            } else {
                if (hashSet.contains(B) || hashSet.contains(f6960a)) {
                    str = "5";
                } else if (hashSet.contains(Z) || hashSet.contains(L)) {
                    this.j = "4";
                } else if (hashSet.contains(S) || hashSet.contains(c)) {
                    str = "3";
                } else {
                    if (!hashSet.contains(C) && !hashSet.contains(b)) {
                        String strCode = bg.Code("ro.build.characteristics");
                        fh.V(Code, "characteristics:" + strCode);
                        if (!strCode.equals("default")) {
                            if (!strCode.equals(e)) {
                                if (strCode.equals(f)) {
                                }
                            }
                        }
                    }
                    str = "2";
                }
                this.j = str;
            }
        } catch (Throwable th) {
            fh.I(Code, "get device type error:" + th.getClass().getSimpleName());
        }
        fh.V(Code, "type is:" + this.j);
    }

    public int I() {
        if ("4".equalsIgnoreCase(this.j)) {
            return 8;
        }
        return "1".equalsIgnoreCase(this.j) ? 5 : 4;
    }

    public String Code() {
        return this.j;
    }

    public boolean V() {
        return "4".equalsIgnoreCase(Code(this.i).Code());
    }
}
