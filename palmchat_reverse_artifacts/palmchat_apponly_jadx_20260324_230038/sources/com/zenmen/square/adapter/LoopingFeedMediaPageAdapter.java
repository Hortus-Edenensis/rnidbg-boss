package com.zenmen.square.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.widget.loopingvp.LoopingPagerAdapter;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import com.zenmen.square.ui.widget.SquarePhotoView;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LoopingFeedMediaPageAdapter extends LoopingPagerAdapter {
    public int f;
    public HashMap<Integer, View> g;
    public SquareFeed h;
    public boolean i;
    public GestureDetector.OnDoubleTapListener j;

    public LoopingFeedMediaPageAdapter(Context context, SquareFeed squareFeed, boolean z, GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        super(context);
        this.g = new HashMap<>();
        this.h = squareFeed;
        this.i = z;
        this.j = onDoubleTapListener;
    }

    @Override // com.zenmen.palmchat.widget.loopingvp.LoopingPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // com.zenmen.palmchat.widget.loopingvp.LoopingPagerAdapter
    public View h(int i, ViewGroup viewGroup, int i2) {
        return null;
    }

    @Override // com.zenmen.palmchat.widget.loopingvp.LoopingPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View viewK = k(viewGroup.getContext(), this.e.toDataPosition(i));
        viewGroup.addView(viewK);
        return viewK;
    }

    public final View k(Context context, int i) {
        View view;
        Media media = (Media) this.b.get(i);
        if (this.h.feedType == 2) {
            SquarePhotoView squarePhotoView = new SquarePhotoView(context);
            squarePhotoView.setNeedClear(false);
            squarePhotoView.setMedia(media);
            view = squarePhotoView;
            if (this.j != null) {
                squarePhotoView.getPhotoView().setOnDoubleTapListener(this.j);
                view = squarePhotoView;
            }
        } else {
            SquareDetailVideoView squareDetailVideoView = new SquareDetailVideoView(context);
            squareDetailVideoView.setFeed(this.h, this.i);
            view = squareDetailVideoView;
        }
        this.g.put(Integer.valueOf(i), view);
        return view;
    }

    public View l(int i) {
        return this.g.get(Integer.valueOf(i));
    }

    public void m(int i) {
        this.f = i;
    }

    @Override // com.zenmen.palmchat.widget.loopingvp.LoopingPagerAdapter
    public void f(View view, int i, int i2) {
    }
}
