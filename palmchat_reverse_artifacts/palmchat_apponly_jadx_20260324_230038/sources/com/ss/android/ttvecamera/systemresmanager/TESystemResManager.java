package com.ss.android.ttvecamera.systemresmanager;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TESystemResManager {
    private boolean isInitialized = false;
    public ITESystemResourceStrategy mStrategy;

    /* JADX INFO: compiled from: SearchBox */
    public enum ActionType {
        UNKNOWN,
        BOOST_CPU,
        RESTORE_CPU
    }

    public void initStrategy(Context context) {
        if (this.isInitialized) {
            return;
        }
        ITESystemResourceStrategy iTESystemResourceStrategy = this.mStrategy;
        if (iTESystemResourceStrategy != null) {
            iTESystemResourceStrategy.init(context);
        }
        this.isInitialized = true;
    }

    public void setStrategy(ITESystemResourceStrategy iTESystemResourceStrategy) {
        this.isInitialized = false;
        this.mStrategy = iTESystemResourceStrategy;
    }

    public void startAction(Action action) {
        ITESystemResourceStrategy iTESystemResourceStrategy;
        if (!this.isInitialized || (iTESystemResourceStrategy = this.mStrategy) == null) {
            return;
        }
        ActionType actionType = action.type;
        if (actionType == ActionType.BOOST_CPU) {
            iTESystemResourceStrategy.boostCpuFreq(action.timeout);
        } else if (actionType == ActionType.RESTORE_CPU) {
            iTESystemResourceStrategy.restoreCpuFreq();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Action {
        public int timeout;
        public ActionType type;

        public Action(ActionType actionType) {
            this.timeout = 0;
            this.type = actionType;
        }

        public Action(ActionType actionType, int i) {
            this.type = actionType;
            this.timeout = i;
        }
    }
}
