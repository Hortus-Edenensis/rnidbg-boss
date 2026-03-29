package com.efs.sdk.net;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class OkHttpInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f5622a = g.c();

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResponseBody f5623a;
        private final BufferedSource b;

        public a(ResponseBody responseBody, InputStream inputStream) {
            this.f5623a = responseBody;
            this.b = Okio.buffer(Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: contentLength */
        public final long getContentLength() {
            return this.f5623a.getContentLength();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: contentType */
        public final MediaType get$contentType() {
            return this.f5623a.get$contentType();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: source */
        public final BufferedSource getBodySource() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5624a;
        private final Request b;
        private h c;

        public b(String str, Request request, h hVar) {
            this.f5624a = str;
            this.b = request;
            this.c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.c
        public final String a() {
            return this.f5624a;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String b() {
            return this.b.url().getUrl();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String c() {
            return this.b.method();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final byte[] d() throws IOException {
            RequestBody requestBodyBody = this.b.body();
            if (requestBodyBody == null) {
                return null;
            }
            h hVar = this.c;
            String strHeader = this.b.header("Content-Encoding");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.efs.sdk.net.a.a.a aVar = new com.efs.sdk.net.a.a.a(Constants.CP_GZIP.equals(strHeader) ? e.a(byteArrayOutputStream) : "deflate".equals(strHeader) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream);
            hVar.c = aVar;
            hVar.b = byteArrayOutputStream;
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(aVar));
            try {
                requestBodyBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                h hVar2 = this.c;
                hVar2.b();
                return hVar2.b.toByteArray();
            } catch (Throwable th) {
                bufferedSinkBuffer.close();
                throw th;
            }
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.b.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i) {
            return this.b.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i) {
            return this.b.headers().value(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements f.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5625a;
        private final Request b;
        private final Response c;
        private final Connection d;

        public c(String str, Request request, Response response, Connection connection) {
            this.f5625a = str;
            this.b = request;
            this.c = response;
            this.d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final String a() {
            return this.f5625a;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final int b() {
            return this.c.code();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.c.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i) {
            return this.c.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i) {
            return this.c.headers().value(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:7:0x001d, B:10:0x0024, B:14:0x0035, B:16:0x0050, B:15:0x004b), top: B:59:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:7:0x001d, B:10:0x0024, B:14:0x0035, B:16:0x0050, B:15:0x004b), top: B:59:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:29:0x00a3, B:35:0x00ae, B:37:0x00b4, B:38:0x00c1, B:40:0x00c7, B:42:0x00d7, B:44:0x00e2, B:46:0x00e6, B:47:0x00ea, B:49:0x00fd, B:50:0x0110, B:51:0x0117), top: B:58:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:29:0x00a3, B:35:0x00ae, B:37:0x00b4, B:38:0x00c1, B:40:0x00c7, B:42:0x00d7, B:44:0x00e2, B:46:0x00e6, B:47:0x00ea, B:49:0x00fd, B:50:0x0110, B:51:0x0117), top: B:58:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        h hVar;
        String str;
        boolean z;
        h hVar2;
        boolean zEnableTracer;
        String strB;
        Connection connection;
        MediaType mediaTypeContentType;
        InputStream inputStreamByteStream;
        Request request = chain.request();
        try {
            Log.d("NetTrace-Interceptor", "begin intercept");
            zEnableTracer = NetManager.getNetConfigManager() != null ? NetManager.getNetConfigManager().enableTracer() : false;
            if (zEnableTracer) {
                if (request == null) {
                }
                strB = this.f5622a.b();
                Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(strB)));
                com.efs.sdk.net.a.a.a().a(strB).c = request.url().getUrl();
                hVar2 = new h(this.f5622a, strB);
                this.f5622a.a(new b(strB, request, hVar2));
            } else {
                try {
                    if (IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                        if (request == null) {
                            Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
                        } else {
                            Log.d("NetTrace-Interceptor", "intercept request is null~");
                        }
                        strB = this.f5622a.b();
                        try {
                            Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(strB)));
                            com.efs.sdk.net.a.a.a().a(strB).c = request.url().getUrl();
                            hVar2 = new h(this.f5622a, strB);
                            try {
                                this.f5622a.a(new b(strB, request, hVar2));
                            } catch (Throwable th) {
                                boolean z2 = zEnableTracer;
                                hVar = hVar2;
                                th = th;
                                str = strB;
                                z = z2;
                                th.printStackTrace();
                                hVar2 = hVar;
                                zEnableTracer = z;
                                strB = str;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = strB;
                            z = zEnableTracer;
                            hVar = null;
                        }
                    } else {
                        Log.d("NetTrace-Interceptor", "net enable is false~");
                        hVar2 = null;
                        strB = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = null;
                    z = zEnableTracer;
                    hVar = null;
                    th.printStackTrace();
                    hVar2 = hVar;
                    zEnableTracer = z;
                    strB = str;
                    Response responseProceed = chain.proceed(request);
                    if (!zEnableTracer) {
                    }
                    if (hVar2 != null) {
                        hVar2.b();
                        f fVar = hVar2.f5635a;
                        hVar2.b.size();
                        fVar.a();
                    }
                    connection = chain.connection();
                    if (connection != null) {
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            hVar = null;
            str = null;
            z = false;
        }
        Response responseProceed2 = chain.proceed(request);
        if (!zEnableTracer) {
            try {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    return responseProceed2;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                return responseProceed2;
            }
        }
        if (hVar2 != null && hVar2.a()) {
            hVar2.b();
            f fVar2 = hVar2.f5635a;
            hVar2.b.size();
            fVar2.a();
        }
        connection = chain.connection();
        if (connection != null) {
            throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
        }
        this.f5622a.a(new c(strB, request, responseProceed2, connection));
        ResponseBody responseBodyBody = responseProceed2.body();
        if (responseBodyBody != null) {
            mediaTypeContentType = responseBodyBody.get$contentType();
            inputStreamByteStream = responseBodyBody.byteStream();
        } else {
            mediaTypeContentType = null;
            inputStreamByteStream = null;
        }
        f fVar3 = this.f5622a;
        String string = mediaTypeContentType != null ? mediaTypeContentType.getMediaType() : null;
        String strHeader = responseProceed2.header("Content-Encoding");
        new com.efs.sdk.net.a.a.c(this.f5622a, strB);
        InputStream inputStreamA = fVar3.a(strB, string, strHeader, inputStreamByteStream);
        return inputStreamA != null ? responseProceed2.newBuilder().body(new a(responseBodyBody, inputStreamA)).build() : responseProceed2;
    }
}
