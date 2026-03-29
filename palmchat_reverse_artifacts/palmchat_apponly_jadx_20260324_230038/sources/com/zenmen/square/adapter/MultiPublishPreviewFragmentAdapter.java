package com.zenmen.square.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.square.fragment.MultiPublishPreviewFragment;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MultiPublishPreviewFragmentAdapter extends FragmentStatePagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<FeedBean> f16180a;

    public MultiPublishPreviewFragmentAdapter(FragmentManager fragmentManager, ArrayList<FeedBean> arrayList) {
        super(fragmentManager);
        this.f16180a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<FeedBean> arrayList = this.f16180a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        FeedBean feedBean = this.f16180a.get(i);
        MultiPublishPreviewFragment multiPublishPreviewFragment = new MultiPublishPreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SquareDetailVideoView.KEY_ITEM, feedBean.getMediaItem());
        multiPublishPreviewFragment.setArguments(bundle);
        return multiPublishPreviewFragment;
    }
}
