package com.zenmen.palmchat.video.recorder;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.l50;
import defpackage.lv4;
import defpackage.me1;
import defpackage.qm4;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CameraView extends FrameLayout implements SurfaceHolder.Callback {
    public static final int CAMERA_USAGE_RECORDING = 1;
    public static final int CAMERA_USAGE_SCANNER = 0;
    private static final int MSG_DUMP_RECORDER_FRAME = 6;
    private static final int MSG_DUMP_RECORDER_FRAME_WITH_PATH = 7;
    private static final int MSG_SEND_CAMERA_PARAMS0 = 0;
    private static final int MSG_SEND_CAMERA_PARAMS1 = 1;
    private static final int MSG_SEND_RECT_SIZE = 2;
    private static final int MSG_SEND_ROTATE_DEG = 4;
    private static final int MSG_SEND_SURFACE_FINISHED = 5;
    private static final int MSG_SEND_ZOOM_AREA = 3;
    public static final String TAG = "CameraView";
    private static SurfaceHolder sSurfaceHolder;
    private double lastDistance;
    private int mCameraUsage;
    private float mCameraViewTouchPosX;
    private float mCameraViewTouchPosY;
    private View mFocusView;
    private int mFocusViewHeight;
    private final String mFocusViewTag;
    private int mFocusViewWidth;
    private int mFormat;
    private com.zenmen.palmchat.video.recorder.a mFrameProvider;
    private boolean mFullscreen;
    private e mHandler;
    private int mHeight;
    private qm4 mPreviewCallback;
    private SurfaceView mPreviewSurface;
    private Rect mROI;
    private SurfaceView mRecordSurface;
    private final String mRecorderSurfaceTag;
    private com.zenmen.palmchat.video.recorder.b mRenderThread;
    private boolean mRenderThreadInitMsgSended;
    private int mWidth;
    private double zoomPercent;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            lv4 lv4VarG;
            if (motionEvent.getPointerCount() != 1) {
                if (motionEvent.getPointerCount() != 2) {
                    return false;
                }
                int action = motionEvent.getAction() & 255;
                if (action != 2) {
                    if (action == 5) {
                        CameraView.this.lastDistance = Math.sqrt(Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                        return false;
                    }
                    if (action != 6) {
                        return false;
                    }
                    LogUtil.uploadInfoImmediate("gesture_001", null, null, null);
                    return false;
                }
                double dSqrt = Math.sqrt(Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                LogUtil.d("logscan", "distance = " + dSqrt);
                if (CameraView.this.lastDistance >= 0.0d) {
                    double d = CameraView.this.zoomPercent;
                    CameraView.this.zoomPercent += ((dSqrt - CameraView.this.lastDistance) * 100.0d) / ((double) me1.g());
                    CameraView cameraView = CameraView.this;
                    cameraView.zoomPercent = Math.max(0.0d, Math.min(50.0d, cameraView.zoomPercent));
                    CameraView cameraView2 = CameraView.this;
                    cameraView2.setZoom(cameraView2.zoomPercent);
                    LogUtil.d("logscan", "zoom = " + d + " --> " + CameraView.this.zoomPercent);
                }
                CameraView.this.lastDistance = dSqrt;
                return false;
            }
            int action2 = motionEvent.getAction() & 255;
            if (action2 == 0) {
                CameraView.this.mCameraViewTouchPosX = motionEvent.getX();
                CameraView.this.mCameraViewTouchPosY = motionEvent.getY();
                return true;
            }
            if (action2 != 1 || CameraView.this.mFocusView == null || CameraView.this.mFocusView.getLayoutParams() == null) {
                return false;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(CameraView.this.mFocusView.getLayoutParams());
            layoutParams.setMargins(((int) CameraView.this.mCameraViewTouchPosX) - 60, ((int) CameraView.this.mCameraViewTouchPosY) - 60, 0, 0);
            if (l50.a()) {
                CameraView cameraView3 = CameraView.this;
                cameraView3.setZoom(cameraView3.zoomPercent != 0.0d ? 0.0d : 50.0d);
                LogUtil.uploadInfoImmediate("gesture_002", null, null, null);
                return false;
            }
            CameraView.this.mFocusView.setLayoutParams(layoutParams);
            Log.d(CameraView.TAG, "mCameraViewTouchPosX = " + CameraView.this.mCameraViewTouchPosX + "mCameraViewTouchPosY = " + CameraView.this.mCameraViewTouchPosY + " mFocusView.getWidth()" + CameraView.this.mFocusView.getWidth() + "mFocusView.getHeight() = " + CameraView.this.mFocusView.getHeight());
            Rect rect = new Rect((int) CameraView.this.mCameraViewTouchPosX, (int) CameraView.this.mCameraViewTouchPosY, CameraView.this.mFocusView.getWidth() + ((int) CameraView.this.mCameraViewTouchPosX), CameraView.this.mFocusView.getHeight() + ((int) CameraView.this.mCameraViewTouchPosY));
            if (CameraView.this.mRenderThread != null && (lv4VarG = CameraView.this.mRenderThread.g()) != null) {
                lv4VarG.a(rect);
            }
            if (CameraView.this.mCameraUsage == 0) {
                return false;
            }
            CameraView cameraView4 = CameraView.this;
            cameraView4.startFocusAnimation(cameraView4.mFocusView);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f15778a;

        public b(View view) {
            this.f15778a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15778a.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("detail", "No previous surface");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("detail", "mRender Thread is not null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<SurfaceView> f15781a;

        public e(SurfaceView surfaceView) {
            this.f15781a = new WeakReference<>(surfaceView);
        }

        public void a(int i, int i2) {
            sendMessage(obtainMessage(5, i, i2));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SurfaceView surfaceView = this.f15781a.get();
            if (surfaceView == null) {
                return;
            }
            switch (message.what) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                    return;
                case 5:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    ViewGroup.LayoutParams layoutParams = surfaceView.getLayoutParams();
                    layoutParams.height = i2;
                    layoutParams.width = i;
                    surfaceView.setLayoutParams(layoutParams);
                    return;
                default:
                    throw new RuntimeException("Unknown message " + message.what);
            }
        }
    }

    public CameraView(Context context) {
        super(context);
        this.lastDistance = -1.0d;
        this.zoomPercent = 0.0d;
        this.mRenderThreadInitMsgSended = true;
        this.mFullscreen = false;
        this.mCameraUsage = 1;
        this.mRecorderSurfaceTag = "recorderSurface";
        this.mFocusViewTag = "FocusViewTag";
        init(context, null);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraView);
            this.mFullscreen = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        View view = new View(context);
        this.mFocusView = view;
        view.setTag("FocusViewTag");
        this.mFocusViewWidth = dip2px(context, 60.0f);
        this.mFocusViewHeight = dip2px(context, 60.0f);
        this.mPreviewSurface = new SurfaceView(getContext());
        this.mHandler = new e(this.mPreviewSurface);
        this.mPreviewSurface.getHolder().addCallback(this);
        addView(this.mPreviewSurface, new FrameLayout.LayoutParams(-2, -2));
        setOnTouchListener(new a());
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.mRecordSurface = surfaceView;
        surfaceView.setTag("recorderSurface");
        this.mRecordSurface.getHolder().setFormat(-2);
        this.mRecordSurface.getHolder().addCallback(this);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFocusAnimation(View view) {
        view.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        view.startAnimation(scaleAnimation);
        view.postDelayed(new b(view), 800L);
    }

    public void autoFocus(Rect rect) {
        lv4 lv4VarG;
        com.zenmen.palmchat.video.recorder.b bVar = this.mRenderThread;
        if (bVar == null || (lv4VarG = bVar.g()) == null) {
            return;
        }
        lv4VarG.a(rect);
    }

    public void closeFlash() {
        try {
            if (this.mRenderThread.f() == null || !getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                return;
            }
            Camera.Parameters parameters = this.mRenderThread.f().getParameters();
            parameters.setFlashMode(WkInteractiveManager.TimingTypeOff);
            this.mRenderThread.f().setParameters(parameters);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getCameraUsage() {
        return this.mCameraUsage;
    }

    public boolean isRecording() {
        return false;
    }

    public void openFlash() {
        try {
            if (this.mRenderThread.f() == null || !getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                return;
            }
            Camera.Parameters parameters = this.mRenderThread.f().getParameters();
            parameters.setFlashMode("torch");
            this.mRenderThread.f().setParameters(parameters);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setCameraUsage(int i) {
        this.mCameraUsage = i;
    }

    public void setPreviewCallback(qm4 qm4Var) {
        this.mPreviewCallback = qm4Var;
    }

    public void setScannerROI(Rect rect) {
        this.mROI = rect;
        com.zenmen.palmchat.video.recorder.a aVar = this.mFrameProvider;
        if (aVar != null) {
            aVar.x(rect);
        }
    }

    public void setZoom(double d2) {
        this.zoomPercent = d2;
        com.zenmen.palmchat.video.recorder.b bVar = this.mRenderThread;
        if (bVar != null) {
            bVar.g().g((int) d2);
        }
    }

    public void startPreview() {
        startPreview(false);
    }

    public String startRecord(boolean z) {
        return null;
    }

    public void stopPreview() {
        com.zenmen.palmchat.video.recorder.b bVar = this.mRenderThread;
        if (bVar != null) {
            lv4 lv4VarG = bVar.g();
            if (lv4VarG != null) {
                lv4VarG.c();
            }
            try {
                this.mRenderThread.join();
            } catch (InterruptedException e2) {
                throw new RuntimeException("join was interrupted", e2);
            }
        }
        this.mRenderThread = null;
        com.zenmen.palmchat.video.recorder.a aVar = this.mFrameProvider;
        if (aVar != null) {
            aVar.D();
            this.mFrameProvider = null;
        }
        removeView(this.mRecordSurface);
        removeView(this.mFocusView);
        Log.d(TAG, "onPause END");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder == this.mPreviewSurface.getHolder()) {
            String str = TAG;
            Log.d(str, "surfaceChanged fmt = " + i + " size = " + i2 + "x" + i3 + " holder = " + surfaceHolder);
            com.zenmen.palmchat.video.recorder.b bVar = this.mRenderThread;
            if (bVar != null) {
                lv4 lv4VarG = bVar.g();
                if (lv4VarG != null) {
                    lv4VarG.e(i, i2, i3);
                    return;
                }
                return;
            }
            this.mFormat = i;
            this.mWidth = i2;
            this.mHeight = i3;
            Log.d(str, "Ignoring surfaceChanged");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        com.zenmen.palmchat.video.recorder.a aVar;
        SurfaceView surfaceView = this.mRecordSurface;
        if (surfaceView != null && surfaceView.getHolder().equals(surfaceHolder) && (aVar = this.mFrameProvider) != null) {
            aVar.B(surfaceHolder);
        }
        SurfaceView surfaceView2 = this.mPreviewSurface;
        if (surfaceView2 == null || !surfaceHolder.equals(surfaceView2.getHolder())) {
            return;
        }
        sSurfaceHolder = surfaceHolder;
        com.zenmen.palmchat.video.recorder.b bVar = this.mRenderThread;
        if (bVar != null) {
            this.mRenderThreadInitMsgSended = true;
            bVar.g().d(surfaceHolder, true);
        } else {
            this.mRenderThreadInitMsgSended = false;
            Log.w(TAG, "render thread not running");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        lv4 lv4VarG;
        if (surfaceHolder == this.mPreviewSurface.getHolder()) {
            com.zenmen.palmchat.video.recorder.b bVar = this.mRenderThread;
            if (bVar != null && (lv4VarG = bVar.g()) != null) {
                lv4VarG.f();
            }
            Log.d(TAG, "surfaceDestroyed holder=" + surfaceHolder);
            sSurfaceHolder = null;
        }
    }

    public void startPreview(boolean z) {
        if (findViewWithTag("recorderSurface") == null && this.mCameraUsage == 0) {
            addView(this.mRecordSurface, new FrameLayout.LayoutParams(-2, -2));
        }
        if (findViewWithTag("FocusViewTag") == null) {
            addView(this.mFocusView);
        }
        this.mFocusView.setBackgroundDrawable(getResources().getDrawable(R.drawable.focus_icon));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mFocusView.getLayoutParams();
        layoutParams.width = this.mFocusViewWidth;
        layoutParams.height = this.mFocusViewHeight;
        layoutParams.gravity = 17;
        this.mFocusView.setLayoutParams(layoutParams);
        this.mFocusView.setVisibility(4);
        if (this.mCameraUsage == 0 && this.mFrameProvider == null) {
            com.zenmen.palmchat.video.recorder.a aVar = new com.zenmen.palmchat.video.recorder.a();
            this.mFrameProvider = aVar;
            aVar.w(this.mPreviewCallback);
            this.mFrameProvider.z();
            Rect rect = this.mROI;
            if (rect != null) {
                this.mFrameProvider.x(rect);
            }
        }
        if (this.mRenderThread != null) {
            LogUtil.i(TAG, 3, new d(), (Throwable) null);
            return;
        }
        com.zenmen.palmchat.video.recorder.b bVar = new com.zenmen.palmchat.video.recorder.b(this.mHandler, this.mFrameProvider, this.mFullscreen, z);
        this.mRenderThread = bVar;
        bVar.setName("RenderThread");
        this.mRenderThread.start();
        this.mRenderThread.y();
        lv4 lv4VarG = this.mRenderThread.g();
        SurfaceHolder surfaceHolder = sSurfaceHolder;
        if (surfaceHolder == null) {
            LogUtil.i(TAG, 3, new c(), (Throwable) null);
        } else if (this.mRenderThreadInitMsgSended) {
            lv4VarG.d(surfaceHolder, false);
        } else {
            lv4VarG.d(surfaceHolder, true);
            lv4VarG.e(this.mFormat, this.mWidth, this.mHeight);
        }
    }

    public String startRecord() {
        return startRecord(true);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastDistance = -1.0d;
        this.zoomPercent = 0.0d;
        this.mRenderThreadInitMsgSended = true;
        this.mFullscreen = false;
        this.mCameraUsage = 1;
        this.mRecorderSurfaceTag = "recorderSurface";
        this.mFocusViewTag = "FocusViewTag";
        init(context, attributeSet);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastDistance = -1.0d;
        this.zoomPercent = 0.0d;
        this.mRenderThreadInitMsgSended = true;
        this.mFullscreen = false;
        this.mCameraUsage = 1;
        this.mRecorderSurfaceTag = "recorderSurface";
        this.mFocusViewTag = "FocusViewTag";
        init(context, attributeSet);
    }

    @TargetApi(21)
    public CameraView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lastDistance = -1.0d;
        this.zoomPercent = 0.0d;
        this.mRenderThreadInitMsgSended = true;
        this.mFullscreen = false;
        this.mCameraUsage = 1;
        this.mRecorderSurfaceTag = "recorderSurface";
        this.mFocusViewTag = "FocusViewTag";
        init(context, attributeSet);
    }

    public void setRecordParameters() {
    }

    public void stopRecord() {
    }

    public void saveAsImage(ByteBuffer byteBuffer, String str) {
    }
}
