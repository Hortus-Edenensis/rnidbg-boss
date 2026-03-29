package com.zenmen.palmchat.chat;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.oplus.tblplayer.Constants;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.media.player.MagicVideoView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.GreetConfig;
import com.zenmen.palmchat.Vo.GroupRedPacketVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.activity.webview.TransparentCordovaWebActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.chat.MessageCursorLoader;
import com.zenmen.palmchat.chat.config.FamilyGroupConfig;
import com.zenmen.palmchat.chat.fragment.a;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.temporary.TemporaryChatInfoActivity;
import com.zenmen.palmchat.circle.bean.CircleGreetEvent;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.bean.CircleWarnBean;
import com.zenmen.palmchat.circle.bean.CircleWarnEvent;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.config.GroupVersionConfig;
import com.zenmen.palmchat.circle.ui.view.CircleNoticeBanner;
import com.zenmen.palmchat.circle.ui.view.CircleWarnView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.bean.ConfigInfoVo;
import com.zenmen.palmchat.contacts.bean.VipWseemeConfig;
import com.zenmen.palmchat.conversations.threadnotifyguide.ExtraInfo;
import com.zenmen.palmchat.conversations.threadnotifyguide.ThreadNotificationGuideActivity;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneItemVo;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.bridge.risk.ChatRiskNotifyEvent;
import com.zenmen.palmchat.framework.bridge.risk.RiskConfig;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.groupchat.ChatInfoActivity;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.messaging.cmdProcessor.CmdMsgEvent;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.mine.view.LoopTextView;
import com.zenmen.palmchat.paidservices.readstate.guide.ReadStateGuideManager;
import com.zenmen.palmchat.peoplenearby.GreetingsThreadsActivity;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.settings.about.AboutActivity;
import com.zenmen.palmchat.task1v1.ComplianceBoardBean;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.rainview.RainSurfaceView;
import com.zenmen.palmchat.widget.rainview.a;
import defpackage.UI;
import defpackage.a46;
import defpackage.a65;
import defpackage.ad1;
import defpackage.ap3;
import defpackage.az2;
import defpackage.b05;
import defpackage.bg6;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.by5;
import defpackage.c5;
import defpackage.c70;
import defpackage.c9;
import defpackage.ch;
import defpackage.co0;
import defpackage.d20;
import defpackage.ds0;
import defpackage.dv0;
import defpackage.dx5;
import defpackage.e9;
import defpackage.ei4;
import defpackage.f46;
import defpackage.f50;
import defpackage.fb2;
import defpackage.fg6;
import defpackage.fn0;
import defpackage.fn2;
import defpackage.fu2;
import defpackage.fu5;
import defpackage.g13;
import defpackage.g50;
import defpackage.gr2;
import defpackage.gu2;
import defpackage.h05;
import defpackage.ha3;
import defpackage.hb3;
import defpackage.hc2;
import defpackage.hk2;
import defpackage.ho0;
import defpackage.ho3;
import defpackage.ie2;
import defpackage.ir5;
import defpackage.iv0;
import defpackage.j6;
import defpackage.je2;
import defpackage.jo6;
import defpackage.ju2;
import defpackage.jw5;
import defpackage.k86;
import defpackage.kh6;
import defpackage.l40;
import defpackage.l50;
import defpackage.l92;
import defpackage.lu4;
import defpackage.mb4;
import defpackage.me1;
import defpackage.me3;
import defpackage.nn0;
import defpackage.nx3;
import defpackage.ny;
import defpackage.o90;
import defpackage.oc0;
import defpackage.p05;
import defpackage.pa6;
import defpackage.pm2;
import defpackage.pt1;
import defpackage.pu1;
import defpackage.q05;
import defpackage.qk6;
import defpackage.qm5;
import defpackage.qt1;
import defpackage.r30;
import defpackage.r75;
import defpackage.r8;
import defpackage.rl0;
import defpackage.s34;
import defpackage.sc0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.te2;
import defpackage.tj2;
import defpackage.ts0;
import defpackage.u93;
import defpackage.ua6;
import defpackage.uj0;
import defpackage.uk2;
import defpackage.uk5;
import defpackage.un0;
import defpackage.v4;
import defpackage.v8;
import defpackage.ve;
import defpackage.vn0;
import defpackage.vt0;
import defpackage.w20;
import defpackage.wa6;
import defpackage.wi0;
import defpackage.x20;
import defpackage.xe2;
import defpackage.xg5;
import defpackage.xn3;
import defpackage.y24;
import defpackage.y56;
import defpackage.y66;
import defpackage.ye2;
import defpackage.yk6;
import defpackage.zd2;
import defpackage.zg5;
import defpackage.zn6;
import defpackage.zp3;
import defpackage.zv3;
import defpackage.zy4;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatterActivity extends BaseActionBarActivity implements pm2<Cursor>, ChatterAdapter.g {
    public static final String O1 = "ChatterActivity";
    public static int P1 = -1;
    public static int Q1;
    public static Field R1;
    public static Method S1;
    public ChatItem A;
    public ListView B;
    public CircleWarnView B1;
    public ChatterAdapter C;
    public FrameLayout C0;
    public r30 E;
    public m1 E0;
    public Toolbar F;
    public TextView F0;
    public View G;
    public TextView G0;
    public TextView H;
    public View H0;
    public TextView I;
    public ImageView J;
    public com.zenmen.palmchat.chat.c J0;
    public TextView K;
    public LinearLayout K0;
    public TextView L;
    public ImageView M;
    public ImageView N;
    public l92 N0;
    public MenuItem O;
    public View P;
    public ImageView Q;
    public String Q0;
    public TextView R;
    public TextView S;
    public CircleNoticeBanner S0;
    public ViewGroup T0;
    public View U;
    public ViewGroup U0;
    public View V;
    public ViewGroup V0;
    public LoopTextView W;
    public ViewGroup W0;
    public View X;
    public EffectiveShapeView X0;
    public TextView Y;
    public EffectiveShapeView Y0;
    public TextView Z;
    public EffectiveShapeView Z0;
    public String a1;
    public ChatOneItemVo b1;
    public boolean c1;
    public boolean d1;
    public View e0;
    public com.zenmen.palmchat.chat.fragment.a e1;
    public View f0;
    public String f1;
    public View g0;
    public TextView h0;
    public FrameLayout h1;
    public ImageView i0;
    public FrameLayout i1;
    public View j0;
    public boolean j1;
    public ImageView k0;
    public boolean k1;
    public TextView l0;
    public l40 l1;
    public TextView m0;
    public int m1;
    public TextView n0;
    public int n1;
    public TextView o0;
    public TextView p0;
    public f50 p1;
    public View q0;
    public TextView r0;
    public TextView s0;
    public long t0;
    public String w;
    public ChatterMoreActionFragment w0;
    public String x0;
    public int x1;
    public String y0;
    public c9 y1;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public long t = 0;
    public MessageCursorLoader.b u = null;
    public ContactInfoItem v = null;
    public int x = 0;
    public int y = 0;
    public String z = "";
    public boolean T = false;
    public HashMap<String, ContactInfoItem> u0 = new HashMap<>();
    public InputFragment v0 = null;
    public boolean z0 = true;
    public boolean A0 = true;
    public w20 B0 = null;
    public MessageCursorLoader D0 = null;
    public boolean I0 = false;
    public int L0 = 0;
    public boolean M0 = false;
    public com.zenmen.palmchat.chat.a O0 = new com.zenmen.palmchat.chat.a(this);
    public boolean P0 = AudioController.N0();
    public xe2 R0 = new xe2();
    public int g1 = -1;
    public g50 o1 = new g50(new k());
    public p1 q1 = new p1(this);
    public BroadcastReceiver r1 = new v();
    public a.l s1 = new w();
    public TextView t1 = null;
    public ImageView u1 = null;
    public ImageView v1 = null;
    public boolean w1 = false;
    public boolean z1 = false;
    public ObjectAnimator A1 = null;
    public boolean C1 = false;
    public boolean D1 = false;
    public boolean E1 = false;
    public InputFragment.i1 F1 = new j0();
    public boolean G1 = false;
    public String H1 = null;
    public o1 I1 = new o1();
    public int J1 = 1;
    public RainSurfaceView K1 = null;
    public boolean L1 = false;
    public String M1 = null;
    public final Set<String> N1 = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public enum LongClickMenuItem {
        MORE,
        DELETE,
        COPY,
        BUBBLE,
        RECALL,
        FORWARD,
        MOMENTS,
        SPEAKERMODE1,
        SPEAKERMODE2,
        SAVEEXPRESSION,
        REPORT,
        KICKOUT
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements j6 {
        public a() {
        }

        @Override // defpackage.j6
        public void a(boolean z) {
            ChatterActivity chatterActivity;
            ChatterAdapter chatterAdapter;
            if (ChatterActivity.this.isFinishing() || (chatterAdapter = (chatterActivity = ChatterActivity.this).C) == null) {
                return;
            }
            chatterAdapter.A(chatterActivity.g1);
            ChatterActivity.this.C.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements Runnable {
        public a0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.O3(false);
            ChatterActivity.this.f3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a1 extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12512a;

        public a1(String str) {
            this.f12512a = str;
            put("fuid", ChatterActivity.this.A.getChatId());
            put("is1v1ConsumeReport", String.valueOf(str.contains("is1v1ConsumeReport=true")));
            put("type", ChatterActivity.this.A.getChatId().equals(AccountUtils.p(ChatterActivity.this)) ? "warning" : "alert");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements j6 {
        public b() {
        }

        @Override // defpackage.j6
        public void a(boolean z) {
            ChatterActivity chatterActivity;
            ChatterAdapter chatterAdapter;
            if (ChatterActivity.this.isFinishing() || (chatterAdapter = (chatterActivity = ChatterActivity.this).C) == null) {
                return;
            }
            chatterAdapter.A(chatterActivity.g1);
            ChatterActivity.this.C.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements View.OnClickListener {
        public b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ap3.q(ChatterActivity.this, "9");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b1 implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c5 f12515a;

        public b1(c5 c5Var) {
            this.f12515a = c5Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            try {
                ChatterActivity.this.hideBaseProgressBar();
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP != null) {
                    c5 c5Var = this.f12515a;
                    if (c5Var != null) {
                        c5Var.call(contactInfoItemP);
                    }
                    LogUtil.uploadInfoImmediate("dt12", "1", null, null);
                    LogUtil.i(ChatterActivity.O1, "dt12");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12516a;
        public final /* synthetic */ GroupInfoItem b;

        public c(int i, GroupInfoItem groupInfoItem) {
            this.f12516a = i;
            this.b = groupInfoItem;
            put("fromtype", Integer.valueOf(i));
            put("rid", groupInfoItem.getGroupId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupInfoItem f12517a;
        public final /* synthetic */ FamilyGroupConfig b;

        public c0(GroupInfoItem groupInfoItem, FamilyGroupConfig familyGroupConfig) {
            this.f12517a = groupInfoItem;
            this.b = familyGroupConfig;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            HashMap map = new HashMap();
            map.put("groupid", this.f12517a.getGroupId());
            zn6.j("group_listicon", "click", map);
            String str = this.b.rankingUrl;
            StringBuilder sb = new StringBuilder(str);
            if (str.contains(Constants.STRING_VALUE_UNSET)) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            } else {
                sb.append(Constants.STRING_VALUE_UNSET);
            }
            sb.append("groupId=");
            sb.append(this.f12517a.getGroupId());
            Intent intent = new Intent();
            intent.setClass(ChatterActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", sb.toString());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putBoolean("hide_progressbar", true);
            intent.putExtras(bundle);
            ChatterActivity.this.startActivity(intent);
            LogUtil.d("logfamily", "open url: " + sb.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c1 implements View.OnClickListener {
        public c1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ChatterActivity chatterActivity = ChatterActivity.this;
            if (chatterActivity.s) {
                return;
            }
            sy5.h(chatterActivity, "与AI虚拟人互动时，请保持尊重和礼貌，禁止利用AI相关功能从事违法活动", 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatterActivity.this.x == 14) {
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "31311", "1", null, null);
            }
            if (fu5.u(ChatterActivity.this.A)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("report_type", "click");
                    jSONObject.put("from", fu5.k(ChatterActivity.this.A.getBizType()).domain);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.d("pagechat_addbutton", null, jSONObject.toString());
            }
            ContactRequestsVO contactRequestsVO = (ContactRequestsVO) view.getTag();
            if (contactRequestsVO == null) {
                ChatterActivity.this.e1.o(true, false, false, null);
            } else {
                ChatterActivity.this.e1.m(false, contactRequestsVO);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements Runnable {
        public d0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity chatterActivity = ChatterActivity.this;
            ChatterAdapter chatterAdapter = chatterActivity.C;
            if (chatterAdapter != null) {
                chatterActivity.E1 = chatterAdapter.r0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d1 implements Response.ErrorListener {
        public d1() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatterActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fuid", ChatterActivity.this.A.getChatId());
                LogUtil.uploadInfoImmediate("5551", null, null, jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ContactRequestsVO contactRequestsVO = (ContactRequestsVO) view.getTag();
            if (contactRequestsVO == null) {
                ChatterActivity.this.e1.o(true, false, false, null);
            } else {
                ChatterActivity.this.e1.m(false, contactRequestsVO);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 extends MaterialDialog.e {
        public e0() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ChatterActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e1 implements Response.Listener<JSONObject> {
        public e1() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            try {
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP != null) {
                    ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemP.getUid());
                    if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                        contactInfoItemP.setFriendType(1);
                        ChatterActivity.this.X4(contactInfoItemP);
                        ChatterActivity.this.O3(true);
                        ChatterActivity.this.f3();
                        un0.h(contactInfoItemP, false);
                        String strC = az2.c(contactInfoItemP.getExt());
                        if (strC != null && (contactInfoItemL == null || !strC.equals(az2.c(contactInfoItemL.getExt())) || contactInfoItemL.getAccountType() != contactInfoItemP.getAccountType())) {
                            co0.e(contactInfoItemP.getUid(), strC, contactInfoItemP.getAccountType());
                        }
                    }
                    if ("temporary_chat_notification".equals(ChatterActivity.this.f1)) {
                        ChatterActivity.this.l5(contactInfoItemP.getNickName());
                        if (bo0.r().l(contactInfoItemP.getUid()) == null) {
                            AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.c(contactInfoItemP));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            ChatterActivity.this.v0.n3();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements Runnable {
        public f0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.z4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements ChatterAdapter.j {
        public g() {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.j
        public String e() {
            return ChatterActivity.this.a1;
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.j
        public ChatOneItemVo f() {
            return ChatterActivity.this.b1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements Runnable {
        public g0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.C1 = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g1 extends wi0<BaseResponse> {
        public g1() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                return;
            }
            c70.R().C0(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements ChatterAdapter.i {
        public h() {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.i
        public void a() {
            ChatterActivity.this.o1.v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h1 implements LoopTextView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12533a;
        public final /* synthetic */ ArrayList b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: com.zenmen.palmchat.chat.ChatterActivity$h1$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0971a implements ValueAnimator.AnimatorUpdateListener {
                public C0971a() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue instanceof Float) {
                        float fFloatValue = ((Float) animatedValue).floatValue();
                        if (ChatterActivity.this.V == null || ChatterActivity.this.V.getLayoutParams() == null) {
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams = ChatterActivity.this.V.getLayoutParams();
                        layoutParams.height = (int) (a46.b(AppContext.getContext(), 32.0f) * fFloatValue);
                        ChatterActivity.this.V.setLayoutParams(layoutParams);
                        ChatterActivity.this.V.setAlpha(fFloatValue);
                    }
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(1000L);
                duration.addUpdateListener(new C0971a());
                duration.cancel();
                duration.start();
            }
        }

        public h1(int i, ArrayList arrayList) {
            this.f12533a = i;
            this.b = arrayList;
        }

        @Override // com.zenmen.palmchat.mine.view.LoopTextView.c
        public void b(int i) {
            if (this.f12533a != 2 || ChatterActivity.this.isFinishing() || ChatterActivity.this.k1 || this.b.isEmpty() || i != this.b.size() - 1) {
                return;
            }
            ChatterActivity.this.k1 = true;
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 800L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements AbsListView.RecyclerListener {
        public i() {
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
    public class i1 implements View.OnClickListener {
        public i1() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[PHI: r0
          0x005b: PHI (r0v2 long) = (r0v1 long), (r0v3 long) binds: [B:15:0x0044, B:17:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            long j;
            int gender;
            if (l50.a()) {
                return;
            }
            ChatterActivity chatterActivity = ChatterActivity.this;
            if (chatterActivity.s) {
                return;
            }
            try {
                long j2 = 0;
                long j3 = (chatterActivity.A == null || TextUtils.isEmpty(ChatterActivity.this.A.getChatId())) ? 0L : Long.parseLong(ChatterActivity.this.A.getChatId());
                String strP = AccountUtils.p(AppContext.getContext());
                if (!TextUtils.isEmpty(strP)) {
                    j2 = Long.parseLong(strP);
                    ContactInfoItem contactInfoItemL = bo0.r().l(strP);
                    if (contactInfoItemL != null) {
                        gender = contactInfoItemL.getGender();
                        j = j2;
                    } else {
                        j = j2;
                        gender = 0;
                    }
                }
                v8.N(ChatterActivity.this, 190101, j3, j, gender, ChatterActivity.this.A != null ? ChatterActivity.this.A.getBizType() : 0);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterActivity.this.Q4(false);
            if (ChatterActivity.this.D0 == null || !ChatterActivity.this.D0.isStarted() || ChatterActivity.this.D0.e()) {
                return;
            }
            if (ChatterActivity.this.D0.h()) {
                ChatterActivity.this.B.setTranscriptMode(0);
                ChatterActivity.this.C.I0(true);
                ChatterActivity.this.D0.forceLoad();
            } else {
                int iK = ChatterActivity.this.C.K();
                if (iK >= 0) {
                    ChatterActivity.this.C.I0(true);
                    ChatterActivity.this.C.notifyDataSetChanged();
                    ChatterActivity.this.B.smoothScrollToPosition(iK);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j0 implements InputFragment.i1 {
        public j0() {
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ChatterAdapter a() {
            return ChatterActivity.this.C;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public FrameworkBaseActivity b() {
            return ChatterActivity.this;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ViewGroup c() {
            if (ChatterActivity.this.i1 != null) {
                return ChatterActivity.this.i1;
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ViewGroup d() {
            if (ChatterActivity.this.h1 != null) {
                return ChatterActivity.this.h1;
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public String e() {
            return ChatterActivity.this.a1;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void f() {
            ChatterActivity.this.o4();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void g(int i) {
            ChatterActivity.Q1 = i;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void h() {
            ChatterActivity.this.S4();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public View i() {
            return ChatterActivity.this.findViewById(R.id.root_view);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void j(ExpressionObject expressionObject) {
            ChatterActivity.this.H4(expressionObject);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void k() {
            ChatterAdapter chatterAdapterA;
            ChatItem chatItemO3 = ChatterActivity.this.o3();
            if (chatItemO3 == null || chatItemO3.getChatType() != 0 || (chatterAdapterA = a()) == null || chatterAdapterA.getCount() > 50) {
                return;
            }
            ArrayList<MessageVo> arrayListI = chatterAdapterA.I();
            int i = 0;
            for (int i2 = 0; i2 < arrayListI.size(); i2++) {
                if (arrayListI.get(i2).mimeType == 1) {
                    i++;
                }
            }
            pa6.p().X(i, chatItemO3.getChatId(), chatItemO3.getBizType());
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public fn2 l() {
            return ChatterActivity.this.getMessagingServiceInterface();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public ChatOneItemVo m() {
            return ChatterActivity.this.b1;
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void n(boolean z) {
            ChatterActivity.this.l4(z);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void o(boolean z) {
            ChatterActivity.this.m4(z);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
            ChatterActivity.this.onPermissionGrant(permissionType, permissionUsage, z);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void p() {
            ChatterActivity.this.G4();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public void q() {
            ChatterActivity.this.b5();
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public String r(String str) {
            return ChatterActivity.this.t3(str);
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.i1
        public int s() {
            return ChatterActivity.Q1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j1 implements hk2 {
        public j1() {
        }

        @Override // defpackage.hk2
        public void onResult(int i) {
            LogUtil.d("AiChatPeopleManagerTag", "ChatterActivity initAiChatUI CheckOpenGuard result " + i + " aiGuardStatus " + ChatterActivity.this.x1);
            ChatterActivity.this.V2(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements uk2 {
        public k() {
        }

        @Override // defpackage.uk2
        public ChatItem b() {
            return ChatterActivity.this.A;
        }

        @Override // defpackage.uk2
        public xe2 c() {
            return ChatterActivity.this.R0;
        }

        @Override // defpackage.uk2
        public int e() {
            return ChatterActivity.this.x;
        }

        @Override // defpackage.uk2
        public InputFragment g() {
            return ChatterActivity.this.v0;
        }

        @Override // defpackage.uk2
        public ChatterActivity getActivity() {
            return ChatterActivity.this;
        }

        @Override // defpackage.uk2
        public InputFragment h() {
            return ChatterActivity.this.v3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f12543a;

        public k0(uk5 uk5Var) {
            this.f12543a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk5 uk5Var = this.f12543a;
            int i = uk5Var.f21235a;
            if (i == 7) {
                MessageVo messageVoD0 = AudioController.b0().d0();
                ArrayList<T> arrayList = this.f12543a.c;
                if (messageVoD0 != null && arrayList != 0 && arrayList.contains(messageVoD0.mid)) {
                    AudioController.b0().D0();
                    AudioController.b0().L0(messageVoD0, 0);
                    ChatterActivity.this.getWindow().clearFlags(128);
                }
                f50 f50Var = ChatterActivity.this.p1;
                if (f50Var != null) {
                    f50Var.U(arrayList);
                    return;
                }
                return;
            }
            if (i == 53) {
                if (fg6.d(AppContext.getContext()) && this.f12543a.b == 1) {
                    ReadStateGuideManager.e().g(ChatterActivity.this.A);
                    return;
                }
                return;
            }
            if (i == 55) {
                String str = uk5Var.d;
                if (str == null || !str.equals(ChatterActivity.this.n3())) {
                    return;
                }
                ChatterActivity.this.C.notifyDataSetChanged();
                return;
            }
            if (i == 21) {
                ChatterActivity.this.O0.a(DomainHelper.j(this.f12543a.d), this.f12543a.b);
                return;
            }
            if (i != 22) {
                return;
            }
            String str2 = uk5Var.d;
            if (ad1.j(ad1.p, str2)) {
                LogUtil.i("TYPE_DIALOG_PROCESS_MSG_RECEIVED", "onStatusChanged pageIndex = " + str2);
                ad1.h().m(ad1.p, ChatterActivity.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r8 f12544a;

        public k1(r8 r8Var) {
            this.f12544a = r8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.V2(this.f12544a.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends MaterialDialog.e {
        public l() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            r75.o(AppContext.getContext(), k86.a("is_first_enter_greet"), false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CmdMsgEvent f12546a;

        public l0(CmdMsgEvent cmdMsgEvent) {
            this.f12546a = cmdMsgEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (fu5.o(this.f12546a.msg) != 2) {
                return;
            }
            ChatterActivity.this.L3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l1 implements j6 {
        public l1() {
        }

        @Override // defpackage.j6
        public void a(boolean z) {
            ChatterActivity chatterActivity;
            ChatterAdapter chatterAdapter;
            if (ChatterActivity.this.isFinishing() || (chatterAdapter = (chatterActivity = ChatterActivity.this).C) == null) {
                return;
            }
            chatterAdapter.A(chatterActivity.g1);
            ChatterActivity.this.C.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (nx3.a("key_new_feedback")) {
                nx3.e("key_new_feedback");
            }
            Intent intent = new Intent();
            intent.setClass(ChatterActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", AboutActivity.B);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            ChatterActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bg6 f12549a;

        public m0(bg6 bg6Var) {
            this.f12549a = bg6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - ((Long) q05.k("KEY_SHOW_INTIMACY_GUID_LASTTIME" + ChatterActivity.this.A.getChatId(), 0L)).longValue() > 300000) {
                if (ChatterActivity.this.A != null && this.f12549a.f1713a == 47 && ChatterActivity.this.A.getChatType() == 0) {
                    ContactInfoItem contactInfoItem = (ContactInfoItem) ChatterActivity.this.A;
                    if (!contactInfoItem.getIsStranger()) {
                        gu2.d(contactInfoItem);
                    }
                }
                q05.w("KEY_SHOW_INTIMACY_GUID_LASTTIME" + ChatterActivity.this.A.getChatId(), Long.valueOf(System.currentTimeMillis()));
            }
            if (ChatterActivity.this.A != null && this.f12549a.f1713a == 47 && ChatterActivity.this.A.getChatType() == 0) {
                kh6.c(ChatterActivity.this.A);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m1 extends AsyncQueryHandler {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f12551a;
            public final /* synthetic */ long b;

            public a(int i, long j) {
                this.f12551a = i;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatterActivity.this.F0.setText(ChatterActivity.this.getString(R.string.chat_unread_count_text, Integer.valueOf(this.f12551a)));
                ChatterActivity.this.Q4(true);
                if (ChatterActivity.this.D0 != null) {
                    ChatterActivity.this.D0.i(this.b);
                }
                ChatterActivity.this.C.B0(this.b);
            }
        }

        public m1(ContentResolver contentResolver) {
            super(contentResolver);
        }

        public final ContactRequestsVO a(ArrayList<ContactRequestsVO> arrayList) {
            ContactRequestsVO contactRequestsVO = null;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            if (ChatterActivity.this.x != 22) {
                return arrayList.get(0);
            }
            Iterator<ContactRequestsVO> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ContactRequestsVO next = it.next();
                if (!ContactRequestsVO.isSenderParseFromRid(next.requestRid)) {
                    contactRequestsVO = next;
                    break;
                }
            }
            return contactRequestsVO == null ? arrayList.get(0) : contactRequestsVO;
        }

        @Override // android.content.AsyncQueryHandler
        public void onDeleteComplete(int i, Object obj, int i2) {
            super.onDeleteComplete(i, obj, i2);
        }

        @Override // android.content.AsyncQueryHandler
        public void onInsertComplete(int i, Object obj, Uri uri) {
            super.onInsertComplete(i, obj, uri);
            LogUtil.i(ChatterActivity.O1, "onInsertComplete" + i);
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            ChatGiftMessageExtensionBean chatGiftMessageExtensionBeanQ;
            GreetConfig greetConfigF;
            List<GreetConfig.Word> listC;
            super.onQueryComplete(i, obj, cursor);
            LogUtil.i(ChatterActivity.O1, "onQueryComplete" + i);
            if (i == 0) {
                if ((cursor != null ? cursor.moveToNext() ? cursor.getInt(cursor.getColumnIndex("thread_nodisturb")) : 0 : 0) == 1) {
                    ChatterActivity.this.M.setVisibility(0);
                    return;
                } else {
                    ChatterActivity.this.M.setVisibility(8);
                    return;
                }
            }
            if (i == 1) {
                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        ChatterActivity chatterActivity = ChatterActivity.this;
                        chatterActivity.b3(1, chatterActivity.x0, null);
                    } else {
                        ChatterActivity.this.j3();
                    }
                    return;
                }
                return;
            }
            if (i == 2) {
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            if (cursor.getInt(cursor.getColumnIndex("unread_message_count")) > 0) {
                                z = true;
                            }
                        } finally {
                        }
                    }
                }
                if (z) {
                    ChatterActivity.this.j5();
                    return;
                }
                return;
            }
            if (i == 8) {
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            int i2 = cursor.getInt(cursor.getColumnIndex("unread_message_count"));
                            String string = cursor.getString(cursor.getColumnIndex("thread_draft"));
                            cursor.getLong(cursor.getColumnIndex("thread_latest_unread_message_time"));
                            long j = cursor.getLong(cursor.getColumnIndex("thread_latest_unread_message_primary_key_id"));
                            if (ChatterActivity.this.u.f12685a <= 0 && ((ChatterActivity.this.u.a() == 0 || ChatterActivity.this.u.a() > j) && i2 >= 10 && j > 0)) {
                                ChatterActivity.this.q1.postDelayed(new a(i2, j), 500L);
                            }
                            if (!TextUtils.isEmpty(string) && ChatterActivity.this.v3() != null) {
                                ChatterActivity.this.v3().Y3(string, false);
                            }
                            ChatterActivity.this.L1 = cursor.getInt(cursor.getColumnIndex("thread_active")) == 1;
                            ChatterActivity.this.M1 = cursor.getString(cursor.getColumnIndex("latest_message"));
                        }
                    } finally {
                    }
                }
                if (ChatterActivity.this.x == 14) {
                    ContactInfoItem contactInfoItemL = bo0.r().l(ChatterActivity.this.A.getChatId());
                    boolean z = contactInfoItemL == null || contactInfoItemL.getIsStranger();
                    ContactInfoItem contactInfoItemL2 = bo0.r().l(AccountUtils.p(AppContext.getContext()));
                    if (contactInfoItemL != null && contactInfoItemL2 != null && contactInfoItemL2.getGender() == 0 && contactInfoItemL.getGender() == 1) {
                        z = true;
                    }
                    if (ChatterActivity.this.L1 || !z || !z || (greetConfigF = rl0.h().f()) == null || (listC = greetConfigF.c()) == null) {
                        return;
                    }
                    ChatterActivity.this.v3().Y3(listC.get(new Random().nextInt(listC.size())).b, true);
                    return;
                }
                return;
            }
            if (i != 10) {
                if (i == 9) {
                    if (cursor != null) {
                        if (cursor.moveToNext()) {
                            ChatterActivity.this.C.H0(cursor.getInt(cursor.getColumnIndex("thread_show_members_nick_name")) == 1);
                        }
                        return;
                    }
                    return;
                }
                if (i != 15 || cursor == null) {
                    return;
                }
                if (cursor.getCount() > 0) {
                    ChatterActivity.this.x4();
                }
                while (cursor.moveToNext()) {
                    String string2 = cursor.getString(cursor.getColumnIndex("msg_extend"));
                    String string3 = cursor.getString(cursor.getColumnIndex("packet_id"));
                    if (TextUtils.isEmpty(string3) || !ChatterActivity.this.N1.contains(string3)) {
                        if (!TextUtils.isEmpty(string2) && (chatGiftMessageExtensionBeanQ = GiftMessageHelper.Q(string2)) != null) {
                            ChatterActivity.this.N1.add(string3);
                            ds0.a().b(new fb2(chatGiftMessageExtensionBeanQ, false));
                        }
                    }
                }
                return;
            }
            if (cursor != null) {
                ArrayList<ContactRequestsVO> arrayListBuildFromCursorForShow = ContactRequestsVO.buildFromCursorForShow(cursor);
                cursor.close();
                ContactRequestsVO contactRequestsVOA = a(arrayListBuildFromCursorForShow);
                if (contactRequestsVOA == null || TextUtils.isEmpty(contactRequestsVOA.requestRid)) {
                    ChatterActivity.this.S.setText(R.string.add_as_contact1);
                    if (ChatterActivity.this.l1 != null && ChatterActivity.this.l1.c()) {
                        ChatterActivity.this.S.setText(R.string.add_as_contact_intimacy);
                    }
                    ChatterActivity.this.R.setText(R.string.contact_add_friend3);
                } else if (ContactRequestsVO.isSenderParseFromRid(contactRequestsVOA.requestRid)) {
                    ChatterActivity.this.S.setText(R.string.add_as_contact1);
                    if (ChatterActivity.this.l1 != null && ChatterActivity.this.l1.c()) {
                        ChatterActivity.this.S.setText(R.string.add_as_contact_intimacy);
                    }
                    ChatterActivity.this.R.setText(R.string.contact_add_friend3);
                } else {
                    ChatterActivity.this.S.setText(R.string.agree_as_contact1);
                    ChatterActivity.this.R.setText(R.string.agree_add_contact_request);
                    ChatterActivity.this.R.setTag(contactRequestsVOA);
                    ChatterActivity.this.Z.setTag(contactRequestsVOA);
                }
                ChatterActivity.this.W4();
            }
        }

        @Override // android.content.AsyncQueryHandler
        public void onUpdateComplete(int i, Object obj, int i2) {
            super.onUpdateComplete(i, obj, i2);
            LogUtil.i(ChatterActivity.O1, "onUpdateComplete" + i + " result " + i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            for (MessageVo messageVo : ChatterActivity.this.C.G()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (messageVo.isSend) {
                        jSONObject.put(DeviceInfoUtil.UID_TAG, DomainHelper.q(AccountUtils.p(AppContext.getContext())));
                    } else {
                        jSONObject.put(DeviceInfoUtil.UID_TAG, DomainHelper.q(messageVo.from));
                    }
                    jSONObject.put("msgType", messageVo.mimeType);
                    jSONObject.put(RemoteMessageConst.MSGID, messageVo.mid);
                    String strY2 = ChatterActivity.this.Y2(messageVo);
                    if (TextUtils.isEmpty(strY2)) {
                        i++;
                    }
                    jSONObject.put("msg", strY2);
                    if (messageVo.mimeType == 7) {
                        jSONObject.put("locationInfo", ChatterActivity.this.x3(messageVo));
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            LogUtil.i(ChatterActivity.O1, "report jsonArray=" + jSONArray);
            Intent intent = new Intent();
            intent.putExtra("result", jSONArray.toString());
            ChatterActivity.this.setResult(-1, intent);
            ChatterActivity.this.finish();
            if (i > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("quantity", i);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                zn6.g("lx_complaint_evidencedamage", jSONObject2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qk6 f12553a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("type", 1);
            }
        }

        public n0(qk6 qk6Var) {
            this.f12553a = qk6Var;
        }

        public static /* synthetic */ Object d(ConfigInfoVo configInfoVo) {
            return "收到谁看过我消息通知 fromUid=" + configInfoVo.fromUid + ", vipStatus=" + configInfoVo.vipStatus;
        }

        public static /* synthetic */ Object e(ConfigInfoVo configInfoVo) {
            return "显示谁看过我消息 fromUid=" + configInfoVo.fromUid;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(VipWseemeConfig vipWseemeConfig, qk6 qk6Var) {
            MessageVo messageVoG = defpackage.u0.g(ChatterActivity.this.A);
            messageVoG.status = 2;
            messageVoG.mimeType = 10000;
            messageVoG.text = vipWseemeConfig.sysMsg_notVip.text_out;
            messageVoG.extention = qk6Var.c;
            messageVoG.data1 = "1";
            messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + q05.g(vipWseemeConfig.sysMsg_notVip.text) + "\"}";
            com.zenmen.palmchat.database.b.t(messageVoG);
        }

        @Override // java.lang.Runnable
        public void run() {
            final ConfigInfoVo configInfoVo = this.f12553a.f20273a;
            final VipWseemeConfig vipWseemeConfig = VipWseemeConfig.getVipWseemeConfig();
            b05.c(new b05.a() { // from class: b50
                @Override // b05.a
                public final Object getValue() {
                    return ChatterActivity.n0.d(configInfoVo);
                }
            });
            if (ChatterActivity.this.A.getChatType() == 0 && configInfoVo.fromUid.equals(ChatterActivity.this.A.getChatId())) {
                if (configInfoVo.vipStatus) {
                    this.f12553a.b = true;
                    yk6.k().u(ChatterActivity.this.sInstance);
                    q05.a("seeme_notify", 1, new a());
                } else if (p05.d() && yk6.h(configInfoVo.fromUid)) {
                    b05.c(new b05.a() { // from class: c50
                        @Override // b05.a
                        public final Object getValue() {
                            return ChatterActivity.n0.e(configInfoVo);
                        }
                    });
                    yk6.t(configInfoVo.fromUid);
                    final qk6 qk6Var = this.f12553a;
                    new g13(new Runnable() { // from class: d50
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f16975a.f(vipWseemeConfig, qk6Var);
                        }
                    }).start();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n1 implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12555a;
        public long b;
        public double c;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ChatterActivity chatterActivity = ChatterActivity.this;
            chatterActivity.j1 = true;
            if (i3 != 0) {
                chatterActivity.E.b();
            }
            if (this.f12555a != i) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                double d = (1.0d / (jCurrentTimeMillis - this.b)) * 1000.0d;
                this.c = d;
                this.f12555a = i;
                this.b = jCurrentTimeMillis;
                ChatterActivity.this.C.G0(d);
                Log.d("HUA", "Speed: " + this.c + "elements/second");
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                return;
            }
            ChatterActivity.this.g3();
            ChatterActivity.this.E.c();
        }

        public n1() {
            this.f12555a = 0;
            this.b = 0L;
            this.c = 0.0d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (fu5.u(ChatterActivity.this.A)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("report_type", "click");
                    jSONObject.put("from", fu5.k(ChatterActivity.this.A.getBizType()).domain);
                    if (fu5.q(ChatterActivity.this.A.getBizType())) {
                        jSONObject.put("bizType", ChatterActivity.this.A.getBizType() + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.d("pagechat_complaintbutton", null, jSONObject.toString());
            }
            ChatterActivity chatterActivity = ChatterActivity.this;
            CordovaWebActivity.v2(chatterActivity, 902, fu5.b, chatterActivity.A, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o0 implements Runnable {
        public o0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.g3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o1 implements AudioController.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MessageVo f12558a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatterActivity.this.G0.setVisibility(8);
            }
        }

        public o1() {
        }

        @Override // com.zenmen.palmchat.media.AudioController.q
        public void a() {
            MessageVo messageVoY3 = ChatterActivity.this.y3(this.f12558a);
            if (messageVoY3 == null) {
                ChatterActivity.this.getWindow().clearFlags(128);
            } else {
                ChatterActivity.this.I1.c(messageVoY3);
                AudioController.b0().r0(messageVoY3, ChatterActivity.this.I1, ChatterActivity.this.getMessagingServiceInterface());
            }
        }

        @Override // com.zenmen.palmchat.media.AudioController.q
        public void b(boolean z) {
            if (z) {
                return;
            }
            ChatterActivity.this.G0.setVisibility(0);
            ChatterActivity.this.G0.postDelayed(new a(), com.igexin.push.config.c.j);
        }

        public void c(MessageVo messageVo) {
            this.f12558a = messageVo;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.b("chat_up_remind-cli01");
            com.zenmen.palmchat.utils.a.E().y0(ChatterActivity.this);
            ChatterActivity.this.f0.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.group_redpacket_notice_area);
            ChatterActivity.this.g0.setLayoutParams(layoutParams);
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_single_chat_notification_banner_should_show", Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12561a;

        public p0(int i) {
            this.f12561a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.B.setSelection(this.f12561a + 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p1 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ChatterActivity> f12562a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Comparator<MessageVo> {
            public a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MessageVo messageVo, MessageVo messageVo2) {
                return Long.valueOf(messageVo.get_id()).compareTo(Long.valueOf(messageVo2.get_id()));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends MaterialDialog.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12564a;
            public final /* synthetic */ ChatterActivity b;

            public b(ArrayList arrayList, ChatterActivity chatterActivity) {
                this.f12564a = arrayList;
                this.b = chatterActivity;
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                ArrayList arrayList = this.f12564a;
                if (arrayList != null && arrayList.size() > 0) {
                    Intent intent = new Intent(this.b, (Class<?>) SendMessageActivity.class);
                    intent.putExtra("message_vo_list", this.f12564a);
                    this.b.startActivityForResult(intent, 102);
                } else if (this.b.C.U()) {
                    this.b.C.F0(false, null);
                    this.b.D4();
                }
            }
        }

        public p1(ChatterActivity chatterActivity) {
            this.f12562a = new WeakReference<>(chatterActivity);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
        
            if (r11 != 2) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00e0, code lost:
        
            if (r11 == false) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:105:0x00ef A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0064 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            ChatterActivity chatterActivity = this.f12562a.get();
            if (chatterActivity == null) {
                return;
            }
            int i = message.what;
            String string = null;
            if (i == 1000) {
                ArrayList<MessageVo> arrayListG = chatterActivity.C.G();
                String[] strArr = new String[arrayListG.size()];
                Iterator<MessageVo> it = arrayListG.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    strArr[i2] = it.next().mid;
                    i2++;
                }
                chatterActivity.Z2(strArr);
                chatterActivity.C.F0(false, null);
                chatterActivity.D4();
                return;
            }
            if (i != 1001) {
                if (i == 1002) {
                    chatterActivity.H0.setVisibility(8);
                    return;
                }
                if (i == 1003) {
                    removeMessages(1003);
                    chatterActivity.l5(null);
                    return;
                } else {
                    if (i == 1004) {
                        chatterActivity.Z4();
                        return;
                    }
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<MessageVo> arrayListG2 = chatterActivity.C.G();
            Collections.sort(arrayListG2, new a());
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            for (MessageVo messageVo : arrayListG2) {
                if (f50.P(messageVo) || messageVo.attachStatus == 5) {
                    z3 = true;
                    z = false;
                } else {
                    z = true;
                }
                if (a65.e(chatterActivity.o3())) {
                    int i3 = messageVo.mimeType;
                    if (i3 != 1) {
                    }
                    if (z) {
                        arrayList.add(messageVo);
                    }
                } else {
                    int i4 = messageVo.mimeType;
                    if (i4 != 3) {
                        if (i4 == 35) {
                            z5 = true;
                        } else if ((i4 != 14 || messageVo.data5 == null) && i4 != 9 && i4 != 16 && i4 != 22 && i4 != 17) {
                            if (i4 == 28) {
                                RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
                                boolean z6 = richMsgExVoH != null && richMsgExVoH.forwardable == 0;
                                if (!TextUtils.isEmpty(messageVo.extention) && messageVo.extention.equals("message_type_link_illegal")) {
                                    z2 = true;
                                }
                            } else if (i4 == 10002) {
                                z4 = true;
                            } else if (i4 == 58) {
                            }
                        }
                    }
                    if (z) {
                    }
                }
                z = false;
                if (z) {
                }
            }
            if (z2) {
                new sd3(chatterActivity).j(R.string.string_forward_dialog_illegal).O(R.string.alert_dialog_ok).e().show();
                return;
            }
            if (z3 && z4) {
                string = chatterActivity.getResources().getString(R.string.string_forward_dialog_forbid);
            } else if (z3) {
                string = chatterActivity.getResources().getString(R.string.downloading_before_forward);
            } else if (z4 || z5) {
                string = chatterActivity.getResources().getString(R.string.string_forward_dialog_content);
            }
            if (string != null) {
                new sd3(chatterActivity).k(string).O(R.string.send).M(AppContext.getContext().getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.dialog_cancel).M(AppContext.getContext().getResources().getColor(R.color.material_dialog_positive_color)).f(new b(arrayList, chatterActivity)).e().show();
            } else if (arrayList.size() > 0) {
                Intent intent = new Intent(chatterActivity, (Class<?>) SendMessageActivity.class);
                intent.putExtra("message_vo_list", arrayList);
                chatterActivity.startActivityForResult(intent, 102);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.b("chat_up_remind-cli02");
            Intent intent = new Intent(ChatterActivity.this, (Class<?>) ThreadNotificationGuideActivity.class);
            intent.putExtra("key_notify_style", true);
            ChatterActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q0 implements Runnable {
        public q0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.B.smoothScrollToPosition(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterActivity.this.f0.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.group_redpacket_notice_area);
            ChatterActivity.this.g0.setLayoutParams(layoutParams);
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_single_chat_notification_banner_should_show", Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r0 extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12568a;

        public r0(int i) {
            this.f12568a = i;
            put("sid", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterActivity.this.e0.setVisibility(8);
            ChatterActivity.this.c1 = false;
            ChatterActivity.this.f3();
            hb3.g().l(ChatterActivity.this.A.getChatId(), ChatterActivity.this.e0.getTag() != null);
            if (ChatterActivity.this.e1 != null) {
                ChatterActivity.this.e1.D();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s0 implements Runnable {
        public s0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.w4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t extends HashMap<String, String> {
        public t() {
            put("fuid", ChatterActivity.this.A.getChatId());
            put("type", "alert");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t0 implements Runnable {
        public t0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.D0.forceLoad();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends HashMap<String, Object> {
        public u() {
            put("roomId", ChatterActivity.this.A.getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u0 extends HashMap<String, Object> {
        public u0() {
            put("action", "send_message");
            put("status", "fail");
            put("detail", "sendExpression");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v extends BroadcastReceiver {
        public v() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (((TelephonyManager) context.getSystemService("phone")).getCallState() != 1) {
                return;
            }
            ChatterActivity.this.U4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v0 extends HashMap<String, Object> {
        public v0() {
            put("action", "send_message");
            put("status", "downloadAudioFileByMessageId");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements a.l {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatterActivity.this.u4();
            }
        }

        public w() {
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public ChatterAdapter a() {
            return ChatterActivity.this.r3();
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public ChatItem b() {
            return ChatterActivity.this.o3();
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public void c() {
            ChatterActivity.this.hideBaseProgressBar();
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public void d(String str, boolean z, boolean z2) {
            ChatterActivity.this.showBaseProgressBar(str, z, z2);
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public void e() {
            ChatterActivity.this.u4();
            if (ChatterActivity.this.P != null) {
                ChatterActivity.this.P.postDelayed(new a(), 1000L);
            }
        }

        @Override // com.zenmen.palmchat.chat.fragment.a.l
        public Activity getActivity() {
            return ChatterActivity.this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w0 implements Runnable {
        public w0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterActivity.this.k4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupRedPacketVo f12580a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("roomId", ChatterActivity.this.A.getChatId());
            }
        }

        public x(GroupRedPacketVo groupRedPacketVo) {
            this.f12580a = groupRedPacketVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f12580a.dest)) {
                return;
            }
            LogUtil.uploadInfoImmediate("qhb809", new a());
            ChatterActivity.this.i4(this.f12580a.dest);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x0 extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentValues f12582a;

        public x0(ContentValues contentValues) {
            this.f12582a = contentValues;
            put("fuid", ChatterActivity.this.A.getChatId());
            put("is1v1ConsumeReport", String.valueOf(contentValues.containsKey("is1v1ConsumeReport") && contentValues.getAsBoolean("is1v1ConsumeReport").booleanValue()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupRedPacketVo f12583a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("roomId", ChatterActivity.this.A.getChatId());
            }
        }

        public y(GroupRedPacketVo groupRedPacketVo) {
            this.f12583a = groupRedPacketVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f12583a.redDetailsLink)) {
                return;
            }
            LogUtil.uploadInfoImmediate("qhb810", new a());
            ChatterActivity.this.i4(this.f12583a.redDetailsLink);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y0 extends HashMap<String, String> {
        public y0() {
            put("target_uid", ChatterActivity.this.A.getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements Runnable {
        public z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatterActivity.this.A.getChatType() == 0) {
                ContactInfoItem contactInfoItemL = bo0.r().l(ChatterActivity.this.A.getChatId());
                ChatterActivity chatterActivity = ChatterActivity.this;
                chatterActivity.h3(chatterActivity.A, contactInfoItemL);
                if (contactInfoItemL != null) {
                    ChatterActivity.this.X4(contactInfoItemL);
                    ChatterActivity.this.O3(false);
                    ChatterActivity chatterActivity2 = ChatterActivity.this;
                    chatterActivity2.C.w0(chatterActivity2.A);
                    ChatterActivity.this.l1.e(contactInfoItemL);
                    if (!contactInfoItemL.getIsStranger()) {
                        ChatterActivity.this.l1.f(null);
                    }
                }
            }
            ChatterActivity.this.f3();
            if (ChatterActivity.this.e1 != null) {
                ChatterActivity.this.e1.D();
            }
            ChatterActivity.this.C.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z0 extends HashMap<String, Object> {
        public z0() {
            put("action", "send_message");
            put("status", "cancelSendMessage");
        }
    }

    static {
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mFlingRunnable");
            R1 = declaredField;
            declaredField.setAccessible(true);
            Method declaredMethod = R1.getType().getDeclaredMethod("endFling", new Class[0]);
            S1 = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception unused) {
            S1 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T3(View view) {
        D3(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U3(View view) {
        D3(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V3(View view) {
        D3(2);
    }

    public static void V4(ListView listView) {
        Field field;
        if (S1 == null || (field = R1) == null) {
            return;
        }
        try {
            Object obj = field.get(listView);
            if (obj != null) {
                S1.invoke(obj, new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W3(CircleWarnEvent circleWarnEvent) {
        R4(circleWarnEvent.content, circleWarnEvent.toUid, circleWarnEvent.roomId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X3(CircleGreetEvent circleGreetEvent) {
        ChatItem chatItem = this.A;
        if (chatItem == null || circleGreetEvent == null || !chatItem.getChatId().equals(circleGreetEvent.roomId)) {
            return;
        }
        T4(R.drawable.icon_circle_greet);
    }

    public static /* synthetic */ Object Y3() {
        return "收到WhoVisitMeEvent事件";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z3(Long l2, String str, ContactInfoItem contactInfoItem) {
        int i2 = this.J1;
        if (i2 == 2 || i2 == 3) {
            startActivity(ei4.b(this, null, l2, str, "", 1, contactInfoItem));
            return;
        }
        Intent intentC = ei4.c(null, l2, str, 1, contactInfoItem, i2);
        LogUtil.uploadInfoImmediate("dt12", "1", null, null);
        startActivity(intentC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a4(GroupInfoItem groupInfoItem, ArrayList arrayList) {
        if (CollectionUtils.isEmpty(arrayList)) {
            this.S0.setVisibility(8);
        } else {
            this.S0.setCircleNotices(arrayList, groupInfoItem.getGroupId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b4(ArrayList arrayList) {
        InputFragment inputFragmentV3 = v3();
        if (inputFragmentV3 != null) {
            inputFragmentV3.B3(CollectionUtils.isEmpty(arrayList) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c4(String str, String str2, ViewGroup viewGroup) {
        sc0.c(str, str2);
        viewGroup.removeView(this.B1);
    }

    public final void A3() {
        l92 l92Var = new l92(new e1(), new f1());
        this.N0 = l92Var;
        try {
            l92Var.o(((ContactInfoItem) this.A).getUid(), ((ContactInfoItem) this.A).getExid());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void A4(ArrayList<ExpressionObject> arrayList) {
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ExpressionObject expressionObject = arrayList.get(i2);
                if (TextUtils.isEmpty(expressionObject.tag) && expressionObject.path != null && !new File(expressionObject.path).exists() && arrayList2.size() < 100) {
                    arrayList2.add(String.valueOf(expressionObject._id));
                }
            }
            if (arrayList2.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    if (i3 == arrayList2.size() - 1) {
                        sb.append("_id=?");
                    } else {
                        sb.append("_id=? or ");
                    }
                }
                this.E0.startDelete(11, null, qt1.f20317a, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
    }

    public final void B3(Long l2, String str, c5<ContactInfoItem> c5Var) {
        this.N0 = new l92(new b1(c5Var), new d1());
        try {
            showBaseProgressBar("正在加载", false);
            this.N0.n(str);
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public final void B4() {
        k86.T(this, this.r1, new IntentFilter("android.intent.action.PHONE_STATE"));
    }

    public p1 C3() {
        return this.q1;
    }

    public boolean C4() {
        return this.o1.D();
    }

    public final void D3(int i2) {
        List<DatingGroupToolBeans.DatingGroupToolBean> toolBeans = ((GroupInfoItem) this.A).getTools().getToolBeans();
        if (toolBeans == null || toolBeans.size() <= i2) {
            return;
        }
        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = toolBeans.get(i2);
        if (datingGroupToolBean.getIsSystem() != 0) {
            if (datingGroupToolBean.getIsSystem() == 1) {
                Toast.makeText(this, "暂不支持的群工具", 0).show();
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", datingGroupToolBean.getToolPage());
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void D4() {
        InputFragment inputFragment;
        if (this.w0 != null) {
            this.O.setVisible(true);
            this.C.E0(null);
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.remove(this.w0);
            fragmentTransactionBeginTransaction.show(this.v0);
            ChatItem chatItem = this.A;
            if (chatItem != null && a65.e(chatItem) && (inputFragment = this.v0) != null) {
                fragmentTransactionBeginTransaction.hide(inputFragment);
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            this.w0 = null;
        }
    }

    public final void E3() {
        if (l50.a()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ChatInfoActivity.class);
        intent.putExtra("chat_type", this.A.getChatType());
        if (this.A.getChatType() == 0) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) this.A;
            if (this.x == 22) {
                contactInfoItem.setSourceType(200);
            }
            intent.putExtra("info_item", (ContactInfoItem) this.A);
        } else if (this.A.getChatType() == 1) {
            intent.putExtra("info_item", (GroupInfoItem) this.A);
        }
        startActivityForResult(intent, 103);
    }

    public final void E4() {
        if (this.A.getChatType() == 1) {
            ChatItem chatItem = this.A;
            if (chatItem instanceof GroupInfoItem) {
                oc0.h("lx_group_chat_show", new c(getIntent().getIntExtra("fromType", -1), (GroupInfoItem) chatItem));
            }
        }
    }

    public final void F3() {
        if (l50.a() || this.A.getChatType() != 0) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) TemporaryChatInfoActivity.class);
        intent.putExtra("info_item", (ContactInfoItem) this.A);
        startActivity(intent);
    }

    public final void F4() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("thread_focus", (Integer) 0);
        this.E0.startUpdate(6, null, dx5.f17178a, contentValues, null, null);
    }

    public void G3(ContactInfoItem contactInfoItem) {
        g50 g50Var = this.o1;
        if (g50Var != null) {
            g50Var.i(contactInfoItem);
        }
    }

    public void G4() {
        ChatterAdapter chatterAdapter;
        MessageCursorLoader messageCursorLoader = this.D0;
        if ((messageCursorLoader == null || !messageCursorLoader.e()) && this.B != null && (chatterAdapter = this.C) != null && chatterAdapter.getCount() > 0 && this.B.canScrollVertically(1)) {
            V4(this.B);
            this.B.setAdapter((ListAdapter) this.C);
            this.B.smoothScrollToPosition(this.C.getCount() - 1);
            this.B.setSelection(130);
        }
    }

    public boolean H3() {
        xe2 xe2Var = this.R0;
        if (xe2Var != null) {
            return xe2Var.e();
        }
        return false;
    }

    public void H4(ExpressionObject expressionObject) {
        if (fu2.g(this, InputItemManager.InputItemType.INPUT_ITEM_EXPRESSION)) {
            String strA = xn3.a();
            ChatItem chatItem = this.A;
            if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
                return;
            }
            try {
                getMessagingServiceInterface().r(MessageVo.buildExpressionMessage(strA, DomainHelper.e(this.A), expressionObject, 0, ir5.b()).setThreadBizType(this, this.x));
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.i(O1, 3, new u0(), e2);
            }
        }
    }

    public final void I3() {
        this.u1 = (ImageView) findViewById(R.id.iv_ai_chat);
        this.t1 = (TextView) findViewById(R.id.iv_ai_nick);
        this.v1 = (ImageView) findViewById(R.id.ai_like_img);
        if (this.w1) {
            int iU = v8.u(this.A.getChatId(), v4.e(this));
            this.x1 = iU;
            this.C.u0(iU);
            V2(0);
            this.u1.setOnClickListener(new c1());
            this.v1.setOnClickListener(new i1());
            if (v8.n) {
                this.u1.setVisibility(0);
                Glide.with((FragmentActivity) this).load2(v8.t).error(R.drawable.ai_chat_msg_aitag).into(this.u1);
            } else {
                this.u1.setVisibility(8);
            }
            ChatItem chatItem = this.A;
            if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatName())) {
                this.t1.setText(this.A.getChatName());
            }
            try {
                if (this.A != null) {
                    String strE = v4.e(this);
                    String chatId = this.A.getChatId();
                    if (TextUtils.isEmpty(strE) || TextUtils.isEmpty(chatId)) {
                        return;
                    }
                    v8.H(new j1(), Long.parseLong(strE), Long.parseLong(chatId));
                }
            } catch (Exception unused) {
            }
        }
    }

    public void I4(String str) {
        String strA = xn3.a();
        ChatItem chatItem = this.A;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        try {
            ch.s().u().r(MessageVo.buildTextMessage(strA, DomainHelper.e(this.A), str, null, 0).setThreadBizType(AppContext.getContext(), this.x));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void J3() {
        this.T0 = (ViewGroup) findViewById(R.id.chatCircleTools);
        this.U0 = (ViewGroup) findViewById(R.id.chatCircleToolsGroup1);
        this.V0 = (ViewGroup) findViewById(R.id.chatCircleToolsGroup2);
        this.W0 = (ViewGroup) findViewById(R.id.chatCircleToolsGroup3);
        this.X0 = (EffectiveShapeView) findViewById(R.id.chatCircleToolsTools1);
        this.Y0 = (EffectiveShapeView) findViewById(R.id.chatCircleToolsTools2);
        this.Z0 = (EffectiveShapeView) findViewById(R.id.chatCircleToolsTools3);
        this.U0.setOnClickListener(new View.OnClickListener() { // from class: y40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22117a.T3(view);
            }
        });
        this.V0.setOnClickListener(new View.OnClickListener() { // from class: z40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22341a.U3(view);
            }
        });
        this.W0.setOnClickListener(new View.OnClickListener() { // from class: a50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1153a.V3(view);
            }
        });
    }

    public void J4() {
        InputFragment inputFragment = this.v0;
        if (inputFragment != null) {
            inputFragment.g3(x20.b());
        }
    }

    public final void K3() {
        this.S0 = (CircleNoticeBanner) findViewById(R.id.circle_notice_banner_view);
    }

    public final void K4(String str) {
        if (TextUtils.isEmpty(str) || !zv3.s()) {
            return;
        }
        List<String> listJ = zv3.j();
        if (listJ != null && !listJ.isEmpty() && listJ.contains(str)) {
            this.g1 = 0;
            if (zv3.d == null || zv3.q()) {
                zv3.v(this, this.g1, new l1());
            }
        }
        List<String> listK = zv3.k();
        if (listK != null && !listK.isEmpty() && listK.contains(str)) {
            this.g1 = 2;
            if (zv3.e == null || zv3.r()) {
                zv3.v(this, this.g1, new a());
            }
        }
        List<String> listP = zv3.p();
        if (listP == null || listP.isEmpty() || !listP.contains(str)) {
            return;
        }
        this.g1 = 1;
        if (zv3.f == null || zv3.t()) {
            zv3.v(this, this.g1, new b());
        }
    }

    public final void L3() {
        ChatItem chatItem = this.A;
        if (chatItem == null || chatItem.getChatType() != 1) {
            return;
        }
        this.q1.removeMessages(1004);
        this.j0 = findViewById(R.id.group_redpacket_notice_area);
        GroupRedPacketVo groupRedPacketVoC = te2.c(this.A.getChatId());
        if (groupRedPacketVoC == null) {
            this.j0.setVisibility(8);
            this.t0 = 0L;
            return;
        }
        LogUtil.uploadInfoImmediate("qhb808", new u());
        this.j0.setVisibility(0);
        this.j0.setOnClickListener(new x(groupRedPacketVoC));
        this.k0 = (ImageView) findViewById(R.id.group_redpacket_notice_icon);
        gr2.j().h(groupRedPacketVoC.iconUrl, this.k0, bq6.k());
        TextView textView = (TextView) findViewById(R.id.group_redpacket_notice_title);
        this.l0 = textView;
        textView.setText(groupRedPacketVoC.title);
        TextView textView2 = (TextView) findViewById(R.id.group_redpacket_notice_acount);
        this.m0 = textView2;
        textView2.setText(groupRedPacketVoC.amount);
        TextView textView3 = (TextView) findViewById(R.id.group_redpacket_notice_issue_amount_title);
        this.n0 = textView3;
        textView3.setText(groupRedPacketVoC.issueAmountText);
        TextView textView4 = (TextView) findViewById(R.id.group_redpacket_notice_issue_amount);
        this.o0 = textView4;
        textView4.setText(groupRedPacketVoC.issueAmount);
        this.o0.setOnClickListener(new y(groupRedPacketVoC));
        TextView textView5 = (TextView) findViewById(R.id.group_redpacket_notice_text);
        this.p0 = textView5;
        textView5.setText(groupRedPacketVoC.text);
        this.q0 = findViewById(R.id.group_redpacket_countdown_area);
        this.r0 = (TextView) findViewById(R.id.group_redpacket_countdown_title);
        this.s0 = (TextView) findViewById(R.id.group_redpacket_countdown);
        long j2 = groupRedPacketVoC.countdown;
        this.t0 = j2;
        if (j2 <= 0) {
            this.q0.setVisibility(8);
            return;
        }
        this.q0.setVisibility(0);
        if (!TextUtils.isEmpty(groupRedPacketVoC.countdownText)) {
            this.r0.setText(groupRedPacketVoC.countdownText);
        }
        Z4();
    }

    public final void L4(ViewGroup viewGroup, EffectiveShapeView effectiveShapeView, DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        if (datingGroupToolBean == null || effectiveShapeView == null) {
            return;
        }
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup.LayoutParams layoutParams = effectiveShapeView.getLayoutParams();
        if (datingGroupToolBean.getIsSystem() == 1) {
            layoutParams.width = me1.b(this, 42);
            layoutParams.height = me1.b(this, 42);
        } else {
            layoutParams.width = me1.b(this, 34);
            layoutParams.height = me1.b(this, 34);
        }
        hc2.b(this).load(datingGroupToolBean.getIcon()).error(R.drawable.icon_circle_tools_default).into(effectiveShapeView);
    }

    public final void M3() {
        InputItemManager.f();
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_CAMERA);
    }

    public final void M4(String str) {
        this.H.setVisibility(0);
        this.H.setText(str);
        this.E0.startQuery(0, null, dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.l(this.A)}, null);
    }

    public final void N3() {
        if (this.A.getChatType() != 0 || a65.e(this.A)) {
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.iv_notify_close);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_desc);
        findViewById(R.id.tv_go_open).setOnClickListener(new p());
        findViewById(R.id.iv_notify_help).setOnClickListener(new q());
        imageView.setOnClickListener(new r());
        ExtraInfo extraInfoD = y24.d();
        if (extraInfoD == null) {
            return;
        }
        if (extraInfoD.singleChatBannerShowCloseIcon) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
        textView.setText(extraInfoD.singleChatBannerTitle);
        textView2.setText(extraInfoD.singleChatBannerContent);
    }

    public final void N4() {
        if (oc0.f() && this.A.getChatType() == 1) {
            final GroupInfoItem groupInfoItem = (GroupInfoItem) this.A;
            c70.R().T(groupInfoItem.getGroupId(), new dv0() { // from class: t40
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f20899a.a4(groupInfoItem, (ArrayList) obj);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O3(boolean z2) {
        String strA;
        boolean z3;
        if (this.A.getChatType() != 0 || a65.e(this.A)) {
            return;
        }
        this.e0 = findViewById(R.id.risk_banner_area);
        ContactInfoItem contactInfoItemL = bo0.r().l(this.A.getChatId());
        if (z2) {
            contactInfoItemL = (ContactInfoItem) this.A;
            LogUtil.i(O1, "initRiskBannerLayout  getAccountType " + contactInfoItemL.getAccountType() + " isFromStrangerUserInfoResponse=" + z2);
        }
        if (contactInfoItemL != null && !contactInfoItemL.getIsStranger()) {
            strA = contactInfoItemL.getUid() != null ? y66.b().a(contactInfoItemL) : null;
            if (TextUtils.isEmpty(strA) && hb3.g().j(contactInfoItemL.getUid())) {
                String strF = hb3.g().f();
                if (!TextUtils.isEmpty(strF)) {
                    strA = strF;
                    z3 = true;
                }
            }
            if (!TextUtils.isEmpty(strA) || this.s) {
                this.e0.setVisibility(8);
                this.c1 = false;
                if (this.d1) {
                    return;
                }
                g5();
                return;
            }
            this.e0.setVisibility(0);
            this.c1 = true;
            if (this.d1) {
                g5();
            }
            this.h0 = (TextView) findViewById(R.id.risk_banner_tip);
            if (!TextUtils.isEmpty(strA)) {
                this.h0.setText(strA);
            }
            ImageView imageView = (ImageView) findViewById(R.id.risk_banner_close);
            this.i0 = imageView;
            imageView.setOnClickListener(new s());
            zn6.h("pagechat_top_alertbanner", "view", new t());
            if (!z3) {
                this.e0.setTag(null);
                this.e0.setBackgroundColor(Color.parseColor("#FCE9E9"));
                this.h0.setTextColor(Color.parseColor("#FF463C"));
                return;
            }
            this.e0.setTag("warning");
            this.e0.setBackgroundColor(Color.parseColor("#F7E7D5"));
            this.h0.setTextColor(Color.parseColor("#FF8A3D"));
            HashMap map = new HashMap();
            ChatItem chatItem = this.A;
            map.put("fuid", chatItem != null ? chatItem.getChatId() : "");
            map.put("scene", "frd");
            map.put("window", "full");
            map.put("type", "riskchat");
            zn6.i("risktip_chat", map);
            return;
        }
        strA = null;
        z3 = false;
        if (TextUtils.isEmpty(strA)) {
        }
        this.e0.setVisibility(8);
        this.c1 = false;
        if (this.d1) {
        }
    }

    public final void O4() {
        if (this.A.getChatType() == 1) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) this.A;
            if (groupInfoItem.getMerchantType() == 1) {
                c70.R().Z(groupInfoItem.getGroupId(), new dv0() { // from class: v40
                    @Override // defpackage.dv0
                    public final void onResponse(Object obj) {
                        this.f21351a.b4((ArrayList) obj);
                    }
                });
            }
        }
    }

    public final void P3() {
        if (v8.h() && v8.C(this.A.getChatId())) {
            this.w1 = true;
        }
        this.F = initToolbar(-1);
        this.G = findViewById(R.id.actionbar_title_layout);
        this.H = (TextView) findViewById(R.id.actionbar_title);
        this.I = (TextView) findViewById(R.id.tv_official);
        this.J = (ImageView) findViewById(R.id.iv_vip);
        this.K = (TextView) findViewById(R.id.actionbar_sub_title);
        this.L = (TextView) findViewById(R.id.action_button);
        this.l1 = new l40(this, this.A, this.G, this.w1);
        this.M = (ImageView) findViewById(R.id.actionbar_title_icon);
        ImageView imageView = (ImageView) findViewById(R.id.actionbar_title_icon2);
        this.N = imageView;
        imageView.setVisibility(this.I0 ? 0 : 8);
        this.L.setVisibility(this.s ? 0 : 8);
        if (TextUtils.isEmpty(this.A.getChatName())) {
            M4(this.A.getChatId());
        } else {
            M4(this.A.getChatName());
        }
        ChatItem chatItem = this.A;
        if (chatItem instanceof ContactInfoItem) {
            int iG = fg6.g(((ContactInfoItem) chatItem).getExt());
            if (fg6.q(iG)) {
                this.J.setVisibility(0);
                this.J.setImageResource(fg6.c(iG));
            } else {
                this.J.setVisibility(8);
            }
            if (((ContactInfoItem) this.A).isOfficialAccount()) {
                this.I.setVisibility(0);
                this.H.setTextColor(getResources().getColor(R.color.Gg));
            } else {
                this.I.setVisibility(8);
                this.H.setTextColor(fg6.n(this, iG));
            }
        }
        this.J.setOnClickListener(new b0());
        i5();
        setSupportActionBar(this.F);
    }

    public void P4() {
        InputFragment inputFragment;
        try {
            if (this.A.getChatType() == 0 && fu5.u(this.A) && (inputFragment = this.v0) != null && inputFragment.r2() && this.v0.Q2()) {
                ComplianceBoardBean complianceBoardBeanA = uj0.a();
                if (complianceBoardBeanA == null || complianceBoardBeanA.mSwitch != 1) {
                    this.U.setVisibility(8);
                    return;
                }
                int i2 = complianceBoardBeanA.frequencyType;
                int i3 = complianceBoardBeanA.residentSwitch;
                String strA = iv0.a(System.currentTimeMillis(), "yyyyMMdd");
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.TASK_1V1;
                int iF = sPUtil.f(scene, k86.a("key_chat_compliance_1v1_enter_chat_page_count_" + strA), 0);
                List<Integer> list = complianceBoardBeanA.showPosition;
                long jI = sPUtil.i(scene, k86.a("key_chat_compliance_1v1_board_show_time_stamp_") + this.A.getChatId(), 0L);
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
                    this.U.setVisibility(8);
                    return;
                }
                String str = this.v0.R2() ? complianceBoardBeanA.textPayer : complianceBoardBeanA.textProfit;
                int iA3 = a3();
                if (iA3 > 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    int length = str.length();
                    int i6 = 0;
                    while (i6 < length) {
                        int i7 = i6 + iA3;
                        arrayList.add(str.substring(i6, Math.min(length, i7)));
                        i6 = i7;
                    }
                    this.W.setAutoScrollListener(new h1(i3, arrayList));
                    this.W.stopAutoScroll();
                    if (arrayList.size() > 1) {
                        this.W.setAnim();
                        this.W.setTextList(arrayList);
                        this.W.startAutoScroll();
                    } else {
                        this.W.setNoAnim();
                        this.W.setText(arrayList.get(0));
                    }
                    SPUtil sPUtil2 = SPUtil.f14322a;
                    SPUtil.SCENE scene2 = SPUtil.SCENE.TASK_1V1;
                    sPUtil2.t(scene2, k86.a("key_chat_compliance_1v1_board_show_time_stamp_") + this.A.getChatId(), Long.valueOf(System.currentTimeMillis()));
                    sPUtil2.t(scene2, k86.a("key_chat_compliance_1v1_board_show_count_" + strA), Integer.valueOf(iF2 + 1));
                    this.U.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(3, R.id.ll_compliance_board);
                    this.g0.setLayoutParams(layoutParams);
                    zn6.c("pagechat_civilize_board", "view");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.U.setVisibility(8);
        }
    }

    public final void Q3() {
        this.y1 = new c9(this.A, findViewById(R.id.ai_greeting_profile_float_guide));
        this.h1 = (FrameLayout) findViewById(R.id.large_gift_container);
        this.i1 = (FrameLayout) findViewById(R.id.small_gift_container);
        this.f0 = findViewById(R.id.rl_notify_guide);
        this.g0 = findViewById(R.id.chat_root_layout);
        this.P = findViewById(R.id.add_contact_area);
        this.Q = (ImageView) findViewById(R.id.iv_risk_serious);
        this.R = (TextView) findViewById(R.id.add_contact_btn);
        this.S = (TextView) findViewById(R.id.add_contact_des);
        this.R.setOnClickListener(new d());
        this.U = findViewById(R.id.ll_compliance_board);
        this.W = (LoopTextView) findViewById(R.id.tv_compliance_board);
        this.V = findViewById(R.id.ll_compliance_board_inner);
        this.W.setText(12.0f, 0, Color.parseColor("#FFD75858"), 16);
        this.W.setTextStillTime(com.igexin.push.config.c.j);
        this.W.setFactory();
        this.X = findViewById(R.id.contact_request_layout);
        this.Y = (TextView) findViewById(R.id.contact_request_title);
        TextView textView = (TextView) findViewById(R.id.contact_request_add);
        this.Z = textView;
        textView.setText(R.string.contact_add_friend2);
        this.Z.setOnClickListener(new e());
        this.B = (ListView) findViewById(R.id.message_list);
        this.C0 = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.header_container, (ViewGroup) null, false);
        w20 w20Var = new w20(this);
        this.B0 = w20Var;
        this.B.addHeaderView(w20Var.g());
        this.B.setOnScrollListener(new n1());
        this.B.setOnTouchListener(new f());
        this.p1 = new f50(this.o1);
        ChatterAdapter chatterAdapter = new ChatterAdapter(this, this.A, this.p1, this.s, this.P0, this.e1);
        this.C = chatterAdapter;
        chatterAdapter.A0(new g());
        this.C.t0(this);
        this.C.x0(new h());
        this.B.setAdapter((ListAdapter) this.C);
        if (this.s) {
            this.C.F0(true, null);
            a5(false);
        }
        this.B.setRecyclerListener(new i());
        TextView textView2 = (TextView) findViewById(R.id.unreadTextView);
        this.F0 = textView2;
        textView2.setOnClickListener(new j());
        this.G0 = (TextView) findViewById(R.id.chat_notice_tv);
        this.H0 = findViewById(R.id.chat_notice_receiver_mode);
        T2();
        if (this.x == 14 && r75.d(AppContext.getContext(), k86.a("is_first_enter_greet"), true)) {
            new sd3(this).j(R.string.nearby_greet_dialog_content).T(R.string.nearby_greet_dialog_title).O(R.string.nearby_greet_dialog_got).b(true).f(new l()).e().show();
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.about_feedback);
        this.K0 = linearLayout;
        linearLayout.setOnClickListener(new m());
        this.L.setOnClickListener(new n());
        TextView textView3 = (TextView) findViewById(R.id.report_temp_chat);
        if (textView3 != null) {
            if (!fu5.p(this.A.getBizType()) || this.s) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
            }
            textView3.setOnClickListener(new o());
        }
        O3(false);
        L3();
        K3();
        J3();
        if (jo6.D()) {
            N3();
        }
    }

    public void Q4(boolean z2) {
        ObjectAnimator objectAnimator = this.A1;
        if ((objectAnimator == null || !objectAnimator.isRunning()) && this.z1 != z2) {
            W2(z2);
            this.z1 = z2;
        }
    }

    public boolean R3() {
        ChatItem chatItem = this.A;
        return chatItem != null && a65.e(chatItem);
    }

    public final void R4(String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        if (this.B1 == null) {
            this.B1 = new CircleWarnView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.add_contact_area);
            this.B1.setLayoutParams(layoutParams);
        }
        this.B1.setCloseListener(new CircleWarnView.a() { // from class: s40
            @Override // com.zenmen.palmchat.circle.ui.view.CircleWarnView.a
            public final void a() {
                this.f20662a.c4(str2, str3, viewGroup);
            }
        });
        this.B1.setContent(str);
        if (viewGroup != null) {
            viewGroup.removeView(this.B1);
            viewGroup.addView(this.B1);
        }
    }

    public boolean S3() {
        if (this.A.getChatType() != 0) {
            return false;
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(this.A.getChatId());
        if (contactInfoItemL != null) {
            return contactInfoItemL.getIsStranger();
        }
        return true;
    }

    public void S4() {
        Intent intent = new Intent(this, (Class<?>) GroupChatInitActivity.class);
        intent.putExtra("group_info_item", (GroupInfoItem) this.A);
        intent.putExtra("from_type", 8);
        intent.putExtra("group_choose_contact", true);
        startActivityForResult(intent, 101);
    }

    public final void T2() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        InputFragment inputFragment = new InputFragment();
        this.v0 = inputFragment;
        inputFragment.z3(this.x);
        Bundle bundle = new Bundle();
        bundle.putParcelable(com.umeng.analytics.pro.f.K, this.A);
        bundle.putString("hoc_category_id", this.z);
        bundle.putString("chat_draft", this.x0);
        bundle.putBoolean("chat_is_near", this.M0);
        bundle.putBoolean("useNewAudioUi", this.P0);
        bundle.putString("draft_remind_uids", this.y0);
        bundle.putBoolean("extra_key_from_report", this.s);
        if (fu5.t(this.A.getBizType())) {
            bundle.putBoolean("extra_key_hide_header_add_panel", true);
            bundle.putBoolean("extra_key_enable_gift", fu5.d(this.A.getBizType()));
        }
        this.v0.setArguments(bundle);
        this.v0.t3(this.o1);
        this.v0.s3(this.F1);
        this.v0.v3(new i0());
        fragmentTransactionBeginTransaction.replace(R.id.input_fragment, this.v0, InputFragment.c1);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        this.v0.y3(this.L0);
    }

    public final void T4(@DrawableRes final int i2) {
        if (isPaused()) {
            return;
        }
        if (this.K1 == null) {
            RainSurfaceView rainSurfaceView = new RainSurfaceView(this);
            this.K1 = rainSurfaceView;
            rainSurfaceView.setPowerMode(true);
            this.K1.setDebug(true);
            ((ViewGroup) findViewById(R.id.rainViewLayout)).addView(this.K1, new ViewGroup.LayoutParams(-1, -1));
        }
        if (!this.K1.isRaining()) {
            d4(i2);
        } else {
            this.K1.stopRain();
            this.K1.postDelayed(new Runnable() { // from class: q40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20175a.d4(i2);
                }
            }, 100L);
        }
    }

    public void U2(MessageVo messageVo) {
        MenuItem menuItem;
        ChatterMoreActionFragment chatterMoreActionFragment;
        if (this.w0 != null || (menuItem = this.O) == null) {
            return;
        }
        menuItem.setVisible(false);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        ChatterMoreActionFragment chatterMoreActionFragment2 = new ChatterMoreActionFragment();
        this.w0 = chatterMoreActionFragment2;
        chatterMoreActionFragment2.Y(this.q1);
        this.C.E0(this.w0);
        ChatItem chatItem = this.A;
        if (chatItem != null && chatItem.getChatId() != null && this.A.getChatId().equals("88888003") && (chatterMoreActionFragment = this.w0) != null) {
            chatterMoreActionFragment.W(false);
        }
        fragmentTransactionBeginTransaction.add(R.id.input_fragment, this.w0, ChatterMoreActionFragment.k);
        fragmentTransactionBeginTransaction.hide(this.v0);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public final void U4() {
        MessageVo messageVoD0 = AudioController.b0().d0();
        if (messageVoD0 != null) {
            AudioController.b0().D0();
            AudioController.b0().L0(messageVoD0, 0);
            getWindow().clearFlags(128);
        }
    }

    public final void V2(int i2) {
        ChatterAdapter chatterAdapter;
        if (i2 == 1) {
            this.v1.setImageResource(R.drawable.ai_chat_act_item_like_bg);
        } else if (i2 == 2) {
            this.v1.setImageResource(R.drawable.ai_chat_act_normal_bg);
            if (!this.s) {
                v8.Q(this, this.A);
            }
        } else {
            this.v1.setImageResource(R.drawable.ai_chat_act_normal_bg);
        }
        if (this.x1 == i2 || (chatterAdapter = this.C) == null) {
            return;
        }
        this.x1 = i2;
        chatterAdapter.u0(i2);
        this.C.notifyDataSetChanged();
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.g
    public void W0(String str) {
        ChatItem chatItem = this.A;
        if (chatItem == null || chatItem.getChatType() != 0 || this.A.getChatId() == null || str == null || !str.contains("a0046")) {
            return;
        }
        zn6.h("pagechat_timestamp_alertbubble", "view", new a1(str));
    }

    public final void W2(boolean z2) {
        if (z2) {
            this.A1 = ObjectAnimator.ofFloat(this.F0, "translationX", r7.getWidth(), 0.0f);
        } else {
            this.A1 = ObjectAnimator.ofFloat(this.F0, "translationX", 0.0f, r7.getWidth());
        }
        this.A1.setDuration(200L);
        this.A1.setInterpolator(new AccelerateInterpolator(2.0f));
        this.A1.start();
    }

    public final void W4() {
        RiskConfig riskConfigH;
        if (!hb3.g().i() || (riskConfigH = hb3.g().h()) == null) {
            return;
        }
        boolean z2 = this.R.getTag() != null;
        boolean zJ = hb3.g().j(this.A.getChatId());
        ContactInfoItem contactInfoItemL = bo0.r().l(this.A.getChatId());
        int riskLevel = contactInfoItemL != null ? contactInfoItemL.getRiskLevel() : 0;
        String str = z2 ? riskConfigH.nochat_block_agree : riskConfigH.nochat_block_add;
        boolean z3 = z2;
        if (riskLevel == 40 && !TextUtils.isEmpty(riskConfigH.nofchat_40)) {
            if (!TextUtils.isEmpty(riskConfigH.nofchat_40)) {
                this.S.setText(riskConfigH.nofchat_40);
            }
            this.Q.setVisibility(0);
            this.P.setBackgroundColor(Color.parseColor("#FCE9E9"));
            this.S.setTextColor(Color.parseColor("#FF463C"));
            this.R.setTextColor(Color.parseColor("#FF463C"));
            this.R.setBackgroundResource(R.drawable.shape_small_button_white_normal);
            HashMap map = new HashMap();
            ChatItem chatItem = this.A;
            map.put("fuid", chatItem != null ? chatItem.getChatId() : "");
            map.put("scene", "nofrd");
            map.put("window", "full");
            map.put("type", "risklevel");
            zn6.i("risktip_chat", map);
        } else if (riskLevel == 50 && !TextUtils.isEmpty(riskConfigH.nofchat_50)) {
            if (!TextUtils.isEmpty(riskConfigH.nofchat_50)) {
                this.S.setText(riskConfigH.nofchat_50);
            }
            this.Q.setVisibility(0);
            this.P.setBackgroundColor(Color.parseColor("#FCE9E9"));
            this.S.setTextColor(Color.parseColor("#FF463C"));
            this.R.setTextColor(Color.parseColor("#FF463C"));
            this.R.setBackgroundResource(R.drawable.shape_small_button_white_normal);
            HashMap map2 = new HashMap();
            ChatItem chatItem2 = this.A;
            map2.put("fuid", chatItem2 != null ? chatItem2.getChatId() : "");
            map2.put("scene", "nofrd");
            map2.put("window", "full");
            map2.put("type", "risklevel");
            zn6.i("risktip_chat", map2);
        } else if (!zJ || TextUtils.isEmpty(str)) {
            String str2 = z3 ? riskConfigH.nofchat_agree : riskConfigH.nofchat_add;
            if (!TextUtils.isEmpty(str2)) {
                this.S.setText(str2);
            }
            this.Q.setVisibility(8);
            this.P.setBackgroundColor(-1);
            this.S.setTextColor(-16777216);
            this.R.setTextColor(-1);
            this.R.setBackgroundResource(R.drawable.selector_small_button_green);
        } else {
            this.S.setText(str);
            this.Q.setVisibility(8);
            this.P.setBackgroundColor(Color.parseColor("#F7E7D5"));
            this.S.setTextColor(Color.parseColor("#FF8A3D"));
            this.R.setTextColor(Color.parseColor("#FF8A3D"));
            this.R.setBackgroundResource(R.drawable.shape_small_button_white_normal);
            HashMap map3 = new HashMap();
            ChatItem chatItem3 = this.A;
            map3.put("fuid", chatItem3 != null ? chatItem3.getChatId() : "");
            map3.put("scene", "nofrd");
            map3.put("window", "full");
            map3.put("type", "riskchat");
            zn6.i("risktip_chat", map3);
        }
        String str3 = z3 ? riskConfigH.nofchat_agree_butt : riskConfigH.nofchat_add_butt;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.R.setText(str3);
    }

    public final void X2() {
        Intent intent = new Intent();
        intent.setClass(this, MainTabsActivity.class);
        intent.putExtra("new_intent_position", "tab_msg");
        startActivity(intent);
        finish();
    }

    public final void X4(ChatItem chatItem) {
        ChatItem chatItem2 = this.A;
        if (chatItem2 == null || chatItem == null) {
            return;
        }
        if (!(chatItem instanceof ContactInfoItem)) {
            if (chatItem instanceof GroupInfoItem) {
                this.A = chatItem;
                InputFragment inputFragment = this.v0;
                if (inputFragment != null) {
                    inputFragment.T3(chatItem);
                    return;
                }
                return;
            }
            return;
        }
        if (!fu5.u(chatItem2) || (!fu5.k(this.A.getBizType()).saveInTempTable && !((ContactInfoItem) chatItem).getIsStranger())) {
            this.A = chatItem;
            int bizType = chatItem.getBizType();
            this.x = bizType;
            InputFragment inputFragment2 = this.v0;
            if (inputFragment2 != null) {
                inputFragment2.z3(bizType);
                return;
            }
            return;
        }
        int bizType2 = this.A.getBizType();
        ContactInfoItem contactInfoItemM792clone = ((ContactInfoItem) chatItem).m792clone();
        contactInfoItemM792clone.setBizType(bizType2);
        contactInfoItemM792clone.setSourceType(fu5.n(bizType2));
        this.A = contactInfoItemM792clone;
        InputFragment inputFragment3 = this.v0;
        if (inputFragment3 != null) {
            inputFragment3.U3(contactInfoItemM792clone, true);
        }
    }

    public final String Y2(MessageVo messageVo) {
        ArrayList<RichMsgExItemVo> arrayList;
        int i2 = messageVo.mimeType;
        if (i2 == 3) {
            return me3.d(messageVo.data3).b;
        }
        if (i2 == 7) {
            return messageVo.data2;
        }
        if (i2 == 2) {
            return me3.d(messageVo.data3).b;
        }
        if (i2 == 1) {
            return messageVo.text;
        }
        if (i2 == 9) {
            ChatItem chatItemFromNameCardString = MessageVo.parseChatItemFromNameCardString(messageVo.extention);
            return (chatItemFromNameCardString != null ? chatItemFromNameCardString.getChatName() : "") + "——" + getResources().getString(R.string.message_item_name_card_title);
        }
        if (i2 == 6) {
            return !TextUtils.isEmpty(messageVo.data3) ? messageVo.data3 : !TextUtils.isEmpty(messageVo.data1) ? new File(messageVo.data1).exists() ? !TextUtils.isEmpty(messageVo.data2) ? me3.d(messageVo.data2).b : messageVo.data1 : messageVo.text : messageVo.text;
        }
        if (i2 == 4) {
            return me3.d(messageVo.data3).b;
        }
        if (i2 != 28) {
            return i2 == 14 ? me3.d(messageVo.data3).b : messageVo.text;
        }
        RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
        return (richMsgExVoH == null || (arrayList = richMsgExVoH.items) == null) ? messageVo.text : arrayList.get(0).url;
    }

    public final void Y4(Cursor cursor) {
        this.u0.clear();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                ContactInfoItem contactInfoItemA = ie2.a(cursor);
                this.u0.put(contactInfoItemA.getUid(), contactInfoItemA);
            } while (cursor.moveToNext());
        }
        this.R0.l();
    }

    public final void Z2(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 == strArr.length - 1) {
                sb.append("packet_id=?");
            } else {
                sb.append("packet_id=? or ");
            }
            try {
                getMessagingServiceInterface().s(strArr[i2]);
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.i(O1, 3, new z0(), e2);
            }
        }
        AppContext.getContext().getContentResolver().delete(DBUriManager.b(ho3.class, this.A), sb.toString(), strArr);
    }

    public void Z4() {
        TextView textView;
        if (isFinishing() || (textView = this.s0) == null) {
            return;
        }
        textView.setText(te2.d(this.t0));
        if (ir5.c(true) < this.t0) {
            this.q1.sendEmptyMessageDelayed(1004, 1000L);
        }
    }

    public final int a3() {
        try {
            return (getResources().getDisplayMetrics().widthPixels - a46.b(AppContext.getContext(), 63.0f)) / ((int) this.W.getTextPaint().measureText("平台", 0, 1));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final void a5(boolean z2) {
        View viewFindViewById = findViewById(R.id.input_fragment);
        if (viewFindViewById != null) {
            if (!z2 || this.s) {
                viewFindViewById.setVisibility(8);
            } else {
                viewFindViewById.setVisibility(0);
            }
        }
    }

    @qm5
    public void aiChatEvent(r8 r8Var) {
        if (r8Var == null || r8Var.a() != 2) {
            return;
        }
        LogUtil.d("AiChatPeopleManagerTag", "ChatterActivity aiChatEvent TYPE_MSG_BUY_SUCCESS");
        u93.c(new k1(r8Var));
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.g
    public void b1(String str, int i2, ContentValues contentValues, y56 y56Var) {
        this.o1.j(i2, contentValues, y56Var, str, null, true, null, false);
        ChatItem chatItem = this.A;
        if (chatItem != null) {
            if (a65.e(chatItem)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DeviceInfoUtil.UID_TAG, this.A.getChatId());
                    jSONObject.put("showType", 10);
                    jSONObject.put("isAds5", false);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("H11", null, null, jSONObject.toString());
                return;
            }
            if (this.A.getChatId() != null && this.A.getChatType() == 0 && contentValues != null && "a0046".equals(contentValues.getAsString("page"))) {
                zn6.h("pagechat_timestamp_complaintbutton", "click", new x0(contentValues));
                return;
            }
            if (this.A.getChatId() != null && contentValues != null && "a0052".equals(contentValues.getAsString("page")) && "bubble".equals(contentValues.getAsString("pkgId"))) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
                    jSONObject2.put("svip_status", fg6.d(AppContext.getContext()) ? 1 : 0);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                zn6.f("bubble_sysmsg_click", "click", jSONObject2);
                return;
            }
            if (this.A.getChatId() != null && contentValues != null && "a0622".equals(contentValues.getAsString("page"))) {
                if (v3() != null) {
                    v3().k3(y56Var.g());
                }
            } else if (this.A.getChatId() != null && contentValues != null && contentValues.containsKey("isComplain") && contentValues.getAsBoolean("isComplain").booleanValue()) {
                zn6.h("banned_complain", "click", new y0());
            } else {
                if (this.A.getChatId() == null || contentValues == null || !"a0052".equals(contentValues.getAsString("page")) || !"wseem".equals(contentValues.getAsString("pkgId"))) {
                    return;
                }
                q05.a("seeme_system_msg", 2, null);
            }
        }
    }

    public final void b3(int i2, String str, Set<String> set) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_message_count", (Integer) 0);
        contentValues.put("thread_latest_unread_message_time", (Integer) 0);
        contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
        contentValues.put("thread_has_remind", (Integer) 0);
        contentValues.put("is_super_greetings", (Integer) 0);
        contentValues.put("has_unread_gift_message", (Integer) 0);
        CircleNoticeItem.circleThreadHasNoticeStatus(this.A.getChatId(), 0);
        VoucherRedPacketVo.circleThreadHasVoucherStatus(this.A.getChatId(), 0);
        contentValues.put("thread_focus", Integer.valueOf(i2));
        boolean zI3 = i3(str);
        contentValues.put("thread_draft", zI3 ? str : "");
        if (zI3) {
            contentValues.put("thread_active", (Integer) 1);
            String str2 = this.x0;
            if (str != str2 && !str.equals(str2)) {
                contentValues.put("thread_draft_time", Long.valueOf(ir5.b()));
            }
        } else {
            contentValues.put("thread_draft_time", (Integer) 0);
        }
        if (set != null && !set.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            contentValues.put("thread_draft_remind_uids", jSONArray.toString());
        }
        this.E0.startUpdate(4, null, dx5.f17178a, contentValues, "contact_relate=?", new String[]{DomainHelper.l(this.A)});
    }

    public void b5() {
        this.O0.g();
    }

    public void c3() {
        this.E0.startQuery(1, null, dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.l(this.A)}, null);
    }

    public void c5(String str) {
        this.E.g(str);
    }

    public final void d3() {
        if (this.A.getChatType() == 1) {
            ChatItem chatItem = this.A;
            if (chatItem instanceof GroupInfoItem) {
                GroupInfoItem groupInfoItem = (GroupInfoItem) chatItem;
                boolean z2 = groupInfoItem.getGroupExtTypeFromExtension() == 2;
                if (z2 && !TextUtils.isEmpty(groupInfoItem.getGroupId())) {
                    SPUtil sPUtil = SPUtil.f14322a;
                    SPUtil.SCENE scene = SPUtil.SCENE.VENUS;
                    long jI = sPUtil.i(scene, k86.a("key_family_enter_time" + groupInfoItem.getGroupId()), 0L);
                    if (this.A0 && jI <= 0) {
                        n4(groupInfoItem.getGroupId(), true, groupInfoItem.getMemberCount());
                        sPUtil.t(scene, k86.a("key_family_enter_time" + groupInfoItem.getGroupId()), Long.valueOf(System.currentTimeMillis()));
                    }
                }
                if (this.A0) {
                    HashMap map = new HashMap();
                    map.put("type", Integer.valueOf(z2 ? 2 : 1));
                    map.put("groupid", groupInfoItem.getGroupId());
                    zn6.j("group_voicepartyicon", "view", map);
                }
            }
        }
        this.A0 = false;
    }

    public final void d5() {
        List<String> listQ;
        ChatterAdapter chatterAdapter = this.C;
        if (chatterAdapter == null || (listQ = chatterAdapter.q()) == null || listQ.size() <= 0) {
            return;
        }
        com.zenmen.palmchat.database.b.G((String[]) listQ.toArray(new String[listQ.size()]), this.A);
        listQ.clear();
    }

    public final void e3(String str) {
        if (oc0.f()) {
            c70.R().G0(Long.parseLong(str), new g1());
        }
    }

    public final void e4() {
        MessageCursorLoader messageCursorLoader = this.D0;
        if (messageCursorLoader == null || !messageCursorLoader.isStarted() || this.D0.e() || this.D0.f()) {
            return;
        }
        this.D0.g();
        this.B.postDelayed(new t0(), 500L);
    }

    public final void e5() {
        if (oc0.f()) {
            ChatItem chatItem = this.A;
            if (chatItem instanceof GroupInfoItem) {
                GroupInfoItem groupInfoItem = (GroupInfoItem) chatItem;
                View viewFindViewById = findViewById(R.id.circle_mute_block);
                if (groupInfoItem.getDiffuse() == 1) {
                    if (groupInfoItem.getRoleType() == 3) {
                        viewFindViewById.setVisibility(0);
                        this.v0.u2();
                        return;
                    } else {
                        viewFindViewById.setVisibility(8);
                        this.v0.H3();
                        return;
                    }
                }
                String strP = AccountUtils.p(this);
                if (this.u0.containsKey(strP)) {
                    if (this.u0.get(strP).getMuteStatus() != 1) {
                        viewFindViewById.setVisibility(8);
                        this.v0.H3();
                    } else {
                        viewFindViewById.setVisibility(0);
                        ((TextView) findViewById(R.id.circle_mute_status_tv)).setText("您已被禁言");
                        this.v0.u2();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f3() {
        boolean z2;
        boolean zA;
        InputFragment inputFragment;
        b05.d(" checkIfNeedShowAddFriendView()");
        if (this.A.getChatType() == 0) {
            ContactInfoItem contactInfoItemL = bo0.r().l(this.A.getChatId());
            if (!fu5.u(this.A) || (inputFragment = this.v0) == null) {
                z2 = true;
                if (this.c1 || !((contactInfoItemL == null || contactInfoItemL.getIsStranger()) && z2 && !this.s)) {
                    if (!fu5.t(this.x)) {
                        this.x = 0;
                        this.v0.z3(0);
                        this.v0.C3();
                    }
                    a5(true);
                    this.P.setVisibility(8);
                    b05.d("4");
                    this.X.setVisibility(8);
                    if (this.d1) {
                        g5();
                    }
                } else if (this.x == 22) {
                    this.P.setVisibility(8);
                    b05.d("1");
                    a5(false);
                    if (!this.G1) {
                        this.G1 = true;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("fuid", this.A.getChatId());
                            LogUtil.uploadInfoImmediate("555", null, null, jSONObject.toString());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.X.setVisibility(0);
                    this.Y.setText(getString(R.string.chat_contact_request_title, this.A.getChatName()));
                    if (this.d1) {
                        g5();
                    }
                } else {
                    if (TextUtils.isEmpty(n3())) {
                        zA = false;
                    } else {
                        zA = SPUtil.f14322a.a(SPUtil.SCENE.CHAT_GUIDE, k86.a("chat_add_contact_close" + n3()), false);
                    }
                    if (fu5.u(this.A)) {
                        if (fu5.p(this.A.getBizType())) {
                            if (zA || this.T) {
                                this.P.setVisibility(8);
                                b05.d("3");
                            } else {
                                b05.d(" mAddContactArea.setVisibility(View.VISIBLE);2");
                                this.P.setVisibility(0);
                            }
                            if (this.d1) {
                                g5();
                            }
                        }
                    } else if (zA || this.T) {
                        this.P.setVisibility(8);
                        b05.d("2");
                    } else {
                        b05.d(" mAddContactArea.setVisibility(View.VISIBLE);1");
                        this.P.setVisibility(0);
                    }
                    if (this.P.getVisibility() == 0) {
                        W4();
                    }
                    a5(true);
                }
            } else {
                if (inputFragment.r2()) {
                    if (this.v0.Q2()) {
                        b05.d("能显示");
                    }
                    z2 = true;
                    if (this.c1) {
                        if (!fu5.t(this.x)) {
                        }
                        a5(true);
                        this.P.setVisibility(8);
                        b05.d("4");
                        this.X.setVisibility(8);
                        if (this.d1) {
                        }
                    }
                } else {
                    b05.d("不能显示");
                }
                z2 = false;
                if (this.c1) {
                }
            }
        }
        b05.d("checkIfNeedShowAddFriendView(2)");
    }

    public final void f4(Intent intent) {
        String str;
        RichMsgExVo richMsgExVoG;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        String str2;
        ChatItem chatItem;
        ContactInfoItem contactInfoItemL;
        ChatItem chatItem2 = (ChatItem) intent.getParcelableExtra("chat_item");
        this.A = chatItem2;
        if (chatItem2 == null) {
            return;
        }
        if (chatItem2.getChatType() == 0 && this.A.getBizType() == 0) {
            ju2.h(this.A.getChatId());
        }
        this.z = intent.getStringExtra("hoc_category_id");
        this.v = (ContactInfoItem) intent.getParcelableExtra("send_name_card");
        this.t = intent.getLongExtra("chat_first_message", 0L);
        long longExtra = intent.getLongExtra("chat_first_message_primary_id", 0L);
        this.x0 = intent.getStringExtra("chat_draft");
        this.y0 = intent.getStringExtra("draft_remind_uids");
        this.q = intent.getBooleanExtra("chat_need_back_to_main", true);
        this.r = intent.getBooleanExtra("chat_back_to_greet", true);
        this.s = intent.getBooleanExtra("chat_from_report", false);
        String stringExtra = intent.getStringExtra("extension");
        this.w = intent.getStringExtra("greet_message");
        this.a1 = intent.getStringExtra("extra_key_square_feed");
        String stringExtra2 = intent.getStringExtra("extra_key_chatone_info");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.b1 = (ChatOneItemVo) az2.a(stringExtra2, ChatOneItemVo.class);
        }
        this.m1 = intent.getIntExtra("chat_mate_activity_from", 13);
        this.n1 = intent.getIntExtra("chat_mate_need_send_gift", 0);
        this.L0 = intent.getIntExtra("superExposeMsgTabItem", -1);
        if (this.A.getChatType() == 0 && (contactInfoItemL = bo0.r().l(this.A.getChatId())) != null) {
            X4(contactInfoItemL);
            this.Q0 = contactInfoItemL.getMobile();
        }
        int intExtra = intent.getIntExtra("thread_biz_type", 0);
        this.x = intExtra;
        if (this.L0 == -1 && fu5.s(intExtra)) {
            this.L0 = 1;
        }
        this.y = this.x;
        this.f1 = intent.getStringExtra("chat_from");
        String stringExtra3 = intent.getStringExtra("chat_notification_mid");
        this.u = new MessageCursorLoader.b(longExtra, (stringExtra3 == null || (chatItem = this.A) == null || !a65.e(chatItem) || !jo6.a("LX-30834", false)) ? null : stringExtra3);
        String str3 = this.f1;
        if (str3 != null && str3.equals("CHAT_FROM_NOTIFICATION")) {
            ChatItem chatItem3 = this.A;
            if (chatItem3 != null && chatItem3.getChatType() == 0) {
                if ("88888000".equals(this.A.getChatId())) {
                    LogUtil.uploadInfoImmediate("p31", null, null, null);
                }
                if ("88888888".equals(this.A.getChatId()) && (richMsgExVoG = com.zenmen.palmchat.chat.g.g(stringExtra)) != null && (arrayList = richMsgExVoG.items) != null && arrayList.size() > 0 && (richMsgExItemVo = richMsgExVoG.items.get(0)) != null && (str2 = richMsgExItemVo.url) != null) {
                    String queryParameter = Uri.parse(str2).getQueryParameter("type");
                    if ("redBubble1".equals(queryParameter)) {
                        LogUtil.uploadInfoImmediate("hbd10", null, null, null);
                    }
                    if ("redBubble2".equals(queryParameter)) {
                        LogUtil.uploadInfoImmediate("hbd11", null, null, null);
                    }
                    if ("redBubble3".equals(queryParameter)) {
                        LogUtil.uploadInfoImmediate("hbd12", null, null, null);
                    }
                }
            }
            ChatItem chatItem4 = this.A;
            if (chatItem4 != null && chatItem4.getChatType() == 0 && bo0.r().p().size() > 0 && bo0.r().l(this.A.getChatId()) == null) {
                X2();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mid", stringExtra3);
                ChatItem chatItem5 = this.A;
                if (chatItem5 != null) {
                    jSONObject.put("fromuid", chatItem5.getChatId());
                    if (h05.c(this.A.getChatId())) {
                        jSONObject.put("type", "H-feedpush");
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("msg_cli", "1", null, jSONObject.toString());
            vt0.d().i(3, jSONObject.toString());
        }
        ChatItem chatItem6 = this.A;
        if (chatItem6 != null && chatItem6.getChatType() == 0 && (str = this.f1) != null && str.equals("CHAT_FROM_MISSED_CALL_NOTIFICATION")) {
            LogUtil.uploadInfoImmediate("802", "1", null, null);
        }
        ChatItem chatItem7 = this.A;
        if (chatItem7 != null && a65.e(chatItem7)) {
            this.o1.y("view", null, null, null);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, this.A.getChatId());
                jSONObject2.put("mid", stringExtra3);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H110", "1", null, jSONObject2.toString());
        }
        this.E = new r30(this.A);
    }

    public final void f5() {
        if (this.e0.getVisibility() == 8) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
            if ((sPUtil.a(scene, "thread_single_chat_notification_banner_should_show", false) && s34.c() != 1) || ((this.f0.getVisibility() == 0 && s34.c() != 1) || y24.i(false))) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, R.id.rl_notify_guide);
                this.g0.setLayoutParams(layoutParams);
                this.f0.setVisibility(0);
                y24.l(false);
                sPUtil.t(scene, "thread_single_chat_notification_banner_should_show", Boolean.TRUE);
                zn6.b("chat_up_remind-show");
                return;
            }
        }
        this.f0.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, R.id.group_redpacket_notice_area);
        this.g0.setLayoutParams(layoutParams2);
        SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_single_chat_notification_banner_should_show", Boolean.FALSE);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        int i2;
        ChatterAdapter chatterAdapter = this.C;
        if (xg5.e().a(this, this.A, new w0(), chatterAdapter != null ? chatterAdapter.getCount() : 0)) {
            return;
        }
        if (!r75.k()) {
            if (this.q) {
                this.needCheckFinishJump = false;
                if (AccountUtils.r(this)) {
                    Intent intent = new Intent();
                    intent.setClass(this, MainTabsActivity.class);
                    intent.putExtra("new_intent_position", "tab_msg");
                    if (!R3()) {
                        intent.putExtra("from_Chatter", true);
                    }
                    startActivity(intent);
                }
            } else if (this.r && ((i2 = this.x) == 13 || i2 == 14 || i2 == 17)) {
                startActivity(new Intent(this, (Class<?>) GreetingsThreadsActivity.class));
            }
        }
        super.finish();
    }

    public final void g3() {
        MessageCursorLoader messageCursorLoader;
        ListView listView = this.B;
        if (listView == null || listView.getFirstVisiblePosition() != 0 || (messageCursorLoader = this.D0) == null || !messageCursorLoader.b()) {
            return;
        }
        e4();
    }

    public void g4(MessageVo messageVo, Object obj) {
        if (com.zenmen.palmchat.videocall.c.f()) {
            return;
        }
        String str = messageVo.data2;
        boolean z2 = !TextUtils.isEmpty(str) && new File(str).exists();
        boolean z3 = messageVo.isSend;
        if ((z3 || messageVo.attachStatus != 2 || !z2) && (!z3 || !z2)) {
            try {
                getMessagingServiceInterface().l(messageVo);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.i(O1, 3, new v0(), e2);
                return;
            }
        }
        AudioController.p pVar = obj != null ? (AudioController.p) obj : null;
        if (pVar == null) {
            if (messageVo.attachPlaying == 1) {
                if (this.I0) {
                    this.q1.sendEmptyMessage(1002);
                }
                if (this.P0) {
                    AudioController.b0().x0(messageVo.mid, AudioController.b0().c0(messageVo.mid));
                }
                AudioController.b0().D0();
                AudioController.b0().L0(messageVo, 0);
                getWindow().clearFlags(128);
                return;
            }
            if (this.I0) {
                this.H0.setVisibility(0);
                this.q1.sendEmptyMessageDelayed(1002, 2000L);
            }
            if (AudioController.b0().i0(messageVo.mid) == 0) {
                AudioController.b0().W();
            }
            AudioController.b0().D0();
            this.I1.c(messageVo);
            if (AudioController.b0().r0(messageVo, this.I1, getMessagingServiceInterface())) {
                getWindow().addFlags(128);
                return;
            }
            return;
        }
        int i2 = pVar.b;
        if (i2 == AudioController.p.d) {
            AudioController.b0().F0(messageVo);
            return;
        }
        if (i2 == AudioController.p.e) {
            AudioController.b0().x0(messageVo.mid, pVar.c);
            if (this.I0) {
                this.H0.setVisibility(0);
                this.q1.sendEmptyMessageDelayed(1002, 2000L);
            }
            AudioController.b0().M0();
            this.I1.c(messageVo);
            if (AudioController.b0().r0(messageVo, this.I1, getMessagingServiceInterface())) {
                getWindow().addFlags(128);
                return;
            }
            return;
        }
        if (i2 == AudioController.p.f) {
            AudioController.b0().M0();
            if (this.P0) {
                AudioController.b0().x0(messageVo.mid, pVar.c);
            }
            if (messageVo.attachPlaying == 1) {
                if (this.I0) {
                    this.q1.sendEmptyMessage(1002);
                }
                AudioController.b0().D0();
                AudioController.b0().L0(messageVo, 0);
                getWindow().clearFlags(128);
                return;
            }
            if (this.I0) {
                this.H0.setVisibility(0);
                this.q1.sendEmptyMessageDelayed(1002, 2000L);
            }
            AudioController.b0().D0();
            this.I1.c(messageVo);
            if (AudioController.b0().r0(messageVo, this.I1, getMessagingServiceInterface())) {
                getWindow().addFlags(128);
            }
        }
    }

    public final void g5() {
        if (!this.c1 && jo6.D() && this.A.getChatType() == 0 && !fu5.u(this.A) && !a65.e(this.A)) {
            f5();
            return;
        }
        this.f0.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.group_redpacket_notice_area);
        this.g0.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 103;
    }

    public final void h3(ChatItem chatItem, ContactInfoItem contactInfoItem) {
        if (!(chatItem instanceof ContactInfoItem) || !((ContactInfoItem) chatItem).getIsStranger() || contactInfoItem == null || contactInfoItem.getIsStranger()) {
            return;
        }
        com.zenmen.palmchat.miniwidget.a.f().c(this, 3);
    }

    public void h4() {
        this.I0 = !this.I0;
        AppContext.getContext().getTrayPreferences().i("receiver_mode", this.I0);
        AudioController.b0().y0(this.I0);
        this.N.setVisibility(this.I0 ? 0 : 8);
        sy5.e(this, this.I0 ? R.string.chat_notice_audio_play_out_receiver : R.string.chat_notice_audio_play_out_speaker, 0).g();
    }

    public final void h5() {
        if (this.A.getChatType() == 1) {
            this.E0.startQuery(9, null, dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.l(this.A)}, null);
        }
    }

    public final boolean i3(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i4(String str) {
        Pair<Integer, ContentValues> pairG = mb4.g(str);
        if (pairG != null) {
            int iIntValue = ((Integer) pairG.first).intValue();
            ContentValues contentValues = (ContentValues) pairG.second;
            if (iIntValue == 3) {
                if ("a0052".equals(contentValues.getAsString("page"))) {
                    ve.y(this, contentValues, false, this.A);
                }
            } else if (iIntValue == -1) {
                zy4.l(this, str, null, false, false);
            } else if (iIntValue == 10) {
                ve.s(this, str, false);
            }
        }
    }

    public final void i5() {
        String strM = fu5.m(this.A.getBizType());
        if (TextUtils.isEmpty(strM)) {
            this.K.setVisibility(8);
            this.l1.f(null);
        } else {
            this.K.setVisibility(0);
            this.K.setText(strM);
            this.l1.f(strM);
        }
    }

    public final void j3() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_relate", DomainHelper.l(this.A));
        contentValues.put("unread_message_count", (Integer) 0);
        contentValues.put("thread_latest_unread_message_time", (Integer) 0);
        contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
        contentValues.put("thread_focus", (Integer) 1);
        contentValues.put("thread_active", (Integer) 0);
        contentValues.put("thread_biz_type", Integer.valueOf(this.x));
        contentValues.put("chat_type", Integer.valueOf(this.A.getChatType()));
        contentValues.put("icon_url", this.A.getIconURL());
        contentValues.put("title", this.A.getChatName());
        contentValues.put("thread_contact_ready", Boolean.TRUE);
        contentValues.put("thread_priority", Integer.valueOf(jw5.j(this.A.getSessionConfig()) ? 100 : 0));
        contentValues.put("thread_nodisturb", Boolean.valueOf(jw5.g(this.A.getSessionConfig())));
        contentValues.put("thread_blacklist", Boolean.valueOf(jw5.e(this.A.getSessionConfig())));
        contentValues.put("thread_action_type", "ACTION_TYPE_REQUEST_FOCUS");
        this.E0.startInsert(7, null, dx5.f17178a, contentValues);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: j4, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        String str;
        ChatterAdapter chatterAdapter;
        boolean z2 = false;
        if (loader.getId() == 1 && cursor != null) {
            LogUtil.i("MessageCursorLoader_lag", "MessageCursorLoader onLoadFinished ");
            LogUtil.d("AiChatPeopleManagerTag", "onLoadFinished count:" + cursor.getCount());
            LogUtil.d(O1, "onLoadFinished count:" + cursor.getCount());
            if (this.C.getCount() > 0) {
                ChatterAdapter chatterAdapter2 = this.C;
                this.H1 = chatterAdapter2.getItem(chatterAdapter2.getCount() - 1).mid;
            } else if (cursor.getCount() == 0) {
                this.H1 = "";
            }
            N4();
            O4();
            if (this.C.getCount() > cursor.getCount()) {
                this.B.postDelayed(new o0(), 200L);
            }
            ChatterAdapter chatterAdapter3 = this.C;
            int i2 = this.g1;
            MessageCursorLoader messageCursorLoader = this.D0;
            chatterAdapter3.y0(cursor, i2, messageCursorLoader != null && messageCursorLoader.b());
            this.E.e(this.C.I());
            this.O0.h(this.C.I());
            if (this.z0) {
                int iS3 = s3();
                if (iS3 < 0) {
                    G4();
                } else if (this.B != null && (chatterAdapter = this.C) != null && chatterAdapter.getCount() > 0) {
                    this.B.post(new p0(iS3));
                }
                this.z0 = false;
            }
            MessageCursorLoader messageCursorLoader2 = this.D0;
            if (messageCursorLoader2 != null) {
                if (this.B0 != null) {
                    if (messageCursorLoader2.b()) {
                        this.B0.l();
                    } else {
                        this.B0.h(this.A.getChatType() == 0 ? (ContactInfoItem) this.A : null, this.A.getChatType() == 0 && !a65.e(this.A));
                    }
                }
                if (this.D0.e()) {
                    if (this.B != null && this.D0.a() > 0) {
                        w20 w20Var = this.B0;
                        this.B.setSelectionFromTop(this.D0.a() + 1, w20Var != null ? w20Var.g().getHeight() : 0);
                    }
                    this.D0.j(false);
                }
                if (this.D0.f()) {
                    if (this.B != null && this.D0.a() > 0) {
                        this.B.postDelayed(new q0(), 200L);
                    }
                    this.D0.k(false);
                    ListView listView = this.B;
                    if (listView != null) {
                        listView.setTranscriptMode(1);
                    }
                }
            }
            ListView listView2 = this.B;
            if (listView2 != null) {
                listView2.postDelayed(new s0(), 1000L);
            }
        } else if (loader.getId() == 2 && cursor != null) {
            String str2 = O1;
            StringBuilder sb = new StringBuilder();
            sb.append("GROUP_MEMBERS_LOADER_ID");
            sb.append(cursor);
            sb.append("  " + cursor.getCount());
            LogUtil.i(str2, sb.toString());
            Y4(cursor);
            this.C.C0((GroupInfoItem) this.A, this.u0);
            this.v0.r3(this.u0);
            this.C.notifyDataSetChanged();
            m5();
            e5();
        } else if (loader.getId() == 3) {
            String str3 = O1;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GROUP_INFO_LOADER_ID");
            sb2.append(cursor);
            if (cursor != null) {
                str = "  " + cursor.getCount();
            } else {
                str = " null";
            }
            sb2.append(str);
            LogUtil.i(str3, sb2.toString());
            if (cursor != null) {
                if (cursor.getCount() <= 0) {
                    sy5.h(this, "未查询到群聊信息", 0);
                    Intent intent = new Intent(this, (Class<?>) MainTabsActivity.class);
                    k86.X(intent);
                    startActivity(intent);
                    finish();
                } else if (cursor.moveToFirst()) {
                    GroupInfoItem itemFromCursor = GroupInfoItem.getItemFromCursor(cursor, this.A);
                    X4(itemFromCursor);
                    m5();
                    String groupOwner = itemFromCursor.getGroupOwner();
                    if (!TextUtils.isEmpty(groupOwner) && groupOwner.equals(v4.e(this))) {
                        z2 = true;
                    }
                    if (z2 && itemFromCursor.getRoomType() == 0) {
                        e3(itemFromCursor.getGroupId());
                    }
                    e5();
                    l3();
                    d3();
                    zd2.c(itemFromCursor.getGroupId(), itemFromCursor.getGroupExtTypeFromExtension());
                }
            }
        } else if (loader.getId() == 4 && cursor != null && v3() != null) {
            v3().p3(pt1.b(cursor));
        }
        if (this.C.getCount() > 0) {
            ChatterAdapter chatterAdapter4 = this.C;
            String str4 = chatterAdapter4.getItem(chatterAdapter4.getCount() - 1).mid;
            if (str4 == null || str4.equals(this.H1)) {
                return;
            }
            ChatterAdapter chatterAdapter5 = this.C;
            if (chatterAdapter5.getItem(chatterAdapter5.getCount() - 1).isSend) {
                b05.d("2");
                G4();
            }
        }
    }

    public final void j5() {
        String[] strArr = {DomainHelper.l(this.A)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_message_count", (Integer) 0);
        contentValues.put("thread_latest_unread_message_time", (Integer) 0);
        contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
        contentValues.put("thread_has_remind", (Integer) 0);
        CircleNoticeItem.circleThreadHasNoticeStatus(this.A.getChatId(), 0);
        VoucherRedPacketVo.circleThreadHasVoucherStatus(this.A.getChatId(), 0);
        this.E0.startUpdate(5, null, dx5.f17178a, contentValues, "contact_relate=?", strArr);
    }

    public final void k3() {
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_FILE);
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_IMAGE);
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_CAMERA);
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD);
    }

    public void k4() {
        this.D1 = true;
    }

    public final void k5() {
        if (this.A.getChatType() == 0) {
            ContactInfoItem contactInfoItemL = bo0.r().l(this.A.getChatId());
            if (contactInfoItemL != null) {
                X4(contactInfoItemL);
                if (TextUtils.isEmpty(this.A.getChatName())) {
                    M4(this.A.getChatId());
                } else {
                    M4(this.A.getChatName());
                }
                this.l1.d(contactInfoItemL);
                return;
            }
            return;
        }
        if (this.A.getChatType() == 1) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) this.A;
            if (!TextUtils.isEmpty(groupInfoItem.getRemarkName())) {
                M4(groupInfoItem.getRemarkName() + getString(R.string.group_chat_title_count_kuohao, Integer.valueOf(this.u0.size())));
                return;
            }
            ChatItem chatItem = this.A;
            if (chatItem == null || TextUtils.isEmpty(chatItem.getChatName())) {
                M4(getString(R.string.group_chat_title_count, Integer.valueOf(this.u0.size())));
                return;
            }
            M4(this.A.getChatName() + getString(R.string.group_chat_title_count_kuohao, Integer.valueOf(this.u0.size())));
        }
    }

    public final void l3() {
        GroupVersionConfig config;
        ChatItem chatItem = this.A;
        if (chatItem instanceof GroupInfoItem) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) chatItem;
            boolean z2 = groupInfoItem.getMerchantType() == 1 && groupInfoItem.getMerchantState() == 1;
            boolean z3 = (!z2 || (config = GroupVersionConfig.getConfig()) == null || config.isShowCircleRedPacket()) ? z2 : false;
            if (!z3) {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
            } else if ((groupInfoItem.getRoleType() == 1 && zp3.a()) || groupInfoItem.getRoleType() == 2) {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
            } else {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
            }
            if (v3() != null) {
                v3().K3(z3);
            }
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
        }
        if (v3() != null) {
            v3().W3();
            if (v3().q2() == null || v3().q2().getAdapter() == null) {
                return;
            }
            v3().q2().getAdapter().notifyDataSetChanged();
        }
    }

    public void l4(boolean z2) {
        this.O0.d(z2);
    }

    public void l5(String str) {
        LogUtil.i("ChatInputStatusHelper", "updateTitleViewOnInputStatusChange title=" + str);
        if (str != null) {
            this.H.setText(str);
        } else if (this.A.getChatType() == 0) {
            this.H.setText(TextUtils.isEmpty(this.A.getChatName()) ? this.A.getChatId() : this.A.getChatName());
        }
    }

    public com.zenmen.palmchat.chat.fragment.a m3() {
        return this.e1;
    }

    public void m4(boolean z2) {
        this.O0.e(z2);
    }

    public final void m5() {
        if (this.F == null || this.A.getChatType() != 1) {
            return;
        }
        GroupInfoItem groupInfoItem = (GroupInfoItem) this.A;
        HashMap<String, ContactInfoItem> map = this.u0;
        int size = map != null ? map.size() : 0;
        if (!TextUtils.isEmpty(groupInfoItem.getRemarkName())) {
            M4(groupInfoItem.getRemarkName() + getString(R.string.group_chat_title_count_kuohao, Integer.valueOf(size)));
        } else if (TextUtils.isEmpty(groupInfoItem.getChatName())) {
            M4(getString(R.string.group_chat_title_count, Integer.valueOf(size)));
        } else {
            M4(groupInfoItem.getChatName() + getString(R.string.group_chat_title_count_kuohao, Integer.valueOf(size)));
        }
        invalidateOptionsMenu();
    }

    public String n3() {
        ChatItem chatItem = this.A;
        if (chatItem != null) {
            return chatItem.getChatId();
        }
        return null;
    }

    public final void n4(String str, boolean z2, int i2) {
        Intent intent = new Intent();
        intent.setClass(this, TransparentCordovaWebActivity.class);
        Bundle bundle = new Bundle();
        String str2 = ((tj2.h() + "?isFamily=" + (z2 ? 1 : 0)) + "&memberCount=" + i2) + "&groupId=" + str;
        bundle.putString("web_url", str2);
        bundle.putBoolean("extra_key_full_window", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        startActivity(intent);
        LogUtil.d("logfamily", "open url: " + str2);
    }

    public ChatItem o3() {
        return this.A;
    }

    public final void o4() {
        String chatId = this.A.getChatId();
        ContactInfoItem contactInfoItemL = bo0.r().l(chatId);
        if (contactInfoItemL != null) {
            zn6.d("chatlw_click", null, null);
            ha3.b(this, "102", chatId, contactInfoItemL.getIconURL(), contactInfoItemL.getNameForShow());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.o1.t(i2, i3, intent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.o1.u()) {
            return;
        }
        if (this.C.U()) {
            this.C.F0(false, null);
            D4();
        } else {
            if (this.o1.D()) {
                return;
            }
            if (this.v0.I2()) {
                this.v0.n3();
            } else {
                finish();
            }
        }
    }

    @qm5
    public void onChatRiskNotifyEvent(ChatRiskNotifyEvent chatRiskNotifyEvent) {
        String str;
        ChatItem chatItem = this.A;
        if (chatItem == null || (str = chatRiskNotifyEvent.uid) == null || !str.equals(chatItem.getChatId())) {
            return;
        }
        runOnUiThread(new a0());
    }

    @qm5
    public void onCircleWarnEvent(final CircleWarnEvent circleWarnEvent) {
        ChatItem chatItem = this.A;
        if (chatItem == null || circleWarnEvent == null || !sc0.g(chatItem.getChatId(), circleWarnEvent.toUid, circleWarnEvent.roomId)) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: w40
            @Override // java.lang.Runnable
            public final void run() {
                this.f21613a.W3(circleWarnEvent);
            }
        });
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new z());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        f4(getIntent());
        getWindow().setSoftInputMode(16);
        setContentView(R.layout.layout_activity_chatter);
        ChatItem chatItem = this.A;
        if (chatItem == null) {
            finish();
            return;
        }
        if (a65.e(chatItem)) {
            String chatId = this.A.getChatId();
            K4(chatId);
            i2 = Integer.parseInt(chatId);
        } else {
            i2 = this.A.getChatType() == 1 ? 2 : 1;
        }
        updateCurrentPageInfo(this, new r0(i2));
        ny.a();
        if (!AccountUtils.r(this)) {
            AppContext.getContext().jumpToInitOnAccountIsNull();
            finish();
        }
        this.E0 = new m1(getContentResolver());
        this.I0 = AppContext.getContext().getTrayPreferences().a("receiver_mode", false);
        AudioController.b0().y0(this.I0);
        AudioController.b0().B0();
        this.e1 = new com.zenmen.palmchat.chat.fragment.a(this.s1);
        this.O0.b(this.A.getBizType() == 0 && this.A.getChatType() == 0 && !a65.e(this.A) && !(this.A.getChatId() != null && this.A.getChatId().equals(AccountUtils.p(this))), this.A.getChatId());
        P3();
        Q3();
        M3();
        f3();
        com.zenmen.palmchat.chat.fragment.a aVar = this.e1;
        if (aVar != null) {
            aVar.D();
        }
        if (fu5.u(this.A)) {
            A3();
        }
        UI.c(this, 1, null, this);
        k3();
        if (this.A.getChatType() == 1) {
            l3();
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_FILE);
            if (wa6.d()) {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL);
                fg6.b("view", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 1);
            } else {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL);
            }
            UI.c(this, 2, null, this);
            UI.c(this, 3, null, this);
            this.R0.f(this, this.A);
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL);
            if ((AccountUtils.p(this) == null || !AccountUtils.p(this).equals(this.A.getChatId())) && com.zenmen.palmchat.videocall.c.e()) {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL);
                fg6.b("view", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 2);
            } else {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL);
            }
        }
        if (this.A.getBizType() != 0 && this.A.getBizType() != 13) {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
        } else if (this.A.getChatType() == 0) {
            if (!lu4.c() || this.A.getChatId() == null || this.A.getChatId().equals(AccountUtils.p(this))) {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
            } else {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
            }
        } else if (lu4.b()) {
            InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
        }
        if (lu4.d() && this.A.getChatType() == 0 && this.A.getBizType() == 0 && this.A.getChatId() != null && !this.A.getChatId().equals(AccountUtils.p(this))) {
            InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_TRANSFER);
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_TRANSFER);
        }
        if (this.A.getChatType() == 0) {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_TRANSFER);
        }
        UI.c(this, 4, null, this);
        bo0.r().i().j(this);
        v4();
        u4();
        ContactInfoItem contactInfoItem = this.v;
        if (contactInfoItem != null) {
            this.o1.F(contactInfoItem);
        }
        if (!TextUtils.isEmpty(this.w)) {
            I4(this.w);
        }
        if (this.A.getChatId() != null) {
            com.zenmen.palmchat.chat.c cVar = new com.zenmen.palmchat.chat.c(this.A.getChatId());
            this.J0 = cVar;
            Q1 = cVar.f();
        }
        ds0.a().c(this);
        ch.s().r().j(this);
        B4();
        d20.m(false);
        E4();
        I3();
        this.o1.w();
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        String str;
        String[] strArr;
        LogUtil.i(O1, "onCreateLoader id" + i2);
        if (i2 != 1) {
            if (i2 == 2) {
                return new CursorLoader(this, je2.f18392a, null, "group_id=? and group_member_state=?", new String[]{this.A.getChatId(), Integer.toString(0)}, null);
            }
            if (i2 == 3) {
                return new CursorLoader(this, DBUriManager.b(ye2.class, this.A), null, "group_id=?", new String[]{this.A.getChatId()}, null);
            }
            if (i2 == 4) {
                return new CursorLoader(this, qt1.f20317a, null, null, null, "_id ASC");
            }
            return null;
        }
        if (this.A.getChatType() == 0) {
            str = "contact_relate=?";
            strArr = new String[]{DomainHelper.a(this.A, false)};
        } else if (this.A.getChatType() == 1) {
            boolean zC = com.zenmen.palmchat.database.a.c();
            String str2 = "contact_relate" + com.zenmen.palmchat.database.a.b(zC);
            strArr = new String[]{DomainHelper.e(this.A) + com.zenmen.palmchat.database.a.a(zC)};
            str = str2;
        } else {
            str = null;
            strArr = null;
        }
        MessageCursorLoader messageCursorLoader = new MessageCursorLoader(this, DBUriManager.b(ho3.class, this.A), null, str, strArr, "_id DESC ", this.u);
        this.D0 = messageCursorLoader;
        return messageCursorLoader;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        b05.d("onCreateOptionsMenu(Menu menu)");
        getMenuInflater().inflate(R.menu.menu_chat_activity, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.zenmen.palmchat.chat.c cVar;
        this.j1 = false;
        zv3.g();
        if (this.A == null) {
            super.onDestroy();
            return;
        }
        this.o1.x();
        int i2 = this.g1;
        if (i2 == 0 && zv3.k) {
            zv3.d = null;
            zv3.k = false;
        } else if (i2 == 1 && zv3.o) {
            zv3.f = null;
            zv3.o = false;
        } else if (i2 == 2 && zv3.m) {
            zv3.e = null;
            zv3.m = false;
        }
        com.zenmen.palmchat.chat.fragment.a aVar = this.e1;
        if (aVar != null) {
            aVar.B();
        }
        l92 l92Var = this.N0;
        if (l92Var != null) {
            l92Var.onCancel();
        }
        r75.p(this, k86.a("last_expression_item"), P1);
        int i3 = Q1;
        if (i3 == 1) {
            com.zenmen.palmchat.chat.c cVar2 = this.J0;
            if (cVar2 != null) {
                cVar2.c();
            }
        } else if (i3 == 0 && (cVar = this.J0) != null) {
            cVar.a();
        }
        bo0.r().i().l(this);
        AudioController.b0().G0();
        ds0.a().d(this);
        ch.s().r().l(this);
        k86.U(this, this.r1);
        getSupportLoaderManager().destroyLoader(1);
        getSupportLoaderManager().destroyLoader(2);
        getSupportLoaderManager().destroyLoader(3);
        getSupportLoaderManager().destroyLoader(4);
        this.R0.g();
        ChatterAdapter chatterAdapter = this.C;
        if (chatterAdapter != null) {
            chatterAdapter.m0();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            return true;
        }
        if (i2 == 4 && this.s) {
            finish();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        LogUtil.i(O1, "onLoaderReset");
        this.C.z0(null, false);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ChatItem chatItem;
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_contact_information) {
            int i2 = this.x;
            if (i2 == 14 || i2 == 17 || ((chatItem = this.A) != null && a65.e(chatItem))) {
                G3((ContactInfoItem) this.A);
            } else if (fu5.u(this.A)) {
                F3();
            } else {
                E3();
            }
        } else if (itemId == R.id.menu_group_information) {
            E3();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.C.n0();
        yk6.k().r(null);
        boolean z2 = false;
        b3(0, this.v0.m2(), this.v0.p2());
        F4();
        InputFragment inputFragment = this.v0;
        if (inputFragment != null) {
            inputFragment.T2();
        }
        this.O0.c();
        f46.m(ch.s().u(), this.A, 2);
        if (this.A.getChatType() == 0 && SAppUtil.a.b() && this.C.I().size() >= 10) {
            for (int size = this.C.I().size() - 1; size >= 0 && this.C.I().size() - size <= 10; size--) {
                if (!this.C.I().get(size).isSend && this.C.I().get(size).mimeType != 10000) {
                    z2 = true;
                }
            }
            if (z2) {
                b05.a("最近10条消息中有消息");
            } else {
                b05.a("最近10条消息中没有对方发送的消息");
                e9.d().c = true;
            }
        }
        this.o1.z();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z2) {
        InputFragment inputFragment;
        super.onPermissionGrant(permissionType, permissionUsage, z2);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_VIDEO) {
            pu1.s();
            InputFragment inputFragment2 = this.v0;
            if (inputFragment2 != null) {
                inputFragment2.b3();
                return;
            }
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            InputFragment inputFragment3 = this.v0;
            if (inputFragment3 != null) {
                inputFragment3.d3(permissionUsage);
            }
            pu1.s();
            UI.e(this, 4, null, this);
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.RECORD_AUDIO) {
            InputFragment inputFragment4 = this.v0;
            if (inputFragment4 != null) {
                inputFragment4.X2();
                return;
            }
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.LOCATION) {
            InputFragment inputFragment5 = this.v0;
            if (inputFragment5 != null) {
                inputFragment5.W2();
                return;
            }
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL) {
            InputFragment inputFragment6 = this.v0;
            if (inputFragment6 != null) {
                inputFragment6.a3();
                return;
            }
            return;
        }
        if (permissionType != BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL || (inputFragment = this.v0) == null) {
            return;
        }
        inputFragment.U2();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        b05.d("onPrepareOptionsMenu(Menu menu)");
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_contact_information);
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_group_information);
        MenuItem menuItemFindItem3 = menu.findItem(R.id.menu_ranking);
        if (this.A.getChatType() == 0) {
            this.O = menuItemFindItem;
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(true);
            }
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(false);
            }
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setVisible(false);
            }
        } else if (this.A.getChatType() == 1) {
            this.O = menuItemFindItem2;
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(false);
            }
            if (menuItemFindItem2 != null) {
                if (((GroupInfoItem) this.A).getGroupState() == 0) {
                    menuItemFindItem2.setVisible(true);
                } else {
                    menuItemFindItem2.setVisible(false);
                }
            }
            if (menuItemFindItem3 != null) {
                FamilyGroupConfig familyGroupConfigK = ts0.o().k();
                GroupInfoItem groupInfoItem = (GroupInfoItem) this.A;
                boolean z2 = groupInfoItem.getGroupExtTypeFromExtension() == 2;
                if (familyGroupConfigK.rankingEnable && z2) {
                    HashMap map = new HashMap();
                    map.put("groupid", groupInfoItem.getGroupId());
                    zn6.j("group_listicon", "view", map);
                    menuItemFindItem3.setVisible(true);
                    menuItemFindItem3.setActionView(R.layout.layout_menu_chat_ranking);
                    ImageView imageView = (ImageView) menuItemFindItem3.getActionView().findViewById(R.id.icon);
                    gr2.j().h(familyGroupConfigK.rankingIcon, imageView, bq6.y());
                    imageView.setOnClickListener(new c0(groupInfoItem, familyGroupConfigK));
                } else {
                    menuItemFindItem3.setVisible(false);
                }
            }
        }
        if (this.s) {
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(false);
            }
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(false);
            }
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setVisible(false);
            }
        }
        if (menuItemFindItem != null) {
            menuItemFindItem.setIcon(R.drawable.icon_chat_single_info_more);
        }
        z4();
        return super.onPrepareOptionsMenu(menu);
    }

    @qm5
    public void onRainExpressionEvent(final CircleGreetEvent circleGreetEvent) {
        runOnUiThread(new Runnable() { // from class: u40
            @Override // java.lang.Runnable
            public final void run() {
                this.f21131a.X3(circleGreetEvent);
            }
        });
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        ChatItem chatItem;
        InputFragment inputFragment;
        super.onResume();
        yk6.k().r(this.A);
        ad1.h().m(ad1.p, this);
        if (TeenagersModeManager.a().d() && S3()) {
            new sd3(this).k("青少年模式下，陌生人私聊暂不支持使用").n(GravityEnum.CENTER).P("返回").b(false).h(false).f(new e0()).e().show();
        }
        ChatItem chatItem2 = this.A;
        if (chatItem2 != null && a65.e(chatItem2) && (inputFragment = this.v0) != null) {
            inputFragment.u2();
            if (a65.h(this.A)) {
                this.K0.setVisibility(0);
            } else {
                this.K0.setVisibility(8);
            }
        }
        LogUtil.i(O1, "onResume isNeedReloadOnResume = " + this.E1);
        if (this.E1) {
            MessageCursorLoader messageCursorLoader = this.D0;
            if (messageCursorLoader != null && messageCursorLoader.isStarted() && !this.D0.e() && !this.D0.f()) {
                this.D0.forceLoad();
            }
            this.E1 = false;
        }
        k5();
        h5();
        A4(v3().k2());
        this.C.p0();
        c3();
        ChatItem chatItem3 = this.A;
        if (chatItem3 != null && !TextUtils.isEmpty(chatItem3.getChatId())) {
            com.zenmen.palmchat.utils.a.E().t(1);
            if (o90.a(this.A.getChatId()) == 1) {
                T4(R.drawable.icon_circle_greet);
            }
            CircleWarnBean circleWarnBeanF = sc0.f(AccountUtils.p(this), this.A.getChatId());
            if (circleWarnBeanF != null && (chatItem = this.A) != null) {
                String chatId = chatItem.getChatId();
                CircleWarnBean.WarnExt warnExt = circleWarnBeanF.info;
                if (sc0.g(chatId, warnExt.to.toUserId, warnExt.roomId)) {
                    CircleWarnBean.WarnExt warnExt2 = circleWarnBeanF.info;
                    R4(warnExt2.content, warnExt2.to.toUserId, warnExt2.roomId);
                }
            }
        }
        f46.m(ch.s().u(), this.A, 1);
        com.zenmen.palmchat.settings.c.f().b(this.A, this);
        ua6.h(this);
        N4();
        this.T0.post(new f0());
        this.d1 = true;
        g5();
        t4();
        this.o1.A();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
        ListView listView = this.B;
        if (listView != null) {
            listView.setFriction(ViewConfiguration.getScrollFriction() * 0.3f);
        }
        LogUtil.d(O1, "onStart");
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        this.q1.post(new k0(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.o1.B();
        super.onStop();
        super.unBindMessagingService();
        LogUtil.d(O1, "onStop");
        this.q1.postDelayed(new d0(), 100L);
        d5();
    }

    @qm5
    public void onWhoVisitMeEvent(qk6 qk6Var) {
        p1 p1Var;
        b05.c(new b05.a() { // from class: x40
            @Override // b05.a
            public final Object getValue() {
                return ChatterActivity.Y3();
            }
        });
        if (q05.o(this) || qk6Var == null || qk6Var.f20273a == null || (p1Var = this.q1) == null) {
            return;
        }
        p1Var.post(new n0(qk6Var));
    }

    public int p3() {
        return this.m1;
    }

    public void p4() {
        if (v3() != null) {
            v3().w();
        }
        c9 c9Var = this.y1;
        if (c9Var != null) {
            c9Var.f();
        }
    }

    public int q3() {
        return this.n1;
    }

    public void q4(ContentValues contentValues) {
        String asString = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
        if (TextUtils.isEmpty(asString)) {
            return;
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(asString);
        if (contactInfoItemL != null && !contactInfoItemL.getIsStranger()) {
            sy5.f(this, getString(R.string.chat_toast_add_friend_already), 1).g();
            return;
        }
        Integer asInteger = contentValues.getAsInteger("sourceType");
        int iIntValue = asInteger != null ? asInteger.intValue() : -1;
        com.zenmen.palmchat.chat.fragment.a aVar = this.e1;
        aVar.q(aVar.w(asString), iIntValue, false, true, false, false, null);
    }

    public ChatterAdapter r3() {
        return this.C;
    }

    public void r4(ContentValues contentValues) {
        final Long asLong = contentValues.getAsLong("feedId");
        final String asString = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
        try {
            this.J1 = contentValues.getAsInteger("type").intValue();
        } catch (Exception unused) {
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(asString);
        if (contactInfoItemL == null) {
            B3(asLong, asString, new c5() { // from class: r40
                @Override // defpackage.c5
                public final void call(Object obj) {
                    this.f20385a.Z3(asLong, asString, (ContactInfoItem) obj);
                }
            });
            return;
        }
        int i2 = this.J1;
        if (i2 == 2 || i2 == 3) {
            startActivity(ei4.b(this, null, asLong, asString, "", 1, contactInfoItemL));
            return;
        }
        Intent intentC = ei4.c(null, asLong, asString, 1, contactInfoItemL, i2);
        LogUtil.uploadInfoImmediate("dt12", "1", null, null);
        startActivity(intentC);
    }

    @qm5
    public void receivedCmdMsgEvent(CmdMsgEvent cmdMsgEvent) {
        p1 p1Var = this.q1;
        if (p1Var == null || cmdMsgEvent.msg == null) {
            return;
        }
        p1Var.post(new l0(cmdMsgEvent));
    }

    @qm5
    public void receivedVipCancelBuy(bg6 bg6Var) {
        p1 p1Var = this.q1;
        if (p1Var != null) {
            p1Var.post(new m0(bg6Var));
        }
    }

    public final int s3() {
        long jA = this.u.a();
        if (jA > 0) {
            for (int i2 = 0; i2 < this.C.I().size(); i2++) {
                if (this.C.I().get(i2)._id == jA) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public void s4(ContentValues contentValues) {
        String asString = contentValues.getAsString("word");
        if (this.v0 == null || TextUtils.isEmpty(asString)) {
            return;
        }
        this.v0.g3(asString);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
        LogUtil.i("MessageCursorLoader_lag", "startActivityForResult");
    }

    public String t3(String str) {
        HashMap<String, ContactInfoItem> map;
        ContactInfoItem contactInfoItem;
        if (TextUtils.isEmpty(str) || (map = this.u0) == null || (contactInfoItem = map.get(str)) == null) {
            return null;
        }
        return contactInfoItem.getNamenomarkName();
    }

    public final void t4() {
        if (zg5.j(this.A.getChatId())) {
            xg5.e().u(1);
        }
        xg5.e().c(this, new g0());
        if (this.C1) {
            this.C1 = false;
            if (s34.c() == 1) {
                xg5.e().q(true);
            }
        }
        if (this.D1) {
            this.D1 = false;
            if (s34.c() == 1) {
                xg5.e().o(this, this.A.getChatId(), true, new h0(), true, true);
            } else {
                sy5.f(this, "设置特别关注必须打开通知栏权限哦！", 0).g();
            }
        }
    }

    public HashMap<String, ContactInfoItem> u3() {
        return this.u0;
    }

    public final void u4() {
        this.E0.startQuery(10, null, vn0.f21483a, null, "from_uid=?", new String[]{this.A.getChatId()}, "_id DESC");
    }

    public InputFragment v3() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(InputFragment.c1);
        if (fragmentFindFragmentByTag != null) {
            return (InputFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    public final void v4() {
        this.E0.startQuery(8, null, dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.l(this.A)}, null);
    }

    public float w3() {
        return fu2.h(this.A);
    }

    public final void w4() {
        this.E0.startQuery(15, null, DBUriManager.b(ho3.class, this.A), null, "contact_relate=? and type=? and read=? and msg_type=? and data1=? and (data2=? or data2=?)", new String[]{DomainHelper.a(this.A, false), String.valueOf(1), String.valueOf(0), String.valueOf(35), String.valueOf(1), String.valueOf(1), String.valueOf(2)}, "_id ASC");
    }

    public final String x3(MessageVo messageVo) {
        try {
            JSONObject jSONObject = new JSONObject(messageVo.data1);
            return jSONObject.getString("name") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + jSONObject.getString("address");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final void x4() {
        String[] strArr = {DomainHelper.a(this.A, false), String.valueOf(1), String.valueOf(0), String.valueOf(35), String.valueOf(1), String.valueOf(1), String.valueOf(2)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read", (Integer) 1);
        this.E0.startUpdate(16, null, DBUriManager.b(ho3.class, this.A), contentValues, "contact_relate=? and type=? and read=? and msg_type=? and data1=? and (data2=? or data2=?)", strArr);
    }

    public final MessageVo y3(MessageVo messageVo) {
        ArrayList<MessageVo> arrayListI;
        if (messageVo.isRead || (arrayListI = this.C.I()) == null || arrayListI.size() < 2) {
            return null;
        }
        for (int i2 = 1; i2 < arrayListI.size(); i2++) {
            if (arrayListI.get(i2).time > messageVo.time) {
                MessageVo messageVo2 = arrayListI.get(i2);
                String str = messageVo2.data2;
                boolean z2 = !TextUtils.isEmpty(str) && new File(str).exists();
                if (messageVo2.mimeType == 3 && !messageVo2.isSend && !messageVo2.isRead && messageVo2.attachStatus == 2 && z2) {
                    return messageVo2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: y4, reason: merged with bridge method [inline-methods] */
    public final void d4(@DrawableRes int i2) {
        if (this.K1 == null) {
            return;
        }
        o90.b(this.A.getChatId(), 0);
        a.C1149a c1149a = new a.C1149a(getResources().getDrawable(i2));
        c1149a.r(true, 0.9f, 1.1f);
        c1149a.s(false);
        c1149a.u(5, false);
        c1149a.q(true);
        c1149a.x(10, true, true);
        c1149a.v(false);
        this.K1.addFallObject(c1149a.o(), 30);
        this.K1.startPlay(this);
    }

    public g50 z3() {
        return this.o1;
    }

    public final void z4() {
        if (oc0.f()) {
            ChatItem chatItem = this.A;
            if ((chatItem instanceof GroupInfoItem) && ((GroupInfoItem) chatItem).getRoomType() > 0 && ((GroupInfoItem) this.A).getGroupState() == 0) {
                if (this.T0 == null) {
                    return;
                }
                DatingGroupToolBeans tools = ((GroupInfoItem) this.A).getTools();
                this.T0.setVisibility(8);
                this.U0.setVisibility(8);
                this.V0.setVisibility(8);
                this.W0.setVisibility(8);
                if (tools == null || tools.getToolBeans() == null || tools.getToolBeans().isEmpty()) {
                    return;
                }
                this.T0.setVisibility(0);
                List<DatingGroupToolBeans.DatingGroupToolBean> toolBeans = tools.getToolBeans();
                L4(this.U0, this.X0, toolBeans.get(0));
                if (toolBeans.size() > 1) {
                    L4(this.V0, this.Y0, toolBeans.get(1));
                }
                if (toolBeans.size() > 2) {
                    L4(this.W0, this.Z0, toolBeans.get(2));
                    return;
                }
                return;
            }
        }
        this.T0.setVisibility(8);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f1 implements Response.ErrorListener {
        public f1() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 implements InputFragment.g1 {
        public i0() {
        }

        @Override // com.zenmen.palmchat.chat.InputFragment.g1
        public void a(boolean z) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements Runnable {
        public h0() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
