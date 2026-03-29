package defpackage;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.chat.specialattention.NotificationUpdateInfo;
import com.zenmen.palmchat.chat.specialattention.SpecialAttentionConfig;
import com.zenmen.palmchat.chat.specialattention.SpecialAttentionService;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xg5 {
    public static volatile xg5 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Notification f21951a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final q34 c = new q34();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21952a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FrameworkBaseActivity d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;

        public a(boolean z, boolean z2, String str, FrameworkBaseActivity frameworkBaseActivity, boolean z3, boolean z4) {
            this.f21952a = z;
            this.b = z2;
            this.c = str;
            this.d = frameworkBaseActivity;
            this.e = z3;
            this.f = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            yg5.b(this.f21952a, "click", this.b ? 2 : 1, this.c);
            zg5.b(this.d, this.c, this.e, this.f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21953a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FrameworkBaseActivity d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;

        public b(boolean z, boolean z2, String str, FrameworkBaseActivity frameworkBaseActivity, boolean z3, boolean z4) {
            this.f21953a = z;
            this.b = z2;
            this.c = str;
            this.d = frameworkBaseActivity;
            this.e = z3;
            this.f = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            yg5.b(this.f21953a, "click", this.b ? 2 : 1, this.c);
            zg5.b(this.d, this.c, this.e, this.f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21954a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Runnable d;

        public c(boolean z, boolean z2, String str, Runnable runnable) {
            this.f21954a = z;
            this.b = z2;
            this.c = str;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            yg5.b(this.f21954a, "click", this.b ? 2 : 1, this.c);
            this.d.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f21955a;

        public d(Runnable runnable) {
            this.f21955a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21955a.run();
        }
    }

    public static xg5 e() {
        if (d == null) {
            synchronized (xg5.class) {
                if (d == null) {
                    d = new xg5();
                }
            }
        }
        return d;
    }

    public boolean a(FrameworkBaseActivity frameworkBaseActivity, ChatItem chatItem, Runnable runnable, int i) {
        if (zg5.h() || i <= zg5.g().lotsmsg_num || frameworkBaseActivity == null || chatItem == null || chatItem.getChatType() != 0 || a65.e(chatItem) || !i(false)) {
            return false;
        }
        v();
        o(frameworkBaseActivity, chatItem.getChatId(), true, runnable, true, true);
        return true;
    }

    public void b(FrameworkBaseActivity frameworkBaseActivity, ChatItem chatItem, Runnable runnable) {
        if (zg5.h() || frameworkBaseActivity == null || chatItem == null || chatItem.getChatType() != 0 || a65.e(chatItem) || !i(true)) {
            return;
        }
        v();
        o(frameworkBaseActivity, chatItem.getChatId(), true, runnable, true, true);
    }

    public void c(Activity activity, Runnable runnable) {
        if (s34.c() == 0 && zg5.h()) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            if (Math.abs(sPUtil.i(scene, "key_special_attention_notification_close", 0L) - ir5.b()) > ((long) (zg5.g().getNotificationCloseRate() * 24 * 60 * 60)) * 1000) {
                sPUtil.t(scene, "key_special_attention_notification_close", Long.valueOf(ir5.b()));
                zg5.k(activity, new d(runnable));
            }
        }
    }

    public Notification d(NotificationUpdateInfo notificationUpdateInfo) {
        return zg5.e(this.c.i(notificationUpdateInfo));
    }

    public Handler f() {
        return this.b;
    }

    public Notification g() {
        return this.f21951a;
    }

    public boolean h() {
        return this.f21951a != null;
    }

    public final boolean i(boolean z) {
        SpecialAttentionConfig specialAttentionConfigG = zg5.g();
        boolean z2 = z ? specialAttentionConfigG.getmsg_enable : specialAttentionConfigG.lotsmsg_enable;
        int i = z ? specialAttentionConfigG.getmsg_validtime : specialAttentionConfigG.lotsmsg_validtime;
        int i2 = z ? specialAttentionConfigG.getmsg_popwinrate : specialAttentionConfigG.lotsmsg_popwinrate;
        int i3 = z ? specialAttentionConfigG.getmsg_maxtime : specialAttentionConfigG.lotsmsg_maxtime;
        if (!z2) {
            return false;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        int iF = sPUtil.f(scene, "key_special_attention_guide_count", 0);
        long jI = sPUtil.i(scene, "key_special_attention_guide_time", 0L);
        if (Math.abs(jI - ir5.b()) > ((long) (i * 24 * 60 * 60)) * 1000 && iF != 0) {
            sPUtil.t(scene, "key_special_attention_guide_count", 0);
            iF = 0;
        }
        return iF < i3 && Math.abs(jI - ir5.b()) > ((long) (((i2 * 24) * 60) * 60)) * 1000;
    }

    public final void j(Activity activity, NotificationUpdateInfo notificationUpdateInfo) {
        ThreadChatItem threadChatItemF = nw5.f(notificationUpdateInfo.uid);
        if (threadChatItemF == null || !threadChatItemF.isContactReady) {
            fu5.y(notificationUpdateInfo.uid, 60, 5000, true);
            return;
        }
        ChatItem chatItemConvert2ContactOrGroupChatInfo = threadChatItemF.convert2ContactOrGroupChatInfo();
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        if (chatItemConvert2ContactOrGroupChatInfo instanceof ContactInfoItem) {
            intent.setExtrasClassLoader(ContactInfoItem.class.getClassLoader());
        } else if (chatItemConvert2ContactOrGroupChatInfo instanceof GroupInfoItem) {
            intent.setExtrasClassLoader(GroupInfoItem.class.getClassLoader());
        }
        intent.putExtra("chat_item", chatItemConvert2ContactOrGroupChatInfo);
        intent.putExtra("thread_biz_type", chatItemConvert2ContactOrGroupChatInfo.getBizType());
        intent.putExtra("chat_need_back_to_main", true);
        intent.putExtra("chat_back_to_greet", false);
        k86.X(intent);
        AppContext.getContext().startActivity(intent);
    }

    public boolean k(String str, String str2, int i, long j) {
        if (!e().h() || !zg5.j(str)) {
            return false;
        }
        NotificationUpdateInfo notificationUpdateInfo = new NotificationUpdateInfo(str);
        notificationUpdateInfo.type = 1;
        notificationUpdateInfo.unRead = i;
        notificationUpdateInfo.time = j;
        notificationUpdateInfo.des = str2;
        this.c.w(notificationUpdateInfo, true);
        return true;
    }

    public boolean l(String str) {
        String str2;
        NoticeBarStyle noticeBarStyleF = g.f(str);
        if (noticeBarStyleF != null && (str2 = noticeBarStyleF.url) != null) {
            Uri uri = Uri.parse(str2);
            String queryParameter = uri.getQueryParameter("page");
            String queryParameter2 = uri.getQueryParameter(DeviceInfoUtil.UID_TAG);
            if (queryParameter != null && queryParameter.equals("a0408") && zg5.j(queryParameter2) && e().h()) {
                NotificationUpdateInfo notificationUpdateInfo = new NotificationUpdateInfo(queryParameter2);
                notificationUpdateInfo.type = 2;
                notificationUpdateInfo.jumpUrl = noticeBarStyleF.url;
                notificationUpdateInfo.unRead = 1;
                notificationUpdateInfo.des = noticeBarStyleF.digest;
                notificationUpdateInfo.time = ir5.b();
                this.c.w(notificationUpdateInfo, true);
                return true;
            }
        }
        return false;
    }

    public void m() {
        if (h()) {
            s(false);
        }
    }

    public void n(Activity activity) {
        NotificationUpdateInfo notificationUpdateInfoJ = this.c.j();
        if (notificationUpdateInfoJ == null) {
            activity.startActivity(new Intent(AppContext.getContext(), (Class<?>) MainTabsActivity.class));
            return;
        }
        yg5.a("click", notificationUpdateInfoJ.uid);
        int i = notificationUpdateInfoJ.type;
        if (i == 0) {
            j(activity, notificationUpdateInfoJ);
            return;
        }
        if (i == 1) {
            j(activity, notificationUpdateInfoJ);
        } else if (i == 2) {
            ve.s(activity, notificationUpdateInfoJ.jumpUrl, false);
            e().u(2);
        }
    }

    public void o(FrameworkBaseActivity frameworkBaseActivity, String str, boolean z, Runnable runnable, boolean z2, boolean z3) {
        if (!z) {
            yg5.b(z3, "click", 3, str);
            zg5.b(frameworkBaseActivity, str, z, z2);
            return;
        }
        boolean z4 = s34.c() == 1;
        yg5.b(z3, "view", z4 ? 2 : 1, str);
        if (!z4) {
            zg5.l(frameworkBaseActivity, new c(z3, z4, str, runnable));
        } else if (z3) {
            zg5.m(frameworkBaseActivity, new a(z3, z4, str, frameworkBaseActivity, z, z2));
        } else {
            zg5.c(frameworkBaseActivity, new b(z3, z4, str, frameworkBaseActivity, z, z2));
        }
    }

    public void p(NotificationUpdateInfo notificationUpdateInfo) {
        if (SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_special_attention_error", false)) {
            HashMap map = new HashMap();
            map.put("action", "ClientSyncError");
            map.put("detail", "SpecialAttentionStartServiceError");
            LogUtil.i("SpecialAttentionManager", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map, (Throwable) null);
            return;
        }
        try {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) SpecialAttentionService.class);
            intent.setAction("action_foreground_notification");
            intent.putExtra("extra_foreground_notification", notificationUpdateInfo);
            if (Build.VERSION.SDK_INT >= 26) {
                AppContext.getContext().startForegroundService(intent);
            } else {
                AppContext.getContext().startService(intent);
            }
            yg5.a("view", notificationUpdateInfo.uid);
        } catch (Exception e) {
            e.printStackTrace();
            t();
        }
    }

    public void q(boolean z) {
        if (zg5.h() && zg5.g().noticebar_enable && s34.c() == 1) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            long jI = sPUtil.i(scene, "key_special_attention_close", 0L);
            if (jI > 0 && z) {
                sPUtil.t(scene, "key_special_attention_close", 0L);
            }
            if (Math.abs(jI - ir5.b()) > ((long) (zg5.g().noticebar_permanent_close * 24 * 60 * 60)) * 1000 || z) {
                this.c.o();
            }
        }
    }

    public void r(Notification notification) {
        this.f21951a = notification;
        if (notification != null) {
            this.c.p();
        }
    }

    public void s(boolean z) {
        if (z) {
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_special_attention_close", Long.valueOf(ir5.b()));
        }
        try {
            AppContext.getContext().stopService(new Intent(AppContext.getContext(), (Class<?>) SpecialAttentionService.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        t();
    }

    public void t() {
        this.f21951a = null;
        this.c.q();
    }

    public void u(int i) {
        if (e().h()) {
            this.c.u(i);
        }
    }

    public final void v() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        sPUtil.t(scene, "key_special_attention_guide_count", Integer.valueOf(sPUtil.f(scene, "key_special_attention_guide_count", 0) + 1));
        sPUtil.t(scene, "key_special_attention_guide_time", Long.valueOf(ir5.b()));
    }
}
