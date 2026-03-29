package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zd2 {
    public static int a(String str) {
        return SPUtil.f14322a.f(SPUtil.SCENE.CIRCLE, "key_group_ext_type_" + AccountUtils.p(AppContext.getContext()) + "_" + str, 0);
    }

    public static int b(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.startsWith(str2)) ? 0 : 1;
    }

    public static void c(String str, int i) {
        SPUtil.f14322a.t(SPUtil.SCENE.CIRCLE, "key_group_ext_type_" + AccountUtils.p(AppContext.getContext()) + "_" + str, Integer.valueOf(i));
    }
}
