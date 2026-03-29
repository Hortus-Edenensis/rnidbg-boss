package com.qiniu.android.storage.serverConfig;

import com.qiniu.android.common.Config;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.storage.UpToken;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class ServerConfigSynchronizer {
    private static String[] Hosts;
    private static String Token;
    private static RequestTransaction serverConfigTransaction;
    private static RequestTransaction serverUserConfigTransaction;

    /* JADX INFO: compiled from: SearchBox */
    public interface ServerConfigHandler {
        void handle(ServerConfig serverConfig);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ServerUserConfigHandler {
        void handle(ServerUserConfig serverUserConfig);
    }

    private static synchronized RequestTransaction createServerConfigTransaction() {
        if (serverConfigTransaction != null) {
            return null;
        }
        UpToken invalidToken = UpToken.parse(Token);
        if (invalidToken == null) {
            invalidToken = UpToken.getInvalidToken();
        }
        ArrayList arrayList = new ArrayList();
        String[] strArr = Hosts;
        if (strArr == null || strArr.length <= 0) {
            arrayList.add(Config.preQueryHost00);
            arrayList.add(Config.preQueryHost01);
        } else {
            arrayList.addAll(Arrays.asList(strArr));
        }
        RequestTransaction requestTransaction = new RequestTransaction(arrayList, invalidToken);
        serverConfigTransaction = requestTransaction;
        return requestTransaction;
    }

    private static synchronized RequestTransaction createServerUserConfigTransaction() {
        String str;
        if (serverUserConfigTransaction == null && (str = Token) != null) {
            UpToken upToken = UpToken.parse(str);
            if (upToken != null && upToken.isValid()) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = Hosts;
                if (strArr == null || strArr.length <= 0) {
                    arrayList.add(Config.preQueryHost00);
                    arrayList.add(Config.preQueryHost01);
                } else {
                    arrayList.addAll(Arrays.asList(strArr));
                }
                RequestTransaction requestTransaction = new RequestTransaction(arrayList, upToken);
                serverUserConfigTransaction = requestTransaction;
                return requestTransaction;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void destroyServerConfigTransaction() {
        serverConfigTransaction = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void destroyServerUserConfigTransaction() {
        serverUserConfigTransaction = null;
    }

    public static void getServerConfigFromServer(final ServerConfigHandler serverConfigHandler) {
        if (serverConfigHandler == null) {
            return;
        }
        RequestTransaction requestTransactionCreateServerConfigTransaction = createServerConfigTransaction();
        if (requestTransactionCreateServerConfigTransaction == null) {
            serverConfigHandler.handle(null);
        } else {
            requestTransactionCreateServerConfigTransaction.serverConfig(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.serverConfig.ServerConfigSynchronizer.1
                @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    if (!responseInfo.isOK() || jSONObject == null) {
                        serverConfigHandler.handle(null);
                    } else {
                        serverConfigHandler.handle(new ServerConfig(jSONObject));
                    }
                    ServerConfigSynchronizer.destroyServerConfigTransaction();
                }
            });
        }
    }

    public static void getServerUserConfigFromServer(final ServerUserConfigHandler serverUserConfigHandler) {
        if (serverUserConfigHandler == null) {
            return;
        }
        RequestTransaction requestTransactionCreateServerUserConfigTransaction = createServerUserConfigTransaction();
        if (requestTransactionCreateServerUserConfigTransaction == null) {
            serverUserConfigHandler.handle(null);
        } else {
            requestTransactionCreateServerUserConfigTransaction.serverUserConfig(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.serverConfig.ServerConfigSynchronizer.2
                @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    if (!responseInfo.isOK() || jSONObject == null) {
                        serverUserConfigHandler.handle(null);
                    } else {
                        serverUserConfigHandler.handle(new ServerUserConfig(jSONObject));
                    }
                    ServerConfigSynchronizer.destroyServerUserConfigTransaction();
                }
            });
        }
    }

    public static void setHosts(String[] strArr) {
        Hosts = strArr;
    }

    public static void setToken(String str) {
        Token = str;
    }
}
