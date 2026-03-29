package com.oplus.tbl.exoplayer2;

import android.view.SurfaceView;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface DebugViewProvider {
    public static final DebugViewProvider NONE = new DebugViewProvider() { // from class: rv0
        @Override // com.oplus.tbl.exoplayer2.DebugViewProvider
        public final SurfaceView getDebugPreviewSurfaceView(int i, int i2) {
            return tv0.a(i, i2);
        }
    };

    @Nullable
    SurfaceView getDebugPreviewSurfaceView(int i, int i2);
}
