package defpackage;

import android.content.ContentValues;
import android.os.Bundle;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class v66 {
    public static int b;
    public static v66 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jr f21368a;

    public v66() {
        this.f21368a = null;
        if (bc1.c().equals("OPPO")) {
            this.f21368a = b54.e();
        }
    }

    public static v66 b() {
        if (c == null) {
            c = new v66();
        }
        return c;
    }

    public final String a() {
        String string = AppContext.getContext().getResources().getString(R.string.oppo_auto_run_permission_notification);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionTypes", "activity");
            jSONObject.put("actionBody", string);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public void c(String str) {
        if (this.f21368a == null) {
            return;
        }
        int i = b + 1;
        b = i;
        if (i > 1) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("message", "");
        contentValues.put("data1", (Integer) 1);
        contentValues.put("data2", a());
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
        contentValues.put("msg_type", (Integer) 10000);
        contentValues.put("type", (Integer) 1);
        contentValues.put("packet_id", xn3.a());
        contentValues.put("contact_relate", str);
        contentValues.put("msg_extend", str);
        contentValues.put("read", (Integer) 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message_values", contentValues);
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        AppContext.getContext().getContentResolver().call(DBUriManager.b(ho3.class, contactInfoItemL), "insertRawMessage", DBUriManager.b(ho3.class, contactInfoItemL).toString(), bundle);
    }

    public void d(String str) {
        jr jrVar = this.f21368a;
        if (jrVar != null) {
            jrVar.d(str);
        }
    }

    public boolean e() {
        jr jrVar = this.f21368a;
        if (jrVar == null) {
            return false;
        }
        try {
            return jrVar.b();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean f() {
        jr jrVar = this.f21368a;
        if (jrVar == null) {
            return false;
        }
        try {
            return jrVar.c();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
