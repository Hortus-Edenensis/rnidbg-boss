package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.alipay.sdk.app.PayResultActivity;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.x;
import com.igexin.push.g.o;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.oplus.tblplayer.Constants;
import com.qq.gdt.action.ActionUtils;
import defpackage.eg7;
import defpackage.fu6;
import defpackage.hu6;
import defpackage.i07;
import defpackage.j07;
import defpackage.k07;
import defpackage.lu6;
import defpackage.mc7;
import defpackage.nf2;
import defpackage.pe7;
import defpackage.qh7;
import defpackage.ru6;
import defpackage.su6;
import defpackage.vt6;
import defpackage.w97;
import defpackage.wt6;
import defpackage.xt6;
import defpackage.xz6;
import defpackage.zd7;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PayTask {
    public static final Object h = zd7.class;
    public static long i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f2583a;
    public wt6 b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, c> g = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2584a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.f2584a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            nf2 nf2VarH5Pay = PayTask.this.h5Pay(new ru6(PayTask.this.f2583a, this.f2584a, "payInterceptorWithUrl"), this.f2584a, this.b);
            w97.h("mspl", "inc finished: " + nf2VarH5Pay.a());
            this.c.onPayResult(nf2VarH5Pay);
        }
    }

    public PayTask(Activity activity) {
        this.f2583a = activity;
        j07.e().b(this.f2583a);
        this.b = new wt6(activity, "去支付宝付款");
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        try {
            j07.e().b(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - i < vt6.I().m()) {
                return false;
            }
            i = jElapsedRealtime;
            vt6.I().f(ru6.r(), context.getApplicationContext(), false, 4);
            return true;
        } catch (Exception e) {
            w97.d(e);
            return false;
        }
    }

    public final zd7.e b() {
        return new b();
    }

    public final String c(ru6 ru6Var, i07 i07Var) {
        String[] strArrF = i07Var.f();
        Intent intent = new Intent(this.f2583a, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrF[0]);
        if (strArrF.length == 2) {
            bundle.putString("cookie", strArrF[1]);
        }
        intent.putExtras(bundle);
        ru6.a.c(ru6Var, intent);
        this.f2583a.startActivity(intent);
        Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                w97.d(e);
                return xz6.a();
            }
        }
        String strG = xz6.g();
        return TextUtils.isEmpty(strG) ? xz6.a() : strG;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        r0 = r6.f();
        r11 = defpackage.xz6.b(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], defpackage.qh7.Q(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String d(ru6 ru6Var, i07 i07Var, String str) {
        boolean zF;
        String strG;
        String[] strArrF = i07Var.f();
        Intent intent = new Intent(this.f2583a, (Class<?>) H5PayActivity.class);
        try {
            JSONObject jSONObjectY = qh7.Y(new String(lu6.d(strArrF[2])));
            intent.putExtra("url", strArrF[0]);
            intent.putExtra("title", strArrF[1]);
            intent.putExtra("version", "v2");
            intent.putExtra(ActionUtils.METHOD, jSONObjectY.optString(ActionUtils.METHOD, "POST"));
            xz6.d(false);
            xz6.c(null);
            ru6.a.c(ru6Var, intent);
            this.f2583a.startActivity(intent);
            Object obj = h;
            synchronized (obj) {
                try {
                    obj.wait();
                    zF = xz6.f();
                    strG = xz6.g();
                    xz6.d(false);
                    xz6.c(null);
                } catch (InterruptedException e) {
                    w97.d(e);
                    return xz6.a();
                }
            }
            String strB = "";
            if (zF) {
                try {
                    List<i07> listB = i07.b(qh7.Y(new String(lu6.d(strG))));
                    int i2 = 0;
                    while (true) {
                        if (i2 >= listB.size()) {
                            break;
                        }
                        i07 i07Var2 = listB.get(i2);
                        if (i07Var2.a() == com.alipay.sdk.m.r.a.SetResult) {
                            break;
                        }
                        i2++;
                    }
                } catch (Throwable th) {
                    w97.d(th);
                    xt6.d(ru6Var, "biz", "H5PayDataAnalysisError", th, strG);
                }
            }
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
            try {
                return xz6.b(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th2) {
                xt6.d(ru6Var, "biz", "H5PayDataAnalysisError", th2, "endCode: " + str);
                return xz6.b(8000, "", "");
            }
        } catch (Throwable th3) {
            w97.d(th3);
            xt6.d(ru6Var, "biz", "H5PayDataAnalysisError", th3, Arrays.toString(strArrF));
            return xz6.a();
        }
    }

    public void dismissLoading() {
        wt6 wt6Var = this.b;
        if (wt6Var != null) {
            wt6Var.c();
            this.b = null;
        }
    }

    public final String e(ru6 ru6Var, String str) {
        showLoading();
        com.alipay.sdk.m.j.c cVarB = null;
        try {
            try {
                try {
                    JSONObject jSONObjectC = new mc7().b(ru6Var, this.f2583a.getApplicationContext(), str).c();
                    String strOptString = jSONObjectC.optString("end_code", null);
                    List<i07> listB = i07.b(jSONObjectC.optJSONObject("form").optJSONObject("onload"));
                    for (int i2 = 0; i2 < listB.size(); i2++) {
                        if (listB.get(i2).a() == com.alipay.sdk.m.r.a.Update) {
                            i07.c(listB.get(i2));
                        }
                    }
                    j(ru6Var, jSONObjectC);
                    dismissLoading();
                    xt6.f(this.f2583a, ru6Var, str, ru6Var.d);
                    for (int i3 = 0; i3 < listB.size(); i3++) {
                        i07 i07Var = listB.get(i3);
                        if (i07Var.a() == com.alipay.sdk.m.r.a.WapPay) {
                            String strC = c(ru6Var, i07Var);
                            dismissLoading();
                            xt6.f(this.f2583a, ru6Var, str, ru6Var.d);
                            return strC;
                        }
                        if (i07Var.a() == com.alipay.sdk.m.r.a.OpenWeb) {
                            String strD = d(ru6Var, i07Var, strOptString);
                            dismissLoading();
                            xt6.f(this.f2583a, ru6Var, str, ru6Var.d);
                            return strD;
                        }
                    }
                    dismissLoading();
                    xt6.f(this.f2583a, ru6Var, str, ru6Var.d);
                } catch (IOException e) {
                    com.alipay.sdk.m.j.c cVarB2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                    xt6.e(ru6Var, TKDownloadReason.KSAD_TK_NET, e);
                    dismissLoading();
                    xt6.f(this.f2583a, ru6Var, str, ru6Var.d);
                    cVarB = cVarB2;
                }
            } catch (Throwable th) {
                w97.d(th);
                xt6.c(ru6Var, "biz", "H5PayDataAnalysisError", th);
                dismissLoading();
                xt6.f(this.f2583a, ru6Var, str, ru6Var.d);
            }
            if (cVarB == null) {
                cVarB = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
            }
            return xz6.b(cVarB.b(), cVarB.a(), "");
        } catch (Throwable th2) {
            dismissLoading();
            xt6.f(this.f2583a, ru6Var, str, ru6Var.d);
            throw th2;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015f A[Catch: all -> 0x01fc, PHI: r9
      0x015f: PHI (r9v18 java.lang.String) = (r9v17 java.lang.String), (r9v20 java.lang.String) binds: [B:34:0x015d, B:29:0x0107] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String f(ru6 ru6Var, String str, boolean z) {
        String strA;
        if (z) {
            showLoading();
            if (str.contains("payment_inst=")) {
                fu6.b("");
            } else {
                String strSubstring = str.substring(str.indexOf("payment_inst=") + 13);
                int iIndexOf = strSubstring.indexOf(38);
                if (iIndexOf > 0) {
                    strSubstring = strSubstring.substring(0, iIndexOf);
                }
                fu6.b(strSubstring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
            }
            if (str.contains("service=alipay.acquire.mr.ord.createandpay")) {
                hu6.c = true;
            }
            if (hu6.c) {
                if (str.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
                    str = str.substring(str.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
                } else if (str.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?")) {
                    str = str.substring(str.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
                }
            }
            strA = "";
            try {
                w97.h("mspl", "pay prepared: " + str);
                strA = g(str, ru6Var);
                w97.h("mspl", "pay raw result: " + strA);
                pe7.c(ru6Var, this.f2583a.getApplicationContext(), strA);
                xt6.b(ru6Var, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
                xt6.b(ru6Var, "biz", "PgReturnV", eg7.a(strA, "resultStatus") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + eg7.a(strA, "memo"));
            } catch (Throwable th) {
                try {
                    strA = xz6.a();
                    w97.d(th);
                    xt6.b(ru6Var, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
                    xt6.b(ru6Var, "biz", "PgReturnV", eg7.a(strA, "resultStatus") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + eg7.a(strA, "memo"));
                    if (!vt6.I().A()) {
                    }
                } catch (Throwable th2) {
                    xt6.b(ru6Var, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
                    xt6.b(ru6Var, "biz", "PgReturnV", eg7.a(strA, "resultStatus") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + eg7.a(strA, "memo"));
                    if (!vt6.I().A()) {
                        vt6.I().f(ru6Var, this.f2583a.getApplicationContext(), false, 3);
                    }
                    dismissLoading();
                    xt6.h(this.f2583a.getApplicationContext(), ru6Var, str, ru6Var.d);
                    throw th2;
                }
            }
            if (!vt6.I().A()) {
                vt6.I().f(ru6Var, this.f2583a.getApplicationContext(), false, 3);
            }
            dismissLoading();
            xt6.h(this.f2583a.getApplicationContext(), ru6Var, str, ru6Var.d);
            w97.h("mspl", "pay returning: " + strA);
        } else {
            if (str.contains("payment_inst=")) {
            }
            if (str.contains("service=alipay.acquire.mr.ord.createandpay")) {
            }
            if (hu6.c) {
            }
            strA = "";
            w97.h("mspl", "pay prepared: " + str);
            strA = g(str, ru6Var);
            w97.h("mspl", "pay raw result: " + strA);
            pe7.c(ru6Var, this.f2583a.getApplicationContext(), strA);
            xt6.b(ru6Var, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
            xt6.b(ru6Var, "biz", "PgReturnV", eg7.a(strA, "resultStatus") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + eg7.a(strA, "memo"));
            if (!vt6.I().A()) {
            }
            dismissLoading();
            xt6.h(this.f2583a.getApplicationContext(), ru6Var, str, ru6Var.d);
            w97.h("mspl", "pay returning: " + strA);
        }
        return strA;
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strTrim = str.trim();
                if (strTrim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || strTrim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String strTrim2 = strTrim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + qh7.l("<request_token>", "</request_token>", qh7.F(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.f2583a) + "\"";
                    }
                }
                if (strTrim.startsWith("https://mclient.alipay.com/service/rest.htm") || strTrim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String strTrim3 = strTrim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + qh7.l("<request_token>", "</request_token>", qh7.F(strTrim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.f2583a) + "\"";
                    }
                }
                if ((strTrim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || strTrim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((strTrim.contains("alipay.wap.create.direct.pay.by.user") || strTrim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(strTrim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", a(this.f2583a));
                    return "new_external_info==" + jSONObject.toString();
                }
                a aVar = null;
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String strL = qh7.l(Constants.STRING_VALUE_UNSET, "", str);
                    if (!TextUtils.isEmpty(strL)) {
                        Map<String, String> mapF = qh7.F(strL);
                        StringBuilder sb = new StringBuilder();
                        if (k(false, true, "trade_no", sb, mapF, "trade_no", "alipay_trade_no")) {
                            k(true, false, "pay_phase_id", sb, mapF, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = mapF.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(mapF.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(mapF.get("sid")) || !TextUtils.isEmpty(mapF.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!k(true, true, "extern_token", sb, mapF, "extern_token", "cid", "sid", "s_id")) {
                                return "";
                            }
                            k(true, false, "appenv", sb, mapF, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            c cVar = new c(this, aVar);
                            cVar.d(mapF.get("return_url"));
                            cVar.f(mapF.get("show_url"));
                            cVar.b(mapF.get("pay_order_id"));
                            String str3 = sb.toString() + "&bizcontext=\"" + a(this.f2583a) + "\"";
                            this.g.put(str3, cVar);
                            return str3;
                        }
                    }
                }
                if (!strTrim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !strTrim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.a() || !strTrim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (vt6.I().q() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(strTrim).find()) {
                        Uri uri = Uri.parse(strTrim);
                        String queryParameter = uri.getQueryParameter("return_url");
                        String queryParameter2 = uri.getQueryParameter("show_url");
                        String queryParameter3 = uri.getQueryParameter("pay_order_id");
                        String strA = a(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                        String strA2 = a(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = uri.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(uri.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(uri.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(uri.getQueryParameter("s_id")) ? "tb" : "";
                        String strA3 = a(strArr);
                        String strA4 = a(uri.getQueryParameter("extern_token"), uri.getQueryParameter("cid"), uri.getQueryParameter("sid"), uri.getQueryParameter("s_id"));
                        String strA5 = a(uri.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strA3) && !TextUtils.isEmpty(strA4)) {
                            String str4 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strA, strA2, strA3, strA4, strA5, a(this.f2583a));
                            c cVar2 = new c(this, null);
                            cVar2.d(queryParameter);
                            cVar2.f(queryParameter2);
                            cVar2.b(queryParameter3);
                            cVar2.h(strA);
                            this.g.put(str4, cVar2);
                            return str4;
                        }
                    }
                }
                String strA6 = a(this.f2583a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", strTrim);
                jSONObject2.put("bizcontext", strA6);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th) {
            w97.d(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return pe7.a(new ru6(this.f2583a, "", "fetchTradeToken"), this.f2583a.getApplicationContext());
    }

    public final String g(String str, ru6 ru6Var) {
        String strB = ru6Var.b(str);
        if (strB.contains("paymethod=\"expressGateway\"")) {
            return e(ru6Var, strB);
        }
        List<vt6.b> listU = vt6.I().u();
        if (!vt6.I().g || listU == null) {
            listU = fu6.d;
        }
        if (!qh7.v(ru6Var, this.f2583a, listU, true)) {
            xt6.a(ru6Var, "biz", "LogCalledH5");
            return e(ru6Var, strB);
        }
        zd7 zd7Var = new zd7(this.f2583a, ru6Var, b());
        w97.h("mspl", "pay inner started: " + strB);
        String strH = zd7Var.h(strB, false);
        if (!TextUtils.isEmpty(strH)) {
            StringBuilder sb = new StringBuilder();
            sb.append("resultStatus={");
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT;
            sb.append(cVar.b());
            sb.append("}");
            if (strH.contains(sb.toString())) {
                qh7.t("alipaySdk", "startActivityEx", this.f2583a, ru6Var);
                if (vt6.I().F()) {
                    strH = zd7Var.h(strB, true);
                } else {
                    strH = strH.replace("resultStatus={" + cVar.b() + "}", "resultStatus={" + com.alipay.sdk.m.j.c.CANCELED.b() + "}");
                }
            }
        }
        w97.h("mspl", "pay inner raw result: " + strH);
        zd7Var.i();
        if (TextUtils.equals(strH, "failed") || TextUtils.equals(strH, "scheme_failed")) {
            xt6.a(ru6Var, "biz", "LogBindCalledH5");
            return e(ru6Var, strB);
        }
        if (TextUtils.isEmpty(strH)) {
            return xz6.a();
        }
        if (!strH.contains("{\"isLogin\":\"false\"}")) {
            return strH;
        }
        xt6.a(ru6Var, "biz", "LogHkLoginByIntent");
        return a(ru6Var, strB, listU, strH, this.f2583a);
    }

    public String getVersion() {
        return "15.8.10";
    }

    public final String h(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    public synchronized nf2 h5Pay(ru6 ru6Var, String str, boolean z) {
        nf2 nf2Var;
        nf2Var = new nf2();
        try {
            String[] strArrSplit = f(ru6Var, str, z).split(x.aQ);
            HashMap map = new HashMap();
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("={");
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    map.put(strSubstring, h(str2, strSubstring));
                }
            }
            if (map.containsKey("resultStatus")) {
                nf2Var.c(map.get("resultStatus"));
            }
            nf2Var.d(i(str, map));
            if (TextUtils.isEmpty(nf2Var.b())) {
                xt6.g(ru6Var, "biz", "H5CbUrlEmpty", "");
            }
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "H5CbEx", th);
            w97.d(th);
        }
        return nf2Var;
    }

    public final String i(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean zEquals = "9000".equals(map.get("resultStatus"));
        String str2 = map.get("result");
        c cVarRemove = this.g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = cVarRemove != null ? cVarRemove.a() : "";
        strArr[1] = cVarRemove != null ? cVarRemove.g() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String strA = a(qh7.l("&callBackUrl=\"", "\"", str2), qh7.l("&call_back_url=\"", "\"", str2), qh7.l("&return_url=\"", "\"", str2), URLDecoder.decode(qh7.l("&return_url=", ContainerUtils.FIELD_DELIMITER, str2), "utf-8"), URLDecoder.decode(qh7.l("&callBackUrl=", ContainerUtils.FIELD_DELIMITER, str2), "utf-8"), qh7.l("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (cVarRemove != null) {
            String strC = zEquals ? cVarRemove.c() : cVarRemove.e();
            if (!TextUtils.isEmpty(strC)) {
                return strC;
            }
        }
        return cVarRemove != null ? vt6.I().z() : "";
    }

    public final void j(ru6 ru6Var, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("tid");
            String strOptString2 = jSONObject.optString("client_key");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            su6.a(j07.e().c()).b(strOptString, strOptString2);
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "ParserTidClientKeyEx", th);
        }
    }

    public final boolean k(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        }
        if (!z) {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
        sb.append(ContainerUtils.FIELD_DELIMITER);
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
        return true;
    }

    public synchronized String pay(String str, boolean z) {
        if (k07.a()) {
            return xz6.e();
        }
        return f(new ru6(this.f2583a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String strFetchOrderInfoFromH5PayUrl;
        strFetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl)) {
            w97.h("mspl", "intercepted: " + strFetchOrderInfoFromH5PayUrl);
            new Thread(new a(strFetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String strF;
        ru6 ru6Var;
        if (k07.a()) {
            strF = xz6.e();
            ru6Var = null;
        } else {
            ru6 ru6Var2 = new ru6(this.f2583a, str, "payV2");
            strF = f(ru6Var2, str, z);
            ru6Var = ru6Var2;
        }
        return eg7.c(ru6Var, strF);
    }

    public void showLoading() {
        wt6 wt6Var = this.b;
        if (wt6Var != null) {
            wt6Var.f();
        }
    }

    public static String a(Context context) {
        String str;
        String str2;
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
        } catch (Exception e) {
            e = e;
            str = "";
        }
        try {
            str2 = packageInfo.packageName;
        } catch (Exception e2) {
            e = e2;
            w97.d(e);
            str2 = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", "2014052600006128");
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_TYPE, "and_lite");
            jSONObject.put("sv", "h.a.3.8.10");
            jSONObject.put("an", str2);
            jSONObject.put(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO, str);
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(o.e)) {
                jSONObject.put(o.e, "h5tonative");
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            w97.d(th);
            return "";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2586a;
        public String b;
        public String c;
        public String d;

        public c() {
            this.f2586a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public String a() {
            return this.c;
        }

        public void b(String str) {
            this.c = str;
        }

        public String c() {
            return this.f2586a;
        }

        public void d(String str) {
            this.f2586a = str;
        }

        public String e() {
            return this.b;
        }

        public void f(String str) {
            this.b = str;
        }

        public String g() {
            return this.d;
        }

        public void h(String str) {
            this.d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements zd7.e {
        public b() {
        }

        @Override // zd7.e
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // zd7.e
        public void b() {
        }
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static String a(ru6 ru6Var, String str, List<vt6.b> list, String str2, Activity activity) {
        qh7.c cVarQ = qh7.q(ru6Var, activity, list);
        if (cVarQ == null || cVarQ.b(ru6Var) || cVarQ.a() || !TextUtils.equals(cVarQ.f20254a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        w97.f("mspl", "PayTask not_login");
        String strValueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> map = PayResultActivity.b;
        map.put(strValueOf, obj);
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra("orderSuffix", str);
        intent.putExtra("externalPkgName", activity.getPackageName());
        intent.putExtra("phonecashier.pay.hash", strValueOf);
        ru6.a.c(ru6Var, intent);
        activity.startActivity(intent);
        synchronized (map.get(strValueOf)) {
            try {
                w97.f("mspl", "PayTask wait");
                map.get(strValueOf).wait();
            } catch (InterruptedException unused) {
                w97.f("mspl", "PayTask interrupted");
                return xz6.a();
            }
        }
        String str3 = PayResultActivity.b.b;
        w97.f("mspl", "PayTask ret: " + str3);
        return str3;
    }
}
