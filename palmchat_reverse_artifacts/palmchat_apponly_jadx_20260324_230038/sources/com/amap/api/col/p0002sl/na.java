package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.wifi.adsdk.download.LxAdDLManager;
import java.nio.ByteBuffer;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f3025a = new StringBuilder();

    public final mx a(String str, Context context, ie ieVar) {
        mx mxVar = new mx("");
        mxVar.setErrorCode(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                this.f3025a.append("json is error ".concat(String.valueOf(str)));
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            if (string.equals("0")) {
                this.f3025a.append("auth fail:".concat(String.valueOf(string2)));
            }
        } catch (Throwable th) {
            this.f3025a.append("json exception error:" + th.getMessage());
            nl.a(th, "MapParser", "paseAuthFailurJson");
        }
        try {
            StringBuilder sb = this.f3025a;
            sb.append("#SHA1AndPackage#");
            sb.append(fr.e(context));
            String str2 = ieVar.b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb2 = this.f3025a;
                sb2.append(" #gsid#");
                sb2.append(str2);
            }
            String str3 = ieVar.c;
            if (!TextUtils.isEmpty(str3)) {
                this.f3025a.append(" #csid#".concat(String.valueOf(str3)));
            }
        } catch (Throwable unused) {
        }
        mxVar.setLocationDetail(this.f3025a.toString());
        if (this.f3025a.length() > 0) {
            StringBuilder sb3 = this.f3025a;
            sb3.delete(0, sb3.length());
        }
        return mxVar;
    }

    public final mx a(byte[] bArr) {
        mx mxVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ByteBuffer byteBuffer = null;
        try {
            mxVar = new mx("");
        } catch (Throwable th) {
            try {
                mx mxVar2 = new mx("");
                mxVar2.setErrorCode(5);
                this.f3025a.append("parser data error:" + th.getMessage());
                mxVar2.setLocationDetail(this.f3025a.toString());
                mxVar = mxVar2;
            } finally {
                if (0 != 0) {
                    byteBuffer.clear();
                }
            }
        }
        if (bArr == null) {
            mxVar.setErrorCode(5);
            this.f3025a.append("byte[] is null");
            mxVar.setLocationDetail(this.f3025a.toString());
            StringBuilder sb = this.f3025a;
            sb.delete(0, sb.length());
            return mxVar;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (byteBufferWrap.get() == 0) {
            mxVar.b(String.valueOf((int) byteBufferWrap.getShort()));
            byteBufferWrap.clear();
            byteBufferWrap.clear();
            return mxVar;
        }
        mxVar.setLongitude(np.a(((double) byteBufferWrap.getInt()) / 1000000.0d));
        mxVar.setLatitude(np.a(((double) byteBufferWrap.getInt()) / 1000000.0d));
        mxVar.setAccuracy(byteBufferWrap.getShort());
        mxVar.c(String.valueOf((int) byteBufferWrap.get()));
        mxVar.d(String.valueOf((int) byteBufferWrap.get()));
        if (byteBufferWrap.get() == 1) {
            byte[] bArr2 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr2);
            try {
                mxVar.setCountry(new String(bArr2, "UTF-8"));
            } catch (Throwable unused) {
            }
            byte[] bArr3 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr3);
            try {
                str = new String(bArr3, "UTF-8");
                try {
                    mxVar.setProvince(str);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                str = "";
            }
            byte[] bArr4 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr4);
            try {
                str2 = new String(bArr4, "UTF-8");
                try {
                    mxVar.setCity(str2);
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                str2 = "";
            }
            byte[] bArr5 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr5);
            try {
                str3 = new String(bArr5, "UTF-8");
                try {
                    mxVar.setDistrict(str3);
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                str3 = "";
            }
            byte[] bArr6 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr6);
            try {
                str4 = new String(bArr6, "UTF-8");
                try {
                    mxVar.setStreet(str4);
                    mxVar.setRoad(str4);
                } catch (Throwable unused8) {
                }
            } catch (Throwable unused9) {
                str4 = "";
            }
            byte[] bArr7 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr7);
            try {
                mxVar.setNumber(new String(bArr7, "UTF-8"));
            } catch (Throwable unused10) {
            }
            byte[] bArr8 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr8);
            try {
                str5 = new String(bArr8, "UTF-8");
                try {
                    mxVar.setPoiName(str5);
                } catch (Throwable unused11) {
                }
            } catch (Throwable unused12) {
                str5 = "";
            }
            byte[] bArr9 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr9);
            try {
                mxVar.setAoiName(new String(bArr9, "UTF-8"));
            } catch (Throwable unused13) {
            }
            byte[] bArr10 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr10);
            try {
                str6 = new String(bArr10, "UTF-8");
                try {
                    mxVar.setAdCode(str6);
                } catch (Throwable unused14) {
                }
            } catch (Throwable unused15) {
                str6 = "";
            }
            byte[] bArr11 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr11);
            try {
                mxVar.setCityCode(new String(bArr11, "UTF-8"));
            } catch (Throwable unused16) {
            }
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb2.append(str);
                sb2.append(" ");
            }
            if (!TextUtils.isEmpty(str2) && (!str.contains("市") || !str.equals(str2))) {
                sb2.append(str2);
                sb2.append(" ");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb2.append(str3);
                sb2.append(" ");
            }
            if (!TextUtils.isEmpty(str4)) {
                sb2.append(str4);
                sb2.append(" ");
            }
            if (!TextUtils.isEmpty(str5)) {
                if (!TextUtils.isEmpty(str6)) {
                    sb2.append("靠近");
                }
                sb2.append(str5);
                sb2.append(" ");
            }
            Bundle bundle = new Bundle();
            bundle.putString("citycode", mxVar.getCityCode());
            bundle.putString(LxAdDLManager.ITEM_DESC, sb2.toString());
            bundle.putString("adcode", mxVar.getAdCode());
            mxVar.setExtras(bundle);
            mxVar.e(sb2.toString());
            String adCode = mxVar.getAdCode();
            mxVar.setAddress((adCode == null || adCode.trim().length() <= 0) ? sb2.toString() : sb2.toString().replace(" ", ""));
        }
        byteBufferWrap.get(new byte[byteBufferWrap.get() & UByte.MAX_VALUE]);
        if (byteBufferWrap.get() == 1) {
            byteBufferWrap.getInt();
            byteBufferWrap.getInt();
            byteBufferWrap.getShort();
        }
        if (byteBufferWrap.get() == 1) {
            byte[] bArr12 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr12);
            try {
                mxVar.setBuildingId(new String(bArr12, "UTF-8"));
            } catch (Throwable unused17) {
            }
            byte[] bArr13 = new byte[byteBufferWrap.get() & UByte.MAX_VALUE];
            byteBufferWrap.get(bArr13);
            try {
                mxVar.setFloor(new String(bArr13, "UTF-8"));
            } catch (Throwable unused18) {
            }
        }
        if (byteBufferWrap.get() == 1) {
            byteBufferWrap.get();
            byteBufferWrap.getInt();
            byteBufferWrap.get();
        }
        if (byteBufferWrap.get() == 1) {
            mxVar.setTime(byteBufferWrap.getLong());
        }
        byte[] bArr14 = new byte[byteBufferWrap.getShort()];
        byteBufferWrap.get(bArr14);
        try {
            mxVar.a(new String(bArr14, "UTF-8"));
        } catch (Throwable unused19) {
        }
        byteBufferWrap.clear();
        if (this.f3025a.length() > 0) {
            StringBuilder sb3 = this.f3025a;
            sb3.delete(0, sb3.length());
        }
        return mxVar;
    }
}
