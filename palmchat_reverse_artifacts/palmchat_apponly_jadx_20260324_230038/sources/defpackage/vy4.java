package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vy4 implements r96 {
    @Override // defpackage.r96
    public boolean a() {
        return false;
    }

    @Override // defpackage.r96
    public void b(Canvas canvas, Paint paint, RectF rectF, float f, RectF rectF2) {
        RectF rectF3;
        if (rectF.width() <= rectF.height()) {
            if (rectF.width() < rectF.height()) {
                rectF3 = new RectF(rectF.left, rectF.top + ((rectF.height() - rectF.width()) / 2.0f), rectF.right, rectF.bottom - ((rectF.height() - rectF.width()) / 2.0f));
            }
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        rectF3 = new RectF(rectF.left + ((rectF.width() - rectF.height()) / 2.0f), rectF.top, rectF.right - ((rectF.width() - rectF.height()) / 2.0f), rectF.bottom);
        rectF = rectF3;
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
