package com.zenmen.palmchat.maintab.cell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.CellViewControllerManager;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.TabCellView2;
import com.zenmen.palmchat.widget.TabCellView3;
import com.zenmen.palmchat.widget.TabCellView4;
import com.zenmen.palmchat.widget.TabCellView5;
import com.zenmen.palmchat.widget.TabCellView6;
import com.zenmen.palmchat.widget.TabCellView7;
import com.zenmen.palmchat.widget.TabCellViewNew;
import defpackage.a00;
import defpackage.f22;
import defpackage.uk5;
import defpackage.yz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DefaultCellViewController extends AbsCellViewController {
    public static final String TAG = "com.zenmen.palmchat.maintab.cell.DefaultCellViewController";
    public Context mContext;
    protected yz mView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicConfigFragment f14608a;
        public final /* synthetic */ yz b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ CellItem d;

        public a(DynamicConfigFragment dynamicConfigFragment, yz yzVar, Activity activity, CellItem cellItem) {
            this.f14608a = dynamicConfigFragment;
            this.b = yzVar;
            this.c = activity;
            this.d = cellItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f22 f22VarZ = this.f14608a.Z();
            DefaultCellViewController defaultCellViewController = DefaultCellViewController.this;
            f22VarZ.m(defaultCellViewController, defaultCellViewController.getViewStatus());
            if (view instanceof yz) {
                this.b.onEntranceClick();
            }
            DefaultCellViewController.this.processOnClick(this.c, this.d);
        }
    }

    private void syncStatusFromView() {
        this.status.f1127a = this.mView.getCellUnReadView().getVisibility() == 0 ? this.mView.getCellUnReadView().getViewStatus() : 0;
        this.status.b = this.mView.getLabel();
        this.status.g = this.mView.isShowGuideIcon();
        this.status.h = this.mView.isBubbleShow();
    }

    public yz createView(Context context, GroupItem groupItem, CellItem cellItem) {
        int i = groupItem.styleType;
        return i == 0 ? new TabCellView2(context) : i == 1 ? new TabCellView3(context) : i == 3 ? CellViewControllerManager.BuildInType.TASK_CENTER.key.equals(cellItem.tag) ? new TabCellView7(context) : new TabCellView4(context) : i == 4 ? new TabCellView5(context) : i == 5 ? CellViewControllerManager.BuildInType.TASK_CENTER.key.equals(cellItem.tag) ? new TabCellView7(context) : new TabCellView6(context) : i == 8 ? new TabCellViewNew(context) : new TabCellView6(context);
    }

    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        int i;
        GroupItem groupItem = this.groupItem;
        return (groupItem == null || (i = groupItem.styleType) == 0) ? R.drawable.icon_tab_cell_default : (i == 1 || i == 8) ? R.drawable.icon_tab_cell_default2 : R.drawable.icon_tab_cell_default;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public View getView() {
        return (View) this.mView;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public a00 getViewStatus() {
        syncStatusFromView();
        return this.status;
    }

    public boolean isDefaultItem() {
        String name = getClass().getName();
        String str = TAG;
        boolean zEquals = name.equals(str);
        LogUtil.i(str, "isDefaultItem " + getClass().getName() + zEquals);
        return zEquals;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        FragmentActivity activity = dynamicConfigFragment.getActivity();
        this.mContext = activity;
        yz yzVarCreateView = createView(activity, groupItem, cellItem);
        a00 a00VarA = a00.a(cellItem);
        this.status = a00VarA;
        Boolean[] boolArrA = CellItem.b.a(a00VarA.f);
        yzVarCreateView.setNoticeType(boolArrA[0].booleanValue(), boolArrA[1].booleanValue(), boolArrA[2].booleanValue(), boolArrA[3].booleanValue(), boolArrA[4].booleanValue(), boolArrA[5].booleanValue());
        yzVarCreateView.setTitle(this.status.c);
        yzVarCreateView.setUnread(this.status.f1127a);
        yzVarCreateView.setBubble(cellItem);
        yzVarCreateView.setIcon(null, Integer.valueOf(getDefaultIconResId()));
        if (!TextUtils.isEmpty(this.status.d)) {
            yzVarCreateView.setIcon(this.status.d, null);
        }
        yzVarCreateView.setGuideIcon(this.status.e, getDefaultGuideIconResId());
        this.mView = yzVarCreateView;
        getView().setOnClickListener(new a(dynamicConfigFragment, yzVarCreateView, activity, cellItem));
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        CellItem cellItem;
        yz yzVar = this.mView;
        if (yzVar == null || (cellItem = this.item) == null) {
            return;
        }
        yzVar.setBubble(cellItem);
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public void updateViewStatus(a00 a00Var) {
        this.mView.setTitle(a00Var.c);
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onPause() {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
