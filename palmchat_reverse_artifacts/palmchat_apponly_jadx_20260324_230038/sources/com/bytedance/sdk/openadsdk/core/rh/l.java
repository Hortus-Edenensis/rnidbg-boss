package com.bytedance.sdk.openadsdk.core.rh;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l {
    private static final HashMap<String, mv> u = new HashMap<>();

    public static void u(bc bcVar) {
        fx fxVar = (fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya");
        if (fxVar != null && fxVar.isPitayaInitSuccess() && fxVar.isPitayaEnvAvailable() && t.nr() && bcVar != null && bcVar.tm() != null) {
            String strXx = bcVar.xx();
            String strEn = bcVar.en();
            String strB = bcVar.tm().b();
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            mv mvVar = new mv();
            mvVar.u(1);
            mvVar.u(strXx);
            mvVar.nr(strEn);
            u.put(strB, mvVar);
        }
    }
}
