package com.ss.bytertc.engine.data;

import androidx.annotation.RequiresApi;
import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 15)
public enum ColorSpace {
    UNKNOWN(0),
    BT601_LIMITED_RANGE(1),
    BT601_FULL_RANGE(2),
    BT709_LIMITED_RANGE(3),
    BT709_FULL_RANGE(4);

    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.ColorSpace$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$ColorSpace;

        static {
            int[] iArr = new int[ColorSpace.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$ColorSpace = iArr;
            try {
                iArr[ColorSpace.BT601_LIMITED_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ColorSpace.BT601_FULL_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ColorSpace.BT709_LIMITED_RANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ColorSpace.BT709_FULL_RANGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    ColorSpace(int i) {
        this.value = i;
    }

    @CalledByNative
    public static ColorSpace fromId(int i) {
        for (ColorSpace colorSpace : values()) {
            if (colorSpace.value() == i) {
                return colorSpace;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "kColorSpaceUnknown" : "kColorSpaceYCbCrBT709FullRange" : "kColorSpaceYCbCrBT709LimitedRange" : "kColorSpaceYCbCrBT601FullRange" : "kColorSpaceYCbCrBT601LimitedRange";
    }

    @CalledByNative
    public int value() {
        return this.value;
    }
}
