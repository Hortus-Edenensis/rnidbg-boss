package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import defpackage.Task;
import defpackage.it5;
import defpackage.yz4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;
    private static final String c = "HmsProfile";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6818a;
    private HuaweiApi<Api.ApiOptions.NoOptions> b;

    private HmsProfile(Context context) {
        this.f6818a = null;
        Preconditions.checkNotNull(context);
        this.f6818a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.b = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.b = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.b.setKitSdkVersion(61200300);
    }

    private Task<Void> a(int i, String str, int i2, String str2) {
        if (!isSupportProfile()) {
            it5 it5Var = new it5();
            it5Var.b(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return it5Var.a();
        }
        if (!TextUtils.isEmpty(str)) {
            String strA = a(this.f6818a);
            if (TextUtils.isEmpty(strA)) {
                HMSLog.i(c, "agc connect services config missing project id.");
                it5 it5Var2 = new it5();
                it5Var2.b(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return it5Var2.a();
            }
            if (str.equals(strA)) {
                str = "";
            }
        }
        ProfileReq profileReq = new ProfileReq();
        if (i == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i2);
        } else {
            profileReq.setOperation(1);
        }
        String strReportEntry = PushBiUtil.reportEntry(this.f6818a, PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(yz4.b(str2));
            profileReq.setPkgName(this.f6818a.getPackageName());
            return this.b.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), strReportEntry));
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                it5 it5Var3 = new it5();
                ApiException apiException = (ApiException) e.getCause();
                it5Var3.b(apiException);
                PushBiUtil.reportExit(this.f6818a, PushNaming.PUSH_PROFILE, strReportEntry, apiException.getStatusCode());
                return it5Var3.a();
            }
            it5 it5Var4 = new it5();
            Context context = this.f6818a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            PushBiUtil.reportExit(context, PushNaming.PUSH_PROFILE, strReportEntry, errorEnum);
            it5Var4.b(errorEnum.toApiException());
            return it5Var4.a();
        }
    }

    private boolean b(Context context) {
        return d.b(context) >= 110001400;
    }

    public static HmsProfile getInstance(Context context) {
        return new HmsProfile(context);
    }

    public Task<Void> addProfile(int i, String str) {
        return addProfile("", i, str);
    }

    public Task<Void> deleteProfile(String str) {
        return deleteProfile("", str);
    }

    public boolean isSupportProfile() {
        if (!d.d(this.f6818a)) {
            return true;
        }
        if (d.c()) {
            HMSLog.i(c, "current EMUI version below 9.1, not support profile operation.");
            return false;
        }
        if (b(this.f6818a)) {
            return true;
        }
        HMSLog.i(c, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
        return false;
    }

    public Task<Void> addProfile(String str, int i, String str2) {
        if (i != 1 && i != 2) {
            HMSLog.i(c, "add profile type undefined.");
            it5 it5Var = new it5();
            it5Var.b(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return it5Var.a();
        }
        if (!TextUtils.isEmpty(str2)) {
            return a(0, str, i, str2);
        }
        HMSLog.i(c, "add profile params is empty.");
        it5 it5Var2 = new it5();
        it5Var2.b(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return it5Var2.a();
    }

    public Task<Void> deleteProfile(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return a(1, str, -1, str2);
        }
        HMSLog.e(c, "del profile params is empty.");
        it5 it5Var = new it5();
        it5Var.b(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return it5Var.a();
    }

    private static String a(Context context) {
        return defpackage.l.c(context).getString("client/project_id");
    }
}
