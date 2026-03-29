package com.qiniu.android.http;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface CancellationHandler {

    /* JADX INFO: compiled from: SearchBox */
    public static class CancellationException extends IOException {
    }

    boolean isCancelled();
}
