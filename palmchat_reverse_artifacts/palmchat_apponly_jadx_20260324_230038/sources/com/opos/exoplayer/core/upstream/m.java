package com.opos.exoplayer.core.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.opos.exoplayer.core.upstream.HttpDataSource;
import com.opos.exoplayer.core.util.y;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class m implements HttpDataSource {
    private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> c = new AtomicReference<>();
    private final boolean d;
    private final int e;
    private final int f;
    private final String g;
    private final com.opos.exoplayer.core.util.r<String> h;
    private final HttpDataSource.e i;
    private final HttpDataSource.e j = new HttpDataSource.e();
    private final r<? super m> k;
    private DataSpec l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;

    public m(String str, com.opos.exoplayer.core.util.r<String> rVar, r<? super m> rVar2, int i, int i2, boolean z, HttpDataSource.e eVar) {
        this.g = com.opos.exoplayer.core.util.a.a(str);
        this.h = rVar;
        this.k = rVar2;
        this.e = i;
        this.f = i2;
        this.d = z;
        this.i = eVar;
    }

    private int b(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.q;
        if (j != -1) {
            long j2 = j - this.s;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = this.n.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.q == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.s += (long) i3;
        r<? super m> rVar = this.k;
        if (rVar != null) {
            rVar.a(this, i3);
        }
        return i3;
    }

    private void d() throws IOException {
        if (this.r == this.p) {
            return;
        }
        byte[] andSet = c.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.r;
            long j2 = this.p;
            if (j == j2) {
                c.set(andSet);
                return;
            }
            int i = this.n.read(andSet, 0, (int) Math.min(j2 - j, andSet.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (i == -1) {
                throw new EOFException();
            }
            this.r += (long) i;
            r<? super m> rVar = this.k;
            if (rVar != null) {
                rVar.a(this, i);
            }
        }
    }

    private void e() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.m = null;
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public int a(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            d();
            return b(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSource.HttpDataSourceException(e, this.l, 2);
        }
    }

    public final long c() {
        long j = this.q;
        return j == -1 ? j : j - this.s;
    }

    private HttpURLConnection b(DataSpec dataSpec) throws IOException {
        HttpURLConnection httpURLConnectionA;
        URL url = new URL(dataSpec.f8366a.toString());
        byte[] bArr = dataSpec.b;
        long j = dataSpec.d;
        long j2 = dataSpec.e;
        boolean zA = dataSpec.a(1);
        if (!this.d) {
            return a(url, bArr, j, j2, zA, true);
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
            long j3 = j;
            httpURLConnectionA = a(url, bArr, j, j2, zA, false);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                break;
            }
            String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
            httpURLConnectionA.disconnect();
            url = a(url, headerField);
            bArr = null;
            i = i2;
            j = j3;
        }
        return httpURLConnectionA;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    @Override // com.opos.exoplayer.core.upstream.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        long j;
        r<? super m> rVar;
        this.l = dataSpec;
        long j2 = 0;
        this.s = 0L;
        this.r = 0L;
        try {
            HttpURLConnection httpURLConnectionB = b(dataSpec);
            this.m = httpURLConnectionB;
            try {
                int responseCode = httpURLConnectionB.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.m.getHeaderFields();
                    e();
                    HttpDataSource.d dVar = new HttpDataSource.d(responseCode, headerFields, dataSpec);
                    if (responseCode != 416) {
                        throw dVar;
                    }
                    dVar.initCause(new h(0));
                    throw dVar;
                }
                String contentType = this.m.getContentType();
                com.opos.exoplayer.core.util.r<String> rVar2 = this.h;
                if (rVar2 != null && !rVar2.a(contentType)) {
                    e();
                    throw new HttpDataSource.c(contentType, dataSpec);
                }
                if (responseCode == 200) {
                    long j3 = dataSpec.d;
                    if (j3 != 0) {
                        j2 = j3;
                    }
                }
                this.p = j2;
                try {
                    if (!dataSpec.a(1)) {
                        j = dataSpec.e;
                        if (j == -1) {
                            long jA = a(this.m);
                            this.q = jA != -1 ? jA - this.p : -1L;
                        }
                        this.n = this.m.getInputStream();
                        this.o = true;
                        rVar = this.k;
                        if (rVar != null) {
                            rVar.a(this, dataSpec);
                        }
                        return this.q;
                    }
                    j = dataSpec.e;
                    this.n = this.m.getInputStream();
                    this.o = true;
                    rVar = this.k;
                    if (rVar != null) {
                    }
                    return this.q;
                } catch (IOException e) {
                    e();
                    throw new HttpDataSource.HttpDataSourceException(e, dataSpec, 1);
                }
                this.q = j;
            } catch (IOException e2) {
                e();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.f8366a.toString(), e2, dataSpec, 1);
            }
        } catch (IOException e3) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.f8366a.toString(), e3, dataSpec, 1);
        }
    }

    private static long a(HttpURLConnection httpURLConnection) {
        long j;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField)) {
            j = -1;
        } else {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
                j = -1;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = b.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long j2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return j2;
            }
            if (j == j2) {
                return j;
            }
            com.opos.cmn.an.f.a.c("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, j2);
        } catch (NumberFormatException unused2) {
            com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public void b() {
        try {
            if (this.n != null) {
                a(this.m, c());
                try {
                    this.n.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, this.l, 3);
                }
            }
        } finally {
            this.n = null;
            e();
            if (this.o) {
                this.o = false;
                r<? super m> rVar = this.k;
                if (rVar != null) {
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
        HttpDataSource.e eVar = this.i;
        if (eVar != null) {
            for (Map.Entry<String, String> entry : eVar.a().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.j.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.g);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        }
        return httpURLConnection;
    }

    private static URL a(URL url, String str) throws ProtocolException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (BaseConstants.SCHEME_HTTPS.equals(protocol) || HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        int i = y.f8407a;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }
}
