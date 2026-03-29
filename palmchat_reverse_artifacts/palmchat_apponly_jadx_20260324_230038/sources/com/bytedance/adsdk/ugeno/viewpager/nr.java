package com.bytedance.adsdk.ugeno.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class nr {
    private DataSetObserver nr;
    private final DataSetObservable u = new DataSetObservable();

    public void fx() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.nr;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.u.notifyChanged();
    }

    public Parcelable nr() {
        return null;
    }

    public float u(int i) {
        return 1.0f;
    }

    public abstract int u();

    public abstract boolean u(View view, Object obj);

    public int u(Object obj) {
        return -1;
    }

    public Object u(ViewGroup viewGroup, int i) {
        return u((View) viewGroup, i);
    }

    public void u(ViewGroup viewGroup, int i, Object obj) {
        u((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object u(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void u(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void u(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.nr = dataSetObserver;
        }
    }
}
