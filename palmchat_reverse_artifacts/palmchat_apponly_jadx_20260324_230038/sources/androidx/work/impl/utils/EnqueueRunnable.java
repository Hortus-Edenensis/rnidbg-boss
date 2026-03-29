package androidx.work.impl.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation = new OperationImpl();
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    private static boolean enqueueContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        boolean zEnqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return zEnqueueWorkWithPrerequisites;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a4 A[LOOP:6: B:111:0x019e->B:113:0x01a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca A[PHI: r1 r9 r12 r13 r14
      0x00ca: PHI (r1v1 java.lang.String[]) = (r1v0 java.lang.String[]), (r1v0 java.lang.String[]), (r1v4 java.lang.String[]), (r1v4 java.lang.String[]) binds: [B:32:0x006c, B:34:0x007a, B:57:0x00c9, B:56:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r9v2 boolean) = (r9v1 boolean), (r9v1 boolean), (r9v5 boolean), (r9v6 boolean) binds: [B:32:0x006c, B:34:0x007a, B:57:0x00c9, B:56:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r12v2 boolean) = (r12v1 boolean), (r12v1 boolean), (r12v4 boolean), (r12v4 boolean) binds: [B:32:0x006c, B:34:0x007a, B:57:0x00c9, B:56:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r13v2 boolean) = (r13v1 boolean), (r13v1 boolean), (r13v4 boolean), (r13v4 boolean) binds: [B:32:0x006c, B:34:0x007a, B:57:0x00c9, B:56:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r14v2 boolean) = (r14v1 boolean), (r14v1 boolean), (r14v4 boolean), (r14v4 boolean) binds: [B:32:0x006c, B:34:0x007a, B:57:0x00c9, B:56:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl workManagerImpl, @NonNull List<? extends WorkRequest> list, String[] strArr, String str, ExistingWorkPolicy existingWorkPolicy) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        int i;
        Iterator<String> it;
        String[] strArr2 = strArr;
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        boolean z5 = strArr2 != null && strArr2.length > 0;
        if (z5) {
            z = true;
            z2 = false;
            z3 = false;
            for (String str2 : strArr2) {
                WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(str2);
                if (workSpec == null) {
                    Logger.get().error(TAG, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                WorkInfo.State state = workSpec.state;
                z &= state == WorkInfo.State.SUCCEEDED;
                if (state == WorkInfo.State.FAILED) {
                    z2 = true;
                } else if (state == WorkInfo.State.CANCELLED) {
                    z3 = true;
                }
            }
        } else {
            z = true;
            z2 = false;
            z3 = false;
        }
        boolean z6 = !TextUtils.isEmpty(str);
        if (z6 && !z5) {
            List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workDatabase.workSpecDao().getWorkSpecIdAndStatesForName(str);
            if (workSpecIdAndStatesForName.isEmpty()) {
                z4 = false;
            } else if (existingWorkPolicy == ExistingWorkPolicy.APPEND) {
                DependencyDao dependencyDao = workDatabase.dependencyDao();
                ArrayList arrayList = new ArrayList();
                for (WorkSpec.IdAndState idAndState : workSpecIdAndStatesForName) {
                    if (!dependencyDao.hasDependents(idAndState.id)) {
                        WorkInfo.State state2 = idAndState.state;
                        boolean z7 = (state2 == WorkInfo.State.SUCCEEDED) & z;
                        if (state2 == WorkInfo.State.FAILED) {
                            z2 = true;
                        } else if (state2 == WorkInfo.State.CANCELLED) {
                            z3 = true;
                        }
                        arrayList.add(idAndState.id);
                        z = z7;
                    }
                }
                strArr2 = (String[]) arrayList.toArray(strArr2);
                z5 = strArr2.length > 0;
                z4 = false;
            } else {
                if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                    Iterator<WorkSpec.IdAndState> it2 = workSpecIdAndStatesForName.iterator();
                    while (it2.hasNext()) {
                        WorkInfo.State state3 = it2.next().state;
                        if (state3 == WorkInfo.State.ENQUEUED || state3 == WorkInfo.State.RUNNING) {
                            return false;
                        }
                    }
                }
                CancelWorkRunnable.forName(str, workManagerImpl, false).run();
                WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                Iterator<WorkSpec.IdAndState> it3 = workSpecIdAndStatesForName.iterator();
                while (it3.hasNext()) {
                    workSpecDao.delete(it3.next().id);
                }
                z4 = true;
            }
        }
        for (WorkRequest workRequest : list) {
            WorkSpec workSpec2 = workRequest.getWorkSpec();
            if (!z5 || z) {
                if (workSpec2.isPeriodic()) {
                    j = jCurrentTimeMillis;
                    workSpec2.periodStartTime = 0L;
                    i = Build.VERSION.SDK_INT;
                    if (i < 23 && i <= 25) {
                        tryDelegateConstrainedWorkSpec(workSpec2);
                    } else if (i <= 22 && usesScheduler(workManagerImpl, Schedulers.GCM_SCHEDULER)) {
                        tryDelegateConstrainedWorkSpec(workSpec2);
                    }
                    if (workSpec2.state == WorkInfo.State.ENQUEUED) {
                        z4 = true;
                    }
                    workDatabase.workSpecDao().insertWorkSpec(workSpec2);
                    if (z5) {
                        for (String str3 : strArr2) {
                            workDatabase.dependencyDao().insertDependency(new Dependency(workRequest.getStringId(), str3));
                        }
                    }
                    it = workRequest.getTags().iterator();
                    while (it.hasNext()) {
                        workDatabase.workTagDao().insert(new WorkTag(it.next(), workRequest.getStringId()));
                    }
                    if (!z6) {
                        workDatabase.workNameDao().insert(new WorkName(str, workRequest.getStringId()));
                    }
                    jCurrentTimeMillis = j;
                } else {
                    workSpec2.periodStartTime = jCurrentTimeMillis;
                }
            } else if (z2) {
                workSpec2.state = WorkInfo.State.FAILED;
            } else if (z3) {
                workSpec2.state = WorkInfo.State.CANCELLED;
            } else {
                workSpec2.state = WorkInfo.State.BLOCKED;
            }
            j = jCurrentTimeMillis;
            i = Build.VERSION.SDK_INT;
            if (i < 23) {
                if (i <= 22) {
                    tryDelegateConstrainedWorkSpec(workSpec2);
                }
            }
            if (workSpec2.state == WorkInfo.State.ENQUEUED) {
            }
            workDatabase.workSpecDao().insertWorkSpec(workSpec2);
            if (z5) {
            }
            it = workRequest.getTags().iterator();
            while (it.hasNext()) {
            }
            if (!z6) {
            }
            jCurrentTimeMillis = j;
        }
        return z4;
    }

    private static boolean processContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            boolean zProcessContinuation = false;
            for (WorkContinuationImpl workContinuationImpl2 : parents) {
                if (workContinuationImpl2.isEnqueued()) {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", workContinuationImpl2.getIds())), new Throwable[0]);
                } else {
                    zProcessContinuation |= processContinuation(workContinuationImpl2);
                }
            }
            z = zProcessContinuation;
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            String str = workSpec.workerClassName;
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    private static boolean usesScheduler(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator<Scheduler> it = workManagerImpl.getSchedulers().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next().getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    @VisibleForTesting
    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean zProcessContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return zProcessContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mWorkContinuation.hasCycles()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.mWorkContinuation));
            }
            if (addToDatabase()) {
                PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                scheduleWorkInBackground();
            }
            this.mOperation.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    @VisibleForTesting
    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
