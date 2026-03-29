package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.w;
import defpackage.bk4;
import defpackage.d25;
import defpackage.tv4;
import defpackage.xe3;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface z extends w.b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onSleep();

        void onWakeup();
    }

    void c(m[] mVarArr, d25 d25Var, long j, long j2) throws ExoPlaybackException;

    void d(int i, bk4 bk4Var);

    void disable();

    void f(tv4 tv4Var, m[] mVarArr, d25 d25Var, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException;

    a0 getCapabilities();

    @Nullable
    xe3 getMediaClock();

    String getName();

    long getReadingPositionUs();

    int getState();

    @Nullable
    d25 getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void release();

    void render(long j, long j2) throws ExoPlaybackException;

    void reset();

    void resetPosition(long j) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException;

    void start() throws ExoPlaybackException;

    void stop();
}
