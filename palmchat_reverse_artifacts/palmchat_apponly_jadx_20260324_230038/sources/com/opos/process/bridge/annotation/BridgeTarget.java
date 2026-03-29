package com.opos.process.bridge.annotation;

import com.opos.process.bridge.a.a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface BridgeTarget {
    a bridgeType();

    boolean makeInterface() default false;

    String[] providerAuthorities() default {};

    String[] serviceActions() default {};

    Class<? extends IBridgeTargetIdentify> targetIdentify() default NullBridgeTargetIdentify.class;

    Class<?> targetProvider() default Object.class;
}
