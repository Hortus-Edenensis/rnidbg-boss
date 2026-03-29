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
public class TabCellView4 extends FrameLayout implements yz {
    private boolean canShowBadge;
    private boolean canShowIcon;
    private boolean canShowLabel;
    private boolean canShowNew;
    private boolean canShowRedDot;
    public TextView cellCenterLabel;
    public EffectiveShapeView cellGuideIcon;
    public View cellGuideLayout;
    public ImageView cellIcon;
    public TextView cellLabel;
    public TextView cellSubtitleLabel;
    public TextView cellTitle;
    public TabCellUnReadView cellUnReadView;
    public RelativeLayout mItemLayout;
    private int mType;
    public View unSend;

    public TabCellView4(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.layout_cell_view_tab_item4, (ViewGroup) this, true);
        this.mItemLayout = (RelativeLayout) findViewById(R.id.cell_item_layout);
        this.cellIcon = (ImageView) findViewById(R.id.cell_icon);
        this.cellTitle = (TextView) findViewById(R.id.cell_title);
        this.cellUnReadView = (TabCellUnReadView) findViewById(R.id.cell_unread);
        this.cellLabel = (TextView) findViewById(R.id.cell_label);
        this.cellCenterLabel = (TextView) findViewById(R.id.cell_label_title);
        this.cellSubtitleLabel = (TextView) findViewById(R.id.cell_label_sutitle);
        this.cellGuideLayout = findViewById(R.id.cell_guide_layout);
        this.cellGuideIcon = (EffectiveShapeView) findViewById(R.id.cell_guide_icon);
        this.unSend = findViewById(R.id.unsend);
        this.cellGuideIcon.changeShapeType(3);
        this.cellGuideIcon.setDegreeForRoundRectangle(13, 13);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabCellView);
            String string = typedArrayObtainStyledAttributes.getString(4);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
            String string2 = typedArrayObtainStyledAttributes.getString(2);
            String string3 = typedArrayObtainStyledAttributes.getString(3);
            int i = typedArrayObtainStyledAttributes.getInt(5, 0);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            updateCellTitle(string);
            updateCellIcon(drawable);
            updateCellLabel(string2);
            updateCellSubtitleLabel(string3);
            updateUnReadView(i);
            updateGuideIcon(drawable2);
        }
    }

    public ImageView getCellIconView() {
        return this.cellIcon;
    }

    public RelativeLayout getCellLayout() {
        return this.mItemLayout;
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
        if (this.cellLabel.getVisibility() != 0 || this.cellLabel.getText() == null) {
            return null;
        }
        return this.cellLabel.getText().toString();
    }

    public TextView getLabelView() {
        return this.cellLabel;
    }

    public TextView getSubTitleLabelView() {
        return this.cellSubtitleLabel;
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
        return this.cellGuideLayout.getVisibility() == 0;
    }

    @Override // defpackage.yz
    public void setGuideIcon(String str, Integer num) {
        if (TextUtils.isEmpty(str) && num == null) {
            this.cellGuideLayout.setVisibility(8);
            return;
        }
        this.cellGuideLayout.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.cellGuideIcon.setImageDrawable(getResources().getDrawable(num.intValue()));
        } else {
            gr2.j().h(str, this.cellGuideIcon, bq6.s());
        }
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
        updateCellLabel(str);
    }

    @Override // defpackage.yz
    public void setNoticeType(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.canShowBadge = z;
        this.canShowRedDot = z2;
        this.canShowNew = z3;
        this.canShowIcon = z4;
        this.canShowLabel = z5;
    }

    @Override // defpackage.yz
    public void setSubTitleLabel(String str) {
        updateCellSubtitleLabel(str);
    }

    @Override // defpackage.yz
    public void setTitle(String str) {
        updateCellTitle(str);
    }

    @Override // defpackage.yz
    public void setUnread(int i) {
        updateUnReadView(i);
    }

    public void showUnSend(boolean z) {
        this.unSend.setVisibility(z ? 0 : 8);
    }

    public void updateCellIcon(Drawable drawable) {
        this.cellIcon.setImageDrawable(drawable);
    }

    public void updateCellLabel(String str) {
        if (this.canShowLabel) {
            if (TextUtils.isEmpty(str)) {
                this.cellLabel.setVisibility(8);
            } else {
                this.cellLabel.setVisibility(0);
            }
            if (this.cellSubtitleLabel.getVisibility() == 8) {
                this.cellCenterLabel.setVisibility(0);
                this.cellCenterLabel.setText(str);
                this.cellLabel.setVisibility(8);
            }
            this.cellLabel.setText(str);
        }
    }

    public void updateCellSubtitleLabel(String str) {
        if (this.canShowLabel) {
            if (TextUtils.isEmpty(str)) {
                this.cellSubtitleLabel.setVisibility(8);
            } else {
                this.cellSubtitleLabel.setVisibility(0);
            }
            this.cellSubtitleLabel.setText(str);
        }
    }

    public void updateCellTitle(String str) {
        this.cellTitle.setText(str);
    }

    public void updateGuideIcon(String str) {
        if (this.canShowIcon) {
            if (TextUtils.isEmpty(str)) {
                this.cellGuideLayout.setVisibility(8);
            } else {
                this.cellGuideLayout.setVisibility(0);
                gr2.j().h(str, this.cellGuideIcon, bq6.s());
            }
        }
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

    public TabCellView4(@NonNull Context context, int i) {
        this(context, (AttributeSet) null);
        this.mType = i;
    }

    public TabCellView4(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabCellView4(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canShowBadge = true;
        this.canShowRedDot = true;
        this.canShowNew = true;
        this.canShowIcon = true;
        this.canShowLabel = true;
        init(context, attributeSet);
    }

    public void updateGuideIcon(Drawable drawable) {
        if (this.canShowIcon) {
            if (drawable == null) {
                this.cellGuideLayout.setVisibility(8);
            } else {
                this.cellGuideLayout.setVisibility(0);
                this.cellGuideIcon.setImageDrawable(drawable);
            }
        }
    }

    @Override // defpackage.yz
    public void onEntranceClick() {
    }

    @Override // defpackage.yz
    public void setBubble(CellItem cellItem) {
    }
}
