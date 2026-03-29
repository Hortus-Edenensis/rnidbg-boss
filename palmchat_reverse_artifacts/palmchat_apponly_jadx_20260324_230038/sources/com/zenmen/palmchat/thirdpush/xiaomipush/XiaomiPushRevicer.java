package com.zenmen.palmchat.thirdpush.xiaomipush;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b63;
import defpackage.hx3;
import defpackage.nl0;
import defpackage.vp3;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class XiaomiPushRevicer extends PushMessageReceiver {
    private static final String TAG = "XiaomiPushRevicer";
    private String mAlias;
    private String mCommand;
    private String mEndTime;
    private String mMessage;
    private String mReason;
    private String mRegId;
    private long mResultCode = -1;
    private String mStartTime;
    private String mTopic;
    private String mUserAccount;

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String str;
        String command = miPushCommandMessage.getCommand();
        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
        String str2 = null;
        String str3 = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            str2 = commandArguments.get(1);
        }
        if ("register".equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mRegId = str3;
            }
        } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mAlias = str3;
            }
        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mAlias = str3;
            }
        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mTopic = str3;
            }
        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mTopic = str3;
            }
        } else if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command) && miPushCommandMessage.getResultCode() == 0) {
            this.mStartTime = str3;
            this.mEndTime = str2;
        }
        String str4 = "mRegId = " + this.mRegId + " ;mTopic=" + this.mTopic + " ;mAlias = " + this.mAlias;
        LogUtil.d(TAG, "onCommandResult: + " + str4);
        if (nl0.g() && PushTokenManager.h() && vp3.e() && hx3.m(context) && (str = this.mRegId) != null) {
            PushTokenManager.l(str, PushTokenManager.PushType.XIAOMI);
        }
        if ("register".equals(command) && b63.a().b().c()) {
            JSONObject jSONObject = new JSONObject();
            if (miPushCommandMessage.getResultCode() == 0) {
                try {
                    jSONObject.put("isTokenGet", true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put("isTokenGet", false);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push03", null, null, jSONObject.toString());
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        this.mMessage = miPushMessage.getContent();
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        } else if (!TextUtils.isEmpty(miPushMessage.getUserAccount())) {
            this.mUserAccount = miPushMessage.getUserAccount();
        }
        LogUtil.d(TAG, "onNotificationMessageArrived is called. " + miPushMessage.toString());
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        this.mMessage = miPushMessage.getContent();
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        } else if (!TextUtils.isEmpty(miPushMessage.getUserAccount())) {
            this.mUserAccount = miPushMessage.getUserAccount();
        }
        LogUtil.d(TAG, "onNotificationMessageClicked is called. " + miPushMessage.toString());
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        this.mMessage = miPushMessage.getContent();
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        } else if (!TextUtils.isEmpty(miPushMessage.getUserAccount())) {
            this.mUserAccount = miPushMessage.getUserAccount();
        }
        String str = "message = " + this.mMessage + " ;mTopic=" + this.mTopic + " ;mAlias = " + this.mAlias + " ;mUserAccount = " + this.mUserAccount;
        LogUtil.d(TAG, "onReceivePassThroughMessage: + " + str);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String command = miPushCommandMessage.getCommand();
        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            commandArguments.get(1);
        }
        if ("register".equals(command) && miPushCommandMessage.getResultCode() == 0) {
            this.mRegId = str;
        }
        LogUtil.d(TAG, "onReceiveRegisterResult, mRegId = " + this.mRegId);
    }
}
