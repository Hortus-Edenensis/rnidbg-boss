package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareButton extends LxRelativeLayout {
    private ImageView icon;
    private TextView textView;

    public SquareButton(Context context) {
        super(context);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.layout_square_widget_btn, this);
        View viewFindViewById = findViewById(R$id.ll_square_btn);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.addRule(13);
        viewFindViewById.setLayoutParams(layoutParams);
        this.icon = (ImageView) findViewById(R$id.iv_bottom_icon);
        this.textView = (TextView) findViewById(R$id.tv_bottom_text);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void initAttr(Context context, AttributeSet attributeSet) {
        int resourceId;
        super.initAttr(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.square_button);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.icon.getLayoutParams();
        int i = R$styleable.square_button_btnIconWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i)) {
            layoutParams.width = (int) typedArrayObtainStyledAttributes.getDimension(i, 0.0f);
        }
        int i2 = R$styleable.square_button_btnIconHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            layoutParams.height = (int) typedArrayObtainStyledAttributes.getDimension(i2, 0.0f);
        }
        int i3 = R$styleable.square_button_btnTextIconSpace;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            layoutParams.rightMargin = (int) typedArrayObtainStyledAttributes.getDimension(i3, 0.0f);
        }
        this.icon.setLayoutParams(layoutParams);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.square_button_btnIcon, 0);
        if (resourceId2 > 0) {
            this.icon.setVisibility(0);
            this.icon.setImageResource(resourceId2);
        } else {
            this.icon.setVisibility(8);
        }
        int i4 = R$styleable.square_button_btnTex;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            if (typedArrayObtainStyledAttributes.getType(i4) == 3) {
                this.textView.setText(typedArrayObtainStyledAttributes.getString(i4));
            } else if (typedArrayObtainStyledAttributes.getType(i4) == 1 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i4, 0)) > 0) {
                this.textView.setText(resourceId);
            }
        }
        int i5 = R$styleable.square_button_btnTexColor;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            if ((typedArrayObtainStyledAttributes.getType(i5) & 31) > 0) {
                this.textView.setTextColor(typedArrayObtainStyledAttributes.getColor(i5, -1));
            } else if (typedArrayObtainStyledAttributes.getType(i5) == 1) {
                this.textView.setTextColor(typedArrayObtainStyledAttributes.getColorStateList(i5));
            }
        }
        int i6 = R$styleable.square_button_btnTexSize;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, 0);
            if (dimensionPixelSize > 0.0f) {
                this.textView.setTextSize(dimensionPixelSize);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setBtnInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setIconImage(str2);
        setText(str);
    }

    public void setIconImage(String str) {
        if (TextUtils.isEmpty(str)) {
            this.icon.setVisibility(8);
        } else {
            this.icon.setVisibility(0);
        }
    }

    public void setIconImageResource(int i) {
        if (i <= 0) {
            this.icon.setVisibility(8);
        } else {
            this.icon.setVisibility(0);
            this.icon.setImageResource(i);
        }
    }

    public void setIconLayout(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.rightMargin = i;
        setIconLayout(layoutParams.width, layoutParams.height);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public SquareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public SquareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SquareButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setIconLayout(int i, int i2) {
        setIconLayout(i, i2, ((LinearLayout.LayoutParams) this.icon.getLayoutParams()).rightMargin);
    }

    public void setIconLayout(int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.rightMargin = i3;
        layoutParams.width = i;
        layoutParams.height = i2;
        this.icon.setLayoutParams(layoutParams);
    }
}
