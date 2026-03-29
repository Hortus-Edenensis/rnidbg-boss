package defpackage;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import java.lang.reflect.Field;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class e73 {
    public static String a() {
        JSONObject jSONObjectH;
        JSONObject jSONObjectE = ts0.o().e();
        String strOptString = jSONObjectE != null ? jSONObjectE.optString("phoneButton") : null;
        return (!TextUtils.isEmpty(strOptString) || (jSONObjectH = ts0.o().h()) == null) ? strOptString : jSONObjectH.optString("phoneButton");
    }

    public static String b() {
        JSONObject jSONObjectH;
        JSONObject jSONObjectE = ts0.o().e();
        String strOptString = jSONObjectE != null ? jSONObjectE.optString("subTitle") : null;
        return (!TextUtils.isEmpty(strOptString) || (jSONObjectH = ts0.o().h()) == null) ? strOptString : jSONObjectH.optString("subTitle");
    }

    public static String c() {
        JSONObject jSONObjectH;
        JSONObject jSONObjectE = ts0.o().e();
        String strOptString = jSONObjectE != null ? jSONObjectE.optString("Title") : null;
        return (!TextUtils.isEmpty(strOptString) || (jSONObjectH = ts0.o().h()) == null) ? strOptString : jSONObjectH.optString("Title");
    }

    public static String d() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("reggenderageintro") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_gender_bitrhday_sub_title) : strOptString;
    }

    public static String e() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("reggenderagetitle") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_gender_bitrhday_title) : strOptString;
    }

    public static String f() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regincomeintro") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_income_sub_title) : strOptString;
    }

    public static String g() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regincometitle") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_income_title) : strOptString;
    }

    public static String h() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regintentionintro") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_intention_sub_title) : strOptString;
    }

    public static String i() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regintentiontitle") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_intention_title) : strOptString;
    }

    public static String j() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regoccupationintro") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_occupation_sub_title) : strOptString;
    }

    public static String k() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regoccupationtitle") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_occupation_title) : strOptString;
    }

    public static String l() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regphotonickintro") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_portrait_nick_sub_title) : strOptString;
    }

    public static String m() {
        JSONObject jSONObjectX = ts0.o().x();
        String strOptString = jSONObjectX != null ? jSONObjectX.optString("regphotonicktitle") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.complete_portrait_nick_title) : strOptString;
    }

    public static String n() {
        JSONObject jSONObjectQ = ts0.o().q();
        String strOptString = jSONObjectQ != null ? jSONObjectQ.optString("pagestartslogan") : null;
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.login_init_welcome) : strOptString;
    }

    public static boolean o() {
        return true;
    }

    public static boolean p() {
        return ts0.o().H() ? ts0.o().J() : o();
    }

    public static boolean q() {
        String strD = ts0.o().D();
        return strD == null || !strD.equals("A");
    }

    public static void r(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }
}
