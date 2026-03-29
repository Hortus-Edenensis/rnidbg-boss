package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class an implements ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile an f11415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f120a = am.f11414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ai f123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f124a;

    private an(Context context) {
        this.f122a = context.getApplicationContext();
        this.f123a = am.a(context);
        com.xiaomi.channel.commonutils.logger.b.m74a("create id manager is: " + this.f120a);
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    public void a() {
    }

    public static an a(Context context) {
        if (f11415a == null) {
            synchronized (an.class) {
                if (f11415a == null) {
                    f11415a = new an(context.getApplicationContext());
                }
            }
        }
        return f11415a;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public boolean mo161a() {
        return this.f123a.mo161a();
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public String mo160a() {
        if (j.m651a(this.f122a)) {
            return a(this.f123a.mo160a());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.f121a) > 86400000) {
            this.f121a = jCurrentTimeMillis;
            String strA = a(this.f123a.mo160a());
            this.f124a = strA;
            return strA;
        }
        return a(this.f124a);
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("udid", strB);
        }
        String strMo160a = mo160a();
        if (!TextUtils.isEmpty(strMo160a)) {
            map.put("oaid", strMo160a);
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            map.put("vaid", strC);
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            map.put("aaid", strD);
        }
        map.put("oaid_type", String.valueOf(this.f120a));
    }
}
