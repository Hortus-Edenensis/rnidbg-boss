package com.zenmen.square.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.square.fragment.MomentDetailFragment;
import com.zenmen.square.lxpager.LxFragmentStateAdapter;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MomentsDetailAdapter extends LxFragmentStateAdapter<MomentDetailFragment, Feed> {
    public MomentsDetailAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override // com.zenmen.square.lxpager.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        List<D> list = this.m;
        if (list == 0 || list.size() <= i) {
            return super.getItemId(i);
        }
        return ((Feed) this.m.get(i)).getId() + ((long) (i + EventParams.KEY_CT_SDK_POSITION).hashCode());
    }

    @Override // com.zenmen.square.lxpager.LxFragmentStateAdapter
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public MomentDetailFragment m(int i) {
        return new MomentDetailFragment();
    }
}
