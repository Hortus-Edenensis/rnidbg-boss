package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.dp;
import com.xiaomi.push.fa;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ey extends fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private et f11558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private eu f422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread f423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f424a;

    public ey(XMPushService xMPushService, fb fbVar) {
        super(xMPushService, fbVar);
    }

    private void h() throws fi {
        try {
            this.f11558a = new et(((fh) this).f452a.getInputStream(), this);
            this.f422a = new eu(((fh) this).f452a.getOutputStream(), this);
            Thread thread = new Thread("Blob Reader (" + ((fa) this).b + ")") { // from class: com.xiaomi.push.ey.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ey.this.f11558a.m426a();
                    } catch (Exception e) {
                        ey.this.c(9, e);
                    }
                }
            };
            this.f423a = thread;
            thread.start();
        } catch (Exception e) {
            throw new fi("Error to init reader and writer", e);
        }
    }

    @Override // com.xiaomi.push.fa
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo431a() {
        return true;
    }

    public void b(fo foVar) {
        if (foVar == null) {
            return;
        }
        Iterator<fa.a> it = ((fa) this).f441a.values().iterator();
        while (it.hasNext()) {
            it.next().a(foVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized byte[] m432a() {
        if (this.f424a == null && !TextUtils.isEmpty(((fa) this).f438a)) {
            String strM729a = com.xiaomi.push.service.ax.m729a();
            StringBuilder sb = new StringBuilder();
            String str = ((fa) this).f438a;
            sb.append(str.substring(str.length() / 2));
            sb.append(strM729a.substring(strM729a.length() / 2));
            this.f424a = com.xiaomi.push.service.ar.a(((fa) this).f438a.getBytes(), sb.toString().getBytes());
        }
        return this.f424a;
    }

    @Override // com.xiaomi.push.fa
    public void b(er erVar) throws fi {
        eu euVar = this.f422a;
        if (euVar != null) {
            try {
                int iA = euVar.a(erVar);
                ((fa) this).d = SystemClock.elapsedRealtime();
                String strF = erVar.f();
                if (!TextUtils.isEmpty(strF)) {
                    fz.a(((fa) this).f437a, strF, iA, false, true, System.currentTimeMillis());
                }
                Iterator<fa.a> it = ((fa) this).f444b.values().iterator();
                while (it.hasNext()) {
                    it.next().a(erVar);
                }
                return;
            } catch (Exception e) {
                throw new fi(e);
            }
        }
        throw new fi("the writer is null.");
    }

    private er a(boolean z) {
        ex exVar = new ex();
        if (z) {
            exVar.a("1");
        }
        byte[] bArrM412a = ep.m412a();
        if (bArrM412a != null) {
            dp.j jVar = new dp.j();
            jVar.a(a.a(bArrM412a));
            exVar.a(jVar.m398a(), (String) null);
        }
        return exVar;
    }

    @Override // com.xiaomi.push.fh
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo430a(boolean z) throws fi {
        if (this.f422a != null) {
            er erVarA = a(z);
            com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] SND ping id=" + erVarA.e());
            b(erVarA);
            f();
            return;
        }
        throw new fi("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.fa
    public synchronized void a(am.b bVar) {
        eq.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fa
    public synchronized void a(String str, String str2) {
        eq.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fh
    public synchronized void a(int i, Exception exc) {
        et etVar = this.f11558a;
        if (etVar != null) {
            etVar.b();
            this.f11558a = null;
        }
        eu euVar = this.f422a;
        if (euVar != null) {
            try {
                euVar.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("SlimConnection shutdown cause exception: " + e);
            }
            this.f422a = null;
            this.f424a = null;
            super.a(i, exc);
        } else {
            this.f424a = null;
            super.a(i, exc);
        }
    }

    @Override // com.xiaomi.push.fh, com.xiaomi.push.fa
    public void a(er[] erVarArr) throws fi {
        for (er erVar : erVarArr) {
            b(erVar);
        }
    }

    @Override // com.xiaomi.push.fa
    @Deprecated
    public void a(fo foVar) throws fi {
        b(er.a(foVar, (String) null));
    }

    @Override // com.xiaomi.push.fh
    /* JADX INFO: renamed from: a */
    public synchronized void mo450a() {
        h();
        this.f422a.a();
    }

    public void a(er erVar) {
        if (erVar == null) {
            return;
        }
        if (com.xiaomi.push.service.e.a(erVar)) {
            er erVar2 = new er();
            erVar2.a(erVar.a());
            erVar2.a("SYNC", "ACK_RTT");
            erVar2.a(erVar.e());
            erVar2.b(erVar.m420b());
            erVar2.a(erVar.m423c());
            XMPushService xMPushService = ((fa) this).f437a;
            xMPushService.a(new com.xiaomi.push.service.aw(xMPushService, erVar2));
        }
        if (erVar.m417a()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] RCV blob chid=" + erVar.a() + "; id=" + erVar.e() + "; errCode=" + erVar.b() + "; err=" + erVar.m424c());
        }
        if (erVar.a() == 0) {
            if ("PING".equals(erVar.m414a())) {
                com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] RCV ping id=" + erVar.e());
                g();
            } else if ("CLOSE".equals(erVar.m414a())) {
                c(13, null);
            }
        }
        Iterator<fa.a> it = ((fa) this).f441a.values().iterator();
        while (it.hasNext()) {
            it.next().a(erVar);
        }
    }
}
