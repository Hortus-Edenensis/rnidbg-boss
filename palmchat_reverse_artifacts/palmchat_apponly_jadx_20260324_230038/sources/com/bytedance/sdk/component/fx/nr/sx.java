package com.bytedance.sdk.component.fx.nr;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class sx {
    public final String[] u;

    public sx(u uVar) {
        List<String> list = uVar.u;
        this.u = (String[]) list.toArray(new String[list.size()]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof sx) && Arrays.equals(((sx) obj).u, this.u);
    }

    public Map<String, List<String>> fx() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iU = u();
        for (int i = 0; i < iU; i++) {
            String lowerCase = u(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(nr(i));
        }
        return treeMap;
    }

    public int hashCode() {
        return Arrays.hashCode(this.u);
    }

    public String nr(int i) {
        return this.u[(i * 2) + 1];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iU = u();
        for (int i = 0; i < iU; i++) {
            sb.append(u(i));
            sb.append(": ");
            sb.append(nr(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String u(String str) {
        return u(this.u, str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        final List<String> u = new ArrayList(20);

        private void b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.fx.nr.u.fx.u("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.fx.nr.u.fx.u("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public u fx(String str, String str2) {
            try {
                b(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                                sb.append(cCharAt);
                            } else {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException unused2) {
                    }
                }
                return this;
            }
            nr(str);
            nr(str, str2);
            return this;
        }

        public u nr(String str, String str2) {
            this.u.add(str);
            this.u.add(str2.trim());
            return this;
        }

        public u u(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? nr(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? nr("", str.substring(1)) : nr("", str);
        }

        public u nr(String str) {
            int i = 0;
            while (i < this.u.size()) {
                if (str.equalsIgnoreCase(this.u.get(i))) {
                    this.u.remove(i);
                    this.u.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public u u(String str, String str2) {
            try {
                b(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException unused2) {
                        return this;
                    }
                }
                return this;
            }
            return nr(str, str2);
        }

        public sx u() {
            return new sx(this);
        }
    }

    public List<String> nr(String str) {
        int iU = u();
        ArrayList arrayList = null;
        for (int i = 0; i < iU; i++) {
            if (str.equalsIgnoreCase(u(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(nr(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public int u() {
        return this.u.length / 2;
    }

    private sx(String[] strArr) {
        this.u = strArr;
    }

    public String u(int i) {
        return this.u[i * 2];
    }

    private static String u(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static sx u(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i = 0; i < strArr2.length; i++) {
                    String str = strArr2[i];
                    if (str != null) {
                        strArr2[i] = str.trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                    String str2 = strArr2[i2];
                    String str3 = strArr2[i2 + 1];
                    if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                        throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
                    }
                }
                return new sx(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    public u nr() {
        u uVar = new u();
        Collections.addAll(uVar.u, this.u);
        return uVar;
    }
}
