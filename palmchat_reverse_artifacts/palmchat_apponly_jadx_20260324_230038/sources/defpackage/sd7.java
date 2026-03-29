package defpackage;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.log.env.oversea.AreaEnv;
import com.oplus.log.env.test.TestAreaEnv;
import defpackage.b37;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class sd7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20726a = "";
    public static String b = "222%23";
    public static String c;

    public static String a() {
        String hostTest;
        try {
            hostTest = TestAreaEnv.getHostTest();
        } catch (Throwable unused) {
            hostTest = "";
        }
        try {
            return k17.k() ? hostTest : o17.e() ? o17.g() ? AreaEnv.getIndiaHost() : AreaEnv.getSingaporeHost() : kw6.a();
        } catch (Throwable th) {
            if (k17.k()) {
                Log.e("NearX-HLog", "makeUploadUrl-->".concat(String.valueOf(th)));
                th.printStackTrace();
            } else {
                Log.e("NearX-HLog", "makeUploadUrl--> Don't find AreaEnv class");
            }
            return "";
        }
    }

    public static String b(b37.b bVar) {
        return bVar == null ? "" : bVar.a();
    }

    public static String c(b37.c cVar) {
        if (cVar == null) {
            return "";
        }
        return (cVar.a() == null ? "" : cVar.a()) + "/" + (cVar.b() == null ? "" : cVar.b()) + "/" + (cVar.c() != null ? cVar.c() : "");
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(c)) {
                c = b + jw6.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            return (TextUtils.isEmpty(c) || b.equals(c)) ? str : c;
        } catch (Exception e) {
            if (!k17.k()) {
                return str;
            }
            e.printStackTrace();
            return str;
        }
    }

    public static String e(String str, String str2, b37.b bVar, b37.c cVar, String str3) {
        return ((a() + "/usertrace/log/business/config").replace("business", str) + "?subType=" + str2 + "&imei=" + h(b(bVar)) + "&openId=" + d(c(cVar)) + "&tracePkg=" + str3).replaceAll(" ", "_");
    }

    public static String f(String str, String str2, String str3, int i, String str4, String str5, b37.b bVar, b37.c cVar, String str6) {
        StringBuilder sb = new StringBuilder((a() + "/usertrace/log/business/upload").replace("business", str));
        sb.append("?traceId=");
        sb.append(str2);
        sb.append("&businessVersion=");
        sb.append(o17.f(o17.a()));
        sb.append("&protocolVersion=3&errorCode=");
        sb.append(i);
        sb.append("&subType=");
        sb.append(str5);
        sb.append("&brand=");
        sb.append(cc7.b());
        sb.append("&model=");
        sb.append(Build.MODEL);
        sb.append("&osVersion=");
        sb.append(cc7.c());
        sb.append("&romVersion=");
        sb.append(cc7.a());
        sb.append("&androidVersion=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("&imei=");
        sb.append(h(b(bVar)));
        sb.append("&openId=");
        sb.append(d(c(cVar)));
        sb.append("&tracePkg=");
        sb.append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=");
            sb.append(str4);
        }
        return sb.toString().replaceAll(" ", "_");
    }

    public static String g(String str, String str2, String str3, int i, String str4, String str5, b37.b bVar, b37.c cVar, String str6, String str7, String str8, long j, String str9, String str10, cw6 cw6Var) {
        String strReplace = (a() + "/usertrace/log/business/report").replace("business", str);
        String strH = h(b(bVar));
        String strD = d(c(cVar));
        String strA = ag7.a(str2, str8, j, i, str5, strH, strD, str6, str7, str3, str4, str9, str10, cw6Var);
        StringBuilder sb = new StringBuilder(strReplace);
        sb.append("?specificId=");
        sb.append(str2);
        sb.append("&reportReason=");
        sb.append(URLEncoder.encode(str8));
        sb.append("&program=");
        sb.append(str7);
        sb.append("&ts=");
        sb.append(j);
        sb.append("&sign=");
        sb.append(strA);
        sb.append("&businessVersion=");
        sb.append(o17.f(o17.a()));
        sb.append("&protocolVersion=3&errorCode=");
        sb.append(i);
        sb.append("&subType=");
        sb.append(str5);
        sb.append("&brand=");
        sb.append(cc7.b());
        sb.append("&model=");
        sb.append(Build.MODEL);
        sb.append("&osVersion=");
        sb.append(cc7.c());
        sb.append("&romVersion=");
        sb.append(cc7.a());
        sb.append("&androidVersion=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("&imei=");
        sb.append(strH);
        sb.append("&openId=");
        sb.append(strD);
        sb.append("&tracePkg=");
        sb.append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=");
            sb.append(str4);
        }
        String string = sb.toString();
        cw6Var.a("NearX-HLog", "签名后请求空格替换前参数: data: ".concat(String.valueOf(string)));
        String strReplaceAll = string.replaceAll(" ", "_");
        cw6Var.a("NearX-HLog", "签名后请求空格替换后参数: data: ".concat(String.valueOf(strReplaceAll)));
        return strReplaceAll;
    }

    public static String h(String str) {
        try {
            if (TextUtils.isEmpty(f20726a)) {
                f20726a = b + jw6.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            return (TextUtils.isEmpty(f20726a) || b.equals(f20726a)) ? str : f20726a;
        } catch (Exception e) {
            if (!k17.k()) {
                return str;
            }
            e.printStackTrace();
            return str;
        }
    }
}
