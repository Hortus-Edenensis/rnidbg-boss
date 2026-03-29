package com.opos.cmn.biz.ststrategy.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.opos.acs.st.STManager;
import com.opos.cmn.biz.ststrategy.entity.DataEntity;
import com.opos.cmn.biz.ststrategy.entity.EncryptEntity;
import com.opos.cmn.biz.ststrategy.entity.MetaEntity;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.entity.StrategyEntity;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {
    public static STConfigEntity a(Context context) {
        JSONObject jSONObjectB;
        if (context == null || (jSONObjectB = e.b(context)) == null) {
            return null;
        }
        return a(jSONObjectB);
    }

    private static String b(String str) {
        String strB = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                strB = com.opos.cmn.an.b.d.b(str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("WrapSTConfigUtil", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("WrapSTConfigUtil", "urlDecodeString before:" + str + ",after:" + strB);
        return strB;
    }

    public static STConfigEntity a(JSONObject jSONObject) {
        STConfigEntity sTConfigEntityBuild;
        String str;
        STConfigEntity.Builder builder;
        String str2;
        String str3;
        String str4;
        String str5 = "oldMetaNameList";
        String str6 = x.cw;
        String str7 = "WrapSTConfigUtil";
        com.opos.cmn.an.f.a.b("WrapSTConfigUtil", "st config read from jsonObject");
        if (jSONObject != null) {
            STConfigEntity.Builder builder2 = new STConfigEntity.Builder();
            try {
                if (jSONObject.has("code") && !jSONObject.isNull("code")) {
                    builder2.setCode(jSONObject.getInt("code"));
                }
                if (jSONObject.has("msg") && !jSONObject.isNull("msg")) {
                    builder2.setMsg(jSONObject.getString("msg"));
                }
                if (!jSONObject.has("data") || jSONObject.isNull("data")) {
                    str = "WrapSTConfigUtil";
                    builder = builder2;
                } else {
                    DataEntity.Builder builder3 = new DataEntity.Builder();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    boolean zHas = jSONObject2.has(WkAdConfigModel.TAG_STRATEGY);
                    str = "WrapSTConfigUtil";
                    String str8 = STManager.KEY_DATA_TYPE;
                    if (zHas) {
                        try {
                            if (!jSONObject2.isNull(WkAdConfigModel.TAG_STRATEGY)) {
                                StrategyEntity.Builder builder4 = new StrategyEntity.Builder();
                                JSONObject jSONObject3 = jSONObject2.getJSONObject(WkAdConfigModel.TAG_STRATEGY);
                                if (jSONObject3.has("frequencyTime") && !jSONObject3.isNull("frequencyTime")) {
                                    builder4.setFrequencyTime(jSONObject3.getInt("frequencyTime"));
                                }
                                if (jSONObject3.has("batchNums") && !jSONObject3.isNull("batchNums")) {
                                    builder4.setBatchNums(jSONObject3.getInt("batchNums"));
                                }
                                if (jSONObject3.has("headKeys") && !jSONObject3.isNull("headKeys")) {
                                    builder4.setHeadKeys(a(jSONObject3.getString("headKeys")));
                                }
                                if (jSONObject3.has("bodyKeys") && !jSONObject3.isNull("bodyKeys")) {
                                    builder4.setBodyKeys(a(jSONObject3.getString("bodyKeys")));
                                }
                                if (jSONObject3.has("commonKeys") && !jSONObject3.isNull("commonKeys")) {
                                    builder4.setCommonKeys(a(jSONObject3.getString("commonKeys")));
                                }
                                if (jSONObject3.has("dms") && !jSONObject3.isNull("dms")) {
                                    builder4.setDmKeys(a(jSONObject3.getString("dms")));
                                }
                                if (jSONObject3.has("modifyTime") && !jSONObject3.isNull("modifyTime")) {
                                    builder4.setModifyTime(jSONObject3.getLong("modifyTime"));
                                }
                                if (jSONObject3.has("wfTime") && !jSONObject3.isNull("wfTime")) {
                                    builder4.setWfTime(jSONObject3.getInt("wfTime"));
                                }
                                if (jSONObject3.has("triggerNums") && !jSONObject3.isNull("triggerNums")) {
                                    builder4.setTriggerNums(jSONObject3.getInt("triggerNums"));
                                }
                                if (jSONObject3.has("prtflg") && !jSONObject3.isNull("prtflg")) {
                                    builder4.setPrtflg(jSONObject3.getInt("prtflg"));
                                }
                                if (jSONObject3.has("aesEncrypt") && !jSONObject3.isNull("aesEncrypt")) {
                                    builder4.setAesKeys(a(jSONObject3.getString("aesEncrypt")));
                                }
                                if (jSONObject3.has("sha256Encrypt") && !jSONObject3.isNull("sha256Encrypt")) {
                                    builder4.setSha256Keys(a(jSONObject3.getString("sha256Encrypt")));
                                }
                                if (jSONObject3.has("md5Encrypt") && !jSONObject3.isNull("md5Encrypt")) {
                                    builder4.setMd5Keys(a(jSONObject3.getString("md5Encrypt")));
                                }
                                if (jSONObject3.has("noCollect") && !jSONObject3.isNull("noCollect")) {
                                    builder4.setNoKeys(a(jSONObject3.getString("noCollect")));
                                }
                                if (jSONObject3.has("reportLimit") && !jSONObject3.isNull("reportLimit")) {
                                    builder4.setReportLimit(jSONObject3.getInt("reportLimit"));
                                }
                                if (jSONObject3.has("extKeys") && !jSONObject3.isNull("extKeys")) {
                                    builder4.setExtKeys(a(b(jSONObject3.getString("extKeys"))));
                                }
                                builder3.setStrategyEntity(builder4.build());
                            }
                        } catch (JSONException e) {
                            e = e;
                            str7 = str;
                            com.opos.cmn.an.f.a.c(str7, "", e);
                            sTConfigEntityBuild = null;
                        }
                    }
                    if (jSONObject2.has("encrypt") && !jSONObject2.isNull("encrypt")) {
                        EncryptEntity.Builder builder5 = new EncryptEntity.Builder();
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("encrypt");
                        if (jSONObject4.has("aesEncrypt") && !jSONObject4.isNull("aesEncrypt")) {
                            builder5.setAesKeys(a(jSONObject4.getString("aesEncrypt")));
                        }
                        if (jSONObject4.has("sha256Encrypt") && !jSONObject4.isNull("sha256Encrypt")) {
                            builder5.setSha256Keys(a(jSONObject4.getString("sha256Encrypt")));
                        }
                        if (jSONObject4.has("md5Encrypt") && !jSONObject4.isNull("md5Encrypt")) {
                            builder5.setMd5Keys(a(jSONObject4.getString("md5Encrypt")));
                        }
                        if (jSONObject4.has("noCollect") && !jSONObject4.isNull("noCollect")) {
                            builder5.setNoKeys(a(jSONObject4.getString("noCollect")));
                        }
                        builder3.setEncryptEntity(builder5.build());
                    }
                    if (jSONObject2.has("metaList") && !jSONObject2.isNull("metaList")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("metaList");
                        if (jSONArray.length() > 0) {
                            HashMap map = new HashMap();
                            int i = 0;
                            while (i < jSONArray.length()) {
                                JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                                if (jSONObject5 != null) {
                                    MetaEntity.Builder builder6 = new MetaEntity.Builder();
                                    String string = "";
                                    str4 = str8;
                                    if (jSONObject5.has(str4) && !jSONObject5.isNull(str4)) {
                                        string = jSONObject5.getString(str4);
                                        builder6.setDataType(string);
                                    }
                                    str3 = str6;
                                    if (jSONObject5.has(str3) && !jSONObject5.isNull(str3)) {
                                        builder6.setCategory(jSONObject5.getInt(str3));
                                    }
                                    if (jSONObject5.has("eventValue") && !jSONObject5.isNull("eventValue")) {
                                        builder6.setEventValue(jSONObject5.getInt("eventValue"));
                                    }
                                    if (jSONObject5.has("setName") && !jSONObject5.isNull("setName")) {
                                        builder6.setName(jSONObject5.getString("setName"));
                                    }
                                    if (jSONObject5.has("url") && !jSONObject5.isNull("url")) {
                                        builder6.setUrl(jSONObject5.getString("url"));
                                    }
                                    if (jSONObject5.has("eventKeys") && !jSONObject5.isNull("eventKeys")) {
                                        builder6.setEventKeys(a(jSONObject5.getString("eventKeys")));
                                    }
                                    if (jSONObject5.has("immFlag") && !jSONObject5.isNull("immFlag")) {
                                        builder6.setImmFlag(jSONObject5.getInt("immFlag"));
                                    }
                                    if (jSONObject5.has("aggrFlag") && !jSONObject5.isNull("aggrFlag")) {
                                        builder6.setAggrFlag(jSONObject5.getInt("aggrFlag"));
                                    }
                                    if (jSONObject5.has("batchNums") && !jSONObject5.isNull("batchNums")) {
                                        builder6.setBatchNums(jSONObject5.getInt("batchNums"));
                                    }
                                    if (jSONObject5.has("uploadFlag") && !jSONObject5.isNull("uploadFlag")) {
                                        builder6.setUploadFlag(jSONObject5.getInt("uploadFlag"));
                                    }
                                    if (jSONObject5.has("modifyTime") && !jSONObject5.isNull("modifyTime")) {
                                        builder6.setModifyTime(jSONObject5.getLong("modifyTime"));
                                    }
                                    if (jSONObject5.has("split") && !jSONObject5.isNull("split")) {
                                        builder6.setSplit(jSONObject5.getString("split"));
                                    }
                                    if (jSONObject5.has("judgePosid") && !jSONObject5.isNull("judgePosid")) {
                                        builder6.setJudgePosids(a(jSONObject5.getString("judgePosid")));
                                    }
                                    str2 = str5;
                                    if (jSONObject5.has(str2) && !jSONObject5.isNull(str2)) {
                                        builder6.setOldMetaNameList(a(jSONObject5.getString(str2)));
                                    }
                                    if (jSONObject5.has("newDataType") && !jSONObject5.isNull("newDataType")) {
                                        builder6.setNewDatatype(jSONObject5.getString("newDataType"));
                                    }
                                    if (jSONObject5.has(str2) && !jSONObject5.isNull(str2)) {
                                        builder6.setOldMetaNameList(a(jSONObject5.getString(str2)));
                                    }
                                    if (jSONObject5.has("version") && !jSONObject5.isNull("version")) {
                                        builder6.setVersion(jSONObject5.getString("version"));
                                    }
                                    map.put(string, builder6.build());
                                } else {
                                    str2 = str5;
                                    str3 = str6;
                                    str4 = str8;
                                }
                                i++;
                                str8 = str4;
                                str6 = str3;
                                str5 = str2;
                            }
                            builder3.setMetaEntityMap(map);
                        }
                    }
                    builder = builder2;
                    builder.setDataEntity(builder3.build());
                }
                sTConfigEntityBuild = builder.build();
                str7 = str;
            } catch (JSONException e2) {
                e = e2;
                str = "WrapSTConfigUtil";
            }
        } else {
            sTConfigEntityBuild = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("stConfigEntity=");
        sb.append(sTConfigEntityBuild == null ? com.igexin.push.core.b.m : sTConfigEntityBuild.toString());
        com.opos.cmn.an.f.a.b(str7, sb.toString());
        return sTConfigEntityBuild;
    }

    private static List<String> a(String str) {
        if (f.a(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken().trim());
        }
        return arrayList;
    }
}
