package com.tencent.matrix.trace.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface BeatLifecycle {
    boolean isAlive();

    void onStart();

    void onStop();
}
