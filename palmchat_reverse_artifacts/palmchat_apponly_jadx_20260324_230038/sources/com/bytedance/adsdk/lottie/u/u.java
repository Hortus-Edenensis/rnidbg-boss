package com.bytedance.adsdk.lottie.u;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.adsdk.lottie.pn.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends Paint {
    public u() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            super.setAlpha(n.u(i, 0, 255));
        } else {
            setColor((n.u(i, 0, 255) << 24) | (getColor() & 16777215));
        }
    }

    public u(int i) {
        super(i);
    }

    public u(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public u(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
