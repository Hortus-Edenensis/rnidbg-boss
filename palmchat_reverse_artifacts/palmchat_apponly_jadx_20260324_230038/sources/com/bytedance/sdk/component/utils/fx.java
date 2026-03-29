package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static HashMap<String, ArrayList<String>> u = new HashMap<>();

    private static Signature[] nr(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            k.u(e.toString());
            return null;
        }
    }

    public static ArrayList<String> u(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (u.get(str) != null) {
                return u.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : nr(context, packageName)) {
                    String strU = "error!";
                    if ("MD5".equals(str)) {
                        strU = u(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        strU = u(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strU = u(signature, "SHA256");
                    }
                    arrayList.add(strU);
                }
            } catch (Exception e) {
                k.u(e.toString());
            }
            u.put(str, arrayList);
        }
        return arrayList;
    }

    public static String u(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListU = u(context, "SHA1");
        if (arrayListU != null && arrayListU.size() != 0) {
            for (int i = 0; i < arrayListU.size(); i++) {
                sb.append(arrayListU.get(i));
                if (i < arrayListU.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String u(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            k.u(e.toString());
            return "error!";
        }
    }
}
