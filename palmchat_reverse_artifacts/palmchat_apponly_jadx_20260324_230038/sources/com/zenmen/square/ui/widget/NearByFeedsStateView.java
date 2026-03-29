package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$string;
import defpackage.a46;
import defpackage.l50;
import defpackage.qj5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByFeedsStateView extends ListStateView implements View.OnClickListener {
    private TextView mButton;

    public NearByFeedsStateView(Context context) {
        super(context);
    }

    private void onBtnClick() {
        if (a46.o()) {
            if (a46.q()) {
                return;
            }
            BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) getContext(), BaseActivityPermissionDispatcher.PermissionType.SQUARE_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_GET_LOCATION);
            qj5.d(1);
            return;
        }
        qj5.d(2);
        try {
            getContext().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.square.ui.widget.ListStateView
    public void createView(Context context) {
        super.createView(context);
        TextView textView = (TextView) findViewById(R$id.btn_operator);
        this.mButton = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || l50.a() || view.getId() != R$id.btn_operator) {
            return;
        }
        onBtnClick();
    }

    @Override // com.zenmen.square.ui.widget.ListStateView
    public void setState(PageState pageState) {
        super.setState(pageState);
        if (pageState == null) {
            return;
        }
        if (pageState.f11843a != PageState.State.ERROR || a46.p()) {
            setImageSize(a46.b(getContext(), 145.0f), a46.b(getContext(), 115.0f));
            setTopMargin(a46.b(getContext(), 136.0f));
            this.mButton.setVisibility(8);
            return;
        }
        if (!a46.o()) {
            this.mText.setText(R$string.square_nearby_guide_defualt_str_func);
            this.mButton.setText(R$string.square_nearby_btn_operator_func);
        } else if (!a46.q()) {
            this.mText.setText(R$string.square_nearby_guide_defualt_str);
            this.mButton.setText(R$string.square_nearby_btn_operator_per);
        }
        this.mButton.setVisibility(0);
        this.mImage.setImageResource(R$drawable.nearby_feed_location_guide);
        setImageSize(-1, -2);
        setTopMargin(a46.b(getContext(), 45.0f));
    }

    public NearByFeedsStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NearByFeedsStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NearByFeedsStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
