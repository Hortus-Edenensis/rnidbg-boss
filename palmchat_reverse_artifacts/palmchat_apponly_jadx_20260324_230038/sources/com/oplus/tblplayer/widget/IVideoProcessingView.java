package com.oplus.tblplayer.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Player;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IVideoProcessingView {
    public static final float DEFAULT_MEASURE_LAYOUT_FACTOR = 1.0f;
    public static final float MAX_ASPECT_RATIO_DEFORMATION_FRACTION = 0.01f;
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface VideoProcessingEventListener {
        void onDrawnFirstFrame();
    }

    void setResizeMode(int i);

    void setVideoComponent(@Nullable Player.VideoComponent videoComponent);

    void setVideoProcessingEventListener(VideoProcessingEventListener videoProcessingEventListener);

    void setVideoProcessor(@NonNull IVideoProcessor iVideoProcessor);
}
