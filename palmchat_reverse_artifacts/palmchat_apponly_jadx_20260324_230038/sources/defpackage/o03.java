package defpackage;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class o03 extends Paint {
    public o03() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            super.setAlpha(sp3.c(i, 0, 255));
        } else {
            setColor((sp3.c(i, 0, 255) << 24) | (getColor() & 16777215));
        }
    }

    public o03(int i) {
        super(i);
    }

    public o03(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public o03(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }
}
