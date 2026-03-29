package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o90 {
    public static int a(String str) {
        return SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).getInt("key_thread_has_greet_of_" + AccountUtils.p(AppContext.getContext()) + "_" + str, 0);
    }

    public static void b(String str, int i) {
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putInt("key_thread_has_greet_of_" + AccountUtils.p(AppContext.getContext()) + "_" + str, i).apply();
    }
}
