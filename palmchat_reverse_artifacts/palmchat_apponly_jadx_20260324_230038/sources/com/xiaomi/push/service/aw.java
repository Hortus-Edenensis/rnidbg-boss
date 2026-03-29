package com.xiaomi.push.service;

import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class aw extends XMPushService.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private er f11736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private XMPushService f952a;

    public aw(XMPushService xMPushService, er erVar) {
        super(4);
        this.f952a = xMPushService;
        this.f11736a = erVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* JADX INFO: renamed from: a */
    public void mo403a() {
        try {
            er erVar = this.f11736a;
            if (erVar != null) {
                if (e.a(erVar)) {
                    this.f11736a.c(System.currentTimeMillis() - this.f11736a.m413a());
                }
                this.f952a.a(this.f11736a);
            }
        } catch (fi e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f952a.a(10, e);
        }
    }
}
