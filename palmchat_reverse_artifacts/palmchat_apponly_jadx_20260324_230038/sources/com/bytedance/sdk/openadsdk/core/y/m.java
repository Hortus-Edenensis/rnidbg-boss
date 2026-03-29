package com.bytedance.sdk.openadsdk.core.y;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class m {
    private static String u;

    public static String nr(String str) {
        try {
            if (!u()) {
                return str;
            }
            String strMh = com.bytedance.sdk.openadsdk.core.n.o().mh();
            return TextUtils.isEmpty(strMh) ? str : Uri.parse(str).buildUpon().appendQueryParameter(nr(), strMh).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(String str) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            File file = new File("data/data/com.union_test.toutiao/" + str);
            if (!file.exists()) {
                return null;
            }
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (Exception unused) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (bufferedReader == null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (Throwable unused3) {
                            throw th;
                        }
                    }
                }
                String string = sb.toString();
                try {
                    fileReader2.close();
                } catch (Throwable unused4) {
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
                return string;
            } catch (Exception unused6) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Exception unused7) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (Throwable unused8) {
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused9) {
            }
        }
        return sb.toString();
    }

    public static String nr() {
        if (TextUtils.isEmpty(u)) {
            u = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return u;
    }

    public static boolean u() {
        if (com.bytedance.sdk.component.utils.k.fx()) {
            return com.bytedance.sdk.openadsdk.core.n.o().tk();
        }
        return false;
    }

    public static String u(String str, String str2) {
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static void u(Map<String, String> map) {
        if (u()) {
            map.put("x-app-id", "5001121");
            String strMh = com.bytedance.sdk.openadsdk.core.n.o().mh();
            if (TextUtils.isEmpty(strMh)) {
                return;
            }
            map.put("x-device-id", strMh);
        }
    }
}
