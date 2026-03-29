package com.qiniu.android.storage;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.storage.PartsUploadPerformer;
import com.qiniu.android.storage.UploadData;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class PartsUploadPerformerV2 extends PartsUploadPerformer {
    public PartsUploadPerformerV2(UploadSource uploadSource, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, String str3) {
        super(uploadSource, str, str2, upToken, uploadOptions, configuration, str3);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void completeUpload(final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        UploadInfoV2 uploadInfoV2 = (UploadInfoV2) this.uploadInfo;
        List<Map<String, Object>> partInfoArray = uploadInfoV2.getPartInfoArray();
        final RequestTransaction requestTransactionCreateUploadRequestTransaction = createUploadRequestTransaction();
        requestTransactionCreateUploadRequestTransaction.completeParts(true, this.fileName, uploadInfoV2.uploadId, partInfoArray, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.4
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                if (responseInfo.isOK()) {
                    PartsUploadPerformerV2.this.notifyProgress(Boolean.TRUE);
                }
                PartsUploadPerformerV2.this.destroyUploadRequestTransaction(requestTransactionCreateUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getDefaultUploadInfo() {
        return new UploadInfoV2(this.uploadSource, this.config);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getUploadInfoFromJson(UploadSource uploadSource, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return UploadInfoV2.infoFromJson(uploadSource, jSONObject);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void serverInit(final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        final UploadInfoV2 uploadInfoV2 = (UploadInfoV2) this.uploadInfo;
        if (uploadInfoV2 == null || !uploadInfoV2.isValid()) {
            final RequestTransaction requestTransactionCreateUploadRequestTransaction = createUploadRequestTransaction();
            requestTransactionCreateUploadRequestTransaction.initPart(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.1
                @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    String string;
                    Long l;
                    PartsUploadPerformerV2.this.destroyUploadRequestTransaction(requestTransactionCreateUploadRequestTransaction);
                    Long lValueOf = null;
                    lValueOf = null;
                    String str = null;
                    if (jSONObject != null) {
                        try {
                            string = jSONObject.getString("uploadId");
                            try {
                                lValueOf = Long.valueOf(jSONObject.getLong("expireAt"));
                            } catch (JSONException unused) {
                            }
                        } catch (JSONException unused2) {
                            string = null;
                        }
                        String str2 = string;
                        l = lValueOf;
                        str = str2;
                    } else {
                        l = null;
                    }
                    if (responseInfo.isOK() && str != null && l != null) {
                        UploadInfoV2 uploadInfoV22 = uploadInfoV2;
                        uploadInfoV22.uploadId = str;
                        uploadInfoV22.expireAt = l;
                        PartsUploadPerformerV2.this.recordUploadInfo();
                    }
                    partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
                }
            });
            return;
        }
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " serverInit success");
        partsUploadPerformerCompleteHandler.complete(ResponseInfo.successResponse(), null, null);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void uploadNextData(final PartsUploadPerformer.PartsUploadPerformerDataCompleteHandler partsUploadPerformerDataCompleteHandler) {
        final UploadData uploadDataNextUploadData;
        UploadInfoV2 uploadInfoV2 = (UploadInfoV2) this.uploadInfo;
        synchronized (this) {
            try {
                uploadDataNextUploadData = uploadInfoV2.nextUploadData();
                if (uploadDataNextUploadData != null) {
                    uploadDataNextUploadData.updateState(UploadData.State.Uploading);
                }
            } catch (Exception e) {
                LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " " + e.getMessage());
                ResponseInfo responseInfoLocalIOError = ResponseInfo.localIOError(e.getMessage());
                partsUploadPerformerDataCompleteHandler.complete(true, responseInfoLocalIOError, null, responseInfoLocalIOError.response);
                return;
            }
        }
        if (uploadDataNextUploadData != null) {
            RequestProgressHandler requestProgressHandler = new RequestProgressHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.2
                @Override // com.qiniu.android.http.request.handler.RequestProgressHandler
                public void progress(long j, long j2) {
                    uploadDataNextUploadData.setUploadSize(j);
                    PartsUploadPerformerV2.this.notifyProgress(Boolean.FALSE);
                }
            };
            final RequestTransaction requestTransactionCreateUploadRequestTransaction = createUploadRequestTransaction();
            requestTransactionCreateUploadRequestTransaction.uploadPart(true, uploadInfoV2.uploadId, uploadInfoV2.getPartIndexOfData(uploadDataNextUploadData), uploadDataNextUploadData.data, requestProgressHandler, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.3
                @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    String string;
                    String str;
                    PartsUploadPerformerV2.this.destroyUploadRequestTransaction(requestTransactionCreateUploadRequestTransaction);
                    String string2 = null;
                    if (jSONObject != null) {
                        try {
                            string = jSONObject.getString("etag");
                            try {
                                string2 = jSONObject.getString("md5");
                            } catch (JSONException unused) {
                            }
                        } catch (JSONException unused2) {
                            string = null;
                        }
                        String str2 = string;
                        str = string2;
                        string2 = str2;
                    } else {
                        str = null;
                    }
                    if (!responseInfo.isOK() || string2 == null || str == null) {
                        uploadDataNextUploadData.updateState(UploadData.State.WaitToUpload);
                    } else {
                        UploadData uploadData = uploadDataNextUploadData;
                        uploadData.etag = string2;
                        uploadData.updateState(UploadData.State.Complete);
                        PartsUploadPerformerV2.this.recordUploadInfo();
                        PartsUploadPerformerV2.this.notifyProgress(Boolean.FALSE);
                    }
                    partsUploadPerformerDataCompleteHandler.complete(false, responseInfo, uploadRegionRequestMetrics, jSONObject);
                }
            });
        } else {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " no data left");
            partsUploadPerformerDataCompleteHandler.complete(true, this.uploadInfo.getSourceSize() == 0 ? ResponseInfo.zeroSize("file is empty") : ResponseInfo.sdkInteriorError("no chunk left"), null, null);
        }
    }
}
