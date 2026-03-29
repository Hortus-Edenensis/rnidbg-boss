package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Response implements ch<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, ct> metaDataMap;
    private static final Map<Class<? extends Cdo>, dp> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final dl STRUCT_DESC = new dl("Response");
    private static final db RESP_CODE_FIELD_DESC = new db("resp_code", (byte) 8, 1);
    private static final db MSG_FIELD_DESC = new db("msg", (byte) 11, 2);
    private static final db IMPRINT_FIELD_DESC = new db(bt.X, (byte) 12, 3);

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends dq<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, Response response) throws cn {
            dgVar.j();
            while (true) {
                db dbVarL = dgVar.l();
                byte b = dbVarL.b;
                if (b == 0) {
                    break;
                }
                short s = dbVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            dj.a(dgVar, b);
                        } else if (b == 12) {
                            com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint = dVar;
                            dVar.read(dgVar);
                            response.setImprintIsSet(true);
                        } else {
                            dj.a(dgVar, b);
                        }
                    } else if (b == 11) {
                        response.msg = dgVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        dj.a(dgVar, b);
                    }
                } else if (b == 8) {
                    response.resp_code = dgVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    dj.a(dgVar, b);
                }
                dgVar.m();
            }
            dgVar.k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new dh("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, Response response) throws cn {
            response.validate();
            dgVar.a(Response.STRUCT_DESC);
            dgVar.a(Response.RESP_CODE_FIELD_DESC);
            dgVar.a(response.resp_code);
            dgVar.c();
            if (response.msg != null && response.isSetMsg()) {
                dgVar.a(Response.MSG_FIELD_DESC);
                dgVar.a(response.msg);
                dgVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                dgVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(dgVar);
                dgVar.c();
            }
            dgVar.d();
            dgVar.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends dr<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, Response response) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            dmVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                dmVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(dmVar);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, Response response) throws cn {
            dm dmVar = (dm) dgVar;
            response.resp_code = dmVar.w();
            response.setResp_codeIsSet(true);
            BitSet bitSetB = dmVar.b(2);
            if (bitSetB.get(0)) {
                response.msg = dmVar.z();
                response.setMsgIsSet(true);
            }
            if (bitSetB.get(1)) {
                com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint = dVar;
                dVar.read(dmVar);
                response.setImprintIsSet(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        schemes = map;
        map.put(dq.class, new b());
        map.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.RESP_CODE, new ct("resp_code", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.MSG, new ct("msg", (byte) 2, new cu((byte) 11)));
        enumMap.put(e.IMPRINT, new ct(bt.X, (byte) 2, new cy((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, ct> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = mapUnmodifiableMap;
        ct.a(Response.class, mapUnmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return ce.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        schemes.get(dgVar.D()).b().b(dgVar, this);
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = ce.a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = ce.b(this.__isset_bitfield, 0);
    }

    public void validate() throws cn {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        schemes.get(dgVar.D()).b().a(dgVar, this);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e implements co {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, bt.X);

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return RESP_CODE;
            }
            if (i == 2) {
                return MSG;
            }
            if (i != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.f;
        }

        public static e a(String str) {
            return d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.e;
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public Response deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.ch
    public e fieldForId(int i) {
        return e.a(i);
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }
}
