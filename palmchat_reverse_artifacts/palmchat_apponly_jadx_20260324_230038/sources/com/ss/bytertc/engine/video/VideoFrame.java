package com.ss.bytertc.engine.video;

import android.opengl.EGLContext;
import androidx.annotation.NonNull;
import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.ColorSpace;
import com.ss.bytertc.engine.data.VideoContentType;
import com.ss.bytertc.engine.data.VideoFrameType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.mediaio.RefObject;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class VideoFrame {
    private Runnable userReleaseCallback = null;

    @NonNull
    private final RefObject refCount = new RefObject(new Runnable() { // from class: nb6
        @Override // java.lang.Runnable
        public final void run() {
            this.f19486a.lambda$new$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        Runnable runnable = this.userReleaseCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    @CalledByNative
    public abstract CameraId getCameraId();

    @CalledByNative
    public abstract ColorSpace getColorSpace();

    @CalledByNative
    public abstract VideoContentType getContentType();

    @CalledByNative
    public abstract EGLContext getEGLContext();

    @CalledByNative
    public abstract ByteBuffer getExternalDataInfo();

    public FovVideoFrameInfo getFovTileInfo() {
        return null;
    }

    @CalledByNative
    public abstract VideoFrameType getFrameType();

    @CalledByNative
    public abstract int getHeight();

    @CalledByNative
    public abstract int getNumberOfPlanes();

    @CalledByNative
    public abstract VideoPixelFormat getPixelFormat();

    @CalledByNative
    public abstract ByteBuffer getPlaneData(int i);

    @CalledByNative
    public abstract int getPlaneStride(int i);

    @CalledByNative
    public abstract VideoRotation getRotation();

    @CalledByNative
    public abstract ByteBuffer getSupplementaryInfo();

    @CalledByNative
    public abstract int getTextureID();

    @CalledByNative
    public abstract float[] getTextureMatrix();

    @CalledByNative
    public abstract long getTimeStampUs();

    @CalledByNative
    public abstract int getWidth();

    public synchronized boolean hasReleaseCallback() {
        return this.userReleaseCallback != null;
    }

    @CalledByNative
    public synchronized void release() {
        RefObject refObject = this.refCount;
        if (refObject != null) {
            refObject.release();
        }
    }

    @CalledByNative
    public synchronized void retain() {
        RefObject refObject = this.refCount;
        if (refObject != null) {
            refObject.retain();
        }
    }

    public synchronized void setReleaseCallback(Runnable runnable) {
        this.userReleaseCallback = runnable;
    }
}
