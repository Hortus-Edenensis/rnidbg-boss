package com.bytedance.adsdk.lottie.fx;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class u implements b {
    private final HttpURLConnection u;

    public u(HttpURLConnection httpURLConnection) {
        this.u = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.lottie.fx.b
    public String b() {
        try {
            if (u()) {
                return null;
            }
            return "Unable to fetch " + this.u.getURL() + ". Failed with " + this.u.getResponseCode() + "\n" + u(this.u);
        } catch (IOException e) {
            com.bytedance.adsdk.lottie.pn.pn.u("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.u.disconnect();
    }

    @Override // com.bytedance.adsdk.lottie.fx.b
    public String fx() {
        return this.u.getContentType();
    }

    @Override // com.bytedance.adsdk.lottie.fx.b
    public InputStream nr() throws IOException {
        return this.u.getInputStream();
    }

    @Override // com.bytedance.adsdk.lottie.fx.b
    public boolean u() {
        try {
            return this.u.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    private String u(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
