package com.qiniu.android.storage;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
abstract class UploadInfo {
    protected String fileName = null;
    private UploadSource source;
    private String sourceId;
    private long sourceSize;

    public UploadInfo(UploadSource uploadSource) {
        this.sourceSize = -1L;
        this.source = uploadSource;
        this.sourceSize = uploadSource.getSize();
        this.sourceId = uploadSource.getId() != null ? uploadSource.getId() : "";
    }

    public abstract void checkInfoStateAndUpdate();

    public abstract void clearUploadState();

    public void close() {
        this.source.close();
    }

    public boolean couldReloadSource() {
        return this.source.couldReloadSource();
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public long getSourceSize() {
        return this.source.getSize();
    }

    public boolean hasValidResource() {
        return this.source != null;
    }

    public abstract boolean isAllUploaded();

    public boolean isSameUploadInfo(UploadInfo uploadInfo) {
        if (uploadInfo == null || !this.sourceId.equals(uploadInfo.sourceId)) {
            return false;
        }
        long j = uploadInfo.sourceSize;
        if (j <= -1) {
            return true;
        }
        long j2 = this.sourceSize;
        return j2 <= -1 || j == j2;
    }

    public boolean isValid() {
        return hasValidResource();
    }

    public byte[] readData(int i, long j) throws IOException {
        byte[] data;
        UploadSource uploadSource = this.source;
        if (uploadSource == null) {
            throw new IOException("file is not exist");
        }
        synchronized (uploadSource) {
            data = this.source.readData(i, j);
        }
        if (data != null && (data.length != i || data.length == 0)) {
            this.sourceSize = j + ((long) data.length);
        }
        return data;
    }

    public boolean reloadSource() {
        return this.source.reloadSource();
    }

    public void setInfoFromJson(JSONObject jSONObject) {
        try {
            this.sourceSize = jSONObject.getLong("sourceSize");
            this.sourceId = jSONObject.optString("sourceId");
        } catch (JSONException unused) {
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sourceId", this.sourceId);
            jSONObject.put("sourceSize", getSourceSize());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public abstract long uploadSize();
}
