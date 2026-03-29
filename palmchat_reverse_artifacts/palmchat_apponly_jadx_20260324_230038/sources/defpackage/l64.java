package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class l64 extends dq {
    public final Call.Factory e;
    public final jj2 f;

    @Nullable
    public final String g;

    @Nullable
    public final CacheControl h;

    @Nullable
    public final jj2 i;

    @Nullable
    public em4<String> j;

    @Nullable
    public com.google.android.exoplayer2.upstream.b k;

    @Nullable
    public Response l;

    @Nullable
    public InputStream m;
    public boolean n;
    public long o;
    public long p;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o65 f18915a;

        public a(o65 o65Var) {
            this.f18915a = o65Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f18915a.B(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            this.f18915a.A(response);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements a.InterfaceC0360a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jj2 f18916a = new jj2();
        public final Call.Factory b;

        @Nullable
        public String c;

        @Nullable
        public u06 d;

        @Nullable
        public CacheControl e;

        @Nullable
        public em4<String> f;

        public b(Call.Factory factory) {
            this.b = factory;
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0360a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l64 createDataSource() {
            l64 l64Var = new l64(this.b, this.c, this.e, this.f18916a, this.f, null);
            u06 u06Var = this.d;
            if (u06Var != null) {
                l64Var.b(u06Var);
            }
            return l64Var;
        }
    }

    static {
        jr1.a("goog.exo.okhttp");
    }

    public /* synthetic */ l64(Call.Factory factory, String str, CacheControl cacheControl, jj2 jj2Var, em4 em4Var, a aVar) {
        this(factory, str, cacheControl, jj2Var, em4Var);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource$HttpDataSourceException {
        byte[] bArrF1;
        this.k = bVar;
        long j = 0;
        this.p = 0L;
        this.o = 0L;
        e(bVar);
        try {
            Response responseH = h(this.e.newCall(i(bVar)));
            this.l = responseH;
            ResponseBody responseBody = (ResponseBody) vh.e(responseH.body());
            this.m = responseBody.byteStream();
            int iCode = responseH.code();
            if (!responseH.isSuccessful()) {
                if (iCode == 416) {
                    if (bVar.g == qj2.c(responseH.headers().get(HttpHeaders.CONTENT_RANGE))) {
                        this.n = true;
                        f(bVar);
                        long j2 = bVar.h;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                try {
                    bArrF1 = g86.f1((InputStream) vh.e(this.m));
                } catch (IOException unused) {
                    bArrF1 = g86.f;
                }
                byte[] bArr = bArrF1;
                Map<String, List<String>> multimap = responseH.headers().toMultimap();
                g();
                throw new HttpDataSource$InvalidResponseCodeException(iCode, responseH.message(), iCode == 416 ? new DataSourceException(2008) : null, multimap, bVar, bArr);
            }
            MediaType mediaType = responseBody.get$contentType();
            String mediaType2 = mediaType != null ? mediaType.getMediaType() : "";
            em4<String> em4Var = this.j;
            if (em4Var != null && !em4Var.apply(mediaType2)) {
                g();
                throw new HttpDataSource$InvalidContentTypeException(mediaType2, bVar);
            }
            if (iCode == 200) {
                long j3 = bVar.g;
                if (j3 != 0) {
                    j = j3;
                }
            }
            long j4 = bVar.h;
            if (j4 != -1) {
                this.o = j4;
            } else {
                long contentLength = responseBody.getContentLength();
                this.o = contentLength != -1 ? contentLength - j : -1L;
            }
            this.n = true;
            f(bVar);
            try {
                k(j, bVar);
                return this.o;
            } catch (HttpDataSource$HttpDataSourceException e) {
                g();
                throw e;
            }
        } catch (IOException e2) {
            throw HttpDataSource$HttpDataSourceException.createForIOException(e2, bVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.n) {
            this.n = false;
            d();
            g();
        }
    }

    public final void g() {
        Response response = this.l;
        if (response != null) {
            ((ResponseBody) vh.e(response.body())).close();
            this.l = null;
        }
        this.m = null;
    }

    @Override // defpackage.dq, com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        Response response = this.l;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        Response response = this.l;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().getUrl());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Response h(Call call) throws IOException {
        o65 o65VarE = o65.E();
        call.enqueue(new a(o65VarE));
        try {
            return (Response) o65VarE.get();
        } catch (InterruptedException unused) {
            call.cancel();
            throw new InterruptedIOException();
        } catch (ExecutionException e) {
            throw new IOException(e);
        }
    }

    public final Request i(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource$HttpDataSourceException {
        long j = bVar.g;
        long j2 = bVar.h;
        HttpUrl httpUrl = HttpUrl.parse(bVar.f6011a.toString());
        if (httpUrl == null) {
            throw new HttpDataSource$HttpDataSourceException("Malformed URL", bVar, 1004, 1);
        }
        Request.Builder builderUrl = new Request.Builder().url(httpUrl);
        CacheControl cacheControl = this.h;
        if (cacheControl != null) {
            builderUrl.cacheControl(cacheControl);
        }
        HashMap map = new HashMap();
        jj2 jj2Var = this.i;
        if (jj2Var != null) {
            map.putAll(jj2Var.a());
        }
        map.putAll(this.f.a());
        map.putAll(bVar.e);
        for (Map.Entry entry : map.entrySet()) {
            builderUrl.header((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = qj2.a(j, j2);
        if (strA != null) {
            builderUrl.addHeader(HttpHeaders.RANGE, strA);
        }
        String str = this.g;
        if (str != null) {
            builderUrl.addHeader("User-Agent", str);
        }
        if (!bVar.d(1)) {
            builderUrl.addHeader(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        }
        byte[] bArr = bVar.d;
        RequestBody requestBodyCreate = null;
        if (bArr != null) {
            requestBodyCreate = RequestBody.create((MediaType) null, bArr);
        } else if (bVar.c == 2) {
            requestBodyCreate = RequestBody.create((MediaType) null, g86.f);
        }
        builderUrl.method(bVar.b(), requestBodyCreate);
        return builderUrl.build();
    }

    public final int j(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.o;
        if (j != -1) {
            long j2 = j - this.p;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) g86.j(this.m)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.p += (long) i3;
        c(i3);
        return i3;
    }

    public final void k(long j, com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource$HttpDataSourceException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            try {
                int i = ((InputStream) g86.j(this.m)).read(bArr, 0, (int) Math.min(j, 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i == -1) {
                    throw new HttpDataSource$HttpDataSourceException(bVar, 2008, 1);
                }
                j -= (long) i;
                c(i);
            } catch (IOException e) {
                if (!(e instanceof HttpDataSource$HttpDataSourceException)) {
                    throw new HttpDataSource$HttpDataSourceException(bVar, 2000, 1);
                }
                throw ((HttpDataSource$HttpDataSourceException) e);
            }
        }
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource$HttpDataSourceException {
        try {
            return j(bArr, i, i2);
        } catch (IOException e) {
            throw HttpDataSource$HttpDataSourceException.createForIOException(e, (com.google.android.exoplayer2.upstream.b) g86.j(this.k), 2);
        }
    }

    public l64(Call.Factory factory, @Nullable String str, @Nullable CacheControl cacheControl, @Nullable jj2 jj2Var, @Nullable em4<String> em4Var) {
        super(true);
        this.e = (Call.Factory) vh.e(factory);
        this.g = str;
        this.h = cacheControl;
        this.i = jj2Var;
        this.j = em4Var;
        this.f = new jj2();
    }
}
