package com.zenmen.palmchat.webplatform;

import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.miniPrograms.Package;
import defpackage.nl0;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15918a = "WebModuleDao";
    public static final String b = nl0.b + "/respkg/v1/download";
    public static final String c = nl0.b + "/respkg/v1/list.json";
    public static final String d = nl0.b + "/respkg/v1/verify.json";
    public static final String e = nl0.b + "/respkg/v1/sync.json";
    public static final String f = nl0.b + "/respkg/v1/noauth_sync.json";
    public static final String g = nl0.c + "/respkg/v1/noauth_download";

    /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1135a {
        void a(JSONObject jSONObject, yy2 yy2Var);

        void onFail(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFail(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void onFail(Exception exc);

        void onSuccess(String str, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC1135a f15919a;

        public d(InterfaceC1135a interfaceC1135a) {
            this.f15919a = interfaceC1135a;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.i("WebModuleDao", "onFail error = " + exc.toString());
            this.f15919a.onFail(exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i("WebModuleDao", "onSuccess oridata = " + jSONObject.toString());
            this.f15919a.a(jSONObject, yy2Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(String str, int i, String str2);

        void onFail(Exception exc);
    }

    public static void a(String str, b bVar) {
        com.zenmen.palmchat.webplatform.b.n().i(str, bVar);
    }

    public static void b(Package r1, c cVar) {
        com.zenmen.palmchat.webplatform.b.n().k(r1, cVar);
    }

    public static void c(String str, c cVar) {
        com.zenmen.palmchat.webplatform.b.n().l(str, cVar);
    }

    public static void d(int i, int i2, InterfaceC1135a interfaceC1135a) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pageNum", i);
            jSONObject.put("pageSize", i2);
            jSONObject.put("webgl", 1);
            LogUtil.i(f15918a, "getPkgList = " + jSONObject.toString());
            zw4.f(c, 1, jSONObject, new d(interfaceC1135a));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void e() {
        com.zenmen.palmchat.webplatform.b.n().v();
    }

    public static void f(JSONArray jSONArray, InterfaceC1135a interfaceC1135a) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkgs", jSONArray);
            LogUtil.i(f15918a, "sync = " + jSONObject.toString());
            zw4.f(e, 1, jSONObject, new d(interfaceC1135a));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void g(String str, e eVar) {
        com.zenmen.palmchat.webplatform.b.n().z(str, eVar);
    }
}
