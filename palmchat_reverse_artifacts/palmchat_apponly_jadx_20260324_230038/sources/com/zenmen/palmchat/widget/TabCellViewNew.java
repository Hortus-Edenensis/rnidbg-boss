package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.config.CellItem;
import defpackage.gr2;
import defpackage.ir5;
import defpackage.je1;
import defpackage.k86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabCellViewNew extends TabCellView2 {
    private CellItem bubble;

    public TabCellViewNew(@NonNull Context context) {
        super(context);
    }

    private String getClickKey(CellItem cellItem) {
        return k86.a("key_mine_tab_item_bubble_click_time") + "_type_" + cellItem.tag;
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2
    public int getLayoutId() {
        return R.layout.layout_cell_view_tab_item_new;
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2, defpackage.yz
    public int getUnread() {
        return super.getUnread();
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2, defpackage.yz
    public boolean isBubbleShow() {
        return this.mCellLabelRelativelayout.getVisibility() == 0;
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2, defpackage.yz
    public void onEntranceClick() {
        if (this.mCellLabelRelativelayout.getVisibility() == 0) {
            this.mCellLabelRelativelayout.setVisibility(8);
            CellItem cellItem = this.bubble;
            if (cellItem != null) {
                SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, getClickKey(cellItem), Long.valueOf(ir5.b()));
            }
        }
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2, defpackage.yz
    public void setBubble(CellItem cellItem) {
        int i;
        if (this.canShowBubble) {
            if (!(!TextUtils.isEmpty(cellItem.desc) && (i = cellItem.noticeGapMinutes) > 0 && Math.abs(SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, getClickKey(cellItem), 0L) - ir5.b()) >= (((long) i) * 60) * 1000)) {
                this.mCellLabelRelativelayout.setVisibility(8);
                return;
            }
            this.bubble = cellItem;
            this.mCellLabelRelativelayout.setVisibility(0);
            this.mCellLabel.setText(cellItem.desc);
        }
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2, defpackage.yz
    public void setIcon(String str, Integer num) {
        if (TextUtils.isEmpty(str) && num != null) {
            this.cellIcon.setImageDrawable(getResources().getDrawable(num.intValue()));
        } else {
            gr2.j().h(str, this.cellIcon, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.icon_tab_cell_default2).A(R.drawable.icon_tab_cell_default2).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r());
        }
    }

    public TabCellViewNew(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TabCellViewNew(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2, defpackage.yz
    public void setLabel(String str) {
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2
    public void updateUnReadView(int i) {
    }
}
