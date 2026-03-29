package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.BigTextActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ChatterBigTextFragment;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoActivity;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.SelectContactActivity;
import com.zenmen.palmchat.contacts.ServiceAccountDetailActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.groupchat.RevokeMemberActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.task1v1.CompliancePopBean;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.af6;
import defpackage.td3;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g50 implements tk2, InputFragment.j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatterBigTextFragment f17649a;
    public final uk2 b;
    public j50 c = new j50(this);
    public List<ContactInfoItem> d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends o {
        public final /* synthetic */ URLSpan b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, URLSpan uRLSpan) {
            super(activity);
            this.b = uRLSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activityA = a();
            if (activityA == null || this.b.getURL() == null) {
                return;
            }
            g50.H(activityA, tj2.u());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#14CD64"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17650a;

        public b(MaterialDialog materialDialog) {
            this.f17650a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17650a.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f17651a;

        public c(LinearLayout linearLayout) {
            this.f17651a = linearLayout;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            if (drawable != null && !g50.this.getActivity().isFinishing()) {
                this.f17651a.setVisibility(0);
            }
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            this.f17651a.setVisibility(0);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g50.this.getActivity().G4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "send_message");
            put("status", "fail");
            put("detail", "sendNameCard");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements af6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f17654a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ RichMsgExItemVo c;

        public f(ChatItem chatItem, MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
            this.f17654a = chatItem;
            this.b = messageVo;
            this.c = richMsgExItemVo;
        }

        @Override // af6.b
        public void onFinish(boolean z) {
            if (z) {
                SmallVideoEntranceController.n(g50.this.getActivity(), this.f17654a, this.b, this.c);
            } else {
                b65.c();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.ErrorListener {
        public g() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            g50.this.getActivity().hideBaseProgressBar();
            sy5.e(g50.this.getActivity(), R.string.send_failed, 0).g();
            LogUtil.d("ChatterActivityPresenter", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.Listener<JSONObject> {
        public h() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            g50.this.getActivity().hideBaseProgressBar();
            if (iOptInt == 0) {
                sy5.e(g50.this.getActivity(), R.string.qrcode_deactivate_toast, 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f17657a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Response.Listener c;
        public final /* synthetic */ Response.ErrorListener d;

        public i(String[] strArr, String str, Response.Listener listener, Response.ErrorListener errorListener) {
            this.f17657a = strArr;
            this.b = str;
            this.c = listener;
            this.d = errorListener;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i == 0) {
                g50.this.E(this.f17657a);
                return;
            }
            HashMap map = new HashMap();
            map.put("qrCode", this.b);
            try {
                new qe2(this.c, this.d, map).n();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17658a;
        public final /* synthetic */ Response.Listener b;
        public final /* synthetic */ Response.ErrorListener c;

        public j(String str, Response.Listener listener, Response.ErrorListener errorListener) {
            this.f17658a = str;
            this.b = listener;
            this.c = errorListener;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i == 0) {
                HashMap map = new HashMap();
                map.put("qrCode", this.f17658a);
                try {
                    new qe2(this.b, this.c, map).n();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.ErrorListener {
        public k() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            g50.this.getActivity().hideBaseProgressBar();
            sy5.e(g50.this.getActivity(), R.string.send_failed, 0).g();
            LogUtil.d("ChatterActivityPresenter", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.Listener<JSONObject> {
        public l() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            g50.this.getActivity().hideBaseProgressBar();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
                sy5.e(g50.this.getActivity(), R.string.members_removed, 0).g();
            } else if (iOptInt == 4004) {
                sy5.e(g50.this.getActivity(), R.string.revoke_members_not_in, 0).g();
            } else {
                sy5.e(g50.this.getActivity(), R.string.revoke_members_failed, 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Response.Listener f17661a;
        public final /* synthetic */ Response.ErrorListener b;
        public final /* synthetic */ ContactInfoItem c;

        public m(Response.Listener listener, Response.ErrorListener errorListener, ContactInfoItem contactInfoItem) {
            this.f17661a = listener;
            this.b = errorListener;
            this.c = contactInfoItem;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            try {
                new ay4(this.f17661a, this.b).n(this.c.getUid(), ((GroupInfoItem) g50.this.b()).getGroupId());
                g50.this.getActivity().showBaseProgressBar(g50.this.p(R.string.removing_members), false, true);
            } catch (DaoException e) {
                g50.this.getActivity().hideBaseProgressBar();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f17662a;
        public final /* synthetic */ ContactInfoItem b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "send_message");
                put("status", "fail");
                put("detail", "sendNameCard");
            }
        }

        public n(ChatItem chatItem, ContactInfoItem contactInfoItem) {
            this.f17662a = chatItem;
            this.b = contactInfoItem;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ChatItem chatItem = this.f17662a;
            if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
                return;
            }
            try {
                String strE = DomainHelper.e(this.f17662a);
                g50.this.getActivity().G4();
                g50.this.getActivity().getMessagingServiceInterface().r(MessageVo.buildNameCardMessage(xn3.a(), strE, this.b, 0, ir5.b()).setThreadBizType(g50.this.getActivity(), g50.this.e()));
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.i("ChatterActivityPresenter", 3, new a(), e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class o extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f17664a;

        public o(Activity activity) {
            this.f17664a = new WeakReference<>(activity);
        }

        public Activity a() {
            return this.f17664a.get();
        }
    }

    public g50(uk2 uk2Var) {
        this.b = uk2Var;
    }

    public static void H(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setClass(activity, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtra("needCheckAccount", false);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static SpannableStringBuilder o(Activity activity) {
        String string = activity.getResources().getString(R.string.string_lx_use_principle_text);
        Spanned spannedFromHtml = Html.fromHtml(activity.getResources().getString(R.string.string_check_lx_use_principle_text).replaceAll(string, "<a href='principle'>" + string + "</a>"));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new a(activity, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return spannableStringBuilder;
    }

    public void A() {
        this.c.f();
    }

    public void B() {
        this.c.g();
    }

    public final void C(ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo, boolean z, String str2, MessageVo messageVo) {
        String strB;
        ChatItem chatItemB = b();
        contentValues.getAsString("extra_key_from_uid");
        if (y56Var == null || "1".equals(y56Var.a())) {
            strB = str;
        } else {
            strB = y56Var.b();
            if ("1".equals(y56Var.k())) {
                try {
                    strB = k86.Z(strB);
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        zy4.p(getActivity(), strB, richMsgExItemVo, z, false, messageVo == null ? null : m40.e(messageVo.from), (chatItemB.getChatType() != 0 && chatItemB.getChatType() == 1) ? 602 : 601, chatItemB.getBizType(), str2, a(), chatItemB, false);
    }

    public boolean D() {
        if (this.f17649a == null) {
            return false;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.remove(this.f17649a);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        this.f17649a = null;
        c().j();
        return true;
    }

    public final void E(String[] strArr) {
        k kVar = new k();
        l lVar = new l();
        if (strArr.length == 1) {
            ContactInfoItem contactInfoItem = getActivity().u3().get(strArr[0]);
            if (contactInfoItem != null) {
                new sd3(getActivity()).k(getActivity().getString(R.string.revoke_members, contactInfoItem.getNameForShow())).O(R.string.alert_dialog_revoke_members).K(R.string.alert_dialog_cancel).f(new m(lVar, kVar, contactInfoItem)).Q();
                return;
            } else {
                new sd3(getActivity()).j(R.string.member_left_group_chat).O(R.string.alert_dialog_i_knoW).Q();
                return;
            }
        }
        if (strArr.length > 1) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                ContactInfoItem contactInfoItem2 = getActivity().u3().get(str);
                if (contactInfoItem2 != null) {
                    arrayList.add(contactInfoItem2);
                }
            }
            if (arrayList.size() <= 0) {
                new sd3(getActivity()).j(R.string.these_members_left_group_chat).O(R.string.alert_dialog_i_knoW).Q();
                return;
            }
            Intent intent = new Intent(getActivity(), (Class<?>) RevokeMemberActivity.class);
            intent.putExtra("revoke_members", arrayList);
            intent.putExtra("group_id", ((GroupInfoItem) b()).getGroupId());
            intent.putExtra("is_circle", ((GroupInfoItem) b()).getRoomType());
            getActivity().startActivity(intent);
        }
    }

    public void F(ContactInfoItem contactInfoItem) {
        new sd3(getActivity()).k(getActivity().getString(R.string.send_name_card_content, contactInfoItem.getNameForShow())).O(R.string.media_pick_activity_send).K(R.string.dialog_cancel).f(new n(b(), contactInfoItem)).e().show();
    }

    public void G() {
        InputFragment inputFragmentG = g();
        ChatItem chatItemB = b();
        CompliancePopBean compliancePopBeanB = uj0.b();
        if (fu5.t(chatItemB.getBizType()) && q(4096) && inputFragmentG != null && inputFragmentG.r2() && inputFragmentG.Q2() && compliancePopBeanB != null && compliancePopBeanB.mSwitch == 1) {
            String str = compliancePopBeanB.bgUrl;
            int i2 = compliancePopBeanB.frequencyDays;
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.TASK_1V1;
            long jI = sPUtil.i(scene, k86.a("key_chat_compliance_1v1_dialog_show_time_stamp"), 0L);
            long jC = by5.c(jI, System.currentTimeMillis());
            LogUtil.i("1V1Compliance", "1V1ComplianceDialog 上一次展示的时间戳是：" + jI + "：：：：： 当前与上次展示相隔天数是：" + jC);
            if (jC >= i2) {
                LogUtil.i("1V1Compliance", "1V1ComplianceDialog 相隔天数大于 频控时间，可以展示。 频控天数是：" + i2);
                sPUtil.t(scene, k86.a("key_chat_compliance_1v1_dialog_show_time_stamp"), Long.valueOf(System.currentTimeMillis()));
                MaterialDialog materialDialogE = new sd3(getActivity()).b(false).h(true).c(0).o(R.layout.layout_dialog_chatter_1v1_compliance, false).e();
                View viewJ = materialDialogE.j();
                if (viewJ != null) {
                    ImageView imageView = (ImageView) viewJ.findViewById(R.id.iv_content);
                    LinearLayout linearLayout = (LinearLayout) viewJ.findViewById(R.id.bottom_container);
                    TextView textView = (TextView) viewJ.findViewById(R.id.tv_i_known);
                    TextView textView2 = (TextView) viewJ.findViewById(R.id.tv_sensitive_word);
                    textView2.setText(o(getActivity()));
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    textView2.setHighlightColor(getActivity().getResources().getColor(android.R.color.transparent));
                    textView.setOnClickListener(new b(materialDialogE));
                    RequestManager requestManagerWith = Glide.with((FragmentActivity) getActivity());
                    boolean zL = il5.l(str);
                    Object objValueOf = str;
                    if (zL) {
                        objValueOf = Integer.valueOf(R.drawable.ic_chatter_1v1_compliance_dialog_top_bg);
                    }
                    requestManagerWith.load2(objValueOf).error(R.drawable.ic_chatter_1v1_compliance_dialog_top_bg).addListener(new c(linearLayout)).into(imageView);
                }
                materialDialogE.c(false);
                materialDialogE.show();
                zn6.c("pagechat_civilize_popup", "view");
            }
        }
    }

    @Override // defpackage.tk2
    public int a() {
        int i2 = h13.m;
        ChatItem chatItemB = b();
        return chatItemB != null ? a65.e(chatItemB) ? h13.s : chatItemB.getChatType() == 1 ? h13.r : h13.q : i2;
    }

    @Override // defpackage.uk2
    public ChatItem b() {
        return this.b.b();
    }

    @Override // defpackage.uk2
    public xe2 c() {
        return this.b.c();
    }

    @Override // defpackage.tk2
    public void d(MessageVo messageVo) {
        InputFragment inputFragmentG = g();
        if (this.f17649a == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            this.f17649a = new ChatterBigTextFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg", messageVo);
            this.f17649a.setArguments(bundle);
            fragmentTransactionBeginTransaction.add(R.id.rootLayout, this.f17649a, ChatterBigTextFragment.g);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            c().d();
            if (inputFragmentG != null) {
                inputFragmentG.v2();
            }
        }
    }

    @Override // defpackage.uk2
    public int e() {
        return this.b.e();
    }

    @Override // com.zenmen.palmchat.chat.InputFragment.j1
    public void f(InputItemManager.InputItemType inputItemType, com.zenmen.palmchat.chat.b bVar) {
        ChatItem chatItemB = b();
        ChatterActivity activity = getActivity();
        InputFragment inputFragmentG = g();
        int iE = e();
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_IMAGE) {
            if (fu2.g(activity, inputItemType)) {
                LogUtil.onClickEvent("V32", null, null);
                BaseActivityPermissionDispatcher.b(activity, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_IMAGE);
                return;
            }
            return;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_FILE) {
            if (fu2.g(activity, inputItemType)) {
                BaseActivityPermissionDispatcher.b(activity, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_FILE);
                return;
            }
            return;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_LOCATION) {
            BaseActivityPermissionDispatcher.b(activity, BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_LOCATION);
            return;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_REDPACKET) {
            return;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VOUCHER) {
            if (!hx3.m(activity)) {
                sy5.f(activity, p(R.string.net_status_unavailable_connect), 0).g();
                return;
            } else {
                if (nx3.a("key_show_voucher_red_packet")) {
                    nx3.e("key_show_voucher_red_packet");
                    if (bVar != null) {
                        bVar.g();
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_CAMERA) {
            if (fu2.g(activity, inputItemType)) {
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
                BaseActivityPermissionDispatcher.b(activity, BaseActivityPermissionDispatcher.PermissionType.CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_SEND_VIDEO);
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
            Intent intent = new Intent(activity, (Class<?>) SelectContactActivity.class);
            intent.putExtra("extra_from", 0);
            intent.putExtra("current_chat_id", chatItemB.getChatId());
            intent.putExtra("thread_biz_type", iE);
            activity.startActivityForResult(intent, 104);
            return;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_BIG_TEXT) {
            Intent intent2 = new Intent(activity, (Class<?>) BigTextActivity.class);
            intent2.putExtra("chat_item", chatItemB);
            intent2.putExtra("thread_biz_type", iE);
            activity.startActivityForResult(intent2, 105);
            return;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_SIGHT) {
            com.zenmen.palmchat.videocall.c.f();
            return;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
            if (com.zenmen.palmchat.videocall.c.f()) {
                return;
            }
            if (!com.zenmen.palmchat.videocall.c.e()) {
                Toast.makeText(activity, R.string.service_not_available, 0).show();
                return;
            }
            if (nx3.a("key_video_call")) {
                nx3.e("key_video_call");
                if (bVar != null) {
                    bVar.g();
                }
            }
            if (g() != null) {
                g().P3(false);
                return;
            }
            return;
        }
        if (inputItemType != InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL) {
            if (inputItemType != InputItemManager.InputItemType.INPUT_ITEM_TRANSFER && inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GIFT) {
                if (nx3.a("key_new_gift_panel")) {
                    nx3.e("key_new_gift_panel");
                }
                if (inputFragmentG != null) {
                    inputFragmentG.D3(null);
                }
                com.zenmen.palmchat.chat.c.d(chatItemB);
                return;
            }
            return;
        }
        if (nx3.a("key_new_group_voice_call")) {
            nx3.e("key_new_group_voice_call");
            if (bVar != null) {
                bVar.g();
            }
        }
        fg6.b("click", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 1);
        if (fg6.d(AppContext.getContext())) {
            wa6.h(activity.H3(), ((GroupInfoItem) chatItemB).getGroupId());
        } else {
            ap3.z(AppContext.getContext(), BaseWrapper.ENTER_ID_OAPS_RECENTS, "1", "scene_voice_video_call");
        }
    }

    @Override // defpackage.uk2
    public InputFragment g() {
        return this.b.g();
    }

    @Override // defpackage.uk2
    public ChatterActivity getActivity() {
        return this.b.getActivity();
    }

    @Override // defpackage.uk2
    public InputFragment h() {
        return this.b.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0095  */
    @Override // defpackage.tk2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(ContactInfoItem contactInfoItem) {
        String nickName;
        String groupRemarkName;
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        ChatItem chatItemB = b();
        ChatterActivity activity = getActivity();
        int iE = e();
        HashMap<String, ContactInfoItem> mapU3 = activity.u3();
        Intent intent = new Intent(getActivity(), (Class<?>) m66.c());
        if (chatItemB.getChatType() == 1) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) chatItemB;
            intent.putExtra("group_id", groupInfoItem.getGroupId());
            intent.putExtra("group_chat_info", chatItemB);
            intent.putExtra("from", 6);
            if (mapU3 == null || mapU3.get(AccountUtils.p(getActivity())) == null) {
                nickName = "";
                intent.putExtra("groupchat_name", groupInfoItem.getGroupNameDisplay(nickName));
                groupRemarkName = contactInfoItem.getGroupRemarkName();
                if (contactInfoItem.getUid() != null && contactInfoItem.getUid().equals(AccountUtils.p(activity)) && chatItemB.getChatType() == 1 && mapU3 != null && mapU3.get(contactInfoItem.getUid()) != null) {
                    groupRemarkName = mapU3.get(contactInfoItem.getUid()).getGroupRemarkName();
                }
                contactInfoItemM792clone.setGroupRemarkName(groupRemarkName);
            } else {
                if (!TextUtils.isEmpty(mapU3.get(AccountUtils.p(activity)).getGroupRemarkName())) {
                    nickName = mapU3.get(AccountUtils.p(activity)).getGroupRemarkName();
                } else if (!TextUtils.isEmpty(mapU3.get(AccountUtils.p(activity)).getNickName())) {
                    nickName = mapU3.get(AccountUtils.p(activity)).getNickName();
                }
                intent.putExtra("groupchat_name", groupInfoItem.getGroupNameDisplay(nickName));
                groupRemarkName = contactInfoItem.getGroupRemarkName();
                if (contactInfoItem.getUid() != null) {
                    groupRemarkName = mapU3.get(contactInfoItem.getUid()).getGroupRemarkName();
                }
                contactInfoItemM792clone.setGroupRemarkName(groupRemarkName);
            }
        } else {
            if (d65.b() && a65.e(contactInfoItemM792clone)) {
                ServiceAccountDetailActivity.Y1(activity, contactInfoItem);
                return;
            }
            intent.putExtra("from", 5);
            if (contactInfoItemM792clone.getSourceType() == -1) {
                contactInfoItemM792clone.setSourceType(11);
            }
            intent.putExtra("back_to_chat", true);
        }
        contactInfoItemM792clone.setBizType(iE);
        intent.putExtra("user_item_info", contactInfoItemM792clone);
        intent.putExtra("thread_biz_type", iE);
        getActivity().startActivityForResult(intent, 100);
    }

    @Override // defpackage.tk2
    public void j(int i2, ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo, boolean z, MessageVo messageVo, boolean z2) {
        LogUtil.i("ChatterActivityPresenter", "judgeUrl actionType=" + i2 + " url=" + str);
        ChatItem chatItemB = b();
        String str2 = messageVo != null ? messageVo.mid : null;
        if (i2 == -1) {
            if (SmallVideoEntranceController.h(richMsgExItemVo)) {
                s(chatItemB, messageVo, richMsgExItemVo);
                return;
            } else {
                C(contentValues, y56Var, str, richMsgExItemVo, z, str2, messageVo);
                return;
            }
        }
        if (i2 == 0) {
            E(contentValues.getAsString("uids").split(","));
            return;
        }
        if (i2 == 1) {
            getActivity().m3().r(getActivity().m3().w(contentValues.getAsString(DeviceInfoUtil.UID_TAG)), false, true, false, false, null);
            return;
        }
        if (i2 == 3) {
            r(richMsgExItemVo, contentValues, str2);
            y("click", contentValues.getAsString("page"), str2, str);
            return;
        }
        if (i2 == 4) {
            LogUtil.uploadInfoImmediate("356", "1", null, null);
            getActivity().m3().p(contentValues);
            return;
        }
        if (i2 == 6) {
            n(contentValues.getAsString("uids").split(","), contentValues.getAsString("qrCode"));
            return;
        }
        if (i2 != 9) {
            if (i2 != 10) {
                return;
            }
            ve.s(getActivity(), str, false);
        } else {
            String asString = contentValues.getAsString("couponId");
            if (asString != null) {
                CircleCouponInfoActivity.J1(getActivity(), asString, contentValues.getAsString(RedirectRespWrapper.KEY_VERCODE));
            }
        }
    }

    public final void n(String[] strArr, String str) {
        g gVar = new g();
        h hVar = new h();
        if (getActivity().u3().get(strArr[0]) != null) {
            new td3.c(getActivity()).c(new String[]{p(R.string.qrcode_revoke_members), p(R.string.qrcode_deactivate)}).d(new i(strArr, str, hVar, gVar)).a().b();
        } else {
            new td3.c(getActivity()).c(new String[]{p(R.string.qrcode_deactivate)}).d(new j(str, hVar, gVar)).a().b();
        }
    }

    public final String p(int i2) {
        return getActivity().getString(i2);
    }

    public final boolean q(int i2) {
        return yg4.a(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), i2);
    }

    public final void r(RichMsgExItemVo richMsgExItemVo, ContentValues contentValues, String str) {
        ve.k(getActivity(), richMsgExItemVo, contentValues, str, b());
    }

    public final void s(ChatItem chatItem, MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
        ChatterActivity activity = getActivity();
        RichMsgExItemVo.WinEx winEx = richMsgExItemVo.wineEx;
        af6.e(activity, winEx != null ? winEx.wineFeedId : null, winEx != null ? winEx.wid : null, new f(chatItem, messageVo, richMsgExItemVo));
    }

    public void t(int i2, int i3, Intent intent) {
        int iE = e();
        ChatItem chatItemB = b();
        if ((i2 == 100 || i2 == 103) && i3 == -1) {
            getActivity().finish();
            return;
        }
        int i4 = 0;
        if (i2 == 101 && i3 == -1) {
            if (intent != null) {
                if (intent.getBooleanExtra("extra_all_of", false)) {
                    g().V1("所有人 ");
                    g().S1(CircleConfig.VALUE_REMIND_ALL_OF_PERSON);
                    return;
                }
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("add_group_member_result");
                this.d = parcelableArrayListExtra;
                if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
                    return;
                }
                for (ContactInfoItem contactInfoItem : this.d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(!TextUtils.isEmpty(contactInfoItem.getGroupRemarkName()) ? contactInfoItem.getGroupRemarkName() : contactInfoItem.getNickName());
                    sb.append(" ");
                    String string = sb.toString();
                    if (i4 > 0 && this.d.size() > 1) {
                        string = "@" + string;
                    }
                    g().V1(string);
                    g().S1(contactInfoItem.getUid());
                    i4++;
                }
                return;
            }
            return;
        }
        if (i2 == 102 && i3 == -1) {
            getActivity().r3().F0(false, null);
            getActivity().D4();
            return;
        }
        if (i2 == 104 && i3 == -1) {
            F((ContactInfoItem) intent.getParcelableExtra("selected_item"));
            return;
        }
        if (i2 == 105 && i3 == -1) {
            u93.b(500, new d());
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
            } else {
                LogUtil.d("tang", "chatter activity on activity result notifyDataSetChanged");
                if (g() == null || g().q2() == null || g().q2().getAdapter() == null) {
                    return;
                }
                g().q2().getAdapter().notifyDataSetChanged();
                return;
            }
        }
        MediaItem mediaItem = (MediaItem) intent.getParcelableExtra("EXTRA_RECORD_ITEM");
        if (mediaItem == null || chatItemB == null || TextUtils.isEmpty(chatItemB.getChatId())) {
            return;
        }
        try {
            String strE = DomainHelper.e(chatItemB);
            getActivity().G4();
            int i5 = mediaItem.mimeType;
            if (i5 != 1) {
                if (i5 == 0) {
                    PhotoObject photoObject = new PhotoObject();
                    photoObject.path = mediaItem.localPath;
                    getActivity().getMessagingServiceInterface().r(MessageVo.buildImageMessage(xn3.a(), strE, photoObject, true, 0, null).setThreadBizType(getActivity(), iE));
                    return;
                }
                return;
            }
            File file = new File(mediaItem.localPath);
            File file2 = new File(mediaItem.thumbnailPath);
            if (file.exists() && file2.exists()) {
                MessageVo threadBizType = MessageVo.buildVideoMessage(xn3.a(), DomainHelper.e(chatItemB), mediaItem.localPath, mediaItem.thumbnailPath, mediaItem.playLength, 0).setThreadBizType(getActivity(), iE);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("video", threadBizType.data5);
                    jSONObject.put("envir", chatItemB.getChatType() == 1 ? "2" : threadBizType.bizType == 0 ? "1" : "3");
                    jSONObject.put("qua", "1");
                    threadBizType.logExtension = jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                getActivity().getMessagingServiceInterface().r(threadBizType);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            LogUtil.i("ChatterActivityPresenter", 3, new e(), e3);
        }
    }

    public boolean u() {
        return this.c.a();
    }

    public void v() {
        this.c.b();
    }

    public void w() {
        this.c.c();
        ch.s().r().j(this);
    }

    public void x() {
        ch.s().r().l(this);
        this.c.d();
    }

    public void y(String str, String str2, String str3, String str4) {
        ChatItem chatItemB = b();
        if ("88888026".equals(chatItemB.getChatId())) {
            if (str.equals("view")) {
                HashMap map = new HashMap();
                map.put("fromid", chatItemB.getChatId());
                zn6.j("pagechat_servicenum", "view", map);
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("fromid", chatItemB.getChatId());
            map2.put("mid", str3);
            map2.put(TurnInfo.TYPE_DEEP_LINK, str4);
            if ("a0404".equals(str2)) {
                map2.put("landpage", 1);
            } else if ("a0405".equals(str2)) {
                map2.put("landpage", 2);
            } else if ("a0406".equals(str2)) {
                map2.put("landpage", 14);
            } else if ("a0407".equals(str2)) {
                map2.put("landpage", 6);
            } else if ("a0408".equals(str2)) {
                map2.put("landpage", 4);
            } else if ("a0409".equals(str2)) {
                map2.put("landpage", 5);
            } else if ("a0410".equals(str2)) {
                map2.put("landpage", 44);
            } else if ("a0052".equals(str2)) {
                map2.put("landpage", 41);
            }
            zn6.j("pagechat_servicenumcli", "click", map2);
        }
    }

    public void z() {
        this.c.e();
    }
}
