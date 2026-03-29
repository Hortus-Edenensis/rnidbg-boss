package com.opos.cmn.func.dl.base.i;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.opos.cmn.an.b.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8009a = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);

    public static int a(String str, String str2) {
        return (str + File.separator + str2).hashCode();
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.opos.cmn.an.f.a.c("DownloadUtils", "parse instance length failed with ".concat(str));
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Matcher matcher = f8009a.matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String d(String str) {
        String strE = e(str);
        return TextUtils.isEmpty(strE) ? a(str) : strE;
    }

    private static String e(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                String path = new URL(str).getPath();
                String strSubstring = path.substring(path.lastIndexOf(47) + 1);
                if (strSubstring.isEmpty()) {
                    return null;
                }
                return strSubstring;
            } catch (MalformedURLException unused) {
            }
        }
        return null;
    }

    public static String a(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & UByte.MAX_VALUE;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 should be supported", e);
        }
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        if (!com.opos.cmn.an.e.b.a.b(com.opos.cmn.an.e.b.a.d(file))) {
            com.opos.cmn.an.e.b.a.c(file);
        }
        com.opos.cmn.an.e.b.a.f(file);
    }

    public static void a(Closeable... closeableArr) {
        try {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (IOException e) {
            com.opos.cmn.an.f.a.c("DownloadUtils", e.getMessage());
        }
    }

    public static boolean a(int i) {
        return i == 200 || i == 206;
    }

    public static boolean a(long j, File file) {
        boolean z = true;
        if (j > 0 && j != file.length()) {
            z = false;
        }
        com.opos.cmn.an.f.a.a("DownloadUtils", "length check:".concat(String.valueOf(z)));
        return z;
    }

    public static boolean a(Context context) {
        return context.checkCallingOrSelfPermission(g.j) == 0 && context.checkCallingOrSelfPermission(g.i) == 0;
    }

    public static boolean a(String str, File file) {
        boolean zEquals = !TextUtils.isEmpty(str) ? str.equals(c.a(file)) : true;
        com.opos.cmn.an.f.a.a("DownloadUtils", "md5 check:".concat(String.valueOf(zEquals)));
        return zEquals;
    }
}
