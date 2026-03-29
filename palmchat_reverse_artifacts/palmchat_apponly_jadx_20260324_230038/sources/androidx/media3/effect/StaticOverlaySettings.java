package androidx.media3.effect;

import android.util.Pair;
import androidx.annotation.FloatRange;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.baidu.mapapi.map.WeightedLatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class StaticOverlaySettings implements OverlaySettings {
    private final float alphaScale;
    private final Pair<Float, Float> backgroundFrameAnchor;
    private final float hdrLuminanceMultiplier;
    private final Pair<Float, Float> overlayFrameAnchor;
    private final float rotationDegrees;
    private final Pair<Float, Float> scale;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private float alphaScale = 1.0f;
        private Pair<Float, Float> backgroundFrameAnchor = OverlaySettings.DEFAULT_BACKGROUND_FRAME_ANCHOR;
        private Pair<Float, Float> overlayFrameAnchor = OverlaySettings.DEFAULT_OVERLAY_FRAME_ANCHOR;
        private Pair<Float, Float> scale = OverlaySettings.DEFAULT_SCALE;
        private float rotationDegrees = 0.0f;
        private float hdrLuminanceMultiplier = 1.0f;

        public StaticOverlaySettings build() {
            return new StaticOverlaySettings(this.alphaScale, this.backgroundFrameAnchor, this.overlayFrameAnchor, this.scale, this.rotationDegrees, this.hdrLuminanceMultiplier);
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

        public Builder setHdrLuminanceMultiplier(float f) {
            this.hdrLuminanceMultiplier = f;
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
    }

    @Override // androidx.media3.common.OverlaySettings
    public float getAlphaScale() {
        return this.alphaScale;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair<Float, Float> getBackgroundFrameAnchor() {
        return this.backgroundFrameAnchor;
    }

    @Override // androidx.media3.common.OverlaySettings
    public float getHdrLuminanceMultiplier() {
        return this.hdrLuminanceMultiplier;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair<Float, Float> getOverlayFrameAnchor() {
        return this.overlayFrameAnchor;
    }

    @Override // androidx.media3.common.OverlaySettings
    public float getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair<Float, Float> getScale() {
        return this.scale;
    }

    private StaticOverlaySettings(float f, Pair<Float, Float> pair, Pair<Float, Float> pair2, Pair<Float, Float> pair3, float f2, float f3) {
        this.alphaScale = f;
        this.backgroundFrameAnchor = pair;
        this.overlayFrameAnchor = pair2;
        this.scale = pair3;
        this.rotationDegrees = f2;
        this.hdrLuminanceMultiplier = f3;
    }
}
