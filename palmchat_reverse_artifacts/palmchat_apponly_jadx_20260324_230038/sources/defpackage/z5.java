package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.ad.view.AdViewFrameLayout;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.AbsCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class z5 extends AbsCellViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DynamicConfigFragment f22352a;
    public TabItem b;
    public int c;
    public FrameLayout d;

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return 0;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public View getView() {
        return this.d;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        this.f22352a = dynamicConfigFragment;
        this.b = tabItem;
        this.c = 0;
        Iterator<GroupItem> it = tabItem.groups.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next() == groupItem) {
                this.c = i;
                break;
            }
            i++;
        }
        FragmentActivity activity = dynamicConfigFragment.getActivity();
        AdViewFrameLayout adViewFrameLayout = new AdViewFrameLayout(activity);
        adViewFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int iB = me1.b(activity, 20);
        layoutParams.setMargins(0, 0, 0, me1.b(activity, 12));
        adViewFrameLayout.setPadding(0, iB, 0, iB);
        adViewFrameLayout.setBackground(activity.getResources().getDrawable(R.drawable.shape_gray_round_corner_12dp));
        this.d = adViewFrameLayout;
        if ("tab_mine".equals(tabItem.tag)) {
            this.d.setVisibility(8);
            gp3.a(this.d, this.c);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        TabItem tabItem;
        WifiLog.d("ad setUserVisibleHint isVisibleToUser: " + z);
        TabItem tabItem2 = this.b;
        if (tabItem2 != null && "tab_mine".equals(tabItem2.tag)) {
            gp3.b(z);
        }
        if (!z || this.f22352a == null || (tabItem = this.b) == null) {
            return;
        }
        if ("tab_mine".equals(tabItem.tag)) {
            gp3.k(this.b.tag, this.f22352a.getActivity());
        } else {
            if (this.d == null || !ns5.e(this.b.tag, true)) {
                return;
            }
            this.d.removeAllViews();
            ns5.i(this.b.tag, this.d, this.f22352a.getActivity(), this.c);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public void updateViewStatus(a00 a00Var) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onPause() {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
