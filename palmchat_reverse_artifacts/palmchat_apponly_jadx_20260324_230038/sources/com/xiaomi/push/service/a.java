package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.g;
import com.xiaomi.push.service.ag;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f11702a = new SparseArray<ag.a<String, String, String>>(6) { // from class: com.xiaomi.push.service.a.1
        {
            put(1, ag.g);
            put(2, ag.f);
            put(4, ag.e);
            put(8, ag.b);
            put(16, ag.c);
            put(32, ag.h);
        }
    };

    private static int a(String str, int i) {
        return ag.a(C1401r.m660a(), str, null, f11702a.get(i));
    }

    private static Bundle a(String str) {
        return ag.a(C1401r.m660a(), str, (String) null);
    }

    public static int a(Context context, String str) {
        int i;
        int i2 = 0;
        if (context != null && !TextUtils.isEmpty(str)) {
            g.b bVarA = com.xiaomi.push.g.a(context, str, true);
            if (bVarA == g.b.ALLOWED) {
                i2 = 1;
            } else if (bVarA == g.b.NOT_ALLOWED) {
                i2 = 2;
            }
            if (ag.a()) {
                Bundle bundleA = a(str);
                ag.a<String, String, String> aVar = ag.g;
                if (bundleA.containsKey(aVar.c)) {
                    i2 |= bundleA.getBoolean(aVar.c) ? 4 : 8;
                }
                ag.a<String, String, String> aVar2 = ag.e;
                if (bundleA.containsKey(aVar2.c)) {
                    i2 |= bundleA.getBoolean(aVar2.c) ? 16 : 32;
                }
                ag.a<String, String, String> aVar3 = ag.f;
                if (bundleA.containsKey(aVar3.c)) {
                    i2 |= bundleA.getBoolean(aVar3.c) ? 64 : 128;
                }
                ag.a<String, String, String> aVar4 = ag.b;
                if (bundleA.containsKey(aVar4.c)) {
                    i2 |= bundleA.getBoolean(aVar4.c) ? 256 : 512;
                }
                ag.a<String, String, String> aVar5 = ag.c;
                if (bundleA.containsKey(aVar5.c)) {
                    i2 |= bundleA.getBoolean(aVar5.c) ? 1024 : 2048;
                }
                ag.a<String, String, String> aVar6 = ag.h;
                if (bundleA.containsKey(aVar6.c)) {
                    return i2 | (bundleA.getBoolean(aVar6.c) ? 4096 : 8192);
                }
                return i2;
            }
            int iA = a(str, 1);
            if (iA == 1) {
                i2 |= 4;
            } else if (iA == 0) {
                i2 |= 8;
            }
            int iA2 = a(str, 4);
            if (iA2 == 1) {
                i2 |= 16;
            } else if (iA2 == 0) {
                i2 |= 32;
            }
            int iA3 = a(str, 2);
            if (iA3 == 1) {
                i2 |= 64;
            } else if (iA3 == 0) {
                i2 |= 128;
            }
            int iA4 = a(str, 8);
            if (iA4 == 1) {
                i2 |= 256;
            } else if (iA4 == 0) {
                i2 |= 512;
            }
            int iA5 = a(str, 16);
            if (iA5 == 1) {
                i2 |= 1024;
            } else if (iA5 == 0) {
                i2 |= 2048;
            }
            int iA6 = a(str, 32);
            if (iA6 == 1) {
                i = i2 | 4096;
            } else {
                if (iA6 != 0) {
                    return i2;
                }
                i = i2 | 8192;
            }
            return i;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("context | packageName must not be null");
        return 0;
    }
}
