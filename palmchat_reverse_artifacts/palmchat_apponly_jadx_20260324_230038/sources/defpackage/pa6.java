package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.cdo.oaps.ad.OapsKey;
import com.zenmen.media.msgevent.MediaClientEvent;
import com.zenmen.media.rtc.CameraRecorder;
import com.zenmen.media.rtc.CameraView;
import com.zenmen.media.rtc.ZMRtcMediaType;
import com.zenmen.media.rtc.ZMRtcParamID;
import com.zenmen.media.rtc.ZMRtcSDK;
import com.zenmen.media.rtc.ZMRtcSessionInfo;
import com.zenmen.media.rtc.ZMRtcUserType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.AudioVoiceSelection;
import com.zenmen.palmchat.videocall.VideoCallActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pa6 implements MediaClientEvent.OnNotifyEventListener {
    public static final String x = "pa6";
    public static volatile pa6 y;
    public ZMRtcSDK h;
    public MediaClientEvent i;
    public MediaClientEvent j;
    public ZMRtcMediaType l;
    public String m;
    public String n;
    public Surface o;
    public Handler p;
    public lo3 q;
    public Long s;
    public long u;
    public ArrayList<String> v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f19977a = e.PlamChat;
    public Handler b = new Handler(Looper.getMainLooper());
    public String c = null;
    public int d = 0;
    public long e = 0;
    public int f = 1001;
    public boolean g = false;
    public int k = 0;
    public boolean r = false;
    public ExecutorService t = null;
    public yf5 w = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19978a;

        public a(String str) {
            this.f19978a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZMRtcSessionInfo zMRtcSessionInfo = new ZMRtcSessionInfo();
            if (!pa6.this.z() || zMRtcSessionInfo.signalType != ZMRtcSessionInfo.SignallingTypeOnHangup || zMRtcSessionInfo.roomId == pa6.this.t()) {
                pa6.this.h.incomingMessage(this.f19978a);
            }
            Log.i(pa6.x, "incomingMessage:" + this.f19978a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19979a;

        public b(String str) {
            this.f19979a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19979a.contains("call-start");
            this.f19979a.contains("-end");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoCallActivity.d1) {
                VideoCallActivity.e1 = false;
            } else {
                VideoCallActivity.e1 = true;
            }
            if (VideoCallActivity.d1) {
                return;
            }
            ny.o(pa6.this.d);
            AudioVoiceSelection audioVoiceSelectionM = AudioVoiceSelection.m();
            audioVoiceSelectionM.p(AppContext.getContext(), false);
            if (pa6.this.n() != e.MiChat) {
                audioVoiceSelectionM.w(false);
                audioVoiceSelectionM.M();
            } else {
                if (audioVoiceSelectionM.r()) {
                    return;
                }
                audioVoiceSelectionM.H(20000);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e {
        PlamChat,
        MiChat
    }

    public static void B() {
        if (p() == null || AppContext.getContext().isBackground()) {
            return;
        }
        p().C();
    }

    public static pa6 p() {
        if (y == null) {
            synchronized (pa6.class) {
                if (y == null) {
                    y = new pa6();
                }
            }
        }
        return y;
    }

    public void A(boolean z) {
        if (this.g) {
            this.h.muteVoice(z);
        }
    }

    public void C() {
        ZMRtcSDK zMRtcSDK = this.h;
        if (zMRtcSDK != null) {
            zMRtcSDK.setParam(ZMRtcParamID.RtcParamID_Set_APP_FOREGROUND, 1);
        }
    }

    public boolean D(String str) {
        if (str == null) {
            Log.i(x, "roomID:" + str);
            return false;
        }
        try {
            ListIterator<String> listIterator = this.v.listIterator();
            while (listIterator.hasNext()) {
                if (str.equals(listIterator.next())) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public int E() {
        if (this.g) {
            return this.h.refuse();
        }
        return -1000;
    }

    public int F() {
        if (this.g) {
            return this.h.refuse_manual();
        }
        return -1000;
    }

    public void G() {
        this.k = 0;
        this.p = null;
    }

    public void H() {
        int i;
        LogUtil.i(x, "removeSurface", (Throwable) null, 1);
        if (this.g && (i = this.k) != 0) {
            this.h.deleteRemoteView(i);
        }
        this.o = null;
    }

    public String I(String str) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = xn3.a();
        messageVo.time = ir5.b();
        messageVo.contactRelate = "@voip.youni";
        messageVo.to = "@voip.youni";
        messageVo.text = AppContext.getContext().getString(R.string.message_type_video_call);
        messageVo.mimeType = 30;
        messageVo.sendFlag = String.valueOf(0);
        messageVo.from = AccountUtils.p(AppContext.getContext());
        LogUtil.i(x, "[sendVideoCallCommand] : from = " + messageVo.from + " to = " + messageVo.to, 1);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", str);
            jSONObject.put("voipMsg", jSONObject2);
            messageVo.extention = jSONObject.toString();
            if (this.q.e() != null) {
                this.q.e().r(messageVo);
            }
            return messageVo.mid;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final void J(Context context, ZMRtcSDK zMRtcSDK) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int iIntValue = 0;
        try {
            Method method = audioManager.getClass().getMethod("getOutputLatency", Integer.TYPE);
            if (method != null) {
                iIntValue = ((Integer) method.invoke(audioManager, 0)).intValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldError e3) {
            e3.printStackTrace();
        }
        String str = x;
        Log.i(str, "audio latency:" + iIntValue);
        int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
        int minBufferSize2 = AudioTrack.getMinBufferSize(8000, 4, 2);
        int i = minBufferSize + minBufferSize2;
        StringBuilder sb = new StringBuilder();
        sb.append("audio latency recsize:");
        sb.append(minBufferSize);
        sb.append(", ");
        int i2 = minBufferSize / 16;
        sb.append(i2);
        sb.append(" playsize:");
        sb.append(minBufferSize2);
        sb.append(" ,");
        int i3 = minBufferSize2 / 16;
        sb.append(i3);
        sb.append(" delay:");
        sb.append(i / 16);
        Log.i(str, sb.toString());
        try {
            zMRtcSDK.setAPMProperty(7, iIntValue == 0 ? i2 + i3 : i2 + iIntValue);
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
        }
    }

    public void K(String str) {
        this.n = str;
    }

    public void L(ZMRtcMediaType zMRtcMediaType) {
        if (this.g) {
            this.l = zMRtcMediaType;
        }
    }

    public final void M(e eVar) {
        this.f19977a = eVar;
    }

    public void N(Handler handler) {
        this.p = handler;
    }

    public void O(boolean z, long j) {
        if (this.g) {
            this.i.MessageEvent(-1001, 0, z ? 1 : 0, Long.valueOf(j));
        }
    }

    public void P(long j) {
        this.u = j;
    }

    public void Q(String str) {
        if (this.g) {
            if (!TextUtils.isEmpty(str)) {
                this.m = str;
            }
            this.h.setNetworkArea(this.m);
        }
    }

    public int R(ZMRtcParamID zMRtcParamID, Object obj) {
        if (this.g) {
            return this.h.setParam(zMRtcParamID, obj);
        }
        return -1;
    }

    public void S(Surface surface) {
        if (this.o == surface) {
            return;
        }
        this.o = surface;
        int i = this.k;
        if (i == 0 || surface == null) {
            return;
        }
        this.h.addRemoteView(i, surface);
    }

    public int T(CameraView cameraView, int i, CameraRecorder.CAMERA_TYPE camera_type) {
        if (this.g) {
            return this.h.startPreviewOnView(cameraView, i, camera_type);
        }
        return -1000;
    }

    public void U() {
        if (this.g) {
            this.h.startVideoCapture(CameraRecorder.BIT_RATE, 15, 0);
        }
    }

    public void V() {
        if (this.g) {
            this.h.stopVideoCapture();
        }
    }

    public void W() {
        if (this.g) {
            this.h.switchCamera();
        }
    }

    public void X(int i, String str, int i2) {
        ta6.f(i, str, i2);
    }

    public void Y(String str) {
        if (System.currentTimeMillis() - this.e > 10000) {
            w(str);
            Log.i(x, "read from upd:" + str);
            this.e = System.currentTimeMillis();
        }
    }

    public int d() {
        ny.c();
        if (this.g) {
            return this.h.accpet();
        }
        return -1000;
    }

    public void e() {
        lo3 lo3Var = new lo3(AppContext.getContext(), new c());
        this.q = lo3Var;
        lo3Var.c();
    }

    public int f(String str, ZMRtcMediaType zMRtcMediaType) {
        if (!this.g) {
            return -1000;
        }
        int iG = r75.g(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 0);
        if (iG == 0) {
            this.h.setParam(ZMRtcParamID.RtcParamID_Set_Call_Source, Integer.valueOf(ZMRtcSDK.RtcCALL_SOURCE_DEFAULT));
        } else if (iG == 1) {
            this.h.setParam(ZMRtcParamID.RtcParamID_Set_Call_Source, Integer.valueOf(ZMRtcSDK.RtcCALL_SOURCE_DETAIL_PAGE));
        } else if (iG == 2) {
            this.h.setParam(ZMRtcParamID.RtcParamID_Set_Call_Source, Integer.valueOf(ZMRtcSDK.RtcCALL_SOURCE_CHATTING_ACTIVITY_RECORD));
        } else if (iG == 3) {
            this.h.setParam(ZMRtcParamID.RtcParamID_Set_Call_Source, Integer.valueOf(ZMRtcSDK.RtcCALL_SOURCE_CHATTING_ACTIVITY_TIPS));
        }
        r75.p(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 0);
        return this.h.calltoFriend(Long.valueOf(str).longValue(), zMRtcMediaType);
    }

    public int g() {
        if (this.g) {
            return this.h.cancel();
        }
        return -1000;
    }

    public int h() {
        if (this.g) {
            return this.h.closePreviewOnView();
        }
        return -1000;
    }

    public synchronized void i() {
        if (this.g) {
            try {
                yf5 yf5Var = this.w;
                if (yf5Var != null) {
                    yf5Var.N();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.h.finish();
            this.h.release();
            this.h = null;
            this.i.setOnNotifyEventListener(null);
            this.i = null;
            this.g = false;
            wa6.k();
        }
    }

    public void j(boolean z) {
        if (this.g) {
            this.h.enableLocalVideo(z);
        }
    }

    public int k() {
        if (!this.g) {
            return -1000;
        }
        this.l = null;
        return this.h.finish();
    }

    public String l() {
        return this.n;
    }

    public ZMRtcMediaType m() {
        return this.l;
    }

    public final e n() {
        return this.f19977a;
    }

    public final ExecutorService o() {
        if (this.t == null) {
            this.t = vw5.d(x);
        }
        return this.t;
    }

    @Override // com.zenmen.media.msgevent.MediaClientEvent.OnNotifyEventListener
    public void onEventNotify(int i, int i2, int i3, Object obj) {
        if (i == -1001) {
            this.r = i3 == 1;
            this.s = (Long) obj;
        } else if (i == 501) {
            String strValueOf = String.valueOf(obj);
            Log.i(x, "guide " + strValueOf);
            v66.b().d(strValueOf);
        } else if (i == 20180617) {
            try {
                Y((String) obj);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (i == 200) {
            LogUtil.i(x, "心跳包信息 " + String.valueOf(obj) + " Status：" + i2, 1);
        } else if (i != 201) {
            switch (i) {
                case 1:
                    if (i2 == 1) {
                        LogUtil.i(x, "开始呼叫中...", 1);
                    } else if (i2 == -107) {
                        LogUtil.i(x, "呼叫失败, 非好友关系", 1);
                    } else if (i2 == -108 || i2 == -109) {
                        LogUtil.i(x, "呼叫失败, 对方版本不支持", 1);
                    } else {
                        LogUtil.i(x, "呼叫失败, 对方版本不是灰度测试用户", 1);
                    }
                    break;
                case 2:
                    String[] strArrSplit = ((String) obj).split("-");
                    String str = strArrSplit[0];
                    this.c = str;
                    String str2 = strArrSplit[1];
                    String str3 = x;
                    LogUtil.i(str3, "被叫者被呼叫,呼叫者id" + str + "roomID" + str2, 1);
                    if (!com.zenmen.palmchat.videocall.c.e()) {
                        r75.o(AppContext.getContext(), k86.a("sp_video_call_enabled"), true);
                        if (com.zenmen.palmchat.videocall.c.e()) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(OapsKey.KEY_CALLER, str);
                                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80", null, null, jSONObject.toString());
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        } else {
                            LogUtil.i(str3, "VideoCall is disabled");
                        }
                    }
                    try {
                        if (com.zenmen.palmchat.videocall.c.j() || LxVoipManager.b().g()) {
                            this.h.busyRefuse(Integer.parseInt(strArrSplit[2]));
                            return;
                        }
                    } catch (Exception unused) {
                    }
                    if (i2 == -203) {
                        LogUtil.i(x, "被叫者被呼叫,但是正在通话中" + str, 1);
                        this.h.busyRefuse(i3);
                    } else if (i2 == 1) {
                        Intent intent = new Intent(AppContext.getContext(), (Class<?>) VideoCallActivity.class);
                        intent.addFlags(268435456);
                        intent.putExtra("is_caller", false);
                        intent.putExtra("caller_uid", str);
                        intent.putExtra("call_time", System.currentTimeMillis());
                        intent.putExtra("room_id", str2);
                        if (p().D(str)) {
                            return;
                        }
                        if (i3 == 0) {
                            LogUtil.i(x, "被叫者视频通话", 1);
                            intent.putExtra("call_type", 0);
                        } else {
                            LogUtil.i(x, "被叫者语音通话", 1);
                            intent.putExtra("call_type", 1);
                        }
                        if (this.r) {
                            this.h.finish();
                            y(AppContext.getContext().getString(R.string.video_call_msg_callee_cancelled), str, i3, this.s);
                        } else if (!TextUtils.isEmpty(str)) {
                            try {
                                AppContext.getContext().startActivity(intent);
                                this.d = intent.getIntExtra("call_type", 0);
                                new Handler().postDelayed(new d(), com.igexin.push.config.c.j);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        this.r = false;
                    }
                    break;
                case 3:
                    if (i2 != 1) {
                        LogUtil.i(x, "接受通话失败", 1);
                    } else {
                        LogUtil.i(x, "连接中...", 1);
                    }
                    break;
                case 4:
                    if (i2 == 1) {
                        LogUtil.i(x, "连接中...", 1);
                    } else if (i2 == -201) {
                        LogUtil.i(x, "对方拒绝", 1);
                    } else if (i2 == -203) {
                        LogUtil.i(x, "对方忙", 1);
                    } else if (i2 != -302) {
                        LogUtil.i(x, "呼叫失败", 1);
                    } else {
                        LogUtil.i(x, "与媒体服务器断开连接", 1);
                    }
                    break;
                case 5:
                    this.h.finish();
                    String[] strArrSplit2 = ((String) obj).split("-");
                    LogUtil.i(x, "挂断通话，通话结束 用户：" + Long.valueOf(String.valueOf(strArrSplit2[0])), 1);
                    break;
                case 6:
                    String[] strArrSplit3 = ((String) obj).split("-");
                    String str4 = strArrSplit3[1];
                    LogUtil.i(x, "对方挂断 用户：" + Long.valueOf(strArrSplit3[0]), 1);
                    ny.c();
                    this.v.add(str4);
                    if (this.v.size() >= 100) {
                        this.v.remove(0);
                    }
                    AudioVoiceSelection.m().M();
                    break;
                case 7:
                    LogUtil.i(x, "通话结束 房间号：" + Long.valueOf(String.valueOf(obj)), 1);
                    break;
                case 8:
                    String str5 = x;
                    LogUtil.i(str5, "被叫者进入通话房间，ID：" + i2 + " 语音还是视频：" + i3, (Throwable) null, 1);
                    this.k = i2;
                    if (i3 == 0) {
                        LogUtil.i(str5, "被叫者语音语音数据进去", 1);
                    } else if (i3 == 1) {
                        LogUtil.i(str5, "被叫者视频数据进去", 1);
                        Surface surface = this.o;
                        if (surface != null) {
                            this.h.addRemoteView(this.k, surface);
                        }
                    }
                    break;
                case 9:
                    String str6 = x;
                    LogUtil.i(str6, "被叫者离开房间 ID: " + i2, 1);
                    if (i3 == 0) {
                        LogUtil.i(str6, "被叫者语音语音数据离开", 1);
                    } else if (i3 == 1) {
                        LogUtil.i(str6, "被叫者视频数据离开", 1);
                    }
                    break;
                case 10:
                    LogUtil.i(x, "被叫传输过来第一帧画面 用户CID：" + i2, 1);
                    break;
                case 11:
                    if (i2 != 1) {
                        LogUtil.i(x, "用户加入通话房间失败 " + i2, 1);
                    } else {
                        ZMRtcSDK zMRtcSDK = this.h;
                        if (zMRtcSDK != null) {
                            zMRtcSDK.startVoip();
                        }
                        LogUtil.i(x, "用户加入通话房间 " + i2, 1);
                    }
                    break;
                case 12:
                    LogUtil.i(x, "用户离开通话房间", 1);
                    break;
                case 13:
                    LogUtil.i(x, "通话过程中网络断了 ", 1);
                    break;
                case 14:
                    if (i2 != 0) {
                        LogUtil.i(x, "对方摄像头又开了", 1);
                    } else {
                        LogUtil.i(x, "对方摄像头关闭了", 1);
                    }
                    break;
                case 15:
                    LogUtil.i(x, "录音有问题问题类型：" + i2 + " 错误代码：" + i3, 1);
                    break;
                default:
                    switch (i) {
                        case 18:
                            String str7 = x;
                            LogUtil.i(str7, "网络状况  " + i2, 1);
                            if (i2 == ZMRtcSDK.RtcNetStatus_Normal) {
                                LogUtil.i(str7, "网络状况一般", 1);
                            } else if (i2 == ZMRtcSDK.RtcNetStatus_Good) {
                                LogUtil.i(str7, "网络状况很好", 1);
                            } else if (i2 == ZMRtcSDK.RtcNetStatus_Bad) {
                                LogUtil.i(str7, "网络状况比较差", 1);
                            } else if (i2 == ZMRtcSDK.RtcNetStatus_VeryBad) {
                                LogUtil.i(str7, "网络状况很差", 1);
                            }
                            break;
                        case 19:
                            LogUtil.i(x, "对方可能掉线了 " + i2, 1);
                            break;
                        case 20:
                            LogUtil.i(x, "采集视频效率不高，最好还是用纯语音聊天", 1);
                            break;
                        case 21:
                            LogUtil.i(x, "采集音频丢帧厉害", 1);
                            break;
                        case 22:
                            Log.i(x, "房间:" + i2 + " 不存在，请关闭来电页面");
                            break;
                        default:
                            switch (i) {
                                case 100:
                                    if (i2 == 1) {
                                        LogUtil.i(x, "主叫呼叫朋友的信息" + String.valueOf(obj) + " Status：" + i2, 1);
                                    }
                                    break;
                                case 101:
                                    if (i2 == 1) {
                                        LogUtil.i(x, "被叫接收呼叫的信息" + String.valueOf(obj) + " Status：" + i2, 1);
                                    }
                                    break;
                                case 102:
                                    if (i2 == 1) {
                                        LogUtil.i(x, "被叫拒绝呼叫的信息 " + String.valueOf(obj) + " Status：" + i2, 1);
                                    }
                                    I((String) obj);
                                    this.h.finish();
                                    break;
                                case 103:
                                    if (i2 == 1) {
                                        LogUtil.i(x, "主叫取消呼叫信息 " + String.valueOf(obj) + " Status：" + i2, 1);
                                    }
                                    break;
                                case 104:
                                    if (i2 == 1) {
                                        LogUtil.i(x, "挂断通话信息 " + String.valueOf(obj) + " Status：" + i2, 1);
                                    }
                                    break;
                                case 105:
                                    LogUtil.i(x, "由于正在通话中信息 " + String.valueOf(obj) + " Status：" + i2, 1);
                                    if (VideoCallActivity.o3() == null) {
                                        I(String.valueOf(obj));
                                    }
                                    break;
                                case 106:
                                    LogUtil.i(x, "通话中的状态信息 " + String.valueOf(obj) + " Status：" + i2, 1);
                                    I((String) obj);
                                    break;
                                case 107:
                                    LogUtil.i(x, "被叫接听超时 ");
                                    this.h.refuse();
                                    y(AppContext.getContext().getString(R.string.video_no_response_toast), (String) obj, i3, Long.valueOf(System.currentTimeMillis()));
                                    if (VideoCallActivity.e1) {
                                        v66.b().c(this.c);
                                        VideoCallActivity.e1 = false;
                                    }
                                    AudioVoiceSelection.m().M();
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            String strValueOf2 = String.valueOf(obj);
            Log.i(x, "设备信息 " + strValueOf2);
            I(strValueOf2);
        }
        try {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = obj;
            VideoCallActivity.b3(message);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public long q() {
        return this.u;
    }

    public int r() {
        if (this.g) {
            return this.h.getLiveMessage();
        }
        return -1000;
    }

    public int s(String str, ZMRtcSessionInfo zMRtcSessionInfo) {
        if (this.g) {
            return this.h.getMessageInfo(str, zMRtcSessionInfo);
        }
        return -1;
    }

    public long t() {
        if (this.g) {
            return this.h.getRoomNumber();
        }
        return -1L;
    }

    public String u(int i, boolean z, int i2, int i3, String str) {
        try {
            return this.h.getCallNotifyMsg(i, z, i2, i3, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public int v() {
        if (this.g) {
            return this.h.hangup();
        }
        return -1000;
    }

    public void w(String str) {
        if (this.g) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (str.contains("voipMsg")) {
                    o().submit(new a(jSONObject.getJSONObject("voipMsg").getString("data")));
                } else if (str.contains("voipState")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("voipState");
                    jSONObject2.getLong("callerid");
                    jSONObject2.getLong("calleeid");
                    jSONObject2.getInt("calltype");
                    jSONObject2.getLong("roomid");
                    jSONObject2.getString("callstate");
                    o().submit(new b(str));
                }
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void x() {
        if (ns.c().b().isVideoCallUdpSwitch()) {
            LogUtil.i(x, "disable VideoCallManager init");
            return;
        }
        if (!this.g) {
            AppContext context = AppContext.getContext();
            if (context.getAppName().toLowerCase().contains("michat")) {
                M(e.MiChat);
            }
            String strP = AccountUtils.p(context);
            if (!TextUtils.isEmpty(strP) && TextUtils.isDigitsOnly(strP)) {
                wa6.b(strP, context);
                e();
                MediaClientEvent newInstance = MediaClientEvent.getNewInstance();
                this.j = newInstance;
                newInstance.registerNotifyEventListener("1", this);
                MediaClientEvent mediaClientEvent = MediaClientEvent.getInstance();
                this.i = mediaClientEvent;
                mediaClientEvent.registerNotifyEventListener("1", this);
                try {
                    ZMRtcSDK zMRtcSDK = new ZMRtcSDK();
                    this.h = zMRtcSDK;
                    zMRtcSDK.init(Long.valueOf(strP).longValue(), ZMRtcUserType.RtcUser_Zhangxin, this.j);
                    this.h.setParam(ZMRtcParamID.RtcParamID_Enable_Report_Callee_No_Response, null);
                    J(context, this.h);
                    String strF = it0.k().f();
                    if (!TextUtils.isEmpty(strF)) {
                        this.m = strF;
                    }
                    this.h.setNetworkArea(this.m);
                    this.g = true;
                    this.v = new ArrayList<>();
                    this.w = wa6.c(this.i.getEventHandler());
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
    }

    public final void y(String str, String str2, int i, Object obj) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = xn3.a();
        messageVo.time = ((Long) obj).longValue();
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(i == 0 ? R.string.message_type_video_call : R.string.message_type_voice_call);
        messageVo.mimeType = 30;
        messageVo.status = 2;
        messageVo.sendFlag = String.valueOf(0);
        messageVo.from = AccountUtils.p(AppContext.getContext());
        messageVo.isSend = false;
        messageVo.isRead = false;
        messageVo.extention = "";
        messageVo.data1 = str;
        messageVo.data2 = String.valueOf(i);
        com.zenmen.palmchat.database.b.t(messageVo);
        if (str == null || !str.contains(AppContext.getContext().getString(R.string.video_call_msg_callee_cancelled))) {
            return;
        }
        ua6.g(AppContext.getContext(), str2);
    }

    public boolean z() {
        return (this.g && this.p != null) || LxVoipManager.b().g();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            pa6.this.q.c();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }
    }
}
