package defpackage;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class aw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static yv2 f1590a;
    public static volatile aw2 b;
    public static final Object c = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends xw2 {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Bundle g;
        public final /* synthetic */ Object[] h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Context context, String str2, int i, String str3, Bundle bundle, Object[] objArr) {
            super(str);
            this.c = context;
            this.d = str2;
            this.e = i;
            this.f = str3;
            this.g = bundle;
            this.h = objArr;
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                aw2.this.d(this.c);
                aw2.f1590a.b(this.c, this.d, this.e, this.f, this.g, this.h);
            } catch (Throwable th) {
                k63.l("JCoreInternalHelper", "onEvent e:" + th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends xw2 {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Bundle f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Context context, String str2, String str3, Bundle bundle) {
            super(str);
            this.c = context;
            this.d = str2;
            this.e = str3;
            this.f = bundle;
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                aw2.this.d(this.c);
                aw2.f1590a.a(this.c, this.d, this.e, this.f);
            } catch (Throwable th) {
                k63.l("JCoreInternalHelper", "directHandle e:" + th);
            }
        }
    }

    public static aw2 c() {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new aw2();
                }
            }
        }
        return b;
    }

    public Bundle b(Context context, String str, String str2, Bundle bundle) {
        yv2 yv2Var = f1590a;
        if (yv2Var != null) {
            return yv2Var.a(context, str, str2, bundle);
        }
        wz4.a("ONCE_TASK", new b("JCoreInternalHelper#directHandle", context, str, str2, bundle));
        return new Bundle();
    }

    public synchronized void d(Context context) {
        yv2 yv2Var = f1590a;
        if (yv2Var != null) {
            return;
        }
        if (context == null) {
            return;
        }
        if (yv2Var == null) {
            k63.a("JCoreInternalHelper", "load action by local");
            f1590a = new xv2();
        }
    }

    public Object e(Context context, String str, int i, boolean z, String str2, Bundle bundle, Object... objArr) {
        yv2 yv2Var = f1590a;
        if (yv2Var != null) {
            return yv2Var.b(context, str, i, str2, bundle, objArr);
        }
        if (!z) {
            return new xv2().b(context, str, i, str2, bundle, objArr);
        }
        wz4.a("ONCE_TASK", new a("JCoreInternalHelper#onEvent", context, str, i, str2, bundle, objArr));
        return null;
    }
}
