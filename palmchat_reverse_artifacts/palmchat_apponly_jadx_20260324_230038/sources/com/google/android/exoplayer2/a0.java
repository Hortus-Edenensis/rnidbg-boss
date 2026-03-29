package com.google.android.exoplayer2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface a0 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(z zVar);
    }

    int a(m mVar) throws ExoPlaybackException;

    void clearListener();

    void e(a aVar);

    String getName();

    int getTrackType();

    int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException;
}
