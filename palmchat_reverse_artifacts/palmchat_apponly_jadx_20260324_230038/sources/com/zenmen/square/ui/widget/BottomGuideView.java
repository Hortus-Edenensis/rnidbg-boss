package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.a46;
import defpackage.ai5;
import defpackage.qj5;
import defpackage.yh5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class BottomGuideView extends LxRelativeLayout implements View.OnClickListener {
    public static final int GUIDE_MODE_LOCATION_FUNCTION = 2;
    public static final int GUIDE_MODE_PERMISSION = 1;
    private long lastShowTime;
    private ImageView mIVClose;
    private ImageView mIcon;
    private int mMode;
    private TextView mTVBtn;
    private TextView mTVInfo;

    public BottomGuideView(Context context) {
        this(context, null);
    }

    private void openBtnClick() {
        if (this.mMode == 1) {
            BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) getContext(), BaseActivityPermissionDispatcher.PermissionType.SQUARE_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_GET_LOCATION);
        } else {
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            getContext().startActivity(intent);
        }
        qj5.d(this.mMode);
    }

    private void xClick() {
        this.lastShowTime = System.currentTimeMillis();
        setVisibility(8);
        qj5.e(this.mMode);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.layout_square_bottom_guide, this);
        this.mIcon = (ImageView) findViewById(R$id.square_guide_bottom_icon);
        ImageView imageView = (ImageView) findViewById(R$id.square_guide_bottom_close);
        this.mIVClose = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R$id.square_guide_bottom_open);
        this.mTVBtn = textView;
        textView.setOnClickListener(this);
        this.mTVInfo = (TextView) findViewById(R$id.square_guide_bottom_info);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mTVBtn) {
            openBtnClick();
        } else if (view == this.mIVClose) {
            xClick();
        }
    }

    public void setCurrentGuideMode(int i) {
        if (i == 0) {
            setVisibility(4);
            return;
        }
        yh5 yh5VarF = ai5.k().f(i == 1 ? "discover_locationlimits" : i == 2 ? "discover_locationfunction" : "");
        if (System.currentTimeMillis() - this.lastShowTime < yh5VarF.c()) {
            setVisibility(4);
            return;
        }
        if (getVisibility() != 0 || this.mMode != i) {
            setVisibility(0);
            qj5.f(i);
        }
        this.mMode = i;
        ViewGroup.LayoutParams layoutParams = this.mIVClose.getLayoutParams();
        if (yh5VarF.e()) {
            layoutParams.width = a46.b(getContext(), 24.0f);
        } else {
            layoutParams.width = 0;
        }
        this.mIcon.setImageResource(this.mMode == 1 ? R$drawable.square_guide_bottom_icon_limit : R$drawable.square_guide_bottom_icon_function);
        this.mIVClose.setLayoutParams(layoutParams);
        this.mTVBtn.setText(yh5VarF.a());
        this.mTVInfo.setText(yh5VarF.b());
    }

    public BottomGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
