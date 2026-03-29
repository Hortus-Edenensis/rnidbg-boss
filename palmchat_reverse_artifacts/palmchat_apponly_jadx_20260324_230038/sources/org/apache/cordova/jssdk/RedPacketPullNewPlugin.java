package org.apache.cordova.jssdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.common.C;
import com.google.zxing.WriterException;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInviteActivity;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.b5;
import defpackage.gr2;
import defpackage.gt;
import defpackage.hu;
import defpackage.ir5;
import defpackage.jr2;
import defpackage.k86;
import defpackage.me1;
import defpackage.ny4;
import defpackage.pu1;
import defpackage.r10;
import defpackage.r75;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.vh4;
import defpackage.wc;
import defpackage.wm3;
import defpackage.zf2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class RedPacketPullNewPlugin extends CordovaPlugin implements IPermissionCallbackPlugin {
    public static final String ACTION_CALLMESSAGE = "callMessage";
    public static final String ACTION_CALLMESSAGE_V2 = "callMessageV2";
    public static final String ACTION_CREATEIMG = "createImg";
    public static final String ACTION_DISMISSHANDINHANDBUBBLE = "dismissHandInHandBubble";
    public static final String ACTION_DOWNLOADAPP = "downloadApp";
    public static final String ACTION_GETVALIDATEINFO = "getValidateInfo";
    public static final String ACTION_ISAPPINSTALLED = "isAppInstalled";
    public static final String ACTION_ISCONTACTCLOSE = "isContactClose";
    public static final String ACTION_ISCONTACTUPLOADED = "isContactUploaded";
    public static final String ACTION_JUMPTOSETTINGTAB = "jumpToSettingTab";
    public static final String ACTION_OPENAPP = "openApp";
    public static final String ACTION_SAVEIMAGE = "saveImage";
    public static final String ACTION_SCREENSHOT = "screenshot";
    public static final String ACTION_SHOWCONTACTSELECTVIEW = "showContactSelectView";
    public static final String ACTION_SHOWWALLET = "showWallet";
    public static final String ACTION_SHOW_BADRE = "setBonusUnreadBadge";
    public static final String ACTION_UPLOADCONTACT = "uploadContact";
    public static final String ACTION_UPLOADCONTACTEXT = "uploadContactExt";
    private static final int CORDOVA_JUMPTO_CONTACT_INVITE = 4097;
    private static final int REQUEST_CODE_SEND_SMS = 101;
    public static final String TAG = "RedPacketPullNewPlugin";
    private CallbackContext mCallbackContext;
    private ContentObserver smsObserver;
    private long sendTime = 0;
    private String sendPhone = null;
    private long resumeTime = 0;
    private boolean paused = false;
    private boolean vivoRecents = false;
    private boolean conversations = false;
    private int smsCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap captureWebView(WebView webView, float f, float f2) {
        Picture pictureCapturePicture = webView.capturePicture();
        int width = pictureCapturePicture.getWidth();
        int height = pictureCapturePicture.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        float f3 = 1.0f - f;
        float f4 = height;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, (int) ((f3 - f2) * f4), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawPicture(pictureCapturePicture, new RectF(0.0f, (-f) * f4, width, f3 * f4));
        return bitmapCreateBitmap;
    }

    private void genRedPacketImg(final Context context, JSONObject jSONObject, final CallbackContext callbackContext) {
        LogUtil.i(TAG, "genRedPacketImg JSON : " + jSONObject);
        String strOptString = jSONObject.optString(Constant.MAP_KEY_TOP);
        String strOptString2 = jSONObject.optString("viceTop");
        String strOptString3 = jSONObject.optString("title");
        String strOptString4 = jSONObject.optString("viceTitle");
        String strOptString5 = jSONObject.optString("amount");
        String strOptString6 = jSONObject.optString("instru");
        String strOptString7 = jSONObject.optString("url");
        final Dialog dialog = new Dialog(context, R.style.red_packet_pull_new_dialog);
        View viewInflate = View.inflate(context, R.layout.dialog_red_pull_new, null);
        final View viewFindViewById = viewInflate.findViewById(R.id.red_content);
        viewFindViewById.setDrawingCacheEnabled(true);
        viewFindViewById.setDrawingCacheQuality(1048576);
        viewFindViewById.setDrawingCacheBackgroundColor(-1);
        ((TextView) viewInflate.findViewById(R.id.top)).setText(strOptString);
        ((TextView) viewInflate.findViewById(R.id.viceTop)).setText(strOptString2);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(strOptString3);
        ((TextView) viewInflate.findViewById(R.id.viceTitle)).setText(strOptString4);
        TextView textView = (TextView) viewInflate.findViewById(R.id.amount);
        if (strOptString5 != null && strOptString5.length() >= 2) {
            textView.setTextSize(42.0f);
        }
        textView.setText(strOptString5);
        ((TextView) viewInflate.findViewById(R.id.instru)).setText(strOptString6);
        try {
            ((ImageView) viewInflate.findViewById(R.id.qrImg)).setImageBitmap(gt.d(strOptString7, me1.b(context, 90)));
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        final View viewFindViewById2 = viewInflate.findViewById(R.id.jumpApp);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RedPacketPullNewPlugin.this.startWxOrQQ(context);
            }
        });
        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.setStartOffset(500L);
        TranslateAnimation translateAnimation = new TranslateAnimation(me1.b(context, 120), 0.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(300L);
        animationSet.addAnimation(translateAnimation);
        viewInflate.findViewById(R.id.red_close).setOnClickListener(new View.OnClickListener() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(viewInflate);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        dialog.setCancelable(true);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                int i;
                View view = viewFindViewById;
                Bitmap bitmapA = r10.a(view, view.getWidth(), viewFindViewById.getHeight());
                if (bitmapA != null) {
                    try {
                        String str = pu1.f + File.separator + "RQ_" + ir5.b() + ".jpg";
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmapA.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                        fileOutputStream.close();
                        wm3.a(str);
                        Context context2 = context;
                        i = 1;
                        sy5.f(context2, context2.getResources().getString(R.string.save_to_dir, pu1.f), 1).g();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                viewFindViewById.setDrawingCacheEnabled(false);
                viewFindViewById2.startAnimation(animationSet);
                LogUtil.uploadInfoImmediate("H4", null, i != 0 ? "1" : "2", null);
                callbackContext.success(i);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
        dialog.show();
    }

    private void getValidateInfo(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        String strP = AccountUtils.p(AppContext.getContext());
        String strO = AccountUtils.o(AppContext.getContext());
        String strGenerateMessageToken = EncryptUtils.generateMessageToken();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, strP);
            jSONObject.put(WkParams.SESSIONID, strO);
            jSONObject.put("token", strGenerateMessageToken);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(az.aW, ac1.f);
            jSONObject.put("deviceName", ac1.b);
            jSONObject.put("platform", ac1.c);
            jSONObject.put("osVersion", ac1.e);
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("versionName", ac1.g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.i(TAG, "getValidateInfo JSON : -" + jSONObject.toString());
        callbackContext.success(jSONObject);
    }

    private void registerSmsObserver() {
        if (this.smsObserver != null) {
            return;
        }
        Uri uri = Uri.parse("content://sms/");
        this.smsObserver = new ContentObserver(new Handler()) { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.11
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri2) {
                super.onChange(z, uri2);
                if (uri2 == null) {
                    return;
                }
                Matcher matcher = Pattern.compile("content://sms/recents").matcher(uri2.toString());
                RedPacketPullNewPlugin redPacketPullNewPlugin = RedPacketPullNewPlugin.this;
                redPacketPullNewPlugin.vivoRecents = matcher.matches() | redPacketPullNewPlugin.vivoRecents;
                RedPacketPullNewPlugin.this.conversations |= uri2.toString().contains("content://sms/conversations");
                RedPacketPullNewPlugin.this.conversations |= uri2.toString().contains("content://sms/queued_with_group_id");
                RedPacketPullNewPlugin.this.conversations |= uri2.toString().contains("content://sms/groupsend");
                RedPacketPullNewPlugin.this.conversations |= RedPacketPullNewPlugin.this.vivoRecents;
                if (!Pattern.compile("content://sms/[0-9]+$").matcher(uri2.toString()).matches()) {
                    LogUtil.i("logsms", "onChange, ignore -> uri = " + uri2);
                    return;
                }
                RedPacketPullNewPlugin.this.smsCount++;
                if (vh4.a() && !RedPacketPullNewPlugin.this.vivoRecents) {
                    LogUtil.i("logsms", "onChange, vivo ignore -> uri = " + uri2);
                    return;
                }
                if (RedPacketPullNewPlugin.this.conversations) {
                    LogUtil.i("logsms", "list: onChange, pass -> uri = " + uri2);
                    RedPacketPullNewPlugin.this.cordova.getOwnerActivity2().runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RedPacketPullNewPlugin.this.sendTime > 0) {
                                long jCurrentTimeMillis = System.currentTimeMillis() - RedPacketPullNewPlugin.this.resumeTime;
                                if ((RedPacketPullNewPlugin.this.paused || jCurrentTimeMillis <= C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) && !TextUtils.isEmpty(RedPacketPullNewPlugin.this.sendPhone)) {
                                    LogUtil.i("logsms", "list: send success");
                                    if (RedPacketPullNewPlugin.this.mCallbackContext != null) {
                                        RedPacketPullNewPlugin.this.mCallbackContext.success(RedPacketPullNewPlugin.this.sendPhone);
                                    }
                                }
                                RedPacketPullNewPlugin.this.sendTime = 0L;
                                RedPacketPullNewPlugin.this.sendPhone = null;
                            }
                        }
                    });
                    return;
                }
                LogUtil.i("logsms", "onChange, conversations ignore -> uri = " + uri2);
                if ((ny4.d() || ny4.e()) && Build.VERSION.SDK_INT >= 30) {
                    RedPacketPullNewPlugin.this.conversations = true;
                } else {
                    if (!ny4.e() || RedPacketPullNewPlugin.this.smsCount < 2) {
                        return;
                    }
                    RedPacketPullNewPlugin.this.conversations = true;
                }
            }
        };
        this.cordova.getOwnerActivity2().getContentResolver().registerContentObserver(uri, true, this.smsObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String saveBitmap(Context context, Bitmap bitmap) {
        File file = new File(pu1.f, System.currentTimeMillis() + ".jpg");
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return file.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
                if (bitmap == null) {
                    return null;
                }
                bitmap.recycle();
                return null;
            }
        } catch (Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    private void saveScreenImage(final float f, final float f2, final CallbackContext callbackContext) {
        LogUtil.uploadInfoImmediate("H43", null, null, null);
        try {
            final Activity ownerActivity2 = this.cordova.getOwnerActivity2();
            ownerActivity2.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    try {
                        String strSaveBitmap = RedPacketPullNewPlugin.saveBitmap(ownerActivity2, RedPacketPullNewPlugin.captureWebView(RedPacketPullNewPlugin.this.webView, f, f2));
                        if (TextUtils.isEmpty(strSaveBitmap)) {
                            LogUtil.uploadInfoImmediate("H441", null, null, null);
                            i = -1;
                        } else {
                            wm3.a(strSaveBitmap);
                            LogUtil.uploadInfoImmediate("H44", null, null, null);
                            i = 0;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("status", i);
                            jSONObject.put("filePath", strSaveBitmap);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callbackContext.success(jSONObject);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("status", -1);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        callbackContext.success(jSONObject2);
                        LogUtil.uploadInfoImmediate("H441", null, null, null);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callbackContext.success(jSONObject);
            LogUtil.uploadInfoImmediate("H441", null, null, null);
        }
    }

    private void saveUrlImage(String str, final CallbackContext callbackContext) {
        LogUtil.uploadInfoImmediate("H41", null, null, null);
        gr2.j().l(str, new jr2() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.7
            @Override // defpackage.jr2
            public void onLoadingCancelled(String str2, View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackContext.success(jSONObject);
                LogUtil.uploadInfoImmediate("H421", null, null, null);
            }

            @Override // defpackage.jr2
            public void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                int i;
                try {
                    String strSaveBitmap = RedPacketPullNewPlugin.saveBitmap(RedPacketPullNewPlugin.this.cordova.getOwnerActivity2(), bitmap);
                    if (TextUtils.isEmpty(strSaveBitmap)) {
                        i = -1;
                    } else {
                        wm3.a(strSaveBitmap);
                        LogUtil.uploadInfoImmediate("H42", null, null, null);
                        i = 0;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("status", i);
                        jSONObject.put("filePath", strSaveBitmap);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    callbackContext.success(jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // defpackage.jr2
            public void onLoadingFailed(String str2, View view, FailReason failReason) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackContext.success(jSONObject);
                LogUtil.uploadInfoImmediate("H421", null, null, null);
            }

            @Override // defpackage.jr2
            public void onLoadingStarted(String str2, View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWxOrQQ(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            launchIntentForPackage.addFlags(268435456);
            context.startActivity(launchIntentForPackage);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                launchIntentForPackage2.addFlags(268435456);
                context.startActivity(launchIntentForPackage2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadContact(final CallbackContext callbackContext) {
        if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
            AppContext.getContext().getTrayPreferences().i(k86.n(), true);
        }
        d.j().i();
        d.j().u(new d.c() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.5
            /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
            @Override // com.zenmen.palmchat.contacts.d.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onFinished(HashMap<String, PhoneContactVo> map) {
                JSONObject jSONObject = new JSONObject();
                if (map != null) {
                    try {
                        int i = map.size() > 0 ? 0 : -1;
                        jSONObject.put("status", i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                callbackContext.success(jSONObject);
            }
        });
    }

    private void uploadContactExt(final CallbackContext callbackContext) {
        try {
            wc.a().a().a(new b5() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.6
                @Override // defpackage.b5
                public void call() {
                    RedPacketPullNewPlugin.this.mCallbackContext = callbackContext;
                    CordovaWebActivity cordovaWebActivity = (CordovaWebActivity) RedPacketPullNewPlugin.this.cordova.getOwnerActivity2();
                    cordovaWebActivity.Q2(RedPacketPullNewPlugin.this);
                    BaseActivityPermissionDispatcher.b(cordovaWebActivity, BaseActivityPermissionDispatcher.PermissionType.CONTACT, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [org.apache.cordova.CallbackContext] */
    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        float fOptDouble;
        if (str.equals("isContactClose")) {
            callbackContext.success(!tg4.b(this.cordova.getOwnerActivity2(), BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList) ? 1 : 0);
            return true;
        }
        if (str.equals(ACTION_UPLOADCONTACT)) {
            uploadContact(callbackContext);
            return true;
        }
        if (str.equals("uploadContactExt")) {
            uploadContactExt(callbackContext);
            return true;
        }
        ?? r11 = 0;
        ?? r112 = 0;
        ?? r113 = 0;
        if (str.equals("callMessage")) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
            try {
                String strOptString = jSONObjectOptJSONObject.optString("ph");
                String strOptString2 = jSONObjectOptJSONObject.optString("txt");
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("smsto:" + strOptString));
                intent.putExtra("sms_body", strOptString2);
                this.cordova.getOwnerActivity2().startActivity(intent);
                r112 = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H5", null, r112 == 0 ? "2" : "1", null);
            callbackContext.success();
            return true;
        }
        if (str.equals("callMessageV2")) {
            try {
                registerSmsObserver();
            } catch (Exception unused) {
            }
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(0);
            try {
                String strOptString3 = jSONObjectOptJSONObject2.optString("ph");
                String strOptString4 = jSONObjectOptJSONObject2.optString("txt");
                this.vivoRecents = false;
                this.conversations = false;
                this.smsCount = 0;
                this.sendTime = System.currentTimeMillis();
                this.sendPhone = strOptString3;
                Intent intent2 = new Intent("android.intent.action.SENDTO");
                intent2.setData(Uri.parse("smsto:" + strOptString3));
                intent2.putExtra("sms_body", strOptString4);
                this.cordova.getOwnerActivity2().startActivityForResult(intent2, 101);
                r11 = 1;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H5", null, r11 == 0 ? "2" : "1", null);
            this.mCallbackContext = callbackContext;
            return true;
        }
        if (str.equals(ACTION_CREATEIMG)) {
            genRedPacketImg(this.cordova.getOwnerActivity2(), jSONArray.optJSONObject(0), callbackContext);
            return true;
        }
        if (str.equals("isAppInstalled")) {
            callbackContext.success(k86.F(this.cordova.getOwnerActivity2(), jSONArray.optString(0)) ? 1 : 0);
            return true;
        }
        if (str.equals(ACTION_OPENAPP)) {
            String strOptString5 = jSONArray.optString(0);
            String strOptString6 = jSONArray.optString(1);
            try {
                Intent intent3 = new Intent();
                intent3.setAction("android.intent.action.VIEW");
                intent3.setData(Uri.parse(strOptString6));
                intent3.setPackage(strOptString5);
                this.cordova.getOwnerActivity2().startActivity(intent3);
                r113 = 1;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H31", null, r113 == 0 ? "2" : "1", null);
            callbackContext.success();
            return true;
        }
        if (str.equals(ACTION_DOWNLOADAPP)) {
            String strOptString7 = jSONArray.optString(0);
            String strOptString8 = jSONArray.optString(1);
            boolean zP = k86.P(this.cordova.getOwnerActivity2(), strOptString7);
            LogUtil.uploadInfoImmediate("H32", null, zP ? "1" : "2", null);
            if (!zP) {
                try {
                    Intent intent4 = new Intent();
                    intent4.setAction("android.intent.action.VIEW");
                    intent4.addCategory("android.intent.category.BROWSABLE");
                    intent4.setData(Uri.parse(strOptString8));
                    intent4.setClassName(BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO, "com.android.browser.BrowserActivity");
                    this.cordova.getOwnerActivity2().startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            callbackContext.success();
            return true;
        }
        if (str.equals(ACTION_ISCONTACTUPLOADED)) {
            boolean zA = AppContext.getContext().getTrayPreferences().a(k86.n(), false);
            callbackContext.success((zA && d.j().k() == 0) ? 0 : zA);
            return true;
        }
        if (str.equals(ACTION_SHOWWALLET)) {
            hu.b();
            callbackContext.success();
            return true;
        }
        if (str.equals(ACTION_GETVALIDATEINFO)) {
            getValidateInfo(callbackContext);
            return true;
        }
        if (str.equals("saveImage")) {
            saveUrlImage(jSONArray.optString(0), callbackContext);
            return true;
        }
        if (str.equals(ACTION_SCREENSHOT)) {
            float fOptDouble2 = 0.0f;
            try {
                fOptDouble = (float) jSONArray.optDouble(0);
            } catch (Exception e5) {
                e = e5;
                fOptDouble = 0.0f;
            }
            try {
                fOptDouble2 = (float) jSONArray.optDouble(1);
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
            }
            saveScreenImage(fOptDouble, fOptDouble2, callbackContext);
            return true;
        }
        if (str.equals(ACTION_SHOW_BADRE)) {
            r75.p(AppContext.getContext(), "sp_redpacket_badge", jSONArray.optInt(0));
            LogUtil.i(TAG, "showbadge :" + r75.g(AppContext.getContext(), "sp_redpacket_badge", 0));
        } else {
            if (str.equals(ACTION_SHOWCONTACTSELECTVIEW)) {
                int iOptInt = jSONArray.optInt(0);
                String strOptString9 = jSONArray.optString(1);
                String strOptString10 = jSONArray.optString(2);
                String strOptString11 = jSONArray.optString(3);
                String strOptString12 = jSONArray.optJSONObject(4).optString("redId");
                Intent intent5 = new Intent(this.cordova.getOwnerActivity2(), (Class<?>) ContactInviteActivity.class);
                intent5.putExtra("isSend", iOptInt);
                intent5.putExtra("content", strOptString9);
                intent5.putExtra("title1", strOptString10);
                intent5.putExtra("title2", strOptString11);
                intent5.putExtra("redId", strOptString12);
                this.mCallbackContext = callbackContext;
                this.cordova.startActivityForResult(this, intent5, 4097);
                return true;
            }
            if (str.equals(ACTION_JUMPTOSETTINGTAB)) {
                Intent intent6 = new Intent();
                intent6.setClass(this.cordova.getOwnerActivity2(), MainTabsActivity.class);
                intent6.putExtra("new_intent_position", "tab_mine");
                this.cordova.getOwnerActivity2().startActivity(intent6);
                this.cordova.getOwnerActivity2().finish();
                callbackContext.success();
                return true;
            }
            if (str.equals(ACTION_DISMISSHANDINHANDBUBBLE)) {
                zf2.e().c();
                callbackContext.success();
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4097 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("contacts");
            CallbackContext callbackContext = this.mCallbackContext;
            if (callbackContext != null) {
                callbackContext.success(stringExtra);
            }
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        super.onDestroy();
        if (this.smsObserver != null) {
            this.cordova.getOwnerActivity2().getContentResolver().unregisterContentObserver(this.smsObserver);
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onPause(boolean z) {
        super.onPause(z);
        this.paused = true;
    }

    @Override // org.apache.cordova.jssdk.IPermissionCallbackPlugin
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CONTACT) {
            wc.a().a().a(new b5() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.10
                @Override // defpackage.b5
                public void call() {
                    if (RedPacketPullNewPlugin.this.mCallbackContext != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("status", -2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        RedPacketPullNewPlugin.this.mCallbackContext.success(jSONObject);
                    }
                }
            });
        }
    }

    @Override // org.apache.cordova.jssdk.IPermissionCallbackPlugin
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CONTACT) {
            wc.a().a().a(new b5() { // from class: org.apache.cordova.jssdk.RedPacketPullNewPlugin.9
                @Override // defpackage.b5
                public void call() {
                    if (RedPacketPullNewPlugin.this.mCallbackContext != null) {
                        RedPacketPullNewPlugin redPacketPullNewPlugin = RedPacketPullNewPlugin.this;
                        redPacketPullNewPlugin.uploadContact(redPacketPullNewPlugin.mCallbackContext);
                    }
                }
            });
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onResume(boolean z) {
        super.onResume(z);
        this.resumeTime = System.currentTimeMillis();
        this.paused = false;
    }
}
