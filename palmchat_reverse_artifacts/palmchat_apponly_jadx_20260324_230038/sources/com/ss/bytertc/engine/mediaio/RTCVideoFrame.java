package com.ss.bytertc.engine.mediaio;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCVideoFrame extends RefObject {

    @Deprecated
    public ByteBuffer buffer;

    @Deprecated
    public int buffer_type;

    @Deprecated
    public int color_space;

    @Deprecated
    public int cropBottom;

    @Deprecated
    public int cropLeft;

    @Deprecated
    public int cropRight;

    @Deprecated
    public int cropTop;

    @Deprecated
    public EGLContext eglContext11;

    @Deprecated
    public android.opengl.EGLContext eglContext14;

    @Deprecated
    public ByteBuffer extend_data;

    @Deprecated
    public int format;

    @Deprecated
    public int glTarget;

    @Deprecated
    public int height;
    private ByteBuffer[] planes_;

    @Deprecated
    public int rotation;

    @Deprecated
    public int stride;
    private int[] strides_;

    @Deprecated
    public ByteBuffer supplementary_info;

    @Deprecated
    public int textureId;

    @Deprecated
    public long timestamp;

    @Deprecated
    public float[] transform;
    private int width_;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    public @interface BufferType {
        public static final int PLANAR = 2;
        public static final int RAWDATA = 0;
        public static final int RTCBUFFER = 2;
        public static final int TEXTURE = 1;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PixelFormat {
        public static final int I420 = 1;
        public static final int NV21 = 3;
        public static final int TEXTURE_2D = 10;
        public static final int TEXTURE_OES = 11;
        public static final int UNKNOW = 0;
    }

    public RTCVideoFrame() {
        super(null);
        this.cropLeft = 0;
        this.cropTop = 0;
        this.cropRight = 0;
        this.cropBottom = 0;
        this.eglContext11 = null;
        this.eglContext14 = null;
        this.transform = null;
    }

    public static RTCVideoFrame createI420Frame(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, int i6, long j, @Nullable Runnable runnable) {
        return new RTCVideoFrame(new ByteBuffer[]{byteBuffer, byteBuffer2, byteBuffer3}, new int[]{i, i2, i3}, i4, i5, 1, i6, j, (ByteBuffer) null, (ByteBuffer) null, runnable);
    }

    public static RTCVideoFrame createTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr, @Nullable Runnable runnable) {
        if (i == 10 || i == 11) {
            return new RTCVideoFrame(i2, i, fArr, (ByteBuffer) null, (ByteBuffer) null, i3, i4, i5, j, runnable);
        }
        return null;
    }

    public static RTCVideoFrame shallowCopy(RTCVideoFrame rTCVideoFrame) {
        RTCVideoFrame rTCVideoFrame2 = new RTCVideoFrame();
        rTCVideoFrame2.buffer = rTCVideoFrame.buffer;
        rTCVideoFrame2.buffer_type = rTCVideoFrame.buffer_type;
        rTCVideoFrame2.cropBottom = rTCVideoFrame.cropBottom;
        rTCVideoFrame2.cropLeft = rTCVideoFrame.cropLeft;
        rTCVideoFrame2.cropRight = rTCVideoFrame.cropRight;
        rTCVideoFrame2.cropTop = rTCVideoFrame.cropTop;
        rTCVideoFrame2.eglContext11 = rTCVideoFrame.eglContext11;
        rTCVideoFrame2.eglContext14 = rTCVideoFrame.eglContext14;
        rTCVideoFrame2.extend_data = rTCVideoFrame.extend_data;
        rTCVideoFrame2.supplementary_info = rTCVideoFrame.supplementary_info;
        rTCVideoFrame2.format = rTCVideoFrame.format;
        rTCVideoFrame2.glTarget = rTCVideoFrame.glTarget;
        rTCVideoFrame2.stride = rTCVideoFrame.stride;
        rTCVideoFrame2.width_ = rTCVideoFrame.width_;
        rTCVideoFrame2.height = rTCVideoFrame.height;
        rTCVideoFrame2.rotation = rTCVideoFrame.rotation;
        rTCVideoFrame2.textureId = rTCVideoFrame.textureId;
        rTCVideoFrame2.timestamp = rTCVideoFrame.timestamp;
        rTCVideoFrame2.transform = rTCVideoFrame.transform;
        rTCVideoFrame2.planes_ = rTCVideoFrame.planes_;
        rTCVideoFrame2.strides_ = rTCVideoFrame.strides_;
        return rTCVideoFrame2;
    }

    public int getColorspace() {
        return this.color_space;
    }

    public int getCropBottom() {
        return this.cropBottom;
    }

    public int getCropLeft() {
        return this.cropLeft;
    }

    public int getCropRight() {
        return this.cropRight;
    }

    public int getCropTop() {
        return this.cropTop;
    }

    public android.opengl.EGLContext getEglContext() {
        return this.eglContext14;
    }

    public ByteBuffer getExtendData() {
        return this.extend_data;
    }

    public int getGlTextureId() {
        return this.textureId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPixelFormat() {
        return this.format;
    }

    public ByteBuffer getPlane(int i) {
        if (getPlaneCount() <= i) {
            return null;
        }
        return this.buffer_type == 0 ? this.buffer : this.planes_[i].slice();
    }

    public int getPlaneCount() {
        if (this.buffer_type == 0) {
            return 1;
        }
        return this.planes_.length;
    }

    public int getPlaneStride(int i) {
        if (getPlaneCount() <= i) {
            return 0;
        }
        return this.buffer_type == 0 ? this.stride : this.strides_[i];
    }

    public int getRotation() {
        return this.rotation;
    }

    public ByteBuffer getSupplementaryInfo() {
        return this.supplementary_info;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public float[] getTransform() {
        return this.transform;
    }

    public int getWidth() {
        return this.width_;
    }

    public void setColorspace(int i) {
        this.color_space = i;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    @Deprecated
    public RTCVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, long j, @Nullable Runnable runnable) {
        super(runnable);
        this.cropLeft = 0;
        this.cropTop = 0;
        this.cropRight = 0;
        this.cropBottom = 0;
        this.eglContext11 = null;
        this.eglContext14 = null;
        this.transform = null;
        this.stride = i;
        this.width_ = i;
        this.height = i2;
        this.buffer_type = 0;
        this.format = 1;
        this.rotation = i3;
        this.timestamp = j;
        this.extend_data = byteBuffer2;
        this.supplementary_info = byteBuffer3;
        this.buffer = byteBuffer;
    }

    @Deprecated
    public RTCVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, long j, @Nullable Runnable runnable) {
        super(runnable);
        this.cropLeft = 0;
        this.cropTop = 0;
        this.cropRight = 0;
        this.cropBottom = 0;
        this.eglContext11 = null;
        this.eglContext14 = null;
        this.transform = null;
        this.stride = i;
        this.height = i2;
        this.buffer_type = 0;
        this.format = 1;
        this.rotation = i3;
        this.color_space = i4;
        this.timestamp = j;
        this.extend_data = byteBuffer2;
        this.supplementary_info = byteBuffer3;
        this.buffer = byteBuffer;
    }

    @Deprecated
    public RTCVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, long j, int i5, @Nullable Runnable runnable) {
        super(runnable);
        this.cropLeft = 0;
        this.cropTop = 0;
        this.cropRight = 0;
        this.cropBottom = 0;
        this.eglContext11 = null;
        this.eglContext14 = null;
        this.transform = null;
        this.stride = i;
        this.width_ = i2;
        this.height = i3;
        this.buffer_type = 0;
        this.format = i5;
        this.rotation = i4;
        this.timestamp = j;
        this.extend_data = byteBuffer2;
        this.supplementary_info = byteBuffer3;
        this.buffer = byteBuffer;
    }

    public RTCVideoFrame(ByteBuffer[] byteBufferArr, int[] iArr, int i, int i2, int i3, int i4, long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, @Nullable Runnable runnable) {
        super(runnable);
        this.cropLeft = 0;
        this.cropTop = 0;
        this.cropRight = 0;
        this.cropBottom = 0;
        this.eglContext11 = null;
        this.eglContext14 = null;
        this.transform = null;
        this.buffer_type = 2;
        this.planes_ = byteBufferArr;
        this.strides_ = iArr;
        this.width_ = i;
        this.height = i2;
        this.format = i3;
        this.rotation = i4;
        this.timestamp = j;
        this.extend_data = byteBuffer;
        this.supplementary_info = byteBuffer2;
    }

    public RTCVideoFrame(int i, int i2, float[] fArr, @Nullable ByteBuffer byteBuffer, @Nullable ByteBuffer byteBuffer2, int i3, int i4, int i5, long j, @Nullable Runnable runnable) {
        super(runnable);
        this.cropLeft = 0;
        this.cropTop = 0;
        this.cropRight = 0;
        this.cropBottom = 0;
        this.eglContext11 = null;
        this.eglContext14 = null;
        this.stride = i3;
        this.width_ = i3;
        this.height = i4;
        this.buffer_type = 1;
        this.format = i2;
        this.rotation = i5;
        this.timestamp = j;
        this.extend_data = byteBuffer;
        this.supplementary_info = byteBuffer2;
        this.textureId = i;
        this.transform = fArr;
    }
}
