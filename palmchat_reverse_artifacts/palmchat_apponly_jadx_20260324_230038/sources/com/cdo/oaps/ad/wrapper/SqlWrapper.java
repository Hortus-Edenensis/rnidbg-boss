package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SqlWrapper extends BaseWrapper {
    public static final String KEY_DATA = "bkd";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5463a = "bkd_md5";
    private static final String c = "sql_rs";

    public SqlWrapper(Map<String, Object> map) {
        super(map);
    }

    public static SqlWrapper wrapper(Map<String, Object> map) {
        return new SqlWrapper(map);
    }

    public byte[] getData() {
        try {
            return (byte[]) get(KEY_DATA);
        } catch (ag unused) {
            return null;
        }
    }

    public String getDataMd5() {
        try {
            return (String) get(f5463a);
        } catch (ag unused) {
            return "";
        }
    }

    public String getResult() {
        try {
            return (String) get(c);
        } catch (ag unused) {
            return "";
        }
    }

    public SqlWrapper setData(byte[] bArr) {
        return (SqlWrapper) set(KEY_DATA, bArr);
    }

    public SqlWrapper setDataMd5(String str) {
        return (SqlWrapper) set(f5463a, str);
    }

    public SqlWrapper setResult(String str) {
        return (SqlWrapper) set(c, str);
    }
}
