package org.junit.runner;

import defpackage.dz4;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class Result implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(c.class).getFields();
    private static final long serialVersionUID = 1;
    private final AtomicInteger count;
    private final CopyOnWriteArrayList<Failure> failures;
    private final AtomicInteger ignoreCount;
    private final AtomicLong runTime;
    private c serializedForm;
    private final AtomicLong startTime;

    /* JADX INFO: compiled from: SearchBox */
    @dz4.a
    public class b extends dz4 {
        public b() {
        }
    }

    public Result() {
        this.count = new AtomicInteger();
        this.ignoreCount = new AtomicInteger();
        this.failures = new CopyOnWriteArrayList<>();
        this.runTime = new AtomicLong();
        this.startTime = new AtomicLong();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.serializedForm = c.f(objectInputStream);
    }

    private Object readResolve() {
        return new Result(this.serializedForm);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        new c(this).g(objectOutputStream);
    }

    public dz4 createListener() {
        return new b();
    }

    public int getFailureCount() {
        return this.failures.size();
    }

    public List<Failure> getFailures() {
        return this.failures;
    }

    public int getIgnoreCount() {
        return this.ignoreCount.get();
    }

    public int getRunCount() {
        return this.count.get();
    }

    public long getRunTime() {
        return this.runTime.get();
    }

    public boolean wasSuccessful() {
        return getFailureCount() == 0;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f19858a;
        public final AtomicInteger b;
        public final List<Failure> c;
        public final long d;
        public final long e;

        public c(Result result) {
            this.f19858a = result.count;
            this.b = result.ignoreCount;
            this.c = Collections.synchronizedList(new ArrayList(result.failures));
            this.d = result.runTime.longValue();
            this.e = result.startTime.longValue();
        }

        public static c f(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            return new c(objectInputStream.readFields());
        }

        public void g(ObjectOutputStream objectOutputStream) throws IOException {
            ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
            putFieldPutFields.put("fCount", this.f19858a);
            putFieldPutFields.put("fIgnoreCount", this.b);
            putFieldPutFields.put("fFailures", this.c);
            putFieldPutFields.put("fRunTime", this.d);
            putFieldPutFields.put("fStartTime", this.e);
            objectOutputStream.writeFields();
        }

        public c(ObjectInputStream.GetField getField) throws IOException {
            this.f19858a = (AtomicInteger) getField.get("fCount", (Object) null);
            this.b = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.c = (List) getField.get("fFailures", (Object) null);
            this.d = getField.get("fRunTime", 0L);
            this.e = getField.get("fStartTime", 0L);
        }
    }

    private Result(c cVar) {
        this.count = cVar.f19858a;
        this.ignoreCount = cVar.b;
        this.failures = new CopyOnWriteArrayList<>(cVar.c);
        this.runTime = new AtomicLong(cVar.d);
        this.startTime = new AtomicLong(cVar.e);
    }
}
