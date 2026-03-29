package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TagSubmitButton extends LxRelativeLayout {
    private int minTagCount;
    private TextView tvDes;
    private TextView tvText;

    public TagSubmitButton(Context context) {
        super(context);
        this.minTagCount = 3;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.square_layout_tag_submit_button, this);
        setBackgroundResource(R$drawable.square_btn_bg_24dp);
        this.tvText = (TextView) findViewById(R$id.button_text);
        this.tvDes = (TextView) findViewById(R$id.button_des);
    }

    public void setMinTagCount(int i) {
        if (i > 0) {
            this.minTagCount = i;
        }
        setSelectTagCount(0);
    }

    public void setSelectTagCount(int i) {
        if (i >= this.minTagCount) {
            setEnabled(true);
            this.tvText.setText(R$string.square_first_select_tag_btn_next);
            this.tvDes.setVisibility(8);
        } else {
            setEnabled(false);
            this.tvText.setText(getContext().getString(R$string.square_first_select_tag_count, Integer.valueOf(i), Integer.valueOf(this.minTagCount)));
            this.tvDes.setVisibility(0);
            this.tvDes.setText(getContext().getString(R$string.square_first_select_tag_limited, Integer.valueOf(this.minTagCount)));
        }
    }

    public TagSubmitButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.minTagCount = 3;
    }

    public TagSubmitButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.minTagCount = 3;
    }

    @RequiresApi(api = 21)
    public TagSubmitButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.minTagCount = 3;
    }
}
