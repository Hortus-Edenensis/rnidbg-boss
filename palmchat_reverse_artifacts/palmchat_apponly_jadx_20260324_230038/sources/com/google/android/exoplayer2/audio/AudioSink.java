package com.google.android.exoplayer2.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.u;
import defpackage.bk4;
import defpackage.bn;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface AudioSink {

    /* JADX INFO: compiled from: SearchBox */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final com.google.android.exoplayer2.m format;
        public final boolean isRecoverable;

        public InitializationException(int i, int i2, int i3, int i4, com.google.android.exoplayer2.m mVar, boolean z, @Nullable Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed ");
            sb.append(i);
            sb.append(" ");
            sb.append("Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(")");
            sb.append(" ");
            sb.append(mVar);
            sb.append(z ? " (recoverable)" : "");
            super(sb.toString(), exc);
            this.audioTrackState = i;
            this.isRecoverable = z;
            this.format = mVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public UnexpectedDiscontinuityException(long j, long j2) {
            super("Unexpected audio track timestamp discontinuity: expected " + j2 + ", got " + j);
            this.actualPresentationTimeUs = j;
            this.expectedPresentationTimeUs = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class WriteException extends Exception {
        public final int errorCode;
        public final com.google.android.exoplayer2.m format;
        public final boolean isRecoverable;

        public WriteException(int i, com.google.android.exoplayer2.m mVar, boolean z) {
            super("AudioTrack write failed: " + i);
            this.isRecoverable = z;
            this.errorCode = i;
            this.format = mVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onAudioCapabilitiesChanged();

        void onAudioSinkError(Exception exc);

        void onOffloadBufferEmptying();

        void onOffloadBufferFull();

        void onPositionAdvancing(long j);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z);

        void onUnderrun(int i, long j, long j2);
    }

    boolean a(com.google.android.exoplayer2.m mVar);

    void b(u uVar);

    void c(com.google.android.exoplayer2.audio.a aVar);

    void d(bn bnVar);

    void disableTunneling();

    void e(a aVar);

    void enableTunnelingV21();

    void experimentalFlushWithoutAudioTrackRelease();

    int f(com.google.android.exoplayer2.m mVar);

    void flush();

    void g(@Nullable bk4 bk4Var);

    long getCurrentPositionUs(boolean z);

    u getPlaybackParameters();

    void h(com.google.android.exoplayer2.m mVar, int i, @Nullable int[] iArr) throws ConfigurationException;

    boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws WriteException, InitializationException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void release();

    void reset();

    void setAudioSessionId(int i);

    void setOutputStreamOffsetUs(long j);

    @RequiresApi(23)
    void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo);

    void setSkipSilenceEnabled(boolean z);

    void setVolume(float f);

    /* JADX INFO: compiled from: SearchBox */
    public static final class ConfigurationException extends Exception {
        public final com.google.android.exoplayer2.m format;

        public ConfigurationException(Throwable th, com.google.android.exoplayer2.m mVar) {
            super(th);
            this.format = mVar;
        }

        public ConfigurationException(String str, com.google.android.exoplayer2.m mVar) {
            super(str);
            this.format = mVar;
        }
    }
}
