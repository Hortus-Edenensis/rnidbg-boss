package com.wifi.adsdk.params;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdReqParams {
    private String channelId;
    private String clientReqId;
    private String contentSource;
    private int height;
    private int interactiveType;
    private String latitude;
    private int limit;
    private String longitude;
    private String lxSrcId;
    private String nestSrcId;
    private String scene;
    private int width;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private final LxAdReqParams config = new LxAdReqParams();

        private Builder setLatitude(String str) {
            this.config.latitude = str;
            return this;
        }

        private Builder setLongitude(String str) {
            this.config.longitude = str;
            return this;
        }

        public LxAdReqParams build() {
            return this.config;
        }

        public Builder setChannelId(String str) {
            this.config.channelId = str;
            return this;
        }

        public Builder setContentSource(String str) {
            this.config.contentSource = str;
            return this;
        }

        public Builder setHeight(int i) {
            this.config.height = i;
            return this;
        }

        public Builder setInteractiveType(int i) {
            this.config.interactiveType = i;
            return this;
        }

        public Builder setLimit(int i) {
            this.config.limit = i;
            return this;
        }

        public Builder setLxSrcId(String str) {
            this.config.lxSrcId = str;
            return this;
        }

        public Builder setNextSrcId(String str) {
            this.config.nestSrcId = str;
            return this;
        }

        public Builder setRequestId(String str) {
            this.config.clientReqId = str;
            return this;
        }

        public Builder setScene(String str) {
            this.config.scene = str;
            return this;
        }

        public Builder setWidth(int i) {
            this.config.width = i;
            return this;
        }
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getClientReqId() {
        return this.clientReqId;
    }

    public String getContentSource() {
        return this.contentSource;
    }

    public int getHeight() {
        return this.height;
    }

    public int getInteractiveType() {
        return this.interactiveType;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public int getLimit() {
        return this.limit;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getLxSrcId() {
        return this.lxSrcId;
    }

    public String getNestSrcId() {
        return this.nestSrcId;
    }

    public String getScene() {
        return this.scene;
    }

    public int getWidth() {
        return this.width;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setClientReqId(String str) {
        this.clientReqId = str;
    }

    public void setContentSource(String str) {
        this.contentSource = str;
    }

    public void setDi(String str) {
        this.lxSrcId = str;
    }

    public void setInteractiveType(int i) {
        this.interactiveType = i;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    private LxAdReqParams() {
        this.limit = 1;
    }
}
