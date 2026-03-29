package com.baidu.platform.comapi.bmsdk.style;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f4126a = new int[4];
    public int[] b;
    public int[] c;
    public int[] d;

    private static void a(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
    }

    private static void a(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    public static b a(byte[] bArr) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (byteBufferOrder.get() == 0) {
            return null;
        }
        b bVar = new b();
        bVar.b = new int[byteBufferOrder.get()];
        bVar.c = new int[byteBufferOrder.get()];
        bVar.d = new int[byteBufferOrder.get()];
        a(bVar.b.length);
        a(bVar.c.length);
        byteBufferOrder.getInt();
        byteBufferOrder.getInt();
        bVar.f4126a[0] = byteBufferOrder.getInt();
        bVar.f4126a[1] = byteBufferOrder.getInt();
        bVar.f4126a[2] = byteBufferOrder.getInt();
        bVar.f4126a[3] = byteBufferOrder.getInt();
        byteBufferOrder.getInt();
        a(bVar.b, byteBufferOrder);
        a(bVar.c, byteBufferOrder);
        a(bVar.d, byteBufferOrder);
        return bVar;
    }
}
