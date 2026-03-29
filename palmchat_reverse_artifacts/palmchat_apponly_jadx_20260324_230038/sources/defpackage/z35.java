package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class z35 implements no2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f22338a;

    @Override // defpackage.no2
    public void a(int i, int i2, int i3) {
        View viewD = d();
        if (viewD instanceof AbsListView) {
            ((AbsListView) viewD).fling(i);
            return;
        }
        if (viewD instanceof ScrollView) {
            ((ScrollView) viewD).fling(i);
        } else if (viewD instanceof RecyclerView) {
            ((RecyclerView) viewD).fling(0, i);
        } else if (viewD instanceof WebView) {
            ((WebView) viewD).flingScroll(0, i);
        }
    }

    @Override // defpackage.no2
    public void b(View view) {
        this.f22338a = view;
    }

    @Override // defpackage.no2
    public boolean c() {
        View viewD = d();
        if (viewD instanceof AdapterView) {
            return e((AdapterView) viewD);
        }
        if (viewD instanceof ScrollView) {
            return g((ScrollView) viewD);
        }
        if (viewD instanceof RecyclerView) {
            return f((RecyclerView) viewD);
        }
        if (viewD instanceof ViewGroup) {
            return h((ViewGroup) viewD);
        }
        return false;
    }

    public View d() {
        return this.f22338a;
    }

    public final boolean e(AdapterView adapterView) {
        if (adapterView != null) {
            int firstVisiblePosition = adapterView.getFirstVisiblePosition();
            View childAt = adapterView.getChildAt(0);
            if (childAt == null) {
                return true;
            }
            if (firstVisiblePosition == 0 && childAt.getTop() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(RecyclerView recyclerView) {
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                View childAt = recyclerView.getChildAt(0);
                if (childAt == null) {
                    return true;
                }
                if (iFindFirstVisibleItemPosition == 0 && childAt.getTop() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean g(ScrollView scrollView) {
        return scrollView != null && scrollView.getScrollY() <= 0;
    }

    public final boolean h(ViewGroup viewGroup) {
        return viewGroup != null && viewGroup.getScrollY() <= 0;
    }
}
