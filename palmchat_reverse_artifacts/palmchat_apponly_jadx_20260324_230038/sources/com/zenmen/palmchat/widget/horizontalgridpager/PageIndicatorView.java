package com.zenmen.palmchat.widget.horizontalgridpager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PageIndicatorView extends LinearLayout {
    private int[] indicatorRes;
    private int indicatorSize;
    private ArrayList<View> indicatorViews;
    private int[] margins;

    public PageIndicatorView(Context context, int i, int[] iArr, int[] iArr2, int i2) {
        super(context);
        this.indicatorSize = i;
        this.margins = iArr;
        this.indicatorRes = iArr2;
        setGravity(i2);
        setOrientation(0);
    }

    public void initIndicator(int i) {
        ArrayList<View> arrayList = this.indicatorViews;
        if (arrayList == null) {
            this.indicatorViews = new ArrayList<>();
        } else {
            arrayList.clear();
            removeAllViews();
        }
        int i2 = this.indicatorSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        int[] iArr = this.margins;
        layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        for (int i3 = 0; i3 < i; i3++) {
            View view = new View(getContext());
            view.setBackgroundResource(this.indicatorRes[0]);
            addView(view, layoutParams);
            this.indicatorViews.add(view);
        }
        if (this.indicatorViews.size() > 0) {
            this.indicatorViews.get(0).setBackgroundResource(this.indicatorRes[1]);
        }
    }

    public void update(int i) {
        for (int i2 = 0; i2 < this.indicatorViews.size(); i2++) {
            if (i2 == i) {
                this.indicatorViews.get(i2).setBackgroundResource(this.indicatorRes[1]);
            } else {
                this.indicatorViews.get(i2).setBackgroundResource(this.indicatorRes[0]);
            }
        }
    }
}
