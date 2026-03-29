package com.kwad.components.ad.reward.monitor;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface FraudVerifyType {
    public static final int KSVideoAdFraudResultDefault = 1;
    public static final int KSVideoAdFraudResultFalse = 2;
    public static final int KSVideoAdFraudResultTrue = 3;
}
