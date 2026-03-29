package com.zenmen.palmchat.chat.fragment;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.media.player.MagicVideoView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.chat.BigTextActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.ChatterMoreActionFragment;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.chat.MessageCursorLoader;
import com.zenmen.palmchat.chat.fragment.a;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoActivity;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.SelectContactActivity;
import com.zenmen.palmchat.contacts.ServiceAccountDetailActivity;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneItemVo;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.mine.view.LoopTextView;
import com.zenmen.palmchat.paidservices.readstate.guide.ReadStateGuideManager;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.task1v1.ComplianceBoardBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.UI;
import defpackage.a46;
import defpackage.a65;
import defpackage.af6;
import defpackage.b65;
import defpackage.bo0;
import defpackage.by5;
import defpackage.c9;
import defpackage.ch;
import defpackage.d65;
import defpackage.f46;
import defpackage.fg6;
import defpackage.fn0;
import defpackage.fn2;
import defpackage.fu2;
import defpackage.fu5;
import defpackage.g20;
import defpackage.h13;
import defpackage.h20;
import defpackage.ha3;
import defpackage.ho0;
import defpackage.i20;
import defpackage.ir5;
import defpackage.iv0;
import defpackage.jo6;
import defpackage.k86;
import defpackage.m66;
import defpackage.nl0;
import defpackage.nn0;
import defpackage.nx3;
import defpackage.oc0;
import defpackage.pa6;
import defpackage.pp3;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.qq2;
import defpackage.r30;
import defpackage.sd3;
import defpackage.tk3;
import defpackage.u93;
import defpackage.uj0;
import defpackage.uk5;
import defpackage.v10;
import defpackage.ve;
import defpackage.xn3;
import defpackage.y56;
import defpackage.zn6;
import defpackage.zy4;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SimpleChatFragment extends BaseFragment {
    public static final String f0 = "SimpleChatFragment";
    public static int g0;
    public static Field h0;
    public static Method i0;
    public View A;
    public InputFragment B;
    public g20 C;
    public h20 E;
    public ChatterMoreActionFragment H;
    public com.zenmen.palmchat.chat.fragment.c J;
    public LinearLayout K;
    public View L;
    public View M;
    public LoopTextView N;
    public com.zenmen.palmchat.chat.fragment.a O;
    public String P;
    public boolean T;
    public c9 U;
    public v e0;
    public r30 h;
    public com.zenmen.palmchat.chat.c j;
    public ChatItem k;
    public String q;
    public String r;
    public String s;
    public String t;
    public boolean u;
    public ListView v;
    public View w;
    public ProgressBar x;
    public ChatterAdapter y;
    public TextView z;
    public final boolean f = AudioController.N0();
    public MessageCursorLoader.b g = null;
    public boolean i = false;
    public int l = 0;
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public HashMap<ChatterActivity.LongClickMenuItem, String> F = null;
    public MaterialDialog G = null;
    public i20 I = new i20(this);
    public int Q = -1;
    public int R = -1;
    public int S = 0;
    public BroadcastReceiver V = new s();
    public a.l W = new t();
    public InputFragment.i1 X = new d();
    public InputFragment.j1 Y = new e();
    public u Z = new u();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements af6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12778a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ RichMsgExItemVo c;

        public b(ChatItem chatItem, MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
            this.f12778a = chatItem;
            this.b = messageVo;
            this.c = richMsgExItemVo;
        }

        @Override // af6.b
        public void onFinish(boolean z) {
            if (z) {
                SmallVideoEntranceController.n(SimpleChatFragment.this.getActivity(), this.f12778a, this.b, this.c);
            } else {
                b65.c();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12779a;

        public c(MessageVo messageVo) {
            this.f12779a = messageVo;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            oc0.g("lx_group_message_chehui_dailog_show_click_cancle");
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            oc0.g("lx_group_message_chehui_dailog_show_click_sure");
            SimpleChatFragment.this.J.q(this.f12779a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements InputFragment.j1 {
        public e() {
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.j1
        public void f(InputItemManager.InputItemType inputItemType, com.zenmen.palmchat.chat.b bVar) {
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_IMAGE) {
                if (fu2.g(SimpleChatFragment.this.e0.b(), inputItemType)) {
                    LogUtil.onClickEvent("V32", null, null);
                    BaseActivityPermissionDispatcher.b(SimpleChatFragment.this.e0.b(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_IMAGE);
                    return;
                }
                return;
            }
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_FILE) {
                if (fu2.g(SimpleChatFragment.this.e0.b(), inputItemType)) {
                    BaseActivityPermissionDispatcher.b(SimpleChatFragment.this.e0.b(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_FILE);
                    return;
                }
                return;
            }
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_LOCATION) {
                BaseActivityPermissionDispatcher.b(SimpleChatFragment.this.e0.b(), BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_LOCATION);
                return;
            }
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_REDPACKET || inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VOUCHER) {
                return;
            }
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_CAMERA) {
                if (fu2.g(SimpleChatFragment.this.e0.b(), inputItemType)) {
                    if (nx3.a("key_new_camera")) {
                        nx3.e("key_new_camera");
                        if (bVar != null) {
                            bVar.g();
                        }
                    }
                    if (com.zenmen.palmchat.videocall.c.f()) {
                        return;
                    }
                    LogUtil.onClickEvent("V31", null, null);
                    BaseActivityPermissionDispatcher.b(SimpleChatFragment.this.e0.b(), BaseActivityPermissionDispatcher.PermissionType.CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_VIDEO);
                    return;
                }
                return;
            }
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD) {
                if (nx3.a("key_name_card")) {
                    nx3.e("key_name_card");
                    if (bVar != null) {
                        bVar.g();
                    }
                }
                Intent intent = new Intent(SimpleChatFragment.this.e0.b(), (Class<?>) SelectContactActivity.class);
                intent.putExtra("extra_from", 0);
                intent.putExtra("current_chat_id", SimpleChatFragment.this.k.getChatId());
                intent.putExtra("thread_biz_type", SimpleChatFragment.this.l);
                SimpleChatFragment.this.startActivityForResult(intent, 104);
                return;
            }
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_BIG_TEXT) {
                Intent intent2 = new Intent(SimpleChatFragment.this.e0.b(), (Class<?>) BigTextActivity.class);
                intent2.putExtra("chat_item", SimpleChatFragment.this.k);
                intent2.putExtra("thread_biz_type", SimpleChatFragment.this.l);
                SimpleChatFragment.this.startActivityForResult(intent2, 105);
                return;
            }
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_SIGHT) {
                if (com.zenmen.palmchat.videocall.c.f() || SimpleChatFragment.this.B == null) {
                    return;
                }
                SimpleChatFragment.this.B.getClass();
                return;
            }
            if (inputItemType != InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
                if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL || inputItemType == InputItemManager.InputItemType.INPUT_ITEM_TRANSFER || inputItemType != InputItemManager.InputItemType.INPUT_ITEM_GIFT) {
                    return;
                }
                if (nx3.a("key_new_gift_panel")) {
                    nx3.e("key_new_gift_panel");
                }
                if (SimpleChatFragment.this.B != null) {
                    SimpleChatFragment.this.B.D3(null);
                }
                com.zenmen.palmchat.chat.c.d(SimpleChatFragment.this.k);
                return;
            }
            if (com.zenmen.palmchat.videocall.c.f()) {
                return;
            }
            if (!com.zenmen.palmchat.videocall.c.e()) {
                Toast.makeText(SimpleChatFragment.this.getActivity(), R.string.service_not_available, 0).show();
                return;
            }
            if (nx3.a("key_video_call")) {
                nx3.e("key_video_call");
                if (bVar != null) {
                    bVar.g();
                }
            }
            if (SimpleChatFragment.this.B != null) {
                SimpleChatFragment.this.B.P3(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInfoItem contactInfoItemL;
            if (SimpleChatFragment.this.k.getChatType() == 0 && (contactInfoItemL = bo0.r().l(SimpleChatFragment.this.k.getChatId())) != null) {
                SimpleChatFragment.this.P1(contactInfoItemL);
                SimpleChatFragment.this.y.w0(SimpleChatFragment.this.k);
            }
            if (SimpleChatFragment.this.O != null) {
                SimpleChatFragment.this.O.D();
            }
            SimpleChatFragment.this.y.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f12783a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "send_message");
                put("status", "fail");
                put("detail", "sendNameCard");
            }
        }

        public g(ContactInfoItem contactInfoItem) {
            this.f12783a = contactInfoItem;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (SimpleChatFragment.this.k == null || TextUtils.isEmpty(SimpleChatFragment.this.k.getChatId())) {
                return;
            }
            try {
                String strE = DomainHelper.e(SimpleChatFragment.this.k);
                SimpleChatFragment.this.D1();
                SimpleChatFragment.this.J.h().r(MessageVo.buildNameCardMessage(xn3.a(), strE, this.f12783a, 0, ir5.b()).setThreadBizType(AppContext.getContext(), SimpleChatFragment.this.l));
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.i(SimpleChatFragment.f0, 3, new a(), e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageCursorLoader f12785a;

        public h(MessageCursorLoader messageCursorLoader) {
            this.f12785a = messageCursorLoader;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12785a.forceLoad();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SimpleChatFragment.this.D1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends HashMap<String, Object> {
        public j() {
            put("action", "send_message");
            put("status", "fail");
            put("detail", "sendNameCard");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f12788a;

        public k(uk5 uk5Var) {
            this.f12788a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            uk5 uk5Var = this.f12788a;
            int i = uk5Var.f21235a;
            if (i == 53) {
                if (fg6.d(AppContext.getContext()) && this.f12788a.b == 1) {
                    ReadStateGuideManager.e().g(SimpleChatFragment.this.k);
                    return;
                }
                return;
            }
            if (i == 55 && (str = uk5Var.d) != null && str.equals(SimpleChatFragment.this.k.getChatId()) && SimpleChatFragment.this.y != null) {
                SimpleChatFragment.this.y.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements LoopTextView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12789a;
        public final /* synthetic */ ArrayList b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.SimpleChatFragment$l$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0982a implements ValueAnimator.AnimatorUpdateListener {
                public C0982a() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue instanceof Float) {
                        float fFloatValue = ((Float) animatedValue).floatValue();
                        if (SimpleChatFragment.this.M == null || SimpleChatFragment.this.M.getLayoutParams() == null) {
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams = SimpleChatFragment.this.M.getLayoutParams();
                        layoutParams.height = (int) (a46.b(AppContext.getContext(), 32.0f) * fFloatValue);
                        SimpleChatFragment.this.M.setLayoutParams(layoutParams);
                        SimpleChatFragment.this.M.setAlpha(fFloatValue);
                    }
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(1000L);
                duration.addUpdateListener(new C0982a());
                duration.cancel();
                duration.start();
            }
        }

        public l(int i, ArrayList arrayList) {
            this.f12789a = i;
            this.b = arrayList;
        }

        @Override // com.zenmen.palmchat.mine.view.LoopTextView.c
        public void b(int i) {
            if (this.f12789a != 2 || SimpleChatFragment.this.getActivity() == null || SimpleChatFragment.this.getActivity().isFinishing() || SimpleChatFragment.this.T || this.b.isEmpty() || i != this.b.size() - 1) {
                return;
            }
            SimpleChatFragment.this.T = true;
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 800L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements ChatterAdapter.j {
        public m() {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.j
        public String e() {
            return SimpleChatFragment.this.s;
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.j
        public ChatOneItemVo f() {
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12793a = 0;
        public long b = 0;
        public double c = 0.0d;

        public n() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i3 != 0) {
                SimpleChatFragment.this.h.b();
            }
            if (this.f12793a != i) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.c = (1.0d / (jCurrentTimeMillis - this.b)) * 1000.0d;
                this.f12793a = i;
                this.b = jCurrentTimeMillis;
                SimpleChatFragment.this.y.G0(this.c);
                Log.d("HUA", "Speed: " + this.c + "elements/second");
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                return;
            }
            SimpleChatFragment.this.B0();
            SimpleChatFragment.this.h.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnTouchListener {
        public o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || SimpleChatFragment.this.B == null) {
                return false;
            }
            SimpleChatFragment.this.B.n3();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements AbsListView.RecyclerListener {
        public p() {
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            MagicVideoView magicVideoView = (MagicVideoView) view.findViewById(R.id.video);
            if (magicVideoView != null) {
                magicVideoView.stop();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements ChatterAdapter.g {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12797a;

            public a(String str) {
                this.f12797a = str;
                put("fuid", SimpleChatFragment.this.k.getChatId());
                put("is1v1ConsumeReport", String.valueOf(str.contains("is1v1ConsumeReport=true")));
                put("type", SimpleChatFragment.this.k.getChatId().equals(AccountUtils.p(AppContext.getContext())) ? "warning" : "alert");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContentValues f12798a;

            public b(ContentValues contentValues) {
                this.f12798a = contentValues;
                put("fuid", SimpleChatFragment.this.k.getChatId());
                put("is1v1ConsumeReport", String.valueOf(contentValues.containsKey("is1v1ConsumeReport") && contentValues.getAsBoolean("is1v1ConsumeReport").booleanValue()));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, String> {
            public c() {
                put("target_uid", SimpleChatFragment.this.k.getChatId());
            }
        }

        public q() {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.g
        public void W0(String str) {
            if (SimpleChatFragment.this.k == null || SimpleChatFragment.this.k.getChatId() == null || str == null || !str.contains("a0046")) {
                return;
            }
            zn6.h("pagechat_timestamp_alertbubble", "view", new a(str));
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.g
        public void b1(String str, int i, ContentValues contentValues, y56 y56Var) {
            SimpleChatFragment.this.r1(i, contentValues, y56Var, str, null, true, null, false);
            if (SimpleChatFragment.this.k != null) {
                if (a65.e(SimpleChatFragment.this.k)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(DeviceInfoUtil.UID_TAG, SimpleChatFragment.this.k.getChatId());
                        jSONObject.put("showType", 10);
                        jSONObject.put("isAds5", false);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LogUtil.uploadInfoImmediate("H11", null, null, jSONObject.toString());
                    return;
                }
                if (SimpleChatFragment.this.k.getChatId() != null && contentValues != null && "a0046".equals(contentValues.getAsString("page"))) {
                    zn6.h("pagechat_timestamp_complaintbutton", "click", new b(contentValues));
                } else {
                    if (SimpleChatFragment.this.k.getChatId() == null || contentValues == null || !contentValues.containsKey("isComplain") || !contentValues.getAsBoolean("isComplain").booleanValue()) {
                        return;
                    }
                    zn6.h("banned_complain", "click", new c());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            SimpleChatFragment.this.K.removeAllViews();
            SimpleChatFragment.this.K.addView(SimpleChatFragment.this.e0.getTitleView(), layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s extends BroadcastReceiver {
        public s() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (((TelephonyManager) context.getSystemService("phone")).getCallState() != 1) {
                return;
            }
            SimpleChatFragment.this.M1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements AudioController.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MessageVo f12803a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SimpleChatFragment.this.z.setVisibility(8);
            }
        }

        public u() {
        }

        @Override // com.zenmen.palmchat.media.AudioController.q
        public void a() {
            MessageVo messageVoZ0 = SimpleChatFragment.this.Z0(this.f12803a);
            if (messageVoZ0 != null) {
                SimpleChatFragment.this.Z.c(messageVoZ0);
                AudioController.b0().r0(messageVoZ0, SimpleChatFragment.this.Z, SimpleChatFragment.this.J.h());
                return;
            }
            FragmentActivity activity = SimpleChatFragment.this.getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            activity.getWindow().clearFlags(128);
        }

        @Override // com.zenmen.palmchat.media.AudioController.q
        public void b(boolean z) {
            if (z) {
                return;
            }
            SimpleChatFragment.this.z.setVisibility(0);
            SimpleChatFragment.this.z.postDelayed(new a(), com.igexin.push.config.c.j);
        }

        public void c(MessageVo messageVo) {
            this.f12803a = messageVo;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface v {
        FrameworkBaseActivity b();

        ViewGroup c();

        ViewGroup d();

        View getTitleView();
    }

    static {
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mFlingRunnable");
            h0 = declaredField;
            declaredField.setAccessible(true);
            Method declaredMethod = h0.getType().getDeclaredMethod("endFling", new Class[0]);
            i0 = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception unused) {
            i0 = null;
        }
    }

    public static void N1(ListView listView) {
        Field field;
        if (i0 == null || (field = h0) == null) {
            return;
        }
        try {
            Object obj = field.get(listView);
            if (obj != null) {
                i0.invoke(obj, new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final int A0() {
        try {
            return (getResources().getDisplayMetrics().widthPixels - a46.b(AppContext.getContext(), 63.0f)) / ((int) this.N.getTextPaint().measureText("平台", 0, 1));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final void A1(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", 5002 == i2 ? "tab_mine" : "tab_square");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.g("friend_recommend_hi_dialog_view", jSONObject);
    }

    public void B0() {
        h20 h20Var = this.E;
        if (h20Var == null) {
            return;
        }
        MessageCursorLoader messageCursorLoaderB = h20Var.b();
        ListView listView = this.v;
        if (listView == null || listView.getFirstVisiblePosition() != 0 || messageCursorLoaderB == null || !messageCursorLoaderB.b()) {
            return;
        }
        u1();
    }

    public final void B1() {
        if (getActivity() == null) {
            return;
        }
        getActivity().registerReceiver(this.V, new IntentFilter("android.intent.action.PHONE_STATE"));
    }

    public <T extends View> T C0(@IdRes int i2) {
        View view = getView();
        if (view != null) {
            return (T) view.findViewById(i2);
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void C1() {
        InputFragment inputFragment;
        if (this.H != null) {
            this.y.E0(null);
            FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.remove(this.H);
            fragmentTransactionBeginTransaction.show(this.B);
            ChatItem chatItem = this.k;
            if (chatItem != null && a65.e(chatItem) && (inputFragment = this.B) != null) {
                fragmentTransactionBeginTransaction.hide(inputFragment);
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            this.H = null;
        }
    }

    public void D1() {
        ChatterAdapter chatterAdapter;
        h20 h20Var = this.E;
        if (h20Var == null) {
            return;
        }
        MessageCursorLoader messageCursorLoaderB = h20Var.b();
        if ((messageCursorLoaderB == null || !messageCursorLoaderB.e()) && this.v != null && (chatterAdapter = this.y) != null && chatterAdapter.getCount() > 0 && this.v.canScrollVertically(1)) {
            N1(this.v);
            this.v.setAdapter((ListAdapter) this.y);
            this.v.smoothScrollToPosition(this.y.getCount() - 1);
            this.v.setSelection(130);
        }
    }

    public final void E0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void E1(ContactInfoItem contactInfoItem) {
        new sd3(getActivity()).k(getString(R.string.send_name_card_content, contactInfoItem.getNameForShow())).O(R.string.media_pick_activity_send).K(R.string.dialog_cancel).f(new g(contactInfoItem)).e().show();
    }

    public void F1(boolean z) {
        this.i = z;
    }

    public u G0() {
        return this.Z;
    }

    public void G1(v vVar) {
        this.e0 = vVar;
    }

    public void H1() {
        InputFragment inputFragment;
        try {
            if (this.k.getChatType() == 0 && fu5.u(this.k) && (inputFragment = this.B) != null && inputFragment.r2() && this.B.Q2()) {
                ComplianceBoardBean complianceBoardBeanA = uj0.a();
                if (complianceBoardBeanA == null || complianceBoardBeanA.mSwitch != 1) {
                    this.L.setVisibility(8);
                    return;
                }
                int i2 = complianceBoardBeanA.frequencyType;
                int i3 = complianceBoardBeanA.residentSwitch;
                String strA = iv0.a(System.currentTimeMillis(), "yyyyMMdd");
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.TASK_1V1;
                int iF = sPUtil.f(scene, k86.a("key_chat_compliance_1v1_enter_chat_page_count_" + strA), 0);
                List<Integer> list = complianceBoardBeanA.showPosition;
                long jI = sPUtil.i(scene, k86.a("key_chat_compliance_1v1_board_show_time_stamp_") + this.k.getChatId(), 0L);
                int iF2 = sPUtil.f(scene, k86.a("key_chat_compliance_1v1_board_show_count_" + strA), 0);
                StringBuilder sb = new StringBuilder();
                sb.append("1V1ComplianceBoard 上次展示的时间戳是：");
                sb.append(jI);
                sb.append(" ===== 今天总共展示的次数是");
                sb.append(iF2);
                sb.append("===== 今天进入聊天页面的次数是");
                int i4 = iF + 1;
                sb.append(i4);
                LogUtil.i("1V1Compliance", sb.toString());
                if (iF2 > 0 && by5.k(jI)) {
                    LogUtil.i("1V1Compliance", "1V1ComplianceBoard 进入同一个用户的聊天页面，公告每天只展示1次");
                    return;
                }
                int i5 = i4 + 1;
                sPUtil.t(scene, k86.a("key_chat_compliance_1v1_enter_chat_page_count_" + strA), Integer.valueOf(i5));
                if (!(i2 == 1 && jI == 0) && (i2 != 2 || list == null || list.isEmpty() || !list.contains(Integer.valueOf(i5 + 1)))) {
                    this.L.setVisibility(8);
                    return;
                }
                String str = this.B.R2() ? complianceBoardBeanA.textPayer : complianceBoardBeanA.textProfit;
                int iA0 = A0();
                if (iA0 > 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    int length = str.length();
                    int i6 = 0;
                    while (i6 < length) {
                        int i7 = i6 + iA0;
                        arrayList.add(str.substring(i6, Math.min(length, i7)));
                        i6 = i7;
                    }
                    this.N.setAutoScrollListener(new l(i3, arrayList));
                    this.N.stopAutoScroll();
                    if (arrayList.size() > 1) {
                        this.N.setAnim();
                        this.N.setTextList(arrayList);
                        this.N.startAutoScroll();
                    } else {
                        this.N.setNoAnim();
                        this.N.setText(arrayList.get(0));
                    }
                    SPUtil sPUtil2 = SPUtil.f14322a;
                    SPUtil.SCENE scene2 = SPUtil.SCENE.TASK_1V1;
                    sPUtil2.t(scene2, k86.a("key_chat_compliance_1v1_board_show_time_stamp_") + this.k.getChatId(), Long.valueOf(System.currentTimeMillis()));
                    sPUtil2.t(scene2, k86.a("key_chat_compliance_1v1_board_show_count_" + strA), Integer.valueOf(iF2 + 1));
                    this.L.setVisibility(0);
                    zn6.c("pagechat_civilize_board", "view");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.L.setVisibility(8);
        }
    }

    public int I0() {
        int i2 = h13.m;
        ChatItem chatItem = this.k;
        return chatItem != null ? a65.e(chatItem) ? h13.s : this.k.getChatType() == 1 ? h13.r : h13.q : i2;
    }

    public void I1() {
        MaterialDialog materialDialogE = new sd3(getActivity()).j(R.string.string_secretary_confine_forward_dialog_content).O(R.string.chat_item_menu_forward).M(getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.dialog_cancel).I(getResources().getColor(R.color.material_dialog_button_text_color)).f(new a()).e();
        this.G = materialDialogE;
        if (materialDialogE.isShowing()) {
            return;
        }
        this.G.show();
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public boolean J() {
        if (this.y.U()) {
            this.y.F0(false, null);
            C1();
            return true;
        }
        if (!this.B.I2()) {
            return super.J();
        }
        this.B.n3();
        return true;
    }

    public void J1(MessageVo messageVo) {
        if (messageVo.isSend) {
            this.J.q(messageVo);
            return;
        }
        oc0.g("lx_group_message_chehui_cick");
        new sd3(getActivity()).k("是否撤回该成员的消息？").O(R.string.string_dialog_positive).N(R.color.Ga).L("取消").J(R.color.Ge).f(new c(messageVo)).e().show();
        oc0.g("lx_group_message_chehui_dailog_show");
    }

    public String K0() {
        return this.r;
    }

    public void K1() {
        new sd3(getActivity()).j(nl0.g() ? R.string.message_recall_fail_past_time : R.string.message_recall_fail_past_time_im).O(R.string.alert_dialog_ok).e().show();
    }

    public ChatItem L0() {
        return this.k;
    }

    public void L1() {
        if (AppContext.getContext().getTrayPreferences().a("key_show_recall", true)) {
            new sd3(getActivity()).j(R.string.message_recall_success).O(R.string.alert_dialog_ok).e().show();
            AppContext.getContext().getTrayPreferences().i("key_show_recall", false);
        }
    }

    public View M0() {
        return this.A;
    }

    public final void M1() {
        MessageVo messageVoD0 = AudioController.b0().d0();
        if (messageVoD0 != null) {
            AudioController.b0().D0();
            AudioController.b0().L0(messageVoD0, 0);
            getActivity().getWindow().clearFlags(128);
        }
    }

    public com.zenmen.palmchat.chat.fragment.c N0() {
        return this.J;
    }

    public ChatterAdapter O0() {
        return this.y;
    }

    public final void O1() {
        ImageView imageView = (ImageView) C0(R.id.contentBgImageView);
        if (v10.a()) {
            imageView.setBackgroundResource(R.color.color_chat_bg_b);
        }
    }

    public final void P1(ChatItem chatItem) {
        ChatItem chatItem2 = this.k;
        if (chatItem2 == null || chatItem == null) {
            return;
        }
        if (!(chatItem instanceof ContactInfoItem)) {
            if (chatItem instanceof GroupInfoItem) {
                this.k = chatItem;
                return;
            }
            return;
        }
        if (fu5.u(chatItem2) && (fu5.k(this.k.getBizType()).saveInTempTable || ((ContactInfoItem) chatItem).getIsStranger())) {
            int bizType = this.k.getBizType();
            ContactInfoItem contactInfoItemM792clone = ((ContactInfoItem) chatItem).m792clone();
            contactInfoItemM792clone.setBizType(bizType);
            contactInfoItemM792clone.setSourceType(fu5.n(bizType));
            this.k = contactInfoItemM792clone;
            return;
        }
        this.k = chatItem;
        int bizType2 = chatItem.getBizType();
        this.l = bizType2;
        InputFragment inputFragment = this.B;
        if (inputFragment != null) {
            inputFragment.z3(bizType2);
        }
    }

    public MessageCursorLoader.b Q0() {
        return this.g;
    }

    public View R0() {
        return this.w;
    }

    public InputFragment S0() {
        return this.B;
    }

    public ProgressBar T0() {
        return this.x;
    }

    public HashMap<ChatterActivity.LongClickMenuItem, String> V0() {
        return this.F;
    }

    public ListView W0() {
        return this.v;
    }

    public r30 X0() {
        return this.h;
    }

    public final MessageVo Z0(MessageVo messageVo) {
        ArrayList<MessageVo> arrayListI;
        if (messageVo.isRead || (arrayListI = this.y.I()) == null || arrayListI.size() < 2) {
            return null;
        }
        for (int i2 = 1; i2 < arrayListI.size(); i2++) {
            if (arrayListI.get(i2).time > messageVo.time) {
                MessageVo messageVo2 = arrayListI.get(i2);
                String str = messageVo2.data2;
                boolean z = !TextUtils.isEmpty(str) && new File(str).exists();
                if (messageVo2.mimeType == 3 && !messageVo2.isSend && !messageVo2.isRead && messageVo2.attachStatus == 2 && z) {
                    return messageVo2;
                }
            }
        }
        return null;
    }

    public int a1() {
        return this.m;
    }

    public v b1() {
        return this.e0;
    }

    public int c1() {
        return this.l;
    }

    public i20 e1() {
        return this.I;
    }

    public void f1(ContactInfoItem contactInfoItem) {
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        Intent intent = new Intent(getActivity(), (Class<?>) m66.c());
        if (L0().getChatType() != 1) {
            if (d65.b() && a65.e(contactInfoItemM792clone)) {
                ServiceAccountDetailActivity.Y1(getActivity(), contactInfoItem);
                return;
            } else {
                intent.putExtra("from", 5);
                if (contactInfoItemM792clone.getSourceType() == -1) {
                    contactInfoItemM792clone.setSourceType(11);
                }
            }
        }
        intent.putExtra("user_item_info", contactInfoItemM792clone);
        intent.putExtra("thread_biz_type", L0().getBizType());
        startActivityForResult(intent, 100);
    }

    public void h1() {
        ContactInfoItem contactInfoItemL;
        ChatItem chatItem;
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i2 = arguments.getInt("thread_biz_type", 0);
            this.l = i2;
            this.m = i2;
            this.Q = arguments.getInt(EventParams.KEY_CT_SDK_POSITION, -1);
            this.R = arguments.getInt("click_area", -1);
            this.S = arguments.getInt("superExposeMsgTabItem", 0);
            this.k = (ChatItem) arguments.getParcelable("chat_item");
            this.P = arguments.getString("extra_key_impr_id", "");
            ChatItem chatItem2 = this.k;
            if (chatItem2 == null) {
                E0();
                return;
            }
            if (chatItem2 instanceof ContactInfoItem) {
                ((ContactInfoItem) chatItem2).setBizType(this.l);
                if (bo0.r().l(this.k.getChatId()) == null) {
                    AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.c((ContactInfoItem) this.k));
                }
            }
            long j2 = arguments.getLong("chat_first_message_primary_id", 0L);
            String string = arguments.getString("chat_notification_mid");
            if (string == null || (chatItem = this.k) == null || !a65.e(chatItem) || !jo6.a("LX-30834", false)) {
                string = null;
            }
            this.g = new MessageCursorLoader.b(j2, string);
            this.h = new r30(this.k);
            this.i = AppContext.getContext().getTrayPreferences().a("receiver_mode", false);
            this.n = arguments.getBoolean("extra_key_disable_item_long_click", false);
            this.o = arguments.getBoolean("extra_key_disable_head_icon_click", false);
            this.p = arguments.getBoolean("extra_key_enable_gift", false);
            this.q = arguments.getString("extra_key_input_hint_text", "");
            this.r = arguments.getString("chat_draft");
            this.s = arguments.getString("extra_key_square_feed");
            this.t = arguments.getString("EXTRA_INPUT_TEXT");
            this.u = arguments.getBoolean("extra_key_auto_show_keyboard", false);
            if (this.k.getChatType() != 0 || (contactInfoItemL = bo0.r().l(this.k.getChatId())) == null) {
                return;
            }
            P1(contactInfoItemL);
        }
    }

    public void i1() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.k.getChatId() != null) {
            com.zenmen.palmchat.chat.c cVar = new com.zenmen.palmchat.chat.c(this.k.getChatId());
            this.j = cVar;
            g0 = cVar.f();
        }
        bo0.r().i().j(this);
        AudioController.b0().y0(this.i);
        AudioController.b0().B0();
        this.C = new g20(this, AppContext.getContext().getContentResolver());
        h20 h20Var = new h20(this);
        this.E = h20Var;
        UI.c(activity, 1, null, h20Var);
        UI.c(activity, 4, null, this.E);
        B1();
        this.J.j();
        this.F = this.J.k();
        O1();
        com.zenmen.palmchat.chat.fragment.a aVar = this.O;
        if (aVar != null) {
            aVar.D();
        }
        ChatItem chatItem = this.k;
        if (chatItem == null || chatItem.getChatType() != 0 || a65.e(this.k)) {
            return;
        }
        int i2 = this.l;
        if (5002 == i2 || 5006 == i2) {
            A1(i2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void j1() {
        this.v.setOnScrollListener(new n());
        this.v.setOnTouchListener(new o());
        this.v.setRecyclerListener(new p());
        this.y.t0(new q());
    }

    public void k1() {
        this.U = new c9(L0(), C0(R.id.ai_greeting_profile_float_guide));
        this.K = (LinearLayout) C0(R.id.title_view_container);
        this.L = C0(R.id.ll_compliance_board);
        this.M = C0(R.id.ll_compliance_board_inner);
        LoopTextView loopTextView = (LoopTextView) C0(R.id.tv_compliance_board);
        this.N = loopTextView;
        loopTextView.setText(12.0f, 0, Color.parseColor("#FFD75858"), 16);
        this.N.setTextStillTime(com.igexin.push.config.c.j);
        this.N.setFactory();
        this.v = (ListView) C0(R.id.message_list);
        View viewInflate = getLayoutInflater().inflate(R.layout.list_headerview_chat_header, (ViewGroup) null, false);
        this.w = viewInflate;
        this.x = (ProgressBar) viewInflate.findViewById(R.id.progress_loading);
        this.v.addHeaderView(this.w);
        ChatterAdapter chatterAdapter = new ChatterAdapter(getActivity(), this.k, new com.zenmen.palmchat.chat.fragment.b(this, this.J), false, this.f, this.O);
        this.y = chatterAdapter;
        chatterAdapter.A0(new m());
        this.v.setAdapter((ListAdapter) this.y);
        this.z = (TextView) C0(R.id.chat_notice_tv);
        this.A = C0(R.id.chat_notice_receiver_mode);
        w0();
        y0();
    }

    public boolean l1() {
        return this.o;
    }

    public boolean m1() {
        return this.n;
    }

    public boolean n1() {
        return this.f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        i1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ChatItem chatItem;
        super.onActivityResult(i2, i3, intent);
        if ((i2 == 100 || i2 == 103) && i3 == -1) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        int i4 = 0;
        if (i2 == 101 && i3 == -1) {
            if (intent != null) {
                if (intent.getBooleanExtra("extra_all_of", false)) {
                    this.B.V1("所有人 ");
                    this.B.S1(CircleConfig.VALUE_REMIND_ALL_OF_PERSON);
                    return;
                }
                ArrayList<ContactInfoItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra("add_group_member_result");
                if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
                    return;
                }
                for (ContactInfoItem contactInfoItem : parcelableArrayListExtra) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(!TextUtils.isEmpty(contactInfoItem.getGroupRemarkName()) ? contactInfoItem.getGroupRemarkName() : contactInfoItem.getNickName());
                    sb.append(" ");
                    String string = sb.toString();
                    if (i4 > 0 && parcelableArrayListExtra.size() > 1) {
                        string = "@" + string;
                    }
                    this.B.V1(string);
                    this.B.S1(contactInfoItem.getUid());
                    i4++;
                }
                return;
            }
            return;
        }
        if (i2 == 102 && i3 == -1) {
            this.y.F0(false, null);
            C1();
            return;
        }
        if (i2 == 104 && i3 == -1) {
            E1((ContactInfoItem) intent.getParcelableExtra("selected_item"));
            return;
        }
        if (i2 == 105 && i3 == -1) {
            ListView listView = this.v;
            if (listView != null) {
                listView.postDelayed(new i(), 500L);
                return;
            }
            return;
        }
        if (i2 == 106 && i3 == 1000) {
            pp3.e(getActivity());
            return;
        }
        if (i2 != 106 || i3 != -1) {
            if (i2 != 107) {
                if (i2 == 1688) {
                    qq2.h(i2, i3, intent, 2);
                    return;
                }
                return;
            }
            LogUtil.d("tang", "chatter activity on activity result notifyDataSetChanged");
            InputFragment inputFragment = this.B;
            if (inputFragment == null || inputFragment.q2() == null || this.B.q2().getAdapter() == null) {
                return;
            }
            this.B.q2().getAdapter().notifyDataSetChanged();
            return;
        }
        MediaItem mediaItem = (MediaItem) intent.getParcelableExtra("EXTRA_RECORD_ITEM");
        if (mediaItem == null || (chatItem = this.k) == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        try {
            String strE = DomainHelper.e(this.k);
            D1();
            int i5 = mediaItem.mimeType;
            if (i5 != 1) {
                if (i5 == 0) {
                    PhotoObject photoObject = new PhotoObject();
                    photoObject.path = mediaItem.localPath;
                    this.J.h().r(MessageVo.buildImageMessage(xn3.a(), strE, photoObject, true, 0, null).setThreadBizType(AppContext.getContext(), this.l));
                    return;
                }
                return;
            }
            File file = new File(mediaItem.localPath);
            File file2 = new File(mediaItem.thumbnailPath);
            if (file.exists() && file2.exists()) {
                MessageVo threadBizType = MessageVo.buildVideoMessage(xn3.a(), DomainHelper.e(this.k), mediaItem.localPath, mediaItem.thumbnailPath, mediaItem.playLength, 0).setThreadBizType(AppContext.getContext(), this.l);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("video", threadBizType.data5);
                    jSONObject.put("envir", this.k.getChatType() == 1 ? "2" : threadBizType.bizType == 0 ? "1" : "3");
                    jSONObject.put("qua", "1");
                    threadBizType.logExtension = jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.J.h().r(threadBizType);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            LogUtil.i(f0, 3, new j(), e3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.J = new com.zenmen.palmchat.chat.fragment.c(this);
        this.O = new com.zenmen.palmchat.chat.fragment.a(this.W);
        h1();
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new f());
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_chatter, (ViewGroup) null);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.zenmen.palmchat.chat.c cVar;
        if (this.k == null) {
            super.onDestroy();
            return;
        }
        com.zenmen.palmchat.chat.fragment.c cVar2 = this.J;
        if (cVar2 != null) {
            cVar2.o();
        }
        com.zenmen.palmchat.chat.fragment.a aVar = this.O;
        if (aVar != null) {
            aVar.B();
        }
        MaterialDialog materialDialog = this.G;
        if (materialDialog != null) {
            materialDialog.cancel();
        }
        int i2 = g0;
        if (i2 == 1) {
            com.zenmen.palmchat.chat.c cVar3 = this.j;
            if (cVar3 != null) {
                cVar3.c();
            }
        } else if (i2 == 0 && (cVar = this.j) != null) {
            cVar.a();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            bo0.r().i().l(this);
            AudioController.b0().G0();
            activity.getSupportLoaderManager().destroyLoader(1);
            activity.getSupportLoaderManager().destroyLoader(4);
            activity.unregisterReceiver(this.V);
        }
        ChatterAdapter chatterAdapter = this.y;
        if (chatterAdapter != null) {
            chatterAdapter.m0();
        }
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            ch.s().r().l(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onDestroyView();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.y.n0();
        this.C.a(0, this.B.m2(), this.B.p2());
        this.C.g();
        InputFragment inputFragment = this.B;
        if (inputFragment != null) {
            inputFragment.T2();
        }
        f46.m(ch.s().u(), this.k, 2);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.C.b();
        f46.m(ch.s().u(), this.k, 1);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.J.d();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i(f0, "onStatusChanged" + uk5Var.f21235a);
        u93.c(new k(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.J.s();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        k1();
        j1();
        try {
            ch.s().r().j(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean p1() {
        return this.i;
    }

    public void r1(int i2, ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo, boolean z, MessageVo messageVo, boolean z2) {
        LogUtil.i(f0, "judgeUrl actionType=" + i2 + " url=" + str);
        String str2 = messageVo != null ? messageVo.mid : null;
        if (i2 == -1) {
            if (SmallVideoEntranceController.h(richMsgExItemVo)) {
                t1(this.k, messageVo, richMsgExItemVo);
                return;
            } else {
                w1(contentValues, y56Var, str, richMsgExItemVo, z, str2);
                return;
            }
        }
        if (i2 == 1) {
            String asString = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
            com.zenmen.palmchat.chat.fragment.a aVar = this.O;
            aVar.r(aVar.w(asString), false, true, false, false, null);
            return;
        }
        if (i2 == 3) {
            s1(richMsgExItemVo, contentValues, str2);
            return;
        }
        if (i2 == 4) {
            LogUtil.uploadInfoImmediate("356", "1", null, null);
            this.O.p(contentValues);
            return;
        }
        if (i2 == 9) {
            String asString2 = contentValues.getAsString("couponId");
            if (asString2 != null) {
                CircleCouponInfoActivity.J1(getActivity(), asString2, contentValues.getAsString(RedirectRespWrapper.KEY_VERCODE));
                return;
            }
            return;
        }
        if (i2 == 10 && getActivity() != null && (getActivity() instanceof FrameworkBaseActivity)) {
            ve.s((FrameworkBaseActivity) getActivity(), str, false);
        }
    }

    public final void s1(RichMsgExItemVo richMsgExItemVo, ContentValues contentValues, String str) {
        ve.k(this.e0.b(), richMsgExItemVo, contentValues, str, this.k);
    }

    public final void t1(ChatItem chatItem, MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
        FragmentActivity activity = getActivity();
        RichMsgExItemVo.WinEx winEx = richMsgExItemVo.wineEx;
        af6.e(activity, winEx != null ? winEx.wineFeedId : null, winEx != null ? winEx.wid : null, new b(chatItem, messageVo, richMsgExItemVo));
    }

    public final void u1() {
        MessageCursorLoader messageCursorLoaderB;
        h20 h20Var = this.E;
        if (h20Var == null || (messageCursorLoaderB = h20Var.b()) == null || !messageCursorLoaderB.isStarted() || messageCursorLoaderB.e() || messageCursorLoaderB.f()) {
            return;
        }
        messageCursorLoaderB.g();
        this.v.postDelayed(new h(messageCursorLoaderB), 500L);
    }

    public void v1(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        InputFragment inputFragment;
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_VIDEO) {
            pu1.s();
            if (this.B != null) {
                tk3.g(this, 0, 106, 0);
                return;
            }
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            InputFragment inputFragment2 = this.B;
            if (inputFragment2 != null) {
                inputFragment2.d3(permissionUsage);
            }
            pu1.s();
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.RECORD_AUDIO) {
            InputFragment inputFragment3 = this.B;
            if (inputFragment3 != null) {
                inputFragment3.X2();
                return;
            }
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.LOCATION) {
            InputFragment inputFragment4 = this.B;
            if (inputFragment4 != null) {
                inputFragment4.W2();
                return;
            }
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL) {
            InputFragment inputFragment5 = this.B;
            if (inputFragment5 != null) {
                inputFragment5.a3();
                return;
            }
            return;
        }
        if (permissionType != BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL || (inputFragment = this.B) == null) {
            return;
        }
        inputFragment.U2();
    }

    public final void w0() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = activity.getSupportFragmentManager().beginTransaction();
        InputFragment inputFragment = new InputFragment();
        this.B = inputFragment;
        inputFragment.z3(this.l);
        this.B.x3(this.Q);
        this.B.o3(this.R);
        this.B.y3(this.S);
        Bundle bundle = new Bundle();
        bundle.putParcelable(com.umeng.analytics.pro.f.K, this.k);
        bundle.putString("chat_draft", this.r);
        bundle.putBoolean("useNewAudioUi", this.f);
        bundle.putBoolean("extra_key_enable_gift", this.p);
        bundle.putBoolean("extra_key_auto_show_keyboard", this.u);
        if (fu5.u(this.k)) {
            bundle.putBoolean("extra_key_hide_header_add_panel", true);
        }
        if (!TextUtils.isEmpty(this.q)) {
            bundle.putString("extra_key_hint_text", this.q);
        }
        if (!TextUtils.isEmpty(this.t)) {
            bundle.putString("EXTRA_INPUT_TEXT", this.t);
        }
        if (!TextUtils.isEmpty(this.P)) {
            bundle.putString("extra_key_impr_id", this.P);
        }
        this.B.setArguments(bundle);
        this.B.t3(this.Y);
        this.B.s3(this.X);
        fragmentTransactionBeginTransaction.replace(R.id.input_fragment, this.B, InputFragment.c1);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public final void w1(ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo, boolean z, String str2) {
        String str3;
        String asString = contentValues.getAsString("extra_key_from_uid");
        if (y56Var == null || "1".equals(y56Var.a())) {
            str3 = str;
        } else {
            String strB = y56Var.b();
            if ("1".equals(y56Var.k())) {
                try {
                    strB = k86.Z(strB);
                } catch (UnsupportedEncodingException unused) {
                }
            }
            str3 = strB;
        }
        zy4.o(getActivity(), str3, richMsgExItemVo, z, false, asString, (this.k.getChatType() != 0 && this.k.getChatType() == 1) ? 602 : 601, this.k.getBizType(), str2, I0());
    }

    public void x0(MessageVo messageVo) {
        ChatterMoreActionFragment chatterMoreActionFragment;
        if (this.H == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            ChatterMoreActionFragment chatterMoreActionFragment2 = new ChatterMoreActionFragment();
            this.H = chatterMoreActionFragment2;
            chatterMoreActionFragment2.Y(this.I);
            this.y.E0(this.H);
            ChatItem chatItem = this.k;
            if (chatItem != null && chatItem.getChatId() != null && this.k.getChatId().equals("88888003") && (chatterMoreActionFragment = this.H) != null) {
                chatterMoreActionFragment.W(false);
            }
            fragmentTransactionBeginTransaction.add(R.id.input_fragment, this.H, ChatterMoreActionFragment.k);
            fragmentTransactionBeginTransaction.hide(this.B);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    public final void x1() {
        String chatId = this.k.getChatId();
        ContactInfoItem contactInfoItemL = bo0.r().l(chatId);
        if (contactInfoItemL != null) {
            zn6.d("chatlw_click", null, null);
            ha3.b(getActivity(), "102", chatId, contactInfoItemL.getIconURL(), contactInfoItemL.getNameForShow());
        }
    }

    public final void y0() {
        v vVar = this.e0;
        if (vVar == null || vVar.getTitleView() == null) {
            return;
        }
        this.K.post(new r());
    }

    public void y1() {
        c9 c9Var = this.U;
        if (c9Var != null) {
            c9Var.f();
        }
    }

    public void z1() {
        g20 g20Var = this.C;
        if (g20Var != null) {
            g20Var.e();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements InputFragment.i1 {
        public d() {
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ChatterAdapter a() {
            return SimpleChatFragment.this.y;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public FrameworkBaseActivity b() {
            return SimpleChatFragment.this.e0.b();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ViewGroup c() {
            if (SimpleChatFragment.this.e0 != null) {
                return SimpleChatFragment.this.e0.c();
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ViewGroup d() {
            if (SimpleChatFragment.this.e0 != null) {
                return SimpleChatFragment.this.e0.d();
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public String e() {
            return SimpleChatFragment.this.s;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void f() {
            SimpleChatFragment.this.x1();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void g(int i) {
            SimpleChatFragment.g0 = i;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void h() {
            Intent intent = new Intent(SimpleChatFragment.this.getActivity(), (Class<?>) GroupChatInitActivity.class);
            intent.putExtra("group_info_item", (GroupInfoItem) SimpleChatFragment.this.k);
            intent.putExtra("from_type", 8);
            intent.putExtra("group_choose_contact", true);
            SimpleChatFragment.this.startActivityForResult(intent, 101);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public View i() {
            return SimpleChatFragment.this.getView();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void j(ExpressionObject expressionObject) {
            SimpleChatFragment.this.J.r(expressionObject);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void k() {
            if (SimpleChatFragment.this.k == null || SimpleChatFragment.this.k.getChatType() != 0 || SimpleChatFragment.this.y == null || SimpleChatFragment.this.y.getCount() > 50) {
                return;
            }
            ArrayList<MessageVo> arrayListI = SimpleChatFragment.this.y.I();
            int i = 0;
            for (int i2 = 0; i2 < arrayListI.size(); i2++) {
                if (arrayListI.get(i2).mimeType == 1) {
                    i++;
                }
            }
            pa6.p().X(i, SimpleChatFragment.this.k.getChatId(), SimpleChatFragment.this.k.getBizType());
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public fn2 l() {
            return SimpleChatFragment.this.J.h();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ChatOneItemVo m() {
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
            SimpleChatFragment.this.v1(permissionType, permissionUsage, z);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void p() {
            SimpleChatFragment.this.D1();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public String r(String str) {
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public int s() {
            return SimpleChatFragment.g0;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void n(boolean z) {
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void o(boolean z) {
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void q() {
        }
    }

    public void g1(MessageVo messageVo) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements a.l {
        public t() {
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public ChatterAdapter a() {
            return SimpleChatFragment.this.O0();
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public ChatItem b() {
            return SimpleChatFragment.this.L0();
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public void c() {
            SimpleChatFragment.this.G();
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public void d(String str, boolean z, boolean z2) {
            SimpleChatFragment.this.O(str, z, z2);
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public Activity getActivity() {
            return SimpleChatFragment.this.getActivity();
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public void e() {
        }
    }
}
