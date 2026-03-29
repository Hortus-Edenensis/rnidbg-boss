package com.ss.bytertc.engine.mediaio;

import android.opengl.EGLContext;
import com.ss.bytertc.engine.video.VideoFrame;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IVideoSink {

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferType {
        public static final int PLANAR = 2;
        public static final int RAWDATA = 0;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PixelFormat {
        public static final int I420 = 1;
    }

    void consumeVideoFrame(VideoFrame videoFrame);

    int getBufferType();

    EGLContext getEGLContextHandle();

    int getPixelFormat();

    int getRenderElapse();

    void onDispose();

    boolean onInitialize();

    boolean onStart();

    void onStop();
}
