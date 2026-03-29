package com.heytap.mcssdk.a;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b implements BinaryDecoder, BinaryEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6336a = 2;
    public static final int b = 76;
    public static final int c = 64;
    protected static final int d = 255;
    protected static final byte e = 61;
    private static final int m = 8192;
    protected final byte f = 61;
    protected final int g;
    protected byte[] h;
    protected int i;
    protected boolean j;
    protected int k;
    protected int l;
    private final int n;
    private final int o;
    private final int p;
    private int q;

    public b(int i, int i2, int i3, int i4) {
        this.n = i;
        this.o = i2;
        this.g = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.p = i4;
    }

    private void a() {
        byte[] bArr = this.h;
        if (bArr == null) {
            this.h = new byte[d()];
            this.i = 0;
            this.q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.h = bArr2;
        }
    }

    private void e() {
        this.h = null;
        this.i = 0;
        this.q = 0;
        this.k = 0;
        this.l = 0;
        this.j = false;
    }

    public abstract void a(byte[] bArr, int i, int i2);

    public abstract void b(byte[] bArr, int i, int i2);

    public boolean b() {
        return this.h != null;
    }

    public abstract boolean b(byte b2);

    public int c() {
        if (this.h != null) {
            return this.i - this.q;
        }
        return 0;
    }

    public int d() {
        return 8192;
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public String j(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String k(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || b(b2)) {
                return true;
            }
        }
        return false;
    }

    public long m(byte[] bArr) {
        int length = bArr.length;
        long j = ((long) (((length + r0) - 1) / this.n)) * ((long) this.o);
        int i = this.g;
        return i > 0 ? j + ((((((long) i) + j) - 1) / ((long) i)) * ((long) this.p)) : j;
    }

    public void a(int i) {
        byte[] bArr = this.h;
        if (bArr == null || bArr.length < this.i + i) {
            a();
        }
    }

    public boolean b(byte[] bArr, boolean z) {
        byte b2;
        for (int i = 0; i < bArr.length; i++) {
            if (!b(bArr[i]) && (!z || ((b2 = bArr[i]) != 61 && !c(b2)))) {
                return false;
            }
        }
        return true;
    }

    public int c(byte[] bArr, int i, int i2) {
        if (this.h == null) {
            return this.j ? -1 : 0;
        }
        int iMin = Math.min(c(), i2);
        System.arraycopy(this.h, this.q, bArr, i, iMin);
        int i3 = this.q + iMin;
        this.q = i3;
        if (i3 >= this.i) {
            this.h = null;
        }
        return iMin;
    }

    public boolean d(String str) {
        return b(StringUtils.getBytesUtf8(str), true);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        int i = this.i;
        byte[] bArr2 = new byte[i];
        c(bArr2, 0, i);
        return bArr2;
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        int i = this.i - this.q;
        byte[] bArr2 = new byte[i];
        c(bArr2, 0, i);
        return bArr2;
    }

    public static boolean c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    public byte[] c(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }
}
