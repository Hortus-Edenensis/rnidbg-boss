package com.tencent.matrix.plugin;

import android.content.Context;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.util.MatrixLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultPluginListener implements PluginListener {
    private static final String TAG = "Matrix.DefaultPluginListener";
    private final Context context;

    public DefaultPluginListener(Context context) {
        this.context = context;
    }

    @Override // com.tencent.matrix.plugin.PluginListener
    public void onDestroy(Plugin plugin) {
        MatrixLog.i(TAG, "%s plugin is destroyed", plugin.getTag());
    }

    @Override // com.tencent.matrix.plugin.PluginListener
    public void onInit(Plugin plugin) {
        MatrixLog.i(TAG, "%s plugin is inited", plugin.getTag());
    }

    @Override // com.tencent.matrix.plugin.PluginListener
    public void onReportIssue(Issue issue) {
        Object[] objArr = new Object[1];
        Object obj = issue;
        if (issue == null) {
            obj = "";
        }
        objArr[0] = obj;
        MatrixLog.i(TAG, "report issue content: %s", objArr);
    }

    @Override // com.tencent.matrix.plugin.PluginListener
    public void onStart(Plugin plugin) {
        MatrixLog.i(TAG, "%s plugin is started", plugin.getTag());
    }

    @Override // com.tencent.matrix.plugin.PluginListener
    public void onStop(Plugin plugin) {
        MatrixLog.i(TAG, "%s plugin is stopped", plugin.getTag());
    }
}
