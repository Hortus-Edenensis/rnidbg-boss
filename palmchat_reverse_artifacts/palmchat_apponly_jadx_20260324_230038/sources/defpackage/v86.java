package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class v86 {
    public static void a(@Nullable ViewGroup viewGroup, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        ViewGroup viewGroup2;
        if (view == null || viewGroup == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent == null) {
            viewGroup.addView(view, layoutParams);
        } else {
            if (!(parent instanceof ViewGroup) || (viewGroup2 = (ViewGroup) parent) == viewGroup) {
                return;
            }
            viewGroup2.removeView(view);
            viewGroup.addView(view, layoutParams);
        }
    }
}
