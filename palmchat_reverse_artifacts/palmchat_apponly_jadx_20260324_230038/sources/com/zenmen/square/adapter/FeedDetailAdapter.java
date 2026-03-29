package com.zenmen.square.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.square.ad.feeddetail.AdFragment;
import com.zenmen.square.fragment.FeedDetailFragment;
import com.zenmen.square.lxpager.LxFragmentStateAdapter;
import com.zenmen.square.lxpager.PagerFragment;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.p66;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedDetailAdapter extends LxFragmentStateAdapter<PagerFragment, SquareFeed> {
    public FeedDetailAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override // com.zenmen.square.lxpager.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        List<D> list = this.m;
        if (list == 0 || i < 0 || list.size() <= i) {
            return super.getItemId(i);
        }
        SquareFeed squareFeed = (SquareFeed) this.m.get(i);
        if (p66.f()) {
            long j = squareFeed.id;
            return squareFeed.adKey != null ? r5.hashCode() : j;
        }
        return squareFeed.id + ((long) (i + EventParams.KEY_CT_SDK_POSITION).hashCode());
    }

    @Override // com.zenmen.square.lxpager.LxFragmentStateAdapter
    public PagerFragment m(int i) {
        List<D> list;
        return (i < 0 || (list = this.m) == 0 || list.size() <= i || ((SquareFeed) this.m.get(i)).adKey == null) ? new FeedDetailFragment() : new AdFragment();
    }
}
