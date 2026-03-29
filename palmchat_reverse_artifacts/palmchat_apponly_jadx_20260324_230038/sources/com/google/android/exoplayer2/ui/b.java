package com.google.android.exoplayer2.ui;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void h(b bVar, long j, boolean z);

        void q(b bVar, long j);

        void t(b bVar, long j);
    }

    void addListener(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setPosition(long j);
}
