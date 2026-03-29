package com.bytedance.sdk.component.fx.nr.u.fx;

import com.bytedance.sdk.component.fx.nr.bg;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.mv;
import com.bytedance.sdk.component.fx.nr.sx;
import com.qiniu.android.http.request.Request;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class pn {
    private static final Pattern u = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static boolean fx(h hVar) {
        if (hVar.u().nr().equals(Request.HttpMethodHEAD)) {
            return false;
        }
        int iFx = hVar.fx();
        return (((iFx >= 100 && iFx < 200) || iFx == 204 || iFx == 304) && u(hVar) == -1 && !HTTP.CHUNK_CODING.equalsIgnoreCase(hVar.u("Transfer-Encoding"))) ? false : true;
    }

    public static Set<String> nr(sx sxVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iU = sxVar.u();
        for (int i = 0; i < iU; i++) {
            if (HttpHeaders.VARY.equalsIgnoreCase(sxVar.u(i))) {
                String strNr = sxVar.nr(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strNr.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static long u(h hVar) {
        return u(hVar.x());
    }

    public static long u(sx sxVar) {
        return u(sxVar.u("Content-Length"));
    }

    private static long u(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static sx u(sx sxVar, sx sxVar2) {
        Set<String> setNr = nr(sxVar2);
        if (setNr.isEmpty()) {
            return new sx.u().u();
        }
        sx.u uVar = new sx.u();
        int iU = sxVar.u();
        for (int i = 0; i < iU; i++) {
            String strU = sxVar.u(i);
            if (setNr.contains(strU)) {
                uVar.u(strU, sxVar.nr(i));
            }
        }
        return uVar.u();
    }

    public static sx nr(h hVar) {
        return u(hVar.jk().u().fx(), hVar.x());
    }

    public static int nr(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static void u(mv mvVar, bg bgVar, sx sxVar) {
        if (mvVar == mv.u) {
            return;
        }
        com.bytedance.sdk.component.fx.nr.l.u(bgVar, sxVar).isEmpty();
    }

    public static int u(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int u(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }
}
