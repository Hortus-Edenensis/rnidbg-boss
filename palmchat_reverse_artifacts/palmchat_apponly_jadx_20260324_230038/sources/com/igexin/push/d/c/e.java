package com.igexin.push.d.c;

import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7315a = 1944742139;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte n;
    public byte[] o;
    public int p;
    public int q;
    public int r;

    private int a() {
        int i = this.e | this.h | this.i | this.j;
        this.e = i;
        return i;
    }

    private int b() {
        int i = this.g | this.k | this.l | this.m | this.n;
        this.g = i;
        return i;
    }

    private void b(byte b) {
        this.g = b & UByte.MAX_VALUE;
        this.k = (byte) (b & 3);
        this.l = (byte) (b & 4);
        this.m = (byte) (b & 8);
        this.n = (byte) (b & 16);
    }

    public final void a(byte b) {
        this.e = b & UByte.MAX_VALUE;
        this.h = (byte) (b & 192);
        this.i = (byte) (b & 48);
        this.j = (byte) (b & 15);
    }
}
