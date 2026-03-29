package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.qq;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.hms.ads.ex;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    public static boolean a(bc bcVar) {
        return (bcVar == null || bcVar.fa() == null) ? false : true;
    }

    public static boolean b(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        int iRh = bcVar.rh();
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVarJa = bcVar.ja();
        return uVarJa != null && iRh == 1 && uVarJa.b() == 3;
    }

    public static boolean fx(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        int iRh = bcVar.rh();
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVarJa = bcVar.ja();
        return uVarJa != null && iRh == 1 && uVarJa.b() == 4;
    }

    public static boolean iz(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return x(bcVar) || n(bcVar);
    }

    public static boolean n(bc bcVar) {
        return bcVar != null && bcVar.c() > 0;
    }

    public static boolean nr(bc bcVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVarBf;
        JSONObject jSONObjectFx;
        return (bcVar == null || (uVarBf = bcVar.bf()) == null || (jSONObjectFx = uVarBf.fx()) == null || jSONObjectFx.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean pn(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        int iRh = bcVar.rh();
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVarJa = bcVar.ja();
        return uVarJa != null && iRh == 1 && uVarJa.b() == 2;
    }

    public static boolean x(bc bcVar) {
        return (bcVar == null || bcVar.rh() != 1 || bg.u(bcVar)) ? false : true;
    }

    public static int u(bc bcVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVarBf;
        JSONObject jSONObjectFx;
        int iOptInt;
        if (bcVar == null || (uVarBf = bcVar.bf()) == null || (jSONObjectFx = uVarBf.fx()) == null || (iOptInt = jSONObjectFx.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return iOptInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(final boolean z, final String str, final fx fxVar) {
        if (fxVar != null) {
            com.bytedance.sdk.component.utils.jk.nr().post(new com.bytedance.sdk.component.jk.a("tt_ugen_tpl") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.jk.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        fxVar.u(str);
                    } else {
                        fxVar.u();
                    }
                }
            });
        }
    }

    private static void nr(String str, final String str2, final fx fxVar) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            nr(false, (String) null, fxVar);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.bytedance.sdk.component.a.nr.fx fxVarFx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
        if (fxVarFx == null) {
            nr(false, (String) null, fxVar);
        } else {
            fxVarFx.u(str);
            fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.jk.2
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                    if (nrVar != null) {
                        try {
                            if (nrVar.a() && nrVar.pn() != null) {
                                com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u("ugeno_template_kv");
                                String strPn = nrVar.pn();
                                fxVarU.put(str2, strPn);
                                jk.nr(true, strPn, fxVar);
                                return;
                            }
                        } catch (Exception unused) {
                            jk.nr(false, (String) null, fxVar);
                            return;
                        }
                    }
                    jk.nr(false, (String) null, fxVar);
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                    jk.nr(false, (String) null, fxVar);
                }
            });
        }
    }

    public static JSONObject u(bc bcVar, View view, boolean z) {
        JSONObject jSONObjectEt = bcVar.et();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            boolean z2 = false;
            jSONObject.put("voice_control", bcVar.jn() == 1);
            Context context = dw.getContext();
            jSONObject3.put("width", y.b(context, y.b(context)));
            jSONObject3.put("height", y.b(context, y.pn(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", y.b(context, width) * 1.0f);
                jSONObject4.put("height", y.b(context, height) * 1.0f);
                jSONObject2.put("content_size", jSONObject4);
            }
            jSONObject2.put("screen_size", jSONObject3);
            jSONObjectEt.put("env_info", jSONObject2);
            jSONObjectEt.put("setting", jSONObject);
            jSONObjectEt.put("meta_hashcode", bcVar.n());
            if (z && dw.nr().uk()) {
                z2 = true;
            }
            jSONObjectEt.put("gesture_through_enable", z2);
        } catch (JSONException unused) {
        }
        return jSONObjectEt;
    }

    public static int nr(Context context, bc bcVar, String str) {
        if (bcVar == null) {
            return -1;
        }
        qq qqVarFa = bcVar.fa();
        if (qqVarFa == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context != null && context.getResources().getConfiguration().orientation != 1) {
            return 9;
        }
        String strNr = qqVarFa.nr();
        if (u(strNr, qqVarFa.fx(), (fx) null) == null) {
            return TextUtils.isEmpty(strNr) ? 2 : 3;
        }
        return 1;
    }

    public static boolean u(Context context, bc bcVar, String str) {
        return nr(context, bcVar, str) == 1;
    }

    public static String u(Context context, String str, bc bcVar, String str2) {
        qq qqVarFa = bcVar.fa();
        JSONObject jSONObjectMs = bcVar.ms();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("icon_url", str2);
            }
            String strYm = bcVar.ym();
            if (!TextUtils.isEmpty(strYm)) {
                jSONObject.put("description", strYm);
            }
            if (jSONObjectMs != null) {
                jSONObject.put("easy_pl_material", jSONObjectMs.toString());
            }
            if (qqVarFa != null) {
                jSONObject.put("ugen_dialog_url", qqVarFa.nr());
                jSONObject.put("ugen_dialog_md5", qqVarFa.fx());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", ex.Code);
                } else {
                    jSONObject.put("vertical", ex.V);
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static JSONObject u(String str, String str2, fx fxVar) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            if (fxVar != null) {
                fxVar.u();
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u("ugeno_template_kv");
        if (fxVarU == null) {
            if (fxVar != null) {
                fxVar.u();
            }
            return null;
        }
        try {
            str3 = fxVarU.get(str2, "");
        } catch (Exception unused) {
            if (fxVar != null) {
                fxVar.u();
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            if (fxVar != null) {
                fxVar.u(str3);
            }
            return new JSONObject(str3);
        }
        if (!TextUtils.isEmpty(str)) {
            nr(str, str2, fxVar);
            return null;
        }
        if (fxVar != null) {
            fxVar.u();
        }
        return null;
    }
}
