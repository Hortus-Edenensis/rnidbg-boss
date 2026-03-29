package com.squareup.okhttp.internal.http;

import com.baidu.mapapi.http.HttpClient;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class RawHeaders {
    private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() { // from class: com.squareup.okhttp.internal.http.RawHeaders.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };
    private int httpMinorVersion;
    private final List<String> namesAndValues;
    private String requestLine;
    private int responseCode;
    private String responseMessage;
    private String statusLine;

    public RawHeaders() {
        this.namesAndValues = new ArrayList(20);
        this.httpMinorVersion = 1;
        this.responseCode = -1;
    }

    private void addLenient(String str, String str2) {
        this.namesAndValues.add(str);
        this.namesAndValues.add(str2.trim());
    }

    public static RawHeaders fromBytes(InputStream inputStream) throws IOException {
        RawHeaders rawHeaders;
        do {
            rawHeaders = new RawHeaders();
            rawHeaders.setStatusLine(Util.readAsciiLine(inputStream));
            readHeaders(inputStream, rawHeaders);
        } while (rawHeaders.getResponseCode() == 100);
        return rawHeaders;
    }

    public static RawHeaders fromMultimap(Map<String, List<String>> map, boolean z) throws IOException {
        if (!z) {
            throw new UnsupportedOperationException();
        }
        RawHeaders rawHeaders = new RawHeaders();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    rawHeaders.addLenient(key, it.next());
                }
            } else if (!value.isEmpty()) {
                rawHeaders.setStatusLine(value.get(value.size() - 1));
            }
        }
        return rawHeaders;
    }

    public static RawHeaders fromNameValueBlock(List<String> list) throws IOException {
        if (list.size() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected name value block: " + list);
        }
        RawHeaders rawHeaders = new RawHeaders();
        String str = null;
        String str2 = null;
        for (int i = 0; i < list.size(); i += 2) {
            String str3 = list.get(i);
            String str4 = list.get(i + 1);
            int i2 = 0;
            while (i2 < str4.length()) {
                int iIndexOf = str4.indexOf(0, i2);
                if (iIndexOf == -1) {
                    iIndexOf = str4.length();
                }
                String strSubstring = str4.substring(i2, iIndexOf);
                if (Header.RESPONSE_STATUS_UTF8.equals(str3)) {
                    str = strSubstring;
                } else if (":version".equals(str3)) {
                    str2 = strSubstring;
                } else {
                    rawHeaders.namesAndValues.add(str3);
                    rawHeaders.namesAndValues.add(strSubstring);
                }
                i2 = iIndexOf + 1;
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        if (str2 == null) {
            throw new ProtocolException("Expected ':version' header not present");
        }
        rawHeaders.setStatusLine(str2 + " " + str);
        return rawHeaders;
    }

    public static void readHeaders(InputStream inputStream, RawHeaders rawHeaders) throws IOException {
        while (true) {
            String asciiLine = Util.readAsciiLine(inputStream);
            if (asciiLine.length() == 0) {
                return;
            } else {
                rawHeaders.addLine(asciiLine);
            }
        }
    }

    public void add(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("fieldname == null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("value == null");
        }
        if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
            addLenient(str, str2);
            return;
        }
        throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
    }

    public void addAll(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            add(str, it.next());
        }
    }

    public void addLine(String str) {
        int iIndexOf = str.indexOf(":", 1);
        if (iIndexOf != -1) {
            addLenient(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } else if (str.startsWith(":")) {
            addLenient("", str.substring(1));
        } else {
            addLenient("", str);
        }
    }

    public void addSpdyRequestHeaders(String str, String str2, String str3, String str4, String str5) {
        add(Header.TARGET_METHOD_UTF8, str);
        add(Header.TARGET_SCHEME_UTF8, str5);
        add(Header.TARGET_PATH_UTF8, str2);
        add(":version", str3);
        add(":host", str4);
    }

    public String get(String str) {
        for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                return this.namesAndValues.get(size + 1);
            }
        }
        return null;
    }

    public RawHeaders getAll(Set<String> set) {
        RawHeaders rawHeaders = new RawHeaders();
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            String str = this.namesAndValues.get(i);
            if (set.contains(str)) {
                rawHeaders.add(str, this.namesAndValues.get(i + 1));
            }
        }
        return rawHeaders;
    }

    public String getFieldName(int i) {
        int i2 = i * 2;
        if (i2 < 0 || i2 >= this.namesAndValues.size()) {
            return null;
        }
        return this.namesAndValues.get(i2);
    }

    public int getHttpMinorVersion() {
        int i = this.httpMinorVersion;
        if (i != -1) {
            return i;
        }
        return 1;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getStatusLine() {
        return this.statusLine;
    }

    public String getValue(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0 || i2 >= this.namesAndValues.size()) {
            return null;
        }
        return this.namesAndValues.get(i2);
    }

    public int length() {
        return this.namesAndValues.size() / 2;
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < length(); i++) {
            treeSet.add(getFieldName(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public void removeAll(String str) {
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            if (str.equalsIgnoreCase(this.namesAndValues.get(i))) {
                this.namesAndValues.remove(i);
                this.namesAndValues.remove(i);
            }
        }
    }

    public void set(String str, String str2) {
        removeAll(str);
        add(str, str2);
    }

    public void setRequestLine(String str) {
        this.requestLine = str.trim();
    }

    public void setStatusLine(String str) throws IOException {
        if (this.responseMessage != null) {
            throw new IllegalStateException("statusLine is already set");
        }
        boolean z = str.length() > 13;
        if (!str.startsWith("HTTP/1.") || str.length() < 12 || str.charAt(8) != ' ' || (z && str.charAt(12) != ' ')) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int iCharAt = str.charAt(7) - '0';
        if (iCharAt < 0 || iCharAt > 9) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i = Integer.parseInt(str.substring(9, 12));
            this.responseMessage = z ? str.substring(13) : "";
            this.responseCode = i;
            this.statusLine = str;
            this.httpMinorVersion = iCharAt;
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public byte[] toBytes() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(256);
        sb.append(this.requestLine);
        sb.append(HttpClient.NEWLINE);
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            sb.append(this.namesAndValues.get(i));
            sb.append(": ");
            sb.append(this.namesAndValues.get(i + 1));
            sb.append(HttpClient.NEWLINE);
        }
        sb.append(HttpClient.NEWLINE);
        return sb.toString().getBytes("ISO-8859-1");
    }

    public Map<String, List<String>> toMultimap(boolean z) {
        String str;
        TreeMap treeMap = new TreeMap(FIELD_NAME_COMPARATOR);
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            String str2 = this.namesAndValues.get(i);
            String str3 = this.namesAndValues.get(i + 1);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(str2);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(str3);
            treeMap.put(str2, Collections.unmodifiableList(arrayList));
        }
        if (!z || (str = this.statusLine) == null) {
            String str4 = this.requestLine;
            if (str4 != null) {
                treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str4)));
            }
        } else {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public List<String> toNameValueBlock() {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            String lowerCase = this.namesAndValues.get(i).toLowerCase(Locale.US);
            String str = this.namesAndValues.get(i + 1);
            if (!lowerCase.equals("connection") && !lowerCase.equals("host") && !lowerCase.equals("keep-alive") && !lowerCase.equals("proxy-connection") && !lowerCase.equals("transfer-encoding")) {
                if (hashSet.add(lowerCase)) {
                    arrayList.add(lowerCase);
                    arrayList.add(str);
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        if (lowerCase.equals(arrayList.get(i2))) {
                            int i3 = i2 + 1;
                            arrayList.set(i3, ((String) arrayList.get(i3)) + "\u0000" + str);
                            break;
                        }
                        i2 += 2;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<String> values(String str) {
        ArrayList arrayList = null;
        for (int i = 0; i < length(); i++) {
            if (str.equalsIgnoreCase(getFieldName(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(getValue(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public RawHeaders(RawHeaders rawHeaders) {
        ArrayList arrayList = new ArrayList(20);
        this.namesAndValues = arrayList;
        this.httpMinorVersion = 1;
        this.responseCode = -1;
        arrayList.addAll(rawHeaders.namesAndValues);
        this.requestLine = rawHeaders.requestLine;
        this.statusLine = rawHeaders.statusLine;
        this.httpMinorVersion = rawHeaders.httpMinorVersion;
        this.responseCode = rawHeaders.responseCode;
        this.responseMessage = rawHeaders.responseMessage;
    }
}
