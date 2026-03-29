package com.qq.gdt.action.multioprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.qq.gdt.action.ChannelType;
import com.qq.gdt.action.j.g;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.v;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {
    private static volatile d b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f10548a;
    private HandlerThread c;
    private Handler d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b f10549a;

        public a(b bVar) {
            this.f10549a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.a("BroadSendRunnable run", new Object[0]);
            Intent intent = new Intent();
            intent.setAction(UserMessageChangeReceiver.f10540a);
            intent.putExtra("user_message", this.f10549a);
            Context contextG = com.qq.gdt.action.d.a().g();
            if (contextG != null && !TextUtils.isEmpty(contextG.getPackageName())) {
                intent.setPackage(contextG.getPackageName());
            }
            com.qq.gdt.action.d.a().g().sendBroadcast(intent, UserMessageChangeReceiver.c);
        }
    }

    private synchronized void g() {
        if (this.f10548a == null) {
            b bVarB = b();
            this.f10548a = bVarB;
            if (bVarB == null) {
                this.f10548a = new b();
            }
        }
    }

    private synchronized com.qq.gdt.action.multioprocess.b.a h() {
        b bVar;
        bVar = this.f10548a;
        return (bVar == null || bVar.o() == null) ? null : this.f10548a.o();
    }

    private synchronized void i() {
        com.qq.gdt.action.h.a.a(2300, this.f10548a);
        b bVar = this.f10548a;
        if (bVar != null) {
            com.qq.gdt.action.h.a.a(2301, bVar);
        }
        if (TextUtils.isEmpty(this.f10548a.b()) || TextUtils.isEmpty(this.f10548a.h())) {
            com.qq.gdt.action.h.a.a(2308, this.f10548a);
        } else {
            com.qq.gdt.action.h.a.a(this.f10548a.b().equals(this.f10548a.h()) ? 2303 : 2302, this.f10548a);
        }
        if (TextUtils.isEmpty(this.f10548a.c()) || TextUtils.isEmpty(this.f10548a.i())) {
            com.qq.gdt.action.h.a.a(2309);
        } else {
            com.qq.gdt.action.h.a.a(this.f10548a.c().equals(this.f10548a.i()) ? 2305 : 2304, this.f10548a);
        }
        if (TextUtils.isEmpty(this.f10548a.d()) || TextUtils.isEmpty(this.f10548a.j())) {
            com.qq.gdt.action.h.a.a(2310, this.f10548a);
        } else {
            com.qq.gdt.action.h.a.a(this.f10548a.d().equals(this.f10548a.j()) ? 2307 : 2306, this.f10548a);
        }
    }

    public b a(String str, String str2, ChannelType channelType, String str3, String str4, boolean z) {
        o.a("updateRemoteMessage enter", new Object[0]);
        g();
        if (channelType == null) {
            channelType = ChannelType.CHANNEL_TENCENT;
        }
        this.f10548a.e(str).f(str2).b(channelType).g(str3).h(str4);
        if (z) {
            com.qq.gdt.action.multioprocess.a.a().a(this.f10548a);
        }
        i();
        a(this.f10548a);
        return this.f10548a;
    }

    public synchronized b b() {
        b bVarC = c();
        this.f10548a = bVarC;
        if (bVarC == null) {
            this.f10548a = com.qq.gdt.action.multioprocess.a.a().b();
        }
        return this.f10548a;
    }

    public synchronized b c() {
        return this.f10548a;
    }

    public synchronized String d() {
        String strF = f();
        if (com.qq.gdt.action.d.a().g() == null) {
            o.a("getUserUniqueId context is null，no allow ipc getUserUniqueId", new Object[0]);
        } else if (TextUtils.isEmpty(strF)) {
            if (g.a().b()) {
                return strF;
            }
            this.f10548a = com.qq.gdt.action.multioprocess.a.a().b();
            strF = f();
        }
        return strF;
    }

    public synchronized com.qq.gdt.action.multioprocess.b.a e() {
        com.qq.gdt.action.multioprocess.b.a aVarH = h();
        if (com.qq.gdt.action.d.a().g() == null) {
            o.a("getPrivacyStatus context is null，no allow ipc getPrivacyStatus", new Object[0]);
        } else if (aVarH == null) {
            if (g.a().b()) {
                return null;
            }
            this.f10548a = com.qq.gdt.action.multioprocess.a.a().b();
            aVarH = h();
        }
        return aVarH;
    }

    public synchronized String f() {
        String strF;
        strF = "";
        b bVar = this.f10548a;
        if (bVar != null && !v.a(bVar.b())) {
            strF = this.f10548a.f();
        }
        return strF;
    }

    public b a(String str, String str2, ChannelType channelType, String str3, boolean z) {
        g();
        this.f10548a.a(str).b(str2).a(channelType).c(str3);
        o.a("updateUserSetMessage needSaveUserSetInfo = " + z, new Object[0]);
        com.qq.gdt.action.h.a.a(z ? 3200 : 3201, this.f10548a);
        if (z) {
            com.qq.gdt.action.multioprocess.a.a().a(this.f10548a);
        }
        com.qq.gdt.action.h.a.a(3408, this.f10548a);
        o.a("update UserMessage-> updateUserSetMessage = " + this.f10548a, new Object[0]);
        i();
        a(this.f10548a);
        return this.f10548a;
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public synchronized void a(com.qq.gdt.action.multioprocess.b.a aVar) {
        g();
        this.f10548a.a(aVar);
        com.qq.gdt.action.multioprocess.a.a().a(this.f10548a);
        o.a("update UserMessage-> updateDeviceMessage = " + this.f10548a, new Object[0]);
        a(this.f10548a);
    }

    private void a(b bVar) {
        o.a("notifyAllProcess BroadSendRunnable, userMessage = " + bVar, new Object[0]);
        if (this.c == null) {
            HandlerThread handlerThread = new HandlerThread("send HandlerThread");
            this.c = handlerThread;
            handlerThread.start();
        }
        if (this.d == null) {
            this.d = new Handler(this.c.getLooper());
        }
        this.d.removeCallbacksAndMessages(null);
        this.d.postDelayed(new a(bVar), 1000L);
    }

    public synchronized void a(String str) {
        g();
        this.f10548a.d(str);
        com.qq.gdt.action.multioprocess.a.a().a(this.f10548a);
        o.a("update UserMessage-> updateUniqueIdMessage = " + this.f10548a, new Object[0]);
        a(this.f10548a);
    }
}
