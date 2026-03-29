package com.zenmen.palmchat.opensdk.share;

import android.app.Activity;
import android.content.Intent;
import com.zenmen.openapi.share.OpenDataBean;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.publish.PublishActivity;
import defpackage.d13;
import defpackage.i84;
import defpackage.j84;
import defpackage.k84;
import defpackage.q03;
import defpackage.s84;
import defpackage.v84;
import defpackage.z03;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXShare {
    private String mAppId;
    private Activity mContext;

    public LXShare(Activity activity, String str) {
        this.mContext = activity;
        this.mAppId = str;
    }

    private Intent addInfo2Intent(Intent intent, int i) {
        intent.putExtra("extra_open_info", getOpenInfo(i));
        return intent;
    }

    private MessageVo addInfo2MessageVo(MessageVo messageVo, int i) {
        messageVo.data4 = getOpenInfo(i);
        return messageVo;
    }

    private String getOpenInfo(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("openType", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void sendMessage(OpenDataBean openDataBean) {
        Intent intent = new Intent(this.mContext, (Class<?>) SendMessageActivity.class);
        intent.putExtra("extra_share_mode", 0);
        int showType = openDataBean.getShowType();
        if (showType == 1) {
            Intent intentF = j84.f(intent, openDataBean.getText());
            intentF.putExtra("extra_open_info", getOpenInfo(1, openDataBean.getText()));
            this.mContext.startActivity(intentF);
            return;
        }
        if (showType == 2) {
            Intent intentA = j84.a(this.mContext, intent, openDataBean.getImages());
            intentA.putExtra("extra_open_info", getOpenInfo(2, openDataBean.getImages()));
            this.mContext.startActivity(intentA);
            return;
        }
        if (showType == 4) {
            MessageVo messageVoG = j84.g(openDataBean.getWeb());
            messageVoG.data4 = getOpenInfo(4);
            this.mContext.startActivity(j84.b(intent, messageVoG));
            return;
        }
        if (showType == 6) {
            MessageVo messageVoE = j84.e(openDataBean.getVideo());
            messageVoE.data4 = getOpenInfo(6);
            this.mContext.startActivity(j84.b(intent, messageVoE));
        } else if (showType == 7) {
            MessageVo messageVoC = j84.c(openDataBean.getNameCard());
            messageVoC.data4 = getOpenInfo(7);
            this.mContext.startActivity(j84.b(intent, messageVoC));
        } else {
            if (showType != 8) {
                return;
            }
            MessageVo messageVoD = j84.d(openDataBean.getApp());
            messageVoD.data4 = getOpenInfo(8);
            this.mContext.startActivity(j84.b(intent, messageVoD));
        }
    }

    public void shareMessage(OpenDataBean openDataBean) {
        Intent intent = new Intent(this.mContext, (Class<?>) PublishActivity.class);
        intent.putExtra("sdk_share_appid", this.mAppId);
        int showType = openDataBean.getShowType();
        if (showType == 1) {
            this.mContext.startActivity(k84.d(intent, openDataBean.getText()));
            return;
        }
        if (showType == 2) {
            this.mContext.startActivity(k84.a(intent, openDataBean.getImages()));
            return;
        }
        if (showType == 4) {
            this.mContext.startActivity(k84.f(intent, openDataBean.getWeb()));
            return;
        }
        if (showType == 6) {
            v84 video = openDataBean.getVideo();
            Intent intentC = k84.c(intent, video);
            if (video instanceof d13) {
                intentC = q03.d(intentC, (d13) video);
            }
            this.mContext.startActivity(intentC);
            return;
        }
        if (showType != 7) {
            if (showType != 8) {
                return;
            }
            this.mContext.startActivity(k84.e(intent, openDataBean.getApp()));
            return;
        }
        s84 nameCard = openDataBean.getNameCard();
        Intent intentB = k84.b(intent, nameCard);
        if (nameCard instanceof z03) {
            intentB = q03.c(intentB, (z03) nameCard);
        }
        this.mContext.startActivity(intentB);
    }

    public String getOpenInfo(int i, i84... i84VarArr) {
        try {
            JSONObject jSONObject = new JSONObject(getOpenInfo(i));
            if (i84VarArr != null && i84VarArr.length > 0) {
                jSONObject.put("sourceName", i84VarArr[0].c());
                jSONObject.put("sourceIcon", i84VarArr[0].b());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
