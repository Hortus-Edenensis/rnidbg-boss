package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.database.DBUriManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ku4 {
    public static int a(MessageVo messageVo) {
        String str = messageVo.data1;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    public static void b(MessageVo messageVo, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data1", String.valueOf(i));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{messageVo.mid});
    }
}
