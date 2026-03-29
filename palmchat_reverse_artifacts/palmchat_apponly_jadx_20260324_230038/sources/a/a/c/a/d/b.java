package a.a.c.a.d;

import a.a.c.a.b.c;
import a.a.c.a.d.o;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<SERVICE> implements a.a.c.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1110a;
    public final a.a.c.a.e.c<Boolean> b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends a.a.c.a.e.c<Boolean> {
        public a() {
        }

        @Override // a.a.c.a.e.c
        public Boolean a(Object[] objArr) {
            boolean z = false;
            Context context = (Context) objArr[0];
            try {
                if (context.getPackageManager().getPackageInfo(b.this.f1110a, 128) != null) {
                    z = true;
                }
            } catch (Throwable unused) {
            }
            return Boolean.valueOf(z);
        }
    }

    public b(String str) {
        this.f1110a = str;
    }

    @Override // a.a.c.a.b.c
    public c.a a(Context context) {
        String str = (String) new o(context, c(context), a()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c.a aVar = new c.a();
        aVar.f1105a = str;
        return aVar;
    }

    public abstract o.b<SERVICE, String> a();

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return this.b.b(context).booleanValue();
    }

    public abstract Intent c(Context context);
}
