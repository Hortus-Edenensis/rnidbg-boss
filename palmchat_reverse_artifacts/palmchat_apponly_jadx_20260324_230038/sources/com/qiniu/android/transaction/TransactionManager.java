package com.qiniu.android.transaction;

import com.qiniu.android.utils.Utils;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TransactionManager {
    private static final TransactionManager transactionManager = new TransactionManager();
    private Timer timer;
    protected final ConcurrentLinkedQueue<Transaction> transactionList = new ConcurrentLinkedQueue<>();
    protected long actionCount = 0;

    private TransactionManager() {
    }

    private synchronized void createTimer() {
        if (this.timer != null) {
            return;
        }
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.qiniu.android.transaction.TransactionManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                TransactionManager.this.timerAction();
            }
        }, 0L, 1000L);
    }

    public static TransactionManager getInstance() {
        return transactionManager;
    }

    private void handleAllTransaction() {
        for (Transaction transaction : this.transactionList) {
            handleTransaction(transaction);
            if (transaction.maybeCompleted()) {
                removeTransaction(transaction);
            }
        }
    }

    private void handleTransaction(Transaction transaction) {
        transaction.handleAction();
    }

    private void invalidateTimer() {
        this.timer.cancel();
        this.timer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timerAction() {
        this.actionCount++;
        handleAllTransaction();
    }

    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        this.transactionList.add(transaction);
        createTimer();
    }

    public synchronized void destroyResource() {
        invalidateTimer();
        this.transactionList.clear();
    }

    public boolean existTransactionsForName(String str) {
        String str2;
        for (Transaction transaction : this.transactionList) {
            if ((str == null && transaction.name == null) || ((str2 = transaction.name) != null && str2.equals(str))) {
                return true;
            }
        }
        return false;
    }

    public synchronized void performTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        if (!this.transactionList.contains(transaction)) {
            this.transactionList.add(transaction);
        }
        transaction.nextExecutionTime = Utils.currentSecondTimestamp();
    }

    public void removeTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        this.transactionList.remove(transaction);
    }

    public ArrayList<Transaction> transactionsForName(String str) {
        String str2;
        ArrayList<Transaction> arrayList = new ArrayList<>();
        for (Transaction transaction : this.transactionList) {
            if ((str == null && transaction.name == null) || ((str2 = transaction.name) != null && str2.equals(str))) {
                arrayList.add(transaction);
            }
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Transaction {
        private static final int TransactionTypeNormal = 0;
        private static final int TransactionTypeTime = 1;
        public final Runnable actionHandler;
        public final int after;
        private long createTime;
        protected long executedCount;
        private final int interval;
        private boolean isExecuting;
        public final String name;
        protected long nextExecutionTime;
        private final int type;

        public Transaction(String str, int i, Runnable runnable) {
            this.executedCount = 0L;
            this.isExecuting = false;
            this.type = 0;
            this.name = str;
            this.after = i;
            this.interval = 0;
            this.actionHandler = runnable;
            long jCurrentSecondTimestamp = Utils.currentSecondTimestamp();
            this.createTime = jCurrentSecondTimestamp;
            this.nextExecutionTime = jCurrentSecondTimestamp + ((long) i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void handleAction() {
            if (shouldAction()) {
                Runnable runnable = this.actionHandler;
                if (runnable != null) {
                    this.isExecuting = true;
                    this.executedCount++;
                    try {
                        runnable.run();
                    } catch (Exception unused) {
                    }
                    this.nextExecutionTime = Utils.currentSecondTimestamp() + ((long) this.interval);
                    this.isExecuting = false;
                }
            }
        }

        public boolean isExecuting() {
            return this.isExecuting;
        }

        public boolean maybeCompleted() {
            return this.type == 0 && this.executedCount > 0;
        }

        public boolean shouldAction() {
            long jCurrentSecondTimestamp = Utils.currentSecondTimestamp();
            int i = this.type;
            return i == 0 ? this.executedCount < 1 && jCurrentSecondTimestamp >= this.nextExecutionTime : i == 1 && jCurrentSecondTimestamp >= this.nextExecutionTime;
        }

        public Transaction(String str, int i, int i2, Runnable runnable) {
            this.executedCount = 0L;
            this.isExecuting = false;
            this.type = 1;
            this.name = str;
            this.after = i;
            this.interval = i2;
            this.actionHandler = runnable;
            long jCurrentSecondTimestamp = Utils.currentSecondTimestamp();
            this.createTime = jCurrentSecondTimestamp;
            this.nextExecutionTime = jCurrentSecondTimestamp + ((long) i);
        }
    }
}
