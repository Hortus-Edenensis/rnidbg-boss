package com.qiniu.android.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SingleFlight<T> {
    private Map<String, SingleFlightCall<T>> callInfo = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface ActionHandler<T> {
        void action(CompleteHandler<T> completeHandler) throws Exception;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CompleteHandler<T> {
        void complete(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SingleFlightCall<T> {
        private Exception exception;
        private boolean isComplete;
        private List<SingleFlightTask<T>> tasks;
        private T value;

        private SingleFlightCall() {
            this.isComplete = false;
            this.tasks = new ArrayList();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SingleFlightTask<T> {
        private CompleteHandler<T> completeHandler;

        private SingleFlightTask() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void perform(final String str, ActionHandler<T> actionHandler, CompleteHandler<T> completeHandler) throws Exception {
        final SingleFlightCall<T> singleFlightCall;
        boolean z;
        boolean z2;
        if (actionHandler == null) {
            return;
        }
        synchronized (this) {
            if (str != null) {
                try {
                    singleFlightCall = this.callInfo.get(str);
                } finally {
                }
            } else {
                singleFlightCall = null;
            }
            if (singleFlightCall == null) {
                singleFlightCall = new SingleFlightCall<>();
                if (str != null) {
                    this.callInfo.put(str, singleFlightCall);
                }
                z = true;
            } else {
                z = false;
            }
            synchronized (singleFlightCall) {
                z2 = ((SingleFlightCall) singleFlightCall).isComplete;
                if (!z2) {
                    SingleFlightTask singleFlightTask = new SingleFlightTask();
                    singleFlightTask.completeHandler = completeHandler;
                    ((SingleFlightCall) singleFlightCall).tasks.add(singleFlightTask);
                }
            }
        }
        if (z2) {
            if (((SingleFlightCall) singleFlightCall).exception != null) {
                throw ((SingleFlightCall) singleFlightCall).exception;
            }
            if (completeHandler != 0) {
                completeHandler.complete(((SingleFlightCall) singleFlightCall).value);
                return;
            }
            return;
        }
        if (z) {
            try {
                actionHandler.action(new CompleteHandler<T>() { // from class: com.qiniu.android.utils.SingleFlight.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.qiniu.android.utils.SingleFlight.CompleteHandler
                    public void complete(T t) {
                        synchronized (singleFlightCall) {
                            if (singleFlightCall.isComplete) {
                                return;
                            }
                            singleFlightCall.isComplete = true;
                            singleFlightCall.value = t;
                            ArrayList<SingleFlightTask> arrayList = new ArrayList(singleFlightCall.tasks);
                            if (str != null) {
                                synchronized (this) {
                                    SingleFlight.this.callInfo.remove(str);
                                }
                            }
                            for (SingleFlightTask singleFlightTask2 : arrayList) {
                                if (singleFlightTask2 != null && singleFlightTask2.completeHandler != null) {
                                    singleFlightTask2.completeHandler.complete(singleFlightCall.value);
                                }
                            }
                        }
                    }
                });
            } catch (Exception e) {
                synchronized (singleFlightCall) {
                    if (((SingleFlightCall) singleFlightCall).isComplete) {
                        return;
                    }
                    ((SingleFlightCall) singleFlightCall).isComplete = true;
                    ((SingleFlightCall) singleFlightCall).exception = e;
                    ArrayList<SingleFlightTask> arrayList = new ArrayList(((SingleFlightCall) singleFlightCall).tasks);
                    if (str != null) {
                        synchronized (this) {
                            this.callInfo.remove(str);
                        }
                    }
                    for (SingleFlightTask singleFlightTask2 : arrayList) {
                        if (singleFlightTask2 != null && singleFlightTask2.completeHandler != null) {
                            throw ((SingleFlightCall) singleFlightCall).exception;
                        }
                    }
                }
            }
        }
    }
}
