package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.invite.ContactInviteFriendsActivity;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.DefaultCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nu2 extends DefaultCellViewController {
    public static boolean a() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.INVITEFRIENDS);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return false;
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return false;
        }
        try {
            return new JSONObject(extra).optBoolean("reddot", false);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void b() {
        yz yzVar = (yz) getView();
        if (nx3.a("key_show_invite_friends") && nx3.a(k86.a("key_show_invite_friends")) && a()) {
            yzVar.setUnread(-1);
        } else {
            yzVar.setUnread(0);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_dynamic_cell_invitefriends;
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        b();
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        Intent intent = new Intent(activity, (Class<?>) ContactInviteFriendsActivity.class);
        intent.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_discover");
        activity.startActivity(intent);
        nx3.e(k86.a("key_show_invite_friends"));
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            b();
        }
    }
}
