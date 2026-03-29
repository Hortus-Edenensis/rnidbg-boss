package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.conversations.recallbar.bean.RecallBarBean;
import com.zenmen.palmchat.conversations.recallbar.bean.RecallBarEvent;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rt4 {
    public static final String b = "rt4";
    public static rt4 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecallBarBean f20567a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("type", Integer.valueOf(rt4.this.f20567a.getType()));
        }
    }

    public rt4() {
        this.f20567a = null;
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, k86.a("key_recall_bar_content"), "");
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        this.f20567a = (RecallBarBean) az2.a(strN, RecallBarBean.class);
    }

    public static rt4 b() {
        if (c == null) {
            synchronized (rt4.class) {
                if (c == null) {
                    c = new rt4();
                }
            }
        }
        return c;
    }

    public RecallBarBean c() {
        return this.f20567a;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LogUtil.d(b, "receiveMsg: " + str);
        RecallBarBean recallBarBean = (RecallBarBean) az2.a(str, RecallBarBean.class);
        this.f20567a = recallBarBean;
        if (recallBarBean != null) {
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_recall_bar_content"), str);
            ds0.a().b(new RecallBarEvent());
            LogUtil.uploadInfoImmediate("recallbar_0", new a());
        }
    }

    public void e() {
        this.f20567a = null;
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_recall_bar_content"), "");
    }
}
