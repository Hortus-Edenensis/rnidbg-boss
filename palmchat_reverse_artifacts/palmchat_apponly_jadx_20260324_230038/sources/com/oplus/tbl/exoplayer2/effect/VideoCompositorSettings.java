package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.effect.OverlaySettings;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface VideoCompositorSettings {
    public static final VideoCompositorSettings DEFAULT = new VideoCompositorSettings() { // from class: com.oplus.tbl.exoplayer2.effect.VideoCompositorSettings.1
        @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositorSettings
        public Size getOutputSize(List<Size> list) {
            return list.get(0);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositorSettings
        public OverlaySettings getOverlaySettings(int i, long j) {
            return new OverlaySettings.Builder().build();
        }
    };

    Size getOutputSize(List<Size> list);

    OverlaySettings getOverlaySettings(int i, long j);
}
