package com.zenmen.media.rtc;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class MP4Writer {
    private int mVideoTrackIndex = -1;
    private MediaMuxer mMediaMuxer = null;
    private boolean mStarted = false;

    public int createVideoTrack(MediaFormat mediaFormat) {
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer == null) {
            return -1;
        }
        this.mVideoTrackIndex = -1;
        try {
            this.mVideoTrackIndex = mediaMuxer.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.mVideoTrackIndex;
    }

    public boolean init(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            this.mMediaMuxer = new MediaMuxer(str, 0);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void start() {
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer == null || this.mStarted) {
            return;
        }
        mediaMuxer.start();
        this.mStarted = true;
    }

    public void stop() {
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer == null || !this.mStarted) {
            return;
        }
        mediaMuxer.stop();
        this.mStarted = false;
    }

    public void uninit() {
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer != null) {
            mediaMuxer.release();
            this.mMediaMuxer = null;
        }
    }

    public void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer == null || i == -1) {
            return;
        }
        mediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
    }
}
