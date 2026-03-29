package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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
import defpackage.il5;
import defpackage.yz;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabCellView7 extends FrameLayout implements yz {
    private boolean canShowBadge;
    private boolean canShowIcon;
    private boolean canShowLabel;
    private boolean canShowNew;
    private boolean canShowRedDot;
    public EffectiveShapeView cellGuideIcon;
    public View cellGuideLayout;
    public ImageView cellIcon;
    public com.zenmen.palmchat.mine.view.LoopTextView cellSubtitleLabel;
    public TextView cellTitle;
    public TabCellUnReadView cellUnReadView;
    public RelativeLayout mItemLayout;

    public TabCellView7(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.layout_cell_view_tab_item7, (ViewGroup) this, true);
        this.mItemLayout = (RelativeLayout) findViewById(R.id.cell_item_layout);
        this.cellIcon = (ImageView) findViewById(R.id.cell_icon);
        this.cellTitle = (TextView) findViewById(R.id.cell_title);
        this.cellUnReadView = (TabCellUnReadView) findViewById(R.id.cell_unread);
        this.cellSubtitleLabel = (com.zenmen.palmchat.mine.view.LoopTextView) findViewById(R.id.cell_label_sutitle);
        this.cellGuideLayout = findViewById(R.id.cell_guide_layout);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.cell_guide_icon);
        this.cellGuideIcon = effectiveShapeView;
        effectiveShapeView.changeShapeType(3);
        this.cellGuideIcon.setDegreeForRoundRectangle(13, 13);
        this.cellSubtitleLabel.setCompoundDrawableInfo(true, context.getResources().getDrawable(R.drawable.ic_red_packet_small));
        this.cellSubtitleLabel.setText(12.0f, 0, Color.parseColor("#666666"), 8388629);
        this.cellSubtitleLabel.setTextStillTime(3000L);
        this.cellSubtitleLabel.setAnimTime(300L);
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
            if (!il5.l(string3)) {
                string2 = string3;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(string2);
            updateCellSubtitleLabel(arrayList);
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
        return null;
    }

    public TextView getLabelView() {
        return null;
    }

    public com.zenmen.palmchat.mine.view.LoopTextView getLoopTextViewView() {
        return this.cellSubtitleLabel;
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
    public void setNoticeType(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.canShowBadge = z;
        this.canShowRedDot = z2;
        this.canShowNew = z3;
        this.canShowIcon = z4;
        this.canShowLabel = z5;
    }

    @Override // defpackage.yz
    public void setSubTitleLabel(String str) {
    }

    @Override // defpackage.yz
    public void setTitle(String str) {
        updateCellTitle(str);
    }

    @Override // defpackage.yz
    public void setUnread(int i) {
        updateUnReadView(i);
    }

    public void updateCellIcon(Drawable drawable) {
        this.cellIcon.setImageDrawable(drawable);
    }

    public void updateCellSubtitleLabel(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.cellSubtitleLabel.setVisibility(8);
            return;
        }
        this.cellSubtitleLabel.setVisibility(0);
        this.cellSubtitleLabel.stopAutoScroll();
        if (arrayList.size() <= 1) {
            this.cellSubtitleLabel.setNoAnim();
            this.cellSubtitleLabel.setText(arrayList.get(0));
        } else {
            this.cellSubtitleLabel.setAnim();
            this.cellSubtitleLabel.setTextList(arrayList);
            this.cellSubtitleLabel.startAutoScroll();
        }
    }

    public void updateCellTitle(String str) {
        this.cellTitle.setText(str);
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

    public void updateUnReadView(int i) {
        if (i != -2 || this.canShowNew) {
            if (i != -1 || this.canShowRedDot) {
                if (i <= 0 || this.canShowBadge) {
                    this.cellUnReadView.updateView(i);
                }
            }
        }
    }

    public TabCellView7(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSubTitleLabel(ArrayList<String> arrayList) {
        updateCellSubtitleLabel(arrayList);
    }

    public TabCellView7(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canShowBadge = true;
        this.canShowRedDot = true;
        this.canShowNew = true;
        this.canShowIcon = true;
        this.canShowLabel = true;
        init(context, attributeSet);
    }

    @Override // defpackage.yz
    public void onEntranceClick() {
    }

    @Override // defpackage.yz
    public void setBubble(CellItem cellItem) {
    }

    @Override // defpackage.yz
    public void setLabel(String str) {
    }
}
