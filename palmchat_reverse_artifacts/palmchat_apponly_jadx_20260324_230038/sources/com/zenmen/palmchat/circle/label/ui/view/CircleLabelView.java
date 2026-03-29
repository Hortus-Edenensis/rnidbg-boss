package com.zenmen.palmchat.circle.label.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.circle.label.bean.CircleLabel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class CircleLabelView extends RelativeLayout {
    protected CircleLabel circleLabel;

    public CircleLabelView(Context context) {
        super(context);
    }

    public String getLabelId() {
        CircleLabel circleLabel = this.circleLabel;
        return circleLabel != null ? circleLabel.id : "";
    }

    public String getLabelName() {
        CircleLabel circleLabel = this.circleLabel;
        return circleLabel != null ? circleLabel.labelName : "";
    }

    public void setData(CircleLabel circleLabel) {
        this.circleLabel = circleLabel;
    }

    public CircleLabelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleLabelView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
