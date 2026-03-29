package com.ss.bytertc.audio.device.webrtc;

import android.media.AudioRecord;
import android.os.Build;
import android.os.Process;
import androidx.annotation.Nullable;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.igexin.push.core.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_AUDIO_SOURCE;
    private static final int INVALID_AUDIO_SESSION_ID = -1;
    private static final int INVALID_AUDIO_SOURCE = -1;
    private static final String TAG = "WebRtcAudioRecord";

    @Nullable
    private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    private static int defaultMediaModeAudioSource;

    @Nullable
    private static WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;
    private String apiResult = "";
    private AudioRecord audioRecord;
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;

    /* JADX INFO: compiled from: SearchBox */
    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    /* JADX INFO: compiled from: SearchBox */
    public class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            Process.setThreadPriority(-19);
            RXLogging.i(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            if (WebRtcAudioRecord.this.audioRecord == null || WebRtcAudioRecord.this.audioRecord.getRecordingState() != 3) {
                StringBuilder sb = new StringBuilder();
                sb.append("AudioRecord.run failed: incorrect state :");
                sb.append(WebRtcAudioRecord.this.audioRecord == null ? b.m : Integer.valueOf(WebRtcAudioRecord.this.audioRecord.getRecordingState()));
                String string = sb.toString();
                RXLogging.e(WebRtcAudioRecord.TAG, string);
                this.keepAlive = false;
                WebRtcAudioRecord.this.reportWebRtcAudioRecordError(string);
            }
            System.nanoTime();
            while (this.keepAlive) {
                try {
                    i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                } catch (Exception e) {
                    RXLogging.e(WebRtcAudioRecord.TAG, "audioRecord.read failed: " + e.getMessage());
                    this.keepAlive = false;
                    i = -1;
                }
                if (i == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                    if (WebRtcAudioRecord.microphoneMute) {
                        WebRtcAudioRecord.this.byteBuffer.clear();
                        WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    }
                    synchronized (this) {
                        if (this.keepAlive) {
                            WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                            webRtcAudioRecord.nativeDataIsRecorded(i, webRtcAudioRecord.nativeAudioRecord);
                        }
                    }
                    if (WebRtcAudioRecord.audioSamplesReadyCallback != null) {
                        WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new AudioSamples(WebRtcAudioRecord.this.audioRecord, Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity())));
                    }
                } else if (i == -3 || i == -6) {
                    this.keepAlive = false;
                    String str = "AudioRecord.read failed: " + i;
                    RXLogging.e(WebRtcAudioRecord.TAG, str);
                    WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
            } catch (Exception e2) {
                RXLogging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e2.getMessage());
            }
        }

        public void stopThread() {
            synchronized (this) {
                RXLogging.i(WebRtcAudioRecord.TAG, "stopThread");
                this.keepAlive = false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        private AudioSamples(AudioRecord audioRecord, byte[] bArr) {
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = bArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    static {
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        defaultMediaModeAudioSource = defaultAudioSource;
    }

    public WebRtcAudioRecord(long j) {
        RXLogging.i(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioRecord = j;
        if (WebRtcAudioEffects.IsAudioEffectSupported()) {
            this.effects = WebRtcAudioEffects.create();
        }
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 16 : 12;
    }

    private int cvtNativeSetAudioSource(int i, boolean z) {
        int i2 = defaultMediaModeAudioSource;
        if (!z) {
            i2 = 7;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 5) {
            return 5;
        }
        if (i == 6) {
            return 6;
        }
        if (i == 7) {
            return 7;
        }
        if (i == 9) {
            return 9;
        }
        if (i != 10) {
            return i2;
        }
        return 10;
    }

    private boolean enableBuiltInAEC(boolean z) {
        RXLogging.i(TAG, "enableBuiltInAEC(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setAEC(z);
        }
        RXLogging.e(TAG, "Built-in AEC is not supported on this platform");
        return false;
    }

    private boolean enableBuiltInNS(boolean z) {
        RXLogging.i(TAG, "enableBuiltInNS(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setNS(z);
        }
        RXLogging.e(TAG, "Built-in NS is not supported on this platform");
        return false;
    }

    private String getApiResult() {
        return this.apiResult;
    }

    private int getAudioSessionId() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null) {
            return -1;
        }
        return audioRecord.getAudioSessionId();
    }

    private int getAudioSource() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null) {
            return -1;
        }
        return audioRecord.getAudioSource();
    }

    private static int getDefaultAudioSource() {
        return 0;
    }

    private int initRecording(int i, int i2, int i3, boolean z, int i4) {
        AudioRecord audioRecord;
        String str = "InitRecording(sampleRate=" + i + ", channels=" + i2 + ", frameSizeMs=" + i3 + ", forbidVoip=" + z + ", preferredSource=" + i4 + "):";
        this.apiResult = str;
        RXLogging.w(TAG, str);
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i5 = i2 * 2;
        int i6 = i / 100;
        if (i3 > 0 && i3 % 10 == 0) {
            i6 = (i3 * i) / 1000;
        }
        int i7 = i6;
        this.byteBuffer = ByteBuffer.allocateDirect(i5 * i7);
        RXLogging.i(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int iChannelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = AudioRecord.getMinBufferSize(i, iChannelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
            this.apiResult += "AudioRecord.getMinBufferSize failed: " + minBufferSize;
            return -1;
        }
        RXLogging.i(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int iMax = Math.max(minBufferSize, this.byteBuffer.capacity() * 2);
        RXLogging.i(TAG, "bufferSizeInBytes: " + iMax);
        try {
            synchronized (this) {
                int iCvtNativeSetAudioSource = cvtNativeSetAudioSource(i4, z);
                this.apiResult += ",AudioSource:" + iCvtNativeSetAudioSource + ",MinBufferSize:" + minBufferSize + ",byteBuffer.capcity:" + this.byteBuffer.capacity() + ", bufferSizeInBytes:" + iMax;
                audioRecord = this.audioRecord;
                if (audioRecord == null) {
                    audioRecord = new AudioRecord(iCvtNativeSetAudioSource, i, iChannelCountToConfiguration, 2, iMax);
                }
                this.audioRecord = audioRecord;
            }
            if (audioRecord != null && audioRecord.getState() == 1) {
                WebRtcAudioEffects webRtcAudioEffects = this.effects;
                if (webRtcAudioEffects != null) {
                    webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
                }
                logMainParameters();
                logMainParametersExtended();
                return i7;
            }
            reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
            releaseAudioResources();
            StringBuilder sb = new StringBuilder();
            sb.append(this.apiResult);
            sb.append("Failed to create a new AudioRecord instance state:");
            AudioRecord audioRecord2 = this.audioRecord;
            sb.append(audioRecord2 == null ? b.m : Integer.valueOf(audioRecord2.getState()));
            this.apiResult = sb.toString();
            return -1;
        } catch (IllegalArgumentException e) {
            reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + e.getMessage());
            releaseAudioResources();
            this.apiResult += "AudioRecord ctor error: " + e.getMessage();
            return -1;
        }
    }

    private void logMainParameters() {
        RXLogging.w(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate() + ", source:" + this.audioRecord.getAudioSource());
    }

    private void logMainParametersExtended() {
        if (Build.VERSION.SDK_INT >= 23) {
            RXLogging.w(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
        }
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int i, long j);

    private void releaseAudioResources() {
        RXLogging.i(TAG, "releaseAudioResources");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        RXLogging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        RXLogging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        RXLogging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback) {
        RXLogging.i(TAG, "Set error callback");
        errorCallback = webRtcAudioRecordErrorCallback;
    }

    public static void setMicrophoneMute(boolean z) {
        RXLogging.w(TAG, "setMicrophoneMute(" + z + ")");
        microphoneMute = z;
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback webRtcAudioRecordSamplesReadyCallback) {
        audioSamplesReadyCallback = webRtcAudioRecordSamplesReadyCallback;
    }

    private boolean startRecording() {
        this.apiResult = "StartRecording:";
        RXLogging.i(TAG, "StartRecording:");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null) {
            RXLogging.e(TAG, "null audio record object");
            return false;
        }
        if (this.audioThread != null) {
            RXLogging.e(TAG, "the previous audio thread leak");
            return false;
        }
        try {
            audioRecord.startRecording();
            if (this.audioRecord.getRecordingState() == 3) {
                AudioRecordThread audioRecordThread = new AudioRecordThread("BaeRecordJavaThread");
                this.audioThread = audioRecordThread;
                audioRecordThread.start();
                return true;
            }
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
            this.apiResult += "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState();
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects != null) {
                webRtcAudioEffects.release();
            }
            releaseAudioResources();
            return false;
        } catch (IllegalStateException e) {
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
            this.apiResult += "AudioRecord.startRecording failed: " + e.getMessage();
            releaseAudioResources();
            return false;
        }
    }

    private boolean stopRecording() {
        this.apiResult = "StopRecording:";
        RXLogging.i(TAG, "StopRecording:");
        AudioRecordThread audioRecordThread = this.audioThread;
        if (audioRecordThread != null) {
            audioRecordThread.stopThread();
            if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
                RXLogging.e(TAG, "Join of AudioRecordJavaThread timed out");
                WebRtcAudioUtils.logAudioState(TAG);
                this.apiResult += "Join of AudioRecordJavaThread timed out";
            }
            this.audioThread = null;
        }
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            webRtcAudioEffects.release();
        }
        releaseAudioResources();
        RXLogging.i(TAG, "stopRecording release done.");
        return true;
    }
}
