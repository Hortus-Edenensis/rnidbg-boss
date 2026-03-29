package com.huawei.hms.opendevice;

import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import defpackage.it5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends TaskApiCall<PushClient, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DeleteTokenReq f6803a;

    public f(String str, DeleteTokenReq deleteTokenReq, String str2) {
        super(str, JsonUtil.createJsonString(deleteTokenReq), str2);
        this.f6803a = deleteTokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, it5<Void> it5Var) {
        if (responseErrorCode.getErrorCode() == 0) {
            ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(str, new DeleteTokenResp())).getRetCode());
            if (errorEnumFromCode != ErrorEnum.SUCCESS) {
                it5Var.b(errorEnumFromCode.toApiException());
                return;
            } else {
                it5Var.c(null);
                h.a(pushClient.getContext(), getUri(), responseErrorCode);
                return;
            }
        }
        HMSLog.e(HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
        ErrorEnum errorEnumFromCode2 = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (errorEnumFromCode2 != ErrorEnum.ERROR_UNKNOWN) {
            it5Var.b(errorEnumFromCode2.toApiException());
        } else {
            it5Var.b(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.f6803a.isMultiSender() ? 50004300 : 30000000;
    }
}
