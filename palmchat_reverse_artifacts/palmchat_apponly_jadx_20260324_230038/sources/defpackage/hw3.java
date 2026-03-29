package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.fragment.FeedsFragment;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hw3 extends zt1 {
    public hw3(FeedsFragment feedsFragment, yt1 yt1Var) {
        super(feedsFragment, yt1Var);
    }

    @Override // com.zenmen.listui.list.a
    public RecyclerView.LayoutManager n() {
        return ((FeedsFragment) this.f11844a).Y();
    }
}
