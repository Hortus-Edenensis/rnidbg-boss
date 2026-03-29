package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class fu4 implements vn2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f17601a;
    public final a b;
    public boolean c = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a {
        public b() {
        }

        @Override // fu4.a
        public boolean a() {
            return !fu4.this.f17601a.canScrollHorizontally(1);
        }

        @Override // fu4.a
        public boolean b() {
            return !fu4.this.f17601a.canScrollHorizontally(-1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a {
        public c() {
        }

        @Override // fu4.a
        public boolean a() {
            return !fu4.this.f17601a.canScrollVertically(1);
        }

        @Override // fu4.a
        public boolean b() {
            return !fu4.this.f17601a.canScrollVertically(-1);
        }
    }

    public fu4(RecyclerView recyclerView) {
        this.f17601a = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        boolean z = layoutManager instanceof LinearLayoutManager;
        if (!z && !(layoutManager instanceof StaggeredGridLayoutManager)) {
            throw new IllegalArgumentException("Recycler views with custom layout managers are not supported by this adapter out of the box.Try implementing and providing an explicit 'impl' parameter to the other c'tors, or otherwise create a custom adapter subclass of your own.");
        }
        if ((z ? ((LinearLayoutManager) layoutManager).getOrientation() : ((StaggeredGridLayoutManager) layoutManager).getOrientation()) == 0) {
            this.b = new b();
        } else {
            this.b = new c();
        }
    }

    @Override // defpackage.vn2
    public boolean a() {
        return !this.c && this.b.a();
    }

    @Override // defpackage.vn2
    public boolean b() {
        return !this.c && this.b.b();
    }

    @Override // defpackage.vn2
    public View getView() {
        return this.f17601a;
    }
}
