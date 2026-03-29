package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmd;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmdExt;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.rtc.bean.RoomInfo;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k50 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f18574a;
    public Response.ErrorListener b;
    public ChatItem c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18575a;
        public final /* synthetic */ VoiceCmd b;

        public a(String str, VoiceCmd voiceCmd) {
            this.f18575a = str;
            this.b = voiceCmd;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject;
            if (jSONObject == null || jSONObject.optInt("resultCode", -1) != 0 || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null || jSONObjectOptJSONObject.optInt("status", -1) != 4) {
                return;
            }
            k50.this.q(this.f18575a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements rx<LXBaseNetBean<RoomInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18577a;
        public final /* synthetic */ VoiceCmd b;

        public c(String str, VoiceCmd voiceCmd) {
            this.f18577a = str;
            this.b = voiceCmd;
        }

        @Override // defpackage.rx
        public void onResult(boolean z, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean != null && lXBaseNetBean.resultCode == 2011) {
                k50.this.q(this.f18577a, this.b);
            }
        }
    }

    public k50(ChatItem chatItem) {
        this.c = chatItem;
    }

    public void o(String str, VoiceCmd voiceCmd) {
        int i = voiceCmd.type;
        if (i == 0) {
            p(str, voiceCmd);
        } else if (i == 1) {
            ww.c(voiceCmd.groupId, "muc.youni", 0, new c(str, voiceCmd));
        }
    }

    public final void p(String str, VoiceCmd voiceCmd) {
        this.f18574a = new a(str, voiceCmd);
        this.b = new b();
        try {
            String strZ = k86.Z(nl0.c + "/one/ax/rtc.groupmsg.checkroom.v1");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("groupId", voiceCmd.groupId);
            jSONObject.put("roomId", voiceCmd.roomId);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f18574a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void q(String str, VoiceCmd voiceCmd) {
        voiceCmd.msgType = 1;
        VoiceCmdExt voiceCmdExt = new VoiceCmdExt();
        voiceCmdExt.voiceCmd = voiceCmd;
        String strC = az2.c(voiceCmdExt);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_extend", strC);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, DBUriManager.b(ho3.class, this.c), contentValues, "packet_id=?", new String[]{str});
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
