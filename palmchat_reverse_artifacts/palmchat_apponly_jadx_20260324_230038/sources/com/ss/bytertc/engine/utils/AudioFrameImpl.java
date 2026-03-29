package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioFrameType;
import com.ss.bytertc.engine.data.AudioSampleRate;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioFrameImpl implements IAudioFrame {
    private ByteBuffer byteBuffer;
    private AudioChannel channel;
    private AudioFrameType frameType;
    private AudioSampleRate sampleRate;
    private int samplesPerChannel;
    private long timestamp;

    public AudioFrameImpl() {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0L;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioChannel channel() {
        return this.channel;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public int data_size() {
        return this.samplesPerChannel * this.channel.value() * 2;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioFrameType frame_type() {
        return this.frameType;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public ByteBuffer getDataBuffer() {
        return this.byteBuffer;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioSampleRate sample_rate() {
        return this.sampleRate;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public long timestamp_us() {
        return this.timestamp;
    }

    public AudioFrameImpl(byte[] bArr, int i, AudioSampleRate audioSampleRate, AudioChannel audioChannel) {
        this(ByteBuffer.wrap(bArr), i, audioSampleRate, audioChannel);
    }

    public AudioFrameImpl(ByteBuffer byteBuffer, int i, AudioSampleRate audioSampleRate, AudioChannel audioChannel) {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0L;
        this.byteBuffer = byteBuffer;
        this.samplesPerChannel = i;
        this.sampleRate = audioSampleRate;
        this.channel = audioChannel;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public void release() {
    }
}
