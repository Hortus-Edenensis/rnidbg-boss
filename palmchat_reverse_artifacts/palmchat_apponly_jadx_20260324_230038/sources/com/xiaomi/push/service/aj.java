package com.xiaomi.push.service;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11715a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f925a = "";

    public static String a() {
        if (TextUtils.isEmpty(f925a)) {
            f925a = com.xiaomi.push.bb.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f925a);
        long j = f11715a;
        f11715a = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String b() {
        return com.xiaomi.push.bb.a(32);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. " + e);
            return "UnexpectedId";
        }
    }
}
