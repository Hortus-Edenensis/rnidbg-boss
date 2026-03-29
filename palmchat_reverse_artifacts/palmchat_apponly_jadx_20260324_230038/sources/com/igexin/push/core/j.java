package com.igexin.push.core;

import com.igexin.push.core.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class j {
    private static final String b = "HeartBeatGenerator";
    private static j e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7286a = 240000;
    private int c = b.f7289a;
    private long d = 0;

    /* JADX INFO: renamed from: com.igexin.push.core.j$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7287a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[a.a().length];
            b = iArr;
            try {
                iArr[a.f7288a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[a.b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[a.c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[a.d - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[b.a().length];
            f7287a = iArr2;
            try {
                iArr2[b.f7289a - 1] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7287a[b.b - 1] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7287a[b.c - 1] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f7288a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};

        private a(String str, int i) {
        }

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f7289a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private b(String str, int i) {
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    private j() {
    }

    public static j a() {
        if (e == null) {
            e = new j();
        }
        return e;
    }

    private void c(int i) {
        int i2;
        int i3 = AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            i2 = b.b;
        } else {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                this.f7286a = 240000L;
                e(b.f7289a);
                return;
            }
            this.f7286a = Math.max(this.f7286a - 60000, 240000L);
            long j = this.d + 1;
            this.d = j;
            if (j < 2) {
                return;
            }
            this.f7286a = 240000L;
            i2 = b.c;
        }
        e(i2);
    }

    private void d(int i) {
        int i2;
        int i3 = AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            this.f7286a = 240000L;
            i2 = b.f7289a;
        } else {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                this.f7286a = 240000L;
                e(b.f7289a);
                return;
            }
            i2 = b.c;
        }
        e(i2);
    }

    private void e(int i) {
        this.c = i;
        this.d = 0L;
    }

    public final long b() {
        long j = this.f7286a;
        int i = com.igexin.push.config.d.e;
        if (i > 0) {
            j = i * 1000;
        }
        if (e.n && e.u && d.a.f7200a.h.b) {
            return j;
        }
        return 3600000L;
    }

    private void b(int i) {
        int i2;
        int i3 = AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            this.f7286a = Math.min(this.f7286a + 60000, com.igexin.push.config.c.n);
            i2 = b.f7289a;
        } else {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                this.f7286a = 240000L;
                e(b.f7289a);
                return;
            }
            long j = this.d + 1;
            this.d = j;
            if (j < 2) {
                return;
            }
            this.f7286a = Math.max(this.f7286a - 60000, 240000L);
            i2 = b.b;
        }
        e(i2);
    }

    public final void a(int i) {
        int i2;
        int i3 = AnonymousClass1.f7287a[this.c - 1];
        if (i3 != 1) {
            if (i3 == 2) {
                int i4 = AnonymousClass1.b[i - 1];
                if (i4 != 1) {
                    if (i4 != 2 && i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        this.f7286a = 240000L;
                        e(b.f7289a);
                        return;
                    }
                    this.f7286a = Math.max(this.f7286a - 60000, 240000L);
                    long j = this.d + 1;
                    this.d = j;
                    if (j < 2) {
                        return;
                    } else {
                        this.f7286a = 240000L;
                    }
                }
                i2 = b.b;
            } else {
                if (i3 != 3) {
                    return;
                }
                int i5 = AnonymousClass1.b[i - 1];
                if (i5 == 1) {
                    this.f7286a = 240000L;
                    i2 = b.f7289a;
                } else if (i5 != 2 && i5 != 3) {
                    if (i5 != 4) {
                        return;
                    }
                    this.f7286a = 240000L;
                    e(b.f7289a);
                    return;
                }
            }
            i2 = b.c;
        } else {
            int i6 = AnonymousClass1.b[i - 1];
            if (i6 == 1) {
                this.f7286a = Math.min(this.f7286a + 60000, com.igexin.push.config.c.n);
                i2 = b.f7289a;
            } else {
                if (i6 != 2 && i6 != 3) {
                    if (i6 != 4) {
                        return;
                    }
                    this.f7286a = 240000L;
                    e(b.f7289a);
                    return;
                }
                long j2 = this.d + 1;
                this.d = j2;
                if (j2 < 2) {
                    return;
                }
                this.f7286a = Math.max(this.f7286a - 60000, 240000L);
                i2 = b.b;
            }
        }
        e(i2);
    }

    private void a(long j) {
        this.f7286a = j;
    }
}
