package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class h84 {
    public static boolean a() {
        return d("LX-32002");
    }

    public static boolean b() {
        return d("LX-32089");
    }

    public static boolean c() {
        return d("LX-32286");
    }

    public static boolean d(String str) {
        boolean zA = jo6.a(str, false);
        LogUtil.i("OpenApiTaichiUtils", String.format("is%sOpen =", str, Boolean.valueOf(zA)));
        return zA;
    }
}
