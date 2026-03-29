package com.bytedance.sdk.openadsdk.gi;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    private static String b = null;
    public static volatile com.bykv.vk.openvk.component.video.api.u.nr fx = null;
    private static int iz = 1;
    public static volatile com.bykv.vk.openvk.component.video.api.u.nr nr;
    private static String pn;
    public static String u;

    private static String a() {
        if (!TextUtils.isEmpty(u)) {
            return u;
        }
        int iDd = dw.nr().dd();
        iz = iDd;
        String strNr = nr(iDd);
        u = strNr;
        return strNr;
    }

    public static int b() {
        return iz;
    }

    public static long[] fx() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    public static String iz() {
        if (pn == null) {
            pn = u("image");
        }
        return pn;
    }

    private static com.bykv.vk.openvk.component.video.api.u.nr n() {
        if (fx == null) {
            synchronized (jk.class) {
                if (fx == null) {
                    com.bytedance.sdk.component.l.nr.u.u uVar = new com.bytedance.sdk.component.l.nr.u.u();
                    fx = uVar;
                    uVar.u(a());
                    fx.pn();
                }
            }
        }
        return fx;
    }

    private static String nr(int i) {
        Context context = dw.getContext();
        File fileNr = i == 1 ? com.bytedance.sdk.component.utils.n.nr(context, com.bytedance.sdk.openadsdk.core.multipro.nr.fx(), "tt_ad") : com.bytedance.sdk.component.utils.n.u(context, com.bytedance.sdk.openadsdk.core.multipro.nr.fx(), "tt_ad");
        if (fileNr.isFile()) {
            fileNr.delete();
        }
        if (!fileNr.exists()) {
            fileNr.mkdirs();
        }
        return fileNr.getAbsolutePath();
    }

    public static String pn() {
        if (b == null) {
            b = u("splash_image");
        }
        return b;
    }

    public static com.bykv.vk.openvk.component.video.api.u.nr u(int i) {
        return i == 1 ? n() : x();
    }

    private static com.bykv.vk.openvk.component.video.api.u.nr x() {
        if (nr == null) {
            synchronized (jk.class) {
                if (nr == null) {
                    com.bykv.vk.openvk.component.video.u.u.u.u uVar = new com.bykv.vk.openvk.component.video.u.u.u.u();
                    nr = uVar;
                    uVar.u(a());
                    nr.pn();
                }
            }
        }
        return nr;
    }

    public static String u() {
        return a() + File.separator + "video_brand";
    }

    public static String u(String str) {
        return a() + File.separator + str;
    }

    public static String[] nr() {
        String strNr = nr(1);
        com.bytedance.sdk.component.l.nr.u.u uVar = new com.bytedance.sdk.component.l.nr.u.u();
        uVar.u(strNr);
        String strNr2 = nr(0);
        com.bytedance.sdk.component.l.nr.u.u uVar2 = new com.bytedance.sdk.component.l.nr.u.u();
        uVar2.u(strNr2);
        return new String[]{uVar.nr(), uVar.fx(), uVar.u(), uVar.b(), uVar2.nr(), uVar2.fx(), uVar2.u(), uVar2.b()};
    }
}
