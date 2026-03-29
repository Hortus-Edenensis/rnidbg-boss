package com.zm.fissionsdk.api;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FissionVideoOption {
    private Builder mBuilder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private int autoPlayPolicy = 3;
        private boolean videoMute = true;
        private boolean showEndCard = true;
        private boolean videoReplay = false;
        private boolean showVideoProgress = true;
        private boolean showVideoCover = true;
        private int theme = 0;
        private int scaleType = 0;

        public FissionVideoOption build() {
            return new FissionVideoOption(this);
        }

        public Builder setAutoPlayPolicy(int i) {
            if (i > 0) {
                this.autoPlayPolicy = i;
            }
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

        public Builder setVideoReplay(boolean z) {
            this.videoReplay = z;
            return this;
        }
    }

    public int getAutoPlayPolicy() {
        return this.mBuilder.autoPlayPolicy;
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

    private FissionVideoOption(Builder builder) {
        this.mBuilder = builder;
    }
}
