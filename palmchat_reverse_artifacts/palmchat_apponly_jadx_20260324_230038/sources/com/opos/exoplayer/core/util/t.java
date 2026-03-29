package com.opos.exoplayer.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<c> f8403a = new a();
    private static final Comparator<c> b = new b();
    private final int c;
    private int g;
    private int h;
    private int i;
    private final c[] e = new c[5];
    private final ArrayList<c> d = new ArrayList<>();
    private int f = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return cVar.f8404a - cVar2.f8404a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Comparator<c> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            float f = cVar.c;
            float f2 = cVar2.c;
            if (f < f2) {
                return -1;
            }
            return f2 < f ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8404a;
        public int b;
        public float c;

        private c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public t(int i) {
        this.c = i;
    }

    private void b() {
        if (this.f != 0) {
            Collections.sort(this.d, b);
            this.f = 0;
        }
    }

    public float a(float f) {
        b();
        float f2 = f * this.h;
        int i = 0;
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            c cVar = this.d.get(i2);
            i += cVar.b;
            if (i >= f2) {
                return cVar.c;
            }
        }
        if (this.d.isEmpty()) {
            return Float.NaN;
        }
        return this.d.get(r5.size() - 1).c;
    }

    private void a() {
        if (this.f != 1) {
            Collections.sort(this.d, f8403a);
            this.f = 1;
        }
    }

    public void a(int i, float f) {
        c cVar;
        int i2;
        c cVar2;
        int i3;
        a();
        int i4 = this.i;
        if (i4 > 0) {
            c[] cVarArr = this.e;
            int i5 = i4 - 1;
            this.i = i5;
            cVar = cVarArr[i5];
        } else {
            cVar = new c(null);
        }
        int i6 = this.g;
        this.g = i6 + 1;
        cVar.f8404a = i6;
        cVar.b = i;
        cVar.c = f;
        this.d.add(cVar);
        int i7 = this.h + i;
        while (true) {
            this.h = i7;
            while (true) {
                int i8 = this.h;
                int i9 = this.c;
                if (i8 <= i9) {
                    return;
                }
                i2 = i8 - i9;
                cVar2 = this.d.get(0);
                i3 = cVar2.b;
                if (i3 <= i2) {
                    this.h -= i3;
                    this.d.remove(0);
                    int i10 = this.i;
                    if (i10 < 5) {
                        c[] cVarArr2 = this.e;
                        this.i = i10 + 1;
                        cVarArr2[i10] = cVar2;
                    }
                }
            }
            cVar2.b = i3 - i2;
            i7 = this.h - i2;
        }
    }
}
