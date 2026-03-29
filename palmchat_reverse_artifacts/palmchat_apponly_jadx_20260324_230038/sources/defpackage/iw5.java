package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class iw5 extends Observable {
    public static final String e = "iw5";
    public static iw5 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f18276a;
    public ArrayList<xc1> b;
    public ArrayList<xc1> c;
    public BroadcastReceiver d = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("pageIndex");
                if ((FrameworkBaseActivity.ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED.equals(action) && "b0000".equals(stringExtra)) || "b0001".equals(stringExtra)) {
                    LogUtil.i(iw5.e, "notifyReceiveDialogMsg pageIndex = " + stringExtra);
                    iw5.this.j(stringExtra);
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
            int i = message.what;
            if (i == 1) {
                iw5.this.setChanged();
                iw5.this.notifyObservers("b0000");
            } else if (i == 2) {
                iw5.this.setChanged();
                iw5.this.notifyObservers("b0001");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements yc1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18279a;

        public c(String str) {
            this.f18279a = str;
        }

        @Override // defpackage.yc1
        public void a(ArrayList<xc1> arrayList) {
            if (TextUtils.equals(this.f18279a, "b0000")) {
                iw5.this.b = arrayList;
            } else if (TextUtils.equals(this.f18279a, "b0001")) {
                iw5.this.c = arrayList;
            }
            iw5.this.setChanged();
            iw5.this.notifyObservers(this.f18279a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xc1 f18280a;

        public d(xc1 xc1Var) {
            this.f18280a = xc1Var;
            put("style", Integer.valueOf(xc1Var.f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xc1 f18281a;
        public final /* synthetic */ String b;

        public e(xc1 xc1Var, String str) {
            this.f18281a = xc1Var;
            this.b = str;
            put("style", Integer.valueOf(xc1Var.f));
            put("mid", xc1Var.j);
            put(TurnInfo.TYPE_DEEP_LINK, xc1Var.d);
            put("type", 53);
            put("pageIndex", str);
        }
    }

    public iw5() {
        LocalBroadcastManager.getInstance(AppContext.getContext()).registerReceiver(this.d, new IntentFilter(FrameworkBaseActivity.ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED));
        this.f18276a = new b(Looper.getMainLooper());
    }

    public static iw5 m() {
        if (f == null) {
            synchronized (iw5.class) {
                if (f == null) {
                    f = new iw5();
                }
            }
        }
        return f;
    }

    public void h(Observer observer, String str) {
        super.addObserver(observer);
        if (TextUtils.equals(str, "b0000")) {
            if (this.b == null) {
                j(str);
            }
        } else if (TextUtils.equals(str, "b0001") && this.c == null) {
            j(str);
        }
    }

    public void i() {
        try {
            this.f18276a.removeMessages(1);
            this.f18276a.removeMessages(2);
            ArrayList<xc1> arrayList = this.b;
            if (arrayList != null && arrayList.size() > 0) {
                this.b.clear();
                this.b = null;
            }
            ArrayList<xc1> arrayList2 = this.c;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            this.c.clear();
            this.c = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void j(String str) {
        ad1.h().o(str, new c(str));
    }

    public final ArrayList<xc1> k(String str) {
        str.hashCode();
        if (str.equals("b0000")) {
            return this.b;
        }
        if (str.equals("b0001")) {
            return this.c;
        }
        return null;
    }

    public final int l(String str) {
        str.hashCode();
        return !str.equals("b0001") ? 1 : 2;
    }

    public hw5 n(String str) {
        long jCurrentTimeMillis;
        try {
            ArrayList<xc1> arrayListK = k(str);
            this.f18276a.removeMessages(l(str));
            if (arrayListK == null || arrayListK.size() <= 0) {
                return null;
            }
            Iterator<xc1> it = arrayListK.iterator();
            while (it.hasNext()) {
                xc1 next = it.next();
                if (next != null && next.g != null) {
                    if (TextUtils.equals(str, next.b)) {
                        JSONObject jSONObject = new JSONObject(next.g);
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("affiche");
                        long jOptLong = jSONObject.optLong("show_time");
                        long jOptLong2 = jSONObjectOptJSONObject.optLong("showTimeSec");
                        if (!o(next.e.longValue(), jOptLong, jOptLong2)) {
                            hw5 hw5Var = new hw5();
                            hw5Var.o(jSONObjectOptJSONObject.optString("icon"));
                            hw5Var.s(jSONObjectOptJSONObject.optString("title"));
                            hw5Var.l(jSONObjectOptJSONObject.optString("body"));
                            hw5Var.m(jSONObjectOptJSONObject.optString("btnText"));
                            hw5Var.k(jSONObjectOptJSONObject.optString("bannerUrl"));
                            hw5Var.r(next.f);
                            hw5Var.p(next.f21921a);
                            hw5Var.n(next.d);
                            hw5Var.q(next.j);
                            if (jOptLong2 <= 0 || jOptLong != 0) {
                                jCurrentTimeMillis = jOptLong2 > 0 ? (jOptLong2 * 1000) - (System.currentTimeMillis() - jOptLong) : 0L;
                            } else {
                                ad1.h().r(next);
                                jCurrentTimeMillis = jOptLong2 * 1000;
                            }
                            if (jCurrentTimeMillis > 0) {
                                this.f18276a.sendEmptyMessageDelayed(l(str), jCurrentTimeMillis);
                            }
                            return hw5Var;
                        }
                        ad1.h().f(next.f21921a);
                        it.remove();
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean o(long j, long j2, long j3) {
        if (System.currentTimeMillis() > j) {
            return true;
        }
        return j2 > 0 && j3 > 0 && System.currentTimeMillis() - j2 > j3 * 1000;
    }

    public void p(Activity activity, String str) {
        LogUtil.d(e, "onClick");
        ArrayList<xc1> arrayListK = k(str);
        int iL = l(str);
        if (arrayListK == null || arrayListK.size() <= 0) {
            return;
        }
        try {
            xc1 xc1Var = arrayListK.get(0);
            if (!TextUtils.isEmpty(xc1Var.d)) {
                if (mb4.g(xc1Var.d) != null) {
                    ve.s(activity, xc1Var.d, false);
                } else {
                    sy5.e(activity, R.string.connection_not_available, 0).g();
                }
                if (xc1Var.h.booleanValue()) {
                    ad1.h().f(xc1Var.f21921a);
                    arrayListK.remove(xc1Var);
                    this.f18276a.removeMessages(iL);
                    setChanged();
                    notifyObservers(str);
                }
            }
            LogUtil.uploadInfoImmediate("notice_new_click", new d(xc1Var));
            zn6.j("pagemsg_noticenew", "click", new e(xc1Var, str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
