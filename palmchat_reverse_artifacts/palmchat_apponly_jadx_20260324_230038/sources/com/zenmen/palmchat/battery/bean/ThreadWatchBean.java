package com.zenmen.palmchat.battery.bean;

import com.zenmen.palmchat.battery.bean.JiffiesBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadWatchBean {
    public int threadJiffiesCount;
    public List<JiffiesBean.ThreadJiffies> threadJiffies = new ArrayList();
    public List<StackTrace> stacks = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static class StackTrace {
        public String customMessage;
        public String stackTrace;
        public long threadId;
        public String threadName;
        public String threadState;
    }
}
