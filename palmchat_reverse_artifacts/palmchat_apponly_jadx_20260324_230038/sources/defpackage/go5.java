package defpackage;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class go5 extends ao5 {
    public go5(ViewGroup viewGroup, SuperExposeNumActivity superExposeNumActivity) {
        super(viewGroup, superExposeNumActivity);
    }

    @Override // defpackage.ao5
    public void f(ViewGroup viewGroup) {
        this.f1537a = 1;
        this.e = viewGroup.findViewById(R.id.mind_all_view);
        this.c = (RecyclerView) viewGroup.findViewById(R.id.mind_super_expose_num_content);
        this.d = viewGroup.findViewById(R.id.mind_super_content_failed);
    }
}
