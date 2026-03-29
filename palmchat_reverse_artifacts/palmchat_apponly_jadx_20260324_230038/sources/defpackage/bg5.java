package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bg5 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f1712a = new LinkedList();
    public final View b;
    public int c;
    public boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b(int i, int i2);
    }

    public bg5(View view, boolean z) {
        this.b = view;
        this.d = z;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void a(a aVar) {
        this.f1712a.add(aVar);
    }

    public boolean b() {
        return this.d;
    }

    public final void c() {
        for (a aVar : this.f1712a) {
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void d(int i, int i2) {
        this.c = i2;
        for (a aVar : this.f1712a) {
            if (aVar != null) {
                aVar.b(i, i2);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        int height = this.b.getRootView().getHeight() - (rect.bottom - rect.top);
        if (!this.d && height > k36.b(100.0f)) {
            this.d = true;
            d(rect.bottom - rect.top, height);
        } else {
            if (!this.d || height >= k36.b(100.0f)) {
                return;
            }
            this.d = false;
            c();
        }
    }
}
