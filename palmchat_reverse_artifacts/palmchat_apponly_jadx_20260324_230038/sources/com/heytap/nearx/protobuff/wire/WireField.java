package com.heytap.nearx.protobuff.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WireField {

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED
    }

    String adapter();

    String keyAdapter() default "";

    a label() default a.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
