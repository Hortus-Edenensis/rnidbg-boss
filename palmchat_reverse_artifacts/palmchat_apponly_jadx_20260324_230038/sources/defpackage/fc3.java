package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.maintab.dialog.PopCardConfig;
import com.zenmen.palmchat.maintab.dialog.PopCardItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fc3 extends Observable {
    public static fc3 h = null;
    public static boolean i = false;
    public static boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<xc1> f17503a;
    public Handler b;
    public PopCardConfig c;
    public long d = 0;
    public int e = 0;
    public PopCardItem f = null;
    public BroadcastReceiver g = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("pageIndex");
                if (FrameworkBaseActivity.ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED.equals(action) && "c0000".equals(stringExtra)) {
                    LogUtil.i("MainTabTopViewManager", "notifyReceiveDialogMsg pageIndex = " + stringExtra);
                    fc3.this.k();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == fc3.this.e) {
                fc3.this.j();
                fc3.this.setChanged();
                fc3.this.notifyObservers("SHOW_DELAY");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements yc1 {
        public c() {
        }

        @Override // defpackage.yc1
        public void a(ArrayList<xc1> arrayList) {
            LogUtil.i("MainTabTopViewManager", "getData end size=" + arrayList.size() + " list =" + az2.c(arrayList));
            boolean z = fc3.this.f17503a == null;
            fc3.this.f17503a = arrayList;
            fc3.this.setChanged();
            fc3.this.notifyObservers();
            if (z) {
                LogUtil.i("MainTabTopViewManagerdata", "getData isFirstLoad");
            }
        }
    }

    public fc3() {
        LocalBroadcastManager.getInstance(AppContext.getContext()).registerReceiver(this.g, new IntentFilter(FrameworkBaseActivity.ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED));
        this.b = new b(Looper.getMainLooper());
    }

    public static fc3 l() {
        if (h == null) {
            synchronized (fc3.class) {
                if (h == null) {
                    h = new fc3();
                }
            }
        }
        return h;
    }

    @Override // java.util.Observable
    public void addObserver(Observer observer) {
        super.addObserver(observer);
        if (this.f17503a == null) {
            k();
        }
    }

    public boolean g() {
        boolean z = this.f17503a != null && this.f == null;
        LogUtil.i("MainTabTopViewManagerdata", "canShowTopDialog result" + z);
        return z;
    }

    public final boolean h() {
        boolean z = Math.abs(this.d - ir5.b()) >= ((long) m().coldDownTime) * 1000;
        if (z) {
            this.d = ir5.b();
        }
        LogUtil.i("MainTabTopViewManager", "checkIfCanShow " + z);
        return z;
    }

    public void i() {
        try {
            j();
            this.b.removeMessages(this.e);
            ArrayList<xc1> arrayList = this.f17503a;
            if (arrayList != null && arrayList.size() > 0) {
                this.f17503a.clear();
            }
            this.f17503a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void j() {
        LogUtil.i("MainTabTopViewManager", "disMissCurrentItem");
        if (this.f != null) {
            this.f = null;
            this.d = ir5.b();
        }
    }

    public final void k() {
        LogUtil.i("MainTabTopViewManager", "getData start");
        ad1.h().n("c0000", new c());
    }

    public PopCardConfig m() {
        if (this.c == null) {
            try {
                int iA = vs0.a().a("incomepop_cooltime", 300);
                PopCardConfig popCardConfig = new PopCardConfig();
                this.c = popCardConfig;
                popCardConfig.coldDownTime = iA;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.c == null) {
                this.c = new PopCardConfig();
            }
        }
        if (i) {
            this.c.coldDownTime = 10;
        }
        return this.c;
    }

    public PopCardItem n() {
        PopCardItem popCardItem = this.f;
        if (popCardItem != null) {
            return popCardItem;
        }
        try {
            ArrayList<xc1> arrayList = this.f17503a;
            this.b.removeMessages(this.e);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<xc1> it = arrayList.iterator();
                while (it.hasNext()) {
                    xc1 next = it.next();
                    if (next != null && next.g != null) {
                        JSONObject jSONObject = new JSONObject(next.g);
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("affiche");
                        long jOptLong = jSONObject.optLong("show_time");
                        long jOptLong2 = jSONObjectOptJSONObject.optLong("showTimeSec");
                        if (o(next.e.longValue(), jOptLong, jOptLong2)) {
                            LogUtil.i("MainTabTopViewManager", "isExpired " + az2.c(next));
                            it.remove();
                        } else if (h()) {
                            LogUtil.i("MainTabTopViewManager", "affiche.toString()=" + jSONObjectOptJSONObject.toString());
                            PopCardItem popCardItem2 = (PopCardItem) az2.a(jSONObjectOptJSONObject.toString(), PopCardItem.class);
                            popCardItem2.style = next.f;
                            if (!popCardItem2.needCheckTeenMode || !TeenagersModeManager.a().d()) {
                                if (!i) {
                                    ad1.h().f(next.f21921a);
                                }
                                long jCurrentTimeMillis = (jOptLong2 <= 0 || jOptLong != 0) ? jOptLong2 > 0 ? (jOptLong2 * 1000) - (System.currentTimeMillis() - jOptLong) : 0L : jOptLong2 * 1000;
                                if (jCurrentTimeMillis > 0) {
                                    this.b.sendEmptyMessageDelayed(this.e, jCurrentTimeMillis);
                                }
                                this.f = popCardItem2;
                                it.remove();
                                return popCardItem2;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("MainTabTopViewManager", "getPopCardItem error ", e);
        }
        if (!j || !h()) {
            return null;
        }
        PopCardItem popCardItemGenTestItem = PopCardItem.genTestItem();
        this.f = popCardItemGenTestItem;
        this.b.sendEmptyMessageDelayed(this.e, 20000L);
        return popCardItemGenTestItem;
    }

    public final boolean o(long j2, long j3, long j4) {
        if (System.currentTimeMillis() > j2) {
            return true;
        }
        return j3 > 0 && j4 > 0 && System.currentTimeMillis() - j3 > j4 * 1000;
    }

    public void p(Activity activity) {
        LogUtil.d("MainTabTopViewManager", "onClick");
        j();
        this.b.removeMessages(this.e);
        setChanged();
        notifyObservers();
    }
}
