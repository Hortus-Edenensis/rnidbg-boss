package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.lang.reflect.Method;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19307a;
    public Class b;
    public Object c;
    public Method d;

    public a2(Context context) {
        this.f19307a = context;
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b940f7", new byte[]{112, 52, 74, 10, 88, 46, 101, 10, 106, 105, 119, 117, 78, 64, 23, 41, 108, 8, 105, 46, 90, Utf8.REPLACEMENT_BYTE, 119, 86, 86, 54, 104, 28, 96, 114, 90, 54, 87, 72}));
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            this.d = this.b.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c12909", new byte[]{117, 54, 85, 98, 46, 7, 68}), Context.class);
        } catch (Exception unused2) {
        }
    }

    public final String a() {
        Context context = this.f19307a;
        Method method = this.d;
        Object obj = this.c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
