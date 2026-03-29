package com.qiniu.android.http.request;

import com.google.android.material.timepicker.TimeModel;
import com.qiniu.android.collect.ReportItem;
import com.qiniu.android.collect.UploadInfoReporter;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.connectCheck.ConnectChecker;
import com.qiniu.android.http.dns.DnsPrefetcher;
import com.qiniu.android.http.dns.DnsSource;
import com.qiniu.android.http.metrics.UploadSingleRequestMetrics;
import com.qiniu.android.http.networkStatus.NetworkStatusManager;
import com.qiniu.android.http.request.IRequestClient;
import com.qiniu.android.http.request.handler.CheckCancelHandler;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.http.request.handler.RequestShouldRetryHandler;
import com.qiniu.android.http.request.httpclient.SystemHttpClient;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.GlobalConfiguration;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.Utils;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class HttpSingleRequest {
    private IRequestClient client;
    private final Configuration config;
    private int currentRetryTime = 0;
    private final UploadRequestInfo requestInfo;
    private ArrayList<UploadSingleRequestMetrics> requestMetricsList;
    private final UploadRequestState requestState;
    private final UpToken token;
    private final UploadOptions uploadOption;

    /* JADX INFO: compiled from: SearchBox */
    public interface RequestCompleteHandler {
        void complete(ResponseInfo responseInfo, ArrayList<UploadSingleRequestMetrics> arrayList, JSONObject jSONObject);
    }

    public HttpSingleRequest(Configuration configuration, UploadOptions uploadOptions, UpToken upToken, UploadRequestInfo uploadRequestInfo, UploadRequestState uploadRequestState) {
        this.config = configuration;
        this.uploadOption = uploadOptions;
        this.token = upToken;
        this.requestInfo = uploadRequestInfo;
        this.requestState = uploadRequestState;
    }

    public static /* synthetic */ int access$812(HttpSingleRequest httpSingleRequest, int i) {
        int i2 = httpSingleRequest.currentRetryTime + i;
        httpSingleRequest.currentRetryTime = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeAction(IUploadServer iUploadServer, ResponseInfo responseInfo, JSONObject jSONObject, UploadSingleRequestMetrics uploadSingleRequestMetrics, RequestCompleteHandler requestCompleteHandler) {
        if (this.client == null) {
            return;
        }
        this.client = null;
        updateHostNetworkStatus(responseInfo, iUploadServer, uploadSingleRequestMetrics);
        if (requestCompleteHandler != null) {
            requestCompleteHandler.complete(responseInfo, this.requestMetricsList, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRequest(ResponseInfo responseInfo, IUploadServer iUploadServer, UploadSingleRequestMetrics uploadSingleRequestMetrics) {
        UploadRequestInfo uploadRequestInfo;
        UpToken upToken = this.token;
        if (upToken == null || !upToken.isValid() || (uploadRequestInfo = this.requestInfo) == null || !uploadRequestInfo.shouldReportRequestLog() || uploadSingleRequestMetrics == null) {
            return;
        }
        long jCurrentTimestamp = Utils.currentTimestamp();
        ReportItem reportItem = new ReportItem();
        reportItem.setReport(ReportItem.LogTypeRequest, "log_type");
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.getStartDate().getTime() / 1000), "up_time");
        reportItem.setReport(ReportItem.requestReportStatusCode(responseInfo), ReportItem.RequestKeyStatusCode);
        String str = null;
        reportItem.setReport(responseInfo != null ? responseInfo.reqId : null, ReportItem.RequestKeyRequestId);
        reportItem.setReport(uploadSingleRequestMetrics.getRequest() != null ? uploadSingleRequestMetrics.getRequest().host : null, "host");
        reportItem.setReport(uploadSingleRequestMetrics.getRemoteAddress(), ReportItem.RequestKeyRemoteIp);
        reportItem.setReport(uploadSingleRequestMetrics.getRemotePort(), ReportItem.RequestKeyPort);
        reportItem.setReport(this.requestInfo.bucket, "target_bucket");
        reportItem.setReport(this.requestInfo.key, "target_key");
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalElapsedTime()), "total_elapsed_time");
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalDnsTime()), ReportItem.RequestKeyDnsElapsedTime);
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalConnectTime()), ReportItem.RequestKeyConnectElapsedTime);
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalSecureConnectTime()), ReportItem.RequestKeyTLSConnectElapsedTime);
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalRequestTime()), ReportItem.RequestKeyRequestElapsedTime);
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalWaitTime()), ReportItem.RequestKeyWaitElapsedTime);
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalWaitTime()), ReportItem.RequestKeyResponseElapsedTime);
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalResponseTime()), ReportItem.RequestKeyResponseElapsedTime);
        reportItem.setReport(this.requestInfo.fileOffset, ReportItem.RequestKeyFileOffset);
        reportItem.setReport(uploadSingleRequestMetrics.bytesSend(), "bytes_sent");
        reportItem.setReport(Long.valueOf(uploadSingleRequestMetrics.totalBytes()), ReportItem.RequestKeyBytesTotal);
        reportItem.setReport(Utils.getCurrentProcessID(), "pid");
        reportItem.setReport(Utils.getCurrentThreadID(), "tid");
        reportItem.setReport(this.requestInfo.targetRegionId, "target_region_id");
        reportItem.setReport(this.requestInfo.currentRegionId, "current_region_id");
        String strRequestReportErrorType = ReportItem.requestReportErrorType(responseInfo);
        reportItem.setReport(strRequestReportErrorType, "error_type");
        if (responseInfo != null && strRequestReportErrorType != null && (str = responseInfo.error) == null) {
            str = responseInfo.message;
        }
        reportItem.setReport(str, "error_description");
        reportItem.setReport(this.requestInfo.requestType, "up_type");
        reportItem.setReport(Utils.systemName(), "os_name");
        reportItem.setReport(Utils.systemVersion(), "os_version");
        reportItem.setReport(Utils.sdkLanguage(), "sdk_name");
        reportItem.setReport(Utils.sdkVerion(), "sdk_version");
        reportItem.setReport(Long.valueOf(jCurrentTimestamp), "client_time");
        reportItem.setReport(Utils.getCurrentNetworkType(), "network_type");
        reportItem.setReport(Utils.getCurrentSignalStrength(), ReportItem.RequestKeySignalStrength);
        reportItem.setReport(iUploadServer.getSource(), ReportItem.RequestKeyPrefetchedDnsSource);
        if (iUploadServer.getIpPrefetchedTime() != null) {
            reportItem.setReport(Long.valueOf((jCurrentTimestamp / 1000) - iUploadServer.getIpPrefetchedTime().longValue()), ReportItem.RequestKeyPrefetchedBefore);
        }
        reportItem.setReport(DnsPrefetcher.getInstance().lastPrefetchErrorMessage, ReportItem.RequestKeyPrefetchedErrorMessage);
        reportItem.setReport(uploadSingleRequestMetrics.getClientName(), ReportItem.RequestKeyHttpClient);
        reportItem.setReport(uploadSingleRequestMetrics.getClientVersion(), ReportItem.RequestKeyHttpClientVersion);
        if (!GlobalConfiguration.getInstance().connectCheckEnable) {
            reportItem.setReport("disable", ReportItem.RequestKeyNetworkMeasuring);
        } else if (uploadSingleRequestMetrics.getConnectCheckMetrics() != null) {
            Locale locale = Locale.ENGLISH;
            reportItem.setReport(String.format("duration:%s status_code:%s", String.format(locale, TimeModel.NUMBER_FORMAT, Long.valueOf(uploadSingleRequestMetrics.getConnectCheckMetrics().totalElapsedTime())), uploadSingleRequestMetrics.getConnectCheckMetrics().getResponse() != null ? String.format(locale, TimeModel.NUMBER_FORMAT, Integer.valueOf(uploadSingleRequestMetrics.getConnectCheckMetrics().getResponse().statusCode)) : ""), ReportItem.RequestKeyNetworkMeasuring);
        }
        reportItem.setReport(uploadSingleRequestMetrics.getHijacked(), "hijacking");
        reportItem.setReport(uploadSingleRequestMetrics.getSyncDnsSource(), ReportItem.RequestKeyDnsSource);
        reportItem.setReport(uploadSingleRequestMetrics.getSyncDnsError(), ReportItem.RequestKeyDnsErrorMessage);
        if (responseInfo.isOK()) {
            reportItem.setReport(uploadSingleRequestMetrics.perceptiveSpeed(), "perceptive_speed");
        }
        reportItem.setReport(uploadSingleRequestMetrics.getHttpVersion(), ReportItem.RequestKeyHttpVersion);
        UploadInfoReporter.getInstance().report(reportItem, this.token.token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryRequest(final Request request, final IUploadServer iUploadServer, final boolean z, final RequestShouldRetryHandler requestShouldRetryHandler, final RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        if (iUploadServer.isHttp3()) {
            this.client = new SystemHttpClient();
        } else {
            this.client = new SystemHttpClient();
        }
        final CheckCancelHandler checkCancelHandler = new CheckCancelHandler() { // from class: com.qiniu.android.http.request.HttpSingleRequest.1
            @Override // com.qiniu.android.http.request.handler.CheckCancelHandler
            public boolean checkCancel() {
                boolean zIsUserCancel = HttpSingleRequest.this.requestState.isUserCancel();
                return (zIsUserCancel || HttpSingleRequest.this.uploadOption.cancellationSignal == null) ? zIsUserCancel : HttpSingleRequest.this.uploadOption.cancellationSignal.isCancelled();
            }
        };
        LogUtil.i("key:" + StringUtils.toNonnullString(this.requestInfo.key) + " retry:" + this.currentRetryTime + " url:" + StringUtils.toNonnullString(request.urlString) + " ip:" + StringUtils.toNonnullString(request.ip));
        this.client.request(request, z, this.config.proxy, new IRequestClient.Progress() { // from class: com.qiniu.android.http.request.HttpSingleRequest.2
            @Override // com.qiniu.android.http.request.IRequestClient.Progress
            public void progress(long j, long j2) {
                if (checkCancelHandler.checkCancel()) {
                    HttpSingleRequest.this.requestState.setUserCancel(true);
                    if (HttpSingleRequest.this.client != null) {
                        HttpSingleRequest.this.client.cancel();
                        return;
                    }
                    return;
                }
                RequestProgressHandler requestProgressHandler2 = requestProgressHandler;
                if (requestProgressHandler2 != null) {
                    requestProgressHandler2.progress(j, j2);
                }
            }
        }, new IRequestClient.CompleteHandler() { // from class: com.qiniu.android.http.request.HttpSingleRequest.3
            @Override // com.qiniu.android.http.request.IRequestClient.CompleteHandler
            public void complete(ResponseInfo responseInfo, UploadSingleRequestMetrics uploadSingleRequestMetrics, JSONObject jSONObject) {
                String str;
                if (uploadSingleRequestMetrics != null) {
                    HttpSingleRequest.this.requestMetricsList.add(uploadSingleRequestMetrics);
                }
                if (checkCancelHandler.checkCancel()) {
                    ResponseInfo responseInfoCancelled = ResponseInfo.cancelled();
                    HttpSingleRequest.this.reportRequest(responseInfoCancelled, iUploadServer, uploadSingleRequestMetrics);
                    HttpSingleRequest.this.completeAction(iUploadServer, responseInfoCancelled, responseInfoCancelled.response, uploadSingleRequestMetrics, requestCompleteHandler);
                    return;
                }
                if (responseInfo != null) {
                    responseInfo = responseInfo.checkMaliciousResponse();
                }
                boolean z2 = false;
                boolean z3 = DnsSource.isCustom(iUploadServer.getSource()) || DnsSource.isDoh(iUploadServer.getSource()) || DnsSource.isDnspod(iUploadServer.getSource());
                if (responseInfo != null && responseInfo.isNotQiniu() && !z3) {
                    z2 = true;
                }
                if (z2 && uploadSingleRequestMetrics != null) {
                    uploadSingleRequestMetrics.setHijacked(UploadSingleRequestMetrics.RequestHijacked);
                    try {
                        uploadSingleRequestMetrics.setSyncDnsSource(DnsPrefetcher.getInstance().lookupBySafeDns(iUploadServer.getHost()));
                    } catch (Exception e) {
                        uploadSingleRequestMetrics.setSyncDnsError(e.toString());
                    }
                }
                if (!z2 && HttpSingleRequest.this.shouldCheckConnect(responseInfo)) {
                    UploadSingleRequestMetrics uploadSingleRequestMetricsCheck = ConnectChecker.check();
                    if (uploadSingleRequestMetrics != null) {
                        uploadSingleRequestMetrics.setConnectCheckMetrics(uploadSingleRequestMetricsCheck);
                    }
                    if (!ConnectChecker.isConnected(uploadSingleRequestMetricsCheck)) {
                        if (responseInfo == null) {
                            str = "";
                        } else {
                            str = "check origin statusCode:" + responseInfo.statusCode + " error:" + responseInfo.error;
                        }
                        responseInfo = ResponseInfo.errorInfo(-1009, str);
                    } else if (uploadSingleRequestMetrics != null && !z3) {
                        uploadSingleRequestMetrics.setHijacked(UploadSingleRequestMetrics.RequestMaybeHijacked);
                        try {
                            uploadSingleRequestMetrics.setSyncDnsSource(DnsPrefetcher.getInstance().lookupBySafeDns(iUploadServer.getHost()));
                        } catch (Exception e2) {
                            uploadSingleRequestMetrics.setSyncDnsError(e2.toString());
                        }
                    }
                }
                ResponseInfo responseInfo2 = responseInfo;
                HttpSingleRequest.this.reportRequest(responseInfo2, iUploadServer, uploadSingleRequestMetrics);
                LogUtil.i("key:" + StringUtils.toNonnullString(HttpSingleRequest.this.requestInfo.key) + " response:" + StringUtils.toNonnullString(responseInfo2));
                RequestShouldRetryHandler requestShouldRetryHandler2 = requestShouldRetryHandler;
                if (requestShouldRetryHandler2 == null || !requestShouldRetryHandler2.shouldRetry(responseInfo2, jSONObject) || HttpSingleRequest.this.currentRetryTime >= HttpSingleRequest.this.config.retryMax || responseInfo2 == null || !responseInfo2.couldHostRetry()) {
                    HttpSingleRequest.this.completeAction(iUploadServer, responseInfo2, jSONObject, uploadSingleRequestMetrics, requestCompleteHandler);
                    return;
                }
                HttpSingleRequest.access$812(HttpSingleRequest.this, 1);
                try {
                    Thread.sleep(HttpSingleRequest.this.config.retryInterval);
                } catch (InterruptedException unused) {
                }
                HttpSingleRequest.this.retryRequest(request, iUploadServer, z, requestShouldRetryHandler, requestProgressHandler, requestCompleteHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldCheckConnect(ResponseInfo responseInfo) {
        if (!GlobalConfiguration.getInstance().connectCheckEnable || responseInfo == null) {
            return false;
        }
        int i = responseInfo.statusCode;
        return i == -1 || i == -1001 || i == -1003 || i == -1004 || i == -1005 || i == -1009 || responseInfo.isTlsError();
    }

    private void updateHostNetworkStatus(ResponseInfo responseInfo, IUploadServer iUploadServer, UploadSingleRequestMetrics uploadSingleRequestMetrics) {
        if (uploadSingleRequestMetrics == null) {
            return;
        }
        long jLongValue = uploadSingleRequestMetrics.bytesSend().longValue();
        long j = uploadSingleRequestMetrics.totalElapsedTime();
        if (j <= 0 || jLongValue < 1048576) {
            return;
        }
        String networkStatusType = NetworkStatusManager.getNetworkStatusType(iUploadServer.getHost(), iUploadServer.getIp());
        NetworkStatusManager.getInstance().updateNetworkStatus(networkStatusType, (int) ((jLongValue * 1000) / j));
    }

    public void request(Request request, IUploadServer iUploadServer, boolean z, RequestShouldRetryHandler requestShouldRetryHandler, RequestProgressHandler requestProgressHandler, RequestCompleteHandler requestCompleteHandler) {
        this.currentRetryTime = 0;
        this.requestMetricsList = new ArrayList<>();
        retryRequest(request, iUploadServer, z, requestShouldRetryHandler, requestProgressHandler, requestCompleteHandler);
    }
}
