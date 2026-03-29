package com.tencent.matrix.report;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.report.IssuePublisher;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FilePublisher extends IssuePublisher {
    private static final String TAG = "Matrix.FilePublisher";
    private final Context mContext;
    private final SharedPreferences.Editor mEditor;
    private final long mExpiredTime;
    private final HashMap<String, Long> mPublishedMap;

    public FilePublisher(Context context, long j, String str, IssuePublisher.OnIssueDetectListener onIssueDetectListener) {
        super(onIssueDetectListener);
        this.mContext = context;
        this.mExpiredTime = j;
        String str2 = "Matrix_" + str + MatrixUtil.getProcessName(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        this.mPublishedMap = new HashMap<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mEditor = sharedPreferences.edit();
        HashSet<String> hashSet = sharedPreferences.getAll() != null ? new HashSet(sharedPreferences.getAll().keySet()) : null;
        if (hashSet != null) {
            for (String str3 : hashSet) {
                try {
                    long j2 = sharedPreferences.getLong(str3, 0L);
                    long j3 = jCurrentTimeMillis - j2;
                    if (j2 <= 0 || j3 > this.mExpiredTime) {
                        this.mEditor.remove(str3);
                    } else {
                        this.mPublishedMap.put(str3, Long.valueOf(j2));
                    }
                } catch (ClassCastException e) {
                    MatrixLog.printErrStackTrace(TAG, e, "might be polluted - sp: %s, key: %s, value : %s", str2, str3, sharedPreferences.getAll().get(str3));
                }
            }
        }
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.apply();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.tencent.matrix.report.IssuePublisher
    public boolean isPublished(String str) {
        if (!this.mPublishedMap.containsKey(str)) {
            return false;
        }
        long jLongValue = this.mPublishedMap.get(str).longValue();
        if (jLongValue > 0 && System.currentTimeMillis() - jLongValue <= this.mExpiredTime) {
            return true;
        }
        SharedPreferences.Editor editorRemove = this.mEditor.remove(str);
        if (editorRemove != null) {
            editorRemove.apply();
        }
        this.mPublishedMap.remove(str);
        return false;
    }

    public void markPublished(String str, boolean z) {
        SharedPreferences.Editor editorPutLong;
        if (str == null || this.mPublishedMap.containsKey(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mPublishedMap.put(str, Long.valueOf(jCurrentTimeMillis));
        if (!z || (editorPutLong = this.mEditor.putLong(str, jCurrentTimeMillis)) == null) {
            return;
        }
        editorPutLong.apply();
    }

    @Override // com.tencent.matrix.report.IssuePublisher
    public void unMarkPublished(String str) {
        if (str != null && this.mPublishedMap.containsKey(str)) {
            this.mPublishedMap.remove(str);
            SharedPreferences.Editor editorRemove = this.mEditor.remove(str);
            if (editorRemove != null) {
                editorRemove.apply();
            }
        }
    }

    @Override // com.tencent.matrix.report.IssuePublisher
    public void markPublished(String str) {
        markPublished(str, true);
    }
}
