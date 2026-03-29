package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class kv {
    private static final String Code = "DcServiceCmdManager";
    private static final int V = 10001;

    public static void Code(final Context context, final kw kwVar) {
        if (kwVar == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.kv.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strF = eh.Code(context).F(com.huawei.openalliance.ad.constant.w.ay);
                    fh.Code(kv.Code, "redirectionAppList from configMap : %s", strF);
                    List<String> listV = com.huawei.openalliance.ad.utils.bc.V(strF, ",");
                    if (!com.huawei.openalliance.ad.utils.ag.Code(listV) && listV.contains(kwVar.Z())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("dc_service_cmd", 10001);
                        final JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("contentId", kwVar.V());
                        jSONObject2.put("pkgName", kwVar.Z());
                        jSONObject2.put("apiVer", String.valueOf(kwVar.C()));
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.kv.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    com.huawei.openalliance.ad.ipc.h.Code(context, false).Code(com.huawei.openalliance.ad.constant.s.R, jSONObject2.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.kv.2.1.1
                                        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                        public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                                            if (callResult.getCode() == 200) {
                                                String data = callResult.getData();
                                                try {
                                                    fh.Code(kv.Code, "do get param from fat is success : %s", Integer.valueOf(callResult.getCode()));
                                                    jSONObject2.put("paramFromServer", data);
                                                    countDownLatch.countDown();
                                                } catch (JSONException e) {
                                                    countDownLatch.countDown();
                                                    fh.Code(kv.Code, "do get param from fat is failed : %s", Integer.valueOf(callResult.getCode()));
                                                    fh.Z(kv.Code, "json exception queryParamFromServer : %s", e.getClass().getSimpleName());
                                                }
                                            }
                                            fh.Code(kv.Code, "do get param from fat durationg is : %s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
                                        }
                                    }, null);
                                } catch (Exception e) {
                                    fh.Z(kv.Code, "json exception sendRedirectionMatchRecord : %s", e.getClass().getSimpleName());
                                }
                            }
                        });
                        jSONObject2.put(WfConstant.EVENT_KEY_TASK_ID, kwVar.I());
                        jSONObject2.put("activityName", kwVar.B());
                        jSONObject2.put("triggerTime", System.currentTimeMillis());
                        countDownLatch.await(500L, TimeUnit.MILLISECONDS);
                        jSONObject.put(RemoteMessageConst.MessageBody.PARAM, jSONObject2);
                        fh.Code(kv.Code, "send direction match record : %s", jSONObject2.toString());
                        kv.Code(context, jSONObject);
                        return;
                    }
                    fh.Code(kv.Code, "%s is not in app list", kwVar.Z());
                } catch (Exception e) {
                    fh.Z(kv.Code, "json exception sendRedirectionMatchRecord : %s", e.getClass().getSimpleName());
                }
            }
        });
    }

    public static void Code(Context context, JSONObject jSONObject) {
        com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(com.huawei.openalliance.ad.constant.s.K, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.kv.1
            /* JADX WARN: Removed duplicated region for block: B:10:0x0018 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0004, B:6:0x000c, B:9:0x0014, B:10:0x0018), top: B:17:0x0004 }] */
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String str2;
                if (callResult != null) {
                    try {
                        if (callResult.getCode() == 200) {
                            if (!fh.Code()) {
                                return;
                            } else {
                                str2 = "query DC_BRIDGE from hms success!";
                            }
                        } else if (!fh.Code()) {
                            return;
                        } else {
                            str2 = "failed to query DC_BRIDGE from hms";
                        }
                    } catch (Throwable th) {
                        fh.Z(kv.Code, "get DC_BRIDGE from hms err : %s", th.getClass().getSimpleName());
                        return;
                    }
                }
                fh.Code(kv.Code, str2);
            }
        }, String.class);
    }
}
