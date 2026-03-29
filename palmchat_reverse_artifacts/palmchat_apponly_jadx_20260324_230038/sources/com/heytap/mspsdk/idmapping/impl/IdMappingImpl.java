package com.heytap.mspsdk.idmapping.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.heytap.msp.IMspCallback;
import com.heytap.msp.MspResponse;
import com.heytap.mspsdk.MspSdk;
import com.heytap.mspsdk.core.e;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.idmapping.util.Constants;
import com.heytap.mspsdk.idmapping.util.Utils;
import com.heytap.mspsdk.log.MspLog;
import com.heytap.mspsdk.util.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class IdMappingImpl {
    public static final String KEY_LAST_TIME_REQ_FROM_MSP = "last_time_req_from_msp";
    private static final String KIE_VERSION_CODE_0 = "0";
    private static final String KIE_VERSION_CODE_100 = "100";
    public static final String MSP_IDMAPPING_FILE = "msp_idmapping";
    private static final long ONE_DAY_MILLIS = 86400000;
    private static final String TAG = "IdMappingImpl";

    public static String convertTimestampToDateTime(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
            MspLog.e(TAG, "Error converting timestamp to date time: " + e.getMessage(), e);
            return "Invalid timestamp";
        }
    }

    public static HashMap<String, String> getAllIdMapping() {
        String str;
        try {
            Context contextB = e.a().b();
            if (contextB == null) {
                MspLog.e(TAG, "Context is null, cannot read ouid mapping data");
                return null;
            }
            g gVar = new g(contextB, MSP_IDMAPPING_FILE, 0);
            HashMap<String, String> map = new HashMap<>();
            Map<String, Object> mapA = gVar.a();
            if (mapA == null || mapA.isEmpty()) {
                str = "No ouid mapping data found in SharedPreferences";
            } else {
                for (Map.Entry<String, Object> entry : mapA.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (key != null && value != null) {
                        map.put(key, value.toString());
                        MspLog.iIgnore(TAG, "Read ouid mapping: " + key + ":" + Utils.sensitiveInfoReplace(value.toString()));
                    }
                }
                str = "Successfully read " + map.size() + " id mapping entries";
            }
            MspLog.iIgnore(TAG, str);
            if (map.isEmpty()) {
                return null;
            }
            return map;
        } catch (Exception e) {
            MspLog.e(TAG, "Error reading ouid mapping data: " + e.getMessage(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, String> getAllIdMappingWithoutReqTime() {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> allIdMapping = getAllIdMapping();
        if (allIdMapping != null && !allIdMapping.isEmpty()) {
            for (Map.Entry<String, String> entry : allIdMapping.entrySet()) {
                String key = entry.getKey();
                if (!KEY_LAST_TIME_REQ_FROM_MSP.equals(key) && !TextUtils.isEmpty(key)) {
                    map.put(key, entry.getValue());
                }
            }
        }
        return map;
    }

    public static void getData(final Context context, final HashMap<String, String> map, final IMspCallback iMspCallback, boolean z, final com.heytap.mspsdk.listener.a aVar) {
        Runnable runnable = new Runnable() { // from class: com.heytap.mspsdk.idmapping.impl.IdMappingImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (!IdMappingImpl.isSupportIdMapping(context)) {
                    IdMappingImpl.handleException(100, Constants.ResultCode.ERROR_NOT_SUPPORT_IM_MAPPING_MSG, iMspCallback);
                    return;
                }
                boolean zIsOverDue = IdMappingImpl.isOverDue();
                MspLog.iIgnore(IdMappingImpl.TAG, "getData, isOverDue " + zIsOverDue);
                if (!zIsOverDue) {
                    HashMap<String, String> allIdMappingWithoutReqTime = IdMappingImpl.getAllIdMappingWithoutReqTime();
                    com.heytap.mspsdk.listener.b bVar = new com.heytap.mspsdk.listener.b();
                    bVar.a(0);
                    bVar.a("success");
                    bVar.a(allIdMappingWithoutReqTime);
                    aVar.onResult(bVar);
                    return;
                }
                Bundle bundleObtainBundleParam = Utils.obtainBundleParam(context, map);
                try {
                    IIdMappingServiceModule idMappingServiceProxyer1 = Utils.getIdMappingServiceProxyer1(context);
                    idMappingServiceProxyer1.getData(bundleObtainBundleParam, iMspCallback);
                    MspSdk.unbind(idMappingServiceProxyer1);
                    MspLog.iIgnore(IdMappingImpl.TAG, "unbind idmapping service");
                } catch (MspSdkException e) {
                    e.printStackTrace();
                    MspLog.e(IdMappingImpl.TAG, e);
                    IdMappingImpl.handleException(e.getCode(), e.getMessage(), iMspCallback);
                }
            }
        };
        if (z) {
            com.heytap.mspsdk.executor.b.a().a(runnable);
        } else {
            runnable.run();
        }
    }

    public static long getLastTimeReqFromMsp() {
        try {
            Context contextB = e.a().b();
            if (contextB == null) {
                MspLog.e(TAG, "Context is null, cannot read last time request");
                return 0L;
            }
            long j = Long.parseLong((String) new g(contextB, MSP_IDMAPPING_FILE, 0).a(KEY_LAST_TIME_REQ_FROM_MSP, "0"));
            MspLog.iIgnore(TAG, "Last time request from MSP: " + convertTimestampToDateTime(j));
            return j;
        } catch (Exception e) {
            MspLog.e(TAG, "Error reading last time request: " + e.getMessage(), e);
            return 0L;
        }
    }

    public static void getVersionCode(final Context context, final com.heytap.mspsdk.listener.a aVar, boolean z) {
        final com.heytap.mspsdk.listener.a aVar2 = new com.heytap.mspsdk.listener.a() { // from class: com.heytap.mspsdk.idmapping.impl.IdMappingImpl.4
            @Override // com.heytap.mspsdk.listener.a
            public void onResult(com.heytap.mspsdk.listener.b bVar) {
                if (bVar.a() == 3010) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put(com.heytap.mspsdk.constants.Constants.KIT_VERSION_CODE, "0");
                    bVar.a(map);
                    bVar.a(0);
                    bVar.a("success");
                }
                aVar.onResult(bVar);
            }
        };
        Runnable runnable = new Runnable() { // from class: com.heytap.mspsdk.idmapping.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                IdMappingImpl.lambda$getVersionCode$1(aVar2, context);
            }
        };
        if (z) {
            com.heytap.mspsdk.executor.b.a().a(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleException(int i, String str, IMspCallback iMspCallback) {
        MspResponse mspResponse = new MspResponse();
        mspResponse.a(i);
        mspResponse.a(str);
        try {
            iMspCallback.callback(mspResponse);
        } catch (RemoteException e) {
            e.printStackTrace();
            MspLog.e(TAG, e);
        }
    }

    public static void init(final Context context, final com.heytap.mspsdk.listener.a aVar, boolean z) {
        MspLog.iIgnore(TAG, "init start");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        MspSdk.init(context);
        final com.heytap.mspsdk.listener.b bVar = new com.heytap.mspsdk.listener.b();
        bVar.a(0);
        bVar.a("success");
        Runnable runnable = new Runnable() { // from class: com.heytap.mspsdk.idmapping.impl.IdMappingImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (IdMappingImpl.isSupportIdMapping(context)) {
                    boolean zIsOverDue = IdMappingImpl.isOverDue();
                    MspLog.iIgnore(IdMappingImpl.TAG, "init, isOverDue " + zIsOverDue);
                    if (zIsOverDue) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (e.a().a(arrayList)) {
                            MspLog.iIgnore(IdMappingImpl.TAG, "init success, cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                        } else {
                            MspLog.e(IdMappingImpl.TAG, "init failed, not connected");
                            bVar.a(103);
                            bVar.a(TextUtils.isEmpty(arrayList.get(0)) ? Constants.ResultCode.ERROR_NOT_CONNECTED_MSG : arrayList.get(0));
                        }
                    }
                } else {
                    MspLog.e(IdMappingImpl.TAG, "init failed, not support idmapping");
                    bVar.a(100);
                    bVar.a(Constants.ResultCode.ERROR_NOT_SUPPORT_IM_MAPPING_MSG);
                }
                aVar.onResult(bVar);
            }
        };
        if (z) {
            com.heytap.mspsdk.executor.b.a().a(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isOverDue() {
        return Math.abs(System.currentTimeMillis() - getLastTimeReqFromMsp()) > 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSupportIdMapping(Context context) {
        return e.a().a(context, Constants.MSP_CORE_IDPMAPPING_SERVICE_COMPONENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getVersionCode$1(com.heytap.mspsdk.listener.a aVar, Context context) {
        com.heytap.mspsdk.listener.b bVar;
        String str;
        boolean zIsOverDue = isOverDue();
        MspLog.iIgnore(TAG, "getVersionCode, isOverDue " + zIsOverDue);
        if (zIsOverDue) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (e.a().a(arrayList)) {
                e.a().a(context, Constants.IDMAPPING_KIT_NAME, aVar);
                return;
            }
            bVar = new com.heytap.mspsdk.listener.b();
            MspLog.e(TAG, "getVersionCode failed, not connected");
            bVar.a(103);
            str = TextUtils.isEmpty(arrayList.get(0)) ? Constants.ResultCode.ERROR_NOT_CONNECTED_MSG : arrayList.get(0);
        } else {
            bVar = new com.heytap.mspsdk.listener.b();
            HashMap<String, String> map = new HashMap<>();
            map.put(com.heytap.mspsdk.constants.Constants.KIT_VERSION_CODE, KIE_VERSION_CODE_100);
            bVar.a(map);
            bVar.a(0);
            str = "success";
        }
        bVar.a(str);
        aVar.onResult(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveOuidMapping$0(HashMap map) {
        try {
            Set<Map.Entry> setEntrySet = map.entrySet();
            Context contextB = e.a().b();
            g gVar = null;
            boolean z = false;
            for (Map.Entry entry : setEntrySet) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    z = true;
                } else {
                    if (gVar == null) {
                        gVar = new g(contextB, MSP_IDMAPPING_FILE, 0);
                    }
                    gVar.b(str, str2);
                    gVar.b();
                }
            }
            if (z) {
                return;
            }
            saveLastTimeReqFromMsp();
        } catch (Exception e) {
            MspLog.e(TAG, e);
        }
    }

    public static IMspCallback obtainCallback(final com.heytap.mspsdk.listener.a aVar) {
        return new IMspCallback.Stub() { // from class: com.heytap.mspsdk.idmapping.impl.IdMappingImpl.2
            @Override // com.heytap.msp.IMspCallback
            public void callback(MspResponse mspResponse) throws RemoteException {
                com.heytap.mspsdk.listener.b bVar = new com.heytap.mspsdk.listener.b();
                bVar.a(mspResponse.a());
                bVar.a(mspResponse.b());
                if (mspResponse.c() != null) {
                    HashMap<String, String> map = (HashMap) mspResponse.c().getSerializable("result_map");
                    bVar.a(map);
                    IdMappingImpl.saveOuidMapping(map);
                }
                aVar.onResult(bVar);
            }
        };
    }

    public static boolean saveLastTimeReqFromMsp() {
        try {
            Context contextB = e.a().b();
            if (contextB == null) {
                MspLog.e(TAG, "Context is null, cannot save last time request");
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            g gVar = new g(contextB, MSP_IDMAPPING_FILE, 0);
            gVar.b(KEY_LAST_TIME_REQ_FROM_MSP, String.valueOf(jCurrentTimeMillis));
            gVar.b();
            MspLog.iIgnore(TAG, "Successfully saved last time request: " + convertTimestampToDateTime(jCurrentTimeMillis));
            return true;
        } catch (Exception e) {
            MspLog.e(TAG, "Error saving last time request: " + e.getMessage(), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveOuidMapping(final HashMap<String, String> map) {
        if (map == null) {
            return;
        }
        com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.idmapping.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                IdMappingImpl.lambda$saveOuidMapping$0(map);
            }
        });
    }
}
