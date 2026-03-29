package com.zenmen.media.rtc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import com.uc.crashsdk.export.LogType;
import com.zenmen.media.rtc.CameraRecorder;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"ViewConstructor"})
public class CameraView extends GLSurfaceView {
    private static String TAG = "CameraView";
    VideoRender mRenderer;

    /* JADX INFO: compiled from: SearchBox */
    public static class VideoRender implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static int GL_TEXTURE_EXTERNAL_OES = 36197;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
        private int mProgram;
        private int mTextureID;
        private FloatBuffer mTriangleVertices;
        private final float[] mTriangleVerticesData;
        private int maPositionHandle;
        private int maTextureHandle;
        private int muMVPMatrixHandle;
        private int muSTMatrixHandle;
        private final String mVertexShader = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        private final String mFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        private float[] mMVPMatrix = new float[16];
        private float[] mSTMatrix = new float[16];
        private int viewWidth = 0;
        private int viewHeight = 0;
        private int mDisaplayOritation = 0;
        private int mVideoWidth = -1;
        private int mVideoHeight = -1;
        private SurfaceTexture mSurfaceTexture = null;
        private Surface mSurface = null;
        private boolean updateSurface = false;
        private boolean updateView = true;
        private CameraRecorder.CameraHandler mCameraHandler = null;

        public VideoRender(Context context) {
            float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
            this.mTriangleVerticesData = fArr;
            FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTriangleVertices = floatBufferAsFloatBuffer;
            floatBufferAsFloatBuffer.put(fArr).position(0);
            Matrix.setIdentityM(this.mSTMatrix, 0);
        }

        private void checkGlError(String str) {
            while (true) {
                int iGlGetError = GLES20.glGetError();
                if (iGlGetError == 0) {
                    return;
                }
                Log.e(CameraView.TAG, str + ": glError " + iGlGetError);
            }
        }

        private int createProgram(String str, String str2) {
            int iLoadShader;
            int iLoadShader2 = loadShader(35633, str);
            if (iLoadShader2 == 0 || (iLoadShader = loadShader(35632, str2)) == 0) {
                return 0;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            if (iGlCreateProgram != 0) {
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
                checkGlError("glAttachShader");
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                checkGlError("glAttachShader");
                GLES20.glLinkProgram(iGlCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    Log.e(CameraView.TAG, "Could not link program: ");
                    Log.e(CameraView.TAG, GLES20.glGetProgramInfoLog(iGlCreateProgram));
                    GLES20.glDeleteProgram(iGlCreateProgram);
                    return 0;
                }
            }
            return iGlCreateProgram;
        }

        private int loadShader(int i, String str) {
            int iGlCreateShader = GLES20.glCreateShader(i);
            if (iGlCreateShader == 0) {
                return iGlCreateShader;
            }
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return iGlCreateShader;
            }
            Log.e(CameraView.TAG, "Could not compile shader " + i + ":");
            Log.e(CameraView.TAG, GLES20.glGetShaderInfoLog(iGlCreateShader));
            GLES20.glDeleteShader(iGlCreateShader);
            return 0;
        }

        private void updateVerticesData() {
            int i;
            int i2 = this.mVideoWidth;
            if (i2 == -1 || (i = this.mVideoHeight) == -1) {
                return;
            }
            int i3 = this.mDisaplayOritation;
            if (i3 == 90 || i3 == 270) {
                i = i2;
                i2 = i;
            }
            Log.i(CameraView.TAG, "CameraView updateVerticesData :nWidth:" + i2 + " nHeight:" + i);
            int i4 = this.viewHeight;
            int i5 = i2 * i4;
            int i6 = this.viewWidth;
            if (i5 > i * i6) {
                float f = (((i2 - (((i * i6) / i4) & (-2))) / 2) & (-2)) / i2;
                float[] fArr = this.mTriangleVerticesData;
                fArr[3] = f;
                float f2 = 1.0f - f;
                fArr[8] = f2;
                fArr[13] = f;
                fArr[18] = f2;
                this.mTriangleVertices.position(0);
                this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
                return;
            }
            if (i2 * i4 < i * i6) {
                float f3 = (((i - (((i2 * i4) / i6) & (-2))) / 2) & (-2)) / i;
                float[] fArr2 = this.mTriangleVerticesData;
                fArr2[4] = f3;
                fArr2[9] = f3;
                float f4 = 1.0f - f3;
                fArr2[14] = f4;
                fArr2[19] = f4;
                this.mTriangleVertices.position(0);
                this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
            }
        }

