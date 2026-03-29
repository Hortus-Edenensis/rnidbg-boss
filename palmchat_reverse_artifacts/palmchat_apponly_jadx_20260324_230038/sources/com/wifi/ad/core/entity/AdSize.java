package com.wifi.ad.core.entity;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\t\u0010%\u001a\u00020\u001bHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006("}, d2 = {"Lcom/wifi/ad/core/entity/AdSize;", "", "width", "", "height", "(FF)V", "getHeight", "()F", "setHeight", "(F)V", "getWidth", "setWidth", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "getBZHeight", "getBZWidth", "getBdHeight", "getBdWidth", "getCsjHeight", "getCsjWidth", "getFSHeight", "getFSWidth", "getGdtHeight", "", "getGdtWidth", "getHuaWeiWidth", "getHuaWieHeight", "getKsHeight", "getKsWidth", "getOppoHeight", "getOppoWidth", "getQMHeight", "getQMWidth", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 1, 16})
public final /* data */ class AdSize {
    private float height;
    private float width;

    /* JADX WARN: Illegal instructions before constructor call */
    public AdSize() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public static /* synthetic */ AdSize copy$default(AdSize adSize, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = adSize.width;
        }
        if ((i & 2) != 0) {
            f2 = adSize.height;
        }
        return adSize.copy(f, f2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    public final AdSize copy(@NonNull float width, @NonNull float height) {
        return new AdSize(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        return Float.compare(this.width, adSize.width) == 0 && Float.compare(this.height, adSize.height) == 0;
    }

    public final float getBZHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getBZWidth() {
        return this.width;
    }

    public final float getBdHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getBdWidth() {
        return this.width;
    }

    public final float getCsjHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getCsjWidth() {
        return this.width;
    }

    public final float getFSHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getFSWidth() {
        return this.width;
    }

    public final int getGdtHeight() {
        return (int) this.height;
    }

    public final int getGdtWidth() {
        if (Float.valueOf(this.width).equals(Float.valueOf(640.0f))) {
            return -1;
        }
        return (int) this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getHuaWeiWidth() {
        return this.width;
    }

    public final float getHuaWieHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getKsHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getKsWidth() {
        return this.width;
    }

    public final float getOppoHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getOppoWidth() {
        return this.width;
    }

    public final float getQMHeight() {
        if (Float.valueOf(this.height).equals(Float.valueOf(-2))) {
            return 0.0f;
        }
        return this.height;
    }

    public final float getQMWidth() {
        return this.width;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.height);
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public final void setWidth(float f) {
        this.width = f;
    }

    public String toString() {
        return "AdSize(width=" + this.width + ", height=" + this.height + ")";
    }

    public AdSize(@NonNull float f, @NonNull float f2) {
        this.width = f;
        this.height = f2;
    }

    public /* synthetic */ AdSize(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 640.0f : f, (i & 2) != 0 ? -2 : f2);
    }
}
