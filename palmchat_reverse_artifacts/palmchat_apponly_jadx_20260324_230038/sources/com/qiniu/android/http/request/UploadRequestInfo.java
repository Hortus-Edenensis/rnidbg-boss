package com.qiniu.android.http.request;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UploadRequestInfo {
    static final String RequestTypeBput = "bput";
    static final String RequestTypeCompletePart = "complete_part";
    static final String RequestTypeForm = "form";
    static final String RequestTypeInitParts = "init_parts";
    static final String RequestTypeMkblk = "mkblk";
    static final String RequestTypeMkfile = "mkfile";
    static final String RequestTypeServerConfig = "server_config";
    static final String RequestTypeServerUserConfig = "server_user_config";
    static final String RequestTypeUCQuery = "uc_query";
    static final String RequestTypeUpLog = "uplog";
    static final String RequestTypeUploadPart = "upload_part";
    String bucket;
    String currentRegionId;
    Long fileOffset;
    String key;
    String requestType;
    String targetRegionId;

    public boolean shouldReportRequestLog() {
        return !this.requestType.equals(RequestTypeUpLog);
    }
}
