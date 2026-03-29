package com.qiniu.android.storage;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
abstract class UploadSource {
    static final long UnknownSourceSize = -1;

    public abstract void close();

    public abstract boolean couldReloadSource();

    public abstract String getFileName();

    public abstract String getId();

    public abstract long getSize();

    public abstract String getSourceType();

    public abstract byte[] readData(int i, long j) throws IOException;

    public abstract boolean reloadSource();
}
