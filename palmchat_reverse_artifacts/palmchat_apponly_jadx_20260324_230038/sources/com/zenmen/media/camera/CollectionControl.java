package com.zenmen.media.camera;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.media.camera.NativeWrap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@SuppressLint({"NewApi"})
public class CollectionControl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int SINK_FLV = 2;
    public static final int SINK_MP4 = 0;
    public static final int SINK_RTMP = 1;
    public static final int SWAP_DISCARD_MAX = 8;
    private static String TAG = "CollectionControl";
    private static int m_level = 2;
    private long Nowpts;
    private int mDisaplayOritation;
    private int mFinalOrientation;
    private boolean mHardEncoder;
    private NativeWrap.OnMediaNotifyEventListener mListen;
    private boolean mMute;
    private NativeWrap mNative;
    private int mNum;
    private byte[] mRotateArray;
    private boolean mUseHWEncFailed;
    private boolean mUseHardEncoder;
    private long mVideoCount;
    private int[] m_Count;
    private int m_SinkType;
    private String m_Videourl;
    private int m_actualframerate;
    private int m_actualrate;
    private AVEncoder m_audioEncoder;
    private int m_bitrate;
    private int m_channel;
    private int m_color;
    private MediaCodecInfo.CodecCapabilities m_colorCapab;
    private int m_displayHight;
    private int m_displayWidth;
    private int m_framerate;
    private long m_preSecond;
    private int m_prevideoHight;
    private int m_prevideoWidth;
    private boolean m_resolution;
    private int m_samplrate;
    public boolean m_startRecord;
    private long m_startsystemtime;
    private long m_starttime;
    private int m_tick;
    private int m_version;
    private AVEncoder m_videoEncoder;
    private int m_videoHight;
    private int m_videoWidth;
    private long nFirstPts;
    private int swapCnt;
    private boolean swapflag;

    public CollectionControl() {
        this.mNative = null;
        this.m_videoEncoder = null;
        this.m_audioEncoder = null;
        this.m_samplrate = 44100;
        this.m_channel = 1;
        this.m_videoWidth = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        this.m_videoHight = 240;
        this.m_prevideoWidth = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        this.m_prevideoHight = TECameraSettings.FPS_480;
        this.m_displayWidth = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        this.m_displayHight = 240;
        this.m_framerate = 30;
        this.m_actualframerate = 30;
        this.m_actualrate = 1;
        this.m_resolution = false;
        this.m_preSecond = 0L;
        this.m_starttime = 0L;
        this.m_startsystemtime = 0L;
        this.m_tick = 0;
        this.mNum = 0;
        this.m_SinkType = 0;
        this.swapflag = false;
        this.mMute = false;
        this.mHardEncoder = true;
        this.mUseHardEncoder = true;
        this.mUseHWEncFailed = false;
        this.swapCnt = 0;
        this.Nowpts = -1L;
        this.nFirstPts = -1L;
        this.m_startRecord = false;
        this.mListen = null;
        this.mDisaplayOritation = 90;
        this.mVideoCount = 0L;
        this.mFinalOrientation = 0;
        this.mNative = new NativeWrap();
        this.m_Count = new int[5];
        this.mNum = 0;
    }

    @SuppressLint({"NewApi"})
    private void CheckDevice() {
        this.m_version = Build.VERSION.SDK_INT;
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        boolean z = false;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.equals("video/avc")) {
                        mediaCodecInfo = codecInfoAt;
                        z = true;
                    }
                }
                if (z) {
                    break;
                }
            }
        }
        if (!z) {
            this.mHardEncoder = false;
            Log.e(TAG, "device hard-encoder not support!");
            return;
        }
        try {
            this.m_colorCapab = mediaCodecInfo.getCapabilitiesForType("video/avc");
            this.m_color = colorformatQuery();
            this.mHardEncoder = true;
        } catch (IllegalArgumentException unused) {
            this.mHardEncoder = false;
            Log.e(TAG, "device hard-encoder not support avc!");
        }
    }

    private boolean IsDiscardingFrame(long j) {
        synchronized (this) {
            boolean z = true;
            int i = this.m_tick + 1;
            this.m_tick = i;
            int i2 = this.m_actualrate;
            if (i2 <= 1) {
                return false;
            }
            if (i % i2 != 0) {
                z = false;
            }
            return z;
        }
    }

    private int colorformatQuery() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.m_colorCapab.colorFormats;
            if (i >= iArr.length) {
                break;
            }
            int i5 = iArr[i];
            if (i5 == 2143289346) {
                i3++;
            }
            if (i5 == 19) {
                i2++;
            }
            if (i5 == 21) {
                i4++;
            }
            i++;
        }
        if (Build.VERSION.SDK_INT >= 31 && i2 > 0) {
            return 19;
        }
        if (i4 > 0 || i3 > 0) {
            return 21;
        }
        return i2 > 0 ? 19 : -1;
    }

    public static int initCpuInfo(int i) throws Throwable {
        int i2;
        String maxCpuFreq = CpuManager.getMaxCpuFreq();
        String curCpuFreq = CpuManager.getCurCpuFreq();
        String cpuCoreNum = CpuManager.getCpuCoreNum();
        try {
            int iIntValue = Integer.valueOf(maxCpuFreq).intValue();
            Integer.valueOf(curCpuFreq).intValue();
            int iIntValue2 = Integer.valueOf(cpuCoreNum).intValue() + 1;
            if (iIntValue < 1000000 || iIntValue2 <= 2) {
                m_level = 0;
                i2 = 10;
            } else {
                i2 = i;
            }
            if (iIntValue >= 1000000 && iIntValue < 1200000 && iIntValue2 >= 2) {
                m_level = 1;
                i2 = 15;
            }
            if (iIntValue >= 1200000 && iIntValue2 >= 4) {
                i2 = i <= 30 ? i : 20;
                m_level = 2;
            }
            if (iIntValue2 <= 2) {
                m_level = 0;
                i2 = 7;
            }
            return i2 > i ? i : i2;
        } catch (Exception unused) {
            Log.e(TAG, "Unable to get the CPU info, set the framerate to origin : " + i);
            return i;
        }
    }

    private void innerEncoderReset() {
        AVEncoder aVEncoder;
        AVEncoder aVEncoder2 = this.m_videoEncoder;
        if (aVEncoder2 != null) {
            aVEncoder2.close();
            this.m_videoEncoder = null;
        }
        this.mNative.setVideoFpsBitrate(this.m_framerate, this.m_bitrate, m_level);
        if (this.mUseHardEncoder && this.m_videoEncoder == null) {
            AVEncoder aVEncoder3 = new AVEncoder(this.mNative);
            this.m_videoEncoder = aVEncoder3;
            aVEncoder3.setVideoInfo(this.m_videoWidth, this.m_videoHight, this.m_framerate, this.m_bitrate);
            this.m_videoEncoder.videoEncodeInit(this.m_color, 0);
        }
        if (!this.mUseHardEncoder || (aVEncoder = this.m_videoEncoder) == null) {
            return;
        }
        aVEncoder.start();
    }

    private boolean isPictureValid(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    public Bitmap GetLastPicture(boolean z) {
        int i;
        int i2 = this.m_displayWidth;
        if (i2 == 0 || (i = this.m_displayHight) == 0) {
            Log.e(TAG, "m_displayWidth or m_displayHight is 0");
            return null;
        }
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap == null) {
            return null;
        }
        int i3 = i2 * i;
        int[] iArr = new int[i3];
        nativeWrap.GetLastPicture(iArr, i3);
        if (!z || isPictureValid(iArr)) {
            return Bitmap.createBitmap(iArr, i2, i, Bitmap.Config.ARGB_8888);
        }
        return null;
    }

    public Bitmap GetPicture() {
        int i;
        int i2 = this.m_videoWidth;
        if (i2 == 0 || (i = this.m_videoHight) == 0) {
            Log.e(TAG, "m_videoWidth or m_videoHight is 0");
            return null;
        }
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap == null) {
            return null;
        }
        int i3 = i2 * i;
        int[] iArr = new int[i3];
        nativeWrap.GetPicture(iArr, i3);
        return Bitmap.createBitmap(iArr, i2, i, Bitmap.Config.ARGB_8888);
    }

    public void SetPicNum(int i) {
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.SetPicNum(i);
        }
    }

    public void feedAudioData(byte[] bArr, int i) {
        if (this.m_startRecord) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.m_startsystemtime;
            if (this.mMute) {
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = 0;
                }
            }
            NativeWrap nativeWrap = this.mNative;
            if (nativeWrap != null) {
                nativeWrap.sendAudioRawData(bArr, i, jCurrentTimeMillis);
            }
        }
    }

    public void feedPictureData(byte[] bArr) {
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.sendPictureRawData(bArr, bArr.length, this.mDisaplayOritation);
        }
    }

    public void feedVideoData(byte[] bArr) {
        if (this.mUseHardEncoder && this.mRotateArray == null) {
            this.mRotateArray = new byte[((this.m_videoWidth * this.m_videoHight) * 3) / 2];
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.m_startsystemtime;
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.sendVideoRawData(bArr, bArr.length, jCurrentTimeMillis, this.mDisaplayOritation);
        }
        if (this.mUseHardEncoder && this.m_startRecord) {
            this.mNative.handleRawData(this.mRotateArray, this.mDisaplayOritation, this.mFinalOrientation);
            if (this.m_videoEncoder != null) {
                Log.e(TAG, "video encode pts = " + jCurrentTimeMillis);
                this.m_videoEncoder.feedDataToVideoEncoder(this.mRotateArray, jCurrentTimeMillis);
            }
        }
    }

    public NativeWrap getNative() {
        return this.mNative;
    }

    public boolean init() {
        NativeWrap.OnMediaNotifyEventListener onMediaNotifyEventListener;
        CheckDevice();
        if (!this.mHardEncoder && this.mUseHardEncoder) {
            this.mUseHardEncoder = false;
        }
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null && (onMediaNotifyEventListener = this.mListen) != null) {
            nativeWrap.setOnMediaNotifyEventListener(onMediaNotifyEventListener);
        }
        this.mNative.setVideoFpsBitrate(this.m_framerate, this.m_bitrate, m_level);
        this.mNative.setSrcVideoWidthHeight(this.m_prevideoHight, this.m_prevideoWidth);
        this.mNative.setDstVideoWidthHeight(this.m_videoWidth, this.m_videoHight);
        if (this.mUseHardEncoder) {
            this.m_videoEncoder = new AVEncoder(this.mNative);
            AVEncoder aVEncoder = new AVEncoder(this.mNative);
            this.m_audioEncoder = aVEncoder;
            aVEncoder.setAudioParameter(this.m_samplrate, this.m_channel, 64000);
            this.m_audioEncoder.audioEncodeInit();
            this.mUseHWEncFailed = false;
        }
        this.mNative.setAudioInfo(this.m_samplrate, this.m_channel, 64000);
        return true;
    }

    public void mute(boolean z) {
        this.mMute = z;
    }

    public void resetEncode(int i, int i2) {
        this.m_framerate = i;
        this.m_bitrate = i2;
    }

    public void setAudioInfo(int i, int i2) {
        this.m_samplrate = i;
        this.m_channel = i2;
    }

    public void setDisplayWXH(int i, int i2) {
        this.m_displayWidth = i;
        this.m_displayHight = i2;
        Log.e(TAG, "m_displayWidth" + this.m_displayWidth + " m_displayHight:" + this.m_displayHight);
    }

    public void setNotifyEventListener(NativeWrap.OnMediaNotifyEventListener onMediaNotifyEventListener) {
        this.mListen = onMediaNotifyEventListener;
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.setOnMediaNotifyEventListener(onMediaNotifyEventListener);
        }
    }

    public void setNotifyLogListener(NativeWrap.OnMediaNotifyLogListener onMediaNotifyLogListener) {
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.setOnMediaNotifyLogListener(onMediaNotifyLogListener);
        }
    }

    public void setPreViewInfo(int i, int i2, int i3) {
        this.m_prevideoWidth = i;
        this.m_prevideoHight = i2;
        this.mDisaplayOritation = i3;
    }

    public void setSinkFilePath(String str, int i) {
        this.m_SinkType = i;
        this.m_Videourl = str;
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.setVideoFpsBitrate(this.m_framerate, this.m_bitrate, m_level);
            this.mNative.setSinkFilePath(str, i);
        }
    }

    public void setUseHardEncode(boolean z) {
        this.mUseHardEncoder = z;
        if (this.mHardEncoder) {
            return;
        }
        this.mUseHardEncoder = false;
    }

    public void setVideoBitRate(int i) {
        int i2;
        int i3;
        synchronized (this) {
            i2 = this.m_framerate;
            i3 = (i * i2) / 30;
            this.m_bitrate = i3;
        }
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.setVideoFpsBitrate(i2, i3, m_level);
        }
    }

    public void setVideoFrameRate(int i, int i2) {
        synchronized (this) {
            this.m_actualframerate = i;
            this.m_framerate = i;
            if (i2 > i) {
                this.m_actualrate = i2 / (i2 - i);
            } else {
                this.m_framerate = i2;
                this.m_actualrate = 1;
            }
            this.m_bitrate = (this.m_bitrate * this.m_framerate) / 30;
        }
    }

    public void setVideoInfo(int i, int i2) {
        this.m_videoWidth = i;
        this.m_videoHight = i2;
        this.m_bitrate = i * i2 * 3;
    }

    public boolean startRecord(int i) {
        this.mFinalOrientation = i;
        if (this.mUseHardEncoder) {
            if (this.m_videoEncoder == null) {
                this.m_videoEncoder = new AVEncoder(this.mNative);
            }
            this.m_videoEncoder.setVideoInfo(this.m_videoWidth, this.m_videoHight, this.m_framerate, this.m_bitrate);
            if (!this.m_videoEncoder.videoEncodeInit(this.m_color, i)) {
                this.mUseHardEncoder = false;
                this.mUseHWEncFailed = true;
            }
            if (this.m_audioEncoder == null) {
                AVEncoder aVEncoder = new AVEncoder(this.mNative);
                this.m_audioEncoder = aVEncoder;
                aVEncoder.setAudioParameter(this.m_samplrate, this.m_channel, 64000);
                this.m_audioEncoder.audioEncodeInit();
            }
            AVEncoder aVEncoder2 = this.m_videoEncoder;
            if (aVEncoder2 != null && !aVEncoder2.start()) {
                this.mUseHardEncoder = false;
                this.mUseHWEncFailed = true;
            }
            AVEncoder aVEncoder3 = this.m_audioEncoder;
            if (aVEncoder3 != null) {
                aVEncoder3.start();
            }
        }
        this.mNative.setVideoFpsBitrate(this.m_framerate, this.m_bitrate, m_level);
        this.mNative.start(this.mUseHardEncoder, i);
        this.m_startRecord = true;
        this.m_startsystemtime = System.currentTimeMillis();
        this.m_starttime = 0L;
        return true;
    }

    public void stopRecord() {
        if (this.m_startRecord) {
            this.m_startRecord = false;
            if (this.mUseHardEncoder || this.mUseHWEncFailed) {
                AVEncoder aVEncoder = this.m_videoEncoder;
                if (aVEncoder != null) {
                    aVEncoder.close();
                    this.m_videoEncoder = null;
                }
                AVEncoder aVEncoder2 = this.m_audioEncoder;
                if (aVEncoder2 != null) {
                    aVEncoder2.close();
                    this.m_audioEncoder = null;
                }
            }
            NativeWrap nativeWrap = this.mNative;
            if (nativeWrap != null) {
                nativeWrap.stop();
            }
            this.Nowpts = -1L;
            this.nFirstPts = -1L;
        }
    }

    public void swap() {
        synchronized (this) {
            this.swapflag = true;
            this.m_starttime = 0L;
            this.m_preSecond = 0L;
            this.mVideoCount = 0L;
            this.m_framerate = this.m_actualframerate;
            this.mNum = 0;
        }
    }

    public CollectionControl(NativeWrap nativeWrap) {
        this.m_videoEncoder = null;
        this.m_audioEncoder = null;
        this.m_samplrate = 44100;
        this.m_channel = 1;
        this.m_videoWidth = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        this.m_videoHight = 240;
        this.m_prevideoWidth = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        this.m_prevideoHight = TECameraSettings.FPS_480;
        this.m_displayWidth = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        this.m_displayHight = 240;
        this.m_framerate = 30;
        this.m_actualframerate = 30;
        this.m_actualrate = 1;
        this.m_resolution = false;
        this.m_preSecond = 0L;
        this.m_starttime = 0L;
        this.m_startsystemtime = 0L;
        this.m_tick = 0;
        this.m_SinkType = 0;
        this.swapflag = false;
        this.mMute = false;
        this.mHardEncoder = true;
        this.mUseHardEncoder = true;
        this.mUseHWEncFailed = false;
        this.swapCnt = 0;
        this.Nowpts = -1L;
        this.nFirstPts = -1L;
        this.m_startRecord = false;
        this.mListen = null;
        this.mDisaplayOritation = 90;
        this.mVideoCount = 0L;
        this.mFinalOrientation = 0;
        this.mNative = nativeWrap;
        this.m_Count = new int[5];
        this.mNum = 0;
    }
}
