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
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zx.a.I8b7.o2;
import com.zx.a.I8b7.q1;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class f1 {
    public static final byte[] b = {-95, -8, -49, 34, 91, -116, -29, -2, -106, 39, -56, 39, -121, 112, -22, 21};
    public static final byte[] c = {-84, -2, -56, -72, -90, 65, -76, -48, -92, 30, -27, -64, -102, 101, 95, 24};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f16793a = b();

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f1 f16795a = new f1();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() throws Throwable {
        boolean zBooleanValue;
        if (!TextUtils.isEmpty(m3.i) && m3.i.startsWith("Z01-") && "中国联通".equals(w3.b(m3.f16830a))) {
            boolean zA = w3.a(m3.f16830a, com.kuaishou.weapon.p0.g.d, false);
            boolean zA2 = w3.a(m3.f16830a, "android.permission.CHANGE_NETWORK_STATE", false);
            int i = Build.VERSION.SDK_INT;
            if (!zA || !zA2) {
                e();
                return;
            }
            Context context = m3.f16830a;
            boolean z = true;
            if (i < 24) {
                zBooleanValue = true;
            } else {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    zBooleanValue = ((Boolean) telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]).invoke(telephonyManager, new Object[0])).booleanValue();
                } catch (Exception unused) {
                    zBooleanValue = true;
                }
            }
            if (zBooleanValue) {
                Context context2 = m3.f16830a;
                if (((WifiManager) context2.getSystemService("wifi")).isWifiEnabled()) {
                    WifiManager wifiManager = (WifiManager) context2.getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (!(wifiManager.isWifiEnabled() && (connectionInfo == null ? 0 : connectionInfo.getIpAddress()) != 0)) {
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    e();
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) m3.f16830a.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                builder.addTransportType(0);
                connectivityManager.requestNetwork(builder.build(), new a(connectivityManager));
            }
        }
    }

    public final String[] b() {
        return new String[]{"https://nisportal.10010.com:9001", "1073741824000"};
    }

    public final String c() throws Exception {
        o2 o2Var = new o2(new o2.a());
        q1.a aVar = new q1.a();
        q1.a aVarA = aVar.a(a(this.f16793a[0]));
        aVarA.b = "GET";
        aVarA.e = "unicom uaid nisportal api";
        JSONObject jSONObject = new JSONObject(new i1(o2Var, new q1(aVar)).a().e.b());
        String strOptString = jSONObject.optString("authurl");
        if (TextUtils.isEmpty(strOptString)) {
            throw new RuntimeException(jSONObject.toString());
        }
        q1.a aVar2 = new q1.a();
        q1.a aVarA2 = aVar2.a(a(strOptString));
        aVarA2.b = "GET";
        aVarA2.e = "unicom uaid auth api";
        return new JSONObject(new i1(o2Var, new q1(aVar2)).a().e.b()).getString("code");
    }

    public final String d() throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(b, EncryptUtils.AES_ENCRYPT_ALGORITHM), new IvParameterSpec(c));
        return new String(cipher.doFinal(Base64.decode("xxXbFehPQ+Zs/VtAtd6DL3ogem3eY/0zoVy6qWtcMuI5NPlB0yUsMmvUu+oK7CzNKOAIJmt5N8/SdP04E4O7Tw==", 2)), "UTF-8");
    }

    public final void e() {
        try {
            c();
            o2 o2Var = new o2(new o2.a());
            q1.a aVar = new q1.a();
            q1.a aVarA = aVar.a(d() + URLEncoder.encode(m3.i, "UTF-8"));
            aVarA.b = "GET";
            aVarA.e = "unicom uaid nisportal api";
            new i1(o2Var, new q1(aVar)).a();
            r2.a("l t s u c!");
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"NewApi"})
    public class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConnectivityManager f16794a;
        public TimerTask c;
        public final AtomicBoolean d = new AtomicBoolean(false);
        public Timer b = new Timer();

        public a(ConnectivityManager connectivityManager) {
            this.f16794a = connectivityManager;
            C1176a c1176a = new C1176a(this, f1.this);
            this.c = c1176a;
            this.b.schedule(c1176a, 7000L);
        }

        public final void a(Network network) throws Exception {
            StringBuilder sbA = f3.a(f1.this.d());
            sbA.append(URLEncoder.encode(m3.i, "UTF-8"));
            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL(sbA.toString()));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.connect();
            u1 u1VarA = u1.a(x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
            StringBuilder sbA2 = f3.a("cmd 8 suc!");
            sbA2.append(u1VarA.b());
            r2.a(sbA2.toString());
            httpURLConnection.disconnect();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            try {
                if (this.d.getAndSet(true)) {
                    return;
                }
                this.c.cancel();
                this.b.cancel();
                String strB = w3.b(m3.f16830a);
                if ("中国联通".equals(strB)) {
                    a(network);
                } else if (!"中国移动".equals(strB)) {
                    "中国电信".equals(strB);
                }
                this.f16794a.unregisterNetworkCallback(this);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: renamed from: com.zx.a.I8b7.f1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1176a extends TimerTask {
            public C1176a(a aVar, f1 f1Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
            }
        }
    }

    public final String a(String str) {
        String str2 = m3.a(m3.h) + "-" + ((System.currentTimeMillis() / 1000) / 86400);
        SecureRandom secureRandom = p.f16841a;
        try {
            return str + "/api?appid=" + this.f16793a[1] + "&request_id=" + p.a("SHA256", str2.getBytes(StandardCharsets.UTF_8)).substring(0, 16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("sha256String fail", e);
        }
    }
}
