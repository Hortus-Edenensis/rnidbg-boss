package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioFrameType;
import com.ss.bytertc.engine.data.AudioSampleRate;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IAudioFrame {
    AudioChannel channel();

    int data_size();

    AudioFrameType frame_type();

    ByteBuffer getDataBuffer();

    void release();

    AudioSampleRate sample_rate();

    long timestamp_us();
}
