package com.zenmen.square.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import com.zenmen.square.ui.widget.SquarePhotoView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFriendPageAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16181a;
    public List<View> b;

    public SquareFriendPageAdapter(Context context, Feed feed, boolean z) {
        h(context, feed, z);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = this.b.get(i);
        if (view != null) {
            viewGroup.removeView(view);
        }
    }

    public View f(int i) {
        if (i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    public List<View> g() {
        return this.b;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.b.size();
    }

    public final void h(Context context, Feed feed, boolean z) {
        this.b = new ArrayList();
        List<Media> mediaList = feed.getMediaList();
        if (mediaList == null) {
            return;
        }
        for (Media media : mediaList) {
            if (media.type == 1) {
                SquareDetailVideoView squareDetailVideoView = new SquareDetailVideoView(context);
                com.zenmen.square.mvp.model.bean.Media media2 = new com.zenmen.square.mvp.model.bean.Media();
                media2.localPath = media.localPath;
                media2.videoUrl = media.videoUrl;
                media2.url = media.url;
                media2.thumbUrl = media.thumbUrl;
                media2.midUrl = media.midUrl;
                SquareFeed squareFeed = new SquareFeed();
                squareFeed.id = feed.getFeedId().longValue();
                ArrayList arrayList = new ArrayList();
                squareFeed.mediaList = arrayList;
                arrayList.add(media2);
                squareDetailVideoView.setFeed(squareFeed, z);
                this.b.add(squareDetailVideoView);
            } else {
                SquarePhotoView squarePhotoView = new SquarePhotoView(context);
                squarePhotoView.setNeedClear(false);
                com.zenmen.square.mvp.model.bean.Media media3 = new com.zenmen.square.mvp.model.bean.Media();
                media3.url = media.url;
                media3.midUrl = media.midUrl;
                media3.thumbUrl = media.thumbUrl;
                squarePhotoView.setMedia(media3);
                this.b.add(squarePhotoView);
            }
        }
    }

    public void i(int i) {
        this.f16181a = i;
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
