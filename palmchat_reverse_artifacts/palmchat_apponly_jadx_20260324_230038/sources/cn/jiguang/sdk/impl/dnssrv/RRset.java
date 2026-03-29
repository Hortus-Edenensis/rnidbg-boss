package cn.jiguang.sdk.impl.dnssrv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class RRset implements Serializable {
    private static final long serialVersionUID = -3270249290171239695L;
    private short nsigs;
    private short position;
    private List rrs;

    public RRset() {
        this.rrs = new ArrayList(1);
        this.nsigs = (short) 0;
        this.position = (short) 0;
    }

    private synchronized Iterator iterator(boolean z, boolean z2) {
        int i;
        int size = this.rrs.size();
        int i2 = z ? size - this.nsigs : this.nsigs;
        if (i2 == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z) {
            i = size - this.nsigs;
        } else if (z2) {
            if (this.position >= i2) {
                this.position = (short) 0;
            }
            i = this.position;
            this.position = (short) (i + 1);
        } else {
            i = 0;
        }
        ArrayList arrayList = new ArrayList(i2);
        if (z) {
            arrayList.addAll(this.rrs.subList(i, i2));
            if (i != 0) {
                arrayList.addAll(this.rrs.subList(0, i));
            }
        } else {
            arrayList.addAll(this.rrs.subList(i, size));
        }
        return arrayList.iterator();
    }

    private String iteratorToString(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            Record record = (Record) it.next();
            stringBuffer.append("[");
            stringBuffer.append(record.rdataToString());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private void safeAddRR(Record record) {
        if (this.nsigs == 0) {
            this.rrs.add(record);
        } else {
            List list = this.rrs;
            list.add(list.size() - this.nsigs, record);
        }
    }

    public synchronized void addRR(Record record) {
        if (this.rrs.size() == 0) {
            safeAddRR(record);
            return;
        }
        Record recordFirst = first();
        if (!record.sameRRset(recordFirst)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (record.getTTL() != recordFirst.getTTL()) {
            if (record.getTTL() > recordFirst.getTTL()) {
                record = record.cloneRecord();
                record.setTTL(recordFirst.getTTL());
            } else {
                for (int i = 0; i < this.rrs.size(); i++) {
                    Record recordCloneRecord = ((Record) this.rrs.get(i)).cloneRecord();
                    recordCloneRecord.setTTL(record.getTTL());
                    this.rrs.set(i, recordCloneRecord);
                }
            }
        }
        if (!this.rrs.contains(record)) {
            safeAddRR(record);
        }
    }

    public synchronized void clear() {
        this.rrs.clear();
        this.position = (short) 0;
        this.nsigs = (short) 0;
    }

    public synchronized void deleteRR(Record record) {
        if (this.rrs.remove(record)) {
            this.nsigs = (short) (this.nsigs - 1);
        }
    }

    public synchronized Record first() {
        if (this.rrs.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (Record) this.rrs.get(0);
    }

    public int getDClass() {
        return first().getDClass();
    }

    public Name getName() {
        return first().getName();
    }

    public synchronized long getTTL() {
        return first().getTTL();
    }

    public int getType() {
        return first().getRRsetType();
    }

    public synchronized Iterator rrs(boolean z) {
        return iterator(true, z);
    }

    public synchronized Iterator sigs() {
        return iterator(false, false);
    }

    public synchronized int size() {
        return this.rrs.size() - this.nsigs;
    }

    public String toString() {
        if (this.rrs.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(getName() + " ");
        stringBuffer.append(getTTL() + " ");
        stringBuffer.append(iteratorToString(iterator(true, false)));
        if (this.nsigs > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(iteratorToString(iterator(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }

    public synchronized Iterator rrs() {
        return iterator(true, true);
    }

    public RRset(Record record) {
        this();
        safeAddRR(record);
    }

    public RRset(RRset rRset) {
        synchronized (rRset) {
            this.rrs = (List) ((ArrayList) rRset.rrs).clone();
            this.nsigs = rRset.nsigs;
            this.position = rRset.position;
        }
    }
}
