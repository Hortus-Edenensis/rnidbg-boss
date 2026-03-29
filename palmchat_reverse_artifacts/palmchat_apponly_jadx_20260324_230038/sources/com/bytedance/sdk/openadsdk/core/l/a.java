package com.bytedance.sdk.openadsdk.core.l;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.pb.t;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.l;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static String b() {
        try {
            Function<SparseArray<Object>, Object> functionY = com.bytedance.sdk.openadsdk.core.n.o().y();
            if (functionY == null) {
                return bq.e;
            }
            functionY.apply(com.bytedance.sdk.openadsdk.my.b.u().u(1).u(String.class).nr());
            return bq.e;
        } catch (Exception unused) {
            return bq.e;
        }
    }

    public static boolean fx() {
        if (Build.VERSION.SDK_INT >= 23) {
            return com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.j);
        }
        return true;
    }

    private static String iz() {
        File fileU = com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext(), Environment.DIRECTORY_DOWNLOADS);
        if (fileU == null) {
            return null;
        }
        if (!fileU.exists()) {
            fileU.mkdirs();
        }
        if (fileU.exists()) {
            return fileU.getAbsolutePath();
        }
        return null;
    }

    private static void nr(final bc bcVar, final String str) {
        final com.bytedance.sdk.openadsdk.core.y.u uVarB;
        if (u(bcVar) || (uVarB = com.bytedance.sdk.openadsdk.core.n.o().b()) == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        uVarB.u(new u.fx() { // from class: com.bytedance.sdk.openadsdk.core.l.a.1
            @Override // com.bytedance.sdk.openadsdk.core.y.u.fx, com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
            public void u() {
                if (!y.u()) {
                    com.bytedance.sdk.openadsdk.core.y.u uVar = uVarB;
                    if (uVar != null) {
                        uVar.fx();
                        return;
                    }
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.k.nr.u(str)) {
                    a.nr(bcVar, jCurrentTimeMillis, uVarB, str);
                }
                com.bytedance.sdk.openadsdk.core.y.u uVar2 = uVarB;
                if (uVar2 != null) {
                    uVar2.fx();
                }
            }
        });
    }

    public static void pn() {
        if (com.bytedance.sdk.openadsdk.core.n.o().y() != null) {
            com.bytedance.sdk.openadsdk.core.n.o().y().apply(com.bytedance.sdk.openadsdk.my.b.u().u(20).u(Void.class).nr());
        } else {
            k.nr("TTDownload-Util", "下载SDK 初始化失败 ， bridge = null ！！！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(bc bcVar, String str) {
        if (bcVar == null) {
            return;
        }
        jp.u(dw.getContext(), str);
    }

    public static void u(String str, bc bcVar) {
        boolean zX;
        try {
            if (dw.getContext() == null || TextUtils.isEmpty(str) || !(zX = com.bytedance.sdk.openadsdk.core.kj.bq.x(bcVar))) {
                return;
            }
            my myVarKv = bcVar.kv();
            if (myVarKv != null && !TextUtils.isEmpty(myVarKv.nr())) {
                k.nr("TTDownload-Util", "含有deepLink");
                if (com.bytedance.sdk.openadsdk.core.kj.bq.b(bcVar) != 0) {
                    k.nr("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + com.bytedance.sdk.openadsdk.core.kj.bq.b(bcVar));
                    return;
                }
            }
            if (zX) {
                if (com.bytedance.sdk.openadsdk.k.nr.u(str)) {
                    k.nr("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                } else if (!com.bytedance.sdk.openadsdk.core.kj.bq.n(bcVar)) {
                    nr(bcVar, str);
                } else {
                    u(dw.getContext(), bcVar, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject nr() {
        t tVarNr = dw.nr();
        if (tVarNr != null && tVarNr.tm() != null) {
            return tVarNr.tm();
        }
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(final com.bytedance.sdk.openadsdk.core.y.u uVar, final bc bcVar, String str, String str2, final String str3) {
        if (uVar != null && jp.fx(dw.getContext(), str3)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String strLk = bcVar.lk();
            com.bytedance.sdk.openadsdk.core.y.iz.u(dw.getContext(), strLk, str, str2, "立即打开", "退出", new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.l.a.3
                @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
                public void onDialogBtnNo() {
                    com.bytedance.sdk.openadsdk.core.y.u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.fx();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
                public void onDialogBtnYes() {
                    a.fx(bcVar, str3);
                    com.bytedance.sdk.openadsdk.core.y.u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.fx();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
                public void onDialogCancel() {
                    com.bytedance.sdk.openadsdk.core.y.u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.fx();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(bc bcVar, long j, com.bytedance.sdk.openadsdk.core.y.u uVar, String str) {
        if (bcVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= ((long) com.bytedance.sdk.openadsdk.core.kj.bq.a(bcVar)) * 1000) {
            String strFx = bcVar.pu() != null ? bcVar.pu().fx() : "";
            nr(uVar, bcVar, strFx, TextUtils.isEmpty(strFx) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
        } else {
            fx(bcVar, str);
        }
    }

    public static String u() {
        String strB = com.bytedance.sdk.openadsdk.k.nr.b();
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = com.bytedance.sdk.openadsdk.core.n.o().sx();
        if (bVarSx == null || bVarSx.pn()) {
            return strB;
        }
        try {
            return iz();
        } catch (Throwable unused) {
            return strB;
        }
    }

    private static void u(Context context, final bc bcVar, final String str) {
        if (context == null || bcVar == null || u(bcVar)) {
            return;
        }
        final String strFx = bcVar.pu() != null ? bcVar.pu().fx() : "";
        final String str2 = TextUtils.isEmpty(strFx) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
        final com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        if (uVarB == null) {
            return;
        }
        uVarB.u(new u.fx() { // from class: com.bytedance.sdk.openadsdk.core.l.a.2
            @Override // com.bytedance.sdk.openadsdk.core.y.u.fx, com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
            public void u() {
                try {
                    if (!y.u()) {
                        com.bytedance.sdk.openadsdk.core.y.u uVar = uVarB;
                        if (uVar != null) {
                            uVar.fx();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.k.nr.u(str)) {
                        a.nr(uVarB, bcVar, strFx, str2, str);
                    }
                    com.bytedance.sdk.openadsdk.core.y.u uVar2 = uVarB;
                    if (uVar2 != null) {
                        uVar2.fx();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean u(bc bcVar) {
        if (bcVar == null || !u(nr())) {
            return false;
        }
        int iQf = bcVar.qf();
        String strKd = bcVar.kd();
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        if ((TextUtils.isEmpty(strKd) || iQf != 4) && !fxVarU.get("is_landing_page_open_market", false)) {
            return false;
        }
        fxVarU.put("is_landing_page_open_market", false);
        return true;
    }

    private static boolean u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optInt("enable_open_app_dialog") == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(boolean z) {
        String path;
        File fileU;
        if (z) {
            try {
                if (fx()) {
                    path = null;
                } else {
                    File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext()), Environment.DIRECTORY_DOWNLOADS);
                    file.mkdirs();
                    path = file.getPath();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        if (TextUtils.isEmpty(path)) {
            if ("mounted".equals(com.bytedance.sdk.openadsdk.gi.fx.u()) && (fileU = com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext(), Environment.DIRECTORY_DOWNLOADS)) != null) {
                path = fileU.getPath();
            }
            if (TextUtils.isEmpty(path)) {
                File file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext()), Environment.DIRECTORY_DOWNLOADS);
                file2.mkdirs();
                path = file2.getPath();
            }
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        l.u();
        return path;
    }

    public static void u(Runnable runnable, bc bcVar) {
        if (bcVar == null || runnable == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.kj.bq.o(bcVar)) {
            com.bytedance.sdk.openadsdk.gi.x.u((Runnable) new com.bytedance.sdk.component.jk.a("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.l.a.4
                @Override // java.lang.Runnable
                public void run() {
                    h.u(dw.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            bg.iz().postDelayed(runnable, 500L);
        } else {
            com.bytedance.sdk.openadsdk.gi.x.u(runnable);
        }
    }
}
