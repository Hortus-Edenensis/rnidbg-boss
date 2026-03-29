package defpackage;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.contacts.recommend.RecommendFriendsActivity;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tn0 {
    public static String x = "ContactRequestStatusManager";
    public static volatile tn0 y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21026a = false;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public int e = -1;
    public ArrayList<ContactInfoItem> f = null;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public String j = null;
    public int k = -1;
    public int l = -1;
    public int m = 0;
    public String n = null;
    public String o = null;
    public int p = -1;
    public int q = -1;
    public String r = null;
    public String s = null;
    public int t = -1;
    public ConcurrentHashMap<String, Pair<Integer, String>> u = new ConcurrentHashMap<>();
    public String v;
    public String w;

    public static tn0 i() {
        if (y == null) {
            synchronized (tn0.class) {
                if (y == null) {
                    y = new tn0();
                }
            }
        }
        return y;
    }

    public void A(boolean z) {
        this.f21026a = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(33:0|2|219|3|244|4|(4:6|(10:9|10|(2:227|12)(1:(1:17)(1:19))|20|(1:142)(4:24|(6:26|223|27|215|28|29)(28:34|(2:85|(9:94|236|95|(1:126)(5:99|230|100|(1:121)(8:104|105|106|250|107|248|108|109)|122)|127|(2:129|130)(1:131)|225|132|133)(3:90|(1:92)|93))(6:221|41|42|213|43|(3:45|254|144)(5:46|(1:48)|49|(5:51|(1:58)(1:57)|59|(1:63)(1:62)|(4:65|(1:67)|68|(2:70|(5:240|72|232|73|74)(1:79))))(1:80)|93))|164|(1:166)|167|168|(2:217|170)|174|(1:176)|(1:178)|179|(1:181)|182|(2:238|184)|187|(1:189)|(1:191)|(1:193)|246|194|198|(1:200)|201|(1:203)|(1:205)|(1:207)|208|209)|234|134)|143|253|144|242|7)|252|145)(1:151)|(1:153)|154|168|(0)|174|(0)|(0)|179|(0)|182|(0)|187|(0)|(0)|(0)|246|194|198|(0)|201|(0)|(0)|(0)|208|209|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(4:24|(6:26|223|27|215|28|29)(28:34|(2:85|(9:94|236|95|(1:126)(5:99|230|100|(1:121)(8:104|105|106|250|107|248|108|109)|122)|127|(2:129|130)(1:131)|225|132|133)(3:90|(1:92)|93))(6:221|41|42|213|43|(3:45|254|144)(5:46|(1:48)|49|(5:51|(1:58)(1:57)|59|(1:63)(1:62)|(4:65|(1:67)|68|(2:70|(5:240|72|232|73|74)(1:79))))(1:80)|93))|164|(1:166)|167|168|(2:217|170)|174|(1:176)|(1:178)|179|(1:181)|182|(2:238|184)|187|(1:189)|(1:191)|(1:193)|246|194|198|(1:200)|201|(1:203)|(1:205)|(1:207)|208|209)|234|134) */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x027c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x027d, code lost:
    
        r30 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03d0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03d1, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0368 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0395 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(boolean z) {
        String str;
        String str2;
        String string;
        String str3;
        String string2;
        String str4;
        String str5;
        int iOptInt;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        boolean z3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String str6;
        String str7;
        String str8;
        Cursor cursorQuery;
        HashMap map;
        String string3;
        int i15;
        int i16;
        String str9;
        long j;
        String string4;
        LogUtil.i(x, "updateContactRequestStatusOnDataChangednew start");
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        string = null;
        String string5 = null;
        cursor = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "read_status = ? and request_type != ? and request_type != ?", new String[]{String.valueOf(0L), String.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR), String.valueOf(301)}, "send_time DESC");
            } catch (Exception e) {
                e = e;
                str = null;
                str2 = null;
                string = null;
                str3 = null;
                string2 = null;
                str4 = null;
                str5 = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                map = new HashMap();
            } catch (Exception e2) {
                e = e2;
                str = null;
                str2 = null;
                string = null;
                str3 = null;
                string2 = null;
                str4 = null;
                str5 = null;
                cursor = cursorQuery;
                iOptInt = -1;
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                z2 = false;
                i6 = 0;
                i7 = 0;
            }
            if (cursorQuery != null) {
                String str10 = null;
                str = null;
                str2 = null;
                string = null;
                str3 = null;
                string2 = null;
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                int i17 = -1;
                i5 = 0;
                z2 = false;
                i6 = 0;
                i7 = 0;
                while (cursorQuery.moveToNext()) {
                    try {
                        string3 = cursorQuery.getString(cursorQuery.getColumnIndex("from_uid"));
                        i15 = cursorQuery.getInt(cursorQuery.getColumnIndex("source_type"));
                        i16 = cursorQuery.getInt(cursorQuery.getColumnIndex("request_type"));
                        if (i16 == 302) {
                            try {
                                str9 = string3 + 302;
                            } catch (Exception e3) {
                                e = e3;
                                str4 = string5;
                                cursor = cursorQuery;
                                str5 = str10;
                                iOptInt = i17;
                                e.printStackTrace();
                                if (cursor != null) {
                                }
                                i14 = i;
                                i12 = i2;
                                i11 = i3;
                                i10 = i4;
                                i9 = i5;
                                z3 = z2;
                                i13 = i6;
                                i8 = i7;
                                string5 = str4;
                                str6 = str5;
                                str7 = string2;
                                str8 = str3;
                                this.b = i14;
                                this.c = i12;
                                this.e = i14;
                                this.f = arrayList;
                                this.d = i11;
                                LogUtil.e(x, "unReadCount:" + i14 + " unReadRecommendCount:" + i11 + " updateContactUnRead:" + z3);
                                if (z) {
                                }
                                this.g = i10;
                                if (string5 != null) {
                                }
                                if (str6 != null) {
                                }
                                this.o = str;
                                this.p = iOptInt;
                                if (z) {
                                }
                                this.h = i9;
                                if (z) {
                                }
                                this.l = i13;
                                if (str2 != null) {
                                }
                                if (string != null) {
                                }
                                if (z) {
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("greetList", jSONArray);
                                ds0.a().b(new aj6("greet", jSONObject));
                                this.k = 0;
                                if (z) {
                                }
                                ch.s().t0();
                                this.q = i8;
                                if (str8 != null) {
                                }
                                if (str7 != null) {
                                }
                                if (z) {
                                }
                                LogUtil.i(x, "updateContactRequestStatusOnDataChangednew end");
                            }
                        } else if (i16 >= 100) {
                            str9 = string3 + 100;
                        } else {
                            str9 = string3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str4 = string5;
                    }
                    if (TextUtils.isEmpty(string3) || map.containsKey(str9)) {
                        str5 = str10;
                        j = 0;
                        string5 = string5;
                    } else {
                        str4 = string5;
                        if (i16 != 302) {
                            if (i15 == 4 || i15 == 14 || i15 == 34 || i15 == 28) {
                                str5 = str10;
                                j = 0;
                                if (i15 == 14 || i15 == 34) {
                                    int i18 = i4 + 1;
                                    try {
                                        if (jo6.u() && TextUtils.isEmpty(str)) {
                                            try {
                                                JSONObject jSONObject2 = new JSONObject(cursorQuery.getString(cursorQuery.getColumnIndex("user_info")));
                                                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("carData");
                                                if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.optBoolean(bq.b.V, false)) {
                                                    string4 = str5;
                                                } else {
                                                    String strOptString = jSONObjectOptJSONObject.optString("image2Url");
                                                    try {
                                                        iOptInt = jSONObject2.optInt("sex", -1);
                                                        try {
                                                            i17 = iOptInt;
                                                            str = strOptString;
                                                            string4 = cursorQuery.getString(cursorQuery.getColumnIndex("from_head_img_url"));
                                                        } catch (JSONException e5) {
                                                            e = e5;
                                                            i17 = iOptInt;
                                                            str = strOptString;
                                                            e.printStackTrace();
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            i4 = i18;
                                                            cursor = cursorQuery;
                                                            str = strOptString;
                                                        }
                                                    } catch (JSONException e7) {
                                                        e = e7;
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        i4 = i18;
                                                        cursor = cursorQuery;
                                                        str = strOptString;
                                                        iOptInt = i17;
                                                    }
                                                }
                                                str5 = string4;
                                            } catch (JSONException e9) {
                                                e = e9;
                                            }
                                        }
                                        String string6 = i18 == 1 ? cursorQuery.getString(cursorQuery.getColumnIndex("from_head_img_url")) : str5;
                                        try {
                                            i4 = i18;
                                            str5 = string6;
                                            string5 = cursorQuery.getString(cursorQuery.getColumnIndex("from_nick_name"));
                                        } catch (Exception e10) {
                                            e = e10;
                                            i4 = i18;
                                            str5 = string6;
                                            cursor = cursorQuery;
                                            iOptInt = i17;
                                            e.printStackTrace();
                                            if (cursor != null) {
                                            }
                                            i14 = i;
                                            i12 = i2;
                                            i11 = i3;
                                            i10 = i4;
                                            i9 = i5;
                                            z3 = z2;
                                            i13 = i6;
                                            i8 = i7;
                                            string5 = str4;
                                            str6 = str5;
                                            str7 = string2;
                                            str8 = str3;
                                            this.b = i14;
                                            this.c = i12;
                                            this.e = i14;
                                            this.f = arrayList;
                                            this.d = i11;
                                            LogUtil.e(x, "unReadCount:" + i14 + " unReadRecommendCount:" + i11 + " updateContactUnRead:" + z3);
                                            if (z) {
                                            }
                                            this.g = i10;
                                            if (string5 != null) {
                                            }
                                            if (str6 != null) {
                                            }
                                            this.o = str;
                                            this.p = iOptInt;
                                            if (z) {
                                            }
                                            this.h = i9;
                                            if (z) {
                                            }
                                            this.l = i13;
                                            if (str2 != null) {
                                            }
                                            if (string != null) {
                                            }
                                            if (z) {
                                            }
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("greetList", jSONArray);
                                            ds0.a().b(new aj6("greet", jSONObject3));
                                            this.k = 0;
                                            if (z) {
                                            }
                                            ch.s().t0();
                                            this.q = i8;
                                            if (str8 != null) {
                                            }
                                            if (str7 != null) {
                                            }
                                            if (z) {
                                            }
                                            LogUtil.i(x, "updateContactRequestStatusOnDataChangednew end");
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        i4 = i18;
                                    }
                                } else {
                                    if (i15 == 28) {
                                        i5++;
                                    }
                                    string5 = str4;
                                }
                            } else {
                                try {
                                    ContactInfoItem contactInfoItemA = a(cursorQuery);
                                    str5 = str10;
                                    try {
                                        if (bo0.r().w(contactInfoItemA.getUid())) {
                                            string5 = str4;
                                            str10 = str5;
                                        } else {
                                            if (cursorQuery.getLong(cursorQuery.getColumnIndex("send_time")) > ap4.f1548a) {
                                                z2 = true;
                                            }
                                            if (contactInfoItemA.getRequestType() < 100) {
                                                long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("applyTime"));
                                                j = 0;
                                                boolean z4 = !ContactRequestsVO.isSenderParseFromRid(cursorQuery.getString(cursorQuery.getColumnIndex("rid"))) && j2 > 0 && System.currentTimeMillis() > j2 + (cursorQuery.getLong(cursorQuery.getColumnIndex("applyExpireSec")) * 1000);
                                                if (!(io0.u(i15) && z4)) {
                                                    arrayList.add(contactInfoItemA);
                                                    i++;
                                                    if (!z4) {
                                                        i2++;
                                                    }
                                                    if (!map.containsKey(string3 + 100)) {
                                                        int i19 = i6 + 1;
                                                        if (i19 == 1) {
                                                            try {
                                                                String string7 = cursorQuery.getString(cursorQuery.getColumnIndex("from_head_img_url"));
                                                                try {
                                                                    string = cursorQuery.getString(cursorQuery.getColumnIndex("from_nick_name"));
                                                                    i6 = i19;
                                                                    str2 = string7;
                                                                } catch (Exception e12) {
                                                                    e = e12;
                                                                    i6 = i19;
                                                                    str2 = string7;
                                                                    cursor = cursorQuery;
                                                                    iOptInt = i17;
                                                                    e.printStackTrace();
                                                                    if (cursor != null) {
                                                                    }
                                                                    i14 = i;
                                                                    i12 = i2;
                                                                    i11 = i3;
                                                                    i10 = i4;
                                                                    i9 = i5;
                                                                    z3 = z2;
                                                                    i13 = i6;
                                                                    i8 = i7;
                                                                    string5 = str4;
                                                                    str6 = str5;
                                                                    str7 = string2;
                                                                    str8 = str3;
                                                                    this.b = i14;
                                                                    this.c = i12;
                                                                    this.e = i14;
                                                                    this.f = arrayList;
                                                                    this.d = i11;
                                                                    LogUtil.e(x, "unReadCount:" + i14 + " unReadRecommendCount:" + i11 + " updateContactUnRead:" + z3);
                                                                    if (z) {
                                                                    }
                                                                    this.g = i10;
                                                                    if (string5 != null) {
                                                                    }
                                                                    if (str6 != null) {
                                                                    }
                                                                    this.o = str;
                                                                    this.p = iOptInt;
                                                                    if (z) {
                                                                    }
                                                                    this.h = i9;
                                                                    if (z) {
                                                                    }
                                                                    this.l = i13;
                                                                    if (str2 != null) {
                                                                    }
                                                                    if (string != null) {
                                                                    }
                                                                    if (z) {
                                                                    }
                                                                    JSONObject jSONObject32 = new JSONObject();
                                                                    jSONObject32.put("greetList", jSONArray);
                                                                    ds0.a().b(new aj6("greet", jSONObject32));
                                                                    this.k = 0;
                                                                    if (z) {
                                                                    }
                                                                    ch.s().t0();
                                                                    this.q = i8;
                                                                    if (str8 != null) {
                                                                    }
                                                                    if (str7 != null) {
                                                                    }
                                                                    if (z) {
                                                                    }
                                                                    LogUtil.i(x, "updateContactRequestStatusOnDataChangednew end");
                                                                }
                                                            } catch (Exception e13) {
                                                                e = e13;
                                                                i6 = i19;
                                                            }
                                                        } else {
                                                            i6 = i19;
                                                        }
                                                    }
                                                }
                                            } else {
                                                j = 0;
                                                i3++;
                                            }
                                            string5 = str4;
                                        }
                                    } catch (Exception e14) {
                                        e = e14;
                                    }
                                } catch (Exception e15) {
                                    e = e15;
                                    str5 = str10;
                                    cursor = cursorQuery;
                                    iOptInt = i17;
                                    e.printStackTrace();
                                    if (cursor != null) {
                                    }
                                    i14 = i;
                                    i12 = i2;
                                    i11 = i3;
                                    i10 = i4;
                                    i9 = i5;
                                    z3 = z2;
                                    i13 = i6;
                                    i8 = i7;
                                    string5 = str4;
                                    str6 = str5;
                                    str7 = string2;
                                    str8 = str3;
                                    this.b = i14;
                                    this.c = i12;
                                    this.e = i14;
                                    this.f = arrayList;
                                    this.d = i11;
                                    LogUtil.e(x, "unReadCount:" + i14 + " unReadRecommendCount:" + i11 + " updateContactUnRead:" + z3);
                                    if (z) {
                                    }
                                    this.g = i10;
                                    if (string5 != null) {
                                    }
                                    if (str6 != null) {
                                    }
                                    this.o = str;
                                    this.p = iOptInt;
                                    if (z) {
                                    }
                                    this.h = i9;
                                    if (z) {
                                    }
                                    this.l = i13;
                                    if (str2 != null) {
                                    }
                                    if (string != null) {
                                    }
                                    if (z) {
                                    }
                                    JSONObject jSONObject322 = new JSONObject();
                                    jSONObject322.put("greetList", jSONArray);
                                    ds0.a().b(new aj6("greet", jSONObject322));
                                    this.k = 0;
                                    if (z) {
                                    }
                                    ch.s().t0();
                                    this.q = i8;
                                    if (str8 != null) {
                                    }
                                    if (str7 != null) {
                                    }
                                    if (z) {
                                    }
                                    LogUtil.i(x, "updateContactRequestStatusOnDataChangednew end");
                                }
                            }
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            i14 = i;
                            i12 = i2;
                            i11 = i3;
                            i10 = i4;
                            i9 = i5;
                            z3 = z2;
                            i13 = i6;
                            i8 = i7;
                            string5 = str4;
                            str6 = str5;
                            str7 = string2;
                            str8 = str3;
                            this.b = i14;
                            this.c = i12;
                            this.e = i14;
                            this.f = arrayList;
                            this.d = i11;
                            LogUtil.e(x, "unReadCount:" + i14 + " unReadRecommendCount:" + i11 + " updateContactUnRead:" + z3);
                            if (z) {
                                try {
                                    ch.s().K(this.b, this.f);
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                            this.g = i10;
                            if (string5 != null) {
                                this.w = string5;
                            }
                            if (str6 != null) {
                                this.j = str6;
                            }
                            this.o = str;
                            this.p = iOptInt;
                            if (z) {
                                ch.s().W(this.g);
                            }
                            this.h = i9;
                            if (z) {
                                try {
                                    ch.s().R(this.h);
                                } catch (RuntimeException unused) {
                                }
                            }
                            this.l = i13;
                            if (str2 != null) {
                                this.n = str2;
                            }
                            if (string != null) {
                                this.v = string;
                            }
                            if (z) {
                                ch.s().X(this.l);
                            }
                            JSONObject jSONObject3222 = new JSONObject();
                            jSONObject3222.put("greetList", jSONArray);
                            ds0.a().b(new aj6("greet", jSONObject3222));
                            this.k = 0;
                            if (z) {
                                ch.s().f0(this.l);
                            }
                            ch.s().t0();
                            this.q = i8;
                            if (str8 != null) {
                                this.r = str8;
                            }
                            if (str7 != null) {
                                this.s = str7;
                            }
                            if (z) {
                                ch.s().M();
                            }
                            LogUtil.i(x, "updateContactRequestStatusOnDataChangednew end");
                        }
                        i7++;
                        try {
                            String string8 = cursorQuery.getString(cursorQuery.getColumnIndex("from_head_img_url"));
                            try {
                                string2 = cursorQuery.getString(cursorQuery.getColumnIndex("from_nick_name"));
                                str3 = string8;
                                str5 = str10;
                                string5 = str4;
                                j = 0;
                            } catch (Exception e17) {
                                e = e17;
                                str3 = string8;
                                cursor = cursorQuery;
                                str5 = str10;
                                iOptInt = i17;
                                e.printStackTrace();
                                if (cursor != null) {
                                }
                                i14 = i;
                                i12 = i2;
                                i11 = i3;
                                i10 = i4;
                                i9 = i5;
                                z3 = z2;
                                i13 = i6;
                                i8 = i7;
                                string5 = str4;
                                str6 = str5;
                                str7 = string2;
                                str8 = str3;
                                this.b = i14;
                                this.c = i12;
                                this.e = i14;
                                this.f = arrayList;
                                this.d = i11;
                                LogUtil.e(x, "unReadCount:" + i14 + " unReadRecommendCount:" + i11 + " updateContactUnRead:" + z3);
                                if (z) {
                                }
                                this.g = i10;
                                if (string5 != null) {
                                }
                                if (str6 != null) {
                                }
                                this.o = str;
                                this.p = iOptInt;
                                if (z) {
                                }
                                this.h = i9;
                                if (z) {
                                }
                                this.l = i13;
                                if (str2 != null) {
                                }
                                if (string != null) {
                                }
                                if (z) {
                                }
                                JSONObject jSONObject32222 = new JSONObject();
                                jSONObject32222.put("greetList", jSONArray);
                                ds0.a().b(new aj6("greet", jSONObject32222));
                                this.k = 0;
                                if (z) {
                                }
                                ch.s().t0();
                                this.q = i8;
                                if (str8 != null) {
                                }
                                if (str7 != null) {
                                }
                                if (z) {
                                }
                                LogUtil.i(x, "updateContactRequestStatusOnDataChangednew end");
                            }
                        } catch (Exception e18) {
                            e = e18;
                        }
                        map.put(str9, Boolean.TRUE);
                    }
                    str10 = str5;
                }
                str5 = str10;
                iOptInt = i17;
            } else {
                str = null;
                str2 = null;
                string = null;
                str3 = null;
                string2 = null;
                str5 = null;
                iOptInt = -1;
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                z2 = false;
                i6 = 0;
                i7 = 0;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            i14 = i;
            i12 = i2;
            i11 = i3;
            i10 = i4;
            i9 = i5;
            z3 = z2;
            i13 = i6;
            i8 = i7;
            str6 = str5;
            str7 = string2;
            str8 = str3;
            this.b = i14;
            this.c = i12;
            this.e = i14;
            this.f = arrayList;
            this.d = i11;
            LogUtil.e(x, "unReadCount:" + i14 + " unReadRecommendCount:" + i11 + " updateContactUnRead:" + z3);
            if (z) {
            }
            this.g = i10;
            if (string5 != null) {
            }
            if (str6 != null) {
            }
            this.o = str;
            this.p = iOptInt;
            if (z) {
            }
            this.h = i9;
            if (z) {
            }
            this.l = i13;
            if (str2 != null) {
            }
            if (string != null) {
            }
            if (z) {
            }
            JSONObject jSONObject322222 = new JSONObject();
            jSONObject322222.put("greetList", jSONArray);
            ds0.a().b(new aj6("greet", jSONObject322222));
            this.k = 0;
            if (z) {
            }
            ch.s().t0();
            this.q = i8;
            if (str8 != null) {
            }
            if (str7 != null) {
            }
            if (z) {
            }
            LogUtil.i(x, "updateContactRequestStatusOnDataChangednew end");
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final ContactInfoItem a(Cursor cursor) {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(cursor.getString(cursor.getColumnIndex("from_uid")));
        contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("from_nick_name")));
        contactInfoItem.setIconURL(cursor.getString(cursor.getColumnIndex("from_head_img_url")));
        contactInfoItem.setSourceType(cursor.getInt(cursor.getColumnIndex("source_type")));
        int i = cursor.getInt(cursor.getColumnIndex("request_type"));
        contactInfoItem.setRequestType(i);
        String string = cursor.getString(cursor.getColumnIndex("identify_code"));
        if (TextUtils.isEmpty(string)) {
            String string2 = cursor.getString(cursor.getColumnIndex("user_info"));
            if (!TextUtils.isEmpty(string2)) {
                try {
                    contactInfoItem.setIdentifyCode(hs0.g().d(nn0.d(new JSONObject(string2)).getMobile()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            contactInfoItem.setIdentifyCode(string);
        }
        if (i < 100) {
            contactInfoItem.setDescription(cursor.getString(cursor.getColumnIndex("request_info")));
        } else if (i >= 200 || i < 100) {
            contactInfoItem.setDescription(AppContext.getContext().getString(R.string.contact_others_phone));
            contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("from_nick_name")));
        } else {
            PhoneContactItem phoneContactItem = d.j().m().get(string);
            contactInfoItem.setDescription(AppContext.getContext().getString(R.string.contact_zx_nick_name, cursor.getString(cursor.getColumnIndex("from_nick_name"))));
            if (phoneContactItem == null) {
                contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("from_nick_name")) + "(" + AppContext.getContext().getString(R.string.add_contact_item_link) + ")");
                contactInfoItem.setDescription(AppContext.getContext().getString(R.string.contact_zx_nick_name, cursor.getString(cursor.getColumnIndex("from_nick_name"))));
            } else if (TextUtils.isEmpty(phoneContactItem.m())) {
                contactInfoItem.setNickName(phoneContactItem.y());
            } else {
                contactInfoItem.setNickName(phoneContactItem.m());
            }
            String string3 = cursor.getString(cursor.getColumnIndex("request_info"));
            if (string3 != null && !TextUtils.isEmpty(string3)) {
                if (phoneContactItem != null) {
                    if (TextUtils.isEmpty(phoneContactItem.m())) {
                        contactInfoItem.setNickName(phoneContactItem.y() + "(" + cursor.getString(cursor.getColumnIndex("from_nick_name")) + ")");
                    } else {
                        contactInfoItem.setNickName(phoneContactItem.m() + "(" + cursor.getString(cursor.getColumnIndex("from_nick_name")) + ")");
                    }
                    contactInfoItem.setDescription(string3);
                } else {
                    contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("from_nick_name")) + "(" + AppContext.getContext().getString(R.string.add_contact_item_link) + ")");
                    contactInfoItem.setDescription(AppContext.getContext().getString(R.string.contact_zx_nick_name, cursor.getString(cursor.getColumnIndex("from_nick_name"))));
                }
            }
        }
        return contactInfoItem;
    }

    public int b() {
        return this.m;
    }

    public int c() {
        return this.t;
    }

    public int d() {
        if (this.d == -1) {
            B(false);
        }
        return this.d;
    }

    public int e() {
        if (this.b == -1) {
            ch.s().v0(false);
        }
        return this.b;
    }

    public ArrayList<ContactInfoItem> f() {
        if (this.f == null) {
            B(false);
        }
        return this.f;
    }

    public String g() {
        return this.r;
    }

    public String h() {
        return this.s;
    }

    public int j() {
        return this.p;
    }

    public String k() {
        return this.o;
    }

    public String l() {
        return this.w;
    }

    public int m() {
        int i;
        if (TeenagersModeManager.a().d() || (i = this.g) == -1) {
            return 0;
        }
        if (i > 999) {
            return 999;
        }
        return i;
    }

    public String n() {
        return this.j;
    }

    public String o() {
        return this.n;
    }

    public String p() {
        return this.v;
    }

    public int q() {
        if (this.e == -1) {
            int i = 0;
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "read_status=? and source_type!=? and source_type!=? and source_type!=?", new String[]{String.valueOf(0L), Integer.toString(4), Integer.toString(34), Integer.toString(14)}, "send_time DESC");
                    HashMap map = new HashMap();
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("from_uid"));
                            if (!TextUtils.isEmpty(string) && !map.containsKey(string)) {
                                i++;
                                map.put(string, Boolean.TRUE);
                            }
                        }
                        cursorQuery.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursorQuery != null) {
                    }
                    this.e = i;
                }
                this.e = i;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return this.e;
    }

    public int r() {
        return 0;
    }

    public int s() {
        int i = this.l;
        if (i == -1) {
            return 0;
        }
        return i + this.m;
    }

    public boolean t() {
        return this.f21026a && t5.f().l(RecommendFriendsActivity.class);
    }

    public boolean u(String str) {
        return v(str, false);
    }

    public boolean v(String str, boolean z) {
        Object obj;
        if (!z) {
            return this.u.containsKey(str);
        }
        Pair<Integer, String> pair = this.u.get(str);
        if (pair == null || (obj = pair.second) == null) {
            return false;
        }
        return !ContactRequestsVO.isSenderParseFromRid((String) obj);
    }

    public boolean w() {
        return t5.f().l(RecommendFriendsActivity.class);
    }

    public void x() {
        String[] strArr = {Integer.toString(14), Integer.toString(34), Integer.toString(21), Integer.toString(302)};
        Cursor cursorQuery = null;
        try {
            try {
                HashMap map = new HashMap();
                ArrayList<ContactRequestsVO> arrayList = new ArrayList();
                HashMap map2 = new HashMap();
                this.u.clear();
                cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "source_type != ? and source_type != ? and source_type != ? and request_type != ?", strArr, "send_time DESC");
                int i = 0;
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("from_uid"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("request_type"));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("source_type"));
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("read_status"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("rid"));
                        if (!TextUtils.isEmpty(string)) {
                            if (!map.containsKey(string) && j == 0 && i3 == 200) {
                                arrayList.add(ContactRequestsVO.convertContactRequestsVO(cursorQuery));
                                map.put(string, Boolean.TRUE);
                            }
                            if (i2 < 100 && !this.u.containsKey(string) && !bo0.r().w(string)) {
                                this.u.put(string, new Pair<>(Integer.valueOf(i3), string2));
                            }
                            if (!map2.containsKey(string)) {
                                if (i2 == 222) {
                                    i++;
                                }
                                map2.put(string, Boolean.TRUE);
                            }
                        }
                    }
                    cursorQuery.close();
                }
                LogUtil.i(x, "queryContact bisRecommendCount = " + i + " ,mApplyFuidMap.size = " + this.u.size());
                this.t = i;
                if (arrayList.size() > 0) {
                    for (ContactRequestsVO contactRequestsVO : arrayList) {
                        LogUtil.e(x, "queryMessageRequest contactRequestsTmp： " + contactRequestsVO.sendTime + "  " + contactRequestsVO.id + "  " + contactRequestsVO.sendTime);
                        if (contactRequestsVO.getIsFriend() != 2) {
                            b.s(contactRequestsVO);
                        }
                    }
                    LogUtil.e(x, "queryMessageRequest end");
                    rn0.s();
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public void y() {
        r75.p(AppContext.getContext(), k86.k(), -1);
        this.f21026a = false;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.w = null;
        this.h = -1;
        this.i = -1;
        this.j = null;
        this.k = -1;
        this.l = -1;
        this.n = null;
        this.v = null;
        this.o = null;
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.t = -1;
        this.u.clear();
    }

    public void z(int i) {
        this.m = i;
    }
}
