package defpackage;

import android.text.TextUtils;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.ServerException;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class va1 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatItem f21390a;

    public va1(ChatItem chatItem) {
        this.f21390a = chatItem;
    }

    public void n() throws DaoException, ServerException {
        String str = vm0.e;
        try {
            String chatId = this.f21390a.getChatId();
            String strZ = k86.Z(str);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fuid", chatId);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            if (((JSONObject) requestFutureNewFuture.get(encryptedJsonRequest)).getInt("resultCode") != 0) {
                throw new ServerException(ServerException.NETWORK_REQUEST_ERROR_MESSAGE);
            }
            String[] strArr = {chatId};
            if (!TextUtils.isEmpty(chatId)) {
                b.k(this.f21390a);
                nw5.d(chatId);
                ie2.c(chatId, "");
                rn0.c(chatId);
            }
            AppContext.getContext().getContentResolver().delete(ho0.f18003a, "uid=?", strArr);
            iq5.j(true, new String[0]);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        } catch (InterruptedException unused2) {
            throw new ServerException(ServerException.NETWORK_REQUEST_ERROR_MESSAGE);
        } catch (ExecutionException unused3) {
            throw new ServerException(ServerException.NETWORK_REQUEST_ERROR_MESSAGE);
        } catch (TimeoutException unused4) {
            throw new ServerException(ServerException.NETWORK_REQUEST_TIMEOUT_MESSAGE);
        } catch (JSONException unused5) {
            throw new DaoException(DaoException.JSON_RESPONSE_PARSE_ERROR);
        }
    }
}
