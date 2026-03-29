package com.igexin.push.d.c;

import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class q extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7326a = 20;
    public int b;

    public q() {
        this.m = 20;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        if (bArr.length == 1) {
            this.b = bArr[0] & UByte.MAX_VALUE;
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        return null;
    }
}
