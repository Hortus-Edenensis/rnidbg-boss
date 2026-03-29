package com.zenmen.palmchat.chat.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.toolbox.Volley;
import com.bytedance.bpea.entry.common.DataType;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.constant.az;
import com.opos.acs.st.utils.ErrorContants;
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
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.fragment.SimpleChatFragment;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.circle.app.dragon.DragonItem;
import com.zenmen.palmchat.circle.app.dragon.DragonJoinActivity;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.expression.ExpressionDetailActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupDetailActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationViewActivity;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.media.AudioObject;
import com.zenmen.palmchat.media.file.FileDetailActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.RedPacketVo;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.transfer.bean.TransferVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.c;
import defpackage.a65;
import defpackage.ap3;
import defpackage.az2;
import defpackage.b65;
import defpackage.bu3;
import defpackage.c70;
import defpackage.dt0;
import defpackage.eb6;
import defpackage.ed5;
import defpackage.f50;
import defpackage.fg6;
import defpackage.fu5;
import defpackage.g53;
import defpackage.ho3;
import defpackage.hp;
import defpackage.ir5;
import defpackage.j70;
import defpackage.k86;
import defpackage.l50;
import defpackage.lg1;
import defpackage.m66;
import defpackage.mb4;
import defpackage.mu4;
import defpackage.nn0;
import defpackage.ot1;
import defpackage.pu1;
import defpackage.q03;
import defpackage.r55;
import defpackage.r75;
import defpackage.rb3;
import defpackage.rl0;
import defpackage.sd1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.td3;
import defpackage.tg4;
import defpackage.ve;
import defpackage.wi0;
import defpackage.xa3;
import defpackage.zy4;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b implements ChatterAdapter.h {
    public static final String f = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleChatFragment f12825a;
    public com.zenmen.palmchat.chat.fragment.c b;
    public boolean c = false;
    public td3 d;
    public MessageVo e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ed5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12826a;
        public final /* synthetic */ MessageVo b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0990a implements Runnable {
            public RunnableC0990a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                sy5.e(AppContext.getContext(), R.string.network_exception_title, 0).g();
            }
        }

        public a(int i, MessageVo messageVo) {
            this.f12826a = i;
            this.b = messageVo;
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onError(int i, String str) {
            LogUtil.d(b.f, str);
            b.this.I(0, this.b);
            b.this.f12825a.getActivity().runOnUiThread(new RunnableC0990a());
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onFinish(File file) {
            if (file != null && file.exists()) {
                b.this.E(file.getAbsolutePath(), (int) file.length(), this.b);
            }
            b.this.I(2, this.b);
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onProgress(int i) {
            LogUtil.d(b.f, "progress " + i);
            if (i >= this.f12826a) {
                LogUtil.d(b.f, "download length exceed,file size is:" + this.f12826a);
                i = this.f12826a;
            }
            b.this.G(i, this.b);
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0991b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12828a;

        public C0991b(MessageVo messageVo) {
            this.f12828a = messageVo;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            b.this.A(this.f12828a);
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12829a;

        public c(String str) {
            this.f12829a = str;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            try {
                if (i == 0) {
                    Intent intent = new Intent("android.intent.action.INSERT");
                    intent.setType("vnd.android.cursor.dir/person");
                    intent.setType("vnd.android.cursor.dir/contact");
                    intent.setType("vnd.android.cursor.dir/raw_contact");
                    intent.putExtra("phone", this.f12829a);
                    b.this.f12825a.startActivity(intent);
                } else {
                    Intent intent2 = new Intent("android.intent.action.INSERT_OR_EDIT");
                    intent2.setType("vnd.android.cursor.item/person");
                    intent2.putExtra("phone", this.f12829a);
                    intent2.putExtra("phone_type", 2);
                    b.this.f12825a.startActivity(intent2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", "send_message");
            put("status", "cancelSendMessage");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f12831a;
        public final /* synthetic */ String b;

        public e(Uri uri, String str) {
            this.f12831a = uri;
            this.b = str;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i == 0) {
                Intent intent = new Intent("android.intent.action.VIEW", this.f12831a);
                intent.putExtra("com.android.browser.application_id", b.this.f12825a.getActivity().getPackageName());
                b.this.f12825a.startActivity(intent);
            } else if (i == 1) {
                b.this.D(this.b);
            } else if (i == 2) {
                ((ClipboardManager) b.this.f12825a.getActivity().getSystemService(DataType.CLIPBOARD)).setText(this.b);
                sy5.e(b.this.f12825a.getActivity(), R.string.copy_success, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("action", "send_message");
            put("status", "downloadAudioFileByMessageId");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends wi0<BaseResponse<CircleRecommendItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12833a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ Object c;

        public g(ChatItem chatItem, MessageVo messageVo, Object obj) {
            this.f12833a = chatItem;
            this.b = messageVo;
            this.c = obj;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleRecommendItem> baseResponse) {
            b.this.f12825a.G();
            if (baseResponse.getResultCode() != 0) {
                Toast.makeText(b.this.f12825a.getActivity(), baseResponse.getErrorMsg(), 0).show();
                return;
            }
            CircleRecommendItem data = baseResponse.getData();
            if (data != null) {
                GroupInfoItem groupInfoItemCopyForGroupInfoItem = data.copyForGroupInfoItem();
                if (groupInfoItemCopyForGroupInfoItem.getRoomType() == 1 || groupInfoItemCopyForGroupInfoItem.getRoomType() == 2) {
                    Intent intent = new Intent(AppContext.getContext(), (Class<?>) CircleDetailActivity.class);
                    intent.putExtra("key_group_info", groupInfoItemCopyForGroupInfoItem);
                    intent.putExtra("key_apply_group_source", 2);
                    b.this.f12825a.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) GroupDetailActivity.class);
                intent2.putExtra(com.umeng.analytics.pro.f.K, this.f12833a);
                intent2.putExtra("issend", this.b.isSend);
                intent2.putExtra("user_detail_name_card_sender_name", (String) this.c);
                b.this.f12825a.startActivityForResult(intent2, 100);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12834a;

        public h(MessageVo messageVo) {
            this.f12834a = messageVo;
        }

        @Override // com.zenmen.palmchat.videocall.c.d
        public void a() {
            r75.p(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 0);
            if (Integer.valueOf(this.f12834a.data2).intValue() == 0) {
                BaseActivityPermissionDispatcher.b(b.this.f12825a.b1().b(), BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_CALL);
            } else {
                BaseActivityPermissionDispatcher.b(b.this.f12825a.b1().b(), BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_AUDIO_CALL);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends wi0<BaseResponse<DragonItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12835a;

        public i(MessageVo messageVo) {
            this.f12835a = messageVo;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DragonItem> baseResponse) {
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                return;
            }
            this.f12835a.extention = new Gson().toJson(baseResponse);
            com.zenmen.palmchat.database.b.N(this.f12835a);
            DragonItem data = baseResponse.getData();
            Intent intent = new Intent(b.this.f12825a.getActivity(), (Class<?>) DragonJoinActivity.class);
            intent.putExtra(j70.b, AccountUtils.p(AppContext.getContext()));
            intent.putExtra(j70.e, data);
            b.this.f12825a.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements td3.e {
        public j() {
        }

        @Override // td3.e
        public void a(td3 td3Var) {
            b.this.c = false;
            b.this.e = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f12837a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ Object c;

        public k(HashMap map, MessageVo messageVo, Object obj) {
            this.f12837a = map;
            this.b = messageVo;
            this.c = obj;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) throws Throwable {
            ArrayList<RichMsgExItemVo> arrayList;
            ArrayList<RichMsgExItemVo> arrayList2;
            if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.MORE))) {
                b.this.f12825a.O0().F0(true, this.b);
                b.this.f12825a.x0(this.b);
                return;
            }
            if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.DELETE))) {
                b.this.u(this.b.mid);
                return;
            }
            if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.COPY))) {
                MessageVo messageVo = this.b;
                String strB = messageVo.text;
                if (messageVo.mimeType == 10002) {
                    strB = a65.b(strB);
                }
                b.this.s(strB);
                return;
            }
            if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.BUBBLE))) {
                f50.V(b.this.f12825a.getActivity());
                return;
            }
            if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.RECALL))) {
                b.this.f12825a.J1(this.b);
                return;
            }
            if (!charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.FORWARD))) {
                if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.MOMENTS))) {
                    r55.c(b.this.f12825a.getActivity(), this.b, 31);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(az.at, 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LogUtil.onImmediateClickEvent("M185", null, jSONObject.toString());
                    return;
                }
                if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.SPEAKERMODE1)) || charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.SPEAKERMODE2))) {
                    b.this.f12825a.F1(true ^ b.this.f12825a.p1());
                    AppContext.getContext().getTrayPreferences().i("receiver_mode", b.this.f12825a.p1());
                    AudioController.b0().y0(b.this.f12825a.p1());
                    sy5.e(b.this.f12825a.getActivity(), b.this.f12825a.p1() ? R.string.chat_notice_audio_play_out_receiver : R.string.chat_notice_audio_play_out_speaker, 0).g();
                    return;
                }
                if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION))) {
                    b.this.B(this.b);
                    return;
                } else {
                    if (charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.REPORT))) {
                        return;
                    }
                    charSequence.toString().equals(this.f12837a.get(ChatterActivity.LongClickMenuItem.KICKOUT));
                    return;
                }
            }
            if (com.zenmen.palmchat.chat.fragment.c.n(this.b)) {
                new sd3(b.this.f12825a.getActivity()).j(R.string.downloading_before_forward).O(R.string.alert_dialog_ok).e().show();
                return;
            }
            MessageVo messageVo2 = this.b;
            if (messageVo2.mimeType != 28) {
                b.this.v(messageVo2);
                return;
            }
            Integer num = (Integer) this.c;
            RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo2);
            if (!TextUtils.isEmpty(this.b.extention) && this.b.extention.equals("message_type_link_illegal")) {
                new sd3(b.this.f12825a.getActivity()).j(R.string.string_forward_dialog_illegal).O(R.string.alert_dialog_ok).e().show();
                return;
            }
            if (richMsgExVoH != null && (arrayList2 = richMsgExVoH.items) != null && arrayList2.size() == 1 && (richMsgExVoH.items.get(0).showType == 11 || richMsgExVoH.items.get(0).showType == 14)) {
                b.this.v(this.b);
                return;
            }
            if (richMsgExVoH == null || num == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= num.intValue()) {
                b.this.v(this.b);
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
            b.this.v(messageVoM791clone);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends HashMap<String, Object> {
        public l() {
            put("action", "send_message");
            put("status", "reSend");
        }
    }

    public b(SimpleChatFragment simpleChatFragment, com.zenmen.palmchat.chat.fragment.c cVar) {
        this.f12825a = simpleChatFragment;
        this.b = cVar;
    }

    public final void A(MessageVo messageVo) {
        ChatItem chatItemL0 = this.f12825a.L0();
        int bizType = chatItemL0.getBizType();
        this.f12825a.b1();
        if (TextUtils.isEmpty(chatItemL0.getChatId())) {
            return;
        }
        try {
            String str = messageVo.mid;
            if (!TextUtils.isEmpty(str)) {
                String strE = DomainHelper.e(chatItemL0);
                int i2 = messageVo.mimeType;
                if (i2 == 1) {
                    this.b.h().r(MessageVo.buildTextMessage(str, strE, messageVo.text, (String[]) null, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                } else if (i2 == 2) {
                    PhotoObject photoObjectBuildImageMessageSend = MessageVo.buildImageMessageSend(messageVo);
                    if (photoObjectBuildImageMessageSend != null) {
                        this.b.h().r(MessageVo.buildImageMessage(str, strE, photoObjectBuildImageMessageSend, photoObjectBuildImageMessageSend.isOriImage, 1, messageVo.time, (String) null).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                    }
                } else if (i2 == 14) {
                    ExpressionObject expressionObjectBuildExpressionMessageSend = MessageVo.buildExpressionMessageSend(messageVo);
                    if (expressionObjectBuildExpressionMessageSend != null) {
                        expressionObjectBuildExpressionMessageSend.tag = messageVo.data5;
                        this.b.h().r(MessageVo.buildExpressionMessage(str, strE, expressionObjectBuildExpressionMessageSend, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                    }
                } else if (i2 == 3) {
                    AudioObject audioObject = new AudioObject();
                    audioObject.setMessageId(messageVo.mid);
                    audioObject.setDuration(Integer.parseInt(messageVo.data1));
                    audioObject.setDate(ir5.b());
                    audioObject.setMimeType("audio/ogg");
                    audioObject.setPath(messageVo.data2);
                    audioObject.setTarget(DomainHelper.e(chatItemL0));
                    this.b.h().r(MessageVo.buildAudioMessage(audioObject, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                } else if (i2 == 6) {
                    if (new File(messageVo.data1).exists()) {
                        this.b.h().r(MessageVo.buildFileMessage(str, strE, messageVo.data1, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                    } else {
                        sy5.e(AppContext.getContext(), R.string.send_file_delete, 0).g();
                    }
                } else if (i2 == 7) {
                    this.b.h().r(MessageVo.buildForwardLocationMessage(str, strE, messageVo.data1, messageVo.data2, 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                } else if (i2 == 9) {
                    if (chatItemL0.getChatType() == 1) {
                        this.b.h().r(MessageVo.buildNameCardMessage(str, strE, GroupInfoItem.parseFromNameCardString(messageVo.extention), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), 1));
                    } else {
                        this.b.h().r(MessageVo.buildNameCardMessage(str, strE, nn0.e(messageVo.extention), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                    }
                } else if (i2 == 4) {
                    this.b.h().r(MessageVo.buildVideoMessage(str, strE, messageVo.data1, messageVo.data2, messageVo.hdFlag, 1, messageVo.time, Long.valueOf(messageVo.data6).longValue()).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                } else if (i2 == 28) {
                    this.b.h().r(MessageVo.buildResendLinkMessage(str, strE, messageVo, 1).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                } else if (i2 == 16) {
                    this.b.h().r(MessageVo.buildRedPacketMessage(str, strE, RedPacketVo.buildFromMessageVo(messageVo), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                } else if (i2 == 22) {
                    this.b.h().r(MessageVo.buildVoucherRedPacketMessage(str, strE, VoucherRedPacketVo.buildFromMessageVo(messageVo), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                } else if (i2 == 17) {
                    this.b.h().r(MessageVo.buildTransferMessage(str, "0", strE, TransferVo.buildFromMessageVo(messageVo), 1, messageVo.time).setSendNetStatus(messageVo.data9).setThreadBizType(this.f12825a.getActivity(), bizType));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(f, 3, new l(), e2);
        }
    }

    public final void B(MessageVo messageVo) throws Throwable {
        String string = this.f12825a.getString(R.string.string_add_expression_fail);
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
                    string = this.f12825a.getString(R.string.string_add_expression_success);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        sy5.f(this.f12825a.getActivity(), string, 0).g();
    }

    public final void C(MessageVo messageVo) {
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment == null || simpleChatFragment.L0() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(AppContext.getContext(), PhotoViewActivity.class);
        intent.putExtra("info_item", this.f12825a.L0());
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
        this.f12825a.startActivity(intent);
    }

    public final void D(String str) {
        new td3.c(this.f12825a.getActivity()).c(new String[]{this.f12825a.getString(R.string.chat_item_menu_create_contact), this.f12825a.getString(R.string.chat_item_menu_edit_contact)}).d(new c(str)).a().b();
    }

    public final void E(String str, int i2, MessageVo messageVo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data1", str);
        contentValues.put("msg_sending_progress", Integer.valueOf(i2));
        this.f12825a.getActivity().getContentResolver().update(DBUriManager.b(ho3.class, this.f12825a.L0()), contentValues, "packet_id=?", new String[]{messageVo.mid});
    }

    @Override // com.zenmen.palmchat.utils.urlspan.MyUrlSpan.a
    public void F(int i2, String str, Uri uri, View view) {
        LogUtil.i(f, "onUrlClicked type =" + i2 + " text =" + str + " uri =" + uri);
        ChatItem chatItemL0 = this.f12825a.L0();
        if (this.c) {
            return;
        }
        if (i2 == 4) {
            new td3.c(this.f12825a.getActivity()).c(new String[]{this.f12825a.getString(R.string.chat_item_menu_dial), this.f12825a.getString(R.string.chat_item_menu_save), this.f12825a.getString(R.string.chat_item_menu_copy)}).d(new e(uri, str.replace("tel:", ""))).a().b();
            return;
        }
        if (i2 != 1) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", mu4.a(uri, zy4.i(view.getTag() instanceof String ? (String) view.getTag() : "", chatItemL0)));
                intent.setFlags(268435456);
                intent.putExtra("com.android.browser.application_id", this.f12825a.getActivity().getPackageName());
                this.f12825a.startActivity(intent);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        String strB = mu4.b(str, new Map[0]);
        Intent intent2 = new Intent();
        intent2.setClass(this.f12825a.getActivity(), CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", strB);
        bundle.putString("web_url_origin", str);
        bundle.putInt("from_source", this.f12825a.I0());
        bundle.putString("extra_key_from_uid", chatItemL0.getChatId());
        bundle.putInt("BackgroundColor", -1);
        int i3 = 601;
        if (chatItemL0.getChatType() != 0 && chatItemL0.getChatType() == 1) {
            i3 = 602;
        }
        bundle.putInt("sourceType", i3);
        intent2.putExtras(bundle);
        this.f12825a.startActivity(intent2);
    }

    public final void G(int i2, MessageVo messageVo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_sending_progress", Integer.valueOf(i2));
        this.f12825a.getActivity().getContentResolver().update(DBUriManager.b(ho3.class, this.f12825a.L0()), contentValues, "packet_id=?", new String[]{messageVo.mid});
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void H(MessageVo messageVo, Object obj) {
        x(messageVo, obj);
    }

    public final void I(int i2, MessageVo messageVo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("attach_status", Integer.valueOf(i2));
        this.f12825a.getActivity().getContentResolver().update(DBUriManager.b(ho3.class, this.f12825a.L0()), contentValues, "packet_id=?", new String[]{messageVo.mid});
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void N(MessageVo messageVo) {
        I(3, messageVo);
        String str = pu1.f20095a;
        String str2 = File.separator;
        String str3 = messageVo.mid;
        dt0.l(AppContext.getContext(), Volley.getUserAgent()).h(messageVo.data2);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void Q(MessageVo messageVo) {
        if (messageVo != null) {
            this.f12825a.X0().g(messageVo.mid);
        }
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void X(ContactInfoItem contactInfoItem) {
        if (this.f12825a == null) {
            return;
        }
        String groupRemarkName = !TextUtils.isEmpty(contactInfoItem.getGroupRemarkName()) ? contactInfoItem.getGroupRemarkName() : contactInfoItem.getNickName();
        if (this.f12825a.L0().getChatType() == 1) {
            groupRemarkName = "@" + groupRemarkName + " ";
            this.f12825a.S0().S1(contactInfoItem.getUid());
        }
        this.f12825a.S0().V1(groupRemarkName);
    }

    @Override // defpackage.w8
    public void a(String str) {
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment == null || simpleChatFragment.S0() == null) {
            return;
        }
        this.f12825a.S0().a(str);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void b0(MessageVo messageVo, boolean z) {
        z(messageVo, z);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void g0(MessageVo messageVo, String str, QuickSendVo quickSendVo) {
        this.f12825a.S0().g0(messageVo, str, quickSendVo);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public boolean i0() {
        return false;
    }

    @Override // defpackage.w8
    public void l() {
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment == null || simpleChatFragment.S0() == null) {
            return;
        }
        this.f12825a.S0().l();
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void m(MessageVo messageVo, Object obj) {
        if (this.f12825a.m1()) {
            return;
        }
        y(messageVo, obj);
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
        I(1, messageVo);
        dt0.l(AppContext.getContext(), Volley.getUserAgent()).e(str, str3, str2, new a(i2, messageVo));
    }

    @Override // defpackage.w8
    public void p() {
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment == null || simpleChatFragment.S0() == null) {
            return;
        }
        this.f12825a.S0().p();
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void q0(ContactInfoItem contactInfoItem) {
        if (this.f12825a.l1()) {
            return;
        }
        this.f12825a.f1(contactInfoItem);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void q1(String str) {
        ve.o(this.f12825a.getActivity(), str, false);
    }

    public final boolean r(ChatItem chatItem, MessageVo messageVo) {
        return messageVo.isSend && messageVo.status == 2;
    }

    public final void s(String str) {
        try {
            ((ClipboardManager) this.f12825a.getActivity().getSystemService(DataType.CLIPBOARD)).setText(str);
            sy5.e(this.f12825a.getActivity(), R.string.copy_success, 0).g();
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void t(MessageVo messageVo, String str) {
        try {
            com.zenmen.palmchat.chat.fragment.c cVar = this.b;
            if (cVar != null && cVar.h() != null && messageVo != null) {
                this.b.h().r(messageVo);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment != null) {
            hp.g(str, simpleChatFragment.L0());
        }
    }

    public final void u(String str) {
        try {
            this.b.h().s(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(f, 3, new d(), e2);
        }
        eb6.e().a(str);
        com.zenmen.palmchat.database.b.i(str, this.f12825a.L0());
    }

    public final void v(MessageVo messageVo) {
        if (!a65.e(this.f12825a.L0())) {
            if (messageVo.mimeType == 10002) {
                this.f12825a.I1();
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.f12825a.getActivity(), SendMessageActivity.class);
            intent.putExtra("message_vo", messageVo);
            this.f12825a.startActivity(intent);
            return;
        }
        int i2 = messageVo.mimeType;
        if (i2 != 1 && i2 != 2) {
            this.f12825a.I1();
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClass(this.f12825a.getActivity(), SendMessageActivity.class);
        intent2.putExtra("message_vo", messageVo);
        this.f12825a.startActivity(intent2);
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void v0(MessageVo messageVo, String str) {
        try {
            com.zenmen.palmchat.chat.fragment.c cVar = this.b;
            if (cVar != null && cVar.h() != null && messageVo != null) {
                this.b.h().r(messageVo);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment != null) {
            ChatBreakHelper.n(str, simpleChatFragment.L0());
        }
    }

    @Override // defpackage.w8
    public void w() {
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment == null || simpleChatFragment.S0() == null) {
            return;
        }
        this.f12825a.y1();
        this.f12825a.S0().w();
    }

    public final void x(MessageVo messageVo, Object obj) {
        String strB;
        Pair<Integer, ContentValues> pairG;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        String strE;
        Pair<Integer, ContentValues> pairG2;
        String str;
        Intent intentE;
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment == null || simpleChatFragment.getActivity() == null) {
            return;
        }
        xa3.d("click", messageVo, obj);
        int i2 = messageVo.mimeType;
        if (i2 == 2) {
            C(messageVo);
            return;
        }
        if (i2 == 14) {
            if (messageVo.data5 == null) {
                Intent intent = new Intent(AppContext.getContext(), (Class<?>) ExpressionDetailActivity.class);
                intent.putExtra("info_item", this.f12825a.L0());
                intent.putExtra("messageVo", messageVo);
                this.f12825a.startActivity(intent);
                return;
            }
            return;
        }
        if (i2 == 3) {
            SimpleChatFragment.u uVarG0 = this.f12825a.G0();
            if (com.zenmen.palmchat.videocall.c.f()) {
                return;
            }
            String str2 = messageVo.data2;
            boolean z = !TextUtils.isEmpty(str2) && new File(str2).exists();
            boolean z2 = messageVo.isSend;
            if ((z2 || messageVo.attachStatus != 2 || !z) && (!z2 || !z)) {
                try {
                    this.b.h().l(messageVo);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    LogUtil.i(f, 3, new f(), e2);
                    return;
                }
            }
            AudioController.p pVar = obj != null ? (AudioController.p) obj : null;
            if (pVar == null) {
                if (messageVo.attachPlaying == 1) {
                    if (this.f12825a.p1()) {
                        this.f12825a.e1().sendEmptyMessage(1002);
                    }
                    if (this.f12825a.n1()) {
                        AudioController.b0().x0(messageVo.mid, AudioController.b0().c0(messageVo.mid));
                    }
                    AudioController.b0().D0();
                    AudioController.b0().L0(messageVo, 0);
                    this.f12825a.getActivity().getWindow().clearFlags(128);
                    return;
                }
                if (this.f12825a.p1()) {
                    this.f12825a.M0().setVisibility(0);
                    this.f12825a.e1().sendEmptyMessageDelayed(1002, 2000L);
                }
                if (AudioController.b0().i0(messageVo.mid) == 0) {
                    AudioController.b0().W();
                }
                AudioController.b0().D0();
                uVarG0.c(messageVo);
                if (AudioController.b0().r0(messageVo, uVarG0, this.b.h())) {
                    this.f12825a.getActivity().getWindow().addFlags(128);
                    return;
                }
                return;
            }
            int i3 = pVar.b;
            if (i3 == AudioController.p.d) {
                AudioController.b0().F0(messageVo);
                return;
            }
            if (i3 == AudioController.p.e) {
                AudioController.b0().x0(messageVo.mid, pVar.c);
                if (this.f12825a.p1()) {
                    this.f12825a.M0().setVisibility(0);
                    this.f12825a.e1().sendEmptyMessageDelayed(1002, 2000L);
                }
                AudioController.b0().M0();
                uVarG0.c(messageVo);
                if (AudioController.b0().r0(messageVo, uVarG0, this.b.h())) {
                    this.f12825a.getActivity().getWindow().addFlags(128);
                    return;
                }
                return;
            }
            if (i3 == AudioController.p.f) {
                AudioController.b0().M0();
                if (this.f12825a.n1()) {
                    AudioController.b0().x0(messageVo.mid, pVar.c);
                }
                if (messageVo.attachPlaying == 1) {
                    if (this.f12825a.p1()) {
                        this.f12825a.e1().sendEmptyMessage(1002);
                    }
                    AudioController.b0().D0();
                    AudioController.b0().L0(messageVo, 0);
                    this.f12825a.getActivity().getWindow().clearFlags(128);
                    return;
                }
                if (this.f12825a.p1()) {
                    this.f12825a.M0().setVisibility(0);
                    this.f12825a.e1().sendEmptyMessageDelayed(1002, 2000L);
                }
                AudioController.b0().D0();
                uVarG0.c(messageVo);
                if (AudioController.b0().r0(messageVo, uVarG0, this.b.h())) {
                    this.f12825a.getActivity().getWindow().addFlags(128);
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 6) {
            FragmentActivity activity = this.f12825a.getActivity();
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
            if (!tg4.b(activity, permissionType.permissionList)) {
                BaseActivityPermissionDispatcher.b(this.f12825a.b1().b(), permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
                return;
            }
            if (!messageVo.isSend) {
                Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) FileDetailActivity.class);
                intent2.putExtra("message_key", messageVo);
                this.f12825a.startActivity(intent2);
                return;
            } else {
                if (messageVo.status != 2) {
                    if (messageVo.sendingProgress < (TextUtils.isEmpty(messageVo.data4) ? 0 : Integer.parseInt(messageVo.data4))) {
                        return;
                    }
                    Intent intent3 = new Intent(AppContext.getContext(), (Class<?>) FileDetailActivity.class);
                    intent3.putExtra("message_key", messageVo);
                    this.f12825a.startActivity(intent3);
                    return;
                }
                if (!TextUtils.isEmpty(messageVo.data1)) {
                    File file = new File(messageVo.data1);
                    if (file.exists()) {
                        messageVo.sendingProgress = (int) file.length();
                    }
                }
                Intent intent4 = new Intent(AppContext.getContext(), (Class<?>) FileDetailActivity.class);
                intent4.putExtra("message_key", messageVo);
                this.f12825a.startActivity(intent4);
                return;
            }
        }
        if (i2 == 7) {
            Intent intent5 = new Intent(AppContext.getContext(), (Class<?>) LocationViewActivity.class);
            intent5.putExtra("location", g53.b(messageVo));
            intent5.putExtra("message_vo", messageVo);
            this.f12825a.startActivity(intent5);
            return;
        }
        if (i2 == 9) {
            ChatItem chatItemFromNameCardString = MessageVo.parseChatItemFromNameCardString(messageVo.extention);
            if (chatItemFromNameCardString != null) {
                if (chatItemFromNameCardString.getChatType() != 1) {
                    Intent intent6 = new Intent(AppContext.getContext(), (Class<?>) m66.c());
                    intent6.putExtra("from", 10);
                    intent6.putExtra("user_item_info", chatItemFromNameCardString);
                    intent6.putExtra("user_detail_name_card_sender_name", (String) obj);
                    this.f12825a.startActivityForResult(intent6, 100);
                    return;
                }
                LogUtil.onEvent(ErrorContants.LOAD_STRATEGY_ERROR, "1", null, null);
                if (chatItemFromNameCardString instanceof GroupInfoItem) {
                    this.f12825a.M(AppContext.getContext().getString(R.string.progress_sending), false);
                    c70.R().F(((GroupInfoItem) chatItemFromNameCardString).getGroupId(), new g(chatItemFromNameCardString, messageVo, obj));
                    return;
                }
                Intent intent7 = new Intent(AppContext.getContext(), (Class<?>) GroupDetailActivity.class);
                intent7.putExtra(com.umeng.analytics.pro.f.K, chatItemFromNameCardString);
                intent7.putExtra("issend", messageVo.isSend);
                intent7.putExtra("user_detail_name_card_sender_name", (String) obj);
                this.f12825a.startActivityForResult(intent7, 100);
                return;
            }
            return;
        }
        if (i2 == 4) {
            if (l50.a()) {
                return;
            }
            LogUtil.onClickEvent("V37", null, null);
            if (messageVo.isSend && messageVo.status == 3) {
                C(messageVo);
                return;
            }
            if ((eb6.e().d(messageVo.data1) && messageVo.attachStatus != 4) || messageVo.attachStatus == 5) {
                C(messageVo);
                return;
            } else {
                eb6.e().b(AppContext.getContext(), messageVo.contactRelate, messageVo.mid, messageVo.data3, messageVo.data4, messageVo.data5);
                C(messageVo);
                return;
            }
        }
        if (i2 != 28) {
            if (i2 == 10005) {
                CircleGuide circleGuide = TextUtils.isEmpty(messageVo.extention) ? null : (CircleGuide) az2.a(messageVo.extention, CircleGuide.class);
                if (circleGuide == null || circleGuide.a() == null || (strB = circleGuide.a().b()) == null || (pairG = mb4.g(strB)) == null) {
                    return;
                }
                int iIntValue = ((Integer) pairG.first).intValue();
                ContentValues contentValues = (ContentValues) pairG.second;
                contentValues.put("extra_key_from_uid", messageVo.contactRelate);
                this.f12825a.r1(iIntValue, contentValues, null, strB, null, false, messageVo, messageVo.isSend);
                return;
            }
            if (i2 == 30) {
                if (!messageVo.isRead) {
                    AudioController.b0().z0(messageVo);
                }
                fg6.b("click", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 2);
                if (!fg6.d(AppContext.getContext())) {
                    ap3.z(AppContext.getContext(), BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP, "1", "scene_voice_video_call");
                    return;
                }
                if (com.zenmen.palmchat.videocall.c.g(this.f12825a.getActivity(), this.f12825a.L0().getChatId())) {
                    return;
                }
                if (!com.zenmen.palmchat.videocall.c.e()) {
                    sy5.e(this.f12825a.getActivity(), R.string.service_not_available, 0).g();
                    return;
                } else {
                    if (TextUtils.isEmpty(messageVo.data2)) {
                        return;
                    }
                    com.zenmen.palmchat.videocall.c.b(this.f12825a.getActivity(), Integer.valueOf(messageVo.data2).intValue(), new h(messageVo));
                    return;
                }
            }
            if (i2 == 16) {
                return;
            }
            if (i2 == 17) {
                this.f12825a.g1(messageVo);
                return;
            }
            if (i2 == 22) {
                this.b.i(messageVo);
                return;
            }
            if (i2 == 24 || i2 == 56 || i2 != 52) {
                return;
            }
            DragonItem dragonItemBuildFromMessageVo = DragonItem.buildFromMessageVo(messageVo);
            if (dragonItemBuildFromMessageVo == null) {
                try {
                    lg1.c().i(messageVo.isSend ? DomainHelper.j(messageVo.to) : DomainHelper.j(messageVo.from), new JSONObject(messageVo.extention).optJSONObject("jieLong").optLong("jlId"), new i(messageVo));
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            Intent intent8 = new Intent();
            String strP = AccountUtils.p(AppContext.getContext());
            intent8.setClass(this.f12825a.getActivity(), DragonJoinActivity.class);
            intent8.putExtra(j70.b, strP);
            intent8.putExtra(j70.e, dragonItemBuildFromMessageVo);
            this.f12825a.startActivity(intent8);
            return;
        }
        Integer num = (Integer) obj;
        RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
        if (richMsgExVoH == null || num == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= num.intValue() || (richMsgExItemVo = richMsgExVoH.items.get(num.intValue())) == null) {
            return;
        }
        if (a65.e(this.f12825a.L0())) {
            strE = q03.e(messageVo.data1);
            q03.b(strE);
        } else {
            strE = richMsgExItemVo.openLink;
            q03.a(richMsgExItemVo.showType, messageVo.data4);
        }
        if (!TextUtils.isEmpty(strE) && (intentE = bu3.g().e(this.f12825a.getActivity(), strE)) != null) {
            this.f12825a.startActivity(intentE);
            return;
        }
        String str3 = richMsgExItemVo.url;
        if (str3 == null || (pairG2 = mb4.g(str3)) == null) {
            return;
        }
        if (b65.a().b(messageVo.contactRelate)) {
            b65.c();
            str = str3;
        } else {
            int iIntValue2 = ((Integer) pairG2.first).intValue();
            ContentValues contentValues2 = (ContentValues) pairG2.second;
            contentValues2.put("extra_key_from_uid", messageVo.contactRelate);
            str = str3;
            this.f12825a.r1(iIntValue2, contentValues2, null, str3, richMsgExItemVo, richMsgExVoH.forwardable == 0, messageVo, messageVo.isSend);
        }
        if ("88888000".equals(messageVo.contactRelate)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H1", null, null, jSONObject.toString());
        }
        if ("88888888".equals(messageVo.contactRelate)) {
            String queryParameter = Uri.parse(str).getQueryParameter("type");
            if ("redBubble1".equals(queryParameter)) {
                LogUtil.uploadInfoImmediate("hbd07", null, null, null);
            }
            if ("redBubble2".equals(queryParameter)) {
                LogUtil.uploadInfoImmediate("hbd08", null, null, null);
            }
            if ("redBubble3".equals(queryParameter)) {
                LogUtil.uploadInfoImmediate("hbd09", null, null, null);
            }
            if (richMsgExItemVo.activityId == 1) {
                LogUtil.uploadInfoImmediate("AM401", null, null, null);
            }
        }
        if (a65.f(messageVo.contactRelate)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(DeviceInfoUtil.UID_TAG, messageVo.contactRelate);
                jSONObject2.put("mid", messageVo.mid);
                jSONObject2.put("showType", richMsgExItemVo.showType);
                jSONObject2.put("isAds5", com.zenmen.palmchat.chat.g.r(richMsgExItemVo));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H11", null, null, jSONObject2.toString());
        }
        if ("88888003".equals(messageVo.contactRelate)) {
            return;
        }
        int i4 = richMsgExItemVo.showType;
        if (i4 == 8 || i4 == 9) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("mid", messageVo.mid);
                jSONObject3.put("showType", richMsgExItemVo.showType);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("M17", null, jSONObject3.toString());
        }
    }

    public final void y(MessageVo messageVo, Object obj) {
        if (this.f12825a == null) {
            return;
        }
        this.c = true;
        this.e = messageVo;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean zR = r(this.f12825a.L0(), messageVo);
        boolean z = messageVo.attachStatus == 5;
        int i2 = messageVo.mimeType;
        if (i2 == 1) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.COPY);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 2) {
            if (!z) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
                if (MomentsConfig.j() && rl0.h().i().f()) {
                    linkedHashSet.add(ChatterActivity.LongClickMenuItem.MOMENTS);
                }
            }
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 3) {
            linkedHashSet.add(this.f12825a.p1() ? ChatterActivity.LongClickMenuItem.SPEAKERMODE1 : ChatterActivity.LongClickMenuItem.SPEAKERMODE2);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 6) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 7) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 14) {
            if (ot1.c(messageVo.data4)) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION);
            }
            if (!z) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            }
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 9) {
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 28) {
            RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(messageVo);
            if (richMsgExVoH != null && richMsgExVoH.forwardable == 0) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            }
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 10005 || i2 == 53) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 4) {
            if (!z) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            }
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 10002) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.COPY);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        } else if (i2 == 30 || i2 == 16) {
            if (i2 == 30) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.BUBBLE);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
        } else if (i2 == 22 || i2 == 30 || i2 == 17 || i2 == 24) {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
        } else {
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.COPY);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.FORWARD);
            if (zR) {
                linkedHashSet.add(ChatterActivity.LongClickMenuItem.RECALL);
            }
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.DELETE);
            linkedHashSet.add(ChatterActivity.LongClickMenuItem.MORE);
        }
        if (fu5.t(this.f12825a.a1())) {
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.MORE);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.MOMENTS);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.SPEAKERMODE1);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.SPEAKERMODE2);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.REPORT);
            linkedHashSet.remove(ChatterActivity.LongClickMenuItem.KICKOUT);
        }
        ArrayList arrayList = new ArrayList();
        HashMap<ChatterActivity.LongClickMenuItem, String> mapV0 = this.f12825a.V0();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(mapV0.get((ChatterActivity.LongClickMenuItem) it.next()));
        }
        td3 td3VarA = new td3.c(this.f12825a.getActivity()).c((String[]) arrayList.toArray(new String[arrayList.size()])).d(new k(mapV0, messageVo, obj)).b(new j()).a();
        this.d = td3VarA;
        td3VarA.b();
    }

    public final void z(MessageVo messageVo, boolean z) {
        SimpleChatFragment simpleChatFragment = this.f12825a;
        if (simpleChatFragment == null) {
            return;
        }
        if (z) {
            new sd3(simpleChatFragment.getActivity()).j(R.string.confirm_resend_message).O(R.string.confirm_resend_message_retry).K(R.string.dialog_cancel).f(new C0991b(messageVo)).e().show();
        } else {
            A(messageVo);
        }
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void D0(String str) {
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void S(MessageVo messageVo) {
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void o1(MessageVo messageVo) {
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void f0() {
    }

    @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
    public void J0(ChatterAdapter.OtherViewType otherViewType, MessageVo messageVo) {
    }
}
