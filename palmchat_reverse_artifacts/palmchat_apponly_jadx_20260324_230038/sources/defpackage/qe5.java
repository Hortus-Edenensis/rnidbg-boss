package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class qe5 {
    public static void a(ImageView imageView, int i, int i2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{i, i2}));
    }

    public static void b(MenuItem menuItem, int i, int i2) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{i, i2});
        Drawable icon = menuItem.getIcon();
        if (icon != null) {
            DrawableCompat.setTintList(icon, colorStateList);
            menuItem.setIcon(icon);
        }
        View actionView = menuItem.getActionView();
        if (actionView == null || !(actionView instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) actionView;
        if (viewGroup.getChildCount() > 0) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof ImageView) {
                    a((ImageView) childAt, i, i2);
                }
            }
        }
    }
}
