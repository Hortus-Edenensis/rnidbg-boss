package com.zenmen.palmchat.utils.dialogmanager.config;

import androidx.annotation.Keep;
import com.zenmen.palmchat.utils.dialogmanager.DialogScene;
import defpackage.ir5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class PopRuleConfig {
    public int coolingTime;
    public String[] excludeDialogList;
    public int newUserShowTimes;
    public boolean newUserStatus;
    public int oldUserShowTimes;

    public boolean isWithList(DialogScene dialogScene) {
        String[] strArr = this.excludeDialogList;
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        for (String str : strArr) {
            if (str.equals(dialogScene.value)) {
                return true;
            }
        }
        return false;
    }

    public boolean testCoolTime(long j) {
        return Math.abs(j - ir5.b()) > ((long) this.coolingTime) * 1000;
    }

    public boolean testTodayCount(long j) {
        return j < ((long) (this.newUserStatus ? this.newUserShowTimes : this.oldUserShowTimes));
    }
}
