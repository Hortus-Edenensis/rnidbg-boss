package com.tencent.matrix.trace.listeners;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IDefaultConfig {
    String getAnrTraceFilePath();

    String getPrintTraceFilePath();

    boolean isAnrTraceEnable();

    boolean isAppMethodBeatEnable();

    boolean isDebug();

    boolean isDevEnv();

    boolean isEvilMethodTraceEnable();

    boolean isFPSEnable();

    boolean isIdleHandlerEnable();

    boolean isMainThreadPriorityTraceEnable();

    boolean isSignalAnrTraceEnable();
}
