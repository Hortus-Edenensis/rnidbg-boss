package com.wifi;

import android.app.Application;
import com.lantern.core.MobEvent;
import com.wifi.open.sec.SmDuManager;
import com.wifi.open.sec.StringCallback;
import com.wifi.utils.MdaParamUtils;
import com.wifi.utils.MdaPubParams;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.SmidHelper;
import defpackage.ac1;
import defpackage.bl2;
import defpackage.cl2;
import defpackage.eb4;
import defpackage.mw3;
import defpackage.nl0;
import defpackage.pc;
import defpackage.v4;
import defpackage.vq0;
import defpackage.xn1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AllinoneHelper {
    public static void initAnalytics(Application application) {
        xn1.h().l(application, application.getPackageName(), pc.w().z(eb4.b()).C(MdaParamUtils.getUhid()).A(ac1.m).F(ac1.f).G(ac1.g).E(v4.e(application) + "").y(ac1.p).D("x1*Jm%b0@X!j9uG2t7ySKglS^dz3*uQ&U^O&z4Q3Hj3jbmGKY2$g@jGQwLM#QH8Y").B("https://bugly-agent-pro.y5kfpt.com/dc/sec/fa.do").x(), new cl2() { // from class: com.wifi.AllinoneHelper.2
            @Override // defpackage.cl2
            public mw3 getNetInfo() {
                mw3 mw3Var = new mw3();
                mw3Var.f("");
                mw3Var.j("");
                mw3Var.g("");
                mw3Var.h("");
                mw3Var.i("");
                return mw3Var;
            }

            @Override // defpackage.cl2
            public boolean isAgreed() {
                return true;
            }

            @Override // defpackage.cl2
            public boolean isAnrEnable() {
                return false;
            }

            @Override // defpackage.cl2
            public /* bridge */ /* synthetic */ boolean isDebug() {
                return bl2.a(this);
            }

            @Override // defpackage.cl2
            public boolean isDintingSupport() {
                return true;
            }

            @Override // defpackage.cl2
            public boolean isSunsetSupport() {
                return true;
            }

            @Override // defpackage.cl2
            public /* bridge */ /* synthetic */ boolean isWifiOnlySubmit() {
                return bl2.d(this);
            }
        });
        vq0.d();
    }

    public static void initMDA(Application application) {
        MobEvent.init(application, new MdaPubParams(application, !nl0.k()));
    }

    public static void initSM(Application application) {
        SmDuManager.setNeedInit(AccountUtils.t(application));
        SmDuManager.init(application, ac1.m, ac1.p);
        SmDuManager.addInitCallback(new StringCallback() { // from class: com.wifi.AllinoneHelper.1
            @Override // com.wifi.open.sec.StringCallback
            public void callback(String str) {
                SmidHelper.v();
            }
        });
    }
}
