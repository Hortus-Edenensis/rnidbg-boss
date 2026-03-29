package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.d;
import com.vivo.push.f.b;
import com.vivo.push.i;
import com.vivo.push.util.aa;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import com.vivo.push.v;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public static void a(Context context, String str, v vVar) {
        boolean zC = vVar.c();
        i iVarA = i.a(context, zC ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean zA = iVarA.a();
        if (TextUtils.isEmpty(vVar.a())) {
            vVar.a(context.getPackageName());
        }
        if (zA && !"com.vivo.pushservice".equals(context.getPackageName())) {
            d dVar = new d(vVar.a(), str, new Bundle());
            vVar.a(dVar);
            if (iVarA.a(dVar.b())) {
                return;
            }
            t.b("CommandBridge", "send command error by aidl");
            t.c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, zC ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        vVar.a(intent);
        try {
            a(context, intent);
        } catch (Exception e) {
            t.a("CommandBridge", "CommandBridge startService exception: ", e);
        }
    }

    public static void a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e) {
                t.a("CommandBridge", "start service error", e);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        t.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    public static void a(Context context, v vVar, String str) {
        try {
            boolean zD = z.d(context, str);
            String str2 = zD ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (!TextUtils.isEmpty(str)) {
                if (zD || a(context, str2, str)) {
                    if (TextUtils.isEmpty(vVar.a())) {
                        vVar.a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(1048576);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    intent.setClassName(str, zD ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                    vVar.b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    intent.putExtra("security_avoid_pull_rsa", b.a().a(context).a("com.vivo.pushservice"));
                    intent.putExtra("security_avoid_rsa_public_key", aa.a(b.a().a(context).a()));
                    a(context, intent);
                    return;
                }
                return;
            }
            t.c(context, "消息接受者包名为空！");
            throw new Exception("消息接受者包名为空！");
        } catch (Exception e) {
            t.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                return true;
            }
            t.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            t.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
