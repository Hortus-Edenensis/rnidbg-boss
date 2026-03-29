package com.zenmen.media.camera;

import defpackage.pu1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CpuManager {
    public static boolean fileIsExists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getCpuCoreNum() throws Throwable {
        BufferedReader bufferedReader;
        FileReader fileReader;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str;
        String strTrim = "N/A";
        FileReader fileReader3 = null;
        try {
            try {
                if (fileIsExists("/sys/devices/system/cpu/kernel_max")) {
                    FileReader fileReader4 = new FileReader("/sys/devices/system/cpu/kernel_max");
                    try {
                        bufferedReader2 = new BufferedReader(fileReader4);
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileReader2 = fileReader4;
                        bufferedReader = null;
                    } catch (IOException e2) {
                        e = e2;
                        fileReader = fileReader4;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        fileReader3 = fileReader4;
                    }
                    try {
                        strTrim = bufferedReader2.readLine().trim();
                        bufferedReader2.close();
                        fileReader3 = fileReader4;
                        bufferedReader3 = bufferedReader2;
                        str = strTrim;
                    } catch (FileNotFoundException e3) {
                        fileReader2 = fileReader4;
                        bufferedReader = bufferedReader2;
                        e = e3;
                        fileReader3 = fileReader2;
                        e.printStackTrace();
                        pu1.u(fileReader3);
                        pu1.u(bufferedReader);
                        return strTrim;
                    } catch (IOException e4) {
                        fileReader = fileReader4;
                        bufferedReader = bufferedReader2;
                        e = e4;
                        fileReader3 = fileReader;
                        e.printStackTrace();
                        pu1.u(fileReader3);
                        pu1.u(bufferedReader);
                        return strTrim;
                    } catch (Throwable th2) {
                        fileReader3 = fileReader4;
                        bufferedReader = bufferedReader2;
                        th = th2;
                        pu1.u(fileReader3);
                        pu1.u(bufferedReader);
                        throw th;
                    }
                } else {
                    str = "0";
                    bufferedReader3 = null;
                }
                pu1.u(fileReader3);
                pu1.u(bufferedReader3);
                return str;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedReader = null;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static String getCpuName() throws Throwable {
        BufferedReader bufferedReader;
        FileReader fileReader;
        FileReader fileReader2;
        FileReader fileReader3 = null;
        try {
            try {
                if (!fileIsExists("/proc/cpuinfo")) {
                    pu1.u(null);
                    pu1.u(null);
                    return "0";
                }
                FileReader fileReader4 = new FileReader("/proc/cpuinfo");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader4);
                    try {
                        String[] strArrSplit = bufferedReader2.readLine().split(":\\s+", 2);
                        for (int i = 0; i < strArrSplit.length; i++) {
                        }
                        String str = strArrSplit[1];
                        pu1.u(fileReader4);
                        pu1.u(bufferedReader2);
                        return str;
                    } catch (FileNotFoundException e) {
                        bufferedReader = bufferedReader2;
                        e = e;
                        fileReader = fileReader4;
                    } catch (IOException e2) {
                        bufferedReader = bufferedReader2;
                        e = e2;
                        fileReader = fileReader4;
                        e.printStackTrace();
                        pu1.u(fileReader);
                        pu1.u(bufferedReader);
                        return null;
                    } catch (Throwable th) {
                        fileReader2 = fileReader4;
                        bufferedReader = bufferedReader2;
                        th = th;
                        fileReader3 = fileReader2;
                        pu1.u(fileReader3);
                        pu1.u(bufferedReader);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileReader = fileReader4;
                    bufferedReader = null;
                } catch (IOException e4) {
                    e = e4;
                    fileReader = fileReader4;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader2 = fileReader4;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileReader3 = fileReader;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedReader = null;
            fileReader = null;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        e.printStackTrace();
        pu1.u(fileReader);
        pu1.u(bufferedReader);
        return null;
    }

    public static String getCurCpuFreq() throws Throwable {
        BufferedReader bufferedReader;
        FileReader fileReader;
        FileReader fileReader2;
        FileReader fileReader3;
        BufferedReader bufferedReader2;
        String strTrim;
        FileReader fileReader4 = null;
        try {
            try {
                if (fileIsExists("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq")) {
                    FileReader fileReader5 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                    try {
                        BufferedReader bufferedReader3 = new BufferedReader(fileReader5);
                        try {
                            bufferedReader2 = bufferedReader3;
                            strTrim = bufferedReader3.readLine().trim();
                            fileReader4 = fileReader5;
                        } catch (FileNotFoundException e) {
                            fileReader3 = fileReader5;
                            bufferedReader = bufferedReader3;
                            e = e;
                            fileReader4 = fileReader3;
                            e.printStackTrace();
                            pu1.u(fileReader4);
                            pu1.u(bufferedReader);
                            return "N/A";
                        } catch (IOException e2) {
                            fileReader2 = fileReader5;
                            bufferedReader = bufferedReader3;
                            e = e2;
                            fileReader4 = fileReader2;
                            e.printStackTrace();
                            pu1.u(fileReader4);
                            pu1.u(bufferedReader);
                            return "N/A";
                        } catch (Throwable th) {
                            fileReader = fileReader5;
                            bufferedReader = bufferedReader3;
                            th = th;
                            fileReader4 = fileReader;
                            pu1.u(fileReader4);
                            pu1.u(bufferedReader);
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileReader3 = fileReader5;
                        bufferedReader = null;
                    } catch (IOException e4) {
                        e = e4;
                        fileReader2 = fileReader5;
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = fileReader5;
                        bufferedReader = null;
                    }
                } else {
                    strTrim = "0";
                    bufferedReader2 = null;
                }
                pu1.u(fileReader4);
                pu1.u(bufferedReader2);
                return strTrim;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedReader = null;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static String getMaxCpuFreq() throws Throwable {
        BufferedReader bufferedReader;
        String strTrim;
        FileReader fileReader;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        FileReader fileReader3 = null;
        try {
            String[] strArr = {"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"};
            if (fileIsExists("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq")) {
                InputStream inputStream = new ProcessBuilder(strArr).start().getInputStream();
                byte[] bArr = new byte[24];
                String str = "";
                while (inputStream.read(bArr) != -1) {
                    str = str + new String(bArr);
                }
                inputStream.close();
                if (str.equals("")) {
                    FileReader fileReader4 = new FileReader(strArr[1]);
                    try {
                        bufferedReader2 = new BufferedReader(fileReader4);
                    } catch (IOException e) {
                        e = e;
                        fileReader2 = fileReader4;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader4;
                        bufferedReader = null;
                    }
                    try {
                        bufferedReader = bufferedReader2;
                        strTrim = bufferedReader2.readLine().trim();
                        fileReader3 = fileReader4;
                    } catch (IOException e2) {
                        fileReader2 = fileReader4;
                        bufferedReader = bufferedReader2;
                        e = e2;
                        fileReader3 = fileReader2;
                        try {
                            e.printStackTrace();
                            strTrim = "N/A";
                        } catch (Throwable th2) {
                            th = th2;
                            pu1.u(fileReader3);
                            pu1.u(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        fileReader = fileReader4;
                        bufferedReader = bufferedReader2;
                        th = th3;
                        fileReader3 = fileReader;
                        pu1.u(fileReader3);
                        pu1.u(bufferedReader);
                        throw th;
                    }
                } else {
                    bufferedReader = null;
                    strTrim = str;
                }
            } else {
                strTrim = "0";
                bufferedReader = null;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        pu1.u(fileReader3);
        pu1.u(bufferedReader);
        return strTrim.trim();
    }

    public static String getMinCpuFreq() throws Throwable {
        BufferedReader bufferedReader;
        String str;
        FileReader fileReader;
        FileReader fileReader2;
        FileReader fileReader3 = null;
        try {
            String[] strArr = {"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"};
            if (fileIsExists("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq")) {
                InputStream inputStream = new ProcessBuilder(strArr).start().getInputStream();
                byte[] bArr = new byte[24];
                String str2 = "";
                while (inputStream.read(bArr) != -1) {
                    str2 = str2 + new String(bArr);
                }
                inputStream.close();
                if (str2.equals("")) {
                    FileReader fileReader4 = new FileReader(strArr[1]);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader4);
                        try {
                            String strTrim = bufferedReader2.readLine().trim();
                            bufferedReader2.close();
                            bufferedReader = bufferedReader2;
                            str = strTrim;
                            fileReader3 = fileReader4;
                        } catch (IOException e) {
                            fileReader2 = fileReader4;
                            bufferedReader = bufferedReader2;
                            e = e;
                            fileReader3 = fileReader2;
                            try {
                                e.printStackTrace();
                                str = "N/A";
                            } catch (Throwable th) {
                                th = th;
                                pu1.u(fileReader3);
                                pu1.u(bufferedReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            fileReader = fileReader4;
                            bufferedReader = bufferedReader2;
                            th = th2;
                            fileReader3 = fileReader;
                            pu1.u(fileReader3);
                            pu1.u(bufferedReader);
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileReader2 = fileReader4;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileReader = fileReader4;
                        bufferedReader = null;
                    }
                } else {
                    bufferedReader = null;
                    str = str2;
                }
            } else {
                str = "0";
                bufferedReader = null;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        pu1.u(fileReader3);
        pu1.u(bufferedReader);
        return str.trim();
    }
}
