package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.er;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fq;
import com.xiaomi.push.service.am;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f11756a = new u();

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (com.xiaomi.push.j.m655c()) {
                intent.addFlags(16777216);
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.f11756a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f936a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(an.s, bVar.f939b);
        intent.putExtra(an.J, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f936a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f936a);
        intent.putExtra(an.v, bVar.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(an.s, bVar.f939b);
        intent.putExtra(an.J, bVar.i);
        if (bVar.f930a != null && "9".equals(bVar.g)) {
            try {
                bVar.f930a.send(Message.obtain(null, 17, intent));
                return;
            } catch (RemoteException unused) {
                bVar.f930a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str = bVar.f939b;
                sb.append(str.substring(str.lastIndexOf(64)));
                com.xiaomi.channel.commonutils.logger.b.m74a(sb.toString());
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f936a, Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fo foVar) {
        String str2;
        am.b bVarA = a(foVar);
        if (bVarA == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f11756a.a(xMPushService, foVar, bVarA);
            return;
        }
        String str3 = bVarA.f936a;
        if (foVar instanceof fn) {
            str2 = "com.xiaomi.push.new_msg";
        } else if (foVar instanceof fm) {
            str2 = "com.xiaomi.push.new_iq";
        } else {
            if (!(foVar instanceof fq)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            }
            str2 = "com.xiaomi.push.new_pres";
        }
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str3);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_packet", foVar.a());
        intent.putExtra(an.J, bVarA.i);
        intent.putExtra(an.B, bVarA.h);
        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("[Bcst] notify packet arrival. %s,%s,%s", bVarA.g, bVarA.f936a, foVar.j()));
        if ("3".equalsIgnoreCase(str)) {
            intent.putExtra(an.w, foVar.f467a);
            intent.putExtra(an.x, System.currentTimeMillis());
        }
        a(xMPushService, intent, bVarA);
    }

    public void a(XMPushService xMPushService, String str, er erVar) {
        am.b bVarA = a(erVar);
        if (bVarA == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f11756a.a(xMPushService, erVar, bVarA);
            return;
        }
        String str2 = bVarA.f936a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", erVar.m419a(bVarA.h));
        intent.putExtra(an.J, bVarA.i);
        intent.putExtra(an.B, bVarA.h);
        if (e.a(erVar)) {
            intent.putExtra("ext_downward_pkt_id", erVar.e());
        }
        if (bVarA.f930a != null) {
            try {
                bVarA.f930a.send(Message.obtain(null, 17, intent));
                com.xiaomi.channel.commonutils.logger.b.m74a("message was sent by messenger for chid=" + str);
                return;
            } catch (RemoteException unused) {
                bVarA.f930a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str3 = bVarA.f939b;
                sb.append(str3.substring(str3.lastIndexOf(64)));
                com.xiaomi.channel.commonutils.logger.b.m74a(sb.toString());
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVarA.g, bVarA.f936a, erVar.e()));
        if (e.a(erVar)) {
            at.a().a(erVar.e(), SystemClock.elapsedRealtime());
        }
        a(xMPushService, intent, bVarA);
    }

    public am.b a(fo foVar) {
        Collection<am.b> collectionM717a = am.a().m717a(foVar.k());
        if (collectionM717a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = collectionM717a.iterator();
        if (collectionM717a.size() == 1) {
            return it.next();
        }
        String strM = foVar.m();
        String strL = foVar.l();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(strM, next.f939b) || TextUtils.equals(strL, next.f939b)) {
                return next;
            }
        }
        return null;
    }

    public am.b a(er erVar) {
        Collection<am.b> collectionM717a = am.a().m717a(Integer.toString(erVar.a()));
        if (collectionM717a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = collectionM717a.iterator();
        if (collectionM717a.size() == 1) {
            return it.next();
        }
        String strG = erVar.g();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(strG, next.f939b)) {
                return next;
            }
        }
        return null;
    }

    public void a(Context context, am.b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f936a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(an.s, bVar.f939b);
        intent.putExtra(an.J, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f936a, str2));
        a(context, intent, bVar);
    }

    private static void a(Context context, Intent intent, am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public static String a(am.b bVar) {
        if (!"9".equals(bVar.g)) {
            return bVar.f936a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f936a + ".permission.MIMC_RECEIVE";
    }
}
