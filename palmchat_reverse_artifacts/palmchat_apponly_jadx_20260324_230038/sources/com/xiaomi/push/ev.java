package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f11555a = {80, 85, 83, 72};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte f418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f420a;
    private byte[] b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11556a = new c();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final d f421a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f421a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (!ev.m428a(bArr)) {
                return bArr;
            }
            ev evVarA = ev.a(bArr);
            return (evVarA.f418a == 0 || evVarA.f418a != bVar.a()) ? evVarA.b : bVar.a(evVarA.b, evVarA.f419a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements b {
        @Override // com.xiaomi.push.ev.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.ev.b
        public byte[] a(byte[] bArr, int i) throws Throwable {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bArr2;
                } catch (IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public ev(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
    }

    public ev(short s, byte b2, int i, byte[] bArr) {
        this.f420a = s;
        this.f418a = b2;
        this.f419a = i;
        this.b = bArr;
    }

    public static ev a(byte b2, int i, byte[] bArr) {
        return new ev(b2, i, bArr);
    }

    public static ev a(short s, byte b2, int i, byte[] bArr) {
        return new ev(s, b2, i, bArr);
    }

    public static ev a(byte[] bArr) {
        if (m428a(bArr)) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            byteBufferOrder.getInt();
            short s = byteBufferOrder.getShort();
            byte b2 = byteBufferOrder.get();
            int i = byteBufferOrder.getInt();
            byte[] bArr2 = new byte[byteBufferOrder.getInt()];
            byteBufferOrder.get(bArr2);
            return a(s, b2, i, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m428a(byte[] bArr) {
        byte[] bArr2 = f11555a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
