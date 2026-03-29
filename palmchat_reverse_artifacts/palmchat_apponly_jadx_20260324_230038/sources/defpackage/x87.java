package defpackage;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class x87 implements oe7, lf7 {
    @Override // defpackage.lf7
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // defpackage.oe7
    public final Object b(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // defpackage.oe7, defpackage.lf7
    public final boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
