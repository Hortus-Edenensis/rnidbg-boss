package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class aw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f1583a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    public static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    public static final Charset c = Charset.forName("ISO-8859-1");
    public static final BigInteger[] d;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1584a;

        static {
            int[] iArr = new int[b.values().length];
            f1584a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1584a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1584a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1584a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1584a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1584a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        d = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = d;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
    
        if (r7 >= 6) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        r1.write((byte) (r18 >> ((5 - r7) * 8)));
        r7 = r7 + 1;
        r2 = com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
        r3 = com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i8 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
        int i9 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
        int i10 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW;
        int i11 = 902;
        long j = 900;
        if (i == 901) {
            int[] iArr2 = new int[6];
            i3 = i2 + 1;
            int i12 = iArr[i2];
            boolean z = false;
            loop0: while (true) {
                i4 = 0;
                long j2 = 0;
                while (true) {
                    i5 = iArr[0];
                    if (i3 >= i5 || z) {
                        break loop0;
                    }
                    int i13 = i4 + 1;
                    iArr2[i4] = i12;
                    j2 = (j2 * j) + ((long) i12);
                    i7 = i3 + 1;
                    i12 = iArr[i3];
                    if (i12 == 900 || i12 == 901 || i12 == 902 || i12 == 924 || i12 == 928 || i12 == i9 || i12 == i8) {
                        i3 = i7 - 1;
                        i4 = i13;
                        i8 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
                        i9 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
                        j = 900;
                        z = true;
                    } else {
                        if (i13 % 5 == 0 && i13 > 0) {
                            break;
                        }
                        i3 = i7;
                        i4 = i13;
                        i8 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
                        i9 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
                        j = 900;
                    }
                }
                i3 = i7;
                j = 900;
            }
            if (i3 != i5 || i12 >= 900) {
                i6 = i4;
            } else {
                i6 = i4 + 1;
                iArr2[i4] = i12;
            }
            for (int i14 = 0; i14 < i6; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i == 924) {
            int i15 = i2;
            boolean z2 = false;
            int i16 = 0;
            long j3 = 0;
            while (i15 < iArr[0] && !z2) {
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                if (i18 < 900) {
                    i16++;
                    j3 = (j3 * 900) + ((long) i18);
                    i15 = i17;
                } else {
                    if (i18 != 900 && i18 != 901 && i18 != i11 && i18 != 924 && i18 != i10) {
                        if (i18 != 923 && i18 != 922) {
                            i15 = i17;
                        }
                    }
                    i15 = i17 - 1;
                    z2 = true;
                }
                if (i16 % 5 == 0 && i16 > 0) {
                    for (int i19 = 0; i19 < 6; i19++) {
                        byteArrayOutputStream.write((byte) (j3 >> ((5 - i19) * 8)));
                    }
                    i16 = 0;
                    j3 = 0;
                }
                i10 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW;
                i11 = 902;
            }
            i3 = i15;
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static nw0 b(int[] iArr, String str) throws FormatException {
        int iG;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charsetForName = c;
        int i = iArr[1];
        wa4 wa4Var = new wa4();
        int i2 = 2;
        while (i2 < iArr[0]) {
            if (i != 913) {
                switch (i) {
                    case 900:
                        iG = g(iArr, i2, sb);
                        break;
                    case 901:
                        iG = a(i, iArr, charsetForName, i2, sb);
                        break;
                    case 902:
                        iG = f(iArr, i2, sb);
                        break;
                    default:
                        switch (i) {
                            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                                throw FormatException.getFormatInstance();
                            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION /* 925 */:
                                iG = i2 + 1;
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION /* 926 */:
                                iG = i2 + 2;
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE /* 927 */:
                                iG = i2 + 1;
                                charsetForName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW /* 928 */:
                                iG = d(iArr, i2, wa4Var);
                                break;
                            default:
                                iG = g(iArr, i2 - 1, sb);
                                break;
                        }
                        break;
                }
            } else {
                iG = i2 + 1;
                sb.append((char) iArr[i2]);
            }
            if (iG >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i2 = iG + 1;
            i = iArr[iG];
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        nw0 nw0Var = new nw0(null, sb.toString(), null, str);
        nw0Var.m(wa4Var);
        return nw0Var;
    }

    public static String c(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(d[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int d(int[] iArr, int i, wa4 wa4Var) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        wa4Var.d(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iG = g(iArr, i, sb);
        wa4Var.a(sb.toString());
        int i3 = iArr[iG];
        if (i3 != 923) {
            if (i3 != 922) {
                return iG;
            }
            wa4Var.b(true);
            return iG + 1;
        }
        int i4 = iG + 1;
        int[] iArr3 = new int[iArr[0] - i4];
        boolean z = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < 900) {
                iArr3[i5] = i7;
                i4 = i6;
                i5++;
            } else {
                if (i7 != 922) {
                    throw FormatException.getFormatInstance();
                }
                wa4Var.b(true);
                i4 = i6 + 1;
                z = true;
            }
        }
        wa4Var.c(Arrays.copyOf(iArr3, i5));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        b bVar;
        int i2;
        b bVar2 = b.ALPHA;
        b bVar3 = bVar2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            char c2 = ' ';
            switch (a.f1584a[bVar2.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c2 = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 == 27) {
                            bVar2 = b.LOWER;
                        } else if (i4 == 28) {
                            bVar2 = b.MIXED;
                        } else if (i4 == 29) {
                            bVar = b.PUNCT_SHIFT;
                            c2 = 0;
                            b bVar4 = bVar;
                            bVar3 = bVar2;
                            bVar2 = bVar4;
                            break;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                    }
                    break;
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c2 = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 != 27) {
                            if (i4 == 28) {
                                bVar2 = b.MIXED;
                            } else if (i4 == 29) {
                                bVar = b.PUNCT_SHIFT;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                bVar2 = b.ALPHA;
                            }
                            c2 = 0;
                        } else {
                            bVar = b.ALPHA_SHIFT;
                        }
                        c2 = 0;
                        b bVar42 = bVar;
                        bVar3 = bVar2;
                        bVar2 = bVar42;
                    }
                    break;
                case 3:
                    if (i4 < 25) {
                        c2 = b[i4];
                    } else {
                        if (i4 == 25) {
                            bVar2 = b.PUNCT;
                        } else if (i4 != 26) {
                            if (i4 == 27) {
                                bVar2 = b.LOWER;
                            } else if (i4 == 28) {
                                bVar2 = b.ALPHA;
                            } else if (i4 == 29) {
                                bVar = b.PUNCT_SHIFT;
                                c2 = 0;
                                b bVar422 = bVar;
                                bVar3 = bVar2;
                                bVar2 = bVar422;
                                break;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                bVar2 = b.ALPHA;
                            }
                        }
                        c2 = 0;
                    }
                    break;
                case 4:
                    if (i4 < 29) {
                        c2 = f1583a[i4];
                    } else {
                        if (i4 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                    }
                    break;
                case 5:
                    if (i4 < 26) {
                        c2 = (char) (i4 + 65);
                    } else if (i4 != 26) {
                        bVar2 = i4 == 900 ? b.ALPHA : bVar3;
                        c2 = 0;
                    }
                    bVar2 = bVar3;
                    break;
                case 6:
                    if (i4 < 29) {
                        c2 = f1583a[i4];
                        bVar2 = bVar3;
                    } else {
                        if (i4 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                    }
                    break;
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    public static int f(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = iArr[0];
            if (i >= i3 || z) {
                break;
            }
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == i3) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i2] = i5;
                i2++;
            } else if (i5 == 900 || i5 == 901 || i5 == 924 || i5 == 928 || i5 == 923 || i5 == 922) {
                i4--;
                z = true;
            }
            if ((i2 % 15 == 0 || i5 == 902 || z) && i2 > 0) {
                sb.append(c(iArr2, i2));
                i2 = 0;
            }
            i = i4;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0036. Please report as an issue. */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static int g(int[] r9, int r10, java.lang.StringBuilder r11) {
        /*
            r0 = 0
            r1 = r9[r0]
            int r2 = r1 - r10
            r3 = 1
            int r2 = r2 << r3
            int[] r2 = new int[r2]
            int r1 = r1 - r10
            int r1 = r1 << r3
            int[] r1 = new int[r1]
            r4 = 0
            r5 = 0
        Lf:
            r6 = r9[r0]
            if (r10 >= r6) goto L4f
            if (r4 != 0) goto L4f
            int r6 = r10 + 1
            r10 = r9[r10]
            r7 = 900(0x384, float:1.261E-42)
            if (r10 >= r7) goto L2b
            int r7 = r10 / 30
            r2[r5] = r7
            int r7 = r5 + 1
            int r10 = r10 % 30
            r2[r7] = r10
            int r5 = r5 + 2
        L29:
            r10 = r6
            goto Lf
        L2b:
            r8 = 913(0x391, float:1.28E-42)
            if (r10 == r8) goto L44
            r8 = 928(0x3a0, float:1.3E-42)
            if (r10 == r8) goto L40
            switch(r10) {
                case 900: goto L3a;
                case 901: goto L40;
                case 902: goto L40;
                default: goto L36;
            }
        L36:
            switch(r10) {
                case 922: goto L40;
                case 923: goto L40;
                case 924: goto L40;
                default: goto L39;
            }
        L39:
            goto L29
        L3a:
            int r10 = r5 + 1
            r2[r5] = r7
            r5 = r10
            goto L29
        L40:
            int r10 = r6 + (-1)
            r4 = 1
            goto Lf
        L44:
            r2[r5] = r8
            int r10 = r6 + 1
            r6 = r9[r6]
            r1[r5] = r6
            int r5 = r5 + 1
            goto Lf
        L4f:
            e(r2, r1, r5, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aw0.g(int[], int, java.lang.StringBuilder):int");
    }
}
