package com.bytedance.sdk.component.fx.nr;

import com.ss.android.download.api.constant.BaseConstants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class bg {
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5118a;
    final int fx;
    private final String iz;
    private final String jk;
    private final List<String> n;
    final String nr;
    private final String pn;
    final String u;
    private final List<String> x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        String b;
        final List<String> iz;
        String n;
        String u;
        List<String> x;
        String nr = "";
        String fx = "";
        int pn = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.fx.nr.bg$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public enum EnumC0215u {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public u() {
            ArrayList arrayList = new ArrayList();
            this.iz = arrayList;
            arrayList.add("");
        }

        private boolean iz(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean x(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public u b(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strPn = pn(str, 0, str.length());
            if (strPn != null) {
                this.b = strPn;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public u fx(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.fx = bg.u(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public u nr(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.nr = bg.u(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public u pn(String str) {
            this.x = str != null ? bg.nr(bg.u(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public u query(String str) {
            this.x = str != null ? bg.nr(bg.u(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.u);
            sb.append("://");
            if (!this.nr.isEmpty() || !this.fx.isEmpty()) {
                sb.append(this.nr);
                if (!this.fx.isEmpty()) {
                    sb.append(':');
                    sb.append(this.fx);
                }
                sb.append('@');
            }
            if (this.b.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.b);
                sb.append(']');
            } else {
                sb.append(this.b);
            }
            int iU = u();
            if (iU != bg.u(this.u)) {
                sb.append(':');
                sb.append(iU);
            }
            bg.u(sb, this.iz);
            if (this.x != null) {
                sb.append('?');
                bg.nr(sb, this.x);
            }
            if (this.n != null) {
                sb.append('#');
                sb.append(this.n);
            }
            return sb.toString();
        }

        public u u(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.u = HttpHost.DEFAULT_SCHEME_NAME;
            } else {
                if (!str.equalsIgnoreCase(BaseConstants.SCHEME_HTTPS)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.u = BaseConstants.SCHEME_HTTPS;
            }
            return this;
        }

        private static int iz(String str, int i, int i2) {
            int i3;
            try {
                i3 = Integer.parseInt(bg.u(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }

        private static String pn(String str, int i, int i2) {
            return com.bytedance.sdk.component.fx.nr.u.fx.u(bg.u(str, i, i2, false));
        }

        public bg fx() {
            if (this.u != null) {
                if (this.b != null) {
                    return new bg(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public u nr() {
            int size = this.iz.size();
            for (int i = 0; i < size; i++) {
                this.iz.set(i, bg.u(this.iz.get(i), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.x;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.x.get(i2);
                    if (str != null) {
                        this.x.set(i2, bg.u(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.n;
            if (str2 != null) {
                this.n = bg.u(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        private void b() {
            if (this.iz.remove(r0.size() - 1).isEmpty() && !this.iz.isEmpty()) {
                this.iz.set(r0.size() - 1, "");
            } else {
                this.iz.add("");
            }
        }

        public u u(int i) {
            if (i > 0 && i <= 65535) {
                this.pn = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        private static int fx(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int b(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        public int u() {
            int i = this.pn;
            return i != -1 ? i : bg.u(this.u);
        }

        public EnumC0215u u(bg bgVar, String str) {
            int iU;
            int i;
            int iU2 = com.bytedance.sdk.component.fx.nr.u.fx.u(str, 0, str.length());
            int iNr = com.bytedance.sdk.component.fx.nr.u.fx.nr(str, iU2, str.length());
            if (nr(str, iU2, iNr) != -1) {
                if (str.regionMatches(true, iU2, "https:", 0, 6)) {
                    this.u = BaseConstants.SCHEME_HTTPS;
                    iU2 += 6;
                } else if (str.regionMatches(true, iU2, "http:", 0, 5)) {
                    this.u = HttpHost.DEFAULT_SCHEME_NAME;
                    iU2 += 5;
                } else {
                    return EnumC0215u.UNSUPPORTED_SCHEME;
                }
            } else if (bgVar != null) {
                this.u = bgVar.u;
            } else {
                return EnumC0215u.MISSING_SCHEME;
            }
            int iFx = fx(str, iU2, iNr);
            char c = '?';
            char c2 = '#';
            if (iFx < 2 && bgVar != null && bgVar.u.equals(this.u)) {
                this.nr = bgVar.pn();
                this.fx = bgVar.iz();
                this.b = bgVar.nr;
                this.pn = bgVar.fx;
                this.iz.clear();
                this.iz.addAll(bgVar.jk());
                if (iU2 == iNr || str.charAt(iU2) == '#') {
                    pn(bgVar.t());
                }
            } else {
                int i2 = iU2 + iFx;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iU = com.bytedance.sdk.component.fx.nr.u.fx.u(str, i2, iNr, "@/\\?#");
                    byte bCharAt = iU != iNr ? str.charAt(iU) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iU3 = com.bytedance.sdk.component.fx.nr.u.fx.u(str, i2, iU, ':');
                            i = iU;
                            String strU = bg.u(str, i2, iU3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strU = this.nr + "%40" + strU;
                            }
                            this.nr = strU;
                            if (iU3 != i) {
                                this.fx = bg.u(str, iU3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iU;
                            this.fx += "%40" + bg.u(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iB = b(str, i2, iU);
                int i3 = iB + 1;
                if (i3 < iU) {
                    this.b = pn(str, i2, iB);
                    int iIz = iz(str, i3, iU);
                    this.pn = iIz;
                    if (iIz == -1) {
                        return EnumC0215u.INVALID_PORT;
                    }
                } else {
                    this.b = pn(str, i2, iB);
                    this.pn = bg.u(this.u);
                }
                if (this.b == null) {
                    return EnumC0215u.INVALID_HOST;
                }
                iU2 = iU;
            }
            int iU4 = com.bytedance.sdk.component.fx.nr.u.fx.u(str, iU2, iNr, "?#");
            u(str, iU2, iU4);
            if (iU4 < iNr && str.charAt(iU4) == '?') {
                int iU5 = com.bytedance.sdk.component.fx.nr.u.fx.u(str, iU4, iNr, '#');
                this.x = bg.nr(bg.u(str, iU4 + 1, iU5, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iU4 = iU5;
            }
            if (iU4 < iNr && str.charAt(iU4) == '#') {
                this.n = bg.u(str, 1 + iU4, iNr, "", true, false, false, false, null);
            }
            return EnumC0215u.SUCCESS;
        }

        private static int nr(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private void u(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt != '/' && cCharAt != '\\') {
                List<String> list = this.iz;
                list.set(list.size() - 1, "");
            } else {
                this.iz.clear();
                this.iz.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.component.fx.nr.u.fx.u(str, i3, i2, "/\\");
                boolean z = i < i2;
                u(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void u(String str, int i, int i2, boolean z, boolean z2) {
            String strU = bg.u(str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (iz(strU)) {
                return;
            }
            if (x(strU)) {
                b();
                return;
            }
            if (this.iz.get(r11.size() - 1).isEmpty()) {
                this.iz.set(r11.size() - 1, strU);
            } else {
                this.iz.add(strU);
            }
            if (z) {
                this.iz.add("");
            }
        }
    }

    public bg(u uVar) {
        this.u = uVar.u;
        this.pn = u(uVar.nr, false);
        this.iz = u(uVar.fx, false);
        this.nr = uVar.b;
        this.fx = uVar.u();
        this.x = u(uVar.iz, false);
        List<String> list = uVar.x;
        this.n = list != null ? u(list, true) : null;
        String str = uVar.n;
        this.f5118a = str != null ? u(str, false) : null;
        this.jk = uVar.toString();
    }

    public String a() {
        int iIndexOf = this.jk.indexOf(47, this.u.length() + 3);
        String str = this.jk;
        return this.jk.substring(iIndexOf, com.bytedance.sdk.component.fx.nr.u.fx.u(str, iIndexOf, str.length(), "?#"));
    }

    public boolean b() {
        return this.u.equals(BaseConstants.SCHEME_HTTPS);
    }

    public boolean equals(Object obj) {
        return (obj instanceof bg) && ((bg) obj).jk.equals(this.jk);
    }

    public String fx() {
        return this.u;
    }

    public int hashCode() {
        return this.jk.hashCode();
    }

    public String iz() {
        if (this.iz.isEmpty()) {
            return "";
        }
        return this.jk.substring(this.jk.indexOf(58, this.u.length() + 3) + 1, this.jk.indexOf(64));
    }

    public List<String> jk() {
        int iIndexOf = this.jk.indexOf(47, this.u.length() + 3);
        String str = this.jk;
        int iU = com.bytedance.sdk.component.fx.nr.u.fx.u(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iU) {
            int i = iIndexOf + 1;
            int iU2 = com.bytedance.sdk.component.fx.nr.u.fx.u(this.jk, i, iU, '/');
            arrayList.add(this.jk.substring(i, iU2));
            iIndexOf = iU2;
        }
        return arrayList;
    }

    public String l() {
        if (this.f5118a == null) {
            return null;
        }
        return this.jk.substring(this.jk.indexOf(35) + 1);
    }

    public String mv() {
        return b("/...").nr("").fx("").fx().toString();
    }

    public int n() {
        return this.fx;
    }

    public URI nr() {
        String string = s().nr().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String pn() {
        if (this.pn.isEmpty()) {
            return "";
        }
        int length = this.u.length() + 3;
        String str = this.jk;
        return this.jk.substring(length, com.bytedance.sdk.component.fx.nr.u.fx.u(str, length, str.length(), ":@"));
    }

    public String query() {
        if (this.n == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        nr(sb, this.n);
        return sb.toString();
    }

    public u s() {
        u uVar = new u();
        uVar.u = this.u;
        uVar.nr = pn();
        uVar.fx = iz();
        uVar.b = this.nr;
        uVar.pn = this.fx != u(this.u) ? this.fx : -1;
        uVar.iz.clear();
        uVar.iz.addAll(jk());
        uVar.pn(t());
        uVar.n = l();
        return uVar;
    }

    public String t() {
        if (this.n == null) {
            return null;
        }
        int iIndexOf = this.jk.indexOf(63) + 1;
        String str = this.jk;
        return this.jk.substring(iIndexOf, com.bytedance.sdk.component.fx.nr.u.fx.u(str, iIndexOf, str.length(), '#'));
    }

    public String toString() {
        return this.jk;
    }

    public URL u() {
        try {
            return new URL(this.jk);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String x() {
        return this.nr;
    }

    public u b(String str) {
        u uVar = new u();
        if (uVar.u(this, str) == u.EnumC0215u.SUCCESS) {
            return uVar;
        }
        return null;
    }

    public bg fx(String str) {
        u uVarB = b(str);
        if (uVarB != null) {
            return uVarB.fx();
        }
        return null;
    }

    public static int u(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        return str.equals(BaseConstants.SCHEME_HTTPS) ? 443 : -1;
    }

    public static bg pn(String str) {
        u uVar = new u();
        if (uVar.u(null, str) == u.EnumC0215u.SUCCESS) {
            return uVar.fx();
        }
        return null;
    }

    public static void u(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public static void nr(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static bg u(URL url) {
        return pn(url.toString());
    }

    public static String u(String str, boolean z) {
        return u(str, 0, str.length(), z);
    }

    private List<String> u(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? u(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static List<String> nr(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 != -1 && iIndexOf2 <= iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            } else {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static String u(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
                fxVar.u(str, i, i3);
                u(fxVar, str, i3, i2, z);
                return fxVar.k();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void u(com.bytedance.sdk.component.fx.u.fx fxVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iU = com.bytedance.sdk.component.fx.nr.u.fx.u(str.charAt(i + 1));
                int iU2 = com.bytedance.sdk.component.fx.nr.u.fx.u(str.charAt(i3));
                if (iU != -1 && iU2 != -1) {
                    fxVar.a((iU << 4) + iU2);
                    i = i3;
                }
            } else if (iCodePointAt == 43 && z) {
                fxVar.a(32);
            } else {
                fxVar.u(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static boolean u(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.fx.nr.u.fx.u(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.fx.nr.u.fx.u(str.charAt(i3)) != -1;
    }

    public static String u(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || u(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
                    fxVar.u(str, i, iCharCount);
                    u(fxVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return fxVar.k();
                }
            } else {
                com.bytedance.sdk.component.fx.u.fx fxVar2 = new com.bytedance.sdk.component.fx.u.fx();
                fxVar2.u(str, i, iCharCount);
                u(fxVar2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return fxVar2.k();
            }
        }
        return str.substring(i, i2);
    }

    public static void u(com.bytedance.sdk.component.fx.u.fx fxVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.fx.u.fx fxVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    fxVar.nr(z ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z && (!z2 || u(str, i, i2)))))) {
                    fxVar.u(iCodePointAt);
                } else {
                    if (fxVar2 == null) {
                        fxVar2 = new com.bytedance.sdk.component.fx.u.fx();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.component.fx.nr.u.fx.pn)) {
                        fxVar2.u(str, i, Character.charCount(iCodePointAt) + i, charset);
                    } else {
                        fxVar2.u(iCodePointAt);
                    }
                    while (!fxVar2.pn()) {
                        int iN = fxVar2.n() & UByte.MAX_VALUE;
                        fxVar.a(37);
                        char[] cArr = b;
                        fxVar.a((int) cArr[(iN >> 4) & 15]);
                        fxVar.a((int) cArr[iN & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static String u(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return u(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
