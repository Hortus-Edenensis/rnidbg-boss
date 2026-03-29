package com.zx.a.I8b7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zx.module.annotation.Java2C;
import com.zx.module.base.Callback;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f16833a = f();
    public final String[] b = d();
    public final String[] c = c();

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"NewApi"})
    public class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConnectivityManager f16834a;
        public Callback b;
        public TimerTask d;
        public JSONObject e;
        public int f;
        public final AtomicBoolean g = new AtomicBoolean(false);
        public Timer c = new Timer();

        /* JADX INFO: renamed from: com.zx.a.I8b7.n3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1179a extends TimerTask {
            public C1179a(n3 n3Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    a aVar = a.this;
                    Callback callback = aVar.b;
                    if (callback != null) {
                        callback.callback(n3.this.a("wifi 情况下切换数据网络超时, 检查是否打开数据网络!", 1));
                    }
                } catch (JSONException e) {
                    r2.a(e);
                }
            }
        }

        public a(JSONObject jSONObject, ConnectivityManager connectivityManager, Callback callback, int i) {
            this.e = jSONObject;
            this.f = i;
            this.f16834a = connectivityManager;
            this.b = callback;
            C1179a c1179a = new C1179a(n3.this);
            this.d = c1179a;
            this.c.schedule(c1179a, 7000L);
        }

        @Java2C.Method2C
        private native void a(Network network, String str);

        public final void a(Network network) throws Throwable {
            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL(n3.this.b[0]));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            JSONObject jSONObjectA = n3.this.a();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(jSONObjectA.toString());
            bufferedWriter.close();
            JSONObject jSONObject = new JSONObject(u1.a(x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b()).getJSONObject("body");
            String string = jSONObject.getString("resultCode");
            String string2 = jSONObject.getString("resultDesc");
            httpURLConnection.disconnect();
            if ("103000".equals(string) && "成功".equals(string2)) {
                n3.this.a(this.e, this.b, this.f, "cmcc", jSONObject.getString("token"), null);
            } else {
                this.b.callback(n3.this.b(jSONObject.toString()));
            }
        }

        public final void b(Network network) throws Exception {
            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL(n3.this.c[0]));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            String strSubstring = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
            String strA = n3.this.a(strSubstring);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(strA);
            bufferedWriter.close();
            JSONObject jSONObject = new JSONObject(u1.a(x0.b(""), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            httpURLConnection.disconnect();
            String string = jSONObject.getString("msg");
            int i = jSONObject.getInt("result");
            String strOptString = jSONObject.optString("data");
            if (i == 0 && "success".equals(string) && !TextUtils.isEmpty(strOptString)) {
                n3.this.a(this.e, this.b, this.f, "ct", n3.this.a(strSubstring, strOptString), null);
            } else {
                this.b.callback(n3.this.b(jSONObject.toString()));
            }
        }

        public final void c(Network network) throws Throwable {
            n3 n3Var = n3.this;
            String strC = n3Var.c(n3Var.f16833a[0]);
            r2.a("unicomUAIDNisportalUrl: " + strC);
            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL(strC));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.connect();
            JSONObject jSONObject = new JSONObject(u1.a(x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            String strOptString = jSONObject.optString("authurl");
            if (TextUtils.isEmpty(strOptString)) {
                this.b.callback(n3.this.b(jSONObject.toString()));
                return;
            }
            String strC2 = n3.this.c(strOptString);
            r2.a("unicomUAIDAuthUrl: " + strC2);
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) network.openConnection(new URL(strC2));
            httpURLConnection2.setConnectTimeout(7000);
            httpURLConnection2.setReadTimeout(7000);
            httpURLConnection2.connect();
            JSONObject jSONObject2 = new JSONObject(u1.a(x0.b("text/json; charset=utf-8"), httpURLConnection2.getContentLength(), httpURLConnection2.getResponseCode() == 200 ? httpURLConnection2.getInputStream() : httpURLConnection2.getErrorStream()).b());
            String strOptString2 = jSONObject2.optString("code");
            if (TextUtils.isEmpty(strOptString2)) {
                this.b.callback(n3.this.b(jSONObject2.toString()));
                return;
            }
            r2.a("unicomUAID code: " + strOptString2);
            a(network, strOptString2);
            httpURLConnection.disconnect();
            httpURLConnection2.disconnect();
            n3.this.a(this.e, this.b, this.f, "unicom", strOptString2, jSONObject2.optString(DistrictSearchQuery.KEYWORDS_PROVINCE, null));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            try {
                if (this.g.getAndSet(true)) {
                    return;
                }
                r2.a("zx 网络切换: 使用移动网络访问");
                this.d.cancel();
                this.c.cancel();
                String strB = w3.b(m3.f16830a);
                if ("中国联通".equals(strB)) {
                    c(network);
                } else if ("中国移动".equals(strB)) {
                    a(network);
                } else if ("中国电信".equals(strB)) {
                    b(network);
                } else {
                    this.b.callback(n3.this.a("暂不支持该运营商", 1));
                }
                this.f16834a.unregisterNetworkCallback(this);
            } catch (Throwable th) {
                r2.a(th);
                Callback callback = this.b;
                if (callback != null) {
                    try {
                        callback.callback(n3.this.a(th.getMessage(), 1));
                        this.f16834a.unregisterNetworkCallback(this);
                    } catch (JSONException e) {
                        r2.a(e);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n3 f16836a = new n3();
    }

    @Java2C.Method2C
    private native String a(Callback callback) throws Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native String a(String str) throws Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native String a(String str, String str2) throws BadPaddingException, JSONException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native JSONObject a() throws JSONException;

    @Java2C.Method2C
    private native void a(JSONObject jSONObject, Callback callback, int i) throws Throwable;

    @Java2C.Method2C
    private native String b(Callback callback) throws Exception;

    @Java2C.Method2C
    private final native String[] b();

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native String c(String str);

    @Java2C.Method2C
    private native JSONObject c(Callback callback) throws Throwable;

    @Java2C.Method2C
    private final native String[] c();

    @Java2C.Method2C
    private final native String[] d();

    @Java2C.Method2C
    private native String e();

    @Java2C.Method2C
    private final native String[] f();

    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(JSONObject jSONObject, Callback callback, int i) throws Throwable {
        boolean zBooleanValue;
        boolean zA = w3.a(m3.f16830a, com.kuaishou.weapon.p0.g.d, false);
        boolean zA2 = w3.a(m3.f16830a, "android.permission.CHANGE_NETWORK_STATE", false);
        int i2 = Build.VERSION.SDK_INT;
        if (!zA || !zA2) {
            r2.a("开始执行getUAID333");
            a(jSONObject, callback, i);
            return;
        }
        Context context = m3.f16830a;
        r2.a("getUAID:forceSendRequestByMobileData with cb");
        boolean z = true;
        if (i2 < 24) {
            zBooleanValue = true;
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                zBooleanValue = ((Boolean) telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]).invoke(telephonyManager, new Object[0])).booleanValue();
            } catch (Exception unused) {
                zBooleanValue = true;
            }
        }
        if (!zBooleanValue) {
            r2.a("zx 网络切换: 移动网络不可用，提示请打开移动网络");
            callback.callback(a("zx 网络切换: 移动网络不可用，提示请打开移动网络", 1));
            return;
        }
        if (((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (!(wifiManager.isWifiEnabled() && (connectionInfo == null ? 0 : connectionInfo.getIpAddress()) != 0)) {
            }
        } else {
            z = false;
        }
        if (!z) {
            r2.a("zx 网络切换: 直接可以使用移动网络访问");
            a(jSONObject, callback, i);
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        connectivityManager.requestNetwork(builder.build(), new a(jSONObject, connectivityManager, callback, i));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:9|31|10|(4:11|(3:13|(2:15|37)(2:16|36)|17)(1:35)|22|39)|18|33|19|22|39) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONObject jSONObject, Callback callback, int i, String str, String str2, String str3) throws Throwable {
        String str4;
        Cipher cipher;
        byte[] bytes;
        int length;
        ByteArrayOutputStream byteArrayOutputStream;
        int i2;
        int i3;
        byte[] bArrDoFinal;
        if (i == 0) {
            try {
                callback.callback(a(w1.b(jSONObject, str, str2, str3), 0));
                return;
            } catch (Throwable th) {
                String message = th.getMessage();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("msg", message);
                jSONObject2.put("code", 10011);
                callback.callback(jSONObject2.toString());
                return;
            }
        }
        if (i != 1) {
            if (i != 2) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", str2);
            jSONObject3.put("type", str);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("data", jSONObject3);
            jSONObject4.put("code", 0);
            callback.callback(jSONObject4.toString());
            return;
        }
        String string = jSONObject.getString("callerId");
        JSONObject jSONObject5 = new JSONObject();
        String str5 = string + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + m3.g + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + m3.a(m3.h) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2;
        String str6 = b()[0];
        SecureRandom secureRandom = p.f16841a;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str6, 0))));
            bytes = str5.getBytes(StandardCharsets.UTF_8);
            length = bytes.length;
            byteArrayOutputStream = new ByteArrayOutputStream();
            i2 = 0;
            i3 = 0;
        } catch (Throwable unused) {
            str4 = "";
        }
        while (true) {
            int i4 = length - i2;
            if (i4 <= 0) {
                break;
            }
            if (i4 > 117) {
                bArrDoFinal = cipher.doFinal(bytes, i2, 117);
            } else {
                bArrDoFinal = cipher.doFinal(bytes, i2, i4);
            }
            byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
            i3++;
            i2 = i3 * 117;
            jSONObject5.put("data", str4);
            jSONObject5.put("code", 0);
            callback.callback(jSONObject5.toString());
        }
        str4 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2), StandardCharsets.UTF_8);
        byteArrayOutputStream.close();
        jSONObject5.put("data", str4);
        jSONObject5.put("code", 0);
        callback.callback(jSONObject5.toString());
    }

    public final String b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msg", str);
        jSONObject.put("code", 10010);
        return jSONObject.toString();
    }

    public final String a(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("code", i);
        return jSONObject.toString();
    }
}
