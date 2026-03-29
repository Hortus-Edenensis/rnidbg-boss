package com.bytedance.sdk.openadsdk.core.jp.u;

import android.net.Network;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject u(Network network, String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        JSONObject jSONObject;
        InputStream inputStream = null;
        if (str == null) {
            return null;
        }
        try {
            httpsURLConnection = network == null ? (HttpsURLConnection) new URL(str).openConnection() : (HttpsURLConnection) network.openConnection(new URL(str));
            if (httpsURLConnection == null) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                com.bytedance.sdk.openadsdk.gi.b.u((Closeable) null);
                com.bytedance.sdk.openadsdk.gi.b.u((Closeable) null);
                return null;
            }
            try {
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDefaultUseCaches(false);
                if (TextUtils.isEmpty(str2)) {
                    httpsURLConnection.setRequestMethod("GET");
                    outputStream = null;
                } else {
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                    } catch (Throwable unused) {
                        outputStream2 = null;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        com.bytedance.sdk.openadsdk.gi.b.u(outputStream);
                        com.bytedance.sdk.openadsdk.gi.b.u(outputStream2);
                        return null;
                    }
                }
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    InputStream inputStream2 = httpsURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[2048];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int i = inputStream2.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            sb.append(new String(bArr, 0, i, StandardCharsets.UTF_8));
                        }
                        jSONObject = new JSONObject(sb.toString());
                        inputStream = inputStream2;
                    } catch (Throwable unused2) {
                        outputStream2 = inputStream2;
                        if (httpsURLConnection != null) {
                        }
                        com.bytedance.sdk.openadsdk.gi.b.u(outputStream);
                        com.bytedance.sdk.openadsdk.gi.b.u(outputStream2);
                        return null;
                    }
                } else {
                    jSONObject = null;
                }
                httpsURLConnection.disconnect();
                com.bytedance.sdk.openadsdk.gi.b.u(outputStream);
                com.bytedance.sdk.openadsdk.gi.b.u(inputStream);
                return jSONObject;
            } catch (Throwable unused3) {
                outputStream = null;
                outputStream2 = outputStream;
                if (httpsURLConnection != null) {
                }
                com.bytedance.sdk.openadsdk.gi.b.u(outputStream);
                com.bytedance.sdk.openadsdk.gi.b.u(outputStream2);
                return null;
            }
        } catch (Throwable unused4) {
            httpsURLConnection = null;
            outputStream = null;
        }
    }
}
