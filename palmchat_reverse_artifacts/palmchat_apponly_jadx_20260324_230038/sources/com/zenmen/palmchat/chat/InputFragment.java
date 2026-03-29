package com.zenmen.palmchat.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.Vibrator;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.litesuits.async.AsyncTask;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.Vo.SuperGreetingsVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.chat.aigreeting.a;
import com.zenmen.palmchat.chat.b;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.gift.ShowChatGiftPanelEvent;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyChatTextGuideVo;
import com.zenmen.palmchat.chat.mate.ChatMateActivityStatusData;
import com.zenmen.palmchat.chat.pay.PayChatEvent;
import com.zenmen.palmchat.chat.pay.a;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.circle.ui.config.GroupVersionConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.conversations.bean.BizpubIsShowNoticeReminderV1Result;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneItemVo;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.expression.a;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.giftkit.GiftBizType;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.giftkit.chat.GiftReceiverInfo;
import com.zenmen.palmchat.giftkit.event.GiftMsgEvent;
import com.zenmen.palmchat.giftkit.event.GiftSendResultEvent;
import com.zenmen.palmchat.giftkit.play.GiftPlayVo;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationSelectActivityV2;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.media.file.FileSelectActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.modulemanager.module.LXRTCModule;
import com.zenmen.palmchat.route.share.a;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.ShareLinkBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.VideoCallActivity;
import com.zenmen.palmchat.videocall.b;
import com.zenmen.palmchat.widget.horizontalgridpager.HorizontalGridPager;
import com.zenmen.palmchat.widget.horizontalgridpager.a;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.a65;
import defpackage.a66;
import defpackage.ap3;
import defpackage.az2;
import defpackage.b05;
import defpackage.b9;
import defpackage.bn4;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.cw;
import defpackage.d9;
import defpackage.ds0;
import defpackage.e20;
import defpackage.ef2;
import defpackage.f33;
import defpackage.fa2;
import defpackage.fa3;
import defpackage.fb2;
import defpackage.fd6;
import defpackage.fn2;
import defpackage.fo5;
import defpackage.fu2;
import defpackage.fu5;
import defpackage.g03;
import defpackage.go2;
import defpackage.gr2;
import defpackage.gu2;
import defpackage.ha3;
import defpackage.ho3;
import defpackage.hu4;
import defpackage.im;
import defpackage.iq4;
import defpackage.ir5;
import defpackage.j94;
import defpackage.k86;
import defpackage.kk;
import defpackage.l50;
import defpackage.l84;
import defpackage.lb3;
import defpackage.m30;
import defpackage.me1;
import defpackage.mi5;
import defpackage.mt2;
import defpackage.n20;
import defpackage.n30;
import defpackage.nl0;
import defpackage.o30;
import defpackage.q05;
import defpackage.qm5;
import defpackage.r75;
import defpackage.rc0;
import defpackage.s34;
import defpackage.sd3;
import defpackage.sw4;
import defpackage.sy5;
import defpackage.t20;
import defpackage.tg4;
import defpackage.tk3;
import defpackage.u93;
import defpackage.uk4;
import defpackage.up4;
import defpackage.v8;
import defpackage.vk3;
import defpackage.vl1;
import defpackage.vp3;
import defpackage.vs0;
import defpackage.w30;
import defpackage.w8;
import defpackage.wb2;
import defpackage.wg4;
import defpackage.ws4;
import defpackage.x30;
import defpackage.xg5;
import defpackage.xn3;
import defpackage.xt4;
import defpackage.yz2;
import defpackage.zn6;
import defpackage.zw4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class InputFragment extends BaseFragment implements mt2.c, w8 {
    public static boolean b1 = false;
    public static final String c1 = "InputFragment";
    public ImageView A;
    public ImageView A0;
    public LinearLayout B;
    public View B0;
    public LinearLayout C;
    public TextView C0;
    public View D0;
    public LinearLayout E;
    public View E0;
    public LinearLayout F;
    public int F0;
    public ChatItem G;
    public View H0;
    public String I;
    public TextView I0;
    public InputMethodManager J;
    public View J0;
    public PopupWindow K;
    public View K0;
    public View L0;
    public CountDownTimer M;
    public TextView M0;
    public TextView N0;
    public Timer O0;
    public int P0;
    public com.zenmen.palmchat.expression.a Q;
    public com.zenmen.palmchat.chat.aigreeting.a Q0;
    public AsyncTask R;
    public int S;
    public ShareLinkBean U;
    public MessageVo V;
    public long W;
    public rc0 X;
    public i1 X0;
    public com.zenmen.palmchat.chat.b Y;
    public j1 Y0;
    public View Z;
    public g1 Z0;
    public View e0;
    public View f;
    public TextView g;
    public ImageView h;
    public String h0;
    public EditText i;
    public String i0;
    public View j;
    public boolean j0;
    public View k;
    public boolean k0;
    public View l;
    public bn4 l0;
    public HorizontalGridPager m;
    public String m0;
    public ImageView n;
    public n20 n0;
    public View o;
    public iq4 o0;
    public TextView p;
    public wb2 p0;
    public TextView q;
    public up4 q0;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public HashMap<String, ContactInfoItem> v0;
    public ImageView w;
    public MessageVo w0;
    public ImageView x;
    public ImageView y;
    public ImageView z;
    public boolean H = true;
    public int L = 0;
    public int N = 1;
    public boolean O = false;
    public Set<String> P = new HashSet();
    public boolean T = false;
    public boolean f0 = false;
    public boolean g0 = false;
    public boolean r0 = false;
    public boolean s0 = false;
    public int t0 = -1;
    public int u0 = -1;
    public boolean x0 = false;
    public boolean y0 = false;
    public boolean z0 = false;
    public int G0 = 1200;
    public k1 R0 = new k1(this);
    public MediaPlayer.OnCompletionListener S0 = new g0();
    public a.g T0 = new c0();
    public boolean U0 = false;
    public int V0 = -1;
    public float W0 = 0.0f;
    public h1 a1 = new a1();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.Q0.n();
            InputFragment.this.N3(false);
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null) {
                i1Var.p();
            }
            if (InputFragment.this.l.getVisibility() == 8) {
                InputFragment.this.getActivity().getWindow().setSoftInputMode(32);
                Log.i(InputFragment.c1, "SOFT_INPUT_ADJUST_PAN");
                if (InputFragment.this.N == 0) {
                    InputFragment.this.O = false;
                    InputFragment.this.J.hideSoftInputFromWindow(InputFragment.this.i.getWindowToken(), 0);
                }
                InputFragment.this.l.setVisibility(0);
                InputFragment.this.T1();
                InputFragment inputFragment = InputFragment.this;
                inputFragment.K = xt4.c(inputFragment.getActivity(), InputFragment.this.h, InputFragment.this.G, InputFragment.this.R0);
                hu4.a(ws4.a(24));
            } else if (InputFragment.this.B.getVisibility() == 0 && InputFragment.this.N != 0) {
                InputFragment inputFragment2 = InputFragment.this;
                inputFragment2.K = xt4.c(inputFragment2.getActivity(), InputFragment.this.h, InputFragment.this.G, InputFragment.this.R0);
            } else if (InputFragment.this.N == 0) {
                InputFragment.this.O = false;
                InputFragment.this.J.hideSoftInputFromWindow(InputFragment.this.i.getWindowToken(), 0);
                InputFragment inputFragment3 = InputFragment.this;
                inputFragment3.K = xt4.c(inputFragment3.getActivity(), InputFragment.this.h, InputFragment.this.G, InputFragment.this.R0);
            } else {
                InputFragment.this.j.setVisibility(8);
                KeyboardKt.d(InputFragment.this.i, InputFragment.this.J, Keyboard$SHOW_FLAG.DEFAULT, 0L);
            }
            InputFragment.this.B.setVisibility(8);
            InputFragment.this.m.setVisibility(0);
            InputFragment.this.A.setSelected(false);
            InputFragment.this.A.setImageResource(R.drawable.selector_background_input_face_button);
            InputFragment.this.h.setImageResource(R.drawable.input_add_icon_close);
            g1 g1Var = InputFragment.this.Z0;
            if (g1Var != null) {
                g1Var.a(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements Runnable {
        public a0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InputFragment.this.getActivity() == null || InputFragment.this.getActivity().isFinishing() || InputFragment.this.G == null) {
                return;
            }
            boolean z = (InputFragment.this.q0 == null || !InputFragment.this.q0.f()) ? InputFragment.this.l0 == null || !InputFragment.this.l0.v() : false;
            if (InputFragment.this.r0 || !z || InputFragment.this.k0) {
                return;
            }
            GiftMessageHelper.B0(InputFragment.this.getActivity(), InputFragment.this.e0, InputFragment.this.G.getChatId(), DomainHelper.m(InputFragment.this.G).domain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a1 implements h1 {
        public a1() {
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.h1
        public ChatterAdapter a() {
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null) {
                return i1Var.a();
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.h1
        public ChatItem b() {
            return InputFragment.this.G;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.h1
        public List<MessageVo> c() {
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null) {
                return i1Var.a().I();
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.h1
        public void d() {
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null) {
                i1Var.a().E().w();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.Q0.n();
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, InputFragment.this.A.isSelected() ? "ME102" : "ME103", "1", null, null);
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null) {
                i1Var.p();
            }
            if (InputFragment.this.l.getVisibility() == 8) {
                InputFragment.this.getActivity().getWindow().setSoftInputMode(32);
                Log.i(InputFragment.c1, "SOFT_INPUT_ADJUST_PAN");
                if (InputFragment.this.N == 0) {
                    InputFragment.this.O = false;
                    InputFragment.this.J.hideSoftInputFromWindow(InputFragment.this.i.getWindowToken(), 0);
                }
                InputFragment.this.l.setVisibility(0);
                InputFragment.this.T1();
                InputFragment.this.N3(false);
            } else if (InputFragment.this.m.getVisibility() != 0 || InputFragment.this.N == 0) {
                if (InputFragment.this.N == 0) {
                    InputFragment.this.O = false;
                    InputFragment.this.J.hideSoftInputFromWindow(InputFragment.this.i.getWindowToken(), 0);
                } else {
                    InputFragment.this.j.setVisibility(8);
                    KeyboardKt.d(InputFragment.this.i, InputFragment.this.J, Keyboard$SHOW_FLAG.DEFAULT, 0L);
                }
            }
            InputFragment.this.B.setVisibility(0);
            if (fu5.u(InputFragment.this.G)) {
                InputFragment.this.Q.i(0);
            } else if (ChatterActivity.P1 <= 0 || !TextUtils.isEmpty(InputFragment.this.m2())) {
                if (TextUtils.isEmpty(InputFragment.this.m2())) {
                    ChatterActivity.P1 = r75.g(InputFragment.this.getActivity(), k86.a("last_expression_item"), 0);
                } else {
                    ChatterActivity.P1 = 0;
                    r75.p(InputFragment.this.getActivity(), k86.a("last_expression_item"), ChatterActivity.P1);
                }
                InputFragment.this.Q.i(ChatterActivity.P1);
            } else {
                InputFragment.this.Q.i(ChatterActivity.P1);
            }
            InputFragment.this.m.setVisibility(8);
            InputFragment.this.A.setSelected(true);
            InputFragment.this.A.setImageResource(R.drawable.selector_keyboard);
            InputFragment.this.h.setImageResource(R.drawable.selector_background_input_add_button);
            g1 g1Var = InputFragment.this.Z0;
            if (g1Var != null) {
                g1Var.a(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InputFragment.this.i.getVisibility() == 0) {
                InputFragment.this.i.performClick();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b1 implements Runnable {
        public b1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InputFragment.this.l0 != null) {
                InputFragment.this.l0.i();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InputFragment.this.l0 != null) {
                InputFragment.this.l0.o(InputFragment.this.G.getBizType());
            }
            if (InputFragment.this.C.getVisibility() == 0 && InputFragment.this.U != null) {
                InputFragment.this.f3();
            } else {
                InputFragment.this.k3(InputFragment.this.i.getText().toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements a.g {
        public c0() {
        }

        @Override // com.zenmen.palmchat.expression.a.g
        public void a(boolean z, int i) {
            if (InputFragment.this.i != null) {
                if (z) {
                    InputFragment.this.i.requestFocus();
                    InputFragment.this.j.setVisibility(8);
                } else {
                    InputFragment.this.i.clearFocus();
                    InputFragment.this.j.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c1 implements b.InterfaceC0976b {
        public c1() {
        }

        @Override // com.zenmen.palmchat.chat.b.InterfaceC0976b
        public void a(View view, int i) {
            if (l50.a()) {
                return;
            }
            InputItemManager.InputItemType inputItemTypeF = InputFragment.this.Y.f(i);
            InputFragment inputFragment = InputFragment.this;
            j1 j1Var = inputFragment.Y0;
            if (j1Var != null) {
                j1Var.f(inputItemTypeF, inputFragment.Y);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.l.setVisibility(0);
            InputFragment.this.N3(true);
            g1 g1Var = InputFragment.this.Z0;
            if (g1Var != null) {
                g1Var.a(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12612a;
        public final /* synthetic */ String b;

        public d0(boolean z, String str) {
            this.f12612a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12612a ? "ai-greet" : "");
            sb.append(xn3.a());
            try {
                InputFragment.this.X0.l().r(MessageVo.buildTextMessage(sb.toString(), DomainHelper.e(InputFragment.this.G), this.b, InputFragment.this.G.getChatType() == 1 ? (String[]) InputFragment.this.P.toArray(new String[0]) : null, 0, InputFragment.this.o2()).setThreadBizType(InputFragment.this.getActivity(), InputFragment.this.S));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0 || !InputFragment.d2(editable)) {
                if (InputFragment.this.l0 == null || !(InputFragment.this.l0.u(InputFragment.this.G.getBizType()) || InputFragment.this.l0.x(InputFragment.this.G.getBizType()))) {
                    InputFragment.this.g.setVisibility(8);
                    return;
                } else {
                    InputFragment.this.g.setVisibility(0);
                    return;
                }
            }
            i1 i1Var = InputFragment.this.X0;
            if (i1Var == null || i1Var.s() == 1) {
                return;
            }
            InputFragment.this.g.setVisibility(0);
            if (InputFragment.this.l0 != null) {
                InputFragment.this.l0.g(InputFragment.this.G.getBizType(), InputFragment.this.g, true, InputFragment.this.t0, InputFragment.this.u0, InputFragment.this.G);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            InputFragment.this.Y2(charSequence, i, i2, i3);
            if (i2 == 1 && charSequence.charAt(i) == " ".charAt(0)) {
                Message message = new Message();
                message.what = 0;
                message.arg1 = i;
                InputFragment.this.R0.sendMessage(message);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (InputFragment.this.G.getChatType() == 1 && i3 == 1 && i3 != i2) {
                String strValueOf = charSequence != null ? String.valueOf(charSequence.charAt(i)) : "";
                if (!TextUtils.isEmpty(strValueOf) && strValueOf.equals("@")) {
                    if (i != 0) {
                        int i4 = i - 1;
                        if (!Character.isDigit(charSequence.charAt(i4)) && !Character.isLowerCase(charSequence.charAt(i4)) && !Character.isUpperCase(charSequence.charAt(i4))) {
                            InputFragment.this.h2();
                        }
                    }
                }
            }
            if (f33.i()) {
                return;
            }
            if (a66.a(String.valueOf(charSequence))) {
                InputFragment.this.I3(String.valueOf(charSequence));
            } else {
                InputFragment.this.C.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterActivity f12615a;

        public e0(ChatterActivity chatterActivity) {
            this.f12615a = chatterActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12615a.k4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e1 implements View.OnClickListener {
        public e1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.C.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null) {
                i1Var.f();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements q05.e<Boolean> {
        public f0() {
        }

        @Override // q05.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            q05.w("KEY_SHOW_LAST_CHAT_USER_ID" + InputFragment.this.G.getChatId(), Boolean.TRUE);
            q05.w("KEY_SHOW_LAST_CHAT_GUIDE_TIME", Long.valueOf(ir5.b()));
            String str = "您未开启消息通知，容易错过重要消息 <a href='zenxin://activity?page=a0641&toUid=" + InputFragment.this.G.getChatId() + "'>立即开启</a>";
            MessageVo messageVoG = defpackage.u0.g(InputFragment.this.G);
            messageVoG.status = 2;
            messageVoG.mimeType = 10000;
            messageVoG.data1 = "1";
            messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + str + "\"}";
            messageVoG.data3 = BaseWrapper.ENTER_ID_GAME_CENTER;
            com.zenmen.palmchat.database.b.u(messageVoG, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f1 implements View.OnClickListener {
        public f1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null && i1Var.s() == 1) {
                if (!f33.i() && a66.a(InputFragment.this.m2())) {
                    InputFragment inputFragment = InputFragment.this;
                    inputFragment.I3(inputFragment.m2());
                }
                InputFragment.this.N3(true);
                return;
            }
            i1 i1Var2 = InputFragment.this.X0;
            if (i1Var2 == null || i1Var2.s() != 0) {
                return;
            }
            InputFragment.this.C.setVisibility(8);
            InputFragment.this.O3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.D3(null);
            com.zenmen.palmchat.chat.c.d(InputFragment.this.G);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements MediaPlayer.OnCompletionListener {
        public g0() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            InputFragment.this.T = false;
            InputFragment.this.R0.removeMessages(1);
            InputFragment.this.R0.sendEmptyMessageDelayed(1, 100L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g1 {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements bn4.h {
        public h() {
        }

        @Override // bn4.h
        public void a(boolean z) {
            if (InputFragment.this.getActivity() == null || InputFragment.this.getActivity().isFinishing()) {
                return;
            }
            if (InputFragment.this.getActivity() instanceof ChatterActivity) {
                ChatterActivity chatterActivity = (ChatterActivity) InputFragment.this.getActivity();
                chatterActivity.f3();
                chatterActivity.P4();
                chatterActivity.z3().G();
            } else if (InputFragment.this.getActivity() instanceof SquareTempChatActivity) {
                ((SquareTempChatActivity) InputFragment.this.getActivity()).U1();
            }
            if (z) {
                InputFragment.this.x0 = true;
                InputFragment.this.O2();
            }
        }

        @Override // bn4.h
        public void b(boolean z) {
            if (InputFragment.this.getActivity() == null || InputFragment.this.getActivity().isFinishing()) {
                return;
            }
            InputFragment.this.Q0.u(z);
            if (InputFragment.this.l2() == null || InputFragment.this.l2().a() == null) {
                return;
            }
            InputFragment.this.l2().a().l0(z);
        }

        @Override // bn4.h
        public void c(boolean z) {
            InputFragment.this.r0 = z;
            if (InputFragment.this.o0 != null) {
                InputFragment.this.o0.C(z);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 extends HashMap<String, Object> {
        public h0() {
            put("action", "send_message");
            put("status", "sendText");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h1 {
        ChatterAdapter a();

        ChatItem b();

        List<MessageVo> c();

        void d();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            o30.E(InputFragment.this.getActivity(), InputFragment.this.G);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 extends go2<LXBaseNetBean<BizpubIsShowNoticeReminderV1Result>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12625a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ q05.e d;

        public i0(String str, HashMap map, boolean z, q05.e eVar) {
            this.f12625a = str;
            this.b = map;
            this.c = z;
            this.d = eVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f12625a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<BizpubIsShowNoticeReminderV1Result> lXBaseNetBean, Exception exc) {
            BizpubIsShowNoticeReminderV1Result bizpubIsShowNoticeReminderV1Result;
            if (q05.o(InputFragment.this.getActivity())) {
                return;
            }
            if (!z || lXBaseNetBean == null || (bizpubIsShowNoticeReminderV1Result = lXBaseNetBean.data) == null || bizpubIsShowNoticeReminderV1Result.showFlag) {
                this.d.a(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i1 {
        ChatterAdapter a();

        FrameworkBaseActivity b();

        ViewGroup c();

        ViewGroup d();

        String e();

        void f();

        void g(int i);

        void h();

        View i();

        void j(ExpressionObject expressionObject);

        void k();

        fn2 l();

        ChatOneItemVo m();

        void n(boolean z);

        void o(boolean z);

        void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z);

        void p();

        void q();

        String r(String str);

        int s();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l50.a() && (InputFragment.this.getActivity() instanceof ChatterActivity)) {
                ds0.a().b(new m30(7));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j0 extends go2<LXBaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12627a;
        public final /* synthetic */ int b;

        public j0(String str, int i) {
            this.f12627a = str;
            this.b = i;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("domain", this.f12627a);
            map.put("bizType", Integer.valueOf(this.b));
            sw4 sw4VarB = sw4.b(1, nl0.z + "/message.send.btn.monitor", map);
            sw4VarB.h = false;
            sw4VarB.g = true;
            return sw4VarB;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            LogUtil.i("reportMsgSend", "onResult=" + az2.c(lXBaseNetBean));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface j1 {
        void f(InputItemManager.InputItemType inputItemType, com.zenmen.palmchat.chat.b bVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputFragment.this.a1.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k0 extends MaterialDialog.e {
        public k0() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k1 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<InputFragment> f12630a;

        public k1(InputFragment inputFragment) {
            this.f12630a = new WeakReference<>(inputFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (this.f12630a.get() != null) {
                    int i2 = message.arg1;
                    Editable text = this.f12630a.get().i.getText();
                    for (int i3 = i2 - 1; i3 >= 0; i3--) {
                        if (i3 < text.length() && text.charAt(i3) == "@".charAt(0)) {
                            try {
                                text.delete(i3, i2);
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (i == 1) {
                if (this.f12630a.get() == null || this.f12630a.get().V0 != 0) {
                    return;
                }
                this.f12630a.get().Z3();
                this.f12630a.get().V3(true);
                this.f12630a.get().g2();
                return;
            }
            if (i != 2) {
                if (i == 3 && this.f12630a.get() != null) {
                    this.f12630a.get().o.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f12630a.get() == null || this.f12630a.get().X0 == null || this.f12630a.get().X0.s() == 1) {
                return;
            }
            this.f12630a.get().i.requestFocus();
            KeyboardKt.d(this.f12630a.get().i, this.f12630a.get().J, Keyboard$SHOW_FLAG.DEFAULT, 0L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputFragment.this.J0.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l0 implements a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12632a;
        public final /* synthetic */ boolean b;

        public l0(String str, boolean z) {
            this.f12632a = str;
            this.b = z;
        }

        @Override // com.zenmen.palmchat.chat.pay.a.c
        public void a(boolean z) {
            if (z) {
                InputFragment.this.j3(this.f12632a, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends TimerTask {
        public m() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InputFragment inputFragment = InputFragment.this;
            inputFragment.G0--;
            if (InputFragment.this.G0 < 0 || InputFragment.this.H0 == null || InputFragment.this.H0.getVisibility() != 0) {
                return;
            }
            int i = InputFragment.this.G0 / 60;
            int i2 = InputFragment.this.G0 - (i * 60);
            String str = i + "";
            if (i < 10) {
                str = "0" + i;
            }
            String str2 = i2 + "";
            if (i2 < 10) {
                str2 = "0" + i2;
            }
            InputFragment.this.P2(str + ":" + str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ lb3 f12634a;

        public m0(lb3 lb3Var) {
            this.f12634a = lb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iB = this.f12634a.b();
            String strA = this.f12634a.a();
            if ((iB == 1 || iB == 2) && InputFragment.this.l0 != null) {
                InputFragment.this.l0.e = true;
                InputFragment.this.l0.d = true;
                if ("scene_voice_video_call".equals(strA) || "scene_chatter_venus".equals(strA)) {
                    return;
                }
                InputFragment.this.l0.g(InputFragment.this.G.getBizType(), InputFragment.this.g, false, InputFragment.this.t0, InputFragment.this.u0, InputFragment.this.G);
                InputFragment.this.l0.B(InputFragment.this.getActivity());
                if (!TextUtils.isEmpty(InputFragment.this.i.getText().toString())) {
                    InputFragment.this.g.performClick();
                } else if (InputFragment.this.l0 != null) {
                    InputFragment.this.l0.y(InputFragment.this.G, InputFragment.this.g, InputFragment.this.t0, InputFragment.this.u0, false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12635a;

        public n(String str) {
            this.f12635a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InputFragment.this.M0 != null) {
                InputFragment.this.M0.setText(this.f12635a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fa2 f12636a;

        public n0(fa2 fa2Var) {
            this.f12636a = fa2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            fa2 fa2Var = this.f12636a;
            int i = fa2Var.f17491a;
            if (1 == i) {
                bn4.m(InputFragment.this.getActivity(), InputFragment.this.G.getBizType(), fa2Var.d);
            } else if (2 == i) {
                int i2 = fa2Var.b;
                int i3 = fa2Var.c;
                InputFragment inputFragment = InputFragment.this;
                GiftMessageHelper.z0(inputFragment, inputFragment.G, i2, i3);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.J0.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o0 implements Runnable {
        public o0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InputFragment.this.Q0 != null) {
                InputFragment.this.Q0.q();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            InputFragment.this.B0.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p0 extends HashMap<String, Object> {
        public p0() {
            put("action", "send_message");
            put("status", "sendText");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o30.m(InputFragment.this.getActivity(), InputFragment.this.P0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q0 implements View.OnTouchListener {
        public q0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            i1 i1Var;
            if (com.zenmen.palmchat.videocall.c.f()) {
                return true;
            }
            if (motionEvent.getAction() == 0 && (i1Var = InputFragment.this.X0) != null && i1Var.b() != null) {
                if (!fu2.g(InputFragment.this.X0.b(), InputItemManager.InputItemType.INPUT_ITEM_AUDIO)) {
                    return true;
                }
                FrameworkBaseActivity frameworkBaseActivityB = InputFragment.this.X0.b();
                BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.RECORD_AUDIO;
                if (!tg4.b(frameworkBaseActivityB, permissionType.permissionList)) {
                    BaseActivityPermissionDispatcher.b(InputFragment.this.X0.b(), permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_AUDIO);
                    return true;
                }
                InputFragment.this.X0.onPermissionGrant(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_AUDIO, false);
            }
            if (motionEvent.getAction() == 0 && InputFragment.this.V0 == -1) {
                if (!l50.a()) {
                    i1 i1Var2 = InputFragment.this.X0;
                    if (i1Var2 != null) {
                        i1Var2.p();
                    }
                    InputFragment.this.V0 = 0;
                    InputFragment.this.c3(true);
                    InputFragment.this.W0 = motionEvent.getY();
                    InputFragment.this.r.setBackgroundResource(R.drawable.shape_voice_record_button_background_pressed);
                    InputFragment.this.r.setText(R.string.voice_record_finish);
                    InputFragment.this.Z3();
                    vk3.c(InputFragment.this.getActivity(), "sound/qrcode_completed.mp3", false, InputFragment.this.S0);
                }
            } else if (motionEvent.getAction() == 2 && InputFragment.this.V0 == 0) {
                if (motionEvent.getY() - InputFragment.this.W0 < -260.0f) {
                    InputFragment.this.r.setText(R.string.voice_swipe_to_cancel_confirm);
                    InputFragment.this.s.setText(R.string.voice_swipe_to_cancel_confirm);
                    InputFragment.this.s.setBackgroundResource(R.drawable.shape_voice_recorder_cancel_message_background);
                    InputFragment.this.v.setVisibility(8);
                    InputFragment.this.w.setVisibility(0);
                    InputFragment.this.y.setVisibility(8);
                    InputFragment.this.V3(false);
                } else {
                    InputFragment.this.r.setText(R.string.voice_record_finish);
                    long jH0 = 60000 - AudioController.b0().h0(InputFragment.this.T);
                    if (jH0 < 9000) {
                        InputFragment.this.s.setText(InputFragment.this.getString(R.string.record_remain_time, Integer.valueOf(Math.round(jH0 / 1000.0f))));
                    } else {
                        InputFragment.this.s.setText(R.string.voice_swipe_to_cancel);
                    }
                    InputFragment.this.s.setBackgroundDrawable(null);
                    InputFragment.this.x.setVisibility(8);
                    InputFragment.this.v.setVisibility(0);
                    InputFragment.this.w.setVisibility(8);
                    InputFragment.this.y.setVisibility(0);
                    InputFragment.this.V3(true);
                }
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && InputFragment.this.V0 == 0) {
                InputFragment.this.V0 = -1;
                float y = motionEvent.getY();
                boolean z = AudioController.b0().h0(InputFragment.this.T) <= 1000;
                if (z || !InputFragment.this.T) {
                    InputFragment.this.v.setVisibility(8);
                    InputFragment.this.w.setVisibility(8);
                    InputFragment.this.y.setVisibility(8);
                    InputFragment.this.V3(false);
                    InputFragment.this.x.setVisibility(0);
                    InputFragment.this.s.setText(R.string.voice_short_cancel);
                    InputFragment.this.R0.sendEmptyMessageDelayed(3, 400L);
                } else {
                    InputFragment.this.o.setVisibility(8);
                    InputFragment.this.x.setVisibility(8);
                    InputFragment.this.v.setVisibility(0);
                    InputFragment.this.w.setVisibility(8);
                    InputFragment.this.y.setVisibility(0);
                    InputFragment.this.V3(true);
                }
                InputFragment.this.r.setBackgroundResource(R.drawable.shape_voice_record_button_background);
                InputFragment.this.r.setText(R.string.voice_record);
                InputFragment.this.s.setBackgroundDrawable(null);
                if (y - InputFragment.this.W0 < -260.0f || z || !InputFragment.this.T || AudioController.b0().e0() == null) {
                    InputFragment.this.c3(false);
                    InputFragment.this.M3(false);
                } else {
                    InputFragment.this.M3(true);
                }
            }
            view.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends TimerTask {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InputFragment.this.B0.setVisibility(8);
            }
        }

        public r() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (InputFragment.this.B0 == null || InputFragment.this.B0.getVisibility() != 0) {
                return;
            }
            InputFragment.this.B0.post(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r0 implements Runnable {
        public r0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputFragment.this.D3(null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements a.j {
        public s() {
        }

        @Override // com.zenmen.palmchat.chat.aigreeting.a.j
        public void a(String str) {
            InputFragment.this.Q0.B(false);
            InputFragment.this.h3(str, true);
        }

        @Override // com.zenmen.palmchat.chat.aigreeting.a.j
        public void b(String str) {
            InputFragment.this.Q0.B(false);
            InputFragment.this.i.setText(str);
            InputFragment.this.i.setSelection(str.length());
            KeyboardKt.d(InputFragment.this.i, InputFragment.this.J, Keyboard$SHOW_FLAG.DEFAULT, 0L);
        }

        @Override // com.zenmen.palmchat.chat.aigreeting.a.j
        public void c(boolean z) {
            if (!z) {
                InputFragment.this.n3();
                return;
            }
            i1 i1Var = InputFragment.this.X0;
            if (i1Var != null) {
                i1Var.p();
            }
            if (InputFragment.this.l.getVisibility() == 8) {
                if (InputFragment.this.getActivity() != null && InputFragment.this.getActivity().getWindow() != null) {
                    InputFragment.this.getActivity().getWindow().setSoftInputMode(32);
                }
                Log.i(InputFragment.c1, "SOFT_INPUT_ADJUST_PAN");
                if (InputFragment.this.N == 0) {
                    InputFragment.this.O = false;
                    InputFragment.this.J.hideSoftInputFromWindow(InputFragment.this.i.getWindowToken(), 0);
                }
                InputFragment.this.l.setVisibility(0);
                InputFragment.this.T1();
                InputFragment.this.N3(false);
            } else if (((InputFragment.this.m.getVisibility() != 0 && InputFragment.this.B.getVisibility() != 0) || InputFragment.this.N == 0) && InputFragment.this.N == 0) {
                InputFragment.this.O = false;
                InputFragment.this.J.hideSoftInputFromWindow(InputFragment.this.i.getWindowToken(), 0);
            }
            InputFragment.this.B.setVisibility(8);
            InputFragment.this.m.setVisibility(8);
            InputFragment.this.A.setSelected(false);
            InputFragment.this.A.setImageResource(R.drawable.selector_background_input_face_button);
            InputFragment.this.h.setImageResource(R.drawable.selector_background_input_add_button);
            g1 g1Var = InputFragment.this.Z0;
            if (g1Var != null) {
                g1Var.a(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ im f12647a;

        public s0(im imVar) {
            this.f12647a = imVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(InputFragment.c1, "volume " + this.f12647a.a());
            if (this.f12647a.a() > 0.1d) {
                InputFragment.this.T = true;
            }
            InputFragment.this.J3(this.f12647a.a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements a.l {
        public t() {
        }

        @Override // com.zenmen.palmchat.chat.aigreeting.a.l
        public void a(boolean z) {
            if (z) {
                InputFragment.this.i.setPadding(me1.b(InputFragment.this.getContext(), 16), me1.b(InputFragment.this.getContext(), 1), me1.b(InputFragment.this.getContext(), 36), me1.b(InputFragment.this.getContext(), 1));
            } else {
                InputFragment.this.i.setPadding(me1.b(InputFragment.this.getContext(), 16), me1.b(InputFragment.this.getContext(), 1), me1.b(InputFragment.this.getContext(), 16), me1.b(InputFragment.this.getContext(), 1));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t0 implements Runnable {
        public t0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputFragment.this.c2(10);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12650a;
        public final /* synthetic */ View b;

        public u(View view, View view2) {
            this.f12650a = view;
            this.b = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.s2(this.f12650a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PayChatEvent f12651a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.InterfaceC1055a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MessageVo f12652a;

            public a(MessageVo messageVo) {
                this.f12652a = messageVo;
            }

            @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
            public void a(boolean z) {
                i1 i1Var;
                if (!z || this.f12652a.mimeType != 1 || (i1Var = InputFragment.this.X0) == null || i1Var.l() == null) {
                    return;
                }
                try {
                    String strE = DomainHelper.e(InputFragment.this.G);
                    fn2 fn2VarL = InputFragment.this.X0.l();
                    MessageVo messageVo = this.f12652a;
                    fn2VarL.r(MessageVo.buildTextMessage(messageVo.mid, strE, messageVo.text, (String[]) null, 1, messageVo.time).setSendNetStatus(this.f12652a.data9).setThreadBizType(InputFragment.this.getContext(), InputFragment.this.S));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        public u0(PayChatEvent payChatEvent) {
            this.f12651a = payChatEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2 = InputFragment.c1;
            StringBuilder sb = new StringBuilder();
            sb.append("onPayChatEvent to=");
            MessageVo messageVo = this.f12651a.messageVo;
            sb.append(messageVo != null ? messageVo.to : null);
            LogUtil.i(str2, sb.toString());
            MessageVo messageVo2 = this.f12651a.messageVo;
            if (InputFragment.this.G == null || messageVo2 == null || (str = messageVo2.to) == null || !str.equals(InputFragment.this.G.getChatId())) {
                return;
            }
            com.zenmen.palmchat.chat.pay.a.c().f(InputFragment.this.getContext(), InputFragment.this.G, -1L, new a(messageVo2));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements Runnable {
        public v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputFragment.this.a1.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v0 implements Runnable {
        public v0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputFragment.this.o.setVisibility(8);
            InputFragment.this.x.setVisibility(8);
            InputFragment.this.v.setVisibility(0);
            InputFragment.this.w.setVisibility(8);
            InputFragment.this.y.setVisibility(0);
            InputFragment.this.V3(true);
            InputFragment.this.r.setBackgroundResource(R.drawable.shape_voice_record_button_background);
            InputFragment.this.r.setText(R.string.voice_record);
            InputFragment.this.s.setBackgroundDrawable(null);
            InputFragment.this.M3(false);
            wg4.a(InputFragment.this.getActivity()).c(false, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12655a;
        public final /* synthetic */ View b;

        public w(View view, View view2) {
            this.f12655a = view;
            this.b = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.s2(this.f12655a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w0 extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12656a;

        public w0(long j, long j2) {
            super(j, j2);
            this.f12656a = false;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (InputFragment.this.V0 == 0) {
                InputFragment.this.o.setVisibility(8);
                InputFragment.this.x.setVisibility(8);
                InputFragment.this.v.setVisibility(0);
                InputFragment.this.w.setVisibility(8);
                InputFragment.this.y.setVisibility(0);
                InputFragment.this.V3(true);
                InputFragment.this.r.setBackgroundResource(R.drawable.shape_voice_record_button_background);
                InputFragment.this.r.setText(R.string.voice_record);
                InputFragment.this.s.setBackgroundDrawable(null);
                InputFragment.this.V0 = -1;
                InputFragment.this.c3(false);
            }
            InputFragment.this.M3(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (j <= 9000) {
                if (!this.f12656a) {
                    ((Vibrator) AppContext.getContext().getSystemService("vibrator")).vibrate(new long[]{0, 50, 200, 50}, -1);
                    this.f12656a = true;
                }
                if (InputFragment.this.s.getBackground() == null && InputFragment.this.isAdded()) {
                    InputFragment.this.s.setText(InputFragment.this.getString(R.string.record_remain_time, Integer.valueOf(Math.round(j / 1000.0f))));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12657a;
        public final /* synthetic */ View b;

        public x(View view, View view2) {
            this.f12657a = view;
            this.b = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.s2(this.f12657a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x0 extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLinkBean f12658a;

        public x0(ShareLinkBean shareLinkBean) {
            this.f12658a = shareLinkBean;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InputFragment.this.n2(this.f12658a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12659a;
        public final /* synthetic */ View b;

        public y(View view, View view2) {
            this.f12659a = view;
            this.b = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputFragment.this.s2(this.f12659a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements up4.c {
        public z() {
        }

        @Override // up4.c
        public void a(String str) {
            InputFragment.this.k3(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(GiftSendResultEvent giftSendResultEvent) {
        iq4 iq4Var = this.o0;
        if (iq4Var != null) {
            iq4Var.B(giftSendResultEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(ChatGiftMessageExtensionBean chatGiftMessageExtensionBean, ContactInfoItem contactInfoItem, fb2 fb2Var) {
        GiftReceiverInfo giftReceiverInfo;
        GiftPlayVo giftPlayVo = new GiftPlayVo();
        giftPlayVo.itemId = chatGiftMessageExtensionBean.itemId;
        giftPlayVo.relatedId = chatGiftMessageExtensionBean.relatedId;
        giftPlayVo.itemName = chatGiftMessageExtensionBean.itemName;
        giftPlayVo.iconUrl = chatGiftMessageExtensionBean.iconUrl;
        giftPlayVo.showIconUrl = chatGiftMessageExtensionBean.showIconUrl;
        giftPlayVo.itemCount = chatGiftMessageExtensionBean.itemCount;
        giftPlayVo.fromUserId = contactInfoItem.getChatId();
        giftPlayVo.fromUserName = contactInfoItem.getChatName();
        giftPlayVo.fromUserAvatarUrl = contactInfoItem.getIconURL();
        giftPlayVo.toUserId = this.G.getChatId();
        giftPlayVo.toUserName = this.G.getChatName();
        giftPlayVo.toUserAvatarUrl = this.G.getIconURL();
        if (this.G.getChatType() == 1 && (giftReceiverInfo = chatGiftMessageExtensionBean.toUser) != null) {
            if (!fb2Var.b) {
                giftPlayVo.fromUserId = giftReceiverInfo.uid;
                giftPlayVo.fromUserName = giftReceiverInfo.nickname;
                giftPlayVo.fromUserAvatarUrl = giftReceiverInfo.headIconUrl;
            }
            giftPlayVo.relatedId = chatGiftMessageExtensionBean.relatedId + chatGiftMessageExtensionBean.toUser.uid;
        }
        giftPlayVo.priceLevel = chatGiftMessageExtensionBean.priceLevel;
        giftPlayVo.comboNumber = chatGiftMessageExtensionBean.comboNumber;
        giftPlayVo.giftMessageType = fb2Var.b ? 1 : 0;
        this.p0.K(giftPlayVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(GiftMsgEvent giftMsgEvent, ChatGiftMessageExtensionBean chatGiftMessageExtensionBean) {
        for (int i2 = 0; i2 < giftMsgEvent.toUserList.size(); i2++) {
            try {
                ChatGiftMessageExtensionBean chatGiftMessageExtensionBean2 = (ChatGiftMessageExtensionBean) chatGiftMessageExtensionBean.clone();
                chatGiftMessageExtensionBean2.toUser = new GiftReceiverInfo(giftMsgEvent.toUserList.get(i2), null, null);
                ds0.a().b(new fb2(chatGiftMessageExtensionBean2, true));
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
        }
        c2(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2(ShowChatGiftPanelEvent showChatGiftPanelEvent) {
        ArrayList arrayList;
        if (showChatGiftPanelEvent.messageVo == null || showChatGiftPanelEvent.contactInfoItem == null || this.G.getChatType() != 1 || showChatGiftPanelEvent.messageVo.isSend) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(showChatGiftPanelEvent.contactInfoItem);
        }
        D3(arrayList);
    }

    public static boolean d2(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                if (!Character.isWhitespace(charSequence.charAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void A2() {
        rc0 rc0Var = new rc0(this.f);
        this.X = rc0Var;
        rc0Var.c(this.G);
        ChatItem chatItem = this.G;
        if (chatItem != null) {
            boolean z2 = true;
            if (chatItem.getChatType() == 1 && ((GroupInfoItem) this.G).getMerchantType() == 1) {
                GroupVersionConfig config = GroupVersionConfig.getConfig();
                rc0 rc0Var2 = this.X;
                if (config != null && !config.isShowCircleRedPacket()) {
                    z2 = false;
                }
                rc0Var2.e(z2);
            }
        }
    }

    public final void A3() {
        i1 i1Var = this.X0;
        if (i1Var == null || i1Var.i() == null) {
            return;
        }
        View viewI = this.X0.i();
        if (this.H) {
            this.s = (TextView) viewI.findViewById(R.id.voice_recorder_message2);
            this.o = viewI.findViewById(R.id.recorder_layout2);
            this.v = (ImageView) viewI.findViewById(R.id.recoder_icon2);
            this.w = (ImageView) viewI.findViewById(R.id.recoder_cancel_icon2);
            this.x = (ImageView) viewI.findViewById(R.id.recoder_short_icon2);
            this.y = (ImageView) viewI.findViewById(R.id.volume_icon2);
            this.z = (ImageView) viewI.findViewById(R.id.volume_fake_img);
        } else {
            this.s = (TextView) viewI.findViewById(R.id.voice_recorder_message);
            this.o = viewI.findViewById(R.id.recorder_layout);
            this.v = (ImageView) viewI.findViewById(R.id.recoder_icon);
            this.w = (ImageView) viewI.findViewById(R.id.recoder_cancel_icon);
            this.x = (ImageView) viewI.findViewById(R.id.recoder_short_icon);
            this.y = (ImageView) viewI.findViewById(R.id.volume_icon);
        }
        this.x.setVisibility(8);
        this.w.setVisibility(8);
        this.y.setVisibility(0);
        this.y.setImageResource(R.drawable.volume_drawable);
        this.r.setOnTouchListener(new q0());
    }

    public final void B2() {
        View viewFindViewById = this.f.findViewById(R.id.layout_gift_quick_input_root);
        i1 i1Var = this.X0;
        this.o0 = new iq4(viewFindViewById, i1Var != null ? i1Var.i() : null);
        G3();
        this.n0 = new n20();
    }

    public void B3(int i2) {
        this.X.d(i2);
    }

    public final void C2() {
        i1 i1Var;
        if (this.p0 != null || (i1Var = this.X0) == null || i1Var.d() == null || this.X0.c() == null) {
            return;
        }
        this.p0 = new wb2(getActivity(), GiftBizType.Chat, this.X0.d(), this.X0.c());
    }

    public void C3() {
        View view = this.f;
        if (view != null) {
            this.g0 = false;
            view.findViewById(R.id.layout_header_add_panel).setVisibility(this.g0 ? 8 : 0);
            View view2 = this.e0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.Z;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View viewFindViewById = this.f.findViewById(R.id.switch_edit_layout);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            View view4 = this.k;
            if (view4 != null) {
                ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMargins(0, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                }
            }
        }
    }

    public final void D2() {
        View view;
        ImageView imageView;
        View view2;
        ImageView imageView2;
        int i2;
        this.f.findViewById(R.id.layout_header_add_panel).setVisibility(this.g0 ? 8 : 0);
        View viewFindViewById = this.f.findViewById(R.id.layout_panel_one);
        View viewFindViewById2 = this.f.findViewById(R.id.layout_panel_two);
        View viewFindViewById3 = this.f.findViewById(R.id.layout_panel_three);
        View viewFindViewById4 = this.f.findViewById(R.id.layout_panel_four);
        ImageView imageView3 = (ImageView) this.f.findViewById(R.id.iv_panel_one);
        ImageView imageView4 = (ImageView) this.f.findViewById(R.id.iv_panel_two);
        ImageView imageView5 = (ImageView) this.f.findViewById(R.id.iv_panel_three);
        ImageView imageView6 = (ImageView) this.f.findViewById(R.id.iv_panel_four);
        View viewFindViewById5 = this.f.findViewById(R.id.red_dot_one);
        View viewFindViewById6 = this.f.findViewById(R.id.red_dot_two);
        View viewFindViewById7 = this.f.findViewById(R.id.red_dot_three);
        View viewFindViewById8 = this.f.findViewById(R.id.red_dot_four);
        viewFindViewById.setOnClickListener(new u(viewFindViewById5, viewFindViewById));
        viewFindViewById2.setOnClickListener(new w(viewFindViewById6, viewFindViewById2));
        viewFindViewById3.setOnClickListener(new x(viewFindViewById7, viewFindViewById3));
        viewFindViewById4.setOnClickListener(new y(viewFindViewById8, viewFindViewById4));
        ArrayList arrayList = new ArrayList();
        ChatItem chatItem = this.G;
        if (chatItem == null || chatItem.getChatType() != 0) {
            ChatItem chatItem2 = this.G;
            if (chatItem2 != null && chatItem2.getChatType() == 1) {
                int iMin = Math.min(4, InputItemManager.d());
                int i3 = 0;
                while (i3 < iMin) {
                    int i4 = iMin;
                    View view3 = viewFindViewById8;
                    ImageView imageView7 = imageView6;
                    if (vs0.a().e("isGroupGiftEnable", false) && i3 == 1) {
                        arrayList.add(InputItemManager.InputItemType.INPUT_ITEM_GIFT);
                        this.s0 = true;
                    } else if (i3 == 3) {
                        arrayList.add(InputItemManager.InputItemType.INPUT_ITEM_CAMERA);
                    } else {
                        arrayList.add(InputItemManager.e(i3));
                    }
                    i3++;
                    iMin = i4;
                    viewFindViewById8 = view3;
                    imageView6 = imageView7;
                }
            }
        } else {
            int i5 = 0;
            for (int iMin2 = Math.min(3, InputItemManager.d()); i5 < iMin2; iMin2 = iMin2) {
                arrayList.add(InputItemManager.e(i5));
                i5++;
            }
            arrayList.add(InputItemManager.InputItemType.INPUT_ITEM_GIFT);
        }
        ImageView imageView8 = imageView6;
        View view4 = viewFindViewById8;
        if (arrayList.size() > 0) {
            int i6 = 0;
            while (i6 < arrayList.size()) {
                InputItemManager.InputItemType inputItemType = (InputItemManager.InputItemType) arrayList.get(i6);
                InputItemManager.b(inputItemType);
                int iB = com.zenmen.palmchat.chat.c.b(inputItemType);
                boolean zE = com.zenmen.palmchat.chat.c.e(inputItemType);
                if (i6 == 0) {
                    viewFindViewById.setTag(inputItemType);
                    viewFindViewById.setVisibility(0);
                    imageView3.setImageResource(iB);
                    viewFindViewById5.setVisibility(zE ? 0 : 8);
                    view = viewFindViewById;
                    imageView = imageView3;
                    view2 = view4;
                    imageView2 = imageView8;
                } else {
                    view = viewFindViewById;
                    imageView = imageView3;
                    if (i6 == 1) {
                        viewFindViewById2.setTag(inputItemType);
                        viewFindViewById2.setVisibility(0);
                        imageView4.setImageResource(iB);
                        viewFindViewById6.setVisibility(zE ? 0 : 8);
                    } else if (i6 == 2) {
                        viewFindViewById3.setTag(inputItemType);
                        viewFindViewById3.setVisibility(0);
                        imageView5.setImageResource(iB);
                        viewFindViewById7.setVisibility(zE ? 0 : 8);
                    } else if (i6 == 3) {
                        viewFindViewById4.setTag(inputItemType);
                        viewFindViewById4.setVisibility(0);
                        imageView2 = imageView8;
                        imageView2.setImageResource(iB);
                        if (zE) {
                            view2 = view4;
                            i2 = 0;
                        } else {
                            view2 = view4;
                            i2 = 8;
                        }
                        view2.setVisibility(i2);
                    } else {
                        view2 = view4;
                        imageView2 = imageView8;
                    }
                    view2 = view4;
                    imageView2 = imageView8;
                }
                i6++;
                imageView8 = imageView2;
                view4 = view2;
                viewFindViewById = view;
                imageView3 = imageView;
            }
        }
        if (a65.c(this.G)) {
            viewFindViewById3.setVisibility(8);
            viewFindViewById4.setVisibility(8);
        }
    }

    public void D3(List<ContactInfoItem> list) {
        ChatItem chatItem;
        if (v8.h() && (chatItem = this.G) != null && v8.C(chatItem.getChatId())) {
            sy5.h(getContext(), "该用户暂不支持收礼", 0);
        } else {
            E3(list, 1);
        }
    }

    public final void E2() {
        View viewFindViewById;
        ChatItem chatItem = this.G;
        if (chatItem == null || chatItem.getChatType() != 0 || (viewFindViewById = this.f.findViewById(R.id.layout_chat_quick_input_root)) == null) {
            return;
        }
        this.q0 = new up4(viewFindViewById, this.G, new z());
    }

    public void E3(List<ContactInfoItem> list, int i2) {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                n20 n20Var = this.n0;
                ChatItem chatItem = this.G;
                n20Var.o(this, chatItem, list, i2, gu2.c(chatItem), 0);
                this.l.setVisibility(8);
                this.h.setImageResource(R.drawable.selector_background_input_add_button);
                if (this.N == 0) {
                    this.O = false;
                    this.J.hideSoftInputFromWindow(this.i.getWindowToken(), 0);
                } else {
                    g1 g1Var = this.Z0;
                    if (g1Var != null) {
                        g1Var.a(true);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void F2(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message", "");
        contentValues.put("data1", (Integer) 1);
        contentValues.put("data2", Y1());
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
        contentValues.put("msg_type", (Integer) 10000);
        contentValues.put("type", (Integer) 1);
        contentValues.put("packet_id", xn3.a());
        contentValues.put("contact_relate", str);
        contentValues.put("msg_extend", str);
        contentValues.put("read", (Integer) 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message_values", contentValues);
        getActivity().getContentResolver().call(DBUriManager.b(ho3.class, this.G), "insertRawMessage", DBUriManager.b(ho3.class, this.G).toString(), bundle);
    }

    public final void F3() {
        View view = this.e0;
        if (view != null) {
            view.postDelayed(new a0(), 1000L);
        }
    }

    public final void G2(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message", "");
        contentValues.put("data1", (Integer) 1);
        contentValues.put("data2", Z1());
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
        contentValues.put("msg_type", (Integer) 10000);
        contentValues.put("type", (Integer) 1);
        contentValues.put("packet_id", xn3.a());
        contentValues.put("contact_relate", str);
        contentValues.put("msg_extend", str);
        contentValues.put("read", (Integer) 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message_values", contentValues);
        getActivity().getContentResolver().call(DBUriManager.b(ho3.class, this.G), "insertRawMessage", DBUriManager.b(ho3.class, this.G).toString(), bundle);
    }

    public final void G3() {
        ChatItem chatItem = this.G;
        if (chatItem == null || chatItem.getChatType() != 0 || a65.c(this.G)) {
            return;
        }
        HashMap map = new HashMap();
        int bizType = this.G.getBizType();
        String str = DomainHelper.m(this.G).domain;
        map.put("domain", str);
        if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && fu5.q(bizType)) {
            map.put("bizType", Integer.valueOf(bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite));
        } else {
            map.put("bizType", Integer.valueOf(bizType));
        }
        map.put("fastlane", 1);
        this.o0.E(this.G, 301, this.G.getChatId() + str, this.G.getChatId(), new JSONObject(map).toString());
    }

    public final boolean H2() {
        return getActivity() instanceof ChatterActivity;
    }

    public void H3() {
        if (getActivity() != null) {
            getView().setVisibility(0);
        }
    }

    public boolean I2() {
        return this.l.getVisibility() == 0;
    }

    public void I3(String str) {
        ShareLinkBean shareLinkBeanD = cw.b().d(str);
        if (shareLinkBeanD != null) {
            this.U = shareLinkBeanD;
            this.C.setVisibility(0);
            gr2.j().h(shareLinkBeanD.getIcon(), this.t, bq6.l());
            this.p.setText(shareLinkBeanD.getTitle());
            this.q.setText(shareLinkBeanD.getOriginUrl());
            return;
        }
        this.C.setVisibility(8);
        ShareLinkBean shareLinkBean = new ShareLinkBean();
        shareLinkBean.setOriginUrl(str);
        shareLinkBean.setUrl(str);
        AsyncTask asyncTask = this.R;
        if (asyncTask == null) {
            n2(shareLinkBean);
            return;
        }
        asyncTask.f(true);
        new Timer().schedule(new x0(shareLinkBean), 1000L);
    }

    public final void J3(float f2) {
        double d2 = f2;
        if (d2 < 0.1d) {
            this.y.getDrawable().setLevel(0);
            return;
        }
        if (d2 < 0.2d) {
            this.y.getDrawable().setLevel(1);
            return;
        }
        if (d2 < 0.3d) {
            this.y.getDrawable().setLevel(2);
            return;
        }
        if (d2 < 0.4d) {
            this.y.getDrawable().setLevel(3);
        } else if (d2 < 0.5d) {
            this.y.getDrawable().setLevel(4);
        } else {
            this.y.getDrawable().setLevel(5);
        }
    }

    public void K3(boolean z2) {
        rc0 rc0Var = this.X;
        if (rc0Var != null) {
            rc0Var.e(z2);
        }
    }

    public final void L3() {
        Timer timer = new Timer();
        this.O0 = timer;
        timer.schedule(new m(), 1000L);
    }

    public final void M3(boolean z2) {
        LogUtil.d(c1, "cancelRecord " + this);
        w3(true);
        try {
            J3(0.0f);
            CountDownTimer countDownTimer = this.M;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.M = null;
            }
            AudioController.b0().H0(z2, this.S);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N2(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < str.length() && (iIndexOf = str.indexOf("[", i2)) >= 0) {
                int iIndexOf2 = str.indexOf("]", iIndexOf);
                if (iIndexOf2 != -1 && vl1.a(str.substring(iIndexOf, iIndexOf2 + 1))) {
                    z2 = true;
                    break;
                }
                i2 = iIndexOf + 1;
            } else {
                break;
            }
        }
        if (z2) {
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME100", "1", null, null);
        }
    }

    public final void N3(boolean z2) {
        i1 i1Var = this.X0;
        if (i1Var != null) {
            i1Var.g(0);
        }
        this.n.setImageResource(R.drawable.selector_speaker);
        this.r.setVisibility(8);
        this.k.setVisibility(0);
        i1 i1Var2 = this.X0;
        if (i1Var2 != null) {
            i1Var2.p();
        }
        if (z2) {
            this.j.setVisibility(8);
            KeyboardKt.d(this.i, this.J, Keyboard$SHOW_FLAG.DEFAULT, 0L);
            if (this.i.getText().length() > 0) {
                this.g.setVisibility(0);
                bn4 bn4Var = this.l0;
                if (bn4Var != null) {
                    bn4Var.g(this.G.getBizType(), this.g, true, this.t0, this.u0, this.G);
                }
            }
        }
    }

    public final void O2() {
        ChatItem chatItem;
        boolean z2 = getActivity() instanceof ChatterActivity;
        if ((!z2 || this.y0) && this.x0 && (chatItem = this.G) != null && chatItem.getChatType() == 0 && !a65.e(this.G)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("report_type", "view");
                jSONObject.put("from", fu5.k(this.G.getBizType()).domain);
                jSONObject.put("fuid", this.G.getChatId());
                if (fu5.q(this.G.getBizType())) {
                    jSONObject.put("bizType", this.G.getBizType() + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
                }
                jSONObject.put("chat_charge_status", (R2() || this.z0) ? 1 : 0);
                if (5016 == this.G.getBizType()) {
                    jSONObject.put("bstype", 2);
                } else if (5012 == this.G.getBizType()) {
                    jSONObject.put("bstype", 1);
                }
                ChatItem chatItem2 = this.G;
                if (chatItem2 != null && !TextUtils.isEmpty(chatItem2.getChatId())) {
                    jSONObject.put("target_uid", this.G.getChatId());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (z2) {
                zn6.d("pagechat", null, jSONObject.toString());
            } else {
                zn6.d("pagechat_half", null, jSONObject.toString());
            }
        }
    }

    public final void O3() {
        this.g.setVisibility(8);
        bn4 bn4Var = this.l0;
        if (bn4Var != null) {
            bn4Var.g(this.G.getBizType(), this.g, false, this.t0, this.u0, this.G);
        }
        i1 i1Var = this.X0;
        if (i1Var != null) {
            i1Var.g(1);
        }
        this.n.setImageResource(R.drawable.selector_keyboard);
        this.r.setVisibility(0);
        this.k.setVisibility(8);
        n3();
    }

    public final void P2(String str) {
        TextView textView = this.M0;
        if (textView != null) {
            textView.post(new n(str));
            L3();
        }
    }

    public void P3(boolean z2) {
        ChatItem chatItem;
        if (!z2) {
            r75.p(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 0);
        }
        if (v8.h() && (chatItem = this.G) != null && v8.C(chatItem.getChatId())) {
            sy5.h(getContext(), "该用户暂不支持音视频聊天", 0);
            return;
        }
        if (!fu2.e(getActivity(), InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL)) {
            ap3.z(AppContext.getContext(), z2 ? BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP : "47", "1", "scene_voice_video_call");
            return;
        }
        i1 i1Var = this.X0;
        if (i1Var == null || i1Var.b() == null) {
            return;
        }
        com.zenmen.palmchat.videocall.b bVar = new com.zenmen.palmchat.videocall.b(this.X0.b(), this.G, new d1());
        bVar.g(z2);
        bVar.h();
    }

    public boolean Q2() {
        bn4 bn4Var = this.l0;
        return bn4Var != null && bn4Var.v();
    }

    public void Q3() {
        P3(true);
    }

    public boolean R2() {
        bn4 bn4Var = this.l0;
        return bn4Var != null && bn4Var.w();
    }

    public final int R3() {
        if (getActivity() == null) {
            return 0;
        }
        int iD = g03.d();
        int dimension = (iD - (((int) getActivity().getResources().getDimension(R.dimen.add_panel_item_height)) * 2)) / 3;
        int i2 = iD - dimension;
        int dimension2 = i2 != 0 ? (i2 - (((int) getActivity().getResources().getDimension(R.dimen.add_panel_item_height)) * 2)) / 4 : 0;
        int i3 = dimension / 2;
        this.m.setPadding(me1.b(getActivity(), 10), i3, me1.b(getActivity(), 10), i3);
        return me1.j(getActivity(), dimension2);
    }

    public void S1(String str) {
        this.P.add(str);
    }

    public void S2() {
        LogUtil.d("", "newMatePeopleJoin start mateType " + this.F0);
        View view = this.J0;
        if (view != null && this.F0 == 1 && view.getVisibility() == 8) {
            this.J0.setVisibility(0);
            this.J0.postDelayed(new l(), 3000L);
        }
    }

    public final void S3() {
        com.zenmen.palmchat.chat.aigreeting.a aVar = new com.zenmen.palmchat.chat.aigreeting.a(getActivity(), this.l, this.f.findViewById(R.id.ai_enter_layout), this.f.findViewById(R.id.layout_ai_greeting_input_root), this.a1, new s());
        this.Q0 = aVar;
        aVar.C(this.G, new t());
    }

    public final void T1() {
        g03.a(this.l, g03.e(AppContext.getContext()));
        this.Q.l();
    }

    public void T2() {
        this.T = false;
        if (this.V0 == 0) {
            this.o.setVisibility(8);
            this.x.setVisibility(8);
            this.v.setVisibility(0);
            this.w.setVisibility(8);
            this.y.setVisibility(0);
            V3(true);
            this.r.setBackgroundResource(R.drawable.shape_voice_record_button_background);
            this.r.setText(R.string.voice_record);
            this.s.setBackgroundDrawable(null);
            this.V0 = -1;
            c3(false);
            M3(true);
        }
    }

    public void T3(ChatItem chatItem) {
        U3(chatItem, false);
    }

    public void U1(q05.e<Boolean> eVar) {
        zw4.e(new i0(q05.c() + "/bizpub.is.show.notice.reminder.v1", new HashMap(), false, eVar));
    }

    public void U2() {
        LXRTCModule.startSingleCall(getActivity(), this.G, false);
    }

    public void U3(ChatItem chatItem, boolean z2) {
        boolean z3 = true;
        if (z2) {
            ChatItem chatItem2 = this.G;
            if (!(chatItem2 instanceof ContactInfoItem) || ((ContactInfoItem) chatItem2).getGender() != -1) {
                z3 = false;
            }
        }
        if (z3) {
            this.G = chatItem;
        }
    }

    public void V1(String str) {
        W1(str, true);
    }

    public void V2(ChatMateActivityStatusData chatMateActivityStatusData) {
        if (!H2() || chatMateActivityStatusData == null) {
            return;
        }
        this.F0 = chatMateActivityStatusData.type;
        z2();
        this.H0.setVisibility(0);
        int i2 = (int) (chatMateActivityStatusData.remainingTime / 1000.0f);
        this.G0 = i2;
        if (i2 > 0) {
            Timer timer = this.O0;
            if (timer != null) {
                timer.cancel();
                this.O0 = null;
            }
            L3();
        }
        int i3 = this.F0;
        if (i3 == 1) {
            this.K0.setVisibility(0);
            this.L0.setVisibility(8);
        } else if (i3 == 2) {
            this.K0.setVisibility(8);
            this.L0.setVisibility(0);
        }
        u3(chatMateActivityStatusData.joinChatSize);
        this.N0.setOnClickListener(new i());
        ChatItem chatItem = this.G;
        if (!(chatItem instanceof ContactInfoItem)) {
            this.I0.setText("礼物送她");
        } else if (((ContactInfoItem) chatItem).getGender() == 0) {
            this.I0.setText("礼物送他");
        }
        this.I0.setOnClickListener(new j());
    }

    public final void V3(boolean z2) {
        ImageView imageView;
        if (!this.H || (imageView = this.z) == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) this.z.getDrawable();
        if (animationDrawable != null) {
            if (z2) {
                animationDrawable.start();
            } else {
                animationDrawable.stop();
            }
        }
    }

    public void W1(String str, boolean z2) {
        X1(str, z2, 0L);
    }

    public void W2() {
        Intent intent = new Intent(getActivity(), (Class<?>) LocationSelectActivityV2.class);
        intent.putExtra("chat_item", this.G);
        intent.putExtra("thread_biz_type", this.S);
        getActivity().startActivity(intent);
    }

    public void W3() {
        com.zenmen.palmchat.chat.b bVar = this.Y;
        if (bVar != null) {
            bVar.i();
        }
    }

    public void X1(String str, boolean z2, long j2) {
        Editable editableText = this.i.getEditableText();
        EditText editText = this.i;
        if (editText == null || editableText == null || str == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0 || selectionStart > selectionEnd) {
            selectionStart = editText.getText().length();
            selectionEnd = selectionStart;
        }
        int length = this.i.getText().length();
        editableText.replace(selectionStart, selectionEnd, str);
        editText.setText(vl1.c(editableText.toString(), getActivity(), vl1.f));
        int length2 = str.length();
        if (length + length2 > 6000) {
            length2 = 6000 - length;
        }
        editText.setSelection(selectionStart + length2);
        this.i.requestFocus();
        this.j.setVisibility(8);
        if (z2) {
            KeyboardKt.d(this.i, this.J, Keyboard$SHOW_FLAG.DEFAULT, j2);
        }
    }

    public void X3() {
        View view;
        if (this.E != null) {
            this.F.setVisibility(0);
            this.E.setBackgroundColor(getResources().getColor(R.color.Ab));
            this.g.setBackground(getResources().getDrawable(R.drawable.selector_btn_send));
            this.A.setImageTintList(null);
            this.A0.setImageDrawable(getResources().getDrawable(R.drawable.ic_chat_bottom_gift_new));
            this.i.setBackground(getResources().getDrawable(R.drawable.shape_add_area_edit));
            if (TextUtils.isEmpty(this.h0)) {
                this.i.setHint(R.string.chat_input_hint_txt);
            } else {
                this.i.setHint(this.h0);
            }
            this.i.setTextColor(getResources().getColor(R.color.Gb));
            G3();
            iq4 iq4Var = this.o0;
            if (iq4Var == null || (view = iq4Var.b) == null) {
                return;
            }
            view.setBackground(getContext().getDrawable(R.drawable.shape_gift_quick_fade_bg));
        }
    }

    public final String Y1() {
        String string = getActivity().getString(R.string.oppo_auto_run_permission_notification);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionTypes", "activity");
            jSONObject.put("actionBody", string);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final void Y2(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.U0) {
            this.U0 = false;
            i1 i1Var = this.X0;
            if (i1Var != null) {
                i1Var.q();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (i4 > 0) {
                Z2(true);
            }
        } else {
            int length = charSequence.length();
            if (i4 == 0 && length == i3) {
                Z2(false);
            } else {
                Z2(true);
            }
        }
    }

    public void Y3(String str, boolean z2) {
        EditText editText;
        if (TextUtils.isEmpty(str) || (editText = this.i) == null) {
            return;
        }
        editText.setText(vl1.c(str, getActivity(), vl1.f));
        this.i.setSelection(str.length());
        if (z2) {
            this.i.selectAll();
        }
        this.j.setVisibility(8);
        this.R0.removeMessages(2);
        this.R0.sendEmptyMessageDelayed(2, 400L);
    }

    public final String Z1() {
        String string = getActivity().getString(R.string.oppo_permission_notification);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionTypes", "activity");
            jSONObject.put("actionBody", string);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final void Z2(boolean z2) {
        LogUtil.i("ChatInputStatusHelper", "inputfragment onTextingStatusChange " + z2);
        i1 i1Var = this.X0;
        if (i1Var != null) {
            i1Var.n(z2);
        }
    }

    public final void Z3() {
        this.x.setVisibility(8);
        this.s.setText(R.string.voice_swipe_to_cancel);
        this.R0.removeMessages(3);
        this.o.setVisibility(0);
        this.s.setBackgroundDrawable(null);
        this.v.setVisibility(0);
        this.w.setVisibility(8);
        this.y.setVisibility(0);
    }

    @Override // defpackage.w8
    public void a(String str) {
        h3(str, true);
        l2().a().a(str);
    }

    public void a2(boolean z2) {
        View view;
        View view2 = this.E0;
        if (view2 != null) {
            if (z2) {
                view2.setVisibility(8);
            } else {
                view2.setVisibility(0);
            }
        }
        if (z2 || (view = this.H0) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void a3() {
        LXRTCModule.startSingleCall(getActivity(), this.G, true);
    }

    public final boolean b2() {
        return true;
    }

    public void b3() {
        tk3.e(getActivity(), 0, 106);
    }

    public final boolean c2(int i2) {
        if (this.F.getVisibility() == 0 && this.B0.getVisibility() != 0) {
            boolean zP = o30.p(i2, this.G.getChatId());
            String str = c1;
            LogUtil.d(str, "saveSendGiftUid checkShowMateGuide type " + i2 + " result " + zP);
            if (zP) {
                int i3 = o30.c;
                ArrayList<String> arrayList = o30.d;
                if (i2 == 8) {
                    i3 = o30.f;
                    arrayList = o30.g;
                } else if (i2 == 10) {
                    i3 = o30.v;
                    arrayList = o30.w;
                }
                this.C0.setText(Html.fromHtml(arrayList.size() > 0 ? arrayList.get(new Random().nextInt(arrayList.size())) : "<p>礼物不够多？试试最佳聊友，高价值礼物聊天就可抢！<span style=\"color: #14CD64\">点击试试> </span></p>"));
                this.B0.setVisibility(0);
                this.P0 = i2;
                o30.i("view", i2);
                if (i2 == 10) {
                    SPUtil.f14322a.s(SPUtil.SCENE.CHATMATE, "KEY_CHATMATE_SEND_GIFT_UIDS");
                    LogUtil.d(str, "saveSendGiftUid removeWithUid KEY_CHATMATE_SEND_GIFT_UIDS type " + i2);
                }
                if (i3 <= 0) {
                    return true;
                }
                new Timer().schedule(new r(), i3 * 1000);
                return true;
            }
        }
        return false;
    }

    public final void c3(boolean z2) {
        LogUtil.i("ChatInputStatusHelper", "inputfragment onVoiceRecordingStatusChange " + z2);
        i1 i1Var = this.X0;
        if (i1Var != null) {
            i1Var.o(z2);
        }
    }

    @qm5
    public void chatMateEvent(m30 m30Var) {
        if (m30Var != null) {
            LogUtil.d(c1, "saveSendGiftUid inputFragment chatMateEvent type " + m30Var.b);
            if (m30Var.b == 4) {
                u93.c(new t0());
            }
        }
    }

    @qm5
    public void chatMateGiftEvent(n30 n30Var) {
        if (n30Var == null || n30Var.f19427a != n30.b) {
            return;
        }
        c2(8);
    }

    public void d3(BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_IMAGE) {
            Intent intent = new Intent(getActivity(), (Class<?>) MediaPickActivity.class);
            intent.putExtra("chat_item", this.G);
            intent.putExtra("select_mode_key", 0);
            intent.putExtra("thread_biz_type", this.S);
            intent.putExtra("from", "from_chat");
            getActivity().startActivityForResult(intent, 105);
            return;
        }
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_FILE && b2()) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) FileSelectActivity.class);
            intent2.putExtra("chat_item", this.G);
            intent2.putExtra("thread_biz_type", this.S);
            getActivity().startActivity(intent2);
        }
    }

    public void e2() {
        int selectionStart;
        if (TextUtils.isEmpty(this.i.getText()) || (selectionStart = this.i.getSelectionStart()) <= 0) {
            return;
        }
        String strSubstring = this.i.getText().toString().substring(0, selectionStart);
        int iLastIndexOf = strSubstring.lastIndexOf("[");
        if (iLastIndexOf == -1) {
            this.i.getEditableText().delete(selectionStart - 1, selectionStart);
        } else if (vl1.a(strSubstring.substring(iLastIndexOf, selectionStart).toString())) {
            this.i.getEditableText().delete(iLastIndexOf, selectionStart);
        } else {
            this.i.getEditableText().delete(selectionStart - 1, selectionStart);
        }
    }

    public void e3() {
        EditText editText = this.i;
        if (editText == null) {
            return;
        }
        editText.postDelayed(new b0(), 250L);
    }

    public final void f2() {
        this.G0 = 0;
        this.M0 = null;
        Timer timer = this.O0;
        if (timer != null) {
            timer.cancel();
            this.O0 = null;
        }
    }

    public final void f3() {
        try {
            String strA = xn3.a();
            ChatItem chatItem = this.G;
            if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatId())) {
                this.V = MessageVo.buildLinkMessage(strA, DomainHelper.e(this.G), this.U.getTitle(), this.U.getOriginUrl(), this.U.getOriginUrl(), this.U.getIcon(), null, 0).setThreadBizType(getActivity(), this.S);
                i1 i1Var = this.X0;
                if (i1Var != null && i1Var.l() != null) {
                    this.X0.l().r(this.V);
                }
                this.P.clear();
                this.i.setText("");
                cw.b().a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(c1, 3, new p0(), e2);
        }
    }

    public void g0(MessageVo messageVo, String str, QuickSendVo quickSendVo) {
        if (!TextUtils.isEmpty(str)) {
            g3(str);
        } else if (quickSendVo != null) {
            this.o0.s(quickSendVo);
        }
    }

    public final boolean g2() {
        LogUtil.d(c1, "doRecordAudio " + this);
        w3(false);
        String strE = DomainHelper.e(this.G);
        i1 i1Var = this.X0;
        if (i1Var != null && i1Var.l() != null) {
            AudioController.b0().C0(strE, this.X0.l());
        }
        w0 w0Var = new w0(60000L, 100L);
        this.M = w0Var;
        w0Var.start();
        return true;
    }

    public void g3(String str) {
        h3(str, false);
    }

    public final void h2() {
        i1 i1Var = this.X0;
        if (i1Var != null) {
            i1Var.h();
        }
    }

    public void h3(String str, boolean z2) {
        ChatItem chatItem = this.G;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        bn4 bn4Var = this.l0;
        com.zenmen.palmchat.chat.pay.a.c().b(getContext(), bn4Var != null ? bn4Var.j() : null, this.G, new l0(str, z2));
    }

    public final ContactInfoItem i2(String str) {
        if (this.G.getChatType() == 0) {
            return (ContactInfoItem) this.G;
        }
        if (TextUtils.isEmpty(str)) {
            return new ContactInfoItem();
        }
        HashMap<String, ContactInfoItem> map = this.v0;
        ContactInfoItem contactInfoItem = map != null ? map.get(str) : null;
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        if (contactInfoItem != null) {
            if (contactInfoItemL != null && contactInfoItemL.getIconURL() != null) {
                contactInfoItem.setIconURL(contactInfoItemL.getIconURL());
            }
        } else {
            if (contactInfoItemL != null) {
                return contactInfoItemL;
            }
            contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(str);
        }
        return contactInfoItem;
    }

    public final void i3(String str, boolean z2, int i2) throws RemoteException {
        d0 d0Var = new d0(z2, str);
        if (i2 > 0) {
            u93.b(i2, d0Var);
        } else {
            d0Var.run();
        }
    }

    public final List<ContactInfoItem> j2(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(i2(it.next()));
        }
        return arrayList;
    }

    public final void j3(String str, boolean z2) {
        if (getActivity() instanceof ChatterActivity) {
            ChatterActivity chatterActivity = (ChatterActivity) getActivity();
            if (!com.zenmen.palmchat.miniwidget.a.f().c(chatterActivity, 2)) {
                xg5.e().b(chatterActivity, this.G, new e0(chatterActivity));
            }
        }
        up4 up4Var = this.q0;
        if (up4Var != null && up4Var.g()) {
            b05.a("showGiftQuickSender()");
            G3();
        }
        String strE = DomainHelper.e(this.G);
        if (!this.P.isEmpty() && !this.P.contains(CircleConfig.VALUE_REMIND_ALL_OF_PERSON)) {
            HashSet hashSet = new HashSet();
            for (String str2 : this.P) {
                i1 i1Var = this.X0;
                if (i1Var != null) {
                    String strR = i1Var.r(str2);
                    if (TextUtils.isEmpty(strR) || !str.contains("@" + strR + " ")) {
                        hashSet.add(str2);
                    }
                }
            }
            this.P.removeAll(hashSet);
        }
        try {
            i1 i1Var2 = this.X0;
            if (i1Var2 != null) {
                i1Var2.k();
            }
        } catch (Exception unused) {
        }
        try {
            i1 i1Var3 = this.X0;
            if (i1Var3 != null && i1Var3.l() != null) {
                ChatOneItemVo chatOneItemVoM = this.X0.m();
                if (chatOneItemVoM != null) {
                    w30.f().l(chatOneItemVoM);
                    if (x30.d(chatOneItemVoM, this.G.getChatId())) {
                        x30.f(chatOneItemVoM, this.G.getChatId());
                        this.X0.l().r(x30.a(this.G, chatOneItemVoM).setThreadBizType(getActivity(), this.S));
                    }
                }
                String strE2 = this.X0.e();
                if (mi5.p(strE2, this.G.getChatId(), true)) {
                    this.X0.l().r(mi5.n(this.G, strE2).setThreadBizType(getActivity(), this.S));
                } else {
                    MessageVo messageVo = this.w0;
                    if (messageVo != null) {
                        ef2.f(messageVo);
                    }
                }
                l3(str, z2);
                this.w0 = null;
                bn4 bn4Var = this.l0;
                if (bn4Var != null && !bn4Var.v()) {
                    GiftMessageHelper.V(this.G);
                }
                uk4.f(this.G);
                if (this.G.getChatType() == 0 && SAppUtil.c.d() && (getActivity() instanceof ChatterActivity) && s34.c() == 0) {
                    if (!((Boolean) q05.k("KEY_SHOW_LAST_CHAT_USER_ID" + this.G.getChatId(), Boolean.FALSE)).booleanValue() && Math.abs(((Long) q05.k("KEY_SHOW_LAST_CHAT_GUIDE_TIME", 0L)).longValue() - ir5.b()) > 86400000 && SAppUtil.c.d()) {
                        if (vp3.e()) {
                            U1(new f0());
                        } else {
                            q05.w("KEY_SHOW_LAST_CHAT_USER_ID" + this.G.getChatId(), Boolean.TRUE);
                            q05.w("KEY_SHOW_LAST_CHAT_GUIDE_TIME", Long.valueOf(ir5.b()));
                            String str3 = "您未开启消息通知，容易错过重要消息 <a href='zenxin://activity?page=a0641&toUid=" + this.G.getChatId() + "'>立即开启</a>";
                            MessageVo messageVoG = defpackage.u0.g(this.G);
                            messageVoG.status = 2;
                            messageVoG.mimeType = 10000;
                            messageVoG.data1 = "1";
                            messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + str3 + "\"}";
                            messageVoG.data3 = BaseWrapper.ENTER_ID_GAME_CENTER;
                            com.zenmen.palmchat.database.b.u(messageVoG, false);
                        }
                    }
                }
            }
            this.P.clear();
            this.U0 = true;
            this.i.setText("");
            gu2.e(this.G, "1".equals(str) ? IntimacyChatTextGuideVo.TYPE_GIFT : IntimacyChatTextGuideVo.TYPE_TEXT);
            if (this.G.getChatType() != 1 && j94.d()) {
                if (VideoCallActivity.e1) {
                    F2(strE);
                    VideoCallActivity.e1 = false;
                }
                if (r75.d(getActivity(), "is_first_message", true)) {
                    G2(strE);
                    r75.o(getActivity(), "is_first_message", false);
                }
            }
            N2(str);
        } catch (DeadObjectException e2) {
            e2.printStackTrace();
            HashMap map = new HashMap();
            map.put("action", "sendText");
            map.put("status", "DeadObjectException");
            LogUtil.i(c1, LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map, e2);
        } catch (Exception e3) {
            e3.printStackTrace();
            LogUtil.i(c1, 3, new h0(), e3);
        }
        bn4 bn4Var2 = this.l0;
        if (bn4Var2 != null && bn4Var2.x(this.G.getBizType())) {
            this.l0.g(this.G.getBizType(), this.g, false, this.t0, this.u0, this.G);
            this.l0.f = false;
        }
        m3();
    }

    public ArrayList<ExpressionObject> k2() {
        com.zenmen.palmchat.expression.a aVar = this.Q;
        if (aVar != null) {
            return aVar.g();
        }
        return null;
    }

    public void k3(String str) {
        ChatItem chatItem = this.G;
        if (chatItem != null && chatItem.getChatId() != null && v8.C(this.G.getChatId()) && TeenagersModeManager.a().d()) {
            sy5.h(getActivity(), "青少年模式已开启，不能发消息给AI虚拟人哦~", 0);
            return;
        }
        bn4 bn4Var = this.l0;
        if (bn4Var != null && bn4Var.u(this.G.getBizType())) {
            bn4.m(getActivity(), this.G.getBizType(), -1);
            this.l0.h(this.G.getBizType(), this.t0, this.u0);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            new sd3(getActivity()).T(R.string.update_install_dialog_title).j(R.string.dialog_content_input_send_empty).O(R.string.dialog_confirm).f(new k0()).e().show();
            return;
        }
        bn4 bn4Var2 = this.l0;
        if (bn4Var2 == null || !bn4Var2.t(this.G.getBizType())) {
            g3(str);
            return;
        }
        this.l0.A(getActivity(), this.G.getBizType(), this.G);
        this.i.setText("");
        n3();
    }

    @Override // defpackage.w8
    public void l() {
        int iE = b9.d().e();
        if (iE > 0 || iE == -999) {
            l2().a().l();
        } else {
            this.Q0.x(new k());
        }
    }

    public i1 l2() {
        return this.X0;
    }

    public final void l3(String str, boolean z2) throws RemoteException {
        List arrayList = new ArrayList();
        if (z2 && str != null && str.contains("||")) {
            arrayList = Arrays.asList(str.split("\\|\\|"));
        } else {
            arrayList.add(str);
        }
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                i3((String) arrayList.get(i2), z2, i2 * 500);
            }
        }
    }

    public String m2() {
        return this.i.getText().toString();
    }

    public final void m3() {
        String str = DomainHelper.m(this.G).domain;
        int bizType = this.G.getBizType();
        if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && fu5.q(bizType)) {
            bizType += AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite;
        }
        zw4.e(new j0(str, bizType));
    }

    public final void n2(ShareLinkBean shareLinkBean) {
        this.R = com.zenmen.palmchat.route.share.a.c(shareLinkBean, new y0());
    }

    public void n3() {
        this.A.setSelected(false);
        this.A.setImageResource(R.drawable.selector_background_input_face_button);
        this.h.setImageResource(R.drawable.selector_background_input_add_button);
        com.zenmen.palmchat.chat.aigreeting.a aVar = this.Q0;
        if (aVar != null) {
            aVar.n();
        }
        this.l.setVisibility(8);
        g1 g1Var = this.Z0;
        if (g1Var != null) {
            g1Var.a(false);
        }
        this.J.hideSoftInputFromWindow(this.i.getWindowToken(), 0);
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(16);
        }
        Log.i(c1, "SOFT_INPUT_ADJUST_RESIZE");
    }

    public final String o2() {
        bn4 bn4Var = this.l0;
        if (bn4Var == null || !bn4Var.x(this.G.getBizType())) {
            return "";
        }
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.superGreetingsVo = new SuperGreetingsVo(true);
        return az2.c(richMsgVo);
    }

    public void o3(int i2) {
        this.u0 = i2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        i1 i1Var = this.X0;
        if (i1Var != null) {
            if (i1Var.s() == 1) {
                O3();
            } else if (this.X0.s() == 0) {
                N3(false);
            }
        }
        C2();
        if (a65.c(this.G)) {
            this.q0.f21265a.setVisibility(8);
            yz2.e(this.G);
        }
    }

    @qm5
    public void onAiGreetingQuickRequestFailEvent(d9 d9Var) {
        if (d9Var == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        u93.c(new o0());
    }

    @qm5
    public void onAudioRecordError(kk kkVar) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new v0());
        }
    }

    @qm5
    public void onAudioVolumeChanged(im imVar) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new s0(imVar));
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mt2.a(getActivity(), this);
        AudioController.b0().Z().j(this);
        ds0.a().c(this);
        this.W = System.currentTimeMillis();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.J = (InputMethodManager) getActivity().getSystemService("input_method");
        this.f = layoutInflater.inflate(R.layout.layout_fragment_input, (ViewGroup) null);
        this.G = (ChatItem) getArguments().getParcelable(com.umeng.analytics.pro.f.K);
        this.I = getArguments().getString("hoc_category_id");
        this.H = getArguments().getBoolean("useNewAudioUi", true);
        this.f0 = getArguments().getBoolean("extra_key_enable_gift", false);
        this.g0 = getArguments().getBoolean("extra_key_hide_header_add_panel", false);
        this.h0 = getArguments().getString("extra_key_hint_text", "");
        this.i0 = getArguments().getString("EXTRA_INPUT_TEXT", "");
        this.j0 = getArguments().getBoolean("extra_key_auto_show_keyboard", false);
        this.k0 = getArguments().getBoolean("extra_key_from_report", false);
        this.m0 = getArguments().getString("extra_key_impr_id");
        this.E0 = this.f.findViewById(R.id.root_layout_normal_view);
        String string = getArguments().getString("chat_draft");
        String string2 = getArguments().getString("draft_remind_uids");
        if (!TextUtils.isEmpty(string2)) {
            try {
                JSONArray jSONArray = new JSONArray(string2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.P.add(jSONArray.getString(i2));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.E = (LinearLayout) this.f.findViewById(R.id.root_layout);
        this.F = (LinearLayout) this.f.findViewById(R.id.root_layout_view);
        this.C = (LinearLayout) this.f.findViewById(R.id.urlLayout);
        this.t = (ImageView) this.f.findViewById(R.id.url_image);
        this.u = (ImageView) this.f.findViewById(R.id.url_cancle);
        this.p = (TextView) this.f.findViewById(R.id.url_title);
        this.q = (TextView) this.f.findViewById(R.id.url_content);
        this.u.setOnClickListener(new e1());
        this.g = (TextView) this.f.findViewById(R.id.send_button);
        this.r = (TextView) this.f.findViewById(R.id.voice_record_button);
        A3();
        ImageView imageView = (ImageView) this.f.findViewById(R.id.edit_button);
        this.n = imageView;
        imageView.setOnClickListener(new f1());
        this.k = this.f.findViewById(R.id.input_area);
        this.l = this.f.findViewById(R.id.add_area);
        g03.a(this.l, g03.e(getActivity()));
        LinearLayout linearLayout = (LinearLayout) this.f.findViewById(R.id.faceLayout);
        this.B = linearLayout;
        this.Q = new com.zenmen.palmchat.expression.a(linearLayout, this, this.T0, false, fu5.u(this.G));
        ImageView imageView2 = (ImageView) this.f.findViewById(R.id.add_button);
        this.h = imageView2;
        imageView2.setOnClickListener(new a());
        this.A = (ImageView) this.f.findViewById(R.id.face);
        ChatterActivity.P1 = r75.g(getActivity(), k86.a("last_expression_item"), 0);
        this.A.setOnClickListener(new b());
        this.g.setOnClickListener(new c());
        this.i = (EditText) this.f.findViewById(R.id.edit_message_area);
        if (!TextUtils.isEmpty(this.h0)) {
            this.i.setHint(this.h0);
        }
        if (!TextUtils.isEmpty(this.i0)) {
            this.i.setText(this.i0);
            this.g.setVisibility(0);
        }
        this.j = this.f.findViewById(R.id.message_hide);
        Y3(string, false);
        this.i.setOnClickListener(new d());
        this.i.addTextChangedListener(new e());
        this.A0 = (ImageView) this.f.findViewById(R.id.gift_icon);
        View viewFindViewById = this.f.findViewById(R.id.gift_btn_layout);
        this.Z = viewFindViewById;
        viewFindViewById.setVisibility((this.f0 && ha3.a()) ? 0 : 8);
        this.Z.setOnClickListener(new f());
        this.e0 = this.f.findViewById(R.id.gift_temp_layout);
        if (fu5.p(this.G.getBizType())) {
            this.e0.setVisibility(0);
            F3();
        } else {
            this.e0.setVisibility(8);
        }
        this.e0.setOnClickListener(new g());
        B2();
        E2();
        x2();
        n3();
        A2();
        y2();
        if (fu5.u(this.G)) {
            w2();
        }
        if (this.j0) {
            e3();
        }
        S3();
        bn4 bn4Var = new bn4(getActivity(), this.G, this.m0, new h());
        this.l0 = bn4Var;
        if (!this.k0) {
            bn4Var.y(this.G, this.g, this.t0, this.u0, true);
        }
        UserProfileGuide.h(this.G.getChatId(), this.G, getActivity());
        C2();
        LogUtil.d("SuperExposeMsgTab", "InputFragment onCreateView msgTadItem " + this.L);
        if (this.L == 1) {
            fo5.f(this.G.getChatId(), this.G, getActivity());
        }
        X3();
        return this.f;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.w0 = null;
        AudioController.b0().Z().l(this);
        ds0.a().d(this);
        wb2 wb2Var = this.p0;
        if (wb2Var != null) {
            wb2Var.Q();
        }
        if (H2()) {
            f2();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        PopupWindow popupWindow = this.K;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.K.dismiss();
        }
        k1 k1Var = this.R0;
        if (k1Var != null) {
            k1Var.removeCallbacksAndMessages(null);
        }
        AsyncTask asyncTask = this.R;
        if (asyncTask != null) {
            asyncTask.f(true);
        }
        super.onDestroyView();
    }

    @qm5
    public void onGiftSendResultEvent(final GiftSendResultEvent giftSendResultEvent) {
        boolean z2;
        if (giftSendResultEvent.sceneType == 2 && getActivity().isFinishing()) {
            LogUtil.d("", "doRechargew onGiftSendResultEvent error canEvent false");
            z2 = false;
        } else {
            z2 = true;
        }
        View view = this.f;
        if (view == null || !z2) {
            return;
        }
        view.post(new Runnable() { // from class: jt2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18496a.J2(giftSendResultEvent);
            }
        });
    }

    @qm5
    public void onPayChatEvent(PayChatEvent payChatEvent) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new u0(payChatEvent));
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.f;
        if (view != null) {
            if (b1) {
                b1 = false;
                view.postDelayed(new r0(), 600L);
            }
            this.f.postDelayed(new b1(), 2000L);
        }
        this.Q0.s();
    }

    @Override // mt2.c
    public void onSoftKeyboardStatusChanged(int i2, int i3) {
        View view;
        if (this.X0 != null) {
            Log.i(c1, i3 + ":" + this.X0.s());
        }
        if (this.m == null || (view = this.l) == null) {
            return;
        }
        if (i3 == 0 && view != null && view.getVisibility() == 0) {
            int height = this.l.getHeight();
            if (g03.g(height)) {
                g03.a(this.l, height);
            }
            if (height != g03.e(AppContext.getContext())) {
                this.Q.l();
            }
        }
        if (i2 == 0) {
            if (this.l.getVisibility() == 8) {
                this.l.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 != i3) {
                if (i4 > 0 && getActivity() != null) {
                    getActivity().getWindow().setSoftInputMode(16);
                    Log.i(c1, "SOFT_INPUT_ADJUST_RESIZE");
                }
                layoutParams.height = i3;
                this.l.setLayoutParams(layoutParams);
                this.Q.l();
                R3();
            }
            this.A.setSelected(false);
            this.A.setImageResource(R.drawable.selector_background_input_face_button);
            this.h.setImageResource(R.drawable.selector_background_input_add_button);
            g1 g1Var = this.Z0;
            if (g1Var != null) {
                g1Var.a(true);
            }
        } else {
            if (this.O) {
                this.A.setSelected(false);
                this.A.setImageResource(R.drawable.selector_background_input_face_button);
                this.h.setImageResource(R.drawable.selector_background_input_add_button);
                this.l.setVisibility(8);
                g1 g1Var2 = this.Z0;
                if (g1Var2 != null) {
                    n20 n20Var = this.n0;
                    g1Var2.a(n20Var != null && n20Var.m());
                }
                if (getActivity() != null) {
                    getActivity().getWindow().setSoftInputMode(16);
                    Log.i(c1, "SOFT_INPUT_ADJUST_RESIZE");
                }
            } else {
                this.O = true;
            }
            if (this.m.getVisibility() == 0 && this.l.getVisibility() == 0) {
                this.l.requestFocus();
                this.j.setVisibility(8);
            }
        }
        this.N = i2;
    }

    @Override // defpackage.w8
    public void p() {
        this.Q0.x(new v());
    }

    public Set<String> p2() {
        return this.P;
    }

    public void p3(ArrayList<ExpressionObject> arrayList) {
        com.zenmen.palmchat.expression.a aVar = this.Q;
        if (aVar != null) {
            aVar.j(arrayList);
        }
    }

    public HorizontalGridPager q2() {
        return this.m;
    }

    public void q3(fa3 fa3Var) {
        n20 n20Var = this.n0;
        if (n20Var != null) {
            n20Var.n(fa3Var);
        }
    }

    public boolean r2() {
        bn4 bn4Var = this.l0;
        return bn4Var != null && bn4Var.l();
    }

    public void r3(HashMap<String, ContactInfoItem> map) {
        this.v0 = map;
    }

    @qm5
    public void receivedChatFirstLoadEvent(t20 t20Var) {
        ChatItem chatItem;
        if (!ef2.g() || e20.a()) {
            return;
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        if (t20Var == null || contactInfoItemL == null || (chatItem = this.G) == null || chatItem.getChatId() == null || this.G.getChatType() != 0) {
            return;
        }
        ef2.d(this.G.getChatId(), false, contactInfoItemL.getBirthday(), new z0());
    }

    @qm5
    public void receivedGiftMsgPlayEvent(final fb2 fb2Var) {
        final ChatGiftMessageExtensionBean chatGiftMessageExtensionBean;
        final ContactInfoItem contactInfoItemL;
        if (fb2Var == null || this.f == null || this.p0 == null || (chatGiftMessageExtensionBean = fb2Var.f17496a) == null || (contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()))) == null || this.G == null) {
            return;
        }
        this.f.post(new Runnable() { // from class: kt2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18825a.K2(chatGiftMessageExtensionBean, contactInfoItemL, fb2Var);
            }
        });
    }

    @qm5
    public void receivedSendGiftMsgEvent(final GiftMsgEvent giftMsgEvent) {
        ChatItem chatItem;
        String str;
        final ChatGiftMessageExtensionBean chatGiftMessageExtensionBean;
        if (giftMsgEvent == null || this.f == null || (chatItem = this.G) == null || 301 != giftMsgEvent.panelId) {
            return;
        }
        String str2 = giftMsgEvent.roomId;
        if ((str2 != null && !str2.contains(chatItem.getChatId())) || (str = giftMsgEvent.bizData) == null || (chatGiftMessageExtensionBean = (ChatGiftMessageExtensionBean) az2.a(str, ChatGiftMessageExtensionBean.class)) == null) {
            return;
        }
        if (!TextUtils.isEmpty(giftMsgEvent.guideMid)) {
            com.zenmen.palmchat.database.b.i(giftMsgEvent.guideMid, this.G);
        }
        GiftMessageHelper.Y(giftMsgEvent.bizData, j2(giftMsgEvent.toUserList), this.G);
        this.f.post(new Runnable() { // from class: it2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18258a.L2(giftMsgEvent, chatGiftMessageExtensionBean);
            }
        });
    }

    @qm5
    public void receivedShowGiftPanelEvent(final ShowChatGiftPanelEvent showChatGiftPanelEvent) {
        View view;
        if (showChatGiftPanelEvent == null || (view = this.f) == null) {
            return;
        }
        view.post(new Runnable() { // from class: ht2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18046a.M2(showChatGiftPanelEvent);
            }
        });
    }

    @qm5
    public void receivedVipCheckEvent(lb3 lb3Var) {
        View view;
        if (lb3Var == null || (view = this.f) == null) {
            return;
        }
        view.post(new m0(lb3Var));
    }

    @qm5
    public void receivedVipGiftEvent(fa2 fa2Var) {
        View view;
        if (fa2Var == null || (view = this.f) == null) {
            return;
        }
        view.post(new n0(fa2Var));
    }

    public final void s2(View view, View view2) {
        if (l50.a()) {
            return;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        if (view2 != null) {
            Object tag = view2.getTag();
            j1 j1Var = this.Y0;
            if (j1Var == null || !(tag instanceof InputItemManager.InputItemType)) {
                return;
            }
            j1Var.f((InputItemManager.InputItemType) tag, this.Y);
        }
    }

    public void s3(i1 i1Var) {
        if (i1Var != null) {
            this.X0 = i1Var;
        }
    }

    public void t2() {
        n20 n20Var = this.n0;
        if (n20Var != null) {
            n20Var.i();
        }
    }

    public void t3(j1 j1Var) {
        if (j1Var != null) {
            this.Y0 = j1Var;
        }
    }

    public void u2() {
        if (getActivity() != null) {
            getView().setVisibility(8);
        }
    }

    public void u3(int i2) {
        String str = "聊下一个/" + i2 + "人";
        TextView textView = this.N0;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void v2() {
        this.i.clearFocus();
        this.J.hideSoftInputFromWindow(this.i.getWindowToken(), 0);
    }

    public void v3(g1 g1Var) {
        if (g1Var != null) {
            this.Z0 = g1Var;
        }
    }

    @Override // defpackage.w8
    public void w() {
        l2().a().w();
    }

    public final void w2() {
        View view;
        if (this.G == null || (view = this.f) == null || this.k == null) {
            return;
        }
        View viewFindViewById = view.findViewById(R.id.switch_edit_layout);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (8 == this.Z.getVisibility() && 8 == this.e0.getVisibility()) {
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(me1.b(getContext(), 15), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
        }
    }

    public final void w3(boolean z2) {
        this.g.setEnabled(z2);
        this.h.setEnabled(z2);
        this.n.setEnabled(z2);
    }

    public final void x2() {
        D2();
        this.m = (HorizontalGridPager) this.f.findViewById(R.id.add_area_grid_view);
        com.zenmen.palmchat.widget.horizontalgridpager.a aVarJ = new a.C1146a().k(2, 4).m(8, 5, 8, 5).o(7).n(R.drawable.add_area_indicator_normal, R.drawable.add_area_indicator_focus).l(17).p(InputItemManager.d() > 6).q(50).r(R3()).j();
        this.m.init(aVarJ);
        com.zenmen.palmchat.chat.b bVar = new com.zenmen.palmchat.chat.b(getActivity(), aVarJ);
        this.Y = bVar;
        this.m.setAdapter(bVar.e());
        this.Y.h(new c1());
    }

    public void x3(int i2) {
        this.t0 = i2;
    }

    public final void y2() {
        View viewFindViewById = this.f.findViewById(R.id.layout_chat_mate_guide);
        this.B0 = viewFindViewById;
        this.C0 = (TextView) viewFindViewById.findViewById(R.id.mate_guide_title);
        View viewFindViewById2 = this.B0.findViewById(R.id.guide_close);
        this.D0 = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new p());
        this.B0.setOnClickListener(new q());
    }

    public void y3(int i2) {
        this.L = i2;
    }

    public final void z2() {
        View viewFindViewById = this.f.findViewById(R.id.layout_chat_mate_activity_status);
        this.H0 = viewFindViewById;
        this.I0 = (TextView) viewFindViewById.findViewById(R.id.chat_mate_activity_status_title);
        this.K0 = this.H0.findViewById(R.id.chat_mate_activity_status_send);
        this.L0 = this.H0.findViewById(R.id.chat_mate_activity_status_receiver);
        this.J0 = this.H0.findViewById(R.id.chat_mate_send_pop_layout);
        int i2 = this.F0;
        if (i2 == 1) {
            this.M0 = (TextView) this.H0.findViewById(R.id.send_time);
        } else if (i2 == 2) {
            this.M0 = (TextView) this.H0.findViewById(R.id.receiver_time);
        }
        this.N0 = (TextView) this.H0.findViewById(R.id.btn_next);
        this.J0.setOnClickListener(new o());
    }

    public void z3(int i2) {
        this.S = i2;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d1 implements b.e {
        public d1() {
        }

        @Override // com.zenmen.palmchat.videocall.b.e
        public void onItemSelected(int i) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z0 implements ef2.b {
        public z0() {
        }

        @Override // ef2.b
        public void onSuccess(String str) {
            i1 i1Var;
            InputFragment inputFragment = InputFragment.this;
            inputFragment.w0 = ef2.c(inputFragment.G, str);
            if (InputFragment.this.w0 == null || (i1Var = InputFragment.this.X0) == null || i1Var.a() == null) {
                return;
            }
            InputFragment.this.X0.a().C(InputFragment.this.w0);
        }

        @Override // ef2.b
        public void onFail(Exception exc) {
        }
    }

    @qm5
    public void showOpenCameraFailedDialog(l84 l84Var) {
    }

    @qm5
    public void showVideoRecordFailedDialog(fd6 fd6Var) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y0 implements a.e {
        public y0() {
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void a(ShareLinkBean shareLinkBean) {
            if (TextUtils.isEmpty(shareLinkBean.getTitle()) || !shareLinkBean.getOriginUrl().equals(InputFragment.this.m2())) {
                return;
            }
            InputFragment.this.C.setVisibility(0);
            gr2.j().h(shareLinkBean.getIcon(), InputFragment.this.t, bq6.l());
            InputFragment.this.p.setText(shareLinkBean.getTitle());
            InputFragment.this.q.setText(shareLinkBean.getOriginUrl());
            cw.b().f(shareLinkBean.getOriginUrl(), shareLinkBean);
            InputFragment.this.U = shareLinkBean;
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void onStart() {
        }
    }

    public void X2() {
    }
}
