package com.tide.host.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.context.base.IResource;
import com.tide.protocol.host.IDexLoaderManager;
import com.tide.protocol.host.IPluginLoader;
import com.tide.protocol.host.model.PluginEvent;
import com.tide.protocol.host.model.PluginEventType;
import com.tide.protocol.host.model.PluginState;
import com.tide.protocol.plugin.base.ITideApplication;
import com.tide.protocol.transfer.TideEventBus;
import com.tide.protocol.util.TdFileUtils;
import com.tide.protocol.util.TdLogUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class u implements IPluginLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f10800a;
    public h b;
    public final Context c;
    public final String d;
    public final String e;
    public b g;
    public ITideApplication k;
    public String h = "";
    public final Object i = new Object();
    public volatile int j = 0;
    public volatile PluginState f = PluginState.NOT_LOADED;

    public u(Context context, String str, String str2) {
        this.d = str;
        this.c = context.getApplicationContext();
        this.e = str2;
    }

    public final void d(final CountDownLatch countDownLatch) {
        new Thread(new Runnable() { // from class: zk7
            @Override // java.lang.Runnable
            public final void run() {
                this.f22442a.b(countDownLatch);
            }
        }).start();
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final ITideApplication getCoreApp() {
        return this.k;
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final IDexLoaderManager getDexLoaderManager() {
        return this.b;
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final String getPluginName() {
        return this.e;
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final String getPluginPath() {
        return this.d;
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final PluginState getPluginState() {
        return this.f;
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final IResource getResourceManager() {
        return this.f10800a;
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final ITideApplication initPlugin() {
        try {
            b bVar = this.g;
            if (bVar == null || TextUtils.isEmpty(bVar.f10783a)) {
                TdLogUtils.error("PluginLoader", "initPlugin fail cause enterClass is null");
            } else {
                Class<?> clsLoadClass = this.b.getDexClassLoader().loadClass(this.g.f10783a);
                if (clsLoadClass != null) {
                    Object objNewInstance = clsLoadClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (objNewInstance instanceof ITideApplication) {
                        ITideApplication iTideApplication = (ITideApplication) objNewInstance;
                        this.k = iTideApplication;
                        iTideApplication.setPluginName(this.e);
                        ITideApplication iTideApplication2 = this.k;
                        b bVar2 = this.g;
                        iTideApplication2.addComponent(bVar2.b, bVar2.c);
                        this.f = PluginState.RUNNING;
                        return this.k;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final void preLoadPlugin() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        this.h = TideWholeConfig.getInstance().getPluginFrom(this.e);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.e;
        e0.a().onEvent("td_install_start", str, new i0(TideWholeConfig.getInstance().getPluginVersionCode(this.e), str, this.h).b);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        c(countDownLatch);
        d(countDownLatch);
        try {
            countDownLatch.await();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (this.f != PluginState.LOAD_FAILED) {
                this.f = PluginState.LOADED;
                String str2 = this.e;
                e0.a().onEvent("td_install_result", str2, new i0(TideWholeConfig.getInstance().getPluginVersionCode(this.e), 1, -1, jCurrentTimeMillis2, str2, this.h).b);
            } else {
                int i = this.j == 1 ? 15001 : this.j == 2 ? 15002 : this.j == 3 ? 15004 : -1;
                TideEventBus.publish(new PluginEvent(PluginEventType.LOAD_FAILED, this.e));
                String str3 = this.e;
                e0.a().onEvent("td_install_result", str3, new i0(TideWholeConfig.getInstance().getPluginVersionCode(this.e), 0, i, jCurrentTimeMillis2, str3, this.h).b);
            }
        } finally {
            Thread.currentThread().interrupt();
            TideEventBus.publish(new PluginEvent(PluginEventType.LOAD_FAILED, this.e));
            String str4 = this.e;
            e0.a().onEvent("td_install_result", str4, new i0(TideWholeConfig.getInstance().getPluginVersionCode(this.e), 0, 15003, System.currentTimeMillis() - jCurrentTimeMillis, str4, this.h).b);
            Object obj = this.i;
        }
    }

    @Override // com.tide.protocol.host.IPluginLoader
    public final void setPluginState(PluginState pluginState) {
        this.f = pluginState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CountDownLatch countDownLatch) {
        try {
            try {
                a();
            } finally {
                this.j += 2;
                Object obj = this.i;
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public final void a(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START);
        b bVar = null;
        str = null;
        String str2 = null;
        if (packageArchiveInfo != null) {
            try {
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                if (applicationInfo != null) {
                    str2 = applicationInfo.name;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = packageArchiveInfo.applicationInfo.className;
                    }
                }
            } catch (Throwable unused) {
            }
            HashMap map = new HashMap();
            ActivityInfo[] activityInfoArr = packageArchiveInfo.activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    Bundle bundle = activityInfo.metaData;
                    if (bundle != null) {
                        Iterator<String> it = bundle.keySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                String next = it.next();
                                if (TextUtils.equals(next, "PROXY_COMPONENT")) {
                                    Object obj = bundle.get(next);
                                    if (obj instanceof String) {
                                        map.put(activityInfo.name, (String) obj);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            HashMap map2 = new HashMap();
            ServiceInfo[] serviceInfoArr = packageArchiveInfo.services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    Bundle bundle2 = serviceInfo.metaData;
                    if (bundle2 != null) {
                        Iterator<String> it2 = bundle2.keySet().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                String next2 = it2.next();
                                if (TextUtils.equals(next2, "PROXY_COMPONENT")) {
                                    Object obj2 = bundle2.get(next2);
                                    if (obj2 instanceof String) {
                                        map2.put(serviceInfo.name, (String) obj2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            TdLogUtils.log("ApkInfoExtractor", "activityMap:" + map + "serviceMap:" + map2);
            bVar = new b(str2, map, map2);
        }
        this.g = bVar;
    }

    public final void c(final CountDownLatch countDownLatch) {
        new Thread(new Runnable() { // from class: al7
            @Override // java.lang.Runnable
            public final void run() {
                this.f1251a.a(countDownLatch);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = this.c;
        String str = this.e;
        if (context != null && !TextUtils.isEmpty(str)) {
            int pluginVersionCodeFromPluginInfo = TideWholeConfig.getInstance().getPluginVersionCodeFromPluginInfo(str);
            String pluginBaseDir = TdFileUtils.getPluginBaseDir(context, str);
            if (TextUtils.isEmpty(pluginBaseDir)) {
                TdLogUtils.error("FileUtils", "cleanUpOldPluginDirectories pluginBaseDir is empty");
                return;
            }
            File file = new File(pluginBaseDir);
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                int i = p0.a(context, "plugin_version_prepared") ? -1 : context.getSharedPreferences(str, 0).getInt("plugin_version_prepared", -1);
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.isDirectory()) {
                            try {
                                int i2 = Integer.parseInt(file2.getName());
                                if (i2 != pluginVersionCodeFromPluginInfo && i2 != i) {
                                    if (m.a(file2)) {
                                        TdLogUtils.log("FileUtils", "Deleted old plugin directory: " + file2.getAbsolutePath());
                                    } else {
                                        TdLogUtils.error("FileUtils", "Failed to delete directory: " + file2.getAbsolutePath());
                                    }
                                }
                            } catch (Throwable unused) {
                                TdLogUtils.error("FileUtils", "Invalid directory name (not a version number): " + file2.getName());
                            }
                        }
                    }
                    return;
                }
                TdLogUtils.error("FileUtils", "No version directories found in: " + pluginBaseDir);
                return;
            }
            TdLogUtils.error("FileUtils", "Base directory does not exist or is not a directory: " + pluginBaseDir);
            return;
        }
        TdLogUtils.error("FileUtils", "cleanUpOldPluginDirectories context or pluginName is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CountDownLatch countDownLatch) {
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                a(this.c, this.d);
                TdLogUtils.log("耗时分析", "findComponent 解析manifest.xml " + (System.currentTimeMillis() - jCurrentTimeMillis) + " milliseconds.");
            } finally {
                countDownLatch.countDown();
            }
        } finally {
            this.j++;
            Object obj = this.i;
        }
    }

    public final void a() throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context context = this.c;
        a0 a0Var = new a0(context);
        this.f10800a = a0Var;
        String str = this.d;
        try {
            a0Var.f10782a = (AssetManager) AssetManager.class.newInstance();
            Object objInvoke = AssetManager.class.getMethod("addAssetPath", String.class).invoke(a0Var.f10782a, str);
            if (objInvoke instanceof Integer) {
                if (((Integer) objInvoke).intValue() != 0) {
                    TdLogUtils.log("ResourceManager", "Success to add asset path: " + str);
                } else {
                    TdLogUtils.error("ResourceManager", "Failed to add asset path: " + str);
                    throw new Exception("Failed to add asset path");
                }
            }
            Resources resources = context.getResources();
            Resources resources2 = new Resources(a0Var.f10782a, resources.getDisplayMetrics(), resources.getConfiguration());
            a0Var.b = resources2;
            Resources.Theme themeNewTheme = resources2.newTheme();
            a0Var.c = themeNewTheme;
            themeNewTheme.setTo(context.getTheme());
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            TdLogUtils.log("耗时分析", "initializeManagers 资源加载 " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " milliseconds.");
            try {
                TdLogUtils.log("PluginLoader", "dealWithOsVUpdate 执行删除校验操作");
                if (n.f10795a) {
                    String strA = n.a();
                    if (!TextUtils.isEmpty(strA)) {
                        Context context2 = this.c;
                        String string = "";
                        if (!p0.a(context2, "hosv")) {
                            string = context2.getSharedPreferences("td_host_sp_name", 0).getString("hosv", "");
                        }
                        if (!strA.equals(string)) {
                            TdLogUtils.log("PluginLoader", "dealWithOsVUpdate 系统升级了 执行删除操作");
                            TdFileUtils.deleteOatFolder(this.d);
                            TdFileUtils.deleteDirectoryContents(TdFileUtils.getDexOutputDir(this.c, this.e));
                            TdLogUtils.log("PluginLoader", "oat and is  odex delete successful  ");
                            Context context3 = this.c;
                            if (!p0.a(context3, "hosv")) {
                                SharedPreferences.Editor editorEdit = context3.getSharedPreferences("td_host_sp_name", 0).edit();
                                editorEdit.putString("hosv", strA);
                                editorEdit.commit();
                            }
                        }
                    } else {
                        TdLogUtils.log("PluginLoader", "dealWithOsVUpdate 旧鸿蒙系统版本 harmonyVersion为空");
                    }
                }
                int iA = g.a();
                Context context4 = this.c;
                int i = -1;
                if (!p0.a(context4, "osv")) {
                    i = context4.getSharedPreferences("td_host_sp_name", 0).getInt("osv", -1);
                }
                TdLogUtils.log("PluginLoader", "dealWithOsVUpdate 旧系统版本 " + i + " 当前系统版本 " + iA);
                if (iA != i) {
                    TdLogUtils.log("PluginLoader", "dealWithOsVUpdate 系统升级了 执行删除操作");
                    TdFileUtils.deleteOatFolder(this.d);
                    TdFileUtils.deleteDirectoryContents(TdFileUtils.getDexOutputDir(this.c, this.e));
                    TdLogUtils.log("PluginLoader", "oat and is  odex delete successful  ");
                    Context context5 = this.c;
                    if (!p0.a(context5, "osv")) {
                        SharedPreferences.Editor editorEdit2 = context5.getSharedPreferences("td_host_sp_name", 0).edit();
                        editorEdit2.putInt("osv", iA);
                        editorEdit2.commit();
                    }
                }
            } catch (Throwable th) {
                TdLogUtils.error("PluginLoader", "dealWithOsVUpdate" + th.getMessage());
            }
            Runnable runnable = new Runnable() { // from class: bl7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1749a.b();
                }
            };
            AtomicInteger atomicInteger = v0.b;
            u0.f10801a.f10803a.execute(runnable);
            this.b = new h(this.c, this.d, this.e);
            TdLogUtils.log("耗时分析", "initializeManagers dex加载 " + (System.currentTimeMillis() - jCurrentTimeMillis2) + " milliseconds.");
        } catch (Throwable th2) {
            th2.printStackTrace();
            throw new Exception("initResources failed " + th2.getMessage());
        }
    }
}
