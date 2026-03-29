package defpackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.huawei.hms.ads.ld;
import com.zenmen.palmchat.framework.httpdns.ResDownloadHttpDnsHelper;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class rx3 implements DataFetcher<InputStream> {

    @VisibleForTesting
    public static final b g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GlideUrl f20620a;
    public final int b;
    public final b c;
    public HttpURLConnection d;
    public InputStream e;
    public volatile boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements b {
        @Override // rx3.b
        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        HttpURLConnection build(URL url) throws IOException;
    }

    public rx3(GlideUrl glideUrl) {
        this(glideUrl, 5000, g);
    }

    public static int c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return -2;
        }
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("NewHttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("NewHttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    public static boolean e(int i) {
        return i / 100 == 2;
    }

    public static boolean f(int i) {
        return i / 100 == 3;
    }

    public final HttpURLConnection a(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection httpURLConnectionBuild = this.c.build(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionBuild.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionBuild.setConnectTimeout(this.b);
            httpURLConnectionBuild.setReadTimeout(this.b);
            httpURLConnectionBuild.setUseCaches(false);
            httpURLConnectionBuild.setDoInput(true);
            httpURLConnectionBuild.setInstanceFollowRedirects(false);
            b13.a(httpURLConnectionBuild);
            if (httpURLConnectionBuild instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnectionBuild;
                HttpsHelper.getmInstance();
                httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
            }
            return httpURLConnectionBuild;
        } catch (IOException e) {
            throw new HttpException("URL.openConnection threw", 0, e);
        }
    }

    public final String b(String str) {
        return str != null ? str.replace("cdnavatar.youni.im", "avatar.cdn.lianxinapp.com") : str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.f = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.d = null;
    }

    public final InputStream d(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.e = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("NewHttpUrlFetcher", 3)) {
                    Log.d("NewHttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.e = httpURLConnection.getInputStream();
            }
            return this.e;
        } catch (IOException e) {
            throw new HttpException("Failed to obtain InputStream", c(httpURLConnection), e);
        }
    }

    public final InputStream g(URL url, int i, URL url2, Map<String, String> map) throws HttpException {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        if (kj2.b()) {
            try {
                HttpURLConnection httpURLConnectionC = new ResDownloadHttpDnsHelper().c(url.toString(), map, false);
                this.d = httpURLConnectionC;
                this.e = httpURLConnectionC.getInputStream();
            } catch (ResDownloadHttpDnsHelper.ResIOException e) {
                throw new HttpException("Failed to connect or obtain data", e.code, e);
            } catch (IOException e2) {
                throw new HttpException("Failed to connect or obtain data", c(this.d), e2);
            }
        } else {
            HttpURLConnection httpURLConnectionA = a(url, map);
            this.d = httpURLConnectionA;
            try {
                httpURLConnectionA.connect();
                this.e = this.d.getInputStream();
            } catch (IOException e3) {
                throw new HttpException("Failed to connect or obtain data", c(this.d), e3);
            }
        }
        if (this.f) {
            return null;
        }
        int iC = c(this.d);
        if (e(iC)) {
            String headerField = this.d.getHeaderField("Media-ZX-Block-Type");
            if (!TextUtils.isEmpty(headerField) && headerField.equals("1")) {
                throw new HttpException("LX_NET_404", iC, new IOException("LX_NET_404"));
            }
            if (TextUtils.isEmpty(headerField) || !headerField.equals("2")) {
                return d(this.d);
            }
            throw new HttpException("LX_NET_403", iC, new IOException("LX_NET_403"));
        }
        if (!f(iC)) {
            if (iC == -1) {
                throw new HttpException(iC);
            }
            try {
                throw new HttpException(this.d.getResponseMessage(), iC);
            } catch (IOException e4) {
                throw new HttpException("Failed to get a response message", iC, e4);
            }
        }
        String headerField2 = this.d.getHeaderField(HttpHeaders.LOCATION);
        if (TextUtils.isEmpty(headerField2)) {
            throw new HttpException("Received empty or null redirect url", iC);
        }
        try {
            URL url3 = new URL(url, headerField2);
            cleanup();
            return g(url3, i + 1, url, map);
        } catch (MalformedURLException e5) {
            throw new HttpException("Bad redirect url: " + headerField2, iC, e5);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long logTime = LogTime.getLogTime();
        try {
            try {
                dataCallback.onDataReady(g(new URL(b(k86.S(this.f20620a.toStringUrl(), true))), 0, null, this.f20620a.getHeaders()));
            } catch (IOException e) {
                HashMap map = new HashMap();
                if (this.f20620a.toStringUrl() != null) {
                    map.put(ld.f6599a, this.f20620a.toStringUrl());
                }
                LogUtil.log4ClientError("Media_load_fail_ImageError", map, e);
                if (Log.isLoggable("NewHttpUrlFetcher", 3)) {
                    Log.d("NewHttpUrlFetcher", "Failed to load data for url", e);
                }
                dataCallback.onLoadFailed(e);
                if (!Log.isLoggable("NewHttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("NewHttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.getElapsedMillis(logTime));
                Log.v("NewHttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("NewHttpUrlFetcher", 2)) {
                Log.v("NewHttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }

    @VisibleForTesting
    public rx3(GlideUrl glideUrl, int i, b bVar) {
        this.f20620a = glideUrl;
        this.b = i;
        this.c = bVar;
    }
}
