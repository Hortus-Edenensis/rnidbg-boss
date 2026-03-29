package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f2910a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<ig> d;
    private static int e;

    public static synchronized void a(boolean z, int i) {
        f2910a = z;
        e = Math.max(0, i);
    }

    public static synchronized void b(List<ik> list, Context context) {
        try {
            List<ik> listB = hz.b();
            if (listB != null && listB.size() > 0) {
                list.addAll(listB);
            }
        } catch (Throwable unused) {
        }
        a(list, context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends jd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static int f2911a = 1;
        static int b = 2;
        static int c = 3;
        private Context d;
        private ik f;
        private int g;
        private List<ik> h;

        public a(Context context, int i) {
            this.d = context;
            this.g = i;
        }

        @Override // com.amap.api.col.p0002sl.jd
        public final void a() {
            ik ikVar;
            Throwable th;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d != null && this.f != null) {
                        synchronized (il.class) {
                            Context context = this.d;
                            if (context != null && (ikVar = this.f) != null) {
                                il.a(context, ikVar.a());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    hd.c(th2, "stm", "as");
                    return;
                }
            }
            if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.d == null) {
                            return;
                        }
                        ig igVarA = im.a(il.d);
                        im.a(this.d, igVarA, hb.h, 1000, 307200, "2");
                        if (igVarA.g == null) {
                            igVarA.g = new in(new ir(this.d, new io(new is(new iu()))));
                        }
                        igVarA.h = 3600000;
                        if (TextUtils.isEmpty(igVarA.i)) {
                            igVarA.i = "cKey";
                        }
                        if (igVarA.f == null) {
                            Context context2 = this.d;
                            igVarA.f = new iy(context2, igVarA.h, igVarA.i, new iv(igVarA.f2905a, new iw(context2, il.f2910a, il.c * 1024, il.b * 1024, "staticUpdate", il.e * 1024)));
                        }
                        ih.a(igVarA);
                        return;
                    } catch (Throwable th3) {
                        hd.c(th3, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (il.class) {
                    if (this.h != null && this.d != null) {
                        byte[] byteArray = new byte[0];
                        ByteArrayOutputStream byteArrayOutputStream = null;
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                for (ik ikVar2 : this.h) {
                                    if (ikVar2 != null) {
                                        byteArrayOutputStream2.write(ikVar2.a());
                                    }
                                }
                                byteArray = byteArrayOutputStream2.toByteArray();
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Throwable th4) {
                                    th = th4;
                                    th.printStackTrace();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    hd.c(th, "stm", "aStB");
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th.printStackTrace();
                                        }
                                    }
                                } finally {
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                        il.a(this.d, byteArray);
                    }
                }
            } catch (Throwable th8) {
                hd.c(th8, "stm", "apb");
            }
        }

        public a(Context context, int i, List<ik> list) {
            this(context, i);
            this.h = list;
        }

        public a(Context context, int i, ik ikVar) {
            this(context, i);
            this.f = ikVar;
        }
    }

    public static synchronized void a(ik ikVar, Context context) {
        jc.a().b(new a(context, a.f2911a, ikVar));
    }

    public static synchronized void a(List<ik> list, Context context) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    jc.a().b(new a(context, a.b, list));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        jc.a().b(new a(context, a.c));
    }

    public static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        ig igVarA = im.a(d);
        im.a(context, igVarA, hb.h, 1000, 307200, "2");
        if (igVarA.e == null) {
            igVarA.e = new hn();
        }
        try {
            ih.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, igVarA);
        } catch (Throwable th) {
            hd.c(th, "stm", "wts");
        }
    }
}
