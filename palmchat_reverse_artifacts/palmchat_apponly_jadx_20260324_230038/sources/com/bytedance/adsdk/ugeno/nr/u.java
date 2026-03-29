package com.bytedance.adsdk.ugeno.nr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.iz.n;
import com.umeng.analytics.pro.dn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u<E extends ViewGroup> extends fx {
    protected List<fx<View>> u;

    public u(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public fx fx(String str) {
        fx<T> fxVarIz;
        if (!TextUtils.isEmpty(str) && jk(str) != null) {
            return this;
        }
        for (fx<View> fxVar : this.u) {
            if (fxVar != null && (fxVarIz = fxVar.iz(str)) != 0) {
                return fxVarIz;
            }
        }
        return null;
    }

    public C0171u n() {
        return new C0171u(this);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
    }

    public void u(fx fxVar) {
        if (fxVar == null) {
            return;
        }
        this.u.add(fxVar);
        View viewA = fxVar.a();
        if (viewA != null) {
            ((ViewGroup) this.pn).addView(viewA);
        }
    }

    public List<fx<View>> x() {
        return this.u;
    }

    public u(Context context, u uVar) {
        super(context, uVar);
        this.u = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public fx nr(String str) {
        fx<T> fxVarPn;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.l)) {
            return this;
        }
        for (fx<View> fxVar : this.u) {
            if (fxVar != null && (fxVarPn = fxVar.pn(str)) != 0) {
                return fxVarPn;
            }
        }
        return null;
    }

    public void u(fx fxVar, ViewGroup.LayoutParams layoutParams) {
        if (fxVar == null) {
            return;
        }
        this.u.add(fxVar);
        View viewA = fxVar.a();
        if (viewA != null) {
            ((ViewGroup) this.pn).addView(viewA, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public fx u(String str) {
        fx<T> fxVarB;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.t)) {
            return this;
        }
        for (fx<View> fxVar : this.u) {
            if (fxVar != null && (fxVarB = fxVar.b(str)) != 0) {
                return fxVarB;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0171u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected float f5036a;
        protected boolean bg;
        protected boolean bq;
        protected boolean c;
        protected boolean dw;
        protected float iz;
        protected float jk;
        protected boolean k;
        protected u kj;
        protected float l;
        protected float mv;
        protected boolean my;
        protected float n;
        protected boolean o;
        protected float pn;
        protected boolean q;
        protected ViewGroup.LayoutParams qq;
        protected float s;
        protected boolean sx;
        protected float t;
        protected float x;
        protected float u = -2.0f;
        protected float nr = -2.0f;
        protected float fx = 0.0f;
        protected float b = 0.0f;

        public C0171u(u uVar) {
            this.kj = uVar;
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.u + ", mHeight=" + this.nr + ", mMargin=" + this.pn + ", mMarginLeft=" + this.iz + ", mMarginRight=" + this.x + ", mMarginTop=" + this.n + ", mMarginBottom=" + this.f5036a + ", mParams=" + this.qq + '}';
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void u(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        b = 0;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        b = 1;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        b = 2;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        b = 3;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        b = 4;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        b = 5;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        b = 6;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        b = 7;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        b = 8;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        b = 9;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        b = 10;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        b = 11;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        b = 12;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        b = dn.k;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    this.t = n.u(context, str2);
                    this.my = true;
                    break;
                case 1:
                    this.fx = n.u(context, str2);
                    break;
                case 2:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.nr = -1.0f;
                    } else if (!TextUtils.equals(str2, "wrap_content")) {
                        this.nr = n.u(context, str2);
                    } else {
                        this.nr = -2.0f;
                    }
                    break;
                case 3:
                    this.pn = n.u(context, str2);
                    break;
                case 4:
                    this.n = n.u(context, str2);
                    this.c = true;
                    break;
                case 5:
                    this.jk = n.u(context, str2);
                    this.k = true;
                    break;
                case 6:
                    this.f5036a = n.u(context, str2);
                    this.q = true;
                    break;
                case 7:
                    this.b = n.u(context, str2);
                    break;
                case 8:
                    this.l = n.u(context, str2);
                    this.sx = true;
                    break;
                case 9:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.u = -1.0f;
                    } else if (!TextUtils.equals(str2, "wrap_content")) {
                        this.u = n.u(context, str2);
                    } else {
                        this.u = -2.0f;
                    }
                    break;
                case 10:
                    this.s = n.u(context, str2);
                    this.bg = true;
                    break;
                case 11:
                    this.mv = n.u(context, str2);
                    this.o = true;
                    break;
                case 12:
                    this.x = n.u(context, str2);
                    this.dw = true;
                    break;
                case 13:
                    this.iz = n.u(context, str2);
                    this.bq = true;
                    break;
            }
        }

        public ViewGroup.LayoutParams u() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.u, (int) this.nr);
            marginLayoutParams.leftMargin = (int) (this.bq ? this.iz : this.pn);
            marginLayoutParams.rightMargin = (int) (this.dw ? this.x : this.pn);
            marginLayoutParams.topMargin = (int) (this.c ? this.n : this.pn);
            marginLayoutParams.bottomMargin = (int) (this.q ? this.f5036a : this.pn);
            return marginLayoutParams;
        }
    }
}
