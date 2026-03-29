package defpackage;

import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class s13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20652a = new Object();
    public final String b;
    public volatile Logger c;

    public s13(Class<?> cls) {
        this.b = cls.getName();
    }

    public Logger a() {
        Logger logger = this.c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f20652a) {
            Logger logger2 = this.c;
            if (logger2 != null) {
                return logger2;
            }
            Logger logger3 = Logger.getLogger(this.b);
            this.c = logger3;
            return logger3;
        }
    }
}
