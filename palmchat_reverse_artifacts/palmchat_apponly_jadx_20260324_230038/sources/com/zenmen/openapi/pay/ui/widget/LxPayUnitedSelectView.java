package com.zenmen.openapi.pay.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.openapi.R$color;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LxPayUnitedSelectView extends RelativeLayout implements View.OnClickListener {
    private int _id;
    private ImageView ivBrand;
    private Context mContext;
    private RadioButton rbSelect;
    private TextView tvBrand;

    public LxPayUnitedSelectView(Context context) {
        this(context, null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.lx_pay_united_select_item, this);
        this.ivBrand = (ImageView) viewInflate.findViewById(R$id.iv_brand);
        this.tvBrand = (TextView) viewInflate.findViewById(R$id.tv_brand);
        this.rbSelect = (RadioButton) viewInflate.findViewById(R$id.rb_select);
        viewInflate.setOnClickListener(this);
    }

    public RadioButton getRadioButton() {
        return this.rbSelect;
    }

    public boolean isChecked() {
        return this.rbSelect.isChecked();
    }

    public boolean isSelectEnable() {
        return this.rbSelect.isEnabled();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.rbSelect.isEnabled()) {
            this.rbSelect.performClick();
        }
    }

    public void setBrandIcon(Drawable drawable) {
        this.ivBrand.setImageDrawable(drawable);
    }

    public void setBrandTxt(String str) {
        this.tvBrand.setText(str);
    }

    public void setCheck(boolean z) {
        this.rbSelect.setChecked(z);
    }

    public void setSelectEnable(boolean z) {
        if (z) {
            this.tvBrand.setTextColor(getResources().getColor(R$color.text_color_black));
        } else {
            this.tvBrand.setTextColor(getResources().getColor(R$color.lx_pay_text_color_hint));
        }
        this.rbSelect.setEnabled(z);
    }

    public LxPayUnitedSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._id = -1;
        initView(context, attributeSet);
    }
}
