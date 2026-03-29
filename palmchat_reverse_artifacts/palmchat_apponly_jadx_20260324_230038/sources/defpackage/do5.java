package defpackage;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumActivity;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class do5 extends ao5 {
    public do5(ViewGroup viewGroup, SuperExposeNumActivity superExposeNumActivity) {
        super(viewGroup, superExposeNumActivity);
    }

    @Override // defpackage.ao5
    public void f(ViewGroup viewGroup) {
        this.f1537a = 2;
        this.e = viewGroup.findViewById(R.id.distance_all_view);
        this.c = (RecyclerView) viewGroup.findViewById(R.id.distance_super_expose_num_content);
        this.d = viewGroup.findViewById(R.id.distance_super_content_failed);
    }

    @Override // defpackage.ao5
    public void h(int i) {
        if (i == 0) {
            boolean zP = a46.p();
            LogUtil.d("", "MsgTabTaijiModelManager SuperExposeMsgTabDistanceView locationPerMission " + zP);
            if (!zP) {
                sy5.h(this.h, "您未开启定位或未授权地理位置，无法使用此服务", 1);
                return;
            }
        }
        super.h(i);
    }
}
