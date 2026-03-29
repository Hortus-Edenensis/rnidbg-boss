package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class WorkInfo {

    @NonNull
    private UUID mId;

    @NonNull
    private Data mOutputData;

    @NonNull
    private State mState;

    @NonNull
    private Set<String> mTags;

    /* JADX INFO: compiled from: SearchBox */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull Data data, @NonNull List<String> list) {
        this.mId = uuid;
        this.mState = state;
        this.mOutputData = data;
        this.mTags = new HashSet(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        UUID uuid = this.mId;
        if (uuid == null ? workInfo.mId != null : !uuid.equals(workInfo.mId)) {
            return false;
        }
        if (this.mState != workInfo.mState) {
            return false;
        }
        Data data = this.mOutputData;
        if (data == null ? workInfo.mOutputData != null : !data.equals(workInfo.mOutputData)) {
            return false;
        }
        Set<String> set = this.mTags;
        Set<String> set2 = workInfo.mTags;
        return set != null ? set.equals(set2) : set2 == null;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    public Data getOutputData() {
        return this.mOutputData;
    }

    @NonNull
    public State getState() {
        return this.mState;
    }

    @NonNull
    public Set<String> getTags() {
        return this.mTags;
    }

    public int hashCode() {
        UUID uuid = this.mId;
        int iHashCode = (uuid != null ? uuid.hashCode() : 0) * 31;
        State state = this.mState;
        int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
        Data data = this.mOutputData;
        int iHashCode3 = (iHashCode2 + (data != null ? data.hashCode() : 0)) * 31;
        Set<String> set = this.mTags;
        return iHashCode3 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "WorkInfo{mId='" + this.mId + "', mState=" + this.mState + ", mOutputData=" + this.mOutputData + ", mTags=" + this.mTags + '}';
    }
}
