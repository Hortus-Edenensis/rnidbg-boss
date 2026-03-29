package com.yuyakaido.android.cardstackview;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public enum SwipeableMethod {
    AutomaticAndManual,
    Automatic,
    Manual,
    None;

    public boolean canSwipe() {
        return canSwipeAutomatically() || canSwipeManually();
    }

    public boolean canSwipeAutomatically() {
        return this == AutomaticAndManual || this == Automatic;
    }

    public boolean canSwipeManually() {
        return this == AutomaticAndManual || this == Manual;
    }
}
