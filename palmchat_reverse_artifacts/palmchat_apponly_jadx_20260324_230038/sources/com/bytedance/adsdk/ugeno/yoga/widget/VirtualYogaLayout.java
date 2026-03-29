package com.bytedance.adsdk.ugeno.yoga.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.jk;
import com.bytedance.adsdk.ugeno.yoga.t;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import com.bytedance.adsdk.ugeno.yoga.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final jk fx;
    private final Map<View, jk> nr;
    private final List<View> u;

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.u(this);
            jk yogaNode = virtualYogaLayout.getYogaNode();
            jk jkVar = this.fx;
            jkVar.u(yogaNode, jkVar.u());
            return;
        }
        jk jkVarU = t.u();
        YogaLayout.u(new YogaLayout.u(layoutParams), jkVarU, view);
        jkVarU.u(view);
        jkVarU.u((x) new YogaLayout.nr());
        jk jkVar2 = this.fx;
        jkVar2.u(jkVarU, jkVar2.u());
        u(view, jkVarU);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.u;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.u(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.u(layoutParams);
    }

    public jk getYogaNode() {
        return this.fx;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    public void u(View view, jk jkVar) {
        this.u.add(view);
        this.nr.put(view, jkVar);
    }

    public void u(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.u) {
                ((VirtualYogaLayout) viewGroup).u(view, this.nr.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.u) {
                ((YogaLayout) viewGroup).u(view2, this.nr.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.u.clear();
    }
}
