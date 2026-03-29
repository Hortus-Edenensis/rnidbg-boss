package com.zenmen.palmchat.circle.label.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.label.bean.CircleLabel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleLabelEditView extends CircleLabelView {
    private ImageView clbCDel;
    private TextView clbCName;
    private a clickListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(CircleLabel circleLabel);
    }

    public CircleLabelEditView(Context context) {
        super(context);
        init();
    }

    private void init() {
        View viewInflate = View.inflate(getContext(), R.layout.circle_label_item_edit, this);
        this.clbCName = (TextView) viewInflate.findViewById(R.id.clb_c_name);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.clb_c_del);
        this.clbCDel = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ea0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17244a.lambda$init$0(view);
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

    private void updateState() {
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

    @Override // com.zenmen.palmchat.circle.label.ui.view.CircleLabelView
    public void setData(CircleLabel circleLabel) {
        super.setData(circleLabel);
        this.clbCName.setText(circleLabel.labelName);
        this.clbCDel.setVisibility(circleLabel.isShowDel ? 0 : 8);
        updateState();
    }

    public void setLabelDelClickListener(a aVar) {
        this.clickListener = aVar;
    }

    public CircleLabelEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CircleLabelEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
