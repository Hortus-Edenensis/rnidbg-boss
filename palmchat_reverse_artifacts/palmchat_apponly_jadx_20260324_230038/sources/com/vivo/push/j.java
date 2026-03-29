package com.vivo.push;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class j implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f11249a;

    public j(i iVar) {
        this.f11249a = iVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message == null) {
            com.vivo.push.util.t.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            com.vivo.push.util.t.a("AidlManager", "In connect, bind core service time out");
            if (this.f11249a.f.get() == 2) {
                this.f11249a.a(1);
            }
        } else if (i != 2) {
            com.vivo.push.util.t.b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            if (this.f11249a.f.get() == 4) {
                this.f11249a.f();
            }
            this.f11249a.a(1);
        }
        return true;
    }
}
