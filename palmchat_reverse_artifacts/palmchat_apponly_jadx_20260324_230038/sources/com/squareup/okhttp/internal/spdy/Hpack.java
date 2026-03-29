package com.squareup.okhttp.internal.spdy;

import com.alipay.sdk.m.x.d;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.refund.RefundData;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import kotlin.UByte;
import okhttp3.internal.http2.Header;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class Hpack {
    static final int INITIAL_CLIENT_TO_SERVER_HEADER_TABLE_LENGTH = 1262;
    static final int INITIAL_SERVER_TO_CLIENT_HEADER_TABLE_LENGTH = 1304;
    static final int PREFIX_5_BITS = 31;
    static final int PREFIX_6_BITS = 63;
    static final int PREFIX_7_BITS = 127;
    static final int PREFIX_8_BITS = 255;
    static final List<HeaderEntry> INITIAL_CLIENT_TO_SERVER_HEADER_TABLE = Arrays.asList(new HeaderEntry(Header.TARGET_SCHEME_UTF8, HttpHost.DEFAULT_SCHEME_NAME), new HeaderEntry(Header.TARGET_SCHEME_UTF8, BaseConstants.SCHEME_HTTPS), new HeaderEntry(":host", ""), new HeaderEntry(Header.TARGET_PATH_UTF8, "/"), new HeaderEntry(Header.TARGET_METHOD_UTF8, "GET"), new HeaderEntry("accept", ""), new HeaderEntry("accept-charset", ""), new HeaderEntry("accept-encoding", ""), new HeaderEntry("accept-language", ""), new HeaderEntry("cookie", ""), new HeaderEntry("if-modified-since", ""), new HeaderEntry("user-agent", ""), new HeaderEntry("referer", ""), new HeaderEntry("authorization", ""), new HeaderEntry("allow", ""), new HeaderEntry("cache-control", ""), new HeaderEntry("connection", ""), new HeaderEntry("content-length", ""), new HeaderEntry("content-type", ""), new HeaderEntry(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, ""), new HeaderEntry("expect", ""), new HeaderEntry("from", ""), new HeaderEntry("if-match", ""), new HeaderEntry("if-none-match", ""), new HeaderEntry("if-range", ""), new HeaderEntry("if-unmodified-since", ""), new HeaderEntry("max-forwards", ""), new HeaderEntry("proxy-authorization", ""), new HeaderEntry("range", ""), new HeaderEntry("via", ""));
    static final List<HeaderEntry> INITIAL_SERVER_TO_CLIENT_HEADER_TABLE = Arrays.asList(new HeaderEntry(Header.RESPONSE_STATUS_UTF8, "200"), new HeaderEntry("age", ""), new HeaderEntry("cache-control", ""), new HeaderEntry("content-length", ""), new HeaderEntry("content-type", ""), new HeaderEntry(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, ""), new HeaderEntry("etag", ""), new HeaderEntry(RefundData.TAG_CLOCK, ""), new HeaderEntry("last-modified", ""), new HeaderEntry("server", ""), new HeaderEntry("set-cookie", ""), new HeaderEntry("vary", ""), new HeaderEntry("via", ""), new HeaderEntry("access-control-allow-origin", ""), new HeaderEntry("accept-ranges", ""), new HeaderEntry("allow", ""), new HeaderEntry("connection", ""), new HeaderEntry("content-disposition", ""), new HeaderEntry("content-encoding", ""), new HeaderEntry("content-language", ""), new HeaderEntry("content-location", ""), new HeaderEntry("content-range", ""), new HeaderEntry("link", ""), new HeaderEntry("location", ""), new HeaderEntry("proxy-authenticate", ""), new HeaderEntry(d.w, ""), new HeaderEntry("retry-after", ""), new HeaderEntry("strict-transport-security", ""), new HeaderEntry("transfer-encoding", ""), new HeaderEntry("www-authenticate", ""));

    /* JADX INFO: compiled from: SearchBox */
    public static class HeaderEntry {
        private final String name;
        private final String value;

        public HeaderEntry(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public int length() {
            return this.name.length() + 32 + this.value.length();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Reader {
        private long bufferSize;
        private final List<HeaderEntry> headerTable;
        private final DataInputStream in;
        private final long maxBufferSize = 4096;
        private final BitSet referenceSet = new BitSet();
        private final List<String> emittedHeaders = new ArrayList();
        private long bytesLeft = 0;

        public Reader(DataInputStream dataInputStream, boolean z) {
            this.bufferSize = 0L;
            this.in = dataInputStream;
            if (z) {
                this.headerTable = new ArrayList(Hpack.INITIAL_SERVER_TO_CLIENT_HEADER_TABLE);
                this.bufferSize = 1304L;
            } else {
                this.headerTable = new ArrayList(Hpack.INITIAL_CLIENT_TO_SERVER_HEADER_TABLE);
                this.bufferSize = 1262L;
            }
        }

        private String getName(int i) {
            return this.headerTable.get(i).name;
        }

        private String getValue(int i) {
            return this.headerTable.get(i).value;
        }

        private void insertIntoHeaderTable(int i, HeaderEntry headerEntry) {
            int length = headerEntry.length();
            if (i != this.headerTable.size()) {
                length -= this.headerTable.get(i).length();
            }
            long j = length;
            if (j > 4096) {
                this.headerTable.clear();
                this.bufferSize = 0L;
                this.emittedHeaders.add(headerEntry.name);
                this.emittedHeaders.add(headerEntry.value);
                return;
            }
            while (this.bufferSize + j > 4096) {
                remove(0);
                i--;
            }
            if (i < 0) {
                this.headerTable.add(0, headerEntry);
                i = 0;
            } else if (i == this.headerTable.size()) {
                this.headerTable.add(i, headerEntry);
            } else {
                this.headerTable.set(i, headerEntry);
            }
            this.bufferSize += j;
            this.referenceSet.set(i);
        }

        private int readByte() throws IOException {
            this.bytesLeft--;
            return this.in.readByte() & UByte.MAX_VALUE;
        }

        private void readIndexedHeader(int i) {
            if (this.referenceSet.get(i)) {
                this.referenceSet.clear(i);
            } else {
                this.referenceSet.set(i);
            }
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
            insertIntoHeaderTable(this.headerTable.size(), new HeaderEntry(getName(i), readString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoHeaderTable(this.headerTable.size(), new HeaderEntry(readString(), readString()));
        }

        private void readLiteralHeaderWithSubstitutionIndexingIndexedName(int i) throws IOException {
            insertIntoHeaderTable(readInt(readByte(), 255), new HeaderEntry(getName(i), readString()));
        }

        private void readLiteralHeaderWithSubstitutionIndexingNewName() throws IOException {
            insertIntoHeaderTable(readInt(readByte(), 255), new HeaderEntry(readString(), readString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            String name = getName(i);
            String string = readString();
            this.emittedHeaders.add(name);
            this.emittedHeaders.add(string);
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            String string = readString();
            String string2 = readString();
            this.emittedHeaders.add(string);
            this.emittedHeaders.add(string2);
        }

        private void remove(int i) {
            this.bufferSize -= (long) this.headerTable.remove(i).length();
        }

        public void emitReferenceSet() {
            int iNextSetBit = this.referenceSet.nextSetBit(0);
            while (iNextSetBit != -1) {
                this.emittedHeaders.add(getName(iNextSetBit));
                this.emittedHeaders.add(getValue(iNextSetBit));
                iNextSetBit = this.referenceSet.nextSetBit(iNextSetBit + 1);
            }
        }

        public List<String> getAndReset() {
            ArrayList arrayList = new ArrayList(this.emittedHeaders);
            this.emittedHeaders.clear();
            return arrayList;
        }

        public void readHeaders(int i) throws IOException {
            this.bytesLeft += (long) i;
            while (this.bytesLeft > 0) {
                int i2 = readByte();
                if ((i2 & 128) != 0) {
                    readIndexedHeader(readInt(i2, 127));
                } else if (i2 == 96) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    int i3 = i2 & 224;
                    if (i3 == 96) {
                        readLiteralHeaderWithoutIndexingIndexedName(readInt(i2, 31) - 1);
                    } else if (i2 == 64) {
                        readLiteralHeaderWithIncrementalIndexingNewName();
                    } else if (i3 == 64) {
                        readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i2, 31) - 1);
                    } else if (i2 == 0) {
                        readLiteralHeaderWithSubstitutionIndexingNewName();
                    } else {
                        if ((i2 & 192) != 0) {
                            throw new AssertionError();
                        }
                        readLiteralHeaderWithSubstitutionIndexingIndexedName(readInt(i2, 63) - 1);
                    }
                }
            }
        }

        public int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = readByte();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        public String readString() throws IOException {
            int i = readInt(readByte(), 255);
            byte[] bArr = new byte[i];
            this.bytesLeft -= (long) i;
            this.in.readFully(bArr);
            return new String(bArr, "UTF-8");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Writer {
        private final OutputStream out;

        public Writer(OutputStream outputStream) {
            this.out = outputStream;
        }

        public void writeHeaders(List<String> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                this.out.write(96);
                writeString(list.get(i));
                writeString(list.get(i + 1));
            }
        }

        public void writeInt(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.out.write(i | i3);
                return;
            }
            this.out.write(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.write(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.write(i4);
        }

        public void writeString(String str) throws IOException {
            byte[] bytes = str.getBytes("UTF-8");
            writeInt(bytes.length, 255, 0);
            this.out.write(bytes);
        }
    }

    private Hpack() {
    }
}
