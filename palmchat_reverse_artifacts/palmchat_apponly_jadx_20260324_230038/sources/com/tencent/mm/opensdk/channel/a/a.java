package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0890a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10645a;
        public String b;
        public String c;
        public long d;
        public Bundle e;
    }

    public static int a(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, i);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return i;
        }
    }

    public static Object a(int i, String str) {
        try {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
            return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0890a c0890a) {
        String str;
        String str2;
        if (context == null || c0890a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!b.b(c0890a.b)) {
                if (b.b(c0890a.f10645a)) {
                    str2 = null;
                } else {
                    str2 = c0890a.f10645a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0890a.b);
                Bundle bundle = c0890a.e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0890a.c);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0890a.d);
                intent.putExtra(ConstantsAPI.CHECK_SUM, a(c0890a.c, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x015b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:116:0x015b */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, int i) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? r8;
        ByteArrayOutputStream byteArrayOutputStream3;
        Object obj;
        ?? r3;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Exception e;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        IOException e2;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream3;
        MalformedURLException e3;
        HttpURLConnection httpURLConnection4;
        InputStream inputStream4;
        ByteArrayOutputStream byteArrayOutputStream4;
        ByteArrayOutputStream byteArrayOutputStream5;
        ByteArrayOutputStream byteArrayOutputStream6;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        HttpURLConnection httpURLConnection8;
        ByteArrayOutputStream byteArrayOutputStream7;
        ?? r2 = 0;
        if (str != null) {
            int length = str.length();
            try {
                if (length != 0) {
                    try {
                        httpURLConnection8 = (HttpURLConnection) new URL(str).openConnection();
                        try {
                        } catch (MalformedURLException e4) {
                            e3 = e4;
                            inputStream4 = null;
                            byteArrayOutputStream6 = null;
                            httpURLConnection7 = httpURLConnection8;
                        } catch (IOException e5) {
                            e2 = e5;
                            inputStream3 = null;
                            byteArrayOutputStream5 = null;
                            httpURLConnection6 = httpURLConnection8;
                        } catch (Exception e6) {
                            e = e6;
                            inputStream2 = null;
                            byteArrayOutputStream4 = null;
                            httpURLConnection5 = httpURLConnection8;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream3 = null;
                            r8 = httpURLConnection8;
                            if (r8 != 0) {
                            }
                            if (r2 != 0) {
                            }
                            if (byteArrayOutputStream3 == null) {
                            }
                        }
                    } catch (MalformedURLException e7) {
                        e3 = e7;
                        httpURLConnection4 = null;
                        inputStream4 = null;
                    } catch (IOException e8) {
                        e2 = e8;
                        httpURLConnection3 = null;
                        inputStream3 = null;
                    } catch (Exception e9) {
                        e = e9;
                        httpURLConnection2 = null;
                        inputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = null;
                        inputStream = null;
                    }
                    if (httpURLConnection8 == null) {
                        Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                        if (httpURLConnection8 != null) {
                            try {
                                httpURLConnection8.disconnect();
                            } catch (Throwable unused) {
                            }
                        }
                        return null;
                    }
                    try {
                        httpURLConnection8.setRequestMethod("GET");
                        httpURLConnection8.setConnectTimeout(i);
                        httpURLConnection8.setReadTimeout(i);
                        if (httpURLConnection8.getResponseCode() >= 300) {
                            Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                            try {
                                httpURLConnection8.disconnect();
                            } catch (Throwable unused2) {
                            }
                            return null;
                        }
                        InputStream inputStream5 = httpURLConnection8.getInputStream();
                        try {
                            byteArrayOutputStream7 = new ByteArrayOutputStream();
                        } catch (MalformedURLException e10) {
                            inputStream4 = inputStream5;
                            e3 = e10;
                            httpURLConnection4 = httpURLConnection8;
                            byteArrayOutputStream6 = null;
                            httpURLConnection7 = httpURLConnection4;
                        } catch (IOException e11) {
                            inputStream3 = inputStream5;
                            e2 = e11;
                            httpURLConnection3 = httpURLConnection8;
                            byteArrayOutputStream5 = null;
                            httpURLConnection6 = httpURLConnection3;
                            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                            if (httpURLConnection6 != null) {
                                try {
                                    httpURLConnection6.disconnect();
                                } catch (Throwable unused3) {
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            if (byteArrayOutputStream5 != null) {
                                try {
                                    byteArrayOutputStream5.close();
                                } catch (Throwable unused5) {
                                }
                            }
                            return null;
                        } catch (Exception e12) {
                            inputStream2 = inputStream5;
                            e = e12;
                            httpURLConnection2 = httpURLConnection8;
                            byteArrayOutputStream4 = null;
                            httpURLConnection5 = httpURLConnection2;
                            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                            if (httpURLConnection5 != null) {
                                try {
                                    httpURLConnection5.disconnect();
                                } catch (Throwable unused6) {
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable unused7) {
                                }
                            }
                            if (byteArrayOutputStream4 != null) {
                                try {
                                    byteArrayOutputStream4.close();
                                } catch (Throwable unused8) {
                                }
                            }
                            return null;
                        } catch (Throwable th3) {
                            inputStream = inputStream5;
                            th = th3;
                            httpURLConnection = httpURLConnection8;
                            r2 = inputStream;
                            byteArrayOutputStream3 = null;
                            r8 = httpURLConnection;
                            if (r8 != 0) {
                                try {
                                    r8.disconnect();
                                } catch (Throwable unused9) {
                                }
                            }
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (Throwable unused10) {
                                }
                            }
                            if (byteArrayOutputStream3 == null) {
                                throw th;
                            }
                            try {
                                byteArrayOutputStream3.close();
                                throw th;
                            } catch (Throwable unused11) {
                                throw th;
                            }
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i2 = inputStream5.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream7.write(bArr, 0, i2);
                            }
                            byte[] byteArray = byteArrayOutputStream7.toByteArray();
                            Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                            try {
                                httpURLConnection8.disconnect();
                            } catch (Throwable unused12) {
                            }
                            try {
                                inputStream5.close();
                            } catch (Throwable unused13) {
                            }
                            try {
                                byteArrayOutputStream7.close();
                            } catch (Throwable unused14) {
                            }
                            return byteArray;
                        } catch (MalformedURLException e13) {
                            inputStream4 = inputStream5;
                            e3 = e13;
                            byteArrayOutputStream6 = byteArrayOutputStream7;
                            httpURLConnection7 = httpURLConnection8;
                        } catch (IOException e14) {
                            inputStream3 = inputStream5;
                            e2 = e14;
                            byteArrayOutputStream5 = byteArrayOutputStream7;
                            httpURLConnection6 = httpURLConnection8;
                            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                            if (httpURLConnection6 != null) {
                            }
                            if (inputStream3 != null) {
                            }
                            if (byteArrayOutputStream5 != null) {
                            }
                            return null;
                        } catch (Exception e15) {
                            inputStream2 = inputStream5;
                            e = e15;
                            byteArrayOutputStream4 = byteArrayOutputStream7;
                            httpURLConnection5 = httpURLConnection8;
                            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                            if (httpURLConnection5 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            if (byteArrayOutputStream4 != null) {
                            }
                            return null;
                        } catch (Throwable th4) {
                            byteArrayOutputStream2 = byteArrayOutputStream7;
                            r3 = inputStream5;
                            th = th4;
                            obj = httpURLConnection8;
                            byteArrayOutputStream3 = byteArrayOutputStream2;
                            r2 = r3;
                            r8 = obj;
                            if (r8 != 0) {
                            }
                            if (r2 != 0) {
                            }
                            if (byteArrayOutputStream3 == null) {
                            }
                        }
                    } catch (MalformedURLException e16) {
                        e3 = e16;
                        inputStream4 = null;
                        httpURLConnection4 = httpURLConnection8;
                    } catch (IOException e17) {
                        e2 = e17;
                        inputStream3 = null;
                        httpURLConnection3 = httpURLConnection8;
                    } catch (Exception e18) {
                        e = e18;
                        inputStream2 = null;
                        httpURLConnection2 = httpURLConnection8;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                        httpURLConnection = httpURLConnection8;
                    }
                    byteArrayOutputStream6 = null;
                    httpURLConnection7 = httpURLConnection4;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                    if (httpURLConnection7 != null) {
                        try {
                            httpURLConnection7.disconnect();
                        } catch (Throwable unused15) {
                        }
                    }
                    if (inputStream4 != null) {
                        try {
                            inputStream4.close();
                        } catch (Throwable unused16) {
                        }
                    }
                    if (byteArrayOutputStream6 != null) {
                        try {
                            byteArrayOutputStream6.close();
                        } catch (Throwable unused17) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream2 = byteArrayOutputStream;
                r3 = length;
                obj = str;
            }
        }
        Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        return null;
    }

    public static byte[] a(String str, int i, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i2 = 0;
            for (byte b : bArrDigest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
