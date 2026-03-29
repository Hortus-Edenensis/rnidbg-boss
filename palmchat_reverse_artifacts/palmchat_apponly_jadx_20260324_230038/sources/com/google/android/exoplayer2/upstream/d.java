package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.efs.sdk.base.Constants;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.d;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.k0;
import com.ss.android.download.api.constant.BaseConstants;
import defpackage.dq;
import defpackage.em4;
import defpackage.g86;
import defpackage.jj2;
import defpackage.n12;
import defpackage.qj2;
import defpackage.u06;
import defpackage.vh;
import defpackage.y53;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class d extends dq {
    public final boolean e;
    public final int f;
    public final int g;

    @Nullable
    public final String h;

    @Nullable
    public final jj2 i;
    public final jj2 j;
    public final boolean k;

    @Nullable
    public em4<String> l;

    @Nullable
    public com.google.android.exoplayer2.upstream.b m;

    @Nullable
    public HttpURLConnection n;

    @Nullable
    public InputStream o;
    public boolean p;
    public int q;
    public long r;
    public long s;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements a.InterfaceC0360a {

        @Nullable
        public u06 b;

        @Nullable
        public em4<String> c;

        @Nullable
        public String d;
        public boolean g;
        public boolean h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jj2 f6021a = new jj2();
        public int e = 8000;
        public int f = 8000;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0360a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createDataSource() {
            d dVar = new d(this.d, this.e, this.f, this.g, this.f6021a, this.c, this.h);
            u06 u06Var = this.b;
            if (u06Var != null) {
                dVar.b(u06Var);
            }
            return dVar;
        }

        public b b(@Nullable String str) {
            this.d = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends n12<String, List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f6022a;

        public c(Map<String, List<String>> map) {
            this.f6022a = map;
        }

        public static /* synthetic */ boolean lambda$entrySet$1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        public static /* synthetic */ boolean lambda$keySet$0(String str) {
            return str != null;
        }

        @Override // defpackage.n12, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // defpackage.n12, java.util.Map
        public boolean containsValue(@Nullable Object obj) {
            return super.standardContainsValue(obj);
        }

        @Override // defpackage.n12, java.util.Map
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return k0.b(super.entrySet(), new em4() { // from class: z51
                @Override // defpackage.em4
                public final boolean apply(Object obj) {
                    return d.c.lambda$entrySet$1((Map.Entry) obj);
                }
            });
        }

        @Override // defpackage.n12, java.util.Map
        public boolean equals(@Nullable Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        @Override // defpackage.n12, java.util.Map
        public int hashCode() {
            return super.standardHashCode();
        }

        @Override // defpackage.n12, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // defpackage.n12, java.util.Map
        public Set<String> keySet() {
            return k0.b(super.keySet(), new em4() { // from class: y51
                @Override // defpackage.em4
                public final boolean apply(Object obj) {
                    return d.c.lambda$keySet$0((String) obj);
                }
            });
        }

        @Override // defpackage.n12, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override // defpackage.n12, defpackage.p12
        public Map<String, List<String>> delegate() {
            return this.f6022a;
        }

        @Override // defpackage.n12, java.util.Map
        @Nullable
        public List<String> get(@Nullable Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    public static boolean i(HttpURLConnection httpURLConnection) {
        return Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    public static void l(@Nullable HttpURLConnection httpURLConnection, long j) {
        int i;
        if (httpURLConnection == null || (i = g86.f17680a) < 19 || i > 20) {
            return;
        }
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
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) vh.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource$HttpDataSourceException {
        byte[] bArrF1;
        this.m = bVar;
        long j = 0;
        this.s = 0L;
        this.r = 0L;
        e(bVar);
        try {
            HttpURLConnection httpURLConnectionJ = j(bVar);
            this.n = httpURLConnectionJ;
            this.q = httpURLConnectionJ.getResponseCode();
            String responseMessage = httpURLConnectionJ.getResponseMessage();
            int i = this.q;
            if (i < 200 || i > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionJ.getHeaderFields();
                if (this.q == 416) {
                    if (bVar.g == qj2.c(httpURLConnectionJ.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                        this.p = true;
                        f(bVar);
                        long j2 = bVar.h;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionJ.getErrorStream();
                try {
                    bArrF1 = errorStream != null ? g86.f1(errorStream) : g86.f;
                } catch (IOException unused) {
                    bArrF1 = g86.f;
                }
                byte[] bArr = bArrF1;
                g();
                throw new HttpDataSource$InvalidResponseCodeException(this.q, responseMessage, this.q == 416 ? new DataSourceException(2008) : null, headerFields, bVar, bArr);
            }
            String contentType = httpURLConnectionJ.getContentType();
            em4<String> em4Var = this.l;
            if (em4Var != null && !em4Var.apply(contentType)) {
                g();
                throw new HttpDataSource$InvalidContentTypeException(contentType, bVar);
            }
            if (this.q == 200) {
                long j3 = bVar.g;
                if (j3 != 0) {
                    j = j3;
                }
            }
            boolean zI = i(httpURLConnectionJ);
            if (zI) {
                this.r = bVar.h;
            } else {
                long j4 = bVar.h;
                if (j4 != -1) {
                    this.r = j4;
                } else {
                    long jB = qj2.b(httpURLConnectionJ.getHeaderField("Content-Length"), httpURLConnectionJ.getHeaderField(HttpHeaders.CONTENT_RANGE));
                    this.r = jB != -1 ? jB - j : -1L;
                }
            }
            try {
                this.o = httpURLConnectionJ.getInputStream();
                if (zI) {
                    this.o = new GZIPInputStream(this.o);
                }
                this.p = true;
                f(bVar);
                try {
                    o(j, bVar);
                    return this.r;
                } catch (IOException e) {
                    g();
                    if (e instanceof HttpDataSource$HttpDataSourceException) {
                        throw ((HttpDataSource$HttpDataSourceException) e);
                    }
                    throw new HttpDataSource$HttpDataSourceException(e, bVar, 2000, 1);
                }
            } catch (IOException e2) {
                g();
                throw new HttpDataSource$HttpDataSourceException(e2, bVar, 2000, 1);
            }
        } catch (IOException e3) {
            g();
            throw HttpDataSource$HttpDataSourceException.createForIOException(e3, bVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws HttpDataSource$HttpDataSourceException {
        try {
            InputStream inputStream = this.o;
            if (inputStream != null) {
                long j = this.r;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.s;
                }
                l(this.n, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new HttpDataSource$HttpDataSourceException(e, (com.google.android.exoplayer2.upstream.b) g86.j(this.m), 2000, 3);
                }
            }
        } finally {
            this.o = null;
            g();
            if (this.p) {
                this.p = false;
                d();
            }
        }
    }

    public final void g() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                y53.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.n = null;
        }
    }

    @Override // defpackage.dq, com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.n;
        return httpURLConnection == null ? ImmutableMap.of() : new c(httpURLConnection.getHeaderFields());
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final URL h(URL url, @Nullable String str, com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource$HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource$HttpDataSourceException("Null location redirect", bVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!BaseConstants.SCHEME_HTTPS.equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
                throw new HttpDataSource$HttpDataSourceException("Unsupported protocol redirect: " + protocol, bVar, 2001, 1);
            }
            if (this.e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new HttpDataSource$HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", bVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new HttpDataSource$HttpDataSourceException(e, bVar, 2001, 1);
        }
    }

    public final HttpURLConnection j(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        HttpURLConnection httpURLConnectionK;
        URL url;
        URL url2 = new URL(bVar.f6011a.toString());
        int i = bVar.c;
        byte[] bArr = bVar.d;
        long j = bVar.g;
        long j2 = bVar.h;
        boolean zD = bVar.d(1);
        if (!this.e && !this.k) {
            return k(url2, i, bArr, j, j2, zD, true, bVar.e);
        }
        URL urlH = url2;
        int i2 = i;
        byte[] bArr2 = bArr;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 > 20) {
                throw new HttpDataSource$HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i4), bVar, 2001, 1);
            }
            long j3 = j;
            long j4 = j;
            int i5 = i2;
            URL url3 = urlH;
            long j5 = j2;
            httpURLConnectionK = k(urlH, i2, bArr2, j3, j2, zD, false, bVar.e);
            int responseCode = httpURLConnectionK.getResponseCode();
            String headerField = httpURLConnectionK.getHeaderField(HttpHeaders.LOCATION);
            if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionK.disconnect();
                urlH = h(url3, headerField, bVar);
                i2 = i5;
            } else {
                if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                httpURLConnectionK.disconnect();
                if (this.k && responseCode == 302) {
                    i2 = i5;
                    url = url3;
                } else {
                    bArr2 = null;
                    url = url3;
                    i2 = 1;
                }
                urlH = h(url, headerField, bVar);
            }
            i3 = i4;
            j = j4;
            j2 = j5;
        }
        return httpURLConnectionK;
    }

    public final HttpURLConnection k(URL url, int i, @Nullable byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionM = m(url);
        httpURLConnectionM.setConnectTimeout(this.f);
        httpURLConnectionM.setReadTimeout(this.g);
        HashMap map2 = new HashMap();
        jj2 jj2Var = this.i;
        if (jj2Var != null) {
            map2.putAll(jj2Var.a());
        }
        map2.putAll(this.j.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionM.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = qj2.a(j, j2);
        if (strA != null) {
            httpURLConnectionM.setRequestProperty(HttpHeaders.RANGE, strA);
        }
        String str = this.h;
        if (str != null) {
            httpURLConnectionM.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionM.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z ? Constants.CP_GZIP : HTTP.IDENTITY_CODING);
        httpURLConnectionM.setInstanceFollowRedirects(z2);
        httpURLConnectionM.setDoOutput(bArr != null);
        httpURLConnectionM.setRequestMethod(com.google.android.exoplayer2.upstream.b.c(i));
        if (bArr != null) {
            httpURLConnectionM.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionM.connect();
            OutputStream outputStream = httpURLConnectionM.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionM.connect();
        }
        return httpURLConnectionM;
    }

    @VisibleForTesting
    public HttpURLConnection m(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public final int n(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.r;
        if (j != -1) {
            long j2 = j - this.s;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) g86.j(this.o)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.s += (long) i3;
        c(i3);
        return i3;
    }

    public final void o(long j, com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int i = ((InputStream) g86.j(this.o)).read(bArr, 0, (int) Math.min(j, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource$HttpDataSourceException(new InterruptedIOException(), bVar, 2000, 1);
            }
            if (i == -1) {
                throw new HttpDataSource$HttpDataSourceException(bVar, 2008, 1);
            }
            j -= (long) i;
            c(i);
        }
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource$HttpDataSourceException {
        try {
            return n(bArr, i, i2);
        } catch (IOException e) {
            throw HttpDataSource$HttpDataSourceException.createForIOException(e, (com.google.android.exoplayer2.upstream.b) g86.j(this.m), 2);
        }
    }

    public d(@Nullable String str, int i, int i2, boolean z, @Nullable jj2 jj2Var, @Nullable em4<String> em4Var, boolean z2) {
        super(true);
        this.h = str;
        this.f = i;
        this.g = i2;
        this.e = z;
        this.i = jj2Var;
        this.l = em4Var;
        this.j = new jj2();
        this.k = z2;
    }
}
