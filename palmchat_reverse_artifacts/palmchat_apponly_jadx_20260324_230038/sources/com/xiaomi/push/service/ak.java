package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.cc;
import com.xiaomi.push.cg;
import com.xiaomi.push.db;
import com.xiaomi.push.dp;
import com.xiaomi.push.ei;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.fb;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fz;
import com.xiaomi.push.service.am;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XMPushService f11716a;

    public ak(XMPushService xMPushService) {
        this.f11716a = xMPushService;
    }

    private void c(er erVar) {
        am.b bVarA;
        String strG = erVar.g();
        String string = Integer.toString(erVar.a());
        if (TextUtils.isEmpty(strG) || TextUtils.isEmpty(string) || (bVarA = am.a().a(string, strG)) == null) {
            return;
        }
        fz.a(this.f11716a, bVarA.f936a, erVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fo foVar) {
        if (!"5".equals(foVar.k())) {
            b(foVar);
        }
        String strK = foVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = "1";
            foVar.l("1");
        }
        if (strK.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Received wrong packet with chid = 0 : " + foVar.mo455a());
        }
        if (foVar instanceof fm) {
            fl flVarA = foVar.a("kick");
            if (flVarA != null) {
                String strL = foVar.l();
                String strA = flVarA.a("type");
                String strA2 = flVarA.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m74a("kicked by server, chid=" + strK + " res=" + am.b.a(strL) + " type=" + strA + " reason=" + strA2);
                if (!"wait".equals(strA)) {
                    this.f11716a.a(strK, strL, 3, strA2, strA);
                    am.a().m721a(strK, strL);
                    return;
                }
                am.b bVarA = am.a().a(strK, strL);
                if (bVarA != null) {
                    this.f11716a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strA2, strA);
                    return;
                }
                return;
            }
        } else if (foVar instanceof fn) {
            fn fnVar = (fn) foVar;
            if ("redir".equals(fnVar.b())) {
                fl flVarA2 = fnVar.a("hosts");
                if (flVarA2 != null) {
                    a(flVarA2);
                    return;
                }
                return;
            }
        }
        this.f11716a.m689b().a(this.f11716a, strK, foVar);
    }

    public void b(er erVar) {
        String strM414a = erVar.m414a();
        if (erVar.a() == 0) {
            if ("PING".equals(strM414a)) {
                byte[] bArrM418a = erVar.m418a();
                if (bArrM418a != null && bArrM418a.length > 0) {
                    dp.j jVarA = dp.j.a(bArrM418a);
                    if (jVarA.m372b()) {
                        ax.a().a(jVarA.m370a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f11716a.getPackageName())) {
                    this.f11716a.m686a();
                }
                if ("1".equals(erVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("received a server ping");
                } else {
                    ep.b();
                }
                this.f11716a.m690b();
                return;
            }
            if (!"SYNC".equals(strM414a)) {
                if ("NOTIFY".equals(erVar.m414a())) {
                    dp.h hVarA = dp.h.a(erVar.m418a());
                    com.xiaomi.channel.commonutils.logger.b.m74a("notify by server err = " + hVarA.c() + " desc = " + hVarA.m364a());
                    return;
                }
                return;
            }
            if ("CONF".equals(erVar.m421b())) {
                ax.a().a(dp.b.a(erVar.m418a()));
                return;
            }
            if (TextUtils.equals("U", erVar.m421b())) {
                dp.k kVarA = dp.k.a(erVar.m418a());
                db.a(this.f11716a).a(kVarA.m374a(), kVarA.m377b(), new Date(kVarA.m373a()), new Date(kVarA.m376b()), kVarA.c() * 1024, kVarA.e());
                er erVar2 = new er();
                erVar2.a(0);
                erVar2.a(erVar.m414a(), "UCA");
                erVar2.a(erVar.e());
                XMPushService xMPushService = this.f11716a;
                xMPushService.a(new aw(xMPushService, erVar2));
                return;
            }
            if (TextUtils.equals("P", erVar.m421b())) {
                dp.i iVarA = dp.i.a(erVar.m418a());
                er erVar3 = new er();
                erVar3.a(0);
                erVar3.a(erVar.m414a(), "PCA");
                erVar3.a(erVar.e());
                dp.i iVar = new dp.i();
                if (iVarA.m368a()) {
                    iVar.a(iVarA.m367a());
                }
                erVar3.a(iVar.m398a(), (String) null);
                XMPushService xMPushService2 = this.f11716a;
                xMPushService2.a(new aw(xMPushService2, erVar3));
                com.xiaomi.channel.commonutils.logger.b.m74a("ACK msgP: id = " + erVar.e());
                return;
            }
            return;
        }
        String string = Integer.toString(erVar.a());
        if ("SECMSG".equals(erVar.m414a())) {
            if (!erVar.m417a()) {
                this.f11716a.m689b().a(this.f11716a, string, erVar);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("Recv SECMSG errCode = " + erVar.b() + " errStr = " + erVar.m424c());
            return;
        }
        if (!"BIND".equals(strM414a)) {
            if ("KICK".equals(strM414a)) {
                dp.g gVarA = dp.g.a(erVar.m418a());
                String strG = erVar.g();
                String strM359a = gVarA.m359a();
                String strM361b = gVarA.m361b();
                com.xiaomi.channel.commonutils.logger.b.m74a("kicked by server, chid=" + string + " res= " + am.b.a(strG) + " type=" + strM359a + " reason=" + strM361b);
                if (!"wait".equals(strM359a)) {
                    this.f11716a.a(string, strG, 3, strM361b, strM359a);
                    am.a().m721a(string, strG);
                    return;
                }
                am.b bVarA = am.a().a(string, strG);
                if (bVarA != null) {
                    this.f11716a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strM361b, strM359a);
                    return;
                }
                return;
            }
            return;
        }
        dp.d dVarA = dp.d.a(erVar.m418a());
        String strG2 = erVar.g();
        am.b bVarA2 = am.a().a(string, strG2);
        if (bVarA2 == null) {
            return;
        }
        if (dVarA.m335a()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("SMACK: channel bind succeeded, chid=" + erVar.a());
            bVarA2.a(am.c.binded, 1, 0, (String) null, (String) null);
            return;
        }
        String strM334a = dVarA.m334a();
        if ("auth".equals(strM334a)) {
            if ("invalid-sig".equals(dVarA.m336b())) {
                com.xiaomi.channel.commonutils.logger.b.m74a("SMACK: bind error invalid-sig token = " + bVarA2.c + " sec = " + bVarA2.h);
                ep.a(0, ei.BIND_INVALID_SIG.a(), 1, null, 0);
            }
            bVarA2.a(am.c.unbind, 1, 5, dVarA.m336b(), strM334a);
            am.a().m721a(string, strG2);
        } else if ("cancel".equals(strM334a)) {
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m336b(), strM334a);
            am.a().m721a(string, strG2);
        } else if ("wait".equals(strM334a)) {
            this.f11716a.a(bVarA2);
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m336b(), strM334a);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("SMACK: channel bind failed, chid=" + string + " reason=" + dVarA.m336b());
    }

    public void a(er erVar) {
        if (5 != erVar.a()) {
            c(erVar);
        }
        try {
            b(erVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + erVar.a() + " cmd = " + erVar.m414a() + " packetid = " + erVar.e() + " failure ", e);
        }
    }

    private void a(fl flVar) {
        String strC = flVar.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        String[] strArrSplit = strC.split(com.huawei.openalliance.ad.constant.x.aQ);
        cc ccVarA = cg.a().a(fb.a(), false);
        if (ccVarA == null || strArrSplit.length <= 0) {
            return;
        }
        ccVarA.a(strArrSplit);
        this.f11716a.a(20, (Exception) null);
        this.f11716a.a(true);
    }

    private void b(fo foVar) {
        am.b bVarA;
        String strL = foVar.l();
        String strK = foVar.k();
        if (TextUtils.isEmpty(strL) || TextUtils.isEmpty(strK) || (bVarA = am.a().a(strK, strL)) == null) {
            return;
        }
        fz.a(this.f11716a, bVarA.f936a, fz.a(foVar.mo455a()), true, true, System.currentTimeMillis());
    }
}
