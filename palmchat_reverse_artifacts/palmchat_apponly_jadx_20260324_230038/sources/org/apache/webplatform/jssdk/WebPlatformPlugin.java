package org.apache.webplatform.jssdk;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import androidx.media3.common.C;
import com.baidu.location.LocationConst;
import com.huawei.openalliance.ad.constant.az;
import com.kuaishou.weapon.p0.g;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.framework.modulebadge.ModuleBadgeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.ApkDownloadManager;
import com.zenmen.palmchat.webplatform.TransparentLyWebActivity;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import com.zenmen.palmchat.webplatform.b;
import defpackage.an1;
import defpackage.ap3;
import defpackage.b05;
import defpackage.eh;
import defpackage.gn2;
import defpackage.gr2;
import defpackage.hq3;
import defpackage.jo6;
import defpackage.jr2;
import defpackage.k86;
import defpackage.me1;
import defpackage.nl0;
import defpackage.ny4;
import defpackage.ot4;
import defpackage.pp3;
import defpackage.pu1;
import defpackage.rp2;
import defpackage.sy5;
import defpackage.tk3;
import defpackage.v4;
import defpackage.vh4;
import defpackage.vj6;
import defpackage.wm3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;
import org.apache.cordova.jssdk.general.Action;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaInterface;
import org.apache.cordovaNew.CordovaPlugin;
import org.apache.cordovaNew.CordovaWebView;
import org.apache.cordovaNew.PluginResult;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class WebPlatformPlugin extends CordovaPlugin {
    public static final String ACTION_CALLMESSAGE = "callMessage";
    public static final String ACTION_CALLMESSAGE_V2 = "callMessageV2";
    public static final String ACTION_JUMPTOCORDOVA = "jumpToCordova";
    public static final String ACTION_JUMPTOCORDOVA2 = "jumpToCordova2";
    public static final String ACTION_NOTIFYEVENT = "notifyEvent";
    public static final String ACTION_SAVEIMAGE = "saveImage";
    public static final String ACTION_SETSTATUSBARCOLOR = "setStatusBarColor";
    public static final String ACTION_SYNCALL = "syncAll";
    private static final int PERMISSION_REQUEST_SELECT_STORAGE = 100;
    public static final int REQUEST_CODE_GET_PICTURE = 1;
    private static final int REQUEST_CODE_SEND_SMS = 101;
    public static final int START_APP_FROM_MINIGAME_CENTER = 1;
    private static final String TAG = "WebPlatformPlugin";
    private static final int TYPE_SHARE_FRIEND = 1;
    private static final int TYPE_SHARE_SYSTEM = 0;
    private static Set<WebPlatformPlugin> sRegisteredSharedObjects = new HashSet();
    private CallbackContext mCallbackContext;
    private String mExtraInfo;
    private boolean mOverrideBackButton;
    private CallbackContext mSaveImgCallbackContext;
    private String mSaveImgUrl;
    private JSONObject mState;
    private CordovaWebView mWebView;
    private ContentObserver smsObserver;
    private long sendTime = 0;
    private String sendPhone = null;
    private long resumeTime = 0;
    private boolean paused = false;
    private boolean vivoRecents = false;
    private boolean conversations = false;
    private int smsCount = 0;

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    public static /* synthetic */ boolean access$376(WebPlatformPlugin webPlatformPlugin, int i) {
        ?? r2 = (byte) (i | (webPlatformPlugin.vivoRecents ? 1 : 0));
        webPlatformPlugin.vivoRecents = r2;
        return r2;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    public static /* synthetic */ boolean access$476(WebPlatformPlugin webPlatformPlugin, int i) {
        ?? r2 = (byte) (i | (webPlatformPlugin.conversations ? 1 : 0));
        webPlatformPlugin.conversations = r2;
        return r2;
    }

    public static /* synthetic */ int access$508(WebPlatformPlugin webPlatformPlugin) {
        int i = webPlatformPlugin.smsCount;
        webPlatformPlugin.smsCount = i + 1;
        return i;
    }

    private String getWebModuleEntrypoint(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(hq3.f18029a, null, "web_id=? AND (uid=? OR uid=?)", new String[]{str, v4.e(context), "0"}, null);
        if (cursorQuery != null) {
            strM = cursorQuery.moveToNext() ? b.m(str, cursorQuery.getInt(cursorQuery.getColumnIndex("version"))) : null;
            cursorQuery.close();
        }
        return strM;
    }

    private void launchWebModule(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String webModuleEntrypoint = getWebModuleEntrypoint(this.cordova.getContext(), str);
        if (TextUtils.isEmpty(webModuleEntrypoint)) {
            return;
        }
        if (!TextUtils.isEmpty(str2) && !str2.equals(com.igexin.push.core.b.m) && !str2.equals("undefined")) {
            webModuleEntrypoint = webModuleEntrypoint + str2;
        }
        Intent intent = new Intent(this.cordova.getContext(), (Class<?>) WebModuleActivity.class);
        intent.putExtra("web_url", webModuleEntrypoint);
        intent.putExtra("app_id", str);
        intent.putExtra("extra_hide_menu", true);
        if (jSONObject != null && jSONObject.optBoolean("transparent", false)) {
            intent.setClass(this.cordova.getContext(), TransparentLyWebActivity.class);
        }
        this.cordova.getContext().startActivity(intent);
    }

    private void notifyEvent(String str, CallbackContext callbackContext) {
        try {
            LogUtil.i(TAG, "notifyEvent " + str);
            callbackContext.success();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                b05.d(jSONObject.toString());
                String strOptString = jSONObject.optString("type");
                int iOptInt = jSONObject.optInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                if ("realNameCertification".equals(strOptString)) {
                    an1.c().l(new ot4(iOptInt));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerSmsObserver() {
        if (this.smsObserver != null) {
            return;
        }
        Uri uri = Uri.parse("content://sms/");
        this.smsObserver = new ContentObserver(new Handler()) { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.10
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri2) {
                super.onChange(z, uri2);
                if (uri2 == null) {
                    return;
                }
                WebPlatformPlugin.access$376(WebPlatformPlugin.this, Pattern.compile("content://sms/recents").matcher(uri2.toString()).matches() ? 1 : 0);
                WebPlatformPlugin.access$476(WebPlatformPlugin.this, uri2.toString().contains("content://sms/conversations") ? 1 : 0);
                WebPlatformPlugin.access$476(WebPlatformPlugin.this, uri2.toString().contains("content://sms/queued_with_group_id") ? 1 : 0);
                WebPlatformPlugin.access$476(WebPlatformPlugin.this, uri2.toString().contains("content://sms/groupsend") ? 1 : 0);
                WebPlatformPlugin webPlatformPlugin = WebPlatformPlugin.this;
                WebPlatformPlugin.access$476(webPlatformPlugin, webPlatformPlugin.vivoRecents ? 1 : 0);
                if (!Pattern.compile("content://sms/[0-9]+$").matcher(uri2.toString()).matches()) {
                    LogUtil.i("logsms", "onChange, ignore -> uri = " + uri2);
                    return;
                }
                WebPlatformPlugin.access$508(WebPlatformPlugin.this);
                if (vh4.a() && !WebPlatformPlugin.this.vivoRecents) {
                    LogUtil.i("logsms", "onChange, vivo ignore -> uri = " + uri2);
                    return;
                }
                if (WebPlatformPlugin.this.conversations) {
                    LogUtil.i("logsms", "list: onChange, pass -> uri = " + uri2);
                    WebPlatformPlugin.this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (WebPlatformPlugin.this.sendTime > 0) {
                                long jCurrentTimeMillis = System.currentTimeMillis() - WebPlatformPlugin.this.resumeTime;
                                if ((WebPlatformPlugin.this.paused || jCurrentTimeMillis <= C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) && !TextUtils.isEmpty(WebPlatformPlugin.this.sendPhone)) {
                                    LogUtil.i("logsms", "list: send success");
                                    if (WebPlatformPlugin.this.mCallbackContext != null) {
                                        WebPlatformPlugin.this.mCallbackContext.success(WebPlatformPlugin.this.sendPhone);
                                    }
                                }
                                WebPlatformPlugin.this.sendTime = 0L;
                                WebPlatformPlugin.this.sendPhone = null;
                            }
                        }
                    });
                    return;
                }
                LogUtil.i("logsms", "onChange, conversations ignore -> uri = " + uri2);
                if ((ny4.d() || ny4.e()) && Build.VERSION.SDK_INT >= 30) {
                    WebPlatformPlugin.this.conversations = true;
                } else {
                    if (!ny4.e() || WebPlatformPlugin.this.smsCount < 2) {
                        return;
                    }
                    WebPlatformPlugin.this.conversations = true;
                }
            }
        };
        this.cordova.getActivity().getContentResolver().registerContentObserver(uri, true, this.smsObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveAndShare(byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        File file = new File(this.cordova.getActivity().getExternalCacheDir(), System.currentTimeMillis() + ".tmp");
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.flush();
            share(file.getAbsolutePath());
            pu1.u(fileOutputStream);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            pu1.u(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            pu1.u(fileOutputStream2);
            throw th;
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String saveBitmap(Context context, Bitmap bitmap) throws Throwable {
        FileOutputStream fileOutputStream;
        IOException e;
        String str = pu1.f;
        ?? r1 = System.currentTimeMillis() + ".jpg";
        File file = new File(str, (String) r1);
        ?? r0 = 0;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    pu1.u(fileOutputStream);
                    r1 = fileOutputStream;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    pu1.u(fileOutputStream);
                    r1 = fileOutputStream;
                    if (bitmap != null) {
                    }
                    return file.getAbsolutePath();
                }
            } catch (Throwable th) {
                th = th;
                r0 = r1;
                pu1.u(r0);
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (IOException e3) {
            fileOutputStream = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            pu1.u(r0);
            if (bitmap != null) {
            }
            throw th;
        }
        bitmap.recycle();
        return file.getAbsolutePath();
    }

    private void saveUrlImage(String str, CallbackContext callbackContext) {
        try {
            this.mSaveImgCallbackContext = callbackContext;
            this.mSaveImgUrl = str;
            if (this.cordova.hasPermission(g.j)) {
                CallbackContext callbackContext2 = this.mSaveImgCallbackContext;
                if (callbackContext2 != null) {
                    saveUrlImageImp(str, callbackContext2);
                }
            } else {
                this.cordova.requestPermission(this, 100, g.j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUrlImageImp(String str, final CallbackContext callbackContext) {
        LogUtil.uploadInfoImmediate("H41", null, null, null);
        gr2.j().l(str, new jr2() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.7
            @Override // defpackage.jr2
            public void onLoadingCancelled(String str2, View view) {
                callbackContext.success(-1);
                LogUtil.uploadInfoImmediate("H421", null, null, null);
            }

            @Override // defpackage.jr2
            public void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                try {
                    wm3.a(WebPlatformPlugin.saveBitmap(WebPlatformPlugin.this.cordova.getActivity(), bitmap));
                    callbackContext.success(0);
                    LogUtil.uploadInfoImmediate("H42", null, null, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.jr2
            public void onLoadingFailed(String str2, View view, FailReason failReason) {
                callbackContext.success(-1);
                LogUtil.uploadInfoImmediate("H421", null, null, null);
            }

            @Override // defpackage.jr2
            public void onLoadingStarted(String str2, View view) {
            }
        });
    }

    private void share(final String str) {
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.8
            @Override // java.lang.Runnable
            public void run() {
                ((WebModuleActivity) WebPlatformPlugin.this.cordova.getActivity()).U(str);
            }
        });
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, final CallbackContext callbackContext) {
        Log.i(TAG, str + "-" + jSONArray.toString());
        this.mCallbackContext = callbackContext;
        if ("share".equals(str)) {
            int iOptInt = jSONArray.optInt(0, -1);
            final JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(1);
            if (iOptInt == 0) {
                final String strOptString = jSONArray.optString(2);
                this.cordova.getThreadPool().execute(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        WebPlatformPlugin.this.saveAndShare(Base64.decode(strOptString, 0));
                    }
                });
            } else if (iOptInt == 1) {
                final WebModuleActivity webModuleActivity = (WebModuleActivity) this.cordova.getActivity();
                webModuleActivity.runOnUiThread(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pp3.a(WebPlatformPlugin.this.cordova.getActivity(), webModuleActivity.K(), jSONObjectOptJSONObject.optString("urlExtra"), jSONObjectOptJSONObject.optString("titleInfo"), pp3.c((WebView) WebPlatformPlugin.this.webView.getView()));
                    }
                });
            }
            callbackContext.success();
            return true;
        }
        if (Action.ACTION_CLOSE_WINDOW.equals(str)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    WebPlatformPlugin.this.cordova.getActivity().finish();
                }
            });
            callbackContext.success();
            return true;
        }
        if ("closeWindowWithResultCode".equals(str)) {
            final int iOptInt2 = jSONArray.optInt(0, 0);
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.4
                @Override // java.lang.Runnable
                public void run() {
                    WebPlatformPlugin.this.cordova.getActivity().setResult(iOptInt2);
                    WebPlatformPlugin.this.cordova.getActivity().finish();
                }
            });
            callbackContext.success();
            return true;
        }
        if ("takePhotoCrop".equals(str)) {
            Intent intentC = tk3.c(this.cordova.getActivity());
            this.cordova.setActivityResultCallback(this);
            this.cordova.startActivityForResult(this, intentC, 1);
            return true;
        }
        if ("getExtraInfo".equals(str)) {
            callbackContext.success(this.mExtraInfo);
            return true;
        }
        if ("setState".equals(str)) {
            this.mState = jSONArray.optJSONObject(0);
            callbackContext.success();
            return true;
        }
        if ("getState".equals(str)) {
            callbackContext.success(this.mState);
            return true;
        }
        if ("getModuleUnRead".equals(str)) {
            callbackContext.success(ModuleBadgeManager.a().b(ModuleBadgeManager.b(jSONArray.optString(0, ""))).f13979a);
            return true;
        }
        if ("setModuleUnRead".equals(str)) {
            ModuleBadgeManager.a().a(ModuleBadgeManager.b(jSONArray.optString(0, "")), new ModuleBadgeManager.a(jSONArray.optInt(1, 0), 0));
            callbackContext.success();
            return true;
        }
        if ("launchWebModule".equals(str)) {
            launchWebModule(jSONArray.optString(0), jSONArray.optString(1), jSONArray.optJSONObject(2));
            callbackContext.success();
            return true;
        }
        if ("registerSharedEventListener".equals(str)) {
            sRegisteredSharedObjects.add(this);
            callbackContext.success();
            return true;
        }
        if ("unregisterSharedEventListener".equals(str)) {
            if (sRegisteredSharedObjects.contains(this)) {
                sRegisteredSharedObjects.remove(this);
            }
            callbackContext.success();
            return true;
        }
        if ("sendSharedEvent".equals(str)) {
            String strOptString2 = jSONArray.optString(0);
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(1);
            Iterator<WebPlatformPlugin> it = sRegisteredSharedObjects.iterator();
            while (it.hasNext()) {
                it.next().fireSharedEvent(strOptString2, jSONObjectOptJSONObject2);
            }
            callbackContext.success();
            return true;
        }
        if (Action.ACTION_SHOW_TOAST.equals(str)) {
            String strOptString3 = jSONArray.optString(0);
            int iOptInt3 = jSONArray.optInt(1, 0);
            sy5.f(this.cordova.getContext(), strOptString3, iOptInt3 >= 0 ? iOptInt3 > 1 ? 1 : iOptInt3 : 0).g();
            callbackContext.success();
            return true;
        }
        if ("isAppInstalled".equals(str)) {
            JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(0);
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                callbackContext.success();
            } else {
                JSONObject jSONObject = new JSONObject();
                while (i < jSONArrayOptJSONArray.length()) {
                    String strOptString4 = jSONArrayOptJSONArray.optString(i);
                    try {
                        jSONObject.put(strOptString4, k86.F(this.cordova.getActivity(), strOptString4));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
                callbackContext.success(jSONObject);
            }
            return true;
        }
        if ("startApp".equals(str)) {
            String strOptString5 = jSONArray.optString(0);
            int iOptInt4 = jSONArray.optInt(1, 0);
            try {
                Intent launchIntentForPackage = this.cordova.getActivity().getPackageManager().getLaunchIntentForPackage(strOptString5);
                launchIntentForPackage.addFlags(268435456);
                this.cordova.getActivity().startActivity(launchIntentForPackage);
                if (iOptInt4 == 1) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("gameid", strOptString5);
                        jSONObject2.put("fromId", "-1");
                        jSONObject2.put(az.at, 3);
                        jSONObject2.put("yxtype", 2);
                        jSONObject2.put("process", 5);
                        LogUtil.uploadInfoImmediate("yx012", null, null, jSONObject2.toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            callbackContext.success();
            return true;
        }
        if ("openUrlByBrowser".equals(str)) {
            String strOptString6 = jSONArray.optString(0);
            int iOptInt5 = jSONArray.optInt(1, 0);
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(strOptString6));
                this.cordova.getActivity().startActivity(intent);
                if (iOptInt5 == 1) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("gameid", jSONArray.optString(2));
                        jSONObject3.put("fromId", "-1");
                        jSONObject3.put(az.at, 3);
                        jSONObject3.put("yxtype", 3);
                        jSONObject3.put("process", 5);
                        LogUtil.uploadInfoImmediate("yx012", null, null, jSONObject3.toString());
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            callbackContext.success();
            return true;
        }
        if (RedPacketPullNewPlugin.ACTION_DOWNLOADAPP.equals(str)) {
            String strOptString7 = jSONArray.optString(0);
            ApkDownloadManager.d().a(strOptString7, jSONArray.optString(1));
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("gameid", strOptString7);
                jSONObject4.put("fromId", "-1");
                jSONObject4.put(az.at, 3);
                jSONObject4.put("yxtype", 2);
                jSONObject4.put("process", 1);
                LogUtil.uploadInfoImmediate("yx012", null, null, jSONObject4.toString());
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            callbackContext.success();
            return true;
        }
        if ("pauseDownloadApp".equals(str)) {
            String strOptString8 = jSONArray.optString(0);
            ApkDownloadManager.d().e(strOptString8);
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("gameid", strOptString8);
                jSONObject5.put("fromId", "-1");
                jSONObject5.put(az.at, 3);
                jSONObject5.put("yxtype", 2);
                jSONObject5.put("process", 2);
                LogUtil.uploadInfoImmediate("yx012", null, null, jSONObject5.toString());
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
            callbackContext.success();
            return true;
        }
        if ("resumeDownloadApp".equals(str)) {
            String strOptString9 = jSONArray.optString(0);
            ApkDownloadManager.d().f(strOptString9);
            try {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("gameid", strOptString9);
                jSONObject6.put("fromId", "-1");
                jSONObject6.put(az.at, 3);
                jSONObject6.put("yxtype", 2);
                jSONObject6.put("process", 3);
                LogUtil.uploadInfoImmediate("yx012", null, null, jSONObject6.toString());
            } catch (JSONException e8) {
                e8.printStackTrace();
            }
            callbackContext.success();
            return true;
        }
        if ("installApp".equals(str)) {
            String strOptString10 = jSONArray.optString(0);
            File externalCacheDir = this.cordova.getContext().getExternalCacheDir();
            eh.c(this.cordova.getContext(), new File(externalCacheDir, strOptString10 + com.huawei.hms.ads.dynamicloader.b.b));
            try {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("gameid", strOptString10);
                jSONObject7.put("fromId", "-1");
                jSONObject7.put(az.at, 3);
                jSONObject7.put("yxtype", 2);
                jSONObject7.put("process", 4);
                LogUtil.uploadInfoImmediate("yx012", null, null, jSONObject7.toString());
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
            callbackContext.success();
            return true;
        }
        if ("getAppStateList".equals(str)) {
            Map<String, Integer> mapC = ApkDownloadManager.d().c();
            JSONObject jSONObject8 = new JSONObject();
            for (String str2 : mapC.keySet()) {
                try {
                    jSONObject8.put(str2, mapC.get(str2));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
            callbackContext.success(jSONObject8);
            return true;
        }
        if (str.equals("getTaiChiStringValue")) {
            String strOptString11 = jSONArray.optString(0);
            String strOptString12 = jSONArray.optString(1);
            callbackContext.success(jo6.c(strOptString11, TextUtils.isEmpty(strOptString12) ? "" : strOptString12));
            return true;
        }
        if (str.equals("getTaiChiBooleanValue")) {
            callbackContext.success(jo6.a(jSONArray.optString(0), jSONArray.optBoolean(1, false)) ? 1 : 0);
            return true;
        }
        if (str.equals("overrideBackButton")) {
            this.mOverrideBackButton = jSONArray.optBoolean(0, false);
            callbackContext.success();
            return true;
        }
        if (str.equals(ACTION_JUMPTOCORDOVA)) {
            String strOptString13 = jSONArray.optString(0);
            rp2.a aVar = new rp2.a();
            aVar.l(strOptString13);
            aVar.g(-1);
            aVar.k(true);
            this.cordova.getActivity().startActivity(vj6.a(this.cordova.getActivity(), aVar));
            callbackContext.success();
            return true;
        }
        if (str.equals(ACTION_JUMPTOCORDOVA2)) {
            String strOptString14 = jSONArray.optString(0);
            boolean zOptBoolean = jSONArray.optBoolean(1);
            rp2.a aVar2 = new rp2.a();
            aVar2.l(strOptString14);
            aVar2.g(-1);
            aVar2.k(zOptBoolean);
            this.cordova.getActivity().startActivity(vj6.a(this.cordova.getActivity(), aVar2));
            callbackContext.success();
            return true;
        }
        if (str.equals("saveImage")) {
            saveUrlImage(jSONArray.optString(0), callbackContext);
            return true;
        }
        if (str.equals("notifyEvent")) {
            notifyEvent(jSONArray.optString(0), callbackContext);
            return true;
        }
        if (str.equals(ACTION_SETSTATUSBARCOLOR)) {
            final String strOptString15 = jSONArray.optString(0);
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        me1.k(WebPlatformPlugin.this.cordova.getActivity().getWindow(), Color.parseColor(strOptString15));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            });
            return true;
        }
        if (str.equals("callMessage")) {
            JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(0);
            try {
                String strOptString16 = jSONObjectOptJSONObject3.optString("ph");
                String strOptString17 = jSONObjectOptJSONObject3.optString("txt");
                Intent intent2 = new Intent("android.intent.action.SENDTO");
                intent2.setData(Uri.parse("smsto:" + strOptString16));
                intent2.putExtra("sms_body", strOptString17);
                this.cordova.getActivity().startActivity(intent2);
                i = 1;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H5", null, i == 0 ? "2" : "1", null);
            callbackContext.success();
            return true;
        }
        if (!str.equals("callMessageV2")) {
            if (str.equals(ACTION_SYNCALL)) {
                ap3.a().K(new gn2.a() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.6
                    @Override // gn2.a
                    public void onFinish() {
                        callbackContext.success();
                    }
                });
                return true;
            }
            callbackContext.success();
            return false;
        }
        try {
            registerSmsObserver();
        } catch (Exception unused) {
        }
        JSONObject jSONObjectOptJSONObject4 = jSONArray.optJSONObject(0);
        try {
            String strOptString18 = jSONObjectOptJSONObject4.optString("ph");
            String strOptString19 = jSONObjectOptJSONObject4.optString("txt");
            this.vivoRecents = false;
            this.conversations = false;
            this.smsCount = 0;
            this.sendTime = System.currentTimeMillis();
            this.sendPhone = strOptString18;
            Intent intent3 = new Intent("android.intent.action.SENDTO");
            intent3.setData(Uri.parse("smsto:" + strOptString18));
            intent3.putExtra("sms_body", strOptString19);
            this.cordova.getActivity().startActivityForResult(intent3, 101);
            i = 1;
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("H5", null, i == 0 ? "2" : "1", null);
        this.mCallbackContext = callbackContext;
        return true;
    }

    public void fireSharedEvent(final String str, final JSONObject jSONObject) {
        if (str != null) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.webplatform.jssdk.WebPlatformPlugin.9
                @Override // java.lang.Runnable
                public void run() {
                    if (WebPlatformPlugin.this.mWebView != null) {
                        if (jSONObject == null) {
                            WebPlatformPlugin.this.mWebView.loadUrl("javascript:(function(){if(zx && zx.fireSharedEvent) zx.fireSharedEvent(\"" + str + "\")})()");
                            return;
                        }
                        WebPlatformPlugin.this.mWebView.loadUrl("javascript:(function(){if(zx && zx.fireSharedEvent) zx.fireSharedEvent(\"" + str + "\", JSON.parse('" + jSONObject.toString() + "'))})()");
                    }
                }
            });
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.mWebView = cordovaWebView;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (!TextUtils.isEmpty(stringExtra)) {
                LogUtil.i(TAG, "onActivityResult url = " + stringExtra);
                if (this.mCallbackContext != null) {
                    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, stringExtra);
                    pluginResult.setKeepCallback(true);
                    this.mCallbackContext.sendPluginResult(pluginResult);
                    return;
                }
            }
        }
        PluginResult pluginResult2 = new PluginResult(PluginResult.Status.NO_RESULT);
        if (this.mCallbackContext != null) {
            pluginResult2.setKeepCallback(true);
            this.mCallbackContext.sendPluginResult(pluginResult2);
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onDestroy() {
        this.mWebView = null;
        if (sRegisteredSharedObjects.contains(this)) {
            sRegisteredSharedObjects.remove(this);
        }
        if (this.smsObserver != null) {
            this.cordova.getActivity().getContentResolver().unregisterContentObserver(this.smsObserver);
        }
        super.onDestroy();
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onPause(boolean z) {
        super.onPause(z);
        this.paused = true;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        super.onRequestPermissionResult(i, strArr, iArr);
        if (i == 100) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                CallbackContext callbackContext = this.mSaveImgCallbackContext;
                if (callbackContext != null) {
                    callbackContext.success(-2);
                    return;
                }
                return;
            }
            CallbackContext callbackContext2 = this.mSaveImgCallbackContext;
            if (callbackContext2 != null) {
                saveUrlImageImp(this.mSaveImgUrl, callbackContext2);
            }
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onResume(boolean z) {
        super.onResume(z);
        this.resumeTime = System.currentTimeMillis();
        this.paused = false;
    }

    public boolean overrideBackButton() {
        return this.mOverrideBackButton;
    }

    public void setExtraInfo(String str) {
        this.mExtraInfo = str;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public Boolean shouldAllowNavigation(String str) {
        return (str == null || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || nl0.c().equals("release")) ? super.shouldAllowNavigation(str) : Boolean.TRUE;
    }
}
