package com.apm.lite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.apm.lite.MonitorCrash;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.efs.sdk.base.Constants;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.hv6;
import defpackage.kj7;
import defpackage.q37;
import defpackage.vf7;
import defpackage.wf7;
import defpackage.x97;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MonitorCrash.Config f3289a;
    public Map<String, String> b;
    public volatile JSONObject c;

    public static vf7 b(String str, byte[] bArr, String str2, String str3) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                hv6.a(httpURLConnection);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpURLConnection.setRequestProperty("Content-Encoding", Constants.CP_GZIP);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty("aid", str2);
                    httpURLConnection.setRequestProperty("x-auth-token", str3);
                }
                httpURLConnection.setRequestMethod("POST");
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            wf7.a(dataOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            wf7.a(dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = null;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    vf7 vf7Var = new vf7(responseCode, "http response code " + responseCode);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused) {
                    }
                    wf7.a(null);
                    return vf7Var;
                }
                vf7 vf7Var2 = new vf7(206, "http response code " + responseCode);
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                }
                wf7.a(null);
                return vf7Var2;
            } catch (Throwable th3) {
                th = th3;
                try {
                    kj7.f(th);
                    return new vf7(207, th);
                } finally {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused3) {
                        }
                    }
                    wf7.a(null);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    public String a() {
        return null;
    }

    public final JSONObject c(HashMap<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (this.c == null) {
            Context contextM = x97.m();
            try {
                this.c = new JSONObject();
                if (this.b != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : this.b.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    this.c.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
                }
                this.c.put("os", AnalyticsConstants.SDK_TYPE);
                this.c.put("platform", AnalyticsConstants.SDK_TYPE);
                this.c.put("os_version", q37.k());
                this.c.put("os_api", Build.VERSION.SDK_INT);
                this.c.put("sdk_version", this.f3289a.d);
                this.c.put("sdk_version_code", this.f3289a.d);
                this.c.put("sdk_version_name", this.f3289a.e);
                this.c.put("aid", this.f3289a.f3285a);
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                this.c.put("device_model", str);
                this.c.put(bt.F, str2);
                this.c.put(bt.H, Build.MANUFACTURER);
                this.c.put("channel", this.f3289a.c);
                this.c.put("app_version", this.f3289a.e);
                this.c.put("version_code", this.f3289a.d);
                this.c.put("update_version_code", this.f3289a.d);
                this.c.put("manifest_version_code", this.f3289a.d);
                this.c.put("bd_did", this.f3289a.getDeviceId());
                String packageName = contextM.getPackageName();
                this.c.put("package", packageName);
                PackageInfo packageInfo = contextM.getPackageManager().getPackageInfo(packageName, 0);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null) {
                    int i = applicationInfo.labelRes;
                    if (i > 0) {
                        this.c.put(bt.s, contextM.getString(i));
                    } else {
                        this.c.put(bt.s, contextM.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
                    }
                }
            } catch (Exception unused) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", this.c);
        jSONObject.put("local_time", jCurrentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", jCurrentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put("session_id", UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis2)));
        if (map != null) {
            JSONObject jSONObject4 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                jSONObject4.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject3.put("pv_filters", jSONObject4);
        }
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    public void d(Context context, MonitorCrash.Config config, Map<String, String> map) {
        if (config == null) {
            return;
        }
        this.f3289a = config;
        this.b = map;
    }

    public void f(HashMap<String, String> map, IUploadCallback iUploadCallback) {
        MonitorCrash.Config config = this.f3289a;
        if (config == null && !TextUtils.isEmpty(config.getDeviceId())) {
            if (iUploadCallback != null) {
                iUploadCallback.afterUpload(false);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObjectC = c(map);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(jSONObjectC.toString().getBytes("UTF-8"));
                    wf7.a(gZIPOutputStream2);
                } catch (Throwable unused) {
                    gZIPOutputStream = gZIPOutputStream2;
                    wf7.a(gZIPOutputStream);
                }
            } catch (Throwable unused2) {
            }
            wf7.a(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str = x97.o().getPageViewUrl() + "?version_code=" + this.f3289a.d + "&device_platform=android&aid=" + this.f3289a.f3285a + "&iid=iid";
            MonitorCrash.Config config2 = this.f3289a;
            vf7 vf7VarB = b(str, byteArray, config2.f3285a, config2.b);
            if (iUploadCallback != null) {
                iUploadCallback.afterUpload(vf7VarB.a());
            }
        } catch (Throwable unused3) {
        }
    }

    public void e(String str) {
    }

    public void g(String str) {
    }
}
