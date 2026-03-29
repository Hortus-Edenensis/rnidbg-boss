package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.az;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pb {
    public static boolean u(bc bcVar, String str) {
        if (bcVar == null) {
            return false;
        }
        String strJf = bcVar.jf();
        if (TextUtils.isEmpty(strJf)) {
            return false;
        }
        return u(strJf, bcVar, str);
    }

    public static boolean u(String str, bc bcVar, String str2) {
        return u(dw.getContext(), str, bcVar, jp.nr(str2), str2);
    }

    public static boolean u(Context context, String str, bc bcVar, String str2) {
        return u(context, str, bcVar, jp.nr(str2), str2);
    }

    public static boolean u(Context context, String str, bc bcVar, int i, String str2) {
        try {
            return com.bytedance.sdk.component.utils.nr.u(context, u(context, str, bcVar, i, null, str2, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean u(Object obj) {
        if (obj == null || !(obj instanceof u.InterfaceC0273u)) {
            return false;
        }
        try {
            return ((u.InterfaceC0273u) obj).m_();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent u(Context context, String str, bc bcVar, int i, Object obj, String str2, boolean z) {
        Class cls;
        boolean z2 = false;
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.iz(bcVar)) {
            cls = TTNativePageActivity.class;
        } else if (!(obj instanceof com.bytedance.sdk.openadsdk.my.fx.nr.a) && bc.nr(bcVar) && !u(obj) && jp.x(bcVar) && (bcVar == null || !bcVar.jk())) {
            cls = TTVideoWebPageActivity.class;
            z2 = true;
        } else {
            cls = TTWebPageActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        if (z2) {
            u(context, bcVar, obj, z, intent);
        }
        u(context, str, bcVar, i, str2, intent);
        return intent;
    }

    private static void u(Context context, bc bcVar, Object obj, boolean z, Intent intent) {
        int i;
        if (obj != null) {
            uVarT = obj instanceof u.InterfaceC0273u ? ((u.InterfaceC0273u) obj).r_() : null;
            if (uVarT != null) {
                intent.putExtra("multi_process_data", uVarT.u().toString());
            }
        }
        if ((obj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.nr) && (uVarT = ((com.bytedance.sdk.openadsdk.core.nativeexpress.nr) obj).t()) != null) {
            intent.putExtra("multi_process_data", uVarT.u().toString());
        }
        if (uVarT != null) {
            intent.putExtra("video_is_auto_play", uVarT.b);
            uVarT.u();
        }
        if (uVarT != null || z) {
            try {
                if (uVarT != null) {
                    i = (int) ((uVarT.x / uVarT.pn) * 100.0f);
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
                    uVar.x = 100L;
                    uVar.u = true;
                    uVar.b = jp.q(bcVar);
                    intent.putExtra("multi_process_data", uVar.u().toString());
                    i = 100;
                }
                if (bcVar.qb() == 0) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                } else {
                    if (bcVar.qb() <= 0 || i <= bcVar.qb() || !jp.q(bcVar)) {
                        return;
                    }
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void u(Context context, String str, bc bcVar, int i, String str2, Intent intent) {
        if (!new com.bytedance.sdk.openadsdk.core.l.fx.fx.fx(context, bcVar).b(false)) {
            bcVar.fx(true);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", bcVar.wv());
        intent.putExtra("title", bcVar.wf());
        intent.putExtra("sdk_version", d.fx);
        intent.putExtra(MediationConstant.EXTRA_ADID, bcVar.lk());
        intent.putExtra("log_extra", bcVar.ap());
        intent.putExtra("icon_url", bcVar.dd() == null ? null : bcVar.dd().u());
        intent.putExtra("event_tag", str2);
        intent.putExtra(az.at, i);
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", bcVar.iz());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        jp.u(intent, bcVar);
    }

    public static boolean u(Context context, bc bcVar, int i, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            u(context, null, bcVar, i, str, intent);
            if (bc.nr(bcVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.bytedance.sdk.component.utils.nr.u(context, intent, null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
