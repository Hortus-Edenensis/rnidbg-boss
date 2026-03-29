package com.zenmen.palmchat.fileupload.blockupload;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface CancellationHandler {

    /* JADX INFO: compiled from: SearchBox */
    public static class CancellationException extends IOException {
    }

    void cancel();

    boolean isCancelled();
}
