package defpackage;

import com.volcengine.lxvertc.videocall.call.a;
import com.volcengine.lxvertc.videocall.call.view.CallActivity;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class sx {
    public static boolean a(String str) {
        return zs1.b() instanceof CallActivity;
    }

    public static void b(rh6 rh6Var, String str) {
        a aVarT = a.t();
        LogUtil.i("RTC", "handleRingState callEngine.isInited() =" + aVarT.J());
        aVarT.C(rh6Var.l, str);
        sh6 sh6Var = new sh6();
        sh6Var.f20748a = 1;
        sh6Var.b = rh6Var;
        aVarT.O(sh6Var);
        if (c.a().isBackground()) {
            return;
        }
        CallActivity.U1(rh6Var.a(), rh6Var.f, rh6Var.h, rh6Var.i, rh6Var.g);
    }
}
