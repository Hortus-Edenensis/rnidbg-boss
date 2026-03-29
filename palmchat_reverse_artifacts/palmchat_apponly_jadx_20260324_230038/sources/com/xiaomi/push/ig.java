package com.xiaomi.push;

import com.xiaomi.push.hw;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ig extends hw {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;
    private static int e = 10485760;
    private static int f = 104857600;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends hw.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.hw.a, com.xiaomi.push.ic
        public ia a(ik ikVar) {
            ig igVar = new ig(ikVar, ((hw.a) this).f834a, this.b);
            int i = ((hw.a) this).f11639a;
            if (i != 0) {
                igVar.b(i);
            }
            return igVar;
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }
    }

    public ig(ik ikVar, boolean z, boolean z2) {
        super(ikVar, z, z2);
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public hz mo629a() throws hu {
        byte bA = a();
        byte bA2 = a();
        int iMo625a = mo625a();
        if (iMo625a <= b) {
            return new hz(bA, bA2, iMo625a);
        }
        throw new ib(3, "Thrift map size " + iMo625a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public hy mo628a() throws hu {
        byte bA = a();
        int iMo625a = mo625a();
        if (iMo625a <= c) {
            return new hy(bA, iMo625a);
        }
        throw new ib(3, "Thrift list size " + iMo625a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public ie mo630a() throws hu {
        byte bA = a();
        int iMo625a = mo625a();
        if (iMo625a <= d) {
            return new ie(bA, iMo625a);
        }
        throw new ib(3, "Thrift set size " + iMo625a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public String mo632a() throws hu {
        int iMo625a = mo625a();
        if (iMo625a <= e) {
            if (((ia) this).f11644a.b() >= iMo625a) {
                try {
                    String str = new String(((ia) this).f11644a.a(), ((ia) this).f11644a.a_(), iMo625a, "UTF-8");
                    ((ia) this).f11644a.a(iMo625a);
                    return str;
                } catch (UnsupportedEncodingException unused) {
                    throw new hu("JVM DOES NOT SUPPORT UTF-8");
                }
            }
            return a(iMo625a);
        }
        throw new ib(3, "Thrift string size " + iMo625a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo633a() throws hu {
        int iMo625a = mo625a();
        if (iMo625a <= f) {
            c(iMo625a);
            if (((ia) this).f11644a.b() >= iMo625a) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(((ia) this).f11644a.a(), ((ia) this).f11644a.a_(), iMo625a);
                ((ia) this).f11644a.a(iMo625a);
                return byteBufferWrap;
            }
            byte[] bArr = new byte[iMo625a];
            ((ia) this).f11644a.b(bArr, 0, iMo625a);
            return ByteBuffer.wrap(bArr);
        }
        throw new ib(3, "Thrift binary size " + iMo625a + " out of range!");
    }
}
