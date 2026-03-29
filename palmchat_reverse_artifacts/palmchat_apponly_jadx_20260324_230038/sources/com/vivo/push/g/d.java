package com.vivo.push.g;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class d extends aa {
    public d(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    @Override // com.vivo.push.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.vivo.push.v vVar) {
        Intent intent;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        if (pVar == null) {
            com.vivo.push.util.t.d("NotifyInnerClientTask", "current onNotifyArrivedCommand is null");
            return;
        }
        InsideNotificationItem insideNotificationItemF = pVar.f();
        if (insideNotificationItemF == null) {
            com.vivo.push.util.t.d("NotifyInnerClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage uPSNotificationMessageA = com.vivo.push.util.u.a(insideNotificationItemF);
        boolean zEquals = this.f11282a.getPackageName().equals(pVar.d());
        if (zEquals) {
            NotifyAdapterUtil.cancelNotify(this.f11282a);
        }
        if (!zEquals) {
            com.vivo.push.util.t.a("NotifyInnerClientTask", "notify is " + uPSNotificationMessageA + " ; isMatch is " + zEquals);
            return;
        }
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
        HashMap<String, String> map = new HashMap<>();
        map.put("type", "2");
        map.put(com.heytap.mcssdk.constant.b.c, String.valueOf(pVar.e()));
        map.put("platform", this.f11282a.getPackageName());
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        xVar.a(map);
        com.vivo.push.m.a().a(xVar);
        com.vivo.push.util.t.d("NotifyInnerClientTask", "notification is clicked by skip type[" + uPSNotificationMessageA.getSkipType() + "]");
        com.vivo.push.util.t.d("NotifyInnerClientTask", "notification is clicked by skip content[" + uPSNotificationMessageA.getSkipContent() + "]");
        try {
            if (uPSNotificationMessageA.getSkipType() == 2) {
                String skipContent = uPSNotificationMessageA.getSkipContent();
                if (!TextUtils.isEmpty(skipContent)) {
                    String lowerCase = skipContent.toLowerCase();
                    boolean z = lowerCase.startsWith("http://") || lowerCase.startsWith("https://");
                    if (!z) {
                        return;
                    }
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(skipContent));
                    intent.setFlags(268435456);
                }
            } else {
                intent = new Intent(pVar.g());
                if (!TextUtils.isEmpty(pVar.h()) && !TextUtils.isEmpty(pVar.i())) {
                    intent.setComponent(new ComponentName(pVar.h(), pVar.i()));
                }
                String packageName = intent.getComponent() == null ? null : intent.getComponent().getPackageName();
                if (!TextUtils.isEmpty(packageName) && !this.f11282a.getPackageName().equals(packageName)) {
                    com.vivo.push.util.t.a("NotifyInnerClientTask", "inner activity component error : local pkgName is " + this.f11282a.getPackageName() + "; but remote pkgName is " + packageName);
                    return;
                }
                if (pVar.j() != null) {
                    intent.setData(pVar.j());
                }
                intent.setSelector(null);
                intent.setPackage(this.f11282a.getPackageName());
                intent.addFlags(335544320);
                ActivityInfo activityInfoResolveActivityInfo = intent.resolveActivityInfo(this.f11282a.getPackageManager(), 65536);
                if (activityInfoResolveActivityInfo != null && !activityInfoResolveActivityInfo.exported) {
                    com.vivo.push.util.t.d("NotifyInnerClientTask", "activity is not exported : " + activityInfoResolveActivityInfo.toString());
                }
            }
            intent.putExtras(pVar.k());
            this.f11282a.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
