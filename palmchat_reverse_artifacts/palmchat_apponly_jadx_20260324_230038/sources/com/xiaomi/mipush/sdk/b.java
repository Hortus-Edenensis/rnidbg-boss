package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f11364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f44a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f45a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f46a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, a> f47a;

    private b(Context context) {
        this.f44a = context;
        c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static b m99a(Context context) {
        if (f11364a == null) {
            synchronized (b.class) {
                if (f11364a == null) {
                    f11364a = new b(context);
                }
            }
        }
        return f11364a;
    }

    private void c() {
        this.f45a = new a(this.f44a);
        this.f47a = new HashMap();
        SharedPreferences sharedPreferencesA = a(this.f44a);
        this.f45a.f49a = sharedPreferencesA.getString("appId", null);
        this.f45a.b = sharedPreferencesA.getString("appToken", null);
        this.f45a.c = sharedPreferencesA.getString("regId", null);
        this.f45a.d = sharedPreferencesA.getString("regSec", null);
        this.f45a.f = sharedPreferencesA.getString("devId", null);
        if (!TextUtils.isEmpty(this.f45a.f) && com.xiaomi.push.i.a(this.f45a.f)) {
            this.f45a.f = com.xiaomi.push.i.h(this.f44a);
            sharedPreferencesA.edit().putString("devId", this.f45a.f).commit();
        }
        this.f45a.e = sharedPreferencesA.getString("vName", null);
        this.f45a.f50a = sharedPreferencesA.getBoolean("valid", true);
        this.f45a.f51b = sharedPreferencesA.getBoolean("paused", false);
        this.f45a.f11365a = sharedPreferencesA.getInt("envType", 1);
        this.f45a.g = sharedPreferencesA.getString("regResource", null);
        this.f45a.h = sharedPreferencesA.getString("appRegion", null);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m106b() {
        if (this.f45a.m113a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("Don't send message before initialization succeeded!");
        return false;
    }

    public String d() {
        return this.f45a.d;
    }

    public String e() {
        return this.f45a.g;
    }

    public String f() {
        return this.f45a.h;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m109d() {
        return (TextUtils.isEmpty(this.f45a.f49a) || TextUtils.isEmpty(this.f45a.b) || TextUtils.isEmpty(this.f45a.c) || TextUtils.isEmpty(this.f45a.d)) ? false : true;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m110e() {
        return this.f45a.f51b;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public boolean m111f() {
        return !this.f45a.f50a;
    }

    public String b() {
        return this.f45a.b;
    }

    public void b(String str, String str2, String str3) {
        this.f45a.b(str, str2, str3);
    }

    public void b(String str) {
        this.f47a.remove(str);
        a(this.f44a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m103a() {
        Context context = this.f44a;
        return !TextUtils.equals(com.xiaomi.push.g.m475a(context, context.getPackageName()), this.f45a.e);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m105b() {
        this.f45a.b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Context f48a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f49a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f50a = true;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f51b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11365a = 1;

        public a(Context context) {
            this.f48a = context;
        }

        public void a(String str, String str2, String str3) {
            this.f49a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f48a).edit();
            editorEdit.putString("appId", this.f49a);
            editorEdit.putString("appToken", str2);
            editorEdit.putString("regResource", str3);
            editorEdit.commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f48a);
            this.e = a();
            this.f50a = true;
            this.h = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f48a).edit();
            editorEdit.putString("regId", str);
            editorEdit.putString("regSec", str2);
            editorEdit.putString("devId", this.f);
            editorEdit.putString("vName", a());
            editorEdit.putBoolean("valid", true);
            editorEdit.putString("appRegion", str3);
            editorEdit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f49a = str;
            this.b = str2;
            this.g = str3;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f48a);
            this.e = a();
            this.f50a = true;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m114a(String str, String str2) {
            boolean zEquals = TextUtils.equals(this.f49a, str);
            boolean zEquals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.c);
            boolean z2 = !TextUtils.isEmpty(this.d);
            boolean z3 = TextUtils.isEmpty(com.xiaomi.push.i.b(this.f48a)) || TextUtils.equals(this.f, com.xiaomi.push.i.h(this.f48a)) || TextUtils.equals(this.f, com.xiaomi.push.i.g(this.f48a));
            boolean z4 = zEquals && zEquals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(zEquals), Boolean.valueOf(zEquals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f50a = false;
            b.a(this.f48a).edit().putBoolean("valid", this.f50a).commit();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m113a() {
            return m114a(this.f49a, this.b);
        }

        private String a() {
            Context context = this.f48a;
            return com.xiaomi.push.g.m475a(context, context.getPackageName());
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m112a() {
            b.a(this.f48a).edit().clear().commit();
            this.f49a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f50a = false;
            this.f51b = false;
            this.h = null;
            this.f11365a = 1;
        }

        public void a(boolean z) {
            this.f51b = z;
        }

        public void a(int i) {
            this.f11365a = i;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f49a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f50a = jSONObject.getBoolean("valid");
                aVar.f51b = jSONObject.getBoolean("paused");
                aVar.f11365a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f49a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f50a);
                jSONObject.put("paused", aVar.f51b);
                jSONObject.put("envType", aVar.f11365a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m102a(String str) {
        SharedPreferences.Editor editorEdit = a(this.f44a).edit();
        editorEdit.putString("vName", str);
        editorEdit.commit();
        this.f45a.e = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m100a() {
        return this.f45a.f49a;
    }

    public boolean a(String str, String str2) {
        return this.f45a.m114a(str, str2);
    }

    public void a(String str, String str2, String str3) {
        this.f45a.a(str, str2, str3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m101a() {
        this.f45a.m112a();
    }

    public a a(String str) {
        if (this.f47a.containsKey(str)) {
            return this.f47a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences sharedPreferencesA = a(this.f44a);
        if (!sharedPreferencesA.contains(str2)) {
            return null;
        }
        a aVarA = a.a(this.f44a, sharedPreferencesA.getString(str2, ""));
        this.f47a.put(str2, aVarA);
        return aVarA;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m107c() {
        return this.f45a.c;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m108c() {
        return this.f45a.m113a();
    }

    public void a(String str, a aVar) {
        this.f47a.put(str, aVar);
        a(this.f44a).edit().putString("hybrid_app_info_" + str, a.a(aVar)).commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m104a(String str, String str2, String str3) {
        a aVarA = a(str3);
        return aVarA != null && TextUtils.equals(str, aVarA.f49a) && TextUtils.equals(str2, aVarA.b);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public int a() {
        return this.f45a.f11365a;
    }

    public void a(boolean z) {
        this.f45a.a(z);
        a(this.f44a).edit().putBoolean("paused", z).commit();
    }

    public void a(int i) {
        this.f45a.a(i);
        a(this.f44a).edit().putInt("envType", i).commit();
    }
}
