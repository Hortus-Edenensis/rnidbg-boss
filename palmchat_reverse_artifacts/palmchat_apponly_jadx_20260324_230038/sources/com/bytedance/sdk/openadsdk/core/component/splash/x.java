package com.bytedance.sdk.openadsdk.core.component.splash;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.lf;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    public static int fx(com.bytedance.sdk.openadsdk.core.kj.u uVar) {
        if (uVar != null) {
            return uVar.u();
        }
        return 0;
    }

    public static boolean nr(com.bytedance.sdk.openadsdk.core.kj.u uVar) {
        return (uVar == null || uVar.nr() == null || uVar.nr().isEmpty() || uVar.nr().get(0) == null) ? false : true;
    }

    public static void u(long j, boolean z, boolean z2, bc bcVar, long j2, String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str2 = z ? z2 ? "load_video_success" : "load_video_error" : z2 ? "download_video_image_success" : "download_video_image_fail";
        if (z) {
            Map<String, Object> mapU = jp.u(z2, bcVar, jElapsedRealtime, j2, str);
            mapU.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.core.s.b.pn(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, str2, mapU);
        } else {
            Map<String, Object> mapNr = jp.nr(z2, bcVar, jElapsedRealtime, j2, str);
            mapNr.put("splash_show_type", 2);
            com.bytedance.sdk.openadsdk.core.s.b.b(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, str2, mapNr);
        }
    }

    public static boolean nr(bc bcVar) {
        if (bcVar == null || bcVar.ju() == 1 || zx.k(bcVar) == null || TextUtils.isEmpty(zx.u(bcVar))) {
            return true;
        }
        bcVar.a(true);
        return false;
    }

    public static void u(com.bytedance.sdk.openadsdk.core.kj.u uVar) {
        com.bykv.vk.openvk.component.video.api.fx.iz izVarU;
        if (nr(uVar)) {
            bc bcVar = uVar.nr().get(0);
            int iT = jp.t(bcVar);
            com.bykv.vk.openvk.component.video.api.fx.b bVarK = zx.k(bcVar);
            if (bVarK != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String strL = bVarK.l();
                if (TextUtils.isEmpty(strL)) {
                    u(jElapsedRealtime, true, false, bcVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(bVarK.k())) {
                    com.bytedance.sdk.component.utils.x.nr(strL);
                }
                if (bcVar.az()) {
                    izVarU = zx.u(2, bcVar);
                } else {
                    izVarU = zx.u(3, bcVar);
                }
                izVarU.u("material_meta", bcVar);
                if (!dw.nr().x(String.valueOf(iT)) || o.b(dw.getContext())) {
                    bVarK.pn(0);
                    com.bykv.vk.openvk.component.video.u.u.u();
                    com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVarU, new com.bykv.vk.openvk.component.video.api.pn.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.x.1
                        @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
                        public void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i) {
                        }

                        @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
                        public void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i, String str) {
                        }
                    });
                }
            }
        }
    }

    public static int u(lf lfVar) {
        if (lfVar == null) {
            return 0;
        }
        int iFx = fx(lfVar.nr());
        return iFx <= 0 ? u(lfVar.u()) : iFx;
    }

    public static int u(bc bcVar) {
        if (bcVar != null) {
            return jp.t(bcVar);
        }
        return 0;
    }
}
