package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.config.CellItem;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.yz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabCellView2 extends FrameLayout implements yz {
    protected boolean canShowBadge;
    protected boolean canShowBubble;
    protected boolean canShowIcon;
    protected boolean canShowLabel;
    protected boolean canShowNew;
    protected boolean canShowRedDot;
    public ImageView cellIcon;
    public TextView cellTitle;
    public TabCellUnReadView cellUnReadView;
    public TextView mCellLabel;
    public RelativeLayout mCellLabelRelativelayout;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (TabCellView2.this.getWidth() == 0 || TabCellView2.this.cellUnReadView.getWidth() == 0) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TabCellView2.this.cellUnReadView.getLayoutParams();
            if (layoutParams.leftMargin != (-TabCellView2.this.cellUnReadView.getWidth()) / 2) {
                layoutParams.leftMargin = (-TabCellView2.this.cellUnReadView.getWidth()) / 2;
                layoutParams.topMargin = (-TabCellView2.this.cellUnReadView.getHeight()) / 2;
                layoutParams.bottomMargin = (-TabCellView2.this.cellUnReadView.getHeight()) / 2;
                TabCellView2.this.cellUnReadView.setLayoutParams(layoutParams);
            }
        }
    }

    public TabCellView2(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        this.cellIcon = (ImageView) findViewById(R.id.cell_icon);
        this.cellTitle = (TextView) findViewById(R.id.cell_title);
        this.mCellLabel = (TextView) findViewById(R.id.cell_label);
        this.cellTitle.setSingleLine();
        this.cellUnReadView = (TabCellUnReadView) findViewById(R.id.cell_unread);
        this.mCellLabelRelativelayout = (RelativeLayout) findViewById(R.id.cell_label_relativelayout);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabCellView);
            String string = typedArrayObtainStyledAttributes.getString(4);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
            int i = typedArrayObtainStyledAttributes.getInt(5, 0);
            typedArrayObtainStyledAttributes.recycle();
            updateCellTitle(string);
            updateCellIcon(drawable);
            updateUnReadView(i);
        }
        if (reSizeMargin()) {
            addOnLayoutChangeListener(new a());
        }
    }

    public ImageView getCellIconView() {
        return this.cellIcon;
    }

    public RelativeLayout getCellLayout() {
        return null;
    }

    public TextView getCellTitleView() {
        return this.cellTitle;
    }

    @Override // defpackage.yz
    public TabCellUnReadView getCellUnReadView() {
        return this.cellUnReadView;
    }

    @Override // defpackage.yz
    public String getLabel() {
        return null;
    }

    public TextView getLabelView() {
        return null;
    }

    public int getLayoutId() {
        return R.layout.layout_cell_view_tab_item2;
    }

    public TextView getSubTitleLabelView() {
        return null;
    }

    @Override // defpackage.yz
    public int getUnread() {
        return this.cellUnReadView.getViewStatus();
    }

    @Override // defpackage.yz
    public boolean isBubbleShow() {
        return false;
    }

    @Override // defpackage.yz
    public boolean isShowGuideIcon() {
        return false;
    }

    @Override // defpackage.yz
    public void onEntranceClick() {
        if (this.mCellLabelRelativelayout.getVisibility() == 0) {
            this.mCellLabelRelativelayout.setVisibility(8);
        }
    }

    public boolean reSizeMargin() {
        return true;
    }

    @Override // defpackage.yz
    public void setIcon(String str, Integer num) {
        if (!TextUtils.isEmpty(str) || num == null) {
            gr2.j().h(str, this.cellIcon, bq6.v());
        } else {
            this.cellIcon.setImageDrawable(getResources().getDrawable(num.intValue()));
        }
    }

    @Override // defpackage.yz
    public void setLabel(String str) {
        if (TextUtils.isEmpty(str) || !this.canShowLabel) {
            return;
        }
        this.mCellLabelRelativelayout.setVisibility(0);
        this.mCellLabel.setText(str);
        this.cellUnReadView.updateView(0);
    }

    @Override // defpackage.yz
    public void setNoticeType(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.canShowBadge = z;
        this.canShowRedDot = z2;
        this.canShowNew = z3;
        this.canShowIcon = z4;
        this.canShowLabel = z5;
        this.canShowBubble = z6;
    }

    @Override // defpackage.yz
    public void setTitle(String str) {
        updateCellTitle(str);
    }

    @Override // defpackage.yz
    public void setUnread(int i) {
        if (!this.canShowLabel || TextUtils.isEmpty(this.mCellLabel.getText())) {
            updateUnReadView(i);
        }
    }

    public void updateCellIcon(Drawable drawable) {
        this.cellIcon.setImageDrawable(drawable);
    }

    public void updateCellTitle(String str) {
        this.cellTitle.setText(str);
    }

    public void updateUnReadView(int i) {
        if (i != -2 || this.canShowNew) {
            if (i != -1 || this.canShowRedDot) {
                if (i <= 0 || this.canShowBadge) {
                    this.cellUnReadView.updateView(i);
                }
            }
        }
    }

    public TabCellView2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabCellView2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canShowBadge = true;
        this.canShowRedDot = true;
        this.canShowNew = true;
        this.canShowIcon = true;
        this.canShowLabel = true;
        this.canShowBubble = true;
        init(context, attributeSet);
    }

    @Override // defpackage.yz
    public void setBubble(CellItem cellItem) {
    }

    @Override // defpackage.yz
    public void setSubTitleLabel(String str) {
    }

    @Override // defpackage.yz
    public void setGuideIcon(String str, Integer num) {
    }
}
