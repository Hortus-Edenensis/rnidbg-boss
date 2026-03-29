package com.zenmen.square.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.zenmen.square.R$string;
import com.zenmen.square.adapter.FeedsAdapter;
import com.zenmen.square.adapter.NestTopicFeedsAdapter;
import com.zenmen.square.ui.widget.ListStateView;
import defpackage.a46;
import defpackage.gw3;
import defpackage.hw3;
import defpackage.yt1;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTopicFeedsFragment extends FeedsFragment<yt1> {
    public long u;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.ItemDecoration {
        public final /* synthetic */ int b;

        public a(int i) {
            this.b = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int i = this.b;
            rect.bottom = i * 2;
            rect.left = i;
            rect.right = i;
            rect.top = i;
        }
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: E0 */
    public FeedsAdapter V() {
        if (this.j == 0) {
            this.j = new NestTopicFeedsAdapter(o());
        }
        return (FeedsAdapter) this.j;
    }

    @Override // com.zenmen.square.fragment.FeedsFragment
    public boolean G0() {
        return false;
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: I0 */
    public zt1 k0() {
        if (this.i == 0) {
            this.i = new hw3(this, c0());
        }
        return (zt1) this.i;
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public yt1 c0() {
        if (this.k == 0) {
            this.k = new gw3("square.topic.recommend.list.v8", this.u, o());
        }
        return (yt1) this.k;
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public RecyclerView.LayoutManager Y() {
        return new StaggeredGridLayoutManager(2, 1);
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 6;
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.square.fragment.SquareBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ListStateView listStateView = this.l;
        if (listStateView != null) {
            listStateView.setEmptyString(getString(R$string.square_nest_topic_list_state_empty));
            this.l.setTopMargin(a46.b(getContext(), 80.0f));
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        int iB = a46.b(getContext(), 4.0f);
        mo794e().setPadding(iB, 0, iB, iB);
        mo794e().addItemDecoration(new a(iB));
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.u = getArguments().getLong("topic_id", -1L);
    }
}
