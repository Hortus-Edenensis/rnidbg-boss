package com.heytap.msp.ipc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IPCModule {
    String[] authsOrActions() default {};

    IPCType ipcType() default IPCType.UNKNOWN;

    String targetComponentClass() default "";

    String targetModuleClass() default "";

    String targetPackage() default "com.heytap.htms";
}
