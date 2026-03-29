package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.cell.DynamicCellListActivity;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dr3 extends DefaultCellViewController {
    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        GroupItem groupItem = this.groupItem;
        if (groupItem != null) {
            int i = groupItem.styleType;
            if (i == 0) {
                return R.drawable.icon_tab_cell_more;
            }
            if (i == 1) {
                return R.drawable.icon_tab_cell_all;
            }
        }
        return super.getDefaultIconResId();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        super.processOnClick(activity, cellItem);
        Intent intent = new Intent(activity, (Class<?>) DynamicCellListActivity.class);
        intent.putExtra("extra_group_name", this.tabItem.getNameForShow());
        intent.putExtra("extra_group_info", this.groupItem);
        activity.startActivity(intent);
    }
}
