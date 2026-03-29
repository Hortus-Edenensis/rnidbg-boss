package defpackage;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.jy;
import defpackage.ti6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class gy implements hy {
    public wo2 b;
    public rh6 c;
    public final ti6.a e;
    public final ti6 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<b> f17833a = new HashSet<>();
    public final c d = new c();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17834a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[VoipState.values().length];
            b = iArr;
            try {
                iArr[VoipState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[VoipState.CALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[VoipState.ONTHECALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[VoipState.RINGING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[VoipState.ACCEPTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[CallCmd.values().length];
            f17834a = iArr2;
            try {
                iArr2[CallCmd.DIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17834a[CallCmd.JOIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17834a[CallCmd.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17834a[CallCmd.HANGUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17834a[CallCmd.ACCEPT.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17834a[CallCmd.ONRTCROOMSTATECHANGED.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17834a[CallCmd.REFUSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17834a[CallCmd.TIME_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void g(VoipState voipState, VoipState voipState2, rh6 rh6Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<VoipState, wo2> f17835a = new HashMap<>();

        public wo2 a(VoipState voipState, hy hyVar) {
            wo2 wo2Var = this.f17835a.get(voipState);
            if (wo2Var != null) {
                return wo2Var;
            }
            int i = a.b[voipState.ordinal()];
            if (i == 1) {
                oq2 oq2Var = new oq2(hyVar);
                this.f17835a.put(voipState, oq2Var);
                return oq2Var;
            }
            if (i == 2) {
                qy qyVar = new qy(hyVar);
                this.f17835a.put(voipState, qyVar);
                return qyVar;
            }
            if (i == 3) {
                u74 u74Var = new u74(hyVar);
                this.f17835a.put(voipState, u74Var);
                return u74Var;
            }
            if (i == 4) {
                jy4 jy4Var = new jy4(hyVar);
                this.f17835a.put(voipState, jy4Var);
                return jy4Var;
            }
            if (i != 5) {
                return null;
            }
            q2 q2Var = new q2(hyVar);
            this.f17835a.put(voipState, q2Var);
            return q2Var;
        }
    }

    public gy() {
        ti6.a aVar = new ti6.a() { // from class: vx
            @Override // ti6.a
            public final void a(Message message) {
                this.f21550a.D(message);
            }
        };
        this.e = aVar;
        this.f = new ti6(aVar);
        oq2 oq2Var = new oq2(this);
        this.b = oq2Var;
        F(null, oq2Var.getStatus());
    }

    public static /* synthetic */ void A(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand REFUSE result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void B(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand HANGUP result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void C(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand TIME_OUT result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Message message) {
        int i = message.what;
        if (i == 20001) {
            r(CallCmd.TIME_OUT, new CallCmd.a());
        } else if (i == 20002) {
            r(CallCmd.TIME_OUT, new CallCmd.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand DIAL result:" + aVar2);
        if (aVar2.b) {
            this.f.sendEmptyMessageDelayed(20001, TimeUnit.SECONDS.toMillis(30L));
        }
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void t(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand REFUSE result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void u(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand TIME_OUT result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand join result:" + aVar2);
        if (aVar2.b) {
            this.f.sendEmptyMessageDelayed(20001, TimeUnit.SECONDS.toMillis(30L));
        }
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void w(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand CANCEL result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void x(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand HANGUP result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void y(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand ACCEPT result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public static /* synthetic */ void z(CallCmd.a aVar, jy.a aVar2) {
        Log.d("CallStateMachine", "CallStateMachine execCommand ONRTCROOMSTATECHANGED result:" + aVar2);
        i86.e(aVar2.f18531a, aVar2.b, aVar.d);
    }

    public final void E() {
        this.f.removeMessages(20001);
        this.f.removeMessages(20002);
        rh6 rh6Var = this.c;
        if (rh6Var != null) {
            this.b.h(ry4.a(rh6Var), this.c.a());
        }
    }

    public final void F(VoipState voipState, VoipState voipState2) {
        synchronized (this.f17833a) {
            Iterator<b> it = this.f17833a.iterator();
            while (it.hasNext()) {
                it.next().g(voipState, voipState2, this.c);
            }
        }
    }

    public void G(sh6 sh6Var) {
        LogUtil.i("RTC", "onReceiveEvent " + az2.c(sh6Var));
        rh6 rh6Var = sh6Var.b;
        this.c = rh6Var;
        switch (sh6Var.f20748a) {
            case 1:
                this.f.sendEmptyMessageDelayed(20002, TimeUnit.SECONDS.toMillis(30L));
                rh6 rh6Var2 = this.c;
                if (rh6Var2 != null) {
                    this.b.b(ry4.a(rh6Var2), this.c.a());
                }
                break;
            case 2:
            case 4:
                if (d() == null || TextUtils.isEmpty(d().h)) {
                    this.f.removeMessages(20001);
                }
                this.f.removeMessages(20002);
                rh6 rh6Var3 = this.c;
                if (rh6Var3 != null) {
                    this.b.d(ry4.a(rh6Var3), this.c.a(), null);
                }
                break;
            case 3:
                if (this.b.getStatus() == VoipState.CALLING) {
                    hg5.g(i86.c(R$string.remote_user_refuse, new String[0]));
                    er4.k(this.c, 12, 0L);
                } else if (this.b.getStatus() == VoipState.RINGING) {
                    er4.k(this.c, 5, 0L);
                }
                E();
                break;
            case 5:
                er4.k(rh6Var, 11, 0L);
                E();
                break;
            case 6:
                hg5.g(i86.c(R$string.minutes_error_message, new String[0]));
                E();
                break;
        }
    }

    public void H(b bVar) {
        synchronized (this.f17833a) {
            this.f17833a.remove(bVar);
        }
    }

    @Override // defpackage.hy
    public wo2 a(VoipState voipState) {
        return this.d.a(voipState, this);
    }

    @Override // defpackage.hy
    public wo2 b() {
        return this.b;
    }

    @Override // defpackage.hy
    public void c(wo2 wo2Var, rh6 rh6Var) {
        VoipState status = wo2Var.getStatus();
        VoipState voipState = VoipState.ONTHECALL;
        if (status == voipState) {
            er4.n(voipState, rh6Var);
        }
        this.c = rh6Var;
        VoipState status2 = this.b.getStatus();
        this.b = wo2Var;
        F(status2, wo2Var.getStatus());
    }

    @Override // defpackage.hy
    public rh6 d() {
        return this.c;
    }

    public void q(b bVar) {
        synchronized (this.f17833a) {
            this.f17833a.add(bVar);
        }
    }

    public void r(CallCmd callCmd, final CallCmd.a aVar) {
        ArrayList<RoomUserInfo> arrayList;
        ArrayList<RoomUserInfo> arrayList2;
        eb3.d(callCmd);
        int i = a.f17834a[callCmd.ordinal()];
        String string = com.igexin.push.core.b.m;
        switch (i) {
            case 1:
                if (TextUtils.isEmpty(aVar.b) || (arrayList = aVar.c) == null || arrayList.size() == 0 || aVar.f11317a == null) {
                    Log.d("CallStateMachine", "CallStateMachine execCommand DIAL failed callerUid:" + aVar.b + ",calleeUid:" + aVar.c + ",callType:" + aVar.f11317a);
                } else {
                    this.b.c(aVar, new jy() { // from class: tx
                        @Override // defpackage.jy
                        public final void a(jy.a aVar2) {
                            this.f21084a.s(aVar, aVar2);
                        }
                    });
                }
                break;
            case 2:
                if (TextUtils.isEmpty(aVar.b) || (arrayList2 = aVar.c) == null || arrayList2.size() == 0 || aVar.f11317a == null) {
                    Log.d("CallStateMachine", "CallStateMachine execCommand JOIN failed callerUid:" + aVar.b + ",calleeUid:" + aVar.c + ",callType:" + aVar.f11317a);
                } else {
                    this.b.e(aVar, new jy() { // from class: xx
                        @Override // defpackage.jy
                        public final void a(jy.a aVar2) {
                            this.f22074a.v(aVar, aVar2);
                        }
                    });
                }
                break;
            case 3:
                this.f.removeMessages(20001);
                rh6 rh6Var = this.c;
                if (rh6Var != null) {
                    this.b.g(ry4.a(rh6Var), this.c.a(), new jy() { // from class: yx
                        @Override // defpackage.jy
                        public final void a(jy.a aVar2) {
                            gy.w(aVar, aVar2);
                        }
                    });
                } else {
                    Log.d("CallStateMachine", "CallStateMachine execCommand CANCEL failed mVoipInfo is null");
                }
                break;
            case 4:
                rh6 rh6Var2 = this.c;
                if (rh6Var2 == null) {
                    Log.d("CallStateMachine", "CallStateMachine execCommand HANGUP failed mVoipInfo is null");
                    break;
                } else {
                    this.b.f(ry4.a(rh6Var2), this.c.a(), new jy() { // from class: zx
                        @Override // defpackage.jy
                        public final void a(jy.a aVar2) {
                            gy.x(aVar, aVar2);
                        }
                    });
                    if (aVar != null && aVar.f) {
                        hg5.g(i86.c(R$string.closed_call, new String[0]));
                        break;
                    }
                }
                break;
            case 5:
                this.f.removeMessages(20002);
                StringBuilder sb = new StringBuilder();
                sb.append("CallStateMachine execCommand ACCEPT mVoipInfo:");
                rh6 rh6Var3 = this.c;
                if (rh6Var3 != null) {
                    string = rh6Var3.toString();
                }
                sb.append(string);
                Log.d("CallStateMachine", sb.toString());
                rh6 rh6Var4 = this.c;
                if (rh6Var4 != null) {
                    this.b.i(ry4.a(rh6Var4), this.c.a(), new jy() { // from class: ay
                        @Override // defpackage.jy
                        public final void a(jy.a aVar2) {
                            gy.y(aVar, aVar2);
                        }
                    });
                    break;
                }
                break;
            case 6:
                if (d() == null || TextUtils.isEmpty(d().h)) {
                    this.f.removeMessages(20001);
                }
                this.f.removeMessages(20002);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CallStateMachine execCommand ONRTCROOMSTATECHANGED mVoipInfo:");
                rh6 rh6Var5 = this.c;
                if (rh6Var5 != null) {
                    string = rh6Var5.toString();
                }
                sb2.append(string);
                Log.d("CallStateMachine", sb2.toString());
                rh6 rh6Var6 = this.c;
                if (rh6Var6 != null) {
                    this.b.a(ry4.a(rh6Var6), this.c.a(), new jy() { // from class: cy
                        @Override // defpackage.jy
                        public final void a(jy.a aVar2) {
                            gy.z(aVar, aVar2);
                        }
                    });
                    break;
                }
                break;
            case 7:
                this.f.removeMessages(20002);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CallStateMachine execCommand REFUSE mVoipInfo:");
                rh6 rh6Var7 = this.c;
                if (rh6Var7 != null) {
                    string = rh6Var7.toString();
                }
                sb3.append(string);
                Log.d("CallStateMachine", sb3.toString());
                rh6 rh6Var8 = this.c;
                if (rh6Var8 != null) {
                    this.b.l(ry4.a(rh6Var8), this.c.a(), new jy() { // from class: dy
                        @Override // defpackage.jy
                        public final void a(jy.a aVar2) {
                            gy.A(aVar, aVar2);
                        }
                    });
                    hg5.g(i86.c(R$string.local_user_refuse, new String[0]));
                    break;
                }
                break;
            case 8:
                Log.d("CallStateMachine", "CallStateMachine execCommand TIME_OUT isCaller:" + (this.b.getStatus() == VoipState.CALLING));
                this.f.removeMessages(20001);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("CallStateMachine execCommand TIME_OUT mVoipInfo:");
                rh6 rh6Var9 = this.c;
                if (rh6Var9 != null) {
                    string = rh6Var9.toString();
                }
                sb4.append(string);
                Log.d("CallStateMachine", sb4.toString());
                if (this.c != null) {
                    Log.d("CallStateMachine", "CallStateMachine execCommand TIME_OUT VideoCallDataManager.ins().getActiveCount():" + ja6.f().d() + " mCurState.getStatus()=" + this.b.getStatus());
                    if (TextUtils.isEmpty(this.c.h)) {
                        this.b.j(ry4.a(this.c), this.c.a(), new jy() { // from class: wx
                            @Override // defpackage.jy
                            public final void a(jy.a aVar2) {
                                gy.u(aVar, aVar2);
                            }
                        });
                        break;
                    } else if (!eg5.c().a().equals(this.c.f)) {
                        this.b.l(ry4.a(this.c), this.c.a(), new jy() { // from class: ux
                            @Override // defpackage.jy
                            public final void a(jy.a aVar2) {
                                gy.t(aVar, aVar2);
                            }
                        });
                        break;
                    } else if (ja6.f().d() <= 1) {
                        if (this.b.getStatus() != VoipState.ONTHECALL) {
                            this.b.j(ry4.a(this.c), this.c.a(), new jy() { // from class: fy
                                @Override // defpackage.jy
                                public final void a(jy.a aVar2) {
                                    gy.C(aVar, aVar2);
                                }
                            });
                        } else {
                            this.b.f(ry4.a(this.c), this.c.a(), new jy() { // from class: ey
                                @Override // defpackage.jy
                                public final void a(jy.a aVar2) {
                                    gy.B(aVar, aVar2);
                                }
                            });
                        }
                        break;
                    }
                }
                break;
        }
    }
}
