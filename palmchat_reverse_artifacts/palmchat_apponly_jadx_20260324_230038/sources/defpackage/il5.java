package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.push.core.b;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.groupchat.GroupMemberInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class il5 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18196a;
        public int b;

        public a(int i, int i2) {
            this.f18196a = i;
            this.b = i2;
        }
    }

    public static String a(Context context, long j) {
        float f = j / 1024;
        float f2 = f / 1024.0f;
        return (f2 >= 1.0f ? String.format("%10.2fM", Float.valueOf(f2)) : String.format("%10.0fK", Float.valueOf(f))).replace(" ", "");
    }

    public static String b(Context context, long j) {
        float f = j / 1024;
        float f2 = f / 1024.0f;
        return (f2 >= 1.0f ? String.format("%10.2fMB", Float.valueOf(f2)) : String.format("%10.0fKB", Float.valueOf(f))).replace(" ", "");
    }

    public static boolean c(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.toLowerCase().contains(str2.toLowerCase())) ? false : true;
    }

    public static boolean d(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static CharSequence e(CharSequence charSequence, float f, int i) {
        if (charSequence == null) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        return TextUtils.ellipsize(charSequence, textPaint, i, TextUtils.TruncateAt.END);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannableString f(ArrayList<GroupMemberInfoItem> arrayList, String str) {
        int iIndexOf;
        int length;
        int i;
        int i2;
        ArrayList<a> arrayList2 = new ArrayList();
        String lowerCase = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(AppContext.getContext().getString(R.string.search_item_contains));
        for (GroupMemberInfoItem groupMemberInfoItem : arrayList) {
            int iIndexOf2 = !TextUtils.isEmpty(groupMemberInfoItem.getDisplayName()) ? groupMemberInfoItem.getDisplayName().toLowerCase().indexOf(lowerCase) : -1;
            int length2 = 0;
            if (TextUtils.isEmpty(groupMemberInfoItem.getRemarkName())) {
                iIndexOf = -1;
                length = 0;
                i = 0;
            } else {
                iIndexOf = groupMemberInfoItem.getRemarkName().toLowerCase().indexOf(lowerCase);
                if (TextUtils.isEmpty(groupMemberInfoItem.getRemarkAllPinyin()) || !groupMemberInfoItem.getRemarkAllPinyin().toLowerCase().startsWith(lowerCase)) {
                    i = 0;
                    length = (TextUtils.isEmpty(groupMemberInfoItem.getRemarkFirstPinyin()) && groupMemberInfoItem.getRemarkFirstPinyin().toLowerCase().startsWith(lowerCase)) ? lowerCase.length() : 0;
                } else {
                    List<String> listO = o(groupMemberInfoItem.getRemarkAllPinyin());
                    StringBuilder sb2 = new StringBuilder();
                    int i3 = 0;
                    i = 0;
                    while (true) {
                        if (i3 >= listO.size()) {
                            break;
                        }
                        sb2.append(listO.get(i3).toLowerCase());
                        if (sb2.toString().startsWith(lowerCase)) {
                            i++;
                            break;
                        }
                        if (!lowerCase.startsWith(sb2.toString())) {
                            break;
                        }
                        i++;
                        i3++;
                    }
                    i = 0;
                    if (TextUtils.isEmpty(groupMemberInfoItem.getRemarkFirstPinyin())) {
                    }
                }
            }
            int iIndexOf3 = groupMemberInfoItem.getNickName() != null ? groupMemberInfoItem.getNickName().toLowerCase().indexOf(lowerCase) : -1;
            if (TextUtils.isEmpty(groupMemberInfoItem.getAllPinyin()) || !groupMemberInfoItem.getAllPinyin().toLowerCase().startsWith(lowerCase)) {
                i2 = 0;
            } else {
                List<String> listO2 = o(groupMemberInfoItem.getAllPinyin());
                StringBuilder sb3 = new StringBuilder();
                int i4 = 0;
                i2 = 0;
                while (true) {
                    if (i4 >= listO2.size()) {
                        break;
                    }
                    sb3.append(listO2.get(i4).toLowerCase());
                    if (sb3.toString().startsWith(lowerCase)) {
                        i2++;
                        break;
                    }
                    if (!lowerCase.startsWith(sb3.toString())) {
                        break;
                    }
                    i2++;
                    i4++;
                }
                i2 = 0;
            }
            int length3 = (TextUtils.isEmpty(groupMemberInfoItem.getFirstPinyin()) || !groupMemberInfoItem.getFirstPinyin().toLowerCase().startsWith(lowerCase)) ? 0 : lowerCase.length();
            if (!TextUtils.isEmpty(groupMemberInfoItem.getAccount()) && groupMemberInfoItem.getAccount().toLowerCase().startsWith(lowerCase)) {
                length2 = lowerCase.length();
            }
            if (iIndexOf2 >= 0) {
                sb.append(TextUtils.isEmpty(groupMemberInfoItem.getRemarkName()) ? groupMemberInfoItem.getNickName() : groupMemberInfoItem.getRemarkName());
                sb.append("(");
                arrayList2.add(new a(sb.length() + iIndexOf2, lowerCase.length()));
                sb.append(groupMemberInfoItem.getDisplayName());
                sb.append("), ");
            } else if (iIndexOf >= 0) {
                arrayList2.add(new a(sb.length() + iIndexOf, lowerCase.length()));
                sb.append(groupMemberInfoItem.getRemarkName());
                sb.append(", ");
            } else if (length > 0) {
                arrayList2.add(new a(sb.length(), length));
                sb.append(groupMemberInfoItem.getRemarkName());
                sb.append(", ");
            } else if (i > 0) {
                arrayList2.add(new a(sb.length(), i));
                sb.append(groupMemberInfoItem.getRemarkName());
                sb.append(", ");
            } else if (iIndexOf3 >= 0) {
                if (TextUtils.isEmpty(groupMemberInfoItem.getRemarkName())) {
                    arrayList2.add(new a(sb.length() + iIndexOf3, lowerCase.length()));
                    sb.append(groupMemberInfoItem.getNickName());
                    sb.append(", ");
                } else {
                    sb.append(groupMemberInfoItem.getRemarkName());
                    sb.append("(");
                    arrayList2.add(new a(sb.length() + iIndexOf3, lowerCase.length()));
                    sb.append(groupMemberInfoItem.getNickName());
                    sb.append("), ");
                }
            } else if (length3 > 0) {
                if (TextUtils.isEmpty(groupMemberInfoItem.getRemarkName())) {
                    arrayList2.add(new a(sb.length(), length3));
                    sb.append(groupMemberInfoItem.getNickName());
                    sb.append(", ");
                } else {
                    sb.append(groupMemberInfoItem.getRemarkName());
                    sb.append("(");
                    arrayList2.add(new a(sb.length(), length3));
                    sb.append(groupMemberInfoItem.getNickName());
                    sb.append("), ");
                }
            } else if (i2 > 0) {
                if (TextUtils.isEmpty(groupMemberInfoItem.getRemarkName())) {
                    arrayList2.add(new a(sb.length(), i2));
                    sb.append(groupMemberInfoItem.getNickName());
                    sb.append(", ");
                } else {
                    sb.append(groupMemberInfoItem.getRemarkName());
                    sb.append("(");
                    arrayList2.add(new a(sb.length(), i2));
                    sb.append(groupMemberInfoItem.getNickName());
                    sb.append("), ");
                }
            } else if (length2 > 0) {
                if (!TextUtils.isEmpty(groupMemberInfoItem.getRemarkName())) {
                    sb.append(groupMemberInfoItem.getRemarkName());
                    sb.append("(");
                } else if (TextUtils.isEmpty(groupMemberInfoItem.getDisplayName())) {
                    sb.append(groupMemberInfoItem.getNickName());
                    sb.append("(");
                } else {
                    sb.append(groupMemberInfoItem.getDisplayName());
                    sb.append("(");
                }
                arrayList2.add(new a(sb.length(), length2));
                sb.append(groupMemberInfoItem.getAccount());
                sb.append("), ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        SpannableString spannableString = new SpannableString(sb.toString());
        for (a aVar : arrayList2) {
            try {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(AppContext.getContext().getResources().getColor(R.color.Ga));
                int i5 = aVar.f18196a;
                spannableString.setSpan(foregroundColorSpan, i5, aVar.b + i5, 33);
            } catch (Exception unused) {
            }
        }
        return spannableString;
    }

    public static SpannableString g(int i, String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && i >= 0 && i < str.length()) {
            try {
                SpannableString spannableString = new SpannableString(str);
                String strSubstring = str.substring(i);
                if (!TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(str4)) {
                    String lowerCase = str4.toLowerCase();
                    int iIndexOf = strSubstring.toLowerCase().indexOf(lowerCase);
                    if (iIndexOf >= 0) {
                        int i2 = iIndexOf + i;
                        spannableString.setSpan(new ForegroundColorSpan(AppContext.getContext().getResources().getColor(R.color.Ga)), i2, lowerCase.length() + i2, 33);
                        return spannableString;
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        int iIndexOf2 = str3.toLowerCase().indexOf(lowerCase);
                        if (iIndexOf2 >= 0) {
                            int i3 = iIndexOf2 + i;
                            spannableString.setSpan(new ForegroundColorSpan(AppContext.getContext().getResources().getColor(R.color.Ga)), i3, lowerCase.length() + i3, 33);
                            return spannableString;
                        }
                        List<String> listO = o(str2);
                        int i4 = 1;
                        for (int i5 = 0; i5 < listO.size(); i5++) {
                            StringBuilder sb = new StringBuilder();
                            for (int i6 = 0; i6 <= i5; i6++) {
                                sb.append(listO.get(i6).toLowerCase());
                            }
                            if (sb.toString().startsWith(lowerCase)) {
                                spannableString.setSpan(new ForegroundColorSpan(AppContext.getContext().getResources().getColor(R.color.Ga)), i, i4 + i, 33);
                                return spannableString;
                            }
                            if (lowerCase.startsWith(sb.toString())) {
                                i4++;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static SpannableString h(String str, String str2) {
        int iIndexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(str2) && (iIndexOf = str.toLowerCase().indexOf(str2.toLowerCase())) >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(AppContext.getContext().getResources().getColor(R.color.Ga)), iIndexOf, str2.length() + iIndexOf, 33);
        }
        return spannableString;
    }

    public static String i(Context context, String str, String str2, String str3) {
        return j(context, str, str2, str3, true);
    }

    public static String j(Context context, String str, String str2, String str3, boolean z) {
        if ((!TextUtils.isEmpty(str) && str.matches(".*[\\u4e00-\\u9faf].*")) || ((!TextUtils.isEmpty(str2) && str2.matches(".*[\\u4e00-\\u9faf].*")) || (!TextUtils.isEmpty(str3) && str3.matches(".*[\\u4e00-\\u9faf].*")))) {
            LogUtil.d("StringUtil", "getDistrict:" + str + " " + str2 + " " + str3);
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            ArrayList<String> arrayListN = r7.j(context).n(context, str, str2, str3);
            String str4 = arrayListN.get(0);
            String str5 = arrayListN.get(1);
            str3 = arrayListN.get(2);
            str = str4;
            str2 = str5;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(context.getString(R.string.user_detail_default_district)) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                sb.append(str);
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(" " + str3);
                } else if (!TextUtils.isEmpty(str2)) {
                    sb.append(" " + str2);
                }
            } else {
                sb.append(" " + str2 + " " + str3);
            }
        }
        String string = sb.toString();
        return (z && TextUtils.isEmpty(string)) ? context.getString(R.string.user_detail_default_district) : string;
    }

    public static float k(Context context, String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(i);
        return textPaint.measureText(str);
    }

    public static boolean l(String str) {
        return str == null || "".equals(str) || b.m.equals(str);
    }

    public static String m(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            int length = strArr.length;
            sb.append("[length =" + length);
            for (int i = 0; i < length; i++) {
                sb.append("index");
                sb.append(i);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(strArr[i]);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public static String n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        if (length <= i) {
            return str.substring(0, length);
        }
        return str.substring(0, i) + "...";
    }

    public static List<String> o(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (Character.isLetter(cCharAt)) {
                    if (Character.isUpperCase(cCharAt) && sb.length() > 0) {
                        arrayList.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    sb.append(cCharAt);
                } else {
                    if (sb.length() > 0) {
                        arrayList.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    arrayList.add(String.valueOf(cCharAt));
                }
            }
            if (sb.length() > 0) {
                arrayList.add(sb.toString());
            }
        }
        return arrayList;
    }

    public static boolean p(String str) {
        return str == null || TextUtils.isEmpty(str.trim());
    }

    public static String q(String str) {
        return str.trim();
    }
}
