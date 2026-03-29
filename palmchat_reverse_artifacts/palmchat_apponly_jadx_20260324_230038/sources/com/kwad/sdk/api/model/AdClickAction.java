package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface AdClickAction {
    public static final int CLICK = 1;
    public static final int NOT_CLICK = 0;
    public static final int UNKNOWN = 2;
}
