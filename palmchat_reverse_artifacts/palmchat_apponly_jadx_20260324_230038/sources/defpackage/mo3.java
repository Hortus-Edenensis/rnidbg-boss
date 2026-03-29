package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ChatPay;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.pay.PayChatEvent;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class mo3 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19280a = bs3.a();
    public static final String b = k86.i("ACTION_MESSAGE_NOTIFY_CONNECTION_FAIL");
    public static final String c = k86.i("ACTION_NOTIFY_SEND_FAIL");
    public static final String d = k86.i("ACTION_NOTIFY_RECIEVE_MESSAGE");
    public static final String e = k86.i("ACTION_NOTIFY_RECIEVE_GROUP_VIDEO_PUSH");
    public static final String f = k86.i("ACTION_NOTIFY_RECIEVE_FRIEND_REQUEST");
    public static final String g = k86.i("ACTION_NOTIFY_RECIEVE_INPUT_STATUS_MSG");
    public static final String h = k86.i("ACTION_NOTIFY_RECIEVE_LBS_CONFIG_CHANGE");
    public static final String i = k86.i("ACTION_NOTIFY_RECIEVE_DYNAMIC_CONFIG_CHANGE");
    public static final String j = k86.i("ACTION_NOTIFY_RECIEVE_ALERT_CHANGE");
    public static final String k = k86.i("ACTION_NOTIFY_RECIEVE_TOKEN");
    public static final String l = k86.i("ACTION_NOTIFY_RECIEVE_AD");
    public static final String m = k86.i("ACTION_NOTIFY_RECIEVE_MOMENTS_AD");
    public static final String n = k86.i("ACTION_NOTIFY_MAINTAB_CONTACTREQUEST_CHANGE");
    public static final String o = k86.i("ACTION_NOTIFY_MOVE_FRONT");
    public static final String p = k86.i("ACTION_NOTIFY_MOVE_BACK");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action.equals(f19280a)) {
                ch.s().A0(true, false);
                return;
            }
            if (action.equals(EncryptedJsonRequest.JSON_PARSE_ERROR)) {
                if (hx3.n()) {
                    ch.s().A0(true, true);
                    return;
                }
                return;
            }
            if (action.equals(c)) {
                MessageVo messageVo = (MessageVo) intent.getParcelableExtra("key_messagevo");
                if (messageVo != null) {
                    ChatPay chatPayInfo = messageVo.getChatPayInfo();
                    if (chatPayInfo == null || !chatPayInfo.isPayFailedWithoutMoney()) {
                        a.E().t0(messageVo);
                        return;
                    } else {
                        ds0.a().b(new PayChatEvent(messageVo));
                        return;
                    }
                }
                return;
            }
            if (action.equals(d)) {
                String stringExtra = intent.getStringExtra("key_packet_extension");
                String stringExtra2 = intent.getStringExtra("key_mid");
                int intExtra = intent.getIntExtra("key_mimetype", 0);
                int intExtra2 = intent.getIntExtra("key_subtype", 0);
                a.E().n0(intent.getStringExtra("key_from"), stringExtra2, stringExtra, intExtra, intExtra2, intent.getStringExtra("key_body"), intent.getBooleanExtra("key_from_sync", false));
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_message_recall_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    return;
                }
                ch.s().T(stringArrayListExtra);
                return;
            }
            if (action.equals(e)) {
                wa6.j(intent.getStringExtra("extContent"));
                return;
            }
            if (action.equals(g)) {
                String stringExtra3 = intent.getStringExtra("from");
                int intExtra3 = intent.getIntExtra(SharePluginInfo.ISSUE_SUB_TYPE, 0);
                if (TextUtils.isEmpty(stringExtra3)) {
                    return;
                }
                ch.s().S(stringExtra3, intExtra3);
                return;
            }
            if (action.equals(f)) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) intent.getParcelableExtra("key_contact_item");
                String stringExtra4 = intent.getStringExtra("key_rid");
                String stringExtra5 = intent.getStringExtra("key_contact_request_extension");
                a.E().k0(intent.getStringExtra("key_mid"), stringExtra4, stringExtra5, contactInfoItem, intent.getBooleanExtra("key_from_sync", false));
                return;
            }
            if (action.equals(b)) {
                if (AppContext.getContext().isBackground()) {
                    return;
                }
                try {
                    sy5.e(context, R.string.net_unavailable_toast, 1).g();
                    return;
                } catch (Exception e2) {
                    LogUtil.e("MessagingService", e2.toString());
                    return;
                }
            }
            if (action.equals(h)) {
                ch.s().x0();
                return;
            }
            if (action.equals(i)) {
                ch.s().w0((HashMap) intent.getSerializableExtra("key_dynamic_pre_status"));
                return;
            }
            if (action.equals(j)) {
                ch.s().s0();
                return;
            }
            if (action.equals(tq3.i) || action.equals(tq3.j)) {
                if (sq3.D()) {
                    ch.s().E0(action, intent.getBooleanExtra("clearPostRead", false));
                    return;
                }
                return;
            }
            if (action.equals(tq3.k)) {
                ch.s().C0();
                return;
            }
            if (action.equals(k)) {
                LogUtil.i("ACTION_NOTIFY_RECIEVE_TOKEN", "onReceive, sendbroadcast token receive");
                ch.s().e0();
                return;
            }
            if (action.equals(FrameworkBaseActivity.ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED)) {
                ch.s().b0(intent.getStringExtra("pageIndex"));
            } else if (action.equals(n)) {
                ch.s().P();
            } else if (action.equals(l)) {
                ch.s().c0();
            } else if (action.equals(m)) {
                ch.s().d0();
            }
        }
    }
}
