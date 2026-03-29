package com.bytedance.sdk.component.widget.recycler.u.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: compiled from: SearchBox */
    public interface u<T> {
        T u();

        boolean u(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr<T> implements u<T> {
        private int nr;
        private final Object[] u;

        public nr(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.u = new Object[i];
        }

        private boolean nr(T t) {
            for (int i = 0; i < this.nr; i++) {
                if (this.u[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.u.nr.b.u
        public T u() {
            int i = this.nr;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.u;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.nr = i - 1;
            return t;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.u.nr.b.u
        public boolean u(T t) {
            if (!nr(t)) {
                int i = this.nr;
                Object[] objArr = this.u;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.nr = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }
}
