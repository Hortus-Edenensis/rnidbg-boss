package com.heytap.msp.mobad.api.params;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class NativeAdSize {
    public final int heightInDp;
    public final int widthInDp;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private int widthInDp = 0;
        private int heightInDp = 0;

        public NativeAdSize build() {
            return new NativeAdSize(this);
        }

        public Builder setHeightInDp(int i) {
            this.heightInDp = i;
            return this;
        }

        public Builder setWidthInDp(int i) {
            this.widthInDp = i;
            return this;
        }
    }

    public NativeAdSize(Builder builder) {
        this.widthInDp = builder.widthInDp;
        this.heightInDp = builder.heightInDp;
    }

    public String toString() {
        return "NativeAdSize{widthInDp=" + this.widthInDp + ", heightInDp=" + this.heightInDp + '}';
    }
}
