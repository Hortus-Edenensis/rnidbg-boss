package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.platform.comapi.map.MapController;
import com.vivo.push.g.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import defpackage.l24;
import defpackage.sz3;
import defpackage.tz3;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NotifyAdapterUtil {
    private static final String EXTRA_VPUSH_TYPE = "extra_vpush_type";
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static final String USER_ID = "sysUserId";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    private static boolean cancelNotify(Context context, int i) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i);
        return true;
    }

    private static synchronized void initAdapter(Context context) {
        NotificationManager notificationManager;
        if (sNotificationManager == null) {
            sNotificationManager = (NotificationManager) context.getSystemService("notification");
        }
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(MapController.DEFAULT_LAYER_TAG);
            if (notificationChannel != null) {
                CharSequence name = notificationChannel.getName();
                if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                    sNotificationManager.deleteNotificationChannel(MapController.DEFAULT_LAYER_TAG);
                }
            }
            NotificationChannel notificationChannel2 = sNotificationManager.getNotificationChannel(PRIMARY_CHANNEL);
            StringBuilder sb = new StringBuilder("initAdapter PRIMARY_CHANNEL yi exist ？= ");
            sb.append(notificationChannel2 == null);
            sb.append(" 是否支持创建推送通知渠道= ");
            sb.append(com.vivo.push.restructure.a.a().g().e());
            t.c(TAG, sb.toString());
            if (!com.vivo.push.restructure.a.a().g().e() || notificationChannel2 == null) {
                String str = isZh(context) ? PUSH_ZH : PUSH_EN;
                tz3.a();
                NotificationChannel notificationChannelA = sz3.a(PRIMARY_CHANNEL, str, 4);
                notificationChannelA.setLightColor(-16711936);
                notificationChannelA.enableVibration(true);
                notificationChannelA.setLockscreenVisibility(1);
                sNotificationManager.createNotificationChannel(notificationChannelA);
            }
        }
    }

    private static boolean isPullService() {
        return m.f11305a ? Build.VERSION.SDK_INT < 31 : Build.VERSION.SDK_INT < 28;
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        t.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j, i, notifyArriveCallbackByUser, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j, notifyArriveCallbackByUser, aVar);
        }
    }

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        Notification notificationBuild;
        Bitmap bitmap;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong(PUSH_ID, j);
        if (com.vivo.push.restructure.a.a().e().l().isOpenMultiUser()) {
            bundle.putInt(USER_ID, v.a());
        }
        bundle.putInt(EXTRA_VPUSH_TYPE, 1);
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder builderA = l24.a(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builderA.setExtras(bundle);
            notificationBuild = builderA.build();
        } else {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setExtras(bundle);
            notificationBuild = builder.build();
        }
        Notification notification = notificationBuild;
        notification.priority = 2;
        notification.flags = 16;
        notification.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i;
        }
        notification.icon = defaultSmallIconId;
        RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, 0);
        if (list == null || list.isEmpty() || (bitmap = list.get(0)) == null) {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        } else {
            remoteViews.setImageViewBitmap(suitIconId, bitmap);
        }
        Bitmap bitmap2 = (list == null || list.size() <= 1) ? null : list.get(1);
        if (bitmap2 == null) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        } else if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
        }
        notification.contentView = remoteViews;
        if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            notification.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        t.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        notification.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification.defaults |= 2;
                        notification.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification.defaults = 2;
                notification.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification.defaults = 1;
        }
        i iVar = new i();
        Intent intentA = iVar.a(context, packageName, j, insideNotificationItem, notifyArriveCallbackByUser);
        if (intentA == null) {
            t.a(TAG, "make notify intent error  ");
            return;
        }
        if (isPullService()) {
            notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), b.a(context, packageName, j, intentA, insideNotificationItem), 201326592);
        } else {
            new com.vivo.push.b.p(packageName, j, insideNotificationItem).b(intentA);
            notification.contentIntent = iVar.a(context, intentA);
        }
        if (sNotificationManager != null) {
            int iJ = com.vivo.push.m.a().j();
            try {
                if (iJ == 0) {
                    sNotificationManager.notify(sNotifyId, notification);
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                if (iJ != 1) {
                    t.a(TAG, "unknow notify style ".concat(String.valueOf(iJ)));
                    return;
                }
                sNotificationManager.notify((int) j, notification);
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Exception e) {
                t.a(TAG, e);
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        Bitmap bitmapA;
        Notification.Builder builderA;
        int i2;
        int i3;
        Bitmap bitmap;
        Intent intentA;
        Bitmap bitmapDecodeResource;
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        String content = insideNotificationItem.getContent();
        int i4 = context.getApplicationInfo().icon;
        boolean zIsShowTime = insideNotificationItem.isShowTime();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        if (list == null || list.isEmpty()) {
            bitmapA = null;
        } else {
            bitmapA = list.get(0);
            if (bitmapA != null && defaultNotifyIcon > 0 && (bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) != null) {
                int width = bitmapDecodeResource.getWidth();
                int height = bitmapDecodeResource.getHeight();
                bitmapDecodeResource.recycle();
                bitmapA = d.a(bitmapA, width, height);
            }
        }
        Bundle bundle = new Bundle();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            builderA = l24.a(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            if (bitmapA != null) {
                builderA.setLargeIcon(bitmapA);
            }
        } else {
            Notification.Builder builder = new Notification.Builder(context);
            if (bitmapA != null) {
                builder.setLargeIcon(bitmapA);
            } else if (i5 <= 22) {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i4));
            }
            builderA = builder;
        }
        if (com.vivo.push.restructure.a.a().e().l().isOpenMultiUser()) {
            bundle.putInt(USER_ID, v.a());
        }
        bundle.putInt(EXTRA_VPUSH_TYPE, 1);
        bundle.putLong(PUSH_ID, j);
        builderA.setExtras(bundle);
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId > 0) {
            i4 = defaultSmallIconId;
        }
        builderA.setSmallIcon(i4);
        if (insideNotificationItem.getCompatibleType() != 1) {
            builderA.setContentTitle(title);
        }
        builderA.setPriority(2);
        builderA.setContentText(content);
        builderA.setWhen(zIsShowTime ? System.currentTimeMillis() : 0L);
        builderA.setShowWhen(zIsShowTime);
        builderA.setTicker(title);
        int ringerMode = audioManager.getRingerMode();
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType == 2) {
            if (ringerMode == 2) {
                i2 = 1;
                builderA.setDefaults(1);
            }
            if (list != null || list.size() <= i2) {
                i3 = i;
                bitmap = null;
            } else {
                bitmap = list.get(i2);
                i3 = i;
            }
            if (i3 != i2) {
                Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                bigTextStyle.setBigContentTitle(title);
                bigTextStyle.bigText(content);
                builderA.setStyle(bigTextStyle);
            }
            if (bitmap != null) {
                Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                bigPictureStyle.setBigContentTitle(title);
                bigPictureStyle.setSummaryText(content);
                bigPictureStyle.bigPicture(bitmap);
                builderA.setStyle(bigPictureStyle);
            }
            builderA.setAutoCancel(true);
            i iVar = new i();
            intentA = iVar.a(context, packageName, j, insideNotificationItem, notifyArriveCallbackByUser);
            if (intentA != null) {
                t.a(TAG, "make notify intent error  ");
                return;
            }
            if (isPullService()) {
                builderA.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), b.a(context, packageName, j, intentA, insideNotificationItem), 201326592));
            } else {
                new com.vivo.push.b.p(packageName, j, insideNotificationItem).b(intentA);
                builderA.setContentIntent(iVar.a(context, intentA));
            }
            Notification notificationBuild = builderA.build();
            int iJ = com.vivo.push.m.a().j();
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                try {
                    if (iJ == 0) {
                        notificationManager.notify(sNotifyId, notificationBuild);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    if (iJ != 1) {
                        t.a(TAG, "unknow notify style ".concat(String.valueOf(iJ)));
                        return;
                    }
                    notificationManager.notify((int) j, notificationBuild);
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    t.a(TAG, e);
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (notifyType != 3) {
            if (notifyType == 4) {
                if (ringerMode == 2) {
                    builderA.setDefaults(3);
                    builderA.setVibrate(new long[]{0, 100, 200, 300});
                } else if (ringerMode == 1) {
                    builderA.setDefaults(2);
                    builderA.setVibrate(new long[]{0, 100, 200, 300});
                }
            }
        } else if (ringerMode == 2) {
            builderA.setDefaults(2);
            builderA.setVibrate(new long[]{0, 100, 200, 300});
        }
        i2 = 1;
        if (list != null) {
            i3 = i;
            bitmap = null;
        }
        if (i3 != i2) {
        }
        if (bitmap != null) {
        }
        builderA.setAutoCancel(true);
        i iVar2 = new i();
        intentA = iVar2.a(context, packageName, j, insideNotificationItem, notifyArriveCallbackByUser);
        if (intentA != null) {
        }
    }

    public static boolean repealNotifyById(Context context, long j) {
        int iJ = com.vivo.push.m.a().j();
        if (iJ != 0) {
            if (iJ == 1) {
                return cancelNotify(context, (int) j);
            }
            t.a(TAG, "unknow cancle notify style ".concat(String.valueOf(iJ)));
            return false;
        }
        long jB = ac.c().b("com.vivo.push.notify_key", -1L);
        if (jB == j) {
            t.d(TAG, "undo showed message ".concat(String.valueOf(j)));
            t.a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
            return cancelNotify(context, sNotifyId);
        }
        t.d(TAG, "current showing message id " + jB + " not match " + j);
        t.a(context, "与已展示的通知" + jB + "与待回收的通知" + j + "不匹配");
        return false;
    }

    public static void setNotifyId(int i) {
        sNotifyId = i;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }
}
