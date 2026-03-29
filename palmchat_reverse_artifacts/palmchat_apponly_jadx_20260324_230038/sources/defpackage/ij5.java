package defpackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.holder.FeedViewHolder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ij5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f18179a;
    public LinearLayoutManager b;
    public RecyclerView.Adapter c;
    public boolean d = true;
    public boolean e = true;
    public Runnable f = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ij5.this.i();
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
            ij5.this.i();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            LogUtil.v("logsquare", "onScrolled");
            ij5.this.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LogUtil.v("logsquare", "onLayoutChange");
            ij5.this.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements RecyclerView.OnChildAttachStateChangeListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            LogUtil.v("logsquare", "attachedToWindow:" + view);
            ij5.this.f18179a.removeCallbacks(ij5.this.f);
            ij5.this.f18179a.post(ij5.this.f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            LogUtil.v("logsquare", "detachedFromWindow:" + view);
            ij5.this.f18179a.removeCallbacks(ij5.this.f);
            ij5.this.f18179a.post(ij5.this.f);
        }
    }

    public ij5(RecyclerView recyclerView) {
        this.f18179a = recyclerView;
        this.b = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.c = recyclerView.getAdapter();
        d();
    }

    public final void c() {
        int iFindLastVisibleItemPosition = this.b.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition && iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < this.c.getItemCount(); iFindFirstVisibleItemPosition++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.f18179a.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
            if (viewHolderFindViewHolderForAdapterPosition instanceof FeedViewHolder) {
                FeedViewHolder feedViewHolder = (FeedViewHolder) viewHolderFindViewHolderForAdapterPosition;
                if (uj5.b()) {
                    feedViewHolder.t();
                } else {
                    feedViewHolder.s();
                }
            }
        }
    }

    public final void d() {
        this.f18179a.addOnScrollListener(new b());
        this.f18179a.addOnLayoutChangeListener(new c());
        this.f18179a.addOnChildAttachStateChangeListener(new d());
        this.c.registerAdapterDataObserver(new e());
    }

    public void e() {
        LogUtil.v("logsquare", "onDestroy");
    }

    public void f() {
        LogUtil.v("logsquare", "onPause");
        this.d = false;
        i();
    }

    public void g() {
        LogUtil.v("logsquare", "onResume");
        this.d = true;
        i();
    }

    public void h(boolean z) {
        LogUtil.v("logsquare", "onUserVisible");
        this.e = z;
        RecyclerView recyclerView = this.f18179a;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.f);
            this.f18179a.post(this.f);
        }
    }

    public void i() {
        if (this.d && this.e) {
            c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends RecyclerView.AdapterDataObserver {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            LogUtil.v("logsquare", "dataChanged");
            ij5.this.i();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            LogUtil.v("logsquare", "dataChanged");
            ij5.this.i();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            LogUtil.v("logsquare", "dataChanged");
            ij5.this.i();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            LogUtil.v("logsquare", "dataChanged");
            ij5.this.i();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            LogUtil.v("logsquare", "dataChanged");
            ij5.this.i();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            LogUtil.v("logsquare", "dataChanged");
            ij5.this.i();
        }
    }
}
