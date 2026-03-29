package defpackage;

import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseListFragment;
import com.zenmen.listui.list.a;
import com.zenmen.square.mvp.model.bean.SquareBean;
import defpackage.ar;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zi5<V extends BaseListFragment, M extends ar, T extends BaseBean> extends a<V, M, T> {
    public zi5(V v, M m) {
        super(v, m);
    }

    @Override // com.zenmen.listui.list.a
    public void k() {
        List<T> listE;
        if (this.c == null || (listE = this.b.e()) == null || listE.size() <= 0) {
            return;
        }
        boolean z = !((SquareBean) listE.get(listE.size() - 1)).isBottomTip();
        this.c.setEnableLoadMore(z);
        this.c.setNoMoreData(!z);
    }
}
