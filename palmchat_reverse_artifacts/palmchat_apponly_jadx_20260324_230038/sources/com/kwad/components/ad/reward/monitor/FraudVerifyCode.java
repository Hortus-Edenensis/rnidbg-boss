package com.kwad.components.ad.reward.monitor;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface FraudVerifyCode {
    public static final int RerwardFraudRepeatRequest = 150006;
    public static final int RerwardFraudUnknown = 100001;
    public static final int RerwardFraudValid = 1;
    public static final int RerwardNoEffectiveExposure = 150007;
}
