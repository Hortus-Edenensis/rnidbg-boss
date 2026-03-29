package com.ss.bytertc.base.media.screen;

import android.annotation.TargetApi;
import android.app.ForegroundServiceStartNotAllowedException;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.util.Log;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.VideoFrame;
import com.igexin.push.config.c;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.VideoSink;
import defpackage.ty;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class ScreenCapturerAndroid implements VideoCapturer, VideoSink {
    private CapturerObserver capturerObserver;
    private Context mContext;
    private CountDownLatch mCountDownLatch;
    private boolean needStartService;

    public ScreenCapturerAndroid(Intent intent, MediaProjection.Callback callback) {
        this(intent, callback, true);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void changeCaptureFormat(int i, int i2, int i3) {
        if (!this.needStartService || Build.VERSION.SDK_INT <= 28) {
            ScreenCaptureAndroidManager.INSTANCE().changeCaptureFormat(i, i2, i3);
        } else {
            Intent intent = new Intent();
            intent.putExtra(RXScreenCaptureService.KEY_WIDTH, i);
            intent.putExtra("h", i2);
            intent.putExtra(RXScreenCaptureService.KEY_IFRAMERATE, i3);
            try {
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 3, intent));
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                CapturerObserver capturerObserver = this.capturerObserver;
                if (capturerObserver != null) {
                    capturerObserver.onCapturerError("Start foreground service failed.");
                }
            }
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void dispose() {
        if (!this.needStartService || Build.VERSION.SDK_INT <= 28) {
            ScreenCaptureAndroidManager.INSTANCE().dispose();
        } else {
            Intent intent = new Intent();
            intent.putExtra(RXScreenCaptureService.KEY_HASHCODE, this.mCountDownLatch.hashCode());
            try {
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 5, intent));
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                CapturerObserver capturerObserver = this.capturerObserver;
                if (capturerObserver != null) {
                    capturerObserver.onCapturerError("Start foreground service failed.");
                }
            }
            try {
                this.mCountDownLatch.await(c.j, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("ScreenCaptureAndroid", "dispose finish");
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableFollowGravity(boolean z) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public float getCameraZoomMaxRatio() {
        return 1.0f;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int getDeviceOrientation() {
        return ty.b(ContextUtils.getApplicationContext());
    }

    public MediaProjection getMediaProjection() {
        return ScreenCaptureAndroidManager.INSTANCE().getMediaProjection();
    }

    public synchronized void initialize(EglBase.Context context, Context context2, CapturerObserver capturerObserver) {
        this.mContext = context2;
        this.capturerObserver = capturerObserver;
        ScreenCaptureAndroidManager.INSTANCE().initialize(context, context2, capturerObserver);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraTorchSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraZoomSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isScreencast() {
        return true;
    }

    @Override // com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (!this.needStartService || Build.VERSION.SDK_INT <= 28) {
            ScreenCaptureAndroidManager.INSTANCE().onFrame(videoFrame);
            return;
        }
        int iAddFrame = ScreenCaptureAndroidManager.INSTANCE().addFrame(videoFrame);
        Intent intent = new Intent();
        intent.putExtra("i", iAddFrame);
        if (RXScreenCaptureService.serviceStarted.get()) {
            Context context = this.mContext;
            context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 4, intent));
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraZoomRatio(float f) {
        return 0;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(int i, int i2, int i3, int i4) {
        if (!this.needStartService || Build.VERSION.SDK_INT <= 28) {
            ScreenCaptureAndroidManager.INSTANCE().startCapture(i, i2, i3, i4);
        } else {
            Intent intent = new Intent();
            intent.putExtra(RXScreenCaptureService.KEY_WIDTH, i);
            intent.putExtra("h", i2);
            intent.putExtra(RXScreenCaptureService.KEY_IFRAMERATE, i3);
            if (i4 <= 0) {
                i4 = 4;
            }
            intent.putExtra(RXScreenCaptureService.KEY_MIN_FRAMERATE, i4);
            try {
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 1, intent));
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                CapturerObserver capturerObserver = this.capturerObserver;
                if (capturerObserver != null) {
                    capturerObserver.onCapturerError("Start foreground service failed.");
                }
            }
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void stopCapture() {
        if (!this.needStartService || Build.VERSION.SDK_INT <= 28) {
            ScreenCaptureAndroidManager.INSTANCE().stopCapture();
        } else {
            try {
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 2, null));
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                CapturerObserver capturerObserver = this.capturerObserver;
                if (capturerObserver != null) {
                    capturerObserver.onCapturerError("Start foreground service failed.");
                }
            }
        }
    }

    public ScreenCapturerAndroid(Intent intent, MediaProjection.Callback callback, boolean z) {
        this.mCountDownLatch = new CountDownLatch(1);
        this.needStartService = true;
        this.capturerObserver = null;
        ScreenCaptureAndroidManager.INSTANCE().addLock(this.mCountDownLatch.hashCode(), this.mCountDownLatch);
        ScreenCaptureAndroidManager.INSTANCE().setData(intent, callback);
        this.needStartService = z;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.mContext = context;
        this.capturerObserver = capturerObserver;
        ScreenCaptureAndroidManager.INSTANCE().initialize(surfaceTextureHelper, context, capturerObserver);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(int i, int i2, int i3) {
        startCapture(i, i2, i3, 4);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOffFlashLight() {
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOnFlashLight() {
    }
}
