package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class ht0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18045a;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z = !TextUtils.isEmpty(str);
        boolean z2 = !TextUtils.isEmpty(Build.ID);
        boolean z3 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb.append("MultiThreadDownloader");
        if (z) {
            sb.append("/");
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z) {
            sb.append(" ");
            sb.append(str);
        }
        if (z3 || z2) {
            sb.append(x.aQ);
            if (z3) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z2) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        f18045a = sb.toString();
    }

    public static List<bt0> a(List<bt0> list, String str, String str2) {
        list.add(new bt0(str, str2));
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(String str, String str2) {
        boolean z;
        z = false;
        try {
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(file, str2);
                if (!file2.exists()) {
                    if (file2.createNewFile()) {
                        z = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return z;
    }

    public static boolean c(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static boolean d(String str, List<bt0> list) {
        Iterator<bt0> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().f1813a.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<bt0> e(List<bt0> list, ct0 ct0Var) {
        if (list == null || list.isEmpty()) {
            list = new ArrayList<>();
            list.add(new bt0(HttpHeaders.ACCEPT, "image/gif, image/jpeg, image/pjpeg, image/pjpeg,application/x-shockwave-flash, application/xaml+xml,application/vnd.ms-xpsdocument, application/x-ms-xbap,application/x-ms-application, application/vnd.ms-excel,application/vnd.ms-powerpoint, application/msword, */*"));
            list.add(new bt0(HttpHeaders.ACCEPT_RANGES, "bytes"));
            list.add(new bt0("Charset", "UTF-8"));
            list.add(new bt0("Connection", HTTP.CONN_KEEP_ALIVE));
            list.add(new bt0(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING));
            list.add(new bt0(HttpHeaders.RANGE, "bytes=0-"));
        }
        if (!d("User-Agent", list)) {
            list.add(new bt0("User-Agent", f18045a));
        }
        if (!TextUtils.isEmpty(ct0Var.l)) {
            list.add(new bt0(HttpHeaders.IF_MATCH, ct0Var.l));
        }
        return list;
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase();
        int iIndexOf = lowerCase.indexOf(59);
        return iIndexOf != -1 ? lowerCase.substring(0, iIndexOf) : lowerCase;
    }

    public static String h(String str, String str2, String str3) {
        String string;
        String strDecode;
        int iLastIndexOf;
        String strDecode2;
        int iLastIndexOf2;
        if (str2 != null) {
            string = i(str2);
            if (string != null && (iLastIndexOf2 = string.lastIndexOf(47) + 1) > 0) {
                string = string.substring(iLastIndexOf2);
            }
        } else {
            string = null;
        }
        if (string == null && str3 != null && (strDecode2 = Uri.decode(str3)) != null && !strDecode2.endsWith("/") && strDecode2.indexOf(63) < 0) {
            int iLastIndexOf3 = strDecode2.lastIndexOf(47) + 1;
            string = iLastIndexOf3 > 0 ? strDecode2.substring(iLastIndexOf3) : strDecode2;
        }
        if (string == null && (strDecode = Uri.decode(str)) != null && !strDecode.endsWith("/") && strDecode.indexOf(63) < 0 && (iLastIndexOf = strDecode.lastIndexOf(47) + 1) > 0) {
            string = strDecode.substring(iLastIndexOf);
        }
        if (string == null) {
            string = UUID.randomUUID().toString();
        }
        return j(string);
    }

    public static String i(String str) {
        int iIndexOf = str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
        if (iIndexOf > 0) {
            return str.substring(iIndexOf + 1);
        }
        return null;
    }

    public static String j(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 31 && cCharAt != '\"' && cCharAt != '*' && cCharAt != '/' && cCharAt != ':' && cCharAt != '<' && cCharAt != '>' && cCharAt != '?' && cCharAt != '\\' && cCharAt != '|' && cCharAt != 127) {
                sb.append(cCharAt);
                z = false;
            } else if (!z) {
                sb.append('_');
                z = true;
            }
        }
        return sb.toString();
    }
}
