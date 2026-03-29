package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class i extends b {
    private int e = 0;

    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Intent b(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        String packageName;
        Intent intentA;
        int iA;
        try {
            packageName = context.getPackageName();
        } catch (Exception e) {
            t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient parsing error : " + e.getMessage());
            this.e = 2159;
        }
        if (insideNotificationItem != null && !TextUtils.isEmpty(packageName)) {
            t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient getSkipType ：：" + insideNotificationItem.getSkipType());
            int skipType = insideNotificationItem.getSkipType();
            boolean z = true;
            if (skipType != 1) {
                if (skipType == 2) {
                    String skipContent = insideNotificationItem.getSkipContent();
                    if (!TextUtils.isEmpty(skipContent)) {
                        String lowerCase = skipContent.toLowerCase();
                        if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                            z = false;
                        }
                        if (z) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(skipContent));
                            intent.setFlags(268435456);
                            a(intent, insideNotificationItem.getParams());
                            t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url urlAddr ::".concat(String.valueOf(skipContent)));
                            intentA = intent;
                        } else {
                            t.c(context, " 跳转参数不合法，打开网页地址不符合要求 通知未展示 2157");
                            t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url not legal");
                            this.e = 2157;
                            intentA = null;
                        }
                    }
                } else if (skipType == 3) {
                    String skipContent2 = insideNotificationItem.getSkipContent();
                    t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + insideNotificationItem.getSkipContent());
                    if (notifyArriveCallbackByUser.getIntent() != null) {
                        t.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   not null  ");
                        try {
                            intentA = notifyArriveCallbackByUser.getIntent();
                            intentA.setSelector(null);
                            intentA.setFlags(335544320);
                            b(intentA, insideNotificationItem.getParams());
                            iA = a(intentA, packageName);
                        } catch (Exception e2) {
                            t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(skipContent2)), e2);
                            this.e = 2158;
                        }
                        if (iA > 0) {
                            this.e = iA;
                            intentA = null;
                        }
                    } else {
                        t.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   is null 根据skipcontent生成跳转参数 ");
                        intentA = a(skipContent2, packageName, insideNotificationItem, context);
                    }
                } else if (skipType != 4) {
                    t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : intent null");
                    this.e = 2159;
                    intentA = null;
                } else {
                    String skipContent3 = insideNotificationItem.getSkipContent();
                    t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + insideNotificationItem.getSkipContent());
                    intentA = a(skipContent3, packageName, insideNotificationItem, context);
                }
                return null;
            }
            intentA = a(insideNotificationItem.getParams(), packageName, context);
            if (intentA == null) {
                t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : " + insideNotificationItem.getSkipType());
                return null;
            }
            intentA.putExtra("vivo_push_messageId", b());
            intentA.putExtra("command_type", "reflect_receiver");
            b.a(intentA, context);
            this.e = 0;
            return intentA;
        }
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient notify == null");
        this.e = 2159;
        return null;
    }

    @Override // com.vivo.push.util.b
    public final int a() {
        return this.e;
    }

    @Override // com.vivo.push.util.b
    public final Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    @Override // com.vivo.push.util.b
    public final PendingIntent a(Context context, Intent intent) {
        return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    private Intent a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.setSelector(null);
            uri.setPackage(str2);
            uri.setFlags(335544320);
            a(uri, insideNotificationItem.getParams());
            int iA = a(uri, str2);
            if (iA <= 0) {
                return uri;
            }
            this.e = iA;
            t.c(context, " 落地页未找到，通知不展示：  " + this.e);
            return null;
        } catch (Exception e) {
            t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e);
            this.e = 2158;
            return null;
        }
    }

    private Intent a(Map<String, String> map, String str, Context context) {
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
            if (intent != null) {
                intent.setFlags(335544320);
                a(intent, map);
            } else {
                this.e = 2162;
                t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e) {
            t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e.getMessage());
        }
        return intent;
    }

    private static Intent a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int a(Intent intent, String str) {
        int iA = a(intent);
        t.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(iA)));
        if (iA != 0) {
            return iA;
        }
        int iB = b(intent, str);
        t.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(iB)));
        if (iB != 0) {
            return iB;
        }
        return 0;
    }

    private int a(Intent intent) {
        if (intent.resolveActivityInfo(this.c.getPackageManager(), 65536) != null) {
            return 0;
        }
        t.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        t.c(this.c, " 跳转参数对应的Activity找不到 通知不展示   2162");
        return 2162;
    }

    private static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && !intent.hasExtra(entry.getKey())) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int b(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : intent.getPackage();
                if (TextUtils.isEmpty(packageName) || TextUtils.equals(str, packageName)) {
                    return 0;
                }
                t.d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + packageName);
                t.a(this.c, " 跳转参数对应的包名不是当前应用包名    local pkgName is " + str + "; but remote pkgName is " + packageName + " code =2813");
                return 2813;
            } catch (Exception e) {
                t.a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e.getMessage());
                return 2158;
            }
        }
        StringBuilder sb = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object obj = intent;
        if (intent == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(" mPkgName = ");
        sb.append(str);
        t.a("AndroidTwelveNotifyClickIntentParam", sb.toString());
        return 2158;
    }
}
