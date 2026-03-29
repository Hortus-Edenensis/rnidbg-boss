package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class q extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InsideNotificationItem f11208a;
    private String b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        String strB = com.vivo.push.util.u.b(this.f11208a);
        this.b = strB;
        dVar.a("notification_v1", strB);
    }

    public final InsideNotificationItem d() {
        return this.f11208a;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        InsideNotificationItem insideNotificationItem = this.f11208a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.u.b(insideNotificationItem);
    }

    public final boolean f() {
        InsideNotificationItem insideNotificationItem = this.f11208a;
        return insideNotificationItem != null && insideNotificationItem.isNoShowOnForeground();
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String strA = dVar.a("notification_v1");
        this.b = strA;
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        InsideNotificationItem insideNotificationItemA = com.vivo.push.util.u.a(this.b);
        this.f11208a = insideNotificationItemA;
        if (insideNotificationItemA != null) {
            insideNotificationItemA.setMsgId(g());
        }
    }
}
