package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class ac extends c {
    private static ac b;
    private static com.vivo.push.e.a d;
    private Map<String, byte[]> c = new ConcurrentHashMap();

    private synchronized void b(Context context) {
        if (!b("data_clear") && context != null) {
            Iterator<Map.Entry<String, ?>> it = a().getAll().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key) && (key.contains("_sub_") || key.contains("_cache_"))) {
                    c(key);
                }
            }
            t.c("SharePreferenceManager", " old data clear ");
            a("data_clear");
        }
    }

    public static synchronized ac c() {
        if (b == null) {
            b = new ac();
        }
        if (d == null) {
            d = new com.vivo.push.e.a();
        }
        return b;
    }

    public final synchronized void a(Context context) {
        if (this.f11300a == null) {
            this.f11300a = context;
            a(context, "com.vivo.push_preferences");
            List<String> listE = e("local_iv");
            if (listE == null || listE.size() < 4) {
                t.a("SharePreferenceManager", " initSecureCode error list is null ");
            } else {
                this.c.put("com.vivo.push.a", d(listE.get(1)));
                this.c.put("com.vivo.push.b", d(listE.get(2)));
                this.c.put("com.vivo.push.c", d(listE.get(3)));
                this.c.put("com.vivo.push.d", d(listE.get(0)));
            }
            b(this.f11300a);
        }
    }

    public final byte[] d() {
        byte[] bArr = this.c.get("com.vivo.push.c");
        return (bArr == null || bArr.length <= 0) ? d.a(this.f11300a) : bArr;
    }

    public final byte[] e() {
        byte[] bArr = this.c.get("com.vivo.push.d");
        return (bArr == null || bArr.length <= 0) ? d.b(this.f11300a) : bArr;
    }

    private static byte[] d(String str) {
        int length;
        byte[] bArr = null;
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length > 0) {
                bArr = new byte[strArrSplit.length];
                length = strArrSplit.length;
            } else {
                length = 0;
            }
            for (int i = 0; i < length; i++) {
                bArr[i] = Byte.parseByte(strArrSplit[i].trim());
            }
        } catch (Exception e) {
            t.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        }
        return bArr;
    }

    private List<String> e(String str) {
        String[] strArrSplit;
        if (this.f11300a == null) {
            t.c("SharePreferenceManager", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.f11300a;
            Object objA = ag.a(context, context.getPackageName(), str);
            if (objA == null) {
                return null;
            }
            String str2 = new String(Base64.decode(objA.toString(), 2));
            if (!TextUtils.isEmpty(str2) && (strArrSplit = str2.split(",#@")) != null && strArrSplit.length >= 4) {
                for (String str3 : strArrSplit) {
                    arrayList.add(str3.replace(",#@", ""));
                }
                if (arrayList.size() < 4) {
                }
            }
            return null;
        } catch (Exception e) {
            t.c("SharePreferenceManager", " parsLocalIv error e =" + e.getMessage());
        }
        return arrayList;
    }
}
