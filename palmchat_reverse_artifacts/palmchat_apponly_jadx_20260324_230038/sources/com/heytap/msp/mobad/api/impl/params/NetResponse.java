package com.heytap.msp.mobad.api.impl.params;

import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class NetResponse {
    public static final int DEFAULT_CODE = -1;
    public static final int DEFAULT_CONTENT_LENGTH = -1;
    private static final String TAG = "NetResponse";
    public final int code;
    public final long contentLength;
    public final String errMsg;
    public final Map<String, String> headerMap;
    public final InputStream inputStream;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private int code = -1;
        private long contentLength = -1;
        private String errMsg;
        private Map<String, String> headerMap;
        private InputStream inputStream;

        public NetResponse build() {
            return new NetResponse(this);
        }

        public Builder setCode(int i) {
            this.code = i;
            return this;
        }

        public Builder setContentLength(long j) {
            this.contentLength = j;
            return this;
        }

        public Builder setErrMsg(String str) {
            this.errMsg = str;
            return this;
        }

        public Builder setHeaderMap(Map<String, String> map) {
            this.headerMap = map;
            return this;
        }

        public Builder setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
            return this;
        }
    }

    public NetResponse(Builder builder) {
        this.code = builder.code;
        this.errMsg = builder.errMsg;
        this.inputStream = builder.inputStream;
        this.contentLength = builder.contentLength;
        this.headerMap = builder.headerMap;
    }

    public String toString() {
        return "NetResponse{code=" + this.code + ", errMsg='" + this.errMsg + "', inputStream=" + this.inputStream + ", contentLength=" + this.contentLength + ", headerMap=" + this.headerMap + '}';
    }
}
