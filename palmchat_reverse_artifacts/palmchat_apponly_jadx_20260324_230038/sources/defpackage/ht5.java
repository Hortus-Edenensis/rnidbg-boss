package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.mine.view.LoopTextView;
import com.zenmen.palmchat.widget.TabCellView7;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ht5 extends uw0 {
    public boolean d;
    public ArrayList<String> e;
    public Activity h;
    public boolean c = false;
    public String f = null;
    public boolean g = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements LoopTextView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicConfigFragment f18051a;
        public final /* synthetic */ CellItem b;

        public a(DynamicConfigFragment dynamicConfigFragment, CellItem cellItem) {
            this.f18051a = dynamicConfigFragment;
            this.b = cellItem;
        }

        @Override // com.zenmen.palmchat.mine.view.LoopTextView.d
        public void a() {
            ht5.this.processOnClick(this.f18051a.getActivity(), this.b);
        }
    }

    @Override // defpackage.uw0
    public void c(boolean z) {
        super.c(z);
        if (this.mView instanceof TabCellView7) {
            if (!q42.a() || !this.d) {
                ((TabCellView7) this.mView).setVisibility(8);
                return;
            }
            e();
            ((TabCellView7) this.mView).setVisibility(0);
            ((TabCellView7) this.mView).setSubTitleLabel(this.e);
            this.mView.setTitle(this.mContext.getString(R.string.my_tab_task_center));
            ip3.d("pagemy_task");
        }
    }

    public final void e() {
        if (this.mView == null) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        if (!this.g) {
            this.f = SPUtil.f14322a.n(SPUtil.SCENE.TASK_CENTER, "key_task_center_click_day", "");
            this.g = true;
        }
        if (TextUtils.equals(this.f, simpleDateFormat.format(date))) {
            this.mView.setUnread(0);
        } else {
            this.mView.setUnread(-1);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return R.drawable.ic_task_center_enter;
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        this.h = dynamicConfigFragment.getActivity();
        yz yzVar = this.mView;
        if (yzVar == null || !(yzVar instanceof TabCellView7)) {
            return;
        }
        LoopTextView loopTextView = ((TabCellView7) yzVar).cellSubtitleLabel;
        if (loopTextView != null) {
            loopTextView.setOnItemClickListener(new a(dynamicConfigFragment, cellItem));
        }
        ((TabCellView7) this.mView).setVisibility(8);
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        super.onResume();
        d();
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
        try {
            ve.o(this.h, "zenxin://activity?page=a0052&pkgId=task", false);
            String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
            this.f = str;
            SPUtil.f14322a.t(SPUtil.SCENE.TASK_CENTER, "key_task_center_click_day", str);
            this.mView.setUnread(0);
            ip3.c("pagemy_task");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.uw0, com.zenmen.palmchat.maintab.cell.DefaultCellViewController, com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            d();
        }
    }

    public void d() {
    }
}
