package com.bytedance.embedapplog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bg {
    private static nr nr = u.u();
    private static int u = 6;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class nr {
        public void u(String str, String str2) {
        }

        public void u(String str, String str2, Throwable th) {
        }

        public boolean u(int i) {
            return bg.u() <= i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u extends nr {

        /* JADX INFO: renamed from: com.bytedance.embedapplog.bg$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0181u {
            private static final u u = new u();
        }

        public static u u() {
            return C0181u.u;
        }

        private u() {
        }

        @Override // com.bytedance.embedapplog.bg.nr
        public void u(String str, String str2, Throwable th) {
            com.bytedance.sdk.component.utils.k.u(str, str2, th);
        }

        @Override // com.bytedance.embedapplog.bg.nr
        public void u(String str, String str2) {
            com.bytedance.sdk.component.utils.k.nr(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (str2 != null && nr.u(6)) {
            nr.u(str, str2);
        }
    }

    public static void fx(String str, String str2) {
        if (str2 == null) {
            return;
        }
        nr.u(5);
    }

    public static boolean nr() {
        return u <= 3;
    }

    public static int u() {
        return u;
    }

    public static void nr(String str, String str2) {
        if (str2 == null) {
            return;
        }
        nr.u(4);
    }

    public static void u(String str) {
        u("Logger", str);
    }

    public static void nr(String str) {
        b("Logger", str);
    }

    public static void u(String str, String str2) {
        if (str2 == null) {
            return;
        }
        nr.u(3);
    }

    public static void u(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && nr.u(6)) {
            nr.u(str, str2, th);
        }
    }
}
