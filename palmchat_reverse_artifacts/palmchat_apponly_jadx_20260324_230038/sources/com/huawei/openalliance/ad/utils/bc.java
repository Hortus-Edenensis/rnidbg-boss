package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.ce;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class bc {
    private static final String Code = "StrUtil";
    private static final String I = "^[0-9]+,[0-9]+$";
    private static final String V = "^[0-9\\*\\+\\-\\.]*$";
    private static final int Z = 100;

    public static boolean B(String str) {
        return str != null && (str.startsWith(ce.HTTP.toString()) || str.startsWith(ce.HTTPS.toString()));
    }

    public static String C(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("://") ? a(str) : b(str);
    }

    public static int Code(String str, int i) {
        try {
            return Code(str) ? i : Integer.parseInt(str);
        } catch (NumberFormatException e) {
            fh.I(Code, "parseIntOrDefault exception: " + e.getClass().getSimpleName());
            return i;
        }
    }

    public static boolean D(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches(I, str) && str.length() < 100;
    }

    public static Integer F(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            fh.Z(Code, "toInteger NumberFormatException:" + e.getClass().getSimpleName());
            return null;
        }
    }

    public static Long I(String str) {
        if (Code(str)) {
            return null;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException e) {
            fh.Z(Code, "toLong NumberFormatException:" + e.getClass().getSimpleName());
            return null;
        }
    }

    public static boolean L(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches(V, str) && str.length() < 100;
    }

    public static String S(String str) {
        if (Code(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            fh.Z(Code, "unsupport encoding");
            return null;
        }
    }

    public static String V(Object obj) {
        return obj == null ? com.igexin.push.core.b.m : "not null";
    }

    public static String Z(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme != null) {
            sb.append(scheme);
            sb.append("://");
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = uri.getHost();
        } else {
            sb.append("******");
            sb.append('/');
        }
        if (lastPathSegment != null) {
            int length = lastPathSegment.length();
            if (length > 3) {
                sb.append((CharSequence) lastPathSegment, 0, 3);
            } else if (length > 1) {
                sb.append((CharSequence) lastPathSegment, 0, length - 1);
            }
        }
        sb.append("******");
        return sb.toString();
    }

    private static String b(String str) {
        int i;
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf >= 0 && (i = iLastIndexOf + 1) < str.length()) {
            str = str.substring(i);
        }
        int length = str.length();
        if (length > 3) {
            return str.substring(0, 3) + "******";
        }
        if (length <= 1) {
            return "******";
        }
        return str.substring(0, length - 1) + "******";
    }

    public static long Code(String str, long j) {
        try {
            return Code(str) ? j : Long.parseLong(str);
        } catch (NumberFormatException e) {
            fh.I(Code, "parseLongOrDefault exception: " + e.getClass().getSimpleName());
            return j;
        }
    }

    private static Object I(Object obj) {
        if (obj instanceof Bundle) {
            return V((Bundle) obj);
        }
        try {
            return JSONObject.wrap(obj);
        } catch (Throwable th) {
            fh.I(Code, "wrap Exception:" + th.getClass().getSimpleName());
            return JSONObject.NULL;
        }
    }

    public static String V(String str) {
        String str2;
        if (Code(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "unsupport encoding";
            fh.Z(Code, str2);
            return null;
        } catch (Exception unused2) {
            str2 = "decode error";
            fh.Z(Code, str2);
            return null;
        }
    }

    public static Float Code(String str, Float f) {
        if (Code(str)) {
            return f;
        }
        try {
            return Float.valueOf(str);
        } catch (NumberFormatException e) {
            fh.Z(Code, "parseFloatOrDefault NumberFormatException:" + e.getClass().getSimpleName());
            return f;
        }
    }

    public static String I(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return str2.lastIndexOf(".") == -1 ? str2 : str2.substring(0, str2.lastIndexOf("."));
        }
        String strReplaceAll = str2.replaceAll("." + str.replace(".java", ""), "");
        int iIndexOf = strReplaceAll.indexOf("$");
        return iIndexOf != -1 ? strReplaceAll.substring(0, iIndexOf) : strReplaceAll;
    }

    public static List<String> V(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : new ArrayList(Arrays.asList(str.split(str2)));
    }

    private static String Code(long j) {
        float f = (j * 1.0f) / 1048576.0f;
        if (f < 0.1f) {
            f = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f));
    }

    public static JSONObject V(Bundle bundle) {
        if (bundle == null) {
            return new JSONObject();
        }
        Set<String> setKeySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : setKeySet) {
            try {
                jSONObject.put(str, I(bundle.get(str)));
            } catch (Throwable th) {
                fh.I(Code, "converBundleToJson Exception:" + th.getClass().getSimpleName());
            }
        }
        return jSONObject;
    }

    public static String Code(Context context, int i, String str, Object... objArr) {
        StringBuilder sb;
        Resources resources = context.getResources();
        String string = null;
        try {
            if (cn.Code(context).Code()) {
                int identifier = resources.getIdentifier(str + "_zh", "string", context.getPackageName());
                string = objArr != null ? resources.getString(identifier, objArr) : resources.getString(identifier);
            }
        } catch (RuntimeException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getChinaString ");
            sb.append(e.getClass().getSimpleName());
            fh.Z(Code, sb.toString());
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getChinaString ");
            sb.append(e.getClass().getSimpleName());
            fh.Z(Code, sb.toString());
        }
        return string == null ? (objArr == null || objArr.length <= 0) ? resources.getString(i) : resources.getString(i, objArr) : string;
    }

    public static String Code(Context context, long j) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j));
    }

    public static String Code(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return V(bundle).toString();
    }

    public static String Code(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static String Code(String str, Context context) {
        BufferedReader bufferedReader;
        Object th;
        InputStream inputStreamOpen;
        AssetManager assets = context.getAssets();
        StringBuilder sb = new StringBuilder();
        try {
            inputStreamOpen = assets.open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fh.I(Code, "getStringFromAsset " + th.getClass().getSimpleName());
                        } finally {
                            bb.Code(bufferedReader);
                            bb.Code((Closeable) inputStreamOpen);
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStreamOpen = null;
        }
        return sb.toString();
    }

    public static String Code(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            boolean z = true;
            for (String str2 : list) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(str2);
                z = false;
            }
        }
        return sb.toString();
    }

    public static List<String> Code(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (ag.Code(list)) {
            return arrayList;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strV = V(it.next());
            if (strV != null) {
                arrayList.add(strV);
            }
        }
        return arrayList;
    }

    public static boolean Code(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean Code(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return TextUtils.equals(str, str2);
    }

    public static boolean Code(Set<String> set, String str) {
        if (!ag.Code(set) && !TextUtils.isEmpty(str)) {
            return set.contains(str);
        }
        fh.Code(Code, "ModelList or ModelName is empty");
        return true;
    }
}
