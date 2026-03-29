package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface zz {
    CellItem getCellItem();

    GroupItem getGroupItem();

    View getView();

    a00 getViewStatus();

    void onActivityResult(int i, int i2, Intent intent);

    void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem);

    void onDestroyView();

    void onPause();

    void onResume();

    void onStatusChanged(uk5 uk5Var);

    void processOnClick(Activity activity, CellItem cellItem);

    void setUserVisibleHint(boolean z);
}
