package com.bytedance.pangle.iz;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.a;
import com.bytedance.pangle.util.mv;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz {

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        boolean u(String str, int i);
    }

    public static u fx() {
        return a.a() ? new pn() : a.x() ? new b() : a.fx() ? new fx() : new u() { // from class: com.bytedance.pangle.iz.iz.2
            @Override // com.bytedance.pangle.iz.iz.u
            public boolean u(String str, int i) {
                return true;
            }
        };
    }

    public static synchronized void nr() {
        Map<String, ?> all = nr.u(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                if (fx().u(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    nr.u(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                    mv.u().fx(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                }
            }
        }
    }

    public static void u() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "start");
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((a.x() || a.a() || a.fx()) && com.bytedance.pangle.pn.b.nr(Zeus.getAppApplication())) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "post");
            com.bytedance.pangle.pn.pn.nr(new Runnable() { // from class: com.bytedance.pangle.iz.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    iz.nr();
                }
            });
        }
    }
}
