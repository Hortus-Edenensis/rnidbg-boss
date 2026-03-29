package defpackage;

import java.lang.reflect.Type;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class s47 implements oe7, lf7 {
    @Override // defpackage.lf7
    public final Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // defpackage.oe7
    public final Object b(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // defpackage.oe7, defpackage.lf7
    public final boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
