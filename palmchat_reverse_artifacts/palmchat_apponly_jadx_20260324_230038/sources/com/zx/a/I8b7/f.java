package com.zx.a.I8b7;

import android.net.Network;
import android.util.Base64;
import com.zx.a.I8b7.m2;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class f implements Runnable {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements m2.b {
        public a(f fVar) {
        }

        @Override // com.zx.a.I8b7.m2.b
        public void a() {
        }

        @Override // com.zx.a.I8b7.m2.b
        public void a(int i, String str) {
        }

        @Override // com.zx.a.I8b7.m2.b
        public void a(Network network) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL("https://zxid-m.mobileservice.cn/sdk/ext/pconfig"));
                i0.a(httpURLConnection);
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                p.b(bArr, m3.a(m3.h));
                HashMap<String, String> mapB = i0.b(new String(Base64.encode(bArr, 2), StandardCharsets.UTF_8));
                httpURLConnection.setRequestMethod("POST");
                for (String str : mapB.keySet()) {
                    httpURLConnection.setRequestProperty(str, mapB.get(str));
                }
                httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.connect();
                JSONObject jSONObject = new JSONObject();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(jSONObject.toString());
                bufferedWriter.close();
                r2.a(u1.a(x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                r2.a(th.getMessage());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            m2.c.f16829a.a(new a(this));
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}
