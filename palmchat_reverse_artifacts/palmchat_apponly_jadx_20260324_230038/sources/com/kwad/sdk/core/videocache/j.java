package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aPC;
    private final com.kwad.sdk.core.videocache.b.b aPD;
    private n aQa;
    private InputStream aQc;
    private OkHttpClient aQh = new OkHttpClient();

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aPC = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.aPD = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n nVarFi = cVar.fi(str);
        this.aQa = nVarFi == null ? new n(str, -2147483648L, l.fg(str)) : nVarFi;
    }

    private void Mm() {
        Response responseEh = null;
        try {
            try {
                responseEh = eh(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aQa.url);
                if (0 == 0 || responseEh.body() == null) {
                    return;
                }
            }
            if (responseEh == null || !responseEh.isSuccessful()) {
                throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
            }
            n nVar = new n(this.aQa.url, c(responseEh), responseEh.header("Content-Type"));
            this.aQa = nVar;
            this.aPC.a(nVar.url, nVar);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aQa);
            if (responseEh.body() == null) {
                return;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(responseEh.body());
        } catch (Throwable th) {
            if (0 != 0 && responseEh.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(responseEh.body());
            }
            throw th;
        }
    }

    private void Mo() {
        n nVarFi;
        com.kwad.sdk.core.videocache.d.c cVar = this.aPC;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (nVarFi = cVar.fi(getUrl())) == null || TextUtils.isEmpty(nVarFi.aQr) || nVarFi.aQq == -2147483648L) {
            return;
        }
        this.aQa = nVarFi;
    }

    private long a(Response response, long j) {
        int iCode = response.code();
        long jContentLength = response.body().contentLength();
        return iCode == 200 ? jContentLength : iCode == 206 ? jContentLength + j : this.aQa.aQq;
    }

    private static long c(Response response) {
        String strHeader = response.header("Content-Length");
        if (strHeader == null) {
            return -1L;
        }
        return Long.parseLong(strHeader);
    }

    private Response eh(int i) throws IOException, ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builderNewBuilder.connectTimeout(10000L, timeUnit);
        builderNewBuilder.readTimeout(10000L, timeUnit);
        builderNewBuilder.writeTimeout(10000L, timeUnit);
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aQh = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            responseExecute = this.aQh.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header(HttpHeaders.LOCATION);
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
    }

    private Response f(long j, int i) throws IOException, ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = this.aQh.newBuilder();
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aQh = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader(HttpHeaders.RANGE, "bytes=" + j + "-");
            }
            responseExecute = this.aQh.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header(HttpHeaders.LOCATION);
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Mn() {
        if (TextUtils.isEmpty(this.aQa.aQr)) {
            Mo();
        }
        if (TextUtils.isEmpty(this.aQa.aQr)) {
            Mm();
        }
        return this.aQa.aQr;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aK(long j) throws ProxyCacheException {
        try {
            Response responseF = f(j, -1);
            String mediaType = responseF.body().contentType().getMediaType();
            long jA = a(responseF, j);
            this.aQc = new BufferedInputStream(responseF.body().byteStream(), 1024);
            n nVar = new n(this.aQa.url, jA, mediaType);
            this.aQa = nVar;
            this.aPC.a(nVar.url, nVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aQc);
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aQa.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.aQa.aQq == -2147483648L) {
            Mo();
        }
        if (this.aQa.aQq == -2147483648L) {
            Mm();
        }
        return this.aQa.aQq;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.aQc;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.aQa.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.aQa.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.aQa.url, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aQa + "}";
    }

    public j(j jVar) {
        this.aQa = jVar.aQa;
        this.aPC = jVar.aPC;
        this.aPD = jVar.aPD;
    }
}
