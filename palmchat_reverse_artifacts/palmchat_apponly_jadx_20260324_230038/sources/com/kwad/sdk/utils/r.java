package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.tide.protocol.util.TdFileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class r {
    public static com.kwad.sdk.l.a.d bdW;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.kwad.sdk.l.a.a {
        public a() {
            RG();
        }

        private void RG() {
            ArrayList arrayList = new ArrayList();
            this.bbC = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.a.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    String str = Build.PRODUCT;
                    int i = (str.contains(com.umeng.ccg.a.x) || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals(com.umeng.ccg.a.x) || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i++;
                    }
                    try {
                        if (!bc.useStoragePermissionDisable()) {
                            if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                                i += 10;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return i > 3;
                }
            });
            this.bbC.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.a.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    return "1".equals(bq.get("ro.kernel.qemu"));
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends com.kwad.sdk.l.a.a {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends com.kwad.sdk.l.a.a {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends com.kwad.sdk.l.a.a {
        public d() {
            RG();
        }

        private void RG() {
            ArrayList arrayList = new ArrayList();
            this.bbC = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.bbC.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + "su").exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.bbC.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    return !TextUtils.isEmpty(r.g(new String[]{"/system/xbin/which", "su"}));
                }
            });
            this.bbC.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.4
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    Charset charsetForName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        w.a(file, com.igexin.push.core.b.B, charsetForName, false);
                        return w.a(file, charsetForName).equals(com.igexin.push.core.b.B);
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends com.kwad.sdk.l.a.a {
        public e() {
            RG();
        }

        private void RG() {
            ArrayList arrayList = new ArrayList();
            this.bbC = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    return as.as(context, "de.robv.android.xposed.installer") || as.as(context, "com.saurik.substrate");
                }
            });
            this.bbC.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e) {
                        boolean z = false;
                        int i = 0;
                        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i = i + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.bbC.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean cv(Context context) throws Throwable {
                    FileReader fileReader;
                    HashSet<String> hashSet;
                    BufferedReader bufferedReader;
                    boolean z = false;
                    BufferedReader bufferedReader2 = null;
                    try {
                        hashSet = new HashSet();
                        fileReader = new FileReader(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/maps");
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception unused2) {
                        fileReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = null;
                    }
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.endsWith(Constants.LIBRARY_SUFFIX) || line.endsWith(TdFileUtils.PLUGIN_FILE_TAIL)) {
                                hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                            }
                        } catch (Exception unused3) {
                            bufferedReader2 = bufferedReader;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader2 = bufferedReader;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                            throw th;
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                        return z;
                    }
                    for (String str : hashSet) {
                        if (str.contains("com.saurik.substrate")) {
                            Log.wtf("HookDetection", "Substrate shared object found: " + str);
                            z = true;
                        }
                        if (str.contains("XposedBridge.jar")) {
                            Log.wtf("HookDetection", "Xposed JAR found: " + str);
                            z = true;
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.l.a.d RF() {
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dh()) {
            return null;
        }
        com.kwad.sdk.l.a.d dVar = bdW;
        if (dVar != null) {
            return dVar;
        }
        Context applicationContext = ServiceProvider.getContext().getApplicationContext();
        com.kwad.sdk.l.a.d dVar2 = new com.kwad.sdk.l.a.d(applicationContext);
        boolean zCu = new d().cu(applicationContext);
        boolean zCu2 = new e().cu(applicationContext);
        boolean zCu3 = new b().cu(applicationContext);
        boolean zCu4 = new a().cu(applicationContext);
        boolean zCu5 = new c().cu(applicationContext);
        dVar2.bX(zCu);
        dVar2.bY(zCu2);
        dVar2.bZ(zCu3);
        dVar2.cb(zCu4);
        dVar2.cc(zCu5);
        bdW = dVar2;
        return dVar2;
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
