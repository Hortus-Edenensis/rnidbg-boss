package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleSecondLevelItemView extends RelativeLayout {
    private Context mContext;
    private int mHeight;
    private int mWidth;
    private TextView tv_second_item;

    public CircleSecondLevelItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.tv_second_item = (TextView) View.inflate(context, R.layout.second_level_item_view, this).findViewById(R.id.tv_second_item);
    }

    public void setSecondLevelItemWidthAndHeight(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public CircleSecondLevelItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CircleSecondLevelItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
