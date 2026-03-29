package com.bykv.vk.openvk.component.video.u;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.iz.fx;
import com.bykv.vk.openvk.component.video.api.u.nr;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    public static int b = 10;
    public static int fx = 10;
    public static int nr = 10;
    private static nr pn = null;
    public static int u = 10;

    public static int b() {
        return fx;
    }

    public static int fx() {
        return nr;
    }

    public static int nr() {
        return u;
    }

    public static int pn() {
        return b;
    }

    public static void u(Context context) {
        com.bykv.vk.openvk.component.video.api.iz.u.u(context);
        if (Build.VERSION.SDK_INT < 23) {
            com.bykv.vk.openvk.component.video.u.nr.iz.u.u();
        }
    }

    public static void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            u = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH, 10);
            nr = jSONObject.optInt("reward", 10);
            fx = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt(AdnName.OTHER, 10);
            b = iOptInt;
            if (u < 0) {
                u = 10;
            }
            if (nr < 0) {
                nr = 10;
            }
            if (fx < 0) {
                fx = 10;
            }
            if (iOptInt < 0) {
                b = 10;
            }
        } catch (Throwable th) {
            fx.u("MediaConfig", th.getMessage());
        }
    }

    public static void u(nr nrVar) {
        pn = nrVar;
    }

    public static void u() {
        nr nrVar = pn;
        if (nrVar != null) {
            nrVar.pn();
        }
    }
}
