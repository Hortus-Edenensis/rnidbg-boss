package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.oplus.tblplayer.Constants;
import defpackage.bv2;
import defpackage.dm4;
import defpackage.fm4;
import defpackage.m54;
import defpackage.o46;
import defpackage.qu4;
import defpackage.qy2;
import defpackage.t26;
import defpackage.u42;
import defpackage.w26;
import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qy2 f6261a = qy2.h(", ").j(com.igexin.push.core.b.m);

    /* JADX INFO: compiled from: SearchBox */
    public class a extends w26 {
        public final /* synthetic */ AtomicReference b;

        public a(AtomicReference atomicReference) {
            this.b = atomicReference;
        }

        @Override // defpackage.w26
        public void b(Class<?> cls) {
            this.b.set(cls.getComponentType());
        }

        @Override // defpackage.w26
        public void c(GenericArrayType genericArrayType) {
            this.b.set(genericArrayType.getGenericComponentType());
        }

        @Override // defpackage.w26
        public void e(TypeVariable<?> typeVariable) {
            this.b.set(c.p(typeVariable.getBounds()));
        }

        @Override // defpackage.w26
        public void f(WildcardType wildcardType) {
            this.b.set(c.p(wildcardType.getUpperBounds()));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b {
        public static final b OWNED_BY_ENCLOSING_CLASS = new a("OWNED_BY_ENCLOSING_CLASS", 0);
        public static final b LOCAL_CLASS_HAS_NO_OWNER = new C0389c("LOCAL_CLASS_HAS_NO_OWNER", 1);
        private static final /* synthetic */ b[] $VALUES = $values();
        static final b JVM_BEHAVIOR = detectJvmBehavior();

        /* JADX INFO: compiled from: SearchBox */
        public enum a extends b {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.c.b
            public Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0388b<T> {
        }

        /* JADX INFO: renamed from: com.google.common.reflect.c$b$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public enum C0389c extends b {
            public C0389c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.c.b
            public Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends C0388b<String> {
        }

        private static /* synthetic */ b[] $values() {
            return new b[]{OWNED_BY_ENCLOSING_CLASS, LOCAL_CLASS_HAS_NO_OWNER};
        }

        private b(String str, int i) {
        }

        private static b detectJvmBehavior() {
            new d();
            ParameterizedType parameterizedType = (ParameterizedType) d.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            ParameterizedType parameterizedType2 = parameterizedType;
            for (b bVar : values()) {
                if (bVar.getOwnerType(C0388b.class) == parameterizedType2.getOwnerType()) {
                    return bVar;
                }
            }
            throw new AssertionError();
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) $VALUES.clone();
        }

        public abstract Class<?> getOwnerType(Class<?> cls);

        public /* synthetic */ b(String str, int i, a aVar) {
            this(str, i);
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0390c implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f6262a;

        public C0390c(Type type) {
            this.f6262a = d.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return m54.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f6262a;
        }

        public int hashCode() {
            return this.f6262a.hashCode();
        }

        public String toString() {
            return c.s(this.f6262a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d {
        private static final /* synthetic */ d[] $VALUES;
        static final d CURRENT;
        public static final d JAVA6;
        public static final d JAVA7;
        public static final d JAVA8;
        public static final d JAVA9;

        /* JADX INFO: compiled from: SearchBox */
        public enum a extends d {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.c.d
            public Type usedInGenericType(Type type) {
                dm4.o(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new C0390c(cls.getComponentType()) : type;
            }

            @Override // com.google.common.reflect.c.d
            public GenericArrayType newArrayType(Type type) {
                return new C0390c(type);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum b extends d {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.c.d
            public Type newArrayType(Type type) {
                return type instanceof Class ? c.h((Class) type) : new C0390c(type);
            }

            @Override // com.google.common.reflect.c.d
            public Type usedInGenericType(Type type) {
                return (Type) dm4.o(type);
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.c$d$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public enum C0391c extends d {
            public C0391c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.c.d
            public Type newArrayType(Type type) {
                return d.JAVA7.newArrayType(type);
            }

            @Override // com.google.common.reflect.c.d
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e) {
                    e = e;
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e2) {
                    e = e2;
                    throw new RuntimeException(e);
                }
            }

            @Override // com.google.common.reflect.c.d
            public Type usedInGenericType(Type type) {
                return d.JAVA7.usedInGenericType(type);
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.c$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public enum C0392d extends d {
            public C0392d(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.c.d
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.common.reflect.c.d
            public Type newArrayType(Type type) {
                return d.JAVA8.newArrayType(type);
            }

            @Override // com.google.common.reflect.c.d
            public String typeName(Type type) {
                return d.JAVA8.typeName(type);
            }

            @Override // com.google.common.reflect.c.d
            public Type usedInGenericType(Type type) {
                return d.JAVA8.usedInGenericType(type);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e extends t26<Map.Entry<String, int[][]>> {
        }

        /* JADX INFO: compiled from: SearchBox */
        public class f extends t26<int[]> {
        }

        private static /* synthetic */ d[] $values() {
            return new d[]{JAVA6, JAVA7, JAVA8, JAVA9};
        }

        static {
            a aVar = new a("JAVA6", 0);
            JAVA6 = aVar;
            b bVar = new b("JAVA7", 1);
            JAVA7 = bVar;
            C0391c c0391c = new C0391c("JAVA8", 2);
            JAVA8 = c0391c;
            C0392d c0392d = new C0392d("JAVA9", 3);
            JAVA9 = c0392d;
            $VALUES = $values();
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new e().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = c0391c;
                    return;
                } else {
                    CURRENT = c0392d;
                    return;
                }
            }
            if (new f().capture() instanceof Class) {
                CURRENT = bVar;
            } else {
                CURRENT = aVar;
            }
        }

        private d(String str, int i) {
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) $VALUES.clone();
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract Type newArrayType(Type type);

        public String typeName(Type type) {
            return c.s(type);
        }

        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (Type type : typeArr) {
                aVarBuilder.a(usedInGenericType(type));
            }
            return aVarBuilder.e();
        }

        public abstract Type usedInGenericType(Type type);

        public /* synthetic */ d(String str, int i, a aVar) {
            this(str, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f6263a = !e.class.getTypeParameters()[0].equals(c.k(e.class, "X", new Type[0]));
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f6264a;
        public final ImmutableList<Type> b;
        public final Class<?> c;

        public f(Type type, Class<?> cls, Type[] typeArr) {
            dm4.o(cls);
            dm4.d(typeArr.length == cls.getTypeParameters().length);
            c.f(typeArr, "type parameter");
            this.f6264a = type;
            this.c = cls;
            this.b = d.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && m54.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return c.r(this.b);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f6264a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.c;
        }

        public int hashCode() {
            Type type = this.f6264a;
            return ((type == null ? 0 : type.hashCode()) ^ this.b.hashCode()) ^ this.c.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f6264a != null) {
                d dVar = d.CURRENT;
                if (dVar.jdkTypeDuplicatesOwnerName()) {
                    sb.append(dVar.typeName(this.f6264a));
                    sb.append('.');
                }
            }
            sb.append(this.c.getName());
            sb.append(Typography.less);
            qy2 qy2Var = c.f6261a;
            ImmutableList<Type> immutableList = this.b;
            final d dVar2 = d.CURRENT;
            Objects.requireNonNull(dVar2);
            sb.append(qy2Var.d(bv2.t(immutableList, new u42() { // from class: b36
                @Override // defpackage.u42
                public final Object apply(Object obj) {
                    return dVar2.typeName((Type) obj);
                }
            })));
            sb.append(Typography.greater);
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D f6265a;
        public final String b;
        public final ImmutableList<Type> c;

        public g(D d, String str, Type[] typeArr) {
            c.f(typeArr, "bound for type variable");
            this.f6265a = (D) dm4.o(d);
            this.b = (String) dm4.o(str);
            this.c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.f6265a;
        }

        public String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (!e.f6263a) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.b.equals(typeVariable.getName()) && this.f6265a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof h)) {
                return false;
            }
            g gVar = ((h) Proxy.getInvocationHandler(obj)).f6266a;
            return this.b.equals(gVar.b()) && this.f6265a.equals(gVar.a()) && this.c.equals(gVar.c);
        }

        public int hashCode() {
            return this.f6265a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h implements InvocationHandler {
        public static final ImmutableMap<String, Method> b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<?> f6266a;

        static {
            ImmutableMap.b bVarBuilder = ImmutableMap.builder();
            for (Method method : g.class.getMethods()) {
                if (method.getDeclaringClass().equals(g.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    bVarBuilder.h(method.getName(), method);
                }
            }
            b = bVarBuilder.c();
        }

        public h(g<?> gVar) {
            this.f6266a = gVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = b.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f6266a, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<Type> f6267a;
        public final ImmutableList<Type> b;

        public i(Type[] typeArr, Type[] typeArr2) {
            c.f(typeArr, "lower bound for wildcard");
            c.f(typeArr2, "upper bound for wildcard");
            d dVar = d.CURRENT;
            this.f6267a = dVar.usedInGenericType(typeArr);
            this.b = dVar.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.f6267a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.b.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return c.r(this.f6267a);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return c.r(this.b);
        }

        public int hashCode() {
            return this.f6267a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(Constants.STRING_VALUE_UNSET);
            o46<Type> it = this.f6267a.iterator();
            while (it.hasNext()) {
                Type next = it.next();
                sb.append(" super ");
                sb.append(d.CURRENT.typeName(next));
            }
            for (Type type : c.g(this.b)) {
                sb.append(" extends ");
                sb.append(d.CURRENT.typeName(type));
            }
            return sb.toString();
        }
    }

    public static void f(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                dm4.k(!r2.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    public static Iterable<Type> g(Iterable<Type> iterable) {
        return bv2.e(iterable, fm4.i(fm4.f(Object.class)));
    }

    public static Class<?> h(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    public static Type i(Type type) {
        dm4.o(type);
        AtomicReference atomicReference = new AtomicReference();
        new a(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    public static Type j(Type type) {
        if (!(type instanceof WildcardType)) {
            return d.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        dm4.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return q(j(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        dm4.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return o(j(upperBounds[0]));
    }

    public static <D extends GenericDeclaration> TypeVariable<D> k(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return n(d2, str, typeArr);
    }

    public static ParameterizedType l(Class<?> cls, Type... typeArr) {
        return new f(b.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    public static ParameterizedType m(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return l(cls, typeArr);
        }
        dm4.o(typeArr);
        dm4.j(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new f(type, cls, typeArr);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> n(D d2, String str, Type[] typeArr) {
        return (TypeVariable) qu4.a(TypeVariable.class, new h(new g(d2, str, typeArr)));
    }

    public static WildcardType o(Type type) {
        return new i(new Type[0], new Type[]{type});
    }

    public static Type p(Type[] typeArr) {
        for (Type type : typeArr) {
            Type typeI = i(type);
            if (typeI != null) {
                if (typeI instanceof Class) {
                    Class cls = (Class) typeI;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return o(typeI);
            }
        }
        return null;
    }

    public static WildcardType q(Type type) {
        return new i(new Type[]{type}, new Type[]{Object.class});
    }

    public static Type[] r(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
