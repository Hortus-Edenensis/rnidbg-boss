package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r30 {
    public ChatItem b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<String> f20383a = new HashSet();
    public boolean c = true;
    public Set<String> d = new HashSet();

    public r30(ChatItem chatItem) {
        this.b = chatItem;
    }

    public final void a() {
        if (this.d.size() > 0) {
            d(this.d);
            this.f20383a.addAll(this.d);
            this.d.clear();
        }
    }

    public void b() {
        if (f() && this.c) {
            this.c = false;
            a();
        }
    }

    public void c() {
        if (f()) {
            a();
        }
    }

    public final void d(Set<String> set) {
        if (set.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fromId", this.b.getChatId());
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("mids", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("fwh001", null, null, jSONObject.toString());
        }
    }

    public void e(ArrayList<MessageVo> arrayList) {
        if (f()) {
            this.c = true;
        }
    }

    public final boolean f() {
        return a65.e(this.b);
    }

    public void g(String str) {
        if (!f() || this.f20383a.contains(str) || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.add(str);
    }
}
