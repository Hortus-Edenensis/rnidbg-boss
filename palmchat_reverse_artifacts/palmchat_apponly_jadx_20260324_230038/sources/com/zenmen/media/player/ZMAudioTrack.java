package com.zenmen.media.player;

import android.media.AudioTrack;
import android.os.Process;
import android.util.Log;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ZMAudioTrack {
    private static final int BUFFER_SIZE = 40960;
    private static final int DEFAULT_CH = 2;
    private static final int ERR_ACCESS_DENIED = -21;
    private static final int ERR_NONE = 0;
    private static final float HARDWARE_COFF = 990.0f;
    private static final String LOG_TAG = "ZMAudioTrack";
    private static final int MIN_HARDWARE_VOLUME = -990;
    private static final int SAMPLERATE_48K = 48000;
    private static final int TWO_K = 2048;
    private static int mAudioSessionId;
    private AudioTrack mAudioTrack;
    private int mChannels;
    private int mMinBufferSize;
    private int mSampleRate;
    private boolean mSetPriority = false;
    private int mDelayedLVolume = 0;
    private int mDelayedRVolume = 0;
    private boolean mDelayedSetVolume = false;

    private void audioClose() {
        if (this.mAudioTrack == null) {
            return;
        }
        try {
            audioStop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void audioDestroy() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null) {
            return;
        }
        try {
            audioTrack.release();
            this.mAudioTrack = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int audioOpen(int i, int i2) {
        this.mSampleRate = i;
        this.mChannels = i2;
        int iCreateAudioTrack = createAudioTrack(i, i2);
        Log.i(LOG_TAG, "mAudioTrack open " + iCreateAudioTrack + " samplerate " + i + " samplerate " + i2);
        if (iCreateAudioTrack != 0) {
            return iCreateAudioTrack;
        }
        return 0;
    }

    public static int audioSessionId() {
        return mAudioSessionId;
    }

    private void audioSetVolume(int i, int i2) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            if (audioTrack.getState() != 3) {
                this.mDelayedSetVolume = true;
                this.mDelayedLVolume = i;
                this.mDelayedRVolume = i2;
            }
            float f = 0.0f;
            float f2 = i == 0 ? 1.0f : i == MIN_HARDWARE_VOLUME ? 0.0f : (i - MIN_HARDWARE_VOLUME) / HARDWARE_COFF;
            if (i2 == 0) {
                f = 1.0f;
            } else if (i2 != MIN_HARDWARE_VOLUME) {
                f = (i2 - MIN_HARDWARE_VOLUME) / HARDWARE_COFF;
            }
            try {
                this.mAudioTrack.setStereoVolume(f2, f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void audioStop() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null) {
            return;
        }
        try {
            audioTrack.stop();
            this.mAudioTrack.flush();
            this.mSetPriority = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int createAudioTrack(int i, int i2) {
        AudioTrack audioTrack;
        int i3 = i2 == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(i, i3, 2);
        this.mMinBufferSize = minBufferSize;
        if (minBufferSize != -2 && minBufferSize != -1) {
            int i4 = minBufferSize * 2;
            int i5 = i4 < 2048 ? 2048 : i4;
            try {
                AudioTrack audioTrack2 = this.mAudioTrack;
                if (mAudioSessionId != 0) {
                    this.mAudioTrack = new AudioTrack(3, i, i3, 2, i5, 1, mAudioSessionId);
                } else {
                    do {
                        int iAbs = Math.abs(new Random().nextInt());
                        mAudioSessionId = iAbs;
                        if (iAbs == 0) {
                            mAudioSessionId = Integer.MAX_VALUE;
                        }
                        audioTrack = new AudioTrack(3, i, i3, 2, i5, 1, mAudioSessionId);
                        this.mAudioTrack = audioTrack;
                    } while (mAudioSessionId != audioTrack.getAudioSessionId());
                }
                if (audioTrack2 != null) {
                    audioTrack2.release();
                }
                if (this.mAudioTrack.getState() == 0) {
                    return -21;
                }
                this.mSetPriority = false;
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -21;
    }

    public static int maxOutputSamplerate() {
        Math.abs(new Random().nextInt());
        try {
            new AudioTrack(3, 48000, 2, 2, BUFFER_SIZE, 1).release();
            return 48000;
        } catch (Exception unused) {
            return AudioTrack.getNativeOutputSampleRate(3);
        }
    }

    private void writeData(byte[] bArr, int i) {
        if (!this.mSetPriority) {
            Process.setThreadPriority(-16);
            this.mSetPriority = true;
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null || i <= 0) {
            return;
        }
        if (audioTrack.getPlayState() != 3) {
            this.mAudioTrack.play();
            if (this.mDelayedSetVolume) {
                this.mDelayedSetVolume = false;
                audioSetVolume(this.mDelayedLVolume, this.mDelayedRVolume);
            }
        }
        try {
            this.mAudioTrack.write(bArr, 0, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
