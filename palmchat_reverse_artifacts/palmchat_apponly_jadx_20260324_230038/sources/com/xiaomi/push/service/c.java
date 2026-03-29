package com.xiaomi.push.service;

import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class c extends XMPushService.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XMPushService f11750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private er[] f976a;

    public c(XMPushService xMPushService, er[] erVarArr) {
        super(4);
        this.f11750a = xMPushService;
        this.f976a = erVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* JADX INFO: renamed from: a */
    public void mo403a() {
        try {
            er[] erVarArr = this.f976a;
            if (erVarArr != null) {
                this.f11750a.a(erVarArr);
            }
        } catch (fi e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f11750a.a(10, e);
        }
    }
}
