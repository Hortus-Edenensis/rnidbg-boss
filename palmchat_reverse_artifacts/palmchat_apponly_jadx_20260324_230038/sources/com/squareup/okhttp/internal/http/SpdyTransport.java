package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class SpdyTransport implements Transport {
    private final HttpEngine httpEngine;
    private final SpdyConnection spdyConnection;
    private SpdyStream stream;

    public SpdyTransport(HttpEngine httpEngine, SpdyConnection spdyConnection) {
        this.httpEngine = httpEngine;
        this.spdyConnection = spdyConnection;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public OutputStream createRequestBody() throws IOException {
        long fixedContentLength = this.httpEngine.policy.getFixedContentLength();
        if (fixedContentLength != -1) {
            this.httpEngine.requestHeaders.setContentLength(fixedContentLength);
        }
        writeRequestHeaders();
        return this.stream.getOutputStream();
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void flushRequest() throws IOException {
        this.stream.getOutputStream().close();
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public InputStream getTransferStream(CacheRequest cacheRequest) throws IOException {
        return new UnknownLengthHttpInputStream(this.stream.getInputStream(), cacheRequest, this.httpEngine);
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public boolean makeReusable(boolean z, OutputStream outputStream, InputStream inputStream) {
        if (!z) {
            return true;
        }
        SpdyStream spdyStream = this.stream;
        if (spdyStream == null) {
            return false;
        }
        spdyStream.closeLater(ErrorCode.CANCEL);
        return true;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public ResponseHeaders readResponseHeaders() throws IOException {
        RawHeaders rawHeadersFromNameValueBlock = RawHeaders.fromNameValueBlock(this.stream.getResponseHeaders());
        this.httpEngine.receiveHeaders(rawHeadersFromNameValueBlock);
        ResponseHeaders responseHeaders = new ResponseHeaders(this.httpEngine.uri, rawHeadersFromNameValueBlock);
        responseHeaders.setTransport("spdy/3");
        return responseHeaders;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void writeRequestBody(RetryableOutputStream retryableOutputStream) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void writeRequestHeaders() throws IOException {
        if (this.stream != null) {
            return;
        }
        this.httpEngine.writingRequestHeaders();
        RawHeaders headers = this.httpEngine.requestHeaders.getHeaders();
        String str = this.httpEngine.connection.getHttpMinorVersion() == 1 ? "HTTP/1.1" : "HTTP/1.0";
        URL url = this.httpEngine.policy.getURL();
        headers.addSpdyRequestHeaders(this.httpEngine.method, HttpEngine.requestPath(url), str, HttpEngine.getOriginAddress(url), this.httpEngine.uri.getScheme());
        SpdyStream spdyStreamNewStream = this.spdyConnection.newStream(headers.toNameValueBlock(), this.httpEngine.hasRequestBody(), true);
        this.stream = spdyStreamNewStream;
        spdyStreamNewStream.setReadTimeout(this.httpEngine.client.getReadTimeout());
    }
}
