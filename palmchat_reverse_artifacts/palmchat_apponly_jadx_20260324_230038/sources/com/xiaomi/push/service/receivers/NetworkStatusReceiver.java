package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.p;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.mipush.sdk.v;
import com.xiaomi.push.au;
import com.xiaomi.push.fz;
import com.xiaomi.push.m;
import com.xiaomi.push.service.ServiceClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11770a = false;
    private boolean b = true;

    public NetworkStatusReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (this.b) {
            return;
        }
        au.m174a();
        m.a().post(new Runnable() { // from class: com.xiaomi.push.service.receivers.NetworkStatusReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                NetworkStatusReceiver.this.a(context);
            }
        });
    }

    public static boolean a() {
        return f11770a;
    }

    public NetworkStatusReceiver(Object obj) {
        f11770a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!u.a(context).m144a() && b.m99a(context).m108c() && !b.m99a(context).m111f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        fz.m471a(context);
        if (au.m175a(context) && u.a(context).m147b()) {
            u.a(context).m148c();
        }
        if (au.m175a(context)) {
            if ("syncing".equals(p.a(context).a(v.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(p.a(context).a(v.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            p pVarA = p.a(context);
            v vVar = v.UPLOAD_HUAWEI_TOKEN;
            if ("syncing".equals(pVarA.a(vVar))) {
                u.a(context).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, TKDownloadReason.KSAD_TK_NET);
            }
            if ("syncing".equals(p.a(context).a(v.UPLOAD_FCM_TOKEN))) {
                u.a(context).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, TKDownloadReason.KSAD_TK_NET);
            }
            p pVarA2 = p.a(context);
            v vVar2 = v.UPLOAD_COS_TOKEN;
            if ("syncing".equals(pVarA2.a(vVar2))) {
                u.a(context).a((String) null, vVar2, d.ASSEMBLE_PUSH_COS, TKDownloadReason.KSAD_TK_NET);
            }
            p pVarA3 = p.a(context);
            v vVar3 = v.UPLOAD_FTOS_TOKEN;
            if ("syncing".equals(pVarA3.a(vVar3))) {
                u.a(context).a((String) null, vVar3, d.ASSEMBLE_PUSH_FTOS, TKDownloadReason.KSAD_TK_NET);
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }
}
