package com.qq.gdt.action;

import android.content.Context;
import com.kuaishou.weapon.p0.bq;
import com.qq.gdt.action.j.i;
import com.qq.gdt.action.j.k;
import com.qq.gdt.action.j.l;
import com.qq.gdt.action.j.n;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.u;
import com.qq.gdt.action.j.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f10461a;
    private static final Object b = new Object();
    private static final Set<String> c = Collections.unmodifiableSet(new HashSet<String>() { // from class: com.qq.gdt.action.b.1
        {
            add(ActionType.START_APP);
            add(ActionType.PAGE_VIEW);
            add(ActionType.REGISTER);
            add(ActionType.VIEW_CONTENT);
            add(ActionType.CONSULT);
            add(ActionType.ADD_TO_CART);
            add(ActionType.PURCHASE);
            add(ActionType.SEARCH);
            add(ActionType.ADD_TO_WISHLIST);
            add(ActionType.INITIATE_CHECKOUT);
            add(ActionType.COMPLETE_ORDER);
            add(ActionType.DOWNLOAD_APP);
            add(ActionType.RATE);
            add(ActionType.RESERVATION);
            add(ActionType.SHARE);
            add(ActionType.APPLY);
            add(ActionType.CLAIM_OFFER);
            add(ActionType.NAVIGATE);
            add(ActionType.PRODUCT_RECOMMEND);
        }
    });
    private static final Set<String> d = Collections.unmodifiableSet(new HashSet<String>() { // from class: com.qq.gdt.action.b.2
    });
    private final Context e;
    private final Random f = new Random(System.currentTimeMillis());
    private volatile String g = bq.e;
    private int h = 30000;
    private int i = 60000;
    private int j = 100;
    private int k = 100;
    private int l = 0;
    private int m = 4;
    private Set<String> n = c;
    private int o = 14400000;
    private int p = 1800000;
    private int q = 3600000;
    private int r = 3600000;
    private Set<String> s = d;
    private int t = 0;
    private int u = 0;
    private int v = 1;
    private int w = 0;
    private int x = 1;
    private int y = 0;
    private int z = 0;
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 5;
    private int G = 1440;
    private int H = 1;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private int Q = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f10462a;
        final String b;
        final String c;

        public a(String str, String str2, String str3) {
            this.f10462a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    private b(Context context) {
        this.e = context.getApplicationContext();
        C();
    }

    private void C() {
        try {
            a aVarD = D();
            if (aVarD != null) {
                if (l.a(aVarD.b, u.a(i.b(aVarD.c)))) {
                    a(aVarD.f10462a, aVarD.c);
                } else {
                    o.c("Fail to verify local config file");
                }
            }
        } catch (Throwable th) {
            o.b("Load SDKConfig from local exception", th);
        }
    }

    private a D() throws IOException {
        File fileE = E();
        if (!fileE.exists()) {
            o.a("SDKConfig file not exist", new Object[0]);
            return null;
        }
        Scanner scanner = new Scanner(new FileInputStream(fileE));
        String strNextLine = scanner.nextLine();
        String strNextLine2 = scanner.nextLine();
        String strNextLine3 = scanner.nextLine();
        scanner.close();
        return new a(strNextLine, strNextLine2, strNextLine3);
    }

    private File E() {
        return new File(G(), b("sdk.conf"));
    }

    private File F() {
        return new File(G(), b("sdk.conf.tmp"));
    }

    private File G() {
        return this.e.getDir("a_gdt_qq_com_conf", 0);
    }

    public static b a(Context context) {
        if (f10461a == null) {
            synchronized (b.class) {
                if (f10461a == null) {
                    f10461a = new b(context);
                }
            }
        }
        return f10461a;
    }

    public boolean A() {
        return this.P == 1;
    }

    public boolean B() {
        return this.Q == 1;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }

    public boolean d() {
        return this.f.nextInt(100) < this.k;
    }

    public int e() {
        return this.m;
    }

    public int f() {
        return this.o;
    }

    public int g() {
        return this.w;
    }

    public int h() {
        return this.x;
    }

    public int i() {
        return this.y;
    }

    public int j() {
        return this.z;
    }

    public int k() {
        return this.A;
    }

    public int l() {
        return this.B;
    }

    public int m() {
        return this.C;
    }

    public int n() {
        return this.E;
    }

    public int o() {
        return this.F * 1000 * 60;
    }

    public int p() {
        return this.H;
    }

    public int q() {
        return this.I;
    }

    public int r() {
        return this.J;
    }

    public int s() {
        return this.K;
    }

    public int t() {
        return this.L;
    }

    public int u() {
        return this.N;
    }

    public int v() {
        return this.O;
    }

    public int w() {
        return this.r;
    }

    public int x() {
        return this.p;
    }

    public Set<String> y() {
        return this.s;
    }

    public boolean z() {
        return this.v == 1;
    }

    private String b(String str) {
        return str + "_" + u.a(d.a().r());
    }

    private Set<String> c(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("package_name");
        HashSet hashSet = new HashSet();
        if (jSONArrayOptJSONArray == null) {
            return d;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            hashSet.add(jSONArrayOptJSONArray.optString(i));
        }
        return hashSet;
    }

    public String a() {
        return this.g;
    }

    private void a(String str, String str2) {
        synchronized (b) {
            String str3 = new String(i.b(str2));
            o.a("======>UpdateSDKConfig:\nversion = " + str + "\noriginal_config_str = \n" + n.a(str3), new Object[0]);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                this.g = str;
                Set<String> setB = b(jSONObject);
                if (setB.isEmpty()) {
                    setB = c;
                }
                this.n = setB;
                this.s = c(jSONObject);
                this.h = jSONObject.optInt("flush_interval", 30000);
                this.i = jSONObject.optInt("ticket_interval", 60000);
                this.j = jSONObject.optInt("his_report_rate", 100);
                this.k = jSONObject.optInt("dp3_report_rate", 100);
                this.o = jSONObject.optInt("oaid_flush_interval", 14400000);
                this.p = jSONObject.optInt("oaid_err_flush_interval", 1800000);
                this.q = jSONObject.optInt("app_waid_flush_interval", 3600000);
                this.r = jSONObject.optInt("open_device_identifier_flushInterval", 3600000);
                this.l = jSONObject.optInt("action_record_strategy", 0);
                this.m = jSONObject.optInt("event_record_strategy", 4);
                this.u = jSONObject.optInt("content_provider_inited", 0);
                this.t = jSONObject.optInt("read_build_config", 0);
                this.v = jSONObject.optInt("ylh_ext_enabled", 1);
                this.w = jSONObject.optInt("bssid_open_value", 0);
                this.x = jSONObject.optInt("imsi_open_value", 1);
                this.y = jSONObject.optInt("imei_open_value", 0);
                this.z = jSONObject.optInt("meid_open_value", 0);
                this.B = jSONObject.optInt("deviceid_open_value", 0);
                this.A = jSONObject.optInt("androidid_open_value", 0);
                this.C = jSONObject.optInt("eventid_report_value", 0);
                this.D = jSONObject.optInt("dp3_report_value", 0);
                this.E = jSONObject.optInt("harmony_collect_value", 0);
                this.F = jSONObject.optInt("client_ipc_interval_time", 5);
                this.G = jSONObject.optInt("before_init_interval_time", 1440);
                this.H = jSONObject.optInt("sensitive_id_collect_times", 1);
                this.I = jSONObject.optInt("fill_process_info_value", 0);
                this.J = jSONObject.optInt("get_mobile_info_value", 0);
                this.K = jSONObject.optInt("get_app_info_value", 0);
                this.L = jSONObject.optInt("get_sdk_info_value", 0);
                this.M = jSONObject.optInt("auto_init_value", 0);
                this.N = jSONObject.optInt("action_enable_https", 0);
                this.O = jSONObject.optInt("event_enable_https", 0);
                this.P = jSONObject.optInt("disable_clickid", 0);
                this.Q = jSONObject.optInt("disable_acaid", 0);
                o.a(v.a("=====>Apply config:\nversion = %s\nflushInterval = %d\nhisReportRate = %d\ndp3ReportRate = %d\nimportantActionTypes = %s\nactionRecordStrategy = %d\neventRecordStrategy = %d\ninstallPackageNames = %s\noaidFlushInterval = %d\noaidErrorFlushInterval = %d\nappWaidFlushInterval = %d\nopenDeviceIdentifierFlushInterval = %d\ncpInited = %d\nreadBudConfig = %d\nbssidOpen = %d\neventidReport = %d\ndp3Report = %d\nharmonyCollect = %d\nclientIpcIntervalTime = %d\nbeforeInitIntervalTime = %d\nsensitive_id_collect_times = %d\nfill_process_info = %d\nget_mobile_info = %d\nget_app_info = %d\nget_sdk_info = %d\nauto_init = %d\nmeidOpen = %d\nimeiOpen = %d\ndeviceidOpen = %d\nandroididOpen = %d\nimsiOpen = %d\naction_enable_https = %d\nevent_enable_https = %d\ndisable_clickid = %d\ndisable_acaid = %d", this.g, Integer.valueOf(this.h), Integer.valueOf(this.j), Integer.valueOf(this.k), this.n, Integer.valueOf(this.l), Integer.valueOf(this.m), this.s, Integer.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r), Integer.valueOf(this.u), Integer.valueOf(this.t), Integer.valueOf(this.w), Integer.valueOf(this.C), Integer.valueOf(this.D), Integer.valueOf(this.E), Integer.valueOf(this.F), Integer.valueOf(this.G), Integer.valueOf(this.H), Integer.valueOf(this.I), Integer.valueOf(this.J), Integer.valueOf(this.K), Integer.valueOf(this.L), Integer.valueOf(this.M), Integer.valueOf(this.z), Integer.valueOf(this.y), Integer.valueOf(this.B), Integer.valueOf(this.A), Integer.valueOf(this.x), Integer.valueOf(this.N), Integer.valueOf(this.O), Integer.valueOf(this.P), Integer.valueOf(this.Q)), new Object[0]);
            } catch (JSONException e) {
                o.b("Json parse exception", e);
            }
        }
    }

    private Set<String> b(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("action_type");
        HashSet hashSet = new HashSet();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                hashSet.add(jSONArrayOptJSONArray.optString(i));
            }
        }
        return hashSet;
    }

    public boolean a(String str) {
        return this.n.contains(str);
    }

    private boolean a(String str, String str2, String str3) throws Throwable {
        PrintWriter printWriter;
        o.a("配置更新 update version = " + str + " sign = " + str2 + " data = " + str3, new Object[0]);
        if (!l.a(str2, u.a(i.b(str3)))) {
            o.c("Fail to update conf for sign check error");
            return false;
        }
        File fileF = F();
        PrintWriter printWriter2 = null;
        try {
            try {
                printWriter = new PrintWriter(new FileOutputStream(fileF));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            printWriter.println(str);
            printWriter.println(str2);
            printWriter.println(str3);
            k.a(fileF, E());
            a(str, str3);
            try {
                printWriter.close();
                return true;
            } catch (Exception unused2) {
                return true;
            }
        } catch (IOException unused3) {
            printWriter2 = printWriter;
            o.c("Exception while persist config");
            if (printWriter2 != null) {
                try {
                    printWriter2.close();
                } catch (Exception unused4) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                try {
                    printWriter2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("conf_version");
        String strOptString2 = jSONObject.optString("sig");
        String strOptString3 = jSONObject.optString("data");
        if (v.a(strOptString) || v.a(strOptString2) || v.a(strOptString3)) {
            return false;
        }
        return a(strOptString, strOptString2, strOptString3);
    }
}
