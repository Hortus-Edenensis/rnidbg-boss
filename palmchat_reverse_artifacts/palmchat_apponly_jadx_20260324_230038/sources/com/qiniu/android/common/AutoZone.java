package com.qiniu.android.common;

import com.qiniu.android.common.Zone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.dns.DnsPrefetchTransaction;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.SingleFlight;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class AutoZone extends Zone {
    private static final SingleFlight SingleFlight = new SingleFlight();
    private ArrayList<RequestTransaction> transactions = new ArrayList<>();
    private String[] ucServers;

    /* JADX INFO: compiled from: SearchBox */
    public static class GlobalCache {
        private static GlobalCache globalCache = new GlobalCache();
        private ConcurrentHashMap<String, ZonesInfo> cache = new ConcurrentHashMap<>();

        private GlobalCache() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void cache(ZonesInfo zonesInfo, String str) {
            if (str != null) {
                if (!str.isEmpty() && zonesInfo != null) {
                    this.cache.put(str, zonesInfo);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCache() {
            Iterator<ZonesInfo> it = this.cache.values().iterator();
            while (it.hasNext()) {
                it.next().toTemporary();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static GlobalCache getInstance() {
            return globalCache;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized ZonesInfo zonesInfoForKey(String str) {
            if (str != null) {
                if (!str.isEmpty()) {
                    return this.cache.get(str);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SingleFlightValue {
        private UploadRegionRequestMetrics metrics;
        private JSONObject response;
        private ResponseInfo responseInfo;

        private SingleFlightValue() {
        }
    }

    public static void clearCache() {
        GlobalCache.getInstance().clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RequestTransaction createUploadRequestTransaction(UpToken upToken) {
        RequestTransaction requestTransaction = new RequestTransaction(getUcServerList(), "unknown", upToken);
        this.transactions.add(requestTransaction);
        return requestTransaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyUploadRequestTransaction(RequestTransaction requestTransaction) {
        this.transactions.remove(requestTransaction);
    }

    private String[] getUcServerArray() {
        String[] strArr = this.ucServers;
        return (strArr == null || strArr.length <= 0) ? new String[]{Config.preQueryHost00, Config.preQueryHost01} : strArr;
    }

    public List<String> getUcServerList() {
        String[] strArr = this.ucServers;
        if (strArr != null && strArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.ucServers);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Config.preQueryHost02);
        arrayList2.add(Config.preQueryHost00);
        arrayList2.add(Config.preQueryHost01);
        return arrayList2;
    }

    @Override // com.qiniu.android.common.Zone
    public ZonesInfo getZonesInfo(UpToken upToken) {
        if (upToken == null) {
            return null;
        }
        ZonesInfo zonesInfoZonesInfoForKey = GlobalCache.getInstance().zonesInfoForKey(upToken.index());
        if (zonesInfoZonesInfoForKey == null) {
            return zonesInfoZonesInfoForKey;
        }
        try {
            return (ZonesInfo) zonesInfoZonesInfoForKey.clone();
        } catch (Exception unused) {
            return zonesInfoZonesInfoForKey;
        }
    }

    @Override // com.qiniu.android.common.Zone
    public void preQuery(final UpToken upToken, final Zone.QueryHandler queryHandler) {
        if (upToken == null || !upToken.isValid()) {
            queryHandler.complete(-1, ResponseInfo.invalidToken("invalid token"), null);
            return;
        }
        UploadRegionRequestMetrics uploadRegionRequestMetrics = new UploadRegionRequestMetrics(null);
        uploadRegionRequestMetrics.start();
        final String strIndex = upToken.index();
        ZonesInfo zonesInfoZonesInfoForKey = GlobalCache.getInstance().zonesInfoForKey(strIndex);
        if (zonesInfoZonesInfoForKey != null && zonesInfoZonesInfoForKey.isValid() && !zonesInfoZonesInfoForKey.isTemporary()) {
            uploadRegionRequestMetrics.end();
            queryHandler.complete(0, ResponseInfo.successResponse(), uploadRegionRequestMetrics);
            return;
        }
        DnsPrefetchTransaction.addDnsCheckAndPrefetchTransaction(getUcServerArray());
        try {
            SingleFlight.perform(strIndex, new SingleFlight.ActionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.utils.SingleFlight.ActionHandler
                public void action(final SingleFlight.CompleteHandler completeHandler) throws Exception {
                    final RequestTransaction requestTransactionCreateUploadRequestTransaction = AutoZone.this.createUploadRequestTransaction(upToken);
                    requestTransactionCreateUploadRequestTransaction.queryUploadHosts(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.common.AutoZone.1.1
                        @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                        public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics2, JSONObject jSONObject) {
                            AutoZone.this.destroyUploadRequestTransaction(requestTransactionCreateUploadRequestTransaction);
                            SingleFlightValue singleFlightValue = new SingleFlightValue();
                            singleFlightValue.responseInfo = responseInfo;
                            singleFlightValue.response = jSONObject;
                            singleFlightValue.metrics = uploadRegionRequestMetrics2;
                            completeHandler.complete(singleFlightValue);
                        }
                    });
                }
            }, new SingleFlight.CompleteHandler() { // from class: com.qiniu.android.common.AutoZone.2
                @Override // com.qiniu.android.utils.SingleFlight.CompleteHandler
                public void complete(Object obj) {
                    SingleFlightValue singleFlightValue = (SingleFlightValue) obj;
                    ResponseInfo responseInfo = singleFlightValue.responseInfo;
                    UploadRegionRequestMetrics uploadRegionRequestMetrics2 = singleFlightValue.metrics;
                    JSONObject jSONObject = singleFlightValue.response;
                    if (responseInfo != null && responseInfo.isOK() && jSONObject != null) {
                        ZonesInfo zonesInfoCreateZonesInfo = ZonesInfo.createZonesInfo(jSONObject);
                        if (!zonesInfoCreateZonesInfo.isValid()) {
                            queryHandler.complete(-1015, responseInfo, uploadRegionRequestMetrics2);
                            return;
                        } else {
                            GlobalCache.getInstance().cache(zonesInfoCreateZonesInfo, strIndex);
                            queryHandler.complete(0, responseInfo, uploadRegionRequestMetrics2);
                            return;
                        }
                    }
                    if (responseInfo.isNetworkBroken()) {
                        queryHandler.complete(-1, responseInfo, uploadRegionRequestMetrics2);
                        return;
                    }
                    ZonesInfo zonesInfo = FixedZone.localsZoneInfo().getZonesInfo(upToken);
                    if (!zonesInfo.isValid()) {
                        queryHandler.complete(-1015, responseInfo, uploadRegionRequestMetrics2);
                    } else {
                        GlobalCache.getInstance().cache(zonesInfo, strIndex);
                        queryHandler.complete(0, responseInfo, uploadRegionRequestMetrics2);
                    }
                }
            });
        } catch (Exception e) {
            queryHandler.complete(-1, ResponseInfo.localIOError(e.toString()), null);
        }
    }

    public void setUcServer(String str) {
        if (str != null) {
            this.ucServers = new String[]{str};
        }
    }

    public void setUcServers(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.ucServers = strArr;
    }
}
