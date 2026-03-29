package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yf2 extends DefaultCellViewController {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yf2.this.b(false);
        }
    }

    public final void b(boolean z) {
        yz yzVar = (yz) getView();
        int i = 0;
        yzVar.getCellUnReadView().setVisibility(zf2.e().g() ? 0 : 8);
        yzVar.setTitle(bg2.b());
        yzVar.setIcon(bg2.a(), Integer.valueOf(getDefaultIconResId()));
        try {
            JSONObject jSONObject = new JSONObject();
            if (!zf2.e().g()) {
                i = 1;
            }
            jSONObject.put("red_point", i);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "sls_show", "1", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController
    public Integer getDefaultGuideIconResId() {
        return null;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.icon_handinhand;
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
        b(false);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        if (l50.a()) {
            return;
        }
        String strC = bg2.c();
        if (!TextUtils.isEmpty(strC)) {
            Intent intent = new Intent();
            intent.setClass(activity, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", strC);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("landingurl", strC);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "sls_click", "1", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @qm5
    public void receivedThreadsBubbleEventEvent(ThreadsBubbleEvent threadsBubbleEvent) {
        if (getView() == null) {
            return;
        }
        getView().post(new a());
    }
}
