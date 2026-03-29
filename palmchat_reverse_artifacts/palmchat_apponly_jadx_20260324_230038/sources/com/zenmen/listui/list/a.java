package com.zenmen.listui.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseListFragment;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.c;
import defpackage.ar;
import defpackage.b05;
import defpackage.ir;
import defpackage.lm2;
import defpackage.xu4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class a<V extends BaseListFragment, M extends ar, T extends BaseBean> implements lm2<BaseRecyclerAdapter, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public V f11844a;
    public M b;
    public SmartRefreshLayout c;
    public BaseRecyclerView d;
    public boolean e = true;
    public boolean f;

    /* JADX INFO: renamed from: com.zenmen.listui.list.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0929a implements ir<BaseNetListBean<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11845a;

        public C0929a(int i) {
            this.f11845a = i;
        }

        @Override // defpackage.ir
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseNetListBean<T> baseNetListBean) {
            a.this.k();
            if (baseNetListBean.isSuccess()) {
                a.this.f11844a.h0((List) baseNetListBean.data, this.f11845a, ((List) baseNetListBean.data).size() - this.f11845a);
            } else if (a.this.c.getState().isOpening) {
                a.this.f11844a.n0(baseNetListBean.getErrMsg());
            }
            a.this.c.finishLoadMore();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ir<BaseNetListBean<T>> {
        public b() {
        }

        @Override // defpackage.ir
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseNetListBean<T> baseNetListBean) {
            a.this.f = false;
            a.this.c.finishRefresh(true);
            a.this.k();
            a aVar = a.this;
            aVar.w(aVar.r(baseNetListBean));
            if (baseNetListBean.isSuccess()) {
                a.this.f11844a.l0((List) baseNetListBean.data);
            } else {
                a.this.f11844a.n0(baseNetListBean.getErrMsg());
            }
        }
    }

    public a(V v, M m) {
        this.f11844a = v;
        this.b = m;
    }

    @Override // defpackage.j74
    public void a(@NonNull xu4 xu4Var) {
        v();
    }

    @Override // defpackage.lm2
    public void f(BaseRecyclerAdapter baseRecyclerAdapter) {
        this.d = this.f11844a.mo794e();
        if (n() != null) {
            this.d.setLayoutManager(n());
        }
        this.d.setItemAnimator(null);
        this.d.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.e(this);
        SmartRefreshLayout smartRefreshLayoutY = this.f11844a.y();
        this.c = smartRefreshLayoutY;
        smartRefreshLayoutY.setEnableLoadMore(true);
        this.c.setOnRefreshListener(this);
        this.c.setOnLoadMoreListener(this);
        this.c.setRefreshFooter(new SquareLoadFooter(c.b()));
    }

    public void j() {
        this.c.autoLoadMore();
    }

    public void k() {
        this.c.setEnableLoadMore(this.b.i());
    }

    public void l(int i, T t) {
        this.b.g(i, t);
    }

    public int m() {
        M m = this.b;
        if (m != null) {
            return m.h();
        }
        return 0;
    }

    public RecyclerView.LayoutManager n() {
        return new LinearLayoutManager(p().W());
    }

    public int o() {
        return this.f11844a.o();
    }

    @Override // defpackage.lm2
    public void onDestroy() {
        M m = this.b;
        if (m != null) {
            m.destroy();
        }
    }

    @Override // defpackage.c74
    public void onLoadMore(@NonNull xu4 xu4Var) {
        q();
    }

    public V p() {
        return this.f11844a;
    }

    public void q() {
        if (this.e) {
            b05.d("BaseListPresenter==>loadMore()");
            this.b.d(new C0929a(this.b.e().size()));
        }
    }

    public PageState r(BaseNetListBean<T> baseNetListBean) {
        T t;
        T t2;
        if (baseNetListBean.isSuccess() && ((t2 = baseNetListBean.data) == null || ((List) t2).size() == 0)) {
            return new PageState(PageState.State.EMPTY, null);
        }
        if (baseNetListBean.isSuccess() || !((t = baseNetListBean.data) == null || ((List) t).size() == 0)) {
            return new PageState(PageState.State.NORMAL, null);
        }
        PageState pageState = new PageState(PageState.State.ERROR, baseNetListBean.getErrMsg());
        pageState.c = baseNetListBean.resultCode;
        return pageState;
    }

    public void s(int i, T t) {
        this.b.c(i, t);
    }

    public void t(int i, T t) {
        this.f11844a.r0(i);
    }

    public void v() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.b.e() == null || this.b.e().size() == 0) {
            w(new PageState(PageState.State.LOADING, null));
        }
        BaseRecyclerView baseRecyclerView = this.d;
        if (baseRecyclerView != null) {
            try {
                baseRecyclerView.scrollToPosition(0);
            } catch (Exception unused) {
            }
        }
        this.b.f(new b());
    }

    public void w(PageState pageState) {
        this.f11844a.p0(pageState);
    }

    @Override // defpackage.lm2
    public void onResume() {
    }

    public void i(T t) {
    }

    public void u(int i) {
    }
}
