package com.ss.android.ttvecamera.mediarecorder;

import android.media.MediaCodec;
import android.media.MediaMetadataRetriever;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 23)
public class TEMediaRecorder {
    private static final SparseIntArray ORIENTATIONS;
    public static final int PAUSE = 2;
    public static final int RESUME = 3;
    private static final int ROTATION_DEGREE_0 = 0;
    private static final int ROTATION_DEGREE_180 = 180;
    private static final int ROTATION_DEGREE_270 = 270;
    private static final int ROTATION_DEGREE_30 = 30;
    private static final int ROTATION_DEGREE_360 = 360;
    private static final int ROTATION_DEGREE_90 = 90;
    public static final int START = 0;
    public static final int STOP = 1;
    private static final String TAG = "TEMediaRecorder";
    public static final int TER_INIT_IO_ERROR = -604;
    public static final int TER_RUNNING_TIME_ERROR = -606;
    public static final int TER_STATE_ERROR = -605;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private ErrorCallback mErrorCallback;
    private String mFolderPath;
    private TEFrameSizei mPreviewSize;
    private List<TEFrameSizei> mSupportSizes;
    private String mVideoFile;
    private boolean mEnableStatus = false;
    private int mState = -1;
    private Surface mVideoSurface = null;
    private Size mVideoSize = new Size(1280, 720);
    private int mFrameRate = 30;
    private int mBitRate = 10000000;
    private int mOrientaton = 0;
    private MediaRecorder mMediaRecorder = new MediaRecorder();

    /* JADX INFO: compiled from: SearchBox */
    public interface ErrorCallback {
        void onError(int i);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ORIENTATIONS = sparseIntArray;
        sparseIntArray.append(0, 90);
        sparseIntArray.append(1, 0);
        sparseIntArray.append(2, 270);
        sparseIntArray.append(3, 180);
    }

    public TEMediaRecorder() {
        startBackgroundThread();
    }

    private void adjustRecordSize() {
        TEFrameSizei tEFrameSizei;
        List<TEFrameSizei> list = this.mSupportSizes;
        if (list == null || (tEFrameSizei = this.mPreviewSize) == null) {
            return;
        }
        TECameraUtils.calcPreviewSize(list, tEFrameSizei);
    }

