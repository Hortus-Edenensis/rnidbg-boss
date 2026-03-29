package defpackage;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class xy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22082a;
    public int b = 0;

    public xy5(String str) {
        e96.j(str);
        this.f22082a = str;
    }

    public static String s(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '\\') {
                sb.append(c2);
            } else if (c != 0 && c == '\\') {
                sb.append(c2);
            }
            i++;
            c = c2;
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0068 A[EDGE_INSN: B:37:0x0068->B:32:0x0068 BREAK  A[LOOP:0: B:3:0x0006->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[LOOP:0: B:3:0x0006->B:40:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(char c, char c2) {
        char cCharValue = 0;
        boolean z = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (!j()) {
            Character chValueOf = Character.valueOf(c());
            if (cCharValue == 0 || cCharValue != '\\') {
                if ((chValueOf.equals('\'') || chValueOf.equals(Character.valueOf(Typography.quote))) && chValueOf.charValue() != c) {
                    z = !z;
                }
                if (!z) {
                    if (chValueOf.equals(Character.valueOf(c))) {
                        i++;
                        if (i2 == -1) {
                            i2 = this.b;
                        }
                    } else if (chValueOf.equals(Character.valueOf(c2))) {
                        i--;
                    }
                    if (i > 0 && cCharValue != 0) {
                        i3 = this.b;
                    }
                    cCharValue = chValueOf.charValue();
                    if (i <= 0) {
                        break;
                    }
                } else if (i <= 0) {
                }
            } else {
                if (i > 0) {
                    i3 = this.b;
                }
                cCharValue = chValueOf.charValue();
                if (i <= 0) {
                }
            }
        }
        return i3 >= 0 ? this.f22082a.substring(i2, i3) : "";
    }

    public String b(String str) {
        String strG = g(str);
        k(str);
        return strG;
    }

    public char c() {
        String str = this.f22082a;
        int i = this.b;
        this.b = i + 1;
        return str.charAt(i);
    }

    public void d(String str) {
        if (!l(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        if (length > r()) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.b += length;
    }

    public String e() {
        int i = this.b;
        while (!j() && (p() || m('-', '_'))) {
            this.b++;
        }
        return this.f22082a.substring(i, this.b);
    }

    public String f() {
        int i = this.b;
        while (!j() && (p() || n("*|", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "_", "-"))) {
            this.b++;
        }
        return this.f22082a.substring(i, this.b);
    }

    public String g(String str) {
        int iIndexOf = this.f22082a.indexOf(str, this.b);
        if (iIndexOf == -1) {
            return q();
        }
        String strSubstring = this.f22082a.substring(this.b, iIndexOf);
        this.b += strSubstring.length();
        return strSubstring;
    }

    public String h(String... strArr) {
        int i = this.b;
        while (!j() && !n(strArr)) {
            this.b++;
        }
        return this.f22082a.substring(i, this.b);
    }

    public boolean i() {
        boolean z = false;
        while (o()) {
            this.b++;
            z = true;
        }
        return z;
    }

    public boolean j() {
        return r() == 0;
    }

    public boolean k(String str) {
        if (!l(str)) {
            return false;
        }
        this.b += str.length();
        return true;
    }

    public boolean l(String str) {
        return this.f22082a.regionMatches(true, this.b, str, 0, str.length());
    }

    public boolean m(char... cArr) {
        if (j()) {
            return false;
        }
        for (char c : cArr) {
            if (this.f22082a.charAt(this.b) == c) {
                return true;
            }
        }
        return false;
    }

    public boolean n(String... strArr) {
        for (String str : strArr) {
            if (l(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean o() {
        return !j() && jl5.f(this.f22082a.charAt(this.b));
    }

    public boolean p() {
        return !j() && Character.isLetterOrDigit(this.f22082a.charAt(this.b));
    }

    public String q() {
        String str = this.f22082a;
        String strSubstring = str.substring(this.b, str.length());
        this.b = this.f22082a.length();
        return strSubstring;
    }

    public final int r() {
        return this.f22082a.length() - this.b;
    }

    public String toString() {
        return this.f22082a.substring(this.b);
    }
}
