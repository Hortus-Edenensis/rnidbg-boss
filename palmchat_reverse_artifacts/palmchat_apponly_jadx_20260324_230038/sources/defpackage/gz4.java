package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class gz4 {
    public static final gz4 b = new gz4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<hz4> f17839a = new AtomicReference<>();

    public static gz4 a() {
        return b;
    }

    public hz4 b() {
        if (this.f17839a.get() == null) {
            g23.a(this.f17839a, null, hz4.a());
        }
        return this.f17839a.get();
    }
}
