package com.zenmen.palmchat.modulemanager;

import android.util.Pair;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zn6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class InitExceptionHelper {
    public static final String KEY_ACTION = "InitException";
    public static final String TAG = "LXINIT_ExceptionHelper";
    public static final String TYPE_ATTACH = "TYPE_ATTACH";
    public static final String TYPE_CONTACT_REGISTERCONTENTOBSERVER = "TYPE_CONTACT_REGISTERCONTENTOBSERVER";
    public static final String TYPE_DH_INIT = "TYPE_DH_INIT";
    public static final String TYPE_LIFE_CIRCLE = "TYPE_LIFE_CIRCLE";
    public static final String TYPE_MODULE_ASYNCEXECUTE = "TYPE_MODULE_ASYNCEXECUTE";
    public static final String TYPE_MODULE_ATTACH = "TYPE_MODULE_ATTACH";
    public static final String TYPE_MODULE_CREATE = "TYPE_MODULE_CREATE";
    public static final String TYPE_MODULE_ONLOGIN = "TYPE_MODULE_LOGIN";
    public static final String TYPE_MODULE_ONLOGOUT = "TYPE_MODULE_ONLOGOUT";
    public static final String TYPE_MODULE_ONMAINUIREADY = "TYPE_MODULE_ONMAINUIREADY";
    public static final String TYPE_MODULE_ONMOVE2BACKGROUND = "TYPE_MODULE_ONMOVE2BACKGROUND";
    public static final String TYPE_MODULE_ONMOVE2FRONT = "TYPE_MODULE_ONMOVE2FRONT";
    public static final String TYPE_MODULE_ONNETAVAILABLE = "TYPE_MODULE_ONMAINUIREADY";
    public static final String TYPE_ONCREATE = "TYPE_ONCREATE";
    public static final String TYPE_ONCREATE_1 = "TYPE_ONCREATE_1";
    public static final String TYPE_ONCREATE_2 = "TYPE_ONCREATE_2";
    public static CopyOnWriteArrayList<ExceptionInfo> currentExceptionInfo = new CopyOnWriteArrayList<>();
    private static boolean isAppOnCreate = false;
    public static final boolean isTest = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class ExceptionInfo {
        public Throwable e;
        public String type;

        public ExceptionInfo(String str, Throwable th) {
            this.type = str;
            this.e = th;
        }
    }

    public static void checkAndUploadException() {
        isAppOnCreate = true;
        if (currentExceptionInfo.size() > 0) {
            try {
                Pair<String, String> pairGenCrashInfo = genCrashInfo();
                LogUtil.e(TAG, "info=" + pairGenCrashInfo);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("crashType", pairGenCrashInfo.first);
                jSONObject.put("info", pairGenCrashInfo.second);
                zn6.d("lx_init_crash", null, jSONObject.toString());
                HashMap map = new HashMap();
                map.put("action", KEY_ACTION);
                map.put("crashType", pairGenCrashInfo.first);
                map.put("info", pairGenCrashInfo.second);
                LogUtil.i("InitExceptionHelper", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map, (Throwable) null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            currentExceptionInfo.clear();
        }
    }

    private static Pair<String, String> genCrashInfo() {
        JSONArray jSONArray = new JSONArray();
        String str = "";
        for (ExceptionInfo exceptionInfo : currentExceptionInfo) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", exceptionInfo.type);
                jSONObject.put("ex", getExceptionString(exceptionInfo.e));
                jSONArray.put(jSONObject);
                str = str + exceptionInfo.type;
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
        return new Pair<>(str, jSONArray.toString());
    }

    private static String getExceptionString(Throwable th) throws IOException {
        if (th == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toString();
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
            throw th2;
        }
    }

    public static void onException(String str, Throwable th) {
        currentExceptionInfo.add(new ExceptionInfo(str, th));
        if (isAppOnCreate) {
            checkAndUploadException();
        }
    }

    public static void triggerCrash() {
    }
}
