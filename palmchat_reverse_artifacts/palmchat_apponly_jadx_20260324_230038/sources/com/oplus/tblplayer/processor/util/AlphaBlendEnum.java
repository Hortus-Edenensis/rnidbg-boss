package com.oplus.tblplayer.processor.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AlphaBlendEnum {
    public static final int BLEND_MODE_COMPOSITE = 3;
    public static final int BLEND_MODE_DEFAULT = 1;
    public static final int BLEND_MODE_OVERLAY = 2;
    public static final int BLEND_MODE_UNSET = 0;
    public static final float FLOAT_ALPHA_VAL_0 = 0.0f;
    public static final float FLOAT_ALPHA_VAL_0_5 = 0.5f;
    public static final float FLOAT_ALPHA_VAL_1 = 1.0f;
    public static final int INT_TEXTURE_POOL_CAPACITY_1 = 1;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BlendMode {
    }
}
