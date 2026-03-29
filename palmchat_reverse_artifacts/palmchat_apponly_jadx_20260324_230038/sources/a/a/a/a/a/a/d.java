package a.a.a.a.a.a;

import android.content.Context;
import android.net.Network;
import com.amap.api.services.district.DistrictSearchQuery;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @Override // a.a.a.a.a.a.a
    public String a() {
        return "3";
    }

    public final String b() {
        for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            Intrinsics.checkNotNullExpressionValue(networkInterface, "networkInterface");
            for (InetAddress inetAddresses : Collections.list(networkInterface.getInetAddresses())) {
                Intrinsics.checkNotNullExpressionValue(inetAddresses, "inetAddresses");
                if (inetAddresses.isSiteLocalAddress() && (inetAddresses instanceof Inet4Address)) {
                    String hostAddress = ((Inet4Address) inetAddresses).getHostAddress();
                    if (hostAddress != null) {
                        return hostAddress;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public final JSONObject a(Network network, String str) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        URL url = new URL(str);
        if (network == null) {
            uRLConnectionOpenConnection = url.openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            }
        } else {
            uRLConnectionOpenConnection = network.openConnection(url);
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            }
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        InputStream inputStream = null;
        try {
            try {
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDefaultUseCaches(false);
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() != 200) {
                    JSONObject jSONObject = new JSONObject();
                    httpsURLConnection.disconnect();
                    return jSONObject;
                }
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                byte[] bArr = new byte[2048];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = inputStream2.read(bArr);
                    if (i <= 0) {
                        JSONObject jSONObject2 = new JSONObject(sb.toString());
                        inputStream2.close();
                        inputStream2.close();
                        httpsURLConnection.disconnect();
                        return jSONObject2;
                    }
                    Charset charset = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(charset, "StandardCharsets.UTF_8");
                    sb.append(new String(bArr, 0, i, charset));
                }
            } catch (Exception unused) {
                JSONObject jSONObject3 = new JSONObject();
                if (0 != 0) {
                    inputStream.close();
                }
                httpsURLConnection.disconnect();
                return jSONObject3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream.close();
            }
            httpsURLConnection.disconnect();
            throw th;
        }
    }

    @Override // a.a.a.a.a.a.a
    public i a(Context context, Network network) {
        JSONObject jSONObjectA;
        String string;
        String strB;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            jSONObjectA = a(network, "https://nisportal.10010.com:9001/api?appid=1554778161154");
        } catch (Exception e) {
            this.b.b = e.getMessage();
        }
        if (jSONObjectA.has("code")) {
            this.b.b = jSONObjectA.getString("code");
        } else {
            if (jSONObjectA.has("authurl")) {
                this.b.b = "81128";
                string = jSONObjectA.getString("authurl");
                if (string != null && (strB = b()) != null) {
                    a(context, network, string, strB);
                }
                return this.b;
            }
            this.b.b = "61128";
        }
        string = null;
        if (string != null) {
            a(context, network, string, strB);
        }
        return this.b;
    }

    public final i a(Context context, Network network, String str, String str2) throws JSONException, IOException {
        JSONObject jSONObjectA = a(network, str + "/api?appid=1554778161154&private_ip=" + str2);
        if (jSONObjectA.has("err_code")) {
            this.b.b = jSONObjectA.getString("err_code");
            return this.b;
        }
        if (!jSONObjectA.has("code") || !jSONObjectA.has(DistrictSearchQuery.KEYWORDS_PROVINCE)) {
            return this.b;
        }
        String string = jSONObjectA.getString("code");
        String string2 = jSONObjectA.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
        i iVar = this.b;
        iVar.f1060a = string;
        iVar.b = "01128";
        iVar.d = "3";
        iVar.c = "3";
        iVar.e = 0;
        iVar.f = string2;
        iVar.g = System.currentTimeMillis();
        return this.b;
    }
}
