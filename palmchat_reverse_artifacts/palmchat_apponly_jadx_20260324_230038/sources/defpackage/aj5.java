package defpackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class aj5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f1237a;
    public LinearLayoutManager b;
    public RecyclerView.Adapter c;
    public int f;
    public boolean d = false;
    public boolean e = false;
    public HashSet<String> g = new HashSet<>();
    public Runnable h = new a();
    public int[] i = new int[2];

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            aj5.this.h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            LogUtil.v("logsquare", "onScrollStateChanged");
            aj5.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            LogUtil.v("logsquare", "onScrolled");
            aj5.this.h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LogUtil.v("logsquare", "onLayoutChange");
            aj5.this.h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LogUtil.v("logsquare", "parent: onLayoutChange");
            aj5.this.h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements RecyclerView.OnChildAttachStateChangeListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            LogUtil.v("logsquare", "attachedToWindow:" + view);
            aj5.this.f1237a.removeCallbacks(aj5.this.h);
            aj5.this.f1237a.post(aj5.this.h);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            LogUtil.v("logsquare", "detachedFromWindow:" + view);
            aj5.this.f1237a.removeCallbacks(aj5.this.h);
            aj5.this.f1237a.post(aj5.this.h);
        }
    }

    public aj5(RecyclerView recyclerView, int i) {
        this.f = 0;
        this.f1237a = recyclerView;
        this.b = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.c = recyclerView.getAdapter();
        this.f = i;
        this.g.clear();
        d();
    }

    public final void c() {
        int iFindFirstCompletelyVisibleItemPosition = this.b.findFirstCompletelyVisibleItemPosition();
        int iFindLastCompletelyVisibleItemPosition = this.b.findLastCompletelyVisibleItemPosition();
        for (int i = 0; i < this.c.getItemCount(); i++) {
            Object objFindViewHolderForAdapterPosition = this.f1237a.findViewHolderForAdapterPosition(i);
            if (objFindViewHolderForAdapterPosition instanceof q33) {
                q33 q33Var = (q33) objFindViewHolderForAdapterPosition;
                View view = q33Var.getView();
                if (i < iFindFirstCompletelyVisibleItemPosition || i > iFindLastCompletelyVisibleItemPosition || view == null) {
                    q33Var.c();
                } else {
                    view.getLocationOnScreen(this.i);
                    int height = view.getHeight();
                    if (height <= 0 || this.i[1] + height > me1.f() - me1.b(view.getContext(), 56)) {
                        q33Var.c();
                    } else {
                        q33Var.e(i, this.g, this.f);
                    }
                }
            }
        }
    }

    public final void d() {
        this.f1237a.addOnScrollListener(new b());
        this.f1237a.addOnLayoutChangeListener(new c());
        if (this.f1237a.getParent() instanceof View) {
            ((View) this.f1237a.getParent()).addOnLayoutChangeListener(new d());
        }
        this.f1237a.addOnChildAttachStateChangeListener(new e());
        this.c.registerAdapterDataObserver(new f());
    }

    public void e() {
        LogUtil.v("logsquare", "onPause");
        this.d = false;
        h();
    }

    public void f(boolean z) {
        LogUtil.v("logsquare", "onResume");
        this.d = true;
        this.e = z;
        h();
    }

    public void g(boolean z) {
        LogUtil.v("logsquare", "onUserVisible");
        this.e = z;
        RecyclerView recyclerView = this.f1237a;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.h);
            this.f1237a.post(this.h);
        }
    }

    public void h() {
        if (this.d && this.e) {
            c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends RecyclerView.AdapterDataObserver {
        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            LogUtil.v("logsquare", "dataChanged");
            aj5.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            LogUtil.v("logsquare", "dataChanged");
            aj5.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            LogUtil.v("logsquare", "dataChanged");
            aj5.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            LogUtil.v("logsquare", "dataChanged");
            aj5.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            LogUtil.v("logsquare", "dataChanged");
            aj5.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            LogUtil.v("logsquare", "dataChanged");
            aj5.this.h();
        }
    }
}
