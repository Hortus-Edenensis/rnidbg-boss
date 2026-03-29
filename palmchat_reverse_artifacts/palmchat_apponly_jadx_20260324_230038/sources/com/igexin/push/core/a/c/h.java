package com.igexin.push.core.a.c;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.x;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.b.r;
import com.igexin.push.core.b.s;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.GetuiActivity;
import com.igexin.sdk.main.FeedbackImpl;
import com.oplus.tblplayer.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7156a = com.igexin.push.core.b.f + h.class.getName();
    private static final int b = 131;
    private static final String c = "push_small";

    /* JADX INFO: renamed from: com.igexin.push.core.a.c.h$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NotificationManager f7158a;
        final /* synthetic */ int b;
        final /* synthetic */ PushTaskBean c;

        public AnonymousClass2(NotificationManager notificationManager, int i, PushTaskBean pushTaskBean) {
            this.f7158a = notificationManager;
            this.b = i;
            this.c = pushTaskBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                StatusBarNotification[] activeNotifications = this.f7158a.getActiveNotifications();
                boolean z = false;
                if (activeNotifications != null && activeNotifications.length > 0) {
                    int length = activeNotifications.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (activeNotifications[i].getId() == this.b) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z) {
                    return;
                }
                String unused = h.f7156a;
                FeedbackImpl.getInstance().feedbackMessageAction(this.c, "10160", "show notification failed");
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        UNSET(0),
        BIG_IMAGE(1),
        LONG_TEXT(2),
        PURE_IMAGE(3);

        int e;

        a(int i) {
            this.e = i;
        }

        private int a() {
            return this.e;
        }
    }

    private static int a(com.igexin.push.core.b.l lVar, boolean z) {
        int identifier = 0;
        if (!z) {
            if (!TextUtils.isEmpty(com.igexin.push.core.e.aL) && (identifier = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aL, "drawable", com.igexin.push.core.e.g)) == 0) {
                identifier = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aL, "mipmap", com.igexin.push.core.e.g);
            }
            int identifier2 = com.igexin.push.core.e.l.getResources().getIdentifier("push", "drawable", com.igexin.push.core.e.g);
            if (identifier2 == 0) {
                identifier2 = com.igexin.push.core.e.l.getResources().getIdentifier("push", "mipmap", com.igexin.push.core.e.g);
            }
            if (TextUtils.isEmpty(lVar.f) || com.igexin.push.core.b.m.equals(lVar.f)) {
                return identifier > 0 ? identifier : identifier2;
            }
            if (lVar.f.startsWith("@")) {
                String str = lVar.f;
                return str.substring(1, str.length()).endsWith(NotificationCompat.CATEGORY_EMAIL) ? R.drawable.sym_action_email : R.drawable.sym_def_app_icon;
            }
            int identifier3 = com.igexin.push.core.e.l.getResources().getIdentifier(lVar.f, "drawable", com.igexin.push.core.e.g);
            if (identifier3 == 0) {
                identifier3 = com.igexin.push.core.e.l.getResources().getIdentifier(lVar.f, "mipmap", com.igexin.push.core.e.g);
            }
            return identifier3 > 0 ? identifier3 : identifier > 0 ? identifier : identifier2;
        }
        if (!TextUtils.isEmpty(com.igexin.push.core.e.aK)) {
            int identifier4 = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aK, "drawable", com.igexin.push.core.e.g);
            if (identifier4 == 0) {
                identifier4 = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aK, "mipmap", com.igexin.push.core.e.g);
            }
            if (identifier4 > 0) {
                return identifier4;
            }
        }
        int identifier5 = com.igexin.push.core.e.l.getResources().getIdentifier(c, "drawable", com.igexin.push.core.e.g);
        if (identifier5 == 0) {
            identifier5 = com.igexin.push.core.e.l.getResources().getIdentifier(c, "mipmap", com.igexin.push.core.e.g);
        }
        if (identifier5 != 0) {
            com.igexin.c.a.c.a.a(f7156a + "|push_small.png is set, use default push_small", new Object[0]);
            return identifier5;
        }
        String str2 = f7156a;
        com.igexin.c.a.c.a.a(str2, "|push_small.png is missing");
        com.igexin.c.a.c.a.a(str2 + "|push_small.png is missing", new Object[0]);
        return com.igexin.push.core.e.l.getApplicationInfo().icon;
    }

    @TargetApi(26)
    private static Notification.Builder b(com.igexin.push.core.b.l lVar) {
        Notification.Builder builder = new Notification.Builder(com.igexin.push.core.e.l);
        NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Constructor<?> constructor = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE);
            Class<?> cls2 = notificationManager.getClass();
            if (((Parcelable) cls2.getMethod("getNotificationChannel", String.class).invoke(notificationManager, lVar.j)) == null) {
                Parcelable parcelable = (Parcelable) constructor.newInstance(lVar.j, lVar.k, Integer.valueOf(lVar.l));
                Method method = cls2.getMethod("createNotificationChannel", Class.forName("android.app.NotificationChannel"));
                Method method2 = cls.getMethod("enableVibration", Boolean.TYPE);
                Method method3 = cls.getMethod("setSound", Uri.class, AudioAttributes.class);
                method2.invoke(parcelable, Boolean.valueOf(lVar.c));
                if (!lVar.d) {
                    method3.invoke(parcelable, null, null);
                } else if (!TextUtils.isEmpty(lVar.p)) {
                    method3.invoke(parcelable, c(lVar.p), null);
                }
                method.invoke(notificationManager, parcelable);
            }
            builder.getClass().getMethod("setChannelId", String.class).invoke(builder, lVar.j);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return builder;
    }

    private static Uri c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Uri.parse("android.resource://" + com.igexin.push.core.e.l.getPackageName() + "/raw/" + str.toLowerCase());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0366 A[Catch: all -> 0x0386, TRY_LEAVE, TryCatch #0 {all -> 0x0386, blocks: (B:128:0x031d, B:130:0x0325, B:134:0x0333, B:136:0x0338, B:150:0x0366, B:140:0x034e, B:142:0x0351, B:144:0x0355, B:147:0x0360), top: B:166:0x031d }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0381  */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        int i;
        int i2;
        int i3;
        String str;
        boolean z;
        Bitmap bitmapDecodeResource;
        Notification.Style styleBigText;
        String str2;
        int i4;
        PushTaskBean pushTaskBean2;
        boolean z2;
        Bitmap bitmapA;
        if (pushTaskBean == null || !(baseActionBean instanceof com.igexin.push.core.b.l)) {
            return true;
        }
        com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean;
        int iA = !lVar.n ? a(pushTaskBean.getTaskId()) : lVar.m;
        try {
            i = Integer.parseInt(lVar.getActionId().substring(lVar.getActionId().length() - 1)) + 30000;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            i = 0;
        }
        int i5 = lVar.r;
        String appKey = pushTaskBean.getAppKey();
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        String str3 = lVar.q;
        com.igexin.push.core.e.ai.put(taskId, Integer.valueOf(iA));
        com.igexin.push.core.a.b.d();
        PushTaskBean pushTaskBean3 = com.igexin.push.core.e.ah.get(com.igexin.push.core.a.b.a(taskId, messageId));
        if (pushTaskBean3 != null) {
            byte[] msgExtra = pushTaskBean3.getMsgExtra();
            if (msgExtra != null) {
                lVar.v = new String(msgExtra);
            }
            for (BaseActionBean baseActionBean2 : pushTaskBean3.getActionChains()) {
                if (baseActionBean2 instanceof s) {
                    String str4 = ((s) baseActionBean2).f7187a;
                    if (str4 == null) {
                        str4 = "";
                    }
                    lVar.t = str4;
                }
                if (baseActionBean2 instanceof r) {
                    String str5 = ((r) baseActionBean2).b;
                    lVar.u = str5 != null ? str5 : "";
                }
            }
        }
        int iA2 = a(lVar, true);
        if (iA2 == 0 || com.igexin.push.core.e.l.getResources().getDrawable(iA2) != null) {
            Notification notificationA = a(str3, iA2, lVar);
            PendingIntent pendingIntentA = a(str3, i5, taskId, messageId, iA, lVar);
            PendingIntent pendingIntentA2 = a(str3, i5, appKey, taskId, messageId, lVar);
            NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
            int i6 = Build.VERSION.SDK_INT;
            Notification.Builder builderB = i6 >= 26 ? b(lVar) : new Notification.Builder(com.igexin.push.core.e.l);
            String str6 = lVar.f7178a;
            String str7 = lVar.b;
            String str8 = lVar.D;
            if (TextUtils.isEmpty(str8)) {
                i2 = i;
                i3 = i5;
                str = messageId;
                z = false;
                bitmapDecodeResource = null;
            } else {
                bitmapDecodeResource = com.igexin.push.g.l.a(str8);
                str = messageId;
                String str9 = f7156a;
                i2 = i;
                StringBuilder sb = new StringBuilder("|use net logo bitmap is null = ");
                i3 = i5;
                sb.append(bitmapDecodeResource == null);
                com.igexin.c.a.c.a.a(str9, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str9);
                sb2.append("|use net logo bitmap is null = ");
                sb2.append(bitmapDecodeResource == null);
                String string = sb2.toString();
                z = false;
                com.igexin.c.a.c.a.a(string, new Object[0]);
            }
            if (bitmapDecodeResource == null) {
                bitmapDecodeResource = BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(lVar, z));
            }
            builderB.setSmallIcon(iA2).setTicker(lVar.b).setWhen(System.currentTimeMillis()).setContentTitle(str6).setContentIntent(pendingIntentA).setContentText(str7).setDeleteIntent(pendingIntentA2);
            if (!TextUtils.isEmpty(lVar.w)) {
                builderB.setCategory(lVar.w);
            }
            if (bitmapDecodeResource != null) {
                builderB.setLargeIcon(bitmapDecodeResource);
            }
            builderB.setShowWhen(true);
            if (i6 >= 24 && !TextUtils.isEmpty(lVar.i)) {
                try {
                    builderB.setColor(Color.parseColor(lVar.i));
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
            int i7 = Build.VERSION.SDK_INT;
            int i8 = lVar.C;
            if (i8 == a.BIG_IMAGE.e) {
                String str10 = lVar.E;
                if (!TextUtils.isEmpty(str10) && (bitmapA = com.igexin.push.g.l.a(str10)) != null) {
                    builderB.setPriority(lVar.x);
                    styleBigText = new Notification.BigPictureStyle().bigPicture(bitmapA);
                    builderB.setStyle(styleBigText);
                }
                if (lVar.z && (lVar.c || lVar.d)) {
                    builderB.setPriority(2);
                }
                if (!TextUtils.isEmpty(str3) || i7 < 24) {
                    str2 = str3;
                } else {
                    str2 = str3;
                    if (com.igexin.push.core.e.aj.containsKey(str2)) {
                        builderB.setGroup(str2);
                        builderB.setGroupSummary(false);
                        HashSet<String> hashSet = com.igexin.push.core.e.aj.get(str2) == null ? new HashSet<>() : com.igexin.push.core.e.aj.get(str2);
                        hashSet.add(taskId);
                        com.igexin.push.core.e.aj.put(str2, hashSet);
                    }
                }
                builderB.setWhen(System.currentTimeMillis());
                Notification notification = builderB.getNotification();
                notification.defaults = 4;
                notification.ledARGB = -16711936;
                notification.ledOnMS = 1000;
                notification.ledOffMS = 3000;
                notification.flags = 1;
                notification.flags = !lVar.e ? 1 | 16 : 1 | 32;
                if (lVar.c) {
                    notification.defaults = 2 | 4;
                }
                if (lVar.d) {
                    if (TextUtils.isEmpty(lVar.p)) {
                        notification.defaults |= 1;
                    } else {
                        notification.sound = c(lVar.p);
                    }
                }
                i4 = lVar.o;
                if (i4 > 0) {
                    com.igexin.push.g.d.a(i4, false);
                    com.igexin.push.g.d.c(lVar.o, false);
                    com.igexin.push.g.d.b(lVar.o, false);
                }
                notification.icon = a(lVar, true);
                a(notification);
                if (!TextUtils.isEmpty(str2) && notificationA != null) {
                    int iA3 = a(str2);
                    com.igexin.push.core.e.ak.put(str2, Integer.valueOf(iA3));
                    notificationManager.notify(iA3, notificationA);
                }
                com.igexin.c.a.c.a.a(f7156a + "|showNotification notification:" + iA, new Object[0]);
                if (i3 > 0) {
                    notificationManager.cancel(iA);
                }
                notificationManager.notify(iA, notification);
                com.igexin.push.core.l.a().a(taskId, str, str6, str7, lVar.t, lVar.u, lVar.v);
                try {
                    if (!TextUtils.isEmpty(com.igexin.push.config.d.al) || com.igexin.push.config.d.al.equals(com.igexin.push.core.b.m) || i7 < 23 || com.igexin.push.core.e.J != 1) {
                        pushTaskBean2 = pushTaskBean;
                    } else {
                        String[] strArrSplit = com.igexin.push.config.d.al.split(",");
                        if (com.igexin.push.config.d.al.equals("*")) {
                            z2 = true;
                            if (!z2) {
                            }
                        } else {
                            if (strArrSplit != null && strArrSplit.length > 0) {
                                for (String str11 : strArrSplit) {
                                    if (str11.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            z2 = false;
                            if (!z2) {
                                pushTaskBean2 = pushTaskBean;
                                try {
                                    com.igexin.b.a.a().b().schedule(new AnonymousClass2(notificationManager, iA, pushTaskBean2), 300L, TimeUnit.MILLISECONDS);
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.igexin.c.a.c.a.a(th);
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    pushTaskBean2 = pushTaskBean;
                }
            } else {
                if (i8 == a.LONG_TEXT.e) {
                    String str12 = lVar.B;
                    if (!TextUtils.isEmpty(str12)) {
                        builderB.setPriority(lVar.x);
                        styleBigText = new Notification.BigTextStyle().bigText(str12);
                        builderB.setStyle(styleBigText);
                    }
                }
                if (lVar.z) {
                    builderB.setPriority(2);
                }
                if (TextUtils.isEmpty(str3)) {
                    str2 = str3;
                    builderB.setWhen(System.currentTimeMillis());
                    Notification notification2 = builderB.getNotification();
                    notification2.defaults = 4;
                    notification2.ledARGB = -16711936;
                    notification2.ledOnMS = 1000;
                    notification2.ledOffMS = 3000;
                    notification2.flags = 1;
                    notification2.flags = !lVar.e ? 1 | 16 : 1 | 32;
                    if (lVar.c) {
                    }
                    if (lVar.d) {
                    }
                    i4 = lVar.o;
                    if (i4 > 0) {
                    }
                    notification2.icon = a(lVar, true);
                    a(notification2);
                    if (!TextUtils.isEmpty(str2)) {
                        int iA32 = a(str2);
                        com.igexin.push.core.e.ak.put(str2, Integer.valueOf(iA32));
                        notificationManager.notify(iA32, notificationA);
                    }
                    com.igexin.c.a.c.a.a(f7156a + "|showNotification notification:" + iA, new Object[0]);
                    if (i3 > 0) {
                    }
                    notificationManager.notify(iA, notification2);
                    com.igexin.push.core.l.a().a(taskId, str, str6, str7, lVar.t, lVar.u, lVar.v);
                    if (TextUtils.isEmpty(com.igexin.push.config.d.al)) {
                        pushTaskBean2 = pushTaskBean;
                    }
                }
            }
        } else {
            com.igexin.c.a.c.a.a(f7156a + "|showNotification smallIconId: " + iA2 + " couldn't find resource", new Object[0]);
            pushTaskBean2 = pushTaskBean;
            i2 = i;
        }
        if (i2 != 0) {
            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, String.valueOf(i2), "notifyStyle:" + lVar.h);
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(pushTaskBean.getTaskId(), com.igexin.push.core.b.aj, lVar.r);
        pushTaskBean2.setPerActionid(Integer.parseInt(lVar.getActionId()));
        pushTaskBean2.setCurrentActionid(Integer.parseInt(lVar.getDoActionId()));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseActionBean parseAction(JSONObject jSONObject) {
        int i;
        int i2;
        try {
            com.igexin.push.core.b.l lVar = new com.igexin.push.core.b.l();
            lVar.setType("notification");
            lVar.setActionId(jSONObject.getString("actionid"));
            lVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("notifyStyle")) {
                try {
                    i = jSONObject.getInt("notifyStyle");
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (jSONObject.has("id")) {
                lVar.y = jSONObject.getString("id");
            }
            if (jSONObject.has("title")) {
                lVar.f7178a = jSONObject.getString("title");
            }
            if (jSONObject.has("text")) {
                lVar.b = jSONObject.getString("text");
            }
            if (TextUtils.isEmpty(lVar.f7178a) && TextUtils.isEmpty(lVar.b) && i != 4) {
                String str = f7156a;
                com.igexin.c.a.c.a.a(str, "title and content is empty, not support");
                com.igexin.c.a.c.a.a(str + "|title and content is empty, not support", new Object[0]);
                return null;
            }
            if (jSONObject.has("bigStyle")) {
                try {
                    i2 = jSONObject.getInt("bigStyle");
                } catch (Exception unused) {
                    i2 = 0;
                }
                if (i2 > 3 || i2 <= 0) {
                    i2 = 0;
                }
            }
            lVar.C = i2;
            if (jSONObject.has("logo_url") && jSONObject.getString("logo_url").startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                lVar.g = jSONObject.getString("logo_url");
            }
            if (jSONObject.has("logo") && !"".equals(jSONObject.getString("logo"))) {
                String string = jSONObject.getString("logo");
                if (string.lastIndexOf(".png") == -1 && string.lastIndexOf(".jpeg") == -1) {
                    string = "";
                    lVar.f = string;
                } else {
                    int iIndexOf = string.indexOf(".png");
                    if (iIndexOf == -1) {
                        iIndexOf = string.indexOf(".jpeg");
                    }
                    if (iIndexOf != -1) {
                        string = string.substring(0, iIndexOf);
                        if (Pattern.compile("^\\d+$").matcher(string).matches()) {
                            string = "";
                        }
                    }
                    lVar.f = string;
                }
            }
            try {
                if (jSONObject.has("priority")) {
                    int i3 = jSONObject.getInt("priority");
                    if (i3 <= -3 || i3 >= 3) {
                        lVar.x = 0;
                    } else {
                        lVar.x = i3;
                    }
                }
            } catch (Exception unused2) {
                lVar.x = 0;
            }
            if (i2 == 1 && jSONObject.has("big_image_url") && jSONObject.getString("big_image_url").startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                lVar.A = jSONObject.getString("big_image_url");
            } else if (i2 == 2 && jSONObject.has("big_text") && !jSONObject.getString("big_text").equals("")) {
                lVar.B = jSONObject.getString("big_text");
            } else if (i2 == 3) {
                com.igexin.c.a.c.a.a(f7156a + "big style = 3 doesn't support", new Object[0]);
                return null;
            }
            if (jSONObject.has("isFloat")) {
                jSONObject.getBoolean("isFloat");
                lVar.z = jSONObject.getBoolean("isFloat");
            }
            if (jSONObject.has("is_noclear")) {
                lVar.e = !jSONObject.getBoolean("is_noclear");
            }
            if (jSONObject.has("is_novibrate")) {
                lVar.c = !jSONObject.getBoolean("is_novibrate");
            }
            if (jSONObject.has("is_noring")) {
                lVar.d = !jSONObject.getBoolean("is_noring");
            }
            if (jSONObject.has("badgeAddNum")) {
                lVar.o = jSONObject.optInt("badgeAddNum");
            }
            if (jSONObject.has("ringName")) {
                lVar.p = jSONObject.getString("ringName");
            }
            if (jSONObject.has("color")) {
                lVar.i = jSONObject.getString("color");
            }
            if (jSONObject.has("channel")) {
                lVar.j = jSONObject.getString("channel");
            }
            if (jSONObject.has("channelName")) {
                lVar.k = jSONObject.getString("channelName");
            }
            if (jSONObject.has("channelLevel")) {
                lVar.a(jSONObject.getInt("channelLevel"));
            }
            int i4 = lVar.l;
            if (i4 > 4 || i4 < 0) {
                lVar.a(3);
            }
            if (jSONObject.has(x.cw)) {
                lVar.w = jSONObject.optString(x.cw, "");
            }
            if (jSONObject.has("notifyid")) {
                try {
                    lVar.m = Integer.parseInt(jSONObject.optString("notifyid"));
                    lVar.n = true;
                } catch (NumberFormatException unused3) {
                    com.igexin.c.a.c.a.a(f7156a + (" NotificationAction.parseAction() : " + jSONObject.optString("notifyid") + "_"), new Object[0]);
                }
            }
            if (jSONObject.has("group_id")) {
                lVar.q = jSONObject.getString("group_id");
            }
            if (jSONObject.has("redisplay_freq")) {
                lVar.r = jSONObject.getInt("redisplay_freq");
            }
            if (jSONObject.has("redisplay_duration")) {
                lVar.s = jSONObject.getLong("redisplay_duration");
            }
            return lVar;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        boolean z;
        if (!(baseActionBean instanceof com.igexin.push.core.b.l)) {
            return PushMessageInterface.ActionPrepareState.stop;
        }
        com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean;
        String str = lVar.g;
        String str2 = lVar.A;
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        boolean z2 = true;
        if (str2 != null) {
            String strA = com.igexin.push.g.j.a(str2);
            if (strA.equals("")) {
                lVar.G = false;
                z = true;
            } else {
                lVar.E = strA;
                z = false;
            }
        } else {
            z = false;
        }
        if (str != null) {
            String strA2 = com.igexin.push.g.j.a(str);
            if ("".equals(strA2)) {
                lVar.F = false;
            } else {
                lVar.D = strA2;
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (!z2 && !z) {
            return PushMessageInterface.ActionPrepareState.success;
        }
        if (z2) {
            a(str, taskId, messageId, baseActionBean, 2);
        }
        if (z) {
            a(str2, taskId, messageId, baseActionBean, 8);
        }
        return PushMessageInterface.ActionPrepareState.wait;
    }

    private static int a(String str) {
        int iCharAt = 0;
        for (int i = 0; i != str.length(); i++) {
            iCharAt = (iCharAt * 131) + str.charAt(i);
        }
        if (iCharAt == Integer.MIN_VALUE) {
            iCharAt = 1;
        }
        return Math.abs(iCharAt);
    }

    private static PendingIntent b(String str) {
        try {
            Context context = com.igexin.push.core.e.l;
            com.igexin.push.core.a.b.d();
            Intent intent = new Intent(context, (Class<?>) com.igexin.push.core.a.b.a(com.igexin.push.core.e.l));
            intent.putExtra("isSummary", true);
            intent.putExtra("action", "com.igexin.action.notification.delete");
            intent.putExtra("groupId", str);
            return PendingIntent.getService(com.igexin.push.core.e.l, new Random().nextInt(1000), intent, (com.igexin.push.g.n.a(com.igexin.push.core.e.l) < 31 || Build.VERSION.SDK_INT < 30) ? 134217728 : 201326592);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private static Notification a(String str, int i, com.igexin.push.core.b.l lVar) {
        int i2;
        Notification.Builder builder;
        if (TextUtils.isEmpty(str) || com.igexin.push.core.e.aj.containsKey(str) || (i2 = Build.VERSION.SDK_INT) < 24) {
            return null;
        }
        com.igexin.push.core.e.aj.put(str, new HashSet<>());
        PendingIntent pendingIntentB = b(str);
        if (i2 >= 26) {
            builder = new Notification.Builder(com.igexin.push.core.e.l);
            NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
            try {
                Constructor<?> constructor = Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE);
                Class<?> cls = notificationManager.getClass();
                if (((Parcelable) cls.getMethod("getNotificationChannel", String.class).invoke(notificationManager, lVar.j)) == null) {
                    cls.getMethod("createNotificationChannel", Class.forName("android.app.NotificationChannel")).invoke(notificationManager, (Parcelable) constructor.newInstance(lVar.j, lVar.k, Integer.valueOf(lVar.l)));
                }
                builder.getClass().getMethod("setChannelId", String.class).invoke(builder, lVar.j);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        } else {
            builder = new Notification.Builder(com.igexin.push.core.e.l);
        }
        Notification notificationBuild = builder.setContentTitle("summary").setContentText("summary").setDeleteIntent(pendingIntentB).setAutoCancel(false).setGroup(str).setSmallIcon(i).setGroupSummary(true).build();
        if (TextUtils.isEmpty(lVar.w)) {
            return notificationBuild;
        }
        builder.setCategory(lVar.w);
        return notificationBuild;
    }

    private static PendingIntent a(String str, int i, String str2, String str3, int i2, com.igexin.push.core.b.l lVar) {
        Intent intent = new Intent();
        intent.putExtra("taskid", str2);
        intent.putExtra("messageid", str3);
        intent.putExtra("appid", com.igexin.push.core.e.f7217a);
        intent.putExtra("actionid", lVar.getDoActionId());
        intent.putExtra("accesstoken", com.igexin.push.core.e.aC);
        intent.putExtra("notifID", i2);
        StringBuilder sb = new StringBuilder();
        sb.append(lVar.h);
        intent.putExtra("notifyStyle", sb.toString());
        intent.putExtra("id", lVar.y);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(lVar.C);
        intent.putExtra("bigStyle", sb2.toString());
        intent.putExtra("isFloat", false);
        intent.putExtra("checkpackage", com.igexin.push.core.e.l.getPackageName());
        intent.putExtra("feedbackid", lVar.getActionId().substring(lVar.getActionId().length() - 1));
        String str4 = lVar.f7178a;
        if (str4 == null) {
            str4 = "";
        }
        intent.putExtra("title", str4);
        String str5 = lVar.b;
        if (str5 == null) {
            str5 = "";
        }
        intent.putExtra("content", str5);
        intent.putExtra("redisplayFreq", i);
        intent.putExtra("groupId", str);
        String str6 = lVar.t;
        if (str6 == null) {
            str6 = "";
        }
        intent.putExtra("url", str6);
        String str7 = lVar.u;
        if (str7 == null) {
            str7 = "";
        }
        intent.putExtra(RemoteMessageConst.Notification.INTENT_URI, str7);
        String str8 = lVar.v;
        intent.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, str8 != null ? str8 : "");
        int i3 = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
        try {
            Intent intent2 = new Intent(com.igexin.push.core.e.l, (Class<?>) GetuiActivity.class);
            intent2.setFlags(268435456);
            intent2.putExtra("action", "com.igexin.action.notification.click");
            intent2.putExtra("broadcast_intent", intent);
            return PendingIntent.getActivity(com.igexin.push.core.e.l, new Random().nextInt(1000), intent2, i3);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            Intent intent3 = new Intent("com.igexin.action.notification.click");
            intent3.setAction("com.igexin.action.notification.click");
            intent3.putExtra("action", "com.igexin.action.notification.click");
            intent3.putExtra("broadcast_intent", intent);
            return PendingIntent.getBroadcast(com.igexin.push.core.e.l, new Random().nextInt(1000), intent3, i3);
        }
    }

    private static PendingIntent a(String str, int i, String str2, String str3, String str4, com.igexin.push.core.b.l lVar) {
        try {
            Context context = com.igexin.push.core.e.l;
            com.igexin.push.core.a.b.d();
            Intent intent = new Intent(context, (Class<?>) com.igexin.push.core.a.b.a(com.igexin.push.core.e.l));
            intent.putExtra("taskid", str3);
            intent.putExtra("messageid", str4);
            intent.putExtra("appid", com.igexin.push.core.e.f7217a);
            intent.putExtra("appkey", str2);
            intent.putExtra("actionid", lVar.getDoActionId());
            StringBuilder sb = new StringBuilder();
            sb.append(lVar.h);
            intent.putExtra("notifyStyle", sb.toString());
            intent.putExtra("id", lVar.y);
            intent.putExtra("feedbackid", lVar.getActionId().substring(lVar.getActionId().length() + (-1)));
            intent.putExtra("action", "com.igexin.action.notification.delete");
            intent.putExtra("redisplayFreq", i);
            intent.putExtra("groupId", str);
            return PendingIntent.getService(com.igexin.push.core.e.l, new Random().nextInt(1000), intent, (com.igexin.push.g.n.a(com.igexin.push.core.e.l) < 31 || Build.VERSION.SDK_INT < 30) ? 134217728 : 201326592);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(f7156a + "|getDelPendingIntent err：" + e.toString(), new Object[0]);
            return null;
        }
    }

    private static Bitmap a(com.igexin.push.core.b.l lVar) {
        Bitmap bitmapA;
        String str = lVar.D;
        if (TextUtils.isEmpty(str)) {
            bitmapA = null;
        } else {
            bitmapA = com.igexin.push.g.l.a(str);
            String str2 = f7156a;
            StringBuilder sb = new StringBuilder("|use net logo bitmap is null = ");
            sb.append(bitmapA == null);
            com.igexin.c.a.c.a.a(str2, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append("|use net logo bitmap is null = ");
            sb2.append(bitmapA == null);
            com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
        }
        if (bitmapA == null) {
            return BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(lVar, false));
        }
        return bitmapA;
    }

    private static void a(Notification notification) {
        if (com.igexin.push.g.a.b() || Build.VERSION.SDK_INT >= 24) {
            return;
        }
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("right_icon");
            field.setAccessible(true);
            int i = field.getInt(null);
            RemoteViews remoteViews = notification.contentView;
            if (remoteViews != null) {
                remoteViews.setViewVisibility(i, 8);
                notification.bigContentView.setViewVisibility(i, 8);
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void a(Notification notification, com.igexin.push.core.b.l lVar) {
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = lVar.e ? 1 | 16 : 1 | 32;
        if (lVar.c) {
            notification.defaults = 4 | 2;
        }
        if (lVar.d) {
            if (TextUtils.isEmpty(lVar.p)) {
                notification.defaults |= 1;
            } else {
                notification.sound = c(lVar.p);
            }
        }
        int i = lVar.o;
        if (i > 0) {
            com.igexin.push.g.d.a(i, false);
            com.igexin.push.g.d.c(lVar.o, false);
            com.igexin.push.g.d.b(lVar.o, false);
        }
        notification.icon = a(lVar, true);
    }

    private static void a(com.igexin.push.core.b.l lVar, String str, String str2, String str3, String str4) {
        com.igexin.push.core.l.a().a(str, str2, str3, str4, lVar.t, lVar.u, lVar.v);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x031c A[Catch: all -> 0x033a, TRY_LEAVE, TryCatch #2 {all -> 0x033a, blocks: (B:115:0x02d4, B:117:0x02dc, B:121:0x02ea, B:123:0x02ee, B:137:0x031c, B:127:0x0304, B:129:0x0307, B:131:0x030b, B:134:0x0316), top: B:153:0x02d4 }] */
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PushTaskBean pushTaskBean, com.igexin.push.core.b.l lVar, int i) {
        int i2;
        String str;
        boolean z;
        Bitmap bitmapDecodeResource;
        Notification.Style styleBigText;
        boolean z2;
        Bitmap bitmapA;
        int i3 = lVar.r;
        String appKey = pushTaskBean.getAppKey();
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        String str2 = lVar.q;
        com.igexin.push.core.e.ai.put(taskId, Integer.valueOf(i));
        com.igexin.push.core.a.b.d();
        PushTaskBean pushTaskBean2 = com.igexin.push.core.e.ah.get(com.igexin.push.core.a.b.a(taskId, messageId));
        if (pushTaskBean2 != null) {
            byte[] msgExtra = pushTaskBean2.getMsgExtra();
            if (msgExtra != null) {
                lVar.v = new String(msgExtra);
            }
            for (BaseActionBean baseActionBean : pushTaskBean2.getActionChains()) {
                if (baseActionBean instanceof s) {
                    String str3 = ((s) baseActionBean).f7187a;
                    if (str3 == null) {
                        str3 = "";
                    }
                    lVar.t = str3;
                }
                if (baseActionBean instanceof r) {
                    String str4 = ((r) baseActionBean).b;
                    lVar.u = str4 != null ? str4 : "";
                }
            }
        }
        int iA = a(lVar, true);
        if (iA != 0 && com.igexin.push.core.e.l.getResources().getDrawable(iA) == null) {
            com.igexin.c.a.c.a.a(f7156a + "|showNotification smallIconId: " + iA + " couldn't find resource", new Object[0]);
            return;
        }
        Notification notificationA = a(str2, iA, lVar);
        PendingIntent pendingIntentA = a(str2, i3, taskId, messageId, i, lVar);
        PendingIntent pendingIntentA2 = a(str2, i3, appKey, taskId, messageId, lVar);
        NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
        int i4 = Build.VERSION.SDK_INT;
        Notification.Builder builderB = i4 >= 26 ? b(lVar) : new Notification.Builder(com.igexin.push.core.e.l);
        String str5 = lVar.f7178a;
        String str6 = lVar.b;
        String str7 = lVar.D;
        if (TextUtils.isEmpty(str7)) {
            i2 = i3;
            str = messageId;
            z = false;
            bitmapDecodeResource = null;
        } else {
            bitmapDecodeResource = com.igexin.push.g.l.a(str7);
            String str8 = f7156a;
            str = messageId;
            i2 = i3;
            StringBuilder sb = new StringBuilder("|use net logo bitmap is null = ");
            sb.append(bitmapDecodeResource == null);
            com.igexin.c.a.c.a.a(str8, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str8);
            sb2.append("|use net logo bitmap is null = ");
            sb2.append(bitmapDecodeResource == null);
            z = false;
            com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
        }
        if (bitmapDecodeResource == null) {
            bitmapDecodeResource = BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(lVar, z));
        }
        builderB.setSmallIcon(iA).setTicker(lVar.b).setWhen(System.currentTimeMillis()).setContentTitle(str5).setContentIntent(pendingIntentA).setContentText(str6).setDeleteIntent(pendingIntentA2);
        if (!TextUtils.isEmpty(lVar.w)) {
            builderB.setCategory(lVar.w);
        }
        if (bitmapDecodeResource != null) {
            builderB.setLargeIcon(bitmapDecodeResource);
        }
        builderB.setShowWhen(true);
        if (i4 >= 24 && !TextUtils.isEmpty(lVar.i)) {
            try {
                builderB.setColor(Color.parseColor(lVar.i));
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        int i6 = lVar.C;
        if (i6 == a.BIG_IMAGE.e) {
            String str9 = lVar.E;
            if (!TextUtils.isEmpty(str9) && (bitmapA = com.igexin.push.g.l.a(str9)) != null) {
                builderB.setPriority(lVar.x);
                styleBigText = new Notification.BigPictureStyle().bigPicture(bitmapA);
                builderB.setStyle(styleBigText);
            }
        } else if (i6 == a.LONG_TEXT.e) {
            String str10 = lVar.B;
            if (!TextUtils.isEmpty(str10)) {
                builderB.setPriority(lVar.x);
                styleBigText = new Notification.BigTextStyle().bigText(str10);
                builderB.setStyle(styleBigText);
            }
        }
        if (lVar.z && (lVar.c || lVar.d)) {
            builderB.setPriority(2);
        }
        if (!TextUtils.isEmpty(str2) && i5 >= 24 && com.igexin.push.core.e.aj.containsKey(str2)) {
            builderB.setGroup(str2);
            builderB.setGroupSummary(false);
            HashSet<String> hashSet = com.igexin.push.core.e.aj.get(str2) == null ? new HashSet<>() : com.igexin.push.core.e.aj.get(str2);
            hashSet.add(taskId);
            com.igexin.push.core.e.aj.put(str2, hashSet);
        }
        builderB.setWhen(System.currentTimeMillis());
        Notification notification = builderB.getNotification();
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = lVar.e ? 1 | 16 : 1 | 32;
        if (lVar.c) {
            notification.defaults = 4 | 2;
        }
        if (lVar.d) {
            if (TextUtils.isEmpty(lVar.p)) {
                notification.defaults |= 1;
            } else {
                notification.sound = c(lVar.p);
            }
        }
        int i7 = lVar.o;
        if (i7 > 0) {
            com.igexin.push.g.d.a(i7, false);
            com.igexin.push.g.d.c(lVar.o, false);
            com.igexin.push.g.d.b(lVar.o, false);
        }
        notification.icon = a(lVar, true);
        a(notification);
        if (!TextUtils.isEmpty(str2) && notificationA != null) {
            int iA2 = a(str2);
            com.igexin.push.core.e.ak.put(str2, Integer.valueOf(iA2));
            notificationManager.notify(iA2, notificationA);
        }
        com.igexin.c.a.c.a.a(f7156a + "|showNotification notification:" + i, new Object[0]);
        if (i2 > 0) {
            notificationManager.cancel(i);
        }
        notificationManager.notify(i, notification);
        com.igexin.push.core.l.a().a(taskId, str, str5, str6, lVar.t, lVar.u, lVar.v);
        try {
            if (!TextUtils.isEmpty(com.igexin.push.config.d.al) && !com.igexin.push.config.d.al.equals(com.igexin.push.core.b.m) && i5 >= 23 && com.igexin.push.core.e.J == 1) {
                String[] strArrSplit = com.igexin.push.config.d.al.split(",");
                if (!com.igexin.push.config.d.al.equals("*")) {
                    if (strArrSplit != null && strArrSplit.length > 0) {
                        for (String str11 : strArrSplit) {
                            if (!str11.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        try {
                            com.igexin.b.a.a().b().schedule(new AnonymousClass2(notificationManager, i, pushTaskBean), 300L, TimeUnit.MILLISECONDS);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            com.igexin.c.a.c.a.a(th);
                            return;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final String str3, final BaseActionBean baseActionBean, final int i) {
        String str4;
        String str5;
        String str6 = "width=" + com.igexin.push.core.e.k + "&height=" + com.igexin.push.core.e.j;
        if (str.contains(str6)) {
            str4 = str;
        } else {
            if (str.indexOf(Constants.STRING_VALUE_UNSET) > 0) {
                str5 = str + ContainerUtils.FIELD_DELIMITER + str6;
            } else {
                str5 = str + Constants.STRING_VALUE_UNSET + str6;
            }
            str4 = str5;
        }
        com.igexin.push.core.h.b bVar = new com.igexin.push.core.h.b(str4, str, str2, baseActionBean, i, new com.igexin.push.core.h.d() { // from class: com.igexin.push.core.a.c.h.1
            @Override // com.igexin.push.core.h.d
            public final void a() {
                BaseActionBean baseActionBean2 = baseActionBean;
                if (((com.igexin.push.core.b.l) baseActionBean2).H >= 3) {
                    ((com.igexin.push.core.b.l) baseActionBean2).F = true;
                }
                if (((com.igexin.push.core.b.l) baseActionBean2).I >= 3) {
                    ((com.igexin.push.core.b.l) baseActionBean2).G = true;
                }
                if (!((com.igexin.push.core.b.l) baseActionBean2).F || !((com.igexin.push.core.b.l) baseActionBean2).G) {
                    h.this.a(str, str2, str3, baseActionBean2, i);
                    return;
                }
                if (com.igexin.push.core.e.a(str2) == 0) {
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(com.igexin.push.core.b.ah, str2);
                    Map<String, PushTaskBean> map = com.igexin.push.core.e.ah;
                    com.igexin.push.core.a.b.d();
                    PushTaskBean pushTaskBean = map.get(com.igexin.push.core.a.b.a(str2, str3));
                    if (pushTaskBean != null) {
                        pushTaskBean.setStatus(com.igexin.push.core.b.ah);
                    }
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(str2, str3, "1");
                }
            }

            @Override // com.igexin.push.core.h.d
            public final void a(BaseActionBean baseActionBean2) {
                int i2 = i;
                if (i2 == 2) {
                    ((com.igexin.push.core.b.l) baseActionBean).F = true;
                } else if (i2 == 8) {
                    ((com.igexin.push.core.b.l) baseActionBean).G = true;
                }
                com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean2;
                if (lVar.F && lVar.G && com.igexin.push.core.e.a(str2) == 0) {
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(com.igexin.push.core.b.ah, str2);
                    Map<String, PushTaskBean> map = com.igexin.push.core.e.ah;
                    com.igexin.push.core.a.b.d();
                    PushTaskBean pushTaskBean = map.get(com.igexin.push.core.a.b.a(str2, str3));
                    if (pushTaskBean != null) {
                        pushTaskBean.setStatus(com.igexin.push.core.b.ah);
                    }
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(str2, str3, "1");
                }
            }
        });
        if (i == 2) {
            ((com.igexin.push.core.b.l) baseActionBean).H++;
        } else if (i == 8) {
            ((com.igexin.push.core.b.l) baseActionBean).I++;
        }
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.e(bVar), false, true);
    }
}
