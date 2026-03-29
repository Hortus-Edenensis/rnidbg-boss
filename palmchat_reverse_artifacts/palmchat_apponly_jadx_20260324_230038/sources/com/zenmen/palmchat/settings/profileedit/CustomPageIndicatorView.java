package com.zenmen.palmchat.settings.profileedit;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import defpackage.me1;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CustomPageIndicatorView extends LinearLayout {
    private int height;
    private int[] indicatorRes;
    private ArrayList<View> indicatorViews;
    private int margins;
    private int normalSizeWidth;
    private int selectSizeWidth;

    public CustomPageIndicatorView(Context context, int i, int[] iArr) {
        super(context);
        this.margins = i;
        this.indicatorRes = iArr;
        setOrientation(0);
        this.selectSizeWidth = me1.b(context, 32);
        this.normalSizeWidth = me1.b(context, 12);
        this.height = me1.b(context, 3);
    }

    public void initIndicator(int i) {
        ArrayList<View> arrayList = this.indicatorViews;
        if (arrayList == null) {
            this.indicatorViews = new ArrayList<>();
        } else {
            arrayList.clear();
            removeAllViews();
        }
        for (int i2 = 0; i2 < i; i2++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.normalSizeWidth, this.height);
            int i3 = this.margins;
            layoutParams.setMargins(i3, i3, i3, i3);
            View view = new View(getContext());
            view.setBackgroundResource(this.indicatorRes[0]);
            addView(view, layoutParams);
            this.indicatorViews.add(view);
        }
        if (this.indicatorViews.size() > 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.indicatorViews.get(0).getLayoutParams();
            layoutParams2.width = this.selectSizeWidth;
            this.indicatorViews.get(0).setLayoutParams(layoutParams2);
            this.indicatorViews.get(0).setBackgroundResource(this.indicatorRes[1]);
        }
    }

    public void setItemSize(int i, int i2, int i3) {
        this.selectSizeWidth = i;
        this.normalSizeWidth = i2;
        this.height = i3;
    }

    public void update(int i) {
        int i2 = 0;
        while (i2 < this.indicatorViews.size()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.indicatorViews.get(i2).getLayoutParams();
            layoutParams.width = i2 == i ? this.selectSizeWidth : this.normalSizeWidth;
            this.indicatorViews.get(i2).setLayoutParams(layoutParams);
            if (i2 == i) {
                this.indicatorViews.get(i2).setBackgroundResource(this.indicatorRes[1]);
            } else {
                this.indicatorViews.get(i2).setBackgroundResource(this.indicatorRes[0]);
            }
            i2++;
        }
    }
}
