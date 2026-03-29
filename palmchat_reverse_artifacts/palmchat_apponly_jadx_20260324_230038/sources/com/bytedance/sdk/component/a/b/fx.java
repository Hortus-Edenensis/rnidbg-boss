package com.bytedance.sdk.component.a.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private nr nr;
    private u u;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.a.b.fx$fx, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0202fx {
        private static final fx u = new fx();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(String str, String str2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public static void nr(String str, String str2) {
        if (C0202fx.u.u.compareTo(u.DEBUG) <= 0) {
            fx unused = C0202fx.u;
        }
    }

    public static void u(u uVar) {
        synchronized (fx.class) {
            C0202fx.u.u = uVar;
        }
    }

    private fx() {
        this.u = u.OFF;
        this.nr = new com.bytedance.sdk.component.a.b.nr();
    }

    public static void u(String str, String str2) {
        if (C0202fx.u.u.compareTo(u.ERROR) <= 0) {
            C0202fx.u.nr.u(str, str2);
        }
    }
}
