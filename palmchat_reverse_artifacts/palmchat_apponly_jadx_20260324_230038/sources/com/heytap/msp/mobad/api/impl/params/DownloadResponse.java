package com.heytap.msp.mobad.api.impl.params;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DownloadResponse {
    private static final String TAG = "DownloadResponse";
    public final long contentLength;
    public final boolean success;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private boolean success = false;
        private long contentLength = -1;

        public DownloadResponse build() {
            return new DownloadResponse(this);
        }

        public Builder setContentLength(long j) {
            this.contentLength = j;
            return this;
        }

        public Builder setSuccess(boolean z) {
            this.success = z;
            return this;
        }
    }

    public DownloadResponse(Builder builder) {
        this.success = builder.success;
        this.contentLength = builder.contentLength;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.success + ", contentLength=" + this.contentLength + '}';
    }
}
