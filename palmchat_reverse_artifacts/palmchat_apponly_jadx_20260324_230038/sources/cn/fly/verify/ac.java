package cn.fly.verify;

import android.net.Network;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.fly.verify.common.exception.VerifyException;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.ad.core.config.EventParams;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ac extends s {
    private static final byte[] m = {98, 126, 126, 122, 121, 48, 37, 37, 99, 110, 60, 36, 103, 111, 37, 107, ByteCompanionObject.MAX_VALUE, 126, 98, 37, 122, 120, 111, 121, 110, 97, 36, 110, 101};
    private static final byte[] n = {126, 115, 114};
    private int i;
    private String j;
    private String k;
    private String l;

    private byte[] b(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int iDigit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (iDigit > 127) {
                iDigit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i] = (byte) iDigit;
        }
        return bArr;
    }

    private String h() {
        String string = UUID.randomUUID().toString();
        try {
            string = UUID.nameUUIDFromBytes((string + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
        } catch (Throwable th) {
            f.a().a(th);
        }
        return !TextUtils.isEmpty(string) ? string.replace("-", "") : string;
    }

    private String i() {
        String strB = fr.b(UUID.randomUUID().toString() + MapController.DEFAULT_LAYER_TAG);
        return TextUtils.isEmpty(strB) ? MapController.DEFAULT_LAYER_TAG : strB;
    }

    @Override // cn.fly.verify.s
    public Object a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(ad.a(this.d, this.b, this.c, ad.b(n), g()));
            String string = jSONObject.getString("p");
            this.l = jSONObject.getString(com.kuaishou.weapon.p0.t.f7496a);
            return TextUtils.isEmpty(string) ? new Throwable("p is null") : string;
        } catch (Throwable th) {
            f.a().a(th);
            return th;
        }
    }

    public String g() {
        return "SDK-HY-v4.5.9";
    }

    @Override // cn.fly.verify.s
    public void a(String str, String str2, String str3, e eVar) {
        this.d = ax.g();
        this.b = str.trim();
        this.c = str2.trim();
        this.g = eVar;
        this.f2433a = str3;
        String strA = ah.a("key_d_i_u", null);
        this.k = strA;
        if (TextUtils.isEmpty(strA)) {
            String strI = i();
            this.k = strI;
            ah.b("key_d_i_u", strI);
        }
    }

    @Override // cn.fly.verify.s
    public void a(boolean z, Network network, Object obj, cn.fly.verify.common.callback.b bVar, e eVar) {
        VerifyException verifyException;
        this.i = 0;
        this.j = h();
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            if (bVar == null) {
                return;
            } else {
                verifyException = new VerifyException(80103, "");
            }
        } else if (as.c()) {
            if (as.b(this.d)) {
                String strB = ad.b(m);
                if (!TextUtils.isEmpty(strB) && !(obj instanceof Throwable)) {
                    a(z, network, strB, obj, 1, bVar);
                    return;
                } else {
                    if (bVar != null) {
                        bVar.a(new VerifyException(80102, as.a((Throwable) obj)));
                        return;
                    }
                    return;
                }
            }
            if (bVar == null) {
                return;
            } else {
                verifyException = new VerifyException(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "");
            }
        } else if (bVar == null) {
            return;
        } else {
            verifyException = new VerifyException(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "");
        }
        bVar.a(verifyException);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x029a A[Catch: all -> 0x030c, TryCatch #10 {all -> 0x030c, blocks: (B:96:0x026b, B:100:0x027b, B:101:0x0296, B:102:0x029a, B:105:0x02a0, B:106:0x02bc, B:109:0x02c2, B:111:0x02e0), top: B:155:0x026b }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fe A[Catch: all -> 0x0302, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0302, blocks: (B:92:0x0264, B:119:0x02fe), top: B:140:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0100 A[EDGE_INSN: B:159:0x0100->B:37:0x0100 BREAK  A[LOOP:1: B:142:0x00fa->B:55:0x01a8], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0146 A[Catch: all -> 0x01b2, TryCatch #2 {all -> 0x01b2, blocks: (B:35:0x00fa, B:37:0x0100, B:43:0x0129, B:46:0x0131, B:48:0x0135, B:50:0x013c, B:51:0x0146, B:53:0x01a2, B:42:0x0122, B:55:0x01a8, B:38:0x010f), top: B:142:0x00fa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a8 A[Catch: all -> 0x01b2, LOOP:1: B:142:0x00fa->B:55:0x01a8, LOOP_END, TRY_LEAVE, TryCatch #2 {all -> 0x01b2, blocks: (B:35:0x00fa, B:37:0x0100, B:43:0x0129, B:46:0x0131, B:48:0x0135, B:50:0x013c, B:51:0x0146, B:53:0x01a2, B:42:0x0122, B:55:0x01a8, B:38:0x010f), top: B:142:0x00fa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0279  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(boolean z, Network network, String str, Object obj, int i, cn.fly.verify.common.callback.b bVar) {
        BufferedReader bufferedReader;
        VerifyException verifyException;
        HttpURLConnection httpURLConnection;
        int i2;
        int responseCode;
        InputStream inputStream;
        List<String> list;
        String strSubstring;
        StringBuilder sb;
        String line;
        String string;
        int i3 = i;
        SystemClock.elapsedRealtime();
        InputStream inputStream2 = null;
        Throwable th = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = (HttpURLConnection) (network != null ? network.openConnection(url) : url.openConnection());
                httpURLConnection.setRequestProperty("accept", "*/*");
                if (i3 == 0) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                }
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setUseCaches(false);
                if (al.c() != 0) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                }
                httpURLConnection.addRequestProperty(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
                httpURLConnection.addRequestProperty("reqId", this.j);
                httpURLConnection.addRequestProperty("deviceId", this.k);
                DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                dataOutputStream.write(obj.toString().getBytes("UTF-8"));
                dataOutputStream.flush();
                dataOutputStream.close();
                responseCode = httpURLConnection.getResponseCode();
            } catch (Throwable th2) {
                f.a().a(th2);
                return;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            try {
                f.a().a(th);
                if (!(th instanceof UnknownHostException)) {
                }
            } finally {
            }
        }
        if (responseCode == 200) {
            List<String> list2 = httpURLConnection.getHeaderFields().get("Set-Cookie");
            if (list2 == null || list2.size() <= 0) {
                strSubstring = null;
                inputStream = httpURLConnection.getInputStream();
                try {
                    sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        try {
                            line = bufferedReader.readLine();
                            if (line != null) {
                                break;
                            }
                            sb.append(line);
                            sb.append("\n");
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream2 = inputStream;
                            f.a().a(th);
                            if (!(th instanceof UnknownHostException)) {
                                if (bVar != null) {
                                    verifyException = new VerifyException(MediationConstant.ErrorCode.ADN_AD_CONTEXT, "presdk-" + th.getMessage());
                                    bVar.a(verifyException);
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th5) {
                                        f.a().a(th5);
                                    }
                                }
                                if (inputStream2 != null) {
                                    return;
                                } else {
                                    inputStream2.close();
                                }
                            } else if (th instanceof SocketTimeoutException) {
                                if (bVar != null) {
                                    verifyException = new VerifyException(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR, "presdk-" + th.getMessage());
                                    bVar.a(verifyException);
                                }
                                if (bufferedReader != null) {
                                }
                                if (inputStream2 != null) {
                                }
                            } else if (th instanceof IOException) {
                                if (bVar != null) {
                                    verifyException = new VerifyException(80007, "presdk-" + th.getMessage());
                                    bVar.a(verifyException);
                                }
                                if (bufferedReader != null) {
                                }
                                if (inputStream2 != null) {
                                }
                            } else {
                                if (bVar != null) {
                                    verifyException = new VerifyException(80102, as.a(th));
                                    bVar.a(verifyException);
                                }
                                if (bufferedReader != null) {
                                }
                                if (inputStream2 != null) {
                                }
                            }
                        }
                    }
                    string = new JSONObject(sb.toString()).getString("data");
                    try {
                        string = new String(ad.a(b(string), this.l));
                    } catch (Throwable th6) {
                        th = th6;
                        f.a().a(th);
                    }
                    if (TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        String strOptString = jSONObject.optString("accessCode");
                        String strOptString2 = jSONObject.optString(EventParams.KEY_PARAM_NUMBER);
                        long jCurrentTimeMillis = System.currentTimeMillis() + (jSONObject.optLong("expiredTime") * 1000);
                        String str2 = strOptString + ":" + ad.a(ax.g(), strSubstring).toLowerCase();
                        HashMap map = new HashMap();
                        map.put("phone", strOptString2);
                        map.put("optoken", str2);
                        map.put("expired", Long.valueOf(jCurrentTimeMillis));
                        if (bVar != null) {
                            bVar.a(map);
                        }
                    } else if (bVar != null) {
                        bVar.a(new VerifyException(80107, th != null ? as.a(th) : ""));
                    }
                    bufferedReader2 = bufferedReader;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader = null;
                }
            } else {
                String str3 = list2.get(0);
                if (!TextUtils.isEmpty(str3) && str3.contains("gw_auth")) {
                    String[] strArrSplit = str3.split(com.huawei.openalliance.ad.constant.x.aQ);
                    for (i2 = 0; i2 < strArrSplit.length; i2++) {
                        if (strArrSplit[i2].contains("gw_auth")) {
                            strSubstring = strArrSplit[i2].substring(("gw_auth" + ContainerUtils.KEY_VALUE_DELIMITER).length());
                            break;
                        }
                    }
                    strSubstring = null;
                    inputStream = httpURLConnection.getInputStream();
                    sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        line = bufferedReader.readLine();
                        if (line != null) {
                        }
                        sb.append(line);
                        sb.append("\n");
                    }
                    string = new JSONObject(sb.toString()).getString("data");
                    string = new String(ad.a(b(string), this.l));
                    if (TextUtils.isEmpty(string)) {
                    }
                    bufferedReader2 = bufferedReader;
                }
            }
        }
        if (responseCode == 302) {
            if (this.i < 10) {
                String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                try {
                    list = httpURLConnection.getHeaderFields().get("rdt_allow");
                } catch (Throwable th8) {
                    f.a().a(th8);
                }
                if (list != null && list.size() > 0) {
                    String str4 = list.get(0);
                    if (!TextUtils.isEmpty(str4)) {
                        i3 = str4.equals("0") ? 0 : 1;
                    }
                }
                this.i++;
                a(z, network, headerField, null, i3, bVar);
            } else if (bVar != null) {
                bVar.a(new VerifyException(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, str + " " + i3));
            }
        } else if (bVar != null) {
            bVar.a(new VerifyException(MediationConstant.ErrorCode.ADN_AD_NO_CACHE, "presdk-code : " + responseCode));
        }
        inputStream = null;
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
            } catch (Throwable th9) {
                f.a().a(th9);
            }
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // cn.fly.verify.s
    public boolean a(VerifyException verifyException, cn.fly.verify.common.callback.b bVar) {
        String message;
        int i = 80800;
        if (verifyException != null) {
            message = verifyException.getMessage();
            if ("switch_timeout".equals(message)) {
                i = 80801;
            }
        } else {
            message = "";
        }
        if (bVar == null) {
            return true;
        }
        bVar.a(new VerifyException(i, message));
        return true;
    }
}
