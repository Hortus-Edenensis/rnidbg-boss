package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class hk6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f17988a = Pattern.compile("^NOTE([ \t].*)?$");

    @Nullable
    public static Matcher a(gc4 gc4Var) {
        String strS;
        while (true) {
            String strS2 = gc4Var.s();
            if (strS2 == null) {
                return null;
            }
            if (f17988a.matcher(strS2).matches()) {
                do {
                    strS = gc4Var.s();
                    if (strS != null) {
                    }
                } while (!strS.isEmpty());
            } else {
                Matcher matcher = dk6.f17062a.matcher(strS2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(gc4 gc4Var) {
        String strS = gc4Var.s();
        return strS != null && strS.startsWith("WEBVTT");
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] strArrA1 = g86.a1(str, "\\.");
        long j = 0;
        for (String str2 : g86.Z0(strArrA1[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrA1.length == 2) {
            j2 += Long.parseLong(strArrA1[1]);
        }
        return j2 * 1000;
    }

    public static void e(gc4 gc4Var) throws ParserException {
        int iF = gc4Var.f();
        if (b(gc4Var)) {
            return;
        }
        gc4Var.U(iF);
        throw ParserException.createForMalformedContainer("Expected WEBVTT. Got " + gc4Var.s(), null);
    }
}
