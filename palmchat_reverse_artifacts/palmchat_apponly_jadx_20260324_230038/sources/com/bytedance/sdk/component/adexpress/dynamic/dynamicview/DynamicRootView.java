package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.fx.iz;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.adexpress.nr.t;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.b, com.bytedance.sdk.component.adexpress.theme.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f5082a;
    private t b;
    public View fx;
    private com.bytedance.sdk.component.adexpress.dynamic.pn.u iz;
    private int jk;
    private mv k;
    private com.bytedance.sdk.component.adexpress.dynamic.pn l;
    private int mv;
    private Context my;
    private com.bytedance.sdk.component.adexpress.dynamic.nr n;
    boolean nr;
    private String o;
    private DynamicBaseWidget pn;
    private int s;
    private Map<Integer, String> sx;
    private List<com.bytedance.sdk.component.adexpress.dynamic.fx> t;
    protected final s u;
    private ThemeStatusBroadcastReceiver x;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, mv mvVar, com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar) {
        super(context);
        this.f5082a = null;
        this.jk = 0;
        this.t = new ArrayList();
        this.mv = 0;
        this.s = 0;
        this.my = context;
        s sVar = new s();
        this.u = sVar;
        sVar.u(2);
        this.iz = uVar;
        uVar.u(this);
        this.x = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.u(this);
        this.nr = z;
        this.k = mvVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.u
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.pn;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.u(i);
    }

    public String getBgColor() {
        return this.o;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.sx;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.pn.u getDynamicClickListener() {
        return this.iz;
    }

    public int getLogoUnionHeight() {
        return this.mv;
    }

    public t getRenderListener() {
        return this.b;
    }

    public mv getRenderRequest() {
        return this.k;
    }

    public int getScoreCountWithIcon() {
        return this.s;
    }

    public ViewGroup getTimeOut() {
        return this.f5082a;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.fx> getTimeOutListener() {
        return this.t;
    }

    public int getTimedown() {
        return this.jk;
    }

    public void nr() {
        u(this.pn, 4);
    }

    public void setBgColor(String str) {
        this.o = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.sx = map;
    }

    public void setDislikeView(View view) {
        this.iz.nr(view);
    }

    public void setLogoUnionHeight(int i) {
        this.mv = i;
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.nr nrVar) {
        this.n = nrVar;
    }

    public void setRenderListener(t tVar) {
        this.b = tVar;
        this.iz.u(tVar);
    }

    public void setScoreCountWithIcon(int i) {
        this.s = i;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.nr nrVar = this.n;
        if (nrVar != null) {
            nrVar.setSoundMute(z);
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.f5082a = viewGroup;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.fx fxVar) {
        this.t.add(fxVar);
    }

    public void setTimeUpdate(int i) {
        this.l.setTimeUpdate(i);
    }

    public void setTimedown(int i) {
        this.jk = i;
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.pn pnVar) {
        this.l = pnVar;
    }

    public void u(n nVar, int i) {
        this.pn = u(nVar, this, i);
        this.u.u(true);
        this.u.u(this.pn.pn);
        this.u.nr(this.pn.iz);
        this.u.u(this.fx);
        this.b.u(this.u);
    }

    public DynamicBaseWidget u(n nVar, ViewGroup viewGroup, int i) {
        if (nVar == null) {
            return null;
        }
        List<n> listT = nVar.t();
        DynamicBaseWidget dynamicBaseWidgetU = com.bytedance.sdk.component.adexpress.dynamic.u.nr.u(this.my, this, nVar);
        if (dynamicBaseWidgetU instanceof DynamicUnKnowView) {
            u(i == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        u(nVar);
        dynamicBaseWidgetU.u();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetU);
            u(viewGroup, nVar);
        }
        if (listT == null || listT.size() <= 0) {
            return null;
        }
        Iterator<n> it = listT.iterator();
        while (it.hasNext()) {
            u(it.next(), dynamicBaseWidgetU, i);
        }
        return dynamicBaseWidgetU;
    }

    private void u(n nVar) {
        iz izVarPn;
        com.bytedance.sdk.component.adexpress.dynamic.fx.pn pnVarJk = nVar.jk();
        if (pnVarJk == null || (izVarPn = pnVarJk.pn()) == null) {
            return;
        }
        this.u.nr(izVarPn.wu());
    }

    private void u(ViewGroup viewGroup, n nVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !nVar.qq()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void u(double d, double d2, double d3, double d4, float f) {
        this.u.fx(d);
        this.u.b(d2);
        this.u.pn(d3);
        this.u.iz(d4);
        this.u.u(f);
        this.u.nr(f);
        this.u.fx(f);
        this.u.b(f);
    }

    public void u(int i, String str) {
        this.u.u(false);
        this.u.nr(i);
        this.u.u(str);
        this.b.u(this.u);
    }

    public void u() {
        u(this.pn, 0);
    }

    public void u(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            View view = dynamicBaseWidget.k;
            if (view != null) {
                view.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                u((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void u(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.t.size(); i3++) {
            if (this.t.get(i3) != null) {
                this.t.get(i3).u(charSequence, i == 1, i2, z);
            }
        }
    }
}
