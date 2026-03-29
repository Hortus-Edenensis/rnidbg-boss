package defpackage;

import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.Vo.UserRiskVo;
import com.zenmen.palmchat.framework.bridge.risk.ChatRiskNotifyEvent;
import com.zenmen.palmchat.framework.bridge.risk.RiskConfig;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hb3 implements lo2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17918a = false;
    public static volatile hb3 b;

    public static hb3 g() {
        if (b == null) {
            synchronized (hb3.class) {
                if (b == null) {
                    b = new hb3();
                }
            }
        }
        return b;
    }

    @Override // defpackage.lo2
    public String a() {
        if (!i() || h() == null) {
            return null;
        }
        if (Math.abs(SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_risk_squarw_comment_close_click_time"), 0L) - ir5.b()) > ((long) ((h().post_show * 60) * 60)) * 1000) {
            return h().post_defaulttxt;
        }
        return null;
    }

    @Override // defpackage.lo2
    public void b() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_risk_squarw_msg_close_click_time"), Long.valueOf(ir5.b()));
    }

    @Override // defpackage.lo2
    public void c() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_risk_squarw_comment_close_click_time"), Long.valueOf(ir5.b()));
    }

    @Override // defpackage.lo2
    public String d(int i) {
        LogUtil.i("LxRiskNotifyManager", "getHalfChatNotify " + i);
        if (!i() || h() == null) {
            return null;
        }
        return i == -4 ? h().half_nofchat_50 : i == -3 ? h().half_nofchat_40 : h().half_nofchat_normal;
    }

    @Override // defpackage.lo2
    public String e() {
        if (!i() || h() == null) {
            return null;
        }
        if (Math.abs(SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_risk_squarw_msg_close_click_time"), 0L) - ir5.b()) > ((long) ((h().noticenter_show * 60) * 60)) * 1000) {
            return h().noticenter_defaulttxt;
        }
        return null;
    }

    public String f() {
        if (h() != null) {
            return h().chat_block;
        }
        return null;
    }

    public RiskConfig h() {
        return y66.b().d();
    }

    public boolean i() {
        return t66.h().f("LX-64775", false) || f17918a;
    }

    public boolean j(String str) {
        if (!i()) {
            return false;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        StringBuilder sb = new StringBuilder();
        sb.append("key_chat_risk_warning");
        sb.append(str);
        return sPUtil.a(scene, k86.a(sb.toString()), false);
    }

    public final boolean k(String str) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (sPUtil.f(scene, k86.a("key_chat_risk_banner_ignore_warning_click_count" + str), 0) >= 2) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("key_chat_risk_banner_ignore_warning_click_time");
        sb.append(str);
        return !by5.k(sPUtil.i(scene, k86.a(sb.toString()), 0L));
    }

    public void l(String str, boolean z) {
        if (!z) {
            y66.b().h(str);
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        sPUtil.t(scene, k86.a("key_chat_risk_banner_ignore_warning_click_count" + str), Integer.valueOf(sPUtil.f(scene, k86.a("key_chat_risk_banner_ignore_warning_click_count" + str), 0) + 1));
        sPUtil.t(scene, k86.a("key_chat_risk_banner_ignore_warning_click_time" + str), Long.valueOf(ir5.b()));
        sPUtil.t(scene, k86.a("key_chat_risk_warning" + str), Boolean.FALSE);
    }

    public void m(MessageProto.Message message) {
        UserRiskVo userRiskVo;
        String str;
        if (message == null || message.getExtension() == null) {
            return;
        }
        LogUtil.i("LxRiskNotifyManager", "onMsg" + message.getExtension());
        RichMsgVo richMsgVo = (RichMsgVo) az2.a(message.getExtension(), RichMsgVo.class);
        if (richMsgVo == null || (userRiskVo = richMsgVo.userRisk) == null || (str = userRiskVo.uid) == null) {
            return;
        }
        boolean zK = k(str);
        LogUtil.i("LxRiskNotifyManager", "onMsg needShowWarning=" + zK);
        if (zK) {
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_risk_warning" + richMsgVo.userRisk.uid), Boolean.TRUE);
            ds0.a().b(new ChatRiskNotifyEvent(richMsgVo.userRisk.uid));
        }
    }
}
