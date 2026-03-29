package com.xiaomi.push;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.download.api.constant.BaseConstants;
import com.xiaomi.push.ax;
import com.xiaomi.push.dp;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private en f395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f397a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ax f394a = ax.a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final eo f11548a = new eo();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static eo m406a() {
        return a.f11548a;
    }

    public boolean b() {
        m407a();
        return this.f397a && this.f394a.m183a() > 0;
    }

    public static en a() {
        en enVar;
        eo eoVar = a.f11548a;
        synchronized (eoVar) {
            enVar = eoVar.f395a;
        }
        return enVar;
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f395a = new en(xMPushService);
        this.f396a = "";
        com.xiaomi.push.service.ax.a().a(new ax.a() { // from class: com.xiaomi.push.eo.1
            @Override // com.xiaomi.push.service.ax.a
            public void a(dp.b bVar) {
                if (bVar.m325e()) {
                    eo.m406a().m410a(bVar.e());
                }
            }
        });
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m411a() {
        return this.f397a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m410a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = BaseConstants.Time.WEEK;
            }
            if (this.f11546a == i2 && this.f397a) {
                return;
            }
            this.f397a = true;
            this.f393a = System.currentTimeMillis();
            this.f11546a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f393a);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m407a() {
        if (!this.f397a || System.currentTimeMillis() - this.f393a <= this.f11546a) {
            return;
        }
        this.f397a = false;
        this.f393a = 0L;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ek m409a() {
        ek ekVarA;
        if (b()) {
            ekVarA = a(!au.d(this.f395a.f390a) ? MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS : 750);
        } else {
            ekVarA = null;
        }
        return ekVarA;
    }

    private ek a(int i) {
        ArrayList arrayList = new ArrayList();
        ek ekVar = new ek(this.f396a, arrayList);
        if (!au.d(this.f395a.f390a)) {
            ekVar.a(i.i(this.f395a.f390a));
        }
        ii iiVar = new ii(i);
        ia iaVarA = new ig.a().a(iiVar);
        try {
            ekVar.b(iaVarA);
        } catch (hu unused) {
        }
        LinkedList<ax.a> linkedListM184a = this.f394a.m184a();
        while (linkedListM184a.size() > 0) {
            try {
                ej ejVarA = a(linkedListM184a.getLast());
                if (ejVarA != null) {
                    ejVarA.b(iaVarA);
                }
                if (iiVar.a() > i) {
                    break;
                }
                if (ejVarA != null) {
                    arrayList.add(ejVarA);
                }
                linkedListM184a.removeLast();
            } catch (hu | NoSuchElementException unused2) {
            }
        }
        return ekVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ej m408a() {
        ej ejVar;
        ejVar = new ej();
        ejVar.a(au.m171a((Context) this.f395a.f390a));
        ejVar.f367a = (byte) 0;
        ejVar.f371b = 1;
        ejVar.d((int) (System.currentTimeMillis() / 1000));
        return ejVar;
    }

    private ej a(ax.a aVar) {
        if (aVar.f139a == 0) {
            Object obj = aVar.f140a;
            if (obj instanceof ej) {
                return (ej) obj;
            }
            return null;
        }
        ej ejVarM408a = m408a();
        ejVarM408a.a(ei.CHANNEL_STATS_COUNTER.a());
        ejVarM408a.c(aVar.f139a);
        ejVarM408a.c(aVar.f141a);
        return ejVarM408a;
    }

    public synchronized void a(ej ejVar) {
        this.f394a.a(ejVar);
    }
}
