package androidx.databinding;

import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public boolean onPreBind(T t) {
        return true;
    }

    public void onBound(T t) {
    }

    public void onCanceled(T t) {
    }
}
