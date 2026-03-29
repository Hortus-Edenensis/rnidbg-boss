package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import com.zenmen.palmchat.widget.views.WheelView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class nk6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<View> f19550a;
    public List<View> b;
    public WheelView c;

    public nk6(WheelView wheelView) {
        this.c = wheelView;
    }

    public void a() {
        List<View> list = this.f19550a;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        }
    }

    public int b(LinearLayout linearLayout, int i, av2 av2Var) {
        int i2 = i;
        int i3 = 0;
        while (i3 < linearLayout.getChildCount()) {
            if (av2Var.a(i2)) {
                i3++;
            } else {
                c(linearLayout.getChildAt(i3), i2);
                linearLayout.removeViewAt(i3);
                if (i3 == 0) {
                    i++;
                }
            }
            i2++;
        }
        return i;
    }

    public final void c(View view, int i) {
        this.c.getViewAdapter();
        throw null;
    }
}
