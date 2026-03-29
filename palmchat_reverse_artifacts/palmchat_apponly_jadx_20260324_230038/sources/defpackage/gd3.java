package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.sync.MyTabOfFriendTabConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class gd3 extends uw0 {
    public lt3 c;

    public final void d() {
        this.c = new lt3(this.mContext);
    }

    public final void e() {
        yz yzVar;
        lt3 lt3Var = this.c;
        if (lt3Var == null || lt3Var.d() == null || (yzVar = this.mView) == null) {
            return;
        }
        yzVar.setLabel(this.c.d().cell_love_marriage_hl);
        this.mView.setSubTitleLabel(this.c.d().cell_love_marriage_shl);
        if (this.c.f(MyTabOfFriendTabConfig.SP_MARRY_AND_FRIEND)) {
            this.mView.setUnread(-1);
        } else {
            this.mView.setUnread(0);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_dynamic_cell_quiz;
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        d();
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        e();
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        super.processOnClick(activity, cellItem);
        lt3 lt3Var = this.c;
        if (lt3Var != null) {
            lt3Var.q(MyTabOfFriendTabConfig.SP_MARRY_AND_FRIEND);
        }
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            e();
        }
    }
}
