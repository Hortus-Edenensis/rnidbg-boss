package com.zenmen.media.transcode;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.media.extractor.ZMMediaExtractor;
import defpackage.g13;
import defpackage.pu1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InterruptedIOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class MediaTranscodePassThrough implements IMediaTranscode {
    private static final float DEFAULT_BITRATE_UP_DELTA = 1.1f;
    private static final String TAG = "MediaTransPassThrough";
    private int mMaxWidth = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING;
    private int mMaxHeight = 960;
    private int mSrcWidth = 0;
    private int mSrcHeight = 0;
    private long mSrcDuration = 0;
    private String mSrcUrl = null;
    private String mDstUrl = null;
    private volatile Handler mHandler = null;
    private volatile Thread mDoPassThroughThread = null;
    private ZMMediaExtractor mExtractor = null;
    private AtomicBoolean mRunning = new AtomicBoolean(false);
    private boolean mIsTimeRange = false;
    private long mTimeRangeStart = 0;
    private long mTimeRangeEnd = 0;
    private int mMaxDuration = 120000;
    private int mMinBitrate = 600;

    /* JADX INFO: compiled from: SearchBox */
    public static class ErrorCodes {
        public static final int ERROR_CREATE_EXTRACTOR_FAILED = -5013;
        public static final int ERROR_DST_FILE_OPEN_FAILED = -5012;
        public static final int ERROR_FILE_IO_FAILED = -5015;
        public static final int ERROR_MEDIA_FILE_UNSUPPORTED = -5014;
        public static final int ERROR_NONE = 0;
        public static final int ERROR_NONE_IS_PASSTHROUGH = 5010;
        public static final int ERROR_SRC_FILE_OPEN_FAILED = -5011;
    }

    private int computeMaxBitrateByResolution(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return -1;
        }
        return (int) (((((i * i2) * 30) / 10) / 1000) * DEFAULT_BITRATE_UP_DELTA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doPassThrough() throws Throwable {
        FileOutputStream fileOutputStream;
        long length;
        long j;
        if (this.mDstUrl == null) {
            sendMessageToHandler(206, ErrorCodes.ERROR_DST_FILE_OPEN_FAILED, 0);
            this.mRunning.set(false);
            return false;
        }
        File file = new File(this.mSrcUrl);
        File file2 = new File(this.mDstUrl);
        FileInputStream fileInputStream = null;
        try {
            length = file.length();
            j = 0;
        } catch (InterruptedIOException unused) {
            fileOutputStream = null;
        } catch (Exception unused2) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        if (length <= 0) {
            sendMessageToHandler(206, ErrorCodes.ERROR_FILE_IO_FAILED, 0);
            pu1.u(null);
            pu1.u(null);
            sendMessageToHandler(203, 0, 0);
            this.mRunning.set(false);
            return false;
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream2.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                    j += (long) i;
                    int i2 = (int) ((j / length) * 100.0d);
                    if (i2 % 10 == 0) {
                        sendMessageToHandler(205, i2, 0);
                    }
                }
                pu1.u(fileInputStream2);
                pu1.u(fileOutputStream);
            } catch (InterruptedIOException unused3) {
                fileInputStream = fileInputStream2;
                pu1.u(fileInputStream);
                pu1.u(fileOutputStream);
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception unused4) {
                fileInputStream = fileInputStream2;
                try {
                    sendMessageToHandler(206, ErrorCodes.ERROR_FILE_IO_FAILED, 0);
                    pu1.u(fileInputStream);
                    pu1.u(fileOutputStream);
                    sendMessageToHandler(203, 0, 0);
                    this.mRunning.set(false);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    pu1.u(fileInputStream);
                    pu1.u(fileOutputStream);
                    sendMessageToHandler(203, 0, 0);
                    this.mRunning.set(false);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                pu1.u(fileInputStream);
                pu1.u(fileOutputStream);
                sendMessageToHandler(203, 0, 0);
                this.mRunning.set(false);
                throw th;
            }
        } catch (InterruptedIOException unused5) {
            fileOutputStream = null;
        } catch (Exception unused6) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        sendMessageToHandler(203, 0, 0);
        this.mRunning.set(false);
        return true;
    }

    private void sendMessageToHandler(int i, int i2, int i3) {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(i, i2, i3, null));
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int getPercent() {
        return 0;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public long getSrcDuration() {
        return this.mSrcDuration;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int getVideoHeight() {
        return this.mSrcHeight;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int getVideoWidth() {
        return this.mSrcWidth;
    }

    public boolean isPassThrough(ZMMediaExtractor zMMediaExtractor) {
        int iD;
        int iF = zMMediaExtractor.f();
        int iC = zMMediaExtractor.c();
        if (iF <= 0 || iC <= 0 || iF * iC > this.mMaxWidth * this.mMaxHeight) {
            return false;
        }
        long jB = zMMediaExtractor.b();
        if (jB <= 0) {
            return false;
        }
        if ((this.mIsTimeRange && (this.mTimeRangeStart != 0 || this.mTimeRangeEnd < (jB / 1000) * 1000)) || (iD = zMMediaExtractor.d() / 1000) <= 0) {
            return false;
        }
        int iComputeMaxBitrateByResolution = computeMaxBitrateByResolution(this.mSrcHeight, this.mSrcWidth);
        if (iComputeMaxBitrateByResolution > 0 && iD > iComputeMaxBitrateByResolution) {
            return false;
        }
        int i = this.mMaxDuration;
        return (jB > ((long) i) && iD < this.mMinBitrate) || jB < ((long) i);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setDstUrl(String str, int i) {
        this.mDstUrl = str;
        return 0;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setSrcUrl(String str, CodecFormatCheckListener codecFormatCheckListener, int i) {
        this.mSrcUrl = str;
        if (str == null) {
            sendMessageToHandler(206, -5011, 0);
            return -5011;
        }
        ZMMediaExtractor zMMediaExtractor = new ZMMediaExtractor(this.mSrcUrl);
        this.mExtractor = zMMediaExtractor;
        if (zMMediaExtractor.g() != 0) {
            sendMessageToHandler(206, ErrorCodes.ERROR_MEDIA_FILE_UNSUPPORTED, 0);
            return ErrorCodes.ERROR_MEDIA_FILE_UNSUPPORTED;
        }
        this.mSrcHeight = this.mExtractor.c();
        this.mSrcWidth = this.mExtractor.f();
        this.mSrcDuration = this.mExtractor.b();
        Log.i(TAG, "w:" + this.mSrcWidth + ",h:" + this.mSrcHeight + ",duration:" + this.mSrcDuration + ",bitrate:" + this.mExtractor.d());
        if (!isPassThrough(this.mExtractor)) {
            return 0;
        }
        sendMessageToHandler(200, 0, 0);
        return 5010;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setTimeRange(long j, long j2) {
        this.mIsTimeRange = true;
        this.mTimeRangeStart = j;
        this.mTimeRangeEnd = j2;
        return 0;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setVideoPropo(int i, int i2, int i3) {
        return 0;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int start(boolean z) {
        if (this.mRunning.getAndSet(true)) {
            return 0;
        }
        sendMessageToHandler(201, 0, 0);
        this.mDoPassThroughThread = new g13(new Runnable() { // from class: com.zenmen.media.transcode.MediaTranscodePassThrough.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                MediaTranscodePassThrough.this.doPassThrough();
            }
        });
        if (this.mDoPassThroughThread != null) {
            this.mDoPassThroughThread.start();
        }
        return 0;
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void stop() {
        this.mHandler = null;
        if (this.mDoPassThroughThread != null) {
            this.mDoPassThroughThread.interrupt();
            try {
                this.mDoPassThroughThread.join();
                this.mRunning.set(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mDoPassThroughThread = null;
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void getBitmap(Bitmap bitmap) {
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void setBlendPic(Bitmap bitmap) {
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void getFrameAtTime(Bitmap bitmap, long j) {
    }
}
