package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class c extends AsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10651a;
    private String b;
    private OAuthListener c;
    private int d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OAuthErrCode f10652a;
        public String b;
        public int c;
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f10651a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:20:0x008d, B:22:0x009c, B:26:0x00b5, B:28:0x00b9, B:29:0x00c6, B:33:0x00d1, B:30:0x00c9, B:31:0x00cc, B:32:0x00cf), top: B:63:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a doInBackground(Void[] voidArr) throws Throwable {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        OAuthErrCode oAuthErrCode2;
        OAuthErrCode oAuthErrCode3;
        String str2;
        JSONObject jSONObject;
        int i;
        OAuthErrCode oAuthErrCode4;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str3 = this.f10651a;
        if (str3 != null && str3.length() != 0) {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                if (this.d == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.d;
                }
                sb.append(str);
                String string = sb.toString();
                long jCurrentTimeMillis = System.currentTimeMillis();
                byte[] bArrA = com.tencent.mm.opensdk.channel.a.a.a(string, 60000);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                aVar = new a();
                Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (bArrA != null && bArrA.length != 0) {
                    try {
                        try {
                            jSONObject = new JSONObject(new String(bArrA, "utf-8"));
                            int i2 = jSONObject.getInt("wx_errcode");
                            aVar.c = i2;
                            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i2)));
                            i = aVar.c;
                        } catch (Exception e) {
                            str2 = String.format("parse json fail, ex = %s", e.getMessage());
                            Log.e("MicroMsg.SDK.NoopingResult", str2);
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.f10652a = oAuthErrCode2;
                        }
                    } catch (Exception e2) {
                        str2 = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                    }
                    if (i == 408) {
                        oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                        aVar.f10652a = oAuthErrCode4;
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.f10652a.toString(), Integer.valueOf(aVar.c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                        oAuthErrCode3 = aVar.f10652a;
                        if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                            int i3 = aVar.c;
                            this.d = i3;
                            if (i3 == d.UUID_SCANED.a()) {
                                this.c.onQrcodeScanned();
                            } else if (aVar.c != d.UUID_KEEP_CONNECT.a() && aVar.c == d.UUID_CONFIRM.a()) {
                                String str4 = aVar.b;
                                if (str4 == null || str4.length() == 0) {
                                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                }
                            }
                        } else {
                            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), Integer.valueOf(aVar.c)));
                        }
                    } else if (i != 500) {
                        switch (i) {
                            case 402:
                                oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Timeout;
                                aVar.f10652a = oAuthErrCode4;
                                break;
                            case 403:
                                oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Cancel;
                                aVar.f10652a = oAuthErrCode4;
                                break;
                            case 404:
                                break;
                            case 405:
                                aVar.f10652a = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.b = jSONObject.getString("wx_code");
                                break;
                            default:
                                oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                aVar.f10652a = oAuthErrCode4;
                                break;
                        }
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.f10652a.toString(), Integer.valueOf(aVar.c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                        oAuthErrCode3 = aVar.f10652a;
                        if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                        }
                    } else {
                        oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f10652a = oAuthErrCode4;
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.f10652a.toString(), Integer.valueOf(aVar.c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                        oAuthErrCode3 = aVar.f10652a;
                        if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                        }
                    }
                    return aVar;
                }
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                aVar.f10652a = oAuthErrCode2;
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.f10652a.toString(), Integer.valueOf(aVar.c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                oAuthErrCode3 = aVar.f10652a;
                if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                }
                return aVar;
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
            aVar.f10652a = oAuthErrCode;
            return aVar;
        }
        Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        aVar = new a();
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.f10652a = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.c.onAuthFinish(aVar2.f10652a, aVar2.b);
    }
}
