package com.zm.adxsdk.protocol.api;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WfSensitivityController {
    private final Builder builder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private boolean canGetAppList = true;
        private boolean canGetAndroidId = true;
        private boolean canGetOaid = true;
        private boolean canReadPhoneState = true;
        private boolean canGetNetworkState = true;
        private boolean canGetLocation = true;

        public WfSensitivityController build() {
            return new WfSensitivityController(this);
        }

        public Builder setCanGetAndroidId(boolean z) {
            this.canGetAndroidId = z;
            return this;
        }

        public Builder setCanGetAppList(boolean z) {
            this.canGetAppList = z;
            return this;
        }

        public Builder setCanGetLocation(boolean z) {
            this.canGetLocation = z;
            return this;
        }

        public Builder setCanGetNetworkState(boolean z) {
            this.canGetNetworkState = z;
            return this;
        }

        @Deprecated
        public Builder setCanGetOaid(boolean z) {
            this.canGetOaid = z;
            return this;
        }

        public Builder setCanReadPhoneState(boolean z) {
            this.canReadPhoneState = z;
            return this;
        }
    }

    public WfSensitivityController(Builder builder) {
        this.builder = builder;
    }

    public boolean canGetAndroidId() {
        return this.builder.canGetAndroidId;
    }

    public boolean canGetAppList() {
        return this.builder.canGetAppList;
    }

    public boolean canGetLocation() {
        return this.builder.canGetLocation;
    }

    public boolean canGetNetworkState() {
        return this.builder.canGetNetworkState;
    }

    public boolean canGetOaid() {
        return this.builder.canGetOaid;
    }

    public boolean canReadPhoneState() {
        return this.builder.canReadPhoneState;
    }
}
