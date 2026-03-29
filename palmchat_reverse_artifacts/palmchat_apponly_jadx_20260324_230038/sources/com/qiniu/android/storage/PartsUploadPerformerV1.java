package com.qiniu.android.storage;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.storage.PartsUploadPerformer;
import com.qiniu.android.storage.UploadData;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class PartsUploadPerformerV1 extends PartsUploadPerformer {
    public PartsUploadPerformerV1(UploadSource uploadSource, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, String str3) {
        super(uploadSource, str, str2, upToken, uploadOptions, configuration, str3);
    }

    private void makeBlock(UploadBlock uploadBlock, UploadData uploadData, RequestProgressHandler requestProgressHandler, final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        final RequestTransaction requestTransactionCreateUploadRequestTransaction = createUploadRequestTransaction();
        requestTransactionCreateUploadRequestTransaction.makeBlock(uploadBlock.offset, uploadBlock.size, uploadData.data, true, requestProgressHandler, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.4
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                PartsUploadPerformerV1.this.destroyUploadRequestTransaction(requestTransactionCreateUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    private void uploadChunk(UploadBlock uploadBlock, UploadData uploadData, RequestProgressHandler requestProgressHandler, final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        final RequestTransaction requestTransactionCreateUploadRequestTransaction = createUploadRequestTransaction();
        requestTransactionCreateUploadRequestTransaction.uploadChunk(uploadBlock.ctx, uploadBlock.offset, uploadData.data, uploadData.offset, true, requestProgressHandler, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.5
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                PartsUploadPerformerV1.this.destroyUploadRequestTransaction(requestTransactionCreateUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void completeUpload(final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        UploadInfoV1 uploadInfoV1 = (UploadInfoV1) this.uploadInfo;
        ArrayList<String> arrayListAllBlocksContexts = uploadInfoV1.allBlocksContexts();
        String[] strArr = (arrayListAllBlocksContexts == null || arrayListAllBlocksContexts.size() <= 0) ? null : (String[]) arrayListAllBlocksContexts.toArray(new String[arrayListAllBlocksContexts.size()]);
        final RequestTransaction requestTransactionCreateUploadRequestTransaction = createUploadRequestTransaction();
        requestTransactionCreateUploadRequestTransaction.makeFile(uploadInfoV1.getSourceSize(), this.fileName, strArr, true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.3
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                if (responseInfo.isOK()) {
                    PartsUploadPerformerV1.this.notifyProgress(Boolean.TRUE);
                }
                PartsUploadPerformerV1.this.destroyUploadRequestTransaction(requestTransactionCreateUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getDefaultUploadInfo() {
        return new UploadInfoV1(this.uploadSource, this.config);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getUploadInfoFromJson(UploadSource uploadSource, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return UploadInfoV1.infoFromJson(uploadSource, jSONObject);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void serverInit(PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        partsUploadPerformerCompleteHandler.complete(ResponseInfo.successResponse(), null, null);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void uploadNextData(final PartsUploadPerformer.PartsUploadPerformerDataCompleteHandler partsUploadPerformerDataCompleteHandler) {
        final UploadBlock uploadBlockNextUploadBlock;
        final UploadData uploadDataNextUploadData;
        UploadInfoV1 uploadInfoV1 = (UploadInfoV1) this.uploadInfo;
        synchronized (this) {
            try {
                uploadBlockNextUploadBlock = uploadInfoV1.nextUploadBlock();
                uploadDataNextUploadData = uploadInfoV1.nextUploadData(uploadBlockNextUploadBlock);
                if (uploadDataNextUploadData != null) {
                    uploadDataNextUploadData.updateState(UploadData.State.Uploading);
                }
            } catch (Exception e) {
                LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + e.getMessage());
                partsUploadPerformerDataCompleteHandler.complete(true, ResponseInfo.localIOError(e.getMessage()), null, null);
                return;
            }
        }
        if (uploadBlockNextUploadBlock == null || uploadDataNextUploadData == null) {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " no chunk left");
            partsUploadPerformerDataCompleteHandler.complete(true, this.uploadInfo.getSourceSize() == 0 ? ResponseInfo.zeroSize("file is empty") : ResponseInfo.sdkInteriorError("no chunk left"), null, null);
            return;
        }
        if (uploadDataNextUploadData.data == null) {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " get chunk null");
            partsUploadPerformerDataCompleteHandler.complete(true, ResponseInfo.invalidArgument("chunk data is null"), null, null);
            return;
        }
        RequestProgressHandler requestProgressHandler = new RequestProgressHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.1
            @Override // com.qiniu.android.http.request.handler.RequestProgressHandler
            public void progress(long j, long j2) {
                uploadDataNextUploadData.setUploadSize(j);
                PartsUploadPerformerV1.this.notifyProgress(Boolean.FALSE);
            }
        };
        PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler = new PartsUploadPerformer.PartsUploadPerformerCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.2
            @Override // com.qiniu.android.storage.PartsUploadPerformer.PartsUploadPerformerCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                String string;
                if (jSONObject != null) {
                    try {
                        string = jSONObject.getString("ctx");
                    } catch (JSONException unused) {
                        string = null;
                    }
                } else {
                    string = null;
                }
                if (!responseInfo.isOK() || string == null) {
                    uploadDataNextUploadData.updateState(UploadData.State.WaitToUpload);
                } else {
                    uploadBlockNextUploadBlock.ctx = string;
                    uploadDataNextUploadData.updateState(UploadData.State.Complete);
                    PartsUploadPerformerV1.this.recordUploadInfo();
                    PartsUploadPerformerV1.this.notifyProgress(Boolean.FALSE);
                }
                partsUploadPerformerDataCompleteHandler.complete(false, responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        };
        if (uploadInfoV1.isFirstData(uploadDataNextUploadData)) {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " makeBlock");
            makeBlock(uploadBlockNextUploadBlock, uploadDataNextUploadData, requestProgressHandler, partsUploadPerformerCompleteHandler);
            return;
        }
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " makeBlock");
        uploadChunk(uploadBlockNextUploadBlock, uploadDataNextUploadData, requestProgressHandler, partsUploadPerformerCompleteHandler);
    }
}
