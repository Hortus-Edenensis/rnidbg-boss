package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.fi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Map<String, byte[]> f1012a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ArrayList<Pair<String, byte[]>> f11773a = new ArrayList<>();

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = f1012a;
        synchronized (map) {
            com.xiaomi.channel.commonutils.logger.b.m74a("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f11773a) {
            f11773a.add(new Pair<>(str, bArr));
            if (f11773a.size() > 50) {
                f11773a.remove(0);
            }
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            Map<String, byte[]> map = f1012a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("processing pending registration request. " + str);
                    w.a(xMPushService, str, f1012a.get(str));
                    if (z && !com.xiaomi.push.s.a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f1012a.clear();
            }
        } catch (fi e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(Context context, int i, String str) {
        Map<String, byte[]> map = f1012a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                com.xiaomi.channel.commonutils.logger.b.m74a("notify registration error. " + str2);
                a(context, str2, f1012a.get(str2), i, str);
            }
            f1012a.clear();
        }
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f11773a) {
                arrayList = f11773a;
                f11773a = new ArrayList<>();
            }
            boolean zA = com.xiaomi.push.s.a();
            for (Pair<String, byte[]> pair : arrayList) {
                w.a(xMPushService, (String) pair.first, (byte[]) pair.second);
                if (!zA) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fi e) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w.a(str));
    }
}
