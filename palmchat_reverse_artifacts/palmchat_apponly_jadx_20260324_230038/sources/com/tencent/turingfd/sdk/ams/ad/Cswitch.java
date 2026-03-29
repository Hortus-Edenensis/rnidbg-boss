package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.switch, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cswitch {
    public static void a(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append("T:");
        long j = Marc.f10722a;
        sb.append(j);
        sb.append(",");
        sb.append("LT:");
        sb.append(System.currentTimeMillis() - j);
    }
}
