package androidx.media3.common;

import android.util.Pair;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import defpackage.la4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface VideoCompositorSettings {
    public static final VideoCompositorSettings DEFAULT = new VideoCompositorSettings() { // from class: androidx.media3.common.VideoCompositorSettings.1
        @Override // androidx.media3.common.VideoCompositorSettings
        public Size getOutputSize(List<Size> list) {
            return list.get(0);
        }

        @Override // androidx.media3.common.VideoCompositorSettings
        public OverlaySettings getOverlaySettings(int i, long j) {
            return new OverlaySettings() { // from class: androidx.media3.common.VideoCompositorSettings.1.1
                @Override // androidx.media3.common.OverlaySettings
                public /* synthetic */ float getAlphaScale() {
                    return la4.a(this);
                }

                @Override // androidx.media3.common.OverlaySettings
                public /* synthetic */ Pair getBackgroundFrameAnchor() {
                    return la4.b(this);
                }

                @Override // androidx.media3.common.OverlaySettings
                public /* synthetic */ float getHdrLuminanceMultiplier() {
                    return la4.c(this);
                }

                @Override // androidx.media3.common.OverlaySettings
                public /* synthetic */ Pair getOverlayFrameAnchor() {
                    return la4.d(this);
                }

                @Override // androidx.media3.common.OverlaySettings
                public /* synthetic */ float getRotationDegrees() {
                    return la4.e(this);
                }

                @Override // androidx.media3.common.OverlaySettings
                public /* synthetic */ Pair getScale() {
                    return la4.f(this);
                }
            };
        }
    };

    Size getOutputSize(List<Size> list);

    OverlaySettings getOverlaySettings(int i, long j);
}