        public void clearSurfaceTexture() {
            this.mSurfaceTexture = null;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                if (this.updateSurface) {
                    this.mSurfaceTexture.updateTexImage();
                    this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                    this.updateSurface = false;
                }
                if (this.updateView) {
                    updateVerticesData();
                    this.updateView = false;
                }
            }
            GLES20.glDisable(3089);
            GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
            GLES20.glClear(LogType.UNEXP_RESTART);
            GLES20.glUseProgram(this.mProgram);
            checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            this.mTriangleVertices.position(0);
            GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (Buffer) this.mTriangleVertices);
            checkGlError("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(this.maPositionHandle);
            checkGlError("glEnableVertexAttribArray maPositionHandle");
            this.mTriangleVertices.position(3);
            GLES20.glVertexAttribPointer(this.maTextureHandle, 3, 5126, false, 20, (Buffer) this.mTriangleVertices);
            checkGlError("glVertexAttribPointer maTextureHandle");
            GLES20.glEnableVertexAttribArray(this.maTextureHandle);
            checkGlError("glEnableVertexAttribArray maTextureHandle");
            Matrix.setIdentityM(this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
            GLES20.glViewport(0, 0, this.viewWidth, this.viewHeight);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFinish();
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.updateSurface = true;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.viewWidth = i;
            this.viewHeight = i2;
            synchronized (this) {
                this.updateView = true;
            }
            CameraRecorder.CameraHandler cameraHandler = this.mCameraHandler;
            if (cameraHandler != null) {
                cameraHandler.sendMessage(cameraHandler.obtainMessage(1, i, i2));
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int iCreateProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
            this.mProgram = iCreateProgram;
            if (iCreateProgram == 0) {
                return;
            }
            this.maPositionHandle = GLES20.glGetAttribLocation(iCreateProgram, "aPosition");
            checkGlError("glGetAttribLocation aPosition");
            if (this.maPositionHandle == -1) {
                throw new RuntimeException("Could not get attrib location for aPosition");
            }
            this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
            checkGlError("glGetAttribLocation aTextureCoord");
            if (this.maTextureHandle == -1) {
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
            checkGlError("glGetUniformLocation uMVPMatrix");
            if (this.muMVPMatrixHandle == -1) {
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            checkGlError("glGetUniformLocation uSTMatrix");
            if (this.muSTMatrixHandle == -1) {
                throw new RuntimeException("Could not get attrib location for uSTMatrix");
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i = iArr[0];
            this.mTextureID = i;
            GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, i);
            checkGlError("glBindTexture mTextureID");
            GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
            GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
            GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
            GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
            synchronized (this) {
                this.updateSurface = false;
            }
            CameraRecorder.CameraHandler cameraHandler = this.mCameraHandler;
            if (cameraHandler != null) {
                cameraHandler.sendMessage(cameraHandler.obtainMessage(0, this.mSurfaceTexture));
            }
        }

        public void setGLSurfaceViewEvenListener(CameraRecorder.CameraHandler cameraHandler) {
            this.mCameraHandler = cameraHandler;
        }

        public void setWidthHeight(int i, int i2, int i3) {
            this.mVideoWidth = i;
            this.mVideoHeight = i2;
            this.mDisaplayOritation = i3;
            synchronized (this) {
                this.updateView = true;
            }
        }
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        VideoRender videoRender = new VideoRender(context);
        this.mRenderer = videoRender;
        setRenderer(videoRender);
    }

    public Surface getSurface() {
        return this.mRenderer.getSurface();
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mRenderer.getSurfaceTexture();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "CameraView onAttachedToWindow");
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, "CameraView onDetachedFromWindow");
        this.mRenderer.clearSurfaceTexture();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Log.i(TAG, "CameraView onPause");
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Log.i(TAG, "CameraView onResume");
        super.onResume();
    }

    public void setGLSurfaceViewListener(CameraRecorder.CameraHandler cameraHandler) {
        this.mRenderer.setGLSurfaceViewEvenListener(cameraHandler);
    }

    public void setWidthHeight(int i, int i2, int i3) {
        this.mRenderer.setWidthHeight(i, i2, i3);
    }

    public CameraView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        VideoRender videoRender = new VideoRender(context);
        this.mRenderer = videoRender;
        setRenderer(videoRender);
    }
}
