package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ru3 {
    public static String j = "NestAdReportHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f20575a;
    public LinearLayoutManager b;
    public RecyclerView.Adapter c;
    public List<su3> d = new ArrayList();
    public boolean e = true;
    public boolean f = true;
    public int g = 0;
    public double h = 0.1d;
    public Runnable i = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ru3.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            ru3.this.g = i;
            LogUtil.d(ru3.j, "idleChanged");
            ru3.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements RecyclerView.OnChildAttachStateChangeListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            LogUtil.d(ru3.j, "attachedToWindow");
            ru3.this.f20575a.removeCallbacks(ru3.this.i);
            ru3.this.f20575a.post(ru3.this.i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            LogUtil.d(ru3.j, "detachedFromWindow");
            Object objFindContainingViewHolder = ru3.this.f20575a.findContainingViewHolder(view);
            if (objFindContainingViewHolder instanceof su3) {
                LogUtil.d(ru3.j, "helper: detached");
                ru3.this.n((su3) objFindContainingViewHolder);
            }
            ru3.this.f20575a.removeCallbacks(ru3.this.i);
            ru3.this.f20575a.post(ru3.this.i);
        }
    }

    public ru3(RecyclerView recyclerView) {
        this.f20575a = recyclerView;
        this.b = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.c = recyclerView.getAdapter();
        h();
    }

    public final double f() {
        LogUtil.d(j, "getShowRation: showRation = " + this.h);
        return this.h;
    }

    public final boolean g(su3 su3Var) {
        return su3Var != null && this.d.contains(su3Var);
    }

    public final void h() {
        this.f20575a.addOnScrollListener(new b());
        this.f20575a.addOnChildAttachStateChangeListener(new c());
    }

    public void i() {
        LogUtil.d(j, "onDestroy");
        m();
    }

    public void j() {
        LogUtil.d(j, "onPause");
        this.e = false;
        r();
        o(false);
    }

    public void k() {
        LogUtil.d(j, "onResume");
        this.e = true;
        r();
        o(true);
    }

    public void l(boolean z) {
        LogUtil.d(j, "onUserVisible visible = " + z);
        this.f = z;
        RecyclerView recyclerView = this.f20575a;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.i);
            this.f20575a.post(this.i);
            o(z);
        }
    }

    public final void m() {
        LogUtil.d(j, "releaseHost");
        List<su3> list = this.d;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator it = new ArrayList(this.d).iterator();
        while (it.hasNext()) {
            n((su3) it.next());
        }
        this.d.clear();
    }

    public final void n(su3 su3Var) {
        if (su3Var == null || !g(su3Var)) {
            return;
        }
        LogUtil.d(j, "reportEnd");
        su3Var.d(su3Var.f(), f());
        this.d.remove(su3Var);
        LogUtil.d(j, "adReportHosts size = " + this.d.size());
    }

    public void o(boolean z) {
        int iFindFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = this.b.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition < 0 || iFindLastVisibleItemPosition < 0) {
            return;
        }
        int i = iFindFirstVisibleItemPosition + 1;
        LogUtil.d(j, " reportFeedNum first = " + i + ", last = " + iFindLastVisibleItemPosition);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start", i);
            jSONObject.put("end", iFindLastVisibleItemPosition);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (z) {
            LogUtil.uploadInfoImmediate("qse1", null, null, jSONObject.toString());
        } else {
            LogUtil.uploadInfoImmediate("qse2", null, null, jSONObject.toString());
        }
    }

    public final void p(su3 su3Var) {
        if (su3Var == null || g(su3Var)) {
            return;
        }
        LogUtil.d(j, "reportStart");
        su3Var.j(su3Var.f(), f(), su3Var.h());
        this.d.add(su3Var);
        LogUtil.d(j, "adReportHosts size = " + this.d.size());
    }

    public final void q() {
        su3 su3Var;
        ViewGroup containerView;
        Rect rect = new Rect();
        int iFindLastVisibleItemPosition = this.b.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition && iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < this.c.getItemCount(); iFindFirstVisibleItemPosition++) {
            Object objFindViewHolderForAdapterPosition = this.f20575a.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
            if ((objFindViewHolderForAdapterPosition instanceof su3) && (containerView = (su3Var = (su3) objFindViewHolderForAdapterPosition).getContainerView()) != null) {
                containerView.getGlobalVisibleRect(rect);
                int height = containerView.getHeight();
                LogUtil.d(j, "hostVisibleHeight:" + rect.height() + ", hostHeight:" + height + ", rect:" + rect);
                int[] iArr = new int[2];
                containerView.getLocationOnScreen(iArr);
                Rect rect2 = new Rect();
                this.f20575a.getGlobalVisibleRect(rect2);
                int iHeight = rect2.height();
                LogUtil.d(j, "getLocationOnScreen y = " + iArr[1] + ", recycleHeight = " + iHeight);
                if (rect.height() == height && iArr[1] > iHeight) {
                    return;
                }
                if (rect.height() > ((double) height) * f()) {
                    p(su3Var);
                } else {
                    n(su3Var);
                }
                su3Var.f();
            }
        }
    }

    public void r() {
        if (this.e && this.f) {
            q();
        } else {
            m();
        }
    }
}
