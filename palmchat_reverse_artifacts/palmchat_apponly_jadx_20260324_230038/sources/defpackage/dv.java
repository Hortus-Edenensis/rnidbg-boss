package defpackage;

import android.content.ContentValues;
import android.net.Uri;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dv {
    public static boolean a(String str, Uri uri, ContentValues[] contentValuesArr, boolean z) {
        LogUtil.i("BulkOperationHelper_leg", "bulkOperation start " + str);
        if (contentValuesArr != null && contentValuesArr.length > 0 && contentValuesArr[0] != null) {
            if (z) {
                int length = contentValuesArr.length;
                int i = ((length + 200) - 1) / 200;
                if (i == 1) {
                    AppContext.getContext().getContentResolver().bulkInsert(uri, contentValuesArr);
                } else {
                    int i2 = 0;
                    while (i > 0) {
                        int iMin = Math.min(length - i2, 200) + i2;
                        if (AppContext.getContext().getContentResolver().bulkInsert(uri, (ContentValues[]) Arrays.copyOfRange(contentValuesArr, i2, iMin)) == -1) {
                            return false;
                        }
                        i--;
                        i2 = iMin;
                    }
                }
            } else {
                AppContext.getContext().getContentResolver().bulkInsert(uri, contentValuesArr);
            }
        }
        LogUtil.i("BulkOperationHelper_leg", "bulkOperation end " + str);
        return true;
    }

    public static int b(int i, ContentValues[] contentValuesArr) {
        int iIntValue = 0;
        int i2 = 0;
        while (i < contentValuesArr.length) {
            ContentValues contentValues = contentValuesArr[i];
            if (contentValues != null) {
                iIntValue++;
                Integer asInteger = contentValues.getAsInteger("group_member_change_count");
                if (asInteger != null) {
                    iIntValue += asInteger.intValue();
                }
                i2++;
                if (iIntValue >= 200) {
                    break;
                }
            }
            i++;
        }
        return i2;
    }

    public static boolean c(String str, Uri uri, ContentValues[] contentValuesArr, boolean z) {
        LogUtil.i("BulkOperationHelper_leg", "smartGroupBulkInsert start " + str);
        int i = 0;
        if (contentValuesArr != null && contentValuesArr.length > 0 && contentValuesArr[0] != null) {
            if (z) {
                int i2 = 0;
                while (i2 < contentValuesArr.length) {
                    int iB = b(i2, contentValuesArr) + i2;
                    if (AppContext.getContext().getContentResolver().bulkInsert(uri, (ContentValues[]) Arrays.copyOfRange(contentValuesArr, i2, iB)) == -1) {
                        return false;
                    }
                    i2 = iB;
                }
                i = i2;
            } else {
                AppContext.getContext().getContentResolver().bulkInsert(uri, contentValuesArr);
            }
        }
        LogUtil.i("BulkOperationHelper_leg", "smartGroupBulkInsert end " + str + " writeLength=" + i);
        return true;
    }
}
