package com.bytedance.sdk.openadsdk.core.y;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.ss.android.download.api.constant.BaseConstants;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static com.bytedance.sdk.openadsdk.core.s nr;
    private static final Map<String, u> u = DesugarCollections.synchronizedMap(new HashMap());

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void onDialogBtnNo();

        void onDialogBtnYes();

        void onDialogCancel();
    }

    public static void b(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, Context context, String str) {
        int iSx = com.bytedance.sdk.openadsdk.core.kj.bq.sx(bcVar);
        if (bcVar == null || context == null) {
            return;
        }
        if (bcVar.qf() == 4 || iSx != 0) {
            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.l.n.u(context, bcVar, str, false);
            if (fxVarU instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
                ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVarU).n().u(false);
            }
            fxVarU.u(bcVar, false);
        }
    }

    public static void fx(final com.bytedance.sdk.openadsdk.core.kj.bc bcVar, final Context context, final String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        u(context, bcVar.lk(), bcVar.wu(), new u() { // from class: com.bytedance.sdk.openadsdk.core.y.iz.5
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                iz.b(bcVar, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
            }
        });
    }

    public static u pn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return u.remove(str);
    }

    public static void nr(final com.bytedance.sdk.openadsdk.core.kj.bc bcVar, final Context context, final String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        u(context, bcVar.lk(), new u() { // from class: com.bytedance.sdk.openadsdk.core.y.iz.4
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                iz.b(bcVar, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
            }
        }, bcVar.wu());
    }

    public static void u(Context context, String str, String str2, String str3, u uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        u(str, uVar);
        TTDelegateActivity.u(context, str, str2, str3);
    }

    public static void fx(String str) {
        u(str, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.s fx() {
        if (nr == null) {
            nr = s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(com.bytedance.sdk.openadsdk.core.dw.getContext()).u(2));
        }
        return nr;
    }

    public static void nr(Context context, String str, String str2, u uVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        u(str2, uVar);
        TTDelegateActivity.fx(context, str2, str);
    }

    public static void u(final Context context, final String str, final String str2, final String str3, final u uVar, final com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar, final com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.iz.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zU = com.bytedance.sdk.openadsdk.core.n.o().u(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                    if (iz.u.containsKey(str)) {
                        return;
                    }
                    if (!jp.b() && !zU) {
                        return;
                    }
                }
                iz.u(str, uVar);
                TTDelegateActivity.u(context, str, str2, str3, xVar, bcVar);
            }
        });
    }

    public static void b(String str) {
        u(str, 3);
    }

    public static void nr(String str) {
        u(str, 1);
    }

    public static void u(final Context context, final String str, final String str2, final String str3, final u uVar, final com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.iz.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zU = com.bytedance.sdk.openadsdk.core.n.o().u(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                    if (iz.u.containsKey(str)) {
                        return;
                    }
                    if (!jp.b() && !zU) {
                        return;
                    }
                }
                iz.u(str, uVar);
                TTDelegateActivity.u(context, str, str2, str3, bcVar);
            }
        });
    }

    public static void u(String str) {
        Map<String, u> map = u;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void u(Context context, String str, u uVar, String str2, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        u(str, uVar);
        TTDelegateActivity.u(context, str, str2, bcVar);
    }

    public static void u(final com.bytedance.sdk.openadsdk.core.kj.bc bcVar, final Context context, final String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        u(context, bcVar.lk(), new u() { // from class: com.bytedance.sdk.openadsdk.core.y.iz.3
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                iz.b(bcVar, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
            }
        }, bcVar.wu(), bcVar);
    }

    public static void u(Context context, String str, u uVar, String str2) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        u(str, uVar);
        TTDelegateActivity.nr(context, str, str2);
    }

    public static void u(Context context, String str, String str2, u uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        u(str, uVar);
        TTDelegateActivity.u(context, str, str2);
    }

    public static void u(final Context context, final com.bytedance.sdk.openadsdk.core.kj.bc bcVar, final String str) {
        if (bcVar == null) {
            return;
        }
        String strLk = bcVar.lk();
        if (TextUtils.isEmpty(strLk)) {
            return;
        }
        u(strLk, new u() { // from class: com.bytedance.sdk.openadsdk.core.y.iz.6
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                iz.b(bcVar, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
            }
        });
        com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = bcVar.hm();
        if (izVarHm == null) {
            return;
        }
        TTDelegateActivity.fx(context, strLk, izVarHm.a());
    }

    public static void u(Context context, String str) {
        TTDelegateActivity.u(context, str);
        com.bytedance.sdk.openadsdk.core.qq.s.u().u(str);
    }

    public static void u(Context context, String str, String str2, String str3, String str4, String str5, u uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        u(str, uVar);
        TTDelegateActivity.u(context, str, str2, str3, str4, str5);
    }

    public static void u(Context context, String str, boolean z, u uVar) {
        if (z) {
            TTDelegateActivity.u(context, str, z);
        } else {
            if (TextUtils.isEmpty(str) || uVar == null) {
                return;
            }
            u(str, uVar);
            TTDelegateActivity.u(context, str, z);
        }
    }

    public static void u(final String str, final u uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("addDialogListener") { // from class: com.bytedance.sdk.openadsdk.core.y.iz.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        iz.fx().u(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.u(uVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            u.put(str, uVar);
        }
    }

    private static void u(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("doHandler") { // from class: com.bytedance.sdk.openadsdk.core.y.iz.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        iz.fx().u(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        u uVarPn = pn(str);
        if (uVarPn == null) {
            return;
        }
        if (i == 1) {
            uVarPn.onDialogBtnYes();
            return;
        }
        if (i == 2) {
            uVarPn.onDialogBtnNo();
        } else if (i != 3) {
            uVarPn.onDialogCancel();
        } else {
            uVarPn.onDialogCancel();
        }
    }

    public static void u(Context context, String str, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        TTDelegateActivity.u(context, str, bcVar);
    }

    public static void u(Context context, final com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return;
        }
        new u.C0284u().pn(bcVar.lk()).u("pangle_logo").nr("open_policy").b(bcVar.ap()).u(new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.iz.9
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", bcVar.yf());
                jSONObject2.put("ad_slot_type", jp.jk(bcVar));
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
        TTDelegateActivity.nr(context, bcVar.yf());
    }

    public static boolean u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null || bcVar.hl() || bcVar.wj() == null || com.bytedance.sdk.openadsdk.core.kj.bq.mv(bcVar) == 1 || bcVar.qf() != 4 || com.bytedance.sdk.openadsdk.core.kj.bq.l(bcVar) == 0) {
            return false;
        }
        int iC = bcVar.c();
        return iC == 4 || iC == 5;
    }
}
