package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.adsdk.lottie.dw;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mv extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4988a;
    private final Map<String, Object> jk;
    private int n;

    public mv(com.bytedance.adsdk.lottie.n nVar, n nVar2, Context context) {
        super(nVar, nVar2);
        this.n = -1;
        this.f4988a = -1;
        HashMap map = new HashMap();
        this.jk = map;
        if (((x) this).x != null) {
            float fU = com.bytedance.adsdk.lottie.pn.a.u();
            this.n = (int) (((x) this).x.u() * fU);
            this.f4988a = (int) (((x) this).x.nr() * fU);
            map.put("ugen_url", ((x) this).x.b());
            map.put("ugen_md5", ((x) this).x.pn());
            map.put("ugen_v", ((x) this).x.iz());
            map.put("ugen_w", Integer.valueOf(this.n));
            map.put("ugen_h", Integer.valueOf(this.f4988a));
        }
    }

    private static void u(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.x, com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        dw dwVarU = this.nr.u();
        View viewU = dwVarU != null ? dwVarU.u("view:", this.jk) : null;
        if (this.n <= 0 || viewU == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        u(i);
        float fN = n();
        u(viewU, this.n, this.f4988a);
        viewU.setAlpha(fN);
        viewU.draw(canvas);
        canvas.restore();
    }
}
