package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.TabCellView;
import com.zenmen.square.activity.SquareCircleActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pq3 extends DefaultCellViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20078a = "MomentsCellViewController";

    public final void a(boolean z) {
        yz yzVar = (yz) getView();
        if (nx3.a("key_moments")) {
            yzVar.setUnread(-1);
        } else {
            int iW = ch.s().w();
            if (iW > 0) {
                yzVar.setUnread(iW);
            } else {
                yzVar.setUnread(0);
            }
        }
        String strX = ch.s().x();
        if (TextUtils.isEmpty(strX)) {
            yzVar.setGuideIcon(null, null);
        } else {
            yzVar.setGuideIcon(strX, null);
        }
        if (yzVar instanceof TabCellView) {
            if (ch.s().v() > 0) {
                ((TabCellView) yzVar).showUnSend(true);
            } else {
                ((TabCellView) yzVar).showUnSend(false);
            }
        }
        yzVar.setLabel("");
        if (z) {
            ds0.a().b(CellUpdateEvent.produceEvent(4, null));
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_moments;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public a00 getViewStatus() {
        return super.getViewStatus();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        a(false);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
        super.onStatusChanged(uk5Var);
        switch (uk5Var.f21235a) {
            case 17:
                LogUtil.i(f20078a, "TYPE_MOMENTS_COMMENT_COUNT_CHANGED");
                a(true);
                break;
            case 18:
                LogUtil.i(f20078a, "TYPE_MOMENTS_NEW_POST");
                a(true);
                break;
            case 19:
                LogUtil.i(f20078a, "TYPE_MOMENTS_UNSEND");
                a(true);
                break;
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        SquareCircleActivity.A1(activity);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            a(true);
        }
    }
}
