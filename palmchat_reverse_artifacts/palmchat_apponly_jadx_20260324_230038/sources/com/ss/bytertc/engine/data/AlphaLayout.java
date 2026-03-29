package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum AlphaLayout {
    TOP(0),
    BOTTOM(1),
    LEFT(2),
    RIGHT(3);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AlphaLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout;

        static {
            int[] iArr = new int[AlphaLayout.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout = iArr;
            try {
                iArr[AlphaLayout.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[AlphaLayout.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[AlphaLayout.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[AlphaLayout.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    AlphaLayout(int i) {
        this.value = i;
    }

    @CalledByNative
    public static AlphaLayout fromId(int i) {
        for (AlphaLayout alphaLayout : values()) {
            if (alphaLayout.value() == i) {
                return alphaLayout;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "RIGHT" : "LEFT" : "BOTTOM" : "TOP";
    }

    public int value() {
        return this.value;
    }
}
