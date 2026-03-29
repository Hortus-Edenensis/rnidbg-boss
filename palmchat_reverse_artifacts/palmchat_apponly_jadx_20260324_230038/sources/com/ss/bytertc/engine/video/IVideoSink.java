package com.ss.bytertc.engine.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IVideoSink {

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PixelFormat {
        public static final int I420 = 1;
        public static final int Original = 0;
        public static final int RGBA = 5;
    }

    int getRenderElapse();

    void onFrame(VideoFrame videoFrame);
}
