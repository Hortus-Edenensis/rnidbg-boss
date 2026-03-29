package com.yuyakaido.android.cardstackview.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.internal.CardStackSmoothScroller;
import defpackage.qz;
import defpackage.tp5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CardStackSnapHelper extends SnapHelper {
    public int b = 0;
    public int c = 0;

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        if (layoutManager instanceof CardStackLayoutManager) {
            CardStackLayoutManager cardStackLayoutManager = (CardStackLayoutManager) layoutManager;
            if (cardStackLayoutManager.findViewByPosition(cardStackLayoutManager.f()) != null) {
                int translationX = (int) view.getTranslationX();
                int translationY = (int) view.getTranslationY();
                if (translationX != 0 || translationY != 0) {
                    qz qzVarD = cardStackLayoutManager.d();
                    float fAbs = Math.abs(translationX) / view.getWidth();
                    int i = this.c;
                    int i2 = this.b;
                    if (i < i2) {
                        i = i2;
                    }
                    Duration durationFromVelocity = Duration.fromVelocity(i);
                    if (durationFromVelocity != Duration.Fast) {
                        float f = qzVarD.f;
                        if (f < fAbs || f < 0.0f) {
                            CardStackState cardStackStateE = cardStackLayoutManager.e();
                            if (qzVarD.i.contains(cardStackStateE.b())) {
                                CardStackSmoothScroller cardStackSmoothScroller = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.ManualForbidden, cardStackLayoutManager);
                                cardStackSmoothScroller.setTargetPosition(cardStackLayoutManager.f());
                                cardStackLayoutManager.startSmoothScroll(cardStackSmoothScroller);
                            } else if (qzVarD.h.contains(cardStackStateE.b())) {
                                cardStackStateE.g = cardStackStateE.f + 1;
                                cardStackLayoutManager.l(new tp5.a().b(qzVarD.m.a()).c(durationFromVelocity.duration).d(qzVarD.m.b()).a());
                                this.b = 0;
                                this.c = 0;
                                CardStackSmoothScroller cardStackSmoothScroller2 = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.ManualSwipe, cardStackLayoutManager);
                                cardStackSmoothScroller2.setTargetPosition(cardStackLayoutManager.f());
                                cardStackLayoutManager.startSmoothScroll(cardStackSmoothScroller2);
                            } else {
                                CardStackSmoothScroller cardStackSmoothScroller3 = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.ManualCancel, cardStackLayoutManager);
                                cardStackSmoothScroller3.setTargetPosition(cardStackLayoutManager.f());
                                cardStackLayoutManager.startSmoothScroll(cardStackSmoothScroller3);
                            }
                        } else {
                            CardStackSmoothScroller cardStackSmoothScroller4 = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.ManualCancel, cardStackLayoutManager);
                            cardStackSmoothScroller4.setTargetPosition(cardStackLayoutManager.f());
                            cardStackLayoutManager.startSmoothScroll(cardStackSmoothScroller4);
                        }
                    }
                }
            }
        }
        return new int[2];
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof CardStackLayoutManager) {
            CardStackLayoutManager cardStackLayoutManager = (CardStackLayoutManager) layoutManager;
            View viewFindViewByPosition = cardStackLayoutManager.findViewByPosition(cardStackLayoutManager.f());
            if (viewFindViewByPosition != null) {
                int translationX = (int) viewFindViewByPosition.getTranslationX();
                int translationY = (int) viewFindViewByPosition.getTranslationY();
                if (translationX == 0 && translationY == 0) {
                    return null;
                }
                return viewFindViewByPosition;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        this.b = Math.abs(i);
        this.c = Math.abs(i2);
        if (layoutManager instanceof CardStackLayoutManager) {
            return ((CardStackLayoutManager) layoutManager).f();
        }
        return -1;
    }
}
