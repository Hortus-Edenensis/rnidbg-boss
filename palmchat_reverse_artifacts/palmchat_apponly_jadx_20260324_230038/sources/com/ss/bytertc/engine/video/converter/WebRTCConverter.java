package com.ss.bytertc.engine.video.converter;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.ss.bytertc.engine.data.VideoFrameType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.utils.ByteBufferUtils;
import com.ss.bytertc.engine.utils.LogUtil;
import defpackage.sb6;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WebRTCConverter {
    private static final String TAG = "WebRTCConverter";

    public static VideoFrame convertByteI420Frame2WebrtcI420Frame(com.ss.bytertc.engine.video.VideoFrame videoFrame) {
        if (videoFrame.getFrameType() != VideoFrameType.RAW_MEMORY || videoFrame.getPixelFormat() != VideoPixelFormat.I420) {
            return null;
        }
        videoFrame.retain();
        try {
            return new VideoFrame(JavaI420Buffer.wrap(videoFrame.getWidth(), videoFrame.getHeight(), videoFrame.getPlaneData(0), videoFrame.getPlaneStride(0), videoFrame.getPlaneData(1), videoFrame.getPlaneStride(1), videoFrame.getPlaneData(2), videoFrame.getPlaneStride(2), new sb6(videoFrame)), videoFrame.getRotation().value(), videoFrame.getTimeStampUs());
        } catch (IllegalArgumentException e) {
            videoFrame.release();
            LogUtil.e(TAG, "Frame convert failed: " + e.getMessage());
            return null;
        }
    }

    public static VideoFrame convertByteRGBAFrame2WebrtcI420Frame(com.ss.bytertc.engine.video.VideoFrame videoFrame) {
        if (videoFrame.getFrameType() != VideoFrameType.RAW_MEMORY || videoFrame.getPixelFormat() != VideoPixelFormat.RGBA) {
            return null;
        }
        int width = videoFrame.getWidth();
        int height = videoFrame.getHeight();
        int planeStride = videoFrame.getPlaneStride(0);
        int i = ((width + 63) / 64) * 64;
        int i2 = (((width >> 1) + 63) / 64) * 64;
        ByteBuffer planeData = videoFrame.getPlaneData(0);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i * height);
        int i3 = ((height + 1) >> 1) * i2;
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(i3);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(i3);
        ByteBufferUtils.nativeRGBAToI420(planeData, planeStride, byteBufferAllocateDirect, i, byteBufferAllocateDirect2, i2, byteBufferAllocateDirect3, i2, width, height);
        return new VideoFrame(JavaI420Buffer.wrap(width, height, byteBufferAllocateDirect, i, byteBufferAllocateDirect2, i2, byteBufferAllocateDirect3, i2, new sb6(videoFrame)), videoFrame.getRotation().value(), videoFrame.getTimeStampUs());
    }

    public static VideoFrame convertByteTexFrame2WebrtcTexFrame(com.ss.bytertc.engine.video.VideoFrame videoFrame, Looper looper) {
        if (videoFrame.getFrameType() != VideoFrameType.GL_TEXTURE || looper == null) {
            return null;
        }
        Matrix matrixConvertMatrixToAndroidGraphicsMatrix = RendererCommon.convertMatrixToAndroidGraphicsMatrix(videoFrame.getTextureMatrix());
        VideoFrame.TextureBuffer.Type type = videoFrame.getPixelFormat() == VideoPixelFormat.TEXTURE_2D ? VideoFrame.TextureBuffer.Type.RGB : VideoFrame.TextureBuffer.Type.OES;
        videoFrame.retain();
        return new VideoFrame(new TextureBufferImpl(videoFrame.getWidth(), videoFrame.getHeight(), type, videoFrame.getTextureID(), matrixConvertMatrixToAndroidGraphicsMatrix, new Handler(looper), new YuvConverter(), new sb6(videoFrame)), videoFrame.getRotation().value(), videoFrame.getTimeStampUs());
    }
}
