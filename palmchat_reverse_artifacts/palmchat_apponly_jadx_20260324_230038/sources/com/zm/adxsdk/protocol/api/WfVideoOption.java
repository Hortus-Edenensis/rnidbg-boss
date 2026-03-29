package com.zm.adxsdk.protocol.api;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WfVideoOption {
    private Builder mBuilder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private int endCardType;
        private int autoPlayPolicy = 3;
        private boolean videoMute = true;
        private boolean showEndCard = true;
        private boolean videoReplay = false;
        private boolean showVideoProgress = true;
        private boolean showVideoCover = true;
        private int videoProgressPosition = 1;
        private int theme = 0;
        private int scaleType = 0;

        public WfVideoOption build() {
            return new WfVideoOption(this);
        }

        public Builder setAutoPlayPolicy(int i) {
            if (i > 0) {
                this.autoPlayPolicy = i;
            }
            return this;
        }

        public Builder setEndCardType(int i) {
            this.endCardType = i;
            return this;
        }

        public Builder setScaleType(int i) {
            this.scaleType = i;
            return this;
        }

        public Builder setShowEndCard(boolean z) {
            this.showEndCard = z;
            return this;
        }

        public Builder setShowVideoCover(boolean z) {
            this.showVideoCover = z;
            return this;
        }

        public Builder setShowVideoProgress(boolean z) {
            this.showVideoProgress = z;
            return this;
        }

        public Builder setTheme(int i) {
            this.theme = i;
            return this;
        }

        public Builder setVideoMute(boolean z) {
            this.videoMute = z;
            return this;
        }

        public Builder setVideoProgressPosition(int i) {
            this.videoProgressPosition = i;
            return this;
        }

        public Builder setVideoReplay(boolean z) {
            this.videoReplay = z;
            return this;
        }
    }

    public int getAutoPlayPolicy() {
        return this.mBuilder.autoPlayPolicy;
    }

    public int getEndCardType() {
        return this.mBuilder.endCardType;
    }

    public int getScaleType() {
        return this.mBuilder.scaleType;
    }

    public int getTheme() {
        return this.mBuilder.theme;
    }

    public boolean getVideoMute() {
        return this.mBuilder.videoMute;
    }

    public int getVideoProgressPosition() {
        return this.mBuilder.videoProgressPosition;
    }

    public boolean showEndCard() {
        return this.mBuilder.showEndCard;
    }

    public boolean showVideoCover() {
        return this.mBuilder.showVideoCover;
    }

    public boolean showVideoProgress() {
        return this.mBuilder.showVideoProgress;
    }

    public boolean videoReplay() {
        return this.mBuilder.videoReplay;
    }

    private WfVideoOption(Builder builder) {
        this.mBuilder = builder;
    }
}
