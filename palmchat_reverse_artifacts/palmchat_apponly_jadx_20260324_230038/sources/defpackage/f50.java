package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bytedance.bpea.entry.common.DataType;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.gson.Gson;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.az;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.comm.constants.ErrorCode;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.CircleGuide;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.MomentsConfig;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatBreakHelper;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.circle.app.dragon.DragonItem;
import com.zenmen.palmchat.circle.app.dragon.DragonJoinActivity;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.circle.ui.dialog.DialogCircleQuickRemoveOrShutUp;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.expression.ExpressionDetailActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupDetailActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationViewActivityV2;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.media.AudioObject;
import com.zenmen.palmchat.media.file.FileDetailActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.RedPacketVo;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.router.PagerRouterManager;
import com.zenmen.palmchat.transfer.bean.TransferVo;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.c;
import defpackage.q05;
import defpackage.td3;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f50 implements ChatterAdapter.h {
    public td3 c;
    public MessageVo d;
    public HashMap<ChatterActivity.LongClickMenuItem, String> e;
    public final tk2 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MaterialDialog f17436a = null;
    public boolean b = false;
    public final fa3 g = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements fa3 {

        /* JADX INFO: renamed from: f50$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1191a implements DialogCircleQuickRemoveOrShutUp.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactInfoItem f17438a;
            public final /* synthetic */ InputFragment b;

            public C1191a(ContactInfoItem contactInfoItem, InputFragment inputFragment) {
                this.f17438a = contactInfoItem;
                this.b = inputFragment;
            }

            @Override // com.zenmen.palmchat.circle.ui.dialog.DialogCircleQuickRemoveOrShutUp.f
            public void a() {
                f50.this.f.i(this.f17438a);
            }

            @Override // com.zenmen.palmchat.circle.ui.dialog.DialogCircleQuickRemoveOrShutUp.f
            public void b() {
                InputFragment inputFragment = this.b;
                if (inputFragment != null) {
                    inputFragment.t2();
                }
            }
        }

        public a() {
        }

        @Override // defpackage.fa3
        public void onEvent(int i, Object obj) {
            ContactInfoItem contactInfoItemM792clone;
            InputFragment inputFragmentG = f50.this.f.g();
            ChatItem chatItemB = f50.this.f.b();
            if (i == 0 || !(obj instanceof ContactInfoItem)) {
                return;
            }
            ContactInfoItem contactInfoItem = (ContactInfoItem) obj;
            if (i == 1 || i == 3) {
                if (inputFragmentG != null) {
                    inputFragmentG.t2();
                }
                f50.this.f.i(contactInfoItem);
                return;
            }
            if (i == 2) {
                if (inputFragmentG != null) {
                    inputFragmentG.t2();
                }
                f50.this.m0(contactInfoItem, 100L);
                return;
            }
            if (i == 4) {
                new DialogCircleQuickRemoveOrShutUp(f50.this.f.getActivity(), new C1191a(contactInfoItem, inputFragmentG)).Q(f50.this.f.getActivity(), (GroupInfoItem) chatItemB, contactInfoItem);
                return;
            }
            if (i == 5) {
                if (inputFragmentG != null) {
                    inputFragmentG.t2();
                }
                ContactInfoItem contactInfoItemA = dn0.a(contactInfoItem.getUid());
                if (contactInfoItemA != null) {
                    contactInfoItemM792clone = contactInfoItemA.m792clone();
                } else {
                    contactInfoItemM792clone = contactInfoItem.m792clone();
                    contactInfoItemM792clone.setFriendType(1);
                }
                contactInfoItemM792clone.setSourceType(60);
                contactInfoItemM792clone.setBizType(ErrorCode.NO_AD_FILL_FOR_INSTALLED);
                ap3.j(f50.this.f.getActivity(), contactInfoItemM792clone, ErrorCode.NO_AD_FILL_FOR_INSTALLED);
                oh6.b(contactInfoItemM792clone.getFriendType());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
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
    public class c implements td3.e {
        public c() {
        }

        @Override // td3.e
        public void a(td3 td3Var) {
            f50.this.b = false;
            f50.this.d = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterActivity f17441a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ Object c;

        public d(ChatterActivity chatterActivity, MessageVo messageVo, Object obj) {
            this.f17441a = chatterActivity;
            this.b = messageVo;
            this.c = obj;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) throws Throwable {
            ArrayList<RichMsgExItemVo> arrayList;
            ArrayList<RichMsgExItemVo> arrayList2;
            if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.MORE))) {
                this.f17441a.C.F0(true, this.b);
                this.f17441a.U2(this.b);
                return;
            }
            if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.DELETE))) {
                f50.this.D(this.b.mid);
                return;
            }
            if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.COPY))) {
                MessageVo messageVo = this.b;
                String strB = messageVo.text;
                if (messageVo.mimeType == 10002) {
                    strB = a65.b(strB);
                }
                f50.this.C(strB);
                return;
            }
            if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.BUBBLE))) {
                f50.V(this.f17441a);
                return;
            }
            if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.RECALL))) {
                f50.this.j0(this.b);
                return;
            }
            if (!charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.FORWARD))) {
                if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.MOMENTS))) {
                    r55.c(this.f17441a, this.b, 31);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(az.at, 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LogUtil.onImmediateClickEvent("M185", null, jSONObject.toString());
                    return;
                }
                if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.SPEAKERMODE1)) || charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.SPEAKERMODE2))) {
                    this.f17441a.h4();
                    return;
                }
                if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION))) {
                    if (BaseActivityPermissionDispatcher.b(this.f17441a, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_SAVE_IMAGE)) {
                        f50.this.a0(this.b);
                        return;
                    }
                    return;
                } else {
                    if (charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.REPORT))) {
                        return;
                    }
                    charSequence.toString().equals(f50.this.e.get(ChatterActivity.LongClickMenuItem.KICKOUT));
                    return;
                }
            }
            if (f50.P(this.b)) {
                new sd3(this.f17441a).j(R.string.downloading_before_forward).O(R.string.alert_dialog_ok).e().show();
                return;
            }
            MessageVo messageVo2 = this.b;
            if (messageVo2.mimeType != 28) {
                f50.this.E(messageVo2);
                return;
            }
            Integer num = (Integer) this.c;
            RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo2);
            if (!TextUtils.isEmpty(this.b.extention) && this.b.extention.equals("message_type_link_illegal")) {
                new sd3(this.f17441a).j(R.string.string_forward_dialog_illegal).O(R.string.alert_dialog_ok).e().show();
                return;
            }
            if (richMsgExVoH != null && (arrayList2 = richMsgExVoH.items) != null && arrayList2.size() == 1 && (richMsgExVoH.items.get(0).showType == 11 || richMsgExVoH.items.get(0).showType == 14)) {
                f50.this.E(this.b);
                return;
            }
            if (richMsgExVoH == null || num == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= num.intValue()) {
                f50.this.E(this.b);
                return;
            }
            RichMsgExItemVo richMsgExItemVo = richMsgExVoH.items.get(num.intValue());
            RichMsgExVo richMsgExVo = new RichMsgExVo();
            richMsgExVo.items = new ArrayList<>();
            richMsgExVo.source = richMsgExVoH.source;
            RichMsgExItemVo richMsgExItemVo2 = new RichMsgExItemVo();
            richMsgExItemVo2.showType = 0;
            richMsgExItemVo2.url = richMsgExItemVo.url;
            richMsgExItemVo2.subType = richMsgExItemVo.subType;
            richMsgExItemVo2.cover = richMsgExItemVo.cover;
            richMsgExItemVo2.title = richMsgExItemVo.title;
            richMsgExItemVo2.digest = richMsgExItemVo.digest;
            richMsgExVo.items.add(richMsgExItemVo2);
            RichMsgVo richMsgVo = new RichMsgVo();
            richMsgVo.appMsg = richMsgExVo;
            String strC = az2.c(richMsgVo);
            MessageVo messageVoM791clone = this.b.m791clone();
            messageVoM791clone.data1 = strC;
            f50.this.E(messageVoM791clone);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "send_message");
            put("status", "reSend");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f17443a;

        public f(MessageVo messageVo) {
            this.f17443a = messageVo;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            f50.this.Z(this.f17443a);
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends ed5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17444a;
        public final /* synthetic */ MessageVo b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                sy5.e(AppContext.getContext(), R.string.network_exception_title, 0).g();
            }
        }

        public g(int i, MessageVo messageVo) {
            this.f17444a = i;
            this.b = messageVo;
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onError(int i, String str) {
            LogUtil.d("ChatterActivityItemListener", str);
            f50.this.r0(0, this.b);
            f50.this.f.getActivity().runOnUiThread(new a());
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onFinish(File file) {
            if (file != null && file.exists()) {
                f50.this.n0(file.getAbsolutePath(), (int) file.length(), this.b);
            }
            f50.this.r0(2, this.b);
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onProgress(int i) {
            LogUtil.d("ChatterActivityItemListener", "progress " + i);
            if (i >= this.f17444a) {
                LogUtil.d("ChatterActivityItemListener", "download length exceed,file size is:" + this.f17444a);
                i = this.f17444a;
            }
            f50.this.p0(i, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements q05.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17446a;

        public h(String str) {
            this.f17446a = str;
        }

        @Override // q05.f
        public void a() {
            f50.this.f.getActivity().I4(this.f17446a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17447a;
        public final /* synthetic */ ChatterActivity b;

        public i(String str, ChatterActivity chatterActivity) {
            this.f17447a = str;
            this.b = chatterActivity;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            try {
                if (i == 0) {
                    Intent intent = new Intent("android.intent.action.INSERT");
                    intent.setType("vnd.android.cursor.dir/person");
                    intent.setType("vnd.android.cursor.dir/contact");
                    intent.setType("vnd.android.cursor.dir/raw_contact");
                    intent.putExtra("phone", this.f17447a);
                    this.b.startActivity(intent);
                } else {
                    Intent intent2 = new Intent("android.intent.action.INSERT_OR_EDIT");
                    intent2.setType("vnd.android.cursor.item/person");
                    intent2.putExtra("phone", this.f17447a);
                    intent2.putExtra("phone_type", 2);
                    this.b.startActivity(intent2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f17448a;
        public final /* synthetic */ ChatterActivity b;
        public final /* synthetic */ String c;

        public j(Uri uri, ChatterActivity chatterActivity, String str) {
            this.f17448a = uri;
            this.b = chatterActivity;
            this.c = str;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i == 0) {
                Intent intent = new Intent("android.intent.action.VIEW", this.f17448a);
                intent.putExtra("com.android.browser.application_id", this.b.getPackageName());
                this.b.startActivity(intent);
            } else if (i == 1) {
                f50.this.h0(this.c);
            } else if (i == 2) {
                ((ClipboardManager) this.b.getSystemService(DataType.CLIPBOARD)).setText(this.c);
                sy5.e(this.b, R.string.copy_success, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends HashMap<ChatterActivity.LongClickMenuItem, String> {
        public k() {
            put(ChatterActivity.LongClickMenuItem.MORE, f50.this.G(R.string.string_more));
            put(ChatterActivity.LongClickMenuItem.DELETE, f50.this.G(R.string.string_delete));
            put(ChatterActivity.LongClickMenuItem.COPY, f50.this.G(R.string.chat_item_menu_copy));
            put(ChatterActivity.LongClickMenuItem.BUBBLE, f50.this.G(R.string.chat_item_menu_bubble));
            put(ChatterActivity.LongClickMenuItem.RECALL, f50.this.G(R.string.chat_item_menu_recall));
            put(ChatterActivity.LongClickMenuItem.FORWARD, f50.this.G(R.string.string_forward));
            put(ChatterActivity.LongClickMenuItem.MOMENTS, f50.this.G(R.string.string_moments));
            put(ChatterActivity.LongClickMenuItem.SPEAKERMODE1, f50.this.G(R.string.string_use_speaker_mode));
            put(ChatterActivity.LongClickMenuItem.SPEAKERMODE2, f50.this.G(R.string.string_use_receiver_mode));
            put(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION, f50.this.G(R.string.string_add_expressions));
            put(ChatterActivity.LongClickMenuItem.REPORT, f50.this.G(R.string.hotchat_message_report));
            put(ChatterActivity.LongClickMenuItem.KICKOUT, f50.this.G(R.string.hotchat_message_kickout));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends wi0<BaseResponse<CircleRecommendItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterActivity f17451a;
        public final /* synthetic */ ChatItem b;
        public final /* synthetic */ MessageVo c;
        public final /* synthetic */ Object d;

        public m(ChatterActivity chatterActivity, ChatItem chatItem, MessageVo messageVo, Object obj) {
            this.f17451a = chatterActivity;
            this.b = chatItem;
            this.c = messageVo;
            this.d = obj;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleRecommendItem> baseResponse) {
            this.f17451a.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                Toast.makeText(this.f17451a, baseResponse.getErrorMsg(), 0).show();
                return;
            }
            CircleRecommendItem data = baseResponse.getData();
            if (data != null) {
                GroupInfoItem groupInfoItemCopyForGroupInfoItem = data.copyForGroupInfoItem();
                if (groupInfoItemCopyForGroupInfoItem.getRoomType() == 1 || groupInfoItemCopyForGroupInfoItem.getRoomType() == 2) {
                    Intent intent = new Intent(this.f17451a, (Class<?>) CircleDetailActivity.class);
                    intent.putExtra("key_group_info", groupInfoItemCopyForGroupInfoItem);
                    intent.putExtra("key_apply_group_source", 2);
                    this.f17451a.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(this.f17451a, (Class<?>) GroupDetailActivity.class);
                intent2.putExtra(com.umeng.analytics.pro.f.K, this.b);
                intent2.putExtra("issend", this.c.isSend);
                intent2.putExtra("user_detail_name_card_sender_name", (String) this.d);
                this.f17451a.startActivityForResult(intent2, 100);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f17452a;
        public final /* synthetic */ ChatterActivity b;

        public n(MessageVo messageVo, ChatterActivity chatterActivity) {
            this.f17452a = messageVo;
            this.b = chatterActivity;
        }

        @Override // com.zenmen.palmchat.videocall.c.d
        public void a() {
            boolean z = Integer.valueOf(this.f17452a.data2).intValue() == 0;
            r75.p(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 0);
            if (z) {
                BaseActivityPermissionDispatcher.b(this.b, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_CALL);
            } else {
                BaseActivityPermissionDispatcher.b(this.b, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_AUDIO_CALL);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends wi0<BaseResponse<DragonItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f17453a;
        public final /* synthetic */ ChatterActivity b;

        public o(MessageVo messageVo, ChatterActivity chatterActivity) {
            this.f17453a = messageVo;
            this.b = chatterActivity;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DragonItem> baseResponse) {
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                return;
            }
            this.f17453a.extention = new Gson().toJson(baseResponse);
            com.zenmen.palmchat.database.b.N(this.f17453a);
            DragonItem data = baseResponse.getData();
            Intent intent = new Intent(this.b, (Class<?>) DragonJoinActivity.class);
            intent.putExtra(j70.b, AccountUtils.p(this.b));
            intent.putExtra(j70.e, data);
            this.b.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f17454a;

        public p(MessageVo messageVo) {
            this.f17454a = messageVo;
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
            f50.this.Y(this.f17454a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterActivity f17455a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ ChatItem c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {
            public a() {
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                LogUtil.d("ChatterActivityItemListener", "onResponse() called with: response = [" + baseResponse + "]");
            }
        }

        public q(ChatterActivity chatterActivity, MessageVo messageVo, ChatItem chatItem) {
            this.f17455a = chatterActivity;
            this.b = messageVo;
            this.c = chatItem;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            this.f17455a.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") != 0) {
                f50.this.k0();
                return;
            }
            MessageVo messageVo = this.b;
            if (messageVo.mimeType == 52) {
                f50.this.I(messageVo);
            }
            f50.this.W(this.b);
            ChatItem chatItem = this.c;
            if (chatItem instanceof GroupInfoItem) {
                c70.R().r0(((GroupInfoItem) chatItem).getGroupId(), this.b.mid, new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterActivity f17457a;

        public r(ChatterActivity chatterActivity) {
            this.f17457a = chatterActivity;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f17457a.hideBaseProgressBar();
            f50.this.e0();
        }
    }

    public f50(tk2 tk2Var) {
        this.e = null;
        this.f = tk2Var;
        this.e = new k();
    }

    public static boolean M(MessageVo messageVo) {
        File fileB;
        boolean z = !TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists();
        if (!z) {
            String strF = com.zenmen.palmchat.expression.a.f(messageVo);
            if (!TextUtils.isEmpty(strF) && (fileB = sd1.b(strF)) != null && fileB.exists() && fileB.length() > 0) {
                return true;
            }
        }
        return z;
    }

    public static boolean O(MessageVo messageVo) {
        File fileB;
        boolean z = false;
        if (messageVo.attachStatus == 5) {
            return false;
        }
        if (!TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists()) {
            z = true;
        }
        if (z || TextUtils.isEmpty(messageVo.data3) || (fileB = sd1.b(messageVo.data3)) == null || !fileB.exists() || fileB.length() <= 0) {
            return z;
        }
        return true;
    }

    public static boolean P(MessageVo messageVo) {
        return (messageVo.mimeType == 6 && !o86.j(messageVo)) || (messageVo.mimeType == 4 && !eb6.e().d(messageVo.data1)) || (messageVo.mimeType == 14 && !M(messageVo)) || (messageVo.mimeType == 2 && !O(messageVo));
    }

    public static void V(Activity activity) {
        PagerRouterManager.getRouter().c(activity, "zenxin://activity?page=a0052&pkgId=bubble&urlExtra=%3Ffrom%3D2", false);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            jSONObject.put("svip_status", fg6.d(AppContext.getContext()) ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("msg_longpress_bubble_click", "click", jSONObject);
    }

    public boolean B(ChatItem chatItem, MessageVo messageVo) {
        if (chatItem.getChatType() == 1 && !messageVo.isSend) {
            if (!oc0.f()) {
                return false;
            }
            ContactInfoItem contactInfoItem = this.f.getActivity().u3().get(AccountUtils.p(this.f.getActivity()));
            int roleType = contactInfoItem != null ? contactInfoItem.getRoleType() : 3;
            if (roleType == 1 || roleType == 2) {
                ContactInfoItem contactInfoItem2 = this.f.getActivity().u3().get(DomainHelper.q(messageVo.from));
                if (roleType < (contactInfoItem2 != null ? contactInfoItem2.getRoleType() : 3)) {
                    return messageVo.status == 2;
                }
            }
        }
        return messageVo.isSend && messageVo.status == 2;
    }

    public final void C(String str) {
        try {
            ((ClipboardManager) this.f.getActivity().getSystemService(DataType.CLIPBOARD)).setText(str);
            sy5.e(this.f.getActivity(), R.string.copy_success, 0).g();
        } catch (Exception unused) {
        }
    }

    public final void D(String str) {
        try {
            this.f.getActivity().getMessagingServiceInterface().s(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        eb6.e().a(str);
        com.zenmen.palmchat.database.b.i(str, this.f.b());
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void D0(String str) {
        q05.u(this.f.getActivity(), new h(str));
    }

    public final void E(MessageVo messageVo) {
        ChatterActivity activity = this.f.getActivity();
        if (!a65.e(this.f.b())) {
            if (messageVo.mimeType == 10002) {
                c0();
                return;
            }
            Intent intent = new Intent();
            intent.setClass(activity, SendMessageActivity.class);
            intent.putExtra("message_vo", messageVo);
            activity.startActivity(intent);
            return;
        }
        int i2 = messageVo.mimeType;
        if (i2 != 1 && i2 != 2) {
            c0();
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClass(activity, SendMessageActivity.class);
        intent2.putExtra("message_vo", messageVo);
        activity.startActivity(intent2);
    }

    @Override // com.zenmen.palmchat.utils.urlspan.MyUrlSpan.a
    public void F(int i2, String str, Uri uri, View view) {
        LogUtil.i("ChatterActivityItemListener", "onUrlClicked type =" + i2 + " text =" + str + " uri =" + uri);
        ChatterActivity activity = this.f.getActivity();
        ChatItem chatItemB = this.f.b();
        if (this.b) {
            return;
        }
        if (i2 == 4) {
            new td3.c(activity).c(new String[]{G(R.string.chat_item_menu_dial), G(R.string.chat_item_menu_save), G(R.string.chat_item_menu_copy)}).d(new j(uri, activity, str.replace("tel:", ""))).a().b();
            return;
        }
        if (i2 != 1) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", mu4.a(uri, zy4.i(view.getTag() instanceof String ? (String) view.getTag() : "", chatItemB)));
                intent.setFlags(268435456);
                intent.putExtra("com.android.browser.application_id", activity.getPackageName());
                activity.startActivity(intent);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        String strB = mu4.b(str, zy4.i(view.getTag() instanceof String ? (String) view.getTag() : "", chatItemB));
        Intent intent2 = new Intent();
        intent2.setClass(activity, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", strB);
        bundle.putString("web_url_origin", str);
        bundle.putInt("from_source", this.f.a());
        bundle.putString("extra_key_from_uid", chatItemB.getChatId());
        bundle.putInt("BackgroundColor", -1);
        int i3 = 601;
        if (chatItemB.getChatType() != 0 && chatItemB.getChatType() == 1) {
            i3 = 602;
        }
        bundle.putInt("sourceType", i3);
        intent2.putExtras(bundle);
        activity.startActivity(intent2);
    }

    public final String G(int i2) {
        return this.f.getActivity().getString(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void H(MessageVo messageVo, Object obj) {
        String strB;
        Pair<Integer, ContentValues> pairG;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        String strE;
        Pair<Integer, ContentValues> pairG2;
        String str;
        int i2;
        Intent intentE;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        ChatItem chatItemB = this.f.b();
        ChatterActivity activity = this.f.getActivity();
        xa3.d("click", messageVo, obj);
        int i3 = messageVo.mimeType;
        if (i3 == 2) {
            d0(messageVo);
            return;
        }
        if (i3 == 14) {
            if (messageVo.data5 == null) {
                Intent intent = new Intent(activity, (Class<?>) ExpressionDetailActivity.class);
                intent.putExtra("info_item", chatItemB);
                intent.putExtra("messageVo", messageVo);
                activity.startActivity(intent);
                return;
            }
            return;
        }
        if (i3 == 3) {
            activity.g4(messageVo, obj);
            return;
        }
        if (i3 == 6) {
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
            if (!tg4.b(activity, permissionType.permissionList)) {
                BaseActivityPermissionDispatcher.b(activity, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
                return;
            }
            if (!messageVo.isSend) {
                Intent intent2 = new Intent(activity, (Class<?>) FileDetailActivity.class);
                intent2.putExtra("message_key", messageVo);
                activity.startActivity(intent2);
                return;
            } else {
                if (messageVo.status != 2) {
                    if (messageVo.sendingProgress < (TextUtils.isEmpty(messageVo.data4) ? 0 : Integer.parseInt(messageVo.data4))) {
                        return;
                    }
                    Intent intent3 = new Intent(activity, (Class<?>) FileDetailActivity.class);
                    intent3.putExtra("message_key", messageVo);
                    activity.startActivity(intent3);
                    return;
                }
                if (!TextUtils.isEmpty(messageVo.data1)) {
                    File file = new File(messageVo.data1);
                    if (file.exists()) {
                        messageVo.sendingProgress = (int) file.length();
                    }
                }
                Intent intent4 = new Intent(activity, (Class<?>) FileDetailActivity.class);
                intent4.putExtra("message_key", messageVo);
                activity.startActivity(intent4);
                return;
            }
        }
        if (i3 == 7) {
            Intent intent5 = new Intent(activity, (Class<?>) LocationViewActivityV2.class);
            intent5.putExtra("location", g53.b(messageVo));
            intent5.putExtra("message_vo", messageVo);
            intent5.putExtra("chat_item", chatItemB);
            if (obj instanceof String) {
                intent5.putExtra("clickFrom", (String) obj);
            }
            activity.startActivity(intent5);
            return;
        }
        if (i3 == 9) {
            ChatItem chatItemFromNameCardString = MessageVo.parseChatItemFromNameCardString(messageVo.extention);
            if (chatItemFromNameCardString != null) {
                if (chatItemFromNameCardString.getChatType() != 1) {
                    Intent intent6 = new Intent(activity, (Class<?>) m66.c());
                    intent6.putExtra("from", 10);
                    intent6.putExtra("user_item_info", chatItemFromNameCardString);
                    intent6.putExtra("user_detail_name_card_sender_name", (String) obj);
                    activity.startActivityForResult(intent6, 100);
                    return;
                }
                LogUtil.onEvent(ErrorContants.LOAD_STRATEGY_ERROR, "1", null, null);
                if (chatItemFromNameCardString instanceof GroupInfoItem) {
                    activity.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                    c70.R().F(((GroupInfoItem) chatItemFromNameCardString).getGroupId(), new m(activity, chatItemFromNameCardString, messageVo, obj));
                    return;
                }
                Intent intent7 = new Intent(activity, (Class<?>) GroupDetailActivity.class);
                intent7.putExtra(com.umeng.analytics.pro.f.K, chatItemFromNameCardString);
                intent7.putExtra("issend", messageVo.isSend);
                intent7.putExtra("user_detail_name_card_sender_name", (String) obj);
                activity.startActivityForResult(intent7, 100);
                return;
            }
            return;
        }
        if (i3 == 4) {
            if (l50.a()) {
                return;
            }
            LogUtil.onClickEvent("V37", null, null);
            if (messageVo.isSend && messageVo.status == 3) {
                d0(messageVo);
                return;
            }
            if ((eb6.e().d(messageVo.data1) && messageVo.attachStatus != 4) || messageVo.attachStatus == 5) {
                d0(messageVo);
                return;
            } else {
                eb6.e().b(activity, messageVo.contactRelate, messageVo.mid, messageVo.data3, messageVo.data4, messageVo.data5);
                d0(messageVo);
                return;
            }
        }
        if (i3 != 28) {
            if (i3 == 10005) {
                CircleGuide circleGuide = !TextUtils.isEmpty(messageVo.extention) ? (CircleGuide) az2.a(messageVo.extention, CircleGuide.class) : null;
                if (circleGuide == null || circleGuide.a() == null || (strB = circleGuide.a().b()) == null || (pairG = mb4.g(strB)) == null) {
                    return;
                }
                int iIntValue = ((Integer) pairG.first).intValue();
                ContentValues contentValues = (ContentValues) pairG.second;
                contentValues.put("extra_key_from_uid", messageVo.contactRelate);
                this.f.j(iIntValue, contentValues, null, strB, null, false, messageVo, messageVo.isSend);
                return;
            }
            if (i3 == 30) {
                if (!messageVo.isRead) {
                    AudioController.b0().z0(messageVo);
                }
                fg6.b("click", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 3);
                if ((chatItemB instanceof ContactInfoItem) && ((ContactInfoItem) chatItemB).getIsStranger()) {
                    sy5.f(activity, "成为好友后才能发起语音聊天哦～", 0).g();
                    return;
                }
                if (!fg6.d(AppContext.getContext())) {
                    ap3.z(AppContext.getContext(), BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP, "1", "scene_voice_video_call");
                    return;
                }
                if (com.zenmen.palmchat.videocall.c.g(activity, chatItemB.getChatId())) {
                    return;
                }
                if (!com.zenmen.palmchat.videocall.c.e()) {
                    sy5.e(activity, R.string.service_not_available, 0).g();
                    return;
                } else {
                    if (TextUtils.isEmpty(messageVo.data2)) {
                        return;
                    }
                    com.zenmen.palmchat.videocall.c.b(activity, Integer.valueOf(messageVo.data2).intValue(), new n(messageVo, activity));
                    return;
                }
            }
            if (i3 == 16 || i3 == 17 || i3 == 22 || i3 == 24 || i3 == 56 || i3 != 52) {
                return;
            }
            Serializable serializableBuildFromMessageVo = DragonItem.buildFromMessageVo(messageVo);
            if (serializableBuildFromMessageVo == null) {
                try {
                    lg1.c().i(messageVo.isSend ? DomainHelper.j(messageVo.to) : DomainHelper.j(messageVo.from), new JSONObject(messageVo.extention).optJSONObject("jieLong").optLong("jlId"), new o(messageVo, activity));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Intent intent8 = new Intent();
            String strP = AccountUtils.p(activity);
            intent8.setClass(activity, DragonJoinActivity.class);
            intent8.putExtra(j70.b, strP);
            intent8.putExtra(j70.e, serializableBuildFromMessageVo);
            activity.startActivity(intent8);
            return;
        }
        if (o30.s() && !TextUtils.isEmpty(messageVo.mid) && messageVo.mid.startsWith("chatmate")) {
            if (o30.t()) {
                sy5.h(activity, "该功能暂不支持青少年模式使用", 0);
                return;
            }
            try {
                String str2 = messageVo.extention;
                if (TextUtils.isEmpty(str2) || (jSONObjectOptJSONObject = new JSONObject(str2).optJSONObject("noticeBar")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ext")) == null) {
                    return;
                }
                String strOptString = jSONObjectOptJSONObject2.optString("roomId");
                String str3 = jSONObjectOptJSONObject2.optLong("oid") + "";
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                o30.x(activity, strOptString, 3, str3);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Integer num = (Integer) obj;
        RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
        if (richMsgExVoH == null || num == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= num.intValue() || (richMsgExItemVo = richMsgExVoH.items.get(num.intValue())) == null) {
            return;
        }
        if (T()) {
            strE = q03.e(messageVo.data1);
            q03.b(strE);
        } else {
            strE = richMsgExItemVo.openLink;
            q03.a(richMsgExItemVo.showType, messageVo.data4);
        }
        if (!TextUtils.isEmpty(strE) && (intentE = bu3.g().e(activity, strE)) != null) {
            activity.startActivity(intentE);
            return;
        }
        String str4 = richMsgExItemVo.url;
        if (str4 == null || (pairG2 = mb4.g(str4)) == null) {
            return;
        }
        if (b65.a().b(messageVo.contactRelate)) {
            b65.c();
            str = null;
            i2 = 9;
        } else {
            int iIntValue2 = ((Integer) pairG2.first).intValue();
            ContentValues contentValues2 = (ContentValues) pairG2.second;
            contentValues2.put("extra_key_from_uid", messageVo.contactRelate);
            tk2 tk2Var = this.f;
            int i4 = richMsgExVoH.forwardable == 0 ? 1 : 0;
            str = null;
            boolean z = i4;
            i2 = 9;
            tk2Var.j(iIntValue2, contentValues2, null, str4, richMsgExItemVo, z, messageVo, messageVo.isSend);
        }
        if ("88888000".equals(messageVo.contactRelate)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str4);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H1", str, str, jSONObject.toString());
        }
        if ("88888888".equals(messageVo.contactRelate)) {
            String queryParameter = Uri.parse(str4).getQueryParameter("type");
            if ("redBubble1".equals(queryParameter)) {
                LogUtil.uploadInfoImmediate("hbd07", str, str, str);
            }
            if ("redBubble2".equals(queryParameter)) {
                LogUtil.uploadInfoImmediate("hbd08", str, str, str);
            }
            if ("redBubble3".equals(queryParameter)) {
                LogUtil.uploadInfoImmediate("hbd09", str, str, str);
            }
            if (richMsgExItemVo.activityId == 1) {
                LogUtil.uploadInfoImmediate("AM401", str, str, str);
            }
        }
        if (a65.f(messageVo.contactRelate)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(DeviceInfoUtil.UID_TAG, messageVo.contactRelate);
                jSONObject2.put("mid", messageVo.mid);
                jSONObject2.put("showType", richMsgExItemVo.showType);
                jSONObject2.put("isAds5", com.zenmen.palmchat.chat.g.r(richMsgExItemVo));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H11", str, str, jSONObject2.toString());
        }
        if ("88888003".equals(messageVo.contactRelate)) {
            return;
        }
        int i5 = richMsgExItemVo.showType;
        if (i5 == 8 || i5 == i2) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("mid", messageVo.mid);
                jSONObject3.put("showType", richMsgExItemVo.showType);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("M17", str, jSONObject3.toString());
        }
    }

    public final void I(MessageVo messageVo) {
        lg1.c().m(messageVo);
    }

    public final int J(ContactInfoItem contactInfoItem) {
        ChatItem chatItemB = this.f.b();
        if (!vs0.a().e("isGroupGiftEnable", false) || !(chatItemB instanceof GroupInfoItem)) {
            return 0;
        }
        GroupInfoItem groupInfoItem = (GroupInfoItem) chatItemB;
        if (AccountUtils.p(AppContext.getContext()).equals(contactInfoItem.getUid()) || groupInfoItem.getGroupState() != 0 || new r03().c(groupInfoItem.getGroupId(), contactInfoItem.getUid()) == null) {
            return 0;
        }
        return contactInfoItem.getRoleType() <= groupInfoItem.getRoleType() ? 1 : 2;
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void J0(ChatterAdapter.OtherViewType otherViewType, MessageVo messageVo) {
        if (ChatterAdapter.OtherViewType.ReSendRedPacket != otherViewType && ChatterAdapter.OtherViewType.SendImageToMoments == otherViewType) {
            r55.c(this.f.getActivity(), messageVo, 32);
            LogUtil.onImmediateClickEvent("M18", null, null);
        }
    }

    public final boolean K() {
        ChatItem chatItemB = this.f.b();
        if (chatItemB.getChatType() != 1 || !(chatItemB instanceof GroupInfoItem)) {
            return false;
        }
        GroupInfoItem groupInfoItem = (GroupInfoItem) chatItemB;
        return groupInfoItem.getRoomType() == 1 || groupInfoItem.getRoomType() == 2;
    }

    public final boolean L() {
        ChatItem chatItemB = this.f.b();
        return (chatItemB instanceof GroupInfoItem) && ((GroupInfoItem) chatItemB).getGroupExtTypeFromExtension() == 2;
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void N(MessageVo messageVo) {
        r0(3, messageVo);
        String str = pu1.f20095a;
        String str2 = File.separator;
        String str3 = messageVo.mid;
        dt0.l(AppContext.getContext(), Volley.getUserAgent()).h(messageVo.data2);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void Q(MessageVo messageVo) {
        if (messageVo != null) {
            this.f.getActivity().c5(messageVo.mid);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean R(ContactInfoItem contactInfoItem) throws Throwable {
        char c2;
        ChatItem chatItemB = this.f.b();
        HashMap map = new HashMap();
        map.put("operateuid", AccountUtils.p(AppContext.getContext()));
        map.put(DeviceInfoUtil.UID_TAG, contactInfoItem.getUid());
        char c3 = 2;
        if (contactInfoItem.getRoleType() != 3) {
            c2 = contactInfoItem.getRoleType() == 2 ? (char) 2 : contactInfoItem.getRoleType() == 1 ? (char) 3 : (char) 1;
        }
        GroupInfoItem groupInfoItem = (GroupInfoItem) chatItemB;
        if (groupInfoItem != null && groupInfoItem.getRoleType() == 1) {
            map.put("fromtype", "1");
            c3 = 3;
        } else if (groupInfoItem == null || groupInfoItem.getRoleType() != 2) {
            map.put("fromtype", "3");
            c3 = 1;
        } else {
            map.put("fromtype", "2");
        }
        ContactInfoItem contactInfoItemC = new r03().c(groupInfoItem.getGroupId(), contactInfoItem.getUid());
        if (AccountUtils.p(AppContext.getContext()).equals(contactInfoItem.getUid())) {
            oc0.i("lx_groupchat_speaker_click", map);
            return false;
        }
        if (groupInfoItem.getGroupState() == 0) {
            oc0.i("lx_groupchat_speaker_click", map);
            return contactInfoItemC != null && c3 > c2;
        }
        map.put("fromtype", "4");
        oc0.i("lx_groupchat_speaker_click", map);
        return false;
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void S(MessageVo messageVo) {
        ChatterAdapter chatterAdapter = this.f.getActivity().C;
        if (messageVo == null || chatterAdapter == null) {
            return;
        }
        try {
            chatterAdapter.I().remove(messageVo);
            chatterAdapter.notifyDataSetChanged();
        } catch (Exception unused) {
        }
    }

    public boolean T() {
        ChatItem chatItemB = this.f.b();
        return chatItemB != null && a65.e(chatItemB);
    }

    public void U(ArrayList<String> arrayList) {
        MessageVo messageVo = this.d;
        if (messageVo == null || arrayList == null || !arrayList.contains(messageVo.mid)) {
            return;
        }
        this.c.a();
    }

    public final void W(MessageVo messageVo) {
        if (messageVo.isSend) {
            l0();
        }
        iq5.j(false, new String[0]);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void X(ContactInfoItem contactInfoItem) {
        m0(contactInfoItem, 0L);
    }

    public final void Y(MessageVo messageVo) {
        ChatterActivity activity = this.f.getActivity();
        ChatItem chatItemB = this.f.b();
        q qVar = new q(activity, messageVo, chatItemB);
        r rVar = new r(activity);
        HashMap map = new HashMap();
        map.put("mid", messageVo.mid);
        map.put(RemoteMessageConst.TO, DomainHelper.a(chatItemB, true));
        if (!messageVo.isSend) {
            map.put("midOwner", DomainHelper.q(messageVo.from));
        }
        try {
            new st4(qVar, rVar).n(map);
            activity.showBaseProgressBar(G(R.string.message_recall), false, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void Z(MessageVo messageVo) {
        ChatItem chatItemB = this.f.b();
        ChatterActivity activity = this.f.getActivity();
        int i2 = activity.x;
        if (chatItemB == null || TextUtils.isEmpty(chatItemB.getChatId())) {
            return;
        }
        try {
            String str = messageVo.mid;
            if (!TextUtils.isEmpty(str)) {
                String strE = DomainHelper.e(chatItemB);
                int i3 = messageVo.mimeType;
                if (i3 == 1) {
                    activity.getMessagingServiceInterface().r(MessageVo.buildTextMessage(str, strE, messageVo.text, (String[]) null, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(activity, i2));
                } else if (i3 == 2) {
                    PhotoObject photoObjectBuildImageMessageSend = MessageVo.buildImageMessageSend(messageVo);
                    if (photoObjectBuildImageMessageSend != null) {
                        activity.getMessagingServiceInterface().r(MessageVo.buildImageMessage(str, strE, photoObjectBuildImageMessageSend, photoObjectBuildImageMessageSend.isOriImage, 1, messageVo.time, (String) null).setSendNetStatus(messageVo.data9).setThreadBizType(activity, i2));
                    }
                } else if (i3 == 14) {
                    ExpressionObject expressionObjectBuildExpressionMessageSend = MessageVo.buildExpressionMessageSend(messageVo);
                    if (expressionObjectBuildExpressionMessageSend != null) {
                        expressionObjectBuildExpressionMessageSend.tag = messageVo.data5;
                        activity.getMessagingServiceInterface().r(MessageVo.buildExpressionMessage(str, strE, expressionObjectBuildExpressionMessageSend, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                    }
                } else if (i3 == 3) {
                    AudioObject audioObject = new AudioObject();
                    audioObject.setMessageId(messageVo.mid);
                    audioObject.setDuration(Integer.parseInt(messageVo.data1));
                    audioObject.setDate(ir5.b());
                    audioObject.setMimeType("audio/ogg");
                    audioObject.setPath(messageVo.data2);
                    audioObject.setTarget(DomainHelper.e(chatItemB));
                    activity.getMessagingServiceInterface().r(MessageVo.buildAudioMessage(audioObject, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                } else if (i3 == 6) {
                    if (new File(messageVo.data1).exists()) {
                        activity.getMessagingServiceInterface().r(MessageVo.buildFileMessage(str, strE, messageVo.data1, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                    } else {
                        sy5.e(AppContext.getContext(), R.string.send_file_delete, 0).g();
                    }
                } else if (i3 == 7) {
                    activity.getMessagingServiceInterface().r(MessageVo.buildForwardLocationMessage(str, strE, messageVo.data1, messageVo.data2, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                } else if (i3 == 9) {
                    if (chatItemB.getChatType() == 1) {
                        activity.getMessagingServiceInterface().r(MessageVo.buildNameCardMessage(str, strE, GroupInfoItem.parseFromNameCardString(messageVo.extention), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), 1));
                    } else {
                        activity.getMessagingServiceInterface().r(MessageVo.buildNameCardMessage(str, strE, nn0.e(messageVo.extention), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                    }
                } else if (i3 == 4) {
                    activity.getMessagingServiceInterface().r(MessageVo.buildVideoMessage(str, strE, messageVo.data1, messageVo.data2, messageVo.hdFlag, 1, messageVo.time, Long.valueOf(messageVo.data6).longValue()).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                } else if (i3 == 28) {
                    activity.getMessagingServiceInterface().r(MessageVo.buildResendLinkMessage(str, strE, messageVo, 1).setSendNetStatus(messageVo.data9).setThreadBizType(activity, i2));
                } else if (i3 == 16) {
                    activity.getMessagingServiceInterface().r(MessageVo.buildRedPacketMessage(str, strE, RedPacketVo.buildFromMessageVo(messageVo), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                } else if (i3 == 22) {
                    activity.getMessagingServiceInterface().r(MessageVo.buildVoucherRedPacketMessage(str, strE, VoucherRedPacketVo.buildFromMessageVo(messageVo), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                } else if (i3 == 17) {
                    activity.getMessagingServiceInterface().r(MessageVo.buildTransferMessage(str, "0", strE, TransferVo.buildFromMessageVo(messageVo), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(AppContext.getContext(), i2));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i("ChatterActivityItemListener", 3, new e(), e2);
        }
    }

    @Override // defpackage.w8
    public void a(String str) {
        InputFragment inputFragmentH = this.f.h();
        if (inputFragmentH != null) {
            inputFragmentH.a(str);
        }
    }

    public final void a0(MessageVo messageVo) throws Throwable {
        String strG = G(R.string.string_add_expression_fail);
        String strF = com.zenmen.palmchat.expression.a.f(messageVo);
        if (!TextUtils.isEmpty(strF)) {
            File fileB = sd1.b(strF);
            String strE = (fileB == null || !fileB.exists()) ? com.zenmen.palmchat.expression.a.e(messageVo) : fileB.getAbsolutePath();
            if (strE != null) {
                try {
                    String str = pu1.k + File.separator + System.currentTimeMillis();
                    File fileC = pu1.c(str);
                    pu1.f(new File(strE), fileC);
                    ExpressionObject expressionObject = new ExpressionObject();
                    expressionObject.path = str;
                    expressionObject.coverPath = str;
                    expressionObject.md5 = rb3.b(fileC);
                    ot1.b(expressionObject);
                    strG = G(R.string.string_add_expression_success);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        sy5.f(this.f.getActivity(), strG, 0).g();
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void b0(MessageVo messageVo, boolean z) {
        if (z) {
            new sd3(this.f.getActivity()).j(R.string.confirm_resend_message).O(R.string.confirm_resend_message_retry).K(R.string.dialog_cancel).f(new f(messageVo)).e().show();
        } else {
            Z(messageVo);
        }
    }

    public final void c0() {
        ChatterActivity activity = this.f.getActivity();
        MaterialDialog materialDialogE = new sd3(activity).j(R.string.string_secretary_confine_forward_dialog_content).O(R.string.chat_item_menu_forward).M(activity.getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.dialog_cancel).I(activity.getResources().getColor(R.color.material_dialog_button_text_color)).f(new b()).e();
        this.f17436a = materialDialogE;
        if (materialDialogE.isShowing()) {
            return;
        }
        this.f17436a.show();
    }

    public final void d0(MessageVo messageVo) {
        ChatItem chatItemB = this.f.b();
        if (chatItemB != null) {
            Intent intent = new Intent();
            intent.setClass(this.f.getActivity(), PhotoViewActivity.class);
            intent.putExtra("info_item", chatItemB);
            intent.putExtra("need_load_chat_image_list", true);
            intent.putExtra("first_item_mid", messageVo.mid);
            MediaItem mediaItem = new MediaItem();
            if (!TextUtils.isEmpty(messageVo.data1) && messageVo.attachStatus != 5 && new File(messageVo.data1).exists()) {
                mediaItem.localPath = messageVo.data1;
                mediaItem.mid = messageVo.mid;
                mediaItem.fileFullPath = messageVo.data3;
                mediaItem.extension = messageVo.data4;
                mediaItem.mimeType = messageVo.mimeType;
                int i2 = messageVo.attachStatus;
                try {
                    mediaItem.playLength = Integer.parseInt(messageVo.data6);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                mediaItem.isFileExpired = i2 == 5;
                intent.putExtra("first_item", mediaItem);
            }
            intent.putExtra("show_mode", 1);
            intent.putExtra("message_vo", messageVo);
            this.f.getActivity().startActivity(intent);
        }
    }

    public final void e0() {
        sy5.e(this.f.getActivity(), R.string.net_operation_fail, 0).g();
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void f0() {
        this.f.getActivity().Q4(false);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void g0(MessageVo messageVo, String str, QuickSendVo quickSendVo) {
        this.f.h().g0(messageVo, str, quickSendVo);
    }

    public final void h0(String str) {
        ChatterActivity activity = this.f.getActivity();
        new td3.c(activity).c(new String[]{G(R.string.chat_item_menu_create_contact), G(R.string.chat_item_menu_edit_contact)}).d(new i(str, activity)).a().b();
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public boolean i0() {
        return this.f.getActivity().C.U();
    }

    public final void j0(MessageVo messageVo) {
        if (messageVo.isSend) {
            Y(messageVo);
            return;
        }
        oc0.g("lx_group_message_chehui_cick");
        new sd3(this.f.getActivity()).k("是否撤回该成员的消息？").O(R.string.string_dialog_positive).N(R.color.Ga).L("取消").J(R.color.Ge).f(new p(messageVo)).e().show();
        oc0.g("lx_group_message_chehui_dailog_show");
    }

    public final void k0() {
        new sd3(this.f.getActivity()).j(nl0.g() ? R.string.message_recall_fail_past_time : R.string.message_recall_fail_past_time_im).O(R.string.alert_dialog_ok).e().show();
    }

    @Override // defpackage.w8
    public void l() {
        InputFragment inputFragmentG = this.f.g();
        if (inputFragmentG != null) {
            inputFragmentG.l();
        }
    }

    public final void l0() {
        if (AppContext.getContext().getTrayPreferences().a("key_show_recall", true)) {
            new sd3(this.f.getActivity()).j(R.string.message_recall_success).O(R.string.alert_dialog_ok).e().show();
            AppContext.getContext().getTrayPreferences().i("key_show_recall", false);
        }
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void m(MessageVo messageVo, Object obj) {
        ChatItem chatItemB = this.f.b();
        ChatterActivity activity = this.f.getActivity();
        int i2 = 1;
        this.b = true;
        this.d = messageVo;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean zB = B(chatItemB, messageVo);
        boolean z = messageVo.attachStatus == 5;
        int i3 = messageVo.mimeType;
        if (i3 == 1) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.COPY);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 2) {
            if (!z) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
                if (MomentsConfig.j() && rl0.h().i().f()) {
                    linkedHashSet.add(ChatterActivity.LongClickMenuItem.MOMENTS);
                }
            }
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 3) {
            linkedHashSet.add(activity.I0 ? ChatterActivity.LongClickMenuItem.SPEAKERMODE1 : ChatterActivity.LongClickMenuItem.SPEAKERMODE2);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 6) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 7) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 14) {
            if (ot1.c(messageVo.data4)) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION);
            }
            if (!z) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            }
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 9) {
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 28) {
            RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
            if (richMsgExVoH != null && richMsgExVoH.forwardable == 0) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            }
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 10005 || i3 == 53) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 34) {
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
        } else if (i3 == 37) {
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
        } else if (i3 == 4) {
            if (!z) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            }
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 10002) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.COPY);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i3 == 30 || i3 == 16) {
            if (i3 == 30) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
        } else if (i3 == 22 || i3 == 30 || i3 == 17 || i3 == 24) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
        } else {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.COPY);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zB) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        }
        if (fu5.t(activity.y)) {
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.MORE);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.MOMENTS);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.SPEAKERMODE1);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.SPEAKERMODE2);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.REPORT);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.KICKOUT);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(this.e.get((ChatterActivity.LongClickMenuItem) it.next()));
        }
        td3 td3VarA = new td3.c(activity).c((String[]) arrayList.toArray(new String[arrayList.size()])).d(new d(activity, messageVo, obj)).b(new c()).a();
        this.c = td3VarA;
        td3VarA.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            if (!fg6.d(AppContext.getContext())) {
                i2 = 0;
            }
            jSONObject.put("svip_status", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("msg_longpress_popup", "click", jSONObject);
    }

    public final void m0(ContactInfoItem contactInfoItem, long j2) {
        ChatItem chatItemB = this.f.b();
        InputFragment inputFragmentH = this.f.h();
        String groupRemarkName = !TextUtils.isEmpty(contactInfoItem.getGroupRemarkName()) ? contactInfoItem.getGroupRemarkName() : contactInfoItem.getNickName();
        if (chatItemB.getChatType() == 1) {
            groupRemarkName = "@" + groupRemarkName + " ";
            inputFragmentH.S1(contactInfoItem.getUid());
        }
        inputFragmentH.X1(groupRemarkName, true, j2);
    }

    public final void n0(String str, int i2, MessageVo messageVo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data1", str);
        contentValues.put("msg_sending_progress", Integer.valueOf(i2));
        this.f.getActivity().getContentResolver().update(DBUriManager.b(ho3.class, this.f.b()), contentValues, "packet_id=?", new String[]{messageVo.mid});
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void o0(MessageVo messageVo) {
        String str = messageVo.data2;
        String str2 = messageVo.data3;
        int i2 = Integer.parseInt(messageVo.data4);
        String str3 = pu1.h + File.separator + messageVo.mid;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdir();
        }
        r0(1, messageVo);
        dt0.l(AppContext.getContext(), Volley.getUserAgent()).e(str, str3, str2, new g(i2, messageVo));
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void o1(MessageVo messageVo) {
        this.f.d(messageVo);
    }

    @Override // defpackage.w8
    public void p() {
        InputFragment inputFragmentG = this.f.g();
        if (inputFragmentG != null) {
            inputFragmentG.p();
        }
    }

    public final void p0(int i2, MessageVo messageVo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_sending_progress", Integer.valueOf(i2));
        this.f.getActivity().getContentResolver().update(DBUriManager.b(ho3.class, this.f.b()), contentValues, "packet_id=?", new String[]{messageVo.mid});
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void q0(ContactInfoItem contactInfoItem) {
        ChatItem chatItemB = this.f.b();
        InputFragment inputFragmentG = this.f.g();
        int iJ = J(contactInfoItem);
        if (iJ > 0) {
            if (inputFragmentG != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(contactInfoItem);
                inputFragmentG.q3(this.g);
                inputFragmentG.E3(arrayList, 2 | ((iJ & 2) == 2 ? 4 : 0) | (L() ? 8 : 0));
                return;
            }
            return;
        }
        if (oc0.f() && K() && R(contactInfoItem)) {
            new DialogCircleQuickRemoveOrShutUp(this.f.getActivity(), new l(contactInfoItem)).Q(this.f.getActivity(), (GroupInfoItem) chatItemB, contactInfoItem);
        } else {
            this.f.i(contactInfoItem);
        }
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void q1(String str) {
        ve.o(this.f.getActivity(), str, false);
    }

    public final void r0(int i2, MessageVo messageVo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("attach_status", Integer.valueOf(i2));
        this.f.getActivity().getContentResolver().update(DBUriManager.b(ho3.class, this.f.b()), contentValues, "packet_id=?", new String[]{messageVo.mid});
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void t(MessageVo messageVo, String str) {
        try {
            if (this.f.getActivity().getMessagingServiceInterface() != null && messageVo != null) {
                this.f.getActivity().getMessagingServiceInterface().r(messageVo);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        hp.g(str, this.f.b());
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void v0(MessageVo messageVo, String str) {
        try {
            if (this.f.getActivity().getMessagingServiceInterface() != null && messageVo != null) {
                this.f.getActivity().getMessagingServiceInterface().r(messageVo);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ChatBreakHelper.n(str, this.f.b());
    }

    @Override // defpackage.w8
    public void w() {
        this.f.getActivity().p4();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements DialogCircleQuickRemoveOrShutUp.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f17450a;

        public l(ContactInfoItem contactInfoItem) {
            this.f17450a = contactInfoItem;
        }

        @Override // com.zenmen.palmchat.circle.ui.dialog.DialogCircleQuickRemoveOrShutUp.f
        public void a() {
            f50.this.f.i(this.f17450a);
        }

        @Override // com.zenmen.palmchat.circle.ui.dialog.DialogCircleQuickRemoveOrShutUp.f
        public void b() {
        }
    }
}
