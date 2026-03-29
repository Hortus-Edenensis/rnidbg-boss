package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class p7 extends DefaultCellViewController {
    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_dynamic_cell_phone;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        if (l50.a()) {
            return;
        }
        if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
            AppContext.getContext().getTrayPreferences().i(k86.n(), true);
        }
        Intent intentA = on0.a("upload_contact_from_discover");
        LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "281", "1", null, null);
        activity.startActivity(intentA);
    }
}
