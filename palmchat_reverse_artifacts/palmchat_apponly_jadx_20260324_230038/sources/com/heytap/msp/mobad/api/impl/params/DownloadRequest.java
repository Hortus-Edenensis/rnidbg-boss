package com.heytap.msp.mobad.api.impl.params;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DownloadRequest {
    public static final int SAVE_TYPE_OF_APP_DIR_FILE = 2;
    public static final int SAVE_TYPE_OF_APP_FILE = 1;
    public static final int SAVE_TYPE_OF_SDCARD = 0;
    private static final String TAG = "DownloadRequest";
    public final String dir;
    public final String fileName;
    public final String md5;
    public final int mode;
    public final NetRequest netRequest;
    public final String savePath;
    public final int saveType;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private String dir;
        private String fileName;
        private String md5;
        private NetRequest netRequest;
        private String savePath;
        private int saveType = -1;
        private int mode = 0;

        private boolean isNullOrEmpty(String str) {
            return str == null || "".equals(str.trim());
        }

        private boolean isSupportSaveType(int i) {
            return i == 0 || 1 == i || 2 == i;
        }

        public DownloadRequest build() throws Exception {
            if (this.netRequest == null) {
                throw new NullPointerException("netRequest is null.");
            }
            if (!isSupportSaveType(this.saveType)) {
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            if (this.saveType == 0 && isNullOrEmpty(this.savePath)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
            }
            int i = this.saveType;
            if ((1 == i || 2 == i) && isNullOrEmpty(this.fileName)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
            }
            return new DownloadRequest(this);
        }

        public Builder setDir(String str) {
            this.dir = str;
            return this;
        }

        public Builder setFileName(String str) {
            this.fileName = str;
            return this;
        }

        public Builder setMd5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder setMode(int i) {
            this.mode = i;
            return this;
        }

        public Builder setNetRequest(NetRequest netRequest) {
            this.netRequest = netRequest;
            return this;
        }

        public Builder setSavePath(String str) {
            this.savePath = str;
            return this;
        }

        public Builder setSaveType(int i) {
            this.saveType = i;
            return this;
        }
    }

    public DownloadRequest(Builder builder) {
        this.netRequest = builder.netRequest;
        this.md5 = builder.md5;
        this.saveType = builder.saveType;
        this.savePath = builder.savePath;
        this.mode = builder.mode;
        this.dir = builder.dir;
        this.fileName = builder.fileName;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.netRequest + ", md5='" + this.md5 + "', saveType=" + this.saveType + ", savePath='" + this.savePath + "', mode=" + this.mode + ", dir='" + this.dir + "', fileName='" + this.fileName + "'}";
    }
}
