package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hs extends ByteArrayOutputStream {
    public hs(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m623a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public hs() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }
}
