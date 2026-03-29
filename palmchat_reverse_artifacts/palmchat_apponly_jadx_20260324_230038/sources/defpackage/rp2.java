package defpackage;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface rp2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20531a;
        public boolean b;
        public int c = -1;
        public Object d;
        public int e;
        public boolean f;

        public int a() {
            return this.e;
        }

        public Object b() {
            return this.d;
        }

        public int c() {
            return this.c;
        }

        public String d() {
            return this.f20531a;
        }

        public boolean e() {
            return this.b;
        }

        public boolean f() {
            return this.f;
        }

        public a g(int i) {
            this.e = i;
            return this;
        }

        public a h(Object obj) {
            this.d = obj;
            return this;
        }

        public a i(int i) {
            this.c = i;
            return this;
        }

        public a j(boolean z) {
            this.f = z;
            return this;
        }

        public a k(boolean z) {
            this.b = z;
            return this;
        }

        public a l(String str) {
            this.f20531a = str;
            return this;
        }
    }

    Intent a(Context context, a aVar);
}
