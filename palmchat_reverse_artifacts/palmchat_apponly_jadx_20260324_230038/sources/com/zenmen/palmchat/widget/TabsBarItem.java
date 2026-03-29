package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.me1;
import defpackage.pe5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabsBarItem extends RelativeLayout {
    private static final int COLOR_TEXT_NORMAL = 2131100280;
    private static final int COLOR_TEXT_SELECT = 2131100281;
    private int badgeCount;
    public ImageView dynamicIconView;
    public View iconLayout;
    private String iconUrl;
    private boolean isSelectable;
    public TextView mBadge;
    public ImageView mIcon;
    public ImageView mIconIv;
    public View mRedDot;
    public TextView mTitle;
    public View noticeLayout;
    private String selectedIconUrl;

    public TabsBarItem(Context context) {
        this(context, null);
    }

    private int getTitleSelectedColor() {
        int color = getResources().getColor(R.color.lx_tab_bar_select_text);
        String strD = pe5.a().d();
        return !TextUtils.isEmpty(strD) ? Color.parseColor(strD) : color;
    }

    private int getTitleUnSelectedColor() {
        int color = getResources().getColor(R.color.lx_tab_bar_normal_text);
        String strE = pe5.a().e();
        return !TextUtils.isEmpty(strE) ? Color.parseColor(strE) : color;
    }

    private void initViews() {
        View viewInflate = View.inflate(getContext(), R.layout.layout_main_tab_item, this);
        this.mTitle = (TextView) viewInflate.findViewById(R.id.tab_title);
        this.mIcon = (ImageView) viewInflate.findViewById(R.id.tab_icon);
        this.mRedDot = viewInflate.findViewById(R.id.red_dot0);
        this.mBadge = (TextView) viewInflate.findViewById(R.id.red_text0);
        this.noticeLayout = viewInflate.findViewById(R.id.noticeLayout);
        this.mIconIv = (ImageView) viewInflate.findViewById(R.id.iconIv);
        this.iconLayout = viewInflate.findViewById(R.id.icon_layout);
        this.dynamicIconView = (ImageView) viewInflate.findViewById(R.id.dynamic_icon);
    }

    public int getViewStatus() {
        return isBadgeShow() ? this.badgeCount : isRedDotShow() ? -1 : 0;
    }

    public boolean isBadgeShow() {
        return this.mBadge.getVisibility() == 0;
    }

    public boolean isRedDotShow() {
        return this.mRedDot.getVisibility() == 0;
    }

    public void onSelected(boolean z) {
        if (this.isSelectable && z) {
            this.mTitle.setTextColor(getTitleSelectedColor());
            this.mTitle.getPaint().setFakeBoldText(true);
            this.mIcon.setSelected(true);
        } else {
            this.mTitle.setTextColor(getTitleUnSelectedColor());
            this.mTitle.getPaint().setFakeBoldText(false);
            this.mIcon.setSelected(false);
        }
        if (TextUtils.isEmpty(this.iconUrl) || TextUtils.isEmpty(this.selectedIconUrl)) {
            return;
        }
        gr2.j().h(this.mIcon.isSelected() ? this.selectedIconUrl : this.iconUrl, this.mIcon, bq6.w());
    }

    public void setBadgeCount(int i) {
        this.badgeCount = i;
        if (i >= 100) {
            this.mBadge.setText(R.string.notification_ellipsis);
        } else {
            this.mBadge.setText(String.valueOf(i));
        }
    }

    public void setBadgeShow(boolean z) {
        this.mBadge.setVisibility(z ? 0 : 8);
    }

    public void setIcon(String str, String str2, Integer num) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.mIcon.setImageDrawable(getResources().getDrawable(num.intValue()));
            return;
        }
        this.iconUrl = str;
        this.selectedIconUrl = str2;
        if (this.mIcon.isSelected()) {
            str = str2;
        }
        gr2.j().h(str, this.mIcon, bq6.w());
    }

    public void setIconStyle() {
        this.mIconIv.setVisibility(0);
        this.mTitle.setVisibility(8);
        this.mIcon.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.noticeLayout.getLayoutParams();
        layoutParams.rightMargin = -me1.b(getContext(), 4);
        this.noticeLayout.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mRedDot.getLayoutParams();
        layoutParams2.rightMargin = me1.b(getContext(), 6);
        this.mRedDot.setLayoutParams(layoutParams2);
    }

    public void setRedDotShow(boolean z) {
        this.mRedDot.setVisibility(z ? 0 : 8);
    }

    public void setSelectable(boolean z) {
        this.isSelectable = z;
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void showDynamicIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iconLayout.setVisibility(0);
            this.dynamicIconView.setVisibility(8);
            this.mTitle.setVisibility(this.mIconIv.getVisibility() == 0 ? 8 : 0);
        } else {
            this.iconLayout.setVisibility(4);
            this.mTitle.setVisibility(8);
            this.dynamicIconView.setVisibility(0);
            gr2.j().h(str, this.dynamicIconView, bq6.s());
        }
    }

    public TabsBarItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabsBarItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.badgeCount = 0;
        this.isSelectable = true;
        initViews();
    }
}
