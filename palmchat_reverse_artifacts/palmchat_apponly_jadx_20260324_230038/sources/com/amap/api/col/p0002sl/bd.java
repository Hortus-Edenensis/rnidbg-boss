package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Point;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bd extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah f2633a;

    public bd(Context context, ah ahVar) {
        super(context);
        this.f2633a = ahVar;
        setWillNotDraw(false);
    }

    private void b(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, ((ViewGroup.LayoutParams) aVar).width, ((ViewGroup.LayoutParams) aVar).height, iArr);
        if (view instanceof cm) {
            a((cm) view, iArr, aVar.e);
            return;
        }
        if (view instanceof ay) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], aVar.e);
            return;
        }
        if (view instanceof y) {
            a(view, iArr[0], iArr[1], 0, 0, aVar.e);
            return;
        }
        LatLng latLng = aVar.b;
        if (latLng != null) {
            af afVar = new af((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
            Point pointA = null;
            try {
                pointA = this.f2633a.c().a(afVar, (Point) null);
            } catch (RemoteException e) {
                ct.a(e, "MapOverlayViewGroup", "layoutMap");
            }
            if (pointA == null) {
                return;
            }
            int i = pointA.x + aVar.c;
            pointA.x = i;
            int i2 = pointA.y + aVar.d;
            pointA.y = i2;
            a(view, iArr[0], iArr[1], i, i2, aVar.e);
        }
    }

    public final void a() {
        onLayout(false, 0, 0, 0, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a aVar = (a) childAt.getLayoutParams();
                        if (aVar.f2634a == 0) {
                            b(childAt, aVar);
                        } else {
                            a(childAt, aVar);
                        }
                    } else {
                        a(childAt, new a(childAt.getLayoutParams()));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, ((ViewGroup.LayoutParams) aVar).width, ((ViewGroup.LayoutParams) aVar).height, iArr);
        a(view, iArr[0], iArr[1], aVar.c, aVar.d, aVar.e);
    }

    private void a(cm cmVar, int[] iArr, int i) {
        int iB = cmVar.b();
        if (iB == 1) {
            a(cmVar, iArr[0], iArr[1], getWidth() - iArr[0], (getHeight() + iArr[1]) / 2, i);
        } else if (iB == 0) {
            a(cmVar, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2634a;
        public LatLng b;
        public int c;
        public int d;
        public int e;

        public a(int i, int i2, LatLng latLng, int i3, int i4, int i5) {
            super(i, i2);
            this.f2634a = 0;
            this.b = latLng;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2634a = 1;
            this.b = null;
            this.c = 0;
            this.d = 0;
            this.e = 51;
        }
    }

    private void a(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private static void a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 & 7;
        int i7 = i5 & 112;
        if (i6 == 5) {
            i3 -= i;
        } else if (i6 == 1) {
            i3 -= i / 2;
        }
        if (i7 == 80) {
            i4 -= i2;
        } else if (i7 == 16) {
            i4 -= i2 / 2;
        }
        view.layout(i3, i4, i + i3, i2 + i4);
    }
}
