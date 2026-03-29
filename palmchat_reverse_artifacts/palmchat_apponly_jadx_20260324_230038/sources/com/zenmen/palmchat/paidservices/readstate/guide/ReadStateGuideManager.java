package com.zenmen.palmchat.paidservices.readstate.guide;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.paidservices.readstate.guide.GuideConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.fg6;
import defpackage.ir5;
import defpackage.lt4;
import defpackage.u0;
import defpackage.u93;
import defpackage.vs0;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ReadStateGuideManager {
    public static ReadStateGuideManager b = new ReadStateGuideManager();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GuideConfig f14772a = null;

    /* JADX INFO: compiled from: SearchBox */
    public enum Scene {
        TYPE_FIRSTMSG("1", 69),
        TYPE_SENDMSG("2", 72),
        TYPE_ENTERCHAT("3", 73);

        public int from;
        public String value;

        Scene(String str, int i) {
            this.value = str;
            this.from = i;
        }

        public static Scene getScene(String str) {
            for (Scene scene : values()) {
                if (scene.value.equals(str)) {
                    return scene;
                }
            }
            return TYPE_ENTERCHAT;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f14773a;

        public a(ChatItem chatItem) {
            this.f14773a = chatItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageVo messageVoG = u0.g(this.f14773a);
            messageVoG.status = 2;
            messageVoG.mimeType = 10000;
            GuideConfig guideConfigD = ReadStateGuideManager.e().d();
            messageVoG.text = (guideConfigD == null || TextUtils.isEmpty(guideConfigD.svip_success)) ? "消息已读权益已到账，已开始自动更新状态，去发消息吧～" : guideConfigD.svip_success;
            b.t(messageVoG);
        }
    }

    public static ReadStateGuideManager e() {
        return b;
    }

    public final boolean a(String str, String str2) {
        boolean z = false;
        if (!fg6.d(AppContext.getContext())) {
            int iB = (int) (ir5.b() / 86400000);
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            int iH = sPUtil.h(scene, "key_read_state_guide_day_total_count" + iB, 0);
            boolean zC = sPUtil.c(scene, "key_read_state_guide_day_uid_has_guide" + str + iB, false);
            long jK = sPUtil.k(scene, "key_read_state_guide_last_guide_time", 0L);
            if (d().totalNum > iH && !zC && Math.abs(ir5.b() - jK) > d().intervalSeconds * 1000) {
                z = true;
            }
            LogUtil.i("ReadStateGuideManager", "canGuide start dayCount= " + iH + " uidHasGuideDay =" + zC + " lastguideTime =" + jK);
        }
        LogUtil.i("ReadStateGuideManager", "canGuide uid = " + str + " type =" + str2 + " result =" + z);
        return z;
    }

    public void b(ChatItem chatItem, ArrayList<MessageVo> arrayList) {
        GuideConfig.Msgs msgs = d().Msgs;
        if (msgs == null || msgs.num <= 0 || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int iB = (int) (ir5.b() / 86400000);
        int i = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            MessageVo messageVo = arrayList.get(size);
            if (lt4.h(messageVo)) {
                boolean z = messageVo.isSend;
                if (!z || messageVo.status != 2) {
                    if (!z) {
                        break;
                    }
                } else {
                    int i2 = (int) (messageVo.time / 86400000);
                    if (i > msgs.num || i2 != iB) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (i < msgs.num || !a(chatItem.getChatId(), "sendmsg")) {
            return;
        }
        j(chatItem.getChatId());
        f(chatItem, msgs.text, Scene.TYPE_SENDMSG);
    }

    public void c(ChatItem chatItem, int i) {
        GuideConfig.Visits visits = d().visits;
        if (visits == null || i < visits.num || !a(chatItem.getChatId(), "visit")) {
            return;
        }
        j(chatItem.getChatId());
        f(chatItem, visits.text, Scene.TYPE_ENTERCHAT);
    }

    public GuideConfig d() {
        JSONObject config;
        GuideConfig guideConfig;
        if (this.f14772a == null && (config = vs0.a().getConfig("vip_msgstatus")) != null && (guideConfig = (GuideConfig) az2.a(config.toString(), GuideConfig.class)) != null) {
            this.f14772a = guideConfig;
        }
        if (this.f14772a == null) {
            this.f14772a = new GuideConfig();
        }
        return this.f14772a;
    }

    public final void f(ChatItem chatItem, String str, Scene scene) {
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.status = 2;
        messageVoG.mimeType = 12346;
        messageVoG.text = str;
        messageVoG.data2 = scene.value;
        b.u(messageVoG, false);
    }

    public void g(ChatItem chatItem) {
        if (lt4.g()) {
            u93.e(new a(chatItem));
        }
    }

    public boolean h() {
        GuideConfig.FirstMsg firstMsg;
        return lt4.g() && (firstMsg = d().firstMsg) != null && firstMsg.enable;
    }

    public boolean i(String str) {
        GuideConfig.FirstMsg firstMsg;
        if (lt4.g() && (firstMsg = d().firstMsg) != null && firstMsg.enable) {
            return a(str, "firstMsg");
        }
        return false;
    }

    public void j(String str) {
        LogUtil.i("ReadStateGuideManager", "onInsertGuideMsg uid = " + str);
        int iB = (int) (ir5.b() / 86400000);
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        sPUtil.v(scene, "key_read_state_guide_day_total_count" + iB, Integer.valueOf(sPUtil.h(scene, "key_read_state_guide_day_total_count" + iB, 0) + 1));
        sPUtil.v(scene, "key_read_state_guide_day_uid_has_guide" + str + iB, Boolean.TRUE);
        sPUtil.v(scene, "key_read_state_guide_last_guide_time", Long.valueOf(ir5.b()));
    }

    public int k(ChatItem chatItem) {
        if (d().visits == null) {
            return 0;
        }
        int iB = (int) (ir5.b() / 86400000);
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        int iH = sPUtil.h(scene, "key_read_state_guide_enter_chat" + chatItem.getChatId() + iB, 0);
        StringBuilder sb = new StringBuilder();
        sb.append("onEnterChat dayCount = ");
        sb.append(iH);
        LogUtil.i("ReadStateGuideManager", sb.toString());
        int i = iH + 1;
        sPUtil.v(scene, "key_read_state_guide_enter_chat" + chatItem.getChatId() + iB, Integer.valueOf(i));
        return i;
    }
}
