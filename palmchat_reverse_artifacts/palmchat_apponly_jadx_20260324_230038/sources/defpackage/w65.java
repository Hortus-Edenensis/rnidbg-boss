package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingConfig;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.sync.MyTabOfFriendTabConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.TabCellView4;
import com.zenmen.palmchat.widget.TabCellView6;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class w65 extends DefaultCellViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lt3 f21630a;

    public final void a() {
        this.f21630a = new lt3(this.mContext);
    }

    public final void b(boolean z) {
        lt3 lt3Var;
        yz yzVar = (yz) getView();
        this.mView = yzVar;
        if (yzVar == null || !(yzVar instanceof yz) || (lt3Var = this.f21630a) == null) {
            return;
        }
        if (lt3Var.o() > 0) {
            this.mView.getCellUnReadView().updateView(this.f21630a.o());
        } else if (this.f21630a.f(MyTabOfFriendTabConfig.SP_PEOPLENEARBY_VALUE)) {
            this.mView.getCellUnReadView().updateView(-1);
        } else {
            this.mView.getCellUnReadView().updateView(0);
        }
        int iNextInt = new Random().nextInt(5) + 1;
        String[] strArrH = this.f21630a.h();
        String str = strArrH[0];
        String str2 = strArrH[1];
        if (str.contains(AiGreetingConfig.COUNT_FLAG)) {
            this.mView.setLabel(str.replace(AiGreetingConfig.COUNT_FLAG, String.valueOf(this.f21630a.o())));
        } else {
            this.mView.setLabel(str);
        }
        if (str2.contains("{nickname}")) {
            this.mView.setSubTitleLabel(str2.replace("{nickname}", this.f21630a.l()));
        } else if (str2.contains(AiGreetingConfig.COUNT_FLAG)) {
            yz yzVar2 = this.mView;
            if (yzVar2 instanceof TabCellView4) {
                ((TabCellView4) yzVar2).updateCellSubtitleLabel(str2.replace(AiGreetingConfig.COUNT_FLAG, String.valueOf(iNextInt)));
            } else if (yzVar2 instanceof TabCellView6) {
                ((TabCellView6) yzVar2).updateCellSubtitleLabel(str2.replace(AiGreetingConfig.COUNT_FLAG, String.valueOf(iNextInt)));
            }
            this.mView.setSubTitleLabel(str2.replace(AiGreetingConfig.COUNT_FLAG, String.valueOf(iNextInt)));
        } else if ((this.mView instanceof TabCellView6) && il5.l(str2)) {
            ((TabCellView6) this.mView).setSubTitleLabel(str);
        } else {
            this.mView.setSubTitleLabel(str2);
        }
        if (z) {
            ds0.a().b(CellUpdateEvent.produceEvent(8, null));
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_dynamic_cell_default;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public a00 getViewStatus() {
        syncStatusFromView();
        return super.getViewStatus();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        a();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        b(false);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
        int i = uk5Var.f21235a;
        if (i == 9 || i == 11 || i == 33 || i == 16) {
            b(true);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        if (l50.a()) {
            return;
        }
        if (!TextUtils.isEmpty(AccountUtils.p(AppContext.getContext()))) {
            u13.b().a();
            Intent intentC = st2.c();
            Bundle bundle = new Bundle();
            bundle.putString("source_tab_tag", MainTabsActivity.y2());
            bundle.putString("source_page_tag", this.item.tag);
            intentC.putExtras(bundle);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), BaseWrapper.ENTER_ID_OAPS_DEMO, "1", null, null);
            zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_near_31", null, null);
            intentC.putExtra("fromType", 3);
            activity.startActivity(intentC);
            this.f21630a.q(MyTabOfFriendTabConfig.SP_PEOPLENEARBY_VALUE);
        }
        ip3.c("pagemy_tool_nearby");
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            b(false);
            ip3.d("pagemy_tool_nearby");
        }
    }

    public final void syncStatusFromView() {
        this.status.f1127a = this.mView.getCellUnReadView().getViewStatus();
        this.status.b = this.mView.getLabel();
        this.status.g = this.mView.isShowGuideIcon();
    }
}
