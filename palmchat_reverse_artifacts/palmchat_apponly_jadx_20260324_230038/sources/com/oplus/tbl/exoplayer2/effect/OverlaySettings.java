package com.oplus.tbl.exoplayer2.effect;

import android.util.Pair;
import androidx.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class OverlaySettings {
    public final float alphaScale;
    public final Pair<Float, Float> backgroundFrameAnchor;
    public final Pair<Float, Float> overlayFrameAnchor;
    public final float rotationDegrees;
    public final Pair<Float, Float> scale;
    public final boolean useHdr;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private float alphaScale;
        private Pair<Float, Float> backgroundFrameAnchor;
        private Pair<Float, Float> overlayFrameAnchor;
        private float rotationDegrees;
        private Pair<Float, Float> scale;
        private boolean useHdr;

        public Builder() {
            Float fValueOf = Float.valueOf(1.0f);
            this.alphaScale = 1.0f;
            Float fValueOf2 = Float.valueOf(0.0f);
            this.backgroundFrameAnchor = Pair.create(fValueOf2, fValueOf2);
            this.overlayFrameAnchor = Pair.create(fValueOf2, fValueOf2);
            this.scale = Pair.create(fValueOf, fValueOf);
            this.rotationDegrees = 0.0f;
        }

        public OverlaySettings build() {
            return new OverlaySettings(this.useHdr, this.alphaScale, this.backgroundFrameAnchor, this.overlayFrameAnchor, this.scale, this.rotationDegrees);
        }

        public Builder setAlphaScale(@FloatRange(from = 0.0d) float f) {
            Assertions.checkArgument(0.0f <= f, "alphaScale needs to be greater than or equal to zero.");
            this.alphaScale = f;
            return this;
        }

        public Builder setBackgroundFrameAnchor(@FloatRange(from = -1.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f, @FloatRange(from = -1.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f2) {
            Assertions.checkArgument(-1.0f <= f && f <= 1.0f);
            Assertions.checkArgument(-1.0f <= f2 && f2 <= 1.0f);
            this.backgroundFrameAnchor = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        public Builder setOverlayFrameAnchor(@FloatRange(from = -1.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f, @FloatRange(from = -1.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f2) {
            Assertions.checkArgument(-1.0f <= f && f <= 1.0f);
            Assertions.checkArgument(-1.0f <= f2 && f2 <= 1.0f);
            this.overlayFrameAnchor = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        public Builder setRotationDegrees(float f) {
            this.rotationDegrees = f;
            return this;
        }

        public Builder setScale(float f, float f2) {
            this.scale = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        public Builder setUsesHdr(boolean z) {
            this.useHdr = z;
            return this;
        }

        private Builder(OverlaySettings overlaySettings) {
            this.useHdr = overlaySettings.useHdr;
            this.alphaScale = overlaySettings.alphaScale;
            this.backgroundFrameAnchor = overlaySettings.backgroundFrameAnchor;
            this.overlayFrameAnchor = overlaySettings.overlayFrameAnchor;
            this.scale = overlaySettings.scale;
            this.rotationDegrees = overlaySettings.rotationDegrees;
        }
    }

    private OverlaySettings(boolean z, float f, Pair<Float, Float> pair, Pair<Float, Float> pair2, Pair<Float, Float> pair3, float f2) {
        this.useHdr = z;
        this.alphaScale = f;
        this.backgroundFrameAnchor = pair;
        this.overlayFrameAnchor = pair2;
        this.scale = pair3;
        this.rotationDegrees = f2;
    }

    public Builder buildUpon() {
        return new Builder();
    }
}
