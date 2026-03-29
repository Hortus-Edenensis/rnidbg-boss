package com.qq.gdt.action;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.opos.mobad.activity.VideoActivity;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.q;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class GDTAction {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, JSONObject jSONObject) {
        com.qq.gdt.action.c.a aVarA = c.a(str, jSONObject);
        JSONObject jSONObjectA = d.a().a(new JSONObject());
        try {
            jSONObjectA.put("currentInitSuccess", d.a().f());
            o.a("init 是否成功 = " + d.a().f(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.h.a.a(4002, aVarA, jSONObjectA);
        d.a().a(aVarA);
    }

    public static String getChannelID(Context context) {
        return com.qq.gdt.action.b.b.a(context);
    }

    public static String getClickID(Context context) {
        return com.qq.gdt.action.b.b.b(context);
    }

    public static void init(Context context, String str, String str2) {
        d.a().a(context, str, str2, ChannelType.CHANNEL_TENCENT, null, null);
    }

    public static boolean isAutoCollectionAction(com.qq.gdt.action.c.a aVar) {
        String strC = aVar.c();
        return "PAUSE".equals(strC) || "RESUME".equals(strC) || "TICKET".equals(strC) || "ENTER_BACKGROUND".equals(strC) || "ENTER_FOREGROUND".equals(strC);
    }

    public static void logAction(String str) {
        logAction(str, null);
    }

    public static void setAnidEnable(boolean z) {
        d.a().a(z);
    }

    public static void setPrivateController(PrivateController privateController) {
        d.a().a(privateController);
    }

    public static void setUserUniqueId(String str) {
        d.a().a(str);
    }

    public static void setYlhExt(JSONObject jSONObject) {
        d.a().b(jSONObject);
    }

    public static void start() {
        d.a().b();
    }

    public static void init(Context context, String str, String str2, ChannelType channelType) {
        d.a().a(context, str, str2, channelType, null, null);
    }

    public static boolean isAutoCollectionAction(String str) {
        return "PAUSE".equals(str) || "RESUME".equals(str) || "TICKET".equals(str) || "ENTER_BACKGROUND".equals(str) || "ENTER_FOREGROUND".equals(str);
    }

    public static void logAction(final String str, final JSONObject jSONObject) {
        d.a().c();
        if (!isAutoCollectionAction(str)) {
            d.a().b();
        }
        final JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, str);
            jSONObject2.put("actionTime", System.currentTimeMillis());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!com.qq.gdt.action.j.b.a(str)) {
            com.qq.gdt.action.h.a.a(5001, jSONObject2);
        } else {
            if (!com.qq.gdt.action.j.b.a(jSONObject)) {
                com.qq.gdt.action.h.a.a(5003, jSONObject2);
                return;
            }
            if (!q.b(d.a().g())) {
                o.b("上报数据前建议在App中先申请获取动态权限！");
            }
            com.qq.gdt.action.multioprocess.a.a().a(new com.qq.gdt.action.multioprocess.c() { // from class: com.qq.gdt.action.GDTAction.1
                @Override // com.qq.gdt.action.multioprocess.c
                public void a(com.qq.gdt.action.multioprocess.b bVar) {
                    try {
                        if (d.a().f()) {
                            GDTAction.b(str, jSONObject);
                            return;
                        }
                        if (!com.qq.gdt.action.multioprocess.a.a().c()) {
                            com.qq.gdt.action.h.a.a(4003, jSONObject2);
                            o.a("tryfillUserInfo fill switch close", new Object[0]);
                            o.c("GDTAction未进行初始化，请先调用GDTAction的init方法成功初始化SDK后，再调用其他数据上报方法！");
                            return;
                        }
                        o.a("logAction remoteUserMessage  = " + bVar, new Object[0]);
                        try {
                            d.a().a(bVar, jSONObject2, "auto_init_by_logaction");
                            if (d.a().f()) {
                                GDTAction.b(str, jSONObject);
                                return;
                            }
                            com.qq.gdt.action.h.a.a(4003, jSONObject2);
                            o.a("logAction remote fill failed", new Object[0]);
                            o.c("GDTAction未进行初始化，请先调用GDTAction的init方法成功初始化SDK后，再调用其他数据上报方法！");
                        } catch (Throwable th) {
                            o.a("logAction fill exception", th);
                            try {
                                com.qq.gdt.action.h.a.a(5004, new JSONObject().put("errorCode", -1).put(MediationConstant.KEY_ERROR_MSG, th.getMessage()));
                            } catch (Exception e2) {
                                o.a("unexpected json exception", e2);
                            }
                        }
                    } catch (Throwable th2) {
                        o.b("Log action exception", th2);
                        try {
                            com.qq.gdt.action.h.a.a(5004, new JSONObject().put("errorCode", -1).put(MediationConstant.KEY_ERROR_MSG, th2.getMessage()));
                        } catch (Exception e3) {
                            o.a("unexpected json exception", e3);
                        }
                    }
                }
            });
        }
    }

    public static void init(Context context, String str, String str2, ChannelType channelType, String str3) {
        d.a().a(context, str, str2, channelType, str3, null);
    }

    @Deprecated
    public static void init(Context context, String str, String str2, ChannelType channelType, String str3, a aVar) {
        d.a().a(context, str, str2, channelType, str3, aVar);
    }

    public static void init(Context context, String str, String str2, String str3) {
        d.a().a(context, str, str2, ChannelType.CHANNEL_TENCENT, str3, null);
    }
}
