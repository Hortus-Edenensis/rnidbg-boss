package com.qiniu.android.dns.dns;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.IDN;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class DnsRequest extends DnsMessage {
    private final String host;
    private final int recordType;

    public DnsRequest(short s, int i, String str) {
        this(s, 0, 1, i, str);
    }

    public String getHost() {
        return this.host;
    }

    public int getRecordType() {
        return this.recordType;
    }

    public byte[] toDnsQuestionData() throws IOException {
        String str = this.host;
        if (str == null || str.length() == 0) {
            throw new IOException("host can not empty");
        }
        int i = this.opCode;
        if (i != 0 && i != 1 && i != 2 && i != 5) {
            throw new IOException("opCode is not valid");
        }
        int i2 = this.rd;
        if (i2 != 0 && i2 != 1) {
            throw new IOException("rd is not valid");
        }
        int i3 = this.recordType;
        if (i3 != 1 && i3 != 28 && i3 != 5 && i3 != 16) {
            throw new IOException("recordType is not valid");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(this.messageId);
        dataOutputStream.writeByte((this.opCode << 3) + this.rd);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(1);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        for (String str2 : this.host.split("[.。．｡]")) {
            if (str2.length() > 63) {
                throw new IOException("host part is too long");
            }
            byte[] bytes = IDN.toASCII(str2).getBytes();
            dataOutputStream.write(bytes.length);
            dataOutputStream.write(bytes, 0, bytes.length);
        }
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(this.recordType);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(1);
        return byteArrayOutputStream.toByteArray();
    }

    public DnsRequest(short s, int i, int i2, int i3, String str) {
        this.messageId = s;
        this.opCode = i;
        this.rd = i2;
        this.recordType = i3;
        this.host = str;
    }
}
