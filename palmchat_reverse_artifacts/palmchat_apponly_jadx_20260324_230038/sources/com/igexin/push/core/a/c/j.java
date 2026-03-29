package com.igexin.push.core.a.c;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.ex;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.push.core.b.p;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7162a = "com.igexin.push.core.a.c.j";

    private static void a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(270532608);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043 A[Catch: Exception -> 0x00cf, TRY_ENTER, TryCatch #0 {Exception -> 0x00cf, blocks: (B:15:0x0043, B:17:0x005c, B:18:0x0063, B:20:0x0069, B:21:0x0078, B:22:0x007c, B:24:0x0093, B:26:0x009b, B:29:0x00a7, B:31:0x00ad, B:32:0x00bd, B:34:0x00c1), top: B:39:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c A[Catch: Exception -> 0x00cf, TryCatch #0 {Exception -> 0x00cf, blocks: (B:15:0x0043, B:17:0x005c, B:18:0x0063, B:20:0x0069, B:21:0x0078, B:22:0x007c, B:24:0x0093, B:26:0x009b, B:29:0x00a7, B:31:0x00ad, B:32:0x00bd, B:34:0x00c1), top: B:39:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[Catch: Exception -> 0x00cf, TryCatch #0 {Exception -> 0x00cf, blocks: (B:15:0x0043, B:17:0x005c, B:18:0x0063, B:20:0x0069, B:21:0x0078, B:22:0x007c, B:24:0x0093, B:26:0x009b, B:29:0x00a7, B:31:0x00ad, B:32:0x00bd, B:34:0x00c1), top: B:39:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd A[Catch: Exception -> 0x00cf, TryCatch #0 {Exception -> 0x00cf, blocks: (B:15:0x0043, B:17:0x005c, B:18:0x0063, B:20:0x0069, B:21:0x0078, B:22:0x007c, B:24:0x0093, B:26:0x009b, B:29:0x00a7, B:31:0x00ad, B:32:0x00bd, B:34:0x00c1), top: B:39:0x0041 }] */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        boolean z;
        String taskId;
        String messageId;
        String doActionId;
        if (pushTaskBean != null && baseActionBean != null) {
            p pVar = (p) baseActionBean;
            String str = pVar.b;
            boolean z2 = false;
            try {
                if (str.equals("")) {
                    str = com.igexin.push.core.e.f7217a;
                } else {
                    if (!com.igexin.push.core.e.f7217a.equals(pVar.b)) {
                        z = false;
                    }
                    com.igexin.c.a.c.a.a("doStartApp|" + z + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str, new Object[0]);
                    if (z) {
                        com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str, (String) null);
                        if (pVar.d.equals(ex.Code)) {
                            if (com.igexin.push.g.c.a(pVar.f7184a)) {
                                a(com.igexin.push.core.e.l, ((p) baseActionBean).f7184a);
                                z2 = true;
                            }
                            if (z2) {
                            }
                        } else {
                            z2 = true;
                            if (z2) {
                                if (pVar.c != null) {
                                    com.igexin.push.core.a.b.d();
                                    taskId = pushTaskBean.getTaskId();
                                    messageId = pushTaskBean.getMessageId();
                                    doActionId = pVar.c;
                                    com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                                }
                            } else if (pVar.getDoActionId() != null) {
                                com.igexin.push.core.a.b.d();
                                taskId = pushTaskBean.getTaskId();
                                messageId = pushTaskBean.getMessageId();
                                doActionId = pVar.getDoActionId();
                                com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                            }
                        }
                    } else {
                        com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str, (String) null);
                        if (((p) baseActionBean).d.equals(ex.Code)) {
                            a(com.igexin.push.core.e.l, com.igexin.push.core.e.g);
                        }
                        if (pVar.getDoActionId() != null) {
                            com.igexin.push.core.a.b.d();
                            taskId = pushTaskBean.getTaskId();
                            messageId = pushTaskBean.getMessageId();
                            doActionId = pVar.getDoActionId();
                            com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                        }
                    }
                }
                if (z) {
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            z = true;
            com.igexin.c.a.c.a.a("doStartApp|" + z + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str, new Object[0]);
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.setType(com.igexin.push.core.b.q);
            pVar.setActionId(jSONObject.getString("actionid"));
            pVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("appstartupid")) {
                pVar.f7184a = jSONObject.getJSONObject("appstartupid").getString("android");
            }
            if (jSONObject.has("is_autostart")) {
                pVar.d = jSONObject.getString("is_autostart");
            }
            if (jSONObject.has("appid")) {
                pVar.b = jSONObject.getString("appid");
            }
            if (jSONObject.has("noinstall_action")) {
                pVar.c = jSONObject.getString("noinstall_action");
            }
            return pVar;
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}
