package com.bytedance.sdk.openadsdk.core.l.fx;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    public static boolean b(bc bcVar) {
        com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = bcVar.hm();
        return (izVarHm == null || TextUtils.isEmpty(izVarHm.s()) || TextUtils.isEmpty(izVarHm.pn()) || TextUtils.isEmpty(izVarHm.x()) || izVarHm.u() == null || izVarHm.u().size() <= 0 || TextUtils.isEmpty(izVarHm.n()) || TextUtils.isEmpty(izVarHm.a())) ? false : true;
    }

    public static boolean fx(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return b(bcVar);
    }

    public static String nr(bc bcVar) {
        if (bcVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = bcVar.pu();
        return (pnVarPu == null || TextUtils.isEmpty(pnVarPu.fx())) ? !TextUtils.isEmpty(bcVar.j()) ? bcVar.j() : !TextUtils.isEmpty(bcVar.ym()) ? bcVar.ym() : !TextUtils.isEmpty(bcVar.it()) ? bcVar.it() : "" : pnVarPu.fx();
    }

    public static int u(bc bcVar) {
        if (bcVar == null || bcVar.zn() != 1) {
            return 0;
        }
        if (bcVar.xh() == 0) {
            return 1;
        }
        return bcVar.xh() == 1 ? fx(bcVar) ? 0 : 1 : bcVar.xh() == 2 ? 2 : 1;
    }

    public static void u(final Context context) {
        if (context == null) {
            context = dw.getContext();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            h.u(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            bg.iz().post(new com.bytedance.sdk.component.jk.a("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.l.fx.jk.1
                @Override // java.lang.Runnable
                public void run() {
                    h.u(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }
}
