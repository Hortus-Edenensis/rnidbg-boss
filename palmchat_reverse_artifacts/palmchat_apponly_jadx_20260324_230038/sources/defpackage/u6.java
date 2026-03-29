package defpackage;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
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
public class u6 {
    public static String l = "AdReportHelper";
    public static double m = 0.5d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f21142a;
    public LinearLayoutManager b;
    public RecyclerView.Adapter c;
    public List<v6> d = new ArrayList();
    public boolean e = true;
    public boolean f = true;
    public int g = 0;
    public double h = 0.5d;
    public int i = 0;
    public long j = 0;
    public Runnable k = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u6.this.v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            u6.this.g = i;
            LogUtil.d(u6.l, "idleChanged");
            u6.this.v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements RecyclerView.OnChildAttachStateChangeListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            LogUtil.d(u6.l, "attachedToWindow");
            u6.this.f21142a.removeCallbacks(u6.this.k);
            u6.this.f21142a.post(u6.this.k);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            LogUtil.d(u6.l, "detachedFromWindow");
            Object objFindContainingViewHolder = u6.this.f21142a.findContainingViewHolder(view);
            if (objFindContainingViewHolder instanceof v6) {
                LogUtil.d(u6.l, "helper: detached");
                u6.this.p((v6) objFindContainingViewHolder);
            }
            u6.this.f21142a.removeCallbacks(u6.this.k);
            u6.this.f21142a.post(u6.this.k);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f21146a;
        public final /* synthetic */ v6 b;
        public final /* synthetic */ int c;

        public d(Rect rect, v6 v6Var, int i) {
            this.f21146a = rect;
            this.b = v6Var;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u6.this.j != 0) {
                LogUtil.d(u6.l, "doReportPercent postDelayed");
                u6.this.g(this.f21146a, this.b, this.c);
            }
        }
    }

    public u6(RecyclerView recyclerView) {
        this.f21142a = recyclerView;
        this.b = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.c = recyclerView.getAdapter();
        j();
    }

    public static void u(String str) {
        LogUtil.d(l, "updateExpiredConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strB = jo6.b();
            LogUtil.d(l, "getLX16947Value = " + strB);
            double d2 = Double.parseDouble(jSONObject.getString(strB));
            if (d2 > 0.0d && d2 < 1.0d) {
                m = d2;
            }
            LogUtil.d(l, "getShowRation: area = " + d2 + ", showRation = " + m);
        } catch (Exception unused) {
        }
    }

    public final void g(Rect rect, v6 v6Var, int i) {
        LogUtil.d(l, "doReportPercent");
        if (v6Var.c() == null) {
            return;
        }
        v6Var.c().Q();
        if (rect.height() <= ((double) i) * this.h || ir5.b() - this.j < this.i * 1000) {
            return;
        }
        v6Var.c().R();
        this.j = 0L;
    }

    public final void h(s7 s7Var) {
        int iL;
        if (s7Var != null && (iL = s7Var.l()) > 0) {
            this.h = (iL % 10000) / 10000.0f;
            this.i = ((iL / 10000) % 10000) / 1000;
            LogUtil.d(l, "getPercentTestRation inviewPercent = " + iL + ", testRation = " + this.h + ", testDelay = " + this.i);
        }
    }

    public final boolean i(v6 v6Var) {
        return v6Var != null && this.d.contains(v6Var);
    }

    public final void j() {
        this.f21142a.addOnScrollListener(new b());
        this.f21142a.addOnChildAttachStateChangeListener(new c());
    }

    public void k() {
        LogUtil.d(l, "onDestroy");
        o();
    }

    public void l() {
        LogUtil.d(l, "onPause");
        this.e = false;
        v();
        q(false);
    }

    public void m() {
        LogUtil.d(l, "onResume");
        this.e = true;
        v();
        q(true);
    }

    public void n(boolean z) {
        LogUtil.d(l, "onUserVisible visible = " + z);
        this.f = z;
        RecyclerView recyclerView = this.f21142a;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.k);
            this.f21142a.post(this.k);
            q(z);
        }
    }

    public final void o() {
        LogUtil.d(l, "releaseHost");
        List<v6> list = this.d;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator it = new ArrayList(this.d).iterator();
        while (it.hasNext()) {
            p((v6) it.next());
        }
        this.d.clear();
    }

    public final void p(v6 v6Var) {
        if (v6Var == null || !i(v6Var)) {
            return;
        }
        LogUtil.d(l, "reportEnd");
        v6Var.a(v6Var.c(), m);
        this.d.remove(v6Var);
        LogUtil.d(l, "adReportHosts size = " + this.d.size());
    }

    public void q(boolean z) {
        int iFindFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = this.b.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition < 0 || iFindLastVisibleItemPosition < 0) {
            return;
        }
        int i = iFindFirstVisibleItemPosition + 1;
        LogUtil.d(l, " reportFeedNum first = " + i + ", last = " + iFindLastVisibleItemPosition);
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

    public final void r(Rect rect, v6 v6Var, int i) {
        h(v6Var.c());
        if (rect.height() > 0 && this.j == 0) {
            this.j = ir5.b();
        }
        new Handler().postDelayed(new d(rect, v6Var, i), this.i * 1000);
        g(rect, v6Var, i);
    }

    public final void s(v6 v6Var) {
        if (v6Var == null || i(v6Var)) {
            return;
        }
        LogUtil.d(l, "reportStart");
        v6Var.b(v6Var.c(), m);
        this.d.add(v6Var);
        LogUtil.d(l, "adReportHosts size = " + this.d.size());
    }

    public final void t() {
        v6 v6Var;
        ViewGroup containerView;
        Rect rect = new Rect();
        int iFindLastVisibleItemPosition = this.b.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition && iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < this.c.getItemCount(); iFindFirstVisibleItemPosition++) {
            Object objFindViewHolderForAdapterPosition = this.f21142a.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
            if ((objFindViewHolderForAdapterPosition instanceof v6) && (containerView = (v6Var = (v6) objFindViewHolderForAdapterPosition).getContainerView()) != null) {
                containerView.getGlobalVisibleRect(rect);
                int height = containerView.getHeight();
                LogUtil.d(l, "hostVisibleHeight:" + rect.height() + ", hostHeight:" + height + ", rect:" + rect);
                int[] iArr = new int[2];
                containerView.getLocationOnScreen(iArr);
                Rect rect2 = new Rect();
                this.f21142a.getGlobalVisibleRect(rect2);
                int iHeight = rect2.height();
                LogUtil.d(l, "getLocationOnScreen y = " + iArr[1] + ", recycleHeight = " + iHeight);
                if (rect.height() == height && iArr[1] > iHeight) {
                    return;
                }
                if (rect.height() > ((double) height) * m) {
                    s(v6Var);
                } else {
                    p(v6Var);
                }
                s7 s7VarC = v6Var.c();
                if (s7VarC != null && s7VarC.B()) {
                    r(rect, v6Var, height);
                }
            }
        }
    }

    public void v() {
        if (this.e && this.f) {
            t();
        } else {
            o();
        }
    }
}
