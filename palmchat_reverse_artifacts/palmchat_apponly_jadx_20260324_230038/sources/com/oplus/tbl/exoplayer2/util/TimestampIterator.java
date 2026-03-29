package com.oplus.tbl.exoplayer2.util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface TimestampIterator {
    TimestampIterator copyOf();

    boolean hasNext();

    long next();
}
