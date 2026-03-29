package com.unicom.xiaowo.account.shield.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11182a;
    final /* synthetic */ c b;

    public a(c cVar, String str) {
        this.b = cVar;
        this.f11182a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized ("callbackLock") {
            try {
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendResult error:");
                sb.append(e.getMessage());
                com.unicom.xiaowo.account.shield.c.b.b(sb.toString());
            }
            if (!c.f11184a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cbresult:");
                sb2.append(this.f11182a);
                com.unicom.xiaowo.account.shield.c.b.b(sb2.toString());
                boolean unused = c.f11184a = true;
                this.b.d.onResult(this.f11182a);
            }
        }
    }
}
