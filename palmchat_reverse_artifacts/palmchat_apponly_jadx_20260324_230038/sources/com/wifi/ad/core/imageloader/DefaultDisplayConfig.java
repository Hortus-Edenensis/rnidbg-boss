package com.wifi.ad.core.imageloader;

import androidx.annotation.DrawableRes;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultDisplayConfig extends AbstractDisplay {
    private int errorImage;
    private int loadingImage;
    private int padding;
    private int tagsTextColor;
    private int tagsTextSize;
    private int titleTextColor;
    private int titleTextSize;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        DefaultDisplayConfig config = new DefaultDisplayConfig();

        public DefaultDisplayConfig build() {
            return this.config;
        }

        public Builder setErrorImage(@DrawableRes int i) {
            this.config.errorImage = i;
            return this;
        }

        public Builder setLoadingImage(@DrawableRes int i) {
            this.config.loadingImage = i;
            return this;
        }
    }

    @Override // com.wifi.ad.core.imageloader.AbstractDisplay
    public int getErrorImage() {
        return this.errorImage;
    }

    @Override // com.wifi.ad.core.imageloader.AbstractDisplay
    public int getLoadingImage() {
        return this.loadingImage;
    }

    private DefaultDisplayConfig() {
    }
}
