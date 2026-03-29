package a.a.b.a.b;

import a.a.a.a.a.a.h;
import a.a.b.a.a.a;
import a.a.c.a.b.b;
import a.a.c.a.d.g;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.qiniu.android.collect.ReportItem;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import defpackage.pn;
import j$.util.Objects;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1072a;

    public a(Context context) {
        this.f1072a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        ?? r4;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        JSONObject jSONObject;
        String str;
        String str2;
        URLConnection uRLConnectionOpenConnection;
        HashMap map;
        pn pnVar = pn.d;
        pnVar.a().c();
        ?? r3 = 1;
        if (pnVar.a().getEnableOAID()) {
            a.a.c.a.b.b bVar = new a.a.c.a.b.b(new b.a(this.f1072a));
            if (bVar.c) {
                if (bVar.e.compareAndSet(false, true)) {
                    bVar.f = a.a.c.a.e.f.a.b.b(new Object[0]).submit(new a.a.c.a.b.a(bVar));
                }
                a.a.c.a.b.d dVar = bVar.g;
                if (dVar == null) {
                    try {
                        a.a.c.a.b.d dVar2 = bVar.f.get(bVar.f1103a instanceof g ? 1100L : 1000L, TimeUnit.MILLISECONDS);
                        SystemClock.elapsedRealtime();
                        dVar = dVar2;
                    } catch (Throwable th) {
                        try {
                            bVar.f.cancel(true);
                            a.a.c.a.b.d dVar3 = bVar.g;
                            if (dVar3 != null) {
                                dVar3.h = th.getMessage();
                            }
                            th.getMessage();
                        } finally {
                            SystemClock.elapsedRealtime();
                        }
                    }
                }
                if (dVar == null) {
                    dVar = bVar.g;
                }
                if (dVar != null) {
                    map = new HashMap();
                    a.a.c.a.b.b.a(map, "id", dVar.f1106a);
                    a.a.c.a.b.b.a(map, ReportItem.RequestKeyRequestId, dVar.b);
                    a.a.c.a.b.b.a(map, "is_track_limited", String.valueOf(dVar.c));
                    a.a.c.a.b.b.a(map, "take_ms", String.valueOf(dVar.d));
                    a.a.c.a.b.b.a(map, "time", String.valueOf(dVar.e));
                    a.a.c.a.b.b.a(map, "query_times", String.valueOf(dVar.f));
                    a.a.c.a.b.b.a(map, "hw_id_version_code", String.valueOf(dVar.g));
                    a.a.c.a.b.b.a(map, "error_msg", dVar.h);
                } else {
                    map = null;
                }
                Objects.toString(map);
            } else {
                map = null;
            }
            if (map != null) {
                b.b = System.currentTimeMillis();
                String str3 = (String) map.get("id");
                if (str3 == null) {
                    str3 = "";
                }
                b.c = str3;
            }
            String msg = "oaid fetch: " + b.c.length();
            Intrinsics.checkNotNullParameter("Convert:Event", "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (pn.d.a().getEnableLog()) {
                Log.d("Convert:Event", msg);
            }
            if (!TextUtils.isEmpty(b.c) && b.f1073a != null) {
                d.b.a();
            }
        }
        a.C0002a c0002a = a.a.b.a.a.a.f1070a;
        Context context = this.f1072a;
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        String str4 = a.a.b.a.a.a.c + "?package_name=" + packageName + "&sdk_version=" + context.getPackageManager().getApplicationInfo(packageName, 128).metaData.getString("hume_convert.AppConvert.sdk.version");
        long jCurrentTimeMillis = System.currentTimeMillis();
        URL url = new URL(str4);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter("Convert:Config", "tag");
        Intrinsics.checkNotNullParameter("Convert:Config", "tag");
        Intrinsics.checkNotNullParameter("start request", "msg");
        pn pnVar2 = pn.d;
        if (pnVar2.a().getEnableLog()) {
            Log.d("Convert:Config", "start request");
        }
        try {
            try {
                uRLConnectionOpenConnection = url.openConnection();
            } catch (Throwable th2) {
                th = th2;
                r4 = url;
            }
        } catch (Exception e) {
            e = e;
            inputStream = null;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            r3 = 0;
            r4 = 0;
        }
        if (uRLConnectionOpenConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            try {
                Intrinsics.checkNotNullExpressionValue(inputStream, "inputStream");
                jSONObject = new JSONObject(new String(ByteStreamsKt.readBytes(inputStream), Charsets.UTF_8));
                inputStream.close();
                String msg2 = "post: response: " + httpURLConnection.getResponseCode() + "\t" + httpURLConnection.getHeaderField("X-Tt-Logid");
                Intrinsics.checkNotNullParameter("Convert:Config", "tag");
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (pnVar2.a().getEnableLog()) {
                    Log.d("Convert:Config", msg2);
                }
                httpURLConnection.disconnect();
                inputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                String msg3 = "request error" + e.getMessage();
                Intrinsics.checkNotNullParameter("Convert:Config", "tag");
                Intrinsics.checkNotNullParameter(msg3, "msg");
                if (pn.d.a().getEnableLog()) {
                    Log.d("Convert:Config", msg3);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("err_code", "-1");
                jSONObject2.put("err_msg", e.getMessage());
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                jSONObject = jSONObject2;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            r4 = httpURLConnection;
            r3 = 0;
            if (r4 != 0) {
                r4.disconnect();
            }
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
        a.a.b.a.a.a.e = System.currentTimeMillis();
        String msg4 = "remote config fetch cost time:" + (a.a.b.a.a.a.e - jCurrentTimeMillis);
        Intrinsics.checkNotNullParameter("Convert:Config", "tag");
        Intrinsics.checkNotNullParameter(msg4, "msg");
        pn pnVar3 = pn.d;
        if (pnVar3.a().getEnableLog()) {
            Log.d("Convert:Config", msg4);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("inode_collect");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optBoolean("enable", false);
            jSONObjectOptJSONObject.optLong(WkAdConfigModel.TAG_TIMEOUT, 200L);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("uaid_collect");
        if (jSONObjectOptJSONObject2 != null) {
            a.a.b.a.a.a.d.f1055a = jSONObjectOptJSONObject2.optBoolean("enable", false);
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("mobile");
            if (jSONObjectOptJSONObject3 != null) {
                a.a.b.a.a.a.d.b.f1054a = jSONObjectOptJSONObject3.optBoolean("enable", false);
                str = "Convert:Event";
                str2 = "tag";
                a.a.b.a.a.a.d.b.b = jSONObjectOptJSONObject3.optLong(WkAdConfigModel.TAG_TIMEOUT, 3300000L);
            } else {
                str = "Convert:Event";
                str2 = "tag";
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("telecom");
            if (jSONObjectOptJSONObject4 != null) {
                a.a.b.a.a.a.d.c.f1054a = jSONObjectOptJSONObject4.optBoolean("enable", false);
                a.a.b.a.a.a.d.c.b = jSONObjectOptJSONObject4.optLong(WkAdConfigModel.TAG_TIMEOUT, 3300000L);
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject("unicom");
            if (jSONObjectOptJSONObject5 != null) {
                a.a.b.a.a.a.d.d.f1054a = jSONObjectOptJSONObject5.optBoolean("enable", false);
                a.a.b.a.a.a.d.d.b = jSONObjectOptJSONObject5.optLong(WkAdConfigModel.TAG_TIMEOUT, 40000L);
            }
        } else {
            str = "Convert:Event";
            str2 = "tag";
        }
        String msg5 = "remote config total cost time:" + (System.currentTimeMillis() - jCurrentTimeMillis);
        String str5 = str2;
        Intrinsics.checkNotNullParameter("Convert:Config", str5);
        Intrinsics.checkNotNullParameter(msg5, "msg");
        if (pnVar3.a().getEnableLog()) {
            Log.d("Convert:Config", msg5);
        }
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, str5);
        Intrinsics.checkNotNullParameter("Config fetch", "msg");
        if (pnVar3.a().getEnableLog()) {
            Log.d(str6, "Config fetch");
        }
        h.c.a(a.a.b.a.a.a.d);
        if (a.a.b.a.a.a.d.f1055a) {
            Context context2 = this.f1072a;
            Intrinsics.checkNotNullParameter(context2, "context");
            new Thread(new a.a.a.a.a.a.g(context2, null)).start();
        }
    }
}
