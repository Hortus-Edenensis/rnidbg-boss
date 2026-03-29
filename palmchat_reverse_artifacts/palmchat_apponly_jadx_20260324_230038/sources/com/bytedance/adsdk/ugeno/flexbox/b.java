package com.bytedance.adsdk.ugeno.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.media3.muxer.MuxerUtil;
import com.bytedance.adsdk.ugeno.iz.iz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class b {
    static final /* synthetic */ boolean fx = true;
    private final com.bytedance.adsdk.ugeno.flexbox.u b;
    private long[] iz;
    long[] nr;
    private boolean[] pn;
    int[] u;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements Comparable<nr> {
        int nr;
        int u;

        private nr() {
        }

        public String toString() {
            return "Order{order=" + this.nr + ", index=" + this.u + '}';
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compareTo(nr nrVar) {
            int i = this.nr;
            int i2 = nrVar.nr;
            return i != i2 ? i - i2 : this.u - nrVar.u;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        int nr;
        List<fx> u;

        public void u() {
            this.u = null;
            this.nr = 0;
        }
    }

    public b(com.bytedance.adsdk.ugeno.flexbox.u uVar) {
        this.b = uVar;
    }

    private int b(boolean z) {
        return z ? this.b.getPaddingBottom() : this.b.getPaddingEnd();
    }

    private int fx(boolean z) {
        return z ? this.b.getPaddingTop() : this.b.getPaddingStart();
    }

    private int iz(com.bytedance.adsdk.ugeno.flexbox.nr nrVar, boolean z) {
        return z ? nrVar.my() : nrVar.k();
    }

    private int pn(com.bytedance.adsdk.ugeno.flexbox.nr nrVar, boolean z) {
        return z ? nrVar.s() : nrVar.mv();
    }

    public int nr(long j) {
        return (int) (j >> 32);
    }

    public int u(long j) {
        return (int) j;
    }

    public long nr(int i, int i2) {
        return (((long) i) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i2) << 32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] u(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.b.getFlexItemCount();
        List<nr> listNr = nr(flexItemCount);
        nr nrVar = new nr();
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.flexbox.nr)) {
            nrVar.nr = 1;
        } else {
            nrVar.nr = ((com.bytedance.adsdk.ugeno.flexbox.nr) layoutParams).fx();
        }
        if (i == -1 || i == flexItemCount || i >= this.b.getFlexItemCount()) {
            nrVar.u = flexItemCount;
        } else {
            nrVar.u = i;
            while (i < flexItemCount) {
                listNr.get(i).u++;
                i++;
            }
        }
        listNr.add(nrVar);
        return u(flexItemCount + 1, listNr, sparseIntArray);
    }

    private int b(com.bytedance.adsdk.ugeno.flexbox.nr nrVar, boolean z) {
        if (z) {
            return nrVar.k();
        }
        return nrVar.my();
    }

    private int fx(com.bytedance.adsdk.ugeno.flexbox.nr nrVar, boolean z) {
        if (z) {
            return nrVar.mv();
        }
        return nrVar.s();
    }

    private List<nr> nr(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) this.b.u(i2).getLayoutParams();
            nr nrVar2 = new nr();
            nrVar2.nr = nrVar.fx();
            nrVar2.u = i2;
            arrayList.add(nrVar2);
        }
        return arrayList;
    }

    private void fx(int i) {
        boolean[] zArr = this.pn;
        if (zArr == null) {
            this.pn = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.pn = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public boolean nr(SparseIntArray sparseIntArray) {
        int flexItemCount = this.b.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewU = this.b.u(i);
            if (viewU != null && ((com.bytedance.adsdk.ugeno.flexbox.nr) viewU.getLayoutParams()).fx() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void nr(u uVar, int i, int i2) {
        u(uVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<fx>) null);
    }

    private int nr(boolean z) {
        if (z) {
            return this.b.getPaddingEnd();
        }
        return this.b.getPaddingBottom();
    }

    public int[] u(SparseIntArray sparseIntArray) {
        int flexItemCount = this.b.getFlexItemCount();
        return u(flexItemCount, nr(flexItemCount), sparseIntArray);
    }

    private int nr(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int[] u(int i, List<nr> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (nr nrVar : list) {
            int i3 = nrVar.u;
            iArr[i2] = i3;
            sparseIntArray.append(i3, nrVar.nr);
            i2++;
        }
        return iArr;
    }

    private int nr(com.bytedance.adsdk.ugeno.flexbox.nr nrVar, boolean z) {
        if (z) {
            return nrVar.nr();
        }
        return nrVar.u();
    }

    private void nr(int i, int i2, fx fxVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        int i7 = fxVar.pn;
        float f = fxVar.t;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i7) {
            return;
        }
        float f3 = (i7 - i3) / f;
        fxVar.pn = i4 + fxVar.iz;
        if (!z) {
            fxVar.x = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < fxVar.n) {
            int i10 = fxVar.k + i8;
            View viewNr = this.b.nr(i10);
            if (viewNr == null || viewNr.getVisibility() == 8) {
                i5 = i7;
                i6 = i8;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) viewNr.getLayoutParams();
                int flexDirection = this.b.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewNr.getMeasuredHeight();
                    long[] jArr = this.iz;
                    if (jArr != null) {
                        measuredHeight = nr(jArr[i10]);
                    }
                    int measuredWidth = viewNr.getMeasuredWidth();
                    long[] jArr2 = this.iz;
                    if (jArr2 != null) {
                        measuredWidth = u(jArr2[i10]);
                    }
                    if (this.pn[i10] || nrVar.pn() <= f2) {
                        i5 = i7;
                        i6 = i8;
                    } else {
                        float fPn = measuredHeight - (nrVar.pn() * f3);
                        if (i8 == fxVar.n - 1) {
                            fPn += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fPn);
                        if (iRound < nrVar.n()) {
                            iRound = nrVar.n();
                            this.pn[i10] = true;
                            fxVar.t -= nrVar.pn();
                            i5 = i7;
                            i6 = i8;
                            z2 = true;
                        } else {
                            f4 += fPn - iRound;
                            i5 = i7;
                            i6 = i8;
                            double d = f4;
                            if (d > 1.0d) {
                                iRound++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f4 += 1.0f;
                            }
                        }
                        int iU = u(i, nrVar, fxVar.mv);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewNr.measure(iU, iMakeMeasureSpec);
                        measuredWidth = viewNr.getMeasuredWidth();
                        int measuredHeight2 = viewNr.getMeasuredHeight();
                        u(i10, iU, iMakeMeasureSpec, viewNr);
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i9, measuredWidth + nrVar.mv() + nrVar.k() + this.b.u(viewNr));
                    fxVar.pn += measuredHeight + nrVar.s() + nrVar.my();
                } else {
                    i5 = i7;
                    int i11 = i8;
                    int measuredWidth2 = viewNr.getMeasuredWidth();
                    long[] jArr3 = this.iz;
                    if (jArr3 != null) {
                        measuredWidth2 = u(jArr3[i10]);
                    }
                    int measuredHeight3 = viewNr.getMeasuredHeight();
                    long[] jArr4 = this.iz;
                    if (jArr4 != null) {
                        measuredHeight3 = nr(jArr4[i10]);
                    }
                    if (this.pn[i10] || nrVar.pn() <= 0.0f) {
                        i6 = i11;
                    } else {
                        float fPn2 = measuredWidth2 - (nrVar.pn() * f3);
                        i6 = i11;
                        if (i6 == fxVar.n - 1) {
                            fPn2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fPn2);
                        if (iRound2 < nrVar.x()) {
                            iRound2 = nrVar.x();
                            this.pn[i10] = true;
                            fxVar.t -= nrVar.pn();
                            z2 = true;
                        } else {
                            f4 += fPn2 - iRound2;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f4 += 1.0f;
                            }
                        }
                        int iNr = nr(i2, nrVar, fxVar.mv);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewNr.measure(iMakeMeasureSpec2, iNr);
                        int measuredWidth3 = viewNr.getMeasuredWidth();
                        int measuredHeight4 = viewNr.getMeasuredHeight();
                        u(i10, iMakeMeasureSpec2, iNr, viewNr);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int iMax2 = Math.max(i9, measuredHeight3 + nrVar.s() + nrVar.my() + this.b.u(viewNr));
                    fxVar.pn += measuredWidth2 + nrVar.mv() + nrVar.k();
                    iMax = iMax2;
                }
                fxVar.x = Math.max(fxVar.x, iMax);
                i9 = iMax;
            }
            i8 = i6 + 1;
            i7 = i5;
            f2 = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == fxVar.pn) {
            return;
        }
        nr(i, i2, fxVar, i3, i4, true);
    }

    public void u(u uVar, int i, int i2) {
        u(uVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<fx>) null);
    }

    public void u(u uVar, int i, int i2, int i3, int i4, int i5, List<fx> list) {
        int i6;
        u uVar2;
        int i7;
        int i8;
        int i9;
        List<fx> list2;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        fx fxVar;
        int i18;
        int i19 = i;
        int i20 = i2;
        int i21 = i5;
        boolean zU = this.b.u();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<fx> arrayList = list == null ? new ArrayList() : list;
        uVar.u = arrayList;
        boolean z = i21 == -1;
        int iU = u(zU);
        int iNr = nr(zU);
        int iFx = fx(zU);
        int iB = b(zU);
        fx fxVar2 = new fx();
        int i22 = i4;
        fxVar2.k = i22;
        int i23 = iNr + iU;
        fxVar2.pn = i23;
        int flexItemCount = this.b.getFlexItemCount();
        boolean z2 = z;
        int i24 = 0;
        int iCombineMeasuredStates = 0;
        int i25 = 0;
        int i26 = Integer.MIN_VALUE;
        while (true) {
            if (i22 >= flexItemCount) {
                i6 = iCombineMeasuredStates;
                uVar2 = uVar;
                break;
            }
            View viewNr = this.b.nr(i22);
            if (viewNr == null) {
                if (u(i22, flexItemCount, fxVar2)) {
                    u(arrayList, fxVar2, i22, i24);
                }
            } else if (viewNr.getVisibility() == 8) {
                fxVar2.f5026a++;
                fxVar2.n++;
                if (u(i22, flexItemCount, fxVar2)) {
                    u(arrayList, fxVar2, i22, i24);
                }
            } else {
                if (viewNr instanceof CompoundButton) {
                    u((CompoundButton) viewNr);
                }
                com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) viewNr.getLayoutParams();
                int i27 = flexItemCount;
                if (nrVar.iz() == 4) {
                    fxVar2.s.add(Integer.valueOf(i22));
                }
                int iU2 = u(nrVar, zU);
                if (nrVar.l() != -1.0f && mode == 1073741824) {
                    iU2 = Math.round(size * nrVar.l());
                }
                if (zU) {
                    int iU3 = this.b.u(i19, i23 + fx(nrVar, true) + b(nrVar, true), iU2);
                    i7 = size;
                    i8 = mode;
                    int iNr2 = this.b.nr(i20, iFx + iB + pn(nrVar, true) + iz(nrVar, true) + i24, nr(nrVar, true));
                    viewNr.measure(iU3, iNr2);
                    u(i22, iU3, iNr2, viewNr);
                    i9 = iU3;
                } else {
                    i7 = size;
                    i8 = mode;
                    int iU4 = this.b.u(i20, iFx + iB + pn(nrVar, false) + iz(nrVar, false) + i24, nr(nrVar, false));
                    int iNr3 = this.b.nr(i19, fx(nrVar, false) + i23 + b(nrVar, false), iU2);
                    viewNr.measure(iU4, iNr3);
                    u(i22, iU4, iNr3, viewNr);
                    i9 = iNr3;
                }
                u(viewNr, i22);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewNr.getMeasuredState());
                int i28 = i24;
                int i29 = i23;
                fx fxVar3 = fxVar2;
                int i30 = i22;
                list2 = arrayList;
                int i31 = i9;
                if (u(viewNr, i8, i7, fxVar2.pn, b(nrVar, zU) + u(viewNr, zU) + fx(nrVar, zU), nrVar, i30, i25, arrayList.size())) {
                    if (fxVar3.nr() > 0) {
                        if (i30 > 0) {
                            i18 = i30 - 1;
                            fxVar = fxVar3;
                        } else {
                            fxVar = fxVar3;
                            i18 = 0;
                        }
                        u(list2, fxVar, i18, i28);
                        i24 = fxVar.x + i28;
                    } else {
                        i24 = i28;
                    }
                    if (zU) {
                        if (nrVar.nr() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.u uVar3 = this.b;
                            i10 = i2;
                            i22 = i30;
                            view = viewNr;
                            view.measure(i31, uVar3.nr(i10, uVar3.getPaddingTop() + this.b.getPaddingBottom() + nrVar.s() + nrVar.my() + i24, nrVar.nr()));
                            u(view, i22);
                        } else {
                            i10 = i2;
                            view = viewNr;
                            i22 = i30;
                        }
                    } else {
                        i10 = i2;
                        view = viewNr;
                        i22 = i30;
                        if (nrVar.u() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.u uVar4 = this.b;
                            view.measure(uVar4.u(i10, uVar4.getPaddingLeft() + this.b.getPaddingRight() + nrVar.mv() + nrVar.k() + i24, nrVar.u()), i31);
                            u(view, i22);
                        }
                    }
                    fxVar2 = new fx();
                    i12 = 1;
                    fxVar2.n = 1;
                    i11 = i29;
                    fxVar2.pn = i11;
                    fxVar2.k = i22;
                    i13 = 0;
                    i14 = Integer.MIN_VALUE;
                } else {
                    i10 = i2;
                    view = viewNr;
                    i22 = i30;
                    fxVar2 = fxVar3;
                    i11 = i29;
                    i12 = 1;
                    fxVar2.n++;
                    i13 = i25 + 1;
                    i24 = i28;
                    i14 = i26;
                }
                fxVar2.o |= nrVar.b() != 0.0f;
                fxVar2.sx |= nrVar.pn() != 0.0f;
                int[] iArr = this.u;
                if (iArr != null) {
                    iArr[i22] = list2.size();
                }
                fxVar2.pn += u(view, zU) + fx(nrVar, zU) + b(nrVar, zU);
                fxVar2.jk += nrVar.b();
                fxVar2.t += nrVar.pn();
                this.b.u(view, i22, i13, fxVar2);
                int iMax = Math.max(i14, nr(view, zU) + pn(nrVar, zU) + iz(nrVar, zU) + this.b.u(view));
                fxVar2.x = Math.max(fxVar2.x, iMax);
                if (zU) {
                    if (this.b.getFlexWrap() != 2) {
                        fxVar2.l = Math.max(fxVar2.l, view.getBaseline() + nrVar.s());
                    } else {
                        fxVar2.l = Math.max(fxVar2.l, (view.getMeasuredHeight() - view.getBaseline()) + nrVar.my());
                    }
                }
                i15 = i27;
                if (u(i22, i15, fxVar2)) {
                    u(list2, fxVar2, i22, i24);
                    i24 += fxVar2.x;
                }
                i16 = i5;
                if (i16 == -1 || list2.size() <= 0 || list2.get(list2.size() - i12).my < i16 || i22 < i16 || z2) {
                    i17 = i3;
                } else {
                    i24 = -fxVar2.u();
                    i17 = i3;
                    z2 = true;
                }
                if (i24 > i17 && z2) {
                    uVar2 = uVar;
                    i6 = iCombineMeasuredStates;
                    break;
                }
                i25 = i13;
                i26 = iMax;
                i22++;
                i19 = i;
                flexItemCount = i15;
                i20 = i10;
                i23 = i11;
                arrayList = list2;
                size = i7;
                i21 = i16;
                mode = i8;
            }
            i7 = size;
            i8 = mode;
            i10 = i20;
            i16 = i21;
            list2 = arrayList;
            i11 = i23;
            i15 = flexItemCount;
            i22++;
            i19 = i;
            flexItemCount = i15;
            i20 = i10;
            i23 = i11;
            arrayList = list2;
            size = i7;
            i21 = i16;
            mode = i8;
        }
        uVar2.nr = i6;
    }

    private int nr(int i, com.bytedance.adsdk.ugeno.flexbox.nr nrVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.u uVar = this.b;
        int iNr = uVar.nr(i, uVar.getPaddingTop() + this.b.getPaddingBottom() + nrVar.s() + nrVar.my() + i2, nrVar.nr());
        int size = View.MeasureSpec.getSize(iNr);
        if (size > nrVar.jk()) {
            return View.MeasureSpec.makeMeasureSpec(nrVar.jk(), View.MeasureSpec.getMode(iNr));
        }
        return size < nrVar.n() ? View.MeasureSpec.makeMeasureSpec(nrVar.n(), View.MeasureSpec.getMode(iNr)) : iNr;
    }

    public void nr(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.b.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        }
        List<fx> flexLinesInternal = this.b.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.b.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).x = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.b.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    fx fxVar = new fx();
                    fxVar.x = i5;
                    flexLinesInternal.add(0, fxVar);
                    return;
                }
                if (alignContent == 2) {
                    this.b.setFlexLines(u(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i4 < size4) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                fx fxVar2 = new fx();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    fxVar2.x = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    fxVar2.x = Math.round(size3);
                                }
                                int i6 = fxVar2.x;
                                f += size3 - i6;
                                if (f > 1.0f) {
                                    fxVar2.x = i6 + 1;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    fxVar2.x = i6 - 1;
                                    f += 1.0f;
                                }
                                arrayList.add(fxVar2);
                            }
                            i4++;
                        }
                        this.b.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.b.setFlexLines(u(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    fx fxVar3 = new fx();
                    fxVar3.x = size5;
                    for (fx fxVar4 : flexLinesInternal) {
                        arrayList2.add(fxVar3);
                        arrayList2.add(fxVar4);
                        arrayList2.add(fxVar3);
                    }
                    this.b.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        fx fxVar5 = flexLinesInternal.get(i4);
                        float f3 = fxVar5.x + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        fxVar5.x = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private void u(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) compoundButton.getLayoutParams();
        int iX = nrVar.x();
        int iN = nrVar.n();
        Drawable drawableU = com.bytedance.adsdk.ugeno.iz.pn.u(compoundButton);
        int minimumWidth = drawableU == null ? 0 : drawableU.getMinimumWidth();
        int minimumHeight = drawableU != null ? drawableU.getMinimumHeight() : 0;
        if (iX == -1) {
            iX = minimumWidth;
        }
        nrVar.u(iX);
        if (iN == -1) {
            iN = minimumHeight;
        }
        nrVar.nr(iN);
    }

    private int u(boolean z) {
        if (z) {
            return this.b.getPaddingStart();
        }
        return this.b.getPaddingTop();
    }

    private int u(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private void nr(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - nrVar.mv()) - nrVar.k()) - this.b.u(view), nrVar.x()), nrVar.a());
        long[] jArr = this.iz;
        if (jArr != null) {
            measuredHeight = nr(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        u(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    private int u(com.bytedance.adsdk.ugeno.flexbox.nr nrVar, boolean z) {
        if (z) {
            return nrVar.u();
        }
        return nrVar.nr();
    }

    private boolean u(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.flexbox.nr nrVar, int i5, int i6, int i7) {
        if (this.b.getFlexWrap() == 0) {
            return false;
        }
        if (nrVar.t()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.b.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iU = this.b.u(view, i5, i6);
        if (iU > 0) {
            i4 += iU;
        }
        return i2 < i3 + i4;
    }

    private boolean u(int i, int i2, fx fxVar) {
        return i == i2 - 1 && fxVar.nr() != 0;
    }

    private void u(List<fx> list, fx fxVar, int i, int i2) {
        fxVar.mv = i2;
        this.b.u(fxVar);
        fxVar.my = i;
        list.add(fxVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(View view, int i) {
        boolean z;
        com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < nrVar.x()) {
            measuredWidth = nrVar.x();
        } else if (measuredWidth > nrVar.a()) {
            measuredWidth = nrVar.a();
        } else {
            z = false;
            if (measuredHeight >= nrVar.n()) {
                measuredHeight = nrVar.n();
            } else if (measuredHeight > nrVar.jk()) {
                measuredHeight = nrVar.jk();
            } else {
                z2 = z;
            }
            if (z2) {
                return;
            }
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            u(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
            return;
        }
        z = true;
        if (measuredHeight >= nrVar.n()) {
        }
        if (z2) {
        }
    }

    public void u(int i, int i2) {
        u(i, i2, 0);
    }

    public void u(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        fx(this.b.getFlexItemCount());
        if (i3 >= this.b.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.b.getFlexDirection();
        int flexDirection2 = this.b.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = this.b.getLargestMainSize();
            }
            paddingLeft = this.b.getPaddingTop();
            paddingRight = this.b.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.b.getLargestMainSize();
            if (mode2 != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.b.getPaddingLeft();
            paddingRight = this.b.getPaddingRight();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.u;
        List<fx> flexLinesInternal = this.b.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            fx fxVar = flexLinesInternal.get(i5);
            int i6 = fxVar.pn;
            if (i6 < size && fxVar.o) {
                u(i, i2, fxVar, size, i4, false);
            } else if (i6 > size && fxVar.sx) {
                nr(i, i2, fxVar, size, i4, false);
            }
        }
    }

    private void u(int i, int i2, fx fxVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        double d;
        int i7;
        double d2;
        float f = fxVar.jk;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = fxVar.pn)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        fxVar.pn = i4 + fxVar.iz;
        if (!z) {
            fxVar.x = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < fxVar.n) {
            int i10 = fxVar.k + i8;
            View viewNr = this.b.nr(i10);
            if (viewNr == null || viewNr.getVisibility() == 8) {
                i6 = i5;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) viewNr.getLayoutParams();
                int flexDirection = this.b.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewNr.getMeasuredHeight();
                    long[] jArr = this.iz;
                    if (jArr != null) {
                        measuredHeight = nr(jArr[i10]);
                    }
                    int measuredWidth = viewNr.getMeasuredWidth();
                    long[] jArr2 = this.iz;
                    if (jArr2 != null) {
                        measuredWidth = u(jArr2[i10]);
                    }
                    if (this.pn[i10] || nrVar.b() <= f2) {
                        i7 = i5;
                    } else {
                        float fB = measuredHeight + (nrVar.b() * f3);
                        if (i8 == fxVar.n - 1) {
                            fB += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fB);
                        if (iRound > nrVar.jk()) {
                            iRound = nrVar.jk();
                            this.pn[i10] = true;
                            fxVar.jk -= nrVar.b();
                            i7 = i5;
                            z2 = true;
                        } else {
                            f4 += fB - iRound;
                            i7 = i5;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                iRound++;
                                d2 = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d2 = d3 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int iU = u(i, nrVar, fxVar.mv);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewNr.measure(iU, iMakeMeasureSpec);
                        measuredWidth = viewNr.getMeasuredWidth();
                        int measuredHeight2 = viewNr.getMeasuredHeight();
                        u(i10, iU, iMakeMeasureSpec, viewNr);
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i9, measuredWidth + nrVar.mv() + nrVar.k() + this.b.u(viewNr));
                    fxVar.pn += measuredHeight + nrVar.s() + nrVar.my();
                    i6 = i7;
                } else {
                    int i11 = i5;
                    int measuredWidth2 = viewNr.getMeasuredWidth();
                    long[] jArr3 = this.iz;
                    if (jArr3 != null) {
                        measuredWidth2 = u(jArr3[i10]);
                    }
                    int measuredHeight3 = viewNr.getMeasuredHeight();
                    long[] jArr4 = this.iz;
                    i6 = i11;
                    if (jArr4 != null) {
                        measuredHeight3 = nr(jArr4[i10]);
                    }
                    if (!this.pn[i10] && nrVar.b() > 0.0f) {
                        float fB2 = measuredWidth2 + (nrVar.b() * f3);
                        if (i8 == fxVar.n - 1) {
                            fB2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fB2);
                        if (iRound2 > nrVar.a()) {
                            iRound2 = nrVar.a();
                            this.pn[i10] = true;
                            fxVar.jk -= nrVar.b();
                            z2 = true;
                        } else {
                            f4 += fB2 - iRound2;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d = d4 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int iNr = nr(i2, nrVar, fxVar.mv);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewNr.measure(iMakeMeasureSpec2, iNr);
                        int measuredWidth3 = viewNr.getMeasuredWidth();
                        int measuredHeight4 = viewNr.getMeasuredHeight();
                        u(i10, iMakeMeasureSpec2, iNr, viewNr);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int iMax2 = Math.max(i9, measuredHeight3 + nrVar.s() + nrVar.my() + this.b.u(viewNr));
                    fxVar.pn += measuredWidth2 + nrVar.mv() + nrVar.k();
                    iMax = iMax2;
                }
                fxVar.x = Math.max(fxVar.x, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i12 = i5;
        if (!z2 || i12 == fxVar.pn) {
            return;
        }
        u(i, i2, fxVar, i3, i4, true);
    }

    private int u(int i, com.bytedance.adsdk.ugeno.flexbox.nr nrVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.u uVar = this.b;
        int iU = uVar.u(i, uVar.getPaddingLeft() + this.b.getPaddingRight() + nrVar.mv() + nrVar.k() + i2, nrVar.u());
        int size = View.MeasureSpec.getSize(iU);
        if (size > nrVar.a()) {
            return View.MeasureSpec.makeMeasureSpec(nrVar.a(), View.MeasureSpec.getMode(iU));
        }
        return size < nrVar.x() ? View.MeasureSpec.makeMeasureSpec(nrVar.x(), View.MeasureSpec.getMode(iU)) : iU;
    }

    private List<fx> u(List<fx> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        fx fxVar = new fx();
        fxVar.x = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(fxVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(fxVar);
            }
        }
        return arrayList;
    }

    public void u() {
        u(0);
    }

    public void u(int i) {
        View viewNr;
        if (i >= this.b.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.b.getFlexDirection();
        if (this.b.getAlignItems() == 4) {
            int[] iArr = this.u;
            List<fx> flexLinesInternal = this.b.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                fx fxVar = flexLinesInternal.get(i2);
                int i3 = fxVar.n;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = fxVar.k + i4;
                    if (i4 < this.b.getFlexItemCount() && (viewNr = this.b.nr(i5)) != null && viewNr.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) viewNr.getLayoutParams();
                        if (nrVar.iz() == -1 || nrVar.iz() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                }
                                nr(viewNr, fxVar.x, i5);
                            } else {
                                u(viewNr, fxVar.x, i5);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (fx fxVar2 : this.b.getFlexLinesInternal()) {
            for (Integer num : fxVar2.s) {
                View viewNr2 = this.b.nr(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                    }
                    nr(viewNr2, fxVar2.x, num.intValue());
                } else {
                    u(viewNr2, fxVar2.x, num.intValue());
                }
            }
        }
    }

    private void u(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - nrVar.s()) - nrVar.my()) - this.b.u(view), nrVar.n()), nrVar.jk());
        long[] jArr = this.iz;
        if (jArr != null) {
            measuredWidth = u(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        u(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    public void u(View view, fx fxVar, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) view.getLayoutParams();
        int alignItems = this.b.getAlignItems();
        if (nrVar.iz() != -1) {
            alignItems = nrVar.iz();
        }
        int i5 = fxVar.x;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.b.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - nrVar.my(), i3, i6 - nrVar.my());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + nrVar.s(), i3, (i4 - i5) + view.getMeasuredHeight() + nrVar.s());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + nrVar.s()) - nrVar.my()) / 2;
                if (this.b.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.b.getFlexWrap() != 2) {
                    int iMax = Math.max(fxVar.l - view.getBaseline(), nrVar.s());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((fxVar.l - view.getMeasuredHeight()) + view.getBaseline(), nrVar.my());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.b.getFlexWrap() != 2) {
            view.layout(i, i2 + nrVar.s(), i3, i4 + nrVar.s());
        } else {
            view.layout(i, i2 - nrVar.my(), i3, i4 - nrVar.my());
        }
    }

    public void u(View view, fx fxVar, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.nr nrVar = (com.bytedance.adsdk.ugeno.flexbox.nr) view.getLayoutParams();
        int alignItems = this.b.getAlignItems();
        if (nrVar.iz() != -1) {
            alignItems = nrVar.iz();
        }
        int i5 = fxVar.x;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - nrVar.k(), i2, ((i3 + i5) - view.getMeasuredWidth()) - nrVar.k(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + nrVar.mv(), i2, (i3 - i5) + view.getMeasuredWidth() + nrVar.mv(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + iz.u(marginLayoutParams)) - iz.nr(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + nrVar.mv(), i2, i3 + nrVar.mv(), i4);
        } else {
            view.layout(i - nrVar.k(), i2, i3 - nrVar.k(), i4);
        }
    }

    private void u(int i, int i2, int i3, View view) {
        long[] jArr = this.nr;
        if (jArr != null) {
            jArr[i] = nr(i2, i3);
        }
        long[] jArr2 = this.iz;
        if (jArr2 != null) {
            jArr2[i] = nr(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}
