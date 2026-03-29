package defpackage;

import cn.jiguang.sdk.impl.dnssrv.Name;
import cn.jiguang.sdk.impl.dnssrv.RRset;
import cn.jiguang.sdk.impl.dnssrv.Record;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class un3 implements Cloneable {
    public static Record[] d = new Record[0];
    public static RRset[] e = new RRset[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wg2 f21247a;
    public List[] b;
    public int c;

    public un3(wg2 wg2Var) {
        this.b = new List[4];
        this.f21247a = wg2Var;
    }

    public static un3 f(Record record) {
        un3 un3Var = new un3();
        un3Var.a(record, 0);
        return un3Var;
    }

    public static boolean g(Record record, Record record2) {
        return record.getRRsetType() == record2.getRRsetType() && record.getDClass() == record2.getDClass() && record.getName().equals(record2.getName());
    }

    public void a(Record record, int i) {
        List[] listArr = this.b;
        if (listArr[i] == null) {
            listArr[i] = new LinkedList();
        }
        this.f21247a.f(i);
        this.b[i].add(record);
    }

    public Record c() {
        List list = this.b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (Record) list.get(0);
    }

    public Object clone() {
        un3 un3Var = new un3();
        int i = 0;
        while (true) {
            List[] listArr = this.b;
            if (i >= listArr.length) {
                un3Var.f21247a = (wg2) this.f21247a.clone();
                un3Var.c = this.c;
                return un3Var;
            }
            if (listArr[i] != null) {
                un3Var.b[i] = new LinkedList(this.b[i]);
            }
            i++;
        }
    }

    public Record[] d(int i) {
        List list = this.b[i];
        return list == null ? d : (Record[]) list.toArray(new Record[list.size()]);
    }

    public RRset[] e(int i) {
        if (this.b[i] == null) {
            return e;
        }
        LinkedList linkedList = new LinkedList();
        Record[] recordArrD = d(i);
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < recordArrD.length; i2++) {
            Name name = recordArrD[i2].getName();
            boolean z = true;
            if (hashSet.contains(name)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    RRset rRset = (RRset) linkedList.get(size);
                    if (rRset.getType() == recordArrD[i2].getRRsetType() && rRset.getDClass() == recordArrD[i2].getDClass() && rRset.getName().equals(name)) {
                        rRset.addRR(recordArrD[i2]);
                        z = false;
                        break;
                    }
                    size--;
                }
            }
            if (z) {
                linkedList.add(new RRset(recordArrD[i2]));
                hashSet.add(name);
            }
        }
        return (RRset[]) linkedList.toArray(new RRset[linkedList.size()]);
    }

    public final int h(nt0 nt0Var, int i, vk0 vk0Var, int i2) {
        int size = this.b[i].size();
        int iB = nt0Var.b();
        Record record = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Record record2 = (Record) this.b[i].get(i5);
            if (i == 3) {
                i3++;
            } else {
                if (record != null && !g(record2, record)) {
                    iB = nt0Var.b();
                    i4 = i5;
                }
                record2.toWire(nt0Var, i, vk0Var);
                if (nt0Var.b() > i2) {
                    nt0Var.c(iB);
                    return (size - i4) + i3;
                }
                record = record2;
            }
        }
        return i3;
    }

    public final boolean i(nt0 nt0Var, int i) {
        if (i < 12) {
            return false;
        }
        nt0Var.b();
        this.f21247a.j(nt0Var);
        vk0 vk0Var = new vk0();
        this.f21247a.c();
        for (int i2 = 0; i2 < 4; i2++) {
            if (this.b[i2] != null) {
                h(nt0Var, i2, vk0Var, i);
            }
        }
        return true;
    }

    public byte[] j(int i) {
        nt0 nt0Var = new nt0();
        i(nt0Var, i);
        this.c = nt0Var.b();
        return nt0Var.e();
    }

    public un3() {
        this(new wg2());
    }

    public un3(lt0 lt0Var) throws IOException {
        this(new wg2(lt0Var));
        for (int i = 0; i < 4; i++) {
            int iA = this.f21247a.a(i);
            if (iA > 0) {
                this.b[i] = new ArrayList(iA);
            }
            for (int i2 = 0; i2 < iA; i2++) {
                this.b[i].add(Record.fromWire(lt0Var, i));
            }
        }
        this.c = lt0Var.b();
    }

    public un3(byte[] bArr) throws IOException {
        this(new lt0(bArr));
    }
}
