package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bb1 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cq0 f1679a;

        public a(cq0 cq0Var) {
            this.f1679a = cq0Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            this.f1679a.j(i >= 0, appBarLayout.getTotalScrollRange() + i <= 0);
        }
    }

    public static void a(View view, wu4 wu4Var, cq0 cq0Var) {
        try {
            if (view instanceof CoordinatorLayout) {
                wu4Var.d().setEnableNestedScroll(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(cq0Var));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
