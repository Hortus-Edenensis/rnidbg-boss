package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.contacts.bean.ConfigInfoVo;
import com.zenmen.palmchat.contacts.bean.LxmbrWhoVisitMePushCheckBean;
import com.zenmen.palmchat.contacts.bean.VipWseemeConfig;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.b05;
import defpackage.yk6;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yk6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatItem f22215a;
    public AnimatorSet b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<LxmbrWhoVisitMePushCheckBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22216a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        public a(String str, HashMap map, boolean z, Activity activity) {
            this.f22216a = str;
            this.b = map;
            this.c = z;
            this.d = activity;
        }

        public static /* synthetic */ Object b(LxmbrWhoVisitMePushCheckBean lxmbrWhoVisitMePushCheckBean, boolean z) {
            return "checkPush vipStatus=" + lxmbrWhoVisitMePushCheckBean.getVipStatus() + ", shouldPush=" + z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f22216a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<LxmbrWhoVisitMePushCheckBean> lXBaseNetBean, Exception exc) {
            LxmbrWhoVisitMePushCheckBean lxmbrWhoVisitMePushCheckBean;
            if (q05.o(this.d) || !z || lXBaseNetBean == null || (lxmbrWhoVisitMePushCheckBean = lXBaseNetBean.data) == null) {
                return;
            }
            final LxmbrWhoVisitMePushCheckBean lxmbrWhoVisitMePushCheckBean2 = lxmbrWhoVisitMePushCheckBean;
            final boolean zIsVipAllowPushFlag = lxmbrWhoVisitMePushCheckBean2.getVipStatus() == 1 ? lxmbrWhoVisitMePushCheckBean2.isVipAllowPushFlag() : lxmbrWhoVisitMePushCheckBean2.isUnVipAllowPushFlag();
            b05.c(new b05.a() { // from class: xk6
                @Override // b05.a
                public final Object getValue() {
                    return yk6.a.b(lxmbrWhoVisitMePushCheckBean2, zIsVipAllowPushFlag);
                }
            });
            if (zIsVipAllowPushFlag) {
                ConfigInfoVo configInfoVo = new ConfigInfoVo();
                configInfoVo.vipStatus = lxmbrWhoVisitMePushCheckBean2.getVipStatus() == 1;
                configInfoVo.createTime = ir5.c(true);
                configInfoVo.fromUid = q05.e().getUid();
                try {
                    ch.s().u().r(yk6.g(String.valueOf(lxmbrWhoVisitMePushCheckBean2.getToUid()), configInfoVo));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22217a;
        public final /* synthetic */ View b;

        public b(Activity activity, View view) {
            this.f22217a = activity;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (q05.o(this.f22217a) || (view = this.b) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static yk6 f22218a = new yk6();
    }

    public static MessageVo g(String str, ConfigInfoVo configInfoVo) {
        MessageVo messageVo = new MessageVo();
        messageVo.time = ir5.b();
        messageVo.contactRelate = str;
        String str2 = AccountUtils.p(AppContext.getContext()) + DomainHelper.Domains.DOMAIN_SINGLECHAT.domain;
        messageVo.to = str + "@cmd.youni";
        messageVo.from = str2;
        messageVo.mimeType = 15000;
        messageVo.mid = xn3.a();
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.configInfo = configInfoVo;
        messageVo.extention = az2.c(richMsgVo);
        return messageVo;
    }

    public static boolean h(final String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        final VipWseemeConfig.SysMsgNotVip sysMsgNotVip = VipWseemeConfig.getVipWseemeConfig().sysMsg_notVip;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLongValue = ((Long) q05.k("KEY_WHO_VISIT_ME_LAST_SHOW_TIME", 0L)).longValue();
        if (jLongValue > 0 && q05.q(jLongValue)) {
            b05.c(new b05.a() { // from class: tk6
                @Override // b05.a
                public final Object getValue() {
                    return yk6.l(str);
                }
            });
            return false;
        }
        final int iIntValue = ((Integer) q05.k("KEY_WHO_VISIT_ME_TOTAL_COUNT", 0)).intValue();
        if (iIntValue >= sysMsgNotVip.totalNum) {
            b05.c(new b05.a() { // from class: uk6
                @Override // b05.a
                public final Object getValue() {
                    return yk6.m(str, iIntValue, sysMsgNotVip);
                }
            });
            return false;
        }
        if (jLongValue > 0) {
            int[] iArr = sysMsgNotVip.gapHours;
            final int i = sysMsgNotVip.gapHours_loop;
            if (iIntValue > 0 && iIntValue <= iArr.length) {
                i = iArr[iIntValue - 1];
            }
            final long j = (jCurrentTimeMillis - jLongValue) / 3600000;
            if (j < i) {
                b05.c(new b05.a() { // from class: vk6
                    @Override // b05.a
                    public final Object getValue() {
                        return yk6.n(str, j, i);
                    }
                });
                return false;
            }
        }
        b05.c(new b05.a() { // from class: wk6
            @Override // b05.a
            public final Object getValue() {
                return yk6.o(str, iIntValue);
            }
        });
        return true;
    }

    public static ConfigInfoVo j(String str) {
        RichMsgVo richMsgVo = !TextUtils.isEmpty(str) ? (RichMsgVo) az2.a(str, RichMsgVo.class) : null;
        if (richMsgVo != null) {
            return richMsgVo.configInfo;
        }
        return null;
    }

    public static yk6 k() {
        return c.f22218a;
    }

    public static /* synthetic */ Object l(String str) {
        return "频控拦截：今天已经显示过该用户的消息 fromUid=" + str;
    }

    public static /* synthetic */ Object m(String str, int i, VipWseemeConfig.SysMsgNotVip sysMsgNotVip) {
        return "频控拦截：已达到总次数上限 fromUid=" + str + ", totalCount=" + i + ", maxCount=" + sysMsgNotVip.totalNum;
    }

    public static /* synthetic */ Object n(String str, long j, int i) {
        return "频控拦截：未达到小时间隔 fromUid=" + str + ", hoursPassed=" + j + ", requiredHours=" + i;
    }

    public static /* synthetic */ Object o(String str, int i) {
        return "频控通过 fromUid=" + str + ", totalCount=" + i;
    }

    public static /* synthetic */ Object p(ConfigInfoVo configInfoVo) {
        return "收到谁看过我消息通知 fromUid=" + configInfoVo.fromUid + ", vipStatus=" + configInfoVo.vipStatus;
    }

    public static /* synthetic */ Object q(String str, int i) {
        return "记录显示消息 fromUid=" + str + ", totalCount=" + (i + 1);
    }

    public static void t(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q05.w("KEY_WHO_VISIT_ME_LAST_SHOW_TIME", Long.valueOf(System.currentTimeMillis()));
        final int iIntValue = ((Integer) q05.k("KEY_WHO_VISIT_ME_TOTAL_COUNT", 0)).intValue();
        q05.w("KEY_WHO_VISIT_ME_TOTAL_COUNT", Integer.valueOf(iIntValue + 1));
        b05.c(new b05.a() { // from class: sk6
            @Override // b05.a
            public final Object getValue() {
                return yk6.q(str, iIntValue);
            }
        });
    }

    public void i(Activity activity, String str, String str2) {
        String str3 = q05.c() + "/lxmbr.who.visit.me.push.check.v1";
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, q05.e().getUid());
        if (!TextUtils.isEmpty(str)) {
            map.put("toUid", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("toExid", str2);
        }
        zw4.e(new a(str3, map, false, activity));
    }

    public void r(ChatItem chatItem) {
        this.f22215a = chatItem;
    }

    public void s(MessageProto.Message message) {
        final ConfigInfoVo configInfoVoJ;
        ThreadChatItem threadChatItemF;
        if (message != null) {
            try {
                String extension = message.getExtension();
                if (!TextUtils.isEmpty(extension) && (configInfoVoJ = j(extension)) != null) {
                    b05.c(new b05.a() { // from class: rk6
                        @Override // b05.a
                        public final Object getValue() {
                            return yk6.p(configInfoVoJ);
                        }
                    });
                    if (configInfoVoJ.vipStatus) {
                        ch.s().r().i(new qk6(configInfoVoJ, extension));
                        ChatItem chatItem = this.f22215a;
                        if ((chatItem == null || chatItem.getChatType() != 0 || !this.f22215a.getChatId().equals(configInfoVoJ.fromUid)) && (threadChatItemF = nw5.f(configInfoVoJ.fromUid)) != null) {
                            VipWseemeConfig vipWseemeConfig = VipWseemeConfig.getVipWseemeConfig();
                            MessageVo messageVoG = u0.g(threadChatItemF);
                            messageVoG.status = 2;
                            messageVoG.mimeType = 10000;
                            messageVoG.text = vipWseemeConfig.sysMsg_Vip_notice;
                            messageVoG.extention = extension;
                            messageVoG.data1 = "1";
                            messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + vipWseemeConfig.sysMsg_Vip_notice + "\"}";
                            com.zenmen.palmchat.database.b.t(messageVoG);
                        }
                    } else {
                        ch.s().r().i(new qk6(configInfoVoJ, extension));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void u(Activity activity) {
        if (q05.o(activity)) {
            return;
        }
        View viewFindViewById = activity.findViewById(R.id.visit_me_top_layout);
        TextView textView = (TextView) activity.findViewById(R.id.visit_me_top_text);
        if (viewFindViewById == null || textView == null) {
            return;
        }
        AnimatorSet animatorSet = this.b;
        if (animatorSet == null || !animatorSet.isRunning()) {
            VipWseemeConfig vipWseemeConfig = VipWseemeConfig.getVipWseemeConfig();
            if (!TextUtils.isEmpty(vipWseemeConfig.sysMsg_Vip_real_time)) {
                textView.setText(vipWseemeConfig.sysMsg_Vip_real_time);
            }
            float f = -me1.a(activity, 44.0f);
            viewFindViewById.setTranslationY(f);
            viewFindViewById.setVisibility(0);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById, "translationY", f, 0.0f);
            objectAnimatorOfFloat.setDuration(400L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.start();
            u93.b(3000, new b(activity, viewFindViewById));
        }
    }

    public yk6() {
    }
}
