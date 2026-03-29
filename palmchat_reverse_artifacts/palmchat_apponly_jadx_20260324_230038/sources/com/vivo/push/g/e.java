package com.vivo.push.g;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class e extends aa {
    public e(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        Intent uri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        InsideNotificationItem insideNotificationItemF = pVar.f();
        if (insideNotificationItemF == null) {
            com.vivo.push.util.t.d("NotifyOpenClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage uPSNotificationMessageA = com.vivo.push.util.u.a(insideNotificationItemF);
        boolean zEquals = this.f11282a.getPackageName().equals(pVar.d());
        if (zEquals) {
            NotifyAdapterUtil.cancelNotify(this.f11282a);
        }
        if (zEquals) {
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
            com.vivo.push.util.t.d("NotifyOpenClientTask", "notification is clicked by skip type[" + uPSNotificationMessageA.getSkipType() + "]");
            int skipType = uPSNotificationMessageA.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new f(this, this.f11282a, uPSNotificationMessageA.getParams())).start();
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType == 2) {
                String skipContent = uPSNotificationMessageA.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    z = false;
                }
                if (z) {
                    Uri uri2 = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", uri2);
                    intent.setFlags(268435456);
                    b(intent, uPSNotificationMessageA.getParams());
                    try {
                        this.f11282a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.t.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(uri2)));
                    }
                } else {
                    com.vivo.push.util.t.a("NotifyOpenClientTask", "url not legal");
                }
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType == 3) {
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.t.a("NotifyOpenClientTask", "illegitmacy skip type error : " + uPSNotificationMessageA.getSkipType());
                return;
            }
            String skipContent2 = uPSNotificationMessageA.getSkipContent();
            try {
                uri = Intent.parseUri(skipContent2, 1);
                str = uri.getPackage();
            } catch (Exception e) {
                com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e);
            }
            if (!TextUtils.isEmpty(str) && !this.f11282a.getPackageName().equals(str)) {
                com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f11282a.getPackageName() + "; but remote pkgName is " + uri.getPackage());
                return;
            }
            String packageName = uri.getComponent() == null ? null : uri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f11282a.getPackageName().equals(packageName)) {
                com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f11282a.getPackageName() + "; but remote pkgName is " + uri.getPackage());
                return;
            }
            uri.setSelector(null);
            uri.setPackage(this.f11282a.getPackageName());
            uri.addFlags(335544320);
            b(uri, uPSNotificationMessageA.getParams());
            ActivityInfo activityInfoResolveActivityInfo = uri.resolveActivityInfo(this.f11282a.getPackageManager(), 65536);
            if (activityInfoResolveActivityInfo != null && !activityInfoResolveActivityInfo.exported) {
                com.vivo.push.util.t.a("NotifyOpenClientTask", "activity is not exported : " + activityInfoResolveActivityInfo.toString());
                return;
            } else {
                this.f11282a.startActivity(uri);
                a(uPSNotificationMessageA);
                return;
            }
        }
        com.vivo.push.util.t.a("NotifyOpenClientTask", "notify is " + uPSNotificationMessageA + " ; isMatch is " + zEquals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.t.c(new g(this, uPSNotificationMessage));
    }
}
