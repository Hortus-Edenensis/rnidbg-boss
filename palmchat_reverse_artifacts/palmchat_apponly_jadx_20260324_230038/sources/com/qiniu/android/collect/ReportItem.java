package com.qiniu.android.collect;

import com.igexin.push.core.b;
import com.qiniu.android.http.ResponseInfo;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ReportItem {
    public static final String BlockKeyBytesSent = "bytes_sent";
    public static final String BlockKeyClientTime = "client_time";
    public static final String BlockKeyCurrentRegionId = "current_region_id";
    public static final String BlockKeyFileSize = "file_size";
    public static final String BlockKeyHijacking = "hijacking";
    public static final String BlockKeyLogType = "log_type";
    public static final String BlockKeyOsName = "os_name";
    public static final String BlockKeyOsVersion = "os_version";
    public static final String BlockKeyPerceptiveSpeed = "perceptive_speed";
    public static final String BlockKeyPid = "pid";
    public static final String BlockKeyRecoveredFrom = "recovered_from";
    public static final String BlockKeySDKName = "sdk_name";
    public static final String BlockKeySDKVersion = "sdk_version";
    public static final String BlockKeyTargetBucket = "target_bucket";
    public static final String BlockKeyTargetKey = "target_key";
    public static final String BlockKeyTargetRegionId = "target_region_id";
    public static final String BlockKeyTid = "tid";
    public static final String BlockKeyTotalElapsedTime = "total_elapsed_time";
    public static final String BlockKeyUpApiVersion = "up_api_version";
    public static final String BlockKeyUpTime = "up_time";
    public static final String LogTypeBlock = "block";
    public static final String LogTypeQuality = "quality";
    public static final String LogTypeRequest = "request";
    public static final String QualityKeyBytesSent = "bytes_sent";
    public static final String QualityKeyCloudType = "cloud_type";
    public static final String QualityKeyErrorDescription = "error_description";
    public static final String QualityKeyErrorType = "error_type";
    public static final String QualityKeyFileSize = "file_size";
    public static final String QualityKeyHijacking = "hijacking";
    public static final String QualityKeyLogType = "log_type";
    public static final String QualityKeyOsName = "os_name";
    public static final String QualityKeyOsVersion = "os_version";
    public static final String QualityKeyPerceptiveSpeed = "perceptive_speed";
    public static final String QualityKeyRegionsCount = "regions_count";
    public static final String QualityKeyRequestsCount = "requests_count";
    public static final String QualityKeyResult = "result";
    public static final String QualityKeySDKName = "sdk_name";
    public static final String QualityKeySDKVersion = "sdk_version";
    public static final String QualityKeyTargetBucket = "target_bucket";
    public static final String QualityKeyTargetKey = "target_key";
    public static final String QualityKeyTotalElapsedTime = "total_elapsed_time";
    public static final String QualityKeyUcQueryElapsedTime = "uc_query_elapsed_time";
    public static final String QualityKeyUpTime = "up_time";
    public static final String QualityKeyUpType = "up_type";
    public static final String RequestKeyBytesSent = "bytes_sent";
    public static final String RequestKeyBytesTotal = "bytes_total";
    public static final String RequestKeyClientTime = "client_time";
    public static final String RequestKeyConnectElapsedTime = "connect_elapsed_time";
    public static final String RequestKeyCurrentRegionId = "current_region_id";
    public static final String RequestKeyDnsElapsedTime = "dns_elapsed_time";
    public static final String RequestKeyDnsErrorMessage = "dns_error_message";
    public static final String RequestKeyDnsSource = "dns_source";
    public static final String RequestKeyErrorDescription = "error_description";
    public static final String RequestKeyErrorType = "error_type";
    public static final String RequestKeyFileOffset = "file_offset";
    public static final String RequestKeyHijacking = "hijacking";
    public static final String RequestKeyHost = "host";
    public static final String RequestKeyHttpClient = "http_client";
    public static final String RequestKeyHttpClientVersion = "http_client_version";
    public static final String RequestKeyHttpVersion = "http_version";
    public static final String RequestKeyLogType = "log_type";
    public static final String RequestKeyNetworkMeasuring = "network_measuring";
    public static final String RequestKeyNetworkType = "network_type";
    public static final String RequestKeyOsName = "os_name";
    public static final String RequestKeyOsVersion = "os_version";
    public static final String RequestKeyPerceptiveSpeed = "perceptive_speed";
    public static final String RequestKeyPid = "pid";
    public static final String RequestKeyPort = "port";
    public static final String RequestKeyPrefetchedBefore = "prefetched_before";
    public static final String RequestKeyPrefetchedDnsSource = "prefetched_dns_source";
    public static final String RequestKeyPrefetchedErrorMessage = "prefetched_error_message";
    public static final String RequestKeyRemoteIp = "remote_ip";
    public static final String RequestKeyRequestElapsedTime = "request_elapsed_time";
    public static final String RequestKeyRequestId = "req_id";
    public static final String RequestKeyResponseElapsedTime = "response_elapsed_time";
    public static final String RequestKeySDKName = "sdk_name";
    public static final String RequestKeySDKVersion = "sdk_version";
    public static final String RequestKeySignalStrength = "signal_strength";
    public static final String RequestKeyStatusCode = "status_code";
    public static final String RequestKeyTLSConnectElapsedTime = "tls_connect_elapsed_time";
    public static final String RequestKeyTargetBucket = "target_bucket";
    public static final String RequestKeyTargetKey = "target_key";
    public static final String RequestKeyTargetRegionId = "target_region_id";
    public static final String RequestKeyTid = "tid";
    public static final String RequestKeyTotalElapsedTime = "total_elapsed_time";
    public static final String RequestKeyUpTime = "up_time";
    public static final String RequestKeyUpType = "up_type";
    public static final String RequestKeyWaitElapsedTime = "wait_elapsed_time";
    private HashMap<String, Object> keyValues = new HashMap<>();

    public static String qualityResult(ResponseInfo responseInfo) {
        if (responseInfo == null) {
            return "unknown_error";
        }
        int i = responseInfo.statusCode;
        String str = (i <= 199 || i >= 300) ? (i <= 399 || !(i < 500 || i == 573 || i == 579 || i == 608 || i == 612 || i == 614 || i == 630 || i == 631 || i == 701)) ? i == -6 ? "zero_size_file" : i == -3 ? "invalid_file" : (i == -5 || i == -4) ? "invalid_args" : null : "bad_request" : b.B;
        return str == null ? requestReportErrorType(responseInfo) : str;
    }

    public static String requestReportErrorType(ResponseInfo responseInfo) {
        if (responseInfo == null) {
            return "unknown_error";
        }
        int i = responseInfo.statusCode;
        if (i <= 199 || i >= 300) {
            return i > 299 ? "response_error" : i == -1 ? "network_error" : i == -1001 ? WkAdConfigModel.TAG_TIMEOUT : i == -1003 ? "unknown_host" : i == -1004 ? "cannot_connect_to_host" : i == -1005 ? "transmission_error" : i == -1200 ? "ssl_error" : i == -1015 ? "parse_error" : i == -8 ? "malicious_response" : i == -2 ? "user_canceled" : i == -7 ? "local_io_error" : i == 100 ? "protocol_error" : i == -1009 ? "network_slow" : "unknown_error";
        }
        return null;
    }

    public static String requestReportStatusCode(ResponseInfo responseInfo) {
        if (responseInfo == null) {
            return null;
        }
        return responseInfo.statusCode + "";
    }

    public void removeReportValue(String str) {
        if (str == null) {
            return;
        }
        this.keyValues.remove(str);
    }

    public void setReport(Object obj, String str) {
        if (str == null || obj == null) {
            return;
        }
        this.keyValues.put(str, obj);
    }

    public String toJson() {
        HashMap<String, Object> map = this.keyValues;
        return (map == null || map.size() == 0) ? "{}" : new JSONObject(this.keyValues).toString();
    }
}
