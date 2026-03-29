package com.zm.fda;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bt;
import com.zm.fda.FobEventClient;
import com.zm.fda.O022Z;
import com.zm.fda.O52OZ.ZZ050;
import com.zm.fda.O52OZ.ZZ0O5;
import com.zm.fda.Z0225.Z0225;
import com.zm.fda.busi.IPubParams;
import com.zm.fda.utils.EventLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16622a = "FdaSdk";
    public static final String b = "com.zm.fda";
    public static volatile boolean c = false;
    public static Context d;
    public static FobEventClient e;
    public static IPubParams f;

    /* JADX INFO: compiled from: SearchBox */
    public static class OO22Z implements IPubParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f16623a;
        public final /* synthetic */ JSONObject b;

        public OO22Z(JSONObject jSONObject) {
            this.b = jSONObject;
        }

        @Override // com.zm.fda.busi.IPubParams
        public boolean collectCrash() {
            return FobProvider.a();
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getAndroidId() {
            return this.b.optString("androidId");
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getAppId() {
            return this.b.optString("appId");
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getCarrier() {
            return this.b.optString(bt.P);
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getChanId() {
            return this.b.optString("chanId");
        }

        @Override // com.zm.fda.busi.IPubParams
        public List<String> getCrashKeyword() {
            List<String> list = this.f16623a;
            if (list != null) {
                return list;
            }
            try {
                ArrayList arrayList = new ArrayList();
                this.f16623a = arrayList;
                arrayList.add("com.zm.fda");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return this.f16623a;
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getDHID() {
            return this.b.optString("dhid");
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getIMEI() {
            return this.b.optString(WkParams.IMEI);
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getLati() {
            return this.b.optString(WkParams.LATI);
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getLongi() {
            return this.b.optString(WkParams.LONGI);
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getMac() {
            return this.b.optString("mac");
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getOaid() {
            return this.b.optString("oaid");
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getProjectId() {
            return O022Z.f16622a;
        }

        @Override // com.zm.fda.busi.IPubParams
        public long getProjectVerCode() {
            return 1000801L;
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getProjectVerName() {
            return com.zm.fda.OO22Z.e;
        }
    }

    public static synchronized FobEventClient a() {
        if (e == null) {
            e = new FobEventClient.Builder().setPubParams(a(d)).setContext(d).a(true).newClient();
        }
        return e;
    }

    public static synchronized void b(Context context) {
        d = context;
    }

    public static boolean b() {
        return c;
    }

    public static void a(boolean z) {
        c = z;
    }

    public static void a(final Context context, final IPubParams iPubParams) {
        f = iPubParams;
        com.zm.fda.OOZ20.Z25O0.a(new Runnable() { // from class: h44
            @Override // java.lang.Runnable
            public final void run() {
                O022Z.a(iPubParams, context);
            }
        }, (com.zm.fda.OOZ20.Z0225.OO22Z) null);
    }

    public static /* synthetic */ void a(IPubParams iPubParams, Context context) {
        try {
            Z0225 z0225 = new Z0225();
            z0225.e(iPubParams.getDHID());
            z0225.j(Z25O0.a(iPubParams));
            z0225.f(iPubParams.getIMEI());
            z0225.a(iPubParams.getAndroidId());
            z0225.c(iPubParams.getCarrier());
            z0225.g(iPubParams.getLati());
            z0225.h(iPubParams.getLongi());
            z0225.i(iPubParams.getMac());
            z0225.b(iPubParams.getAppId());
            z0225.d(iPubParams.getChanId());
            a(context, ZZ0O5.a(z0225));
        } catch (Exception unused) {
        }
    }

    public static IPubParams a(Context context) {
        String strB;
        EventLog.i("FobInnerClient", "KEY_SDK_LAST_PARAMS mPubParams: " + f);
        IPubParams iPubParams = f;
        if (iPubParams != null) {
            return iPubParams;
        }
        String strA = ZZ050.a(d, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.o, "");
        if (TextUtils.isEmpty(strA)) {
            strB = ZZ050.a(d, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.n, "");
            ZZ050.a(d, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.n);
            a(context, strB);
        } else {
            strB = com.zm.fda.OOZ20.ZZ00Z.b(strA);
        }
        EventLog.d("FobInnerClient", "getSpParams:" + strB);
        try {
            return new OO22Z(new JSONObject(strB));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String strB = com.zm.fda.OOZ20.ZZ00Z.b(str.getBytes(StandardCharsets.UTF_8));
        EventLog.d("FobInnerClient", "saveSpParams " + strB);
        ZZ050.b(context, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.o, strB);
    }
}
