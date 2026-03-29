package com.zenmen.palmchat.handinhand.v3;

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
import com.zenmen.palmchat.widget.TabCellUnReadView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.yz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class HandInHandV3CellView extends FrameLayout implements yz {
    private boolean canShowBadge;
    private boolean canShowIcon;
    private boolean canShowLabel;
    private boolean canShowNew;
    private boolean canShowRedDot;
    public ImageView cellIcon;
    public TextView cellSubTitle;
    public TextView cellTitle;
    public TabCellUnReadView cellUnReadView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (HandInHandV3CellView.this.getWidth() == 0 || HandInHandV3CellView.this.cellUnReadView.getWidth() == 0) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) HandInHandV3CellView.this.cellUnReadView.getLayoutParams();
            if (layoutParams.leftMargin != (-HandInHandV3CellView.this.cellUnReadView.getWidth()) / 2) {
                layoutParams.leftMargin = (-HandInHandV3CellView.this.cellUnReadView.getWidth()) / 2;
                layoutParams.topMargin = (-HandInHandV3CellView.this.cellUnReadView.getHeight()) / 2;
                HandInHandV3CellView.this.cellUnReadView.setLayoutParams(layoutParams);
            }
        }
    }

    public HandInHandV3CellView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        this.cellIcon = (ImageView) findViewById(R.id.cell_icon);
        TextView textView = (TextView) findViewById(R.id.cell_title);
        this.cellTitle = textView;
        textView.setSingleLine();
        TextView textView2 = (TextView) findViewById(R.id.cell_subtitle);
        this.cellSubTitle = textView2;
        textView2.setSingleLine();
        this.cellUnReadView = (TabCellUnReadView) findViewById(R.id.cell_unread);
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
        addOnLayoutChangeListener(new a());
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
        return R.layout.layout_cell_view_tab_handinhand_v3_item;
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

    public void updateCellSubTitle(String str) {
        this.cellSubTitle.setText(str);
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

    public HandInHandV3CellView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void updateCellSubTitle(CharSequence charSequence) {
        this.cellSubTitle.setText(charSequence);
    }

    public HandInHandV3CellView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canShowBadge = true;
        this.canShowRedDot = true;
        this.canShowNew = true;
        this.canShowIcon = true;
        this.canShowLabel = true;
        init(context, attributeSet);
    }

    @Override // defpackage.yz
    public void setBubble(CellItem cellItem) {
    }

    @Override // defpackage.yz
    public void setLabel(String str) {
    }

    @Override // defpackage.yz
    public void setSubTitleLabel(String str) {
    }

    @Override // defpackage.yz
    public void onEntranceClick() {
    }

    @Override // defpackage.yz
    public void setGuideIcon(String str, Integer num) {
    }
}
