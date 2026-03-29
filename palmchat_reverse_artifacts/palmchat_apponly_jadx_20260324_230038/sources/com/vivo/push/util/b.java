package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.security.PublicKey;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f11299a;
    protected long b;
    protected Context c;
    protected NotifyArriveCallbackByUser d;

    public static void a(Intent intent, Context context) {
        try {
            String strA = com.vivo.push.f.b.a().a(context).a("com.vivo.pushservice");
            PublicKey publicKeyA = com.vivo.push.f.b.a().a(context).a();
            if (TextUtils.isEmpty(strA)) {
                strA = "com.vivo.pushservice";
            }
            intent.putExtra("security_avoid_pull_rsa", strA);
            intent.putExtra("security_avoid_rsa_public_key", publicKeyA == null ? "com.vivo.pushservice" : aa.a(publicKeyA));
        } catch (Exception e) {
            t.a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e.getMessage());
            intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
            intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
        }
    }

    public abstract int a();

    public abstract PendingIntent a(Context context, Intent intent);

    public abstract Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    public final long b() {
        return this.b;
    }

    public final Intent a(Context context, String str, long j, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.b = j;
        this.f11299a = str;
        this.c = context;
        this.d = notifyArriveCallbackByUser;
        Intent intentA = a(context, insideNotificationItem, notifyArriveCallbackByUser);
        int iA = a();
        if (iA <= 0) {
            return intentA;
        }
        HashMap map = new HashMap();
        map.put(com.heytap.mcssdk.constant.b.c, String.valueOf(this.b));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        map.put("ap", this.f11299a);
        map.put("clientsdkver", String.valueOf(ag.c(this.c, this.f11299a)));
        f.a(iA, (HashMap<String, String>) map);
        return null;
    }

    public static Intent a(Context context, String str, long j, Intent intent, InsideNotificationItem insideNotificationItem) {
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        intent2.putExtras(intent.getExtras());
        a(intent2, context);
        com.vivo.push.b.p pVar = new com.vivo.push.b.p(str, j, insideNotificationItem);
        pVar.b(intent.getAction());
        if (intent.getComponent() != null) {
            pVar.c(intent.getComponent().getPackageName());
            pVar.d(intent.getComponent().getClassName());
        }
        if (intent.getData() != null) {
            pVar.a(intent.getData());
        }
        pVar.b(intent2);
        return intent2;
    }
}
