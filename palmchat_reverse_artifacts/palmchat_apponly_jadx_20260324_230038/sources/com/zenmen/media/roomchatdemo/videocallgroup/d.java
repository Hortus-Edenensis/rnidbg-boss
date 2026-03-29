package com.zenmen.media.roomchatdemo.videocallgroup;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.media.common.IPInfo;
import com.zenmen.media.msgevent.MediaClientEvent;
import com.zenmen.media.roomchat.FloatingViewService;
import com.zenmen.media.roomchat.NetworkUtil;
import com.zenmen.media.roomchat.PopUpActivity;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.ZMRoomChatImp;
import com.zenmen.media.roomchat.ZMRtcParseRoomInfo;
import com.zenmen.media.roomchat.a;
import com.zenmen.media.roomchat.b;
import com.zenmen.media.roomchat.permission.PermissionRequestActivity;
import com.zenmen.media.roomchat.permission.PermissionRequestInterface;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupUserAttribute;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bh;
import defpackage.bz4;
import defpackage.ct2;
import defpackage.gi0;
import defpackage.na6;
import defpackage.oa6;
import defpackage.qn1;
import defpackage.qy4;
import defpackage.ty5;
import defpackage.u93;
import defpackage.v4;
import defpackage.w66;
import defpackage.we2;
import defpackage.yf5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d implements b.InterfaceC0935b, a.b {
    public static String w = "VideoCallGroupMgr";
    public static d x;
    public Context b;
    public List<userInfo> h;
    public long o;
    public long p;
    public long[] q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f12007a = null;
    public ZMRoomChatImp c = null;
    public qn1 d = null;
    public bh e = null;
    public MediaClientEvent f = null;
    public MediaClientEvent g = null;
    public boolean i = false;
    public boolean j = false;
    public ZMRtcParseRoomInfo k = null;
    public long l = 0;
    public boolean m = false;
    public String n = "\"tags\":[2002]";
    public Map<Long, Integer> r = new HashMap();
    public ZMRtcParseRoomInfo s = null;
    public boolean t = false;
    public boolean u = true;
    public BroadcastReceiver v = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCallGroupChattingUIActivity.R2(d.this.N());
            d.this.T();
            Log.i(d.w, "VideoCallGroupMgr:UI Instance " + VideoCallGroupChattingUIActivity.w2());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ((intent != null ? intent.getAction() : "").equals(FrameworkBaseActivity.INTENT_ACTION_KICKOUT)) {
                d.this.s0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivityW2 = VideoCallGroupChattingUIActivity.w2();
            int i = message.what;
            if (i == 1) {
                com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_UPDATE_CALLING_DURATION"));
                Message message2 = new Message();
                message2.what = 1;
                sendMessageDelayed(message2, 1000L);
                return;
            }
            switch (i) {
                case 6:
                    if (videoCallGroupChattingUIActivityW2 != null) {
                        videoCallGroupChattingUIActivityW2.n2(R.string.manychats_video_call_group_finish_call);
                    }
                    break;
                case 7:
                    if (videoCallGroupChattingUIActivityW2 == null) {
                        Log.i(d.w, "MESSAGE_INNER_JOIN_ROOM_OK, but UIInstance is null");
                    } else {
                        videoCallGroupChattingUIActivityW2.M2();
                    }
                    break;
                case 8:
                    if (videoCallGroupChattingUIActivityW2 != null) {
                        Log.i(d.w, "Join Room: 2131887317");
                        videoCallGroupChattingUIActivityW2.n2(R.string.manychats_video_call_group_join_meeting_fail);
                    }
                    sendEmptyMessageDelayed(13, 5000L);
                    break;
                case 9:
                    Message message3 = new Message();
                    message3.what = 9;
                    int i2 = message.arg1 + 1;
                    message3.arg1 = i2;
                    if (i2 > 30) {
                        if (videoCallGroupChattingUIActivityW2 != null) {
                            videoCallGroupChattingUIActivityW2.n2(R.string.manychats_video_call_group_timeout_alice);
                        }
                        sendEmptyMessageDelayed(13, 5000L);
                    } else if (videoCallGroupChattingUIActivityW2 != null && videoCallGroupChattingUIActivityW2.A >= 2) {
                        videoCallGroupChattingUIActivityW2.Z2();
                    } else {
                        sendMessageDelayed(message3, 2000L);
                    }
                    break;
                case 10:
                    Message message4 = new Message();
                    message4.what = message.what;
                    int i3 = message.arg1 + 1;
                    message4.arg1 = i3;
                    if (i3 > 33) {
                        if (videoCallGroupChattingUIActivityW2 != null) {
                            videoCallGroupChattingUIActivityW2.r2(R.string.manychats_video_call_group_timeout_bob);
                            na6.f(RTCParameters.l(), d.this.l, d.this.o);
                        }
                        sendEmptyMessageDelayed(13, 5000L);
                        break;
                    } else if (videoCallGroupChattingUIActivityW2 != null && !videoCallGroupChattingUIActivityW2.I2()) {
                        sendMessageDelayed(message4, 2000L);
                        break;
                    }
                    break;
                default:
                    try {
                        switch (i) {
                            case 12:
                                if (!d.this.i) {
                                    ty5.c(d.this.b, RTCParameters.c().getString(R.string.manychats_video_call_group_timeout_server_connect), 1).show();
                                    if (videoCallGroupChattingUIActivityW2 != null) {
                                        videoCallGroupChattingUIActivityW2.finish();
                                    }
                                }
                                break;
                            case 13:
                                Log.i(d.w, "自动回收资源！");
                                d.this.x();
                                break;
                            case 14:
                                ty5.c(d.this.b, (String) message.obj, 1).show();
                                break;
                            case 15:
                                if (message.arg1 == 1 && RTCParameters.c() != null) {
                                    RTCParameters.c().startService(new Intent(RTCParameters.c(), (Class<?>) FloatingViewService.class));
                                    break;
                                }
                                break;
                            case 16:
                            case 17:
                                if (RTCParameters.c() != null) {
                                    RTCParameters.c().stopService(new Intent(RTCParameters.c(), (Class<?>) FloatingViewService.class));
                                    break;
                                }
                                break;
                            case 18:
                            case 29:
                                if (RTCParameters.c() != null) {
                                    Log.i(d.w, "Receive message: resume calling UI");
                                    Intent intent = new Intent(RTCParameters.c(), (Class<?>) VideoCallGroupChattingUIActivity.class);
                                    intent.addFlags(268435456);
                                    try {
                                        PendingIntent.getActivity(RTCParameters.c(), 0, intent, 0).send();
                                    } catch (PendingIntent.CanceledException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                    break;
                                }
                                break;
                            case 19:
                                Message message5 = new Message();
                                message5.what = 19;
                                if (d.this.m) {
                                    message5.arg1 = 0;
                                    if (videoCallGroupChattingUIActivityW2 != null) {
                                        videoCallGroupChattingUIActivityW2.X2(false);
                                    }
                                } else {
                                    message5.arg1 = message.arg1 + 1;
                                }
                                int i4 = message5.arg1;
                                if (i4 != 10) {
                                    if (i4 > 30) {
                                        if (videoCallGroupChattingUIActivityW2 != null) {
                                            videoCallGroupChattingUIActivityW2.n2(R.string.manychats_video_call_group_timeout_server_keeplive);
                                        }
                                        ty5.c(d.this.b, RTCParameters.c().getString(R.string.manychats_video_call_group_timeout_server_keeplive), 1).show();
                                        sendEmptyMessageDelayed(13, 5000L);
                                    }
                                } else if (videoCallGroupChattingUIActivityW2 != null) {
                                    videoCallGroupChattingUIActivityW2.X2(true);
                                }
                                sendMessageDelayed(message5, 2000L);
                                d.this.m = false;
                                break;
                            case 20:
                                if (VideoCallGroupChattingUIActivity.w2() != null) {
                                    VideoCallGroupChattingUIActivity.w2().k3(d.this.k);
                                }
                                break;
                            case 21:
                                if (RTCParameters.MY_NAME.values()[message.arg1] == RTCParameters.MY_NAME.I_AM_ALICE) {
                                    d.this.n();
                                } else if (RTCParameters.MY_NAME.values()[message.arg1] == RTCParameters.MY_NAME.I_AM_CHARLIE) {
                                    d.this.K();
                                }
                                break;
                            case 22:
                                Object obj = message.obj;
                                if (obj != null) {
                                    d.this.o((List) obj);
                                }
                                break;
                            case 23:
                                try {
                                    w66.b().d();
                                    d.this.e0(PermissionRequestInterface.RequestType.FloatView);
                                    d.this.R();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                                break;
                            case 24:
                                if (RTCParameters.c() != null) {
                                    ty5.b(RTCParameters.c(), R.string.manychats_video_call_group_network_disconnect, 1).show();
                                }
                                break;
                            case 25:
                                RTCParameters.f().f();
                                sendEmptyMessage(1);
                                break;
                            case 26:
                                if (((Integer) d.this.r.get(Long.valueOf(d.this.s.transid))).intValue() != 1 && VideoCallGroupChattingUIActivity.w2() == null) {
                                    if (d.this.i) {
                                        oa6.k(0);
                                        d dVar = d.this;
                                        dVar.t(dVar.s);
                                    }
                                    if (message.arg1 <= 10 && !d.this.t) {
                                        Message message6 = new Message();
                                        message6.what = 26;
                                        message6.arg1 = message.arg1 + 1;
                                        sendMessageDelayed(message6, 5000L);
                                    } else {
                                        d.this.x();
                                    }
                                }
                                break;
                            case 27:
                                if (RTCParameters.c() != null) {
                                    ty5.b(RTCParameters.c(), R.string.manychats_charlie_join_meeting_fail, 1).show();
                                }
                                if (VideoCallGroupChattingUIActivity.w2() != null) {
                                    VideoCallGroupChattingUIActivity.w2().K2();
                                }
                                d.this.x();
                                break;
                            case 28:
                                if (RTCParameters.c() != null) {
                                    ty5.b(RTCParameters.c(), R.string.manychats_bob_accept_fail, 1).show();
                                }
                                if (VideoCallGroupChattingUIActivity.w2() != null) {
                                    VideoCallGroupChattingUIActivity.w2().K2();
                                }
                                d.this.x();
                                break;
                        }
                    } catch (Exception unused) {
                        return;
                    }
                    break;
            }
        }
    }

    public d() {
        this.b = null;
        this.h = null;
        this.h = new ArrayList();
        AppContext context = AppContext.getContext();
        this.b = context;
        RTCParameters.o(context);
        try {
            RTCParameters.u(Long.valueOf(v4.e(this.b)).longValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        VideoCallGroupChattingUIActivity.W2(-1L);
        u93.c(new a());
    }

    public static d P() {
        try {
            if (x == null) {
                synchronized (d.class) {
                    if (x == null) {
                        x = new d();
                    }
                }
            }
        } catch (Exception e) {
            Log.e(w, "init error=", e);
        }
        return x;
    }

    public void A(long j) {
        this.j = true;
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.j(j);
        }
    }

    public void B(long j, long j2, long j3, boolean z) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.a(j, j2, j3, z);
        }
    }

    public void C(long j, long j2) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.k(j, j2);
        }
    }

    public void D() {
        try {
            if (this.i) {
                return;
            }
            this.i = false;
            this.c.l();
            N().sendEmptyMessageDelayed(12, 5000L);
            N().removeMessages(19);
            N().sendEmptyMessageDelayed(19, 2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void E(boolean z) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.n(z);
        }
    }

    public void F(long j) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.q(j);
        }
    }

    public void G(String str) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.u(str);
        }
    }

    public void H(long j) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.x(j);
        }
    }

    public void I() {
        try {
            this.i = false;
            ZMRoomChatImp zMRoomChatImp = this.c;
            if (zMRoomChatImp != null) {
                zMRoomChatImp.y();
            }
            N().removeMessages(12);
            N().removeMessages(19);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void J(int i, long j, long j2, long j3, List<String> list) {
        boolean z;
        if (we2.c(j3, RTCParameters.l()) && M(R.string.manychats_charlie_join_meeting_fail) && list != null) {
            if (list.size() >= RTCParameters.k.f11966a) {
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().equals(Long.toString(RTCParameters.l()))) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    ty5.c(RTCParameters.c(), RTCParameters.c().getString(R.string.manychats_max_invited_warning, Integer.valueOf(RTCParameters.k.f11966a)), 1).show();
                    return;
                }
            }
            if (!com.zenmen.palmchat.videocall.c.f() && X(i)) {
                this.j = true;
                r0();
                this.l = j3;
                this.o = j;
                this.p = j2;
                L(list);
            }
        }
    }

    public void K() {
        N().sendEmptyMessageDelayed(12, 5000L);
        N().removeMessages(19);
        N().sendEmptyMessageDelayed(19, 2000L);
        VideoCallGroupChattingUIActivity.W2(this.o);
        B(this.o, this.p, this.l, true);
        Message message = new Message();
        message.what = 27;
        message.arg1 = 1;
        N().sendMessageDelayed(message, 5000L);
    }

    public final void L(List<String> list) {
        if (list != null && list.size() > 0) {
            if (VideoCallGroupChattingUIActivity.w2() != null) {
                Log.i(w, "Charlie existed");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                VideoCallGroupUserAttribute videoCallGroupUserAttribute = new VideoCallGroupUserAttribute();
                videoCallGroupUserAttribute.status = VideoCallGroupUserAttribute.a.connecting;
                long j = Long.parseLong(list.get(i));
                videoCallGroupUserAttribute.userId = j;
                videoCallGroupUserAttribute.iconId = ct2.f(j);
                videoCallGroupUserAttribute.iconUrl = ct2.g(videoCallGroupUserAttribute.userId);
                videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.others;
                if (videoCallGroupUserAttribute.userId == RTCParameters.l()) {
                    videoCallGroupUserAttribute.status = VideoCallGroupUserAttribute.a.connected;
                    videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.myself;
                }
                arrayList.add(videoCallGroupUserAttribute);
            }
            Intent intent = new Intent(this.b, (Class<?>) VideoCallGroupChattingUIActivity.class);
            VideoCallGroupChattingUIActivity.U2(RTCParameters.MY_NAME.I_AM_CHARLIE);
            VideoCallGroupChattingUIActivity.Q2(arrayList);
            intent.putExtra("REQUEST_PERMISSION_ENUM_TYPE", PermissionRequestInterface.RequestType.Record_Audio);
            intent.addFlags(268435456);
            this.b.startActivity(intent);
        }
    }

    public boolean M(int i) {
        if (!NetworkUtil.a()) {
            if (i != 0) {
                ty5.b(RTCParameters.c(), i, 1).show();
            }
            this.u = false;
        }
        return this.u;
    }

    public c N() {
        if (this.f12007a == null) {
            this.f12007a = new c();
        }
        return this.f12007a;
    }

    public long O() {
        return this.l;
    }

    public List<userInfo> Q() {
        return this.h;
    }

    public final void R() {
        try {
            if (!((ActivityManager) RTCParameters.c().getSystemService("activity")).getRunningTasks(2).get(1).topActivity.getPackageName().contains(RTCParameters.c().getPackageName())) {
                if (((ActivityManager) RTCParameters.c().getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName().contains(RTCParameters.c().getPackageName())) {
                    return;
                }
                Intent intent = new Intent();
                if (RTCParameters.m()) {
                    intent.setData(Uri.parse("zenmenim://activity/init"));
                } else {
                    intent.setData(Uri.parse("zenxin://activity/init"));
                }
                intent.putExtra("", "");
                intent.setFlags(268435456);
                RTCParameters.c().startActivity(intent);
                return;
            }
            Log.i(w, "gobacktoMainApp at " + RTCParameters.c().getPackageName());
            if (VideoCallGroupChattingUIActivity.w2() != null) {
                VideoCallGroupChattingUIActivity.w2().moveTaskToBack(true);
                return;
            }
            if (((ActivityManager) RTCParameters.c().getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName().contains(RTCParameters.c().getPackageName())) {
                return;
            }
            Intent intent2 = new Intent();
            if (RTCParameters.m()) {
                intent2.setData(Uri.parse("zenmenim://activity/init"));
            } else {
                intent2.setData(Uri.parse("zenxin://activity/init"));
            }
            intent2.putExtra("", "");
            intent2.setFlags(268435456);
            RTCParameters.c().startActivity(intent2);
        } catch (Exception unused) {
        }
    }

    public void S() {
        if (a0("hasAMeetinginGroup")) {
            N().sendEmptyMessage(29);
        } else {
            ty5.b(RTCParameters.c(), R.string.string_group_video_chat_has_another_meeting, 0).show();
        }
    }

    public final void T() {
        qn1 qn1VarA = qn1.a();
        this.d = qn1VarA;
        qn1VarA.b(this.b);
        qn1.c(this);
        bh bhVar = new bh();
        this.e = bhVar;
        bhVar.b(this.d);
        MediaClientEvent newInstance = MediaClientEvent.getNewInstance();
        this.f = newInstance;
        newInstance.registerNotifyEventListener("2", this.d);
        MediaClientEvent mediaClientEvent = MediaClientEvent.getInstance();
        this.g = mediaClientEvent;
        mediaClientEvent.registerNotifyEventListener("2", this.d);
        com.zenmen.media.roomchat.b.e(RTCParameters.c());
        com.zenmen.media.roomchat.b.d(this);
        com.zenmen.media.roomchat.a.d(this);
    }

    public void U(long j, Context context) {
        Log.i(w, "initMgr" + this.c);
        this.b = context;
        c0();
        RTCParameters.o(context);
        RTCParameters.u(j);
        if (this.c != null) {
            return;
        }
        T();
        V();
        if (this.c != null) {
            IPInfo iPInfoE = RTCParameters.e(IPInfo.IP_Type.Notify);
            this.c.v(iPInfoE.a(), iPInfoE.b());
            IPInfo iPInfoE2 = RTCParameters.e(IPInfo.IP_Type.Cmd);
            this.c.t(iPInfoE2.a(), iPInfoE2.b());
        }
        o0();
    }

    public final void V() {
        if (this.c != null) {
            return;
        }
        try {
            this.i = false;
            this.c = null;
            ZMRoomChatImp zMRoomChatImpB = qy4.b();
            this.c = zMRoomChatImpB;
            zMRoomChatImpB.h(RTCParameters.l(), RTCParameters.a(), this.f);
            String strG = RTCParameters.g();
            Log.i(w, "netarea:" + strG);
            G(strG);
        } catch (Exception e) {
            Log.i(w, "initSDK error:");
            e.printStackTrace();
        }
        Log.i(w, "initSDK");
    }

    public final boolean W(long j, long j2) {
        Iterator<Map.Entry<Long, Integer>> it = this.r.entrySet().iterator();
        while (it.hasNext()) {
            if (j == it.next().getKey().longValue()) {
                LogUtil.i(w, "Same transId(" + j + "), roomId(" + j2 + ") skipped.");
                Log.i(w, "Same transId(" + j + "), roomId(" + j2 + ") skipped.");
                return true;
            }
        }
        if (this.r.size() > 200) {
            this.r.remove(0);
        }
        this.r.put(Long.valueOf(j), 0);
        return false;
    }

    public final boolean X(int i) {
        if (i == 0 || this.n.contains(String.valueOf(i))) {
            return true;
        }
        ty5.b(RTCParameters.c(), R.string.video_call_dialog_low_tag_for_manychatgs, 0).show();
        return false;
    }

    public final boolean Y(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean Z(String str) {
        try {
            return !gi0.a().d(Long.parseLong(str));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.zenmen.media.roomchat.b.InterfaceC0935b
    public void a() {
        Log.i(w, "onNetDisconnected");
        this.u = false;
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.p();
        }
        if (this.j) {
            M(R.string.manychats_video_call_group_network_disconnect);
        }
    }

    public boolean a0(String str) {
        bz4.a(w, str + " UI Activity Instance " + VideoCallGroupChattingUIActivity.w2() + " callling-" + this.j);
        return this.j;
    }

    @Override // com.zenmen.media.roomchat.b.InterfaceC0935b
    public void b(NetworkUtil.NetworkType networkType) {
        Log.i(w, "onNetConnected");
        this.u = true;
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.o();
        }
        o0();
    }

    public void b0(String str) {
        try {
            N().removeMessages(27);
            if (new ZMRtcParseRoomInfo(str).mRetCode == 0) {
                N().sendEmptyMessageDelayed(7, 500L);
            } else {
                N().sendEmptyMessageDelayed(8, 2000L);
                gi0.a().b(str);
            }
        } catch (Exception unused) {
        }
    }

    public void c0() {
        LocalBroadcastManager.getInstance(RTCParameters.c()).registerReceiver(this.v, new IntentFilter(FrameworkBaseActivity.INTENT_ACTION_KICKOUT));
    }

    public boolean d0(int i, long j) {
        if (!com.zenmen.palmchat.videocall.c.i()) {
            return false;
        }
        try {
            this.i = false;
            D();
            Thread.sleep(1000L);
            u(i, j);
            Thread.sleep(500L);
            I();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public void e0(PermissionRequestInterface.RequestType requestType) {
        if (requestType == PermissionRequestInterface.RequestType.FloatView) {
            try {
                if (VideoCallGroupChattingUIActivity.w2() == null) {
                    return;
                }
                if (VideoCallGroupChattingUIActivity.w2().t0) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        Intent intent = new Intent(this.b, (Class<?>) PermissionRequestActivity.class);
        intent.putExtra("REQUEST_PERMISSION_ENUM_TYPE", requestType);
        intent.putExtra("REQUEST_PERMISSION_ONLY", 1);
        intent.addFlags(268435456);
        this.b.startActivity(intent);
    }

    public void f0(int i) {
        if (i != 1) {
            try {
                N().sendEmptyMessageDelayed(28, 2000L);
            } catch (Exception unused) {
            }
        }
    }

    public void g0(String str) {
        if (str != null && str.contains("\"msgType\":0") && str.contains(String.valueOf(RTCParameters.l()))) {
            o0();
        }
    }

    public synchronized void h0(boolean z) {
        try {
            this.i = z;
        } catch (Exception unused) {
        }
    }

    public void i0(int i) {
        if (VideoCallGroupChattingUIActivity.w2() != null) {
            VideoCallGroupChattingUIActivity.w2().L2(i);
        }
    }

    public synchronized void j0() {
        this.t = true;
    }

    @Override // com.zenmen.media.roomchat.a.b
    public void k0(Intent intent) {
        String action = intent.getAction();
        if (action.equals("INTENT_ACTION_FLOATVIEW_CLICK")) {
            N().sendEmptyMessage(18);
            return;
        }
        if (action.equals("INTENT_ACTION_GROUPLOAD_FINISH")) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < ct2.j().size(); i++) {
                arrayList.add(Long.valueOf(ct2.j().get(i).id));
            }
            P().t0(arrayList);
            if (VideoCallGroupSelectionActivity.R1() != null) {
                VideoCallGroupSelectionActivity.R1().a2(null);
                return;
            } else {
                if (VideoCallGroupChattingUIActivity.w2() != null) {
                    VideoCallGroupChattingUIActivity.w2().G0.sendEmptyMessage(0);
                    return;
                }
                return;
            }
        }
        if (action.equals("INTENT_ACTION_GROUPLOAD_MEMBER_INACTIVE")) {
            if (VideoCallGroupChattingUIActivity.w2() != null) {
                VideoCallGroupChattingUIActivity.w2().n2(R.string.manychats_video_call_group_leave_group);
            }
        } else if (action.equals("INTENT_ACTION_USER_LIST_FOR_SELECTION_UPDATE")) {
            if (VideoCallGroupSelectionActivity.R1() != null) {
                VideoCallGroupSelectionActivity.R1().O1();
            }
        } else {
            if (!action.equals("INTENT_ACTION_CALL_FINISH") || VideoCallGroupSelectionActivity.R1() == null) {
                return;
            }
            VideoCallGroupSelectionActivity.R1().finish();
        }
    }

    public void l0(String str) {
        try {
            ZMRtcParseRoomInfo zMRtcParseRoomInfo = new ZMRtcParseRoomInfo(str);
            int i = zMRtcParseRoomInfo.mCmd;
            if (i == 116) {
                LogUtil.i(w, "116 comming:" + str);
                return;
            }
            if (i == 117) {
                LogUtil.i(w, "117 comming:" + str);
                return;
            }
            if (i == 123) {
                LogUtil.i(w, "123 comming:" + str);
                return;
            }
            LogUtil.i(w, "更新用户列表:");
            synchronized (P()) {
                for (int i2 = 0; i2 < zMRtcParseRoomInfo.mUserList.size(); i2++) {
                    ZMRtcParseRoomInfo.UserItem userItem = zMRtcParseRoomInfo.mUserList.get(i2);
                    LogUtil.i(w, i2 + ":" + userItem.mUserID + ", status:" + userItem.mUserStatus);
                }
                this.k = zMRtcParseRoomInfo;
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivityW2 = VideoCallGroupChattingUIActivity.w2();
                if (videoCallGroupChattingUIActivityW2 != null) {
                    videoCallGroupChattingUIActivityW2.k3(zMRtcParseRoomInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m0() {
        try {
            if (VideoCallGroupChattingUIActivity.w2() != null) {
                VideoCallGroupChattingUIActivity.w2().K2();
                VideoCallGroupChattingUIActivity.w2().E0 = true;
            }
            long jB = RTCParameters.f().b();
            if (jB < 0) {
                jB = RTCParameters.f().a();
            }
            long j = jB;
            if (VideoCallGroupChattingUIActivity.L0 == RTCParameters.MY_NAME.I_AM_BOB && this.j) {
                na6.f(RTCParameters.l(), this.l, this.o);
            } else {
                na6.p(RTCParameters.l(), this.l, this.o, j);
            }
            x();
        } catch (Exception unused) {
        }
    }

    public void n() {
        long[] jArr = this.q;
        if (jArr == null) {
            return;
        }
        if (jArr.length > 0 || this.l > 0) {
            D();
            VideoCallGroupChattingUIActivity.W2(0L);
            if (w(this.l, this.q, 0) != 0) {
                VideoCallGroupChattingUIActivity.w2().n2(R.string.manychats_video_call_group_create_room_error);
                ty5.b(RTCParameters.c(), R.string.manychats_video_call_group_create_room_error, 1).show();
            } else {
                Message message = new Message();
                message.what = 9;
                message.arg1 = 1;
                N().sendMessageDelayed(message, 2000L);
            }
        }
    }

    public final void n0() {
        Intent intent = new Intent(this.b, (Class<?>) VideoCallGroupSelectionActivity.class);
        ArrayList arrayList = new ArrayList();
        userInfo userinfo = new userInfo();
        long jL = RTCParameters.l();
        userinfo.id = jL;
        userinfo.icon = ct2.f(jL);
        userinfo.name = ct2.h(userinfo.id);
        arrayList.add(userinfo);
        intent.putExtra("USER_LIST_FOR_SELECTION", arrayList);
        intent.putExtra("REQUEST_PERMISSION_ENUM_TYPE", PermissionRequestInterface.RequestType.Record_Audio);
        intent.addFlags(268435456);
        this.b.startActivity(intent);
        na6.a(userinfo.id, this.l);
    }

    public final void o(List<Long> list) {
        synchronized (this) {
            if (list == null) {
                return;
            }
            if (a0("aliceOpenActivity")) {
                return;
            }
            if (list.size() <= 0) {
                return;
            }
            r0();
            this.j = true;
            this.q = new long[list.size() - 1];
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                VideoCallGroupUserAttribute videoCallGroupUserAttribute = new VideoCallGroupUserAttribute();
                videoCallGroupUserAttribute.status = VideoCallGroupUserAttribute.a.connecting;
                long jLongValue = list.get(i2).longValue();
                videoCallGroupUserAttribute.userId = jLongValue;
                videoCallGroupUserAttribute.iconId = ct2.f(jLongValue);
                videoCallGroupUserAttribute.iconUrl = ct2.g(videoCallGroupUserAttribute.userId);
                videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.others;
                if (videoCallGroupUserAttribute.userId == RTCParameters.l()) {
                    videoCallGroupUserAttribute.status = VideoCallGroupUserAttribute.a.connected;
                    videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.myself;
                } else {
                    this.q[i] = videoCallGroupUserAttribute.userId;
                    i++;
                }
                arrayList.add(videoCallGroupUserAttribute);
            }
            Intent intent = new Intent(this.b, (Class<?>) VideoCallGroupChattingUIActivity.class);
            VideoCallGroupChattingUIActivity.U2(RTCParameters.MY_NAME.I_AM_ALICE);
            VideoCallGroupChattingUIActivity.Q2(arrayList);
            intent.putExtra("REQUEST_PERMISSION_ENUM_TYPE", PermissionRequestInterface.RequestType.Record_Audio);
            intent.addFlags(268435456);
            this.b.startActivity(intent);
            RTCParameters.f().e();
            na6.c(RTCParameters.l(), this.l, this.q);
        }
    }

    public final void o0() {
        G(RTCParameters.g());
        if (yf5.A() != null) {
            yf5.A().G();
            return;
        }
        int i = 1;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            try {
                ZMRoomChatImp zMRoomChatImp = this.c;
                if (zMRoomChatImp != null) {
                    zMRoomChatImp.z();
                    this.c.m();
                }
                Thread.sleep(1000L);
                i = i2;
            } catch (Exception unused) {
                return;
            }
        }
    }

    public void p(long j) {
        if (!we2.c(j, RTCParameters.l()) || com.zenmen.palmchat.videocall.c.f() || RTCParameters.c() == null) {
            return;
        }
        Intent intent = new Intent(RTCParameters.c(), (Class<?>) PopUpActivity.class);
        intent.putExtra(PopUpActivity.f11961a, PopUpActivity.c);
        intent.addFlags(268435456);
        RTCParameters.c().startActivity(intent);
        if (M(0)) {
            this.l = j;
            n0();
        }
    }

    public void p0(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(ct2.h(Long.valueOf(str).longValue()));
        sb.append(i == 0 ? "拒绝" : i == 3 ? "忙" : "未知");
        String string = sb.toString();
        Log.i(w, "119 refuseCallNotify " + string);
        try {
            Message message = new Message();
            message.what = 14;
            message.arg1 = i;
            message.obj = RTCParameters.c().getResources().getString(R.string.manychats_busy_refuse, ct2.h(Long.valueOf(str).longValue()));
            N().sendMessageDelayed(message, 1000L);
        } catch (Exception unused) {
        }
    }

    public void q(String str) {
        if (Y(str)) {
            Log.i(w, "anotherMeetingComing");
            ZMRtcParseRoomInfo zMRtcParseRoomInfo = new ZMRtcParseRoomInfo(str);
            ZMRoomChatImp zMRoomChatImp = this.c;
            if (zMRoomChatImp != null) {
                zMRoomChatImp.b(zMRtcParseRoomInfo.mSessionId, zMRtcParseRoomInfo.mRoomid);
                if (W(zMRtcParseRoomInfo.transid, zMRtcParseRoomInfo.mRoomid)) {
                    return;
                }
                na6.g(RTCParameters.l(), zMRtcParseRoomInfo);
                na6.l(RTCParameters.l(), zMRtcParseRoomInfo, 1);
            }
        }
    }

    public void q0() {
        try {
            VideoCallGroupChattingUIActivity.W2(-1L);
            N().removeMessages(1);
            N().removeMessages(9);
            N().removeMessages(10);
            N().removeMessages(11);
            N().removeMessages(12);
            N().removeMessages(13);
            N().removeMessages(19);
            N().removeMessages(27);
        } catch (Exception unused) {
        }
    }

    public void r(String str) {
        synchronized (this) {
            if (Y(str)) {
                Log.i(w, "bobHasAMeeting");
                ZMRtcParseRoomInfo zMRtcParseRoomInfo = new ZMRtcParseRoomInfo(str);
                if (oa6.l() == 3) {
                    na6.m(RTCParameters.l(), zMRtcParseRoomInfo.mGroupId, zMRtcParseRoomInfo.mRoomid);
                }
                if (oa6.i()) {
                    long jX2 = VideoCallGroupChattingUIActivity.x2();
                    LogUtil.i(w, "接到群聊呼叫...1 ID：" + zMRtcParseRoomInfo.mCmd + "," + zMRtcParseRoomInfo.mRoomid + "," + zMRtcParseRoomInfo.mRoomkey + " ," + zMRtcParseRoomInfo.mGroupId + " ," + jX2);
                    if (W(zMRtcParseRoomInfo.transid, zMRtcParseRoomInfo.mRoomid)) {
                        x();
                        return;
                    }
                    if (!X(zMRtcParseRoomInfo.mTag)) {
                        x();
                        return;
                    }
                    this.s = zMRtcParseRoomInfo;
                    RTCParameters.f().e();
                    na6.g(RTCParameters.l(), zMRtcParseRoomInfo);
                    if (d0(zMRtcParseRoomInfo.mSessionId, zMRtcParseRoomInfo.mRoomid)) {
                        na6.l(RTCParameters.l(), zMRtcParseRoomInfo, 2);
                        return;
                    }
                    ZMRtcParseRoomInfo zMRtcParseRoomInfo2 = this.s;
                    long j = zMRtcParseRoomInfo2.mRoomid;
                    if (j == jX2) {
                        return;
                    }
                    if (j != jX2 && jX2 != -1) {
                        ZMRoomChatImp zMRoomChatImp = this.c;
                        if (zMRoomChatImp != null) {
                            zMRoomChatImp.b(zMRtcParseRoomInfo2.mSessionId, j);
                        }
                        na6.l(RTCParameters.l(), zMRtcParseRoomInfo, 1);
                        return;
                    }
                    LogUtil.i(w, "接到群聊呼叫...2 ID：" + this.s.mCmd + "," + this.s.mRoomid + "," + this.s.mRoomkey + " ," + this.s.mGroupId + " ," + jX2);
                    if (VideoCallGroupSelectionActivity.R1() != null) {
                        VideoCallGroupSelectionActivity.R1().finish();
                    }
                    this.j = true;
                    ZMRtcParseRoomInfo zMRtcParseRoomInfo3 = this.s;
                    this.l = zMRtcParseRoomInfo3.mGroupId;
                    long j2 = zMRtcParseRoomInfo3.mRoomid;
                    this.o = j2;
                    VideoCallGroupChattingUIActivity.W2(j2);
                    this.t = false;
                    s();
                    Message message = new Message();
                    message.what = 26;
                    message.arg1 = 0;
                    N().sendMessageDelayed(message, 0L);
                }
            }
        }
    }

    public final void r0() {
        this.k = null;
        q0();
    }

    public void s() {
        this.i = false;
        D();
        Message message = new Message();
        message.what = 10;
        message.arg1 = 1;
        N().sendMessageDelayed(message, 2000L);
    }

    public void s0() {
        Log.i(w, "uninitMgr");
        try {
            VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivityW2 = VideoCallGroupChattingUIActivity.w2();
            if (videoCallGroupChattingUIActivityW2 != null) {
                videoCallGroupChattingUIActivityW2.m2(R.string.manychats_video_call_group_finish_call);
                Thread.sleep(1000L);
            }
        } catch (Exception unused) {
        }
        try {
            x();
            qy4.a();
            this.c = null;
            com.zenmen.media.roomchat.b.g(RTCParameters.c());
            com.zenmen.media.roomchat.b.f(this);
            com.zenmen.media.roomchat.a.f(this);
            LocalBroadcastManager.getInstance(RTCParameters.c()).unregisterReceiver(this.v);
        } catch (Exception unused2) {
        }
    }

    public final void t(ZMRtcParseRoomInfo zMRtcParseRoomInfo) {
        Intent intent = new Intent(this.b, (Class<?>) VideoCallGroupChattingUIActivity.class);
        VideoCallGroupChattingUIActivity.U2(RTCParameters.MY_NAME.I_AM_BOB);
        VideoCallGroupChattingUIActivity.V2(zMRtcParseRoomInfo);
        intent.putExtra("REQUEST_PERMISSION_ENUM_TYPE", PermissionRequestInterface.RequestType.Record_Audio);
        intent.addFlags(268435456);
        this.b.startActivity(intent);
    }

    public void t0(List<Long> list) {
        this.h.clear();
        for (int i = 0; i < list.size(); i++) {
            long jLongValue = list.get(i).longValue();
            userInfo userinfo = new userInfo();
            userinfo.icon = ct2.f(jLongValue);
            userinfo.iconurl = ct2.g(jLongValue);
            userinfo.id = jLongValue;
            userinfo.name = ct2.h(jLongValue);
            if (RTCParameters.l() == jLongValue) {
                userinfo.selected = true;
            } else {
                userinfo.selected = false;
            }
            this.h.add(userinfo);
        }
    }

    public void u(int i, long j) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.b(i, j);
        }
    }

    public void u0(String str) {
        try {
            LogUtil.i(w, "updateRoomID " + str);
            ZMRtcParseRoomInfo zMRtcParseRoomInfo = new ZMRtcParseRoomInfo(str);
            if (zMRtcParseRoomInfo.mRetCode == 0) {
                long j = zMRtcParseRoomInfo.mRoomid;
                this.o = j;
                VideoCallGroupChattingUIActivity.W2(j);
            } else {
                VideoCallGroupChattingUIActivity.w2().n2(R.string.manychats_video_call_group_create_room_error);
                ty5.b(RTCParameters.c(), R.string.manychats_video_call_group_create_room_error, 1).show();
            }
        } catch (Exception unused) {
        }
    }

    public void v(boolean z) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.c(z);
        }
    }

    public void v0(String str, int i) {
        try {
            VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivityW2 = VideoCallGroupChattingUIActivity.w2();
            long jLongValue = Long.valueOf(str).longValue();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            videoCallGroupChattingUIActivityW2.l3(jLongValue, z);
        } catch (Exception unused) {
        }
    }

    public int w(long j, long[] jArr, int i) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            return zMRoomChatImp.d(j, jArr, i);
        }
        return 1;
    }

    public void w0(String str) {
        try {
            if (new ZMRtcParseRoomInfo(str).mRetCode == 0) {
                this.m = true;
            }
        } catch (Exception unused) {
        }
    }

    public void x() {
        Log.i(w, "callFinish");
        try {
            this.r.put(Long.valueOf(this.s.transid), 1);
        } catch (Exception unused) {
        }
        RTCParameters.f().d();
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.j = false;
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.f();
        }
        I();
        r0();
        VideoCallGroupChattingUIActivity.W2(-1L);
        R();
    }

    public void y(String str) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.g(str);
        }
    }

    public void z(long[] jArr) {
        ZMRoomChatImp zMRoomChatImp = this.c;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.i(jArr);
            na6.n(RTCParameters.l(), this.l, this.o, jArr);
        }
    }
}
