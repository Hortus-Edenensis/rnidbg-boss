package com.qiniu.android.http.request;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UploadRequestState {
    private boolean isUseOldServer;
    private boolean isUserCancel;

    public boolean isUseOldServer() {
        return this.isUseOldServer;
    }

    public boolean isUserCancel() {
        return this.isUserCancel;
    }

    public void setUseOldServer(boolean z) {
        this.isUseOldServer = z;
    }

    public void setUserCancel(boolean z) {
        this.isUserCancel = z;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public UploadRequestState m71clone() {
        UploadRequestState uploadRequestState = new UploadRequestState();
        uploadRequestState.isUseOldServer = this.isUseOldServer;
        uploadRequestState.isUserCancel = this.isUserCancel;
        return uploadRequestState;
    }
}
