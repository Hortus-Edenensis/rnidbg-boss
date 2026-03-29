package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u implements View.OnClickListener {
    private Method b;
    private final int fx;
    private final String nr;
    private final Activity u;

    public u(@NonNull Activity activity, int i, @NonNull String str) {
        this.u = activity;
        this.nr = str;
        this.fx = i;
    }

    @NonNull
    private void u(@Nullable Activity activity, @NonNull String str) {
        try {
            Method method = activity.getClass().getMethod(this.nr, View.class);
            if (method != null) {
                this.b = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.nr + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.fx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        if (this.b == null) {
            u(this.u, this.nr);
        }
        try {
            this.b.invoke(this.u, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
