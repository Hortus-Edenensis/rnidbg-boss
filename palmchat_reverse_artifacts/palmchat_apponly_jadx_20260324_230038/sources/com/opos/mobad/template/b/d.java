package com.opos.mobad.template.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.q;
import com.opos.mobad.template.g.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aa f9314a;
    private Context b;
    private int c;
    private com.opos.mobad.d.a g;
    private g h;
    private com.opos.mobad.template.d.b i;
    private am j;
    private int k;
    private int l;
    private ObjectAnimator m;
    private AnimatorSet n;
    private boolean o;
    private p p;
    private p q;
    private q r;
    private com.opos.mobad.template.cmn.baseview.f s;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    private d(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar, boolean z) {
        super(i);
        this.o = true;
        this.p = new p() { // from class: com.opos.mobad.template.b.d.5
            @Override // com.opos.mobad.template.cmn.p
            public void b(final View view, final int[] iArr) {
                if (d.this.r()) {
                    return;
                }
                d.this.a(new a() { // from class: com.opos.mobad.template.b.d.5.1
                    @Override // com.opos.mobad.template.b.d.a
                    public void a() {
                        d.this.a(view, iArr);
                    }
                });
            }
        };
        this.q = new p() { // from class: com.opos.mobad.template.b.d.6
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                d.this.h(view, iArr);
            }
        };
        this.r = new q() { // from class: com.opos.mobad.template.b.d.7
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                d.this.g(view, iArr);
            }
        };
        this.s = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.b.d.8
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z2) {
                com.opos.cmn.an.f.a.a("BannerNewBigImage", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                d.this.a(view, i3, z2);
            }
        };
        this.b = context.getApplicationContext();
        this.j = amVar;
        this.c = i2;
        this.g = aVar;
        this.o = z;
        i();
    }

    public static com.opos.mobad.template.a b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return b(context, amVar, i, aVar, true);
    }

    public static com.opos.mobad.template.a d(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new d(context, amVar, i, 4, aVar, true);
    }

    private void i() {
        p();
        Context context = this.b;
        am amVar = this.j;
        this.f9314a = new aa(context, new aa.a(amVar.f9704a, amVar.b, this.k / this.l));
        int i = this.c;
        this.h = (i == 0 || i == 1) ? new g(this.b, this.c, this.g, this.o) : i != 2 ? i != 3 ? i != 4 ? new g(this.b, this.c, this.g, this.o) : new e(this.b, this.c, this.g, this.o) : new f(this.b, this.c, this.g, this.o) : new h(this.b, this.c, this.g, this.o);
        this.f9314a.setGravity(1);
        this.f9314a.addView(this.h);
        this.f9314a.setAlpha(0.0f);
    }

    private void p() {
        if (this.j == null) {
            int iA = com.opos.cmn.an.h.f.a.a(this.b, 328.0f);
            this.j = new am(iA, (int) (((double) iA) * 0.6d));
        }
        this.k = com.opos.cmn.an.h.f.a.a(this.b, 328.0f);
        this.l = com.opos.cmn.an.h.f.a.a(this.b, 112.0f);
    }

    private void q() {
        this.f9314a.post(new Runnable() { // from class: com.opos.mobad.template.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
                d.this.n = new AnimatorSet();
                d.this.n.setDuration(500L);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(d.this.f9314a, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(interpolatorCreate);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(d.this.f9314a, "translationX", -(d.this.f9314a.getWidth() - com.opos.cmn.an.h.f.a.a(d.this.b, 200.0f)), 0.0f);
                objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
                d.this.n.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                d.this.n.start();
                d.this.n.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.b.d.1.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.h.d();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        return n() == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.r() || d.this.h == null) {
                    return;
                }
                d.this.h.a(null, 0);
            }
        });
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        g gVar = this.h;
        if (gVar == null) {
            return false;
        }
        gVar.f();
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        this.b = null;
        this.i = null;
        ObjectAnimator objectAnimator = this.m;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.end();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.g();
        }
        aa aaVar = this.f9314a;
        if (aaVar != null) {
            aaVar.clearAnimation();
            this.f9314a.removeAllViews();
        }
    }

    public static com.opos.mobad.template.a b(Context context, am amVar, int i, com.opos.mobad.d.a aVar, boolean z) {
        return new d(context, amVar, i, 1, aVar, z);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f9314a;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        g gVar = this.h;
        if (gVar == null) {
            return false;
        }
        gVar.e();
        return false;
    }

    public static com.opos.mobad.template.a a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return a(context, amVar, i, aVar, true);
    }

    public static com.opos.mobad.template.a c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return c(context, amVar, i, aVar, true);
    }

    public static com.opos.mobad.template.a a(Context context, am amVar, int i, com.opos.mobad.d.a aVar, boolean z) {
        return new d(context, amVar, i, 0, aVar, z);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.c == 3) {
            a(bVar);
        } else if (!c(bVar) && this.c == 2) {
            a(1);
            return;
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a(this.e).b(this.p).a(this.q).a(this.r).a_(this.s).b(bVar.f9413a).c(bVar.b).a(bVar.u).a(bVar.j).a(bVar);
        }
    }

    public static com.opos.mobad.template.a c(Context context, am amVar, int i, com.opos.mobad.d.a aVar, boolean z) {
        return new d(context, amVar, i, 3, aVar, z);
    }

    private boolean c(com.opos.mobad.template.d.b bVar) {
        if ((bVar == null && bVar.c == null) || bVar.c.size() <= 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int iMin = Math.min(bVar.c.size(), 3);
        for (int i = 0; i < iMin; i++) {
            com.opos.mobad.template.d.e eVar = bVar.c.get(i);
            if (eVar != null) {
                a(eVar, arrayList, bVar.y);
            }
        }
        return true;
    }

    public void a(ViewGroup viewGroup, a.InterfaceC0778a interfaceC0778a) {
        if (viewGroup == null || interfaceC0778a == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.b.d.9
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                com.opos.cmn.an.f.a.b("BannerNewBigImageTemplate", "visible change:" + z);
                if (z) {
                    d.this.a((Map<String, String>) null);
                    aVar.a((a.InterfaceC0735a) null);
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.b.d.10
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                com.opos.cmn.an.f.a.b("BannerNewBigImageTemplate", "onViewVisibleWithoutFocus change:" + z + ", " + z2);
                HashMap map = new HashMap();
                map.put("isVisibleRect", String.valueOf(z));
                map.put("isAttached", String.valueOf(z2));
                d.this.b(map);
                aVar.a((a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f9314a, "alpha", 1.0f, 0.0f);
        this.m = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(500L);
        this.m.setInterpolator(interpolatorCreate);
        this.m.start();
        this.m.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.b.d.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                d.this.m.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.b.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.g == null || bVar == null || (eVar = bVar.k) == null || TextUtils.isEmpty(eVar.f9414a)) {
            s();
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 48.0f);
        com.opos.mobad.d.a aVar = this.g;
        com.opos.mobad.template.d.e eVar2 = bVar.k;
        aVar.a(eVar2.f9414a, eVar2.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.b.d.2
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (d.this.r()) {
                    return;
                }
                if (i != 0 && i != 1) {
                    d.this.s();
                    d.this.b(i);
                } else {
                    if (i == 1) {
                        d.this.b(i);
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.b.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled() || d.this.r() || d.this.h == null) {
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(bitmap);
                            d.this.h.a(arrayList, 0);
                        }
                    });
                }
            }
        });
    }

    private void a(com.opos.mobad.template.d.e eVar, final List<Bitmap> list, final int i) {
        this.g.a(eVar.f9414a, eVar.b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.b.d.11
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i2, final Bitmap bitmap) {
                if (d.this.r()) {
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    d.this.b(i2);
                    return;
                }
                if (i2 == 1) {
                    d.this.b(i2);
                }
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.b.d.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 == null || bitmap2.isRecycled() || d.this.r()) {
                            return;
                        }
                        list.add(bitmap);
                        if (d.this.h != null) {
                            g gVar = d.this.h;
                            AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                            gVar.a(list, i);
                        }
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        List<com.opos.mobad.template.d.e> list;
        String str;
        String str2;
        if (fVar == null) {
            a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            str = "BannerNewBigImageTemplate";
            str2 = "render with data null";
        } else {
            if (this.c != 2 || ((list = bVarA.c) != null && list.size() > 0)) {
                b(bVarA);
                if (this.i == null) {
                    q();
                }
                if (this.i == null && this.e != null) {
                    m();
                    a(this.f9314a, this.e);
                }
                this.i = bVarA;
                return;
            }
            str = "";
            str2 = "render with imgList null";
        }
        com.opos.cmn.an.f.a.d(str, str2);
        a(1);
    }
}
