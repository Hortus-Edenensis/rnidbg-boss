package com.qiniu.android.utils;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class GroupTaskThread extends Thread {
    public final GroupTaskCompleteHandler completeHandler;
    private ArrayList<GroupTask> tasks = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface GroupTaskCompleteHandler {
        void complete();
    }

    public GroupTaskThread(GroupTaskCompleteHandler groupTaskCompleteHandler) {
        this.completeHandler = groupTaskCompleteHandler;
    }

    private void completeAction() {
        GroupTaskCompleteHandler groupTaskCompleteHandler = this.completeHandler;
        if (groupTaskCompleteHandler != null) {
            groupTaskCompleteHandler.complete();
        }
    }

    private GroupTask getNextWaitingTask() {
        for (int i = 0; i < this.tasks.size(); i++) {
            GroupTask groupTask = this.tasks.get(i);
            if (groupTask.state == GroupTask.State.Waiting) {
                return groupTask;
            }
        }
        return null;
    }

    private boolean isAllTasksCompleted() {
        if (this.tasks.size() == 0) {
            return false;
        }
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).state != GroupTask.State.Complete) {
                return false;
            }
        }
        return true;
    }

    public void addTask(GroupTask groupTask) {
        synchronized (this) {
            if (!isAllTasksCompleted()) {
                this.tasks.add(groupTask);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean zIsAllTasksCompleted;
        super.run();
        while (!isInterrupted()) {
            synchronized (this) {
                zIsAllTasksCompleted = isAllTasksCompleted();
            }
            if (zIsAllTasksCompleted) {
                completeAction();
                return;
            }
            GroupTask nextWaitingTask = getNextWaitingTask();
            if (nextWaitingTask != null) {
                nextWaitingTask.state = GroupTask.State.Running;
                nextWaitingTask.run(nextWaitingTask);
            } else {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class GroupTask {
        public final String id;
        protected State state;

        /* JADX INFO: compiled from: SearchBox */
        public enum State {
            Waiting,
            Running,
            Complete
        }

        public GroupTask() {
            this.state = State.Waiting;
            this.id = null;
        }

        public abstract void run(GroupTask groupTask);

        public void taskComplete() {
            this.state = State.Complete;
        }

        public GroupTask(String str) {
            this.state = State.Waiting;
            this.id = str;
        }
    }
}
