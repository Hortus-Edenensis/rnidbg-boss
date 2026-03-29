package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.SearchUserActivity;
import com.zenmen.palmchat.contacts.SearchUserActivityV2;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class c45 extends DefaultCellViewController {
    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_dynamic_cell_searchnumber;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        if (l50.a()) {
            return;
        }
        activity.startActivity(new Intent(AppContext.getContext(), (Class<?>) (jo6.A() ? SearchUserActivityV2.class : SearchUserActivity.class)));
    }
}
