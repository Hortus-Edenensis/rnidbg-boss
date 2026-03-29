package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.widget.TabCellView4;
import com.zenmen.palmchat.widget.TabCellView6;
import com.zenmen.square.show.ShowMainActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class x65 extends DefaultCellViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yz f21889a;

    public final boolean a() {
        return Math.abs(SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, "key_main_tab_show_click_time", 0L) - ir5.b()) >= 259200000;
    }

    public final void b(boolean z) {
        yz yzVar = (yz) getView();
        this.f21889a = yzVar;
        if (yzVar == null || !(yzVar instanceof yz)) {
            return;
        }
        this.f21889a.setUnread(a() ? -1 : 0);
        this.f21889a.setLabel("这是你的舞台, 尽情闪耀吧");
        yz yzVar2 = this.f21889a;
        if (yzVar2 instanceof TabCellView4) {
            ((TabCellView4) yzVar2).updateCellSubtitleLabel("这是你的舞台, 尽情闪耀吧");
        } else if (yzVar2 instanceof TabCellView6) {
            ((TabCellView6) yzVar2).updateCellSubtitleLabel("这是你的舞台, 尽情闪耀吧");
        }
        this.f21889a.setSubTitleLabel("这是你的舞台, 尽情闪耀吧");
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_dynamic_cell_show;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        b(false);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        if (l50.a()) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_main_tab_show_click_time", Long.valueOf(ir5.b()));
        ShowMainActivity.E1(100, activity);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}
