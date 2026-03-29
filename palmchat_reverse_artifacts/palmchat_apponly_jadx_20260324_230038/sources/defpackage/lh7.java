package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class lh7 {
    public static String a(Context context) {
        if (EnvUtils.a()) {
            return "https://mobilegw.alipaydev.com/mgw.htm";
        }
        if (context == null) {
            return hu6.f18056a;
        }
        String str = hu6.f18056a;
        return TextUtils.isEmpty(str) ? hu6.f18056a : str;
    }
}
