package com.heytap.msp.mobad.api.impl.params;

import java.util.Arrays;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class NetRequest {
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 30000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 30000;
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final int NET_PROTOCOL_HTTP = 0;
    public static final int NET_PROTOCOL_HTTP2 = 2;
    public static final int NET_PROTOCOL_HTTPS = 1;
    public static final int NET_PROTOCOL_SPDY = 3;
    private static final String TAG = "NetRequest";
    public final int connectTimeout;
    public final byte[] data;
    public final Map<String, String> headerMap;
    public final HostnameVerifier hostnameVerifier;
    public final String httpMethod;
    public final int protocol;
    public final int readTimeout;
    public final SSLSocketFactory sslSocketFactory;
    public final String url;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private byte[] data;
        private Map<String, String> headerMap;
        private HostnameVerifier hostnameVerifier;
        private String httpMethod;
        private SSLSocketFactory sslSocketFactory;
        private String url;
        private int protocol = 0;
        private int connectTimeout = 30000;
        private int readTimeout = 30000;

        private boolean isNullOrEmpty(String str) {
            return str == null || "".equals(str.trim());
        }

        private boolean isSupportProtocol(int i) {
            return i == 0 || 1 == i || 2 == i || 3 == i;
        }

        public NetRequest build() throws Exception {
            if (isNullOrEmpty(this.httpMethod) || isNullOrEmpty(this.url)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            if (isSupportProtocol(this.protocol)) {
                return new NetRequest(this);
            }
            throw new Exception("protocol should be NET_PROTOCOL_HTTP or NET_PROTOCOL_HTTPS or NET_PROTOCOL_HTTP2 or NET_PROTOCOL_SPDY");
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        public Builder setData(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder setHeaderMap(Map<String, String> map) {
            this.headerMap = map;
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public Builder setHttpMethod(String str) {
            this.httpMethod = str;
            return this;
        }

        public Builder setProtocol(int i) {
            this.protocol = i;
            return this;
        }

        public Builder setReadTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        public Builder setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public NetRequest(Builder builder) {
        this.protocol = builder.protocol;
        this.httpMethod = builder.httpMethod;
        this.url = builder.url;
        this.headerMap = builder.headerMap;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.data = builder.data;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.hostnameVerifier = builder.hostnameVerifier;
    }

    public String toString() {
        return "NetRequest{protocol=" + this.protocol + ", httpMethod='" + this.httpMethod + "', url='" + this.url + "', headerMap=" + this.headerMap + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", data=" + Arrays.toString(this.data) + ", sslSocketFactory=" + this.sslSocketFactory + ", hostnameVerifier=" + this.hostnameVerifier + '}';
    }
}
