package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wb4 extends ut1 {
    public wb4(int i, String str, Bundle bundle) {
        super(i, str, bundle);
    }

    @Override // defpackage.ut1, defpackage.om2
    public JSONObject a() {
        JSONObject jSONObjectA = super.a();
        SquareFeed squareFeedZ = z();
        try {
            if (squareFeedZ != null) {
                jSONObjectA.put("topicId", squareFeedZ.topicId);
                jSONObjectA.put("version", squareFeedZ.version);
            } else {
                jSONObjectA.put("version", 0);
            }
            int i = this.h;
            if (i == 7) {
                jSONObjectA.put("type", "topic");
            } else if (i == 16) {
                jSONObjectA.put("type", FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);
                jSONObjectA.put("feedUid", this.j.get("key_feed_uid"));
            } else if (i == 5) {
                jSONObjectA.put("tagId", squareFeedZ.tagId);
                jSONObjectA.put("feedUid", squareFeedZ.uid);
                jSONObjectA.put("feedExid", squareFeedZ.exid);
                jSONObjectA.put("version", squareFeedZ.version);
            }
            jSONObjectA.put("page", this.d);
            jSONObjectA.put("reqId", this.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObjectA;
    }

    @Override // defpackage.tb4
    public String l() {
        return TextUtils.equals(this.i, "square.friend.feed.scroll.list.v8") ? "暂无更多好友动态" : super.l();
    }
}
