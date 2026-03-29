package defpackage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.bean.CircleWarnBean;
import com.zenmen.palmchat.circle.bean.CircleWarnEvent;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class sc0 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends a41 {
        @Override // defpackage.ln2
        public boolean a(MessageProto.Message message) {
            return sc0.d(message);
        }

        @Override // defpackage.a41, defpackage.ln2
        public void d(MessageProto.Message message) {
            sc0.h(message);
        }
    }

    public static boolean b(CircleWarnBean circleWarnBean) {
        CircleWarnBean.WarnExt warnExt;
        CircleWarnBean.WarnUserTo warnUserTo;
        return (circleWarnBean == null || (warnExt = circleWarnBean.info) == null || TextUtils.isEmpty(warnExt.roomId) || TextUtils.isEmpty(warnExt.content) || (warnUserTo = warnExt.to) == null || TextUtils.isEmpty(warnUserTo.toUserId)) ? false : true;
    }

    public static void c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putString(e(str2, str), "").apply();
    }

    public static boolean d(MessageProto.Message message) {
        return message.getType() == 56 && fu5.o(message) == 1;
    }

    public static String e(String str, String str2) {
        return "circle_warn_key" + str + str2;
    }

    public static CircleWarnBean f(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String string = SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).getString(e(str2, str), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        CircleWarnBean circleWarnBean = (CircleWarnBean) az2.a(string, CircleWarnBean.class);
        if (b(circleWarnBean)) {
            return circleWarnBean;
        }
        return null;
    }

    public static boolean g(String str, String str2, String str3) {
        return str != null && str.equals(str3) && AccountUtils.p(AppContext.getContext()).equals(str2);
    }

    public static void h(MessageProto.Message message) {
        i(message);
    }

    public static void i(MessageProto.Message message) {
        if (message == null || message.getExtension() == null) {
            return;
        }
        CircleWarnBean circleWarnBean = (CircleWarnBean) az2.a(message.getExtension(), CircleWarnBean.class);
        if (b(circleWarnBean)) {
            CircleWarnBean.WarnUserTo warnUserTo = circleWarnBean.info.to;
            warnUserTo.toUserId = DomainHelper.q(warnUserTo.toUserId);
            SharedPreferences.Editor editorEdit = SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit();
            CircleWarnBean.WarnExt warnExt = circleWarnBean.info;
            editorEdit.putString(e(warnExt.roomId, warnExt.to.toUserId), az2.c(circleWarnBean)).apply();
            CircleWarnBean.WarnExt warnExt2 = circleWarnBean.info;
            ds0.a().b(new CircleWarnEvent(warnExt2.roomId, warnExt2.to.toUserId, warnExt2.content));
        }
    }
}
