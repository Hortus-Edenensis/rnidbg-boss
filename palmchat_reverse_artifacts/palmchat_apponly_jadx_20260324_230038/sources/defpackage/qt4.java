package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qt4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static qt4 f20320a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (AppContext.getContext().isBackground()) {
                System.exit(0);
            }
        }
    }

    public static int a(long j) {
        return (int) (j / 86400000);
    }

    public static qt4 b() {
        if (f20320a == null) {
            f20320a = new qt4();
        }
        return f20320a;
    }

    public final boolean c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ir5.b());
        int i = calendar.get(11);
        boolean z = i >= 2 && i <= 4;
        boolean z2 = AppContext.getContext().getBackgroundTime() != -1 && ir5.e(AppContext.getContext().getBackgroundTime()) > 3600000;
        boolean zA = jo6.a("LX-40190", false);
        LogUtil.i("RebootManager", "hour=" + i + "isTimeOK=" + z + "isBackgroudTimeOk=" + z2 + " isBackgroud=" + AppContext.getContext().isBackground() + "config=" + ns.c().b().isProguardReboot() + "taiji=" + zA);
        if (z && z2 && AppContext.getContext().isBackground() && ((ns.c().b().isProguardReboot() || zA) && yn6.d(AppContext.getContext(), "has_success", false))) {
            if (!SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_reboot_daytime" + a(ir5.b()), false)) {
                return true;
            }
        }
        return false;
    }

    public void d(long j) {
        LogUtil.i("RebootManager", "onBatteryEvent" + j + AppContext.getContext().isBackground());
        if (j <= 1000 || !c()) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_reboot_daytime" + a(ir5.b()), Boolean.TRUE);
        LogUtil.uploadInfoImmediate("COMP_BATTERY_REBOOT", null);
        new Thread(new a()).start();
    }
}
