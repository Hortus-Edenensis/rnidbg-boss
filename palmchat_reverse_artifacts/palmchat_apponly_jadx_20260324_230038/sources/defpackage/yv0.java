package defpackage;

import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class yv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f22284a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] b;
    public static final char[] c;
    public static final char[] d;
    public static final char[] e;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22285a;

        static {
            int[] iArr = new int[b.values().length];
            f22285a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22285a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22285a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22285a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22285a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', Typography.less, '=', Typography.greater, '?', '@', '[', '\\', ']', '^', '_'};
        b = cArr;
        c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = cArr;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    public static nw0 a(byte[] bArr) throws FormatException {
        mt mtVar = new mt(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVarC = b.ASCII_ENCODE;
        do {
            b bVar = b.ASCII_ENCODE;
            if (bVarC == bVar) {
                bVarC = c(mtVar, sb, sb2);
            } else {
                int i = a.f22285a[bVarC.ordinal()];
                if (i == 1) {
                    e(mtVar, sb);
                } else if (i == 2) {
                    g(mtVar, sb);
                } else if (i == 3) {
                    b(mtVar, sb);
                } else if (i == 4) {
                    f(mtVar, sb);
                } else {
                    if (i != 5) {
                        throw FormatException.getFormatInstance();
                    }
                    d(mtVar, sb, arrayList);
                }
                bVarC = bVar;
            }
            if (bVarC == b.PAD_ENCODE) {
                break;
            }
        } while (mtVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new nw0(bArr, string, arrayList, null);
    }

    public static void b(mt mtVar, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        while (mtVar.a() != 8 && (iD = mtVar.d(8)) != 254) {
            h(iD, mtVar.d(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append(Typography.greater);
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else {
                    if (i2 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    sb.append((char) (i2 + 51));
                }
            }
            if (mtVar.a() <= 0) {
                return;
            }
        }
    }

    public static b c(mt mtVar, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int iD = mtVar.d(8);
            if (iD == 0) {
                throw FormatException.getFormatInstance();
            }
            if (iD <= 128) {
                if (z) {
                    iD += 128;
                }
                sb.append((char) (iD - 1));
                return b.ASCII_ENCODE;
            }
            if (iD == 129) {
                return b.PAD_ENCODE;
            }
            if (iD <= 229) {
                int i = iD - 130;
                if (i < 10) {
                    sb.append('0');
                }
                sb.append(i);
            } else {
                if (iD == 230) {
                    return b.C40_ENCODE;
                }
                if (iD == 231) {
                    return b.BASE256_ENCODE;
                }
                if (iD == 232) {
                    sb.append((char) 29);
                } else if (iD != 233 && iD != 234) {
                    if (iD == 235) {
                        z = true;
                    } else if (iD == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (iD == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (iD == 238) {
                            return b.ANSIX12_ENCODE;
                        }
                        if (iD == 239) {
                            return b.TEXT_ENCODE;
                        }
                        if (iD == 240) {
                            return b.EDIFACT_ENCODE;
                        }
                        if (iD != 241 && iD >= 242 && (iD != 254 || mtVar.a() != 0)) {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
            }
        } while (mtVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    public static void d(mt mtVar, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int iC = mtVar.c() + 1;
        int i = iC + 1;
        int i2 = i(mtVar.d(8), iC);
        if (i2 == 0) {
            i2 = mtVar.a() / 8;
        } else if (i2 >= 250) {
            i2 = ((i2 - 249) * 250) + i(mtVar.d(8), i);
            i++;
        }
        if (i2 < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            if (mtVar.a() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i3] = (byte) i(mtVar.d(8), i);
            i3++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: " + e2);
        }
    }

    public static void e(mt mtVar, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (mtVar.a() != 8 && (iD = mtVar.d(8)) != 254) {
            h(iD, mtVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = b;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i = 0;
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z) {
                                sb.append((char) (i3 + 224));
                                z = false;
                                i = 0;
                            } else {
                                sb.append((char) (i3 + 96));
                                i = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                        i = 0;
                    } else {
                        sb.append((char) i3);
                        i = 0;
                    }
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr2 = f22284a;
                    if (i3 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c3 = cArr2[i3];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (mtVar.a() <= 0) {
                return;
            }
        }
    }

    public static void f(mt mtVar, StringBuilder sb) {
        while (mtVar.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int iD = mtVar.d(6);
                if (iD == 31) {
                    int iB = 8 - mtVar.b();
                    if (iB != 8) {
                        mtVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                sb.append((char) iD);
            }
            if (mtVar.a() <= 0) {
                return;
            }
        }
    }

    public static void g(mt mtVar, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (mtVar.a() != 8 && (iD = mtVar.d(8)) != 254) {
            h(iD, mtVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = d;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i = 0;
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = e;
                            if (i3 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c3 = cArr2[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                                i = 0;
                            } else {
                                sb.append(c3);
                                i = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                        i = 0;
                    } else {
                        sb.append((char) i3);
                        i = 0;
                    }
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr3 = c;
                    if (i3 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c4 = cArr3[i3];
                    if (z) {
                        sb.append((char) (c4 + 128));
                        z = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (mtVar.a() <= 0) {
                return;
            }
        }
    }

    public static void h(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    public static int i(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
