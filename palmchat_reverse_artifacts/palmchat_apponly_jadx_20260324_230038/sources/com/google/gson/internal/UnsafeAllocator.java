package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class UnsafeAllocator {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends UnsafeAllocator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f6302a;
        public final /* synthetic */ Object b;

        public a(Method method, Object obj) {
            this.f6302a = method;
            this.b = obj;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.a(cls);
            return (T) this.f6302a.invoke(this.b, cls);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends UnsafeAllocator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f6303a;
        public final /* synthetic */ int b;

        public b(Method method, int i) {
            this.f6303a = method;
            this.b = i;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.a(cls);
            return (T) this.f6303a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends UnsafeAllocator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f6304a;

        public c(Method method) {
            this.f6304a = method;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.a(cls);
            return (T) this.f6304a.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends UnsafeAllocator {
        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static UnsafeAllocator create() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
