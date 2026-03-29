package cn.fly.verify;

import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.fq;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.ad.core.config.EventParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2444a = "AID";
    private String b;
    private String c;
    private String h;
    private Network i;
    private String n;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String j = "";
    private byte[] k = new byte[0];
    private byte[] l = new byte[0];
    private String m = "";
    private HashMap<String, String> o = new HashMap<>();

    public x(String str, String str2) {
        this.b = "";
        this.c = "";
        this.h = "";
        this.h = ab.b();
        this.b = str;
        this.c = str2;
        this.o.put("CMCC", "1");
        this.o.put("CUCC", "2");
        this.o.put("CTCC", "3");
    }

    private JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.b);
            jSONObject.put("traceId", this.h);
            jSONObject.put(WfConstant.EVENT_KEY_APP_NAME, al.i());
            jSONObject.put("appVersion", fq.d.c() + ContainerUtils.FIELD_DELIMITER + fq.d.f());
            jSONObject.put("sdkVersion", this.f);
            jSONObject.put("clientType", "android");
            jSONObject.put("timeOut", "8000");
            jSONObject.put("requestTime", "");
            jSONObject.put("responseTime", "");
            jSONObject.put("elapsedTime", System.currentTimeMillis() + "");
            jSONObject.put("requestType", "eventTracking5");
            jSONObject.put("interfaceType", "");
            jSONObject.put("interfaceCode", (Object) null);
            jSONObject.put("interfaceElasped", (Object) null);
            jSONObject.put("loginType", (Object) null);
            jSONObject.put("exceptionStackTrace", (Object) null);
            jSONObject.put("operatorType", this.o.get(as.b()));
            jSONObject.put("networkType", t());
            jSONObject.put("brand", fq.d.l());
            jSONObject.put("reqDevice", fq.d.j());
            jSONObject.put("reqSystem", "android" + Build.VERSION.RELEASE);
            jSONObject.put("simCardNum", "");
            jSONObject.put("imsiState", "0");
            jSONObject.put("resultCode", (Object) null);
            jSONObject.put("AID", (Object) null);
            jSONObject.put("sysOperType", (Object) null);
            jSONObject.put("scripType", (Object) null);
            jSONObject.put("event", s());
            jSONObject.put("exceptionStackTrace", (Object) null);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("authPageOut", "1");
            jSONObject.put("authPageIn", "1");
            jSONObject.put("authClickSuccess", "1");
            jSONObject.put("timeOnAuthPage", String.valueOf(new Random().nextInt(5000) + 800));
            jSONObject.put("authClickFailed", "0");
            jSONObject.put("authPrivacyState", "1");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private int t() {
        String strJ = al.j();
        if (!TextUtils.isEmpty(strJ) && !"none".equalsIgnoreCase(strJ)) {
            boolean zB = as.b(ax.g());
            if ("wifi".equalsIgnoreCase(strJ) && zB) {
                return 3;
            }
            if ("wifi".equalsIgnoreCase(strJ) && !zB) {
                return 2;
            }
            if (zB) {
                return 1;
            }
        }
        return 0;
    }

    private String u() {
        String strA = ah.a(f2444a, null);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String str = "%" + ab.a();
        ah.b(f2444a, str);
        return str;
    }

    public String a() {
        return this.h;
    }

    public String b() {
        return this.j;
    }

    public Network c() {
        return this.i;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        JSONObject jSONObject;
        String str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            String str3 = this.o.get(as.b());
            int iT = t();
            String strEncode = URLEncoder.encode(fq.d.l());
            String strEncode2 = URLEncoder.encode(fq.d.j());
            String strEncode3 = URLEncoder.encode("android" + Build.VERSION.RELEASE);
            String str4 = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
            String strC = fq.d.c();
            String upperCase = al.a().toUpperCase();
            String[] strArrA = aa.a(true);
            if (strArrA == null || strArrA.length <= 0) {
                str = "";
                str2 = str;
            } else {
                str2 = strArrA[0];
                str = strArrA[1];
            }
            try {
                String strA = ab.a();
                String strB = fr.b(this.f + this.b + "" + str3 + iT + strEncode + strEncode2 + strEncode3 + "0" + strA + str4 + this.c + "" + strC + upperCase + str2 + str + PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY + u() + this.d + "200authz" + this.e);
                String str5 = str;
                String str6 = str2;
                jSONObject = jSONObject2;
                try {
                    jSONObject.put("ver", "1.0");
                    jSONObject.put(EventParams.KEY_PARAM_SDKVER, this.f);
                    jSONObject.put("appid", this.b);
                    jSONObject.put("imsi", "");
                    jSONObject.put("operatortype", str3);
                    jSONObject.put("networktype", iT);
                    jSONObject.put("mobilebrand", strEncode);
                    jSONObject.put("mobilemodel", strEncode2);
                    jSONObject.put("mobilesystem", strEncode3);
                    jSONObject.put("clienttype", "0");
                    jSONObject.put("interfacever", "3.0");
                    jSONObject.put("expandparams", "");
                    jSONObject.put("msgid", strA);
                    jSONObject.put("timestamp", str4);
                    jSONObject.put("subimsi", "");
                    jSONObject.put("sign", strB);
                    jSONObject.put("apppackage", strC);
                    jSONObject.put("appsign", upperCase);
                    jSONObject.put("ipv4_list", str6);
                    jSONObject.put("ipv6_list", str5);
                    jSONObject.put("sdkType", PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY);
                    jSONObject.put("tempPDR", u());
                    jSONObject.put("scrip", this.d);
                    jSONObject.put("userCapaid", "200");
                    jSONObject.put("funcType", "authz");
                    jSONObject.put("socketip", this.e);
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                jSONObject = jSONObject2;
            }
        } catch (JSONException unused3) {
            jSONObject = jSONObject2;
        }
        return jSONObject.toString();
    }

    public String f() {
        String str;
        String str2;
        String str3;
        try {
            String strU = u();
            String str4 = this.o.get(as.b());
            int iT = t();
            JSONObject jSONObject = new JSONObject();
            try {
                this.k = UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (Exception unused) {
            }
            jSONObject.put("encrypted", y.a().a(this.k));
            byte[] bArrA = w.a();
            this.l = bArrA;
            jSONObject.put("encryptedIV", Base64.encodeToString(bArrA, 0));
            String strEncode = URLEncoder.encode(fq.d.l());
            String strEncode2 = URLEncoder.encode(fq.d.j());
            String strEncode3 = URLEncoder.encode("android" + Build.VERSION.RELEASE);
            String strA = ab.a();
            String str5 = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
            String strC = fq.d.c();
            String upperCase = al.a().toUpperCase();
            String[] strArrA = aa.a(true);
            if (strArrA != null) {
                str = "pre";
                if (strArrA.length > 0) {
                    str2 = strArrA[0];
                    str3 = strArrA[1];
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f);
                sb.append(this.b);
                sb.append("");
                sb.append(str4);
                sb.append(iT);
                sb.append(strEncode);
                sb.append(strEncode2);
                sb.append(strEncode3);
                sb.append("0");
                sb.append(strA);
                sb.append(str5);
                sb.append(this.c);
                sb.append("");
                sb.append(strC);
                sb.append(upperCase);
                sb.append(str2);
                sb.append(str3);
                sb.append(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY);
                sb.append(strU);
                sb.append(this.d);
                sb.append("");
                String str6 = str;
                sb.append(str6);
                sb.append(this.e);
                jSONObject.put("reqdata", w.a(this.k, "1.0&" + this.f + ContainerUtils.FIELD_DELIMITER + this.b + "&&" + str4 + ContainerUtils.FIELD_DELIMITER + iT + ContainerUtils.FIELD_DELIMITER + strEncode + ContainerUtils.FIELD_DELIMITER + strEncode2 + ContainerUtils.FIELD_DELIMITER + strEncode3 + ContainerUtils.FIELD_DELIMITER + "0" + ContainerUtils.FIELD_DELIMITER + "3.0&&" + strA + ContainerUtils.FIELD_DELIMITER + str5 + "&&" + fr.b(sb.toString()) + ContainerUtils.FIELD_DELIMITER + strC + ContainerUtils.FIELD_DELIMITER + upperCase + "&&" + str2 + ContainerUtils.FIELD_DELIMITER + str3 + ContainerUtils.FIELD_DELIMITER + PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY + ContainerUtils.FIELD_DELIMITER + strU + ContainerUtils.FIELD_DELIMITER + this.d + ContainerUtils.FIELD_DELIMITER + "" + ContainerUtils.FIELD_DELIMITER + str6 + ContainerUtils.FIELD_DELIMITER + this.e, this.l));
                jSONObject.put("securityreinforce", "");
                return jSONObject.toString();
            }
            str = "pre";
            str2 = "";
            str3 = str2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f);
            sb2.append(this.b);
            sb2.append("");
            sb2.append(str4);
            sb2.append(iT);
            sb2.append(strEncode);
            sb2.append(strEncode2);
            sb2.append(strEncode3);
            sb2.append("0");
            sb2.append(strA);
            sb2.append(str5);
            sb2.append(this.c);
            sb2.append("");
            sb2.append(strC);
            sb2.append(upperCase);
            sb2.append(str2);
            sb2.append(str3);
            sb2.append(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY);
            sb2.append(strU);
            sb2.append(this.d);
            sb2.append("");
            String str62 = str;
            sb2.append(str62);
            sb2.append(this.e);
            jSONObject.put("reqdata", w.a(this.k, "1.0&" + this.f + ContainerUtils.FIELD_DELIMITER + this.b + "&&" + str4 + ContainerUtils.FIELD_DELIMITER + iT + ContainerUtils.FIELD_DELIMITER + strEncode + ContainerUtils.FIELD_DELIMITER + strEncode2 + ContainerUtils.FIELD_DELIMITER + strEncode3 + ContainerUtils.FIELD_DELIMITER + "0" + ContainerUtils.FIELD_DELIMITER + "3.0&&" + strA + ContainerUtils.FIELD_DELIMITER + str5 + "&&" + fr.b(sb2.toString()) + ContainerUtils.FIELD_DELIMITER + strC + ContainerUtils.FIELD_DELIMITER + upperCase + "&&" + str2 + ContainerUtils.FIELD_DELIMITER + str3 + ContainerUtils.FIELD_DELIMITER + PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY + ContainerUtils.FIELD_DELIMITER + strU + ContainerUtils.FIELD_DELIMITER + this.d + ContainerUtils.FIELD_DELIMITER + "" + ContainerUtils.FIELD_DELIMITER + str62 + ContainerUtils.FIELD_DELIMITER + this.e, this.l));
            jSONObject.put("securityreinforce", "");
            return jSONObject.toString();
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String g() {
        JSONObject jSONObjectI = i();
        try {
            jSONObjectI.put("data", this.m);
            jSONObjectI.put("funcType", "pre");
        } catch (JSONException unused) {
        }
        return jSONObjectI.toString();
    }

    public String h() {
        JSONObject jSONObjectI = i();
        try {
            jSONObjectI.put("data", this.m);
            jSONObjectI.put("funcType", "authz");
        } catch (JSONException unused) {
        }
        return jSONObjectI.toString();
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", "1.0");
            jSONObject.put("userCapaid", "");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "1.0");
            jSONObject.put("apptype", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("phone_ID", u());
            jSONObject.put("certflag", "0");
            jSONObject.put("sdkversion", this.f);
            jSONObject.put("appid", this.b);
            jSONObject.put("expandparams", "");
            jSONObject.put("sign", fr.b("1.0" + this.f + this.b + "iYm0HAnkxQtpvN44"));
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String k() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            String strA = ab.a();
            String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
            jSONObject2.put("sign", fr.b("2.0" + this.b + str + strA + "@Fdiwmxy7CBDDQNUI"));
            jSONObject2.put("msgid", strA);
            jSONObject2.put("systemtime", str);
            jSONObject2.put("appid", this.b);
            jSONObject2.put("version", "2.0");
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", r());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public byte[] l() {
        return this.k;
    }

    public byte[] m() {
        return this.l;
    }

    public HashMap<String, String> n() {
        HashMap<String, String> mapP = p();
        mapP.put("defendEOF", "1");
        return mapP;
    }

    public HashMap<String, String> o() {
        HashMap<String, String> mapP = p();
        mapP.put("defendEOF", "0");
        return mapP;
    }

    public HashMap<String, String> p() {
        HashMap<String, String> map = new HashMap<>();
        map.put("sdkVersion", this.f);
        map.put("Content-Type", "application/json");
        map.put("CMCC-EncryptType", "STD");
        map.put("traceId", this.h);
        map.put("appid", this.b);
        map.put("connection", HTTP.CONN_KEEP_ALIVE);
        map.put("interfaceVersion", "3.0");
        return map;
    }

    public String q() {
        return this.n;
    }

    public void a(Network network) {
        this.i = network;
    }

    public void b(String str) {
        this.j = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.m = str;
    }

    public void h(String str) {
        this.n = str;
    }

    public void a(String str) {
        this.h = str;
    }
}
