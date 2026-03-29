package com.zenmen.palmchat.conversations.threadgroup;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.mo5;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadFolderManager {

    /* JADX INFO: compiled from: SearchBox */
    public enum FolderType {
        TYPE_OLD_GREETINGS(10001, new Integer[]{13, 17, 14}, null),
        TYPE_SQUARE_GREETINGS(10005, ThreadFolderManager.d(), new Pair(5000, 6023));

        public Integer[] bizTypes;
        public int groupBizType;
        public Pair<Integer, Integer> region;

        FolderType(int i, Integer[] numArr, Pair pair) {
            this.groupBizType = i;
            this.bizTypes = numArr;
            this.region = pair;
        }

        public boolean enable() {
            int i = this.groupBizType;
            return i != 10001 && i == 10005;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(StringBuilder sb, ArrayList<String> arrayList, int i, boolean z) {
        String str;
        String str2 = "(";
        sb.append("(");
        FolderType[] folderTypeArrValues = FolderType.values();
        int length = folderTypeArrValues.length;
        int i2 = 0;
        while (i2 < length) {
            FolderType folderType = folderTypeArrValues[i2];
            if (folderType.groupBizType != i) {
                str = str2;
            } else {
                if (z) {
                    sb.append("thread_biz_type");
                    sb.append("=? or ");
                    arrayList.add(String.valueOf(i));
                }
                if (10005 != folderType.groupBizType) {
                    str = str2;
                    for (int i3 = 0; i3 < folderType.bizTypes.length; i3++) {
                        sb.append("thread_biz_type");
                        sb.append("=?");
                        arrayList.add(String.valueOf(folderType.bizTypes[i3]));
                        if (i3 != folderType.bizTypes.length - 1) {
                            sb.append(" or ");
                        }
                    }
                } else if (folderType.bizTypes.length > 0) {
                    sb.append(str2);
                    if (folderType.region != null) {
                        sb.append("(thread_biz_type>=" + folderType.region.first + " and thread_biz_type<= " + folderType.region.second + ") or ");
                    }
                    Integer[] numArr = folderType.bizTypes;
                    int length2 = numArr.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < length2) {
                        Integer num = numArr[i4];
                        int i6 = i5 + 1;
                        String str3 = str2;
                        if (i6 < folderType.bizTypes.length) {
                            sb.append("thread_biz_type");
                            sb.append("=? or ");
                        } else {
                            sb.append("thread_biz_type");
                            sb.append("=? ");
                        }
                        arrayList.add(String.valueOf(num));
                        i4++;
                        str2 = str3;
                        i5 = i6;
                    }
                    str = str2;
                    sb.append(")");
                    sb.append(" and ");
                    sb.append("latest_message_time_stamp");
                    sb.append("<?");
                    arrayList.add(String.valueOf(System.currentTimeMillis() - mo5.d()));
                }
            }
            i2++;
            str2 = str;
        }
        sb.append(")");
        LogUtil.i("ThreadFolderManager", "appendForThreadBizQuery " + sb.toString());
    }

    public static String c(Context context, int i, int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("thread_biz_type");
            String string = "";
            if (iOptInt == 14) {
                string = context.getString(R.string.settings_item_fujinderen);
            } else if (iOptInt == 17) {
                string = context.getString(R.string.source_type_people_match);
            }
            String strOptString = jSONObject.optString("nick_name");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = context.getString(R.string.myself);
            }
            return !TextUtils.isEmpty(string) ? i == 10001 ? String.format("[%s]", string) : String.format("[%s] %s: ", string, strOptString) : String.format("%s: ", strOptString);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @NonNull
    public static Integer[] d() {
        return (Integer[]) new ArrayList(Arrays.asList(64, 65, 66, 67, 68, 69)).toArray(new Integer[0]);
    }

    public static boolean e(int i) {
        for (FolderType folderType : FolderType.values()) {
            if (folderType.groupBizType == i) {
                return true;
            }
        }
        return false;
    }
}
