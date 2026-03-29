package com.heytap.msp.mobad.api.params;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class InterstitialParams {
    public final InterstitialScene interstitialScene;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private InterstitialScene interstitialScene;

        public InterstitialParams build() {
            return new InterstitialParams(this);
        }

        public Builder scene(InterstitialScene interstitialScene) {
            this.interstitialScene = interstitialScene;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum InterstitialScene {
        NORMAL,
        INSTANT_EXIT
    }

    public InterstitialParams(Builder builder) {
        this.interstitialScene = builder.interstitialScene;
    }
}
