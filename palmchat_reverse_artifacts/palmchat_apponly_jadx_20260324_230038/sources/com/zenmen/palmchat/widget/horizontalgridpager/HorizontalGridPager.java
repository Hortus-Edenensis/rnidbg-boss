package com.zenmen.palmchat.widget.horizontalgridpager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.zenmen.palmchat.widget.horizontalgridpager.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class HorizontalGridPager extends LinearLayout {
    PageGridView gridView;
    PageIndicatorView indicatorView;

    public HorizontalGridPager(Context context) {
        this(context, null);
    }

    private int dip2px(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public PageGridAdapter getAdapter() {
        return (PageGridAdapter) this.gridView.getAdapter();
    }

    public void init(a aVar) {
        setOrientation(1);
        if (aVar == null) {
            aVar = new a.C1146a().j();
        }
        PageGridView pageGridView = new PageGridView(getContext(), aVar.a(), aVar.g());
        this.gridView = pageGridView;
        pageGridView.addItemDecoration(new VerticalSpacingItemDecoration(dip2px(aVar.h())));
        PageIndicatorView pageIndicatorView = new PageIndicatorView(getContext(), dip2px(aVar.e()), new int[]{dip2px(aVar.c()[0]), dip2px(aVar.c()[1]), dip2px(aVar.c()[2]), dip2px(aVar.c()[3])}, aVar.d(), aVar.b());
        this.indicatorView = pageIndicatorView;
        this.gridView.setIndicator(pageIndicatorView);
        addView(this.gridView);
        if (aVar.i()) {
            addView(this.indicatorView);
        } else {
            removeView(this.indicatorView);
        }
    }

    public void setAdapter(PageGridAdapter pageGridAdapter) {
        this.gridView.setAdapter(pageGridAdapter);
    }

    public HorizontalGridPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalGridPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
