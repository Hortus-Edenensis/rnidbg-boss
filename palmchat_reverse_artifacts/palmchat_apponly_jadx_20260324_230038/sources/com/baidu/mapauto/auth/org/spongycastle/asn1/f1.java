package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.ss.android.ttvecamera.TELogUtils;
import java.io.IOException;
import kotlin.UByte;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class f1 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3875a;

    public f1(byte[] bArr) {
        this.f3875a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f3875a, 12);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return u1.a(this.f3875a.length) + 1 + this.f3875a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f3875a);
    }

    public final String toString() {
        char c;
        byte[] bArr = this.f3875a;
        int i = com.baidu.mapauto.auth.org.spongycastle.util.d.f3917a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            i4++;
            byte b = bArr[i3];
            if ((b & 240) == 240) {
                i4++;
                i3 += 4;
            } else {
                i3 = (b & 224) == 224 ? i3 + 3 : (b & 192) == 192 ? i3 + 2 : i3 + 1;
            }
        }
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if ((b2 & 240) == 240) {
                int i6 = (((((b2 & 3) << 18) | ((bArr[i2 + 1] & Utf8.REPLACEMENT_BYTE) << 12)) | ((bArr[i2 + 2] & Utf8.REPLACEMENT_BYTE) << 6)) | (bArr[i2 + 3] & Utf8.REPLACEMENT_BYTE)) - 65536;
                char c2 = (char) ((i6 >> 10) | 55296);
                c = (char) ((i6 & 1023) | Utf8.LOG_SURROGATE_HEADER);
                cArr[i5] = c2;
                i2 += 4;
                i5++;
            } else if ((b2 & 224) == 224) {
                c = (char) (((b2 & 15) << 12) | ((bArr[i2 + 1] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i2 + 2] & Utf8.REPLACEMENT_BYTE));
                i2 += 3;
            } else if ((b2 & 208) == 208 || (b2 & 192) == 192) {
                int i7 = (b2 & TELogUtils.DEBUG_LEVEL_V) << 6;
                byte b3 = bArr[i2 + 1];
                c = (char) (i7 | (b3 & Utf8.REPLACEMENT_BYTE));
                i2 += 2;
            } else {
                c = (char) (b2 & UByte.MAX_VALUE);
                i2++;
            }
            cArr[i5] = c;
            i5++;
        }
        return new String(cArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof f1) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f3875a, ((f1) rVar).f3875a);
        }
        return false;
    }
}
