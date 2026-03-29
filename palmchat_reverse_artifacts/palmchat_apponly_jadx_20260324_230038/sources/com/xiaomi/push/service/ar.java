package com.xiaomi.push.service;

import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11730a = 8;
    private int d = -666;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f948a = new byte[256];
    private int c = 0;
    private int b = 0;

    public static int a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f948a[i2] = (byte) i2;
        }
        this.c = 0;
        this.b = 0;
        while (true) {
            int i3 = this.b;
            if (i3 >= i) {
                break;
            }
            int iA = ((this.c + a(this.f948a[i3])) + a(bArr[this.b % length])) % 256;
            this.c = iA;
            a(this.f948a, this.b, iA);
            this.b++;
        }
        if (i != 256) {
            this.d = ((this.c + a(this.f948a[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i4 = i - 1;
            sb.append(i4);
            sb.append(":");
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(" ");
                sb.append(a(this.f948a[i5]));
            }
            sb.append("   j_");
            sb.append(i4);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.c);
            sb.append("   j_");
            sb.append(i);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.d);
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i4);
            sb.append("]=");
            sb.append(a(this.f948a[this.c]));
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(a(this.f948a[this.d]));
            if (this.f948a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m74a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private void a() {
        this.c = 0;
        this.b = 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte m726a() {
        int i = (this.b + 1) % 256;
        this.b = i;
        int iA = (this.c + a(this.f948a[i])) % 256;
        this.c = iA;
        a(this.f948a, this.b, iA);
        byte[] bArr = this.f948a;
        return bArr[(a(bArr[this.b]) + a(this.f948a[this.c])) % 256];
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        ar arVar = new ar();
        arVar.a(bArr);
        arVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ arVar.m726a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i >= 0 && i <= bArr2.length && i + i2 <= bArr2.length) {
            if (z) {
                bArr3 = bArr2;
                i3 = i;
            } else {
                bArr3 = new byte[i2];
                i3 = 0;
            }
            ar arVar = new ar();
            arVar.a(bArr);
            arVar.a();
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ arVar.m726a());
            }
            return bArr3;
        }
        throw new IllegalArgumentException("start = " + i + " len = " + i2);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.ay.m185a(str));
    }

    public static byte[] a(String str, String str2) {
        byte[] bArrM185a = com.xiaomi.push.ay.m185a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[bArrM185a.length + 1 + bytes.length];
        for (int i = 0; i < bArrM185a.length; i++) {
            bArr[i] = bArrM185a[i];
        }
        bArr[bArrM185a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[bArrM185a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }
}
