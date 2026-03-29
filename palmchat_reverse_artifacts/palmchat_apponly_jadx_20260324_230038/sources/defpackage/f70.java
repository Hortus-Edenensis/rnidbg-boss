package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.ui.CircleFindActivity;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class f70 extends DefaultCellViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17471a = false;

    public f70() {
        oc0.g("lx_group_id");
    }

    public final void a() {
        if (!(getView() instanceof yz) || ((yz) getView()).getUnread() == 0) {
            return;
        }
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putLong("key_circle_group_show_status_of_" + AccountUtils.p(AppContext.getContext()), System.currentTimeMillis()).apply();
    }

    public final void b() {
        if (getView() instanceof yz) {
            yz yzVar = (yz) getView();
            long j = SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).getLong("key_circle_group_show_status_of_" + AccountUtils.p(AppContext.getContext()), 0L);
            CircleConfig config = CircleConfig.getConfig();
            if (config == null || config.getGroupTime() <= 0) {
                return;
            }
            if (System.currentTimeMillis() - j > ((long) config.getGroupTime()) * 86400000) {
                yzVar.setUnread(-2);
            } else {
                yzVar.setUnread(0);
            }
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_dynamic_cell_circle;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        if (this.f17471a) {
            oc0.g("lx_richgroup_tab_show");
            b();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        oc0.g("lx_richgroup_tab_click");
        Intent intent = new Intent();
        intent.setClass(getView().getContext(), CircleFindActivity.class);
        intent.putExtra("fromtype", 101);
        getView().getContext().startActivity(intent);
        a();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f17471a = z;
        if (z) {
            oc0.g("lx_richgroup_tab_show");
            b();
        }
    }
}
