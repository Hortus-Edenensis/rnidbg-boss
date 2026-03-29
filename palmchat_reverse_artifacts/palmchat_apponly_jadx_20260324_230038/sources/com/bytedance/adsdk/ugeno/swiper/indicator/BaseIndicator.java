package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.swiper.nr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5042a;
    private List<View> b;
    protected int fx;
    private int iz;
    private float jk;
    private String l;
    private boolean n;
    protected int nr;
    private int pn;
    private float t;
    protected Context u;
    private int x;

    public BaseIndicator(Context context) {
        super(context);
        this.pn = SupportMenu.CATEGORY_MASK;
        this.iz = -16776961;
        this.x = 5;
        this.nr = 40;
        this.fx = 20;
        this.l = "row";
        this.u = context;
        this.b = new ArrayList();
        setOrientation(0);
    }

    public int getSize() {
        return this.b.size();
    }

    public abstract Drawable nr(int i);

    public void setIndicatorDirection(String str) {
        this.l = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorHeight(int i) {
        this.fx = i;
    }

    public void setIndicatorWidth(int i) {
        this.nr = i;
    }

    public void setIndicatorX(float f) {
        this.jk = f;
    }

    public void setIndicatorY(float f) {
        this.t = f;
    }

    public void setLoop(boolean z) {
        this.n = z;
    }

    public void setSelectedColor(int i) {
        this.pn = i;
    }

    public void setUnSelectedColor(int i) {
        this.iz = i;
    }

    public void u(int i, int i2) {
        Iterator<View> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().setBackground(nr(this.iz));
        }
        if (i < 0 || i >= this.b.size()) {
            i = 0;
        }
        if (this.b.size() > 0) {
            this.b.get(i).setBackground(nr(this.pn));
            this.f5042a = i2;
        }
    }

    public void u(int i) {
        if (this instanceof DotIndicator) {
            this.fx = this.nr;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.nr, this.fx);
        if (getOrientation() == 1) {
            int i2 = this.x;
            layoutParams.topMargin = i2;
            layoutParams.bottomMargin = i2;
        } else {
            int i3 = this.x;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.nr, this.fx);
        if (getOrientation() == 1) {
            int i4 = this.x;
            layoutParams2.topMargin = i4;
            layoutParams2.bottomMargin = i4;
        } else {
            int i5 = this.x;
            layoutParams2.leftMargin = i5;
            layoutParams2.rightMargin = i5;
        }
        int iU = nr.u(this.n, this.f5042a, this.b.size());
        int iU2 = nr.u(this.n, i, this.b.size());
        if (this.b.size() == 0) {
            iU2 = 0;
        }
        if (!this.b.isEmpty() && nr.u(iU, this.b) && nr.u(iU2, this.b)) {
            this.b.get(iU).setBackground(nr(this.iz));
            this.b.get(iU).setLayoutParams(layoutParams2);
            this.b.get(iU2).setBackground(nr(this.pn));
            this.b.get(iU2).setLayoutParams(layoutParams);
            this.f5042a = i;
        }
    }

    public void u() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.fx = this.nr;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.nr, this.fx);
        if (getOrientation() == 1) {
            int i = this.x;
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i;
        } else {
            int i2 = this.x;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        }
        addView(view, layoutParams);
        view.setBackground(nr(this.iz));
        this.b.add(view);
    }
}
