package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class s23 extends u23 {
    public s23(g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
    }

    public final boolean k() {
        return s86.s() >= 18;
    }

    public void l(Canvas canvas, Path path, int i, int i2) {
        int i3 = (i & 16777215) | (i2 << 24);
        if (k()) {
            int iSave = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i3);
            canvas.restoreToCount(iSave);
            return;
        }
        Paint.Style style = this.c.getStyle();
        int color = this.c.getColor();
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(i3);
        canvas.drawPath(path, this.c);
        this.c.setColor(color);
        this.c.setStyle(style);
    }

    public void m(Canvas canvas, Path path, Drawable drawable) {
        if (!k()) {
            throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + s86.s() + ".");
        }
        int iSave = canvas.save();
        canvas.clipPath(path);
        drawable.setBounds((int) this.f20113a.h(), (int) this.f20113a.j(), (int) this.f20113a.i(), (int) this.f20113a.f());
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
