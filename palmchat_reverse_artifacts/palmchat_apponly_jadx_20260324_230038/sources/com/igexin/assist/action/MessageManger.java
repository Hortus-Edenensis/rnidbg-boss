package com.igexin.assist.action;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.igexin.assist.MessageBean;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.core.d;
import com.igexin.push.core.e;
import com.igexin.push.core.e.d;
import com.igexin.push.core.e.f;
import com.igexin.push.core.l;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import com.igexin.sdk.message.GTTransmitMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MessageManger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6998a = "Assist_MessageManger";
    private String b;

    /* JADX INFO: renamed from: com.igexin.assist.action.MessageManger$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6999a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Context c;

        public AnonymousClass1(String str, boolean z, Context context) {
            this.f6999a = str;
            this.b = z;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (e.m.get()) {
                com.igexin.c.a.c.a.b(MessageManger.f6998a, "delay 1s save token = " + this.f6999a);
                MessageManger.b(this.f6999a, this.b);
                return;
            }
            Context context = this.c;
            if (context == null) {
                com.igexin.c.a.c.a.b(MessageManger.f6998a, " save token in SP ,but context is null " + this.f6999a);
                return;
            }
            d dVarA = d.a(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("token", this.f6999a);
                jSONObject.put("isForce", this.b);
            } catch (JSONException e) {
                com.igexin.c.a.c.a.a(e);
            }
            dVarA.a(jSONObject);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MessageBean f7000a;

        public a(MessageBean messageBean) {
            this.f7000a = messageBean;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            byte b;
            try {
                MessageBean messageBean = this.f7000a;
                if (messageBean != null) {
                    GtcProvider.setContext(messageBean.getContext());
                    String messageType = this.f7000a.getMessageType();
                    int iHashCode = messageType.hashCode();
                    if (iHashCode != -1161803523) {
                        if (iHashCode != -786701938) {
                            b = (iHashCode == 110541305 && messageType.equals("token")) ? (byte) 0 : (byte) -1;
                        } else if (messageType.equals(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
                            b = 1;
                        }
                    } else if (messageType.equals(AssistPushConsts.MSG_TYPE_ACTIONS)) {
                        b = 2;
                    }
                    if (b == 0) {
                        MessageManger.a(MessageManger.this, this.f7000a.getContext(), this.f7000a.getStringMessage(), this.f7000a.extra.getBoolean("isForce"));
                        return;
                    }
                    if (b == 1) {
                        if (TextUtils.isEmpty(this.f7000a.getStringMessage())) {
                            return;
                        }
                        com.igexin.assist.action.a aVar = new com.igexin.assist.action.a();
                        aVar.a(this.f7000a);
                        if (aVar.a(false) && aVar.e.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                            MessageManger.a(MessageManger.this, aVar, this.f7000a.getContext());
                            return;
                        }
                        return;
                    }
                    if (b == 2 && !TextUtils.isEmpty(this.f7000a.getStringMessage())) {
                        com.igexin.assist.action.a aVar2 = new com.igexin.assist.action.a();
                        aVar2.a(this.f7000a);
                        if (aVar2.a(true) && aVar2.e.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                            MessageManger.a(this.f7000a.getContext(), aVar2);
                        }
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final MessageManger f7001a = new MessageManger(0);

        private b() {
        }
    }

    private MessageManger() {
    }

    public /* synthetic */ MessageManger(byte b2) {
        this();
    }

    private static PushTaskBean a(com.igexin.assist.action.a aVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(aVar.d);
        pushTaskBean.setMessageId(aVar.c);
        pushTaskBean.setTaskId(aVar.b);
        pushTaskBean.setId(String.valueOf(jCurrentTimeMillis));
        pushTaskBean.setCurrentActionid(1);
        return pushTaskBean;
    }

    private static void b(Context context, com.igexin.assist.action.a aVar) {
        if (!e.m.get()) {
            AssistUtils.startGetuiService(context);
        }
        if (aVar == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = com.igexin.push.core.b.U;
        messageObtain.obj = aVar.f;
        Bundle bundle = new Bundle();
        bundle.putString("content", aVar.f);
        byte[] bArr = aVar.f7002a;
        if (bArr != null) {
            bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, bArr);
        }
        messageObtain.setData(bundle);
        d.a.f7200a.a(messageObtain);
    }

    public static MessageManger getInstance() {
        return b.f7001a;
    }

    public void addMessage(MessageBean messageBean) {
        com.igexin.b.a.a().f7007a.execute(new a(messageBean));
    }

    public void feedbackPushMessage(Context context, com.igexin.assist.action.a aVar, String str) {
        try {
            if (e.m.get()) {
                FeedbackImpl feedbackImpl = FeedbackImpl.getInstance();
                long jCurrentTimeMillis = System.currentTimeMillis();
                PushTaskBean pushTaskBean = new PushTaskBean();
                pushTaskBean.setAppid(aVar.d);
                pushTaskBean.setMessageId(aVar.c);
                pushTaskBean.setTaskId(aVar.b);
                pushTaskBean.setId(String.valueOf(jCurrentTimeMillis));
                pushTaskBean.setCurrentActionid(1);
                feedbackImpl.feedbackMultiBrandMessageAction(pushTaskBean, str);
                return;
            }
            com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(context);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(jCurrentTimeMillis2));
            jSONObject.put("messageid", aVar.c);
            jSONObject.put("taskid", aVar.b);
            jSONObject.put("multaid", str);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
            dVarA.a(aVar.b, jSONObject);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public String getBrandCode() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        AbstractPushManager abstractPushManager = com.igexin.assist.sdk.a.a().b;
        String brandCode = abstractPushManager == null ? "" : abstractPushManager.getBrandCode();
        this.b = brandCode;
        return brandCode;
    }

    public static /* synthetic */ void a(Context context, com.igexin.assist.action.a aVar) {
        if (!e.m.get()) {
            AssistUtils.startGetuiService(context);
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = com.igexin.push.core.b.U;
        messageObtain.obj = aVar.f;
        Bundle bundle = new Bundle();
        bundle.putString("content", aVar.f);
        byte[] bArr = aVar.f7002a;
        if (bArr != null) {
            bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, bArr);
        }
        messageObtain.setData(bundle);
        d.a.f7200a.a(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, boolean z) {
        a(str);
        if (!z) {
            try {
                if (str.equals(e.I)) {
                    return;
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return;
            }
        }
        f.a().b(str);
        if (e.u) {
            com.igexin.c.a.c.a.b(f6998a, "online, send addphoneinfo");
            com.igexin.push.core.a.b.d().i();
        } else if (z) {
            f.a().c("");
        }
    }

    private void a(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(f6998a, "other token = ".concat(String.valueOf(str)));
        if (e.m.get()) {
            b(str, z);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(str, z, context), 1000L);
        }
    }

    public static /* synthetic */ void a(MessageManger messageManger, Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(f6998a, "other token = ".concat(String.valueOf(str)));
        if (e.m.get()) {
            b(str, z);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(messageManger.new AnonymousClass1(str, z, context), 1000L);
        }
    }

    public static /* synthetic */ void a(MessageManger messageManger, com.igexin.assist.action.a aVar, Context context) {
        if (context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(context);
            if (dVarA.a(aVar.b)) {
                messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "1");
                return;
            }
            dVarA.b(aVar.b);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(aVar.b, aVar.c, aVar.c + ":" + aVar.b, aVar.f7002a));
            l.a(context);
            l.a().a(bundle);
            messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "0");
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(com.igexin.assist.action.a aVar, Context context) {
        if (aVar == null || context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(context);
            if (dVarA.a(aVar.b)) {
                feedbackPushMessage(context, aVar, getBrandCode() + "1");
                return;
            }
            dVarA.b(aVar.b);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(aVar.b, aVar.c, aVar.c + ":" + aVar.b, aVar.f7002a));
            l.a(context);
            l.a().a(bundle);
            feedbackPushMessage(context, aVar, getBrandCode() + "0");
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(String str) {
        try {
            l.a().a(str);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
