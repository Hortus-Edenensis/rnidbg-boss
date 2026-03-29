package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.d.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {
    private static final String b = "b";

    public b(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x037c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0385 A[Catch: IOException -> 0x0380, TRY_LEAVE, TryCatch #14 {IOException -> 0x0380, blocks: (B:94:0x037c, B:98:0x0385), top: B:108:0x037c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h a(String str, String str2, int i, g gVar) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        IOException iOException;
        InputStream inputStream;
        UnknownHostException unknownHostException;
        SocketTimeoutException socketTimeoutException;
        Throwable th2;
        HttpURLConnection httpURLConnectionB;
        int responseCode;
        int i2;
        StringBuilder sb;
        h hVar = new h();
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    httpURLConnectionB = b(str, str2, i, gVar);
                    responseCode = httpURLConnectionB.getResponseCode();
                    i2 = 0;
                } catch (Throwable th3) {
                    th2 = th3;
                    bufferedReader = bufferedReader2;
                    inputStream2 = inputStream;
                    if (bufferedReader != null) {
                    }
                    if (inputStream2 != null) {
                    }
                }
            } catch (SocketTimeoutException e) {
                socketTimeoutException = e;
                inputStream = null;
            } catch (UnknownHostException e2) {
                unknownHostException = e2;
                inputStream = null;
            } catch (IOException e3) {
                iOException = e3;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        if (responseCode == 200) {
            inputStream = httpURLConnectionB.getInputStream();
            try {
                sb = new StringBuilder();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (SocketTimeoutException e5) {
                socketTimeoutException = e5;
            } catch (UnknownHostException e6) {
                unknownHostException = e6;
            } catch (IOException e7) {
                iOException = e7;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                } catch (SocketTimeoutException e8) {
                    socketTimeoutException = e8;
                    bufferedReader2 = bufferedReader;
                    hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR, cn.com.chinatelecom.account.api.a.d.a(j.f) + "-" + gVar.c + "-" + socketTimeoutException.getMessage());
                    CtAuth.warn(b, "SocketTimeoutException-" + gVar.c + "-" + socketTimeoutException.getMessage(), socketTimeoutException);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SocketTimeoutException ：");
                    sb2.append(socketTimeoutException.getMessage());
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb2.toString());
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (UnknownHostException e9) {
                    unknownHostException = e9;
                    bufferedReader2 = bufferedReader;
                    hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_CONTEXT, cn.com.chinatelecom.account.api.a.d.a(j.g) + "-" + gVar.c + "-" + unknownHostException.getMessage());
                    CtAuth.warn(b, "UnknownHostException-" + gVar.c + "-" + unknownHostException.getMessage(), unknownHostException);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("UnknownHostException ：");
                    sb3.append(unknownHostException.getMessage());
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb3.toString());
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e10) {
                    iOException = e10;
                    bufferedReader2 = bufferedReader;
                    hVar.b = j.a(80007, cn.com.chinatelecom.account.api.a.d.a(j.h) + "-" + gVar.c + "-" + iOException.getMessage());
                    CtAuth.warn(b, "IOException-" + gVar.c + "-" + iOException.getMessage(), iOException);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("IOException ：");
                    sb4.append(iOException.getMessage());
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb4.toString());
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream2 = inputStream;
                    try {
                        hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, cn.com.chinatelecom.account.api.a.d.a(j.b) + "-" + gVar.c + "-" + th.getMessage());
                        CtAuth.warn(b, "Throwable-" + gVar.c + "-" + th.getMessage(), th);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Throwable ：");
                        sb5.append(th.getMessage());
                        cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb5.toString());
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                throw th2;
                            }
                        }
                        if (inputStream2 != null) {
                            throw th2;
                        }
                        inputStream2.close();
                        throw th2;
                    }
                }
                return hVar;
            }
            hVar.f2048a = 0;
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                hVar.b = jSONObject;
                cn.com.chinatelecom.account.api.d.f.a(gVar.d, jSONObject, null);
            }
            cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, null);
            d dVarA = cn.com.chinatelecom.account.api.d.a.a(this.f2045a, httpURLConnectionB, true);
            if (dVarA != null) {
                hVar.c = dVarA.f2044a;
                hVar.d = dVarA.e;
                cn.com.chinatelecom.account.api.d.f.a(gVar.d).f(dVarA.c).b(cn.com.chinatelecom.account.api.d.g.f(this.f2045a));
            }
            bufferedReader3 = bufferedReader;
        } else {
            if (responseCode == 302) {
                int i3 = gVar.b;
                if (i3 < 10) {
                    gVar.b = i3 + 1;
                    gVar.f = false;
                    String headerField = httpURLConnectionB.getHeaderField(HttpHeaders.LOCATION);
                    d dVarA2 = cn.com.chinatelecom.account.api.d.a.a(httpURLConnectionB);
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d).f(dVarA2.c).b(cn.com.chinatelecom.account.api.d.g.f(this.f2045a));
                    if (!TextUtils.isEmpty(dVarA2.d) && !dVarA2.d.equals("0")) {
                        i2 = 1;
                    }
                    CtAuth.info(b, " method : " + i2);
                    return a(headerField, null, i2, gVar, false);
                }
                JSONObject jSONObjectA = j.a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, cn.com.chinatelecom.account.api.a.d.a(j.b) + "-Redirect more than 10 times");
                hVar.b = jSONObjectA;
                cn.com.chinatelecom.account.api.d.f.a(gVar.d, jSONObjectA, "Redirect more than 10 times");
            } else {
                hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_NO_CACHE, cn.com.chinatelecom.account.api.a.d.a(j.c) + "-" + gVar.c + "-code : " + responseCode);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(" Http response code :");
                sb6.append(responseCode);
                String string2 = sb6.toString();
                cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, string2);
                CtAuth.info(b, string2);
            }
            inputStream = null;
        }
        if (bufferedReader3 != null) {
            bufferedReader3.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0284 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02f5 A[Catch: IOException -> 0x042b, TRY_ENTER, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02fa A[Catch: IOException -> 0x042b, TRY_LEAVE, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x030a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x037b A[Catch: IOException -> 0x042b, TRY_ENTER, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0380 A[Catch: IOException -> 0x042b, TRY_LEAVE, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0410 A[Catch: all -> 0x043a, TryCatch #13 {all -> 0x043a, blocks: (B:163:0x0391, B:166:0x0397, B:167:0x0399, B:168:0x0404, B:170:0x0410, B:172:0x0415, B:171:0x0413), top: B:215:0x0391 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0413 A[Catch: all -> 0x043a, TryCatch #13 {all -> 0x043a, blocks: (B:163:0x0391, B:166:0x0397, B:167:0x0399, B:168:0x0404, B:170:0x0410, B:172:0x0415, B:171:0x0413), top: B:215:0x0391 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0422 A[Catch: all -> 0x041e, TRY_LEAVE, TryCatch #30 {all -> 0x041e, blocks: (B:174:0x041a, B:177:0x0422), top: B:223:0x041a }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0427 A[Catch: IOException -> 0x042b, TRY_ENTER, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0430 A[Catch: IOException -> 0x042b, TRY_LEAVE, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x044d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04c0 A[Catch: IOException -> 0x042b, TRY_ENTER, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04c5 A[Catch: IOException -> 0x042b, TRY_LEAVE, TryCatch #6 {IOException -> 0x042b, blocks: (B:179:0x0427, B:183:0x0430, B:109:0x0247, B:111:0x024c, B:142:0x02f5, B:144:0x02fa, B:155:0x037b, B:157:0x0380, B:197:0x04c0, B:199:0x04c5), top: B:212:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0391 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x041a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h b(String str, String str2, int i, g gVar, boolean z) throws Throwable {
        Throwable th;
        Throwable th2;
        InputStream inputStream;
        boolean z2;
        IOException iOException;
        boolean z3;
        UnknownHostException unknownHostException;
        String str3;
        BufferedReader bufferedReader;
        boolean z4;
        SocketTimeoutException socketTimeoutException;
        boolean z5;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        InputStream inputStream2;
        BufferedReader bufferedReader4;
        boolean zA;
        String str4;
        String strReplace;
        HttpsURLConnection httpsURLConnectionC;
        int responseCode;
        BufferedReader bufferedReader5;
        StringBuilder sb;
        Context context;
        long jCurrentTimeMillis;
        h hVar = new h();
        boolean z6 = false;
        try {
            try {
                try {
                    boolean zC = cn.com.chinatelecom.account.api.d.g.c(this.f2045a);
                    zA = a(gVar.f, gVar.g);
                    if (zA) {
                        try {
                            try {
                                str4 = str;
                            } catch (UnknownHostException e) {
                                e = e;
                                str4 = str;
                            }
                            try {
                                strReplace = str4.replace(gVar.h, gVar.g);
                            } catch (UnknownHostException e2) {
                                e = e2;
                                unknownHostException = e;
                                str3 = str4;
                                bufferedReader = null;
                                inputStream2 = null;
                                z4 = zA;
                                z6 = false;
                                if (!z) {
                                }
                                if (str3.contains(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.g))) {
                                }
                                hVar.d = true;
                                if (bufferedReader != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                return hVar;
                            }
                        } catch (SocketTimeoutException e3) {
                            socketTimeoutException = e3;
                            inputStream = null;
                            bufferedReader4 = null;
                            z5 = zA;
                            z6 = false;
                            if (!gVar.e) {
                                hVar.d = z6;
                            }
                            hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR, cn.com.chinatelecom.account.api.a.d.a(j.f) + "-" + gVar.c + "-" + socketTimeoutException.getMessage());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SocketTimeoutException : ");
                            sb2.append(socketTimeoutException.getMessage());
                            cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb2.toString());
                            CtAuth.warn(b, "STE_" + gVar.c + "_" + socketTimeoutException.getMessage(), socketTimeoutException);
                            if (bufferedReader4 != null) {
                            }
                            if (inputStream != null) {
                            }
                            return hVar;
                        } catch (IOException e4) {
                            iOException = e4;
                            inputStream = null;
                            bufferedReader3 = null;
                            z3 = zA;
                            z6 = false;
                            if (!gVar.e && z3) {
                                hVar.d = z6;
                            }
                            hVar.b = j.a(80007, cn.com.chinatelecom.account.api.a.d.a(j.h) + "-" + gVar.c + "-" + iOException.getMessage());
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("IOException : ");
                            sb3.append(iOException.getMessage());
                            cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb3.toString());
                            CtAuth.warn(b, "IOException-" + gVar.c + "-" + iOException.getMessage(), iOException);
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return hVar;
                        } catch (Throwable th3) {
                            th2 = th3;
                            inputStream = null;
                            bufferedReader2 = null;
                            z2 = zA;
                            z6 = false;
                            if (!gVar.e && z2) {
                                hVar.d = z6;
                            }
                            hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, cn.com.chinatelecom.account.api.a.d.a(j.b) + "-" + gVar.c + "-" + th2.getMessage());
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Throwable : ");
                            sb4.append(th2.getMessage());
                            cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb4.toString());
                            CtAuth.warn(b, "Throwable-" + gVar.c + "-" + th2.getMessage(), th2);
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return hVar;
                        }
                    } else {
                        strReplace = str;
                    }
                    try {
                        if (gVar.b > 0 && !zC) {
                            try {
                                if (!a()) {
                                    f.a(this.f2045a, strReplace);
                                }
                            } catch (UnknownHostException e5) {
                                unknownHostException = e5;
                                str3 = strReplace;
                                bufferedReader = null;
                                inputStream2 = null;
                                z4 = zA;
                                z6 = false;
                                if (!z) {
                                    try {
                                        if (!gVar.e && z4) {
                                            hVar.d = z6;
                                        }
                                        hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_CONTEXT, cn.com.chinatelecom.account.api.a.d.a(j.g) + "-" + gVar.c + "-" + unknownHostException.getMessage());
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("UnknownHostException : ");
                                        sb5.append(unknownHostException.getMessage());
                                        cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb5.toString());
                                        CtAuth.warn(b, "UnknownHostException-" + gVar.c + "-" + unknownHostException.getMessage(), unknownHostException);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        InputStream inputStream3 = inputStream2;
                                        BufferedReader bufferedReader6 = bufferedReader;
                                        if (bufferedReader6 != null) {
                                            try {
                                                bufferedReader6.close();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (inputStream3 == null) {
                                            throw th;
                                        }
                                        inputStream3.close();
                                        throw th;
                                    }
                                }
                                if (str3.contains(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.g))) {
                                    hVar.e = "2";
                                } else {
                                    hVar.e = "1";
                                }
                                hVar.d = true;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable unused) {
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStream2 != null) {
                                        }
                                        return hVar;
                                    }
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                return hVar;
                            }
                        }
                        httpsURLConnectionC = c(strReplace, str2, i, gVar);
                        responseCode = httpsURLConnectionC.getResponseCode();
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        z6 = false;
                    } catch (UnknownHostException e8) {
                        e = e8;
                        str3 = strReplace;
                        z6 = false;
                    } catch (IOException e9) {
                        e = e9;
                        z6 = false;
                    } catch (Throwable th5) {
                        th = th5;
                        z6 = false;
                    }
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            } catch (SocketTimeoutException e11) {
                z6 = false;
                socketTimeoutException = e11;
                inputStream = null;
                z5 = false;
            } catch (UnknownHostException e12) {
                z6 = false;
                unknownHostException = e12;
                str3 = str;
                bufferedReader = null;
                z4 = false;
            } catch (IOException e13) {
                z6 = false;
                iOException = e13;
                inputStream = null;
                z3 = false;
            } catch (Throwable th6) {
                z6 = false;
                th2 = th6;
                inputStream = null;
                z2 = false;
            }
            if (responseCode == 200) {
                inputStream = httpsURLConnectionC.getInputStream();
                try {
                    sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } catch (SocketTimeoutException e14) {
                    socketTimeoutException = e14;
                    bufferedReader4 = null;
                } catch (UnknownHostException e15) {
                    unknownHostException = e15;
                    inputStream2 = inputStream;
                    str3 = strReplace;
                    bufferedReader = null;
                } catch (IOException e16) {
                    iOException = e16;
                    bufferedReader3 = null;
                } catch (Throwable th7) {
                    th2 = th7;
                    bufferedReader2 = null;
                }
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    } catch (SocketTimeoutException e17) {
                        socketTimeoutException = e17;
                        bufferedReader4 = bufferedReader;
                        z5 = zA;
                        z6 = false;
                        if (!gVar.e) {
                        }
                        hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR, cn.com.chinatelecom.account.api.a.d.a(j.f) + "-" + gVar.c + "-" + socketTimeoutException.getMessage());
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append("SocketTimeoutException : ");
                        sb22.append(socketTimeoutException.getMessage());
                        cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb22.toString());
                        CtAuth.warn(b, "STE_" + gVar.c + "_" + socketTimeoutException.getMessage(), socketTimeoutException);
                        if (bufferedReader4 != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (UnknownHostException e18) {
                        unknownHostException = e18;
                        inputStream2 = inputStream;
                        str3 = strReplace;
                        z4 = zA;
                        z6 = false;
                        if (!z) {
                        }
                        if (str3.contains(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.g))) {
                        }
                        hVar.d = true;
                        if (bufferedReader != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (inputStream2 != null) {
                        }
                    } catch (IOException e19) {
                        iOException = e19;
                        bufferedReader3 = bufferedReader;
                        z3 = zA;
                        z6 = false;
                        if (!gVar.e) {
                        }
                        hVar.b = j.a(80007, cn.com.chinatelecom.account.api.a.d.a(j.h) + "-" + gVar.c + "-" + iOException.getMessage());
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append("IOException : ");
                        sb32.append(iOException.getMessage());
                        cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb32.toString());
                        CtAuth.warn(b, "IOException-" + gVar.c + "-" + iOException.getMessage(), iOException);
                        if (bufferedReader3 != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (Throwable th8) {
                        th2 = th8;
                        bufferedReader2 = bufferedReader;
                        z2 = zA;
                        z6 = false;
                        if (!gVar.e) {
                        }
                        hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, cn.com.chinatelecom.account.api.a.d.a(j.b) + "-" + gVar.c + "-" + th2.getMessage());
                        StringBuilder sb42 = new StringBuilder();
                        sb42.append("Throwable : ");
                        sb42.append(th2.getMessage());
                        cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb42.toString());
                        CtAuth.warn(b, "Throwable-" + gVar.c + "-" + th2.getMessage(), th2);
                        if (bufferedReader2 != null) {
                        }
                        if (inputStream != null) {
                        }
                    }
                    return hVar;
                }
                hVar.f2048a = 0;
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    hVar.b = jSONObject;
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, jSONObject, null);
                }
                d dVarA = cn.com.chinatelecom.account.api.d.a.a(this.f2045a, httpsURLConnectionC, true);
                if (dVarA != null) {
                    hVar.c = dVarA.f2044a;
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d).f(dVarA.c);
                }
                if (dVarA.e && z) {
                    if (strReplace.contains(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.g))) {
                        hVar.e = "1";
                    } else {
                        hVar.e = "2";
                    }
                    hVar.d = true;
                }
                if (!z) {
                    if (strReplace.contains(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.f))) {
                        context = this.f2045a;
                        jCurrentTimeMillis = 0;
                    } else {
                        cn.com.chinatelecom.account.api.d.g.a(this.f2045a, "2");
                        context = this.f2045a;
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                    cn.com.chinatelecom.account.api.d.g.a(context, jCurrentTimeMillis);
                }
                bufferedReader5 = bufferedReader;
            } else {
                try {
                } catch (SocketTimeoutException e20) {
                    e = e20;
                    socketTimeoutException = e;
                    z5 = zA;
                    inputStream = null;
                    bufferedReader4 = null;
                    if (!gVar.e) {
                    }
                    hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR, cn.com.chinatelecom.account.api.a.d.a(j.f) + "-" + gVar.c + "-" + socketTimeoutException.getMessage());
                    StringBuilder sb222 = new StringBuilder();
                    sb222.append("SocketTimeoutException : ");
                    sb222.append(socketTimeoutException.getMessage());
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb222.toString());
                    CtAuth.warn(b, "STE_" + gVar.c + "_" + socketTimeoutException.getMessage(), socketTimeoutException);
                    if (bufferedReader4 != null) {
                    }
                    if (inputStream != null) {
                    }
                } catch (UnknownHostException e21) {
                    e = e21;
                    unknownHostException = e;
                    z4 = zA;
                    bufferedReader = null;
                    inputStream2 = null;
                    if (!z) {
                    }
                    if (str3.contains(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.g))) {
                    }
                    hVar.d = true;
                    if (bufferedReader != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStream2 != null) {
                    }
                } catch (IOException e22) {
                    e = e22;
                    iOException = e;
                    z3 = zA;
                    inputStream = null;
                    bufferedReader3 = null;
                    if (!gVar.e) {
                        hVar.d = z6;
                    }
                    hVar.b = j.a(80007, cn.com.chinatelecom.account.api.a.d.a(j.h) + "-" + gVar.c + "-" + iOException.getMessage());
                    StringBuilder sb322 = new StringBuilder();
                    sb322.append("IOException : ");
                    sb322.append(iOException.getMessage());
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb322.toString());
                    CtAuth.warn(b, "IOException-" + gVar.c + "-" + iOException.getMessage(), iOException);
                    if (bufferedReader3 != null) {
                    }
                    if (inputStream != null) {
                    }
                } catch (Throwable th9) {
                    th = th9;
                    th2 = th;
                    z2 = zA;
                    inputStream = null;
                    bufferedReader2 = null;
                    if (!gVar.e) {
                        hVar.d = z6;
                    }
                    hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, cn.com.chinatelecom.account.api.a.d.a(j.b) + "-" + gVar.c + "-" + th2.getMessage());
                    StringBuilder sb422 = new StringBuilder();
                    sb422.append("Throwable : ");
                    sb422.append(th2.getMessage());
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb422.toString());
                    CtAuth.warn(b, "Throwable-" + gVar.c + "-" + th2.getMessage(), th2);
                    if (bufferedReader2 != null) {
                    }
                    if (inputStream != null) {
                    }
                }
                if (responseCode == 302) {
                    int i2 = gVar.b;
                    if (i2 < 10) {
                        gVar.b = i2 + 1;
                        gVar.f = false;
                        String headerField = httpsURLConnectionC.getHeaderField(HttpHeaders.LOCATION);
                        d dVarA2 = cn.com.chinatelecom.account.api.d.a.a(httpsURLConnectionC);
                        cn.com.chinatelecom.account.api.d.f.a(gVar.d).f(dVarA2.c).b(cn.com.chinatelecom.account.api.d.g.f(this.f2045a));
                        int i3 = (TextUtils.isEmpty(dVarA2.d) || dVarA2.d.equals("0")) ? 0 : 1;
                        CtAuth.info(b, "method : " + i3);
                        return a(headerField, null, i3, gVar, false);
                    }
                    JSONObject jSONObjectA = j.a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, cn.com.chinatelecom.account.api.a.d.a(j.b) + "-Redirect more than 10 times");
                    hVar.b = jSONObjectA;
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, jSONObjectA, "Redirect more than 10 times");
                    socketTimeoutException = e;
                    z5 = zA;
                    inputStream = null;
                    bufferedReader4 = null;
                    if (!gVar.e && z5) {
                        hVar.d = z6;
                    }
                    hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR, cn.com.chinatelecom.account.api.a.d.a(j.f) + "-" + gVar.c + "-" + socketTimeoutException.getMessage());
                    StringBuilder sb2222 = new StringBuilder();
                    sb2222.append("SocketTimeoutException : ");
                    sb2222.append(socketTimeoutException.getMessage());
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, sb2222.toString());
                    CtAuth.warn(b, "STE_" + gVar.c + "_" + socketTimeoutException.getMessage(), socketTimeoutException);
                    if (bufferedReader4 != null) {
                        bufferedReader4.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return hVar;
                }
                String str5 = strReplace;
                if (!z) {
                    cn.com.chinatelecom.account.api.d.g.a(this.f2045a, 0L);
                    hVar.b = j.a(MediationConstant.ErrorCode.ADN_AD_NO_CACHE, cn.com.chinatelecom.account.api.a.d.a(j.c) + "-" + gVar.c + "-code : " + responseCode);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("response code ：");
                    sb6.append(responseCode);
                    String string2 = sb6.toString();
                    cn.com.chinatelecom.account.api.d.f.a(gVar.d, hVar.b, string2);
                    CtAuth.info(b, string2);
                    return hVar;
                }
                if (str5.contains(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.g))) {
                    hVar.e = "1";
                } else {
                    hVar.e = "2";
                }
                hVar.d = true;
                inputStream = null;
                bufferedReader5 = null;
            }
            if (bufferedReader5 != null) {
                bufferedReader5.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return hVar;
        } catch (Throwable th10) {
            th = th10;
        }
    }

    @Override // cn.com.chinatelecom.account.api.c.e
    public h a(String str, String str2, int i, g gVar, boolean z) {
        return a(str) ? b(str, str2, i, gVar, z) : a(str, str2, i, gVar);
    }
}
