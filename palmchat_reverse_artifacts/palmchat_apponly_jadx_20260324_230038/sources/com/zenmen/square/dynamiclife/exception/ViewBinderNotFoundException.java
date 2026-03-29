package com.zenmen.square.dynamiclife.exception;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ViewBinderNotFoundException extends RuntimeException {
    public ViewBinderNotFoundException(@NonNull Class<?> cls) {
        super(String.format("Do you have registered the binder for %s.class in the adapter?", cls.getSimpleName()));
    }

    public ViewBinderNotFoundException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        super(String.format("Do you have registered the %s.class for %s.class in the adapter?", cls2.getSimpleName(), cls.getSimpleName()));
    }
}
