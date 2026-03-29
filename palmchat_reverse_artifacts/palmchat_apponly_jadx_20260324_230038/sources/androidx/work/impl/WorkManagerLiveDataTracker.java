package androidx.work.impl;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class WorkManagerLiveDataTracker {

    @VisibleForTesting
    final Set<LiveData> mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());

    /* JADX INFO: compiled from: SearchBox */
    public static class TrackedLiveData<T> extends MediatorLiveData<T> {
        private final WorkManagerLiveDataTracker mContainer;

        /* JADX WARN: Multi-variable type inference failed */
        public TrackedLiveData(WorkManagerLiveDataTracker workManagerLiveDataTracker, LiveData<T> liveData) {
            this.mContainer = workManagerLiveDataTracker;
            addSource(liveData, new Observer<T>() { // from class: androidx.work.impl.WorkManagerLiveDataTracker.TrackedLiveData.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable T t) {
                    TrackedLiveData.this.setValue(t);
                }
            });
        }

        @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
        public void onActive() {
            super.onActive();
            this.mContainer.onActive(this);
        }

        @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
        public void onInactive() {
            super.onInactive();
            this.mContainer.onInactive(this);
        }
    }

    public void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    public void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }

    public <T> LiveData<T> track(LiveData<T> liveData) {
        return new TrackedLiveData(this, liveData);
    }
}
