package com.tencent.matrix.trace.tracer;

import com.tencent.matrix.listeners.IAppForeground;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITracer extends IAppForeground {
    boolean isAlive();

    void onCloseTrace();

    void onStartTrace();
}
