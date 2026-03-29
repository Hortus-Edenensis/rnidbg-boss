package com.zenmen.square.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import com.zenmen.square.ui.widget.SquarePhotoView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedMediaPageAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16179a;
    public List<View> b = Collections.emptyList();

    public FeedMediaPageAdapter(Context context, SquareFeed squareFeed, boolean z) {
        h(context, squareFeed, z);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.b.get(i));
    }

    public View f(int i) {
        if (i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    public List<View> g() {
        return this.b;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<View> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void h(Context context, SquareFeed squareFeed, boolean z) {
        List<Media> list;
        if (squareFeed == null || (list = squareFeed.mediaList) == null || list.isEmpty()) {
            return;
        }
        this.b = new ArrayList();
        for (Media media : squareFeed.mediaList) {
            if (squareFeed.feedType == 2) {
                SquarePhotoView squarePhotoView = new SquarePhotoView(context);
                squarePhotoView.setNeedClear(false);
                squarePhotoView.setMedia(media);
                this.b.add(squarePhotoView);
            } else {
                SquareDetailVideoView squareDetailVideoView = new SquareDetailVideoView(context);
                squareDetailVideoView.setFeed(squareFeed, z);
                this.b.add(squareDetailVideoView);
            }
        }
    }

    public void i(int i) {
        this.f16179a = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.b.get(i);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
