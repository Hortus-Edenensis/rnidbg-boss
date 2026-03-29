package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.flexbox.FlexboxLayout;
import com.zenmen.palmchat.R;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommonInfoCellView extends FrameLayout {
    private TextView cellLabel;
    private TextView cellTitle;
    private View cellUnReadView;
    private View root;
    private FlexboxLayout tagLayout;

    public CommonInfoCellView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.layout_cell_view_common_info, (ViewGroup) this, true);
        this.root = findViewById(R.id.rootView);
        this.cellTitle = (TextView) findViewById(R.id.titleTv);
        this.cellUnReadView = findViewById(R.id.dotView);
        this.cellLabel = (TextView) findViewById(R.id.infoTv);
        this.tagLayout = (FlexboxLayout) findViewById(R.id.tag);
        this.cellLabel.setHintTextColor(Color.parseColor("#FF14CD64"));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonInfoCellView);
            String string = typedArrayObtainStyledAttributes.getString(2);
            String string2 = typedArrayObtainStyledAttributes.getString(0);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(1, true);
            typedArrayObtainStyledAttributes.recycle();
            if (!TextUtils.isEmpty(string)) {
                this.cellTitle.setText(string);
            }
            if (string2 != null) {
                this.cellLabel.setHint(string2);
            }
            this.cellUnReadView.setVisibility(z ? 0 : 8);
        }
    }

    public boolean isShowUnRead() {
        return this.cellUnReadView.getVisibility() == 0;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.root.setOnClickListener(onClickListener);
    }

    public void setClicked() {
        if (isShowUnRead()) {
            this.cellUnReadView.setVisibility(8);
        }
    }

    public void update(String str, boolean z) {
        this.cellLabel.setText(str);
        this.cellUnReadView.setVisibility(z ? 0 : 8);
    }

    public void updateTag(String[] strArr, boolean z) {
        this.tagLayout.removeAllViews();
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (String str : strArr) {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(z ? R.layout.layout_cell_view_common_info_tag_item_bold : R.layout.layout_cell_view_common_info_tag_item, (ViewGroup) null, false);
            textView.setText(str);
            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = me1.b(getContext(), 10);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = me1.b(getContext(), 4);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = me1.b(getContext(), 10);
            this.tagLayout.addView(textView, layoutParams);
        }
        this.cellLabel.setText(" ");
    }

    public CommonInfoCellView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonInfoCellView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
