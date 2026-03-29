package com.bef.effectsdk;

import android.media.MediaPlayer;
import android.util.Log;
import defpackage.lk1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@lk1
public class AudioPlayer {
    public static final String TAG = "AudioPlayer";
    private long mNativePtr;
    private MediaPlayer mMediaPlayer = null;
    private boolean mIsPrepared = false;
    private String mFilename = null;

    @lk1
    public AudioPlayer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @lk1
    public native void nativeOnCompletion(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @lk1
    public native void nativeOnError(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @lk1
    public native void nativeOnInfo(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @lk1
    public native void nativeOnPrepared(long j);

    @lk1
    public float getCurrentPlayTime() {
        if (this.mMediaPlayer != null) {
            return r0.getCurrentPosition() / 1000.0f;
        }
        Log.e(TAG, "MediaPlayer is null!");
        return 0.0f;
    }

    @lk1
    public float getTotalPlayTime() {
        if (this.mMediaPlayer != null) {
            return r0.getDuration() / 1000.0f;
        }
        Log.e(TAG, "MediaPlayer is null!");
        return 0.0f;
    }

    @lk1
    public int init() {
        this.mIsPrepared = false;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
        }
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer2;
        mediaPlayer2.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.bef.effectsdk.AudioPlayer.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer3, int i, int i2) {
                Log.i(AudioPlayer.TAG, "MediaPlayer onInfo: [what, extra] = [" + i + ", " + i2 + "]");
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnInfo(audioPlayer.mNativePtr, i, i2);
                return false;
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.bef.effectsdk.AudioPlayer.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer3, int i, int i2) {
                Log.d(AudioPlayer.TAG, "MediaPlayer onError: [what, extra] = [" + i + ", " + i2 + "]");
                try {
                    AudioPlayer.this.mMediaPlayer.stop();
                    AudioPlayer.this.mMediaPlayer.release();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(AudioPlayer.TAG, "MediaPlayer stop exception on error " + e.toString());
                }
                AudioPlayer.this.mMediaPlayer = null;
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnError(audioPlayer.mNativePtr, i, i2);
                return false;
            }
        });
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bef.effectsdk.AudioPlayer.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer3) {
                Log.i(AudioPlayer.TAG, "MediaPlayer onPrepared...");
                AudioPlayer.this.mIsPrepared = true;
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnPrepared(audioPlayer.mNativePtr);
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.bef.effectsdk.AudioPlayer.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer3) {
                Log.i(AudioPlayer.TAG, "MediaPlayer onCompletion...");
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnCompletion(audioPlayer.mNativePtr);
            }
        });
        return 0;
    }

    @lk1
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        if (!this.mIsPrepared) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        try {
            return mediaPlayer.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "MediaPlayer isPlaying exception. " + e.toString());
            return false;
        }
    }

    @lk1
    public boolean pause() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        if (this.mIsPrepared) {
            mediaPlayer.pause();
            return true;
        }
        Log.e(TAG, "MediaPlayer is null!");
        return false;
    }

    @lk1
    public int release() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        try {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "MediaPlayer stop exception on release " + e.toString());
        }
        this.mMediaPlayer = null;
        return 0;
    }

    @lk1
    public boolean resume() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        if (this.mIsPrepared) {
            mediaPlayer.start();
            return true;
        }
        Log.e(TAG, "MediaPlayer is null!");
        return false;
    }

    @lk1
    public boolean seek(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        if (!this.mIsPrepared) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        try {
            mediaPlayer.seekTo(i);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "MediaPlayer seek exception. " + e.toString());
            return true;
        }
    }

    @lk1
    public void setDataSource(String str) {
        if (this.mMediaPlayer == null) {
            init();
        }
        if (str.equals(this.mFilename) && this.mIsPrepared && this.mMediaPlayer.isPlaying()) {
            return;
        }
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDataSource(str);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "MediaPlayer setDataSource exception. " + e.toString());
        }
        this.mFilename = str;
    }

    @lk1
    public boolean setLoop(boolean z) {
        if (this.mMediaPlayer == null) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        Log.i(TAG, "set isLoop " + z);
        this.mMediaPlayer.setLooping(z);
        return true;
    }

    @lk1
    public void setNativePtr(long j) {
        this.mNativePtr = j;
    }

    @lk1
    public boolean setVolume(float f) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "MediaPlayer is null!");
            return false;
        }
        if (this.mIsPrepared) {
            mediaPlayer.setVolume(f, f);
            return true;
        }
        Log.e(TAG, "MediaPlayer is null!");
        return false;
    }

    @lk1
    public void startPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (!this.mIsPrepared) {
                mediaPlayer.prepare();
                this.mIsPrepared = true;
            }
            this.mMediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "MediaPlayer setDataSource exception. " + e.toString());
        }
    }

    @lk1
    public void stopPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "MediaPlayer is null!");
            return;
        }
        if (this.mIsPrepared) {
            try {
                mediaPlayer.stop();
                this.mMediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "MediaPlayer stop exception on stop " + e.toString());
            }
            this.mMediaPlayer = null;
            this.mIsPrepared = false;
        }
    }
}
