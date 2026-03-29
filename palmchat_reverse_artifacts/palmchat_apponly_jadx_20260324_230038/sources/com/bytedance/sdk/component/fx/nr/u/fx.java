package com.bytedance.sdk.component.fx.nr.u;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.fx.nr.dw;
import com.bytedance.sdk.component.fx.nr.gi;
import com.bytedance.sdk.component.fx.nr.rh;
import com.bytedance.sdk.component.fx.u.bg;
import com.bytedance.sdk.component.fx.u.iz;
import com.bytedance.sdk.component.fx.u.pn;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx {
    public static final gi b;
    public static final rh fx;
    public static final byte[] u;
    public static final String[] nr = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final iz f5129a = iz.nr("efbbbf");
    private static final iz jk = iz.nr("feff");
    private static final iz t = iz.nr("fffe");
    private static final iz l = iz.nr("0000ffff");
    private static final iz mv = iz.nr("ffff0000");
    public static final Charset pn = Charset.forName("UTF-8");
    public static final Charset iz = Charset.forName("ISO-8859-1");
    private static final Charset s = Charset.forName(CharEncoding.UTF_16BE);
    private static final Charset k = Charset.forName("UTF-16LE");
    private static final Charset my = Charset.forName("UTF-32BE");
    private static final Charset o = Charset.forName("UTF-32LE");
    public static final TimeZone x = DesugarTimeZone.getTimeZone("GMT");
    public static final Comparator<String> n = new Comparator<String>() { // from class: com.bytedance.sdk.component.fx.nr.u.fx.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Pattern sx = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        u = bArr;
        fx = rh.u(null, bArr);
        b = gi.u((dw) null, bArr);
    }

    private static boolean b(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String fx(String str, int i, int i2) {
        int iU = u(str, i, i2);
        return str.substring(iU, nr(str, iU, i2));
    }

    public static boolean nr(bg bgVar, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jG_ = bgVar.u().fx() ? bgVar.u().g_() - jNanoTime : Long.MAX_VALUE;
        bgVar.u().u(Math.min(jG_, timeUnit.toNanos(i)) + jNanoTime);
        try {
            com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
            while (bgVar.u(fxVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                fxVar.sx();
            }
            if (jG_ == Long.MAX_VALUE) {
                bgVar.u().iz();
                return true;
            }
            bgVar.u().u(jNanoTime + jG_);
            return true;
        } catch (InterruptedIOException unused) {
            if (jG_ == Long.MAX_VALUE) {
                bgVar.u().iz();
                return false;
            }
            bgVar.u().u(jNanoTime + jG_);
            return false;
        } catch (Throwable th) {
            if (jG_ == Long.MAX_VALUE) {
                bgVar.u().iz();
            } else {
                bgVar.u().u(jNanoTime + jG_);
            }
            throw th;
        }
    }

    public static int u(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static void u(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean u(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        if (r4 == 16) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        if (r5 != (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        r11 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r11, r11);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static InetAddress b(String str, int i, int i2) {
        int i3;
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i < i2) {
                if (i4 != 16) {
                    int i7 = i + 2;
                    if (i7 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                        if (i5 == -1) {
                            i4 += 2;
                            i5 = i4;
                            if (i7 != i2) {
                                i6 = i7;
                                i = i6;
                                int i8 = 0;
                                while (i < i2) {
                                }
                                i3 = i - i6;
                                if (i3 == 0) {
                                    break;
                                }
                                break;
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i4 != 0) {
                        if (str.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else {
                            if (!str.regionMatches(i, ".", 0, 1) || !u(str, i6, i2, bArr, i4 - 2)) {
                                return null;
                            }
                            i4 += 2;
                        }
                    }
                    i6 = i;
                    i = i6;
                    int i82 = 0;
                    while (i < i2) {
                        int iU = u(str.charAt(i));
                        if (iU == -1) {
                            break;
                        }
                        i82 = (i82 << 4) + iU;
                        i++;
                    }
                    i3 = i - i6;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i9 = i4 + 1;
                    bArr[i4] = (byte) ((i82 >>> 8) & 255);
                    i4 = i9 + 1;
                    bArr[i9] = (byte) (i82 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        return null;
    }

    public static boolean fx(String str) {
        return sx.matcher(str).matches();
    }

    public static void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void u(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!u(e)) {
                    throw e;
                }
            } catch (RuntimeException unused) {
            } catch (Exception unused2) {
            }
        }
    }

    public static boolean u(bg bgVar, int i, TimeUnit timeUnit) {
        try {
            return nr(bgVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> u(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> u(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory u(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.component.fx.nr.u.fx.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.jk.b.fx fxVar = new com.bytedance.sdk.component.jk.b.fx(runnable, "csj_" + str);
                fxVar.setDaemon(z);
                fxVar.setPriority(10);
                return fxVar;
            }
        };
    }

    public static String[] u(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean nr(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int nr(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String u(com.bytedance.sdk.component.fx.nr.bg bgVar, boolean z) {
        String strX;
        if (bgVar.x().contains(":")) {
            strX = "[" + bgVar.x() + "]";
        } else {
            strX = bgVar.x();
        }
        if (!z && bgVar.n() == com.bytedance.sdk.component.fx.nr.bg.u(bgVar.fx())) {
            return strX;
        }
        return strX + ":" + bgVar.n();
    }

    public static int nr(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static boolean u(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int u(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] u(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int u(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int u(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int u(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String u(String str) {
        InetAddress inetAddressB;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressB = b(str, 1, str.length() - 1);
            } else {
                inetAddressB = b(str, 0, str.length());
            }
            if (inetAddressB == null) {
                return null;
            }
            byte[] address = inetAddressB.getAddress();
            if (address.length == 16) {
                return u(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (b(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String u(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset u(pn pnVar, Charset charset) throws IOException {
        if (pnVar.u(0L, f5129a)) {
            pnVar.n(r0.x());
            return pn;
        }
        if (pnVar.u(0L, jk)) {
            pnVar.n(r0.x());
            return s;
        }
        if (pnVar.u(0L, t)) {
            pnVar.n(r0.x());
            return k;
        }
        if (pnVar.u(0L, l)) {
            pnVar.n(r0.x());
            return my;
        }
        if (!pnVar.u(0L, mv)) {
            return charset;
        }
        pnVar.n(r0.x());
        return o;
    }

    public static AssertionError u(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    private static boolean u(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static String u(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
        while (i2 < bArr.length) {
            if (i2 == i) {
                fxVar.a(58);
                i2 += i4;
                if (i2 == 16) {
                    fxVar.a(58);
                }
            } else {
                if (i2 > 0) {
                    fxVar.a(58);
                }
                fxVar.t(((bArr[i2] & UByte.MAX_VALUE) << 8) | (bArr[i2 + 1] & UByte.MAX_VALUE));
                i2 += 2;
            }
        }
        return fxVar.k();
    }
}
