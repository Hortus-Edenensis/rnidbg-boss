package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingConfig;
import com.zenmen.palmchat.contacts.ContactActivity;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.sync.MyTabOfFriendTabConfig;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class v65 extends DefaultCellViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lt3 f21366a;
    public boolean b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f21367a;

        public a(uk5 uk5Var) {
            this.f21367a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f21367a.f21235a;
            if (i == 34) {
                Log.i("MyFriendsCellView", "TYPE_NEW_FRIEND_ITEM_COUNT_CHANGE");
                v65.this.e(true);
                return;
            }
            if (i == 35) {
                Log.i("MyFriendsCellView", "TYPE_ENHANCED_ITEM_COUNT_CHANGE");
                v65.this.e(true);
            } else {
                if (i != 47) {
                    return;
                }
                Log.i("MyFriendsCellView", "TYPE_MY_TAB_MY_FRIEND_CLICK");
                v65 v65Var = v65.this;
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.MYTAB;
                v65Var.b = sPUtil.a(scene, "key_has_load_new_friend", false);
                v65.this.c = sPUtil.a(scene, "key_has_load_may_known", false);
            }
        }
    }

    public final void d() {
        this.f21366a = new lt3(this.mContext);
        ch.s().r().j(this);
    }

    public final void e(boolean z) {
        yz yzVar = (yz) getView();
        this.mView = yzVar;
        if (yzVar == null || !(yzVar instanceof yz)) {
            return;
        }
        if (this.f21366a.n() > 0) {
            this.mView.setUnread(this.f21366a.n());
        } else if (this.f21366a.f(MyTabOfFriendTabConfig.SP_MYFRIENDS_VALUE)) {
            this.mView.setUnread(-1);
        } else {
            this.mView.setUnread(0);
        }
        try {
            String[] strArrG = this.f21366a.g();
            if (strArrG.length <= 0 || !strArrG[0].contains(AiGreetingConfig.COUNT_FLAG)) {
                this.mView.setLabel(strArrG[0]);
            } else {
                this.mView.setLabel(strArrG[0].replace(AiGreetingConfig.COUNT_FLAG, String.valueOf(this.f21366a.n())));
            }
            if (strArrG.length <= 0 || !strArrG[1].contains("{nickname}")) {
                this.mView.setSubTitleLabel(strArrG[1]);
            } else {
                this.mView.setSubTitleLabel(strArrG[1].replace("{nickname}", this.f21366a.k()));
            }
        } catch (Exception unused) {
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 9211 || this.fragment.getActivity() == null) {
            return;
        }
        UserProfileGuide.k(this.fragment.getActivity(), 15);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        d();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
        super.onDestroyView();
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        e(false);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        if (getView() == null) {
            return;
        }
        getView().post(new a(uk5Var));
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        if (l50.a()) {
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) ContactActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("source_tab_tag", MainTabsActivity.y2());
        bundle.putString("source_page_tag", this.item.tag);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 9211);
        this.f21366a.q(MyTabOfFriendTabConfig.SP_MYFRIENDS_VALUE);
        HashMap map = new HashMap();
        map.put(EventParams.KEY_CT_SDK_POSITION, "2");
        ip3.b("pagemy_tool_friend", "click", map);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            e(false);
            HashMap map = new HashMap();
            map.put(EventParams.KEY_CT_SDK_POSITION, "2");
            ip3.b("pagemy_tool_friend", "view", map);
        }
    }

    public final void syncStatusFromView() {
        this.status.f1127a = this.mView.getCellUnReadView().getViewStatus();
        this.status.b = this.mView.getLabel();
        this.status.g = this.mView.isShowGuideIcon();
    }
}
