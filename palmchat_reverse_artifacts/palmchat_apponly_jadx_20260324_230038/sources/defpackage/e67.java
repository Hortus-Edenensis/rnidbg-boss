package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cdadata.cdazmj.cdazmb;
import com.cdadata.sdk.api.IAppParams;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass;
import com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kuaishou.weapon.p0.g;
import com.lantern.auth.server.WkParams;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import com.zm.fda.Z2500.ZZ00Z;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class e67 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17225a;
    public static String b;
    public static String c;
    public static j67 d;
    public static o67 e;

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode + "";
        } catch (Exception e2) {
            g57.a(e2);
        }
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        if (r1 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(File file) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
            try {
                bArr = new byte[1024];
            } catch (FileNotFoundException e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
            } catch (IOException e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                try {
                    break;
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            fileInputStream.close();
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static String c(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader;
        Exception e2;
        StringBuilder sb;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                try {
                    sb = new StringBuilder();
                } catch (Exception e3) {
                    e2 = e3;
                    g57.a(e2);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            g57.a(e4);
                        }
                    }
                    if (inputStream == null) {
                        return "";
                    }
                    try {
                        inputStream.close();
                        return "";
                    } catch (IOException e5) {
                        g57.a(e5);
                        return "";
                    }
                }
            } catch (Throwable th) {
                BufferedReader bufferedReader3 = bufferedReader;
                th = th;
                bufferedReader2 = bufferedReader3;
            }
        } catch (Exception e6) {
            bufferedReader = null;
            e2 = e6;
        } catch (Throwable th2) {
            th = th2;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append("\n");
            BufferedReader bufferedReader32 = bufferedReader;
            th = th;
            bufferedReader2 = bufferedReader32;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e7) {
                    g57.a(e7);
                }
            }
            if (inputStream == null) {
                throw th;
            }
            try {
                inputStream.close();
                throw th;
            } catch (IOException e8) {
                g57.a(e8);
                throw th;
            }
        }
        inputStream.close();
        String string = sb.toString();
        try {
            bufferedReader.close();
        } catch (IOException e9) {
            g57.a(e9);
        }
        try {
            inputStream.close();
        } catch (IOException e10) {
            g57.a(e10);
        }
        return string;
    }

    public static String d(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return new String(i57.c(messageDigest.digest(), 11)).replace("-", "").replace("_", "").toLowerCase();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:207:0x03a9 A[Catch: Exception -> 0x03d3, TryCatch #21 {Exception -> 0x03d3, blocks: (B:205:0x03a3, B:207:0x03a9, B:208:0x03b2, B:210:0x03bc, B:211:0x03c3, B:213:0x03c7), top: B:405:0x03a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03b2 A[Catch: Exception -> 0x03d3, TryCatch #21 {Exception -> 0x03d3, blocks: (B:205:0x03a3, B:207:0x03a9, B:208:0x03b2, B:210:0x03bc, B:211:0x03c3, B:213:0x03c7), top: B:405:0x03a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03e7 A[Catch: Exception -> 0x0411, TryCatch #23 {Exception -> 0x0411, blocks: (B:221:0x03e1, B:223:0x03e7, B:224:0x03f0, B:226:0x03fa, B:227:0x0401, B:229:0x0405), top: B:408:0x03e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03f0 A[Catch: Exception -> 0x0411, TryCatch #23 {Exception -> 0x0411, blocks: (B:221:0x03e1, B:223:0x03e7, B:224:0x03f0, B:226:0x03fa, B:227:0x0401, B:229:0x0405), top: B:408:0x03e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0425 A[Catch: Exception -> 0x0446, TryCatch #36 {Exception -> 0x0446, blocks: (B:237:0x041f, B:239:0x0425, B:240:0x042e), top: B:427:0x041f }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x042e A[Catch: Exception -> 0x0446, TRY_LEAVE, TryCatch #36 {Exception -> 0x0446, blocks: (B:237:0x041f, B:239:0x0425, B:240:0x042e), top: B:427:0x041f }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0459 A[Catch: Exception -> 0x04b2, TryCatch #13 {Exception -> 0x04b2, blocks: (B:245:0x0453, B:247:0x0459, B:248:0x0462, B:250:0x046c, B:256:0x049c, B:257:0x04a0, B:259:0x04a4, B:251:0x046e, B:253:0x0492), top: B:393:0x0453, inners: #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0462 A[Catch: Exception -> 0x04b2, TryCatch #13 {Exception -> 0x04b2, blocks: (B:245:0x0453, B:247:0x0459, B:248:0x0462, B:250:0x046c, B:256:0x049c, B:257:0x04a0, B:259:0x04a4, B:251:0x046e, B:253:0x0492), top: B:393:0x0453, inners: #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04c6 A[Catch: Exception -> 0x04fd, TryCatch #29 {Exception -> 0x04fd, blocks: (B:268:0x04c0, B:270:0x04c6, B:271:0x04cf, B:273:0x04d9, B:274:0x04ed, B:276:0x04f1), top: B:417:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04cf A[Catch: Exception -> 0x04fd, TryCatch #29 {Exception -> 0x04fd, blocks: (B:268:0x04c0, B:270:0x04c6, B:271:0x04cf, B:273:0x04d9, B:274:0x04ed, B:276:0x04f1), top: B:417:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0511 A[Catch: Exception -> 0x0539, TryCatch #34 {Exception -> 0x0539, blocks: (B:284:0x050b, B:286:0x0511, B:287:0x051a, B:289:0x0524, B:290:0x0529, B:292:0x052d), top: B:424:0x050b }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x051a A[Catch: Exception -> 0x0539, TryCatch #34 {Exception -> 0x0539, blocks: (B:284:0x050b, B:286:0x0511, B:287:0x051a, B:289:0x0524, B:290:0x0529, B:292:0x052d), top: B:424:0x050b }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x054d A[Catch: Exception -> 0x0584, TryCatch #39 {Exception -> 0x0584, blocks: (B:300:0x0547, B:302:0x054d, B:303:0x0556, B:305:0x0560, B:306:0x0574, B:308:0x0578), top: B:433:0x0547 }] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0556 A[Catch: Exception -> 0x0584, TryCatch #39 {Exception -> 0x0584, blocks: (B:300:0x0547, B:302:0x054d, B:303:0x0556, B:305:0x0560, B:306:0x0574, B:308:0x0578), top: B:433:0x0547 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0598 A[Catch: Exception -> 0x05c2, TryCatch #45 {Exception -> 0x05c2, blocks: (B:316:0x0592, B:318:0x0598, B:319:0x05a1, B:321:0x05ab, B:322:0x05b2, B:324:0x05b6), top: B:443:0x0592 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05a1 A[Catch: Exception -> 0x05c2, TryCatch #45 {Exception -> 0x05c2, blocks: (B:316:0x0592, B:318:0x0598, B:319:0x05a1, B:321:0x05ab, B:322:0x05b2, B:324:0x05b6), top: B:443:0x0592 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x05d7 A[Catch: Exception -> 0x0609, TryCatch #17 {Exception -> 0x0609, blocks: (B:332:0x05ce, B:334:0x05d7, B:335:0x05e3, B:337:0x05ed, B:338:0x05f6, B:340:0x05fa), top: B:399:0x05ce }] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x05e3 A[Catch: Exception -> 0x0609, TryCatch #17 {Exception -> 0x0609, blocks: (B:332:0x05ce, B:334:0x05d7, B:335:0x05e3, B:337:0x05ed, B:338:0x05f6, B:340:0x05fa), top: B:399:0x05ce }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(Context context, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String resolution;
        String str14;
        y47 y47VarK;
        String fingerPrint;
        String str15;
        y47 y47VarK2;
        String hardware;
        String str16;
        y47 y47VarK3;
        String str17;
        y47 y47VarK4;
        String str18;
        String timeZone;
        y47 y47VarK5;
        String cpuCore;
        String str19;
        y47 y47VarK6;
        String str20;
        String memorySize;
        y47 y47VarK7;
        String maxCpuHZ;
        String str21;
        y47 y47VarK8;
        String incremental;
        String str22;
        y47 y47VarK9;
        String radio;
        String str23;
        String str24;
        String user;
        String type;
        String tags;
        String id;
        String host;
        String display;
        String device;
        String cpuAbi;
        String board;
        String manufacturer;
        String product;
        String model;
        String str25 = "device";
        y47 y47VarK10 = y47.k();
        y47VarK10.getClass();
        try {
            if (y47VarK10.c(WkParams.MODEL)) {
                str2 = y47VarK10.f22121a.get(WkParams.MODEL);
                str = "";
            } else {
                str = "";
                try {
                    if (ZMDataSDKManager.getInstance().zmConfigOptions.isModelEnable) {
                        model = Build.MODEL.toLowerCase();
                    } else {
                        IAppParams iAppParams = y47VarK10.d;
                        model = iAppParams != null ? iAppParams.getModel() : str;
                    }
                    try {
                        y47VarK10.f22121a.put(WkParams.MODEL, model);
                    } catch (Exception unused) {
                    }
                    str2 = model;
                } catch (Exception unused2) {
                    str2 = str;
                }
            }
        } catch (Exception unused3) {
            str = "";
        }
        g(jSONObject, WkParams.MODEL, str2);
        y47 y47VarK11 = y47.k();
        y47VarK11.getClass();
        try {
            if (y47VarK11.c("product")) {
                str3 = y47VarK11.f22121a.get("product");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isProductEnable) {
                    product = Build.PRODUCT.toLowerCase();
                } else {
                    IAppParams iAppParams2 = y47VarK11.d;
                    product = iAppParams2 != null ? iAppParams2.getProduct() : str;
                }
                try {
                    y47VarK11.f22121a.put("product", product);
                } catch (Exception unused4) {
                }
                str3 = product;
            }
        } catch (Exception unused5) {
            str3 = str;
        }
        g(jSONObject, "product", str3);
        y47 y47VarK12 = y47.k();
        y47VarK12.getClass();
        try {
            if (y47VarK12.c("manufacturer")) {
                str4 = y47VarK12.f22121a.get("manufacturer");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isManufacturerEnable) {
                    manufacturer = Build.MANUFACTURER.toLowerCase();
                } else {
                    IAppParams iAppParams3 = y47VarK12.d;
                    manufacturer = iAppParams3 != null ? iAppParams3.getManufacturer() : str;
                }
                try {
                    y47VarK12.f22121a.put("manufacturer", manufacturer);
                } catch (Exception unused6) {
                }
                str4 = manufacturer;
            }
        } catch (Exception unused7) {
            str4 = str;
        }
        g(jSONObject, "manufacturer", str4);
        y47 y47VarK13 = y47.k();
        y47VarK13.getClass();
        try {
            if (y47VarK13.c("board")) {
                str5 = y47VarK13.f22121a.get("board");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isBoardEnable) {
                    board = Build.BOARD.toLowerCase();
                } else {
                    IAppParams iAppParams4 = y47VarK13.d;
                    board = iAppParams4 != null ? iAppParams4.getBoard() : str;
                }
                try {
                    y47VarK13.f22121a.put("board", board);
                } catch (Exception unused8) {
                }
                str5 = board;
            }
        } catch (Exception unused9) {
            str5 = str;
        }
        g(jSONObject, "board", str5);
        y47 y47VarK14 = y47.k();
        y47VarK14.getClass();
        try {
            if (y47VarK14.c("cpuAbi")) {
                str6 = y47VarK14.f22121a.get("cpuAbi");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isCpuAbiEnable) {
                    cpuAbi = cdazmb.b();
                } else {
                    IAppParams iAppParams5 = y47VarK14.d;
                    cpuAbi = iAppParams5 != null ? iAppParams5.getCpuAbi() : str;
                }
                try {
                    y47VarK14.f22121a.put("cpuAbi", cpuAbi);
                } catch (Exception unused10) {
                }
                str6 = cpuAbi;
            }
        } catch (Exception unused11) {
            str6 = str;
        }
        g(jSONObject, "cpuAbi", str6);
        y47 y47VarK15 = y47.k();
        y47VarK15.getClass();
        try {
            if (y47VarK15.c("device")) {
                str7 = y47VarK15.f22121a.get("device");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isDeviceEnable) {
                    device = Build.DEVICE.toLowerCase();
                } else {
                    IAppParams iAppParams6 = y47VarK15.d;
                    device = iAppParams6 != null ? iAppParams6.getDevice() : str;
                }
                try {
                    y47VarK15.f22121a.put("device", device);
                } catch (Exception unused12) {
                }
                str7 = device;
            }
        } catch (Exception unused13) {
            str7 = str;
        }
        g(jSONObject, "device", str7);
        y47 y47VarK16 = y47.k();
        y47VarK16.getClass();
        try {
            if (y47VarK16.c("display")) {
                str8 = y47VarK16.f22121a.get("display");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isDisplayEnable) {
                    display = Build.DISPLAY.toLowerCase();
                } else {
                    IAppParams iAppParams7 = y47VarK16.d;
                    display = iAppParams7 != null ? iAppParams7.getDisplay() : str;
                }
                try {
                    y47VarK16.f22121a.put("display", display);
                } catch (Exception unused14) {
                }
                str8 = display;
            }
        } catch (Exception unused15) {
            str8 = str;
        }
        g(jSONObject, "display", str8);
        y47 y47VarK17 = y47.k();
        y47VarK17.getClass();
        try {
            if (y47VarK17.c("host")) {
                str9 = y47VarK17.f22121a.get("host");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isHostEnable) {
                    host = Build.HOST.toLowerCase();
                } else {
                    IAppParams iAppParams8 = y47VarK17.d;
                    host = iAppParams8 != null ? iAppParams8.getHost() : str;
                }
                try {
                    y47VarK17.f22121a.put("host", host);
                } catch (Exception unused16) {
                }
                str9 = host;
            }
        } catch (Exception unused17) {
            str9 = str;
        }
        g(jSONObject, "host", str9);
        y47 y47VarK18 = y47.k();
        y47VarK18.getClass();
        try {
            if (y47VarK18.c("id")) {
                str10 = y47VarK18.f22121a.get("id");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isIdEnable) {
                    id = Build.ID.toLowerCase();
                } else {
                    IAppParams iAppParams9 = y47VarK18.d;
                    id = iAppParams9 != null ? iAppParams9.getId() : str;
                }
                try {
                    y47VarK18.f22121a.put("id", id);
                } catch (Exception unused18) {
                }
                str10 = id;
            }
        } catch (Exception unused19) {
            str10 = str;
        }
        g(jSONObject, "id", str10);
        y47 y47VarK19 = y47.k();
        y47VarK19.getClass();
        try {
            if (y47VarK19.c("tags")) {
                str11 = y47VarK19.f22121a.get("tags");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isTagsEnable) {
                    tags = Build.TAGS.toLowerCase();
                } else {
                    IAppParams iAppParams10 = y47VarK19.d;
                    tags = iAppParams10 != null ? iAppParams10.getTags() : str;
                }
                try {
                    y47VarK19.f22121a.put("tags", tags);
                } catch (Exception unused20) {
                }
                str11 = tags;
            }
        } catch (Exception unused21) {
            str11 = str;
        }
        g(jSONObject, "tags", str11);
        y47 y47VarK20 = y47.k();
        y47VarK20.getClass();
        try {
            if (y47VarK20.c("type")) {
                str12 = y47VarK20.f22121a.get("type");
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isTypeEnable) {
                    type = Build.TYPE.toLowerCase();
                } else {
                    IAppParams iAppParams11 = y47VarK20.d;
                    type = iAppParams11 != null ? iAppParams11.getType() : str;
                }
                try {
                    y47VarK20.f22121a.put("type", type);
                } catch (Exception unused22) {
                }
                str12 = type;
            }
        } catch (Exception unused23) {
            str12 = str;
        }
        g(jSONObject, "type", str12);
        y47 y47VarK21 = y47.k();
        y47VarK21.getClass();
        try {
            if (y47VarK21.c(bd.m)) {
                str13 = y47VarK21.f22121a.get(bd.m);
            } else {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isUserEnable) {
                    user = Build.USER.toLowerCase();
                } else {
                    IAppParams iAppParams12 = y47VarK21.d;
                    user = iAppParams12 != null ? iAppParams12.getUser() : str;
                }
                try {
                    y47VarK21.f22121a.put(bd.m, user);
                } catch (Exception unused24) {
                }
                str13 = user;
            }
        } catch (Exception unused25) {
            str13 = str;
        }
        g(jSONObject, bd.m, str13);
        y47 y47VarK22 = y47.k();
        y47VarK22.getClass();
        try {
        } catch (Exception unused26) {
            str25 = str;
        }
        if (y47VarK22.c("resolution")) {
            str14 = y47VarK22.f22121a.get("resolution");
            str25 = str;
            g(jSONObject, "resolution", str14);
            y47VarK = y47.k();
            y47VarK.getClass();
            try {
            } catch (Exception unused27) {
                fingerPrint = str25;
            }
            if (y47VarK.c(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT)) {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isFingerPrintEnable) {
                    fingerPrint = Build.FINGERPRINT.toLowerCase();
                } else {
                    IAppParams iAppParams13 = y47VarK.d;
                    fingerPrint = iAppParams13 != null ? iAppParams13.getFingerPrint() : str25;
                }
                try {
                    y47VarK.f22121a.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, fingerPrint);
                } catch (Exception unused28) {
                }
                str15 = fingerPrint;
                g(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, str15);
                y47VarK2 = y47.k();
                y47VarK2.getClass();
                if (y47VarK2.c("hardware")) {
                }
            } else {
                str15 = y47VarK.f22121a.get(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT);
                g(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, str15);
                y47VarK2 = y47.k();
                y47VarK2.getClass();
                try {
                } catch (Exception unused29) {
                    hardware = str25;
                }
                if (y47VarK2.c("hardware")) {
                    if (ZMDataSDKManager.getInstance().zmConfigOptions.isHardwareEnable) {
                        hardware = Build.HARDWARE.toLowerCase();
                    } else {
                        IAppParams iAppParams14 = y47VarK2.d;
                        hardware = iAppParams14 != null ? iAppParams14.getHardware() : str25;
                    }
                    try {
                        y47VarK2.f22121a.put("hardware", hardware);
                    } catch (Exception unused30) {
                    }
                    str16 = hardware;
                    g(jSONObject, "hardware", str16);
                    y47VarK3 = y47.k();
                    y47VarK3.getClass();
                    if (y47VarK3.c("sdkInt")) {
                    }
                    g(jSONObject, "sdkInt", str17);
                    y47VarK4 = y47.k();
                    y47VarK4.getClass();
                    if (!y47VarK4.c("timeZone")) {
                    }
                    g(jSONObject, "timeZone", timeZone);
                    y47VarK5 = y47.k();
                    y47VarK5.getClass();
                    if (y47VarK5.c("cpuCore")) {
                    }
                } else {
                    str16 = y47VarK2.f22121a.get("hardware");
                    g(jSONObject, "hardware", str16);
                    y47VarK3 = y47.k();
                    y47VarK3.getClass();
                    try {
                        if (y47VarK3.c("sdkInt")) {
                            String str26 = Build.VERSION.SDK_INT + str25;
                            try {
                                y47VarK3.f22121a.put("sdkInt", str26);
                            } catch (Exception unused31) {
                            }
                            str17 = str26;
                        } else {
                            str17 = y47VarK3.f22121a.get("sdkInt");
                        }
                    } catch (Exception unused32) {
                        str17 = str25;
                    }
                    g(jSONObject, "sdkInt", str17);
                    y47VarK4 = y47.k();
                    y47VarK4.getClass();
                    try {
                        if (!y47VarK4.c("timeZone")) {
                            timeZone = y47VarK4.f22121a.get("timeZone");
                        } else if (ZMDataSDKManager.getInstance().zmConfigOptions.isTimeZoneEnable) {
                            String str27 = cdazmb.f1964a;
                            try {
                                TimeZone timeZone2 = TimeZone.getDefault();
                                str24 = timeZone2.getDisplayName(false, 0) + " " + timeZone2.getID();
                            } catch (Exception e2) {
                                g57.a(e2);
                            }
                            timeZone = str24 != null ? str24.trim().toLowerCase() : str25;
                            try {
                                y47VarK4.f22121a.put("timeZone", timeZone);
                            } catch (Exception unused33) {
                                str18 = timeZone;
                                timeZone = str18;
                            }
                        } else {
                            IAppParams iAppParams15 = y47VarK4.d;
                            if (iAppParams15 != null) {
                                timeZone = iAppParams15.getTimeZone();
                            }
                            y47VarK4.f22121a.put("timeZone", timeZone);
                        }
                    } catch (Exception unused34) {
                        str18 = str25;
                    }
                    g(jSONObject, "timeZone", timeZone);
                    y47VarK5 = y47.k();
                    y47VarK5.getClass();
                    try {
                    } catch (Exception unused35) {
                        cpuCore = str25;
                    }
                    if (y47VarK5.c("cpuCore")) {
                        if (ZMDataSDKManager.getInstance().zmConfigOptions.isCpuCoreEnable) {
                            cpuCore = cdazmb.p() + str25;
                        } else {
                            IAppParams iAppParams16 = y47VarK5.d;
                            cpuCore = iAppParams16 != null ? iAppParams16.getCpuCore() : str25;
                        }
                        try {
                            y47VarK5.f22121a.put("cpuCore", cpuCore);
                        } catch (Exception unused36) {
                        }
                        str19 = cpuCore;
                        g(jSONObject, "cpuCore", str19);
                        y47VarK6 = y47.k();
                        y47VarK6.getClass();
                        if (y47VarK6.c("memSize")) {
                        }
                    } else {
                        str19 = y47VarK5.f22121a.get("cpuCore");
                        g(jSONObject, "cpuCore", str19);
                        y47VarK6 = y47.k();
                        y47VarK6.getClass();
                        try {
                        } catch (Exception unused37) {
                            str20 = str25;
                        }
                        if (y47VarK6.c("memSize")) {
                            if (ZMDataSDKManager.getInstance().zmConfigOptions.isMemorySizeEnable) {
                                memorySize = cdazmb.s(context);
                            } else {
                                IAppParams iAppParams17 = y47VarK6.d;
                                memorySize = iAppParams17 != null ? iAppParams17.getMemorySize() : str25;
                            }
                            try {
                                y47VarK6.f22121a.put("memSize", memorySize);
                            } catch (Exception unused38) {
                            }
                            g(jSONObject, "memSize", memorySize);
                            y47VarK7 = y47.k();
                            y47VarK7.getClass();
                            if (y47VarK7.c("cpuHz")) {
                            }
                        } else {
                            str20 = y47VarK6.f22121a.get("memSize");
                            memorySize = str20;
                            g(jSONObject, "memSize", memorySize);
                            y47VarK7 = y47.k();
                            y47VarK7.getClass();
                            try {
                            } catch (Exception unused39) {
                                maxCpuHZ = str25;
                            }
                            if (y47VarK7.c("cpuHz")) {
                                if (ZMDataSDKManager.getInstance().zmConfigOptions.isMaxCpuHZEnable) {
                                    maxCpuHZ = cdazmb.r() + str25;
                                } else {
                                    IAppParams iAppParams18 = y47VarK7.d;
                                    maxCpuHZ = iAppParams18 != null ? iAppParams18.getMaxCpuHZ() : str25;
                                }
                                try {
                                    y47VarK7.f22121a.put("cpuHz", maxCpuHZ);
                                } catch (Exception unused40) {
                                }
                                str21 = maxCpuHZ;
                                g(jSONObject, "cpuHz", str21);
                                y47VarK8 = y47.k();
                                y47VarK8.getClass();
                                if (!y47VarK8.c("incremental")) {
                                }
                            } else {
                                str21 = y47VarK7.f22121a.get("cpuHz");
                                g(jSONObject, "cpuHz", str21);
                                y47VarK8 = y47.k();
                                y47VarK8.getClass();
                                try {
                                } catch (Exception unused41) {
                                    incremental = str25;
                                }
                                if (!y47VarK8.c("incremental")) {
                                    str22 = y47VarK8.f22121a.get("incremental");
                                    g(jSONObject, "incremental", str22);
                                    y47VarK9 = y47.k();
                                    y47VarK9.getClass();
                                    try {
                                    } catch (Exception unused42) {
                                        radio = str25;
                                    }
                                    if (!y47VarK9.c("radio")) {
                                        str23 = y47VarK9.f22121a.get("radio");
                                        g(jSONObject, "radio", str23);
                                        return;
                                    }
                                    if (ZMDataSDKManager.getInstance().zmConfigOptions.isRadioEnable) {
                                        radio = Build.getRadioVersion().toLowerCase();
                                    } else {
                                        IAppParams iAppParams19 = y47VarK9.d;
                                        radio = iAppParams19 != null ? iAppParams19.getRadio() : str25;
                                    }
                                    try {
                                        y47VarK9.f22121a.put("radio", radio);
                                    } catch (Exception unused43) {
                                    }
                                    str23 = radio;
                                    g(jSONObject, "radio", str23);
                                    return;
                                }
                                if (ZMDataSDKManager.getInstance().zmConfigOptions.isIncrementalEnable) {
                                    incremental = Build.VERSION.INCREMENTAL.toLowerCase();
                                } else {
                                    IAppParams iAppParams20 = y47VarK8.d;
                                    incremental = iAppParams20 != null ? iAppParams20.getIncremental() : str25;
                                }
                                try {
                                    y47VarK8.f22121a.put("incremental", incremental);
                                } catch (Exception unused44) {
                                }
                                str22 = incremental;
                                g(jSONObject, "incremental", str22);
                                y47VarK9 = y47.k();
                                y47VarK9.getClass();
                                if (!y47VarK9.c("radio")) {
                                }
                            }
                        }
                    }
                }
            }
        } else {
            try {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isResolutionEnable) {
                    StringBuilder sb = new StringBuilder();
                    str25 = str;
                    sb.append(cdazmb.a(context, "width"));
                    sb.append("*");
                    sb.append(cdazmb.a(context, "height"));
                    resolution = sb.toString();
                } else {
                    str25 = str;
                    IAppParams iAppParams21 = y47VarK22.d;
                    resolution = iAppParams21 != null ? iAppParams21.getResolution() : str25;
                }
                try {
                    y47VarK22.f22121a.put("resolution", resolution);
                } catch (Exception unused45) {
                }
            } catch (Exception unused46) {
                resolution = str25;
            }
            str14 = resolution;
            g(jSONObject, "resolution", str14);
            y47VarK = y47.k();
            y47VarK.getClass();
            if (y47VarK.c(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT)) {
            }
        }
    }

    public static void f(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                sb.append('\t');
            } catch (Exception e2) {
                g57.a(e2);
                return;
            }
        }
    }

    public static void g(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.put(next, jSONObject.get(next));
            }
        } catch (Exception e2) {
            g57.a(e2);
        }
    }

    public static boolean i(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(7) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
    }

    public static boolean j(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes());
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return true;
            } catch (FileNotFoundException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                }
                return false;
            } catch (IOException e7) {
                e = e7;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static byte[] k(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] l(String str, String str2, byte[] bArr) {
        if (bArr.length == 0) {
            return null;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] m(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (byte[] bArr2 : list) {
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static byte[] n(JSONArray jSONArray) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        JSONArray jSONArray2 = jSONArray;
        String str13 = bt.P;
        String str14 = "brand";
        String str15 = "dhid";
        String str16 = WfConstant.EVENT_KEY_APP_NAME;
        String str17 = "udid";
        String str18 = ZZ00Z.v;
        String str19 = "sdkVersion";
        String str20 = "appVersionCode";
        String str21 = "appVersion";
        String str22 = "bundleId";
        String str23 = "channelId";
        if (jSONArray.length() == 0) {
            return null;
        }
        String str24 = "cid";
        try {
            CdaEventRequestOuterClass.CdaEventRequest.Builder builderNewBuilder = CdaEventRequestOuterClass.CdaEventRequest.newBuilder();
            String str25 = "networkType";
            builderNewBuilder.setAppId(((JSONObject) jSONArray2.get(0)).optString("appId"));
            int i = 0;
            CdaEventRequestOuterClass.CdaEventRequest.Builder builder = builderNewBuilder;
            while (i < jSONArray.length()) {
                CdaEventOuterClass.CdaEvent.Builder builderNewBuilder2 = CdaEventOuterClass.CdaEvent.newBuilder();
                String str26 = str13;
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                builderNewBuilder2.setAppId(jSONObject.optString("appId"));
                builderNewBuilder2.setEventName(jSONObject.optString("eventName"));
                builderNewBuilder2.setEventType(jSONObject.optString("eventType"));
                builderNewBuilder2.setEventDate(jSONObject.optString("eventDate"));
                builderNewBuilder2.setEventTime(jSONObject.optString("eventTime"));
                builderNewBuilder2.setSequence(jSONObject.optString("sequence"));
                builderNewBuilder2.setFlushTime(jSONObject.optString("flushTime"));
                if (!TextUtils.isEmpty(jSONObject.optString("sid"))) {
                    builderNewBuilder2.putProperties("sid", jSONObject.optString("sid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("aid"))) {
                    builderNewBuilder2.putProperties("aid", jSONObject.optString("aid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("loginid"))) {
                    builderNewBuilder2.putProperties("loginid", jSONObject.optString("loginid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("thirdid"))) {
                    builderNewBuilder2.putProperties("thirdid", jSONObject.optString("thirdid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(str17))) {
                    builderNewBuilder2.putProperties(str17, jSONObject.optString(str17));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(str15))) {
                    builderNewBuilder2.putProperties(str15, jSONObject.optString(str15));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("language"))) {
                    builderNewBuilder2.putProperties("language", jSONObject.optString("language"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("os"))) {
                    builderNewBuilder2.putProperties("os", jSONObject.optString("os"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("osVersion"))) {
                    builderNewBuilder2.putProperties("osVersion", jSONObject.optString("osVersion"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("androidRelease"))) {
                    builderNewBuilder2.putProperties("androidRelease", jSONObject.optString("androidRelease"));
                }
                if (TextUtils.isEmpty(jSONObject.optString(str26))) {
                    str = str15;
                } else {
                    str = str15;
                    builderNewBuilder2.putProperties(str26, jSONObject.optString(str26));
                }
                String str27 = str25;
                if (TextUtils.isEmpty(jSONObject.optString(str27))) {
                    str2 = str26;
                } else {
                    str2 = str26;
                    builderNewBuilder2.putProperties(str27, jSONObject.optString(str27));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("appId"))) {
                    builderNewBuilder2.putProperties("appId", jSONObject.optString("appId"));
                }
                String str28 = str23;
                if (TextUtils.isEmpty(jSONObject.optString(str28))) {
                    str3 = str27;
                } else {
                    str3 = str27;
                    builderNewBuilder2.putProperties(str28, jSONObject.optString(str28));
                }
                String str29 = str22;
                if (TextUtils.isEmpty(jSONObject.optString(str29))) {
                    str4 = str28;
                } else {
                    str4 = str28;
                    builderNewBuilder2.putProperties(str29, jSONObject.optString(str29));
                }
                String str30 = str21;
                if (TextUtils.isEmpty(jSONObject.optString(str30))) {
                    str5 = str29;
                } else {
                    str5 = str29;
                    builderNewBuilder2.putProperties(str30, jSONObject.optString(str30));
                }
                String str31 = str20;
                if (TextUtils.isEmpty(jSONObject.optString(str31))) {
                    str6 = str30;
                } else {
                    str6 = str30;
                    builderNewBuilder2.putProperties(str31, jSONObject.optString(str31));
                }
                String str32 = str19;
                if (TextUtils.isEmpty(jSONObject.optString(str32))) {
                    str7 = str31;
                } else {
                    str7 = str31;
                    builderNewBuilder2.putProperties(str32, jSONObject.optString(str32));
                }
                String str33 = str18;
                if (TextUtils.isEmpty(jSONObject.optString(str33))) {
                    str8 = str32;
                } else {
                    str8 = str32;
                    builderNewBuilder2.putProperties(str33, jSONObject.optString(str33));
                }
                String str34 = str16;
                if (TextUtils.isEmpty(jSONObject.optString(str34))) {
                    str9 = str33;
                } else {
                    str9 = str33;
                    builderNewBuilder2.putProperties(str34, jSONObject.optString(str34));
                }
                String str35 = str14;
                if (TextUtils.isEmpty(jSONObject.optString(str35))) {
                    str10 = str34;
                } else {
                    str10 = str34;
                    builderNewBuilder2.putProperties(str35, jSONObject.optString(str35));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA))) {
                    builderNewBuilder2.setExtra(jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA));
                }
                if (TextUtils.isEmpty(jSONObject.optString(WkParams.CAPBSSID))) {
                    str11 = str35;
                } else {
                    str11 = str35;
                    builderNewBuilder2.putProperties(WkParams.CAPBSSID, jSONObject.optString(WkParams.CAPBSSID));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(WkParams.CAPSSID))) {
                    builderNewBuilder2.putProperties(WkParams.CAPSSID, jSONObject.optString(WkParams.CAPSSID));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(DeviceInfoUtil.UID_TAG))) {
                    builderNewBuilder2.putProperties(DeviceInfoUtil.UID_TAG, jSONObject.optString(DeviceInfoUtil.UID_TAG));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("did"))) {
                    builderNewBuilder2.putProperties("did", jSONObject.optString("did"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("esid"))) {
                    builderNewBuilder2.putProperties("esid", jSONObject.optString("esid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("epid"))) {
                    builderNewBuilder2.putProperties("epid", jSONObject.optString("epid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("mapsp"))) {
                    builderNewBuilder2.putProperties("mapsp", jSONObject.optString("mapsp"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("manufacturer"))) {
                    builderNewBuilder2.putProperties("manufacturer", jSONObject.optString("manufacturer"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(WkParams.MODEL))) {
                    builderNewBuilder2.putProperties(WkParams.MODEL, jSONObject.optString(WkParams.MODEL));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("oaid"))) {
                    builderNewBuilder2.putProperties("oaid", jSONObject.optString("oaid"));
                }
                String str36 = str24;
                if (!TextUtils.isEmpty(jSONObject.optString(str36))) {
                    builderNewBuilder2.putProperties(str36, jSONObject.optString(str36));
                }
                if (TextUtils.isEmpty(jSONObject.optString(WkParams.IMEI))) {
                    str12 = str17;
                } else {
                    str12 = str17;
                    builderNewBuilder2.putProperties(WkParams.IMEI, jSONObject.optString(WkParams.IMEI));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("mac"))) {
                    builderNewBuilder2.putProperties("mac", jSONObject.optString("mac"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("sn"))) {
                    builderNewBuilder2.putProperties("sn", jSONObject.optString("sn"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(str36))) {
                    builderNewBuilder2.putProperties(str36, jSONObject.optString(str36));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(f.C))) {
                    builderNewBuilder2.putProperties(f.C, jSONObject.optString(f.C));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("lon"))) {
                    builderNewBuilder2.putProperties("lon", jSONObject.optString("lon"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("screenName"))) {
                    builderNewBuilder2.putProperties("screenName", jSONObject.optString("screenName"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("isFirstStart"))) {
                    builderNewBuilder2.putProperties("isFirstStart", jSONObject.optString("isFirstStart"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("firstInstallTime"))) {
                    builderNewBuilder2.putProperties("firstInstallTime", jSONObject.optString("firstInstallTime"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("resumeFromBackground"))) {
                    builderNewBuilder2.putProperties("resumeFromBackground", jSONObject.optString("resumeFromBackground"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("isInitiative"))) {
                    builderNewBuilder2.putProperties("isInitiative", jSONObject.optString("isInitiative"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("lastUpdateTime"))) {
                    builderNewBuilder2.putProperties("lastUpdateTime", jSONObject.optString("lastUpdateTime"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("timeZone"))) {
                    builderNewBuilder2.putProperties("timeZone", jSONObject.optString("timeZone"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("meid"))) {
                    builderNewBuilder2.putProperties("meid", jSONObject.optString("meid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("imsi"))) {
                    builderNewBuilder2.putProperties("imsi", jSONObject.optString("imsi"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("iccid"))) {
                    builderNewBuilder2.putProperties("iccid", jSONObject.optString("iccid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("product"))) {
                    builderNewBuilder2.putProperties("product", jSONObject.optString("product"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("board"))) {
                    builderNewBuilder2.putProperties("board", jSONObject.optString("board"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("cpuAbi"))) {
                    builderNewBuilder2.putProperties("cpuAbi", jSONObject.optString("cpuAbi"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("device"))) {
                    builderNewBuilder2.putProperties("device", jSONObject.optString("device"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("display"))) {
                    builderNewBuilder2.putProperties("display", jSONObject.optString("display"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("host"))) {
                    builderNewBuilder2.putProperties("host", jSONObject.optString("host"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("id"))) {
                    builderNewBuilder2.putProperties("id", jSONObject.optString("id"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("tags"))) {
                    builderNewBuilder2.putProperties("tags", jSONObject.optString("tags"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("type"))) {
                    builderNewBuilder2.putProperties("type", jSONObject.optString("type"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(bd.m))) {
                    builderNewBuilder2.putProperties(bd.m, jSONObject.optString(bd.m));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("resolution"))) {
                    builderNewBuilder2.putProperties("resolution", jSONObject.optString("resolution"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT))) {
                    builderNewBuilder2.putProperties(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("hardware"))) {
                    builderNewBuilder2.putProperties("hardware", jSONObject.optString("hardware"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("incremental"))) {
                    builderNewBuilder2.putProperties("incremental", jSONObject.optString("incremental"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("radio"))) {
                    builderNewBuilder2.putProperties("radio", jSONObject.optString("radio"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("isRoot"))) {
                    builderNewBuilder2.putProperties("isRoot", jSONObject.optString("isRoot"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("isTablet"))) {
                    builderNewBuilder2.putProperties("isTablet", jSONObject.optString("isTablet"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("isEmulator"))) {
                    builderNewBuilder2.putProperties("isEmulator", jSONObject.optString("isEmulator"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("cpuCore"))) {
                    builderNewBuilder2.putProperties("cpuCore", jSONObject.optString("cpuCore"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("memSize"))) {
                    builderNewBuilder2.putProperties("memSize", jSONObject.optString("memSize"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("cpuHz"))) {
                    builderNewBuilder2.putProperties("cpuHz", jSONObject.optString("cpuHz"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("sdkInt"))) {
                    builderNewBuilder2.putProperties("sdkInt", jSONObject.optString("sdkInt"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("productId"))) {
                    builderNewBuilder2.putProperties("productId", jSONObject.optString("productId"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("isnet"))) {
                    builderNewBuilder2.putProperties("isnet", jSONObject.optString("isnet"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("pid"))) {
                    builderNewBuilder2.putProperties("pid", jSONObject.optString("pid"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("isFlush"))) {
                    builderNewBuilder2.putProperties("isFlush", jSONObject.optString("isFlush"));
                }
                builderNewBuilder2.putProperties("flushVersion", r(ZMDataSDKManager.getInstance().getContext()));
                builderNewBuilder2.putProperties("flushVersionCode", a(ZMDataSDKManager.getInstance().getContext()));
                builderNewBuilder2.putProperties("flushChannelId", ZMDataSDKManager.getInstance().zmConfigOptions.channelId);
                CdaEventRequestOuterClass.CdaEventRequest.Builder builder2 = builder;
                builder2.addEvents(builderNewBuilder2);
                i++;
                builder = builder2;
                str17 = str12;
                str13 = str2;
                str15 = str;
                str24 = str36;
                str25 = str3;
                jSONArray2 = jSONArray;
                str23 = str4;
                str22 = str5;
                str21 = str6;
                str20 = str7;
                str19 = str8;
                str18 = str9;
                str16 = str10;
                str14 = str11;
            }
            return builder.build().toByteArray();
        } catch (JSONException | Exception e2) {
            g57.a(e2);
            return null;
        }
    }

    public static byte[] o(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i = byteArrayInputStream.read(bArr2, 0, 1024);
            if (i == -1) {
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return byteArray;
            }
            gZIPOutputStream.write(bArr2, 0, i);
        }
    }

    public static int p(String str) {
        if ("NULL".equals(str)) {
            return 3;
        }
        if ("WIFI".equals(str)) {
            return 1;
        }
        return ("2G".equals(str) || "3G".equals(str) || "4G".equals(str) || "5G".equals(str)) ? 2 : 3;
    }

    public static String q(int i) {
        if (i < 3) {
            throw new IllegalArgumentException("字符串长度不能小于3");
        }
        char[] cArr = new char[i];
        cArr[0] = (char) (f67.a(0, 10) + 48);
        cArr[1] = (char) (f67.a(0, 26) + 65);
        cArr[2] = (char) (f67.a(0, 26) + 97);
        char[] cArr2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i2 = 3; i2 < i; i2++) {
            cArr[i2] = cArr2[f67.a(0, 62)];
        }
        for (int i3 = 0; i3 < i; i3++) {
            int iNextInt = f67.f17468a.nextInt(i - i3) + i3;
            char c2 = cArr[i3];
            cArr[i3] = cArr[iNextInt];
            cArr[iNextInt] = c2;
        }
        return new String(cArr);
    }

    public static String r(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(f17225a)) {
            return f17225a;
        }
        try {
            f17225a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            g57.a(e2);
        }
        return f17225a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(46:0|2|(1:6)|7|(1:9)|10|(2:12|(2:337|15))(4:19|363|20|(1:28)(1:24))|29|(1:31)|32|(1:34)|35|(2:37|(2:342|40))(4:44|356|45|(1:53)(1:49))|54|(2:348|55)|(30:57|85|330|86|(25:88|116|358|117|(20:119|147|341|148|(15:150|178|324|179|(10:181|209|369|210|(5:212|251|327|252|(24:254|260|(1:262)|263|353|264|(1:266)(3:267|(3:269|530|275)|279)|282|(1:284)(2:367|285)|289|(1:291)(2:354|292)|296|332|297|(1:299)(1:300)|331|303|(1:305)|306|(1:308)|309|(1:311)(1:312)|313|314)(25:255|259|260|(0)|263|353|264|(0)(0)|282|(0)(0)|289|(0)(0)|296|332|297|(0)(0)|331|303|(0)|306|(0)|309|(0)(0)|313|314))(3:213|(6:215|216|335|217|(1:219)(2:220|(1:222)(4:223|224|225|226))|334)(4:227|(1:229)|230|(2:232|(2:372|235))(4:239|325|240|(1:248)(1:244)))|249)|250|251|327|252|(0)(0))(3:182|(1:184)(4:185|(1:187)|188|(2:190|(2:322|193))(4:197|346|198|(1:206)(1:202)))|207)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:151|(1:153)(4:154|(1:156)|157|(2:159|(2:344|162))(4:166|349|167|(1:175)(1:171)))|176)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:120|(1:122)(4:123|(1:125)|126|(2:128|(2:361|131))(4:135|365|136|(1:144)(1:140)))|145)|146|147|341|148|(0)(0)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:89|(1:91)(4:92|(1:94)|95|(2:97|(2:370|100))(4:104|328|105|(1:113)(1:109)))|114)|115|116|358|117|(0)(0)|146|147|341|148|(0)(0)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:58|(1:60)(4:61|(1:63)|64|(2:66|(2:339|69))(4:73|359|74|(1:82)(1:78)))|83)|84|85|330|86|(0)(0)|115|116|358|117|(0)(0)|146|147|341|148|(0)(0)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(47:0|2|(1:6)|7|(1:9)|10|(2:12|(2:337|15))(4:19|363|20|(1:28)(1:24))|29|(1:31)|32|(1:34)|35|(2:37|(2:342|40))(4:44|356|45|(1:53)(1:49))|54|348|55|(30:57|85|330|86|(25:88|116|358|117|(20:119|147|341|148|(15:150|178|324|179|(10:181|209|369|210|(5:212|251|327|252|(24:254|260|(1:262)|263|353|264|(1:266)(3:267|(3:269|530|275)|279)|282|(1:284)(2:367|285)|289|(1:291)(2:354|292)|296|332|297|(1:299)(1:300)|331|303|(1:305)|306|(1:308)|309|(1:311)(1:312)|313|314)(25:255|259|260|(0)|263|353|264|(0)(0)|282|(0)(0)|289|(0)(0)|296|332|297|(0)(0)|331|303|(0)|306|(0)|309|(0)(0)|313|314))(3:213|(6:215|216|335|217|(1:219)(2:220|(1:222)(4:223|224|225|226))|334)(4:227|(1:229)|230|(2:232|(2:372|235))(4:239|325|240|(1:248)(1:244)))|249)|250|251|327|252|(0)(0))(3:182|(1:184)(4:185|(1:187)|188|(2:190|(2:322|193))(4:197|346|198|(1:206)(1:202)))|207)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:151|(1:153)(4:154|(1:156)|157|(2:159|(2:344|162))(4:166|349|167|(1:175)(1:171)))|176)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:120|(1:122)(4:123|(1:125)|126|(2:128|(2:361|131))(4:135|365|136|(1:144)(1:140)))|145)|146|147|341|148|(0)(0)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:89|(1:91)(4:92|(1:94)|95|(2:97|(2:370|100))(4:104|328|105|(1:113)(1:109)))|114)|115|116|358|117|(0)(0)|146|147|341|148|(0)(0)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0))(3:58|(1:60)(4:61|(1:63)|64|(2:66|(2:339|69))(4:73|359|74|(1:82)(1:78)))|83)|84|85|330|86|(0)(0)|115|116|358|117|(0)(0)|146|147|341|148|(0)(0)|177|178|324|179|(0)(0)|208|209|369|210|(0)(0)|250|251|327|252|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x04ec, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x04ed, code lost:
    
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x024d A[Catch: Exception -> 0x02c9, TryCatch #20 {Exception -> 0x02c9, blocks: (B:117:0x0245, B:119:0x024d, B:120:0x0259, B:122:0x0263, B:145:0x02c2, B:123:0x0268, B:125:0x026c, B:126:0x0270, B:128:0x0276, B:131:0x0284, B:134:0x029d, B:135:0x02a1, B:143:0x02bd, B:136:0x02a8, B:138:0x02b6, B:140:0x02b9), top: B:358:0x0245, inners: #22, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0259 A[Catch: Exception -> 0x02c9, TryCatch #20 {Exception -> 0x02c9, blocks: (B:117:0x0245, B:119:0x024d, B:120:0x0259, B:122:0x0263, B:145:0x02c2, B:123:0x0268, B:125:0x026c, B:126:0x0270, B:128:0x0276, B:131:0x0284, B:134:0x029d, B:135:0x02a1, B:143:0x02bd, B:136:0x02a8, B:138:0x02b6, B:140:0x02b9), top: B:358:0x0245, inners: #22, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e0 A[Catch: Exception -> 0x035c, TryCatch #10 {Exception -> 0x035c, blocks: (B:148:0x02d8, B:150:0x02e0, B:151:0x02ec, B:153:0x02f6, B:176:0x0355, B:154:0x02fb, B:156:0x02ff, B:157:0x0303, B:159:0x0309, B:162:0x0317, B:165:0x0330, B:166:0x0334, B:174:0x0350, B:167:0x033b, B:169:0x0349, B:171:0x034c), top: B:341:0x02d8, inners: #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ec A[Catch: Exception -> 0x035c, TryCatch #10 {Exception -> 0x035c, blocks: (B:148:0x02d8, B:150:0x02e0, B:151:0x02ec, B:153:0x02f6, B:176:0x0355, B:154:0x02fb, B:156:0x02ff, B:157:0x0303, B:159:0x0309, B:162:0x0317, B:165:0x0330, B:166:0x0334, B:174:0x0350, B:167:0x033b, B:169:0x0349, B:171:0x034c), top: B:341:0x02d8, inners: #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0373 A[Catch: Exception -> 0x03ef, TryCatch #1 {Exception -> 0x03ef, blocks: (B:179:0x036b, B:181:0x0373, B:182:0x037f, B:184:0x0389, B:207:0x03e8, B:185:0x038e, B:187:0x0392, B:188:0x0396, B:190:0x039c, B:193:0x03aa, B:196:0x03c3, B:197:0x03c7, B:205:0x03e3, B:198:0x03ce, B:200:0x03dc, B:202:0x03df), top: B:324:0x036b, inners: #0, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x037f A[Catch: Exception -> 0x03ef, TryCatch #1 {Exception -> 0x03ef, blocks: (B:179:0x036b, B:181:0x0373, B:182:0x037f, B:184:0x0389, B:207:0x03e8, B:185:0x038e, B:187:0x0392, B:188:0x0396, B:190:0x039c, B:193:0x03aa, B:196:0x03c3, B:197:0x03c7, B:205:0x03e3, B:198:0x03ce, B:200:0x03dc, B:202:0x03df), top: B:324:0x036b, inners: #0, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0408 A[Catch: Exception -> 0x04ba, TryCatch #26 {Exception -> 0x04ba, blocks: (B:210:0x03ff, B:212:0x0408, B:213:0x0415, B:215:0x041f, B:249:0x04b2, B:227:0x0458, B:229:0x045c, B:230:0x0460, B:232:0x0466, B:235:0x0474, B:238:0x048d, B:239:0x0491, B:247:0x04ad, B:240:0x0498, B:242:0x04a6, B:244:0x04a9), top: B:369:0x03ff, inners: #2, #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0415 A[Catch: Exception -> 0x04ba, TryCatch #26 {Exception -> 0x04ba, blocks: (B:210:0x03ff, B:212:0x0408, B:213:0x0415, B:215:0x041f, B:249:0x04b2, B:227:0x0458, B:229:0x045c, B:230:0x0460, B:232:0x0466, B:235:0x0474, B:238:0x048d, B:239:0x0491, B:247:0x04ad, B:240:0x0498, B:242:0x04a6, B:244:0x04a9), top: B:369:0x03ff, inners: #2, #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04d3 A[Catch: Exception -> 0x04ec, TryCatch #3 {Exception -> 0x04ec, blocks: (B:252:0x04ca, B:254:0x04d3, B:255:0x04df), top: B:327:0x04ca }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04df A[Catch: Exception -> 0x04ec, TRY_LEAVE, TryCatch #3 {Exception -> 0x04ec, blocks: (B:252:0x04ca, B:254:0x04d3, B:255:0x04df), top: B:327:0x04ca }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x051a A[Catch: Exception -> 0x054e, TryCatch #17 {Exception -> 0x054e, blocks: (B:264:0x0512, B:266:0x051a, B:267:0x0526, B:270:0x0530, B:278:0x0543, B:279:0x0544, B:271:0x0531, B:273:0x0539, B:274:0x053f), top: B:353:0x0512, inners: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0526 A[Catch: Exception -> 0x054e, TryCatch #17 {Exception -> 0x054e, blocks: (B:264:0x0512, B:266:0x051a, B:267:0x0526, B:270:0x0530, B:278:0x0543, B:279:0x0544, B:271:0x0531, B:273:0x0539, B:274:0x053f), top: B:353:0x0512, inners: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x061b A[Catch: Exception -> 0x0635, TryCatch #6 {Exception -> 0x0635, blocks: (B:297:0x0613, B:299:0x061b, B:300:0x0627), top: B:332:0x0613 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0627 A[Catch: Exception -> 0x0635, TRY_LEAVE, TryCatch #6 {Exception -> 0x0635, blocks: (B:297:0x0613, B:299:0x061b, B:300:0x0627), top: B:332:0x0613 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x05ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0573 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b9 A[Catch: Exception -> 0x0236, TryCatch #5 {Exception -> 0x0236, blocks: (B:86:0x01b1, B:88:0x01b9, B:89:0x01c5, B:91:0x01cf, B:114:0x022f, B:92:0x01d5, B:94:0x01d9, B:95:0x01dd, B:97:0x01e3, B:100:0x01f1, B:103:0x020a, B:104:0x020e, B:112:0x022a, B:105:0x0215, B:107:0x0223, B:109:0x0226), top: B:330:0x01b1, inners: #4, #27 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c5 A[Catch: Exception -> 0x0236, TryCatch #5 {Exception -> 0x0236, blocks: (B:86:0x01b1, B:88:0x01b9, B:89:0x01c5, B:91:0x01cf, B:114:0x022f, B:92:0x01d5, B:94:0x01d9, B:95:0x01dd, B:97:0x01e3, B:100:0x01f1, B:103:0x020a, B:104:0x020e, B:112:0x022a, B:105:0x0215, B:107:0x0223, B:109:0x0226), top: B:330:0x01b1, inners: #4, #27 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void s(Context context, JSONObject jSONObject) {
        String[] strArrE;
        String[] strArrE2;
        String imei;
        String str;
        y47 y47VarK;
        String meid;
        String str2;
        y47 y47VarK2;
        String imsi;
        String str3;
        y47 y47VarK3;
        String iccid;
        String str4;
        y47 y47VarK4;
        String mac;
        String str5;
        y47 y47VarK5;
        String sn;
        String str6;
        y47 y47VarK6;
        String str7;
        y47 y47VarK7;
        String str8;
        String string;
        y47 y47VarK8;
        String[] strArrE3;
        String[] strArrE4;
        String[] strArrE5;
        String[] strArrE6;
        String[] strArrE7;
        String[] strArrE8;
        if (!TextUtils.isEmpty(c57.l().h()) || c57.l().a() > 0) {
            g(jSONObject, "sid", c57.l().m());
        }
        g(jSONObject, "aid", y47.k().b(context));
        IAppParams iAppParams = y47.k().d;
        String oaid = iAppParams != null ? iAppParams.getOAID() : "";
        if (TextUtils.isEmpty(oaid)) {
            c57 c57VarL = c57.l();
            c57VarL.getClass();
            try {
                strArrE = c57VarL.c.e(o57.a().o, 1, true);
            } catch (Exception e2) {
                g57.a(e2);
            }
            oaid = (strArrE == null || strArrE.length <= 0) ? "" : strArrE[0];
        } else {
            c57 c57VarL2 = c57.l();
            c57VarL2.getClass();
            if (!TextUtils.isEmpty(oaid)) {
                try {
                    c57VarL2.c.b(o57.a().o, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, oaid), true);
                } catch (JSONException e3) {
                    g57.a(e3);
                }
            }
        }
        g(jSONObject, "oaid", oaid);
        IAppParams iAppParams2 = y47.k().d;
        g(jSONObject, "loginid", iAppParams2 != null ? iAppParams2.getLoginId() : "");
        IAppParams iAppParams3 = y47.k().d;
        String thirdID = iAppParams3 != null ? iAppParams3.getThirdID() : "";
        if (TextUtils.isEmpty(thirdID)) {
            c57 c57VarL3 = c57.l();
            c57VarL3.getClass();
            try {
                strArrE2 = c57VarL3.c.e(o57.a().t, 1, true);
            } catch (Exception e4) {
                g57.a(e4);
            }
            thirdID = (strArrE2 == null || strArrE2.length <= 0) ? "" : strArrE2[0];
        } else {
            c57 c57VarL4 = c57.l();
            c57VarL4.getClass();
            if (!TextUtils.isEmpty(thirdID)) {
                try {
                    c57VarL4.c.b(o57.a().t, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, thirdID), true);
                } catch (JSONException e5) {
                    g57.a(e5);
                }
            }
        }
        g(jSONObject, "thirdid", thirdID);
        y47 y47VarK9 = y47.k();
        y47VarK9.getClass();
        imei = "";
        if (y47VarK9.c(WkParams.IMEI)) {
            str = y47VarK9.f22121a.get(WkParams.IMEI);
            g(jSONObject, WkParams.IMEI, str);
            y47VarK = y47.k();
            y47VarK.getClass();
            meid = "";
            if (y47VarK.c("meid")) {
                if (ZMDataSDKManager.getInstance().zmConfigOptions.isImeiEnable) {
                    meid = cdazmb.d(context, -2);
                } else {
                    IAppParams iAppParams4 = y47VarK.d;
                    meid = iAppParams4 != null ? iAppParams4.getMEID() : "";
                    if (TextUtils.isEmpty(meid)) {
                        c57 c57VarL5 = c57.l();
                        c57VarL5.getClass();
                        try {
                            strArrE7 = c57VarL5.c.e(o57.a().j, 1, true);
                        } catch (Exception e6) {
                            g57.a(e6);
                        }
                        if (strArrE7 == null || strArrE7.length <= 0) {
                            meid = "";
                        } else {
                            meid = strArrE7[0];
                        }
                    } else {
                        c57 c57VarL6 = c57.l();
                        c57VarL6.getClass();
                        if (!TextUtils.isEmpty(meid)) {
                            try {
                                c57VarL6.c.b(o57.a().j, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, meid), true);
                            } catch (JSONException e7) {
                                g57.a(e7);
                            }
                        }
                    }
                }
                y47VarK.f22121a.put("meid", meid);
            } else {
                str2 = y47VarK.f22121a.get("meid");
                g(jSONObject, "meid", str2);
                y47VarK2 = y47.k();
                y47VarK2.getClass();
                imsi = "";
                if (y47VarK2.c("imsi")) {
                    str3 = y47VarK2.f22121a.get("imsi");
                    g(jSONObject, "imsi", str3);
                    y47VarK3 = y47.k();
                    y47VarK3.getClass();
                    iccid = "";
                    if (y47VarK3.c("iccid")) {
                        if (ZMDataSDKManager.getInstance().zmConfigOptions.isImeiEnable) {
                            iccid = cdazmb.k(context);
                        } else {
                            IAppParams iAppParams5 = y47VarK3.d;
                            iccid = iAppParams5 != null ? iAppParams5.getICCID() : "";
                            if (TextUtils.isEmpty(iccid)) {
                                c57 c57VarL7 = c57.l();
                                c57VarL7.getClass();
                                try {
                                    strArrE5 = c57VarL7.c.e(o57.a().k, 1, true);
                                } catch (Exception e8) {
                                    g57.a(e8);
                                }
                                if (strArrE5 == null || strArrE5.length <= 0) {
                                    iccid = "";
                                } else {
                                    iccid = strArrE5[0];
                                }
                            } else {
                                c57 c57VarL8 = c57.l();
                                c57VarL8.getClass();
                                if (!TextUtils.isEmpty(iccid)) {
                                    try {
                                        c57VarL8.c.b(o57.a().k, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, iccid), true);
                                    } catch (JSONException e9) {
                                        g57.a(e9);
                                    }
                                }
                            }
                        }
                        y47VarK3.f22121a.put("iccid", iccid);
                    } else {
                        str4 = y47VarK3.f22121a.get("iccid");
                        g(jSONObject, "iccid", str4);
                        y47VarK4 = y47.k();
                        y47VarK4.getClass();
                        mac = "";
                        if (y47VarK4.c("mac")) {
                            str5 = y47VarK4.f22121a.get("mac");
                            g(jSONObject, "mac", str5);
                            y47VarK5 = y47.k();
                            y47VarK5.getClass();
                            sn = "";
                            if (!y47VarK5.c("sn")) {
                                str6 = y47VarK5.f22121a.get("sn");
                                g(jSONObject, "sn", str6);
                                y47VarK6 = y47.k();
                                y47VarK6.getClass();
                                String strJ = "";
                                if (!y47VarK6.c("udid")) {
                                    strJ = cdazmb.j();
                                    y47VarK6.f22121a.put("udid", strJ);
                                    str7 = strJ;
                                    g(jSONObject, "udid", str7);
                                    IAppParams iAppParams6 = y47.k().d;
                                    g(jSONObject, "dhid", iAppParams6 != null ? iAppParams6.getDHID() : "");
                                    y47VarK7 = y47.k();
                                    y47VarK7.getClass();
                                    String str9 = "";
                                    if (y47VarK7.c("cid")) {
                                    }
                                    g(jSONObject, "cid", str9);
                                    g(jSONObject, "appId", ZMDataSDKManager.getInstance().zmConfigOptions.appId);
                                    g(jSONObject, "channelId", ZMDataSDKManager.getInstance().zmConfigOptions.channelId);
                                    if (context != null) {
                                    }
                                    g(jSONObject, "bundleId", str8);
                                    g(jSONObject, "appVersion", r(context));
                                    g(jSONObject, "appVersionCode", a(context));
                                    g(jSONObject, "sdkVersion", "2.0.6");
                                    g(jSONObject, ZZ00Z.v, "250731");
                                    if (context != null) {
                                    }
                                    g(jSONObject, WfConstant.EVENT_KEY_APP_NAME, string);
                                    g(jSONObject, "brand", y47.k().a());
                                    g(jSONObject, "language", y47.k().l());
                                    g(jSONObject, "os", y47.k().o());
                                    g(jSONObject, "os_version", y47.k().p());
                                    y47VarK8 = y47.k();
                                    y47VarK8.getClass();
                                    String lowerCase = "";
                                    if (y47VarK8.c("androidRelease")) {
                                    }
                                    g(jSONObject, "androidRelease", lowerCase);
                                    g(jSONObject, bt.P, y47.k().e(context));
                                    g(jSONObject, "networkType", y47.k().i(context));
                                    g(jSONObject, f.C, y47.k().g(context));
                                    g(jSONObject, "lon", y47.k().m());
                                    IAppParams iAppParams7 = y47.k().d;
                                    g(jSONObject, "productId", iAppParams7 != null ? iAppParams7.getProductId() : "");
                                    IAppParams iAppParams8 = y47.k().d;
                                    g(jSONObject, WkParams.CAPBSSID, iAppParams8 != null ? iAppParams8.getCapBssid() : "");
                                    g(jSONObject, WkParams.CAPSSID, y47.k().d());
                                    g(jSONObject, DeviceInfoUtil.UID_TAG, y47.k().q());
                                    g(jSONObject, "did", y47.k().f());
                                    g(jSONObject, "esid", y47.k().j());
                                    g(jSONObject, "epid", y47.k().h());
                                    g(jSONObject, "firstInstallTime", u(context) + "");
                                    g(jSONObject, "lastUpdateTime", v(context) + "");
                                    g(jSONObject, "isnet", !w(ZMDataSDKManager.getInstance().getContext()) ? "1" : "0");
                                    g(jSONObject, "pid", r67.a().c("pid", ""));
                                    g(jSONObject, "mapsp", y47.k().n());
                                    return;
                                }
                                str7 = y47VarK6.f22121a.get("udid");
                                g(jSONObject, "udid", str7);
                                IAppParams iAppParams62 = y47.k().d;
                                g(jSONObject, "dhid", iAppParams62 != null ? iAppParams62.getDHID() : "");
                                y47VarK7 = y47.k();
                                y47VarK7.getClass();
                                String str92 = "";
                                try {
                                    if (y47VarK7.c("cid")) {
                                        if (TextUtils.isEmpty(r57.f20397a)) {
                                            synchronized (r57.class) {
                                                if (TextUtils.isEmpty(r57.f20397a)) {
                                                    r57.f20397a = r57.d();
                                                }
                                            }
                                        }
                                        str92 = r57.f20397a;
                                        y47VarK7.f22121a.put("cid", str92);
                                    } else {
                                        str92 = y47VarK7.f22121a.get("cid");
                                    }
                                } catch (Exception unused) {
                                }
                                g(jSONObject, "cid", str92);
                                g(jSONObject, "appId", ZMDataSDKManager.getInstance().zmConfigOptions.appId);
                                g(jSONObject, "channelId", ZMDataSDKManager.getInstance().zmConfigOptions.channelId);
                                if (context != null) {
                                    str8 = "";
                                } else {
                                    try {
                                        str8 = context.getApplicationInfo().processName;
                                    } catch (Exception e10) {
                                        g57.a(e10);
                                        str8 = "";
                                    }
                                }
                                g(jSONObject, "bundleId", str8);
                                g(jSONObject, "appVersion", r(context));
                                g(jSONObject, "appVersionCode", a(context));
                                g(jSONObject, "sdkVersion", "2.0.6");
                                g(jSONObject, ZZ00Z.v, "250731");
                                if (context != null) {
                                    string = "";
                                } else {
                                    try {
                                        PackageManager packageManager = context.getPackageManager();
                                        string = packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager).toString();
                                    } catch (Throwable th) {
                                        g57.b("AppInfoUtils", th.getMessage());
                                        string = "";
                                    }
                                }
                                g(jSONObject, WfConstant.EVENT_KEY_APP_NAME, string);
                                g(jSONObject, "brand", y47.k().a());
                                g(jSONObject, "language", y47.k().l());
                                g(jSONObject, "os", y47.k().o());
                                g(jSONObject, "os_version", y47.k().p());
                                y47VarK8 = y47.k();
                                y47VarK8.getClass();
                                String lowerCase2 = "";
                                try {
                                    if (y47VarK8.c("androidRelease")) {
                                        lowerCase2 = Build.VERSION.RELEASE.toLowerCase();
                                        y47VarK8.f22121a.put("androidRelease", lowerCase2);
                                    } else {
                                        lowerCase2 = y47VarK8.f22121a.get("androidRelease");
                                    }
                                } catch (Exception unused2) {
                                }
                                g(jSONObject, "androidRelease", lowerCase2);
                                g(jSONObject, bt.P, y47.k().e(context));
                                g(jSONObject, "networkType", y47.k().i(context));
                                g(jSONObject, f.C, y47.k().g(context));
                                g(jSONObject, "lon", y47.k().m());
                                IAppParams iAppParams72 = y47.k().d;
                                g(jSONObject, "productId", iAppParams72 != null ? iAppParams72.getProductId() : "");
                                IAppParams iAppParams82 = y47.k().d;
                                g(jSONObject, WkParams.CAPBSSID, iAppParams82 != null ? iAppParams82.getCapBssid() : "");
                                g(jSONObject, WkParams.CAPSSID, y47.k().d());
                                g(jSONObject, DeviceInfoUtil.UID_TAG, y47.k().q());
                                g(jSONObject, "did", y47.k().f());
                                g(jSONObject, "esid", y47.k().j());
                                g(jSONObject, "epid", y47.k().h());
                                g(jSONObject, "firstInstallTime", u(context) + "");
                                g(jSONObject, "lastUpdateTime", v(context) + "");
                                g(jSONObject, "isnet", !w(ZMDataSDKManager.getInstance().getContext()) ? "1" : "0");
                                g(jSONObject, "pid", r67.a().c("pid", ""));
                                g(jSONObject, "mapsp", y47.k().n());
                                return;
                            }
                            if (ZMDataSDKManager.getInstance().zmConfigOptions.isSnEnable) {
                                String str10 = cdazmb.f1964a;
                                sn = "";
                                try {
                                    int i = Build.VERSION.SDK_INT;
                                    if (i >= 28) {
                                        sn = Build.getSerial();
                                    } else if (i > 24) {
                                        sn = Build.SERIAL;
                                    } else {
                                        Class<?> cls = Class.forName("android.os.SystemProperties");
                                        sn = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
                                    }
                                } catch (Exception unused3) {
                                }
                            } else {
                                IAppParams iAppParams9 = y47VarK5.d;
                                sn = iAppParams9 != null ? iAppParams9.getSN() : "";
                                if (TextUtils.isEmpty(sn)) {
                                    c57 c57VarL9 = c57.l();
                                    c57VarL9.getClass();
                                    try {
                                        strArrE3 = c57VarL9.c.e(o57.a().m, 1, true);
                                    } catch (Exception e11) {
                                        g57.a(e11);
                                    }
                                    if (strArrE3 == null || strArrE3.length <= 0) {
                                        sn = "";
                                    } else {
                                        sn = strArrE3[0];
                                    }
                                } else {
                                    c57 c57VarL10 = c57.l();
                                    c57VarL10.getClass();
                                    if (!TextUtils.isEmpty(sn)) {
                                        try {
                                            c57VarL10.c.b(o57.a().m, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, sn), true);
                                        } catch (JSONException e12) {
                                            g57.a(e12);
                                        }
                                    }
                                }
                            }
                            y47VarK5.f22121a.put("sn", sn);
                            str6 = sn;
                            g(jSONObject, "sn", str6);
                            y47VarK6 = y47.k();
                            y47VarK6.getClass();
                            String strJ2 = "";
                            if (!y47VarK6.c("udid")) {
                            }
                        } else {
                            if (ZMDataSDKManager.getInstance().zmConfigOptions.isMacEnable) {
                                mac = cdazmb.q(context);
                            } else {
                                IAppParams iAppParams10 = y47VarK4.d;
                                mac = iAppParams10 != null ? iAppParams10.getMAC() : "";
                                if (TextUtils.isEmpty(mac)) {
                                    c57 c57VarL11 = c57.l();
                                    c57VarL11.getClass();
                                    try {
                                        strArrE4 = c57VarL11.c.e(o57.a().l, 1, true);
                                    } catch (Exception e13) {
                                        g57.a(e13);
                                    }
                                    if (strArrE4 == null || strArrE4.length <= 0) {
                                        mac = "";
                                    } else {
                                        mac = strArrE4[0];
                                    }
                                } else {
                                    c57 c57VarL12 = c57.l();
                                    c57VarL12.getClass();
                                    if (!TextUtils.isEmpty(mac)) {
                                        try {
                                            c57VarL12.c.b(o57.a().l, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, mac), true);
                                        } catch (JSONException e14) {
                                            g57.a(e14);
                                        }
                                    }
                                }
                            }
                            y47VarK4.f22121a.put("mac", mac);
                        }
                        str5 = mac;
                        g(jSONObject, "mac", str5);
                        y47VarK5 = y47.k();
                        y47VarK5.getClass();
                        sn = "";
                        if (!y47VarK5.c("sn")) {
                        }
                        str6 = sn;
                        g(jSONObject, "sn", str6);
                        y47VarK6 = y47.k();
                        y47VarK6.getClass();
                        String strJ22 = "";
                        if (!y47VarK6.c("udid")) {
                        }
                    }
                    str4 = iccid;
                    g(jSONObject, "iccid", str4);
                    y47VarK4 = y47.k();
                    y47VarK4.getClass();
                    mac = "";
                    if (y47VarK4.c("mac")) {
                    }
                    str5 = mac;
                    g(jSONObject, "mac", str5);
                    y47VarK5 = y47.k();
                    y47VarK5.getClass();
                    sn = "";
                    if (!y47VarK5.c("sn")) {
                    }
                    str6 = sn;
                    g(jSONObject, "sn", str6);
                    y47VarK6 = y47.k();
                    y47VarK6.getClass();
                    String strJ222 = "";
                    if (!y47VarK6.c("udid")) {
                    }
                } else {
                    if (ZMDataSDKManager.getInstance().zmConfigOptions.isImeiEnable) {
                        imsi = cdazmb.o(context);
                    } else {
                        IAppParams iAppParams11 = y47VarK2.d;
                        imsi = iAppParams11 != null ? iAppParams11.getIMSI() : "";
                        if (TextUtils.isEmpty(imsi)) {
                            c57 c57VarL13 = c57.l();
                            c57VarL13.getClass();
                            try {
                                strArrE6 = c57VarL13.c.e(o57.a().i, 1, true);
                            } catch (Exception e15) {
                                g57.a(e15);
                            }
                            if (strArrE6 == null || strArrE6.length <= 0) {
                                imsi = "";
                            } else {
                                imsi = strArrE6[0];
                            }
                        } else {
                            c57 c57VarL14 = c57.l();
                            c57VarL14.getClass();
                            if (!TextUtils.isEmpty(imsi)) {
                                try {
                                    c57VarL14.c.b(o57.a().i, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, imsi), true);
                                } catch (JSONException e16) {
                                    g57.a(e16);
                                }
                            }
                        }
                    }
                    y47VarK2.f22121a.put("imsi", imsi);
                }
                str3 = imsi;
                g(jSONObject, "imsi", str3);
                y47VarK3 = y47.k();
                y47VarK3.getClass();
                iccid = "";
                if (y47VarK3.c("iccid")) {
                }
                str4 = iccid;
                g(jSONObject, "iccid", str4);
                y47VarK4 = y47.k();
                y47VarK4.getClass();
                mac = "";
                if (y47VarK4.c("mac")) {
                }
                str5 = mac;
                g(jSONObject, "mac", str5);
                y47VarK5 = y47.k();
                y47VarK5.getClass();
                sn = "";
                if (!y47VarK5.c("sn")) {
                }
                str6 = sn;
                g(jSONObject, "sn", str6);
                y47VarK6 = y47.k();
                y47VarK6.getClass();
                String strJ2222 = "";
                if (!y47VarK6.c("udid")) {
                }
            }
            str2 = meid;
            g(jSONObject, "meid", str2);
            y47VarK2 = y47.k();
            y47VarK2.getClass();
            imsi = "";
            if (y47VarK2.c("imsi")) {
            }
            str3 = imsi;
            g(jSONObject, "imsi", str3);
            y47VarK3 = y47.k();
            y47VarK3.getClass();
            iccid = "";
            if (y47VarK3.c("iccid")) {
            }
            str4 = iccid;
            g(jSONObject, "iccid", str4);
            y47VarK4 = y47.k();
            y47VarK4.getClass();
            mac = "";
            if (y47VarK4.c("mac")) {
            }
            str5 = mac;
            g(jSONObject, "mac", str5);
            y47VarK5 = y47.k();
            y47VarK5.getClass();
            sn = "";
            if (!y47VarK5.c("sn")) {
            }
            str6 = sn;
            g(jSONObject, "sn", str6);
            y47VarK6 = y47.k();
            y47VarK6.getClass();
            String strJ22222 = "";
            if (!y47VarK6.c("udid")) {
            }
        } else {
            if (ZMDataSDKManager.getInstance().zmConfigOptions.isImeiEnable) {
                imei = cdazmb.m(context);
            } else {
                IAppParams iAppParams12 = y47VarK9.d;
                imei = iAppParams12 != null ? iAppParams12.getIMEI() : "";
                if (TextUtils.isEmpty(imei)) {
                    c57 c57VarL15 = c57.l();
                    c57VarL15.getClass();
                    try {
                        strArrE8 = c57VarL15.c.e(o57.a().h, 1, true);
                    } catch (Exception e17) {
                        g57.a(e17);
                    }
                    if (strArrE8 == null || strArrE8.length <= 0) {
                        imei = "";
                    } else {
                        imei = strArrE8[0];
                    }
                } else {
                    c57 c57VarL16 = c57.l();
                    c57VarL16.getClass();
                    if (!TextUtils.isEmpty(imei)) {
                        try {
                            c57VarL16.c.b(o57.a().h, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, imei), true);
                        } catch (JSONException e18) {
                            g57.a(e18);
                        }
                    }
                }
            }
            y47VarK9.f22121a.put(WkParams.IMEI, imei);
        }
        str = imei;
        g(jSONObject, WkParams.IMEI, str);
        y47VarK = y47.k();
        y47VarK.getClass();
        meid = "";
        if (y47VarK.c("meid")) {
        }
        str2 = meid;
        g(jSONObject, "meid", str2);
        y47VarK2 = y47.k();
        y47VarK2.getClass();
        imsi = "";
        if (y47VarK2.c("imsi")) {
        }
        str3 = imsi;
        g(jSONObject, "imsi", str3);
        y47VarK3 = y47.k();
        y47VarK3.getClass();
        iccid = "";
        if (y47VarK3.c("iccid")) {
        }
        str4 = iccid;
        g(jSONObject, "iccid", str4);
        y47VarK4 = y47.k();
        y47VarK4.getClass();
        mac = "";
        if (y47VarK4.c("mac")) {
        }
        str5 = mac;
        g(jSONObject, "mac", str5);
        y47VarK5 = y47.k();
        y47VarK5.getClass();
        sn = "";
        if (!y47VarK5.c("sn")) {
        }
        str6 = sn;
        g(jSONObject, "sn", str6);
        y47VarK6 = y47.k();
        y47VarK6.getClass();
        String strJ222222 = "";
        if (!y47VarK6.c("udid")) {
        }
    }

    public static byte[] t(String str, String str2, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static long u(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e2) {
            g57.a(e2);
            return 0L;
        }
    }

    public static long v(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e2) {
            g57.a(e2);
            return 0L;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static boolean w(Context context) {
        if (!l67.a(context, g.b)) {
            return false;
        }
        try {
            return i((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e2) {
            g57.a(e2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String x(Context context) {
        String str;
        NetworkInfo activeNetworkInfo;
        int networkType;
        NetworkCapabilities networkCapabilities;
        try {
            if (!TextUtils.isEmpty(c) && !"NULL".equals(c)) {
                return c;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && !l67.a(context, g.c)) {
                c = "NULL";
                return "NULL";
            }
            if (!l67.a(context, g.b)) {
                c = "NULL";
                return "NULL";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            int subtype = 0;
            if (connectivityManager != null) {
                if (!i(connectivityManager)) {
                    c = "NULL";
                    return "NULL";
                }
                boolean zHasTransport = true;
                if (i >= 23) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    zHasTransport = (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? false : networkCapabilities.hasTransport(1);
                    if (zHasTransport) {
                        c = "WIFI";
                        return "WIFI";
                    }
                } else {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
                    }
                    if (zHasTransport) {
                    }
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                if (i < 30 || !(l67.a(context, g.c) || telephonyManager.hasCarrierPrivileges())) {
                    try {
                        networkType = telephonyManager.getNetworkType();
                    } catch (Exception e2) {
                        g57.a(e2);
                    }
                } else {
                    networkType = telephonyManager.getDataNetworkType();
                }
                subtype = networkType;
            }
            if (subtype != 0) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = "3G";
                        break;
                    case 13:
                    case 18:
                    case 19:
                        str = "4G";
                        break;
                    case 16:
                    case 17:
                    default:
                        str = "NULL";
                        break;
                    case 20:
                        str = "5G";
                        break;
                }
            } else if (Build.VERSION.SDK_INT < 30) {
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    subtype = activeNetworkInfo.getSubtype();
                }
                switch (subtype) {
                }
            } else {
                str = "NULL";
            }
            c = str;
            return str;
        } catch (Exception e3) {
            g57.a(e3);
            c = "NULL";
            return "NULL";
        }
    }
}
