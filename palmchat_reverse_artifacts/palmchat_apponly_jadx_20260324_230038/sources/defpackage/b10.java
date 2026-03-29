package defpackage;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class b10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f1622a;
    public final int b;
    public int c = 0;
    public int d = 0;
    public final String[] e = new String[512];

    public b10(String str) {
        e96.j(str);
        char[] charArray = str.toCharArray();
        this.f1622a = charArray;
        this.b = charArray.length;
    }

    public boolean A() {
        if (q()) {
            return false;
        }
        char c = this.f1622a[this.c];
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c);
    }

    public int B(char c) {
        for (int i = this.c; i < this.b; i++) {
            if (c == this.f1622a[i]) {
                return i - this.c;
            }
        }
        return -1;
    }

    public int C(CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        int i = this.c;
        while (i < this.b) {
            if (cCharAt != this.f1622a[i]) {
                do {
                    i++;
                    if (i >= this.b) {
                        break;
                    }
                } while (cCharAt != this.f1622a[i]);
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            int i3 = this.b;
            if (i < i3 && length <= i3) {
                int i4 = i2;
                for (int i5 = 1; i4 < length && charSequence.charAt(i5) == this.f1622a[i4]; i5++) {
                    i4++;
                }
                if (i4 == length) {
                    return i - this.c;
                }
            }
            i = i2;
        }
        return -1;
    }

    public int D() {
        return this.c;
    }

    public boolean E(int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        char[] cArr = this.f1622a;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            int i5 = i + 1;
            int i6 = i3 + 1;
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i = i5;
            i2 = i4;
            i3 = i6;
        }
    }

    public void F() {
        this.c = this.d;
    }

    public void G() {
        this.c--;
    }

    public void a() {
        this.c++;
    }

    public final String b(int i, int i2) {
        char[] cArr = this.f1622a;
        String[] strArr = this.e;
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i3 < i2) {
            i5 = (i5 * 31) + cArr[i4];
            i3++;
            i4++;
        }
        int length = (strArr.length - 1) & i5;
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i, i2);
            strArr[length] = str2;
            return str2;
        }
        if (E(i, i2, str)) {
            return str;
        }
        String str3 = new String(cArr, i, i2);
        strArr[length] = str3;
        return str3;
    }

    public char c() {
        int i = this.c;
        char c = i >= this.b ? CharCompanionObject.MAX_VALUE : this.f1622a[i];
        this.c = i + 1;
        return c;
    }

    public String d() {
        int i;
        char c;
        int i2 = this.c;
        int i3 = this.b;
        char[] cArr = this.f1622a;
        while (true) {
            i = this.c;
            if (i >= i3 || (c = cArr[i]) == '&' || c == '<' || c == 0) {
                break;
            }
            this.c = i + 1;
        }
        return i > i2 ? b(i2, i - i2) : "";
    }

    public String e() {
        int i;
        char c;
        int i2 = this.c;
        while (true) {
            i = this.c;
            if (i >= this.b || (c = this.f1622a[i]) < '0' || c > '9') {
                break;
            }
            this.c = i + 1;
        }
        return b(i2, i - i2);
    }

    public String f() {
        int i;
        char c;
        int i2 = this.c;
        while (true) {
            i = this.c;
            if (i >= this.b || (((c = this.f1622a[i]) < '0' || c > '9') && ((c < 'A' || c > 'F') && (c < 'a' || c > 'f')))) {
                break;
            }
            this.c = i + 1;
        }
        return b(i2, i - i2);
    }

    public String g() {
        char c;
        int i = this.c;
        while (true) {
            int i2 = this.c;
            if (i2 >= this.b || (((c = this.f1622a[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.c++;
        }
        return b(i, this.c - i);
    }

    public String h() {
        char c;
        int i = this.c;
        while (true) {
            int i2 = this.c;
            if (i2 >= this.b || (((c = this.f1622a[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.c++;
        }
        while (!q()) {
            char[] cArr = this.f1622a;
            int i3 = this.c;
            char c2 = cArr[i3];
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.c = i3 + 1;
        }
        return b(i, this.c - i);
    }

    public String i() {
        int i;
        char c;
        int i2 = this.c;
        int i3 = this.b;
        char[] cArr = this.f1622a;
        while (true) {
            i = this.c;
            if (i >= i3 || (c = cArr[i]) == '\t' || c == '\n' || c == '\r' || c == '\f' || c == ' ' || c == '/' || c == '>' || c == 0) {
                break;
            }
            this.c = i + 1;
        }
        return i > i2 ? b(i2, i - i2) : "";
    }

    public String j(char c) {
        int iB = B(c);
        if (iB == -1) {
            return n();
        }
        String strB = b(this.c, iB);
        this.c += iB;
        return strB;
    }

    public String k(String str) {
        int iC = C(str);
        if (iC == -1) {
            return n();
        }
        String strB = b(this.c, iC);
        this.c += iC;
        return strB;
    }

    public String l(char... cArr) {
        int i = this.c;
        int i2 = this.b;
        char[] cArr2 = this.f1622a;
        loop0: while (this.c < i2) {
            for (char c : cArr) {
                if (cArr2[this.c] == c) {
                    break loop0;
                }
            }
            this.c++;
        }
        int i3 = this.c;
        return i3 > i ? b(i, i3 - i) : "";
    }

    public String m(char... cArr) {
        int i = this.c;
        int i2 = this.b;
        char[] cArr2 = this.f1622a;
        while (true) {
            int i3 = this.c;
            if (i3 >= i2 || Arrays.binarySearch(cArr, cArr2[i3]) >= 0) {
                break;
            }
            this.c++;
        }
        int i4 = this.c;
        return i4 > i ? b(i, i4 - i) : "";
    }

    public String n() {
        int i = this.c;
        String strB = b(i, this.b - i);
        this.c = this.b;
        return strB;
    }

    public boolean o(String str) {
        Locale locale = Locale.ENGLISH;
        return C(str.toLowerCase(locale)) > -1 || C(str.toUpperCase(locale)) > -1;
    }

    public char p() {
        int i = this.c;
        return i >= this.b ? CharCompanionObject.MAX_VALUE : this.f1622a[i];
    }

    public boolean q() {
        return this.c >= this.b;
    }

    public void r() {
        this.d = this.c;
    }

    public boolean s(String str) {
        if (!v(str)) {
            return false;
        }
        this.c += str.length();
        return true;
    }

    public boolean t(String str) {
        if (!z(str)) {
            return false;
        }
        this.c += str.length();
        return true;
    }

    public String toString() {
        char[] cArr = this.f1622a;
        int i = this.c;
        return new String(cArr, i, this.b - i);
    }

    public boolean u(char c) {
        return !q() && this.f1622a[this.c] == c;
    }

    public boolean v(String str) {
        int length = str.length();
        if (length > this.b - this.c) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.f1622a[this.c + i]) {
                return false;
            }
        }
        return true;
    }

    public boolean w(char... cArr) {
        if (q()) {
            return false;
        }
        char c = this.f1622a[this.c];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public boolean x(char[] cArr) {
        return !q() && Arrays.binarySearch(cArr, this.f1622a[this.c]) >= 0;
    }

    public boolean y() {
        char c;
        return !q() && (c = this.f1622a[this.c]) >= '0' && c <= '9';
    }

    public boolean z(String str) {
        int length = str.length();
        if (length > this.b - this.c) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.f1622a[this.c + i])) {
                return false;
            }
        }
        return true;
    }
}
