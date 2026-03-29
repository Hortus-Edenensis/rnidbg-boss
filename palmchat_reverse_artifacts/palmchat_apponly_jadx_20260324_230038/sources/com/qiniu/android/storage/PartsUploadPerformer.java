package com.qiniu.android.storage;

import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.IUploadRegion;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.http.serverRegion.UploadDomainRegion;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
abstract class PartsUploadPerformer {
    private static final String kRecordFileInfoKey = "recordFileInfo";
    private static final String kRecordZoneInfoKey = "recordZoneInfo";
    final Configuration config;
    protected IUploadRegion currentRegion;
    final String fileName;
    final String key;
    final UploadOptions options;
    final Recorder recorder;
    final String recorderKey;
    Long recoveredFrom;
    private IUploadRegion targetRegion;
    final UpToken token;
    private final UpProgress upProgress;
    UploadInfo uploadInfo;
    final UploadSource uploadSource;
    List<RequestTransaction> uploadTransactions;

    /* JADX INFO: compiled from: SearchBox */
    public interface PartsUploadPerformerCompleteHandler {
        void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PartsUploadPerformerDataCompleteHandler {
        void complete(boolean z, ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject);
    }

    public PartsUploadPerformer(UploadSource uploadSource, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, String str3) {
        this.uploadSource = uploadSource;
        this.key = str2;
        this.fileName = str;
        this.token = upToken;
        this.options = uploadOptions;
        this.config = configuration;
        this.recorder = configuration.recorder;
        this.recorderKey = str3;
        this.upProgress = new UpProgress(uploadOptions.progressHandler);
        initData();
    }

    public boolean canReadFile() {
        UploadInfo uploadInfo = this.uploadInfo;
        return uploadInfo != null && uploadInfo.hasValidResource();
    }

    public void closeFile() {
        UploadInfo uploadInfo = this.uploadInfo;
        if (uploadInfo != null) {
            uploadInfo.close();
        }
    }

    public abstract void completeUpload(PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler);

    public boolean couldReloadInfo() {
        return this.uploadInfo.couldReloadSource();
    }

    public RequestTransaction createUploadRequestTransaction() {
        RequestTransaction requestTransaction = new RequestTransaction(this.config, this.options, this.targetRegion, this.currentRegion, this.key, this.token);
        synchronized (this) {
            List<RequestTransaction> list = this.uploadTransactions;
            if (list != null) {
                list.add(requestTransaction);
            }
        }
        return requestTransaction;
    }

    public void destroyUploadRequestTransaction(RequestTransaction requestTransaction) {
        if (requestTransaction != null) {
            synchronized (this) {
                List<RequestTransaction> list = this.uploadTransactions;
                if (list != null) {
                    list.remove(requestTransaction);
                }
            }
        }
    }

    public abstract UploadInfo getDefaultUploadInfo();

    public abstract UploadInfo getUploadInfoFromJson(UploadSource uploadSource, JSONObject jSONObject);

    public void initData() {
        this.uploadTransactions = new ArrayList();
        this.uploadInfo = getDefaultUploadInfo();
        recoverUploadInfoFromRecord();
    }

    public void notifyProgress(Boolean bool) {
        if (this.uploadInfo == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.upProgress.notifyDone(this.key, this.uploadInfo.getSourceSize());
        } else {
            this.upProgress.progress(this.key, this.uploadInfo.uploadSize(), this.uploadInfo.getSourceSize());
        }
    }

    public void recordUploadInfo() {
        String str = this.recorderKey;
        if (this.recorder == null || str == null || str.length() == 0) {
            return;
        }
        synchronized (this) {
            IUploadRegion iUploadRegion = this.currentRegion;
            JSONObject jSONObject = (iUploadRegion == null || iUploadRegion.getZoneInfo() == null) ? null : this.currentRegion.getZoneInfo().detailInfo;
            UploadInfo uploadInfo = this.uploadInfo;
            JSONObject jsonObject = uploadInfo != null ? uploadInfo.toJsonObject() : null;
            if (jSONObject != null && jsonObject != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(kRecordZoneInfoKey, jSONObject);
                    jSONObject2.put(kRecordFileInfoKey, jsonObject);
                } catch (JSONException unused) {
                }
                this.recorder.set(str, jSONObject2.toString().getBytes());
            }
        }
        LogUtil.i("key:" + StringUtils.toNonnullString(str) + " recorderKey:" + StringUtils.toNonnullString(this.recorderKey) + " recordUploadInfo");
    }

