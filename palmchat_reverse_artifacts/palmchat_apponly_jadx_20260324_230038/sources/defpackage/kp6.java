package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import defpackage.lp6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class kp6 extends ip6 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements lp6.a {
        public a() {
        }

        @Override // lp6.a
        public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    @Override // defpackage.jp6
    public void initStatic() {
        lp6.r = new a();
    }
}
