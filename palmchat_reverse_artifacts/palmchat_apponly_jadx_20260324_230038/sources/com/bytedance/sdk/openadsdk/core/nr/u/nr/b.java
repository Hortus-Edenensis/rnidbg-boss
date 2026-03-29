package com.bytedance.sdk.openadsdk.core.nr.u.nr;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nr.u.nr.pn;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.x;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.openalliance.ad.constant.az;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static volatile b u;
    private Object fx;
    private boolean nr;
    private AtomicBoolean b = new AtomicBoolean(false);
    private AtomicInteger pn = new AtomicInteger(3);
    private AtomicBoolean iz = new AtomicBoolean(false);

    private b() {
        this.nr = false;
        try {
            Object obj = Build.class.getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                Locale locale = Locale.ROOT;
                this.nr = "android 5.3.1".toLowerCase(locale).compareTo(((String) obj).toLowerCase(locale)) <= 0;
            }
        } catch (Throwable unused) {
            this.nr = false;
        }
    }

    private boolean b() {
        Context context = dw.getContext();
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (jk.u(intent, 0).size() > 0) {
            return true;
        }
        if (jp.nr(context)) {
            return false;
        }
        return jp.u("com.tencent.mm");
    }

    public static b fx() {
        if (u == null) {
            synchronized (b.class) {
                if (u == null) {
                    u = new b();
                }
            }
        }
        return u;
    }

    private void pn() {
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.b.2
            @Override // java.lang.Runnable
            public void run() {
                h.nr(dw.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    public int nr() {
        return this.nr ? 1 : 0;
    }

    public boolean u() {
        return this.nr;
    }

    private void u(String str) {
        Method methodU;
        if (!this.b.get() && this.pn.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                u("wc_init_fail", "error_appid");
                return;
            }
            if (!b()) {
                u("wc_init_fail", "error_no_wechat");
                return;
            }
            if (!this.nr) {
                u("wc_init_fail", "error_no_sdk");
                return;
            }
            try {
                Method methodU2 = d.u("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                if (methodU2 != null) {
                    Function<SparseArray<Object>, Object> functionV = n.o().v();
                    Object objApply = functionV != null ? functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Context.class).nr()) : null;
                    if (objApply == null) {
                        objApply = dw.getContext();
                    }
                    if (objApply == null && (methodU = d.u("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        objApply = methodU.invoke(null, new Object[0]);
                    }
                    if (objApply == null) {
                        u("wc_init_fail", "error_sdk");
                        return;
                    }
                    this.fx = methodU2.invoke(null, objApply, str);
                    u("wc_init_suc", "");
                    this.b.set(true);
                }
            } catch (Throwable th) {
                u("wc_init_fail", "error_sdk_" + th.getMessage());
            }
        }
    }

    private void u(String str, String str2) {
        try {
            final com.bytedance.sdk.openadsdk.core.qq.u.nr<com.bytedance.sdk.openadsdk.core.qq.u.nr> nrVarNr = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr();
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error_message", str2);
                nrVarNr.nr(jSONObject.toString());
            }
            nrVarNr.u(str);
            s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.b.1
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() {
                    return nrVarNr;
                }
            }, str);
        } catch (Throwable unused) {
        }
    }

    public void u(bc bcVar, String str, String str2, final pn.u uVar, String str3, boolean z) {
        try {
            if (bcVar == null) {
                uVar.nr();
                pn();
                return;
            }
            jw jwVarKg = bcVar.kg();
            if (jwVarKg == null) {
                u("wc_init_fail", "wechat data is null");
                uVar.nr();
                pn();
                return;
            }
            u(jwVarKg.n());
            if (this.fx == null) {
                uVar.nr();
                pn();
                return;
            }
            Object objNewInstance = WXLaunchMiniProgram.Req.class.newInstance();
            Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
            declaredField.setAccessible(true);
            declaredField.set(objNewInstance, str);
            Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField(OapsWrapper.KEY_PATH);
            declaredField2.setAccessible(true);
            declaredField2.set(objNewInstance, str2);
            Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
            declaredField3.setAccessible(true);
            try {
                declaredField3.set(objNewInstance, WXLaunchMiniProgram.Req.class.getDeclaredField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            } catch (Throwable unused) {
                declaredField3.set(objNewInstance, 0);
            }
            Method method = this.fx.getClass().getMethod("sendReq", WXLaunchMiniProgram.Req.class.getSuperclass());
            jwVarKg.nr(2);
            com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, str3, "deeplink_success_realtime", (Throwable) null);
            HashMap map = new HashMap();
            map.put(az.at, "WeChatOpenSdkProcessor");
            com.bytedance.sdk.openadsdk.core.s.b.n(bcVar, str3, "open_url_app", map);
            com.bytedance.sdk.openadsdk.core.s.n.u().u(bcVar, str3, z);
            method.invoke(this.fx, objNewInstance);
            x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.b.3
                @Override // java.lang.Runnable
                public void run() {
                    uVar.u();
                }
            });
        } catch (Throwable th) {
            u("wc_init_fail", "invoke:" + th.getMessage());
            uVar.nr();
            pn();
        }
    }
}
