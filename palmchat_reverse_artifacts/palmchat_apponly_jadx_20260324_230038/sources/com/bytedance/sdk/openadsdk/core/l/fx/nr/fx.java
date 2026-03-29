package com.bytedance.sdk.openadsdk.core.l.fx.nr;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.pn;
import com.bytedance.sdk.openadsdk.core.l.a;
import com.bytedance.sdk.openadsdk.core.l.u.jk;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.bytedance.sdk.openadsdk.my.b;
import com.ss.android.download.api.constant.BaseConstants;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(final Map<String, Object> map, bc bcVar) {
        a.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.o().y() != null) {
                    n.o().y().apply(b.u().u(12).u(Boolean.class).u(0, map).nr());
                }
            }
        }, bcVar);
    }

    public static void u(String str, String str2, bc bcVar, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        if (bcVar == null) {
            u(true, functionY, str2, bcVar, jSONObject, str, "", null, i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            u(true, functionY, str2, bcVar, jSONObject, str, "", null, i);
            return;
        }
        String strIt = bcVar.it();
        if (TextUtils.isEmpty(strIt) && bcVar.hm() != null) {
            strIt = bcVar.hm().mv();
        }
        u(false, functionY, str2, bcVar, jSONObject, str, "", strIt, i);
    }

    public static void nr(int i, int i2) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        functionY.apply(b.u().u(30).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(i2)).u(WfConstant.EVENT_KEY_DOWNLOAD_SCENE, Integer.valueOf(i))).nr());
    }

    public static void u(String str, bc bcVar, JSONObject jSONObject, int i) {
        String str2;
        String str3;
        String strB;
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        if (bcVar == null) {
            u(true, functionY, str, bcVar, jSONObject, null, null, null, i);
            return;
        }
        pn pnVarPu = bcVar.pu();
        if (pnVarPu != null) {
            String strNr = pnVarPu.nr();
            String strFx = pnVarPu.fx();
            strB = pnVarPu.b();
            str2 = strNr;
            str3 = strFx;
        } else {
            str2 = "";
            str3 = str2;
            strB = str3;
        }
        u(false, functionY, str, bcVar, jSONObject, str2, str3, strB, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(boolean z, Function<SparseArray<Object>, Object> function, String str, bc bcVar, JSONObject jSONObject, String str2, String str3, String str4, int i) {
        Class<?> cls;
        String str5;
        String strWf;
        String strNr;
        int i2;
        boolean zFx;
        int i3;
        int iBg;
        if (function == null) {
            return;
        }
        if (z) {
            function.apply(b.u().u(23).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(i)).u("mateIsEmpty", Boolean.valueOf(z))).nr());
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            try {
                jSONObject2.put(jk.EXTRA_DOWN_INFO_KEY, nr.u().u(str).nr(jSONObject).u(bcVar).nr());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
        long jLongValue = Double.valueOf(bcVar.lk()).longValue();
        String strU = bcVar.dd() == null ? null : bcVar.dd().u();
        boolean zRh = n.o().rh();
        boolean z2 = !n.o().rh();
        String strAp = bcVar.ap();
        JSONObject jSONObjectNr = a.nr();
        JSONObject jSONObject3 = new JSONObject();
        try {
            int iOptInt = jSONObjectNr.optInt("notification_opt_2", 0);
            i3 = iOptInt != 1 ? 0 : iOptInt;
            iBg = bq.bg(bcVar);
            if (!d.x()) {
                cls = Void.class;
                try {
                    jSONObject3.put("cancel_pause_optimise_switch", iBg);
                    jSONObject3.put("cancel_pause_optimise_wifi_retain_switch", iBg);
                    jSONObject3.put("cancel_pause_optimise_apk_retain_switch", iBg);
                    jSONObject3.put("cancel_pause_optimise_download_percent_retain_switch", iBg);
                } catch (JSONException unused3) {
                    str5 = "hashCode";
                }
            } else {
                cls = Void.class;
            }
        } catch (JSONException unused4) {
            cls = Void.class;
        }
        try {
            jSONObject3.put("show_pause_continue_toast", iBg);
            str5 = "hashCode";
        } catch (JSONException unused5) {
            str5 = "hashCode";
            String strJf = "";
            if (bcVar.kv() == null) {
            }
            i2 = d.fx;
            if (i2 < 7000) {
                zFx = com.bytedance.sdk.openadsdk.core.multipro.nr.fx();
            }
            function.apply(b.u().u(23).u(cls).u(0, new wq().u("mateIsEmpty", Boolean.FALSE).u("id", Long.valueOf(jLongValue)).u("appIcon", strU).u("isShowNotification", Boolean.valueOf(zRh)).u("isAutoInstallWithoutNotification", Boolean.valueOf(z2)).u("logExtra", strAp).u("extraJson", jSONObject2).u("downloadSettings", jSONObject3).u("filePath", n.o().nr()).u(WfConstant.EVENT_KEY_APP_NAME, str3).u("downloadUrl", str2).u("packageName", str4).u("isNeedIndependentProcess", Boolean.valueOf(zFx)).u("openUrl", strNr).u("webTitle", strWf).u(str5, Integer.valueOf(i)).u("webUrl", strJf)).nr());
        }
        try {
            if (iBg == 1) {
                u(true, i);
                jSONObject3.put("download_start_toast_text", jSONObjectNr.optString("download_start_toast_text", "已开始下载，再次点击可暂停或取消该下载任务。"));
            } else if (dw.nr().je()) {
                u(true, i);
                jSONObject3.put("enable_notification_ui", 1);
                jSONObject3.put("download_start_toast_text", "下载中，可在通知栏暂停或取消");
            }
            jSONObject3.put("notification_opt_2", i3);
            jSONObject3.put("is_use_obm_convert", bq.nr(bcVar));
        } catch (JSONException unused6) {
        }
        String strJf2 = "";
        if (bcVar.kv() == null) {
            strNr = bcVar.kv().nr();
            strWf = bcVar.wf();
            if (bcVar.kv().pn() != 2 || bc.nr(bcVar)) {
                if (bcVar.kv().pn() == 1) {
                    strJf2 = bcVar.kv().b();
                } else {
                    strJf2 = bcVar.jf();
                }
            }
        } else {
            strWf = "";
            strJf2 = bcVar.jf();
            strNr = strWf;
        }
        i2 = d.fx;
        if (i2 < 7000 && i2 < 7300) {
            boolean zU = com.bytedance.sdk.component.utils.bq.u(dw.getContext());
            zFx = dw.nr().c();
            if (!zU) {
                zFx = com.bytedance.sdk.openadsdk.core.multipro.nr.fx();
            }
        } else {
            zFx = com.bytedance.sdk.openadsdk.core.multipro.nr.fx();
        }
        function.apply(b.u().u(23).u(cls).u(0, new wq().u("mateIsEmpty", Boolean.FALSE).u("id", Long.valueOf(jLongValue)).u("appIcon", strU).u("isShowNotification", Boolean.valueOf(zRh)).u("isAutoInstallWithoutNotification", Boolean.valueOf(z2)).u("logExtra", strAp).u("extraJson", jSONObject2).u("downloadSettings", jSONObject3).u("filePath", n.o().nr()).u(WfConstant.EVENT_KEY_APP_NAME, str3).u("downloadUrl", str2).u("packageName", str4).u("isNeedIndependentProcess", Boolean.valueOf(zFx)).u("openUrl", strNr).u("webTitle", strWf).u(str5, Integer.valueOf(i)).u("webUrl", strJf2)).nr());
    }

    public static void u(bc bcVar, int i, boolean z) {
        boolean zNr;
        boolean zU;
        boolean z2;
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        int iB = bq.b(bcVar);
        int iPn = bq.pn(bcVar);
        if (bcVar != null && (!TextUtils.isEmpty(bcVar.kd()) || z)) {
            iPn = 2;
        }
        if (bcVar == null || bcVar.g() == null) {
            zNr = false;
            zU = false;
            z2 = false;
        } else {
            zU = bcVar.g().u();
            zNr = bcVar.g().nr();
            z2 = true;
        }
        functionY.apply(b.u().u(25).u(Void.class).u(0, new wq().u("autoOpen", Integer.valueOf(iB)).u("downloadMode", Integer.valueOf(iPn)).u("isHaveDownloadSdkConfig", Boolean.valueOf(z2)).u("hashCode", Integer.valueOf(i)).u("isEnableAH", Boolean.valueOf(zU)).u("isEnableAM", Boolean.valueOf(zNr))).nr());
    }

    public static void u(int i, int i2) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        functionY.apply(b.u().u(26).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(i2)).u("downloadMode", Integer.valueOf(i))).nr());
    }

    public static void u(boolean z, int i) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        functionY.apply(b.u().u(31).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(i)).u("isShowToast", Boolean.valueOf(z))).nr());
    }

    public static int u(Function<SparseArray<Object>, Object> function, int i) {
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(b.u().u(27).u(Integer.class).u(0, new wq().u("hashCode", Integer.valueOf(i))).nr());
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static void u(boolean z, com.bytedance.sdk.openadsdk.core.l.u.b bVar, int i) {
        try {
            Function<SparseArray<Object>, Object> functionY = n.o().y();
            if (functionY == null) {
                return;
            }
            functionY.apply(b.u().u(28).u(Void.class).u(0, new wq().u("isEnableOppoAutoDownload", Boolean.valueOf(z)).u("hashCode", Integer.valueOf(i)).u("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.my.fx.b.u(bVar))).nr());
        } catch (Throwable th) {
            k.u("xgc_dof", "throwable", th);
        }
    }

    public static void u(com.bytedance.sdk.openadsdk.core.l.u.b bVar, int i) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        functionY.apply(b.u().u(154).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(i)).u("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.my.fx.b.u(bVar))).nr());
    }

    public static void u(u uVar, String str, int i, Bitmap bitmap) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null || uVar == null) {
            return;
        }
        functionY.apply(b.u().u(160).u(Void.class).u(0, new wq().u("install_app_name", uVar.u()).u("install_icon_bitmap", bitmap).u("install_action_type", str).u("install_click_type", Integer.valueOf(i)).u("install_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && dw.nr().vk() > 0)).u("install_package_name", uVar.fx()).u("install_tag", uVar.x()).u("install_value", uVar.n()).u("install_log_extra", uVar.pn()).u("install_download_id", Integer.valueOf(uVar.b()))).nr());
    }

    public static com.bytedance.sdk.openadsdk.core.l.u.b u(bc bcVar, final boolean z) {
        if (bcVar == null) {
            return null;
        }
        String strDv = bcVar.dv();
        if (!TextUtils.isEmpty(strDv) && d.fx >= 6400) {
            final String strXx = bcVar.xx();
            final String strEn = bcVar.en();
            final com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar = (com.bytedance.sdk.openadsdk.my.fx.u.nr) c.u(strDv, com.bytedance.sdk.openadsdk.my.fx.u.nr.class);
            if (nrVar != null && !TextUtils.isEmpty(bcVar.kd()) && bcVar.wj().b() == 1) {
                return new com.bytedance.sdk.openadsdk.core.l.u.b() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.1
                    @Override // com.ss.android.download.api.config.DownloadMarketInterceptor
                    public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
                        if (map != null) {
                            if (!z) {
                                map.put("is_button", Boolean.FALSE);
                            }
                            Object obj = map.get("is_button");
                            nrVar.u(100, map);
                            fx.u(map, obj, strXx, strEn);
                        } else {
                            s sVarU = s.u();
                            Boolean bool = Boolean.FALSE;
                            sVarU.u(bool, bool, "param is null", strXx, strEn);
                        }
                        return map;
                    }
                };
            }
        }
        return null;
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(BaseConstants.SCHEME_MARKET) || str.startsWith("mimarket")) {
            return gi.my();
        }
        return false;
    }

    public static boolean u(Uri uri, bc bcVar, Context context, String str, int i) {
        if (n.o().y() == null || bcVar == null) {
            return false;
        }
        u(str, bcVar, (JSONObject) null, i);
        u(bcVar, i, false);
        u(str, i);
        wq<String, Object> wqVarU = new wq().u("hashCode", Integer.valueOf(i)).u(ContentProviderManager.PROVIDER_URI, uri);
        com.bytedance.sdk.openadsdk.core.l.fx.fx.fx fxVar = new com.bytedance.sdk.openadsdk.core.l.fx.fx.fx(context, bcVar);
        fxVar.u(new com.bytedance.sdk.openadsdk.core.l.fx.fx.pn());
        if (u(bcVar, str, wqVarU, fxVar)) {
            return true;
        }
        nr(wqVarU, bcVar);
        return true;
    }

    private static boolean u(final bc bcVar, String str, final Map<String, Object> map, com.bytedance.sdk.openadsdk.core.l.fx.fx.fx fxVar) {
        if (!fxVar.b(false)) {
            return false;
        }
        fxVar.u(str, new com.bytedance.sdk.openadsdk.core.l.fx.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.2
            @Override // com.bytedance.sdk.openadsdk.core.l.fx.u.nr
            public void u() {
                fx.nr((Map<String, Object>) map, bcVar);
            }
        });
        return true;
    }

    public static void u(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            s.u().u(obj, obj2, "success", str, str2);
            return;
        }
        s sVarU = s.u();
        Boolean bool = Boolean.FALSE;
        sVarU.u(bool, bool, "no intercept result", str, str2);
    }

    public static void u(String str, int i) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null) {
            return;
        }
        functionY.apply(b.u().u(29).u(Void.class).u(0, new wq().u("clickButtonTag", str).u("clickItemTag", str).u("hashCode", Integer.valueOf(i)).u("clickStartLabel", "click_start").u("clickContinueLabel", "click_continue").u("clickPauseLabel", "click_pause").u("storageDenyLabel", "download_failed").u("clickInstallLabel", "click_install").u("isEnableClickEvent", Boolean.TRUE).u("isEnableV3Event", Boolean.FALSE)).nr());
    }

    public static void u(String str, String str2, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionY = n.o().y();
        if (functionY == null || jSONObject == null) {
            return;
        }
        functionY.apply(b.u().u(29).u(Void.class).u(0, new wq().u("clickButtonTag", str).u("clickItemTag", str2).u("clickStartLabel", "click_start").u("clickContinueLabel", "click_continue").u("clickPauseLabel", "click_pause").u("storageDenyLabel", "download_failed").u("clickInstallLabel", "click_install").u("isEnableClickEvent", Boolean.TRUE).u("hashCode", Integer.valueOf(i)).u("isEnableV3Event", Boolean.FALSE).u("extraEventObject", jSONObject)).nr());
    }

    public static void u(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.l.u.nr nrVar) {
        if (d.fx < 4400 || map == null || nrVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", com.bytedance.sdk.openadsdk.my.fx.b.u(nrVar));
    }
}
