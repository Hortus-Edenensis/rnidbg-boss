package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends RecyclerView.a implements RecyclerView.bg.nr {
    int b;
    private boolean bg;
    private boolean bq;
    private boolean c;
    private boolean dw;
    boolean fx;
    b iz;
    private int kj;
    n nr;
    int pn;
    private boolean q;
    private final nr qq;
    private fx sx;
    int u;
    final u x;

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.bytedance.sdk.component.widget.recycler.pn.b.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        };
        boolean fx;
        int nr;
        int u;

        public b() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void nr() {
            this.u = -1;
        }

        public boolean u() {
            return this.u >= 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.u);
            parcel.writeInt(this.nr);
            parcel.writeInt(this.fx ? 1 : 0);
        }

        public b(Parcel parcel) {
            this.u = parcel.readInt();
            this.nr = parcel.readInt();
            this.fx = parcel.readInt() == 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {
        int b;
        int fx;
        int iz;
        int jk;
        boolean l;
        int nr;
        int pn;
        int x;
        boolean u = true;
        int n = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5183a = false;
        List<RecyclerView.q> t = null;

        private View nr() {
            int size = this.t.size();
            for (int i = 0; i < size; i++) {
                View view = this.t.get(i).u;
                RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
                if (!jkVar.nr() && this.b == jkVar.b()) {
                    u(view);
                    return view;
                }
            }
            return null;
        }

        public boolean u(RecyclerView.bq bqVar) {
            int i = this.b;
            return i >= 0 && i < bqVar.b();
        }

        public View u(RecyclerView.my myVar) {
            if (this.t != null) {
                return nr();
            }
            View viewNr = myVar.nr(this.b);
            this.b += this.pn;
            return viewNr;
        }

        public View nr(View view) {
            int iB;
            int size = this.t.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.t.get(i2).u;
                RecyclerView.jk jkVar = (RecyclerView.jk) view3.getLayoutParams();
                if (view3 != view && !jkVar.nr() && (iB = (jkVar.b() - this.b) * this.pn) >= 0 && iB < i) {
                    view2 = view3;
                    if (iB == 0) {
                        break;
                    }
                    i = iB;
                }
            }
            return view2;
        }

        public void u() {
            u((View) null);
        }

        public void u(View view) {
            View viewNr = nr(view);
            if (viewNr == null) {
                this.b = -1;
            } else {
                this.b = ((RecyclerView.jk) viewNr.getLayoutParams()).b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public boolean b;
        public boolean fx;
        public boolean nr;
        public int u;

        public void u() {
            this.u = 0;
            this.nr = false;
            this.fx = false;
            this.b = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        boolean b;
        int fx;
        int nr;
        boolean pn;
        n u;

        public u() {
            u();
        }

        public void nr() {
            this.fx = this.b ? this.u.b() : this.u.fx();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.nr + ", mCoordinate=" + this.fx + ", mLayoutFromEnd=" + this.b + ", mValid=" + this.pn + '}';
        }

        public void u() {
            this.nr = -1;
            this.fx = Integer.MIN_VALUE;
            this.b = false;
            this.pn = false;
        }

        public void nr(View view, int i) {
            if (this.b) {
                this.fx = this.u.nr(view) + this.u.nr();
            } else {
                this.fx = this.u.u(view);
            }
            this.nr = i;
        }

        public boolean u(View view, RecyclerView.bq bqVar) {
            RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
            return !jkVar.nr() && jkVar.b() >= 0 && jkVar.b() < bqVar.b();
        }

        public void u(View view, int i) {
            int iNr = this.u.nr();
            if (iNr >= 0) {
                nr(view, i);
                return;
            }
            this.nr = i;
            if (this.b) {
                int iB = (this.u.b() - iNr) - this.u.nr(view);
                this.fx = this.u.b() - iB;
                if (iB > 0) {
                    int iPn = this.fx - this.u.pn(view);
                    int iFx = this.u.fx();
                    int iMin = iPn - (iFx + Math.min(this.u.u(view) - iFx, 0));
                    if (iMin < 0) {
                        this.fx += Math.min(iB, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iU = this.u.u(view);
            int iFx2 = iU - this.u.fx();
            this.fx = iU;
            if (iFx2 > 0) {
                int iB2 = (this.u.b() - Math.min(0, (this.u.b() - iNr) - this.u.nr(view))) - (iU + this.u.pn(view));
                if (iB2 < 0) {
                    this.fx -= Math.min(iFx2, -iB2);
                }
            }
        }
    }

    public pn(Context context) {
        this(context, 1, false);
    }

    private int a(RecyclerView.bq bqVar) {
        if (bg() == 0) {
            return 0;
        }
        iz();
        return jk.u(bqVar, this.nr, u(!this.c, true), nr(!this.c, true), this, this.c, this.fx);
    }

    private void iz(int i, int i2) {
        this.sx.fx = this.nr.b() - i2;
        fx fxVar = this.sx;
        fxVar.pn = this.fx ? -1 : 1;
        fxVar.b = i;
        fxVar.iz = 1;
        fxVar.nr = i2;
        fxVar.x = Integer.MIN_VALUE;
    }

    private int jk(RecyclerView.bq bqVar) {
        if (bg() == 0) {
            return 0;
        }
        iz();
        return jk.u(bqVar, this.nr, u(!this.c, true), nr(!this.c, true), this, this.c);
    }

    private View m() {
        return n(this.fx ? 0 : bg() - 1);
    }

    private void pb() {
        if (this.u == 1 || !pn()) {
            this.fx = this.bq;
        } else {
            this.fx = !this.bq;
        }
    }

    private int t(RecyclerView.bq bqVar) {
        if (bg() == 0) {
            return 0;
        }
        iz();
        return jk.nr(bqVar, this.nr, u(!this.c, true), nr(!this.c, true), this, this.c);
    }

    private void x(int i, int i2) {
        this.sx.fx = i2 - this.nr.fx();
        fx fxVar = this.sx;
        fxVar.b = i;
        fxVar.pn = this.fx ? 1 : -1;
        fxVar.iz = -1;
        fxVar.nr = i2;
        fxVar.x = Integer.MIN_VALUE;
    }

    private View xg() {
        return n(this.fx ? bg() - 1 : 0);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public boolean b() {
        return this.u == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public boolean fx() {
        return this.u == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public boolean l() {
        return this.iz == null && this.bg == this.dw;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int n(RecyclerView.bq bqVar) {
        return t(bqVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public RecyclerView.jk nr() {
        return new RecyclerView.jk(-2, -2);
    }

    public boolean pn() {
        return o() == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public boolean u() {
        return true;
    }

    public pn(Context context, int i, boolean z) {
        this.u = 1;
        this.bq = false;
        this.fx = false;
        this.dw = false;
        this.c = true;
        this.b = -1;
        this.pn = Integer.MIN_VALUE;
        this.iz = null;
        this.x = new u();
        this.qq = new nr();
        this.kj = 2;
        u(i);
        u(z);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void b(int i) {
        this.b = i;
        this.pn = Integer.MIN_VALUE;
        b bVar = this.iz;
        if (bVar != null) {
            bVar.nr();
        }
        mv();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.bg.nr
    public PointF fx(int i) {
        if (bg() == 0) {
            return null;
        }
        int i2 = (i < b(n(0))) != this.fx ? -1 : 1;
        return this.u == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public boolean n() {
        return this.nr.n() == 0 && this.nr.pn() == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public View nr(int i) {
        int iBg = bg();
        if (iBg == 0) {
            return null;
        }
        int iB = i - b(n(0));
        if (iB >= 0 && iB < iBg) {
            View viewN = n(iB);
            if (b(viewN) == i) {
                return viewN;
            }
        }
        return super.nr(i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int pn(RecyclerView.bq bqVar) {
        return jk(bqVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void u(RecyclerView recyclerView, RecyclerView.my myVar) {
        super.u(recyclerView, myVar);
        if (this.q) {
            fx(myVar);
            myVar.u();
        }
    }

    private View n(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return u(0, bg());
    }

    public int pn(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.u == 1) ? 1 : Integer.MIN_VALUE : this.u == 0 ? 1 : Integer.MIN_VALUE : this.u == 1 ? -1 : Integer.MIN_VALUE : this.u == 0 ? -1 : Integer.MIN_VALUE : (this.u != 1 && pn()) ? -1 : 1 : (this.u != 1 && pn()) ? 1 : -1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public boolean a() {
        return (dw() == 1073741824 || bq() == 1073741824 || !wq()) ? false : true;
    }

    public int jk() {
        View viewU = u(0, bg(), false, true);
        if (viewU == null) {
            return -1;
        }
        return b(viewU);
    }

    public int t() {
        View viewU = u(bg() - 1, -1, false, true);
        if (viewU == null) {
            return -1;
        }
        return b(viewU);
    }

    private View a(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return u(bg() - 1, -1);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int fx(RecyclerView.bq bqVar) {
        return a(bqVar);
    }

    public void u(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        u((String) null);
        if (i != this.u || this.nr == null) {
            n nVarU = n.u(this, i);
            this.nr = nVarU;
            this.x.u = nVarU;
            this.u = i;
            mv();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int b(RecyclerView.bq bqVar) {
        return a(bqVar);
    }

    public int fx(int i, RecyclerView.my myVar, RecyclerView.bq bqVar) {
        if (bg() == 0 || i == 0) {
            return 0;
        }
        this.sx.u = true;
        iz();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        u(i2, iAbs, true, bqVar);
        fx fxVar = this.sx;
        int iU = fxVar.x + u(myVar, fxVar, bqVar, false);
        if (iU < 0) {
            return 0;
        }
        if (iAbs > iU) {
            i = i2 * iU;
        }
        this.nr.u(-i);
        this.sx.jk = i;
        return i;
    }

    public void iz() {
        if (this.sx == null) {
            this.sx = x();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void nr(RecyclerView.bq bqVar) {
        super.nr(bqVar);
        this.iz = null;
        this.b = -1;
        this.pn = Integer.MIN_VALUE;
        this.x.u();
    }

    public fx x() {
        return new fx();
    }

    private View b(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return u(myVar, bqVar, 0, bg(), bqVar.b());
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int x(RecyclerView.bq bqVar) {
        return t(bqVar);
    }

    private View x(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return this.fx ? a(myVar, bqVar) : n(myVar, bqVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int iz(RecyclerView.bq bqVar) {
        return jk(bqVar);
    }

    private View iz(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return this.fx ? n(myVar, bqVar) : a(myVar, bqVar);
    }

    private View pn(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return u(myVar, bqVar, bg() - 1, -1, bqVar.b());
    }

    private void nr(RecyclerView.my myVar, RecyclerView.bq bqVar, int i, int i2) {
        if (!bqVar.nr() || bg() == 0 || bqVar.u() || !l()) {
            return;
        }
        List<RecyclerView.q> listFx = myVar.fx();
        int size = listFx.size();
        int iB = b(n(0));
        int iPn = 0;
        int iPn2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.q qVar = listFx.get(i3);
            if (!qVar.o()) {
                if (((qVar.b() < iB) != this.fx ? (byte) -1 : (byte) 1) == -1) {
                    iPn += this.nr.pn(qVar.u);
                } else {
                    iPn2 += this.nr.pn(qVar.u);
                }
            }
        }
        this.sx.t = listFx;
        if (iPn > 0) {
            x(b(xg()), i);
            fx fxVar = this.sx;
            fxVar.n = iPn;
            fxVar.fx = 0;
            fxVar.u();
            u(myVar, this.sx, bqVar, false);
        }
        if (iPn2 > 0) {
            iz(b(m()), i2);
            fx fxVar2 = this.sx;
            fxVar2.n = iPn2;
            fxVar2.fx = 0;
            fxVar2.u();
            u(myVar, this.sx, bqVar, false);
        }
        this.sx.t = null;
    }

    public void u(boolean z) {
        u((String) null);
        if (z != this.bq) {
            this.bq = z;
            mv();
        }
    }

    private View fx(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return this.fx ? pn(myVar, bqVar) : b(myVar, bqVar);
    }

    public int u(RecyclerView.bq bqVar) {
        if (bqVar.fx()) {
            return this.nr.iz();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void u(RecyclerView recyclerView, RecyclerView.bq bqVar, int i) {
        iz izVar = new iz(recyclerView.getContext());
        izVar.fx(i);
        u(izVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void u(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iU;
        int i6;
        View viewNr;
        int iU2;
        int iB;
        if ((this.iz != null || this.b != -1) && bqVar.b() == 0) {
            fx(myVar);
            return;
        }
        b bVar = this.iz;
        if (bVar != null && bVar.u()) {
            this.b = this.iz.u;
        }
        iz();
        this.sx.u = false;
        pb();
        View viewD = d();
        u uVar = this.x;
        if (uVar.pn && this.b == -1 && this.iz == null) {
            if (viewD != null && (this.nr.u(viewD) >= this.nr.b() || this.nr.nr(viewD) <= this.nr.fx())) {
                this.x.u(viewD, b(viewD));
            }
        } else {
            uVar.u();
            u uVar2 = this.x;
            uVar2.b = this.fx ^ this.dw;
            u(myVar, bqVar, uVar2);
            this.x.pn = true;
        }
        int iU3 = u(bqVar);
        if (this.sx.jk >= 0) {
            i = iU3;
            iU3 = 0;
        } else {
            i = 0;
        }
        int iFx = iU3 + this.nr.fx();
        int iX = i + this.nr.x();
        if (bqVar.u() && (i6 = this.b) != -1 && this.pn != Integer.MIN_VALUE && (viewNr = nr(i6)) != null) {
            if (this.fx) {
                iB = this.nr.b() - this.nr.nr(viewNr);
                iU2 = this.pn;
            } else {
                iU2 = this.nr.u(viewNr) - this.nr.fx();
                iB = this.pn;
            }
            int i7 = iB - iU2;
            if (i7 > 0) {
                iFx += i7;
            } else {
                iX -= i7;
            }
        }
        u(myVar);
        this.sx.l = n();
        this.sx.f5183a = bqVar.u();
        u uVar3 = this.x;
        if (uVar3.b) {
            nr(uVar3);
            fx fxVar = this.sx;
            fxVar.n = iFx;
            u(myVar, fxVar, bqVar, false);
            fx fxVar2 = this.sx;
            i3 = fxVar2.nr;
            int i8 = fxVar2.b;
            int i9 = fxVar2.fx;
            if (i9 > 0) {
                iX += i9;
            }
            u(this.x);
            fx fxVar3 = this.sx;
            fxVar3.n = iX;
            fxVar3.b += fxVar3.pn;
            u(myVar, fxVar3, bqVar, false);
            fx fxVar4 = this.sx;
            i2 = fxVar4.nr;
            int i10 = fxVar4.fx;
            if (i10 > 0) {
                x(i8, i3);
                fx fxVar5 = this.sx;
                fxVar5.n = i10;
                u(myVar, fxVar5, bqVar, false);
                i3 = this.sx.nr;
            }
        } else {
            u(uVar3);
            fx fxVar6 = this.sx;
            fxVar6.n = iX;
            u(myVar, fxVar6, bqVar, false);
            fx fxVar7 = this.sx;
            i2 = fxVar7.nr;
            int i11 = fxVar7.b;
            int i12 = fxVar7.fx;
            if (i12 > 0) {
                iFx += i12;
            }
            nr(this.x);
            fx fxVar8 = this.sx;
            fxVar8.n = iFx;
            fxVar8.b += fxVar8.pn;
            u(myVar, fxVar8, bqVar, false);
            fx fxVar9 = this.sx;
            i3 = fxVar9.nr;
            int i13 = fxVar9.fx;
            if (i13 > 0) {
                iz(i11, i2);
                fx fxVar10 = this.sx;
                fxVar10.n = i13;
                u(myVar, fxVar10, bqVar, false);
                i2 = this.sx.nr;
            }
        }
        if (bg() > 0) {
            if (this.fx ^ this.dw) {
                int iU4 = u(i2, myVar, bqVar, true);
                i4 = i3 + iU4;
                i5 = i2 + iU4;
                iU = nr(i4, myVar, bqVar, false);
            } else {
                int iNr = nr(i3, myVar, bqVar, true);
                i4 = i3 + iNr;
                i5 = i2 + iNr;
                iU = u(i5, myVar, bqVar, false);
            }
            i3 = i4 + iU;
            i2 = i5 + iU;
        }
        nr(myVar, bqVar, i3, i2);
        if (!bqVar.u()) {
            this.nr.u();
        } else {
            this.x.u();
        }
        this.bg = this.dw;
    }

    private boolean nr(RecyclerView.my myVar, RecyclerView.bq bqVar, u uVar) {
        if (bg() == 0) {
            return false;
        }
        View viewD = d();
        if (viewD != null && uVar.u(viewD, bqVar)) {
            uVar.u(viewD, b(viewD));
            return true;
        }
        if (this.bg != this.dw) {
            return false;
        }
        View viewNr = uVar.b ? nr(myVar, bqVar) : fx(myVar, bqVar);
        if (viewNr == null) {
            return false;
        }
        uVar.nr(viewNr, b(viewNr));
        if (!bqVar.u() && l()) {
            if (this.nr.u(viewNr) >= this.nr.b() || this.nr.nr(viewNr) < this.nr.fx()) {
                uVar.fx = uVar.b ? this.nr.b() : this.nr.fx();
            }
        }
        return true;
    }

    private int nr(int i, RecyclerView.my myVar, RecyclerView.bq bqVar, boolean z) {
        int iFx;
        int iFx2 = i - this.nr.fx();
        if (iFx2 <= 0) {
            return 0;
        }
        int i2 = -fx(iFx2, myVar, bqVar);
        int i3 = i + i2;
        if (!z || (iFx = i3 - this.nr.fx()) <= 0) {
            return i2;
        }
        this.nr.u(-iFx);
        return i2 - iFx;
    }

    private void nr(u uVar) {
        x(uVar.nr, uVar.fx);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int nr(int i, RecyclerView.my myVar, RecyclerView.bq bqVar) {
        if (this.u == 0) {
            return 0;
        }
        return fx(i, myVar, bqVar);
    }

    private void nr(RecyclerView.my myVar, int i) {
        int iBg = bg();
        if (i >= 0) {
            int iPn = this.nr.pn() - i;
            if (this.fx) {
                for (int i2 = 0; i2 < iBg; i2++) {
                    View viewN = n(i2);
                    if (this.nr.u(viewN) < iPn || this.nr.b(viewN) < iPn) {
                        u(myVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iBg - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewN2 = n(i4);
                if (this.nr.u(viewN2) < iPn || this.nr.b(viewN2) < iPn) {
                    u(myVar, i3, i4);
                    return;
                }
            }
        }
    }

    private View nr(boolean z, boolean z2) {
        int iBg;
        int iBg2;
        if (this.fx) {
            iBg = 0;
            iBg2 = bg();
        } else {
            iBg = bg() - 1;
            iBg2 = -1;
        }
        return u(iBg, iBg2, z, z2);
    }

    private View nr(RecyclerView.my myVar, RecyclerView.bq bqVar) {
        return this.fx ? b(myVar, bqVar) : pn(myVar, bqVar);
    }

    private void u(RecyclerView.my myVar, RecyclerView.bq bqVar, u uVar) {
        if (u(bqVar, uVar) || nr(myVar, bqVar, uVar)) {
            return;
        }
        uVar.nr();
        uVar.nr = this.dw ? bqVar.b() - 1 : 0;
    }

    private boolean u(RecyclerView.bq bqVar, u uVar) {
        int i;
        if (!bqVar.u() && (i = this.b) != -1) {
            if (i >= 0 && i < bqVar.b()) {
                uVar.nr = this.b;
                b bVar = this.iz;
                if (bVar != null && bVar.u()) {
                    boolean z = this.iz.fx;
                    uVar.b = z;
                    if (z) {
                        uVar.fx = this.nr.b() - this.iz.nr;
                    } else {
                        uVar.fx = this.nr.fx() + this.iz.nr;
                    }
                    return true;
                }
                if (this.pn == Integer.MIN_VALUE) {
                    View viewNr = nr(this.b);
                    if (viewNr != null) {
                        if (this.nr.pn(viewNr) > this.nr.iz()) {
                            uVar.nr();
                            return true;
                        }
                        if (this.nr.u(viewNr) - this.nr.fx() < 0) {
                            uVar.fx = this.nr.fx();
                            uVar.b = false;
                            return true;
                        }
                        if (this.nr.b() - this.nr.nr(viewNr) < 0) {
                            uVar.fx = this.nr.b();
                            uVar.b = true;
                            return true;
                        }
                        uVar.fx = uVar.b ? this.nr.nr(viewNr) + this.nr.nr() : this.nr.u(viewNr);
                    } else {
                        if (bg() > 0) {
                            uVar.b = (this.b < b(n(0))) == this.fx;
                        }
                        uVar.nr();
                    }
                    return true;
                }
                boolean z2 = this.fx;
                uVar.b = z2;
                if (z2) {
                    uVar.fx = this.nr.b() - this.pn;
                } else {
                    uVar.fx = this.nr.fx() + this.pn;
                }
                return true;
            }
            this.b = -1;
            this.pn = Integer.MIN_VALUE;
        }
        return false;
    }

    private int u(int i, RecyclerView.my myVar, RecyclerView.bq bqVar, boolean z) {
        int iB;
        int iB2 = this.nr.b() - i;
        if (iB2 <= 0) {
            return 0;
        }
        int i2 = -fx(-iB2, myVar, bqVar);
        int i3 = i + i2;
        if (!z || (iB = this.nr.b() - i3) <= 0) {
            return i2;
        }
        this.nr.u(iB);
        return iB + i2;
    }

    private void u(u uVar) {
        iz(uVar.nr, uVar.fx);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int u(int i, RecyclerView.my myVar, RecyclerView.bq bqVar) {
        if (this.u == 1) {
            return 0;
        }
        return fx(i, myVar, bqVar);
    }

    private void u(int i, int i2, boolean z, RecyclerView.bq bqVar) {
        int iFx;
        this.sx.l = n();
        this.sx.n = u(bqVar);
        fx fxVar = this.sx;
        fxVar.iz = i;
        if (i == 1) {
            fxVar.n += this.nr.x();
            View viewM = m();
            fx fxVar2 = this.sx;
            fxVar2.pn = this.fx ? -1 : 1;
            int iB = b(viewM);
            fx fxVar3 = this.sx;
            fxVar2.b = iB + fxVar3.pn;
            fxVar3.nr = this.nr.nr(viewM);
            iFx = this.nr.nr(viewM) - this.nr.b();
        } else {
            View viewXg = xg();
            this.sx.n += this.nr.fx();
            fx fxVar4 = this.sx;
            fxVar4.pn = this.fx ? 1 : -1;
            int iB2 = b(viewXg);
            fx fxVar5 = this.sx;
            fxVar4.b = iB2 + fxVar5.pn;
            fxVar5.nr = this.nr.u(viewXg);
            iFx = (-this.nr.u(viewXg)) + this.nr.fx();
        }
        fx fxVar6 = this.sx;
        fxVar6.fx = i2;
        if (z) {
            fxVar6.fx = i2 - iFx;
        }
        fxVar6.x = iFx;
    }

    public void u(RecyclerView.bq bqVar, fx fxVar, RecyclerView.a.u uVar) {
        int i = fxVar.b;
        if (i < 0 || i >= bqVar.b()) {
            return;
        }
        uVar.nr(i, Math.max(0, fxVar.x));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void u(int i, RecyclerView.a.u uVar) {
        boolean z;
        int i2;
        b bVar = this.iz;
        if (bVar != null && bVar.u()) {
            b bVar2 = this.iz;
            z = bVar2.fx;
            i2 = bVar2.u;
        } else {
            pb();
            z = this.fx;
            i2 = this.b;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.kj && i2 >= 0 && i2 < i; i4++) {
            uVar.nr(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void u(int i, int i2, RecyclerView.bq bqVar, RecyclerView.a.u uVar) {
        if (this.u != 0) {
            i = i2;
        }
        if (bg() == 0 || i == 0) {
            return;
        }
        iz();
        u(i > 0 ? 1 : -1, Math.abs(i), true, bqVar);
        u(bqVar, this.sx, uVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void u(String str) {
        if (this.iz == null) {
            super.u(str);
        }
    }

    private void u(RecyclerView.my myVar, int i, int i2) {
        if (i != i2) {
            if (i2 <= i) {
                while (i > i2) {
                    u(i, myVar);
                    i--;
                }
            } else {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    u(i3, myVar);
                }
            }
        }
    }

    private void u(RecyclerView.my myVar, int i) {
        if (i >= 0) {
            int iBg = bg();
            if (!this.fx) {
                for (int i2 = 0; i2 < iBg; i2++) {
                    View viewN = n(i2);
                    if (this.nr.nr(viewN) > i || this.nr.fx(viewN) > i) {
                        u(myVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iBg - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewN2 = n(i4);
                if (this.nr.nr(viewN2) > i || this.nr.fx(viewN2) > i) {
                    u(myVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void u(RecyclerView.my myVar, fx fxVar) {
        if (!fxVar.u || fxVar.l) {
            return;
        }
        if (fxVar.iz == -1) {
            nr(myVar, fxVar.x);
        } else {
            u(myVar, fxVar.x);
        }
    }

    public int u(RecyclerView.my myVar, fx fxVar, RecyclerView.bq bqVar, boolean z) {
        int i = fxVar.fx;
        int i2 = fxVar.x;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                fxVar.x = i2 + i;
            }
            u(myVar, fxVar);
        }
        int i3 = fxVar.fx + fxVar.n;
        nr nrVar = this.qq;
        while (true) {
            if ((!fxVar.l && i3 <= 0) || !fxVar.u(bqVar)) {
                break;
            }
            nrVar.u();
            u(myVar, bqVar, fxVar, nrVar);
            if (!nrVar.nr) {
                fxVar.nr += nrVar.u * fxVar.iz;
                if (!nrVar.fx || this.sx.t != null || !bqVar.u()) {
                    int i4 = fxVar.fx;
                    int i5 = nrVar.u;
                    fxVar.fx = i4 - i5;
                    i3 -= i5;
                }
                int i6 = fxVar.x;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + nrVar.u;
                    fxVar.x = i7;
                    int i8 = fxVar.fx;
                    if (i8 < 0) {
                        fxVar.x = i7 + i8;
                    }
                    u(myVar, fxVar);
                }
                if (z && nrVar.b) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - fxVar.fx;
    }

    public void u(RecyclerView.my myVar, RecyclerView.bq bqVar, fx fxVar, nr nrVar) {
        int i;
        int i2;
        int i3;
        int iQq;
        int iIz;
        View viewU = fxVar.u(myVar);
        if (viewU == null) {
            nrVar.nr = true;
            return;
        }
        RecyclerView.jk jkVar = (RecyclerView.jk) viewU.getLayoutParams();
        if (fxVar.t == null) {
            if (this.fx == (fxVar.iz == -1)) {
                nr(viewU);
            } else {
                nr(viewU, 0);
            }
        } else {
            if (this.fx == (fxVar.iz == -1)) {
                u(viewU);
            } else {
                u(viewU, 0);
            }
        }
        u(viewU, 0, 0);
        nrVar.u = this.nr.pn(viewU);
        if (this.u == 1) {
            if (pn()) {
                iIz = c() - z();
                iQq = iIz - this.nr.iz(viewU);
            } else {
                iQq = qq();
                iIz = this.nr.iz(viewU) + iQq;
            }
            if (fxVar.iz == -1) {
                int i4 = fxVar.nr;
                i3 = i4;
                i2 = iIz;
                i = i4 - nrVar.u;
            } else {
                int i5 = fxVar.nr;
                i = i5;
                i2 = iIz;
                i3 = nrVar.u + i5;
            }
        } else {
            int iKj = kj();
            int iIz2 = this.nr.iz(viewU) + iKj;
            if (fxVar.iz == -1) {
                int i6 = fxVar.nr;
                i2 = i6;
                i = iKj;
                i3 = iIz2;
                iQq = i6 - nrVar.u;
            } else {
                int i7 = fxVar.nr;
                i = iKj;
                i2 = nrVar.u + i7;
                i3 = iIz2;
                iQq = i7;
            }
        }
        u(viewU, iQq, i, i2, i3);
        if (jkVar.nr() || jkVar.fx()) {
            nrVar.fx = true;
        }
        nrVar.b = viewU.hasFocusable();
    }

    private View u(boolean z, boolean z2) {
        int iBg;
        int iBg2;
        if (this.fx) {
            iBg = bg() - 1;
            iBg2 = -1;
        } else {
            iBg = 0;
            iBg2 = bg();
        }
        return u(iBg, iBg2, z, z2);
    }

    public View u(RecyclerView.my myVar, RecyclerView.bq bqVar, int i, int i2, int i3) {
        iz();
        int iFx = this.nr.fx();
        int iB = this.nr.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewN = n(i);
            int iB2 = b(viewN);
            if (iB2 >= 0 && iB2 < i3) {
                if (((RecyclerView.jk) viewN.getLayoutParams()).nr()) {
                    if (view2 == null) {
                        view2 = viewN;
                    }
                } else {
                    if (this.nr.u(viewN) < iB && this.nr.nr(viewN) >= iFx) {
                        return viewN;
                    }
                    if (view == null) {
                        view = viewN;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public View u(int i, int i2, boolean z, boolean z2) {
        iz();
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        int i4 = z ? 24579 : MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        if (!z2) {
            i3 = 0;
        }
        return (this.u == 0 ? this.jk : this.t).u(i, i2, i4, i3);
    }

    public View u(int i, int i2) {
        int i3;
        int i4;
        iz();
        if ((i2 > i ? (byte) 1 : i2 < i ? (byte) -1 : (byte) 0) == 0) {
            return n(i);
        }
        if (this.nr.u(n(i)) < this.nr.fx()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.u == 0 ? this.jk : this.t).u(i, i2, i3, i4);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public View u(View view, int i, RecyclerView.my myVar, RecyclerView.bq bqVar) {
        int iPn;
        View viewIz;
        View viewM;
        pb();
        if (bg() == 0 || (iPn = pn(i)) == Integer.MIN_VALUE) {
            return null;
        }
        iz();
        iz();
        u(iPn, (int) (this.nr.iz() * 0.33333334f), false, bqVar);
        fx fxVar = this.sx;
        fxVar.x = Integer.MIN_VALUE;
        fxVar.u = false;
        u(myVar, fxVar, bqVar, true);
        if (iPn == -1) {
            viewIz = x(myVar, bqVar);
        } else {
            viewIz = iz(myVar, bqVar);
        }
        if (iPn == -1) {
            viewM = xg();
        } else {
            viewM = m();
        }
        if (!viewM.hasFocusable()) {
            return viewIz;
        }
        if (viewIz == null) {
            return null;
        }
        return viewM;
    }
}
