package com.zenmen.palmchat.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFitGridView extends GridView {
    private int line;
    private int lineHeight;
    private int maxHeight;
    private int otherheight;

    public AutoFitGridView(Context context) {
        super(context);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.group_height_max);
        this.line = 1;
        this.lineHeight = (int) getContext().getResources().getDimension(R.dimen.group_line_height);
        this.otherheight = (int) getContext().getResources().getDimension(R.dimen.text_size_middle);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(i, Math.min((this.line * this.lineHeight) + this.otherheight, this.maxHeight));
    }

    public void setHeight(int i) {
        this.line = i;
    }

    public AutoFitGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.group_height_max);
        this.line = 1;
        this.lineHeight = (int) getContext().getResources().getDimension(R.dimen.group_line_height);
        this.otherheight = (int) getContext().getResources().getDimension(R.dimen.text_size_middle);
    }

    public AutoFitGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.group_height_max);
        this.line = 1;
        this.lineHeight = (int) getContext().getResources().getDimension(R.dimen.group_line_height);
        this.otherheight = (int) getContext().getResources().getDimension(R.dimen.text_size_middle);
    }
}
