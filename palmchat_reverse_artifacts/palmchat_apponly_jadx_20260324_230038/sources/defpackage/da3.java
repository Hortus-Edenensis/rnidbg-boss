package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.dialogmanager.DialogScene;
import com.zenmen.palmchat.utils.dialogmanager.config.PopRuleConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class da3 {
    public static da3 b = new da3();
    public static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ca3 f17004a = new ca3();

    public static da3 b() {
        return b;
    }

    public boolean a(DialogScene dialogScene) {
        int i;
        LogUtil.i("LxDialogManager", "checkCanShow scene = " + dialogScene.value);
        boolean zTestCoolTime = false;
        if (!t66.h().f("LX-75937", false) && !c) {
            LogUtil.i("LxDialogManager", "checkCanShow pandaconfig miss match");
            return true;
        }
        String strA = ir5.a();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        long jK = 0;
        long jK2 = sPUtil.k(scene, "key_pop_rule_today_show_count" + strA, 0L);
        PopRuleConfig popRuleConfigC = this.f17004a.c();
        if (popRuleConfigC.isWithList(dialogScene)) {
            i = 0;
            zTestCoolTime = true;
        } else if (popRuleConfigC.testTodayCount(jK2)) {
            jK = sPUtil.k(scene, "key_pop_rule_show_time", 0L);
            zTestCoolTime = popRuleConfigC.testCoolTime(jK);
            i = !zTestCoolTime ? 1 : 0;
        } else {
            i = 2;
        }
        if (zTestCoolTime) {
            jK2++;
            sPUtil.v(scene, "key_pop_rule_today_show_count" + strA, Long.valueOf(jK2));
            sPUtil.v(scene, "key_pop_rule_show_time", Long.valueOf(ir5.b()));
        }
        HashMap map = new HashMap();
        map.put("popcode", dialogScene.value);
        map.put("result", zTestCoolTime ? "realshow" : "postpone");
        if (!zTestCoolTime) {
            map.put("postponereason", String.valueOf(i));
        }
        zn6.i("allpop_request", map);
        LogUtil.i("LxDialogManager", "checkCanShow result=" + zTestCoolTime + " reason=" + i + " todayShowTime=" + jK2 + " lastPopTime=" + jK);
        return zTestCoolTime;
    }

    public void c() {
        if (AccountUtils.r(AppContext.getContext())) {
            this.f17004a.d();
        }
    }
}
