package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.http.HeaderParser;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class RequestHeaders {
    private String acceptEncoding;
    private String connection;
    private long contentLength;
    private String contentType;
    private boolean hasAuthorization;
    private final RawHeaders headers;
    private String host;
    private String ifModifiedSince;
    private String ifNoneMatch;
    private int maxAgeSeconds = -1;
    private int maxStaleSeconds = -1;
    private int minFreshSeconds = -1;
    private boolean noCache;
    private boolean onlyIfCached;
    private String proxyAuthorization;
    private String transferEncoding;
    private final URI uri;
    private String userAgent;

    public RequestHeaders(URI uri, RawHeaders rawHeaders) {
        this.contentLength = -1L;
        this.uri = uri;
        this.headers = rawHeaders;
        HeaderParser.CacheControlHandler cacheControlHandler = new HeaderParser.CacheControlHandler() { // from class: com.squareup.okhttp.internal.http.RequestHeaders.1
            @Override // com.squareup.okhttp.internal.http.HeaderParser.CacheControlHandler
            public void handle(String str, String str2) {
                if ("no-cache".equalsIgnoreCase(str)) {
                    RequestHeaders.this.noCache = true;
                    return;
                }
                if ("max-age".equalsIgnoreCase(str)) {
                    RequestHeaders.this.maxAgeSeconds = HeaderParser.parseSeconds(str2);
                    return;
                }
                if ("max-stale".equalsIgnoreCase(str)) {
                    RequestHeaders.this.maxStaleSeconds = HeaderParser.parseSeconds(str2);
                } else if ("min-fresh".equalsIgnoreCase(str)) {
                    RequestHeaders.this.minFreshSeconds = HeaderParser.parseSeconds(str2);
                } else if ("only-if-cached".equalsIgnoreCase(str)) {
                    RequestHeaders.this.onlyIfCached = true;
                }
            }
        };
        for (int i = 0; i < rawHeaders.length(); i++) {
            String fieldName = rawHeaders.getFieldName(i);
            String value = rawHeaders.getValue(i);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(fieldName)) {
                HeaderParser.parseCacheControl(value, cacheControlHandler);
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(fieldName)) {
                if ("no-cache".equalsIgnoreCase(value)) {
                    this.noCache = true;
                }
            } else if (HttpHeaders.IF_NONE_MATCH.equalsIgnoreCase(fieldName)) {
                this.ifNoneMatch = value;
            } else if (HttpHeaders.IF_MODIFIED_SINCE.equalsIgnoreCase(fieldName)) {
                this.ifModifiedSince = value;
            } else if (HttpHeaders.AUTHORIZATION.equalsIgnoreCase(fieldName)) {
                this.hasAuthorization = true;
            } else if ("Content-Length".equalsIgnoreCase(fieldName)) {
                try {
                    this.contentLength = Integer.parseInt(value);
                } catch (NumberFormatException unused) {
                }
            } else if ("Transfer-Encoding".equalsIgnoreCase(fieldName)) {
                this.transferEncoding = value;
            } else if ("User-Agent".equalsIgnoreCase(fieldName)) {
                this.userAgent = value;
            } else if ("Host".equalsIgnoreCase(fieldName)) {
                this.host = value;
            } else if ("Connection".equalsIgnoreCase(fieldName)) {
                this.connection = value;
            } else if (HttpHeaders.ACCEPT_ENCODING.equalsIgnoreCase(fieldName)) {
                this.acceptEncoding = value;
            } else if ("Content-Type".equalsIgnoreCase(fieldName)) {
                this.contentType = value;
            } else if (HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(fieldName)) {
                this.proxyAuthorization = value;
            }
        }
    }

    private String buildCookieHeader(List<String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public void addCookies(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                if (!entry.getValue().isEmpty()) {
                    this.headers.add(key, buildCookieHeader(entry.getValue()));
                }
            }
        }
    }

    public String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    public String getConnection() {
        return this.connection;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public RawHeaders getHeaders() {
        return this.headers;
    }

    public String getHost() {
        return this.host;
    }

    public String getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public String getIfNoneMatch() {
        return this.ifNoneMatch;
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    public String getProxyAuthorization() {
        return this.proxyAuthorization;
    }

    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public URI getUri() {
        return this.uri;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean hasAuthorization() {
        return this.hasAuthorization;
    }

    public boolean hasConditions() {
        return (this.ifModifiedSince == null && this.ifNoneMatch == null) ? false : true;
    }

    public boolean hasConnectionClose() {
        return "close".equalsIgnoreCase(this.connection);
    }

    public boolean isChunked() {
        return HTTP.CHUNK_CODING.equalsIgnoreCase(this.transferEncoding);
    }

    public boolean isNoCache() {
        return this.noCache;
    }

    public boolean isOnlyIfCached() {
        return this.onlyIfCached;
    }

    public void removeContentLength() {
        if (this.contentLength != -1) {
            this.headers.removeAll("Content-Length");
            this.contentLength = -1L;
        }
    }

    public void setAcceptEncoding(String str) {
        if (this.acceptEncoding != null) {
            this.headers.removeAll(HttpHeaders.ACCEPT_ENCODING);
        }
        this.headers.add(HttpHeaders.ACCEPT_ENCODING, str);
        this.acceptEncoding = str;
    }

    public void setChunked() {
        if (this.transferEncoding != null) {
            this.headers.removeAll("Transfer-Encoding");
        }
        this.headers.add("Transfer-Encoding", HTTP.CHUNK_CODING);
        this.transferEncoding = HTTP.CHUNK_CODING;
    }

    public void setConnection(String str) {
        if (this.connection != null) {
            this.headers.removeAll("Connection");
        }
        this.headers.add("Connection", str);
        this.connection = str;
    }

    public void setContentLength(long j) {
        if (this.contentLength != -1) {
            this.headers.removeAll("Content-Length");
        }
        this.headers.add("Content-Length", Long.toString(j));
        this.contentLength = j;
    }

    public void setContentType(String str) {
        if (this.contentType != null) {
            this.headers.removeAll("Content-Type");
        }
        this.headers.add("Content-Type", str);
        this.contentType = str;
    }

    public void setHost(String str) {
        if (this.host != null) {
            this.headers.removeAll("Host");
        }
        this.headers.add("Host", str);
        this.host = str;
    }

    public void setIfModifiedSince(Date date) {
        if (this.ifModifiedSince != null) {
            this.headers.removeAll(HttpHeaders.IF_MODIFIED_SINCE);
        }
        String str = HttpDate.format(date);
        this.headers.add(HttpHeaders.IF_MODIFIED_SINCE, str);
        this.ifModifiedSince = str;
    }

    public void setIfNoneMatch(String str) {
        if (this.ifNoneMatch != null) {
            this.headers.removeAll(HttpHeaders.IF_NONE_MATCH);
        }
        this.headers.add(HttpHeaders.IF_NONE_MATCH, str);
        this.ifNoneMatch = str;
    }

    public void setUserAgent(String str) {
        if (this.userAgent != null) {
            this.headers.removeAll("User-Agent");
        }
        this.headers.add("User-Agent", str);
        this.userAgent = str;
    }
}
