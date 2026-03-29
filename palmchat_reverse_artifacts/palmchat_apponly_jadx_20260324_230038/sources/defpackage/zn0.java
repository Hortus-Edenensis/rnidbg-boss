package defpackage;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zn0 extends Observable {
    public static final String e = "zn0";
    public static zn0 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f22453a;
    public Handler b;
    public en0 c = new en0();
    public int d = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1001) {
                removeMessages(1001);
                zn0.this.j();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            zn0.this.k();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(zn0.e, "显示好友申请：" + zn0.this.c.b().d());
            zn0 zn0Var = zn0.this;
            zn0Var.notifyObservers(zn0Var.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(zn0.e, "显示好友推荐：" + zn0.this.c.b().d());
            zn0 zn0Var = zn0.this;
            zn0Var.notifyObservers(zn0Var.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(zn0.e, "没有可以显示的申请或者推送");
            zn0 zn0Var = zn0.this;
            zn0Var.notifyObservers(zn0Var.c);
        }
    }

    public zn0() {
        HandlerThread handlerThreadA = lg2.a("working_thread_contact_request_table");
        handlerThreadA.start();
        this.f22453a = new a(handlerThreadA.getLooper());
        this.b = new Handler(Looper.getMainLooper());
        l();
    }

    public static zn0 i() {
        if (f == null) {
            synchronized (zn0.class) {
                if (f == null) {
                    f = new zn0();
                }
            }
        }
        return f;
    }

    @Override // java.util.Observable
    public void addObserver(Observer observer) {
        super.addObserver(observer);
        if (this.d == -1) {
            this.f22453a.sendEmptyMessage(1001);
        } else {
            observer.update(this, this.c);
        }
    }

    public boolean e() {
        long jI = SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, k86.a("key_inited_time"), -1L);
        long jC = io0.c();
        LogUtil.d("logcontact", "initedTime=" + jI);
        if (jI < 0 || System.currentTimeMillis() - jI <= 24 * jC * 60 * 60 * 1000) {
            return true;
        }
        LogUtil.d("logcontact", "not show: showDay=" + jC);
        return false;
    }

    public final xh4 f(xh4 xh4Var) {
        if (!TextUtils.isEmpty(xh4Var.b().deleteTime) || !TextUtils.isEmpty(xh4Var.b().operateTime) || bo0.r().w(xh4Var.d()) || tn0.i().u(xh4Var.d())) {
            return null;
        }
        return xh4Var;
    }

    public void g() {
        this.d = -1;
        setChanged();
        this.c.d(0);
    }

    public final xh4 h() {
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "source_type == ? and request_type == ?", new String[]{Integer.toString(21), Integer.toString(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR)}, "send_time DESC");
        ArrayList<xh4> arrayListB = wh4.b(cursorQuery);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (!arrayListB.isEmpty()) {
            xh4 xh4Var = arrayListB.get(0);
            if ((TextUtils.isEmpty(xh4Var.b().expireTime) || Long.parseLong(xh4Var.b().expireTime) > ir5.b()) && TextUtils.isEmpty(xh4Var.b().deleteTime) && TextUtils.isEmpty(xh4Var.b().operateTime) && !bo0.r().w(xh4Var.d())) {
                return xh4Var;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        if (PreferenceManager.getDefaultSharedPreferences(AppContext.getContext()).getLong(k86.q(), 0L) == 0) {
            return;
        }
        this.d = 0;
        if (e()) {
            String[] strArr = {Integer.toString(3), Integer.toString(20), Integer.toString(200), Integer.toString(22), Integer.toString(100)};
            ContentResolver contentResolver = AppContext.getContext().getContentResolver();
            Uri uri = vn0.f21483a;
            Cursor cursorQuery = contentResolver.query(uri, null, "(source_type == ?  or source_type == ?  or source_type == ?  or source_type == ?  ) and request_type < ? ", strArr, "send_time DESC");
            ArrayList<xh4> arrayListB = wh4.b(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            xh4 xh4VarF = null;
            if (!arrayListB.isEmpty()) {
                xh4 xh4Var = arrayListB.get(0);
                xh4 xh4VarH = h();
                if (TextUtils.isEmpty(xh4Var.b().expireTime)) {
                    if (xh4VarH != null) {
                        wh4.j(xh4VarH);
                    }
                    if (wh4.e(xh4Var.a())) {
                        return;
                    }
                    if (!TextUtils.isEmpty(xh4Var.b().deleteTime) || !TextUtils.isEmpty(xh4Var.b().operateTime) || xh4Var.b().acceptStatus == 1 || bo0.r().w(xh4Var.d()) || ContactRequestsVO.isSenderParseFromRid(xh4Var.b().requestRid)) {
                        xh4Var = null;
                    }
                    if (xh4Var == null) {
                        setChanged();
                        String nickName = xh4Var.a().getNickName();
                        String localOrRealName = xh4Var.b().getLocalOrRealName();
                        if (!TextUtils.isEmpty(localOrRealName)) {
                            nickName = nickName + "(" + localOrRealName + ")";
                        }
                        xh4Var.a().setNickName(nickName);
                        this.c.d(1);
                        this.c.e(xh4Var);
                        this.b.post(new c());
                        return;
                    }
                    Cursor cursorQuery2 = AppContext.getContext().getContentResolver().query(uri, null, "request_type == ?", new String[]{Integer.toString(301)}, "");
                    ArrayList<xh4> arrayListB2 = wh4.b(cursorQuery2);
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                    }
                    ArrayList arrayList = new ArrayList();
                    if (!arrayListB2.isEmpty()) {
                        for (xh4 xh4Var2 : arrayListB2) {
                            if (TextUtils.isEmpty(xh4Var2.b().expireTime)) {
                                if (wh4.g(xh4Var2.a())) {
                                    return;
                                } else {
                                    xh4VarF = f(xh4Var2);
                                }
                            } else if (Long.parseLong(xh4Var2.b().expireTime) > ir5.b()) {
                                xh4VarF = f(xh4Var2);
                            }
                            if (xh4VarF == null || bo0.r().w(xh4VarF.d())) {
                                rn0.g(xh4Var2.b().fromUid);
                            } else {
                                arrayList.add(xh4VarF);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        setChanged();
                        this.c.d(2);
                        this.c.e((xh4) arrayList.get(0));
                        this.c.f(arrayList);
                        this.b.post(new d());
                        return;
                    }
                } else {
                    if (Long.parseLong(xh4Var.b().expireTime) > ir5.b() && TextUtils.isEmpty(xh4Var.b().deleteTime) && TextUtils.isEmpty(xh4Var.b().operateTime) && xh4Var.b().acceptStatus != 1 && !bo0.r().w(xh4Var.d()) && !ContactRequestsVO.isSenderParseFromRid(xh4Var.b().requestRid)) {
                        if (xh4VarH != null) {
                            wh4.j(xh4VarH);
                        }
                    }
                    if (xh4Var == null) {
                    }
                }
            }
        }
        setChanged();
        this.c.d(0);
        this.b.post(new e());
    }

    public final void k() {
        this.f22453a.removeMessages(1001);
        this.f22453a.sendEmptyMessageDelayed(1001, 150L);
    }

    public final void l() {
        AppContext.getContext().getContentResolver().registerContentObserver(vn0.f21483a, true, new b(this.f22453a));
        bo0.r().i().j(this);
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        k();
    }
}
