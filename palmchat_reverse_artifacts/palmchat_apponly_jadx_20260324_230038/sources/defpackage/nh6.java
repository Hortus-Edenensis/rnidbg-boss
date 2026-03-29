package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.widget.TabCellView5;
import com.zenmen.palmchat.widget.TabCellView6;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nh6 extends uw0 {
    public lt3 c;
    public String d = null;
    public boolean e = false;

    @Override // defpackage.uw0
    public void c(boolean z) {
        lt3 lt3Var;
        super.c(z);
        d();
        yz yzVar = this.mView;
        if (yzVar instanceof TabCellView5) {
            ((TabCellView5) yzVar).getWaveView().start();
        }
        if (!(this.mView instanceof TabCellView6) || (lt3Var = this.c) == null) {
            return;
        }
        String strP = lt3Var.p();
        if (TextUtils.isEmpty(strP)) {
            this.mView.setSubTitleLabel("生活无趣？听听别人都在聊什么～");
        } else {
            this.mView.setSubTitleLabel(strP);
        }
    }

    public final void d() {
        if (this.mView == null) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        if (!this.e) {
            this.d = SPUtil.f14322a.n(SPUtil.SCENE.FIND_FRIEND_TAB, "key_find_friend_room_click_day", "");
            this.e = true;
        }
        if (TextUtils.equals(this.d, simpleDateFormat.format(date))) {
            this.mView.setUnread(0);
        } else {
            this.mView.setUnread(-1);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_voice_room_enter;
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        this.c = new lt3(this.mContext);
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        c(false);
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        super.processOnClick(activity, cellItem);
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        this.d = str;
        SPUtil.f14322a.t(SPUtil.SCENE.FIND_FRIEND_TAB, "key_find_friend_room_click_day", str);
        this.mView.setUnread(0);
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        c(false);
    }
}
