package defpackage;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class su4 implements ru4, cq0, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f20848a;
    public View b;
    public View c;
    public View d;
    public View e;
    public int f = 0;
    public boolean g = true;
    public boolean h = true;
    public y35 i = new y35();

    public su4(@NonNull View view) {
        this.c = view;
        this.b = view;
        this.f20848a = view;
    }

    @Override // defpackage.ru4
    public void a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f20848a.getLeft(), -this.f20848a.getTop());
        View view = this.c;
        View view2 = this.f20848a;
        if (view != view2) {
            this.c = l(view2, pointF, view);
        }
        if (this.c == this.f20848a) {
            this.i.f22114a = null;
        } else {
            this.i.f22114a = pointF;
        }
    }

    @Override // defpackage.ru4
    public void b(x35 x35Var) {
        if (x35Var instanceof y35) {
            this.i = (y35) x35Var;
        } else {
            this.i.b = x35Var;
        }
    }

    @Override // defpackage.ru4
    public void c(boolean z) {
        this.i.c = z;
    }

    @Override // defpackage.ru4
    public ValueAnimator.AnimatorUpdateListener d(int i) {
        View view = this.c;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !nf5.c(view, 1)) && (i <= 0 || !nf5.c(this.c, -1))) {
            return null;
        }
        this.f = i;
        return this;
    }

    @Override // defpackage.ru4
    public void e(int i, int i2, int i3) {
        boolean z;
        View viewFindViewById;
        View viewFindViewById2;
        boolean z2 = true;
        if (i2 == -1 || (viewFindViewById2 = this.b.findViewById(i2)) == null) {
            z = false;
        } else if (i > 0) {
            viewFindViewById2.setTranslationY(i);
            z = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z = false;
        }
        if (i3 == -1 || (viewFindViewById = this.b.findViewById(i3)) == null) {
            z2 = z;
        } else if (i < 0) {
            viewFindViewById.setTranslationY(i);
        } else {
            if (viewFindViewById.getTranslationY() < 0.0f) {
                viewFindViewById.setTranslationY(0.0f);
            }
            z2 = z;
        }
        if (z2) {
            this.b.setTranslationY(0.0f);
        } else {
            this.b.setTranslationY(i);
        }
        View view = this.d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i));
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i));
        }
    }

    @Override // defpackage.ru4
    public boolean f() {
        return this.h && this.i.a(this.f20848a);
    }

    @Override // defpackage.ru4
    public void g(wu4 wu4Var, View view, View view2) {
        k(this.f20848a, wu4Var);
        if (view == null && view2 == null) {
            return;
        }
        this.d = view;
        this.e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f20848a.getContext());
        int iIndexOfChild = wu4Var.d().getLayout().indexOfChild(this.f20848a);
        wu4Var.d().getLayout().removeView(this.f20848a);
        frameLayout.addView(this.f20848a, 0, new ViewGroup.LayoutParams(-1, -1));
        wu4Var.d().getLayout().addView(frameLayout, iIndexOfChild, this.f20848a.getLayoutParams());
        this.f20848a = frameLayout;
        if (view != null) {
            view.setTag("fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild2 = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams.height = nf5.i(view);
            viewGroup.addView(new Space(this.f20848a.getContext()), iIndexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
        if (view2 != null) {
            view2.setTag("fixed-bottom");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int iIndexOfChild3 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams2.height = nf5.i(view2);
            viewGroup2.addView(new Space(this.f20848a.getContext()), iIndexOfChild3, layoutParams2);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams3);
        }
    }

    @Override // defpackage.ru4
    @NonNull
    public View getView() {
        return this.f20848a;
    }

    @Override // defpackage.ru4
    @NonNull
    public View h() {
        return this.c;
    }

    @Override // defpackage.ru4
    public boolean i() {
        return this.g && this.i.b(this.f20848a);
    }

    @Override // defpackage.cq0
    public void j(boolean z, boolean z2) {
        this.g = z;
        this.h = z2;
    }

    public void k(View view, wu4 wu4Var) {
        boolean zIsInEditMode = this.f20848a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = m(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!zIsInEditMode) {
                bb1.a(view, wu4Var, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.c = view2;
        }
    }

    public View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (nf5.h(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && nf5.f(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewL = l(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewL;
                }
            }
        }
        return view2;
    }

    public View m(View view, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && nf5.f(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.f) * this.c.getScaleY();
            View view = this.c;
            if (view instanceof AbsListView) {
                nf5.k((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f = iIntValue;
    }
}
