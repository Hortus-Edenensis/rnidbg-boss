package com.igexin.push.core.i.a;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b<T extends Drawable> implements l, m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f7274a;

    public b(T t) {
        this.f7274a = (T) k.a(t);
    }

    @Override // com.igexin.push.core.i.a.m
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T c() {
        Drawable.ConstantState constantState = this.f7274a.getConstantState();
        return constantState == null ? this.f7274a : (T) constantState.newDrawable();
    }

    @Override // com.igexin.push.core.i.a.l
    public void b() {
        T t = this.f7274a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof e) {
            ((e) t).a().prepareToDraw();
        }
    }
}
