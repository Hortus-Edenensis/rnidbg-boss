package com.umeng.logsdk;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UploadFileFilterCodeLog implements IFileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ULogConfigManager f11115a;
    private b b;
    private String c;
    private String e;
    private long g;
    private long h;
    private int d = -1;
    private int f = -1;

    private void a() {
        Log.i("UploadFileFilterCodeLog", "reset task.");
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = null;
        this.f = -1;
        this.g = 0L;
        this.h = 0L;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean filter(File file) {
        StringBuilder sb;
        String string;
        StringBuilder sb2;
        List<b> taskList;
        if (this.b == null) {
            ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
            this.f11115a = uLogConfigManager;
            if (uLogConfigManager != null && (taskList = uLogConfigManager.getTaskList()) != null && !taskList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i >= taskList.size()) {
                        break;
                    }
                    b bVar = taskList.get(i);
                    this.b = bVar;
                    if (bVar != null) {
                        int i2 = bVar.b;
                        this.d = i2;
                        if (i2 == 0) {
                            this.c = bVar.f11117a;
                            this.e = bVar.d;
                            this.f = bVar.c;
                            this.g = bVar.e;
                            this.h = bVar.f;
                            break;
                        }
                        a();
                    }
                    i++;
                }
            }
        }
        if (this.b != null && this.d == 0) {
            Log.i("UploadFileFilterCodeLog", this.c + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h);
            String name = file.getName();
            LogDto logDtoCreateLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
            if (logDtoCreateLogDtoByName == null) {
                CacheManager.getInstance().onChangeDtoError(file);
                return true;
            }
            long beginTime = logDtoCreateLogDtoByName.getBeginTime();
            logDtoCreateLogDtoByName.getEndTime();
            String did = logDtoCreateLogDtoByName.getDid();
            String uid = logDtoCreateLogDtoByName.getUid();
            if (beginTime >= this.g && beginTime <= this.h) {
                Log.i("UploadFileFilterCodeLog", "task target type is " + this.f);
                int i3 = this.f;
                if (i3 == 1) {
                    if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(did) || !this.e.equals(did)) {
                        string = "taskTarget is " + this.e + ", did is " + did;
                        Log.i("UploadFileFilterCodeLog", string);
                    } else {
                        sb2 = new StringBuilder("task is ");
                    }
                } else if (i3 == 0) {
                    if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(uid) || !this.e.equals(uid)) {
                        sb = new StringBuilder("taskTarget is ");
                        sb.append(this.e);
                        sb.append(", uid is ");
                        sb.append(uid);
                    } else {
                        sb2 = new StringBuilder("task is ");
                    }
                }
                sb2.append(this.c);
                sb2.append(", target is ");
                sb2.append(this.e);
                sb2.append(", file time is ");
                sb2.append(beginTime);
                Log.i("UploadFileFilterCodeLog", sb2.toString());
                return false;
            }
            sb = new StringBuilder("time is ");
            sb.append(beginTime >= this.g);
            sb.append(", is ");
            sb.append(beginTime <= this.h);
            string = sb.toString();
            Log.i("UploadFileFilterCodeLog", string);
        }
        return true;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public void finish() {
        ULogConfigManager uLogConfigManager;
        Log.i("UploadFileFilterCodeLog", "clear task.");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i("UploadFileFilterCodeLog", "taskEndTime is " + this.h + ", current time is " + jCurrentTimeMillis);
        if (this.h > jCurrentTimeMillis) {
            Log.i("UploadFileFilterCodeLog", "future task. not remove.");
            uLogConfigManager = this.f11115a;
            if (uLogConfigManager != null) {
                uLogConfigManager.removeTask(this.b);
            }
        } else {
            ULogConfigManager uLogConfigManager2 = this.f11115a;
            if (uLogConfigManager2 != null) {
                uLogConfigManager2.reMoveTaskFroSP(this.c);
                uLogConfigManager = this.f11115a;
                uLogConfigManager.removeTask(this.b);
            }
        }
        a();
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean hasTask() {
        List<b> taskList;
        ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
        if (uLogConfigManager == null || (taskList = uLogConfigManager.getTaskList()) == null || taskList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < taskList.size(); i++) {
            b bVar = taskList.get(i);
            if (bVar != null && bVar.b == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public void finish(boolean z, boolean z2) {
    }
}
