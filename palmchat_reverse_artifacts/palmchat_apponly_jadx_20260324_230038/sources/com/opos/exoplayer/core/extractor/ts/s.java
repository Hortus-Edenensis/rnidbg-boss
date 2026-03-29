package com.opos.exoplayer.core.extractor.ts;

import android.util.SparseArray;
import com.opos.exoplayer.core.util.w;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface s {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8245a;
        public final int b;
        public final byte[] c;

        public a(String str, int i, byte[] bArr) {
            this.f8245a = str;
            this.b = i;
            this.c = bArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8246a;
        public final String b;
        public final List<a> c;
        public final byte[] d;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.f8246a = i;
            this.b = str;
            this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.d = bArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        SparseArray<s> a();

        s a(int i, b bVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8247a;
        private final int b;
        private final int c;
        private int d;
        private String e;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        private void d() {
            if (this.d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.e = this.f8247a + this.d;
        }

        public int b() {
            d();
            return this.d;
        }

        public String c() {
            d();
            return this.e;
        }

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.f8247a = str;
            this.b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
        }
    }

    void a();

    void a(com.opos.exoplayer.core.util.p pVar, boolean z);

    void a(w wVar, com.opos.exoplayer.core.extractor.g gVar, d dVar);
}
