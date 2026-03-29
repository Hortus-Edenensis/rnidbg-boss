package defpackage;

import android.graphics.Paint;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qs2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20311a;
    public int b;
    public int c;
    public int d;
    public Paint e = new Paint();
    public int f;
    public View g;

    public qs2(View view) {
        this.g = view;
    }

    public int a() {
        return this.f20311a;
    }

    public Paint b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b;
    }

    public qs2 g() {
        this.g.invalidate();
        return this;
    }

    public qs2 h(int i) {
        this.e.setColor(i);
        return this;
    }

    public qs2 i(int i) {
        this.f20311a = i;
        return this;
    }

    public qs2 j(int i) {
        this.f = i;
        this.g.invalidate();
        return this;
    }

    public qs2 k(int i) {
        this.c = Math.min(this.d, i);
        return this;
    }

    public qs2 l(int i) {
        this.d = i;
        return this;
    }

    public qs2 m(int i) {
        this.b = i;
        return this;
    }
}
