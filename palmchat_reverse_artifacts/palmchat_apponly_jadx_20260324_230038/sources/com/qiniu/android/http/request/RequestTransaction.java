package com.qiniu.android.http.request;

import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.UserAgent;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.HttpRegionRequest;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.http.request.handler.RequestShouldRetryHandler;
import com.qiniu.android.http.serverRegion.UploadDomainRegion;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.GZipUtil;
import com.qiniu.android.utils.MD5;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import com.qiniu.android.utils.Utils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RequestTransaction {
    private final Configuration config;
    private final String key;
    private HttpRegionRequest regionRequest;
    private UploadRequestInfo requestInfo;
    private UploadRequestState requestState;
    private final UpToken token;
    private final UploadOptions uploadOption;
    private final String userAgent;

    /* JADX INFO: compiled from: SearchBox */
    public interface RequestCompleteHandler {
        void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject);
    }

    public RequestTransaction(List<String> list, UpToken upToken) {
        this(new Configuration.Builder().build(), UploadOptions.defaultOptions(), list, (String) null, (String) null, upToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeAction(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject, RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo = null;
        this.regionRequest = null;
        if (requestCompleteHandler != null) {
            requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
        }
    }

    private void initData(IUploadRegion iUploadRegion, IUploadRegion iUploadRegion2) {
        this.requestState = new UploadRequestState();
        UploadRequestInfo uploadRequestInfo = new UploadRequestInfo();
        this.requestInfo = uploadRequestInfo;
        uploadRequestInfo.targetRegionId = iUploadRegion.getZoneInfo().getRegionId();
        this.requestInfo.currentRegionId = iUploadRegion2.getZoneInfo().getRegionId();
        UploadRequestInfo uploadRequestInfo2 = this.requestInfo;
        UpToken upToken = this.token;
        uploadRequestInfo2.bucket = upToken != null ? upToken.bucket : "";
        uploadRequestInfo2.key = this.key;
        this.regionRequest = new HttpRegionRequest(this.config, this.uploadOption, upToken, iUploadRegion2, uploadRequestInfo2, this.requestState);
    }

    private String resumeV2EncodeKey(String str) {
        return str == null ? Constants.WAVE_SEPARATOR : str.equals("") ? "" : UrlSafeBase64.encodeToString(str);
    }

    public void completeParts(boolean z, String str, String str2, List<Map<String, Object>> list, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "complete_part";
        if (list == null || list.size() == 0) {
            ResponseInfo responseInfoInvalidArgument = ResponseInfo.invalidArgument("partInfoArray");
            if (requestCompleteHandler != null) {
                requestCompleteHandler.complete(responseInfoInvalidArgument, null, responseInfoInvalidArgument.response);
                return;
            }
            return;
        }
        Object[] objArr = new Object[1];
        String str3 = this.token.token;
        if (str3 == null) {
            str3 = "";
        }
        objArr[0] = str3;
        String str4 = String.format("UpToken %s", objArr);
        HashMap map = new HashMap();
        map.put(HttpHeaders.AUTHORIZATION, str4);
        map.put("Content-Type", "application/octet-stream");
        map.put("User-Agent", this.userAgent);
        String str5 = ("/buckets/" + this.token.bucket) + ("/objects/" + resumeV2EncodeKey(this.key)) + ("/uploads/" + str2);
        HashMap map2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(new JSONObject(list.get(i)));
        }
        map2.put("parts", jSONArray);
        if (str != null) {
            map2.put("fname", str);
        }
        String str6 = this.uploadOption.mimeType;
        if (str6 != null) {
            map2.put("mimeType", str6);
        }
        if (this.uploadOption.params != null) {
            map2.put("customVars", new JSONObject(this.uploadOption.params));
        }
        if (this.uploadOption.metaDataParam != null) {
            map2.put("metaData", new JSONObject(this.uploadOption.metaDataParam));
        }
        this.regionRequest.post(str5, z, new JSONObject(map2).toString().getBytes(), map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.15
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.16
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    public void initPart(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "init_parts";
        Object[] objArr = new Object[1];
        String str = this.token.token;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String str2 = String.format("UpToken %s", objArr);
        HashMap map = new HashMap();
        map.put(HttpHeaders.AUTHORIZATION, str2);
        map.put("Content-Type", "application/octet-stream");
        map.put("User-Agent", this.userAgent);
        this.regionRequest.post(("/buckets/" + this.token.bucket) + ("/objects/" + resumeV2EncodeKey(this.key)) + "/uploads", z, null, map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.11
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.12
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    public void makeBlock(long j, long j2, byte[] bArr, boolean z, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        UploadRequestInfo uploadRequestInfo = this.requestInfo;
        uploadRequestInfo.requestType = "mkblk";
        uploadRequestInfo.fileOffset = Long.valueOf(j);
        Object[] objArr = new Object[1];
        String str = this.token.token;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String str2 = String.format("UpToken %s", objArr);
        HashMap map = new HashMap();
        map.put(HttpHeaders.AUTHORIZATION, str2);
        map.put("Content-Type", "application/octet-stream");
        map.put("User-Agent", this.userAgent);
        final String str3 = "" + Crc32.bytes(bArr);
        this.regionRequest.post("/mkblk/" + j2, z, bArr, map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.5
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                String string;
                if (jSONObject == null) {
                    return true;
                }
                String strValueOf = null;
                try {
                    string = jSONObject.getString("ctx");
                    try {
                        strValueOf = String.valueOf(jSONObject.getLong("crc32"));
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    string = null;
                }
                return !responseInfo.isOK() || string == null || strValueOf == null || !str3.equals(strValueOf);
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.6
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void makeFile(long j, String str, String[] strArr, boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "mkfile";
        if (strArr == null) {
            ResponseInfo responseInfoInvalidArgument = ResponseInfo.invalidArgument("invalid blockContexts");
            completeAction(responseInfoInvalidArgument, null, responseInfoInvalidArgument.response, requestCompleteHandler);
            return;
        }
        Object[] objArr = new Object[1];
        String str2 = this.token.token;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String str3 = String.format("UpToken %s", objArr);
        HashMap map = new HashMap();
        map.put(HttpHeaders.AUTHORIZATION, str3);
        map.put("Content-Type", "application/octet-stream");
        map.put("User-Agent", this.userAgent);
        String str4 = "/mkfile/" + j + String.format("/mimeType/%s", UrlSafeBase64.encodeToString(this.uploadOption.mimeType));
        String str5 = this.key;
        if (str5 != null) {
            str4 = str4 + String.format("/key/%s", UrlSafeBase64.encodeToString(str5));
        }
        Map<String, String> map2 = this.uploadOption.params;
        if (map2 != null) {
            for (String str6 : map2.keySet()) {
                String str7 = this.uploadOption.params.get(str6);
                if (str7 != null) {
                    str4 = str4 + ("/" + str6 + "/" + UrlSafeBase64.encodeToString(str7));
                }
            }
        }
        Map<String, String> map3 = this.uploadOption.metaDataParam;
        if (map3 != null) {
            for (String str8 : map3.keySet()) {
                String str9 = this.uploadOption.metaDataParam.get(str8);
                if (str9 != null) {
                    str4 = str4 + ("/" + str8 + "/" + UrlSafeBase64.encodeToString(str9));
                }
            }
        }
        this.regionRequest.post(str4 + String.format("/fname/%s", UrlSafeBase64.encodeToString(str)), z, StringUtils.join(strArr, ",").getBytes(), map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.9
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.10
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void queryUploadHosts(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "uc_query";
        RequestShouldRetryHandler requestShouldRetryHandler = new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.1
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        };
        HashMap map = new HashMap();
        map.put("User-Agent", this.userAgent);
        UpToken upToken = this.token;
        this.regionRequest.get(String.format("/v4/query?ak=%s&bucket=%s&sdk_version=%s&sdk_name=%s", upToken.accessKey, upToken.bucket, Utils.sdkVerion(), Utils.sdkLanguage()), z, map, requestShouldRetryHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.2
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void reportLog(byte[] bArr, String str, boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "uplog";
        Object[] objArr = new Object[1];
        String str2 = this.token.token;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String str3 = String.format("UpToken %s", objArr);
        HashMap map = new HashMap();
        map.put(HttpHeaders.AUTHORIZATION, str3);
        map.put("Content-Type", HTTP.PLAIN_TEXT_TYPE);
        map.put("User-Agent", this.userAgent);
        if (str != null) {
            map.put("X-Log-Client-Id", str);
        }
        this.regionRequest.post("/log/4?compressed=gzip", z, GZipUtil.gZip(bArr), map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.17
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.18
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void serverConfig(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "server_config";
        HashMap map = new HashMap();
        map.put("User-Agent", this.userAgent);
        this.regionRequest.post(String.format("/v1/sdk/config?sdk_name=%s&sdk_version=%s", Utils.sdkLanguage(), Utils.sdkVerion()), z, null, map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.19
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.20
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void serverUserConfig(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "server_user_config";
        HashMap map = new HashMap();
        map.put("User-Agent", this.userAgent);
        this.regionRequest.post(String.format("/v1/sdk/config/user?ak=%s&sdk_name=%s&sdk_version=%s", this.token.accessKey, Utils.sdkLanguage(), Utils.sdkVerion()), z, null, map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.21
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.22
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void uploadChunk(String str, long j, byte[] bArr, long j2, boolean z, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        UploadRequestInfo uploadRequestInfo = this.requestInfo;
        uploadRequestInfo.requestType = "bput";
        uploadRequestInfo.fileOffset = Long.valueOf(j + j2);
        Object[] objArr = new Object[1];
        String str2 = this.token.token;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String str3 = String.format("UpToken %s", objArr);
        HashMap map = new HashMap();
        map.put(HttpHeaders.AUTHORIZATION, str3);
        map.put("Content-Type", "application/octet-stream");
        map.put("User-Agent", this.userAgent);
        String str4 = String.format("/bput/%s/%s", str, j2 + "");
        final String str5 = "" + Crc32.bytes(bArr);
        this.regionRequest.post(str4, z, bArr, map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.7
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                String string;
                if (jSONObject == null) {
                    return true;
                }
                String strValueOf = null;
                try {
                    string = jSONObject.getString("ctx");
                    try {
                        strValueOf = String.valueOf(jSONObject.getLong("crc32"));
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    string = null;
                }
                return !responseInfo.isOK() || string == null || strValueOf == null || !str5.equals(strValueOf);
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.8
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void uploadFormData(byte[] bArr, String str, boolean z, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "form";
        HashMap map = new HashMap();
        Map<String, String> map2 = this.uploadOption.params;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.uploadOption.metaDataParam;
        if (map3 != null) {
            map.putAll(map3);
        }
        String str2 = this.key;
        if (str2 != null && str2.length() > 0) {
            map.put("key", this.key);
        }
        String str3 = this.token.token;
        if (str3 == null) {
            str3 = "";
        }
        map.put("token", str3);
        if (this.uploadOption.checkCrc) {
            map.put("crc32", String.valueOf(Crc32.bytes(bArr)));
        }
        StringBuilder sb = new StringBuilder();
        for (String str4 : map.keySet()) {
            String str5 = (String) map.get(str4);
            sb.append(String.format("--%s\r\n%s; name=\"%s\"\r\n\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf", "Content-Disposition: form-data", str4));
            sb.append(String.format("%s\r\n", str5));
        }
        String str6 = String.format("--%s\r\n%s; name=\"%s\"; filename=\"%s\"\nContent-Type:%s\r\n\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf", "Content-Disposition: form-data", "file", Utils.formEscape(str), this.uploadOption.mimeType);
        String str7 = String.format("\r\n--%s--\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf");
        byte[] bytes = sb.toString().getBytes();
        byte[] bytes2 = str6.getBytes();
        byte[] bytes3 = str7.getBytes();
        int length = bytes.length + bytes2.length + bArr.length + bytes3.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr2, bytes.length, bytes2.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length + bytes2.length, bArr.length);
        System.arraycopy(bytes3, 0, bArr2, bytes.length + bytes2.length + bArr.length, bytes3.length);
        HashMap map4 = new HashMap();
        map4.put("Content-Type", "multipart/form-data; boundary=werghnvt54wef654rjuhgb56trtg34tweuyrgf");
        map4.put("Content-Length", String.valueOf(length));
        map4.put("User-Agent", this.userAgent);
        this.regionRequest.post(null, z, bArr2, map4, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.3
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.4
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void uploadPart(boolean z, String str, int i, byte[] bArr, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        String strEncrypt;
        this.requestInfo.requestType = "upload_part";
        Object[] objArr = new Object[1];
        String str2 = this.token.token;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String str3 = String.format("UpToken %s", objArr);
        HashMap map = new HashMap();
        map.put(HttpHeaders.AUTHORIZATION, str3);
        map.put("Content-Type", "application/octet-stream");
        map.put("User-Agent", this.userAgent);
        if (this.uploadOption.checkCrc && (strEncrypt = MD5.encrypt(bArr)) != null) {
            map.put(HttpHeaders.CONTENT_MD5, strEncrypt);
        }
        this.regionRequest.put(("/buckets/" + this.token.bucket) + ("/objects/" + resumeV2EncodeKey(this.key)) + ("/uploads/" + str) + ("/" + i), z, bArr, map, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.13
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                String string;
                if (jSONObject == null) {
                    return true;
                }
                String string2 = null;
                try {
                    string = jSONObject.getString("etag");
                    try {
                        string2 = jSONObject.getString("md5");
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    string = null;
                }
                return !responseInfo.isOK() || string == null || string2 == null;
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.14
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    public RequestTransaction(List<String> list, String str, UpToken upToken) {
        this(new Configuration.Builder().build(), UploadOptions.defaultOptions(), list, str, (String) null, upToken);
    }

    public RequestTransaction(Configuration configuration, UploadOptions uploadOptions, List<String> list, String str, String str2, UpToken upToken) {
        this(configuration, uploadOptions, str2, upToken);
        UploadDomainRegion uploadDomainRegion = new UploadDomainRegion();
        uploadDomainRegion.setupRegionData(ZoneInfo.buildInfo(list, str));
        initData(uploadDomainRegion, uploadDomainRegion);
    }

    public RequestTransaction(Configuration configuration, UploadOptions uploadOptions, IUploadRegion iUploadRegion, IUploadRegion iUploadRegion2, String str, UpToken upToken) {
        this(configuration, uploadOptions, str, upToken);
        initData(iUploadRegion, iUploadRegion2);
    }

    private RequestTransaction(Configuration configuration, UploadOptions uploadOptions, String str, UpToken upToken) {
        String str2;
        this.config = configuration;
        this.uploadOption = uploadOptions;
        this.key = str;
        this.token = upToken;
        this.userAgent = UserAgent.instance().getUa((upToken == null || (str2 = upToken.accessKey) == null) ? "" : str2);
    }
}
