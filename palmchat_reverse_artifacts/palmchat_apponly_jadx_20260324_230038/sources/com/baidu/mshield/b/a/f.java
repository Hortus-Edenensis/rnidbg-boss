package com.baidu.mshield.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4019a;
        public String b;
        public String c;

        public a(int i, String str, String str2) {
            this.f4019a = i;
            this.b = str;
            this.c = str2;
        }

        public String toString() {
            return "CommandResult{result=" + this.f4019a + ", successMsg='" + this.b + "', errorMsg='" + this.c + "'}";
        }
    }

    public static a a(String str, boolean z) {
        return a(new String[]{str}, z, true);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(7:140|7|(1:9)(1:10)|11|138|12|(5:142|13|(3:15|(2:17|148)(2:18|147)|19)|146|20))|(13:22|134|23|(9:136|24|25|(1:27)(1:149)|48|91|(2:129|93)|(1:97)|(1:99))|28|144|29|(1:31)|151|(5:32|(1:34)(1:150)|104|105|106)|35|(1:37)|38)(1:53)|125|54|(1:56)|(1:58)|104|105|106) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x014d, code lost:
    
        if (r10 == 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x014f, code lost:
    
        r9 = r11;
        r11 = r1;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f1, code lost:
    
        com.baidu.mshield.b.c.a.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x012a, code lost:
    
        if (r10 != 0) goto L103;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0177 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011e A[Catch: IOException -> 0x011a, TryCatch #0 {IOException -> 0x011a, blocks: (B:77:0x0116, B:81:0x011e, B:83:0x0123), top: B:123:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0123 A[Catch: IOException -> 0x011a, TRY_LEAVE, TryCatch #0 {IOException -> 0x011a, blocks: (B:77:0x0116, B:81:0x011e, B:83:0x0123), top: B:123:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0141 A[Catch: IOException -> 0x013d, TryCatch #13 {IOException -> 0x013d, blocks: (B:93:0x0139, B:97:0x0141, B:99:0x0146), top: B:129:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0146 A[Catch: IOException -> 0x013d, TRY_LEAVE, TryCatch #13 {IOException -> 0x013d, blocks: (B:93:0x0139, B:97:0x0141, B:99:0x0146), top: B:129:0x0139 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String[] strArr, boolean z, boolean z2) {
        String str;
        ?? r1;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        int i;
        String string;
        ?? r11;
        DataOutputStream dataOutputStream;
        Object obj;
        Object obj2;
        DataOutputStream dataOutputStream2 = null;
        String str2 = null;
        String str3 = null;
        BufferedReader bufferedReader3 = null;
        dataOutputStream2 = null;
        dataOutputStream2 = null;
        int iWaitFor = -1;
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    try {
                        z = Runtime.getRuntime().exec(z != 0 ? "su" : "sh");
                        try {
                            dataOutputStream = new DataOutputStream(z.getOutputStream());
                            try {
                                for (String str4 : strArr) {
                                    if (str4 != null) {
                                        dataOutputStream.write(str4.getBytes());
                                        dataOutputStream.writeBytes("\n");
                                        dataOutputStream.flush();
                                    }
                                }
                                dataOutputStream.writeBytes("exit\n");
                                dataOutputStream.flush();
                                iWaitFor = z.waitFor();
                            } catch (IOException e) {
                                e = e;
                                str = null;
                                bufferedReader = null;
                                bufferedReader2 = null;
                            } catch (Throwable th) {
                                th = th;
                                str = null;
                                bufferedReader = null;
                                bufferedReader2 = null;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            str = null;
                            r1 = 0;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            i = -1;
                            z = z;
                        } catch (Throwable th2) {
                            th = th2;
                            str = null;
                            r1 = 0;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            i = -1;
                            z = z;
                            com.baidu.mshield.b.c.a.a(th);
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        z = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        z = 0;
                    }
                    if (z2) {
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        bufferedReader = new BufferedReader(new InputStreamReader(z.getInputStream()));
                        try {
                            bufferedReader2 = new BufferedReader(new InputStreamReader(z.getErrorStream()));
                        } catch (IOException e4) {
                            e = e4;
                            str = null;
                            bufferedReader2 = null;
                            dataOutputStream2 = dataOutputStream;
                            i = iWaitFor;
                            r1 = bufferedReader2;
                            z = z;
                        } catch (Throwable th4) {
                            th = th4;
                            str = null;
                            bufferedReader2 = null;
                            dataOutputStream2 = dataOutputStream;
                            i = iWaitFor;
                            r1 = bufferedReader2;
                            z = z;
                            com.baidu.mshield.b.c.a.a(th);
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (IOException e5) {
                                    com.baidu.mshield.b.c.a.a(e5);
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                        }
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            } catch (IOException e6) {
                                e = e6;
                                obj2 = null;
                            } catch (Throwable th5) {
                                th = th5;
                                obj = null;
                            }
                            r1 = obj2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                            i = iWaitFor;
                            z = z;
                            com.baidu.mshield.b.c.a.a(e);
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (IOException e7) {
                                    com.baidu.mshield.b.c.a.a(e7);
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                        }
                        string = sb.toString();
                        try {
                            if (string.length() > 0) {
                                string = string.substring(0, string.length() - 1);
                            }
                        } catch (IOException e8) {
                            str2 = string;
                            e = e8;
                            obj2 = null;
                            r1 = obj2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                            i = iWaitFor;
                            z = z;
                            com.baidu.mshield.b.c.a.a(e);
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        } catch (Throwable th6) {
                            str3 = string;
                            th = th6;
                            obj = null;
                            r1 = obj;
                            str = str3;
                            dataOutputStream2 = dataOutputStream;
                            i = iWaitFor;
                            z = z;
                            com.baidu.mshield.b.c.a.a(th);
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        }
                        while (true) {
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null) {
                                break;
                            }
                            sb2.append(line2);
                            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            z.destroy();
                            i = iWaitFor;
                            r1 = r11;
                            str = string;
                            return new a(i, str, r1);
                        }
                        String string2 = sb2.toString();
                        if (string2.length() > 0) {
                            string2 = string2.substring(0, string2.length() - 1);
                        }
                        r11 = string2;
                        bufferedReader3 = bufferedReader;
                    } else {
                        string = null;
                        r11 = 0;
                        bufferedReader2 = null;
                    }
                    dataOutputStream.close();
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    z.destroy();
                    i = iWaitFor;
                    r1 = r11;
                    str = string;
                    return new a(i, str, r1);
                }
            } finally {
            }
        }
        return new a(-1, null, null);
    }
}
