package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.b;
import com.xiaomi.push.service.am;
import java.util.Collection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class s extends XMPushService.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XMPushService f11772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f1010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f1011a;
    private String b;
    private String c;

    public s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f11772a = xMPushService;
        this.f1010a = str;
        this.f1011a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* JADX INFO: renamed from: a */
    public void mo403a() {
        am.b next;
        p pVarM765a = q.m765a((Context) this.f11772a);
        if (pVarM765a == null) {
            try {
                pVarM765a = q.a(this.f11772a, this.f1010a, this.b, this.c);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e);
            }
        }
        if (pVarM765a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            t.a(this.f11772a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("do registration now.");
        Collection<am.b> collectionM717a = am.a().m717a("5");
        if (collectionM717a.isEmpty()) {
            next = pVarM765a.a(this.f11772a);
            w.a(this.f11772a, next);
            am.a().a(next);
        } else {
            next = collectionM717a.iterator().next();
        }
        if (!this.f11772a.m692c()) {
            t.a(this.f1010a, this.f1011a);
            this.f11772a.a(true);
            return;
        }
        try {
            am.c cVar = next.f934a;
            if (cVar == am.c.binded) {
                w.a(this.f11772a, this.f1010a, this.f1011a);
            } else if (cVar == am.c.unbind) {
                t.a(this.f1010a, this.f1011a);
                XMPushService xMPushService = this.f11772a;
                xMPushService.getClass();
                xMPushService.a(xMPushService.new b(next));
            }
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e2);
            this.f11772a.a(10, e2);
        }
    }
}
