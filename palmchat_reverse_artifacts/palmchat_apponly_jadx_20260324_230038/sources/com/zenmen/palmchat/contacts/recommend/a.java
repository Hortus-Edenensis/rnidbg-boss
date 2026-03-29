package com.zenmen.palmchat.contacts.recommend;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.k86;
import defpackage.r75;
import defpackage.rl0;
import defpackage.tn0;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13657a = "a";

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.recommend.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1027a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13658a;
        public String b;
        public String c;
        public boolean d;
        public String e;
        public int f;

        public static C1027a e(JSONObject jSONObject) {
            C1027a c1027a = new C1027a();
            if (jSONObject != null) {
                c1027a.i(jSONObject.optBoolean("pop"));
                c1027a.k(jSONObject.optString("poptitle"));
                c1027a.j(jSONObject.optString("popbutton"));
                c1027a.f(jSONObject.optBoolean("name"));
                c1027a.g(jSONObject.optString("pagetitle"));
                c1027a.h(jSONObject.optInt("pagetop"));
            }
            return c1027a;
        }

        public String a() {
            return this.e;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.b;
        }

        public boolean d() {
            return this.f13658a;
        }

        public void f(boolean z) {
            this.d = z;
        }

        public void g(String str) {
            this.e = str;
        }

        public void h(int i) {
            this.f = i;
        }

        public void i(boolean z) {
            this.f13658a = z;
        }

        public void j(String str) {
            this.c = str;
        }

        public void k(String str) {
            this.b = str;
        }

        public String toString() {
            return "BisRecConfig{pop=" + this.f13658a + ", poptitle='" + this.b + "', popbutton=" + this.c + ", name=" + this.d + ", pagetitle='" + this.e + "', pagetop=" + this.f + '}';
        }
    }

    public static C1027a a() {
        DynamicConfig dynamicConfigD = rl0.h().d();
        DynamicConfig.Type type = DynamicConfig.Type.BISREC;
        boolean zIsEnable = dynamicConfigD.getDynamicConfig(type).isEnable();
        String extra = rl0.h().d().getDynamicConfig(type).getExtra();
        C1027a c1027a = new C1027a();
        if (zIsEnable && extra != null) {
            try {
                c1027a = C1027a.e(new JSONObject(extra));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LogUtil.d(f13657a, c1027a.toString());
        return c1027a;
    }

    public static void b(Context context) {
        boolean zD = a().d();
        boolean zD2 = r75.d(AppContext.getContext(), k86.a("sp_bis_rec_pop"), false);
        LogUtil.d(f13657a, "startBisRec:pop-" + zD + " isPopped-" + zD2);
        if (!zD || zD2 || tn0.i().c() <= 0) {
            return;
        }
        context.startActivity(new Intent(context, (Class<?>) BisRecActivity.class));
        r75.o(AppContext.getContext(), k86.a("sp_bis_rec_pop"), true);
    }
}
