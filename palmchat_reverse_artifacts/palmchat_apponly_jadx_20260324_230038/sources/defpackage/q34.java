package defpackage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.widget.RemoteViews;
import com.igexin.sdk.PushConsts;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.specialattention.NotificationUpdateInfo;
import com.zenmen.palmchat.chat.specialattention.SpecialAttentionConfig;
import com.zenmen.palmchat.chat.specialattention.UserStatusVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.NotificationClickReceiver;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class q34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f20164a;
    public Handler b;
    public final HashMap<Integer, NotificationUpdateInfo> c = new HashMap<>();
    public NotificationUpdateInfo d = null;
    public long e = 0;
    public final Runnable f = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("NotificationUpdateHelper", "loop run");
            q34.this.r();
            q34.this.n().postDelayed(this, SpecialAttentionConfig.getStatusUpdateInterval());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationUpdateInfo f20167a;
        public final /* synthetic */ boolean b;

        public c(NotificationUpdateInfo notificationUpdateInfo, boolean z) {
            this.f20167a = notificationUpdateInfo;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteViews remoteViews;
            if (this.f20167a != null) {
                LogUtil.i("NotificationUpdateHelper", "updateViewOnReceivedMsg" + az2.c(this.f20167a));
                q34.this.c.put(Integer.valueOf(this.f20167a.type), this.f20167a);
            }
            Notification notificationG = xg5.e().g();
            if (notificationG == null || (remoteViews = notificationG.contentView) == null) {
                return;
            }
            q34.this.t(false, notificationG, remoteViews, this.f20167a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM = q34.this.m();
            if (strM != null) {
                q34.this.d = null;
                q34.this.c.clear();
                q34.this.v(true, strM);
                q34.this.s(strM);
                NotificationUpdateInfo notificationUpdateInfoL = q34.this.l();
                if (notificationUpdateInfoL != null) {
                    xg5.e().p(notificationUpdateInfoL);
                }
            }
        }
    }

    public RemoteViews i(NotificationUpdateInfo notificationUpdateInfo) {
        RemoteViews remoteViews = new RemoteViews(AppContext.getContext().getPackageName(), R.layout.special_attention_notification_view);
        t(true, null, remoteViews, notificationUpdateInfo, true);
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) NotificationClickReceiver.class);
        intent.setAction("cancel_special_attention");
        remoteViews.setOnClickPendingIntent(R.id.close, PendingIntent.getBroadcast(AppContext.getContext(), PushConsts.MIN_FEEDBACK_ACTION, intent, 134217728));
        remoteViews.setOnClickPendingIntent(R.id.root, zg5.a());
        return remoteViews;
    }

    public NotificationUpdateInfo j() {
        return this.d;
    }

    public final Handler k() {
        if (this.b == null) {
            this.b = new Handler(Looper.getMainLooper());
        }
        return this.b;
    }

    public final NotificationUpdateInfo l() {
        NotificationUpdateInfo notificationUpdateInfo;
        NotificationUpdateInfo notificationUpdateInfo2 = this.c.get(1);
        NotificationUpdateInfo notificationUpdateInfo3 = this.c.get(2);
        NotificationUpdateInfo notificationUpdateInfo4 = this.c.get(0);
        if (notificationUpdateInfo2 == null || notificationUpdateInfo3 == null || (notificationUpdateInfo = this.d) == null) {
            if (notificationUpdateInfo2 != null) {
                return notificationUpdateInfo2;
            }
            if (notificationUpdateInfo3 == null) {
                if (notificationUpdateInfo4 != null) {
                    return notificationUpdateInfo4;
                }
                return null;
            }
        } else if (notificationUpdateInfo.type != 1) {
            return notificationUpdateInfo2;
        }
        return notificationUpdateInfo3;
    }

    public final String m() {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayListQ = bo0.r().q();
        if (copyOnWriteArrayListQ.size() > 0) {
            return copyOnWriteArrayListQ.get(0).getUid();
        }
        return null;
    }

    public final Handler n() {
        if (this.f20164a == null) {
            HandlerThread handlerThreadA = lg2.a("WORKING_THREAD_SpecialAttentionManager");
            handlerThreadA.start();
            this.f20164a = new Handler(handlerThreadA.getLooper());
        }
        return this.f20164a;
    }

    public void o() {
        n().post(new e());
    }

    public void p() {
        n().removeCallbacks(this.f);
        n().post(this.f);
    }

    public void q() {
        n().removeCallbacks(this.f);
    }

    public final void r() {
        String strM = m();
        if (strM != null) {
            v(false, strM);
        }
        NotificationUpdateInfo notificationUpdateInfoL = l();
        if (notificationUpdateInfoL != null) {
            w(notificationUpdateInfoL, false);
        }
    }

    public final void s(String str) {
        ThreadChatItem threadChatItemF = nw5.f(str);
        if (threadChatItemF == null || threadChatItemF.unReadCount <= 0) {
            this.c.remove(1);
            return;
        }
        NotificationUpdateInfo notificationUpdateInfo = new NotificationUpdateInfo(str);
        notificationUpdateInfo.type = 1;
        notificationUpdateInfo.unRead = threadChatItemF.unReadCount;
        notificationUpdateInfo.time = threadChatItemF.lastMessageDate;
        notificationUpdateInfo.des = threadChatItemF.lastMsg;
        this.c.put(1, notificationUpdateInfo);
    }

    public void t(boolean z, Notification notification, RemoteViews remoteViews, NotificationUpdateInfo notificationUpdateInfo, boolean z2) {
        if (remoteViews == null || notificationUpdateInfo == null) {
            return;
        }
        LogUtil.i("NotificationUpdateHelper", "updateNotification info" + z + az2.c(notificationUpdateInfo) + " current=" + az2.c(this.d) + z2);
        NotificationUpdateInfo notificationUpdateInfo2 = this.d;
        if (notificationUpdateInfo2 == null || notificationUpdateInfo2.needUpdateUi(notificationUpdateInfo)) {
            if (!z) {
                this.d = notificationUpdateInfo;
            }
            remoteViews.setTextViewText(R.id.app_title, notificationUpdateInfo.getTimeForShow());
            remoteViews.setTextViewText(R.id.update_tv, notificationUpdateInfo.getTitleForShow());
            remoteViews.setTextViewText(R.id.update_sub_tv, notificationUpdateInfo.getDesForShow());
            remoteViews.setImageViewResource(R.id.update_image, R.drawable.ic_launcher);
            remoteViews.setOnClickPendingIntent(R.id.root, zg5.a());
            int i = notificationUpdateInfo.unRead;
            if (i > 0) {
                remoteViews.setTextViewText(R.id.unread, String.valueOf(i));
                remoteViews.setViewVisibility(R.id.unread, 0);
            } else {
                remoteViews.setViewVisibility(R.id.unread, 8);
            }
            if (z) {
                return;
            }
            NotificationManager notificationManager = (NotificationManager) AppContext.getContext().getSystemService("notification");
            String iconUrl = notificationUpdateInfo.getIconUrl();
            if (iconUrl != null) {
                Bitmap bitmapA = sd1.a(iconUrl);
                if (bitmapA != null) {
                    remoteViews.setImageViewBitmap(R.id.update_image, bitmapA);
                } else {
                    gr2.j().k(iconUrl, bq6.s(), new b(remoteViews, notificationManager, notification));
                }
            }
            try {
                notificationManager.notify(PushConsts.MIN_FEEDBACK_ACTION, notification);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void u(int i) {
        this.c.remove(Integer.valueOf(i));
        NotificationUpdateInfo notificationUpdateInfoL = l();
        if (notificationUpdateInfoL != null) {
            w(notificationUpdateInfoL, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v(boolean z, String str) {
        boolean z2;
        T t;
        LogUtil.i("NotificationUpdateHelper", "updateOnlineStatusSync");
        if (Math.abs(this.e - ir5.b()) >= SpecialAttentionConfig.getOnlineStatusInterval() || z) {
            this.e = ir5.b();
            LogUtil.i("NotificationUpdateHelper", "updateOnlineStatusSync inter");
            try {
                t = zw4.k(new d(str)).data;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (t != 0) {
                z2 = ((UserStatusVo) t).onlineStatusCode == 1;
            }
            NotificationUpdateInfo notificationUpdateInfo = new NotificationUpdateInfo(str);
            notificationUpdateInfo.type = 0;
            notificationUpdateInfo.isOnline = z2;
            notificationUpdateInfo.time = ir5.b();
            this.c.put(0, notificationUpdateInfo);
        }
    }

    public void w(NotificationUpdateInfo notificationUpdateInfo, boolean z) {
        k().post(new c(notificationUpdateInfo, z));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoteViews f20166a;
        public final /* synthetic */ NotificationManager b;
        public final /* synthetic */ Notification c;

        public b(RemoteViews remoteViews, NotificationManager notificationManager, Notification notification) {
            this.f20166a = remoteViews;
            this.b = notificationManager;
            this.c = notification;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                this.f20166a.setImageViewBitmap(R.id.update_image, bitmap);
                try {
                    this.b.notify(PushConsts.MIN_FEEDBACK_ACTION, this.c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
    public class d extends go2<LXBaseNetBean<UserStatusVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20168a;

        public d(String str) {
            this.f20168a = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("fuid", this.f20168a);
            return sw4.b(1, nl0.z + "/userem.notice.status.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<UserStatusVo> lXBaseNetBean, Exception exc) {
        }
    }
}
