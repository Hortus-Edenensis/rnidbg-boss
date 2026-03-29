package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.tag.bean.SquareTagBean;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class fw3 extends yt1 {
    public ContactInfoItem B;
    public SquareTagBean C;
    public int E;

    public fw3(String str, SquareTagBean squareTagBean, ContactInfoItem contactInfoItem, int i, int i2) {
        super(str, i);
        this.C = squareTagBean;
        this.B = contactInfoItem;
        this.E = i2;
    }

    public final JSONObject T(boolean z) {
        HashMap map = new HashMap();
        map.put("tagId", Integer.valueOf(this.C.getId()));
        if (!TextUtils.isEmpty(this.B.getExid())) {
            map.put("feedExid", this.B.getExid());
        }
        if (!TextUtils.isEmpty(this.B.getUid())) {
            map.put("feedUid", this.B.getUid());
        }
        int i = this.E;
        if (i != 0) {
            map.put("scene", Integer.valueOf(i));
        }
        map.put("version", Long.valueOf(G()));
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            map.put("longitude", locationExI.getLongitude() + "");
            map.put("latitude", locationExI.getLatitude() + "");
        }
        return new JSONObject(map);
    }

    @Override // defpackage.om2
    public JSONObject a() {
        return T(false);
    }

    @Override // defpackage.om2
    public JSONObject b() {
        return T(true);
    }

    @Override // defpackage.br
    public boolean t() {
        return false;
    }
}
