package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.CellViewControllerManager;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.cell.cellstatus.CellStatusContent;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class uw0 extends DefaultCellViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean[] f21305a = null;
    public CellStatusContent b = null;

    public final String a(CellItem cellItem) {
        String str = cellItem.turnInfo.url;
        boolean zA = jo6.a("LX-31481", false);
        CellStatusContent cellStatusContent = this.b;
        String str2 = cellStatusContent != null ? cellStatusContent.url : null;
        if (zA && !TextUtils.isEmpty(str2) && CellViewControllerManager.e(str2)) {
            str = str2;
        }
        LogUtil.i(DefaultCellViewController.TAG, "getJumpUrl ori" + cellItem.turnInfo.url + " taichi" + zA + " currentCellStatus" + this.b + " currentCellStatusUrl=" + str2);
        return str;
    }

    public final boolean b() {
        Boolean[] boolArr = this.f21305a;
        if (boolArr != null && boolArr.length > 0 && boolArr[2].booleanValue()) {
            if (nx3.a("dynamic_deeplink_cell_" + this.item.tag)) {
                return true;
            }
        }
        return false;
    }

    public void c(boolean z) {
        String str;
        boolean zB = b();
        CellItem cellItem = this.item;
        CellStatusContent cellStatusContentB = (cellItem == null || (str = cellItem.appId) == null) ? null : y31.b(str);
        if (cellStatusContentB != null) {
            this.mView.setUnread(cellStatusContentB.computeUnreadStatus(zB));
            this.mView.setLabel(cellStatusContentB.label);
            this.mView.setGuideIcon(cellStatusContentB.iconUrl, null);
        } else {
            if (zB) {
                this.mView.setUnread(-2);
            } else {
                this.mView.setUnread(0);
            }
            this.mView.setLabel(null);
            this.mView.setGuideIcon(null, null);
        }
        this.b = cellStatusContentB;
        if (z) {
            ds0.a().b(CellUpdateEvent.produceEvent(5, null));
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        if (this.mView != null) {
            Boolean[] boolArrA = CellItem.b.a(this.status.f);
            this.f21305a = boolArrA;
            this.mView.setNoticeType(boolArrA[0].booleanValue(), this.f21305a[1].booleanValue(), this.f21305a[2].booleanValue(), this.f21305a[3].booleanValue(), this.f21305a[4].booleanValue(), this.f21305a[5].booleanValue());
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        c(false);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
        CellItem cellItem;
        String str;
        super.onStatusChanged(uk5Var);
        if (uk5Var == null || uk5Var.f21235a != 40 || (cellItem = this.item) == null || (str = cellItem.appId) == null || !str.equals(uk5Var.d)) {
            return;
        }
        c(true);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        String str;
        if (cellItem == null || cellItem.turnInfo == null) {
            return;
        }
        nx3.e("dynamic_deeplink_cell_" + cellItem.tag);
        CellItem cellItem2 = this.item;
        if (cellItem2 != null && (str = cellItem2.appId) != null) {
            y31.a(str);
        }
        if (TurnInfo.TYPE_DEEP_LINK.equals(cellItem.turnInfo.type)) {
            FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) activity;
            Intent intentP = ve.p(frameworkBaseActivity, cellItem.turnInfo.url);
            if (intentP != null) {
                if (activity instanceof MainTabsActivity) {
                    intentP.putExtra("source_tab_tag", MainTabsActivity.y2());
                    intentP.putExtra("source_page_tag", cellItem.tag);
                }
                try {
                    activity.startActivity(intentP);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            String strA = a(cellItem);
            if (ve.q(frameworkBaseActivity, strA)) {
                return;
            }
            if ("appCenter".equals(cellItem.tag)) {
                ap3.q(this.mContext, "2");
            } else {
                ve.s(frameworkBaseActivity, strA, cellItem.turnInfo.showMenu);
            }
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}
