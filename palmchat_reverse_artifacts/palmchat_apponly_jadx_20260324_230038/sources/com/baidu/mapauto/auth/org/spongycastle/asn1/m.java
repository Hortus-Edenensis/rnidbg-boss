package com.baidu.mapauto.auth.org.spongycastle.asn1;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class m extends r {
    public static final ConcurrentHashMap c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3887a;
    public byte[] b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3888a;
        public final byte[] b;

        public a(byte[] bArr) {
            this.f3888a = com.baidu.mapauto.auth.org.spongycastle.util.a.b(bArr);
            this.b = bArr;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.b, ((a) obj).b);
            }
            return false;
        }

        public final int hashCode() {
            return this.f3888a;
        }
    }

    public m(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        BigInteger bigIntegerShiftLeft = null;
        long j = 0;
        for (int i = 0; i != bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (i2 & 127));
                if ((i2 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j) : bigIntegerShiftLeft).or(BigInteger.valueOf(i2 & 127));
                if ((i2 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.f3887a = stringBuffer.toString();
        this.b = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i = iBitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & ByteCompanionObject.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int length = i().length;
        return u1.a(length) + 1 + length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return this.f3887a.hashCode();
    }

    public final synchronized byte[] i() {
        String strSubstring;
        int i;
        String strSubstring2;
        int i2;
        int i3;
        String strSubstring3;
        if (this.b == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String str = this.f3887a;
            int iIndexOf = str.indexOf(46, 0);
            if (iIndexOf == -1) {
                strSubstring = str.substring(0);
                i = -1;
            } else {
                strSubstring = str.substring(0, iIndexOf);
                i = iIndexOf + 1;
            }
            int i4 = Integer.parseInt(strSubstring) * 40;
            if (i == -1) {
                i2 = i;
                strSubstring2 = null;
            } else {
                int iIndexOf2 = str.indexOf(46, i);
                if (iIndexOf2 == -1) {
                    strSubstring2 = str.substring(i);
                    i2 = -1;
                } else {
                    strSubstring2 = str.substring(i, iIndexOf2);
                    i2 = iIndexOf2 + 1;
                }
            }
            int i5 = 18;
            if (strSubstring2.length() <= 18) {
                i3 = i2;
                long j = Long.parseLong(strSubstring2) + ((long) i4);
                byte[] bArr = new byte[9];
                bArr[8] = (byte) (((int) j) & 127);
                int i6 = 8;
                while (j >= 128) {
                    j >>= 7;
                    i6--;
                    bArr[i6] = (byte) ((((int) j) & 127) | 128);
                }
                byteArrayOutputStream.write(bArr, i6, 9 - i6);
            } else {
                i3 = i2;
                a(byteArrayOutputStream, new BigInteger(strSubstring2).add(BigInteger.valueOf(i4)));
            }
            int i7 = i3;
            while (true) {
                if (!(i7 != -1)) {
                    break;
                }
                if (i7 == -1) {
                    strSubstring3 = null;
                } else {
                    int iIndexOf3 = str.indexOf(46, i7);
                    if (iIndexOf3 == -1) {
                        strSubstring3 = str.substring(i7);
                        i7 = -1;
                    } else {
                        String strSubstring4 = str.substring(i7, iIndexOf3);
                        i7 = iIndexOf3 + 1;
                        strSubstring3 = strSubstring4;
                    }
                }
                if (strSubstring3.length() <= i5) {
                    long j2 = Long.parseLong(strSubstring3);
                    byte[] bArr2 = new byte[9];
                    bArr2[8] = (byte) (((int) j2) & 127);
                    int i8 = 8;
                    while (j2 >= 128) {
                        j2 >>= 7;
                        i8--;
                        bArr2[i8] = (byte) ((((int) j2) & 127) | 128);
                    }
                    byteArrayOutputStream.write(bArr2, i8, 9 - i8);
                } else {
                    a(byteArrayOutputStream, new BigInteger(strSubstring3));
                }
                i5 = 18;
            }
            this.b = byteArrayOutputStream.toByteArray();
        }
        return this.b;
    }

    public final String toString() {
        return this.f3887a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar == this) {
            return true;
        }
        if (rVar instanceof m) {
            return this.f3887a.equals(((m) rVar).f3887a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        byte[] bArrI = i();
        pVar.a(6);
        pVar.b(bArrI.length);
        pVar.f3892a.write(bArrI);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static m a(d dVar) {
        if (dVar == 0 || (dVar instanceof m)) {
            return (m) dVar;
        }
        if (dVar.c() instanceof m) {
            return (m) dVar.c();
        }
        if (dVar instanceof byte[]) {
            try {
                return (m) r.a((byte[]) dVar);
            } catch (IOException e) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("failed to construct object identifier from byte[]: ");
                sbA.append(e.getMessage());
                throw new IllegalArgumentException(sbA.toString());
            }
        }
        StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("illegal object in getInstance: ");
        sbA2.append(dVar.getClass().getName());
        throw new IllegalArgumentException(sbA2.toString());
    }
}
