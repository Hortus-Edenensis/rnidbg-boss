package com.vivo.push.g;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f11243a;
    final /* synthetic */ com.vivo.push.b.q b;
    final /* synthetic */ boolean c;
    final /* synthetic */ u d;

    public v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar, boolean z) {
        this.d = uVar;
        this.f11243a = insideNotificationItem;
        this.b = qVar;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11243a.isNoShowOnForeground()) {
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "msg " + this.f11243a.getMsgId() + " no show on foreground");
            ((aa) this.d).b.onForegroundMessageArrived(com.vivo.push.util.u.a(this.f11243a));
            return;
        }
        if (this.f11243a.isAppInstallCompleteMsg()) {
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "msg " + this.f11243a.getMsgId() + " notify app install");
            ((aa) this.d).b.onAppInstallCompleteShowMsg(this.f11243a.getThirdPackageName());
            return;
        }
        u uVar = this.d;
        NotifyArriveCallbackByUser notifyArriveCallbackByUserOnNotificationMessageArrived = ((aa) uVar).b.onNotificationMessageArrived(((com.vivo.push.s) uVar).f11282a, com.vivo.push.util.u.a(this.f11243a));
        int iA = this.d.a(notifyArriveCallbackByUserOnNotificationMessageArrived);
        if (iA > 0) {
            com.vivo.push.util.f.a(iA, this.d.a(this.b.g()));
            return;
        }
        int iB = this.d.b();
        if (iB > 0) {
            com.vivo.push.util.t.b("OnNotificationArrivedTask", "pkg name : " + ((com.vivo.push.s) this.d).f11282a.getPackageName() + " notify channel switch is " + iB);
            com.vivo.push.util.t.b(((com.vivo.push.s) this.d).f11282a, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(iB)));
            com.vivo.push.util.f.a((long) iB, this.d.a(this.b.g()));
            return;
        }
        if (this.c && this.f11243a.isOperateMsg() && !com.vivo.push.util.ah.a().a(this.f11243a.getWindowPeriod())) {
            com.vivo.push.util.f.a(1017L, this.d.a(this.b.g()));
            com.vivo.push.util.t.b(((com.vivo.push.s) this.d).f11282a, "内部运营消息不在窗口期内，不做展示");
            return;
        }
        Context context = ((com.vivo.push.s) this.d).f11282a;
        InsideNotificationItem insideNotificationItem = this.f11243a;
        long jG = this.b.g();
        u uVar2 = this.d;
        com.vivo.push.util.o oVar = new com.vivo.push.util.o(context, insideNotificationItem, jG, ((aa) uVar2).b.isAllowNet(((com.vivo.push.s) uVar2).f11282a), new w(this), notifyArriveCallbackByUserOnNotificationMessageArrived);
        boolean zIsShowBigPicOnMobileNet = this.f11243a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f11243a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.f11243a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.t.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(zIsShowBigPicOnMobileNet)));
            if (zIsShowBigPicOnMobileNet) {
                com.vivo.push.util.t.a(((com.vivo.push.s) this.d).f11282a, "mobile net show");
            } else {
                com.vivo.push.util.t.a(((com.vivo.push.s) this.d).f11282a, "mobile net unshow");
                NetworkInfo networkInfoA = com.vivo.push.util.w.a(((com.vivo.push.s) this.d).f11282a);
                char c = 0;
                if (networkInfoA != null && networkInfoA.getState() == NetworkInfo.State.CONNECTED) {
                    int type = networkInfoA.getType();
                    c = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                }
                if (c == 1) {
                    this.f11243a.clearCoverUrl();
                    this.f11243a.clearPurePicUrl();
                    purePicUrl = null;
                }
            }
        }
        oVar.execute(this.f11243a.getIconUrl(), purePicUrl);
    }
}
