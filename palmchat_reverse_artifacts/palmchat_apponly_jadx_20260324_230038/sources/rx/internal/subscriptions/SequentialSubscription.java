package rx.internal.subscriptions;

import defpackage.cn5;
import defpackage.zm5;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class SequentialSubscription extends AtomicReference<zm5> implements zm5 {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public zm5 current() {
        zm5 zm5Var = (zm5) super.get();
        return zm5Var == Unsubscribed.INSTANCE ? cn5.c() : zm5Var;
    }

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }

    public boolean replace(zm5 zm5Var) {
        zm5 zm5Var2;
        do {
            zm5Var2 = get();
            if (zm5Var2 == Unsubscribed.INSTANCE) {
                if (zm5Var == null) {
                    return false;
                }
                zm5Var.unsubscribe();
                return false;
            }
        } while (!compareAndSet(zm5Var2, zm5Var));
        return true;
    }

    public boolean replaceWeak(zm5 zm5Var) {
        zm5 zm5Var2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (zm5Var2 == unsubscribed) {
            if (zm5Var != null) {
                zm5Var.unsubscribe();
            }
            return false;
        }
        if (compareAndSet(zm5Var2, zm5Var) || get() != unsubscribed) {
            return true;
        }
        if (zm5Var != null) {
            zm5Var.unsubscribe();
        }
        return false;
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
        zm5 andSet;
        zm5 zm5Var = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (zm5Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == unsubscribed) {
            return;
        }
        andSet.unsubscribe();
    }

    public boolean update(zm5 zm5Var) {
        zm5 zm5Var2;
        do {
            zm5Var2 = get();
            if (zm5Var2 == Unsubscribed.INSTANCE) {
                if (zm5Var == null) {
                    return false;
                }
                zm5Var.unsubscribe();
                return false;
            }
        } while (!compareAndSet(zm5Var2, zm5Var));
        if (zm5Var2 == null) {
            return true;
        }
        zm5Var2.unsubscribe();
        return true;
    }

    public boolean updateWeak(zm5 zm5Var) {
        zm5 zm5Var2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (zm5Var2 == unsubscribed) {
            if (zm5Var != null) {
                zm5Var.unsubscribe();
            }
            return false;
        }
        if (compareAndSet(zm5Var2, zm5Var)) {
            return true;
        }
        zm5 zm5Var3 = get();
        if (zm5Var != null) {
            zm5Var.unsubscribe();
        }
        return zm5Var3 == unsubscribed;
    }

    public SequentialSubscription(zm5 zm5Var) {
        lazySet(zm5Var);
    }
}
