package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0069 A[Catch: Exception -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x006d, blocks: (B:23:0x003d, B:46:0x0069), top: B:76:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x006e -> B:75:0x0071). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        File fileC = c(context);
        StringBuilder sb = new StringBuilder();
        if (fileC == null || !fileC.exists()) {
            return "";
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileC);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                sb.append(line);
                            } else {
                                try {
                                    break;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != 0) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return sb.toString();
                            } finally {
                            }
                        }
                    }
                    bufferedReader.close();
                    try {
                        inputStreamReader.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    fileInputStream.close();
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                th = th;
                inputStreamReader = bufferedReader;
                th.printStackTrace();
                if (bufferedReader != null) {
                }
                if (inputStreamReader != 0) {
                }
                if (fileInputStream != null) {
                }
                return sb.toString();
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            bufferedReader = null;
        }
        return sb.toString();
    }

    private static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File file = new File(context.getFilesDir() + "/eAccount/Log/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "ipa_ol.ds");
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static File c(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir() + "/eAccount/Log/");
                if (!file.exists()) {
                    return null;
                }
                File file2 = new File(file, "ipa_ol.ds");
                if (file2.exists()) {
                    return file2;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void a(Context context, String str) throws Throwable {
        File fileC = c(context);
        if (fileC == null || !fileC.exists()) {
            a(b(context), str);
        } else {
            a(fileC, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x004f -> B:52:0x0069). Please report as a decompilation issue!!! */
    private static void a(File file, String str) throws Throwable {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        if (file == null || !file.exists()) {
            return;
        }
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            try {
                try {
                    fileWriter = new FileWriter(file, false);
                    try {
                        bufferedWriter = new BufferedWriter(fileWriter);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    r0 = r0;
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
            } catch (Throwable th) {
                th = th;
                fileWriter = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            boolean zIsEmpty = TextUtils.isEmpty(str);
            if (zIsEmpty) {
                str = "";
            }
            bufferedWriter.write(str);
            bufferedWriter.flush();
            try {
                bufferedWriter.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            fileWriter.close();
            r0 = zIsEmpty;
        } catch (Exception e5) {
            e = e5;
            r0 = bufferedWriter;
            e.printStackTrace();
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            if (fileWriter != null) {
                fileWriter.close();
                r0 = r0;
            }
        } catch (Throwable th3) {
            th = th3;
            r0 = bufferedWriter;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            if (fileWriter == null) {
                throw th;
            }
            try {
                fileWriter.close();
                throw th;
            } catch (Exception e8) {
                e8.printStackTrace();
                throw th;
            }
        }
    }
}
