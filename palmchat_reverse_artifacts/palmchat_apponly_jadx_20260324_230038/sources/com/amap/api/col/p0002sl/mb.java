package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.district.DistrictSearchQuery;
import com.wifi.ad.core.config.EventParams;
import com.wifi.adsdk.download.LxAdDLManager;
import java.nio.ByteBuffer;
import kotlin.UByte;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f2995a = new StringBuilder();
    private AMapLocationClientOption b = new AMapLocationClientOption();

    private static String b(String str) {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str) ? "" : str;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.b = new AMapLocationClientOption();
        } else {
            this.b = aMapLocationClientOption;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0286 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0292  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final lh a(lh lhVar, byte[] bArr, lb lbVar) {
        ByteBuffer byteBufferWrap;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        byte b;
        lh lhVar2 = lhVar;
        ByteBuffer byteBuffer3 = null;
        try {
            if (bArr == null) {
                try {
                    lhVar2.setErrorCode(5);
                    lbVar.f("#0504");
                    this.f2995a.append("binaryResult is null#0504");
                    lhVar2.setLocationDetail(this.f2995a.toString());
                    StringBuilder sb = this.f2995a;
                    sb.delete(0, sb.length());
                    return lhVar2;
                } catch (Throwable th) {
                    th = th;
                }
            } else {
                try {
                    byteBufferWrap = ByteBuffer.wrap(bArr);
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        byteBuffer = byteBufferWrap;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteBuffer3 = null;
                }
                if (byteBufferWrap.get() == 0) {
                    try {
                        lhVar2.b(String.valueOf((int) byteBufferWrap.getShort()));
                        byteBufferWrap.clear();
                        byteBufferWrap.clear();
                        return lhVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        byteBuffer3 = byteBufferWrap;
                    }
                } else {
                    lhVar2.setLongitude(mm.a(((double) byteBufferWrap.getInt()) / 1000000.0d));
                    lhVar2.setLatitude(mm.a(((double) byteBufferWrap.getInt()) / 1000000.0d));
                    lhVar2.setAccuracy(byteBufferWrap.getShort());
                    lhVar2.c(String.valueOf((int) byteBufferWrap.get()));
                    lhVar2.d(String.valueOf((int) byteBufferWrap.get()));
                    if (byteBufferWrap.get() == 1) {
                        try {
                            byte[] bArr2 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr2);
                            try {
                                lhVar2.setCountry(new String(bArr2, "UTF-8"));
                            } catch (Throwable unused) {
                            }
                            byte[] bArr3 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr3);
                            try {
                                str = new String(bArr3, "UTF-8");
                                try {
                                    lhVar2.setProvince(str);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable unused3) {
                                str = "";
                            }
                            String str9 = str;
                            byte[] bArr4 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr4);
                            try {
                                str2 = new String(bArr4, "UTF-8");
                                try {
                                    lhVar2.setCity(str2);
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                                str2 = "";
                            }
                            String str10 = str2;
                            byte[] bArr5 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr5);
                            try {
                                str3 = new String(bArr5, "UTF-8");
                                try {
                                    lhVar2.setDistrict(str3);
                                } catch (Throwable unused6) {
                                }
                            } catch (Throwable unused7) {
                                str3 = "";
                            }
                            String str11 = str3;
                            byte[] bArr6 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr6);
                            try {
                                str4 = new String(bArr6, "UTF-8");
                                try {
                                    lhVar2.setStreet(str4);
                                    lhVar2.setRoad(str4);
                                } catch (Throwable unused8) {
                                }
                            } catch (Throwable unused9) {
                                str4 = "";
                            }
                            String str12 = str4;
                            byte[] bArr7 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr7);
                            try {
                                str5 = new String(bArr7, "UTF-8");
                                try {
                                    lhVar2.setNumber(str5);
                                } catch (Throwable unused10) {
                                }
                            } catch (Throwable unused11) {
                                str5 = "";
                            }
                            String str13 = str5;
                            byte[] bArr8 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr8);
                            try {
                                str6 = new String(bArr8, "UTF-8");
                                try {
                                    lhVar2.setPoiName(str6);
                                } catch (Throwable unused12) {
                                }
                            } catch (Throwable unused13) {
                                str6 = "";
                            }
                            String str14 = str6;
                            byte[] bArr9 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr9);
                            try {
                                lhVar2.setAoiName(new String(bArr9, "UTF-8"));
                            } catch (Throwable unused14) {
                            }
                            byte[] bArr10 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr10);
                            try {
                                str7 = new String(bArr10, "UTF-8");
                                try {
                                    lhVar2.setAdCode(str7);
                                } catch (Throwable unused15) {
                                }
                            } catch (Throwable unused16) {
                                str7 = "";
                            }
                            String str15 = str7;
                            byte[] bArr11 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
                            byteBufferWrap.get(bArr11);
                            try {
                                lhVar2.setCityCode(new String(bArr11, "UTF-8"));
                            } catch (Throwable unused17) {
                            }
                            str8 = "UTF-8";
                            b = 1;
                            byteBuffer2 = byteBufferWrap;
                            try {
                                a(lhVar, str9, str10, str11, str12, str13, str14, str15);
                            } catch (Throwable th5) {
                                th = th5;
                                byteBuffer3 = byteBuffer2;
                                lh lhVar3 = new lh("");
                                lhVar3.setErrorCode(5);
                                lbVar.f("#0505");
                                this.f2995a.append("parser data error:" + th.getMessage() + "#0505");
                                mk.a((String) null, 2054);
                                lhVar3.setLocationDetail(this.f2995a.toString());
                                lhVar2 = lhVar3;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            byteBuffer2 = byteBufferWrap;
                        }
                    } else {
                        str8 = "UTF-8";
                        byteBuffer2 = byteBufferWrap;
                        b = 1;
                    }
                    try {
                        byteBuffer = byteBuffer2;
                        try {
                            byteBuffer.get(new byte[byteBuffer2.get() & UByte.MAX_VALUE]);
                            if (byteBuffer.get() == b) {
                                byteBuffer.getInt();
                                byteBuffer.getInt();
                                byteBuffer.getShort();
                            }
                            if (byteBuffer.get() == b) {
                                byte[] bArr12 = new byte[byteBuffer.get() & UByte.MAX_VALUE];
                                byteBuffer.get(bArr12);
                                try {
                                    lhVar2.setBuildingId(new String(bArr12, str8));
                                } catch (Throwable unused18) {
                                }
                                byte[] bArr13 = new byte[byteBuffer.get() & UByte.MAX_VALUE];
                                byteBuffer.get(bArr13);
                                try {
                                    lhVar2.setFloor(new String(bArr13, str8));
                                } catch (Throwable unused19) {
                                }
                            }
                            if (byteBuffer.get() == b) {
                                byteBuffer.get();
                                byteBuffer.getInt();
                                byteBuffer.get();
                            }
                            if (byteBuffer.get() == b) {
                                lhVar2.setTime(byteBuffer.getLong());
                            }
                            int i = byteBuffer.getShort();
                            if (i > 0) {
                                byte[] bArr14 = new byte[i];
                                byteBuffer.get(bArr14);
                                if (i > 0) {
                                    try {
                                        lhVar2.a(new String(Base64.decode(bArr14, 0), str8));
                                    } catch (Throwable unused20) {
                                    }
                                }
                            }
                            int i2 = byteBuffer.getShort();
                            if (i2 > 0) {
                                byteBuffer.get(new byte[i2]);
                            }
                            if (Double.valueOf(me.f2999a).doubleValue() >= 5.1d) {
                                a(lhVar2, byteBuffer.getShort());
                                lhVar2.a(byteBuffer.get());
                            }
                            byteBuffer.clear();
                        } catch (Throwable th7) {
                            th = th7;
                            byteBuffer3 = byteBuffer;
                            lh lhVar32 = new lh("");
                            lhVar32.setErrorCode(5);
                            lbVar.f("#0505");
                            this.f2995a.append("parser data error:" + th.getMessage() + "#0505");
                            mk.a((String) null, 2054);
                            lhVar32.setLocationDetail(this.f2995a.toString());
                            lhVar2 = lhVar32;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        byteBuffer = byteBuffer2;
                    }
                    if (this.f2995a.length() > 0) {
                        StringBuilder sb2 = this.f2995a;
                        sb2.delete(0, sb2.length());
                    }
                    return lhVar2;
                }
            }
            lh lhVar322 = new lh("");
            lhVar322.setErrorCode(5);
            lbVar.f("#0505");
            this.f2995a.append("parser data error:" + th.getMessage() + "#0505");
            mk.a((String) null, 2054);
            lhVar322.setLocationDetail(this.f2995a.toString());
            lhVar2 = lhVar322;
            if (this.f2995a.length() > 0) {
            }
            return lhVar2;
        } finally {
            if (byteBuffer3 != null) {
                byteBuffer3.clear();
            }
        }
    }

    private void a(lh lhVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            a(str, str2, sb);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            a(str7, str6, sb, lhVar);
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", lhVar.getCityCode());
        bundle.putString(LxAdDLManager.ITEM_DESC, sb.toString());
        bundle.putString("adcode", lhVar.getAdCode());
        lhVar.setExtras(bundle);
        lhVar.g(sb.toString());
        String adCode = lhVar.getAdCode();
        if (adCode != null && adCode.trim().length() > 0 && this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
            lhVar.setAddress(sb.toString().replace(" ", ""));
        } else {
            lhVar.setAddress(sb.toString());
        }
    }

    private void a(String str, String str2, StringBuilder sb) {
        if (this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            if (str2.equals(str)) {
                return;
            }
            sb.append(str2);
            sb.append(" ");
            return;
        }
        if (str.contains("市") && str.equals(str2)) {
            return;
        }
        sb.append(str2);
        sb.append(" ");
    }

    private void a(String str, String str2, StringBuilder sb, lh lhVar) {
        if (!TextUtils.isEmpty(str) && this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
            sb.append("靠近");
            sb.append(str2);
            sb.append(" ");
            lhVar.setDescription("在" + str2 + "附近");
            return;
        }
        sb.append("Near ".concat(String.valueOf(str2)));
        lhVar.setDescription("Near ".concat(String.valueOf(str2)));
    }

    public final lh a(String str) {
        String str2;
        try {
            lh lhVar = new lh("");
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("regeocode");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("addressComponent");
            lhVar.setCountry(b(jSONObjectOptJSONObject2.optString("country")));
            String strB = b(jSONObjectOptJSONObject2.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
            lhVar.setProvince(strB);
            String strB2 = b(jSONObjectOptJSONObject2.optString("citycode"));
            lhVar.setCityCode(strB2);
            String strOptString = jSONObjectOptJSONObject2.optString(DistrictSearchQuery.KEYWORDS_CITY);
            if (!strB2.endsWith("010") && !strB2.endsWith("021") && !strB2.endsWith("022") && !strB2.endsWith("023")) {
                strOptString = b(strOptString);
                lhVar.setCity(strOptString);
            } else if (strB != null && strB.length() > 0) {
                lhVar.setCity(strB);
                strOptString = strB;
            }
            if (TextUtils.isEmpty(strOptString)) {
                lhVar.setCity(strB);
                strOptString = strB;
            }
            String strB3 = b(jSONObjectOptJSONObject2.optString(DistrictSearchQuery.KEYWORDS_DISTRICT));
            lhVar.setDistrict(strB3);
            String strB4 = b(jSONObjectOptJSONObject2.optString("adcode"));
            lhVar.setAdCode(strB4);
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("streetNumber");
            String strB5 = b(jSONObjectOptJSONObject3.optString("street"));
            lhVar.setStreet(strB5);
            lhVar.setRoad(strB5);
            String strB6 = b(jSONObjectOptJSONObject3.optString(EventParams.KEY_PARAM_NUMBER));
            lhVar.setNumber(strB6);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("pois");
            if (jSONArrayOptJSONArray.length() > 0) {
                String strB7 = b(jSONArrayOptJSONArray.getJSONObject(0).optString("name"));
                lhVar.setPoiName(strB7);
                str2 = strB7;
            } else {
                str2 = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("aois");
            if (jSONArrayOptJSONArray2.length() > 0) {
                lhVar.setAoiName(b(jSONArrayOptJSONArray2.getJSONObject(0).optString("name")));
            }
            a(lhVar, strB, strOptString, strB3, strB5, strB6, str2, strB4);
            return lhVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final lh a(String str, Context context, ie ieVar, lb lbVar) {
        lh lhVar = new lh("");
        lhVar.setErrorCode(7);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("#SHA1AndPackage#");
            stringBuffer.append(fr.e(context));
            String str2 = ieVar.b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("#gsid#");
                stringBuffer.append(str2);
            }
            String str3 = ieVar.c;
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("#csid#".concat(String.valueOf(str3)));
            }
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                lbVar.f("#0702");
                StringBuilder sb = this.f2995a;
                sb.append("json is error:");
                sb.append(str);
                sb.append(stringBuffer);
                sb.append("#0702");
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                lbVar.f("#0701");
                StringBuilder sb2 = this.f2995a;
                sb2.append("auth fail:");
                sb2.append(string2);
                sb2.append(stringBuffer);
                sb2.append("#0701");
                mk.a(ieVar.d, string3, string2);
            }
        } catch (Throwable th) {
            lbVar.f("#0703");
            StringBuilder sb3 = this.f2995a;
            sb3.append("json exception error:");
            sb3.append(th.getMessage());
            sb3.append(stringBuffer);
            sb3.append("#0703");
            me.a(th, "parser", "paseAuthFailurJson");
        }
        lhVar.setLocationDetail(this.f2995a.toString());
        if (this.f2995a.length() > 0) {
            StringBuilder sb4 = this.f2995a;
            sb4.delete(0, sb4.length());
        }
        return lhVar;
    }

    private static void a(lh lhVar, short s) {
        if (!"-1".equals(lhVar.d())) {
            if (s == -1) {
                s = 0;
            } else if (s == 0) {
                s = -1;
            }
            lhVar.setConScenario(s);
            return;
        }
        if (s == 101) {
            s = 100;
        }
        lhVar.setConScenario(s);
    }
}
