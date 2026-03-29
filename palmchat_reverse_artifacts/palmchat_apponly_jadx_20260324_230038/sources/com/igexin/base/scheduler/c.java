package com.igexin.base.scheduler;

import com.igexin.base.scheduler.BaseTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface c<T extends BaseTask> {
    void execute(T t);

    void submit(T t);
}