    private void clearInvalidFile() throws IOException {
        String str = this.mVideoFile;
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.mVideoFile);
        TELogUtils.d(TAG, "file length = " + file.length());
        if (file.exists() && file.length() == 0) {
            file.delete();
            this.mVideoFile = "";
            TELogUtils.d(TAG, "invalid video file deleted!");
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(this.mVideoFile);
                Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (IllegalArgumentException unused) {
                deleteFile();
                TELogUtils.e(TAG, "cannot access the file");
            }
            mediaMetadataRetriever.release();
        }
    }

    private void handleError(int i) {
        ErrorCallback errorCallback = this.mErrorCallback;
        if (errorCallback != null) {
            errorCallback.onError(i);
        }
    }

    private void startBackgroundThread() {
        HandlerThread handlerThread = new HandlerThread("MediaRecorderBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.mBackgroundThread.join();
                this.mBackgroundThread = null;
                this.mBackgroundHandler = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Surface createRecordSurface() {
        if (this.mVideoSurface == null) {
            this.mVideoSurface = MediaCodec.createPersistentInputSurface();
        }
        return this.mVideoSurface;
    }

    public void deleteFile() {
        String str = this.mVideoFile;
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.mVideoFile);
        TELogUtils.d(TAG, "file length = " + file.length());
        if (file.exists()) {
            file.delete();
            this.mVideoFile = "";
            TELogUtils.d(TAG, "invalid video file deleted!");
        }
    }

    public int getImageRotation(int i, int i2) {
        TELogUtils.d(TAG, "getImageRotation: mSensorOrientation = " + i);
        int i3 = 0;
        if (i2 <= 330 && i2 >= 30) {
            if (i2 > 60 && i2 < 120) {
                i3 = 90;
            } else if (i2 > 150 && i2 < 210) {
                i3 = 180;
            } else if (i2 > 240 && i2 < 300) {
                i3 = 270;
            }
        }
        int i4 = (i3 + i) % 360;
        TELogUtils.d(TAG, "getImageRotation: imageRotation = " + i4);
        return i4;
    }

    @RequiresApi(api = 24)
    public boolean pause() {
        try {
            try {
                this.mMediaRecorder.pause();
                Log.d(TAG, "mMediaRecorder pause");
                TELogUtils.d(TAG, "pauseRecord end");
                return true;
            } catch (IllegalStateException unused) {
                TELogUtils.e(TAG, "mMediaRecorder pause state error");
                handleError(TER_STATE_ERROR);
                TELogUtils.d(TAG, "pauseRecord end");
                return false;
            }
        } catch (Throwable th) {
            TELogUtils.d(TAG, "pauseRecord end");
            throw th;
        }
    }

    public void release() throws IOException {
        TELogUtils.d(TAG, "[schedule] releaseMediaRecorder");
        if (this.mMediaRecorder != null) {
            TELogUtils.v(TAG, "Releasing media recorder.");
            try {
                this.mMediaRecorder.reset();
            } catch (IllegalStateException e) {
                TELogUtils.e(TAG, "media recorder maybe has been released! msg=" + e.getMessage());
                handleError(TER_STATE_ERROR);
            }
            clearInvalidFile();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
            stopBackgroundThread();
        }
    }

    @RequiresApi(api = 24)
    public boolean resume() {
        TELogUtils.d(TAG, "[schedule] resume recording");
        try {
            try {
                this.mMediaRecorder.resume();
                TELogUtils.d(TAG, "resume end");
                return true;
            } catch (IllegalStateException unused) {
                TELogUtils.e(TAG, "mMediaRecorder resume state error");
                handleError(TER_STATE_ERROR);
                TELogUtils.d(TAG, "resume end");
                return false;
            }
        } catch (Throwable th) {
            TELogUtils.d(TAG, "resume end");
            throw th;
        }
    }

    public void setErrorCallback(ErrorCallback errorCallback) {
        this.mErrorCallback = errorCallback;
    }

    public void setFileName(String str) throws IOException {
        if (str == null || str.isEmpty()) {
            TELogUtils.e(TAG, "empty file name");
        }
        clearInvalidFile();
        this.mVideoFile = str;
        Log.d(TAG, "file path = " + this.mVideoFile);
    }

    public void setPreviewSize(TEFrameSizei tEFrameSizei) {
        this.mPreviewSize = tEFrameSizei;
    }

    public void setRecorderSetting(int i, int i2, int i3, int i4) {
        this.mVideoSize = new Size(i, i2);
        this.mFrameRate = i3;
        this.mBitRate = i4;
    }

    public void setSupportSizes(List<TEFrameSizei> list) {
        this.mSupportSizes = list;
    }

    public void start() {
        try {
            try {
                try {
                    this.mMediaRecorder.start();
                    TELogUtils.d(TAG, "Recording starts!");
                } catch (IllegalStateException unused) {
                    TELogUtils.e(TAG, "mMediaRecorder prepare not well!");
                    clearInvalidFile();
                    handleError(TER_STATE_ERROR);
                }
            } catch (RuntimeException unused2) {
                TELogUtils.e(TAG, "start error: runtime");
                deleteFile();
                handleError(TER_RUNNING_TIME_ERROR);
            }
        } finally {
            TELogUtils.d(TAG, "start end");
        }
    }

    public void startRecord(int i) {
        this.mOrientaton = i;
        if (this.mState != 0) {
            this.mBackgroundHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.mediarecorder.TEMediaRecorder.1
                @Override // java.lang.Runnable
                public void run() {
                    TEMediaRecorder.this.prepare();
                    TEMediaRecorder.this.start();
                }
            });
            this.mState = 0;
        }
    }

    public void stop() {
        try {
            try {
                this.mMediaRecorder.stop();
            } catch (IllegalStateException unused) {
                TELogUtils.e(TAG, "mMediaRecorder stop state error");
                handleError(TER_STATE_ERROR);
            } catch (RuntimeException e) {
                TELogUtils.e(TAG, "going to clean up the invalid output file, exception message = " + e.getMessage());
                deleteFile();
                handleError(TER_RUNNING_TIME_ERROR);
            }
        } finally {
            TELogUtils.d(TAG, "stopRecord end");
        }
    }

    public void stopRecord() {
        if (this.mState != 1) {
            this.mBackgroundHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.mediarecorder.TEMediaRecorder.2
                @Override // java.lang.Runnable
                public void run() {
                    TEMediaRecorder.this.stop();
                }
            });
            this.mState = 1;
        }
    }

    public void prepare() {
    }
}
