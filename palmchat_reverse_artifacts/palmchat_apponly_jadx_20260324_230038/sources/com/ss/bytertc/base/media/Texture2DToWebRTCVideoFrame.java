package com.ss.bytertc.base.media;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Texture2DToWebRTCVideoFrame {
    Handler mHandler;
    Matrix mMat;
    boolean needPendingRelease;
    YuvConverter yuvConverter = new YuvConverter();
    boolean isReleased = false;
    boolean isFrameInUse = false;

    @CalledByNative
    public Texture2DToWebRTCVideoFrame() {
        this.mHandler = null;
        this.needPendingRelease = false;
        HandlerThread handlerThread = new HandlerThread("Texture2DToVideoFrame");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.needPendingRelease = false;
        Matrix matrix = new Matrix();
        this.mMat = matrix;
        matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1() {
        this.yuvConverter.release();
        this.mHandler.getLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseFrame$0() {
        this.yuvConverter.release();
        this.mHandler.getLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseFrame() {
        this.isFrameInUse = false;
        if (!this.needPendingRelease || this.isReleased) {
            return;
        }
        this.isReleased = true;
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: lv5
            @Override // java.lang.Runnable
            public final void run() {
                this.f19086a.lambda$releaseFrame$0();
            }
        });
    }

    @CalledByNative
    public VideoFrame convertTexture2DToWebRTCVideoFrame(int i, int i2, int i3) {
        if (this.needPendingRelease || this.isReleased) {
            return null;
        }
        this.isFrameInUse = true;
        return new VideoFrame(new TextureBufferImpl(i2, i3, VideoFrame.TextureBuffer.Type.RGB, i, this.mMat, this.mHandler, this.yuvConverter, new Runnable() { // from class: mv5
            @Override // java.lang.Runnable
            public final void run() {
                this.f19375a.releaseFrame();
            }
        }), 0, 0L);
    }

    @CalledByNative
    public boolean isFameInUse() {
        return this.isFrameInUse;
    }

    @CalledByNative
    public void release() {
        if (this.isFrameInUse) {
            this.needPendingRelease = true;
        } else {
            this.isReleased = true;
            ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: kv5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18838a.lambda$release$1();
                }
            });
        }
    }
}
