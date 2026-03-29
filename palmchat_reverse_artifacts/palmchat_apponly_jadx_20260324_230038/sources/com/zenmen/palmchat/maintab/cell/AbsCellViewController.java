package com.zenmen.palmchat.maintab.cell;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.annotation.Keep;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import defpackage.a00;
import defpackage.uk5;
import defpackage.zz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public abstract class AbsCellViewController implements zz {
    public static final String TAG = "com.zenmen.palmchat.maintab.cell.AbsCellViewController";
    protected DynamicConfigFragment fragment;
    protected GroupItem groupItem;
    protected CellItem item;
    protected a00 status = new a00();
    protected TabItem tabItem;

    @Override // defpackage.zz
    public CellItem getCellItem() {
        return this.item;
    }

    public abstract /* synthetic */ int getDefaultIconResId();

    @Override // defpackage.zz
    public GroupItem getGroupItem() {
        return this.groupItem;
    }

    @Override // defpackage.zz
    public abstract /* synthetic */ View getView();

    @Override // defpackage.zz
    public a00 getViewStatus() {
        return this.status;
    }

    @Override // defpackage.zz
    public abstract /* synthetic */ void onActivityResult(int i, int i2, Intent intent);

    @Override // defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        this.fragment = dynamicConfigFragment;
        this.tabItem = tabItem;
        this.groupItem = groupItem;
        this.item = cellItem;
    }

    @Override // defpackage.zz
    public abstract /* synthetic */ void onDestroyView();

    @Override // defpackage.zz
    public abstract /* synthetic */ void onPause();

    @Override // defpackage.zz
    public abstract /* synthetic */ void onResume();

    @Override // defpackage.zz
    public abstract /* synthetic */ void onStatusChanged(uk5 uk5Var);

    @Override // defpackage.zz
    public abstract /* synthetic */ void processOnClick(Activity activity, CellItem cellItem);

    @Override // defpackage.zz
    public abstract /* synthetic */ void setUserVisibleHint(boolean z);

    public abstract /* synthetic */ void updateViewStatus(a00 a00Var);
}
