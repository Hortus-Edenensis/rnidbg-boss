package com.zenmen.palmchat.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.bq;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.NoticeBarExt;
import com.zenmen.palmchat.Vo.NoticeBarExtStyle;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.NewContactActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.notification.NotificationChannelManager;
import com.zenmen.palmchat.smallvideo.EnterScene;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.smallvideo.VideoSDKPushReceiver;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.a65;
import defpackage.ac1;
import defpackage.az2;
import defpackage.b05;
import defpackage.bq6;
import defpackage.br3;
import defpackage.ch;
import defpackage.dd6;
import defpackage.dx5;
import defpackage.es3;
import defpackage.fk2;
import defpackage.fu5;
import defpackage.gr2;
import defpackage.h05;
import defpackage.hc2;
import defpackage.hs0;
import defpackage.ir5;
import defpackage.j94;
import defpackage.jo6;
import defpackage.jr2;
import defpackage.k86;
import defpackage.lg6;
import defpackage.m40;
import defpackage.mb4;
import defpackage.n5;
import defpackage.qj5;
import defpackage.r75;
import defpackage.st2;
import defpackage.t34;
import defpackage.t5;
import defpackage.to;
import defpackage.tw5;
import defpackage.u93;
import defpackage.vp3;
import defpackage.vs0;
import defpackage.w24;
import defpackage.x24;
import defpackage.xa3;
import defpackage.xg5;
import defpackage.yg4;
import defpackage.zn6;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static a p;
    public static final long[] q = {0, 0, 0, 0};
    public static final long[] r = {100, 200, 300, 200};
    public boolean l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, s> f15717a = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, s> d = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, s> e = new ConcurrentHashMap<>();
    public int f = 0;
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public long m = 0;
    public Boolean n = null;
    public boolean o = false;
    public NotificationManager k = (NotificationManager) AppContext.getContext().getSystemService("notification");

    /* JADX INFO: renamed from: com.zenmen.palmchat.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC1122a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageProto.Message f15718a;

        public RunnableC1122a(MessageProto.Message message) {
            this.f15718a = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageProto.Message message = this.f15718a;
            if (message != null) {
                a.this.w0(message);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoticeBarStyle f15720a;

        public c(NoticeBarStyle noticeBarStyle) {
            this.f15720a = noticeBarStyle;
            put("title", noticeBarStyle.title);
            put(MediaFormat.KEY_SUBTITLE, noticeBarStyle.digest);
            put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            NoticeBarExt noticeBarExt = noticeBarStyle.ext;
            if (noticeBarExt != null) {
                put("pushid", noticeBarExt.pushId);
                put("source_actsite", noticeBarStyle.ext.sourceActSite);
                put("videoid", noticeBarStyle.ext.videoId);
                put(EventParams.KEY_PARAM_MEDIAID, noticeBarStyle.ext.mediaId);
                put("unionid", noticeBarStyle.ext.unionId);
                put("scene_from", noticeBarStyle.ext.sceneFrom);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements x24.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15723a;

        public f(String str) {
            this.f15723a = str;
        }

        @Override // x24.a
        public void a(Notification notification) {
            a.this.z0(a.this.M(this.f15723a + EventParams.KEY_GROUP), notification);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements x24.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15724a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public g(boolean z, String str, String str2, boolean z2) {
            this.f15724a = z;
            this.b = str;
            this.c = str2;
            this.d = z2;
        }

        @Override // x24.a
        public void a(Notification notification) {
            a.this.z0(a.this.F(this.f15724a, this.b + EventParams.KEY_GROUP, this.c + EventParams.KEY_GROUP, this.d, x24.d().f()), notification);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Notification f15726a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;

        public i(Notification notification, Context context, int i) {
            this.f15726a = notification;
            this.b = context;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Notification notification = this.f15726a;
            if (notification != null) {
                to.e(this.b, notification, this.c);
            } else {
                to.d(this.b, this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15728a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ContactInfoItem d;
        public final /* synthetic */ boolean e;

        public k(String str, String str2, String str3, ContactInfoItem contactInfoItem, boolean z) {
            this.f15728a = str;
            this.b = str2;
            this.c = str3;
            this.d = contactInfoItem;
            this.e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l0(this.f15728a, this.b, this.c, this.d, this.e);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements x24.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15730a;

        public m(String str) {
            this.f15730a = str;
        }

        @Override // x24.a
        public void a(Notification notification) {
            a.this.z0(a.this.D(this.f15730a + EventParams.KEY_GROUP), notification);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15731a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public n(String str, int i, String str2, boolean z) {
            this.f15731a = str;
            this.b = i;
            this.c = str2;
            this.d = z;
            put("from", "friend");
            put("pageid", Integer.valueOf(t5.i()));
            put("mid", str);
            put("sourceType", Integer.valueOf(i));
            put("fromUid", str2);
            put("sync", Boolean.valueOf(z));
            put("channelId", NotificationChannelManager.MessageType.INTERACTIVE.getNotificationChannelForLog());
            put("showNewStyle", Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f15732a;

        public o(MessageVo messageVo) {
            this.f15732a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.u0(this.f15732a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15733a;
        public final /* synthetic */ int b;

        public p(String str, int i) {
            this.f15733a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.q0(this.f15733a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15735a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;

        public r(int i, int i2, String str, String str2, String str3, String str4, boolean z) {
            this.f15735a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mb4.i(this.f15735a, this.b)) {
                a.this.s0(this.c, this.d, this.e, this.f15735a, this.b);
            } else {
                a.this.o0(this.c, this.d, this.e, this.f15735a, this.b, this.f, this.g);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15736a;
        public int b;

        public s(String str, int i) {
            this.f15736a = str;
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15737a;
        public String b;
        public String c;
        public String d;
        public int e;
        public NotificationChannelManager.MessageType f;
    }

    public static void B0(NotificationCompat.Builder builder) {
        builder.setSmallIcon(R.drawable.message_notify_icon_white).setColor(AppContext.getContext().getResources().getColor(R.color.Aa));
    }

    public static a E() {
        if (p == null) {
            synchronized (a.class) {
                if (p == null) {
                    p = new a();
                }
            }
        }
        return p;
    }

    public static Uri I() {
        String strI = r75.i(AppContext.getContext(), "notify_sound_url");
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        return Uri.parse(strI);
    }

    public static boolean V() {
        return !yg4.a(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), 16);
    }

    public static boolean W(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return false;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return false;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean b0() {
        return r75.d(AppContext.getContext(), "notify_sound", true);
    }

    public static boolean c0() {
        return r75.d(AppContext.getContext(), "notify_vibration", true);
    }

    public final boolean A(String str) {
        return false;
    }

    public final String A0(NotificationCompat.Builder builder, NoticeBarStyle noticeBarStyle) {
        NoticeBarExtStyle noticeBarExtStyle;
        LogUtil.d("NotificationHelper", "setCustomView start");
        StringBuilder sb = new StringBuilder();
        if (noticeBarStyle != null && (noticeBarExtStyle = noticeBarStyle.style) != null) {
            LogUtil.d("NotificationHelper", "setCustomView enter" + az2.c(noticeBarStyle));
            if (vp3.e()) {
                int i2 = Build.VERSION.SDK_INT;
            }
            RemoteViews remoteViews = new RemoteViews(AppContext.getContext().getPackageName(), R.layout.lx_custom_notification_view2);
            if (TextUtils.isEmpty(noticeBarExtStyle.title)) {
                remoteViews.setTextViewText(R.id.update_tv, Html.fromHtml(noticeBarStyle.title));
            } else {
                remoteViews.setTextViewText(R.id.update_tv, Html.fromHtml(noticeBarExtStyle.title));
                sb.append("title|");
            }
            if (TextUtils.isEmpty(noticeBarExtStyle.digest)) {
                remoteViews.setTextViewText(R.id.update_sub_tv, Html.fromHtml(noticeBarStyle.digest));
            } else {
                remoteViews.setTextViewText(R.id.update_sub_tv, Html.fromHtml(noticeBarExtStyle.digest));
                sb.append("digest|");
            }
            try {
                Bitmap bitmap = Glide.with(AppContext.getContext()).asBitmap().load2(noticeBarStyle.icon).submit().get(3L, TimeUnit.SECONDS);
                if (bitmap != null) {
                    Log.d("NotificationHelper", "bitmap load " + bitmap.getWidth() + " x " + bitmap.getHeight());
                    remoteViews.setImageViewBitmap(R.id.update_image, bitmap);
                } else {
                    Log.d("NotificationHelper", "bitmap load fail");
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } catch (ExecutionException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (!TextUtils.isEmpty(noticeBarExtStyle.background_color)) {
                try {
                    remoteViews.setInt(R.id.update_background, "setBackgroundColor", Color.parseColor(noticeBarExtStyle.background_color));
                    sb.append(OapsKey.KEY_BG);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            builder.setCustomContentView(remoteViews);
            builder.setGroup("group_type_custom");
            builder.setGroupSummary(false);
        }
        LogUtil.d("NotificationHelper", "setCustomView end styleType=" + ((Object) sb));
        return sb.toString();
    }

    public StatusBarNotification[] B() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return this.k.getActiveNotifications();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int C() {
        ConcurrentHashMap<String, s> concurrentHashMap = this.f15717a;
        int size = concurrentHashMap != null ? 0 + concurrentHashMap.size() : 0;
        ConcurrentHashMap<String, Integer> concurrentHashMap2 = this.b;
        if (concurrentHashMap2 != null) {
            size += concurrentHashMap2.size();
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap3 = this.c;
        if (concurrentHashMap3 != null) {
            size += concurrentHashMap3.size();
        }
        ConcurrentHashMap<String, s> concurrentHashMap4 = this.d;
        if (concurrentHashMap4 != null) {
            size += concurrentHashMap4.size();
        }
        ConcurrentHashMap<String, s> concurrentHashMap5 = this.e;
        return concurrentHashMap5 != null ? size + concurrentHashMap5.size() : size;
    }

    public void C0(boolean z) {
        this.l = z;
    }

    public final int D(String str) {
        if (this.b.get(str) != null) {
            return this.b.get(str).intValue();
        }
        int size = this.b.size() + 2001;
        this.b.put(str, Integer.valueOf(size));
        return size;
    }

    public final void D0(NotificationCompat.Builder builder) {
        if (b0()) {
            Uri uriI = I();
            if (uriI == null) {
                builder.setDefaults(1);
            } else {
                builder.setSound(uriI);
            }
        }
    }

    public final void E0(NotificationCompat.Builder builder) {
        if (c0()) {
            builder.setVibrate(r);
        } else {
            builder.setVibrate(q);
        }
    }

    public final synchronized int F(boolean z, String str, String str2, boolean z2, boolean z3) {
        int size;
        int size2;
        size = -1;
        if (!z) {
            s sVar = this.f15717a.get("NO_DETAIL_CHAT_NOTIFY_ID");
            if (sVar == null) {
                size = 1000;
                this.f15717a.put("NO_DETAIL_CHAT_NOTIFY_ID", new s(str2, 1000));
            } else if (!sVar.f15736a.equals(str2)) {
                this.f15717a.put("NO_DETAIL_CHAT_NOTIFY_ID", new s(str2, sVar.b));
                size = sVar.b;
            }
        } else if ((U(str) && z2) || z3) {
            size = this.f15717a.size() + 1001;
            this.f15717a.put(str + str2, new s(str2, size));
        } else {
            s sVar2 = this.f15717a.get(str);
            if (sVar2 != null) {
                String str3 = sVar2.f15736a;
                if (str3 == null || !str3.equals(str2)) {
                    this.f15717a.put(str, new s(str2, sVar2.b));
                    size2 = sVar2.b;
                }
            } else {
                size2 = this.f15717a.size() + 1001;
                this.f15717a.put(str, new s(str2, size2));
            }
            size = size2;
        }
        return size;
    }

    public void F0(Context context, Notification notification, int i2) {
        u93.e(new i(notification, context, i2));
    }

    public final synchronized int G(boolean z, String str, String str2, boolean z2) {
        int size;
        size = -1;
        if (z) {
            s sVar = this.e.get(str);
            if (sVar != null) {
                String str3 = sVar.f15736a;
                if (str3 == null || !str3.equals(str2)) {
                    this.e.put(str, new s(str2, sVar.b));
                    size = sVar.b;
                }
            } else {
                size = this.e.size() + 6001;
                this.e.put(str, new s(str2, size));
            }
        } else {
            s sVar2 = this.e.get("NO_DETAIL_MOMENTS_NOTIFY_ID");
            if (sVar2 != null) {
                String str4 = sVar2.f15736a;
                if (str4 == null || !str4.equals(str2)) {
                    this.e.put("NO_DETAIL_MOMENTS_NOTIFY_ID", new s(str2, sVar2.b));
                    size = sVar2.b;
                }
            } else {
                this.e.put("NO_DETAIL_MOMENTS_NOTIFY_ID", new s(str2, 6000));
                size = 6000;
            }
        }
        return size;
    }

    public void G0(boolean z) {
        com.zenmen.palmchat.settings.c.f().l(null, z);
        com.zenmen.palmchat.settings.c.f().c();
    }

    public final int H(String str) {
        if (this.c.get(str) != null) {
            return this.c.get(str).intValue();
        }
        int size = this.c.size() + 3001;
        this.c.put(str, Integer.valueOf(size));
        return size;
    }

    public String J(boolean z, int i2, int i3, String str, String str2, int i4, int i5, String str3, String str4, boolean z2) {
        String str5;
        String string;
        String string2 = AppContext.getContext().getResources().getString(R.string.message_notification_default_content);
        if (!z) {
            if (z2) {
                return AppContext.getContext().getResources().getString(R.string.notify_moments_no_detail, Integer.valueOf(this.f + 1));
            }
            return ch.s().z() + AppContext.getContext().getResources().getString(R.string.notify_chat_no_detail, Integer.valueOf(ch.s().A()));
        }
        if (TextUtils.isEmpty(str2)) {
            return string2;
        }
        String str6 = "";
        if (i4 > 1) {
            b05.a("threadUnread>1");
            string = !x24.d().f() ? AppContext.getContext().getResources().getString(R.string.thread_nodisturb_unread_count, Integer.valueOf(i4)) : "";
            if (i2 != 0 || i3 == 10001) {
                str5 = "";
            } else {
                str5 = str + ":";
            }
        } else {
            str5 = "";
            string = str5;
        }
        if (a65.f(str3)) {
            str2 = a65.b(str2);
        }
        if (i5 != 13) {
            if (i5 == 14) {
                str6 = String.format("[%s]", AppContext.getContext().getString(R.string.settings_item_fujinderen));
                str5 = str + ":";
            } else if (i5 == 17) {
                str6 = String.format("[%s]", AppContext.getContext().getString(R.string.source_type_people_match));
                str5 = str + ":";
            }
        } else if (!SAppUtil.b.b()) {
            str5 = str + ":";
        }
        return ("88888027".equals(str3) && dd6.b()) ? str2 : string + str6 + str5 + str2;
    }

    public String K(boolean z, int i2, int i3, String str, String str2, int i4, int i5, String str3, String str4) {
        String str5;
        String str6;
        String string = AppContext.getContext().getResources().getString(R.string.message_notification_default_content);
        str5 = "";
        if (!z) {
            this.o = !this.o;
            StringBuilder sb = new StringBuilder();
            sb.append(AppContext.getContext().getResources().getString(R.string.app_name));
            sb.append(":");
            sb.append(string);
            sb.append(this.o ? " " : "");
            return sb.toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return string;
        }
        if (i2 != 0 || i3 == 10001) {
            str6 = "";
        } else {
            str6 = str + ": ";
        }
        if (a65.f(str3)) {
            str2 = a65.b(str2);
        }
        if (i5 == 14) {
            str5 = String.format("[%s]", AppContext.getContext().getString(R.string.settings_item_fujinderen));
        } else if (i5 == 17) {
            str5 = String.format("[%s]", AppContext.getContext().getString(R.string.source_type_people_match));
        }
        if (str2.length() > 150) {
            str2 = str2.substring(0, 150) + "...";
        }
        return str5 + str6 + str2;
    }

    public String L(String str, int i2, boolean z) {
        return (TextUtils.isEmpty(str) || !z) ? AppContext.getContext().getResources().getString(R.string.app_name) : Q(i2) ? AppContext.getContext().getString(R.string.greetings_group_title) : str;
    }

    public final int M(String str) {
        s sVar = this.d.get(str);
        if (sVar == null) {
            int size = this.d.size() + 4001;
            this.d.put(str, new s(str, size));
            return size;
        }
        if (sVar.f15736a.equals(str)) {
            return -1;
        }
        this.d.put(str, new s(str, sVar.b));
        return sVar.b;
    }

    public boolean N() {
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationManager notificationManager = (NotificationManager) AppContext.getContext().getSystemService("notification");
            if (notificationManager == null) {
                return true;
            }
            return notificationManager.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) AppContext.getContext().getSystemService("appops");
        if (appOpsManager == null) {
            return true;
        }
        ApplicationInfo applicationInfo = AppContext.getContext().getApplicationInfo();
        String packageName = AppContext.getContext().getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean O() {
        return com.zenmen.palmchat.settings.c.f().g();
    }

    public final boolean P() {
        return AccountUtils.r(AppContext.getContext());
    }

    public final boolean Q(int i2) {
        return i2 == 14 || i2 == 17;
    }

    public boolean R() {
        LogUtil.i("NotificationHelper", "bKeepNotification = " + this.l);
        return this.l;
    }

    public boolean S() {
        return true;
    }

    public final boolean T(boolean z, NotificationChannelManager.MessageType messageType) {
        boolean zG = x24.g();
        String strB = vs0.a().b("chatstyle_blacklist");
        return zG && !(strB != null && strB.contains(Build.MANUFACTURER.toLowerCase())) && Build.VERSION.SDK_INT >= 24 && z && messageType == NotificationChannelManager.MessageType.MSG;
    }

    public boolean U(String str) {
        return MediationConstant.RIT_TYPE_FEED.equals(str);
    }

    public boolean X() {
        return (SAppUtil.c.d() && SAppUtil.c.c()) ? N() : (d0() || com.zenmen.palmchat.settings.c.j()) ? O() && N() : O();
    }

    public boolean Y() {
        return (d0() || com.zenmen.palmchat.settings.c.j()) ? o() && N() : o();
    }

    public boolean Z(int i2, int i3, String str) {
        return (d0() || com.zenmen.palmchat.settings.c.j()) ? p(i2, i3, str) && N() : p(i2, i3, str);
    }

    public boolean a0(String str, String str2, int i2, int i3) {
        return (d0() || com.zenmen.palmchat.settings.c.j()) ? q(str, str2, i2, i3) && N() : q(str, str2, i2, i3);
    }

    public boolean d0() {
        int i2;
        if ((!lg6.c() && !j94.d()) || (i2 = Build.VERSION.SDK_INT) < 24 || i2 > 27) {
            return false;
        }
        if (this.n == null) {
            this.n = Boolean.TRUE;
        }
        return this.n.booleanValue();
    }

    public final boolean e0(String str) {
        return str != null && (str.startsWith("special-square") || str.startsWith("special-profile") || str.startsWith("special-online"));
    }

    public final Bitmap f0(String str) {
        Bitmap bitmap = null;
        try {
            Drawable drawable = hc2.a(AppContext.getContext()).load(str).submit().get(3L, TimeUnit.SECONDS);
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            return ((BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
        } catch (Exception e3) {
            e3.printStackTrace();
            return bitmap;
        }
    }

    public final boolean g0() {
        String strY2 = MainTabsActivity.y2();
        return !AppContext.getContext().isBackground() && ((t5.j() == MainTabsActivity.class && ("tab_discover".equals(strY2) || "tab_dynamic_1".equals(strY2))) || t5.j() == NewContactActivity.class);
    }

    public final boolean h0(String str) {
        return !a65.f(str) && !AppContext.getContext().isBackground() && t5.j() == MainTabsActivity.class && MainTabsActivity.y2().equals("tab_msg");
    }

    public void j0(Activity activity, String str) {
        ApplicationInfo applicationInfo = activity.getApplicationInfo();
        String packageName = activity.getPackageName();
        int i2 = applicationInfo.uid;
        Intent intent = new Intent();
        intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("android.provider.extra.CHANNEL_ID", str);
        intent.putExtra(WfConstant.EXTRA_KEY_APP_PKG, packageName);
        intent.putExtra("app_uid", i2);
        try {
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void k0(String str, String str2, String str3, ContactInfoItem contactInfoItem, boolean z) {
        u93.e(new k(str, str2, str3, contactInfoItem, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l0(String str, String str2, String str3, ContactInfoItem contactInfoItem, boolean z) {
        String string;
        BitmapDrawable bitmapDrawable;
        PhoneContactItem phoneContactItem;
        HashMap map = new HashMap(1);
        boolean zIsSenderParseFromRid = ContactRequestsVO.isSenderParseFromRid(str2);
        if (g0()) {
            return;
        }
        if (!P()) {
            map.put("type", "8");
            zn6.i("selfchannel_push_noshow", map);
            return;
        }
        if (SAppUtil.c.d() && SAppUtil.c.c()) {
            if (!Y()) {
                map.put("type", "5");
                zn6.i("selfchannel_push_noshow", map);
                return;
            }
        } else if (!X()) {
            map.put("type", "5");
            zn6.i("selfchannel_push_noshow", map);
            return;
        }
        String uid = contactInfoItem.getUid();
        String nickName = contactInfoItem.getNickName();
        String iconURL = contactInfoItem.getIconURL();
        int sourceType = contactInfoItem.getSourceType();
        if (!TextUtils.isEmpty(nickName) && !TextUtils.isEmpty(contactInfoItem.getMobile()) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(hs0.g().d(contactInfoItem.getMobile()))) != null && !TextUtils.isEmpty(phoneContactItem.m())) {
            nickName = phoneContactItem.m() + "(" + nickName + ")";
        }
        if (sourceType == 28) {
            return;
        }
        if (sourceType == 14 || sourceType == 4 || sourceType == 34) {
            m0(contactInfoItem);
            return;
        }
        int iD = D(uid);
        if (TextUtils.isEmpty(nickName)) {
            nickName = AppContext.getContext().getString(R.string.notification_add_title);
        }
        if (sourceType == 2) {
            string = AppContext.getContext().getString(R.string.notification_add_contact_request_group);
        } else if (sourceType == 3) {
            string = AppContext.getContext().getString(R.string.notification_add_contact_request_contact);
        } else if (sourceType == 7) {
            string = AppContext.getContext().getString(R.string.notification_add_contact_request_auto);
        } else if (sourceType != 20) {
            if (sourceType != 17) {
                string = sourceType != 18 ? AppContext.getContext().getString(R.string.notification_add_contact_request_content_new) : AppContext.getContext().getString(R.string.notification_add_contact_request_accurate);
            }
        }
        NoticeBarStyle fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(str3);
        if (fromMsgExtension != null) {
            if (fromMsgExtension.unnoticeable) {
                map.put("type", "0");
                zn6.i("selfchannel_push_noshow", map);
                return;
            }
            if (!TextUtils.isEmpty(fromMsgExtension.title)) {
                nickName = fromMsgExtension.title;
            }
            if (!TextUtils.isEmpty(fromMsgExtension.digest)) {
                string = fromMsgExtension.digest;
            }
            if (!TextUtils.isEmpty(fromMsgExtension.icon)) {
                iconURL = fromMsgExtension.icon;
            }
        }
        NotificationChannelManager.MessageType messageType = NotificationChannelManager.MessageType.INTERACTIVE;
        if (NotificationChannelManager.a(messageType)) {
            NotificationCompat.Builder contentText = messageType.genNotificationCompatBuilder().setTicker(string).setAutoCancel(true).setContentTitle(nickName).setContentText(string);
            B0(contentText);
            try {
                bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                contentText.setLargeIcon(bitmapDrawable.getBitmap());
            }
            this.h = uid;
            if (ir5.b() - this.m > 3000) {
                D0(contentText);
                E0(contentText);
                if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                    contentText.setPriority(2);
                }
                this.m = ir5.b();
            }
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
            intent.setAction("extra_action_add_contact_click");
            intent.putExtra("user_item_info", contactInfoItem);
            intent.putExtra("extra_mid", str);
            intent.putExtra("extra_sourcetype", sourceType);
            contentText.setContentIntent(PendingIntent.getBroadcast(AppContext.getContext(), iD, intent, 134217728));
            Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
            intent2.setAction("extra_action_add_contact_action");
            intent2.putExtra("user_item_info", contactInfoItem);
            intent2.putExtra("rid", str2);
            intent2.putExtra("isSenderReceiveReply", zIsSenderParseFromRid);
            intent2.putExtra("extra_mid", str);
            intent2.putExtra("extra_sourcetype", sourceType);
            PendingIntent broadcast = PendingIntent.getBroadcast(AppContext.getContext(), iD, intent2, 134217728);
            Intent intent3 = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
            intent3.setAction("extra_action_add_contact_ignore");
            intent3.putExtra("isAccept", !zIsSenderParseFromRid);
            intent3.putExtra("from_uid", uid);
            intent3.putExtra("extra_mid", str);
            intent3.putExtra("extra_sourcetype", sourceType);
            intent3.putExtra("user_item_info", contactInfoItem);
            contentText.addAction(R.drawable.icon_ignore, AppContext.getContext().getString(R.string.ignore_add_contact_request), PendingIntent.getBroadcast(AppContext.getContext(), iD, intent3, 134217728));
            if (zIsSenderParseFromRid) {
                contentText.addAction(R.drawable.icon_accept, AppContext.getContext().getString(R.string.view_add_contact_request), broadcast);
            } else {
                contentText.addAction(R.drawable.icon_accept, AppContext.getContext().getString(R.string.accept_add_contact_request), broadcast);
            }
            if (V() && !TextUtils.isEmpty(iconURL)) {
                gr2.j().k(iconURL, bq6.s(), new l(uid, contentText, iD));
            }
            x24.d().h(iD, contentText, new w24(str, String.valueOf(10), null, 0), new m(uid));
            z0(iD, contentText.build());
            LogUtil.uploadInfoImmediate("msg_show", new n(str, sourceType, uid, z));
        }
    }

    public final void m0(ContactInfoItem contactInfoItem) {
        BitmapDrawable bitmapDrawable;
        String uid = contactInfoItem.getUid();
        String nickName = contactInfoItem.getNickName();
        String iconURL = contactInfoItem.getIconURL();
        int iH = H(uid);
        if (TextUtils.isEmpty(nickName)) {
            nickName = AppContext.getContext().getString(R.string.notification_add_title);
        }
        String string = AppContext.getContext().getString(R.string.nearby_greet_notification);
        NotificationChannelManager.MessageType messageType = NotificationChannelManager.MessageType.INTERACTIVE;
        if (NotificationChannelManager.a(messageType)) {
            NotificationCompat.Builder contentText = messageType.genNotificationCompatBuilder().setTicker(string).setAutoCancel(true).setContentTitle(nickName).setContentText(string);
            B0(contentText);
            try {
                bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                contentText.setLargeIcon(bitmapDrawable.getBitmap());
            }
            if (ir5.b() - this.m > 3000) {
                D0(contentText);
                E0(contentText);
                if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                    contentText.setPriority(2);
                }
                this.m = ir5.b();
            }
            this.i = uid;
            contentText.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), iH, st2.e(true, false), 268435456));
            if (V() && !TextUtils.isEmpty(iconURL)) {
                gr2.j().k(iconURL, bq6.s(), new j(uid, contentText, iH));
            }
            z0(iH, contentText.build());
        }
    }

    public void n0(String str, String str2, String str3, int i2, int i3, String str4, boolean z) {
        u93.e(new r(i2, i3, str, str2, str3, str4, z));
    }

    public final boolean o() {
        return t34.c(t34.b(), 16);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0632 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0142 A[Catch: Exception -> 0x018d, TRY_LEAVE, TryCatch #0 {Exception -> 0x018d, blocks: (B:56:0x0110, B:67:0x0139, B:71:0x0142, B:85:0x0189, B:88:0x018f, B:92:0x01a1, B:73:0x0148, B:75:0x0158, B:77:0x0162, B:79:0x0166, B:80:0x0170, B:82:0x0176), top: B:416:0x00cc, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0176 A[Catch: Exception -> 0x0188, LOOP:0: B:80:0x0170->B:82:0x0176, LOOP_END, TRY_LEAVE, TryCatch #4 {Exception -> 0x0188, blocks: (B:73:0x0148, B:75:0x0158, B:77:0x0162, B:79:0x0166, B:80:0x0170, B:82:0x0176), top: B:421:0x0148, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a0  */
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(String str, String str2, String str3, int i2, int i3, String str4, boolean z) {
        String str5;
        boolean z2;
        String str6;
        String str7;
        HashMap map;
        String str8;
        boolean z3;
        String str9;
        String str10;
        long j2;
        boolean z4;
        boolean z5;
        int i4;
        boolean z6;
        String str11;
        boolean z7;
        int i5;
        String str12;
        String str13;
        boolean z8;
        String str14;
        String str15;
        boolean z9;
        int i6;
        int i7;
        String str16;
        String str17;
        String str18;
        String str19;
        boolean z10;
        String str20;
        String str21;
        NotificationChannelManager.MessageType messageType;
        NotificationChannelManager.MessageType messageType2;
        BitmapDrawable bitmapDrawable;
        NotificationChannelManager.MessageType messageType3;
        String str22;
        String str23;
        Pair<Integer, ContentValues> pairG;
        Object obj;
        Bitmap bitmapF0;
        JSONArray jSONArrayOptJSONArray;
        String strOptString;
        String strOptString2;
        String str24;
        boolean z11;
        boolean z12;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObject;
        Pair<Integer, ContentValues> pairG2;
        Object obj2;
        Matcher matcher;
        Pair<Integer, ContentValues> pairG3;
        Object obj3;
        HashMap map2 = new HashMap(1);
        if (!P() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            map2.put("type", "8");
            zn6.i("selfchannel_push_noshow", map2);
            return;
        }
        boolean zV = V();
        String strA = m40.a(str);
        int iB = m40.b(str);
        if (h0(strA)) {
            map2.put("type", "3");
            zn6.i("selfchannel_push_noshow", map2);
            return;
        }
        if (MediationConstant.RIT_TYPE_FEED.equals(str) || "88888003".equals(strA)) {
            br3.d();
        }
        if (es3.c(str3, str4, i2)) {
            return;
        }
        DomainHelper.Domains domainsN = DomainHelper.n(str);
        if (DomainHelper.Domains.DOMAIN_VOICE_ROOM == domainsN || DomainHelper.Domains.DOMAIN_KDY == domainsN) {
            map2.put("type", "7");
            zn6.i("selfchannel_push_noshow", map2);
            return;
        }
        LogUtil.i("NotificationHelper", "FROM: " + strA);
        String str25 = "appMsg";
        if (TextUtils.isEmpty(strA)) {
            str5 = "appMsg";
            z2 = false;
        } else {
            if ("88888000".equals(strA)) {
                str24 = null;
                LogUtil.uploadInfoImmediate("p11", null, null, null);
                z2 = true;
            } else {
                str24 = null;
                z2 = false;
            }
            if ("88888003".equals(strA)) {
                LogUtil.uploadInfoImmediate("dt1", "1", str24, str24);
                LogUtil.i("NotificationHelper", "dt1");
            }
            if ("88888008".equals(strA)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                } catch (Exception e2) {
                    e = e2;
                }
                if (str3 != null) {
                    try {
                        JSONObject jSONObjectOptJSONObject = new JSONObject(str3).optJSONObject("appMsg");
                        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("items")) == null || jSONArrayOptJSONArray2.length() <= 0 || (jSONObject = jSONArrayOptJSONArray2.getJSONObject(0)) == null || (pairG2 = mb4.g(jSONObject.optString("url"))) == null || (obj2 = pairG2.second) == null) {
                            str5 = "appMsg";
                            z11 = false;
                        } else {
                            Iterator<String> it = ((ContentValues) obj2).keySet().iterator();
                            while (it.hasNext()) {
                                str5 = str25;
                                try {
                                    String next = it.next();
                                    Iterator<String> it2 = it;
                                    jSONObject2.put(next, ((ContentValues) pairG2.second).get(next));
                                    it = it2;
                                    str25 = str5;
                                } catch (JSONException e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    z12 = false;
                                    if (!z12) {
                                    }
                                    jSONObject2.put("mid", str2);
                                    jSONObject2.put("active", AppContext.getContext().isBackground() ? 0 : 1);
                                    LogUtil.uploadInfoImmediate("pm260", "1", null, jSONObject2.toString());
                                    if (SAppUtil.c.d()) {
                                        str6 = "selfchannel_push_noshow";
                                        str7 = "type";
                                        map = map2;
                                        if (!X()) {
                                        }
                                    }
                                    if (AudioController.b0().l0()) {
                                    }
                                }
                            }
                            str5 = str25;
                            z11 = true;
                        }
                        z12 = z11;
                    } catch (JSONException e4) {
                        e = e4;
                        str5 = str25;
                    } catch (Exception e5) {
                        e = e5;
                        str5 = str25;
                        e.printStackTrace();
                        LogUtil.uploadInfoImmediate("pm260", "1", null, jSONObject2.toString());
                        if (SAppUtil.c.d()) {
                        }
                        if (AudioController.b0().l0()) {
                        }
                    }
                    if (!z12 && !TextUtils.isEmpty(str4)) {
                        try {
                            matcher = Pattern.compile("[^'\"]+://[^'\"]+").matcher(str4);
                            if (matcher.find() && (pairG3 = mb4.g(matcher.group())) != null && (obj3 = pairG3.second) != null) {
                                for (String str26 : ((ContentValues) obj3).keySet()) {
                                    jSONObject2.put(str26, ((ContentValues) pairG3.second).get(str26));
                                }
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    jSONObject2.put("mid", str2);
                    jSONObject2.put("active", AppContext.getContext().isBackground() ? 0 : 1);
                    LogUtil.uploadInfoImmediate("pm260", "1", null, jSONObject2.toString());
                } else {
                    str5 = "appMsg";
                }
                z12 = false;
                if (!z12) {
                    matcher = Pattern.compile("[^'\"]+://[^'\"]+").matcher(str4);
                    if (matcher.find()) {
                        while (r1.hasNext()) {
                        }
                    }
                }
                jSONObject2.put("mid", str2);
                jSONObject2.put("active", AppContext.getContext().isBackground() ? 0 : 1);
                LogUtil.uploadInfoImmediate("pm260", "1", null, jSONObject2.toString());
            } else {
                str5 = "appMsg";
            }
        }
        if (SAppUtil.c.d() && SAppUtil.c.c()) {
            str7 = "type";
            map = map2;
            if (!a0(str, str2, i2, i3)) {
                map.put(str7, "5");
                zn6.i("selfchannel_push_noshow", map);
                return;
            }
            str6 = "selfchannel_push_noshow";
        } else {
            str6 = "selfchannel_push_noshow";
            str7 = "type";
            map = map2;
            if (!X()) {
                map.put(str7, "5");
                zn6.i(str6, map);
                return;
            }
        }
        if (AudioController.b0().l0()) {
            map.put(str7, "6");
            zn6.i(str6, map);
            return;
        }
        if (i2 == 10000 || strA == null || A(str) || strA.equals(AccountUtils.p(AppContext.getContext()))) {
            HashMap map3 = map;
            map3.put(str7, "9");
            zn6.i(str6, map3);
            return;
        }
        if (jo6.k() && "88888003".equals(strA)) {
            r0(str, str2, str3, i2);
            return;
        }
        if (MediationConstant.RIT_TYPE_FEED.equals(str)) {
            StringBuilder sb = new StringBuilder();
            str8 = MediationConstant.RIT_TYPE_FEED;
            sb.append("notifyNewMessageImp: ext = ");
            sb.append(str3);
            LogUtil.d("lognotify", sb.toString());
            if (NoticeBarStyle.parseFromMsgExtension(str3) == null) {
                LogUtil.d("lognotify", "notifyNewMessageImp: noticeBar is null, return");
                return;
            } else {
                if (!AppContext.getContext().isBackground()) {
                    LogUtil.d("lognotify", "notifyNewMessageImp: app is foreground, return");
                    return;
                }
                z3 = true;
            }
        } else {
            str8 = MediationConstant.RIT_TYPE_FEED;
            z3 = false;
        }
        long jB = ir5.b();
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.d(strA, DomainHelper.n(str))}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    boolean z13 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_contact_ready")) == 1;
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("icon_url"));
                    boolean z14 = z13;
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                    str9 = "88888003";
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("latest_message"));
                    str10 = "mid";
                    if (cursorQuery.getInt(cursorQuery.getColumnIndex("latest_message_mime_type")) == 9) {
                        string3 = SAppUtil.b.b() ? tw5.c(AppContext.getContext(), string3, string2) : tw5.b(AppContext.getContext(), string3, string2);
                    }
                    int i8 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_message_count"));
                    str11 = string3;
                    z7 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_nodisturb")) == 1;
                    z5 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_has_remind")) == 2;
                    i5 = i8;
                    z6 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_focus")) == 1;
                    i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_biz_type"));
                    str12 = string2;
                    j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("latest_message_time_stamp"));
                    z4 = z14;
                    str13 = string;
                } else {
                    str9 = "88888003";
                    str10 = "mid";
                    j2 = jB;
                    z4 = false;
                    z5 = false;
                    i4 = 0;
                    z6 = false;
                    str11 = null;
                    z7 = false;
                    i5 = 0;
                    str12 = null;
                    str13 = null;
                }
                cursorQuery.close();
                z8 = z4;
                str14 = str12;
                str15 = "url";
                int i9 = i4;
                z9 = z5;
                i6 = i9;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        } else {
            str9 = "88888003";
            str10 = "mid";
            j2 = jB;
            str15 = "url";
            str14 = null;
            z8 = false;
            i6 = 0;
            z9 = false;
            z6 = false;
            str11 = null;
            z7 = false;
            i5 = 0;
            str13 = null;
        }
        if (i2 != 10001) {
            i7 = i6;
            str16 = str11;
        } else if (str3 != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = new JSONObject(str3).optJSONObject("revokeMsg");
                if (jSONObjectOptJSONObject2 != null) {
                    strOptString = jSONObjectOptJSONObject2.optString("replaceMid");
                    i7 = i6;
                    try {
                        strOptString2 = jSONObjectOptJSONObject2.optString("replaceMsg");
                    } catch (JSONException e7) {
                        e = e7;
                        e.printStackTrace();
                        strOptString2 = null;
                    }
                } else {
                    i7 = i6;
                    strOptString2 = null;
                    strOptString = null;
                }
            } catch (JSONException e8) {
                e = e8;
                i7 = i6;
                strOptString = null;
            }
            if (!(!TextUtils.isEmpty(strOptString) ? com.zenmen.palmchat.database.b.z(str, strOptString) : false)) {
                return;
            } else {
                str16 = strOptString2;
            }
        }
        if (z6) {
            if (c0() && i2 != 10001 && ir5.b() - this.m > 3000) {
                ((Vibrator) AppContext.getContext().getSystemService("vibrator")).vibrate(r, -1);
                this.m = ir5.b();
            }
            map.put(str7, "1");
            zn6.i(str6, map);
            return;
        }
        if (!z8) {
            map.put(str7, "2");
            zn6.i(str6, map);
            return;
        }
        String str27 = str7;
        String str28 = str9;
        int i10 = i7;
        HashMap map4 = map;
        String str29 = str8;
        String str30 = str16;
        String str31 = str5;
        if (xg5.e().k(strA, str16, i5, j2)) {
            return;
        }
        if (!z3 && z7 && !z9) {
            map4.put(str27, "2");
            zn6.i(str6, map4);
            return;
        }
        String strC = DomainHelper.c(strA, i10);
        String asString = "";
        if (jo6.k() && !TextUtils.isEmpty(strA) && str28.equals(strA) && str3 != null) {
            try {
                JSONObject jSONObjectOptJSONObject3 = new JSONObject(str3).optJSONObject(str31);
                if (jSONObjectOptJSONObject3 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("items")) != null) {
                    if (jSONArrayOptJSONArray.length() > 0) {
                        try {
                            JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(0);
                            if (jSONObject3 != null) {
                                JSONObject jSONObjectOptJSONObject4 = jSONObject3.optJSONObject("feedEx");
                                Pair<Integer, ContentValues> pairG4 = mb4.g(jSONObject3.optString(str15));
                                if (pairG4 != null) {
                                    asString = ((ContentValues) pairG4.second).getAsString(DeviceInfoUtil.UID_TAG);
                                    if (!TextUtils.isEmpty(asString)) {
                                        strC = strA + "_" + asString;
                                    }
                                    if (jSONObjectOptJSONObject4 != null) {
                                        String strOptString3 = jSONObjectOptJSONObject4.optString("headIconUrl");
                                        if (!TextUtils.isEmpty(strOptString3)) {
                                            str13 = strOptString3;
                                        }
                                    }
                                    i5 = 0;
                                }
                            }
                        } catch (JSONException e9) {
                            e = e9;
                            e.printStackTrace();
                        }
                    }
                }
            } catch (JSONException e10) {
                e = e10;
            }
        }
        String str32 = strC;
        String str33 = asString;
        int i11 = i5;
        String str34 = str10;
        String str35 = str6;
        String strK = K(zV, iB, i2, str14, str30, i11, i10, strA, str3);
        String str36 = str14;
        String strL = L(str36, i10, zV);
        String strJ = J(zV, iB, i2, str36, str30, i11, i10, strA, str3, false);
        NoticeBarStyle fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(str3);
        if (fromMsgExtension == null) {
            str17 = strJ;
            str18 = strL;
            str19 = str13;
            z10 = false;
        } else {
            if (fromMsgExtension.unnoticeable) {
                map4.put(str27, "0");
                zn6.i(str35, map4);
                return;
            }
            if (!TextUtils.isEmpty(fromMsgExtension.title)) {
                strL = fromMsgExtension.title;
            }
            if (!TextUtils.isEmpty(fromMsgExtension.digest)) {
                strJ = fromMsgExtension.digest;
            }
            if (TextUtils.isEmpty(fromMsgExtension.icon)) {
                str17 = strJ;
                str18 = strL;
                str19 = str13;
            } else {
                str17 = strJ;
                str19 = fromMsgExtension.icon;
                str18 = strL;
            }
            z10 = true;
        }
        int iF = F(zV, str32, str2, z10, x24.d().f());
        if (iF == -1 || TextUtils.isEmpty(str18)) {
            map4.put(str27, "11");
            zn6.i(str35, map4);
            return;
        }
        if (!z3 && !zV && ch.s().A() == 0) {
            w();
            v();
            this.k.cancel(iF);
            return;
        }
        if (S() && !TextUtils.isEmpty(strA)) {
            str20 = strA;
            if (str28.equals(str20)) {
                messageType = NotificationChannelManager.MessageType.MOMENT;
                str21 = str;
            }
            messageType2 = messageType;
            if (NotificationChannelManager.a(messageType2)) {
                return;
            }
            NotificationCompat.Builder contentText = messageType2.genNotificationCompatBuilder().setTicker(strK).setAutoCancel(true).setContentTitle(str18).setContentText(str17);
            B0(contentText);
            NoticeBarStyle noticeBarStyle = new NoticeBarStyle();
            noticeBarStyle.title = str18;
            noticeBarStyle.digest = str17;
            noticeBarStyle.icon = str19;
            if (fromMsgExtension != null) {
                noticeBarStyle.style = fromMsgExtension.style;
            }
            String strA0 = A0(contentText, noticeBarStyle);
            boolean zT = T(zV, messageType2);
            if (!zT) {
                try {
                    bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    bitmapDrawable = null;
                }
                if (bitmapDrawable != null) {
                    contentText.setLargeIcon(bitmapDrawable.getBitmap());
                }
            }
            this.g = str20;
            if (ir5.b() - this.m > 3000 && i2 != 10001) {
                E0(contentText);
                D0(contentText);
                if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                    contentText.setPriority(2);
                }
                this.m = ir5.b();
            }
            contentText.setLights(-16711936, 300, 900);
            contentText.setVisibility(1);
            if (zT) {
                String str37 = str14;
                Person.Builder key = new Person.Builder().setName(str14.length() > 20 ? str37.substring(0, 20) : str37).setKey(DomainHelper.j(str));
                Bitmap bitmapF02 = f0(str19);
                if (bitmapF02 != null) {
                    key.setIcon(IconCompat.createWithBitmap(bitmapF02));
                }
                Person personBuild = key.build();
                messageType3 = messageType2;
                contentText.setStyle(new NotificationCompat.MessagingStyle(personBuild).addMessage(str30, System.currentTimeMillis(), personBuild));
            } else {
                messageType3 = messageType2;
            }
            NotificationChannelManager.MessageType messageType4 = messageType3;
            String str38 = str21;
            String str39 = str20;
            String str40 = str19;
            contentText.setContentIntent(r(i10, str20, str33, str2, str3, i2, iB, iF, strA0));
            if (i0(zV, i10) && !zT && !TextUtils.isEmpty(str40) && (bitmapF0 = f0(str40)) != null) {
                contentText.setLargeIcon(bitmapF0);
            }
            x24.d().h(iF, contentText, new w24(str2, String.valueOf(i2), str38, 2), new g(zV, str32, str2, z10));
            Notification notificationBuild = contentText.build();
            to.e(AppContext.getContext(), notificationBuild, ch.s().A());
            if (zV) {
                this.k.cancel(1000);
                z0(iF, notificationBuild);
            } else {
                v();
                w();
                z0(iF, notificationBuild);
            }
            if (z2 && W(AppContext.getContext())) {
                str22 = null;
                LogUtil.uploadInfoImmediate("p21", null, null, null);
            } else {
                str22 = null;
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(str34, str2);
                jSONObject4.put("fromuid", str39);
                jSONObject4.put("pageid", t5.i());
                jSONObject4.put("sync", z);
                jSONObject4.put("style", strA0);
                jSONObject4.put("channelId", messageType4.getNotificationChannelForLog());
                jSONObject4.put("showNewStyle", zT);
                if (h05.c(str39)) {
                    str23 = str27;
                    jSONObject4.put(str23, "H-feedpush");
                } else {
                    str23 = str27;
                }
                if (str29.equals(str39) && fromMsgExtension != null && (pairG = mb4.g(fromMsgExtension.url)) != null && (obj = pairG.second) != null) {
                    Integer asInteger = ((ContentValues) obj).getAsInteger("noticeType");
                    if (asInteger != null && asInteger.intValue() == 0) {
                        jSONObject4.put(str23, 113);
                    } else if (asInteger != null && asInteger.intValue() == 1) {
                        jSONObject4.put(str23, 114);
                    }
                    Integer asInteger2 = ((ContentValues) pairG.second).getAsInteger("commentType");
                    if (asInteger2 != null && asInteger2.intValue() == 11) {
                        jSONObject4.put("action", 111);
                    } else if (asInteger2 != null && asInteger2.intValue() == 12) {
                        jSONObject4.put("action", 112);
                    }
                }
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("msg_show", "1", str22, jSONObject4.toString());
            return;
        }
        str20 = strA;
        if (NotificationChannelManager.c()) {
            str21 = str;
            if (str21 == null || ((!str21.contains(DomainHelper.Domains.DOMAIN_SINGLECHAT.domain) || str.length() < 18 || a65.f(str20)) && !str21.contains(DomainHelper.Domains.DOMAIN_GROUPCHAT.domain))) {
                DomainHelper.Domains domainsN2 = DomainHelper.n(str);
                messageType = (!(domainsN2 != null && fu5.v(domainsN2)) || NotificationChannelManager.d()) ? NotificationChannelManager.MessageType.PUBLIC : NotificationChannelManager.MessageType.MSG;
            } else {
                messageType = NotificationChannelManager.MessageType.MSG;
            }
        } else {
            str21 = str;
            messageType = a65.f(str20) ? NotificationChannelManager.MessageType.PUBLIC : NotificationChannelManager.MessageType.MSG;
        }
        messageType2 = messageType;
        if (NotificationChannelManager.a(messageType2)) {
        }
    }

    public boolean p(int i2, int i3, String str) {
        int iB = t34.b();
        return str.equals("88888004") ? t34.c(iB, 8) : i3 == 1 ? t34.c(iB, 4) : i2 == 0 ? t34.c(iB, 1) : t34.c(iB, 2);
    }

    public void p0(String str, int i2) {
        u93.e(new p(str, i2));
    }

    public boolean q(String str, String str2, int i2, int i3) {
        int iB = t34.b();
        return str.contains("@muc.youni") ? t34.c(iB, 4) : str.equals("88888004@youni") ? t34.c(iB, 8) : (i2 == 103 && i3 == 10) ? t34.c(iB, 32) : (i2 == 103 && i3 == 11) ? t34.c(iB, 64) : e0(str2) ? t34.c(iB, 128) : str2.startsWith("nearby_real") ? t34.c(iB, 256) : str.contains("@youni") ? t34.c(iB, 1) : (str.contains("couple.youni") || str.contains("svo.youni") || str.contains("tinder.youni") || str.contains("square.youni") || str.contains("nearby.youni") || str.contains("match.youni") || str.contains("discussion.youni") || str.contains("recommend.youni") || str.contains("profile.youni") || str.contains("private.youni") || str.contains("match.youni")) ? t34.c(iB, 2) : t34.c(iB, 512);
    }

    public final void q0(String str, int i2) {
        int i3;
        String string;
        String string2;
        String string3;
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        boolean z3;
        String str2;
        boolean z4;
        int i7;
        int i8;
        int i9;
        int i10;
        String str3;
        String str4;
        String str5;
        boolean z5;
        String str6;
        boolean z6;
        BitmapDrawable bitmapDrawable;
        int i11;
        if (P()) {
            if (TextUtils.isEmpty(str) && "88888003".equals(str)) {
                LogUtil.uploadInfoImmediate("dt1", "1", null, null);
                LogUtil.i("NotificationHelper", "dt1");
            }
            LogUtil.i("NotificationHelper", "notifyNewMessageOnContactReadyImp relateContact=" + str);
            if (!(SAppUtil.c.d() && SAppUtil.c.c()) && (!X() || AudioController.b0().l0() || "88888027".equals(str))) {
                return;
            }
            boolean zV = V();
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.c(str, i2)}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("chat_type"));
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("icon_url"));
                        string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        string3 = cursorQuery.getString(cursorQuery.getColumnIndex("latest_message"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("thread_message_mid"));
                        i5 = cursorQuery.getInt(cursorQuery.getColumnIndex("latest_message_mime_type"));
                        z = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_contact_ready")) == 1;
                        if (i5 == 9) {
                            string3 = SAppUtil.b.b() ? tw5.c(AppContext.getContext(), string3, string2) : tw5.b(AppContext.getContext(), string3, string2);
                        }
                        i6 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_message_count"));
                        z3 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_nodisturb")) == 1;
                        str2 = string4;
                        z2 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_focus")) == 1;
                        i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_biz_type"));
                    } else {
                        i3 = 0;
                        string = null;
                        string2 = null;
                        string3 = null;
                        i4 = 0;
                        i5 = 1;
                        z = false;
                        i6 = 0;
                        z2 = false;
                        z3 = false;
                        str2 = null;
                    }
                    cursorQuery.close();
                    z4 = z;
                    i7 = i6;
                    i8 = i4;
                    i9 = i5;
                    boolean z7 = z3;
                    i10 = i3;
                    str3 = string2;
                    str4 = str2;
                    str5 = string3;
                    z5 = z7;
                    boolean z8 = z2;
                    str6 = string;
                    z6 = z8;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            } else {
                str3 = null;
                z4 = false;
                z6 = false;
                str4 = null;
                z5 = false;
                i9 = 1;
                i8 = 0;
                str6 = null;
                i10 = 0;
                str5 = null;
                i7 = 0;
            }
            if (z5 || i9 == 10000 || !z4) {
                return;
            }
            if (SAppUtil.c.d() && SAppUtil.c.c() && (!Z(i8, i10, str) || AudioController.b0().l0() || "88888027".equals(str))) {
                return;
            }
            if (z6) {
                if (!c0() || i9 == 10001 || ir5.b() - this.m <= 3000) {
                    return;
                }
                ((Vibrator) AppContext.getContext().getSystemService("vibrator")).vibrate(r, -1);
                this.m = ir5.b();
                return;
            }
            int iF = F(zV, DomainHelper.c(str, i2), str4, false, false);
            if (iF == -1) {
                return;
            }
            if (!zV && ch.s().A() == 0) {
                w();
                v();
                this.k.cancel(iF);
                return;
            }
            this.g = str;
            String strL = L(str3, i8, zV);
            if (TextUtils.isEmpty(strL)) {
                return;
            }
            int i12 = i10;
            String str7 = str3;
            String str8 = str5;
            int i13 = i7;
            int i14 = i9;
            int i15 = i8;
            String str9 = str6;
            NotificationCompat.Builder contentText = NotificationChannelManager.MessageType.MSG.genNotificationCompatBuilder().setTicker(K(zV, i12, i9, str7, str8, i13, i8, str, null)).setAutoCancel(true).setContentTitle(strL).setContentText(J(zV, i12, i14, str7, str8, i13, i15, str, null, false));
            B0(contentText);
            try {
                bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                contentText.setLargeIcon(bitmapDrawable.getBitmap());
            }
            if (ir5.b() - this.m > 3000 && i14 != 10001) {
                E0(contentText);
                D0(contentText);
                if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                    contentText.setPriority(2);
                }
                this.m = ir5.b();
            }
            contentText.setLights(-16711936, 300, 900);
            contentText.setVisibility(1);
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
            if (i10 == 0) {
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(str);
                contactInfoItem.setBizType(i2);
                if (fu5.t(i2) && !AppContext.getContext().isBackground()) {
                    intent.putExtra("chat_need_back_to_main", false);
                }
                i11 = i15;
                intent.putExtra("thread_biz_type", i11);
                intent.putExtra("chat_item", contactInfoItem);
            } else {
                i11 = i15;
                GroupInfoItem groupInfoItem = new GroupInfoItem();
                groupInfoItem.setGroupId(str);
                intent.putExtra("fromType", 8);
                intent.putExtra("chat_item", groupInfoItem);
            }
            k86.X(intent);
            contentText.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), iF, intent, 268435456));
            if (i0(zV, i11) && !TextUtils.isEmpty(str9)) {
                gr2.j().k(str9, bq6.s(), new q(str, contentText, iF));
            }
            Notification notificationBuild = contentText.build();
            to.e(AppContext.getContext(), notificationBuild, ch.s().A());
            if (zV) {
                this.k.cancel(1000);
                z0(iF, notificationBuild);
            } else {
                w();
                v();
                z0(iF, notificationBuild);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PendingIntent r(int i2, String str, String str2, String str3, String str4, int i3, int i4, int i5, String str5) {
        RichMsgExItemVo.WinEx winEx;
        Intent intent;
        NoticeBarStyle noticeBarStyleF;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        NoticeBarStyle noticeBarStyle;
        RichMsgExItemVo richMsgExItemVo2;
        Pair<Integer, ContentValues> pairG;
        Object obj;
        RichMsgExVo richMsgExVoG;
        ArrayList<RichMsgExItemVo> arrayList2;
        RichMsgExItemVo richMsgExItemVo3;
        NoticeBarExt noticeBarExt;
        LogUtil.i("NotificationHelper", "buildPendingIntentForMsg packetMid=" + str3 + " threadBizType=" + i2 + " from=" + str + " uid=" + str2 + " extension=" + str4 + " packetMimeType=" + i3);
        RichMsgExVo richMsgExVo = null;
        str = null;
        String str6 = null;
        richMsgExVo = null;
        if (!dd6.c() || !"88888027".equals(str) || i3 != 28 || (richMsgExVoG = com.zenmen.palmchat.chat.g.g(str4)) == null || (arrayList2 = richMsgExVoG.items) == null || (richMsgExItemVo3 = arrayList2.get(0)) == null || (winEx = richMsgExItemVo3.wineEx) == null) {
            winEx = null;
        } else {
            NoticeBarStyle fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(str4);
            SmallVideoEntranceController.a(winEx.wineFeedId, EnterScene.LX_JUE, (fromMsgExtension == null || (noticeBarExt = fromMsgExtension.ext) == null) ? null : az2.c(noticeBarExt));
        }
        if (winEx != null) {
            Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
            intent2.setAction("extra_action_jump_smallvideo");
            intent2.putExtra("extra_winex", winEx);
            intent2.putExtra("extra_extension", str4);
            return PendingIntent.getBroadcast(AppContext.getContext(), i5, intent2, 134217728);
        }
        boolean z = true;
        if (jo6.k() && !TextUtils.isEmpty(str) && "88888003".equals(str)) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_square");
            bundle.putString("square_tab", "momentsTitle");
            aVar.b(bundle);
            intent = n5.b(AppContext.getContext(), aVar);
            intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
        } else {
            if (MediationConstant.RIT_TYPE_FEED.equals(str)) {
                Intent intent3 = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
                intent3.setAction("extra_action_jump_moments");
                if (!TextUtils.isEmpty(str2)) {
                    intent3.putExtra("moment_from_uid", str2);
                }
                intent3.putExtra("moment_from_mid", str3);
                NoticeBarStyle fromMsgExtension2 = NoticeBarStyle.parseFromMsgExtension(str4);
                if (fromMsgExtension2 != null && (pairG = mb4.g(fromMsgExtension2.url)) != null && (obj = pairG.second) != null) {
                    Integer asInteger = ((ContentValues) obj).getAsInteger("noticeType");
                    if (asInteger != null) {
                        intent3.putExtra("notice_type", asInteger);
                    }
                    Integer asInteger2 = ((ContentValues) pairG.second).getAsInteger("commentType");
                    if (asInteger2 != null) {
                        intent3.putExtra("comment_type", asInteger2);
                    }
                }
                return PendingIntent.getBroadcast(AppContext.getContext(), i5, intent3, 134217728);
            }
            if (i3 == 28 && a65.f(str)) {
                RichMsgExVo richMsgExVoG2 = com.zenmen.palmchat.chat.g.g(str4);
                if (richMsgExVoG2 == null || (noticeBarStyle = richMsgExVoG2.noticeBar) == null || noticeBarStyle.openType != 1) {
                    richMsgExVo = richMsgExVoG2;
                    if (a65.f(str)) {
                        Intent intent4 = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
                        if (i4 != 0) {
                        }
                        intent = intent4;
                    }
                } else {
                    ArrayList<RichMsgExItemVo> arrayList3 = richMsgExVoG2.items;
                    if (arrayList3 != null && (richMsgExItemVo2 = arrayList3.get(0)) != null) {
                        str6 = richMsgExItemVo2.url;
                    }
                    intent = new Intent(AppContext.getContext(), (Class<?>) InitActivity.class);
                    intent.putExtra("key_push_extension", str4);
                    intent.putExtra("key_push_param", str6);
                    intent.putExtra("key_push_chatitem_id", str);
                    intent.putExtra("key_from_push", true);
                    intent.putExtra("key_push_mid", str3);
                }
            } else if (a65.f(str) || (noticeBarStyleF = com.zenmen.palmchat.chat.g.f(str4)) == null || noticeBarStyleF.openType != 1) {
                Intent intent42 = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
                if (i4 != 0) {
                    ContactInfoItem contactInfoItem = new ContactInfoItem();
                    contactInfoItem.setBizType(i2);
                    contactInfoItem.setUid(str);
                    intent42.putExtra("thread_biz_type", i2);
                    if (fu5.t(i2) && !AppContext.getContext().isBackground()) {
                        z = false;
                    }
                    intent42.putExtra("chat_need_back_to_main", z);
                    intent42.putExtra("chat_back_to_greet", false);
                    intent42.putExtra("chat_item", contactInfoItem);
                    intent42.putExtra("extension", str4);
                } else {
                    GroupInfoItem groupInfoItem = new GroupInfoItem();
                    groupInfoItem.setGroupId(str);
                    intent42.putExtra("fromType", 8);
                    intent42.putExtra("chat_item", groupInfoItem);
                }
                intent = intent42;
            } else {
                String str7 = noticeBarStyleF.url;
                if (TextUtils.isEmpty(str7) && richMsgExVo != null && (arrayList = richMsgExVo.items) != null && (richMsgExItemVo = arrayList.get(0)) != null) {
                    str7 = richMsgExItemVo.url;
                }
                Intent intent5 = new Intent(AppContext.getContext(), (Class<?>) InitActivity.class);
                intent5.putExtra("key_push_extension", str4);
                intent5.putExtra("key_push_param", str7);
                intent5.putExtra("key_push_chatitem_id", str);
                intent5.putExtra("key_from_push", true);
                intent5.putExtra("key_push_mid", str3);
                intent = intent5;
            }
        }
        k86.X(intent);
        intent.putExtra("chat_from", "CHAT_FROM_NOTIFICATION");
        intent.putExtra("chat_notification_mid", str3);
        intent.putExtra("key_notification_style_type", str5);
        return PendingIntent.getActivity(AppContext.getContext(), i5, intent, 268435456);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0214  */
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r0(String str, String str2, String str3, int i2) {
        boolean z;
        String string;
        String string2;
        String string3;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        boolean z4;
        String str4;
        int i5;
        String str5;
        String str6;
        String str7;
        String str8;
        int i6;
        String str9;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObject;
        NoticeBarStyle fromMsgExtension;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z5;
        int iG;
        BitmapDrawable bitmapDrawable;
        String strOptString;
        String strOptString2;
        LogUtil.d("NotificationHelper", "notifyNewMomentsMessageImp");
        boolean zV = V();
        String strA = m40.a(str);
        int iB = m40.b(str);
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, "contact_relate=?", new String[]{strA}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    z = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_contact_ready")) == 1;
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("icon_url"));
                    string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                    string3 = cursorQuery.getString(cursorQuery.getColumnIndex("latest_message"));
                    if (cursorQuery.getInt(cursorQuery.getColumnIndex("latest_message_mime_type")) == 9) {
                        string3 = SAppUtil.b.b() ? tw5.c(AppContext.getContext(), string3, string2) : tw5.b(AppContext.getContext(), string3, string2);
                    }
                    i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_message_count"));
                    z3 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_nodisturb")) == 1;
                    z2 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_has_remind")) == 2;
                    cursorQuery.getInt(cursorQuery.getColumnIndex("thread_focus"));
                    i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_biz_type"));
                } else {
                    z = false;
                    string = null;
                    string2 = null;
                    string3 = null;
                    i3 = 0;
                    z2 = false;
                    z3 = false;
                    i4 = 0;
                }
                cursorQuery.close();
                z4 = z;
                int i7 = i4;
                str4 = string2;
                i5 = i7;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        } else {
            z4 = false;
            string = null;
            i5 = 0;
            string3 = null;
            i3 = 0;
            z2 = false;
            z3 = false;
            str4 = null;
        }
        if (i2 != 10001) {
            str5 = string3;
        } else if (str3 != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = new JSONObject(str3).optJSONObject("revokeMsg");
                if (jSONObjectOptJSONObject2 != null) {
                    strOptString = jSONObjectOptJSONObject2.optString("replaceMid");
                    try {
                        strOptString2 = jSONObjectOptJSONObject2.optString("replaceMsg");
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        strOptString2 = null;
                    }
                } else {
                    strOptString2 = null;
                    strOptString = null;
                }
            } catch (JSONException e3) {
                e = e3;
                strOptString = null;
            }
            if (!(!TextUtils.isEmpty(strOptString) ? com.zenmen.palmchat.database.b.z(str, strOptString) : false)) {
                return;
            } else {
                str5 = strOptString2;
            }
        }
        HashMap map = new HashMap(1);
        if ((z3 && !z2) || !z4) {
            map.put("type", "2");
            zn6.i("selfchannel_push_noshow", map);
            return;
        }
        String asString = "";
        if (str3 != null) {
            try {
                jSONObjectOptJSONObject = new JSONObject(str3).optJSONObject("appMsg");
            } catch (JSONException e4) {
                e = e4;
            }
            if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("items")) == null) {
                str6 = strA;
                str7 = asString;
                str8 = string;
                i6 = i3;
                str9 = str6;
            } else {
                if (jSONArrayOptJSONArray.length() > 0) {
                    try {
                        jSONObject = jSONArrayOptJSONArray.getJSONObject(0);
                    } catch (JSONException e5) {
                        e = e5;
                        str6 = strA;
                        e.printStackTrace();
                        str7 = asString;
                        str8 = string;
                        i6 = i3;
                        str9 = str6;
                        int i8 = i5;
                        String str15 = str8;
                        String str16 = str9;
                        String str17 = str5;
                        String str18 = str7;
                        int i9 = i6;
                        String str19 = str4;
                        String strK = K(zV, iB, i2, str4, str17, i9, i8, strA, str3);
                        String strL = L(str19, i8, zV);
                        String strJ = J(zV, iB, i2, str19, str17, i9, i8, strA, str3, true);
                        fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(str3);
                        if (fromMsgExtension != null) {
                        }
                        iG = G(zV, str16, str11, z5);
                        if (iG != -1) {
                        }
                        map.put(str12, "11");
                        zn6.i(str10, map);
                        return;
                    }
                    if (jSONObject != null) {
                        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("feedEx");
                        Pair<Integer, ContentValues> pairG = mb4.g(jSONObject.optString("url"));
                        if (pairG != null) {
                            asString = ((ContentValues) pairG.second).getAsString(DeviceInfoUtil.UID_TAG);
                            if (TextUtils.isEmpty(asString)) {
                                str6 = strA;
                            } else {
                                str6 = strA + "_" + asString;
                            }
                            if (jSONObjectOptJSONObject3 != null) {
                                try {
                                    String strOptString3 = jSONObjectOptJSONObject3.optString("headIconUrl");
                                    if (!TextUtils.isEmpty(strOptString3)) {
                                        string = strOptString3;
                                    }
                                } catch (JSONException e6) {
                                    e = e6;
                                    e.printStackTrace();
                                }
                            }
                            i3 = 0;
                        }
                        str7 = asString;
                        str8 = string;
                        i6 = i3;
                        str9 = str6;
                    }
                }
                str6 = strA;
                str7 = asString;
                str8 = string;
                i6 = i3;
                str9 = str6;
            }
        } else {
            str7 = "";
            str8 = string;
            i6 = i3;
            str9 = strA;
        }
        int i82 = i5;
        String str152 = str8;
        String str162 = str9;
        String str172 = str5;
        String str182 = str7;
        int i92 = i6;
        String str192 = str4;
        String strK2 = K(zV, iB, i2, str4, str172, i92, i82, strA, str3);
        String strL2 = L(str192, i82, zV);
        String strJ2 = J(zV, iB, i2, str192, str172, i92, i82, strA, str3, true);
        fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(str3);
        if (fromMsgExtension != null) {
            str10 = "selfchannel_push_noshow";
            str11 = str2;
            str12 = "type";
            str13 = str152;
            str14 = strL2;
            z5 = false;
        } else {
            if (fromMsgExtension.unnoticeable) {
                map.put("type", "0");
                zn6.i("selfchannel_push_noshow", map);
                return;
            }
            str10 = "selfchannel_push_noshow";
            if (!TextUtils.isEmpty(fromMsgExtension.title)) {
                strL2 = fromMsgExtension.title;
            }
            if (!TextUtils.isEmpty(fromMsgExtension.digest)) {
                strJ2 = fromMsgExtension.digest;
            }
            if (TextUtils.isEmpty(fromMsgExtension.icon)) {
                str11 = str2;
                str12 = "type";
                str13 = str152;
            } else {
                str13 = fromMsgExtension.icon;
                str11 = str2;
                str12 = "type";
            }
            str14 = strL2;
            z5 = true;
        }
        iG = G(zV, str162, str11, z5);
        if (iG != -1 || TextUtils.isEmpty(str14)) {
            map.put(str12, "11");
            zn6.i(str10, map);
            return;
        }
        NotificationChannelManager.MessageType messageType = NotificationChannelManager.MessageType.MOMENT;
        if (NotificationChannelManager.a(messageType)) {
            this.j = strA;
            NotificationCompat.Builder contentText = messageType.genNotificationCompatBuilder().setTicker(strK2).setAutoCancel(true).setContentTitle(str14).setContentText(strJ2);
            B0(contentText);
            try {
                bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
            } catch (NullPointerException e7) {
                e7.printStackTrace();
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                contentText.setLargeIcon(bitmapDrawable.getBitmap());
            }
            if (ir5.b() - this.m > 3000 && i2 != 10001) {
                E0(contentText);
                D0(contentText);
                if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                    contentText.setPriority(2);
                }
                this.m = ir5.b();
            }
            contentText.setLights(-16711936, 300, 900);
            contentText.setVisibility(1);
            if (AppContext.getContext().isBackground()) {
                Intent intent = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
                intent.setAction("extra_action_jump_moments");
                if (!TextUtils.isEmpty(str182)) {
                    intent.putExtra("moment_from_uid", str182);
                }
                intent.putExtra("moment_from_mid", str11);
                contentText.setContentIntent(PendingIntent.getBroadcast(AppContext.getContext(), iG, intent, 134217728));
                if (i0(zV, i82) && !TextUtils.isEmpty(str13)) {
                    gr2.j().k(str13, bq6.s(), new h(strA, contentText, iG));
                }
                Notification notificationBuild = contentText.build();
                if (zV) {
                    this.k.cancel(6000);
                    z0(iG, notificationBuild);
                } else {
                    x();
                    z0(iG, notificationBuild);
                }
                this.f++;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("mid", str11);
                    jSONObject2.put("fromuid", strA);
                    jSONObject2.put("pageid", t5.i());
                    jSONObject2.put("channelId", NotificationChannelManager.MessageType.MOMENT.getNotificationChannelForLog());
                    jSONObject2.put("showNewStyle", false);
                    if (h05.c(strA)) {
                        jSONObject2.put(str12, "H-feedpush");
                    }
                } catch (JSONException e8) {
                    e8.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("msg_show", "1", null, jSONObject2.toString());
            }
        }
    }

    public void s() {
        try {
            v();
            w();
            y();
            z();
            x();
            this.k.cancel(1000);
            this.k.cancel(999);
            this.k.cancel(6000);
            this.k.cancel(7000);
            x24.d().a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s0(String str, String str2, String str3, int i2, int i3) {
        String str4;
        String str5;
        String str6;
        String str7;
        HashMap map;
        String str8;
        String str9;
        Object obj;
        String str10;
        String str11;
        String str12;
        Object obj2;
        BitmapDrawable bitmapDrawable;
        Pair<Integer, ContentValues> pairG;
        Object obj3;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        Object obj4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mid", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("p1", null, null, jSONObject.toString());
        HashMap map2 = new HashMap(1);
        if (!P() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            map2.put("type", "8");
            zn6.i("selfchannel_push_noshow", map2);
            return;
        }
        V();
        String strA = m40.a(str);
        m40.b(str);
        if (SAppUtil.c.d() && SAppUtil.c.c()) {
            if (!a0(str, str2, i2, i3)) {
                map2.put("type", "5");
                zn6.i("selfchannel_push_noshow", map2);
                return;
            }
        } else if (!X()) {
            map2.put("type", "5");
            zn6.i("selfchannel_push_noshow", map2);
            return;
        }
        if (AudioController.b0().l0()) {
            map2.put("type", "6");
            zn6.i("selfchannel_push_noshow", map2);
            return;
        }
        if (i2 == 10000 || strA == null || A(str) || strA.equals(AccountUtils.p(AppContext.getContext()))) {
            map2.put("type", "9");
            zn6.i("selfchannel_push_noshow", map2);
            return;
        }
        NoticeBarStyle fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(str3);
        if (i2 == 103 && !AppContext.getContext().isBackground()) {
            LogUtil.d("lognotify", "notifyNewMessageImp: app is foreground, return");
            if (fromMsgExtension == null) {
                LogUtil.d("lognotify", "notifyNewMessageImp: noticeBar is null, return");
                return;
            }
            HashMap map3 = new HashMap();
            try {
                map3.put("mid", str2);
                map3.put("from", "square");
                map3.put("pageid", Integer.valueOf(t5.i()));
                Pair<Integer, ContentValues> pairG2 = mb4.g(fromMsgExtension.url);
                if (pairG2 != null && (obj4 = pairG2.second) != null) {
                    for (String str13 : ((ContentValues) obj4).keySet()) {
                        map3.put(str13, ((ContentValues) pairG2.second).get(str13));
                    }
                }
            } catch (Exception unused) {
            }
            map2.put("type", "10");
            zn6.i("selfchannel_push_noshow", map2);
            qj5.Y(new JSONObject(map3));
            return;
        }
        int iM = M(str2);
        if (i2 == 300 || i2 == 103) {
            NoticeBarStyle noticeBarStyleF = com.zenmen.palmchat.chat.g.f(str3);
            if (noticeBarStyleF != null) {
                str6 = noticeBarStyleF.icon;
                str7 = noticeBarStyleF.title;
                str5 = noticeBarStyleF.digest;
                str4 = noticeBarStyleF.url;
            } else {
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            map = map2;
            String str14 = str5;
            str8 = str4;
            str9 = str7;
            obj = "type";
            str10 = str14;
        } else {
            RichMsgExVo richMsgExVoG = com.zenmen.palmchat.chat.g.g(str3);
            if (richMsgExVoG == null || (arrayList = richMsgExVoG.items) == null || (richMsgExItemVo = arrayList.get(0)) == null) {
                map = map2;
                str11 = "selfchannel_push_noshow";
                obj = "type";
                str9 = null;
                str12 = null;
                str10 = null;
                str8 = null;
                if (xg5.e().l(str3)) {
                    if (iM == -1 || TextUtils.isEmpty(str9)) {
                        HashMap map4 = map;
                        map4.put(obj, "11");
                        zn6.i(str11, map4);
                        return;
                    }
                    LogUtil.i("NotificationHelper", "message: " + str8);
                    LogUtil.i("NotificationHelper", "title: " + str9);
                    LogUtil.i("NotificationHelper", "iconURL: " + str12);
                    LogUtil.i("NotificationHelper", "content: " + str10);
                    NotificationChannelManager.MessageType messageType = NotificationChannelManager.MessageType.PUBLIC;
                    if (e0(str2)) {
                        messageType = NotificationChannelManager.MessageType.SUBSCRIPTION_MSG;
                    }
                    NotificationChannelManager.MessageType messageType2 = messageType;
                    if (NotificationChannelManager.a(messageType2)) {
                        NotificationCompat.Builder contentText = messageType2.genNotificationCompatBuilder().setTicker(str9).setAutoCancel(true).setContentTitle(str9).setContentText(str10);
                        B0(contentText);
                        try {
                            obj2 = "from";
                        } catch (NullPointerException e3) {
                            e = e3;
                            obj2 = "from";
                        }
                        try {
                            bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
                        } catch (NullPointerException e4) {
                            e = e4;
                            e.printStackTrace();
                            bitmapDrawable = null;
                        }
                        if (bitmapDrawable != null) {
                            contentText.setLargeIcon(bitmapDrawable.getBitmap());
                        }
                        NoticeBarStyle noticeBarStyle = new NoticeBarStyle();
                        noticeBarStyle.title = str9;
                        noticeBarStyle.digest = str10;
                        noticeBarStyle.icon = str12;
                        if (fromMsgExtension != null) {
                            noticeBarStyle.style = fromMsgExtension.style;
                        }
                        String strA0 = A0(contentText, noticeBarStyle);
                        if (ir5.b() - this.m > 3000 && i2 != 10001) {
                            E0(contentText);
                            D0(contentText);
                            if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                                contentText.setPriority(2);
                            }
                            this.m = ir5.b();
                        }
                        contentText.setLights(-16711936, 300, 900);
                        contentText.setVisibility(1);
                        Intent intent = new Intent(AppContext.getContext(), (Class<?>) InitActivity.class);
                        intent.putExtra("key_push_extension", str3);
                        intent.putExtra("key_push_param", str8);
                        intent.putExtra("key_from_push", true);
                        intent.putExtra("key_push_mid", str2);
                        intent.putExtra("key_mime_type", i2);
                        intent.putExtra("key_notification_style_type", strA0);
                        k86.X(intent);
                        contentText.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), iM, intent, 268435456));
                        if (!TextUtils.isEmpty(str12)) {
                            gr2.j().k(str12, bq6.s(), new e(contentText, iM));
                        }
                        x24.d().h(iM, contentText, new w24(str2, String.valueOf(i2), str, 1), new f(str2));
                        Notification notificationBuild = contentText.build();
                        to.e(AppContext.getContext(), notificationBuild, ch.s().A());
                        z0(iM, notificationBuild);
                        if (W(AppContext.getContext())) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("mid", str2);
                                jSONObject2.put("style", strA0);
                                jSONObject2.put("channelId", messageType2.getNotificationChannelForLog());
                                jSONObject2.put("showNewStyle", false);
                            } catch (JSONException e5) {
                                e5.printStackTrace();
                            }
                            LogUtil.uploadInfoImmediate("p2", null, null, jSONObject2.toString());
                        }
                        if (i2 == 103) {
                            HashMap map5 = new HashMap();
                            map5.put("mid", str2);
                            map5.put(obj2, "square");
                            map5.put("pageid", Integer.valueOf(t5.i()));
                            map5.put("channelId", messageType2.getNotificationChannelForLog());
                            map5.put("showNewStyle", Boolean.FALSE);
                            if (fromMsgExtension != null && (pairG = mb4.g(fromMsgExtension.url)) != null && (obj3 = pairG.second) != null) {
                                for (String str15 : ((ContentValues) obj3).keySet()) {
                                    map5.put(str15, ((ContentValues) pairG.second).get(str15));
                                }
                            }
                            LogUtil.uploadInfoImmediate("msg_show", "1", null, new JSONObject(map5).toString());
                        }
                        if (i2 == 300) {
                            xa3.b(bq.b.V, str3, "self");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            str6 = richMsgExItemVo.cover;
            String str16 = richMsgExItemVo.title;
            String str17 = richMsgExItemVo.digest;
            str8 = richMsgExItemVo.url;
            map = map2;
            str10 = str17;
            str9 = str16;
            obj = "type";
        }
        String str18 = str6;
        str11 = "selfchannel_push_noshow";
        str12 = str18;
        if (xg5.e().l(str3)) {
        }
    }

    public void t(int i2) {
        if (i2 == 0) {
            v();
            return;
        }
        if (i2 != 2) {
            w();
            this.k.cancel(1000);
        } else {
            x();
            this.k.cancel(6000);
            this.f = 0;
        }
    }

    public void t0(MessageVo messageVo) {
        u93.e(new o(messageVo));
    }

    public void u(int i2) {
        try {
            this.k.cancel(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void u0(MessageVo messageVo) {
        int i2;
        boolean z;
        BitmapDrawable bitmapDrawable;
        String str = messageVo.mid;
        if (P()) {
            String strE = com.zenmen.palmchat.database.b.E(messageVo);
            if (TextUtils.isEmpty(strE) || fu5.v(DomainHelper.n(strE))) {
                return;
            }
            String strJ = DomainHelper.j(strE);
            Boolean boolValueOf = Boolean.valueOf(m40.b(strE) == 0);
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.d(strJ, DomainHelper.n(strE))}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_biz_type"));
                        z = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_focus")) == 1;
                    } else {
                        i2 = 0;
                    }
                } finally {
                    cursorQuery.close();
                }
            } else {
                i2 = 0;
                z = false;
            }
            if (z) {
                if (!c0() || ir5.b() - this.m <= 3000) {
                    return;
                }
                ((Vibrator) AppContext.getContext().getSystemService("vibrator")).vibrate(r, -1);
                this.m = ir5.b();
                return;
            }
            NotificationCompat.Builder contentText = NotificationChannelManager.MessageType.MSG.genNotificationCompatBuilder().setTicker(AppContext.getContext().getResources().getString(R.string.notify_message_send_fail)).setAutoCancel(true).setContentTitle(AppContext.getContext().getResources().getString(R.string.app_name)).setContentText(AppContext.getContext().getResources().getString(R.string.notify_message_send_fail));
            B0(contentText);
            try {
                bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                contentText.setLargeIcon(bitmapDrawable.getBitmap());
            }
            if (ir5.b() - this.m > 3000) {
                E0(contentText);
                D0(contentText);
                if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                    contentText.setPriority(2);
                }
                this.m = ir5.b();
            }
            contentText.setLights(-16711936, 300, 900);
            contentText.setVisibility(1);
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
            if (boolValueOf.booleanValue()) {
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(strJ);
                contactInfoItem.setBizType(i2);
                if (fu5.t(i2) && !AppContext.getContext().isBackground()) {
                    intent.putExtra("chat_need_back_to_main", false);
                }
                intent.putExtra("chat_item", contactInfoItem);
            } else {
                GroupInfoItem groupInfoItem = new GroupInfoItem();
                groupInfoItem.setGroupId(strJ);
                groupInfoItem.setBizType(i2);
                intent.putExtra("fromType", 8);
                intent.putExtra("chat_item", groupInfoItem);
            }
            intent.putExtra("thread_biz_type", i2);
            k86.X(intent);
            contentText.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), 0, intent, 268435456));
            z0(999, contentText.build());
        }
    }

    public final void v() {
        Iterator<Map.Entry<String, Integer>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            this.k.cancel(it.next().getValue().intValue());
        }
        this.b.clear();
    }

    public void v0(MessageProto.Message message) {
        u93.e(new RunnableC1122a(message));
    }

    public final void w() {
        Iterator<Map.Entry<String, s>> it = this.f15717a.entrySet().iterator();
        while (it.hasNext()) {
            int i2 = it.next().getValue().b;
            if (i2 != 1000) {
                this.k.cancel(i2);
            }
        }
        this.f15717a.clear();
    }

    public final void w0(MessageProto.Message message) {
        String str;
        String str2;
        String str3;
        BitmapDrawable bitmapDrawable;
        HashMap map = new HashMap(1);
        String from = message.getFrom();
        String mid = message.getMid();
        int iM = M(mid);
        LogUtil.i(VideoSDKPushReceiver.TAG, "notifyVideoMessageImp ext=" + message.getExtension());
        NoticeBarStyle fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(message.getExtension());
        if (fromMsgExtension != null) {
            str = !TextUtils.isEmpty(fromMsgExtension.title) ? fromMsgExtension.title : null;
            str2 = !TextUtils.isEmpty(fromMsgExtension.digest) ? fromMsgExtension.digest : null;
            str3 = !TextUtils.isEmpty(fromMsgExtension.icon) ? fromMsgExtension.icon : null;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if (fromMsgExtension == null || fromMsgExtension.unnoticeable || iM == -1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (fromMsgExtension == null || fromMsgExtension.unnoticeable) {
                map.put("type", "0");
                zn6.i("selfchannel_push_noshow", map);
                return;
            } else {
                if (iM == -1) {
                    map.put("type", "11");
                    zn6.i("selfchannel_push_noshow", map);
                    return;
                }
                return;
            }
        }
        NotificationChannelManager.MessageType messageType = NotificationChannelManager.MessageType.PUBLIC;
        if (NotificationChannelManager.a(messageType)) {
            NotificationCompat.Builder contentText = messageType.genNotificationCompatBuilder().setTicker(str).setAutoCancel(true).setContentTitle(str).setContentText(str2);
            B0(contentText);
            try {
                bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                contentText.setLargeIcon(bitmapDrawable.getBitmap());
            }
            if (ir5.b() - this.m > 3000) {
                E0(contentText);
                D0(contentText);
                if (!k86.E(AppContext.getContext()) && Integer.valueOf(ac1.d).intValue() >= 21) {
                    contentText.setPriority(2);
                }
                this.m = ir5.b();
            }
            contentText.setLights(-16711936, 300, 900);
            contentText.setVisibility(1);
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
            intent.setAction("extra_action_jump_smallvideo_msg_push");
            intent.putExtra("extra_extension", message.getExtension());
            PendingIntent broadcast = PendingIntent.getBroadcast(AppContext.getContext(), iM, intent, 134217728);
            String str4 = fromMsgExtension.url;
            if (str4 != null) {
                SmallVideoEntranceController.b(str4, EnterScene.PUSH, az2.c(fromMsgExtension.ext));
            }
            contentText.setContentIntent(broadcast);
            if (!TextUtils.isEmpty(str3)) {
                gr2.j().k(str3, bq6.s(), new b(contentText, iM));
            }
            z0(iM, contentText.build());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mid", mid);
                jSONObject.put("fromuid", from);
                jSONObject.put("pageid", t5.i());
                if (h05.c(from)) {
                    jSONObject.put("type", "H-feedpush");
                }
                jSONObject.put("channelId", NotificationChannelManager.MessageType.PUBLIC.getNotificationChannelForLog());
                jSONObject.put("showNewStyle", false);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("msg_show", "1", null, jSONObject.toString());
            zn6.d("dou_push_sh", null, new JSONObject(new c(fromMsgExtension)).toString());
        }
    }

    public final void x() {
        Iterator<Map.Entry<String, s>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            int i2 = it.next().getValue().b;
            if (i2 != 6000) {
                this.k.cancel(i2);
            }
        }
        this.e.clear();
    }

    public void x0(t tVar) {
        BitmapDrawable bitmapDrawable;
        if (tVar != null && NotificationChannelManager.a(tVar.f)) {
            NotificationCompat.Builder contentText = tVar.f.genNotificationCompatBuilder().setTicker(tVar.f15737a).setAutoCancel(true).setContentTitle(tVar.f15737a).setContentText(tVar.b);
            B0(contentText);
            try {
                bitmapDrawable = (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                contentText.setLargeIcon(bitmapDrawable.getBitmap());
            }
            if (ir5.b() - this.m > 3000) {
                E0(contentText);
                D0(contentText);
                this.m = ir5.b();
            }
            contentText.setLights(-16711936, 300, 900);
            contentText.setVisibility(1);
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) InitActivity.class);
            intent.putExtra("key_push_param", tVar.d);
            intent.putExtra("key_from_push", true);
            k86.X(intent);
            contentText.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), tVar.e, intent, 268435456));
            if (!TextUtils.isEmpty(tVar.c)) {
                gr2.j().k(tVar.c, bq6.s(), new d(contentText, tVar));
            }
            Notification notificationBuild = contentText.build();
            to.e(AppContext.getContext(), notificationBuild, ch.s().A());
            z0(tVar.e, notificationBuild);
            zn6.c("keepalive_notice", "view");
        }
    }

    public final void y() {
        Iterator<Map.Entry<String, Integer>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            this.k.cancel(it.next().getValue().intValue());
        }
        this.c.clear();
    }

    public void y0(Activity activity) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra(WfConstant.EXTRA_KEY_APP_PKG, activity.getPackageName());
            intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        }
        try {
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void z() {
        Iterator<Map.Entry<String, s>> it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            this.k.cancel(it.next().getValue().b);
        }
        this.d.clear();
    }

    public final void z0(int i2, Notification notification) {
        try {
            this.k.notify(i2, notification);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationCompat.Builder f15719a;
        public final /* synthetic */ int b;

        public b(NotificationCompat.Builder builder, int i) {
            this.f15719a = builder;
            this.b = i;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                this.f15719a.setLargeIcon(bitmap);
                a.this.z0(this.b, this.f15719a.build());
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationCompat.Builder f15721a;
        public final /* synthetic */ t b;

        public d(NotificationCompat.Builder builder, t tVar) {
            this.f15721a = builder;
            this.b = tVar;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                this.f15721a.setLargeIcon(bitmap);
                a.this.z0(this.b.e, this.f15721a.build());
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationCompat.Builder f15722a;
        public final /* synthetic */ int b;

        public e(NotificationCompat.Builder builder, int i) {
            this.f15722a = builder;
            this.b = i;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                this.f15722a.setLargeIcon(bitmap);
                a.this.z0(this.b, this.f15722a.build());
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15725a;
        public final /* synthetic */ NotificationCompat.Builder b;
        public final /* synthetic */ int c;

        public h(String str, NotificationCompat.Builder builder, int i) {
            this.f15725a = str;
            this.b = builder;
            this.c = i;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (!this.f15725a.equals(a.this.j) || bitmap == null) {
                return;
            }
            this.b.setLargeIcon(bitmap);
            a.this.z0(this.c, this.b.build());
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15727a;
        public final /* synthetic */ NotificationCompat.Builder b;
        public final /* synthetic */ int c;

        public j(String str, NotificationCompat.Builder builder, int i) {
            this.f15727a = str;
            this.b = builder;
            this.c = i;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (!this.f15727a.equals(a.this.i) || bitmap == null) {
                return;
            }
            this.b.setLargeIcon(bitmap);
            a.this.z0(this.c, this.b.build());
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15729a;
        public final /* synthetic */ NotificationCompat.Builder b;
        public final /* synthetic */ int c;

        public l(String str, NotificationCompat.Builder builder, int i) {
            this.f15729a = str;
            this.b = builder;
            this.c = i;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (!this.f15729a.equals(a.this.h) || bitmap == null) {
                return;
            }
            this.b.setLargeIcon(bitmap);
            a.this.z0(this.c, this.b.build());
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15734a;
        public final /* synthetic */ NotificationCompat.Builder b;
        public final /* synthetic */ int c;

        public q(String str, NotificationCompat.Builder builder, int i) {
            this.f15734a = str;
            this.b = builder;
            this.c = i;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (!this.f15734a.equals(a.this.g) || bitmap == null) {
                return;
            }
            this.b.setLargeIcon(bitmap);
            a.this.z0(this.c, this.b.build());
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    public boolean i0(boolean z, int i2) {
        return z;
    }
}
