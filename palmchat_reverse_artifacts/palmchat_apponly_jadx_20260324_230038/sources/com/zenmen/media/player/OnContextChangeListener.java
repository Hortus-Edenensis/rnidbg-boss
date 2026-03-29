package com.zenmen.media.player;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface OnContextChangeListener {
    void onContextArrived(int i, int i2);

    void onContextEOS(int i);

    void onContextError(int i, int i2);

    void onContextFirstFrame(int i);

    void onContextStarted(int i);

    void onContextStoped(int i);
}
