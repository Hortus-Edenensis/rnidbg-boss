package defpackage;

import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.widget.TabCellUnReadView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface yz {
    TabCellUnReadView getCellUnReadView();

    String getLabel();

    int getUnread();

    boolean isBubbleShow();

    boolean isShowGuideIcon();

    void onEntranceClick();

    void setBubble(CellItem cellItem);

    void setGuideIcon(String str, Integer num);

    void setIcon(String str, Integer num);

    void setLabel(String str);

    void setNoticeType(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    void setSubTitleLabel(String str);

    void setTitle(String str);

    void setUnread(int i);
}
