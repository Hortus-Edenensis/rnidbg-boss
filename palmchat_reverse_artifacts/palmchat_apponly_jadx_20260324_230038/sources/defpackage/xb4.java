package defpackage;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class xb4 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f21918a;

    public xb4() {
        Paint paint = new Paint();
        this.f21918a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f21918a.setAntiAlias(true);
        this.f21918a.setColor(-5592406);
    }

    public void a(int i) {
        this.f21918a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f21918a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f21918a.setColorFilter(colorFilter);
    }
}
