package com.xiaomi.push.service;

import com.oplus.tblplayer.monitor.ErrorCode;
import com.xiaomi.push.eo;
import com.xiaomi.push.service.XMPushService.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class as {
    private static int d = 300000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private XMPushService f950a;
    private int b = 0;
    private int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11731a = 500;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f949a = 0;

    public as(XMPushService xMPushService) {
        this.f950a = xMPushService;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m727a() {
        this.f949a = System.currentTimeMillis();
        this.f950a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f950a.m687a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.f950a.m688a(1)) {
                this.b++;
            }
            this.f950a.a(1);
            com.xiaomi.channel.commonutils.logger.b.m75a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
            XMPushService xMPushService = this.f950a;
            xMPushService.getClass();
            xMPushService.a(xMPushService.new e());
            return;
        }
        if (this.f950a.m688a(1)) {
            return;
        }
        int iA = a();
        this.b++;
        com.xiaomi.channel.commonutils.logger.b.m74a("schedule reconnect in " + iA + "ms");
        XMPushService xMPushService2 = this.f950a;
        xMPushService2.getClass();
        xMPushService2.a(xMPushService2.new e(), (long) iA);
        if (this.b == 2 && eo.m406a().m411a()) {
            z.b();
        }
        if (this.b == 3) {
            z.a();
        }
    }

    private int a() {
        double d2;
        if (this.b > 8) {
            return ErrorCode.REASON_RD_VIDEO;
        }
        double dRandom = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            d2 = 60000.0d;
        } else {
            if (i <= 1) {
                if (this.f949a == 0) {
                    return 0;
                }
                if (System.currentTimeMillis() - this.f949a < 310000) {
                    int i2 = this.f11731a;
                    int i3 = d;
                    if (i2 >= i3) {
                        return i2;
                    }
                    int i4 = this.c + 1;
                    this.c = i4;
                    if (i4 >= 4) {
                        return i3;
                    }
                    this.f11731a = (int) (((double) i2) * 1.5d);
                    return i2;
                }
                this.f11731a = 1000;
                this.c = 0;
                return 0;
            }
            d2 = 10000.0d;
        }
        return (int) (dRandom * d2);
    }
}
