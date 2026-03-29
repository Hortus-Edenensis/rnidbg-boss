package defpackage;

import defpackage.ro5;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ro5 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> implements qo5<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Object f20519a = new Object();
        public final qo5<T> b;
        public volatile transient boolean c;
        public transient T d;

        public a(qo5<T> qo5Var) {
            this.b = (qo5) dm4.o(qo5Var);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f20519a = new Object();
        }

        @Override // defpackage.qo5
        public T get() {
            if (!this.c) {
                synchronized (this.f20519a) {
                    if (!this.c) {
                        T t = this.b.get();
                        this.d = t;
                        this.c = true;
                        return t;
                    }
                }
            }
            return (T) c44.a(this.d);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.c) {
                obj = "<supplier that returned " + this.d + ">";
            } else {
                obj = this.b;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<T> implements qo5<T> {
        public static final qo5<Void> d = new qo5() { // from class: so5
            @Override // defpackage.qo5
            public final Object get() {
                return ro5.b.b();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f20520a = new Object();
        public volatile qo5<T> b;
        public T c;

        public b(qo5<T> qo5Var) {
            this.b = (qo5) dm4.o(qo5Var);
        }

        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // defpackage.qo5
        public T get() {
            qo5<T> qo5Var = this.b;
            qo5<T> qo5Var2 = (qo5<T>) d;
            if (qo5Var != qo5Var2) {
                synchronized (this.f20520a) {
                    if (this.b != qo5Var2) {
                        T t = this.b.get();
                        this.c = t;
                        this.b = qo5Var2;
                        return t;
                    }
                }
            }
            return (T) c44.a(this.c);
        }

        public String toString() {
            Object obj = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == d) {
                obj = "<supplier that returned " + this.c + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static <T> qo5<T> a(qo5<T> qo5Var) {
        return ((qo5Var instanceof b) || (qo5Var instanceof a)) ? qo5Var : qo5Var instanceof Serializable ? new a(qo5Var) : new b(qo5Var);
    }
}
