package com.zenmen.palmchat.giftkit;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f14071a;

    /* JADX INFO: renamed from: com.zenmen.palmchat.giftkit.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1055a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(Context context, String str, long j, InterfaceC1055a interfaceC1055a);

        boolean b();

        boolean c();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f14072a = new a();
    }

    public static a a() {
        return c.f14072a;
    }

    public void b(Context context, String str, long j, InterfaceC1055a interfaceC1055a) {
        b bVar = this.f14071a;
        if (bVar != null) {
            bVar.a(context, str, j, interfaceC1055a);
        }
    }

    public boolean c() {
        b bVar = this.f14071a;
        if (bVar != null) {
            return bVar.b();
        }
        return false;
    }

    public boolean d() {
        b bVar = this.f14071a;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    public void e(b bVar) {
        this.f14071a = bVar;
    }
}
