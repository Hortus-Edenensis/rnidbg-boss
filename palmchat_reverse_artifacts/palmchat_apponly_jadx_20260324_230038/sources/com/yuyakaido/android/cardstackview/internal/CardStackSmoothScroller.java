package com.yuyakaido.android.cardstackview.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.internal.CardStackState;
import defpackage.by4;
import defpackage.ge;
import defpackage.pz;
import defpackage.tp5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CardStackSmoothScroller extends RecyclerView.SmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollType f11801a;
    public CardStackLayoutManager b;

    /* JADX INFO: compiled from: SearchBox */
    public enum ScrollType {
        AutomaticSwipe,
        AutomaticRewind,
        ManualSwipe,
        ManualForbidden,
        ManualCancel
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11802a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Direction.values().length];
            b = iArr;
            try {
                iArr[Direction.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Direction.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Direction.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Direction.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ScrollType.values().length];
            f11802a = iArr2;
            try {
                iArr2[ScrollType.AutomaticSwipe.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11802a[ScrollType.AutomaticRewind.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11802a[ScrollType.ManualSwipe.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11802a[ScrollType.ManualCancel.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11802a[ScrollType.ManualForbidden.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public CardStackSmoothScroller(ScrollType scrollType, CardStackLayoutManager cardStackLayoutManager) {
        this.f11801a = scrollType;
        this.b = cardStackLayoutManager;
    }

    public final int a(ge geVar) {
        int i;
        CardStackState cardStackStateE = this.b.e();
        int i2 = a.b[geVar.a().ordinal()];
        if (i2 == 1) {
            i = -cardStackStateE.b;
        } else {
            if (i2 != 2) {
                return i2 != 3 ? 0 : 0;
            }
            i = cardStackStateE.b;
        }
        return i * 2;
    }

    public final int b(ge geVar) {
        int i;
        CardStackState cardStackStateE = this.b.e();
        int i2 = a.b[geVar.a().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return cardStackStateE.c / 4;
        }
        if (i2 == 3) {
            i = -cardStackStateE.c;
        } else {
            if (i2 != 4) {
                return 0;
            }
            i = cardStackStateE.c;
        }
        return i * 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onSeekTargetStep(int i, int i2, @NonNull RecyclerView.State state, @NonNull RecyclerView.SmoothScroller.Action action) {
        if (this.f11801a == ScrollType.AutomaticRewind) {
            by4 by4Var = this.b.d().n;
            action.update(-a(by4Var), -b(by4Var), by4Var.getDuration(), by4Var.b());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStart() {
        pz pzVarC = this.b.c();
        CardStackState cardStackStateE = this.b.e();
        int i = a.f11802a[this.f11801a.ordinal()];
        if (i == 1) {
            cardStackStateE.f(CardStackState.Status.AutomaticSwipeAnimating);
            pzVarC.d(this.b.g(), this.b.f());
            return;
        }
        if (i == 2) {
            cardStackStateE.f(CardStackState.Status.RewindAnimating);
            return;
        }
        if (i == 3) {
            cardStackStateE.f(CardStackState.Status.ManualSwipeAnimating);
            pzVarC.d(this.b.g(), this.b.f());
        } else if (i == 4 || i == 5) {
            cardStackStateE.f(CardStackState.Status.RewindAnimating);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStop() {
        pz pzVarC = this.b.c();
        int i = a.f11802a[this.f11801a.ordinal()];
        if (i == 2) {
            pzVarC.g();
            pzVarC.f(this.b.g(), this.b.f());
        } else if (i == 4) {
            pzVarC.b();
        } else {
            if (i != 5) {
                return;
            }
            pzVarC.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(@NonNull View view, @NonNull RecyclerView.State state, @NonNull RecyclerView.SmoothScroller.Action action) {
        int translationX = (int) view.getTranslationX();
        int translationY = (int) view.getTranslationY();
        int i = a.f11802a[this.f11801a.ordinal()];
        if (i == 1) {
            tp5 tp5Var = this.b.d().m;
            action.update(-a(tp5Var), -b(tp5Var), tp5Var.getDuration(), tp5Var.b());
            return;
        }
        if (i == 2) {
            by4 by4Var = this.b.d().n;
            action.update(translationX, translationY, by4Var.getDuration(), by4Var.b());
        } else if (i == 3) {
            tp5 tp5Var2 = this.b.d().m;
            action.update((-translationX) * 10, (-translationY) * 10, tp5Var2.getDuration(), tp5Var2.b());
        } else if (i == 4 || i == 5) {
            by4 by4Var2 = this.b.d().n;
            action.update(translationX, translationY, by4Var2.getDuration(), by4Var2.b());
        }
    }
}
