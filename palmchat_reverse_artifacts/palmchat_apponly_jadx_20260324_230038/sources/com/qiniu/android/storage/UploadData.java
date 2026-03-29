package com.qiniu.android.storage;

import com.baidu.location.LocationConst;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UploadData {
    byte[] data;
    String etag;
    final int index;
    String md5;
    final long offset;
    final int size;
    private State state = State.NeedToCheck;
    private long uploadSize;

    /* JADX INFO: renamed from: com.qiniu.android.storage.UploadData$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$qiniu$android$storage$UploadData$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$qiniu$android$storage$UploadData$State = iArr;
            try {
                iArr[State.NeedToCheck.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$qiniu$android$storage$UploadData$State[State.WaitToUpload.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$qiniu$android$storage$UploadData$State[State.Uploading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qiniu$android$storage$UploadData$State[State.Complete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum State {
        NeedToCheck,
        WaitToUpload,
        Uploading,
        Complete;

        /* JADX INFO: Access modifiers changed from: private */
        public int intValue() {
            return ordinal();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static State state(int i) {
            State[] stateArrValues = values();
            return (i < 0 || i >= stateArrValues.length) ? NeedToCheck : stateArrValues[i];
        }
    }

    public UploadData(long j, int i, int i2) {
        this.uploadSize = 0L;
        this.offset = j;
        this.size = i;
        this.index = i2;
        this.uploadSize = 0L;
    }

    public static UploadData dataFromJson(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        long j = jSONObject.getLong("offset");
        int i = jSONObject.getInt("size");
        int i2 = jSONObject.getInt("index");
        String strOptString = jSONObject.optString("etag");
        State state = State.state(jSONObject.getInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE));
        String strOptString2 = jSONObject.optString("md5");
        UploadData uploadData = new UploadData(j, i, i2);
        uploadData.etag = strOptString;
        uploadData.md5 = strOptString2;
        uploadData.state = state;
        uploadData.uploadSize = 0L;
        return uploadData;
    }

    public void checkStateAndUpdate() {
        State state = this.state;
        if ((state == State.WaitToUpload || state == State.Uploading) && this.data == null) {
            this.state = State.NeedToCheck;
        }
    }

    public void clearUploadState() {
        this.etag = null;
        this.md5 = null;
        this.state = State.NeedToCheck;
    }

    public State getState() {
        return this.state;
    }

    public boolean isUploaded() {
        return this.state == State.Complete;
    }

    public boolean needToUpload() {
        int i = AnonymousClass1.$SwitchMap$com$qiniu$android$storage$UploadData$State[this.state.ordinal()];
        return i == 1 || i == 2;
    }

    public void setUploadSize(long j) {
        this.uploadSize = j;
    }

    public JSONObject toJsonObject() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("offset", Long.valueOf(this.offset));
        jSONObject.putOpt("size", Integer.valueOf(this.size));
        jSONObject.putOpt("index", Integer.valueOf(this.index));
        jSONObject.putOpt("etag", this.etag);
        jSONObject.putOpt("md5", this.md5);
        jSONObject.putOpt(LocationConst.HDYawConst.KEY_HD_YAW_STATE, Integer.valueOf(this.state.intValue()));
        return jSONObject;
    }

    public void updateState(State state) {
        int i = AnonymousClass1.$SwitchMap$com$qiniu$android$storage$UploadData$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.uploadSize = 0L;
            this.etag = null;
        } else if (i == 4) {
            this.data = null;
        }
        this.state = state;
    }

    public long uploadSize() {
        return this.state == State.Complete ? this.size : this.uploadSize;
    }
}
