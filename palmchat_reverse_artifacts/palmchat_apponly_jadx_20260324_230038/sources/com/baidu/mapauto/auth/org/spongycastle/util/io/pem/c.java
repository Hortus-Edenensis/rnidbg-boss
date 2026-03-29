package com.baidu.mapauto.auth.org.spongycastle.util.io.pem;

import com.baidu.mapauto.auth.org.spongycastle.util.d;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends BufferedWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f3924a;

    public c(StringWriter stringWriter) {
        super(stringWriter);
        this.f3924a = new char[64];
        int i = d.f3917a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(b bVar) throws IOException {
        int i;
        byte[] byteArray;
        int length;
        char[] cArr;
        int i2;
        write("-----BEGIN RSA PUBLIC KEY-----");
        newLine();
        if (!bVar.f3923a.isEmpty()) {
            Iterator it = bVar.f3923a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).getClass();
                write((String) null);
                write(": ");
                write((String) null);
                newLine();
            }
            newLine();
        }
        byte[] bArr = bVar.b;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.b bVar2 = com.baidu.mapauto.auth.org.spongycastle.util.encoders.a.f3918a;
        int length2 = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((length2 + 2) / 3) * 4);
        try {
            bVar2.getClass();
            int i3 = length2 % 3;
            int i4 = length2 - i3;
            int i5 = 0;
            while (true) {
                i = 0 + i4;
                if (i5 >= i) {
                    break;
                }
                int i6 = bArr[i5] & UByte.MAX_VALUE;
                int i7 = bArr[i5 + 1] & UByte.MAX_VALUE;
                int i8 = bArr[i5 + 2] & UByte.MAX_VALUE;
                byteArrayOutputStream.write(bVar2.f3919a[(i6 >>> 2) & 63]);
                byteArrayOutputStream.write(bVar2.f3919a[((i6 << 4) | (i7 >>> 4)) & 63]);
                byteArrayOutputStream.write(bVar2.f3919a[((i7 << 2) | (i8 >>> 6)) & 63]);
                byteArrayOutputStream.write(bVar2.f3919a[i8 & 63]);
                i5 += 3;
            }
            if (i3 == 1) {
                int i9 = bArr[i] & UByte.MAX_VALUE;
                byteArrayOutputStream.write(bVar2.f3919a[(i9 >>> 2) & 63]);
                byteArrayOutputStream.write(bVar2.f3919a[(i9 << 4) & 63]);
                byteArrayOutputStream.write(61);
            } else {
                if (i3 != 2) {
                    int i10 = i4 / 3;
                    byteArray = byteArrayOutputStream.toByteArray();
                    length = 0;
                    while (length < byteArray.length) {
                        int i11 = 0;
                        while (true) {
                            cArr = this.f3924a;
                            if (i11 == cArr.length || (i2 = length + i11) >= byteArray.length) {
                                break;
                            }
                            cArr[i11] = (char) byteArray[i2];
                            i11++;
                        }
                        write(cArr, 0, i11);
                        newLine();
                        length += this.f3924a.length;
                    }
                    write("-----END RSA PUBLIC KEY-----");
                    newLine();
                }
                int i12 = bArr[i] & UByte.MAX_VALUE;
                int i13 = bArr[i + 1] & UByte.MAX_VALUE;
                byteArrayOutputStream.write(bVar2.f3919a[(i12 >>> 2) & 63]);
                byteArrayOutputStream.write(bVar2.f3919a[((i12 << 4) | (i13 >>> 4)) & 63]);
                byteArrayOutputStream.write(bVar2.f3919a[(i13 << 2) & 63]);
            }
            byteArrayOutputStream.write(61);
            int i102 = i4 / 3;
            byteArray = byteArrayOutputStream.toByteArray();
            length = 0;
            while (length < byteArray.length) {
            }
            write("-----END RSA PUBLIC KEY-----");
            newLine();
        } catch (Exception e) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("exception encoding base64 string: ");
            sbA.append(e.getMessage());
            throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(sbA.toString(), e);
        }
    }
}
