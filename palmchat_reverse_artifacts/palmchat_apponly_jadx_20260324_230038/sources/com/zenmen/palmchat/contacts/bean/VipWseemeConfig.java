package com.zenmen.palmchat.contacts.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.contacts.bean.VipWseemeConfig;
import com.zenmen.palmchat.utils.SAppUtil;
import defpackage.az2;
import defpackage.b05;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class VipWseemeConfig {
    public SysMsgNotVip sysMsg_notVip;
    public String sysMsg_Vip_real_time = "ta正在看你的个人主页……";
    public String sysMsg_Vip_notice = "ta看了你的个人主页";

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class SysMsgNotVip {
        public String text = "刚刚有人看了你的主页，是ta吗？{ href='zenxin://activity?page=a0052&pkgId=wseem&urlExtra=?from=604'>去看看> }";
        public String text_out = "刚刚有人看了你的主页，是ta吗？去看看> ";
        public int totalNum = 10;
        public int[] gapHours = {48, 72, 168};
        public int gapHours_loop = 168;
    }

    public static VipWseemeConfig getVipWseemeConfig() {
        VipWseemeConfig vipWseemeConfig;
        final Exception e;
        final String strF;
        final VipWseemeConfig vipWseemeConfig2 = null;
        try {
            strF = SAppUtil.F("vip_wseeme");
        } catch (Exception e2) {
            vipWseemeConfig = null;
            e = e2;
        }
        if (!TextUtils.isEmpty(strF)) {
            vipWseemeConfig = (VipWseemeConfig) az2.a(strF, VipWseemeConfig.class);
            try {
                b05.c(new b05.a() { // from class: gg6
                    @Override // b05.a
                    public final Object getValue() {
                        return VipWseemeConfig.lambda$getVipWseemeConfig$0(strF);
                    }
                });
            } catch (Exception e3) {
                e = e3;
                b05.c(new b05.a() { // from class: hg6
                    @Override // b05.a
                    public final Object getValue() {
                        return VipWseemeConfig.lambda$getVipWseemeConfig$1(e);
                    }
                });
            }
            vipWseemeConfig2 = vipWseemeConfig;
        }
        if (vipWseemeConfig2 == null) {
            vipWseemeConfig2 = new VipWseemeConfig();
        }
        if (vipWseemeConfig2.sysMsg_notVip == null) {
            vipWseemeConfig2.sysMsg_notVip = new SysMsgNotVip();
        }
        b05.c(new b05.a() { // from class: ig6
            @Override // b05.a
            public final Object getValue() {
                return VipWseemeConfig.lambda$getVipWseemeConfig$2(this.f18162a);
            }
        });
        return vipWseemeConfig2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getVipWseemeConfig$0(String str) {
        return "读取vip_wseeme配置: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getVipWseemeConfig$1(Exception exc) {
        return "读取vip_wseeme配置异常: " + exc.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getVipWseemeConfig$2(VipWseemeConfig vipWseemeConfig) {
        return "返回的配置配值: " + az2.c(vipWseemeConfig);
    }
}
