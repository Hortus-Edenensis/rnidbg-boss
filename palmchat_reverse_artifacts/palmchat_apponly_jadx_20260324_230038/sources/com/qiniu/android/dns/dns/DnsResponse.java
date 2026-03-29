package com.qiniu.android.dns.dns;

import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class DnsResponse extends DnsMessage {
    private int aa;
    private List<Record> additionalArray;
    private List<Record> answerArray;
    private List<Record> authorityArray;
    private int rCode;
    private byte[] recordData;
    private DnsRequest request;
    private String server;
    private int source;
    private long timestamp;

    /* JADX INFO: compiled from: SearchBox */
    public static class RecordName {
        private String name;
        private int skipLength;

        private RecordName() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class RecordResource {
        private final int count;
        private final int from;
        private int length;
        private final String name;
        private final List<Record> records;

        /* JADX INFO: Access modifiers changed from: private */
        public void addRecord(Record record) {
            if (record != null) {
                this.records.add(record);
            }
        }

        private RecordResource(String str, int i, int i2) {
            this.name = str;
            this.count = i;
            this.from = i2;
            this.length = 0;
            this.records = new ArrayList();
        }
    }

    public DnsResponse(String str, int i, DnsRequest dnsRequest, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new IOException("response data is empty");
        }
        this.server = str;
        this.source = i;
        this.request = dnsRequest;
        this.recordData = bArr;
        this.timestamp = new Date().getTime() / 1000;
        parse();
    }

    private RecordName getNameFrom(int i) throws IOException {
        StringBuilder sb = new StringBuilder();
        RecordName recordName = new RecordName();
        int i2 = 128;
        int recordDataInt8 = i;
        do {
            int recordDataInt82 = readRecordDataInt8(recordDataInt8);
            int i3 = recordDataInt82 & 192;
            if (i3 == 192) {
                if (recordName.skipLength < 1) {
                    recordName.skipLength = (recordDataInt8 + 2) - i;
                }
                recordDataInt8 = readRecordDataInt8(recordDataInt8 + 1) | ((recordDataInt82 & 63) << 8);
            } else {
                if (i3 > 0) {
                    return null;
                }
                recordDataInt8++;
                if (recordDataInt82 > 0) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    int i4 = recordDataInt8 + recordDataInt82;
                    sb.append(IDN.toUnicode(new String(Arrays.copyOfRange(this.recordData, recordDataInt8, i4))));
                    recordDataInt8 = i4;
                }
            }
            if (recordDataInt82 <= 0) {
                break;
            }
            i2--;
        } while (i2 > 0);
        recordName.name = sb.toString();
        if (recordName.skipLength < 1) {
            recordName.skipLength = recordDataInt8 - i;
        }
        return recordName;
    }

    private void parse() throws IOException {
        if (this.recordData.length < 12) {
            throw new IOException("response data too small");
        }
        parseHeader();
        int question = parseQuestion();
        RecordResource recordResource = new RecordResource("answer", readRecordDataInt16(6), question);
        parseResourceRecord(recordResource);
        this.answerArray = recordResource.records;
        int i = question + recordResource.length;
        RecordResource recordResource2 = new RecordResource("authority", readRecordDataInt16(8), i);
        parseResourceRecord(recordResource2);
        this.authorityArray = recordResource2.records;
        String str = "additional";
        RecordResource recordResource3 = new RecordResource(str, readRecordDataInt16(10), i + recordResource2.length);
        parseResourceRecord(recordResource3);
        this.additionalArray = recordResource3.records;
    }

    private void parseHeader() throws IOException {
        short recordDataInt16 = readRecordDataInt16(0);
        this.messageId = recordDataInt16;
        if (recordDataInt16 != this.request.messageId) {
            throw new IOException("question id error");
        }
        int recordDataInt8 = readRecordDataInt8(2);
        if ((readRecordDataInt8(2) & 128) == 0) {
            throw new IOException("not a response data");
        }
        this.opCode = (recordDataInt8 >> 3) & 7;
        this.aa = (recordDataInt8 >> 2) & 1;
        this.rd = recordDataInt8 & 1;
        int recordDataInt82 = readRecordDataInt8(3);
        this.ra = (recordDataInt82 >> 7) & 1;
        this.rCode = recordDataInt82 & 15;
    }

    private int parseQuestion() throws IOException {
        int i = 12;
        for (int recordDataInt16 = readRecordDataInt16(4); recordDataInt16 > 0; recordDataInt16--) {
            RecordName nameFrom = getNameFrom(i);
            if (nameFrom == null) {
                throw new IOException("read Question error");
            }
            i += nameFrom.skipLength + 4;
        }
        return i;
    }

    private void parseResourceRecord(RecordResource recordResource) throws IOException {
        int i = recordResource.from;
        for (int i2 = recordResource.count; i2 > 0; i2--) {
            RecordName nameFrom = getNameFrom(i);
            if (nameFrom == null) {
                throw new IOException("read " + recordResource.name + " error");
            }
            int i3 = i + nameFrom.skipLength;
            short recordDataInt16 = readRecordDataInt16(i3);
            int i4 = i3 + 2;
            short recordDataInt162 = readRecordDataInt16(i4);
            int i5 = i4 + 2;
            int recordDataInt32 = readRecordDataInt32(i5);
            int i6 = i5 + 4;
            short recordDataInt163 = readRecordDataInt16(i6);
            int i7 = i6 + 2;
            String data = readData(recordDataInt16, i7, recordDataInt163);
            if (recordDataInt162 == 1 && (recordDataInt16 == 5 || recordDataInt16 == this.request.getRecordType())) {
                recordResource.addRecord(new Record(data, recordDataInt16, recordDataInt32, this.timestamp, this.source, this.server));
            }
            i = i7 + recordDataInt163;
        }
        recordResource.length = i - recordResource.from;
    }

    private String readData(int i, int i2, int i3) throws IOException {
        if (i != 1) {
            if (i != 5) {
                if (i != 16) {
                    if (i == 28 && i3 == 16) {
                        StringBuilder sb = new StringBuilder();
                        int i4 = 0;
                        while (i4 < 16) {
                            sb.append(i4 > 0 ? ":" : "");
                            int i5 = i2 + i4;
                            sb.append(readRecordDataInt8(i5));
                            sb.append(readRecordDataInt8(i5 + 1));
                            i4 += 2;
                        }
                        return sb.toString();
                    }
                } else if (i3 > 0) {
                    int i6 = i3 + i2;
                    byte[] bArr = this.recordData;
                    if (i6 < bArr.length) {
                        return IDN.toUnicode(new String(Arrays.copyOfRange(bArr, i2, i6)));
                    }
                }
            } else if (i3 > 1) {
                return getNameFrom(i2).name;
            }
        } else if (i3 == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(readRecordDataInt8(i2));
            for (int i7 = 1; i7 < 4; i7++) {
                sb2.append(".");
                sb2.append(readRecordDataInt8(i2 + i7));
            }
            return sb2.toString();
        }
        return null;
    }

    private short readRecordDataInt16(int i) throws IOException {
        int i2 = i + 1;
        byte[] bArr = this.recordData;
        if (i2 < bArr.length) {
            return (short) (((bArr[i] & UByte.MAX_VALUE) << 8) + (bArr[i2] & UByte.MAX_VALUE));
        }
        throw new IOException("read response data out of range");
    }

    private int readRecordDataInt32(int i) throws IOException {
        int i2 = i + 3;
        byte[] bArr = this.recordData;
        if (i2 >= bArr.length) {
            throw new IOException("read response data out of range");
        }
        int i3 = (bArr[i] & UByte.MAX_VALUE) << 24;
        int i4 = (bArr[i + 1] & UByte.MAX_VALUE) << 16;
        return i3 + i4 + ((bArr[i + 2] & UByte.MAX_VALUE) << 8) + (bArr[i2] & UByte.MAX_VALUE);
    }

    private int readRecordDataInt8(int i) throws IOException {
        byte[] bArr = this.recordData;
        if (i < bArr.length) {
            return bArr[i] & UByte.MAX_VALUE;
        }
        throw new IOException("read response data out of range");
    }

    public int getAA() {
        return this.aa;
    }

    public List<Record> getAdditionalArray() {
        return this.additionalArray;
    }

    public List<Record> getAnswerArray() {
        return this.answerArray;
    }

    public List<Record> getAuthorityArray() {
        return this.authorityArray;
    }

    public int getRCode() {
        return this.rCode;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "{messageId:%d, rd:%d, ra:%d, aa:%d, rCode:%d, server:%s, request:%s, answerArray:%s, authorityArray:%s, additionalArray:%s}", Short.valueOf(this.messageId), Integer.valueOf(this.rd), Integer.valueOf(this.ra), Integer.valueOf(this.aa), Integer.valueOf(this.rCode), this.server, this.request, this.answerArray, this.authorityArray, this.additionalArray);
    }
}
