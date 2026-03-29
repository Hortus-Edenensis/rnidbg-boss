package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f19699a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static String b = "https://cds.y5cds.com/feeds.sec";

    public static String a() {
        return b;
    }

    public static void b(String str) {
        LogUtil.d("AdNetProcess", "updateConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b = new JSONObject(str).getString("domain");
            LogUtil.d("AdNetProcess", "domain = " + b);
        } catch (Exception unused) {
        }
    }
}
