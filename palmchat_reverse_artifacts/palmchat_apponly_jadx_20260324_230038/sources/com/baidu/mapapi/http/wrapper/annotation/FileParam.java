package com.baidu.mapapi.http.wrapper.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface FileParam {
    public static final int TYPE_FILE = 0;
    public static final int TYPE_FILE_ARRAY = 1;
    public static final int TYPE_FILE_MAP = 2;
    public static final int TYPE_FILE_MAP_ARRAY = 3;
    public static final int TYPE_FILE_WRAPPER = 4;
    public static final int TYPE_FILE_WRAPPER_ARRAY = 5;
    public static final int TYPE_FILE_WRAPPER_MAP = 6;
    public static final int TYPE_FILE_WRAPPER_MAP_ARRAY = 7;

    int type() default 0;

    String value() default "";
}
