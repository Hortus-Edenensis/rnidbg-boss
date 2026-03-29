package defpackage;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.alipay.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class tw6 implements oe7, lf7 {
    @Override // defpackage.lf7
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(hc7.b(obj2));
        }
        return arrayList;
    }

    @Override // defpackage.oe7
    public final Object b(Object obj, Type type) {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        if (type instanceof GenericArrayType) {
            throw new IllegalArgumentException("Does not support generic array!");
        }
        Class<?> componentType = ((Class) type).getComponentType();
        int iA = aVar.a();
        Object objNewInstance = Array.newInstance(componentType, iA);
        for (int i = 0; i < iA; i++) {
            Array.set(objNewInstance, i, oa7.a(aVar.a(i), componentType));
        }
        return objNewInstance;
    }

    @Override // defpackage.oe7, defpackage.lf7
    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
