package com.bytedance.sdk.openadsdk.api.plugin.nr;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class nr {
    private int b;
    private int fx;
    private int iz;
    private final int nr;
    private int pn;
    private final String u;
    private char[] x;

    public nr(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.u = name;
        this.nr = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.pn - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b() {
        int i;
        int i2;
        char c;
        int i3 = this.fx;
        this.b = i3;
        this.pn = i3;
        while (true) {
            int i4 = this.fx;
            if (i4 >= this.nr) {
                char[] cArr = this.x;
                int i5 = this.b;
                return new String(cArr, i5, this.pn - i5);
            }
            char[] cArr2 = this.x;
            char c2 = cArr2[i4];
            if (c2 == ' ') {
                int i6 = this.pn;
                this.iz = i6;
                this.fx = i4 + 1;
                this.pn = i6 + 1;
                cArr2[i6] = ' ';
                while (true) {
                    i = this.fx;
                    i2 = this.nr;
                    if (i >= i2) {
                        break;
                    }
                    char[] cArr3 = this.x;
                    if (cArr3[i] != ' ') {
                        break;
                    }
                    int i7 = this.pn;
                    this.pn = i7 + 1;
                    cArr3[i7] = ' ';
                    this.fx = i + 1;
                }
                if (i == i2 || (c = this.x[i]) == ',' || c == '+' || c == ';') {
                    break;
                }
            } else {
                if (c2 == ';') {
                    break;
                }
                if (c2 == '\\') {
                    int i8 = this.pn;
                    this.pn = i8 + 1;
                    cArr2[i8] = pn();
                    this.fx++;
                } else {
                    if (c2 == '+' || c2 == ',') {
                        break;
                    }
                    int i9 = this.pn;
                    this.pn = i9 + 1;
                    cArr2[i9] = c2;
                    this.fx = i4 + 1;
                }
            }
        }
        char[] cArr4 = this.x;
        int i10 = this.b;
        return new String(cArr4, i10, this.iz - i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.pn = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String fx() {
        char[] cArr;
        char c;
        int i = this.fx;
        if (i + 4 >= this.nr) {
            throw new IllegalStateException("Unexpected end of DN: " + this.u);
        }
        this.b = i;
        this.fx = i + 1;
        while (true) {
            int i2 = this.fx;
            if (i2 == this.nr || (c = (cArr = this.x)[i2]) == '+' || c == ',' || c == ';') {
                break;
            }
            if (c == ' ') {
                this.pn = i2;
                this.fx = i2 + 1;
                while (true) {
                    int i3 = this.fx;
                    if (i3 >= this.nr || this.x[i3] != ' ') {
                        break;
                    }
                    this.fx = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.fx = i2 + 1;
            }
        }
        int i4 = this.pn;
        int i5 = this.b;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.u);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) u(i8);
            i8 += 2;
        }
        return new String(this.x, this.b, i6);
    }

    private char iz() {
        int i;
        int i2;
        int iU = u(this.fx);
        this.fx++;
        if (iU < 128) {
            return (char) iU;
        }
        if (iU < 192 || iU > 247) {
            return '?';
        }
        if (iU <= 223) {
            i = iU & 31;
            i2 = 1;
        } else if (iU <= 239) {
            i = iU & 15;
            i2 = 2;
        } else {
            i = iU & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.fx + 1;
            this.fx = i4;
            if (i4 == this.nr || this.x[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.fx = i5;
            int iU2 = u(i5);
            this.fx++;
            if ((iU2 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (iU2 & 63);
        }
        return (char) i;
    }

    private String nr() {
        int i = this.fx + 1;
        this.fx = i;
        this.b = i;
        this.pn = i;
        while (true) {
            int i2 = this.fx;
            if (i2 == this.nr) {
                throw new IllegalStateException("Unexpected end of DN: " + this.u);
            }
            char[] cArr = this.x;
            char c = cArr[i2];
            if (c == '\"') {
                this.fx = i2 + 1;
                while (true) {
                    int i3 = this.fx;
                    if (i3 >= this.nr || this.x[i3] != ' ') {
                        break;
                    }
                    this.fx = i3 + 1;
                }
                char[] cArr2 = this.x;
                int i4 = this.b;
                return new String(cArr2, i4, this.pn - i4);
            }
            if (c == '\\') {
                cArr[this.pn] = pn();
            } else {
                cArr[this.pn] = c;
            }
            this.fx++;
            this.pn++;
        }
    }

    private char pn() {
        int i = this.fx + 1;
        this.fx = i;
        if (i == this.nr) {
            throw new IllegalStateException("Unexpected end of DN: " + this.u);
        }
        char c = this.x[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return iz();
                }
        }
    }

    private String u() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c3;
        while (true) {
            i = this.fx;
            i2 = this.nr;
            if (i >= i2 || this.x[i] != ' ') {
                break;
            }
            this.fx = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.b = i;
        this.fx = i + 1;
        while (true) {
            i3 = this.fx;
            i4 = this.nr;
            if (i3 >= i4 || (c3 = this.x[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.fx = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.u);
        }
        this.pn = i3;
        if (this.x[i3] == ' ') {
            while (true) {
                i6 = this.fx;
                i7 = this.nr;
                if (i6 >= i7 || (c2 = this.x[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.fx = i6 + 1;
            }
            if (this.x[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.u);
            }
        }
        do {
            i5 = this.fx + 1;
            this.fx = i5;
            if (i5 >= this.nr) {
                break;
            }
        } while (this.x[i5] == ' ');
        int i8 = this.pn;
        int i9 = this.b;
        if (i8 - i9 > 4) {
            char[] cArr = this.x;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.b = i9 + 4;
            }
        }
        char[] cArr2 = this.x;
        int i10 = this.b;
        return new String(cArr2, i10, i8 - i10);
    }

    private int u(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.nr) {
            char[] cArr = this.x;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else {
                if (c < 'A' || c > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.u);
                }
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.u);
                }
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.u);
    }

    public String u(String str) {
        String strNr;
        this.fx = 0;
        this.b = 0;
        this.pn = 0;
        this.iz = 0;
        this.x = this.u.toCharArray();
        String strU = u();
        if (strU == null) {
            return null;
        }
        do {
            int i = this.fx;
            if (i == this.nr) {
                return null;
            }
            char c = this.x[i];
            if (c == '\"') {
                strNr = nr();
            } else if (c != '#') {
                strNr = (c == '+' || c == ',' || c == ';') ? "" : b();
            } else {
                strNr = fx();
            }
            if (str.equalsIgnoreCase(strU)) {
                return strNr;
            }
            int i2 = this.fx;
            if (i2 >= this.nr) {
                return null;
            }
            char c2 = this.x[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.u);
            }
            this.fx = i2 + 1;
            strU = u();
        } while (strU != null);
        throw new IllegalStateException("Malformed DN: " + this.u);
    }
}
