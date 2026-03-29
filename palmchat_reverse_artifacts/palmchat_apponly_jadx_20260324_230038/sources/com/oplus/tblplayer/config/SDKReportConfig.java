package com.oplus.tblplayer.config;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SDKReportConfig {
    public boolean normalEnabled;
    public boolean stuckEnabled;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        public boolean stuckEnabled = false;
        public boolean normalEnabled = false;

        public SDKReportConfig build() {
            return new SDKReportConfig(this.stuckEnabled, this.normalEnabled);
        }

        public Builder setNormalEnabled(boolean z) {
            this.normalEnabled = z;
            return this;
        }

        public Builder setStuckEnabled(boolean z) {
            this.stuckEnabled = z;
            return this;
        }
    }

    public SDKReportConfig(boolean z, boolean z2) {
        this.stuckEnabled = z;
        this.normalEnabled = z2;
    }
}
