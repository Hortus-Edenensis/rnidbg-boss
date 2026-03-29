package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.component.b.nr.fx;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.EventParams;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static String nr = "tt_csj_node_line_detail";
    public static volatile fx u;

    private static fx nr() {
        if (u == null) {
            u = bf.u(nr);
        }
        return u;
    }

    public static void u(String str) {
        nr().remove(str);
    }

    public static void u(String str, String str2) {
        nr().put(str, str2);
    }

    public static void u() {
        Map all = nr().getAll();
        if (all == null || all.isEmpty()) {
            return;
        }
        all.size();
        for (String str : all.keySet()) {
            Object obj = all.get(str);
            if (str != null && str.startsWith("key_tt_csj_node_line_")) {
                if (obj instanceof String) {
                    nr((String) obj);
                }
                nr().remove(str);
            }
        }
    }

    private static void nr(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String strOptString = jSONObject.optString("ad_load_id");
            final String strOptString2 = jSONObject.optString("ad_show_id");
            final String strOptString3 = jSONObject.optString("node_line_version");
            final int iOptInt = jSONObject.optInt("unexpected_type");
            final int iOptInt2 = jSONObject.optInt("bidding_type");
            final String strOptString4 = jSONObject.optString("node_line");
            final JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("node_line_detail");
            final String strOptString5 = jSONObject.optString("creative_id");
            final String strOptString6 = jSONObject.optString(ReportItem.RequestKeyRequestId);
            final String strOptString7 = jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA);
            final int iOptInt3 = jSONObject.optInt(EventParams.KEY_PARAM_ADTYPE);
            final String strOptString8 = jSONObject.optString("rit");
            final String strOptString9 = jSONObject.optString("ad_info");
            long jOptLong = jSONObject.optLong("ts");
            final boolean zOptBoolean = jSONObject.optBoolean("need_node_line_detail");
            s.u().u(jOptLong, new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.d.nr.1
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.putOpt("ad_load_id", strOptString);
                        jSONObject2.putOpt("ad_show_id", strOptString2);
                        jSONObject2.putOpt("bidding_type", Integer.valueOf(iOptInt2));
                        jSONObject2.putOpt("is_from_cache", 1);
                        jSONObject2.putOpt("node_line_version", strOptString3);
                        jSONObject2.putOpt("unexpected_type", Integer.valueOf(iOptInt));
                        jSONObject2.putOpt("node_line", strOptString4);
                        if (zOptBoolean) {
                            jSONObject2.putOpt("node_line_detail", jSONArrayOptJSONArray);
                        }
                    } catch (Throwable unused) {
                    }
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().b(strOptString5).iz(strOptString6).n(strOptString7).u(iOptInt3).fx(strOptString8).a(strOptString9).nr(jSONObject2.toString());
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void u(final List<u> list, final com.bytedance.sdk.openadsdk.core.component.nr nrVar, final boolean z, final int i) {
        if (nrVar == null || nrVar.pn == null) {
            return;
        }
        s.u().u(System.currentTimeMillis() / 1000, new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.d.nr.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("ad_load_id", nrVar.u);
                    jSONObject.putOpt("ad_show_id", nrVar.u());
                    jSONObject.putOpt("bidding_type", Integer.valueOf(nr.u(nrVar)));
                    jSONObject.putOpt("node_line_version", "1.0.0");
                    jSONObject.putOpt("unexpected_type", Integer.valueOf(i));
                    jSONObject.putOpt("node_line", nr.u((List<u>) list));
                    if (z) {
                        jSONObject.putOpt("node_line_detail", nr.nr((List<u>) list));
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().b(nrVar.pn.lk()).iz(nrVar.pn.xx()).n(nrVar.pn.ap()).u(nrVar.nr).fx(nrVar.fx).a(nrVar.pn.yf()).nr(jSONObject.toString());
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(List<u> list) {
        StringBuilder sb = new StringBuilder();
        for (u uVar : list) {
            if ("ad_load".equals(uVar.nr())) {
                String strU = uVar.u();
                strU.hashCode();
                switch (strU) {
                    case "loaded":
                        sb.append("0104");
                        break;
                    case "req":
                        sb.append("0102");
                        break;
                    case "start":
                        sb.append("0101");
                        break;
                    case "receive":
                        sb.append("0103");
                        break;
                }
            } else if ("ad_show".equals(uVar.nr())) {
                String strU2 = uVar.u();
                strU2.hashCode();
                switch (strU2.hashCode()) {
                    case -1352294148:
                        if (strU2.equals("create")) {
                        }
                        break;
                    case 100571:
                        if (strU2.equals("end")) {
                            break;
                        }
                        break;
                    case 3529469:
                        if (strU2.equals(bq.b.V)) {
                            break;
                        }
                        break;
                    case 94750088:
                        if (!strU2.equals("click")) {
                        }
                        break;
                    case 109757538:
                        if (strU2.equals("start")) {
                            break;
                        }
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:207)
                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:88)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    Method dump skipped, instruction units count: 312
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.d.nr.u(java.util.List):java.lang.String");
            }

            public static JSONArray nr(List<u> list) {
                JSONArray jSONArray = new JSONArray();
                for (u uVar : list) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("l_type", uVar.nr());
                        jSONObject.putOpt("type", uVar.u());
                        jSONObject.putOpt("ts", Long.valueOf(uVar.fx()));
                        if ("end".equals(uVar.u())) {
                            jSONObject.putOpt(az.at, Integer.valueOf(uVar.b()));
                        }
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }

            public static int u(com.bytedance.sdk.openadsdk.core.component.nr nrVar) {
                bc bcVar;
                if (nrVar != null && (bcVar = nrVar.pn) != null) {
                    try {
                        Map<String, Object> mapSj = bcVar.sj();
                        if (mapSj == null) {
                            return 0;
                        }
                        Object obj = mapSj.get("sdk_bidding_type");
                        if (obj instanceof Integer) {
                            return ((Integer) obj).intValue();
                        }
                    } catch (Throwable unused) {
                    }
                }
                return 0;
            }
        }
