package com.zenmen.square.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.list.BaseRecyclerView;
import com.zenmen.listui.list.PageState;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.adapter.FeedsAdapter;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.ListStateView;
import defpackage.ij5;
import defpackage.nq3;
import defpackage.qj5;
import defpackage.sd5;
import defpackage.sy5;
import defpackage.ti0;
import defpackage.ym;
import defpackage.yt1;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class FeedsFragment<M extends yt1> extends SquareBaseFragment<FeedsAdapter, M, SquareFeed, zt1> {
    public ym q;
    public ij5 r;
    public boolean s = false;
    public boolean t = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements nq3.b {
        public a() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                sy5.e(FeedsFragment.this.getContext(), R$string.square_comment_send_success, 1).g();
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.e(FeedsFragment.this.getContext(), R$string.square_http_error, 1).g();
                } else {
                    sy5.f(FeedsFragment.this.getContext(), unitedException.getErrorMsg(), 1).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements sd5.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f16291a;
        public final /* synthetic */ int b;

        public b(SquareFeed squareFeed, int i) {
            this.f16291a = squareFeed;
            this.b = i;
        }

        @Override // sd5.e
        public void a(sd5 sd5Var, int i, CharSequence charSequence) {
            qj5.M(this.f16291a, FeedsFragment.this.o(), 3);
            if (i == 0) {
                ((zt1) FeedsFragment.this.i).C(this.b, this.f16291a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements sd5.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f16292a;
        public final /* synthetic */ int b;

        public c(SquareFeed squareFeed, int i) {
            this.f16292a = squareFeed;
            this.b = i;
        }

        @Override // sd5.e
        public void a(sd5 sd5Var, int i, CharSequence charSequence) {
            qj5.M(this.f16292a, FeedsFragment.this.o(), i + 1);
            if (i == 0) {
                ((zt1) FeedsFragment.this.i).B(this.b, this.f16292a, 1);
            } else if (i == 1) {
                ((zt1) FeedsFragment.this.i).B(this.b, this.f16292a, 2);
            } else if (i == 2) {
                ((zt1) FeedsFragment.this.i).C(this.b, this.f16292a);
            }
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public FeedsAdapter V() {
        if (this.j == 0) {
            FeedsAdapter feedsAdapter = new FeedsAdapter(o());
            this.j = feedsAdapter;
            feedsAdapter.f(getActivity());
        }
        return (FeedsAdapter) this.j;
    }

    public boolean G0() {
        return true;
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void I() {
        super.I();
        if (o() != 74 && o() != 1) {
            ((zt1) this.i).v();
        } else {
            ((zt1) this.i).I();
            y().autoRefresh();
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public zt1 k0() {
        if (this.i == 0) {
            this.i = new zt1(this, c0());
        }
        return (zt1) this.i;
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        this.t = z && this.h;
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.n(z);
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            ij5Var.h(z);
        }
    }

    public void K0(int i, SquareFeed squareFeed) {
        if (squareFeed.discussionNum == 0) {
            N0(squareFeed);
        } else {
            ti0.c().d(getContext(), squareFeed, ((zt1) this.i).o(), 0);
        }
    }

    public final void L0(int i, SquareFeed squareFeed) {
        Context context = getContext();
        if (o() == 74 && squareFeed.ifFriend) {
            String[] strArr = {context.getString(R$string.square_more_complaint)};
            new sd5.c(context).c(strArr).b(new int[]{R$drawable.icon_square_complaint}).d(new b(squareFeed, i)).a().a();
        } else {
            String[] strArr2 = {context.getString(R$string.square_more_dislike_content), context.getString(R$string.square_more_dislike_auth), context.getString(R$string.square_more_complaint)};
            new sd5.c(context).c(strArr2).b(new int[]{R$drawable.icon_square_dislike_content, R$drawable.icon_square_dislike_auth, R$drawable.icon_square_complaint}).d(new c(squareFeed, i)).a().a();
        }
    }

    public void M0(int i, SquareFeed squareFeed) {
        L0(i, squareFeed);
    }

    public final void N0(SquareFeed squareFeed) {
        ti0.c().f(getActivity(), squareFeed, null, ((zt1) this.i).o(), 0, new a());
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public Context W() {
        return getActivity();
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public int Z() {
        return R$layout.layout_square_feeds_fragment;
    }

    @Override // defpackage.nm2
    public BaseRecyclerView e() {
        if (getView() != null) {
            return (BaseRecyclerView) getView().findViewById(R$id.recycler_view_feeds);
        }
        return null;
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (G0()) {
            ym ymVar = new ym(e(), true);
            this.q = ymVar;
            ymVar.n(this.t);
        }
        if (o() == 1 || o() == 73) {
            this.r = new ij5(e());
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.k();
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            ij5Var.e();
        }
        ExpandableTextView.TEXT.clear();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.l();
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            ij5Var.f();
        }
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.m();
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            ij5Var.g();
        }
        if (o() == 1 || o() == 2 || o() == 74 || o() == 73) {
            qj5.D(o(), getSid());
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void p0(PageState pageState) {
        ListStateView listStateView = this.l;
        if (listStateView != null) {
            listStateView.setVisibility(0);
            this.l.setState(pageState);
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public void u(String str) {
        super.u(str);
        c0().S(str);
    }

    @Override // defpackage.nm2
    public SmartRefreshLayout y() {
        if (getView() != null) {
            return (SmartRefreshLayout) getView().findViewById(R$id.refresh_layout);
        }
        return null;
    }
}
