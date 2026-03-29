package defpackage;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public abstract class l implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, l> f18867a = new HashMap();
    public static final Object b = new Object();

    public static l c(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return d(context, context.getPackageName());
    }

    public static l d(Context context, String str) {
        l z37Var;
        synchronized (b) {
            Map<String, l> map = f18867a;
            z37Var = map.get(str);
            if (z37Var == null) {
                z37Var = new z37(context, str);
                map.put(str, z37Var);
            }
        }
        return z37Var;
    }
}
