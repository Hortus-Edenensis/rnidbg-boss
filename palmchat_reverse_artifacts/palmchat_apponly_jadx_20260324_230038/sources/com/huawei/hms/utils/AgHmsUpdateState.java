package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class AgHmsUpdateState {
    private static final Object c = new Object();
    private static volatile AgHmsUpdateState d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HmsCheckedState f6883a = HmsCheckedState.UNCHECKED;
    private int b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (d == null) {
            synchronized (c) {
                if (d == null) {
                    d = new AgHmsUpdateState();
                }
            }
        }
        return d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f6883a;
    }

    public int getTargetVersionCode() {
        return this.b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() != HmsCheckedState.NEED_UPDATE) {
            return;
        }
        setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        setTargetVersionCode(0);
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f6883a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i) {
        this.b = i;
    }
}
