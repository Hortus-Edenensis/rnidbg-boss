package com.ss.bytertc.base.media.screen;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.core.content.ContextCompat;
import defpackage.j35;
import defpackage.k35;
import defpackage.l35;
import defpackage.m35;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ScreenAudioCaptureAndroidManager extends MediaProjection.Callback {
    private static final int NUM_SAMPLES_PER_READ = 1024;
    private static final int SAMPLE_RATE = 48000;
    private int mAudioMode;
    private AudioRecord mAudioRecord;
    private ScreenAudioCaptureObserver mCaptureObserver;
    private WeakReference<Context> mContextRef;
    private boolean mIsDisposed;
    private volatile boolean mIsRecording;
    private MediaProjection mMediaProjection;
    private Thread mRecordingThread;
    private Handler sHandler;
    private HandlerThread sHandlerThread;

    /* JADX INFO: compiled from: SearchBox */
    public static final class HOLDER {
        private static final ScreenAudioCaptureAndroidManager INSTANCE = new ScreenAudioCaptureAndroidManager();

        private HOLDER() {
        }
    }

    public static ScreenAudioCaptureAndroidManager INSTANCE() {
        return HOLDER.INSTANCE;
    }

    private void checkNotDisposed() {
        if (this.mIsDisposed) {
            throw new RuntimeException("screen audio capturer is disposed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRun() {
        AudioRecord audioRecord;
        short[] sArr = new short[1024];
        while (this.mIsRecording && (audioRecord = this.mAudioRecord) != null) {
            if (audioRecord.read(sArr, 0, 1024) >= 0) {
                byte[] bArrShort2byte = short2byte(sArr);
                ScreenAudioCaptureObserver screenAudioCaptureObserver = this.mCaptureObserver;
                if (screenAudioCaptureObserver == null) {
                    return;
                } else {
                    screenAudioCaptureObserver.onAudioFrameCapture(bArrShort2byte, 1024, 48000, 1);
                }
            }
        }
    }

    private static boolean hasPermissions(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : strArr) {
            if (!selfPermissionGranted(context, str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean selfPermissionGranted(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context.getApplicationInfo().targetSdkVersion >= 23) {
            if (context.checkSelfPermission(str) == 0) {
                return true;
            }
        } else if (ContextCompat.checkSelfPermission(context, str) == 0) {
            return true;
        }
        return false;
    }

    private void setMusicMode(boolean z) {
        AudioManager audioManager = (AudioManager) this.mContextRef.get().getSystemService("audio");
        try {
            if (z) {
                this.mAudioMode = audioManager.getMode();
                audioManager.setMode(0);
            } else {
                audioManager.setMode(this.mAudioMode);
            }
        } catch (Exception e) {
            Log.e("ScreenAudioCapture", z + ", " + e.getMessage());
        }
    }

    private byte[] short2byte(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            short s = sArr[i];
            bArr[i2] = (byte) (s & 255);
            bArr[i2 + 1] = (byte) (s >> 8);
            sArr[i] = 0;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startAudioCapture_, reason: merged with bridge method [inline-methods] */
    public void lambda$startAudioCapture$0(MediaProjection mediaProjection) {
        if (Build.VERSION.SDK_INT > 28 && !this.mIsRecording) {
            this.mMediaProjection = mediaProjection;
            if (mediaProjection == null) {
                return;
            }
            l35.a();
            AudioPlaybackCaptureConfiguration audioPlaybackCaptureConfigurationBuild = j35.a(this.mMediaProjection).addMatchingUsage(1).addMatchingUsage(14).addMatchingUsage(0).build();
            AudioFormat audioFormatBuild = new AudioFormat.Builder().setEncoding(2).setSampleRate(48000).setChannelMask(16).build();
            try {
                m35.a();
                AudioRecord audioRecordBuild = k35.a().setAudioFormat(audioFormatBuild).setBufferSizeInBytes(2048).setAudioPlaybackCaptureConfig(audioPlaybackCaptureConfigurationBuild).build();
                this.mAudioRecord = audioRecordBuild;
                if (audioRecordBuild.getState() == 0) {
                    Log.e("ScreenAudioCapture", "audioRecord init fail, permission: " + hasPermissions(this.mContextRef.get(), "android.permission.RECORD_AUDIO"));
                    this.mAudioRecord = null;
                    return;
                }
                this.mMediaProjection.registerCallback(this, this.sHandler);
                this.mCaptureObserver.onCapturerStarted();
                setMusicMode(true);
                this.mIsRecording = true;
                this.mAudioRecord.startRecording();
                Thread thread = new Thread(new Runnable() { // from class: o35
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19688a.doRun();
                    }
                });
                this.mRecordingThread = thread;
                thread.start();
                setMusicMode(false);
            } catch (UnsupportedOperationException e) {
                Log.e("ScreenAudioCapture", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAudioCapture_() {
        if (Build.VERSION.SDK_INT > 28 && this.mIsRecording) {
            this.mIsRecording = false;
            AudioRecord audioRecord = this.mAudioRecord;
            if (audioRecord != null) {
                audioRecord.stop();
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
            this.mCaptureObserver.onCapturerStopped();
            this.mMediaProjection = null;
        }
    }

    public void dispose() {
        this.mIsDisposed = true;
    }

    public void initialize(Context context, ScreenAudioCaptureObserver screenAudioCaptureObserver) {
        if (screenAudioCaptureObserver == null) {
            throw new RuntimeException("audio capture observer not set.");
        }
        this.mCaptureObserver = screenAudioCaptureObserver;
        this.mContextRef = new WeakReference<>(context);
        this.mIsDisposed = false;
    }

    @Override // android.media.projection.MediaProjection.Callback
    public void onStop() {
        super.onStop();
        stopAudioCapture_();
    }

    public void startAudioCapture(final MediaProjection mediaProjection) {
        checkNotDisposed();
        this.sHandler.post(new Runnable() { // from class: n35
            @Override // java.lang.Runnable
            public final void run() {
                this.f19428a.lambda$startAudioCapture$0(mediaProjection);
            }
        });
    }

    public void stopAudioCapture() {
        checkNotDisposed();
        MediaProjection mediaProjection = this.mMediaProjection;
        if (mediaProjection != null) {
            mediaProjection.unregisterCallback(this);
        }
        this.sHandler.removeCallbacksAndMessages(null);
        this.sHandler.post(new Runnable() { // from class: p35
            @Override // java.lang.Runnable
            public final void run() {
                this.f19931a.stopAudioCapture_();
            }
        });
    }

    private ScreenAudioCaptureAndroidManager() {
        HandlerThread handlerThread = new HandlerThread("sdk-audio-share");
        this.sHandlerThread = handlerThread;
        handlerThread.start();
        this.sHandler = new Handler(this.sHandlerThread.getLooper());
        this.mIsRecording = false;
        this.mCaptureObserver = null;
        this.mAudioRecord = null;
        this.mRecordingThread = null;
        this.mIsDisposed = false;
    }
}
