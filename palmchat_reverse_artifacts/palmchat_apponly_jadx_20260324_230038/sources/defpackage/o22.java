package defpackage;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.listui.list.PageState;
import com.zenmen.square.lxpager.BasePagerBean;
import com.zenmen.square.lxpager.SquareViewPager2;
import defpackage.tb4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class o22<VM extends tb4<B>, B extends BasePagerBean> implements c74, j74, km2<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SmartRefreshLayout f19664a;
    public SquareViewPager2 b;
    public VM c;
    public B d = null;
    public boolean e = false;
    public k66 f = null;
    public l66 g = null;
    public mm2 h;
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ir<BaseNetListBean<B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19665a;

        public a(int i) {
            this.f19665a = i;
        }

        @Override // defpackage.ir
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseNetListBean<B> baseNetListBean) {
            if (baseNetListBean.isSuccess()) {
                int i = this.f19665a;
                int size = ((List) baseNetListBean.data).size() - this.f19665a;
                List<BasePagerBean> listF = (List) baseNetListBean.data;
                if (o22.this.f != null) {
                    listF = o22.this.f.f(listF, i, size);
                }
                o22.this.b.loadMore(listF, i, size);
            } else if (o22.this.f19664a.getState().isOpening) {
                o22.this.b.showMessage(baseNetListBean.getErrMsg());
            }
            o22.this.f19664a.finishLoadMore();
            o22.this.t();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ir<BaseNetListBean<B>> {
        public b() {
        }

        @Override // defpackage.ir
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseNetListBean<B> baseNetListBean) {
            B b;
            B b2;
            o22.this.f19664a.finishRefresh(true);
            o22.this.i = false;
            o22 o22Var = o22.this;
            o22Var.z(o22Var.o(baseNetListBean));
            if (baseNetListBean.isSuccess() && (b2 = baseNetListBean.data) != null && ((List) b2).size() > 0) {
                o22.this.b.refresh((List) baseNetListBean.data);
            } else if (!baseNetListBean.isSuccess() || (b = baseNetListBean.data) == null || ((List) b).size() != 0 || o22.this.h == null) {
                ry5.a(baseNetListBean.getErrMsg());
            }
        }
    }

    public o22(SquareViewPager2 squareViewPager2, VM vm) {
        this.c = vm;
        this.b = squareViewPager2;
        SmartRefreshLayout refreshLayout = squareViewPager2.getRefreshLayout();
        this.f19664a = refreshLayout;
        refreshLayout.setEnableRefresh(this.c.h());
        this.f19664a.setEnableLoadMore(!this.c.n());
        this.f19664a.setOnLoadMoreListener(this);
        this.f19664a.setOnRefreshListener(this);
    }

    public final void A() {
        if (this.d != null && this.c.e().size() >= 1 && this.c.e().get(0) == this.d) {
            if (this.c.e().size() > 1) {
                m(0, (BasePagerBean) this.c.e().get(0));
            } else if (this.b.getContext() instanceof Activity) {
                ((Activity) this.b.getContext()).onBackPressed();
            }
            this.d = null;
        }
    }

    public void B(int i, B b2) {
        if (i < 0 || this.c.e().size() <= i) {
            return;
        }
        this.c.e().set(i, b2);
    }

    @Override // defpackage.j74
    public void a(@NonNull xu4 xu4Var) {
        u();
    }

    @Override // defpackage.km2
    public void d(String str) {
        ry5.a(str);
    }

    @Override // defpackage.km2
    public void g(List<B> list) {
        this.b.refresh(list);
    }

    public void l(List<B> list, int i) {
        this.c.q(this);
        this.c.p(list);
        this.b.getAdapter().o(this);
        this.b.setCurrentItem(i);
    }

    public void m(int i, B b2) {
        this.c.i(i, b2);
    }

    public void n() {
        if (this.c.n() || !this.c.m()) {
            t();
        } else {
            this.c.d(new a(this.c.e().size()));
        }
    }

    public PageState o(BaseNetListBean<B> baseNetListBean) {
        B b2;
        B b3;
        if (baseNetListBean.isSuccess() && ((b3 = baseNetListBean.data) == null || ((List) b3).size() == 0)) {
            return new PageState(PageState.State.EMPTY, null);
        }
        if (baseNetListBean.isSuccess() || !((b2 = baseNetListBean.data) == null || ((List) b2).size() == 0)) {
            return new PageState(PageState.State.NORMAL, null);
        }
        PageState pageState = new PageState(PageState.State.ERROR, baseNetListBean.getErrMsg());
        pageState.c = baseNetListBean.resultCode;
        return pageState;
    }

    @Override // defpackage.c74
    public void onLoadMore(@NonNull xu4 xu4Var) {
        if (this.c.m() && !this.c.n()) {
            n();
            return;
        }
        if (!this.c.m()) {
            ry5.a(this.c.l());
        }
        this.f19664a.finishLoadMore();
        t();
    }

    public void p(B b2) {
        this.d = b2;
        if (this.e) {
            A();
        }
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void c(int i, B b2) {
        this.b.updateItem(i);
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void b(int i, B b2) {
        this.b.removeItem(i);
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void e(int i, B b2) {
        this.b.insertedItem(i);
    }

    public final void t() {
        if (this.e) {
            return;
        }
        this.e = true;
        A();
    }

    public void u() {
        if (this.i) {
            return;
        }
        this.i = true;
        if (this.c.e() == null || this.c.e().size() == 0) {
            z(new PageState(PageState.State.LOADING, null));
        }
        this.c.f(new b());
    }

    public void v(k66 k66Var) {
        this.f = k66Var;
    }

    public void w(l66 l66Var) {
        this.g = l66Var;
    }

    public void x(int i) {
        this.b.setCurrentItem(i);
    }

    public void y(mm2 mm2Var) {
        this.h = mm2Var;
    }

    public void z(PageState pageState) {
        mm2 mm2Var = this.h;
        if (mm2Var != null) {
            mm2Var.showStatePage(pageState);
        }
    }
}
