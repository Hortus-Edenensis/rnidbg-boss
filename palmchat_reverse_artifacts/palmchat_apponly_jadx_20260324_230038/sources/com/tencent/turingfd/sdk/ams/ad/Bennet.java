package com.tencent.turingfd.sdk.ams.ad;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Bennet extends Eridanus {
    public static byte[] k = null;
    public static Map<String, String> l = null;
    public static final /* synthetic */ boolean m = true;
    public byte[] g;
    public Map<String, String> i;
    public Map<String, String> j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f10661a = 0;
    public byte b = 0;
    public int c = 0;
    public int d = 0;
    public String e = null;
    public String f = null;
    public int h = 0;

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Draco draco) {
        draco.a(this.f10661a, 1);
        draco.a(this.b, 2);
        draco.a(this.c, 3);
        draco.a(this.d, 4);
        draco.a(this.e, 5);
        draco.a(this.f, 6);
        draco.a(this.g, 7);
        draco.a(this.h, 8);
        draco.a((Map) this.i, 9);
        draco.a((Map) this.j, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        Bennet bennet = (Bennet) obj;
        Integer num = 1;
        return Equuleus.a(1, (int) bennet.f10661a) && Equuleus.a(1, (int) bennet.b) && Equuleus.a(1, bennet.c) && Equuleus.a(1, bennet.d) && num.equals(bennet.e) && num.equals(bennet.f) && num.equals(bennet.g) && Equuleus.a(1, bennet.h) && num.equals(bennet.i) && num.equals(bennet.j);
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Dorado dorado) {
        String str;
        try {
            this.f10661a = dorado.a(this.f10661a, 1, true);
            this.b = dorado.a(this.b, 2, true);
            this.c = dorado.a(this.c, 3, true);
            this.d = dorado.a(this.d, 4, true);
            this.e = dorado.b(5, true);
            this.f = dorado.b(6, true);
            if (k == null) {
                k = new byte[]{0};
            }
            this.g = dorado.a(7, true);
            this.h = dorado.a(this.h, 8, true);
            if (l == null) {
                HashMap map = new HashMap();
                l = map;
                map.put("", "");
            }
            this.i = (Map) dorado.a(l, 9, true);
            if (l == null) {
                HashMap map2 = new HashMap();
                l = map2;
                map2.put("", "");
            }
            this.j = (Map) dorado.a(l, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder sbA = Banana.a("RequestPacket decode error ");
            byte[] bArr = this.g;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    int i2 = i * 2;
                    char[] cArr2 = Orange.f10729a;
                    cArr[i2 + 1] = cArr2[b & 15];
                    cArr[i2 + 0] = cArr2[((byte) (b >>> 4)) & 15];
                }
                str = new String(cArr);
            }
            sbA.append(str);
            printStream.println(sbA.toString());
            throw new RuntimeException(e);
        }
    }
}
