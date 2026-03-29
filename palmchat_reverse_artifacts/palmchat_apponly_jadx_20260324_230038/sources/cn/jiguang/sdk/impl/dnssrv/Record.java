package cn.jiguang.sdk.impl.dnssrv;

import defpackage.lt0;
import defpackage.nt0;
import defpackage.vk0;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class Record implements Cloneable, Comparable, Serializable {
    private static final DecimalFormat byteFormat;
    private static final long serialVersionUID = 2694906050116005466L;
    protected int dclass;
    protected Name name;
    protected long ttl;
    protected int type;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public Record() {
    }

    public static Name checkName(String str, Name name) {
        if (name.isAbsolute()) {
            return name;
        }
        throw new RelativeNameException(name);
    }

    public static int checkU16(String str, int i) {
        if (i >= 0 && i <= 65535) {
            return i;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i + " must be an unsigned 16 bit value");
    }

    public static Record fromWire(lt0 lt0Var, int i) throws IOException {
        Name name = new Name(lt0Var);
        int iE = lt0Var.e();
        int iE2 = lt0Var.e();
        return i == 0 ? newRecord(name, iE, iE2) : newRecord(name, iE, iE2, lt0Var.f(), lt0Var.e(), lt0Var);
    }

    private static final Record getEmptyRecord(Name name, int i, int i2, long j, boolean z) {
        SRVRecord sRVRecord = new SRVRecord();
        sRVRecord.name = name;
        sRVRecord.type = i;
        sRVRecord.dclass = i2;
        sRVRecord.ttl = j;
        return sRVRecord;
    }

    private static Record newRecord(Name name, int i, int i2, long j, int i3, lt0 lt0Var) throws IOException {
        Record emptyRecord = getEmptyRecord(name, i, i2, j, lt0Var != null);
        if (lt0Var != null) {
            if (lt0Var.h() < i3) {
                throw new IOException("truncated record");
            }
            lt0Var.l(i3);
            emptyRecord.rrFromWire(lt0Var);
            if (lt0Var.h() > 0) {
                throw new IOException("invalid record length");
            }
            lt0Var.a();
        }
        return emptyRecord;
    }

    private void toWireCanonical(nt0 nt0Var, boolean z) {
        this.name.toWireCanonical(nt0Var);
        nt0Var.h(this.type);
        nt0Var.h(this.dclass);
        if (z) {
            nt0Var.j(0L);
        } else {
            nt0Var.j(this.ttl);
        }
        int iB = nt0Var.b();
        nt0Var.h(0);
        rrToWire(nt0Var, null, true);
        nt0Var.i((nt0Var.b() - iB) - 2, iB);
    }

    public Record cloneRecord() {
        try {
            return (Record) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Record record = (Record) obj;
        if (this == record) {
            return 0;
        }
        int iCompareTo = this.name.compareTo(record.name);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.dclass - record.dclass;
        if (i != 0) {
            return i;
        }
        int i2 = this.type - record.type;
        if (i2 != 0) {
            return i2;
        }
        byte[] bArrRdataToWireCanonical = rdataToWireCanonical();
        byte[] bArrRdataToWireCanonical2 = record.rdataToWireCanonical();
        for (int i3 = 0; i3 < bArrRdataToWireCanonical.length && i3 < bArrRdataToWireCanonical2.length; i3++) {
            int i4 = (bArrRdataToWireCanonical[i3] & UByte.MAX_VALUE) - (bArrRdataToWireCanonical2[i3] & UByte.MAX_VALUE);
            if (i4 != 0) {
                return i4;
            }
        }
        return bArrRdataToWireCanonical.length - bArrRdataToWireCanonical2.length;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Record)) {
            Record record = (Record) obj;
            if (this.type == record.type && this.dclass == record.dclass && this.name.equals(record.name)) {
                return Arrays.equals(rdataToWireCanonical(), record.rdataToWireCanonical());
            }
        }
        return false;
    }

    public int getDClass() {
        return this.dclass;
    }

    public Name getName() {
        return this.name;
    }

    public abstract Record getObject();

    public int getRRsetType() {
        return this.type;
    }

    public long getTTL() {
        return this.ttl;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = 0;
        for (byte b : toWireCanonical(true)) {
            i += (i << 3) + (b & UByte.MAX_VALUE);
        }
        return i;
    }

    public String rdataToString() {
        return rrToString();
    }

    public byte[] rdataToWireCanonical() {
        nt0 nt0Var = new nt0();
        rrToWire(nt0Var, null, true);
        return nt0Var.e();
    }

    public abstract void rrFromWire(lt0 lt0Var) throws IOException;

    public abstract String rrToString();

    public abstract void rrToWire(nt0 nt0Var, vk0 vk0Var, boolean z);

    public boolean sameRRset(Record record) {
        return getRRsetType() == record.getRRsetType() && this.dclass == record.dclass && this.name.equals(record.name);
    }

    public void setTTL(long j) {
        this.ttl = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String strRrToString = rrToString();
        if (!strRrToString.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(strRrToString);
        }
        return stringBuffer.toString();
    }

    public void toWire(nt0 nt0Var, int i, vk0 vk0Var) {
        this.name.toWire(nt0Var, vk0Var);
        nt0Var.h(this.type);
        nt0Var.h(this.dclass);
    }

    public Record(Name name, int i, int i2, long j) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        this.name = name;
        this.type = i;
        this.dclass = i2;
        this.ttl = j;
    }

    public byte[] toWire(int i) {
        nt0 nt0Var = new nt0();
        toWire(nt0Var, i, null);
        return nt0Var.e();
    }

    public static Record fromWire(byte[] bArr, int i) throws IOException {
        return fromWire(new lt0(bArr), i);
    }

    public static Record newRecord(Name name, int i, int i2, long j, int i3, byte[] bArr) {
        if (name.isAbsolute()) {
            try {
                return newRecord(name, i, i2, j, i3, bArr != null ? new lt0(bArr) : null);
            } catch (IOException unused) {
                return null;
            }
        }
        throw new RelativeNameException(name);
    }

    private byte[] toWireCanonical(boolean z) {
        nt0 nt0Var = new nt0();
        toWireCanonical(nt0Var, z);
        return nt0Var.e();
    }

    public static Record newRecord(Name name, int i, int i2, long j, byte[] bArr) {
        return newRecord(name, i, i2, j, bArr.length, bArr);
    }

    public static Record newRecord(Name name, int i, int i2, long j) {
        if (name.isAbsolute()) {
            return getEmptyRecord(name, i, i2, j, false);
        }
        throw new RelativeNameException(name);
    }

    public static Record newRecord(Name name, int i, int i2) {
        return newRecord(name, i, i2, 0L);
    }
}
