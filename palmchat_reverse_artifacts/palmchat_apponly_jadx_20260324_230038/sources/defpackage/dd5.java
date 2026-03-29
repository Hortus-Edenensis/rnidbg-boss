package defpackage;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dd5 extends PorterDuffColorFilter {
    public dd5(@ColorInt int i) {
        super(i, PorterDuff.Mode.SRC_ATOP);
    }
}
