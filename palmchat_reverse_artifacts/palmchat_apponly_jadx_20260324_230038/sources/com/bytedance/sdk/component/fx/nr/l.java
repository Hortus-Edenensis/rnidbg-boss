package com.bytedance.sdk.component.fx.nr;

import com.amap.api.services.core.AMapException;
import com.cdo.oaps.ad.OapsWrapper;
import com.zenmen.palmchat.refund.RefundData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5124a;
    private final String iz;
    private final boolean jk;
    private final boolean l;
    private final boolean mv;
    private final String n;
    private final String pn;
    private final boolean t;
    private final long x;
    private static final Pattern u = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern nr = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern fx = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern b = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.pn = str;
        this.iz = str2;
        this.x = j;
        this.n = str3;
        this.f5124a = str4;
        this.jk = z;
        this.t = z2;
        this.mv = z3;
        this.l = z4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.pn.equals(this.pn) && lVar.iz.equals(this.iz) && lVar.n.equals(this.n) && lVar.f5124a.equals(this.f5124a) && lVar.x == this.x && lVar.jk == this.jk && lVar.t == this.t && lVar.l == this.l && lVar.mv == this.mv;
    }

    public int hashCode() {
        int iHashCode = (((((((this.pn.hashCode() + 527) * 31) + this.iz.hashCode()) * 31) + this.n.hashCode()) * 31) + this.f5124a.hashCode()) * 31;
        long j = this.x;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.jk ? 1 : 0)) * 31) + (!this.t ? 1 : 0)) * 31) + (!this.l ? 1 : 0)) * 31) + (!this.mv ? 1 : 0);
    }

    public String nr() {
        return this.iz;
    }

    public String toString() {
        return u(false);
    }

    public String u() {
        return this.pn;
    }

    private static String nr(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strU = com.bytedance.sdk.component.fx.nr.u.fx.u(str);
        if (strU != null) {
            return strU;
        }
        throw new IllegalArgumentException();
    }

    private static boolean u(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.fx.nr.u.fx.fx(str);
    }

    public static l u(bg bgVar, String str) {
        return u(System.currentTimeMillis(), bgVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[PHI: r0
      0x00c0: PHI (r0v15 long) = (r0v2 long), (r0v5 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static l u(long j, bg bgVar, String str) {
        long j2;
        l lVar;
        String str2;
        String strSubstring;
        int length = str.length();
        char c = ';';
        int iU = com.bytedance.sdk.component.fx.nr.u.fx.u(str, 0, length, ';');
        char c2 = '=';
        int iU2 = com.bytedance.sdk.component.fx.nr.u.fx.u(str, 0, iU, '=');
        if (iU2 == iU) {
            return null;
        }
        String strFx = com.bytedance.sdk.component.fx.nr.u.fx.fx(str, 0, iU2);
        if (strFx.isEmpty() || com.bytedance.sdk.component.fx.nr.u.fx.nr(strFx) != -1) {
            return null;
        }
        String strFx2 = com.bytedance.sdk.component.fx.nr.u.fx.fx(str, iU2 + 1, iU);
        if (com.bytedance.sdk.component.fx.nr.u.fx.nr(strFx2) != -1) {
            return null;
        }
        int i = iU + 1;
        String str3 = null;
        String strNr = null;
        long jU = -1;
        long jU2 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i < length) {
            int iU3 = com.bytedance.sdk.component.fx.nr.u.fx.u(str, i, length, c);
            int iU4 = com.bytedance.sdk.component.fx.nr.u.fx.u(str, i, iU3, c2);
            String strFx3 = com.bytedance.sdk.component.fx.nr.u.fx.fx(str, i, iU4);
            String strFx4 = iU4 < iU3 ? com.bytedance.sdk.component.fx.nr.u.fx.fx(str, iU4 + 1, iU3) : "";
            if (strFx3.equalsIgnoreCase(RefundData.TAG_CLOCK)) {
                try {
                    jU2 = u(strFx4, 0, strFx4.length());
                    z4 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strFx3.equalsIgnoreCase("max-age")) {
                jU = u(strFx4);
                z4 = true;
            } else if (strFx3.equalsIgnoreCase("domain")) {
                strNr = nr(strFx4);
                z3 = false;
            } else if (strFx3.equalsIgnoreCase(OapsWrapper.KEY_PATH)) {
                str3 = strFx4;
            } else if (strFx3.equalsIgnoreCase("secure")) {
                z = true;
            } else if (strFx3.equalsIgnoreCase("httponly")) {
                z2 = true;
            }
            i = iU3 + 1;
            c = ';';
            c2 = '=';
        }
        long j3 = Long.MIN_VALUE;
        if (jU != Long.MIN_VALUE) {
            if (jU != -1) {
                j3 = j + (jU <= 9223372036854775L ? jU * 1000 : Long.MAX_VALUE);
                j2 = (j3 < j || j3 > DatesKt.MAX_DATE) ? 253402300799999L : j3;
            } else {
                j2 = jU2;
            }
        }
        String strX = bgVar.x();
        if (strNr == null) {
            str2 = strX;
            lVar = null;
        } else {
            if (!u(strX, strNr)) {
                return null;
            }
            lVar = null;
            str2 = strNr;
        }
        if (strX.length() != str2.length() && com.bytedance.sdk.component.fx.nr.u.n.u.u().u(str2) == null) {
            return lVar;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String strA = bgVar.a();
            int iLastIndexOf = strA.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strA.substring(0, iLastIndexOf) : "/";
        } else {
            strSubstring = str3;
        }
        return new l(strFx, strFx2, j2, str2, strSubstring, z, z2, z3, z4);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long u(String str, int i, int i2) {
        int iU = u(str, i, i2, false);
        Matcher matcher = b.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iU < i2) {
            int iU2 = u(str, iU + 1, i2, true);
            matcher.region(iU, iU2);
            if (i4 == -1 && matcher.usePattern(b).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i6 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(fx).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = nr;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 == -1 && matcher.usePattern(u).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            iU = u(str, iU2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 <= 0 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 >= 0 && i7 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.component.fx.nr.u.fx.x);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iIndexOf - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    private static int u(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long u(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    public static List<l> u(bg bgVar, sx sxVar) {
        List<String> listNr = sxVar.nr("Set-Cookie");
        int size = listNr.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            l lVarU = u(bgVar, listNr.get(i));
            if (lVarU != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lVarU);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String u(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.pn);
        sb.append('=');
        sb.append(this.iz);
        if (this.l) {
            if (this.x == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.bytedance.sdk.component.fx.nr.u.fx.b.u(new Date(this.x)));
            }
        }
        if (!this.mv) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.n);
        }
        sb.append("; path=");
        sb.append(this.f5124a);
        if (this.jk) {
            sb.append("; secure");
        }
        if (this.t) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