    public void recoverUploadInfoFromRecord() {
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " recorderKey:" + StringUtils.toNonnullString(this.recorderKey) + " recorder:" + StringUtils.toNonnullString(this.recorder) + " recoverUploadInfoFromRecord");
        String str = this.recorderKey;
        if (this.recorder == null || str == null || str.length() == 0 || this.uploadSource == null) {
            return;
        }
        byte[] bArr = this.recorder.get(str);
        if (bArr == null) {
            LogUtil.i("key:" + StringUtils.toNonnullString(str) + " recorderKey:" + StringUtils.toNonnullString(this.recorderKey) + " recoverUploadInfoFromRecord data:null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            ZoneInfo zoneInfoBuildFromJson = ZoneInfo.buildFromJson(jSONObject.getJSONObject(kRecordZoneInfoKey));
            UploadInfo uploadInfoFromJson = getUploadInfoFromJson(this.uploadSource, jSONObject.getJSONObject(kRecordFileInfoKey));
            if (zoneInfoBuildFromJson == null || uploadInfoFromJson == null || !uploadInfoFromJson.isValid() || !this.uploadInfo.isSameUploadInfo(uploadInfoFromJson)) {
                LogUtil.i("key:" + StringUtils.toNonnullString(str) + " recorderKey:" + StringUtils.toNonnullString(this.recorderKey) + " recoverUploadInfoFromRecord invalid");
                this.recorder.del(str);
                this.currentRegion = null;
                this.targetRegion = null;
                this.recoveredFrom = null;
            } else {
                LogUtil.i("key:" + StringUtils.toNonnullString(str) + " recorderKey:" + StringUtils.toNonnullString(this.recorderKey) + " recoverUploadInfoFromRecord valid");
                uploadInfoFromJson.checkInfoStateAndUpdate();
                this.uploadInfo = uploadInfoFromJson;
                UploadDomainRegion uploadDomainRegion = new UploadDomainRegion();
                uploadDomainRegion.setupRegionData(zoneInfoBuildFromJson);
                this.currentRegion = uploadDomainRegion;
                this.targetRegion = uploadDomainRegion;
                this.recoveredFrom = Long.valueOf(uploadInfoFromJson.uploadSize());
            }
        } catch (Exception unused) {
            LogUtil.i("key:" + StringUtils.toNonnullString(str) + " recorderKey:" + StringUtils.toNonnullString(this.recorderKey) + " recoverUploadInfoFromRecord json:error");
            this.recorder.del(str);
            this.currentRegion = null;
            this.targetRegion = null;
            this.recoveredFrom = null;
        }
    }

    public boolean reloadInfo() {
        return this.uploadInfo.reloadSource();
    }

    public void removeUploadInfoRecord() {
        String str;
        this.recoveredFrom = null;
        UploadInfo uploadInfo = this.uploadInfo;
        if (uploadInfo != null) {
            uploadInfo.clearUploadState();
        }
        Recorder recorder = this.recorder;
        if (recorder != null && (str = this.recorderKey) != null) {
            recorder.del(str);
        }
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " recorderKey:" + StringUtils.toNonnullString(this.recorderKey) + " removeUploadInfoRecord");
    }

    public abstract void serverInit(PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler);

    public void switchRegion(IUploadRegion iUploadRegion) {
        UploadInfo uploadInfo = this.uploadInfo;
        if (uploadInfo != null) {
            uploadInfo.clearUploadState();
        }
        this.currentRegion = iUploadRegion;
        this.recoveredFrom = null;
        if (this.targetRegion == null) {
            this.targetRegion = iUploadRegion;
        }
    }

    public abstract void uploadNextData(PartsUploadPerformerDataCompleteHandler partsUploadPerformerDataCompleteHandler);
}
