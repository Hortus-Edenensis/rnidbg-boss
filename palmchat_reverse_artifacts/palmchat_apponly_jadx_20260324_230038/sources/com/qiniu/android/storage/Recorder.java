package com.qiniu.android.storage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface Recorder {
    void del(String str);

    byte[] get(String str);

    String getFileName();

    void set(String str, byte[] bArr);
}
