package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.zenmen.find.ConditionHelper;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$dimen;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import defpackage.a46;
import defpackage.bj5;
import defpackage.l50;
import defpackage.qj5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByStateView extends ListStateView implements View.OnClickListener {
    private TextView mButton;
    private View mNearbyEmptyView;
    private View mNearbyEmptyViewAiQuickMatch;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NearByStateView.this.openBtnClick();
        }
    }

    public NearByStateView(Context context) {
        super(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openBtnClick() {
        if (a46.o()) {
            BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) getContext(), BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.FIND_FRIEND_GET_LOCATION);
            qj5.d(1);
            return;
        }
        qj5.d(2);
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        try {
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.square.ui.widget.ListStateView
    public void createView(Context context) {
        super.createView(context);
        TextView textView = (TextView) findViewById(R$id.btn_operator);
        this.mButton = textView;
        textView.setOnClickListener(new a());
        this.mNearbyEmptyView = findViewById(R$id.rl_nearby_empty_view);
        this.mNearbyEmptyViewAiQuickMatch = findViewById(R$id.rl_nearby_empty_view_ai_quick_match);
        findViewById(R$id.btn_condition).setOnClickListener(this);
        findViewById(R$id.btn_condition_ai_quick_match).setOnClickListener(this);
        showEmptyView(true);
    }

    @Override // com.zenmen.square.ui.widget.ListStateView
    public int getLayoutResource() {
        return R$layout.layout_nearby_list_state_view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        if (view.getId() == R$id.btn_condition) {
            ConditionHelper.openFilterDialog(this.pageType, (FrameworkBaseActivity) getContext());
        } else if (view.getId() == R$id.btn_condition_ai_quick_match) {
            bj5.b().a().G((FrameworkBaseActivity) getContext());
        }
    }

    @Override // com.zenmen.square.ui.widget.ListStateView
    public void setState(PageState pageState) {
        super.setState(pageState);
        boolean zIsDefaultCond = (this.pageType == 48 ? ConditionHelper.getInstance().getRecommendCond() : ConditionHelper.getInstance().getNearByCond()).isDefaultCond();
        if (pageState.f11843a != PageState.State.EMPTY || zIsDefaultCond) {
            showEmptyView(false);
        } else {
            showEmptyView(true);
            this.mText.setVisibility(8);
            this.mImage.setVisibility(8);
        }
        if (pageState.f11843a == PageState.State.ERROR) {
            if (!a46.p() && this.pageType == 49) {
                if (a46.o()) {
                    this.mText.setText(R$string.square_nearby_guide_defualt_str);
                    this.mButton.setText(R$string.square_nearby_btn_operator_per);
                } else {
                    this.mText.setText(R$string.square_nearby_guide_defualt_str_func);
                    this.mButton.setText(R$string.square_nearby_btn_operator_func);
                }
                this.mButton.setVisibility(0);
                this.mImage.setImageResource(R$drawable.icon_square_nearby_guide);
                return;
            }
            this.mText.setVisibility(0);
            this.mImage.setVisibility(0);
        }
        this.mText.setTextSize(0, getResources().getDimensionPixelSize(R$dimen.text_size_xsmall));
        this.mButton.setVisibility(8);
    }

    public void showEmptyView(boolean z) {
        if (z) {
            if (bj5.b().a().R()) {
                this.mNearbyEmptyView.setVisibility(8);
                this.mNearbyEmptyViewAiQuickMatch.setVisibility(0);
                return;
            } else {
                this.mNearbyEmptyViewAiQuickMatch.setVisibility(8);
                this.mNearbyEmptyView.setVisibility(0);
                return;
            }
        }
        if (bj5.b().a().R()) {
            this.mNearbyEmptyView.setVisibility(8);
            this.mNearbyEmptyViewAiQuickMatch.setVisibility(8);
        } else {
            this.mNearbyEmptyViewAiQuickMatch.setVisibility(8);
            this.mNearbyEmptyView.setVisibility(8);
        }
    }

    public NearByStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public NearByStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    public NearByStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
