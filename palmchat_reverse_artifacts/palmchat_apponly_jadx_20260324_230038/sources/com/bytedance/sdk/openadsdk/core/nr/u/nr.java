package com.bytedance.sdk.openadsdk.core.nr.u;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    public nr() {
    }

    public boolean nr(View view) {
        if (view != null && this.u != null) {
            String strValueOf = String.valueOf(view.getTag(2097610717));
            if (view.getTag(2097610717) != null && !TextUtils.isEmpty(strValueOf)) {
                if ("click".equals(strValueOf)) {
                    return this.fx.x();
                }
                return true;
            }
            Context context = this.nr;
            if (context == null) {
                context = dw.getContext();
            }
            if (u(view, context)) {
                return this.u.w() != 1 || this.fx.x();
            }
            if (this.u.oa() == 1 && !this.fx.x()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.u.u
    public int u(Map<String, Object> map, fx fxVar) {
        return !nr(this.b) ? 1 : 0;
    }

    public nr(bc bcVar, Context context) {
        this.u = bcVar;
        this.nr = context;
    }

    public boolean u(View view, Context context) {
        int id = view.getId();
        List<Integer> listMv = this.fx.mv();
        if (listMv != null && listMv.size() == 0) {
            listMv.add(2114387830);
            listMv.add(2114387864);
            listMv.add(2114387633);
            listMv.add(2114387466);
            listMv.add(2114387468);
            listMv.add(2114387962);
            listMv.add(2114387625);
        }
        return listMv != null && listMv.contains(Integer.valueOf(id));
    }

    public boolean u(View view, Point point) {
        int i;
        int i2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Context context = this.nr;
                if (context == null) {
                    context = dw.getContext();
                }
                if (u(childAt, context)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    int i4 = point.x;
                    int i5 = iArr[0];
                    return i4 >= i5 && i4 <= i5 + childAt.getWidth() && (i = point.y) >= (i2 = iArr[1]) && i <= i2 + childAt.getHeight();
                }
                if (u(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
