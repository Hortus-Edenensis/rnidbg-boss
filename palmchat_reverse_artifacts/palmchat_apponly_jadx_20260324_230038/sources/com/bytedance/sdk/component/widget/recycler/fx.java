package com.bytedance.sdk.component.widget.recycler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TimeInterpolator f5182a;
    private ArrayList<RecyclerView.q> jk = new ArrayList<>();
    private ArrayList<RecyclerView.q> t = new ArrayList<>();
    private ArrayList<nr> l = new ArrayList<>();
    private ArrayList<u> mv = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.q>> u = new ArrayList<>();
    ArrayList<ArrayList<nr>> nr = new ArrayList<>();
    ArrayList<ArrayList<u>> fx = new ArrayList<>();
    ArrayList<RecyclerView.q> b = new ArrayList<>();
    ArrayList<RecyclerView.q> pn = new ArrayList<>();
    ArrayList<RecyclerView.q> iz = new ArrayList<>();
    ArrayList<RecyclerView.q> x = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public int b;
        public int fx;
        public int nr;
        public int pn;
        public RecyclerView.q u;

        public nr(RecyclerView.q qVar, int i, int i2, int i3, int i4) {
            this.u = qVar;
            this.nr = i;
            this.fx = i2;
            this.b = i3;
            this.pn = i4;
        }
    }

    private void l(RecyclerView.q qVar) {
        if (f5182a == null) {
            f5182a = new ValueAnimator().getInterpolator();
        }
        qVar.u.animate().setInterpolator(f5182a);
        b(qVar);
    }

    private void t(final RecyclerView.q qVar) {
        final View view = qVar.u;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.iz.add(qVar);
        viewPropertyAnimatorAnimate.setDuration(x()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.fx.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                fx.this.n(qVar);
                fx.this.iz.remove(qVar);
                fx.this.fx();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public void b(RecyclerView.q qVar) {
        View view = qVar.u;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.l.get(size).u == qVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                a(qVar);
                this.l.remove(size);
            }
        }
        u(this.mv, qVar);
        if (this.jk.remove(qVar)) {
            view.setAlpha(1.0f);
            n(qVar);
        }
        if (this.t.remove(qVar)) {
            view.setAlpha(1.0f);
            jk(qVar);
        }
        for (int size2 = this.fx.size() - 1; size2 >= 0; size2--) {
            ArrayList<u> arrayList = this.fx.get(size2);
            u(arrayList, qVar);
            if (arrayList.isEmpty()) {
                this.fx.remove(size2);
            }
        }
        for (int size3 = this.nr.size() - 1; size3 >= 0; size3--) {
            ArrayList<nr> arrayList2 = this.nr.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).u == qVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    a(qVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.nr.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.u.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.q> arrayList3 = this.u.get(size5);
            if (arrayList3.remove(qVar)) {
                view.setAlpha(1.0f);
                jk(qVar);
                if (arrayList3.isEmpty()) {
                    this.u.remove(size5);
                }
            }
        }
        this.iz.remove(qVar);
        this.b.remove(qVar);
        this.x.remove(qVar);
        this.pn.remove(qVar);
        fx();
    }

    public void fx(final RecyclerView.q qVar) {
        final View view = qVar.u;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.b.add(qVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(iz()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.fx.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                fx.this.jk(qVar);
                fx.this.b.remove(qVar);
                fx.this.fx();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.t
    public boolean nr(RecyclerView.q qVar) {
        l(qVar);
        qVar.u.setAlpha(0.0f);
        this.t.add(qVar);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public void u() {
        boolean z = !this.jk.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.mv.isEmpty();
        boolean z4 = !this.t.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.q> it = this.jk.iterator();
            while (it.hasNext()) {
                t(it.next());
            }
            this.jk.clear();
            if (z2) {
                final ArrayList<nr> arrayList = new ArrayList<>();
                arrayList.addAll(this.l);
                this.nr.add(arrayList);
                this.l.clear();
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.fx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (nr nrVar : arrayList) {
                            fx.this.nr(nrVar.u, nrVar.nr, nrVar.fx, nrVar.b, nrVar.pn);
                        }
                        arrayList.clear();
                        fx.this.nr.remove(arrayList);
                    }
                };
                if (z) {
                    com.bytedance.sdk.component.widget.recycler.u.fx.x.u(arrayList.get(0).u.u, runnable, x());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<u> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.mv);
                this.fx.add(arrayList2);
                this.mv.clear();
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.fx.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            fx.this.u((u) it2.next());
                        }
                        arrayList2.clear();
                        fx.this.fx.remove(arrayList2);
                    }
                };
                if (z) {
                    com.bytedance.sdk.component.widget.recycler.u.fx.x.u(arrayList2.get(0).u.u, runnable2, x());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.q> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.t);
                this.u.add(arrayList3);
                this.t.clear();
                Runnable runnable3 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.fx.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            fx.this.fx((RecyclerView.q) it2.next());
                        }
                        arrayList3.clear();
                        fx.this.u.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    com.bytedance.sdk.component.widget.recycler.u.fx.x.u(arrayList3.get(0).u, runnable3, (z ? x() : 0L) + Math.max(z2 ? pn() : 0L, z3 ? n() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public int b;
        public int fx;
        public int iz;
        public RecyclerView.q nr;
        public int pn;
        public RecyclerView.q u;

        private u(RecyclerView.q qVar, RecyclerView.q qVar2) {
            this.u = qVar;
            this.nr = qVar2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.u + ", newHolder=" + this.nr + ", fromX=" + this.fx + ", fromY=" + this.b + ", toX=" + this.pn + ", toY=" + this.iz + '}';
        }

        public u(RecyclerView.q qVar, RecyclerView.q qVar2, int i, int i2, int i3, int i4) {
            this(qVar, qVar2);
            this.fx = i;
            this.b = i2;
            this.pn = i3;
            this.iz = i4;
        }
    }

    public void nr(final RecyclerView.q qVar, int i, int i2, int i3, int i4) {
        final View view = qVar.u;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.pn.add(qVar);
        viewPropertyAnimatorAnimate.setDuration(pn()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.fx.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                fx.this.a(qVar);
                fx.this.pn.remove(qVar);
                fx.this.fx();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    public void fx() {
        if (nr()) {
            return;
        }
        a();
    }

    private void nr(u uVar) {
        RecyclerView.q qVar = uVar.u;
        if (qVar != null) {
            u(uVar, qVar);
        }
        RecyclerView.q qVar2 = uVar.nr;
        if (qVar2 != null) {
            u(uVar, qVar2);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public boolean nr() {
        return (this.t.isEmpty() && this.mv.isEmpty() && this.l.isEmpty() && this.jk.isEmpty() && this.pn.isEmpty() && this.iz.isEmpty() && this.b.isEmpty() && this.x.isEmpty() && this.nr.isEmpty() && this.u.isEmpty() && this.fx.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.t
    public boolean u(RecyclerView.q qVar) {
        l(qVar);
        this.jk.add(qVar);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.t
    public boolean u(RecyclerView.q qVar, int i, int i2, int i3, int i4) {
        View view = qVar.u;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) qVar.u.getTranslationY());
        l(qVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            a(qVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.l.add(new nr(qVar, translationX, translationY, i3, i4));
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public void b() {
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            nr nrVar = this.l.get(size);
            View view = nrVar.u.u;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            a(nrVar.u);
            this.l.remove(size);
        }
        for (int size2 = this.jk.size() - 1; size2 >= 0; size2--) {
            n(this.jk.get(size2));
            this.jk.remove(size2);
        }
        int size3 = this.t.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.q qVar = this.t.get(size3);
            qVar.u.setAlpha(1.0f);
            jk(qVar);
            this.t.remove(size3);
        }
        for (int size4 = this.mv.size() - 1; size4 >= 0; size4--) {
            nr(this.mv.get(size4));
        }
        this.mv.clear();
        if (nr()) {
            for (int size5 = this.nr.size() - 1; size5 >= 0; size5--) {
                ArrayList<nr> arrayList = this.nr.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    nr nrVar2 = arrayList.get(size6);
                    View view2 = nrVar2.u.u;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    a(nrVar2.u);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.nr.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.u.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.q> arrayList2 = this.u.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.q qVar2 = arrayList2.get(size8);
                    qVar2.u.setAlpha(1.0f);
                    jk(qVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.u.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.fx.size() - 1; size9 >= 0; size9--) {
                ArrayList<u> arrayList3 = this.fx.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    nr(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.fx.remove(arrayList3);
                    }
                }
            }
            u(this.iz);
            u(this.pn);
            u(this.b);
            u(this.x);
            a();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.t
    public boolean u(RecyclerView.q qVar, RecyclerView.q qVar2, int i, int i2, int i3, int i4) {
        if (qVar == qVar2) {
            return u(qVar, i, i2, i3, i4);
        }
        float translationX = qVar.u.getTranslationX();
        float translationY = qVar.u.getTranslationY();
        float alpha = qVar.u.getAlpha();
        l(qVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        qVar.u.setTranslationX(translationX);
        qVar.u.setTranslationY(translationY);
        qVar.u.setAlpha(alpha);
        if (qVar2 != null) {
            l(qVar2);
            qVar2.u.setTranslationX(-i5);
            qVar2.u.setTranslationY(-i6);
            qVar2.u.setAlpha(0.0f);
        }
        this.mv.add(new u(qVar, qVar2, i, i2, i3, i4));
        return true;
    }

    public void u(final u uVar) {
        RecyclerView.q qVar = uVar.u;
        final View view = qVar == null ? null : qVar.u;
        RecyclerView.q qVar2 = uVar.nr;
        final View view2 = qVar2 != null ? qVar2.u : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(n());
            this.x.add(uVar.u);
            duration.translationX(uVar.pn - uVar.fx);
            duration.translationY(uVar.iz - uVar.b);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.fx.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    fx.this.u(uVar.u, true);
                    fx.this.x.remove(uVar.u);
                    fx.this.fx();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.x.add(uVar.nr);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(n()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.fx.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    fx.this.u(uVar.nr, false);
                    fx.this.x.remove(uVar.nr);
                    fx.this.fx();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    private void u(List<u> list, RecyclerView.q qVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            u uVar = list.get(size);
            if (u(uVar, qVar) && uVar.u == null && uVar.nr == null) {
                list.remove(uVar);
            }
        }
    }

    private boolean u(u uVar, RecyclerView.q qVar) {
        boolean z = false;
        if (uVar.nr == qVar) {
            uVar.nr = null;
        } else {
            if (uVar.u != qVar) {
                return false;
            }
            uVar.u = null;
            z = true;
        }
        qVar.u.setAlpha(1.0f);
        qVar.u.setTranslationX(0.0f);
        qVar.u.setTranslationY(0.0f);
        u(qVar, z);
        return true;
    }

    public void u(List<RecyclerView.q> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).u.animate().cancel();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public boolean u(RecyclerView.q qVar, List<Object> list) {
        return !list.isEmpty() || super.u(qVar, list);
    }
}
