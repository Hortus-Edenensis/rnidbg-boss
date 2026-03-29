package defpackage;

import android.app.Activity;
import android.content.Context;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.handinhand.bean.HandInHandUpdateEvent;
import com.zenmen.palmchat.handinhand.v3.HandInHandV3CellView;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class cg2 extends DefaultCellViewController {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cg2.this.b();
        }
    }

    public final void b() {
        HandInHandV3CellView handInHandV3CellView = (HandInHandV3CellView) getView();
        handInHandV3CellView.setVisibility(dg2.f().e() ? 0 : 8);
        handInHandV3CellView.updateCellSubTitle(dg2.f().g());
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public yz createView(Context context, GroupItem groupItem, CellItem cellItem) {
        return new HandInHandV3CellView(context);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.icon_handinhand_v3;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public a00 getViewStatus() {
        return super.getViewStatus();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        ds0.a().c(this);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
        super.onDestroyView();
        ds0.a().d(this);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        b();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        eg2.a().b(activity);
    }

    @qm5
    public void receivedHandInHandBubbleEvent(HandInHandUpdateEvent handInHandUpdateEvent) {
        if (getView() != null) {
            getView().post(new a());
        }
    }
}
