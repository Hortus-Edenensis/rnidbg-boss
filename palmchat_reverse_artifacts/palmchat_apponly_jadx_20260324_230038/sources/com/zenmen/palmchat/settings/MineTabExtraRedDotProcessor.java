package com.zenmen.palmchat.settings;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.bo0;
import defpackage.il5;
import defpackage.ir5;
import defpackage.k86;
import defpackage.nx3;
import defpackage.rl0;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class MineTabExtraRedDotProcessor {
    public static final String TAG = "MineTabExtraRedDotProcessor";
    public static boolean isTest = false;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class PayGuideInfo {
        public int firstShowTime = 5;
        public int gapLengthMin = 2;
        public int gapLengthMax = 4;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class TabGuideInfo {
        public int profileGuideTime = 2;
        public int payGuideTime = 3;
        public int settingGuideTime = 1;
    }

    public static boolean needImproveProfile() {
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        if (contactInfoItemL != null) {
            return TextUtils.isEmpty(contactInfoItemL.getNickName()) || TextUtils.isEmpty(contactInfoItemL.getAccount()) || TextUtils.isEmpty(contactInfoItemL.getSignature()) || TextUtils.isEmpty(contactInfoItemL.getHobby()) || TextUtils.isEmpty(il5.j(AppContext.getContext(), contactInfoItemL.getCountry(), contactInfoItemL.getProvince(), contactInfoItemL.getCity(), false)) || contactInfoItemL.getGender() == -1;
        }
        return false;
    }

    public static void onAppOpen() {
        String strP = AccountUtils.p(AppContext.getContext());
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        long jB = (ir5.b() - k86.y(strP)) / 86400000;
        boolean zA = nx3.a("key_tab_mine");
        LogUtil.i(TAG, "onAppOpen registerDays=" + jB + " currentTabRedDot=" + zA);
        if (jB < 0 || zA) {
            return;
        }
        processTabGuide(jB);
        processPayGuide(jB);
    }

    private static void processPayGuide(long j) {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.PAYGUIDE);
        if (isTest) {
            PayGuideInfo payGuideInfo = new PayGuideInfo();
            dynamicConfig.setEnable(true);
            dynamicConfig.setExtra(az2.c(payGuideInfo));
        }
        if (dynamicConfig.isEnable()) {
            PayGuideInfo payGuideInfo2 = (PayGuideInfo) dynamicConfig.parseExtra(PayGuideInfo.class);
            LogUtil.i(TAG, "processPayGuide  extra=" + dynamicConfig.getExtra() + " obj=" + az2.c(payGuideInfo2));
            if (payGuideInfo2 == null || j < payGuideInfo2.firstShowTime) {
                return;
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.EXTRA_REDDOT;
            long jI = sPUtil.i(scene, "key_extra_reddot_pay_next_guide", 0L);
            LogUtil.i(TAG, "processPayGuide  process currentTime=" + ir5.b() + " nextShowTime=" + jI);
            if (ir5.b() > jI) {
                int iNextInt = payGuideInfo2.gapLengthMin + new Random().nextInt(payGuideInfo2.gapLengthMax - payGuideInfo2.gapLengthMin);
                sPUtil.t(scene, "key_extra_reddot_pay_next_guide", Long.valueOf(ir5.b() + (((long) (iNextInt * 24 * 60 * 60)) * 1000)));
                LogUtil.i(TAG, "processPayGuide  process randomDay=" + iNextInt);
                nx3.f("key_wallet_new", true);
                nx3.f("key_tab_mine", true);
                LogUtil.uploadInfoImmediate("mtg4", null, null, null);
            }
        }
    }

    private static void processTabGuide(long j) {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MYTABGUIDE);
        if (isTest) {
            TabGuideInfo tabGuideInfo = new TabGuideInfo();
            dynamicConfig.setEnable(true);
            dynamicConfig.setExtra(az2.c(tabGuideInfo));
        }
        if (dynamicConfig.isEnable()) {
            TabGuideInfo tabGuideInfo2 = (TabGuideInfo) dynamicConfig.parseExtra(TabGuideInfo.class);
            LogUtil.i(TAG, "processTabGuide  extra=" + dynamicConfig.getExtra() + " obj=" + az2.c(tabGuideInfo2));
            if (tabGuideInfo2 != null) {
                if (j == tabGuideInfo2.payGuideTime) {
                    SPUtil sPUtil = SPUtil.f14322a;
                    SPUtil.SCENE scene = SPUtil.SCENE.EXTRA_REDDOT;
                    if (sPUtil.a(scene, "key_extra_reddot_pay", false)) {
                        return;
                    }
                    sPUtil.t(scene, "key_extra_reddot_pay", Boolean.TRUE);
                    nx3.f("key_wallet_new", true);
                    nx3.f("key_tab_mine", true);
                    LogUtil.uploadInfoImmediate("mtg4", null, null, null);
                    return;
                }
                if (j == tabGuideInfo2.profileGuideTime) {
                    SPUtil sPUtil2 = SPUtil.f14322a;
                    SPUtil.SCENE scene2 = SPUtil.SCENE.EXTRA_REDDOT;
                    if (sPUtil2.a(scene2, "key_extra_reddot_edit_profile", false)) {
                        return;
                    }
                    sPUtil2.t(scene2, "key_extra_reddot_edit_profile", Boolean.TRUE);
                    if (needImproveProfile()) {
                        nx3.f("key_new_edit_profile", true);
                        nx3.f("key_tab_mine", true);
                    }
                    LogUtil.uploadInfoImmediate("mtg3", null, null, null);
                }
            }
        }
    }
}
