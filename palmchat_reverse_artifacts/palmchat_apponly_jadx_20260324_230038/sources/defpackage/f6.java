package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17462a = true;

    public static void a(String str) {
        b(str);
    }

    public static void b(String str) {
        LogUtil.d("", "AdDiscountInfoSwitch initExt ext " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int iOptInt = new JSONObject(str).optInt("switch", 1);
            if (iOptInt == 0) {
                f17462a = false;
            } else if (iOptInt == 1) {
                f17462a = true;
            }
            LogUtil.d("", "AdDiscountInfoSwitch initExt infoSwitch " + f17462a);
        } catch (Exception unused) {
        }
    }

    public static void c(String str) {
        b(str);
    }
}
