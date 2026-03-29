package defpackage;

import cdadata.cdazmg.cdazmb;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class k67 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cdazmb f18587a = new cdazmb();

    public final m67 a(Exception exc) {
        m67 m67Var = new m67();
        m67Var.d = exc;
        m67Var.b = exc.getMessage();
        g57.b("HttpRequest", m67Var.toString());
        return m67Var;
    }

    public final m67 b(HttpURLConnection httpURLConnection) {
        m67 m67Var = new m67();
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                m67Var.c = responseCode;
                if (responseCode < 400) {
                    m67Var.f19147a = e67.c(httpURLConnection.getInputStream());
                } else {
                    m67Var.b = e67.c(httpURLConnection.getErrorStream());
                }
                httpURLConnection.disconnect();
                g57.b("HttpRequest", m67Var.toString());
                return m67Var;
            } catch (IOException e) {
                m67 m67VarA = a(e);
                httpURLConnection.disconnect();
                return m67VarA;
            }
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public final HttpURLConnection c(String str, String str2) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setUseCaches(false);
        this.f18587a.getClass();
        httpURLConnection.setConnectTimeout(30000);
        this.f18587a.getClass();
        httpURLConnection.setReadTimeout(30000);
        if (str2.equals("POST")) {
            httpURLConnection.setDoOutput(true);
        }
        return httpURLConnection;
    }

    public final void d(HttpURLConnection httpURLConnection, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpURLConnection.setRequestProperty(str, map.get(str));
        }
    }
}
