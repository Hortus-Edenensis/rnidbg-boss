package com.qq.gdt.action.f.b;

import com.qq.gdt.action.f.b.i;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f10505a;

    public e(d dVar) {
        this.f10505a = dVar;
    }

    private static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public i a(g gVar) throws Throwable {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(gVar.a()).openConnection();
        httpURLConnection.setRequestMethod(gVar.e());
        httpURLConnection.setReadTimeout(this.f10505a.b);
        httpURLConnection.setConnectTimeout(this.f10505a.f10503a);
        if (gVar.c() > 0) {
            httpURLConnection.setReadTimeout(gVar.c());
        }
        if (gVar.b() > 0) {
            httpURLConnection.setConnectTimeout(gVar.b());
        }
        httpURLConnection.setDoInput(true);
        Map<String, String> mapD = gVar.d();
        if (mapD != null && !mapD.isEmpty()) {
            a(httpURLConnection, mapD);
        }
        if (b(gVar)) {
            a(httpURLConnection, gVar.f());
        }
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        return new i.a().a(gVar).a(responseCode).a(responseMessage).a(headerFields).a(a(httpURLConnection)).a();
    }

    private static j a(HttpURLConnection httpURLConnection) throws IOException {
        return new j(httpURLConnection.getContentType(), httpURLConnection.getContentLength(), new BufferedInputStream(b(httpURLConnection)), httpURLConnection);
    }

    private static boolean b(g gVar) {
        if (gVar.f() == null) {
            return false;
        }
        return "POST".equals(gVar.e());
    }

    public Executor a() {
        return this.f10505a.c;
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        httpURLConnection.setFixedLengthStreamingMode(j);
    }

    private static void a(HttpURLConnection httpURLConnection, h hVar) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        httpURLConnection.setDoOutput(true);
        BufferedOutputStream bufferedOutputStream2 = null;
        if ((hVar.a() != null ? hVar.a().toString() : null) != null) {
            httpURLConnection.addRequestProperty("Content-Type", hVar.a().toString());
        }
        long jB = hVar.b();
        if (jB > 0) {
            a(httpURLConnection, jB);
            httpURLConnection.addRequestProperty("Content-Length", Long.toString(jB));
        } else {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        } catch (Throwable th) {
            th = th;
        }
        try {
            hVar.a(bufferedOutputStream);
            k.a(bufferedOutputStream);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            k.a(bufferedOutputStream2);
            throw th;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                httpURLConnection.addRequestProperty(entry.getKey(), value);
            }
        }
    }
}
