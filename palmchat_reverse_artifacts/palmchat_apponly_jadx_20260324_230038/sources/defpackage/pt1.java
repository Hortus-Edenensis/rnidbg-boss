package defpackage;

import android.database.Cursor;
import android.text.TextUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20093a = "pt1";

    public static String a(String str) {
        if ("jsb".equals(str)) {
            str = "jsb" + new Random().nextInt(3);
        } else if ("dice".equals(str)) {
            str = "dice" + new Random().nextInt(6);
        }
        LogUtil.i(f20093a, "genRandomSpecialExpression " + str);
        return str;
    }

    public static ArrayList<ExpressionObject> b(Cursor cursor) {
        ArrayList<ExpressionObject> arrayList = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                ExpressionObject expressionObject = new ExpressionObject();
                expressionObject._id = cursor.getInt(cursor.getColumnIndex("_id"));
                expressionObject.path = cursor.getString(cursor.getColumnIndex("local_path"));
                expressionObject.coverPath = cursor.getString(cursor.getColumnIndex("local_path_cover"));
                expressionObject.index = cursor.getInt(cursor.getColumnIndex("exp_index"));
                expressionObject.type = cursor.getInt(cursor.getColumnIndex("type"));
                expressionObject.description = cursor.getString(cursor.getColumnIndex("description"));
                arrayList.add(expressionObject);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.startsWith("jsb")) {
            int iIntValue = Integer.valueOf(str.substring(3)).intValue();
            if (iIntValue == 0) {
                return R.drawable.jsb_j;
            }
            if (iIntValue == 1) {
                return R.drawable.jsb_s;
            }
            if (iIntValue != 2) {
                return 0;
            }
            return R.drawable.jsb_b;
        }
        if (!str.startsWith("dice")) {
            return 0;
        }
        int iIntValue2 = Integer.valueOf(str.substring(4)).intValue();
        if (iIntValue2 == 0) {
            return R.drawable.dice_1;
        }
        if (iIntValue2 == 1) {
            return R.drawable.dice_2;
        }
        if (iIntValue2 == 2) {
            return R.drawable.dice_3;
        }
        if (iIntValue2 == 3) {
            return R.drawable.dice_4;
        }
        if (iIntValue2 == 4) {
            return R.drawable.dice_5;
        }
        if (iIntValue2 != 5) {
            return 0;
        }
        return R.drawable.dice_6;
    }

    public static ArrayList<ExpressionObject> d(ArrayList<ExpressionObject> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<ExpressionObject> arrayList3 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            ExpressionObject expressionObject = arrayList.get(i);
            if (TextUtils.isEmpty(expressionObject.tag)) {
                if (new File(expressionObject.path).exists()) {
                    arrayList3.add(expressionObject);
                } else {
                    arrayList2.add(String.valueOf(expressionObject._id));
                }
            }
        }
        ot1.a(arrayList2);
        return arrayList3;
    }
}
