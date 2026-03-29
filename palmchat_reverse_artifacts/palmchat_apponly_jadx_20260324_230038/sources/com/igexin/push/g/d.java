package com.igexin.push.g;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import com.getui.gtc.BuildConfig;
import com.vivo.push.PushClientConstants;
import com.wifi.ad.core.config.EventParams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static long f7357a = 0;
    static HashMap<String, Object> b = new HashMap<>();
    private static final String c = "ro.miui.ui.version.name";
    private static final String d = "ro.miui.ui.version.code";
    private static final String e = "GT";
    private static volatile Boolean f;
    private static String g;
    private static PackageInfo h;

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e1, code lost:
    
        if (r3.getPackage() != null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e3, code lost:
    
        r3.setSelector(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e7, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01e8, code lost:
    
        if (r5 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f0, code lost:
    
        if (r5.startsWith("intent:") == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f2, code lost:
    
        r5 = r5.substring(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01f7, code lost:
    
        if (r10 == null) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01f9, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r10);
        r0.append(':');
        r0.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0209, code lost:
    
        r5 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0213, code lost:
    
        if (r5.startsWith("android-app:") == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x021d, code lost:
    
        if (r5.charAt(12) != '/') goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0225, code lost:
    
        if (r5.charAt(13) != '/') goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0227, code lost:
    
        r6 = r5.indexOf(47, 14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x022f, code lost:
    
        if (r6 >= 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0231, code lost:
    
        r3.setPackage(r5.substring(14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0238, code lost:
    
        if (r11 != false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x023a, code lost:
    
        r3.setAction("android.intent.action.MAIN");
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x023e, code lost:
    
        r3.setPackage(r5.substring(14, r6));
        r0 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x024b, code lost:
    
        if (r0 >= r5.length()) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x024d, code lost:
    
        r8 = r5.indexOf(47, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0251, code lost:
    
        if (r8 < 0) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0253, code lost:
    
        r10 = r5.substring(r0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x025b, code lost:
    
        if (r8 >= r5.length()) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x025d, code lost:
    
        r0 = r8 + 1;
        r6 = r5.indexOf(47, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0263, code lost:
    
        if (r6 < 0) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0265, code lost:
    
        r0 = r5.substring(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x026a, code lost:
    
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x026c, code lost:
    
        r10 = r5.substring(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0270, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0271, code lost:
    
        if (r10 != null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0273, code lost:
    
        if (r11 != false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0276, code lost:
    
        if (r0 != null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0278, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r10);
        r0.append(":");
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0284, code lost:
    
        r5 = r10 + "://" + r0 + r5.substring(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02a0, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02a5, code lost:
    
        if (r5.length() <= 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02a7, code lost:
    
        r3.setData(android.net.Uri.parse(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02af, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02b9, code lost:
    
        throw new java.net.URISyntaxException(r17, r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02ba, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d8, code lost:
    
        r8.putExtras(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01db, code lost:
    
        if (r9 == false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(String str) throws URISyntaxException {
        String string;
        int i = 0;
        try {
            boolean zStartsWith = str.startsWith("android-app:");
            int iLastIndexOf = str.lastIndexOf("#");
            try {
                if (iLastIndexOf == -1) {
                    if (!zStartsWith) {
                        return new Intent("android.intent.action.VIEW", Uri.parse(str));
                    }
                } else if (!str.startsWith("#Intent;", iLastIndexOf)) {
                    if (!zStartsWith) {
                        return d(str);
                    }
                    iLastIndexOf = -1;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (iLastIndexOf >= 0) {
                    string = str.substring(0, iLastIndexOf);
                    iLastIndexOf += 8;
                } else {
                    string = str;
                }
                if (intent.getExtras() == null) {
                    intent.putExtras(new Bundle());
                }
                Bundle extras = intent.getExtras();
                Intent intent2 = intent;
                boolean z = false;
                String strSubstring = null;
                boolean z2 = false;
                while (true) {
                    if (iLastIndexOf < 0 || str.startsWith("end", iLastIndexOf)) {
                        break;
                    }
                    int iIndexOf = str.indexOf(61, iLastIndexOf);
                    if (iIndexOf < 0) {
                        iIndexOf = iLastIndexOf - 1;
                    }
                    int iIndexOf2 = str.indexOf(59, iLastIndexOf);
                    String strDecode = iIndexOf < iIndexOf2 ? Uri.decode(str.substring(iIndexOf + 1, iIndexOf2)) : "";
                    if (str.startsWith("action=", iLastIndexOf)) {
                        intent2.setAction(strDecode);
                        if (!z) {
                            z2 = true;
                        }
                    } else if (str.startsWith("category=", iLastIndexOf)) {
                        intent2.addCategory(strDecode);
                    } else if (str.startsWith("type=", iLastIndexOf)) {
                        intent2.setType(strDecode);
                    } else if (str.startsWith("launchFlags=", iLastIndexOf)) {
                        intent2.setFlags(Integer.decode(strDecode).intValue());
                        intent2.setFlags((~(67 | 128)) & intent2.getFlags());
                    } else if (str.startsWith("package=", iLastIndexOf)) {
                        intent2.setPackage(strDecode);
                    } else if (str.startsWith("component=", iLastIndexOf)) {
                        intent2.setComponent(ComponentName.unflattenFromString(strDecode));
                    } else if (str.startsWith("scheme=", iLastIndexOf)) {
                        if (z) {
                            intent2.setData(Uri.parse(strDecode + ":"));
                        } else {
                            strSubstring = strDecode;
                        }
                    } else if (str.startsWith("sourceBounds=", iLastIndexOf)) {
                        intent2.setSourceBounds(Rect.unflattenFromString(strDecode));
                    } else if (iIndexOf2 == iLastIndexOf + 3 && str.startsWith("SEL", iLastIndexOf)) {
                        intent2 = new Intent();
                        z = true;
                    } else {
                        String strDecode2 = Uri.decode(str.substring(iLastIndexOf + 2, iIndexOf));
                        if (str.startsWith("S.", iLastIndexOf)) {
                            extras.putString(strDecode2, strDecode);
                        } else if (str.startsWith("B.", iLastIndexOf)) {
                            extras.putBoolean(strDecode2, Boolean.parseBoolean(strDecode));
                        } else if (str.startsWith("b.", iLastIndexOf)) {
                            extras.putByte(strDecode2, Byte.parseByte(strDecode));
                        } else if (str.startsWith("c.", iLastIndexOf)) {
                            extras.putChar(strDecode2, strDecode.charAt(0));
                        } else if (str.startsWith("d.", iLastIndexOf)) {
                            extras.putDouble(strDecode2, Double.parseDouble(strDecode));
                        } else if (str.startsWith("f.", iLastIndexOf)) {
                            extras.putFloat(strDecode2, Float.parseFloat(strDecode));
                        } else if (str.startsWith("i.", iLastIndexOf)) {
                            extras.putInt(strDecode2, Integer.parseInt(strDecode));
                        } else if (str.startsWith("l.", iLastIndexOf)) {
                            extras.putLong(strDecode2, Long.parseLong(strDecode));
                        } else {
                            if (!str.startsWith("s.", iLastIndexOf)) {
                                throw new URISyntaxException(str, "unknown EXTRA type", iLastIndexOf);
                            }
                            extras.putShort(strDecode2, Short.parseShort(strDecode));
                        }
                    }
                    iLastIndexOf = iIndexOf2 + 1;
                }
            } catch (IndexOutOfBoundsException unused) {
                i = iLastIndexOf;
                throw new URISyntaxException(str, "illegal Intent URI format", i);
            }
        } catch (IndexOutOfBoundsException unused2) {
        }
    }

    private static boolean b() {
        try {
            if (f != null) {
                return f.booleanValue();
            }
            Boolean boolValueOf = Boolean.valueOf((!"Xiaomi".equalsIgnoreCase(com.igexin.push.core.e.G) && TextUtils.isEmpty(c(c)) && TextUtils.isEmpty(c("ro.miui.ui.version.code"))) ? false : true);
            f = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String c() {
        try {
            Field declaredField = BuildConfig.class.getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            return ((String) declaredField.get(null)).substring(4);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    private static Intent d(String str) throws URISyntaxException {
        boolean z;
        int i;
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(35);
        if (iLastIndexOf < 0) {
            return new Intent("android.intent.action.VIEW", Uri.parse(str));
        }
        int i2 = iLastIndexOf + 1;
        boolean z2 = true;
        if (str.regionMatches(i2, "action(", 0, 7)) {
            int i3 = i2 + 7;
            int iIndexOf = str.indexOf(41, i3);
            strSubstring = str.substring(i3, iIndexOf);
            i = iIndexOf + 1;
            z = true;
        } else {
            z = false;
            i = i2;
            strSubstring = null;
        }
        Intent intent = new Intent(strSubstring);
        int i4 = 33;
        if (str.regionMatches(i, "categories(", 0, 11)) {
            int i5 = i + 11;
            int iIndexOf2 = str.indexOf(41, i5);
            while (i5 < iIndexOf2) {
                int iIndexOf3 = str.indexOf(33, i5);
                if (iIndexOf3 < 0 || iIndexOf3 > iIndexOf2) {
                    iIndexOf3 = iIndexOf2;
                }
                if (i5 < iIndexOf3) {
                    intent.addCategory(str.substring(i5, iIndexOf3));
                }
                i5 = iIndexOf3 + 1;
            }
            i = iIndexOf2 + 1;
            z = true;
        }
        if (str.regionMatches(i, "type(", 0, 5)) {
            int i6 = i + 5;
            int iIndexOf4 = str.indexOf(41, i6);
            intent.setType(str.substring(i6, iIndexOf4));
            i = iIndexOf4 + 1;
            z = true;
        }
        if (str.regionMatches(i, "launchFlags(", 0, 12)) {
            int i7 = i + 12;
            int iIndexOf5 = str.indexOf(41, i7);
            intent.setFlags(Integer.decode(str.substring(i7, iIndexOf5)).intValue());
            intent.setFlags((~(67 | 128)) & intent.getFlags());
            i = iIndexOf5 + 1;
            z = true;
        }
        if (str.regionMatches(i, "component(", 0, 10)) {
            int i8 = i + 10;
            int iIndexOf6 = str.indexOf(41, i8);
            int iIndexOf7 = str.indexOf(33, i8);
            if (iIndexOf7 >= 0 && iIndexOf7 < iIndexOf6) {
                intent.setComponent(new ComponentName(str.substring(i8, iIndexOf7), str.substring(iIndexOf7 + 1, iIndexOf6)));
            }
            i = iIndexOf6 + 1;
            z = true;
        }
        if (str.regionMatches(i, "extras(", 0, 7)) {
            int i9 = i + 7;
            int iIndexOf8 = str.indexOf(41, i9);
            int i10 = -1;
            if (iIndexOf8 == -1) {
                throw new URISyntaxException(str, "EXTRA missing trailing ')'", i9);
            }
            if (intent.getExtras() == null) {
                intent.putExtras(new Bundle());
            }
            Bundle extras = intent.getExtras();
            while (i9 < iIndexOf8) {
                int iIndexOf9 = str.indexOf(61, i9);
                int i11 = i9 + 1;
                if (iIndexOf9 <= i11 || i9 >= iIndexOf8) {
                    throw new URISyntaxException(str, "EXTRA missing '='", i9);
                }
                char cCharAt = str.charAt(i9);
                String strSubstring2 = str.substring(i11, iIndexOf9);
                int i12 = iIndexOf9 + 1;
                int iIndexOf10 = str.indexOf(i4, i12);
                if (iIndexOf10 == i10 || iIndexOf10 >= iIndexOf8) {
                    iIndexOf10 = iIndexOf8;
                }
                if (i12 >= iIndexOf10) {
                    throw new URISyntaxException(str, "EXTRA missing '!'", i12);
                }
                String strSubstring3 = str.substring(i12, iIndexOf10);
                if (cCharAt == 'B') {
                    extras.putBoolean(strSubstring2, Boolean.parseBoolean(strSubstring3));
                } else if (cCharAt == 'S') {
                    extras.putString(strSubstring2, Uri.decode(strSubstring3));
                } else if (cCharAt == 'f') {
                    extras.putFloat(strSubstring2, Float.parseFloat(strSubstring3));
                } else if (cCharAt == 'i') {
                    extras.putInt(strSubstring2, Integer.parseInt(strSubstring3));
                } else if (cCharAt == 'l') {
                    extras.putLong(strSubstring2, Long.parseLong(strSubstring3));
                } else {
                    if (cCharAt != 's') {
                        switch (cCharAt) {
                            case 'b':
                                extras.putByte(strSubstring2, Byte.parseByte(strSubstring3));
                                break;
                            case 'c':
                                extras.putChar(strSubstring2, Uri.decode(strSubstring3).charAt(0));
                                break;
                            case 'd':
                                try {
                                    extras.putDouble(strSubstring2, Double.parseDouble(strSubstring3));
                                } catch (NumberFormatException unused) {
                                    throw new URISyntaxException(str, "EXTRA value can't be parsed", iIndexOf10);
                                }
                                break;
                            default:
                                throw new URISyntaxException(str, "EXTRA has unknown type", iIndexOf10);
                        }
                        throw new URISyntaxException(str, "EXTRA value can't be parsed", iIndexOf10);
                    }
                    extras.putShort(strSubstring2, Short.parseShort(strSubstring3));
                }
                char cCharAt2 = str.charAt(iIndexOf10);
                if (cCharAt2 == ')') {
                    intent.putExtras(extras);
                } else {
                    if (cCharAt2 != '!') {
                        throw new URISyntaxException(str, "EXTRA missing '!'", iIndexOf10);
                    }
                    i9 = iIndexOf10 + 1;
                    i10 = -1;
                    i4 = 33;
                }
            }
            intent.putExtras(extras);
        } else {
            z2 = z;
        }
        intent.setData(z2 ? Uri.parse(str.substring(0, iLastIndexOf)) : Uri.parse(str));
        if (intent.getAction() != null) {
            return intent;
        }
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public static Pair<ServiceInfo, Class> a(Context context, Class cls) {
        try {
            if (h == null) {
                h = context.getPackageManager().getPackageInfo(context.getPackageName(), Build.VERSION.SDK_INT >= 24 ? 516 : 4);
            }
            ServiceInfo[] serviceInfoArr = h.services;
            if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                int length = serviceInfoArr.length;
                for (int i = 0; i < length; i++) {
                    ServiceInfo serviceInfo = serviceInfoArr[i];
                    try {
                        Class<?> cls2 = Class.forName(serviceInfo.name);
                        if (cls2 != cls && cls.isAssignableFrom(cls2)) {
                            com.igexin.c.a.c.a.b("GT", cls.getSimpleName() + " child is " + cls2.getSimpleName());
                            return Pair.create(serviceInfo, cls2);
                        }
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            com.igexin.c.a.c.a.c.a().a(" findGtImplClassInManifest error = " + th2.toString());
        }
        return Pair.create(null, null);
    }

    public static boolean b(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null || !"vivo".equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
            Intent launchIntentForPackage = com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(com.igexin.push.core.e.l.getPackageName());
            if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
                return false;
            }
            int iIntValue = ((Integer) o.b(com.igexin.push.core.e.l, o.i, 0)).intValue();
            if (!z) {
                i += iIntValue;
            }
            o.a(com.igexin.push.core.e.l, o.i, Integer.valueOf(i));
            intent.putExtra(PushClientConstants.TAG_CLASS_NAME, launchIntentForPackage.getComponent().getClassName());
            intent.putExtra("notificationNum", i);
            intent.addFlags(16777216);
            com.igexin.push.core.e.l.sendBroadcast(intent);
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static String c(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
                return line;
            } catch (Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        com.igexin.c.a.c.a.a(e4);
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String a(Context context) {
        try {
            Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            return (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) ? "" : launchIntentForPackage.getComponent().getClassName();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(g)) {
                g = c();
                com.igexin.c.a.c.a.b("GT", " gtcVersion = " + g);
            }
            String[] strArrSplit = g.split("\\.");
            String[] strArrSplit2 = str.split("\\.");
            if (strArrSplit.length == 4 && strArrSplit2.length == 4) {
                for (int i = 0; i < 3; i++) {
                    int i2 = Integer.parseInt(strArrSplit2[i]);
                    int i3 = Integer.parseInt(strArrSplit[i]);
                    if (i3 != i2) {
                        return i3 < i2;
                    }
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    public static boolean c(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null || !"oppo".equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            int iIntValue = ((Integer) o.b(com.igexin.push.core.e.l, o.j, 0)).intValue();
            if (!z) {
                i += iIntValue;
            }
            o.a(com.igexin.push.core.e.l, o.j, Integer.valueOf(i));
            Intent intent = new Intent("com.oppo.unsettledevent");
            intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
            intent.putExtra(EventParams.KEY_PARAM_NUMBER, i);
            intent.putExtra("upgradeNumber", i);
            List<ResolveInfo> listQueryBroadcastReceivers = com.igexin.push.core.e.l.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                com.igexin.push.core.e.l.sendBroadcast(intent);
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i);
            com.igexin.push.core.e.l.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    public static String a(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(com.igexin.push.core.b.f7166a);
            if (TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(string + ".BuildConfig");
            return (String) cls.getField("GETUI_APPID").get(cls);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a("get cf error|" + e2.toString(), new Object[0]);
            return "";
        }
    }

    public static HashMap<String, Object> a() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - f7357a < 2000) {
                return b;
            }
            HashMap<String, Object> map = b;
            Boolean bool = Boolean.FALSE;
            map.put("isPause", bool);
            b.put("isTranslucent", bool);
            f7357a = jCurrentTimeMillis;
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Activity activity = null;
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return b;
            }
            Boolean boolValueOf = null;
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj);
                Field declaredField3 = cls2.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                boolean z = declaredField3.getBoolean(obj);
                boolValueOf = Boolean.valueOf(boolValueOf == null ? z : boolValueOf.booleanValue() && z);
                if (!z) {
                    activity = activity2;
                }
            }
            boolean z2 = activity != null ? activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent}).getBoolean(0, false) : false;
            b.put("isPause", Boolean.valueOf(Boolean.TRUE.equals(boolValueOf)));
            b.put("isTranslucent", Boolean.valueOf(z2));
            return b;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return b;
        }
    }

    public static synchronized boolean a(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null) {
                return false;
            }
            String str = com.igexin.push.core.e.G;
            if ("huawei".equalsIgnoreCase(str) || "honor".equalsIgnoreCase(str)) {
                int iIntValue = ((Integer) o.b(com.igexin.push.core.e.l, o.h, 0)).intValue();
                if (!z) {
                    i += iIntValue;
                }
                o.a(com.igexin.push.core.e.l, o.h, Integer.valueOf(i));
                Bundle bundle = new Bundle();
                bundle.putString("package", com.igexin.push.core.e.g);
                bundle.putString("class", a(com.igexin.push.core.e.l));
                bundle.putInt("badgenumber", i);
                Uri uri = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                Uri uri2 = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(com.igexin.push.core.e.l.getContentResolver().getType(uri))) {
                    uri = uri2;
                }
                com.igexin.push.core.e.l.getContentResolver().call(uri, "change_badge", (String) null, bundle);
                return true;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    public static boolean a(String... strArr) {
        for (int i = 0; i < 5; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                return true;
            }
        }
        return false;
    }
}
