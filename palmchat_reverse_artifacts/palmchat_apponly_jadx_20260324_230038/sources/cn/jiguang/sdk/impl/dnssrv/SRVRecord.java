package cn.jiguang.sdk.impl.dnssrv;

import com.qiniu.android.collect.ReportItem;
import com.umeng.ccg.a;
import defpackage.lt0;
import defpackage.nt0;
import defpackage.vk0;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class SRVRecord extends Record {
    private static final long serialVersionUID = -3886460132387522052L;
    private int port;
    private int priority;
    private Name target;
    private int weight;

    public SRVRecord() {
    }

    public Name getAdditionalName() {
        return this.target;
    }

    @Override // cn.jiguang.sdk.impl.dnssrv.Record
    public Record getObject() {
        return new SRVRecord();
    }

    public int getPort() {
        return this.port;
    }

    public int getPriority() {
        return this.priority;
    }

    public Name getTarget() {
        return this.target;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override // cn.jiguang.sdk.impl.dnssrv.Record
    public void rrFromWire(lt0 lt0Var) throws IOException {
        this.priority = lt0Var.e();
        this.weight = lt0Var.e();
        this.port = lt0Var.e();
        this.target = new Name(lt0Var);
    }

    @Override // cn.jiguang.sdk.impl.dnssrv.Record
    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.priority + " ");
        stringBuffer.append(this.weight + " ");
        stringBuffer.append(this.port + " ");
        stringBuffer.append(this.target);
        return stringBuffer.toString();
    }

    @Override // cn.jiguang.sdk.impl.dnssrv.Record
    public void rrToWire(nt0 nt0Var, vk0 vk0Var, boolean z) {
        nt0Var.h(this.priority);
        nt0Var.h(this.weight);
        nt0Var.h(this.port);
        this.target.toWire(nt0Var, null, z);
    }

    public SRVRecord(Name name, int i, long j, int i2, int i3, int i4, Name name2) {
        super(name, 33, i, j);
        this.priority = Record.checkU16("priority", i2);
        this.weight = Record.checkU16("weight", i3);
        this.port = Record.checkU16(ReportItem.RequestKeyPort, i4);
        this.target = Record.checkName(a.F, name2);
    }
}
