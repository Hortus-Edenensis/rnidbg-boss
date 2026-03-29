package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.ads.ex;
import com.igexin.push.core.b;
import defpackage.vy2;
import defpackage.wy2;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.internal._BufferKt;
import org.apache.http.message.BasicHeaderValueFormatter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class a extends JsonReader {
    public static final ByteString n = ByteString.encodeUtf8("'\\");
    public static final ByteString o = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
    public static final ByteString p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final ByteString q = ByteString.encodeUtf8("\n\r");
    public static final ByteString r = ByteString.encodeUtf8("*/");
    public final BufferedSource h;
    public final Buffer i;
    public int j = 0;
    public long k;
    public int l;

    @Nullable
    public String m;

    public a(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.h = bufferedSource;
        this.i = bufferedSource.getBufferField();
        q(6);
    }

    public final void B() throws IOException {
        if (!this.e) {
            throw A("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final int C() throws IOException {
        int[] iArr = this.b;
        int i = this.f2529a;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iF = F(true);
            this.i.readByte();
            if (iF != 44) {
                if (iF != 59) {
                    if (iF != 93) {
                        throw A("Unterminated array");
                    }
                    this.j = 4;
                    return 4;
                }
                B();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int iF2 = F(true);
                    this.i.readByte();
                    if (iF2 != 44) {
                        if (iF2 != 59) {
                            if (iF2 != 125) {
                                throw A("Unterminated object");
                            }
                            this.j = 2;
                            return 2;
                        }
                        B();
                    }
                }
                int iF3 = F(true);
                if (iF3 == 34) {
                    this.i.readByte();
                    this.j = 13;
                    return 13;
                }
                if (iF3 == 39) {
                    this.i.readByte();
                    B();
                    this.j = 12;
                    return 12;
                }
                if (iF3 != 125) {
                    B();
                    if (!E((char) iF3)) {
                        throw A("Expected name");
                    }
                    this.j = 14;
                    return 14;
                }
                if (i2 == 5) {
                    throw A("Expected name");
                }
                this.i.readByte();
                this.j = 2;
                return 2;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iF4 = F(true);
                this.i.readByte();
                if (iF4 != 58) {
                    if (iF4 != 61) {
                        throw A("Expected ':'");
                    }
                    B();
                    if (this.h.request(1L) && this.i.getByte(0L) == 62) {
                        this.i.readByte();
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (F(false) == -1) {
                    this.j = 18;
                    return 18;
                }
                B();
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iF5 = F(true);
        if (iF5 == 34) {
            this.i.readByte();
            this.j = 9;
            return 9;
        }
        if (iF5 == 39) {
            B();
            this.i.readByte();
            this.j = 8;
            return 8;
        }
        if (iF5 != 44 && iF5 != 59) {
            if (iF5 == 91) {
                this.i.readByte();
                this.j = 3;
                return 3;
            }
            if (iF5 != 93) {
                if (iF5 == 123) {
                    this.i.readByte();
                    this.j = 1;
                    return 1;
                }
                int I = I();
                if (I != 0) {
                    return I;
                }
                int iJ = J();
                if (iJ != 0) {
                    return iJ;
                }
                if (!E(this.i.getByte(0L))) {
                    throw A("Expected value");
                }
                B();
                this.j = 10;
                return 10;
            }
            if (i2 == 1) {
                this.i.readByte();
                this.j = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw A("Unexpected value");
        }
        B();
        this.j = 7;
        return 7;
    }

    public final int D(String str, JsonReader.a aVar) {
        int length = aVar.f2530a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.f2530a[i])) {
                this.j = 0;
                this.c[this.f2529a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean E(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        B();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.i.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r1 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r6.h.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        B();
        r3 = r6.i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        r6.i.readByte();
        r6.i.readByte();
        N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r6.i.readByte();
        r6.i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (M() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        throw A("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        B();
        N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int F(boolean z) throws IOException {
        while (true) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (!this.h.request(i2)) {
                    if (z) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte b = this.i.getByte(i);
                if (b != 10 && b != 32 && b != 13 && b != 9) {
                    break;
                }
                i = i2;
            }
        }
    }

    public final String G(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.h.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw A("Unterminated string");
            }
            if (this.i.getByte(jIndexOfElement) != 92) {
                if (sb == null) {
                    String utf8 = this.i.readUtf8(jIndexOfElement);
                    this.i.readByte();
                    return utf8;
                }
                sb.append(this.i.readUtf8(jIndexOfElement));
                this.i.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.i.readUtf8(jIndexOfElement));
            this.i.readByte();
            sb.append(K());
        }
    }

    public final String H() throws IOException {
        long jIndexOfElement = this.h.indexOfElement(p);
        return jIndexOfElement != -1 ? this.i.readUtf8(jIndexOfElement) : this.i.readUtf8();
    }

    public final int I() throws IOException {
        String str;
        String str2;
        int i;
        byte b = this.i.getByte(0L);
        if (b == 116 || b == 84) {
            str = ex.Code;
            str2 = "TRUE";
            i = 5;
        } else if (b == 102 || b == 70) {
            str = ex.V;
            str2 = "FALSE";
            i = 6;
        } else {
            if (b != 110 && b != 78) {
                return 0;
            }
            str = b.m;
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.h.request(i3)) {
                return 0;
            }
            byte b2 = this.i.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.h.request(length + 1) && E(this.i.getByte(length))) {
            return 0;
        }
        this.i.skip(length);
        this.j = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        if (E(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
    
        r16.k = r8;
        r16.i.skip(r5);
        r16.j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
    
        r16.l = r5;
        r16.j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int J() throws IOException {
        boolean z = true;
        long j = 0;
        int i = 0;
        char c = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i2 = i + 1;
            if (!this.h.request(i2)) {
                break;
            }
            byte b = this.i.getByte(i);
            if (b != 43) {
                if (b == 69 || b == 101) {
                    if (c != 2 && c != 4) {
                        return 0;
                    }
                    c = 5;
                } else if (b != 45) {
                    if (b != 46) {
                        if (b < 48 || b > 57) {
                            break;
                        }
                        if (c == z || c == 0) {
                            j = -(b - 48);
                            c = 2;
                        } else if (c == 2) {
                            if (j == 0) {
                                return 0;
                            }
                            long j2 = (10 * j) - ((long) (b - 48));
                            z2 &= j > _BufferKt.OVERFLOW_ZONE || (j == _BufferKt.OVERFLOW_ZONE && j2 < j);
                            j = j2;
                        } else if (c == 3) {
                            c = 4;
                        } else if (c == 5 || c == 6) {
                            c = 7;
                        }
                    } else {
                        if (c != 2) {
                            return 0;
                        }
                        c = 3;
                    }
                } else if (c == 0) {
                    c = 1;
                    z3 = true;
                } else if (c != 5) {
                    return 0;
                }
                i = i2;
                z = true;
            } else if (c != 5) {
                return 0;
            }
            c = 6;
            i = i2;
            z = true;
        }
    }

    public final char K() throws IOException {
        int i;
        int i2;
        if (!this.h.request(1L)) {
            throw A("Unterminated escape sequence");
        }
        byte b = this.i.readByte();
        if (b == 10 || b == 34 || b == 39 || b == 47 || b == 92) {
            return (char) b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            if (this.e) {
                return (char) b;
            }
            throw A("Invalid escape sequence: \\" + ((char) b));
        }
        if (!this.h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte b2 = this.i.getByte(i3);
            char c2 = (char) (c << 4);
            if (b2 < 48 || b2 > 57) {
                if (b2 >= 97 && b2 <= 102) {
                    i = b2 - 97;
                } else {
                    if (b2 < 65 || b2 > 70) {
                        throw A("\\u" + this.i.readUtf8(4L));
                    }
                    i = b2 - 65;
                }
                i2 = i + 10;
            } else {
                i2 = b2 - 48;
            }
            c = (char) (c2 + i2);
        }
        this.i.skip(4L);
        return c;
    }

    public final void L(ByteString byteString) throws IOException {
        while (true) {
            long jIndexOfElement = this.h.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw A("Unterminated string");
            }
            if (this.i.getByte(jIndexOfElement) != 92) {
                this.i.skip(jIndexOfElement + 1);
                return;
            } else {
                this.i.skip(jIndexOfElement + 1);
                K();
            }
        }
    }

    public final boolean M() throws IOException {
        BufferedSource bufferedSource = this.h;
        ByteString byteString = r;
        long jIndexOf = bufferedSource.indexOf(byteString);
        boolean z = jIndexOf != -1;
        Buffer buffer = this.i;
        buffer.skip(z ? jIndexOf + ((long) byteString.size()) : buffer.size());
        return z;
    }

    public final void N() throws IOException {
        long jIndexOfElement = this.h.indexOfElement(q);
        Buffer buffer = this.i;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    public final void O() throws IOException {
        long jIndexOfElement = this.h.indexOfElement(p);
        Buffer buffer = this.i;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void c() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 3) {
            q(1);
            this.d[this.f2529a - 1] = 0;
            this.j = 0;
        } else {
            throw new vy2("Expected BEGIN_ARRAY but was " + p() + " at path " + getPath());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j = 0;
        this.b[0] = 8;
        this.f2529a = 1;
        this.i.clear();
        this.h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void d() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 1) {
            q(3);
            this.j = 0;
            return;
        }
        throw new vy2("Expected BEGIN_OBJECT but was " + p() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void e() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 4) {
            throw new vy2("Expected END_ARRAY but was " + p() + " at path " + getPath());
        }
        int i = this.f2529a - 1;
        this.f2529a = i;
        int[] iArr = this.d;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.j = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void f() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 2) {
            throw new vy2("Expected END_OBJECT but was " + p() + " at path " + getPath());
        }
        int i = this.f2529a - 1;
        this.f2529a = i;
        this.c[i] = null;
        int[] iArr = this.d;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.j = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean g() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        return (iC == 2 || iC == 4 || iC == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean h() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 5) {
            this.j = 0;
            int[] iArr = this.d;
            int i = this.f2529a - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iC == 6) {
            this.j = 0;
            int[] iArr2 = this.d;
            int i2 = this.f2529a - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new vy2("Expected a boolean but was " + p() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double i() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 16) {
            this.j = 0;
            int[] iArr = this.d;
            int i = this.f2529a - 1;
            iArr[i] = iArr[i] + 1;
            return this.k;
        }
        if (iC == 17) {
            this.m = this.i.readUtf8(this.l);
        } else if (iC == 9) {
            this.m = G(o);
        } else if (iC == 8) {
            this.m = G(n);
        } else if (iC == 10) {
            this.m = H();
        } else if (iC != 11) {
            throw new vy2("Expected a double but was " + p() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double d = Double.parseDouble(this.m);
            if (this.e || !(Double.isNaN(d) || Double.isInfinite(d))) {
                this.m = null;
                this.j = 0;
                int[] iArr2 = this.d;
                int i2 = this.f2529a - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return d;
            }
            throw new wy2("JSON forbids NaN and infinities: " + d + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new vy2("Expected a double but was " + this.m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int j() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 16) {
            long j = this.k;
            int i = (int) j;
            if (j == i) {
                this.j = 0;
                int[] iArr = this.d;
                int i2 = this.f2529a - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new vy2("Expected an int but was " + this.k + " at path " + getPath());
        }
        if (iC == 17) {
            this.m = this.i.readUtf8(this.l);
        } else if (iC == 9 || iC == 8) {
            String strG = iC == 9 ? G(o) : G(n);
            this.m = strG;
            try {
                int i3 = Integer.parseInt(strG);
                this.j = 0;
                int[] iArr2 = this.d;
                int i4 = this.f2529a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iC != 11) {
            throw new vy2("Expected an int but was " + p() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double d = Double.parseDouble(this.m);
            int i5 = (int) d;
            if (i5 == d) {
                this.m = null;
                this.j = 0;
                int[] iArr3 = this.d;
                int i6 = this.f2529a - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new vy2("Expected an int but was " + this.m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new vy2("Expected an int but was " + this.m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String k() throws IOException {
        String strG;
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 14) {
            strG = H();
        } else if (iC == 13) {
            strG = G(o);
        } else if (iC == 12) {
            strG = G(n);
        } else {
            if (iC != 15) {
                throw new vy2("Expected a name but was " + p() + " at path " + getPath());
            }
            strG = this.m;
        }
        this.j = 0;
        this.c[this.f2529a - 1] = strG;
        return strG;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String m() throws IOException {
        String utf8;
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 10) {
            utf8 = H();
        } else if (iC == 9) {
            utf8 = G(o);
        } else if (iC == 8) {
            utf8 = G(n);
        } else if (iC == 11) {
            utf8 = this.m;
            this.m = null;
        } else if (iC == 16) {
            utf8 = Long.toString(this.k);
        } else {
            if (iC != 17) {
                throw new vy2("Expected a string but was " + p() + " at path " + getPath());
            }
            utf8 = this.i.readUtf8(this.l);
        }
        this.j = 0;
        int[] iArr = this.d;
        int i = this.f2529a - 1;
        iArr[i] = iArr[i] + 1;
        return utf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token p() throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        switch (iC) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int r(JsonReader.a aVar) throws IOException {
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC < 12 || iC > 15) {
            return -1;
        }
        if (iC == 15) {
            return D(this.m, aVar);
        }
        int iSelect = this.h.select(aVar.b);
        if (iSelect != -1) {
            this.j = 0;
            this.c[this.f2529a - 1] = aVar.f2530a[iSelect];
            return iSelect;
        }
        String str = this.c[this.f2529a - 1];
        String strK = k();
        int iD = D(strK, aVar);
        if (iD == -1) {
            this.j = 15;
            this.m = strK;
            this.c[this.f2529a - 1] = str;
        }
        return iD;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void s() throws IOException {
        if (this.f) {
            throw new vy2("Cannot skip unexpected " + p() + " at " + getPath());
        }
        int iC = this.j;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 14) {
            O();
        } else if (iC == 13) {
            L(o);
        } else if (iC == 12) {
            L(n);
        } else if (iC != 15) {
            throw new vy2("Expected a name but was " + p() + " at path " + getPath());
        }
        this.j = 0;
        this.c[this.f2529a - 1] = b.m;
    }

    public String toString() {
        return "JsonReader(" + this.h + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void x() throws IOException {
        if (this.f) {
            throw new vy2("Cannot skip unexpected " + p() + " at " + getPath());
        }
        int i = 0;
        do {
            int iC = this.j;
            if (iC == 0) {
                iC = C();
            }
            if (iC == 3) {
                q(1);
            } else if (iC == 1) {
                q(3);
            } else {
                if (iC == 4) {
                    i--;
                    if (i < 0) {
                        throw new vy2("Expected a value but was " + p() + " at path " + getPath());
                    }
                    this.f2529a--;
                } else if (iC == 2) {
                    i--;
                    if (i < 0) {
                        throw new vy2("Expected a value but was " + p() + " at path " + getPath());
                    }
                    this.f2529a--;
                } else if (iC == 14 || iC == 10) {
                    O();
                } else if (iC == 9 || iC == 13) {
                    L(o);
                } else if (iC == 8 || iC == 12) {
                    L(n);
                } else if (iC == 17) {
                    this.i.skip(this.l);
                } else if (iC == 18) {
                    throw new vy2("Expected a value but was " + p() + " at path " + getPath());
                }
                this.j = 0;
            }
            i++;
            this.j = 0;
        } while (i != 0);
        int[] iArr = this.d;
        int i2 = this.f2529a;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.c[i2 - 1] = b.m;
    }
}
