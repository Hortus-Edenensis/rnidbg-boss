package com.zenmen.square.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseListFragment;
import com.zenmen.listui.list.BaseRecyclerAdapter;
import com.zenmen.listui.list.PageState;
import com.zenmen.listui.list.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$id;
import com.zenmen.square.ui.widget.ListStateView;
import defpackage.a46;
import defpackage.br;
import defpackage.ma3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareBaseFragment<T extends BaseRecyclerAdapter, M extends br, B extends BaseBean, P extends com.zenmen.listui.list.a> extends BaseListFragment<T, M, B, P> {
    public ListStateView l;
    public RecyclerView.OnScrollListener m;
    public View.OnClickListener n = new a();
    public RecyclerView.OnScrollListener o = new b();
    public boolean p = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PageState.State state = SquareBaseFragment.this.l.getState().f11843a;
            if (state == PageState.State.LOADING || state == PageState.State.EMPTY) {
                return;
            }
            ((com.zenmen.listui.list.a) SquareBaseFragment.this.i).v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (SquareBaseFragment.this.m != null) {
                SquareBaseFragment.this.m.onScrollStateChanged(recyclerView, i);
            }
            if (SquareBaseFragment.this.i != null) {
                ((com.zenmen.listui.list.a) SquareBaseFragment.this.i).u(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (SquareBaseFragment.this.m != null) {
                SquareBaseFragment.this.m.onScrolled(recyclerView, i, i2);
            }
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public void i(boolean z) {
        ma3.a("onSupperSelect " + z, new Object[0]);
        super.i(z);
        if (this.h) {
            x0();
        }
    }

    public void n(RecyclerView.OnScrollListener onScrollListener) {
        this.m = onScrollListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ListStateView listStateView = (ListStateView) getView().findViewById(R$id.square_feeds_list_state);
        this.l = listStateView;
        listStateView.setOnClickListener(this.n);
        this.l.setPageType(o());
        e().addOnScrollListener(this.o);
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x0();
    }

    public void x() {
        z(false);
    }

    public boolean x0() {
        DriftInfo driftInfo;
        ma3.a("checkRefresh " + isResumed(), new Object[0]);
        if (this.i == 0 || this.k == 0 || !isResumed() || !this.h) {
            return false;
        }
        if (o() == 49 || o() == 73) {
            if (((((br) this.k).e() == null || ((br) this.k).e().size() == 0) && (a46.p() || ((br) this.k).v())) || !this.p) {
                this.p = true;
                ((com.zenmen.listui.list.a) this.i).v();
                return true;
            }
        } else {
            if (o() == 113 && ((driftInfo = ConditionHelper.getInstance().getDriftInfo()) == null || !driftInfo.valid())) {
                LogUtil.d("", "mapFindX MAP_FIND_TAB startLoadData 无解锁资源，不请求数据");
                return false;
            }
            if (((br) this.k).e() == null || ((br) this.k).e().size() == 0 || ((br) this.k).v()) {
                ((com.zenmen.listui.list.a) this.i).v();
                return true;
            }
        }
        return false;
    }

    public void z(boolean z) {
        if (e() == null || y() == null) {
            return;
        }
        if (isResumed() || z) {
            e().scrollToPosition(0);
            y().autoRefresh();
        }
    }
}
