package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class h46 implements r96 {
    @Override // defpackage.r96
    public boolean a() {
        return false;
    }

    @Override // defpackage.r96
    public void b(Canvas canvas, Paint paint, RectF rectF, float f, RectF rectF2) {
        float f2 = rectF.left;
        float f3 = rectF.bottom;
        canvas.drawLine(f2, f3, rectF.right, f3, paint);
    }
}
