package com.zenmen.palmchat.photoview;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.zenmen.palmchat.friendcircle.video.VideoViewFragment;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhotoViewFragmentAdapter extends FragmentStatePagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<FeedBean> f15023a;
    public int b;
    public boolean c;
    public String d;
    public int e;

    public PhotoViewFragmentAdapter(FragmentManager fragmentManager, ArrayList<FeedBean> arrayList, boolean z, String str) {
        super(fragmentManager);
        this.f15023a = arrayList;
        this.c = z;
        this.d = str;
    }

    public void f(int i) {
        this.b = i;
    }

    public void g(int i) {
        this.e = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<FeedBean> arrayList = this.f15023a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        FeedBean feedBean = this.f15023a.get(i);
        if (feedBean.getMediaItem().mimeType != 1) {
            PhotoViewFragment photoViewFragment = new PhotoViewFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("long_click", this.c);
            bundle.putParcelable(SquareDetailVideoView.KEY_ITEM, feedBean.getMediaItem());
            photoViewFragment.setArguments(bundle);
            return photoViewFragment;
        }
        VideoViewFragment videoViewFragment = new VideoViewFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(SquareDetailVideoView.KEY_ITEM, feedBean);
        bundle2.putString("KEY_FROM", this.d);
        bundle2.putBoolean("long_click", this.c);
        bundle2.putInt(SquareDetailVideoView.KEY_POSITION, i);
        bundle2.putInt(SquareDetailVideoView.KEY_INIT_POSITION, this.b);
        bundle2.putInt(SquareDetailVideoView.KEY_VIDEO_POSITION, this.e);
        videoViewFragment.setArguments(bundle2);
        return videoViewFragment;
    }
}
