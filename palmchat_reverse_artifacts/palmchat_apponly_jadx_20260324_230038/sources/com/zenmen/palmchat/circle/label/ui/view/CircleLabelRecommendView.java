package com.zenmen.palmchat.circle.label.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.label.bean.CircleLabel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleLabelRecommendView extends CircleLabelView {
    private TextView clbCName;
    private a clickListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(CircleLabel circleLabel);
    }

    public CircleLabelRecommendView(Context context) {
        super(context);
        init();
    }

    private void init() {
        View viewInflate = View.inflate(getContext(), R.layout.circle_label_item_recommend, this);
        this.clbCName = (TextView) viewInflate.findViewById(R.id.clb_c_name);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ia0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18131a.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        a aVar = this.clickListener;
        if (aVar != null) {
            aVar.a(this.circleLabel);
        }
    }

    public CircleLabel getData() {
        return this.circleLabel;
    }

    @Override // com.zenmen.palmchat.circle.label.ui.view.CircleLabelView
    public void setData(CircleLabel circleLabel) {
        super.setData(circleLabel);
        this.clbCName.setText(circleLabel.labelName);
        updateState();
    }

    public void setLabelRecClickListener(a aVar) {
        this.clickListener = aVar;
    }

    public void updateState() {
        Resources resources;
        int i;
        this.clbCName.setEnabled(this.circleLabel.isChoose);
        TextView textView = this.clbCName;
        if (this.circleLabel.isChoose) {
            resources = getResources();
            i = R.color.white;
        } else {
            resources = getResources();
            i = R.color.color_222222;
        }
        textView.setTextColor(resources.getColor(i));
    }

    public CircleLabelRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CircleLabelRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
