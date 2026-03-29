package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.tag.bean.SquareTagBean;
import defpackage.gr2;
import defpackage.hr2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFirstTagItemView extends LxRelativeLayout {
    private ImageView tagIcon;
    private TextView tagName;

    public SquareFirstTagItemView(Context context) {
        super(context);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.square_layout_fisrt_tag_item_view, this);
        this.tagName = (TextView) findViewById(R$id.tag_name);
        this.tagIcon = (ImageView) findViewById(R$id.tag_icon);
    }

    public void setTag(SquareTagBean squareTagBean) {
        this.tagName.setText(squareTagBean.getName());
        this.tagIcon.setColorFilter(-1);
        gr2.j().h(squareTagBean.getPicUrl(), this.tagIcon, hr2.g());
    }

    public SquareFirstTagItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareFirstTagItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public SquareFirstTagItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
