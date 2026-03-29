package com.zenmen.palmchat.video.recorder;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.MediaController;
import com.uc.crashsdk.export.LogType;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g13;
import defpackage.xb3;
import defpackage.ze6;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL11;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PrimeVideoView extends TextureView implements MediaController.MediaPlayerControl, TextureView.SurfaceTextureListener {
    private static final int MILLIS_IN_SEC = 1000;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final String TAG = "MagicVideoView";
    private AlertDialog errorDialog;
    private AssetFileDescriptor mAssetFileDescriptor;
    private int mAudioSession;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private MediaPlayer.OnErrorListener mErrorListener;
    private AtomicBoolean mGLThreadIsReady;
    private Map<String, String> mHeaders;
    private MediaPlayer.OnInfoListener mInfoListener;
    private boolean mIsError;
    private MediaPlayer mMediaPlayer;
    private boolean mMuted;
    private m mOnCompletionListener;
    private n mOnErrorListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    private MediaController mPlayerController;
    private MediaPlayer.OnPreparedListener mPreparedListener;
    private int mRoundCorner;
    private ScaleType mScaleType;
    private int mSeekWhenPrepared;
    private int mSideTriangle;
    private MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private o mSurfaceTextureListener;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private SurfaceTexture mVideoSurface;
    private int mVideoWidth;
    private ViewScaleType mViewScaleType;
    private final MediaPlayer.OnInfoListener onInfoToPlayStateListener;
    private xb3 onPlayStateListener;
    float xff;

    /* JADX INFO: compiled from: SearchBox */
    public enum ScaleType {
        SCALE_TO_FIT,
        CROP
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ViewScaleType {
        CENTER_CROP,
        TOP,
        BOTTOM
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements MediaPlayer.OnBufferingUpdateListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            PrimeVideoView.this.mCurrentBufferPercentage = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15784a;

        static {
            int[] iArr = new int[ScaleType.values().length];
            f15784a = iArr;
            try {
                iArr[ScaleType.SCALE_TO_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15784a[ScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("detail", "error prepare at state is " + PrimeVideoView.this.mCurrentState);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements MediaPlayer.OnInfoListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (PrimeVideoView.this.noPlayStateListener()) {
                return false;
            }
            if (3 == i) {
                PrimeVideoView.m(PrimeVideoView.this);
            }
            if (701 == i) {
                PrimeVideoView.m(PrimeVideoView.this);
            }
            if (702 == i) {
                PrimeVideoView.m(PrimeVideoView.this);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements MediaPlayer.OnSeekCompleteListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Log.i(PrimeVideoView.TAG, "seek completed");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("detail", "get different SurfaceTexture to display");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements MediaPlayer.OnVideoSizeChangedListener {
        public h() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            Log.d(PrimeVideoView.TAG, "onVideoSizeChanged " + i + "X " + i2);
            PrimeVideoView.this.mVideoHeight = i2;
            PrimeVideoView.this.mVideoWidth = i;
            PrimeVideoView.this.updateTextureViewSize();
            PrimeVideoView.this.requestLayout();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements MediaPlayer.OnPreparedListener {
        public i() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            PrimeVideoView.this.mCurrentState = 2;
            PrimeVideoView.this.mCanPause = true;
            PrimeVideoView.this.mCanSeekBack = true;
            PrimeVideoView.this.mCanSeekForward = true;
            if (PrimeVideoView.this.mOnPreparedListener != null) {
                PrimeVideoView.this.mOnPreparedListener.onPrepared(PrimeVideoView.this.mMediaPlayer);
            }
            int i = PrimeVideoView.this.mSeekWhenPrepared;
            if (i != 0) {
                PrimeVideoView.this.seekTo(i);
            }
            PrimeVideoView.this.mSeekWhenPrepared = 0;
            if (PrimeVideoView.this.mTargetState == 3) {
                PrimeVideoView.this.start();
                PrimeVideoView.this.showMediaController();
            } else if (PrimeVideoView.this.pausedAt(i)) {
                PrimeVideoView.this.showStickyMediaController();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements MediaPlayer.OnCompletionListener {
        public j() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            PrimeVideoView.this.setKeepScreenOn(false);
            PrimeVideoView.this.mCurrentState = 5;
            PrimeVideoView.this.mTargetState = 5;
            PrimeVideoView.this.hideMediaController();
            PrimeVideoView.d(PrimeVideoView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements MediaPlayer.OnInfoListener {
        public k() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 801) {
                PrimeVideoView.this.mCanPause = false;
                PrimeVideoView.this.mCanSeekForward = false;
                PrimeVideoView.this.mCanSeekBack = false;
            }
            if (PrimeVideoView.this.noPlayStateListener()) {
                return false;
            }
            if (3 == i) {
                PrimeVideoView.m(PrimeVideoView.this);
            }
            if (701 == i) {
                PrimeVideoView.m(PrimeVideoView.this);
            }
            if (702 == i) {
                PrimeVideoView.m(PrimeVideoView.this);
            }
            if (PrimeVideoView.this.mOnInfoListener == null) {
                return true;
            }
            PrimeVideoView.this.mOnInfoListener.onInfo(mediaPlayer, i, i2);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements MediaPlayer.OnErrorListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f15794a;
            public final /* synthetic */ int b;

            public a(int i, int i2) {
                this.f15794a = i;
                this.b = i2;
                put("detail", "Error: " + i + "," + i2 + "STATE_ERROR = " + PrimeVideoView.this.mCurrentState);
            }
        }

        public l() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtil.i(PrimeVideoView.TAG, 3, new a(i, i2), (Throwable) null);
            if (PrimeVideoView.this.mCurrentState == -1) {
                return true;
            }
            PrimeVideoView.this.mCurrentState = -1;
            PrimeVideoView.this.mTargetState = -1;
            PrimeVideoView.this.mIsError = true;
            PrimeVideoView.this.hideMediaController();
            PrimeVideoView.e(PrimeVideoView.this);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface m {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface n {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends g13 implements SurfaceTexture.OnFrameAvailableListener {
        public float[] d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public SurfaceTexture k;
        public SurfaceTexture l;
        public EGLDisplay o;
        public EGLSurface p;
        public EGLContext q;
        public EGL10 r;
        public GL11 s;
        public Handler t;
        public int u;
        public int v;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15795a = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix *aTextureCoord).xy;\n}\n";
        public final String b = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D texture; \nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        public float[] c = new float[16];
        public ze6 m = null;
        public boolean n = false;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f15796a;

            public a(int i) {
                this.f15796a = i;
                put("detail", "Could not compile shader " + i);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("detail", "Could not link program");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15798a;
            public final /* synthetic */ int b;

            public c(String str, int i) {
                this.f15798a = str;
                this.b = i;
                put("detail", str + ": glError " + i);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements Handler.Callback {
            public d() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    o.this.j();
                    return false;
                }
                if (i != 1) {
                    return false;
                }
                o.this.k();
                return false;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f15800a;

            public e(int i) {
                this.f15800a = i;
                put("detail", "EGL error = 0x" + Integer.toHexString(i));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class f extends HashMap<String, Object> {
            public f() {
                put("detail", "eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW");
            }
        }

        public o() {
            float[] fArr = new float[16];
            this.d = fArr;
            Matrix.setIdentityM(fArr, 0);
        }

        public final void c() {
            if (this.q.equals(this.r.eglGetCurrentContext()) && this.p.equals(this.r.eglGetCurrentSurface(12377))) {
                return;
            }
            d();
            EGL10 egl10 = this.r;
            EGLDisplay eGLDisplay = this.o;
            EGLSurface eGLSurface = this.p;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.q)) {
                d();
                return;
            }
            throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.r.eglGetError()));
        }

        public final void d() {
            int iEglGetError = this.r.eglGetError();
            if (iEglGetError != 12288) {
                LogUtil.i("SurfaceTextureListener", 3, new e(iEglGetError), (Throwable) null);
            }
        }

        public final void e(String str) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            LogUtil.i("SurfaceTextureListener", 3, new c(str, iGlGetError), (Throwable) null);
            throw new RuntimeException(str + ": glError " + iGlGetError);
        }

        public final int f(String str, String str2) {
            int iM;
            int iM2 = m(35633, str);
            if (iM2 == 0 || (iM = m(35632, str2)) == 0) {
                return 0;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            if (iGlCreateProgram != 0) {
                GLES20.glAttachShader(iGlCreateProgram, iM2);
                e("glAttachShader");
                GLES20.glAttachShader(iGlCreateProgram, iM);
                e("glAttachShader");
                GLES20.glLinkProgram(iGlCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    LogUtil.i("SurfaceTextureListener", 3, new b(), (Throwable) null);
                    GLES20.glDeleteProgram(iGlCreateProgram);
                    return 0;
                }
            }
            return iGlCreateProgram;
        }

        public int g() {
            return this.f;
        }

        public void h() {
            ze6 ze6Var = new ze6(-1.0f, 1.0f, 2.0f, 2.0f, 0.05f, 0.2f, 0.12f, 0.8f);
            this.m = ze6Var;
            ze6Var.e(this.u / this.v);
            this.m.c(PrimeVideoView.this.mRoundCorner);
            this.m.d(PrimeVideoView.this.mSideTriangle);
            this.m.a();
            int iF = f("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix *aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D texture; \nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
            this.e = iF;
            if (iF == 0) {
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            this.i = GLES20.glGetAttribLocation(iF, "aPosition");
            e("glGetAttribLocation aPosition");
            if (this.i == -1) {
                throw new RuntimeException("Could not get attrib location for aPosition");
            }
            this.j = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
            e("glGetAttribLocation aTextureCoord");
            if (this.j == -1) {
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            this.g = GLES20.glGetUniformLocation(this.e, "uMVPMatrix");
            e("glGetUniformLocation uMVPMatrix");
            if (this.g == -1) {
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            this.h = GLES20.glGetUniformLocation(this.e, "uSTMatrix");
            e("glGetUniformLocation uSTMatrix");
            if (this.h == -1) {
                throw new RuntimeException("Could not get attrib location for uSTMatrix");
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i = iArr[0];
            this.f = i;
            GLES20.glBindTexture(36197, i);
            e("glBindTexture mTextureID");
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
        }

        public final void i() {
            Log.d("SurfaceTextureListener", "##############gl Release##################");
            e("releaseGl start");
            this.r.eglDestroySurface(this.o, this.p);
            this.r.eglDestroyContext(this.o, this.q);
            EGL10 egl10 = this.r;
            EGLDisplay eGLDisplay = this.o;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.o = null;
            this.q = null;
            e("gl Release done");
        }

        public final void j() {
            c();
            q(this.u, this.v);
            this.r.eglSwapBuffers(this.o, this.p);
        }

        public final void k() {
            i();
            Looper.myLooper().quit();
        }

        public final void l() {
            Log.d("SurfaceTextureListener", "####################initGL######################");
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.r = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.o = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.r.eglGetError()));
            }
            if (!this.r.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.r.eglGetError()));
            }
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.r.eglChooseConfig(this.o, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.r.eglGetError()));
            }
            EGLConfig eGLConfig = iArr[0] > 0 ? eGLConfigArr[0] : null;
            if (eGLConfig == null) {
                throw new RuntimeException("eglConfig not initialized");
            }
            this.q = this.r.eglCreateContext(this.o, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            d();
            this.p = this.r.eglCreateWindowSurface(this.o, eGLConfig, this.l, null);
            d();
            EGLSurface eGLSurface = this.p;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                int iEglGetError = this.r.eglGetError();
                if (iEglGetError == 12299) {
                    LogUtil.i("SurfaceTextureListener", 3, new f(), (Throwable) null);
                    return;
                }
                throw new RuntimeException("eglCreateWindowSurface failed " + GLUtils.getEGLErrorString(iEglGetError));
            }
            if (this.r.eglMakeCurrent(this.o, eGLSurface, eGLSurface, this.q)) {
                d();
                this.s = (GL11) this.q.getGL();
                d();
            } else {
                throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.r.eglGetError()));
            }
        }

        public final int m(int i, String str) {
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
            LogUtil.i("SurfaceTextureListener", 3, new a(i), (Throwable) null);
            GLES20.glDeleteShader(iGlCreateShader);
            return 0;
        }

        public final void n() {
            Handler handler = this.t;
            if (handler != null) {
                handler.sendEmptyMessage(0);
            }
        }

        public void o() {
            Handler handler = this.t;
            if (handler != null) {
                handler.removeMessages(0);
                this.t.sendEmptyMessage(1);
            }
            this.t = null;
            try {
                PrimeVideoView.this.mSurfaceTextureListener.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.k = surfaceTexture;
            n();
        }

        public void p(SurfaceTexture surfaceTexture) {
            this.l = surfaceTexture;
        }

        public void q(int i, int i2) {
            this.k.updateTexImage();
            this.k.getTransformMatrix(this.d);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(this.n ? 49408 : LogType.UNEXP_RESTART);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUseProgram(this.e);
            e("glUseProgram");
            Matrix.setIdentityM(this.c, 0);
            float f2 = PrimeVideoView.this.xff;
            if (f2 < 1.0d) {
                Matrix.scaleM(this.c, 0, f2, 1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.c, 0, 1.0f, 1.0f / f2, 1.0f);
            }
            GLES20.glUniformMatrix4fv(this.g, 1, false, this.c, 0);
            GLES20.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
            this.m.b(this.i, this.j);
            e("glDrawElements");
            GLES20.glFinish();
        }

        public void r(int i, int i2) {
            this.u = i;
            this.v = i2;
            ze6 ze6Var = this.m;
            if (ze6Var != null) {
                ze6Var.a();
            }
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            l();
            h();
            Looper.prepare();
            Looper.myLooper();
            this.t = new Handler(new d());
            PrimeVideoView.this.mGLThreadIsReady.set(true);
            synchronized (PrimeVideoView.this.mGLThreadIsReady) {
                PrimeVideoView.this.mGLThreadIsReady.notify();
            }
            Looper.loop();
        }
    }

    public PrimeVideoView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mViewScaleType = ViewScaleType.CENTER_CROP;
        this.mMediaPlayer = null;
        this.mIsError = false;
        this.mMuted = false;
        this.mSideTriangle = 2;
        this.mRoundCorner = 3;
        this.mGLThreadIsReady = new AtomicBoolean(false);
        this.onInfoToPlayStateListener = new e();
        this.xff = 1.0f;
        this.mSizeChangedListener = new h();
        this.mPreparedListener = new i();
        this.mCompletionListener = new j();
        this.mInfoListener = new k();
        this.mErrorListener = new l();
        this.mBufferingUpdateListener = new b();
        init();
    }

    private void attachMediaController() {
        MediaController mediaController;
        if (this.mMediaPlayer == null || (mediaController = this.mPlayerController) == null) {
            return;
        }
        mediaController.setMediaPlayer(this);
    }

    private static AlertDialog createErrorDialog(Context context, m mVar, PrimeVideoView primeVideoView, int i2) {
        return new AlertDialog.Builder(context).setMessage(R.string.httpErrorUnsupportedScheme).setPositiveButton(R.string.ok, new a(mVar, primeVideoView)).setCancelable(false).create();
    }

    public static /* bridge */ /* synthetic */ m d(PrimeVideoView primeVideoView) {
        primeVideoView.getClass();
        return null;
    }

    private void disableFileDescriptor() {
        this.mAssetFileDescriptor = null;
    }

    public static /* bridge */ /* synthetic */ n e(PrimeVideoView primeVideoView) {
        primeVideoView.getClass();
        return null;
    }

    private static int getErrorMessage(int i2) {
        if (i2 == -1004) {
            Log.d(TAG, "TextureVideoView error. File or network related operation errors.");
            return 0;
        }
        if (i2 == -1007) {
            Log.d(TAG, "TextureVideoView error. Bitstream is not conforming to the related coding standard or file spec.");
            return 0;
        }
        if (i2 == 100) {
            Log.d(TAG, "TextureVideoView error. Media server died. In this case, the application must release the MediaPlayer object and instantiate a new one.");
            return 0;
        }
        if (i2 == -110) {
            Log.d(TAG, "TextureVideoView error. Some operation takes too long to complete, usually more than 3-5 seconds.");
            return 0;
        }
        if (i2 == 1) {
            Log.d(TAG, "TextureVideoView error. Unspecified media player error.");
            return 0;
        }
        if (i2 == -1010) {
            Log.d(TAG, "TextureVideoView error. Bitstream is conforming to the related coding standard or file spec, but the media framework does not support the feature.");
            return 0;
        }
        if (i2 != 200) {
            return 0;
        }
        Log.d(TAG, "TextureVideoView error. The video is streamed and its container is not valid for progressive playback i.e the video's index (e.g moov atom) is not at the start of the file.");
        return 0;
    }

    private void handleError(int i2) {
        if (getWindowToken() != null) {
            AlertDialog alertDialog = this.errorDialog;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.errorDialog.dismiss();
            }
            AlertDialog alertDialogCreateErrorDialog = createErrorDialog(getContext(), null, this, getErrorMessage(i2));
            this.errorDialog = alertDialogCreateErrorDialog;
            alertDialogCreateErrorDialog.show();
        }
    }

    private boolean hasPlayStateListener() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideMediaController() {
        MediaController mediaController = this.mPlayerController;
        if (mediaController != null) {
            mediaController.hide();
        }
    }

    private void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mGLThreadIsReady.set(false);
        setOnInfoListener(this.onInfoToPlayStateListener);
        setSurfaceTextureListener(this);
        setOpaque(false);
    }

    private boolean isInPlaybackState() {
        int i2;
        return (this.mMediaPlayer == null || (i2 = this.mCurrentState) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public static /* bridge */ /* synthetic */ xb3 m(PrimeVideoView primeVideoView) {
        primeVideoView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean noPlayStateListener() {
        return !hasPlayStateListener();
    }

    private void notifyUnableToOpenContent(Exception exc) {
        Log.w("Unable to open content:" + this.mUri, exc);
        this.mCurrentState = -1;
        this.mTargetState = -1;
        this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
    }

    private void openVideo() {
        tellTheMusicPlaybackServiceToPause();
        release(false);
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mMediaPlayer = mediaPlayer;
            int i2 = this.mAudioSession;
            if (i2 != 0) {
                mediaPlayer.setAudioSessionId(i2);
            } else {
                this.mAudioSession = mediaPlayer.getAudioSessionId();
            }
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
            this.mCurrentBufferPercentage = 0;
            setDataSource();
            mediaPlayerPrepare();
        } catch (IOException | IllegalArgumentException e2) {
            notifyUnableToOpenContent(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pausedAt(int i2) {
        return !isPlaying() && (i2 != 0 || getCurrentPosition() > 0);
    }

    private void setDataSource() throws IOException {
        AssetFileDescriptor assetFileDescriptor = this.mAssetFileDescriptor;
        if (assetFileDescriptor != null) {
            this.mMediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), this.mAssetFileDescriptor.getStartOffset(), this.mAssetFileDescriptor.getLength());
        } else {
            this.mMediaPlayer.setDataSource(getContext(), this.mUri, this.mHeaders);
        }
    }

    private void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    private void setPlayerScaleType(ScaleType scaleType) {
        int i2 = c.f15784a[scaleType.ordinal()];
        if (i2 == 1) {
            this.mMediaPlayer.setVideoScalingMode(1);
        } else {
            if (i2 != 2) {
                return;
            }
            this.mMediaPlayer.setVideoScalingMode(2);
        }
    }

    private void setVideoURI(Uri uri, Map<String, String> map, int i2) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = i2 * 1000;
        openVideo();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMediaController() {
        MediaController mediaController = this.mPlayerController;
        if (mediaController != null) {
            mediaController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStickyMediaController() {
        MediaController mediaController = this.mPlayerController;
        if (mediaController != null) {
            mediaController.show(0);
        }
    }

    private void tellTheMusicPlaybackServiceToPause() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra(com.heytap.mcssdk.constant.b.y, "pause");
        getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextureViewSize() {
        float width = getWidth();
        float height = getHeight();
        float f2 = this.mVideoWidth / this.mVideoHeight;
        float f3 = width / height;
        if (Math.abs(f2 - f3) > 0.01d) {
            this.xff = f2 / f3;
        }
        Log.d(TAG, "viewWidth = " + width + " x " + height + "  Video " + this.mVideoWidth + " x " + this.mVideoHeight);
        StringBuilder sb = new StringBuilder();
        sb.append("xff = ");
        sb.append(this.xff);
        sb.append("videoRatio  = ");
        sb.append(f2);
        sb.append("viewRatio = ");
        sb.append(f3);
        Log.d(TAG, sb.toString());
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.mCanPause;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (this.mAudioSession == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mAudioSession = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.mAudioSession;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return this.mCurrentBufferPercentage;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition() / 1000;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return -1;
    }

    public boolean isError() {
        return this.mIsError;
    }

    public boolean isLooping() {
        return this.mMediaPlayer.isLooping();
    }

    public boolean isMuted() {
        return this.mMuted;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public void mediaPlayerPrepare() {
        if (this.mCurrentState != 0 || this.mSurfaceTextureListener == null) {
            LogUtil.i(TAG, 3, new d(), (Throwable) null);
            return;
        }
        while (!this.mGLThreadIsReady.get()) {
            synchronized (this.mGLThreadIsReady) {
                try {
                    this.mGLThreadIsReady.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mSurfaceTextureListener.g());
        surfaceTexture.setOnFrameAvailableListener(this.mSurfaceTextureListener);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(new Surface(surfaceTexture));
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
            try {
                this.mCurrentState = 1;
                this.mMediaPlayer.prepare();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Log.d(TAG, "########onSurfaceTextureAvailable##########" + i2 + "X " + i3);
        this.mVideoSurface = surfaceTexture;
        o oVar = new o();
        this.mSurfaceTextureListener = oVar;
        oVar.p(surfaceTexture);
        this.mSurfaceTextureListener.r(i2, i3);
        this.mSurfaceTextureListener.start();
        mediaPlayerPrepare();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.d(TAG, "########onSurfaceTextureDestroyed##########");
        release(true);
        this.mSurfaceTextureListener.o();
        this.mSurfaceTextureListener = null;
        this.mVideoSurface = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Log.d(TAG, "########onSurfaceTextureSizeChanged##########" + i2 + "X " + i3);
        this.mSurfaceTextureListener.r(i2, i3);
        if (this.mVideoSurface.equals(surfaceTexture)) {
            return;
        }
        LogUtil.i(TAG, 3, new g(), (Throwable) null);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
            setKeepScreenOn(false);
        }
        this.mTargetState = 4;
    }

    public void release(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setKeepScreenOn(false);
            this.mCurrentState = 0;
            this.mTargetState = 0;
            if (z) {
                this.mTargetState = 0;
            }
        }
    }

    public void resume() {
        openVideo();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            int i3 = this.mCurrentState;
            if (i3 == 1 || i3 == 0) {
                this.mSeekWhenPrepared = i2;
            } else {
                mediaPlayer.seekTo(i2);
                this.mSeekWhenPrepared = 0;
            }
        }
    }

    public void seekToSeconds(int i2) {
        seekTo(i2 * 1000);
        this.mMediaPlayer.setOnSeekCompleteListener(new f());
    }

    public void setLooping(boolean z) {
        this.mMediaPlayer.setLooping(z);
    }

    public void setMediaController(MediaController mediaController) {
        hideMediaController();
        this.mPlayerController = mediaController;
        attachMediaController();
    }

    public void setMute(boolean z) {
        this.mMuted = z;
        this.mMediaPlayer.setVolume(z ? 0.0f : 1.0f, z ? 0.0f : 1.0f);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setRoundCorner(int i2) {
        this.mRoundCorner = i2;
    }

    public void setScaleType(ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTriangle(int i2) {
        this.mSideTriangle = i2;
    }

    public void setVideo(String str) {
        disableFileDescriptor();
        if (str != null) {
            Log.d(TAG, "set video path =" + str);
            setVideo(Uri.parse(str), 0);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.mIsError = false;
        if (isInPlaybackState()) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            boolean z = this.mMuted;
            mediaPlayer.setVolume(z ? 0.0f : 1.0f, z ? 0.0f : 1.0f);
            this.mMediaPlayer.start();
            setKeepScreenOn(true);
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            setKeepScreenOn(false);
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    public void suspend() {
        release(false);
    }

    public void setVideo(String str, int i2) {
        disableFileDescriptor();
        if (str != null) {
            setVideo(Uri.parse(str), i2);
        }
    }

    public void setVideo(Uri uri, int i2) {
        disableFileDescriptor();
        if (uri != null) {
            setVideoURI(uri, null, i2);
        }
    }

    public void setVideo(AssetFileDescriptor assetFileDescriptor) {
        this.mAssetFileDescriptor = assetFileDescriptor;
        setVideoURI(null, null, 0);
    }

    public void start(boolean z) {
        this.mMuted = z;
        start();
    }

    public void setVideo(AssetFileDescriptor assetFileDescriptor, int i2) {
        this.mAssetFileDescriptor = assetFileDescriptor;
        setVideoURI(null, null, i2);
    }

    public PrimeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mViewScaleType = ViewScaleType.CENTER_CROP;
        this.mMediaPlayer = null;
        this.mIsError = false;
        this.mMuted = false;
        this.mSideTriangle = 2;
        this.mRoundCorner = 3;
        this.mGLThreadIsReady = new AtomicBoolean(false);
        this.onInfoToPlayStateListener = new e();
        this.xff = 1.0f;
        this.mSizeChangedListener = new h();
        this.mPreparedListener = new i();
        this.mCompletionListener = new j();
        this.mInfoListener = new k();
        this.mErrorListener = new l();
        this.mBufferingUpdateListener = new b();
        init();
    }

    public PrimeVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mViewScaleType = ViewScaleType.CENTER_CROP;
        this.mMediaPlayer = null;
        this.mIsError = false;
        this.mMuted = false;
        this.mSideTriangle = 2;
        this.mRoundCorner = 3;
        this.mGLThreadIsReady = new AtomicBoolean(false);
        this.onInfoToPlayStateListener = new e();
        this.xff = 1.0f;
        this.mSizeChangedListener = new h();
        this.mPreparedListener = new i();
        this.mCompletionListener = new j();
        this.mInfoListener = new k();
        this.mErrorListener = new l();
        this.mBufferingUpdateListener = new b();
        init();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setOnCompletionListener(m mVar) {
    }

    public void setOnErrorListener(n nVar) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrimeVideoView f15782a;

        public a(m mVar, PrimeVideoView primeVideoView) {
            this.f15782a = primeVideoView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
