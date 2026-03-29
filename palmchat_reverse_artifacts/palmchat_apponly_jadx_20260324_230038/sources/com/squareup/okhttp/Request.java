package com.squareup.okhttp;

import android.support.v4.media.session.PlaybackStateCompat;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RawHeaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class Request {
    private final Body body;
    private final RawHeaders headers;
    private final String method;
    private final Object tag;
    private final URL url;

    public Body body() {
        return this.body;
    }

    public String header(String str) {
        return this.headers.get(str);
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

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this.url).method(this.method, this.body).rawHeaders(this.headers).tag(this.tag);
    }

    public RawHeaders rawHeaders() {
        return new RawHeaders(this.headers);
    }

    public Object tag() {
        return this.tag;
    }

    public URL url() {
        return this.url;
    }

    public String urlString() {
        return this.url.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private Body body;
        private Object tag;
        private URL url;
        private String method = "GET";
        private RawHeaders headers = new RawHeaders();

        public Builder(String str) {
            url(str);
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method(com.qiniu.android.http.request.Request.HttpMethodHEAD, null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder method(String str, Body body) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            this.method = str;
            this.body = body;
            return this;
        }

        public Builder post(Body body) {
            return method("POST", body);
        }

        public Builder put(Body body) {
            return method("PUT", body);
        }

        public Builder rawHeaders(RawHeaders rawHeaders) {
            this.headers = new RawHeaders(rawHeaders);
            return this;
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder url(String str) {
            try {
                this.url = new URL(str);
                return this;
            } catch (MalformedURLException unused) {
                throw new IllegalArgumentException("Malformed URL: " + str);
            }
        }

        public Builder url(URL url) {
            if (url != null) {
                this.url = url;
                return this;
            }
            throw new IllegalStateException("url == null");
        }

        public Builder(URL url) {
            url(url);
        }
    }

    private Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = new RawHeaders(builder.headers);
        this.body = builder.body;
        this.tag = builder.tag != null ? builder.tag : this;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Body {
        public static Body create(MediaType mediaType, String str) {
            if (mediaType.charset() == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
            try {
                return create(mediaType, str.getBytes(mediaType.charset().name()));
            } catch (UnsupportedEncodingException unused) {
                throw new AssertionError();
            }
        }

        public long contentLength() {
            return -1L;
        }

        public abstract MediaType contentType();

        public abstract void writeTo(OutputStream outputStream) throws IOException;

        public static Body create(final MediaType mediaType, final byte[] bArr) {
            if (mediaType == null) {
                throw new NullPointerException("contentType == null");
            }
            if (bArr != null) {
                return new Body() { // from class: com.squareup.okhttp.Request.Body.1
                    @Override // com.squareup.okhttp.Request.Body
                    public long contentLength() {
                        return bArr.length;
                    }

                    @Override // com.squareup.okhttp.Request.Body
                    public MediaType contentType() {
                        return mediaType;
                    }

                    @Override // com.squareup.okhttp.Request.Body
                    public void writeTo(OutputStream outputStream) throws IOException {
                        outputStream.write(bArr);
                    }
                };
            }
            throw new NullPointerException("content == null");
        }

        public static Body create(final MediaType mediaType, final File file) {
            if (mediaType == null) {
                throw new NullPointerException("contentType == null");
            }
            if (file != null) {
                return new Body() { // from class: com.squareup.okhttp.Request.Body.2
                    @Override // com.squareup.okhttp.Request.Body
                    public long contentLength() {
                        return file.length();
                    }

                    @Override // com.squareup.okhttp.Request.Body
                    public MediaType contentType() {
                        return mediaType;
                    }

                    @Override // com.squareup.okhttp.Request.Body
                    public void writeTo(OutputStream outputStream) throws Throwable {
                        long jContentLength = contentLength();
                        if (jContentLength == 0) {
                            return;
                        }
                        FileInputStream fileInputStream = null;
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                byte[] bArr = new byte[(int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, jContentLength)];
                                while (true) {
                                    int i = fileInputStream2.read(bArr);
                                    if (i == -1) {
                                        Util.closeQuietly(fileInputStream2);
                                        return;
                                    }
                                    outputStream.write(bArr, 0, i);
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                Util.closeQuietly(fileInputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                };
            }
            throw new NullPointerException("content == null");
        }
    }
}
