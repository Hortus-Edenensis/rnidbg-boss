package com.bytedance.sdk.component.panglearmor.u.nr;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx {
    public static nr u(RandomAccessFile randomAccessFile, long j, long j2) {
        return u(randomAccessFile.getChannel(), j, j2);
    }

    public static nr u(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new b(fileChannel, j, j2);
    }
}
