package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.ExpressionObject;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ot1 {
    public static void a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            if (arrayList.size() > 100) {
                arrayList2.addAll(arrayList.subList(0, 100));
            } else {
                arrayList2.addAll(arrayList);
            }
        }
        if (arrayList2.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList2.size(); i++) {
                if (i == arrayList2.size() - 1) {
                    sb.append("_id=?");
                } else {
                    sb.append("_id=? or ");
                }
            }
            AppContext.getContext().getContentResolver().delete(qt1.f20317a, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
    }

    public static void b(ExpressionObject expressionObject) {
        if (expressionObject != null) {
            String[] strArr = {expressionObject.md5};
            ContentResolver contentResolver = AppContext.getContext().getContentResolver();
            Uri uri = qt1.f20317a;
            Cursor cursorQuery = contentResolver.query(uri, null, "md5=?", strArr, null);
            if (cursorQuery != null) {
                z = cursorQuery.getCount() <= 0;
                cursorQuery.close();
            }
            if (z) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("local_path", expressionObject.path);
                contentValues.put("local_path_cover", expressionObject.coverPath);
                contentValues.put("exp_index", Integer.valueOf(expressionObject.index));
                contentValues.put("type", Integer.valueOf(expressionObject.type));
                contentValues.put("description", expressionObject.description);
                contentValues.put("md5", expressionObject.md5);
                AppContext.getContext().getContentResolver().insert(uri, contentValues);
            }
        }
    }

    public static boolean c(String str) {
        boolean z = true;
        if (!TextUtils.isEmpty(str)) {
            try {
                Cursor cursorQuery = AppContext.getContext().getContentResolver().query(qt1.f20317a, null, "md5=?", new String[]{new JSONObject(str).getString("md5")}, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z = false;
                    }
                    cursorQuery.close();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return z;
    }
}
