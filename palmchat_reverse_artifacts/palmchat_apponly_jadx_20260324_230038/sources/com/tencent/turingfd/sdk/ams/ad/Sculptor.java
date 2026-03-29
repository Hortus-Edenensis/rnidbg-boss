package com.tencent.turingfd.sdk.ams.ad;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Sculptor extends Ara {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<String> f10738a = new AtomicReference<>(null);
    public final boolean b;

    public Sculptor(boolean z) {
        this.b = z;
    }

    public String toString() {
        synchronized (this.f10738a) {
            String str = this.f10738a.get();
            if (str != null) {
                return str;
            }
            try {
                this.f10738a.wait(2000L);
            } catch (InterruptedException unused) {
            }
            return this.f10738a.get();
        }
    }
}
