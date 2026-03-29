package com.tide.host.a;

import android.content.Context;
import android.text.TextUtils;
import com.tide.protocol.host.model.PluginInfo;
import com.tide.protocol.util.TdFileUtils;
import com.tide.protocol.util.TdLogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class g0 {
    public static PluginInfo a(Context context, InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            TdLogUtils.log("TdFileController", "Input stream is empty or plugin name is empty, return!");
            return null;
        }
        try {
            String strA = q0.a(inputStream);
            if (TextUtils.isEmpty(strA)) {
                TdLogUtils.error("TdFileController", "String from input stream is empty, return!");
                return null;
            }
            PluginInfo pluginInfoA = q0.a(strA);
            if (pluginInfoA == null) {
                TdLogUtils.error("TdFileController", "Plugin info from string is empty, return!");
                return null;
            }
            String privatePluginPath = TdFileUtils.getPrivatePluginPath(context, String.valueOf(pluginInfoA.getPluginVCode()), pluginInfoA.getPluginName());
            if (TextUtils.isEmpty(privatePluginPath)) {
                TdLogUtils.error("TdFileController", "Plugin target path creation failed, return!");
                return null;
            }
            TdLogUtils.log("TdFileController", "Plugin target path: " + privatePluginPath);
            pluginInfoA.setPluginPath(privatePluginPath);
            return pluginInfoA;
        } catch (Throwable th) {
            TdLogUtils.error("TdFileController", "Error processing input stream: " + th.getMessage());
            return null;
        }
    }

    public static boolean a(InputStream inputStream, String str) {
        File file;
        File parentFile;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        if (!TextUtils.isEmpty(str) && (parentFile = (file = new File(str)).getParentFile()) != null && (parentFile.exists() || parentFile.mkdirs())) {
            if (file.exists() && !file.delete()) {
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    bArr = new byte[1024];
                } finally {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.flush();
                    file.setReadOnly();
                    fileOutputStream.close();
                    return true;
                }
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(PluginInfo pluginInfo) {
        String str;
        int i;
        TdLogUtils.log("TdFileController", "校验插件开始");
        if (pluginInfo == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String pluginName = pluginInfo.getPluginName();
        e0.a().onEvent("td_verify_start", pluginName, new i0(pluginInfo.getPluginVCode(), pluginName, pluginInfo.getPluginFrom()).b);
        String pluginPath = pluginInfo.getPluginPath();
        if (!TdFileUtils.isFileExist(pluginPath)) {
            i = 12001;
            str = "verify file is not exist";
        } else if (c0.a(pluginPath, pluginInfo.getMd5())) {
            str = "file is valid!";
            i = 1;
        } else {
            str = "verify file md5 is wrong";
            TdLogUtils.error("TdFileController", "verify file md5 is wrong");
            TdFileUtils.deleteFile(pluginPath);
            i = 12002;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (i == 1) {
            String pluginName2 = pluginInfo.getPluginName();
            e0.a().onEvent("td_verify_result", pluginName2, new i0(pluginInfo.getPluginVCode(), 1, -1, jCurrentTimeMillis2, pluginName2, pluginInfo.getPluginFrom()).b);
        } else {
            String pluginName3 = pluginInfo.getPluginName();
            e0.a().onEvent("td_verify_result", pluginName3, new i0(pluginInfo.getPluginVCode(), 0, i, jCurrentTimeMillis2, pluginName3, pluginInfo.getPluginFrom()).b);
            TdLogUtils.log("TdFileController", str);
        }
        return i == 1;
    }
}
