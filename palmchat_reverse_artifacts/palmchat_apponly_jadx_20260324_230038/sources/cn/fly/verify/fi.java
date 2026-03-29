package cn.fly.verify;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fi implements fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HttpURLConnection f2350a;

    public fi(HttpURLConnection httpURLConnection) {
        this.f2350a = httpURLConnection;
    }

    @Override // cn.fly.verify.fh
    public int a() throws IOException {
        return this.f2350a.getResponseCode();
    }

    @Override // cn.fly.verify.fh
    public InputStream b() throws IOException {
        return this.f2350a.getInputStream();
    }

    @Override // cn.fly.verify.fh
    public InputStream c() throws IOException {
        return this.f2350a.getErrorStream();
    }

    @Override // cn.fly.verify.fh
    public Map<String, List<String>> d() throws IOException {
        return this.f2350a.getHeaderFields();
    }
}
