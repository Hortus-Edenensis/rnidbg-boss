package defpackage;

import android.text.TextUtils;
import com.zenmen.openapi.OpenApiManager;
import com.zenmen.openapi.offline.request.FetchPkgInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1656a = OpenApiManager.getContext().getFilesDir().getAbsolutePath() + "/OfflineRes";
    public static b64 b;

    public static int a(String str, String str2) {
        int i = 0;
        try {
            String strE = e(str);
            String strE2 = e(str2);
            String[] strArrSplit = strE.split("\\.");
            String[] strArrSplit2 = strE2.split("\\.");
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            int i2 = 0;
            while (i < iMax) {
                try {
                    String str3 = i < strArrSplit.length ? strArrSplit[i] : "0";
                    String str4 = i < strArrSplit2.length ? strArrSplit2[i] : "0";
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "0";
                    }
                    i2 = Integer.parseInt(e(str3)) - Integer.parseInt(e(TextUtils.isEmpty(str4) ? "0" : str4));
                    if (i2 != 0) {
                        return i2;
                    }
                    i++;
                } catch (Exception e) {
                    e = e;
                    i = i2;
                    e.printStackTrace();
                    return i;
                }
            }
            return i2;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static b64 b() {
        if (b == null) {
            synchronized (b64.class) {
                if (b == null) {
                    b = new b64();
                }
            }
        }
        return b;
    }

    public static String e(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    public String c(String str) {
        ex4 ex4VarA = a64.a(str);
        if (ex4VarA != null) {
            boolean zA = ex4VarA.a();
            ma3.a("offline res canLoadOffline:" + zA, new Object[0]);
            if (!zA) {
                return "";
            }
        }
        return f1656a + File.separator + str;
    }

    public String d(String str) {
        String strB = ya3.b(OpenApiManager.getContext(), "offline_res", "offline_res_ver" + str, "");
        ma3.a("offline res appId:" + str + " ver:" + strB, new Object[0]);
        return strB;
    }

    public void f(List<FetchPkgInfo> list) {
        if (list != null && list.size() > 0) {
            zn6.d("wp_push_received", null, list.toString());
        }
        Iterator<FetchPkgInfo> it = list.iterator();
        while (it.hasNext()) {
            new z54(it.next()).f();
        }
    }
}
