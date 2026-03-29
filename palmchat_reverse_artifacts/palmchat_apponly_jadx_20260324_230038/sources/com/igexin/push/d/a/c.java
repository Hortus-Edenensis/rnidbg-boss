package com.igexin.push.d.a;

import com.igexin.c.a.b.a.a.h;
import com.igexin.c.a.b.d;
import com.igexin.c.a.b.g;
import com.igexin.push.d.c.e;
import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7306a = "com.igexin.push.d.a.c";
    public static int b = -1;
    private byte[] g;

    private c(String str) {
        super(str, (byte) 0);
    }

    private static byte a(h hVar) throws IOException {
        return (byte) b(hVar, 1);
    }

    private static int b(h hVar, int i) throws IOException {
        byte[] bArrA = a(hVar, i);
        if (i == 1) {
            return bArrA[0] & UByte.MAX_VALUE;
        }
        if (i == 2) {
            return g.a(bArrA, 0);
        }
        if (i == 4) {
            return g.c(bArrA, 0);
        }
        return 0;
    }

    private static int c(h hVar) throws IOException {
        return b(hVar, 4);
    }

    public static d a() {
        c cVar = new c("socketProtocol");
        new a(com.heytap.mcssdk.constant.b.y, cVar);
        return cVar;
    }

    private Object b(h hVar, e eVar) throws Exception {
        byte b2;
        if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
            this.g = a(hVar, b2);
        }
        if (eVar.f == 0) {
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] bArrA = a(hVar, 3);
        short sA = g.a(bArrA, 0);
        int i = bArrA[2] & UByte.MAX_VALUE;
        com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
        aVar2.f7312a = sA;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        if (i != 26) {
            com.igexin.c.a.c.a.a(f7306a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
            return null;
        }
        if (sA > 0) {
            byte[] bArrA2 = a(hVar, sA);
            if (eVar.i == 48) {
                byte[] bArr = this.g;
                bArrA2 = com.igexin.c.a.a.a.a(bArrA2, bArr == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr));
            }
            byte b3 = eVar.h;
            if (b3 == -128) {
                bArrA2 = g.b(bArrA2);
            } else if (b3 != 0) {
                return null;
            }
            aVar2.a(bArrA2);
        }
        return aVar2;
    }

    private static e a(com.igexin.push.d.c.a aVar) {
        int i;
        e eVar = new e();
        eVar.b = e.f7315a;
        eVar.a(aVar.c);
        eVar.f = aVar.b > 0 ? 1 : 0;
        eVar.d = 7;
        eVar.c = 11;
        eVar.g = aVar.d;
        int length = 11 + com.igexin.push.g.g.c().length;
        eVar.c = length;
        if (aVar.f7312a <= 0) {
            if (eVar.i == 0) {
                eVar.p = 0;
                i = length + 0;
            }
            com.igexin.c.a.b.e.c();
            return eVar;
        }
        eVar.q = com.igexin.push.g.g.e();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        eVar.r = iCurrentTimeMillis;
        byte[] bArrA = com.igexin.push.g.g.a(aVar, eVar.q, iCurrentTimeMillis);
        eVar.o = bArrA;
        int length2 = bArrA.length;
        eVar.p = length2;
        i = eVar.c + length2;
        eVar.c = i;
        com.igexin.c.a.b.e.c();
        return eVar;
    }

    @Override // com.igexin.c.a.b.d
    public final Object b(Object obj) throws Exception {
        com.igexin.push.d.c.a aVar;
        byte b2;
        h hVar = obj instanceof h ? (h) obj : null;
        if (hVar == null) {
            String str = f7306a;
            com.igexin.c.a.c.a.a(str, "syncIns is null");
            com.igexin.c.a.c.a.a(str + "|syncIns is null", new Object[0]);
            return null;
        }
        byte[] bArrA = a(hVar, 8);
        if (g.c(bArrA, 0) != 1944742139) {
            return null;
        }
        e eVar = new e();
        eVar.c = bArrA[4] & UByte.MAX_VALUE;
        eVar.d = bArrA[5] & UByte.MAX_VALUE;
        eVar.a(bArrA[6]);
        eVar.f = bArrA[7] & UByte.MAX_VALUE;
        int i = eVar.d;
        if (i == 7) {
            if (eVar.i == 48) {
                com.igexin.c.a.c.a.a(f7306a, "decodeAes, encryptType = 0x30, return");
                return null;
            }
            byte b3 = (byte) b(hVar, 1);
            if (b3 > 0) {
                a(hVar, b3);
            }
            eVar.g = (byte) b(hVar, 1);
            byte b4 = (byte) b(hVar, 1);
            eVar.p = b4;
            if (b4 > 0) {
                eVar.o = a(hVar, b4);
            }
            if (eVar.f != 0) {
                byte[] bArrA2 = a(hVar, 11);
                int iC = g.c(bArrA2, 0);
                if (iC <= b) {
                    b = -1;
                    throw new Exception("server packetId can't be less than previous");
                }
                b = iC;
                int iC2 = g.c(bArrA2, 4);
                short sA = g.a(bArrA2, 8);
                int i2 = bArrA2[10] & UByte.MAX_VALUE;
                com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
                aVar2.f7312a = sA;
                aVar2.b = (byte) i2;
                aVar2.f = eVar.d;
                aVar2.g = eVar.i;
                if (sA > 0) {
                    byte[] bArrA3 = a(hVar, sA);
                    byte b5 = eVar.i;
                    if (b5 == 16) {
                        bArrA3 = com.igexin.push.g.g.d(bArrA3, com.igexin.push.g.g.b(g.b(iC2)));
                    } else if (b5 == 32) {
                        if (i2 != 26) {
                            return null;
                        }
                        com.igexin.c.a.c.a.a(f7306a, "decodeAes, encryptType = 0x20, special");
                        bArrA3 = com.igexin.push.g.g.e(bArrA3, g.b(iC2));
                    } else if (b5 != 0) {
                        return null;
                    }
                    byte b6 = eVar.h;
                    if (b6 == -128) {
                        bArrA3 = g.b(bArrA3);
                    } else if (b6 != 0) {
                        return null;
                    }
                    aVar2.a(bArrA3);
                    if (!Arrays.equals(eVar.o, com.igexin.push.g.g.a(aVar2, iC, iC2))) {
                        String str2 = f7306a;
                        com.igexin.c.a.c.a.a(str2, "decode signature error!!!!");
                        com.igexin.c.a.c.a.a(str2 + "|decode signature error!!!!", new Object[0]);
                        return null;
                    }
                } else if (sA < 0) {
                    String str3 = f7306a;
                    com.igexin.c.a.c.a.a(str3, "data len < 0, error");
                    com.igexin.c.a.c.a.a(str3 + "|data len < 0, error", new Object[0]);
                    return null;
                }
                return aVar2;
            }
            aVar = new com.igexin.push.d.c.a();
        } else {
            if (i != 1) {
                String str4 = f7306a;
                com.igexin.c.a.c.a.a(str4, "server socket resp version = " + eVar.d + ", not support!!!");
                com.igexin.c.a.c.a.a(str4 + "|server socket resp version = " + eVar.d + ", not support !!!", new Object[0]);
                return null;
            }
            if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
                this.g = a(hVar, b2);
            }
            if (eVar.f != 0) {
                byte[] bArrA4 = a(hVar, 3);
                short sA2 = g.a(bArrA4, 0);
                int i3 = bArrA4[2] & UByte.MAX_VALUE;
                com.igexin.push.d.c.a aVar3 = new com.igexin.push.d.c.a();
                aVar3.f7312a = sA2;
                aVar3.b = (byte) i3;
                aVar3.f = eVar.d;
                if (i3 != 26) {
                    com.igexin.c.a.c.a.a(f7306a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
                    return null;
                }
                if (sA2 > 0) {
                    byte[] bArrA5 = a(hVar, sA2);
                    if (eVar.i == 48) {
                        byte[] bArr = this.g;
                        bArrA5 = com.igexin.c.a.a.a.a(bArrA5, bArr == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr));
                    }
                    byte b7 = eVar.h;
                    if (b7 == -128) {
                        bArrA5 = g.b(bArrA5);
                    } else if (b7 != 0) {
                        return null;
                    }
                    aVar3.a(bArrA5);
                }
                return aVar3;
            }
            aVar = new com.igexin.push.d.c.a();
        }
        aVar.f = eVar.d;
        aVar.b = (byte) 0;
        return aVar;
    }

    private static Object a(h hVar, e eVar) throws Exception {
        if (eVar.i == 48) {
            com.igexin.c.a.c.a.a(f7306a, "decodeAes, encryptType = 0x30, return");
            return null;
        }
        byte b2 = (byte) b(hVar, 1);
        if (b2 > 0) {
            a(hVar, b2);
        }
        eVar.g = (byte) b(hVar, 1);
        byte b3 = (byte) b(hVar, 1);
        eVar.p = b3;
        if (b3 > 0) {
            eVar.o = a(hVar, b3);
        }
        if (eVar.f == 0) {
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] bArrA = a(hVar, 11);
        int iC = g.c(bArrA, 0);
        if (iC <= b) {
            b = -1;
            throw new Exception("server packetId can't be less than previous");
        }
        b = iC;
        int iC2 = g.c(bArrA, 4);
        short sA = g.a(bArrA, 8);
        int i = bArrA[10] & UByte.MAX_VALUE;
        com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
        aVar2.f7312a = sA;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        aVar2.g = eVar.i;
        if (sA > 0) {
            byte[] bArrA2 = a(hVar, sA);
            byte b4 = eVar.i;
            if (b4 == 16) {
                bArrA2 = com.igexin.push.g.g.d(bArrA2, com.igexin.push.g.g.b(g.b(iC2)));
            } else if (b4 == 32) {
                if (i != 26) {
                    return null;
                }
                com.igexin.c.a.c.a.a(f7306a, "decodeAes, encryptType = 0x20, special");
                bArrA2 = com.igexin.push.g.g.e(bArrA2, g.b(iC2));
            } else if (b4 != 0) {
                return null;
            }
            byte b5 = eVar.h;
            if (b5 == -128) {
                bArrA2 = g.b(bArrA2);
            } else if (b5 != 0) {
                return null;
            }
            aVar2.a(bArrA2);
            if (!Arrays.equals(eVar.o, com.igexin.push.g.g.a(aVar2, iC, iC2))) {
                String str = f7306a;
                com.igexin.c.a.c.a.a(str, "decode signature error!!!!");
                com.igexin.c.a.c.a.a(str + "|decode signature error!!!!", new Object[0]);
                return null;
            }
        } else if (sA < 0) {
            String str2 = f7306a;
            com.igexin.c.a.c.a.a(str2, "data len < 0, error");
            com.igexin.c.a.c.a.a(str2 + "|data len < 0, error", new Object[0]);
            return null;
        }
        return aVar2;
    }

    private static short b(h hVar) throws IOException {
        return (short) b(hVar, 2);
    }

    @Override // com.igexin.c.a.b.d
    public final Object a(Object obj) throws Exception {
        int iA;
        byte[] bArr = null;
        if (obj instanceof com.igexin.push.d.c.a) {
            com.igexin.push.d.c.a aVar = (com.igexin.push.d.c.a) obj;
            e eVar = new e();
            eVar.b = e.f7315a;
            eVar.a(aVar.c);
            eVar.f = aVar.b > 0 ? 1 : 0;
            eVar.d = 7;
            eVar.c = 11;
            eVar.g = aVar.d;
            int length = com.igexin.push.g.g.c().length + 11;
            eVar.c = length;
            if (aVar.f7312a > 0) {
                eVar.q = com.igexin.push.g.g.e();
                int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                eVar.r = iCurrentTimeMillis;
                byte[] bArrA = com.igexin.push.g.g.a(aVar, eVar.q, iCurrentTimeMillis);
                eVar.o = bArrA;
                int length2 = bArrA.length;
                eVar.p = length2;
                eVar.c += length2;
            } else if (eVar.i == 0) {
                eVar.p = 0;
                eVar.c = length + 0;
            }
            com.igexin.c.a.b.e.c();
            if (aVar.b > 0 && aVar.f7312a > 0) {
                if ((eVar.h & 192) == 128) {
                    aVar.a(g.a(aVar.e));
                }
                byte b2 = eVar.i;
                if ((b2 & 48) == 16) {
                    byte[] bArrB = com.igexin.push.g.g.b(g.b(eVar.r));
                    if ((eVar.g & 16) != 16) {
                        aVar.a(com.igexin.push.g.g.c(aVar.e, bArrB));
                    }
                } else if ((b2 & 48) != 0) {
                    if ((b2 & 48) == 48) {
                        String str = f7306a;
                        com.igexin.c.a.c.a.a(str, "encry type = 0x30 not support");
                        com.igexin.c.a.c.a.a(str + "|encry type = 0x30 not support", new Object[0]);
                        return null;
                    }
                    if ((b2 & 48) != 32) {
                        String str2 = f7306a;
                        com.igexin.c.a.c.a.a(str2, "encry type = " + (eVar.i & 48) + " not support");
                        com.igexin.c.a.c.a.a(str2 + "|encry type = " + (eVar.i & 48) + " not support", new Object[0]);
                        return null;
                    }
                    String str3 = f7306a;
                    com.igexin.c.a.c.a.a(str3, "encry type = 0x20 reserved");
                    com.igexin.c.a.c.a.a(str3 + "|encry type = 0x20 reserved", new Object[0]);
                }
            }
            bArr = new byte[eVar.c + (aVar.b > 0 ? aVar.f7312a + 11 : 0)];
            g.a(e.f7315a, bArr, 0);
            bArr[4] = (byte) eVar.c;
            bArr[5] = (byte) eVar.d;
            int i = eVar.e | eVar.h | eVar.i | eVar.j;
            eVar.e = i;
            bArr[6] = (byte) i;
            bArr[7] = (byte) eVar.f;
            byte[] bArrC = com.igexin.push.g.g.c();
            bArr[8] = (byte) bArrC.length;
            int iA2 = g.a(bArrC, bArr, 9, bArrC.length) + 9;
            int i2 = eVar.g | eVar.k | eVar.l | eVar.m | eVar.n;
            eVar.g = i2;
            bArr[iA2] = (byte) i2;
            int i3 = iA2 + 1;
            if (aVar.f7312a > 0) {
                int i4 = eVar.p;
                bArr[i3] = (byte) i4;
                int i5 = i3 + 1;
                iA = i5 + g.a(eVar.o, bArr, i5, i4);
            } else {
                bArr[i3] = 0;
                iA = i3 + 1;
            }
            if (aVar.b > 0) {
                int iA3 = iA + g.a(eVar.q, bArr, iA);
                int iA4 = iA3 + g.a(eVar.r, bArr, iA3);
                int iB = iA4 + g.b(aVar.f7312a, bArr, iA4);
                bArr[iB] = aVar.b;
                int i6 = iB + 1;
                int i7 = aVar.f7312a;
                if (i7 > 0) {
                    g.a(aVar.e, bArr, i6, i7);
                }
            }
        }
        return bArr;
    }

    private static byte[] a(h hVar, int i) throws IOException {
        byte[] bArr = new byte[i];
        hVar.a(bArr);
        return bArr;
    }
}
