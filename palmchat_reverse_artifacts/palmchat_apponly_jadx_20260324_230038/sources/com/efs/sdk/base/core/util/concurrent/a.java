package com.efs.sdk.base.core.util.concurrent;

import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HandlerThread f5599a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        f5599a = handlerThread;
        handlerThread.start();
    }
}
