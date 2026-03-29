package com.opos.mobad.template.a;

import android.animation.TypeEvaluator;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d<T> implements TypeEvaluator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9279a = 0;
    private int c = 0;
    private List<a<T>> b = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f9280a;
        private TypeEvaluator<T> b;
        private long c;

        public a(TypeEvaluator<T> typeEvaluator, long j, long j2) {
            this.f9280a = j;
            this.b = typeEvaluator;
            this.c = j2;
        }
    }

    public long a() {
        return this.f9279a;
    }

    @Override // android.animation.TypeEvaluator
    public T evaluate(float f, T t, T t2) {
        List<a<T>> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        a aVarA = a(f);
        if (aVarA != null) {
            return (T) aVarA.b.evaluate((float) (((((double) f) * this.f9279a) - aVarA.c) / aVarA.f9280a), t, t2);
        }
        Log.d("", "null node:" + f);
        return t2;
    }

    private a a(float f) {
        float f2 = this.f9279a * f;
        for (int i = this.c; i < this.b.size(); i++) {
            a<T> aVar = this.b.get(i);
            if (f2 >= ((a) aVar).c && f2 <= ((a) aVar).f9280a + ((a) aVar).c) {
                this.c = i;
                return aVar;
            }
        }
        if (this.c <= 0) {
            return null;
        }
        this.c = 0;
        return a(f);
    }

    public d a(TypeEvaluator<T> typeEvaluator, long j) {
        if (j > 0 && typeEvaluator != null) {
            this.b.add(new a<>(typeEvaluator, j, this.f9279a));
            this.f9279a += j;
        }
        return this;
    }
}
