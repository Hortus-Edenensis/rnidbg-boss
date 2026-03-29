package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.RequestInfo;
import com.huawei.openalliance.ad.constant.be;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.lantern.auth.server.WkParams;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4750a = "HttpUtil";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae A[Catch: IOException -> 0x00c9, TRY_ENTER, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:77:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3 A[Catch: IOException -> 0x00c9, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:77:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8 A[Catch: IOException -> 0x00c9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:77:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c5 A[Catch: IOException -> 0x00c9, TRY_ENTER, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:77:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd A[Catch: IOException -> 0x00c9, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:77:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d2 A[Catch: IOException -> 0x00c9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:77:0x0006 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        HttpURLConnection httpURLConnection3;
        int responseCode;
        BufferedReader bufferedReader4;
        ?? stringBuffer = new StringBuffer();
        try {
            try {
                try {
                    httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection2 = null;
                bufferedReader2 = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
                bufferedReader = null;
            }
            try {
                httpURLConnection3.setRequestMethod("GET");
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setReadTimeout(5000);
                httpURLConnection3.setUseCaches(false);
                if (!TextUtils.isEmpty(str2)) {
                    httpURLConnection3.setRequestProperty("User-Agent", str2);
                }
                httpURLConnection3.setChunkedStreamingMode(0);
                httpURLConnection3.setRequestProperty("Connection", "close");
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.connect();
                responseCode = httpURLConnection3.getResponseCode();
                aa.a(f4750a, "get code:" + responseCode);
            } catch (Exception e3) {
                e = e3;
                bufferedReader2 = null;
                httpURLConnection2 = httpURLConnection3;
                bufferedReader3 = bufferedReader2;
                stringBuffer = bufferedReader2;
                str = httpURLConnection2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                httpURLConnection = httpURLConnection3;
                bufferedReader3 = bufferedReader;
                stringBuffer = bufferedReader;
                str = httpURLConnection;
                th.printStackTrace();
                if (bufferedReader3 != null) {
                }
                if (stringBuffer != 0) {
                }
                if (str != 0) {
                }
                return null;
            }
            if (responseCode != 200) {
                httpURLConnection3.disconnect();
                return null;
            }
            InputStream inputStream = httpURLConnection3.getInputStream();
            try {
                bufferedReader4 = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String line = bufferedReader4.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    } catch (Exception e4) {
                        e = e4;
                        Exception exc = e;
                        stringBuffer = inputStream;
                        e = exc;
                        bufferedReader3 = bufferedReader4;
                        str = httpURLConnection3;
                        e.printStackTrace();
                        if (bufferedReader3 != null) {
                        }
                        if (stringBuffer != 0) {
                        }
                        if (str != 0) {
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        Throwable th4 = th;
                        stringBuffer = inputStream;
                        th = th4;
                        bufferedReader3 = bufferedReader4;
                        str = httpURLConnection3;
                        th.printStackTrace();
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        if (stringBuffer != 0) {
                            stringBuffer.close();
                        }
                        if (str != 0) {
                            str.disconnect();
                        }
                        return null;
                    }
                }
                String string = stringBuffer.toString();
                try {
                    bufferedReader4.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpURLConnection3.disconnect();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return string;
            } catch (Exception e6) {
                e = e6;
                bufferedReader4 = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader4 = null;
            }
            e.printStackTrace();
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            if (stringBuffer != 0) {
                stringBuffer.close();
            }
            if (str != 0) {
                str.disconnect();
            }
            return null;
        } catch (Throwable th6) {
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    throw th6;
                }
            }
            if (stringBuffer != 0) {
                stringBuffer.close();
            }
            if (str != 0) {
                str.disconnect();
            }
            throw th6;
        }
    }

    private static byte[] b(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", "5.2.2.0");
            jSONObject.put("srcType", 1);
            jSONObject.put("timeStamp", System.currentTimeMillis());
            jSONObject.put("appid", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put("platform", 2);
            jSONObject2.put("devType", Integer.valueOf(devInfo.getDevType()));
            jSONObject2.put("brand", devInfo.getBrand());
            jSONObject2.put(WkParams.MODEL, devInfo.getModel());
            jSONObject2.put("resolution", devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put("language", devInfo.getLanguage());
            jSONObject2.put(be.ar, devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TKDownloadReason.KSAD_TK_NET, Integer.valueOf(envInfo.getNet()));
            jSONObject3.put("isp", Integer.valueOf(envInfo.getIsp()));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String strA = b.a(y.a(), jSONObject.toString());
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return strA.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ed A[Catch: IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0117, blocks: (B:72:0x00ed, B:89:0x0113, B:47:0x00b4), top: B:114:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0113 A[Catch: IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0117, blocks: (B:72:0x00ed, B:89:0x0113, B:47:0x00b4), top: B:114:0x0001 }] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        HttpURLConnection httpURLConnection3;
        ?? r3;
        ?? r2;
        ?? r1;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader4;
        OutputStream outputStream2;
        InputStream inputStream;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader5;
        OutputStream outputStream3;
        InputStream inputStream2;
        BufferedReader bufferedReader6;
        OutputStream outputStream4;
        InputStream inputStream3;
        BufferedReader bufferedReader7;
        OutputStream outputStream5;
        InputStream inputStream4;
        try {
            try {
                try {
                    httpURLConnection5 = (HttpURLConnection) new URL(str).openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    httpURLConnection5.setRequestMethod("POST");
                    httpURLConnection5.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                    httpURLConnection5.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection5.setConnectTimeout(20000);
                    httpURLConnection5.setReadTimeout(20000);
                    httpURLConnection5.setDoOutput(true);
                    httpURLConnection5.setDoInput(true);
                    httpURLConnection5.connect();
                    if (bArr.length > 0) {
                        outputStream = httpURLConnection5.getOutputStream();
                        try {
                            outputStream.write(bArr);
                            outputStream = outputStream;
                        } catch (Exception e2) {
                            e = e2;
                            r3 = 0;
                            bufferedReader3 = null;
                            r2 = outputStream;
                            r1 = 0;
                            httpURLConnection4 = httpURLConnection5;
                            e.printStackTrace();
                            str = httpURLConnection4;
                            if (r1 != 0) {
                            }
                            if (r2 != 0) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            r3 = 0;
                            bufferedReader3 = null;
                            r2 = outputStream;
                            r1 = 0;
                            httpURLConnection3 = httpURLConnection5;
                            th.printStackTrace();
                            str = httpURLConnection3;
                            if (r1 != 0) {
                            }
                            if (r2 != 0) {
                            }
                            return null;
                        }
                    } else {
                        outputStream = null;
                    }
                    r2 = 200;
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader2 = null;
                    httpURLConnection2 = httpURLConnection5;
                    BufferedReader bufferedReader8 = bufferedReader2;
                    BufferedReader bufferedReader9 = bufferedReader8;
                    bufferedReader3 = bufferedReader9;
                    r1 = bufferedReader2;
                    r2 = bufferedReader8;
                    r3 = bufferedReader9;
                    httpURLConnection4 = httpURLConnection2;
                    e.printStackTrace();
                    str = httpURLConnection4;
                    if (r1 != 0) {
                    }
                    if (r2 != 0) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection5;
                    BufferedReader bufferedReader10 = bufferedReader;
                    BufferedReader bufferedReader11 = bufferedReader10;
                    bufferedReader3 = bufferedReader11;
                    r1 = bufferedReader;
                    r2 = bufferedReader10;
                    r3 = bufferedReader11;
                    httpURLConnection3 = httpURLConnection;
                    th.printStackTrace();
                    str = httpURLConnection3;
                    if (r1 != 0) {
                    }
                    if (r2 != 0) {
                    }
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection2 = null;
                bufferedReader2 = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                bufferedReader = null;
            }
            if (httpURLConnection5.getResponseCode() != 200) {
                if (outputStream != null) {
                    outputStream.close();
                    r1 = outputStream;
                    str = httpURLConnection5;
                }
                return null;
            }
            InputStream inputStream5 = httpURLConnection5.getInputStream();
            try {
                InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream5);
                try {
                    BufferedReader bufferedReader12 = new BufferedReader(inputStreamReader3);
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String line = bufferedReader12.readLine();
                            if (line == null) {
                                break;
                            }
                            stringBuffer.append(line);
                        }
                        String string = stringBuffer.toString();
                        if (inputStream5 != null) {
                            try {
                                inputStream5.close();
                                inputStreamReader3.close();
                                bufferedReader12.close();
                                httpURLConnection5.disconnect();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return string;
                    } catch (Exception e7) {
                        outputStream5 = outputStream;
                        inputStream4 = inputStream5;
                        e = e7;
                        bufferedReader7 = bufferedReader12;
                        inputStreamReader2 = inputStreamReader3;
                        inputStream2 = inputStream4;
                        bufferedReader5 = bufferedReader7;
                        outputStream3 = outputStream5;
                        r2 = outputStream3;
                        r1 = inputStream2;
                        r3 = inputStreamReader2;
                        bufferedReader3 = bufferedReader5;
                        httpURLConnection4 = httpURLConnection5;
                        e.printStackTrace();
                        str = httpURLConnection4;
                        if (r1 != 0) {
                            try {
                                r1.close();
                                if (r3 != 0) {
                                    r3.close();
                                }
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                                httpURLConnection4.disconnect();
                                str = httpURLConnection4;
                            } catch (IOException e8) {
                                e8.printStackTrace();
                                str = e8;
                            }
                        }
                        if (r2 != 0) {
                            r2.close();
                            r1 = r1;
                            r2 = r2;
                            r3 = r3;
                            bufferedReader3 = bufferedReader3;
                            str = str;
                        }
                        return null;
                    } catch (Throwable th4) {
                        outputStream4 = outputStream;
                        inputStream3 = inputStream5;
                        th = th4;
                        bufferedReader6 = bufferedReader12;
                        inputStreamReader = inputStreamReader3;
                        inputStream = inputStream3;
                        bufferedReader4 = bufferedReader6;
                        outputStream2 = outputStream4;
                        r2 = outputStream2;
                        r1 = inputStream;
                        r3 = inputStreamReader;
                        bufferedReader3 = bufferedReader4;
                        httpURLConnection3 = httpURLConnection5;
                        th.printStackTrace();
                        str = httpURLConnection3;
                        if (r1 != 0) {
                            try {
                                r1.close();
                                if (r3 != 0) {
                                    r3.close();
                                }
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                                httpURLConnection3.disconnect();
                                str = httpURLConnection3;
                            } catch (IOException e9) {
                                e9.printStackTrace();
                                str = e9;
                            }
                        }
                        if (r2 != 0) {
                            r2.close();
                            r1 = r1;
                            r2 = r2;
                            r3 = r3;
                            bufferedReader3 = bufferedReader3;
                            str = str;
                        }
                        return null;
                    }
                } catch (Exception e10) {
                    bufferedReader7 = null;
                    outputStream5 = outputStream;
                    inputStream4 = inputStream5;
                    e = e10;
                } catch (Throwable th5) {
                    bufferedReader6 = null;
                    outputStream4 = outputStream;
                    inputStream3 = inputStream5;
                    th = th5;
                }
            } catch (Exception e11) {
                inputStreamReader2 = null;
                bufferedReader5 = null;
                outputStream3 = outputStream;
                inputStream2 = inputStream5;
                e = e11;
            } catch (Throwable th6) {
                inputStreamReader = null;
                bufferedReader4 = null;
                outputStream2 = outputStream;
                inputStream = inputStream5;
                th = th6;
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, File file) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStream inputStream;
        InputStream inputStream2;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        FileInputStream fileInputStream;
        byte[] bArr;
        InputStream inputStream3;
        InputStreamReader inputStreamReader3;
        StringBuffer stringBuffer = new StringBuffer();
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(HttpClient.ENDFLAG + "*****" + HttpClient.NEWLINE);
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + file.getName() + "\"" + HttpClient.NEWLINE);
                dataOutputStream.writeBytes(HttpClient.NEWLINE);
                fileInputStream = new FileInputStream(file);
                bArr = new byte[1024];
            } catch (Exception e) {
                e = e;
                inputStream2 = null;
                inputStreamReader2 = null;
                bufferedReader2 = null;
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                bufferedReader = null;
                inputStream = null;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream2 = null;
            inputStreamReader2 = null;
            bufferedReader2 = null;
            dataOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
        }
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            dataOutputStream.write(bArr, 0, i);
            try {
                e.printStackTrace();
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (inputStreamReader2 != null) {
                    try {
                        inputStreamReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream2 = dataOutputStream;
                BufferedReader bufferedReader3 = bufferedReader2;
                inputStream = inputStream2;
                inputStreamReader = inputStreamReader2;
                bufferedReader = bufferedReader3;
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
        dataOutputStream.writeBytes(HttpClient.NEWLINE);
        fileInputStream.close();
        dataOutputStream.writeBytes(HttpClient.ENDFLAG + "*****" + HttpClient.ENDFLAG + HttpClient.NEWLINE);
        dataOutputStream.flush();
        if (httpURLConnection.getResponseCode() == 200) {
            inputStream3 = httpURLConnection.getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream3);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e11) {
                    bufferedReader2 = null;
                    inputStreamReader3 = inputStreamReader;
                    inputStream2 = inputStream3;
                    e = e11;
                    inputStreamReader2 = inputStreamReader3;
                    e.printStackTrace();
                    if (dataOutputStream != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    if (inputStreamReader2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    return null;
                } catch (Throwable th4) {
                    inputStream = inputStream3;
                    th = th4;
                    bufferedReader = null;
                    dataOutputStream2 = dataOutputStream;
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                }
            } catch (Exception e12) {
                inputStreamReader2 = null;
                bufferedReader2 = null;
                inputStream2 = inputStream3;
                e = e12;
            } catch (Throwable th5) {
                inputStream = inputStream3;
                th = th5;
                inputStreamReader = null;
                bufferedReader = null;
            }
            try {
                stringBuffer = new StringBuffer();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
            } catch (Exception e13) {
                inputStreamReader3 = inputStreamReader;
                inputStream2 = inputStream3;
                e = e13;
                bufferedReader2 = bufferedReader;
                inputStreamReader2 = inputStreamReader3;
                e.printStackTrace();
                if (dataOutputStream != null) {
                }
                if (bufferedReader2 != null) {
                }
                if (inputStreamReader2 != null) {
                }
                if (inputStream2 != null) {
                }
                return null;
            } catch (Throwable th6) {
                dataOutputStream2 = dataOutputStream;
                inputStream = inputStream3;
                th = th6;
                if (dataOutputStream2 != null) {
                }
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                if (inputStream != null) {
                }
            }
        } else {
            inputStream3 = null;
            inputStreamReader = null;
            bufferedReader = null;
        }
        String string = stringBuffer.toString();
        try {
            dataOutputStream.close();
        } catch (IOException e14) {
            e14.printStackTrace();
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e15) {
                e15.printStackTrace();
            }
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        if (inputStream3 != null) {
            try {
                inputStream3.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fd A[Catch: IOException -> 0x013f, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x013f, blocks: (B:70:0x00fd, B:93:0x013b, B:52:0x00c6), top: B:109:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013b A[Catch: IOException -> 0x013f, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x013f, blocks: (B:70:0x00fd, B:93:0x013b, B:52:0x00c6), top: B:109:0x0018 }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.InputStreamReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, String str2, Boolean bool) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        ?? r2;
        OutputStream outputStream3;
        ?? r1;
        ?? r12;
        ?? r8;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection3;
        BufferedReader bufferedReader2;
        if (context != null && str != null && str2 != null) {
            byte[] bArrB = bool.booleanValue() ? b(context, str2) : a(context, str2);
            try {
                if (bArrB == null) {
                    return null;
                }
                try {
                    httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                } catch (Exception unused) {
                    inputStream2 = null;
                    httpURLConnection2 = null;
                    outputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                    httpURLConnection = null;
                    outputStream = null;
                }
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(bArrB.length));
                    httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.connect();
                    if (bArrB.length > 0) {
                        outputStream2 = httpURLConnection2.getOutputStream();
                        try {
                            outputStream2.write(bArrB);
                        } catch (Exception unused2) {
                            inputStream2 = null;
                            outputStream3 = null;
                            r1 = outputStream3;
                            r8 = outputStream3;
                            if (inputStream2 != null) {
                            }
                            if (outputStream2 != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = outputStream2;
                            r12 = 0;
                            r2 = 0;
                            httpURLConnection = httpURLConnection2;
                            inputStream = null;
                            try {
                                th.printStackTrace();
                                if (inputStream != null) {
                                }
                                if (outputStream != null) {
                                }
                                return null;
                            } finally {
                            }
                        }
                    } else {
                        outputStream2 = null;
                    }
                } catch (Exception unused3) {
                    inputStream2 = null;
                    outputStream2 = null;
                    outputStream3 = outputStream2;
                    r1 = outputStream3;
                    r8 = outputStream3;
                    if (inputStream2 != null) {
                    }
                    if (outputStream2 != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                    outputStream = null;
                    OutputStream outputStream4 = outputStream;
                    r2 = outputStream4;
                    r12 = outputStream4;
                    th.printStackTrace();
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    return null;
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    inputStream2 = httpURLConnection2.getInputStream();
                    try {
                        InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream2);
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                StringBuffer stringBuffer = new StringBuffer();
                                while (true) {
                                    String line = bufferedReader3.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    stringBuffer.append(line);
                                }
                                String string = stringBuffer.toString();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                        inputStreamReader2.close();
                                        bufferedReader3.close();
                                        httpURLConnection2.disconnect();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return string;
                            } catch (Exception unused4) {
                                r1 = bufferedReader3;
                                r8 = inputStreamReader2;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                        r8.close();
                                        r1.close();
                                        httpURLConnection2.disconnect();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                return null;
                            } catch (Throwable th4) {
                                httpURLConnection3 = httpURLConnection2;
                                inputStream = inputStream2;
                                th = th4;
                                bufferedReader2 = bufferedReader3;
                                inputStreamReader = inputStreamReader2;
                                bufferedReader = bufferedReader2;
                                outputStream = outputStream2;
                                httpURLConnection = httpURLConnection3;
                                r12 = inputStreamReader;
                                r2 = bufferedReader;
                                th.printStackTrace();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                        r12.close();
                                        r2.close();
                                        httpURLConnection.disconnect();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                return null;
                            }
                        } catch (Exception unused5) {
                            r1 = 0;
                            r8 = inputStreamReader2;
                        } catch (Throwable th5) {
                            bufferedReader2 = null;
                            httpURLConnection3 = httpURLConnection2;
                            inputStream = inputStream2;
                            th = th5;
                        }
                    } catch (Exception unused6) {
                        outputStream3 = null;
                        r1 = outputStream3;
                        r8 = outputStream3;
                        if (inputStream2 != null) {
                        }
                        if (outputStream2 != null) {
                        }
                        return null;
                    } catch (Throwable th6) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        httpURLConnection3 = httpURLConnection2;
                        inputStream = inputStream2;
                        th = th6;
                    }
                } else if (outputStream2 != null) {
                    outputStream2.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    private static byte[] a(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", str);
            jSONObject.put("packageName", ap.c(context));
            jSONObject.put("installTime", String.valueOf(ap.a(context)));
            jSONObject.put("updateTime", String.valueOf(ap.b(context)));
            jSONObject.put("uploadTime", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("appVersion", ap.d(context));
            jSONObject.put("sdkVersion", "5.2.2.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            if (!TextUtils.isEmpty(devInfo.getOaid())) {
                jSONObject2.put("oaid", devInfo.getOaid());
            } else if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
                jSONObject2.put("oaid", requestInfo.getCustomOaid());
            }
            if (!TextUtils.isEmpty(devInfo.getHonorOaid())) {
                jSONObject2.put("honorOaid", devInfo.getHonorOaid());
            }
            jSONObject2.put("gaid", devInfo.getGaid());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put("platform", "2");
            jSONObject2.put("devType", devInfo.getDevType());
            jSONObject2.put("brand", devInfo.getBrand());
            jSONObject2.put(WkParams.MODEL, devInfo.getModel());
            jSONObject2.put("resolution", devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put("language", devInfo.getLanguage());
            jSONObject2.put(be.ar, devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TKDownloadReason.KSAD_TK_NET, envInfo.getNet());
            jSONObject3.put("isp", envInfo.getIsp());
            jSONObject3.put("developerMode", ap.g(context));
            jSONObject3.put("isDebugApk", ap.f(context));
            jSONObject3.put("isDebugConnected", Debug.isDebuggerConnected());
            jSONObject3.put("isWifiProxy", ap.h(context));
            jSONObject3.put("isVpn", ap.b());
            jSONObject3.put("isSimulator", q.a().a(context));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String strA = a.a(jSONObject.toString(), y.b());
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return strA.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
