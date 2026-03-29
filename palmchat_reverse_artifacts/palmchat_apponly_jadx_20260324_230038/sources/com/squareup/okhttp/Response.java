package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RawHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class Response {
    private final Body body;
    private final int code;
    private final RawHeaders headers;
    private final Response redirectedBy;
    private final Request request;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Body {
        private Reader reader;

        private Charset charset() {
            MediaType mediaTypeContentType = contentType();
            return mediaTypeContentType != null ? mediaTypeContentType.charset(Util.UTF_8) : Util.UTF_8;
        }

        public abstract InputStream byteStream() throws IOException;

        public final byte[] bytes() throws IOException {
            long jContentLength = contentLength();
            if (jContentLength > 2147483647L) {
                throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
            }
            if (jContentLength == -1) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Util.copy(byteStream(), byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            byte[] bArr = new byte[(int) jContentLength];
            InputStream inputStreamByteStream = byteStream();
            Util.readFully(inputStreamByteStream, bArr);
            if (inputStreamByteStream.read() == -1) {
                return bArr;
            }
            throw new IOException("Content-Length and stream length disagree");
        }

        public final Reader charStream() throws IOException {
            if (this.reader == null) {
                this.reader = new InputStreamReader(byteStream(), charset());
            }
            return this.reader;
        }

        public abstract long contentLength();

        public abstract MediaType contentType();

        public abstract boolean ready() throws IOException;

        public final String string() throws IOException {
            return new String(bytes(), charset().name());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private Body body;
        private final int code;
        private RawHeaders headers = new RawHeaders();
        private Response redirectedBy;
        private final Request request;

        public Builder(Request request, int i) {
            if (request == null) {
                throw new IllegalArgumentException("request == null");
            }
            if (i <= 0) {
                throw new IllegalArgumentException("code <= 0");
            }
            this.request = request;
            this.code = i;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder body(Body body) {
            this.body = body;
            return this;
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("Response has no request.");
            }
            if (this.code != -1) {
                return new Response(this);
            }
            throw new IllegalStateException("Response has no code.");
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder rawHeaders(RawHeaders rawHeaders) {
            this.headers = new RawHeaders(rawHeaders);
            return this;
        }

        public Builder redirectedBy(Response response) {
            this.redirectedBy = response;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Receiver {
        void onFailure(Failure failure);

        boolean onResponse(Response response) throws IOException;
    }

    public Body body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }

    public String header(String str) {
        return header(str, null);
    }

    public int headerCount() {
        return this.headers.length();
    }

    public String headerName(int i) {
        return this.headers.getFieldName(i);
    }

    public Set<String> headerNames() {
        return this.headers.names();
    }

    public String headerValue(int i) {
        return this.headers.getValue(i);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public RawHeaders rawHeaders() {
        return new RawHeaders(this.headers);
    }

    public Response redirectedBy() {
        return this.redirectedBy;
    }

    public Request request() {
        return this.request;
    }

    private Response(Builder builder) {
        this.request = builder.request;
        this.code = builder.code;
        this.headers = new RawHeaders(builder.headers);
        this.body = builder.body;
        this.redirectedBy = builder.redirectedBy;
    }

    public String header(String str, String str2) {
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }
}
