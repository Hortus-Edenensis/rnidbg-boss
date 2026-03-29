package com.zenmen.palmchat.messaging;

import com.zenmen.palmchat.c;
import com.zenmen.palmchat.messaging.CreateConnectionDelegate;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ko3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class b {
    public static volatile b e;
    public boolean c = true;
    public CreateConnectionDelegate.k d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ko3 f14703a = new ko3(c.b());
    public com.zenmen.palmchat.messaging.a b = new com.zenmen.palmchat.messaging.a(c.b(), this.d);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CreateConnectionDelegate.k {
        public a() {
        }

        @Override // com.zenmen.palmchat.messaging.CreateConnectionDelegate.k
        public void a(boolean z) {
            LogUtil.i("LXMessageCoreManager", "connect onFinished" + z);
            if (b.this.c) {
                b.d().e().O();
                b.this.c = false;
            }
        }
    }

    public static b d() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    public com.zenmen.palmchat.messaging.a c() {
        return this.b;
    }

    public ko3 e() {
        return this.f14703a;
    }

    public void g() {
    }

    public void f(MessagingService messagingService) {
    }
}
