package com.zenmen.palmchat.database;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.huawei.hms.adapter.internal.CommonCode;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.CircleNotice;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.Vo.SuperGreetingsVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.giftkit.chat.GiftMessageExtensionBean;
import com.zenmen.palmchat.giftkit.chat.GiftReceiverInfo;
import com.zenmen.palmchat.groupchat.GroupMemberInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.venus.bean.VenusRoomShareCard;
import defpackage.ae2;
import defpackage.az2;
import defpackage.bo0;
import defpackage.dx5;
import defpackage.f46;
import defpackage.fu5;
import defpackage.ho3;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.je2;
import defpackage.jv0;
import defpackage.jw5;
import defpackage.lg2;
import defpackage.m40;
import defpackage.mb4;
import defpackage.me3;
import defpackage.mo5;
import defpackage.p96;
import defpackage.tw5;
import defpackage.vh5;
import defpackage.vn0;
import defpackage.wf5;
import defpackage.xf5;
import defpackage.yn0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({HttpHeaders.RANGE})
public class SocialContentProvider extends ContentProvider {
    public static final UriMatcher b;
    public static String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f13882a = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f13883a;
        public final /* synthetic */ String b;

        public a(Uri uri, String str) {
            this.f13883a = uri;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msg_status", (Integer) 1);
            SocialContentProvider.this.getContext().getContentResolver().update(this.f13883a, contentValues, "packet_id=? AND msg_status=?", new String[]{this.b, String.valueOf(4)});
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13884a;
        public int b;

        public b() {
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        b = uriMatcher;
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_messages", 3000);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_contacts", 9000);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_contact_requests", 11000);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_threads", 10000);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_synckey", 4000);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_groups", ErrorCode.REASON_TEE);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_group_members", ErrorCode.REASON_DS_SCHEME);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_favorite_expression", 15000);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_account", ErrorCode.REASON_DS_OUT_OF_RANGE);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_video", ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_uploaded_contact", 20000);
        uriMatcher.addURI("com.zenmen.palmchat.social.provider", "tb_dialog_message", ErrorCode.REASON_EXTRACTOR_UNSUPPORT);
    }

    public static void l(String str) {
        c = str;
    }

    public static String v() {
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[PHI: r2
      0x0041: PHI (r2v3 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:17:0x003f, B:11:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<String> A(vh5 vh5Var, String str, String[] strArr, Uri uri) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursorG = null;
        try {
            try {
                cursorG = vh5Var.g(DBUriManager.h(uri), new String[]{"packet_id"}, str, strArr, null, null, null);
                if (cursorG != null) {
                    while (cursorG.moveToNext()) {
                        String string = cursorG.getString(cursorG.getColumnIndex("packet_id"));
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorG != null) {
                }
            }
            if (cursorG != null) {
                cursorG.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorG != null) {
                cursorG.close();
            }
            throw th;
        }
    }

    public final long B(ContentValues contentValues, Uri uri) {
        wf5 wf5VarA = xf5.a(a());
        long jI = 0;
        if (wf5VarA == null) {
            return 0L;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        Object obj = contentValues.get("resource_version");
        Object obj2 = contentValues.get("resource_type");
        if (obj != null && obj2 != null) {
            long jLongValue = ((Long) obj).longValue();
            contentValues.remove("resource_version");
            contentValues.remove("resource_type");
            M(writableDatabase, (String) obj2, jLongValue);
        }
        String[] strArr = {(String) contentValues.get("group_id")};
        Cursor cursorG = vh5Var.g(DBUriManager.e(uri), null, "group_id=?", strArr, null, null, null);
        if (cursorG.moveToFirst()) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("group_state", (Integer) 1);
            jI = vh5Var.i(DBUriManager.e(uri), contentValues2, "group_id=?", strArr);
        }
        cursorG.close();
        return jI;
    }

    public final long C(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        long jF;
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        Cursor cursorG = vh5Var.g("tb_account", null, null, null, null, null, null);
        if (cursorG == null) {
            return vh5Var.f("tb_account", null, contentValues);
        }
        if (cursorG.moveToFirst()) {
            jF = cursorG.getLong(cursorG.getColumnIndex("_id"));
            vh5Var.i("tb_account", contentValues, null, null);
        } else {
            jF = vh5Var.f("tb_account", null, contentValues);
        }
        cursorG.close();
        return jF;
    }

    public final long D(ContentValues contentValues) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return 0L;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        vh5Var.a();
        try {
            long jG = G(contentValues, writableDatabase);
            vh5Var.h();
            return jG;
        } finally {
            vh5Var.d();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:78|(29:898|80|(4:98|(2:100|(5:102|(1:106)|107|(1:109)|110)(1:113))|114|(27:142|(2:144|(24:146|894|154|155|911|156|(12:882|158|159|864|160|161|888|(5:163|164|(2:168|(2:170|(1:174)))|175|176)(13:179|180|181|(1:183)(1:184)|185|(1:189)|191|(1:193)|194|195|866|196|(2:198|199)(2:200|201))|208|209|149|861)(2:210|(3:845|846|847)(2:906|215))|216|217|(2:886|219)(1:223)|918|224|(2:226|(3:893|228|(15:230|(7:232|233|869|234|880|235|(16:237|891|238|(1:240)|251|259|263|264|(1:266)(1:267)|(5:269|270|(2:310|(1:312)(1:313))(16:274|(1:276)|277|(1:279)|280|(1:282)|283|(1:285)(1:286)|287|(1:289)(1:290)|291|(1:293)(1:294)|295|(1:297)(1:298)|299|(2:(1:302)(1:(1:304))|309)(3:305|(2:308|302)|309))|(1:315)|316)(2:317|(9:319|920|320|321|924|322|(1:352)(11:326|(2:328|(1:330))(1:331)|332|(1:334)(1:335)|336|(1:338)(1:339)|340|(1:342)(1:343)|344|(2:346|(1:348)(1:349))(1:350)|351)|(1:354)|355)(1:363))|878|364|867|365|366|(9:905|368|(8:370|(1:372)|373|(1:377)|(1:384)(4:381|(1:383)|386|387)|385|386|387)(1:390)|391|(2:393|394)(1:396)|397|398|922|(1:(18:401|(1:403)(3:404|(1:406)(1:407)|408)|409|421|526|(1:528)(1:529)|(4:531|(1:537)(1:536)|(1:542)(1:541)|543)(1:548)|876|549|(1:551)(1:552)|553|554|(1:560)(1:559)|561|(1:563)(17:565|566|(1:568)|569|(3:645|646|647)(1:(7:874|573|(10:575|(1:577)(1:578)|579|(1:581)(1:582)|583|584|(3:586|914|587)(1:590)|591|(3:593|594|(1:600))(1:601)|602)(5:606|(1:608)(1:609)|901|610|611)|612|(1:614)(4:616|(9:618|(0)|(1:631)(1:630)|632|(1:635)|(1:637)|638|(1:640)(1:641)|642)(1:623)|624|(7:631|632|(1:635)|(0)|638|(0)(0)|642)(0))|615|(0)(0))(0))|(1:679)(2:650|(2:652|(2:673|(1:675)(2:676|(1:678)))(5:660|(3:663|(2:936|672)(2:934|671)|661)|932|673|(0)(0))))|(2:681|(1:687)(1:685))(1:688)|689|690|(3:692|693|(1:703))(2:705|706)|(2:(1:711)|712)|(1:716)|717|(6:723|(1:725)|727|(2:734|(1:736))(2:731|(1:733))|737|(3:746|747|(8:889|749|(2:(1:752)(1:754)|755)(3:758|884|759)|(1:769)(2:763|(1:767))|770|908|771|(5:916|773|(3:775|776|(1:778))(1:781)|(1:826)(13:786|787|928|788|(3:790|899|791)|795|(1:797)|798|799|930|800|(6:802|(1:804)(1:805)|(1:808)|809|(1:812)|813)(3:814|(1:817)|818)|819)|827)(0))(0))(5:739|(4:742|(0)|747|(0)(0))|745|747|(0)(0)))(1:722)|726|727|(4:734|(0)|737|(0)(0))(0))|564|569|(4:645|646|647|(9:679|(0)(0)|689|690|(0)(0)|(3:708|(0)|712)|(2:714|716)|717|(5:719|723|(1:726)(0)|727|(0)(0))(0))(0))(0))(10:410|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(7:556|560|561|(0)(0)|564|569|(0)(0))(0)))(12:411|(11:(2:414|(1:420)(1:419))|421|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(0)(0))(3:422|(1:(1:425))(2:428|(1:(1:431))(2:432|(1:(1:435))(13:436|(1:(3:439|(1:444)(1:443)|(1:446)(1:447)))(2:449|(11:(6:903|452|(1:458)(1:457)|926|(5:460|(1:462)(1:464)|465|466|467)(1:468)|469)|476|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(0)(0))(12:477|(1:(5:896|480|(1:490)(2:488|489)|491|(4:498|499|(1:501)(1:502)|503)(5:494|(2:496|497)(0)|499|(0)(0)|503))(1:506))(2:508|(2:510|(1:512)(10:513|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(0)(0)))(10:(4:515|(1:517)(1:518)|519|(1:525)(1:524))|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(0)(0)))|507|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(0)(0)))|475|476|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(0)(0))))|426)|427|526|(0)(0)|(0)(0)|876|549|(0)(0)|553|554|(0)(0)))(0))(1:243))(1:249)|250|251|259|263|264|(0)(0)|(0)(0)|878|364|867|365|366|(0)(0))(0))(1:260))(1:261)|262|263|264|(0)(0)|(0)(0)|878|364|867|365|366|(0)(0)))|152|153|894|154|155|911|156|(0)(0)|216|217|(0)(0)|918|224|(0)(0)|262|263|264|(0)(0)|(0)(0)|878|364|867|365|366|(0)(0))(31:118|(1:137)(2:122|(3:124|(1:131)(1:130)|(29:133|138|(1:140)|141|112|153|894|154|155|911|156|(0)(0)|216|217|(0)(0)|918|224|(0)(0)|262|263|264|(0)(0)|(0)(0)|878|364|867|365|366|(0)(0))(1:134))(1:136))|135|138|(0)|141|112|153|894|154|155|911|156|(0)(0)|216|217|(0)(0)|918|224|(0)(0)|262|263|264|(0)(0)|(0)(0)|878|364|867|365|366|(0)(0)))(7:84|(1:86)(1:87)|88|(1:93)(1:92)|94|(1:96)|97)|111|112|153|894|154|155|911|156|(0)(0)|216|217|(0)(0)|918|224|(0)(0)|262|263|264|(0)(0)|(0)(0)|878|364|867|365|366|(0)(0))(1:150)|151|152|153|894|154|155|911|156|(0)(0)|216|217|(0)(0)|918|224|(0)(0)|262|263|264|(0)(0)|(0)(0)|878|364|867|365|366|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:834:0x11ac, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:835:0x11ad, code lost:
    
        r77 = " ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:838:0x11b7, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:839:0x11b8, code lost:
    
        r77 = " ";
        r13 = r52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:840:0x11bd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:841:0x11be, code lost:
    
        r13 = r14;
        r77 = " ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:842:0x11c1, code lost:
    
        r1 = r0;
        r10 = r16;
        r18 = r10;
        r48 = r18;
        r13 = r13;
        r77 = r77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:848:0x11d3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:849:0x11d4, code lost:
    
        r77 = " ";
        r13 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:850:0x11d9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:851:0x11da, code lost:
    
        r13 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02bf A[Catch: Exception -> 0x02e6, TryCatch #19 {Exception -> 0x02e6, blocks: (B:80:0x016c, B:82:0x0180, B:84:0x018a, B:88:0x01a2, B:90:0x01a8, B:92:0x01b0, B:94:0x01b5, B:96:0x01bb, B:97:0x01be, B:98:0x01c4, B:100:0x01d1, B:102:0x01db, B:104:0x01e9, B:106:0x01f1, B:107:0x01f3, B:109:0x01f9, B:110:0x01fc, B:114:0x0209, B:116:0x0213, B:118:0x021e, B:120:0x022c, B:122:0x0234, B:124:0x023f, B:126:0x0243, B:128:0x0247, B:133:0x0254, B:138:0x02b9, B:140:0x02bf, B:141:0x02c2, B:134:0x0275, B:136:0x0296, B:142:0x02c8, B:144:0x02d6), top: B:898:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[Catch: Exception -> 0x0051, TRY_ENTER, TryCatch #28 {Exception -> 0x0051, blocks: (B:7:0x0035, B:9:0x003e, B:26:0x0085, B:28:0x0099, B:30:0x00a5, B:34:0x00b0, B:39:0x00c1, B:44:0x00d9, B:50:0x00f9, B:55:0x010b, B:61:0x0122, B:67:0x0142, B:69:0x014a), top: B:913:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x06ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x08d1  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0b7c  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0b94  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0b97  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0c37  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x0c3a  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0c3e A[Catch: Exception -> 0x0cbb, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0cc3  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0cd6  */
    /* JADX WARN: Removed duplicated region for block: B:552:0x0cd8  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0ced A[Catch: Exception -> 0x0cbb, TRY_ENTER, TRY_LEAVE, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:560:0x0cf4  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x0d09  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x0d10 A[Catch: Exception -> 0x11aa, TRY_LEAVE, TryCatch #7 {Exception -> 0x11aa, blocks: (B:549:0x0cc9, B:553:0x0cd9, B:561:0x0cf5, B:689:0x0f0b, B:737:0x0fe1, B:747:0x0fff, B:706:0x0f52, B:646:0x0e5a, B:565:0x0d10), top: B:876:0x0cc9 }] */
    /* JADX WARN: Removed duplicated region for block: B:571:0x0d20 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0db1  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0df6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0e00  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0e16 A[Catch: Exception -> 0x0cbb, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:640:0x0e33 A[Catch: Exception -> 0x0cbb, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:641:0x0e3d A[Catch: Exception -> 0x0cbb, TRY_LEAVE, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0e50  */
    /* JADX WARN: Removed duplicated region for block: B:675:0x0ed0 A[Catch: Exception -> 0x0cbb, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0edb  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x0eeb  */
    /* JADX WARN: Removed duplicated region for block: B:681:0x0eef  */
    /* JADX WARN: Removed duplicated region for block: B:688:0x0f07  */
    /* JADX WARN: Removed duplicated region for block: B:692:0x0f13  */
    /* JADX WARN: Removed duplicated region for block: B:705:0x0f50  */
    /* JADX WARN: Removed duplicated region for block: B:711:0x0f6c A[Catch: Exception -> 0x0cbb, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:723:0x0fb2  */
    /* JADX WARN: Removed duplicated region for block: B:725:0x0fb7 A[Catch: Exception -> 0x0cbb, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:729:0x0fc5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:734:0x0fd6  */
    /* JADX WARN: Removed duplicated region for block: B:736:0x0fdd A[Catch: Exception -> 0x0cbb, TRY_LEAVE, TryCatch #33 {Exception -> 0x0cbb, blocks: (B:531:0x0c3e, B:543:0x0c79, B:556:0x0ced, B:635:0x0e07, B:637:0x0e16, B:638:0x0e1d, B:640:0x0e33, B:652:0x0e74, B:654:0x0e7a, B:656:0x0e86, B:658:0x0e8e, B:661:0x0e9c, B:663:0x0ea2, B:665:0x0eb0, B:675:0x0ed0, B:678:0x0ee0, B:667:0x0eba, B:669:0x0ec0, B:672:0x0eca, B:685:0x0ef8, B:693:0x0f15, B:695:0x0f22, B:697:0x0f28, B:699:0x0f34, B:701:0x0f38, B:703:0x0f3c, B:708:0x0f5d, B:711:0x0f6c, B:712:0x0f7e, B:714:0x0f8a, B:716:0x0f97, B:722:0x0fa9, B:731:0x0fc9, B:733:0x0fcf, B:742:0x0ff3, B:736:0x0fdd, B:725:0x0fb7, B:641:0x0e3d, B:616:0x0dd2, B:618:0x0dda, B:620:0x0de6, B:542:0x0c64, B:497:0x0b77, B:499:0x0b86, B:503:0x0b99, B:510:0x0bc4, B:512:0x0bca, B:517:0x0bdd, B:519:0x0bf0, B:522:0x0bfd, B:524:0x0c07, B:525:0x0c2d), top: B:922:0x0951 }] */
    /* JADX WARN: Removed duplicated region for block: B:739:0x0fed  */
    /* JADX WARN: Removed duplicated region for block: B:746:0x0ffe  */
    /* JADX WARN: Removed duplicated region for block: B:758:0x1023  */
    /* JADX WARN: Removed duplicated region for block: B:781:0x1083  */
    /* JADX WARN: Removed duplicated region for block: B:882:0x0366 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:886:0x04b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:889:0x1005 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:905:0x081f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v4, types: [jv0] */
    /* JADX WARN: Type inference failed for: r13v53 */
    /* JADX WARN: Type inference failed for: r13v54 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v126 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r77v11 */
    /* JADX WARN: Type inference failed for: r77v12 */
    /* JADX WARN: Type inference failed for: r77v14 */
    /* JADX WARN: Type inference failed for: r77v15 */
    /* JADX WARN: Type inference failed for: r77v16 */
    /* JADX WARN: Type inference failed for: r77v18 */
    /* JADX WARN: Type inference failed for: r77v19 */
    /* JADX WARN: Type inference failed for: r77v22 */
    /* JADX WARN: Type inference failed for: r77v27 */
    /* JADX WARN: Type inference failed for: r77v28 */
    /* JADX WARN: Type inference failed for: r77v29 */
    /* JADX WARN: Type inference failed for: r77v3 */
    /* JADX WARN: Type inference failed for: r77v30 */
    /* JADX WARN: Type inference failed for: r77v31 */
    /* JADX WARN: Type inference failed for: r77v32 */
    /* JADX WARN: Type inference failed for: r77v33 */
    /* JADX WARN: Type inference failed for: r77v34 */
    /* JADX WARN: Type inference failed for: r77v37 */
    /* JADX WARN: Type inference failed for: r77v38 */
    /* JADX WARN: Type inference failed for: r77v39 */
    /* JADX WARN: Type inference failed for: r77v4 */
    /* JADX WARN: Type inference failed for: r77v40 */
    /* JADX WARN: Type inference failed for: r77v41 */
    /* JADX WARN: Type inference failed for: r77v42 */
    /* JADX WARN: Type inference failed for: r77v43 */
    /* JADX WARN: Type inference failed for: r77v44 */
    /* JADX WARN: Type inference failed for: r77v45 */
    /* JADX WARN: Type inference failed for: r77v46 */
    /* JADX WARN: Type inference failed for: r77v47 */
    /* JADX WARN: Type inference failed for: r77v48 */
    /* JADX WARN: Type inference failed for: r77v49 */
    /* JADX WARN: Type inference failed for: r77v50 */
    /* JADX WARN: Type inference failed for: r77v51 */
    /* JADX WARN: Type inference failed for: r77v52 */
    /* JADX WARN: Type inference failed for: r77v53 */
    /* JADX WARN: Type inference failed for: r77v54 */
    /* JADX WARN: Type inference failed for: r77v55 */
    /* JADX WARN: Type inference failed for: r77v56 */
    /* JADX WARN: Type inference failed for: r77v57 */
    /* JADX WARN: Type inference failed for: r77v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final jv0 E(ContentValues contentValues, SQLiteDatabase sQLiteDatabase, Uri uri, boolean[] zArr) throws Throwable {
        Object obj;
        Object obj2;
        Object obj3;
        Exception exc;
        long jB;
        long jB2;
        long jB3;
        long jB4;
        ?? r77;
        ?? r13;
        ?? r772;
        Object obj4;
        Object obj5;
        Object obj6;
        int i;
        boolean z;
        int iIntValue;
        int i2;
        String str;
        boolean z2;
        String str2;
        String string;
        Object obj7;
        String asString;
        String asString2;
        String str3;
        String str4;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        String str5;
        String str6;
        Cursor cursorG;
        jv0 jv0Var;
        Object obj8;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i4;
        int i5;
        Cursor cursor;
        long j;
        boolean z6;
        String str12;
        String str13;
        Exception e;
        int i6;
        int i7;
        String str14;
        boolean z7;
        SocialContentProvider socialContentProvider;
        String str15;
        int iB;
        String str16;
        int i8;
        String str17;
        int i9;
        jv0 jv0Var2;
        String str18;
        String str19;
        String str20;
        int i10;
        String str21;
        String str22;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        ?? r773;
        ?? r774;
        Object obj9;
        ?? r775;
        Cursor cursorG2;
        String str23;
        long j2;
        String str24;
        boolean z8;
        String str25;
        boolean z9;
        String str26;
        int circleThreadHasNoticeStatus;
        int circleThreadHasVoucherStatus;
        boolean z10;
        String str27;
        int i20;
        String str28;
        int i21;
        int i22;
        String str29;
        String str30;
        ?? r776;
        int i23;
        String str31;
        int i24;
        int i25;
        ContentValues contentValues2;
        int i26;
        ContentValues contentValues3;
        int i27;
        String str32;
        String str33;
        String str34;
        int i28;
        String str35;
        String str36;
        int i29;
        Object obj10;
        Object obj11;
        String str37;
        String strX;
        CircleNotice circleNotice;
        String asString3;
        ?? r777;
        String str38;
        String str39;
        String str40;
        int iIntValue2;
        Integer asInteger;
        int i30;
        int i31;
        long j3;
        boolean z11;
        String str41;
        String str42;
        String str43;
        boolean z12;
        String str44;
        String str45;
        int i32;
        boolean z13;
        int i33;
        String str46;
        int i34;
        String str47;
        int i35;
        boolean z14;
        vh5 vh5Var;
        Cursor cursor2;
        String str48;
        long j4;
        long j5;
        Object obj12;
        Object obj13;
        String str49;
        int iC;
        RichMsgVo richMsgVo;
        SuperGreetingsVo superGreetingsVo;
        boolean z15;
        String asString4;
        JSONArray jSONArray;
        jv0 jv0Var3;
        int i36;
        int i37;
        long j6;
        boolean z16;
        long j7;
        boolean z17;
        boolean zX;
        String str50;
        String nameForShow;
        String str51;
        int i38;
        int i39;
        int i40;
        int i41;
        JSONException jSONException;
        String strC;
        JSONObject jSONObjectOptJSONObject;
        Object obj14 = "title";
        vh5 vh5Var2 = new vh5(sQLiteDatabase, a());
        jv0 jv0Var4 = new jv0();
        long jB5 = ir5.b();
        try {
            obj5 = contentValues.get("resource_version");
            obj6 = contentValues.get("resource_type");
            i = 0;
        } catch (Exception e2) {
            e = e2;
            obj14 = jv0Var4;
            obj = " ";
        }
        if (obj5 == null || obj6 == null) {
            z = true;
            contentValues.remove("resource_version");
            contentValues.remove("resource_type");
            if (z || contentValues.get(CommonCode.MapKey.UPDATE_VERSION) != null) {
                return jv0Var4;
            }
            iIntValue = ((Integer) contentValues.get("msg_type")).intValue();
            if (iIntValue != 42) {
                jv0Var4.b = f46.i(sQLiteDatabase, (String) contentValues.get("msg_extend"), contentValues.getAsInteger("data1").intValue(), contentValues.containsKey("thread_biz_type") ? contentValues.getAsInteger("thread_biz_type").intValue() : 0);
                return jv0Var4;
            }
            if (iIntValue == 1 && mb4.j(contentValues.getAsString("data2"))) {
                return jv0Var4;
            }
            if (contentValues.containsKey("thread_biz_type")) {
                int iIntValue3 = contentValues.getAsInteger("thread_biz_type").intValue();
                contentValues.remove("thread_biz_type");
                i2 = iIntValue3;
            } else {
                i2 = 0;
            }
            if (contentValues.containsKey("is_greeting")) {
                boolean zBooleanValue = contentValues.getAsBoolean("is_greeting").booleanValue();
                str = "thread_biz_type";
                contentValues.remove("is_greeting");
                z2 = zBooleanValue;
            } else {
                str = "thread_biz_type";
                z2 = false;
            }
            if (contentValues.containsKey("icon_url")) {
                String asString5 = contentValues.getAsString("icon_url");
                contentValues.remove("icon_url");
                str2 = asString5;
            } else {
                str2 = "";
            }
            if (contentValues.containsKey("title")) {
                String asString6 = contentValues.getAsString("title");
                contentValues.remove("title");
                string = asString6;
            } else {
                string = "";
            }
            String str52 = (String) contentValues.get("contact_relate");
            if (str52 == null) {
                HashMap map = new HashMap();
                map.put("values", contentValues.toString());
                LogUtil.log4ClientError("provider_insert_msg_contactRelate", map, null);
                return jv0Var4;
            }
            try {
            } catch (Exception e3) {
                e = e3;
            }
            if (str52.equals("voip") || (iIntValue == 30 && ("@voip.youni".equals(str52) || str52.contains("voip")))) {
                Log.i("SocialContentProvider", "messageMIMEType:voip message,return");
                return jv0Var4;
            }
            if (iIntValue == 102 || iIntValue == 50) {
                return jv0Var4;
            }
            if (iIntValue == 35) {
                try {
                    asString = contentValues.getAsString("data1");
                    asString2 = contentValues.getAsString("data2");
                    str3 = "data2";
                } catch (Exception e4) {
                    exc = e4;
                    jB = jB5;
                    jB2 = jB;
                    jB3 = jB2;
                    jB4 = jB3;
                    obj7 = jv0Var4;
                }
                if (String.valueOf(0).equals(asString) && String.valueOf(0).equals(asString2)) {
                    GiftMessageExtensionBean giftMessageExtensionBeanN = GiftMessageHelper.N((String) contentValues.get("msg_extend"), 2 == contentValues.getAsInteger("type").intValue());
                    String str53 = (giftMessageExtensionBeanN == null || TextUtils.isEmpty(giftMessageExtensionBeanN.unOpenGiftName)) ? "[礼物]" : giftMessageExtensionBeanN.unOpenGiftName;
                    if (contentValues.containsKey("message")) {
                        contentValues.remove("message");
                    }
                    contentValues.put("message", str53);
                    str4 = str52;
                } else {
                    str4 = str52;
                    int i42 = 1;
                    if (String.valueOf(1).equals(asString)) {
                        if (String.valueOf(1).equals(asString2)) {
                            String str54 = "[礼物]";
                            ChatGiftMessageExtensionBean chatGiftMessageExtensionBeanQ = GiftMessageHelper.Q((String) contentValues.get("msg_extend"));
                            if (chatGiftMessageExtensionBeanQ != null && !TextUtils.isEmpty(chatGiftMessageExtensionBeanQ.subTitle)) {
                                str54 = chatGiftMessageExtensionBeanQ.subTitle;
                            }
                            if (contentValues.containsKey("message")) {
                                contentValues.remove("message");
                            }
                            contentValues.put("message", str54);
                        } else {
                            i42 = 1;
                        }
                    }
                    if (String.valueOf(i42).equals(asString) && String.valueOf(2).equals(asString2)) {
                        String string2 = "[礼物]";
                        ChatGiftMessageExtensionBean chatGiftMessageExtensionBeanQ2 = GiftMessageHelper.Q((String) contentValues.get("msg_extend"));
                        if (chatGiftMessageExtensionBeanQ2 == null || TextUtils.isEmpty(chatGiftMessageExtensionBeanQ2.subTitle)) {
                            i3 = iIntValue;
                        } else if (contentValues.getAsInteger("type").intValue() == 1) {
                            GiftReceiverInfo giftReceiverInfo = chatGiftMessageExtensionBeanQ2.toUser;
                            if ((giftReceiverInfo == null || (str5 = giftReceiverInfo.uid) == null || !str5.equals(c)) ? false : true) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("送你");
                                i3 = iIntValue;
                                sb.append(chatGiftMessageExtensionBeanQ2.itemCount);
                                sb.append("个 ");
                                sb.append(chatGiftMessageExtensionBeanQ2.subTitle);
                                string2 = sb.toString();
                                z5 = true;
                                if (contentValues.containsKey("message")) {
                                    contentValues.remove("message");
                                }
                                contentValues.put("message", string2);
                                z3 = z5;
                                z4 = false;
                                String str55 = (String) contentValues.get("msg_extend");
                                String str56 = (String) contentValues.get("packet_id");
                                String[] strArr = {str56};
                                String str57 = str3;
                                String str58 = str;
                                str6 = str4;
                                int i43 = i3;
                                boolean z18 = z3;
                                cursorG = vh5Var2.g(DBUriManager.h(uri), null, "packet_id=?", strArr, null, null, null);
                                long jLongValue = ((Long) contentValues.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)).longValue();
                                if (cursorG.moveToFirst()) {
                                }
                                cursor.close();
                                jB3 = ir5.b();
                                if (i5 != 17) {
                                }
                                String strY = (String) contentValues.get("message");
                                if (i5 != i4) {
                                }
                                socialContentProvider = this;
                                str15 = strY;
                                z7 = true;
                                iB = m40.b(str6);
                                String strJ = DomainHelper.j(str6);
                                if (iB == 1) {
                                }
                                if (iB == 0) {
                                }
                                jB4 = ir5.b();
                                String[] strArr2 = {str18};
                                int i44 = i10;
                                String str59 = str18;
                                String str60 = str21;
                                String str61 = str22;
                                int i45 = i11;
                                String str62 = str20;
                                cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr2, null, null, null);
                                if (cursorG2 != null) {
                                }
                            } else {
                                i3 = iIntValue;
                                string2 = "送出了" + chatGiftMessageExtensionBeanQ2.itemCount + "个 " + chatGiftMessageExtensionBeanQ2.subTitle;
                            }
                        } else {
                            i3 = iIntValue;
                            string2 = "送出了" + chatGiftMessageExtensionBeanQ2.itemCount + "个 " + chatGiftMessageExtensionBeanQ2.subTitle;
                        }
                        z5 = false;
                        if (contentValues.containsKey("message")) {
                        }
                        contentValues.put("message", string2);
                        z3 = z5;
                        z4 = false;
                        String str552 = (String) contentValues.get("msg_extend");
                        String str562 = (String) contentValues.get("packet_id");
                        String[] strArr3 = {str562};
                        String str572 = str3;
                        String str582 = str;
                        str6 = str4;
                        int i432 = i3;
                        boolean z182 = z3;
                        cursorG = vh5Var2.g(DBUriManager.h(uri), null, "packet_id=?", strArr3, null, null, null);
                        long jLongValue2 = ((Long) contentValues.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)).longValue();
                        if (cursorG.moveToFirst()) {
                        }
                        cursor.close();
                        jB3 = ir5.b();
                        if (i5 != 17) {
                        }
                        String strY2 = (String) contentValues.get("message");
                        if (i5 != i4) {
                        }
                        socialContentProvider = this;
                        str15 = strY2;
                        z7 = true;
                        iB = m40.b(str6);
                        String strJ2 = DomainHelper.j(str6);
                        if (iB == 1) {
                        }
                        if (iB == 0) {
                        }
                        jB4 = ir5.b();
                        String[] strArr22 = {str18};
                        int i442 = i10;
                        String str592 = str18;
                        String str602 = str21;
                        String str612 = str22;
                        int i452 = i11;
                        String str622 = str20;
                        cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr22, null, null, null);
                        if (cursorG2 != null) {
                        }
                    } else {
                        i3 = iIntValue;
                        if (String.valueOf(1).equals(asString)) {
                            if (String.valueOf(3).equals(asString2)) {
                                z3 = false;
                                z4 = true;
                                String str5522 = (String) contentValues.get("msg_extend");
                                String str5622 = (String) contentValues.get("packet_id");
                                String[] strArr32 = {str5622};
                                String str5722 = str3;
                                String str5822 = str;
                                str6 = str4;
                                int i4322 = i3;
                                boolean z1822 = z3;
                                cursorG = vh5Var2.g(DBUriManager.h(uri), null, "packet_id=?", strArr32, null, null, null);
                                long jLongValue22 = ((Long) contentValues.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)).longValue();
                                if (cursorG.moveToFirst()) {
                                    cursor = cursorG;
                                    str11 = "contact_relate";
                                    str8 = "icon_url";
                                    str9 = str5722;
                                    i5 = i4322;
                                    str7 = "";
                                    jv0Var = jv0Var4;
                                    str10 = "type";
                                    i4 = 10001;
                                    if (i5 == 10001 || i5 == 44) {
                                        cursor.close();
                                        return jv0Var;
                                    }
                                    try {
                                        jv0Var.f18513a = vh5Var2.f(DBUriManager.h(uri), null, contentValues);
                                        j = jLongValue22;
                                        z6 = false;
                                    } catch (Exception e5) {
                                        e = e5;
                                        obj14 = jv0Var;
                                        obj = " ";
                                        exc = e;
                                        obj3 = obj14;
                                        obj2 = obj;
                                        jB = jB5;
                                        jB2 = jB;
                                        jB3 = jB2;
                                        jB4 = jB3;
                                        obj4 = obj3;
                                        r772 = obj2;
                                    }
                                } else {
                                    try {
                                        try {
                                            jv0Var4.f18513a = cursorG.getInt(cursorG.getColumnIndex("_id"));
                                        } catch (Exception e6) {
                                            e = e6;
                                            jv0Var = jv0Var4;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        jv0Var = jv0Var4;
                                    }
                                    try {
                                        if (i4322 == 44) {
                                            String string3 = cursorG.getString(cursorG.getColumnIndex(str5722));
                                            if (cursorG.getInt(cursorG.getColumnIndex("type")) != 2 || TextUtils.isEmpty(string3)) {
                                                String string4 = cursorG.getString(cursorG.getColumnIndex("data4"));
                                                me3.a aVarD = me3.d(string4);
                                                if (!TextUtils.isEmpty(aVarD.f19200a)) {
                                                    String strA = me3.a(contentValues.getAsString("message"), aVarD.f19200a);
                                                    if (string4 != null && !string4.equals(strA)) {
                                                        ContentValues contentValues4 = new ContentValues();
                                                        contentValues4.put("data4", strA);
                                                        contentValues4.put(str5722, "");
                                                        vh5Var2.i(DBUriManager.h(uri), contentValues4, "packet_id=?", strArr32);
                                                    }
                                                }
                                            }
                                            cursorG.close();
                                            return jv0Var4;
                                        }
                                        str7 = "";
                                        long j8 = cursorG.getLong(cursorG.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
                                        if (j8 > 0) {
                                            contentValues.remove(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE);
                                        } else {
                                            j8 = jLongValue22;
                                        }
                                        if (i4322 == 3 && cursorG.getInt(cursorG.getColumnIndex("read")) == 1) {
                                            contentValues.remove("read");
                                        }
                                        if (i4322 == 10001) {
                                            m(cursorG);
                                        }
                                        str8 = "icon_url";
                                        str9 = str5722;
                                        str10 = "type";
                                        jv0Var = jv0Var4;
                                        str11 = "contact_relate";
                                        i4 = 10001;
                                        i5 = i4322;
                                        cursor = cursorG;
                                        try {
                                            if (T(vh5Var2, jv0Var4.f18513a, i4322, str5522, cursorG.getString(cursorG.getColumnIndex("contact_relate")), cursorG.getInt(cursorG.getColumnIndex("type")))) {
                                                cursor.close();
                                                return jv0Var;
                                            }
                                            vh5Var2.i(DBUriManager.h(uri), contentValues, "packet_id=?", strArr32);
                                            j = j8;
                                            z6 = true;
                                        } catch (Exception e8) {
                                            e = e8;
                                            exc = e;
                                            obj8 = jv0Var;
                                            jB = jB5;
                                            jB2 = jB;
                                            jB3 = jB2;
                                            jB4 = jB3;
                                            obj7 = obj8;
                                        }
                                    } catch (Exception e9) {
                                        exc = e9;
                                        obj8 = jv0Var4;
                                        jB = jB5;
                                        jB2 = jB;
                                        jB3 = jB2;
                                        jB4 = jB3;
                                        obj7 = obj8;
                                    }
                                    exc = e;
                                    obj8 = jv0Var;
                                    jB = jB5;
                                    jB2 = jB;
                                    jB3 = jB2;
                                    jB4 = jB3;
                                    obj7 = obj8;
                                    r772 = " ";
                                    obj4 = obj7;
                                    exc.printStackTrace();
                                    LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                    r13 = obj4;
                                    r77 = r772;
                                }
                                cursor.close();
                                jB3 = ir5.b();
                                if (i5 != 17) {
                                    try {
                                        str12 = str9;
                                        String[] strArr4 = {(String) contentValues.get(str12)};
                                        ContentValues contentValues5 = new ContentValues();
                                        str13 = "data1";
                                        contentValues5.put(str13, String.valueOf(contentValues.get(str13)));
                                        vh5Var2.i(DBUriManager.h(uri), contentValues5, "data2=?", strArr4);
                                    } catch (Exception e10) {
                                        e = e10;
                                        exc = e;
                                        obj7 = jv0Var;
                                        jB = jB5;
                                        jB2 = jB;
                                        jB4 = jB2;
                                        r772 = " ";
                                        obj4 = obj7;
                                        exc.printStackTrace();
                                        LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                        r13 = obj4;
                                        r77 = r772;
                                        long jB6 = ir5.b();
                                        ?? sb2 = new StringBuilder();
                                        sb2.append("inserttimecost  ");
                                        sb2.append(jB3 - jB5);
                                        ?? r4 = r77;
                                        sb2.append(r4);
                                        sb2.append(jB4 - jB3);
                                        sb2.append(r4);
                                        sb2.append(jB - jB4);
                                        sb2.append(r4);
                                        sb2.append(jB2 - jB);
                                        sb2.append(r4);
                                        sb2.append(jB6 - jB2);
                                        LogUtil.i("SocialContentProvider", sb2.toString());
                                        return r13;
                                    }
                                } else {
                                    str13 = "data1";
                                    str12 = str9;
                                }
                                String strY22 = (String) contentValues.get("message");
                                if (i5 != i4) {
                                    str14 = str5522;
                                    if (str14 != null) {
                                        try {
                                            try {
                                                jSONObjectOptJSONObject = new JSONObject(str14).optJSONObject("revokeMsg");
                                            } catch (Exception e11) {
                                                e = e11;
                                                exc = e;
                                                obj7 = jv0Var;
                                                jB = jB5;
                                                jB2 = jB;
                                                jB4 = jB2;
                                                r772 = " ";
                                                obj4 = obj7;
                                            }
                                        } catch (JSONException e12) {
                                            e = e12;
                                            i6 = i5;
                                            i7 = i2;
                                        }
                                        if (jSONObjectOptJSONObject != null) {
                                            String strOptString = jSONObjectOptJSONObject.optString(f.aC);
                                            if (TextUtils.isEmpty(strOptString)) {
                                                i6 = i5;
                                                i7 = i2;
                                                socialContentProvider = this;
                                                strC = str6;
                                            } else {
                                                i7 = i2;
                                                try {
                                                    strC = DomainHelper.c(DomainHelper.t(strOptString), i7);
                                                    try {
                                                    } catch (JSONException e13) {
                                                        e = e13;
                                                        i6 = i5;
                                                        socialContentProvider = this;
                                                    }
                                                } catch (JSONException e14) {
                                                    e = e14;
                                                    i6 = i5;
                                                    socialContentProvider = this;
                                                    jSONException = e;
                                                    strC = str6;
                                                    jSONException.printStackTrace();
                                                    str6 = strC;
                                                    z7 = true;
                                                    str15 = strY22;
                                                    iB = m40.b(str6);
                                                    String strJ22 = DomainHelper.j(str6);
                                                    if (iB == 1) {
                                                    }
                                                    if (iB == 0) {
                                                    }
                                                    jB4 = ir5.b();
                                                    String[] strArr222 = {str18};
                                                    int i4422 = i10;
                                                    String str5922 = str18;
                                                    String str6022 = str21;
                                                    String str6122 = str22;
                                                    int i4522 = i11;
                                                    String str6222 = str20;
                                                    cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr222, null, null, null);
                                                    if (cursorG2 != null) {
                                                    }
                                                    long jB62 = ir5.b();
                                                    ?? sb22 = new StringBuilder();
                                                    sb22.append("inserttimecost  ");
                                                    sb22.append(jB3 - jB5);
                                                    ?? r42 = r77;
                                                    sb22.append(r42);
                                                    sb22.append(jB4 - jB3);
                                                    sb22.append(r42);
                                                    sb22.append(jB - jB4);
                                                    sb22.append(r42);
                                                    sb22.append(jB2 - jB);
                                                    sb22.append(r42);
                                                    sb22.append(jB62 - jB2);
                                                    LogUtil.i("SocialContentProvider", sb22.toString());
                                                    return r13;
                                                }
                                                if (TextUtils.isEmpty(strY22)) {
                                                    i6 = i5;
                                                    socialContentProvider = this;
                                                    try {
                                                        strY22 = socialContentProvider.y(sQLiteDatabase, strC, uri);
                                                        boolean z19 = TextUtils.isEmpty(strY22) ? false : true;
                                                        str6 = strC;
                                                        z7 = z19;
                                                    } catch (JSONException e15) {
                                                        e = e15;
                                                        jSONException = e;
                                                        jSONException.printStackTrace();
                                                        str6 = strC;
                                                        z7 = true;
                                                    }
                                                    str15 = strY22;
                                                    iB = m40.b(str6);
                                                    String strJ222 = DomainHelper.j(str6);
                                                    String str63 = iB == 1 ? strJ222 : str6;
                                                    if (iB == 0) {
                                                        str16 = str15;
                                                        i8 = i6;
                                                        int i46 = i7;
                                                        str17 = str13;
                                                        String str64 = str12;
                                                        String str65 = str63;
                                                        Cursor cursorG3 = vh5Var2.g("tb_contacts", new String[]{"head_img_url", "nick_name", "remark_name", "chat_config", str12}, "uid=?", new String[]{strJ222}, null, null, null);
                                                        if (cursorG3 == null || !cursorG3.moveToNext()) {
                                                            str51 = str64;
                                                            if (i46 == 0) {
                                                                i38 = 0;
                                                                i39 = 0;
                                                                i40 = 0;
                                                                i41 = 0;
                                                                i46 = 13;
                                                            } else {
                                                                i38 = 0;
                                                                i39 = 0;
                                                                i40 = 0;
                                                                i41 = 0;
                                                            }
                                                        } else {
                                                            String string5 = cursorG3.getString(cursorG3.getColumnIndex("head_img_url"));
                                                            String string6 = cursorG3.getString(cursorG3.getColumnIndex("remark_name"));
                                                            if (!TextUtils.isEmpty(string6)) {
                                                                string = string6;
                                                            }
                                                            if (TextUtils.isEmpty(string)) {
                                                                string = cursorG3.getString(cursorG3.getColumnIndex("nick_name"));
                                                            }
                                                            if (TextUtils.isEmpty(string)) {
                                                                string = strJ222;
                                                            }
                                                            int i47 = cursorG3.getInt(cursorG3.getColumnIndex("chat_config"));
                                                            i40 = jw5.j(i47) ? 100 : 0;
                                                            i41 = jw5.g(i47) ? 1 : 0;
                                                            i39 = jw5.e(i47) ? 1 : 0;
                                                            str51 = str64;
                                                            boolean z20 = cursorG3.getInt(cursorG3.getColumnIndex(str51)) != 0;
                                                            if (fu5.t(i46)) {
                                                                if (!fu5.k(i46).saveInTempTable && !z20) {
                                                                    i46 = 0;
                                                                }
                                                                str2 = string5;
                                                                i38 = 1;
                                                            } else {
                                                                if (!z20) {
                                                                    i46 = 0;
                                                                } else if (i46 == 0) {
                                                                    i46 = 13;
                                                                }
                                                                str2 = string5;
                                                                i38 = 1;
                                                            }
                                                        }
                                                        if (cursorG3 != null) {
                                                            cursorG3.close();
                                                        }
                                                        i11 = i38;
                                                        jv0Var2 = jv0Var;
                                                        str21 = str2;
                                                        i9 = iB;
                                                        i14 = 0;
                                                        str19 = str51;
                                                        str20 = str7;
                                                        int i48 = i46;
                                                        i12 = i39;
                                                        i10 = i48;
                                                        i13 = i40;
                                                        str18 = str65;
                                                        String str66 = string;
                                                        i15 = i41;
                                                        str22 = str66;
                                                    } else {
                                                        str16 = str15;
                                                        i8 = i6;
                                                        int i49 = i7;
                                                        str17 = str13;
                                                        String str67 = str63;
                                                        String str68 = str12;
                                                        if (iB == 1) {
                                                            try {
                                                                i9 = iB;
                                                                jv0Var2 = jv0Var;
                                                                str19 = str68;
                                                            } catch (Exception e16) {
                                                                e = e16;
                                                                jv0Var2 = jv0Var;
                                                            }
                                                            try {
                                                                Cursor cursorG4 = vh5Var2.g(DBUriManager.e(uri), new String[]{"headImgUrl", "name", "group_config", "local_name", "owner", "group_extra_info"}, "group_id=?", new String[]{str67}, null, null, null);
                                                                if (cursorG4 == null || !cursorG4.moveToNext()) {
                                                                    str18 = str67;
                                                                    str20 = str7;
                                                                    i16 = 0;
                                                                    i17 = 0;
                                                                    i18 = 0;
                                                                    i19 = 0;
                                                                } else {
                                                                    String string7 = cursorG4.getString(cursorG4.getColumnIndex("headImgUrl"));
                                                                    String string8 = cursorG4.getString(cursorG4.getColumnIndex("name"));
                                                                    String string9 = cursorG4.getString(cursorG4.getColumnIndex("local_name"));
                                                                    cursorG4.getString(cursorG4.getColumnIndex("owner"));
                                                                    String string10 = cursorG4.getString(cursorG4.getColumnIndex("group_extra_info"));
                                                                    if (TextUtils.isEmpty(string10)) {
                                                                        str20 = str7;
                                                                    } else {
                                                                        str20 = str7;
                                                                        String strOptString2 = new JSONObject(string10).optString("remarkName", str20);
                                                                        if (!TextUtils.isEmpty(strOptString2)) {
                                                                            string8 = strOptString2;
                                                                        }
                                                                    }
                                                                    int i50 = cursorG4.getInt(cursorG4.getColumnIndex("group_config"));
                                                                    i18 = jw5.j(i50) ? 100 : 0;
                                                                    i19 = jw5.g(i50) ? 1 : 0;
                                                                    i17 = jw5.k(i50) ? 1 : 0;
                                                                    if (!TextUtils.isEmpty(string8)) {
                                                                        str18 = str67;
                                                                        string = string8;
                                                                    } else if (TextUtils.isEmpty(string9)) {
                                                                        string = socialContentProvider.z(str67, sQLiteDatabase).f13884a;
                                                                        str18 = str67;
                                                                    } else {
                                                                        string = string9;
                                                                        str18 = str67;
                                                                    }
                                                                    str2 = string7;
                                                                    i16 = 1;
                                                                }
                                                                if (cursorG4 != null) {
                                                                    cursorG4.close();
                                                                }
                                                                i13 = i18;
                                                                i10 = i49;
                                                                str22 = string;
                                                                i12 = 0;
                                                                i15 = i19;
                                                                i11 = i16;
                                                                String str69 = str2;
                                                                i14 = i17;
                                                                str21 = str69;
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                                exc = e;
                                                                jB = jB5;
                                                                jB2 = jB;
                                                                jB4 = jB2;
                                                                r773 = " ";
                                                                obj4 = jv0Var2;
                                                                r772 = r773;
                                                                exc.printStackTrace();
                                                                LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                r13 = obj4;
                                                                r77 = r772;
                                                                long jB622 = ir5.b();
                                                                ?? sb222 = new StringBuilder();
                                                                sb222.append("inserttimecost  ");
                                                                sb222.append(jB3 - jB5);
                                                                ?? r422 = r77;
                                                                sb222.append(r422);
                                                                sb222.append(jB4 - jB3);
                                                                sb222.append(r422);
                                                                sb222.append(jB - jB4);
                                                                sb222.append(r422);
                                                                sb222.append(jB2 - jB);
                                                                sb222.append(r422);
                                                                sb222.append(jB622 - jB2);
                                                                LogUtil.i("SocialContentProvider", sb222.toString());
                                                                return r13;
                                                            }
                                                        } else {
                                                            i9 = iB;
                                                            jv0Var2 = jv0Var;
                                                            str18 = str67;
                                                            str19 = str68;
                                                            str20 = str7;
                                                            i10 = i49;
                                                            str21 = str2;
                                                            str22 = string;
                                                            i11 = 0;
                                                            i12 = 0;
                                                            i13 = 0;
                                                            i14 = 0;
                                                            i15 = 0;
                                                        }
                                                    }
                                                    jB4 = ir5.b();
                                                    String[] strArr2222 = {str18};
                                                    int i44222 = i10;
                                                    String str59222 = str18;
                                                    String str60222 = str21;
                                                    String str61222 = str22;
                                                    int i45222 = i11;
                                                    String str62222 = str20;
                                                    cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr2222, null, null, null);
                                                    if (cursorG2 != null) {
                                                        try {
                                                            if (cursorG2.moveToFirst()) {
                                                                long j9 = cursorG2.getLong(cursorG2.getColumnIndex("latest_message_time_stamp"));
                                                                String string11 = cursorG2.getString(cursorG2.getColumnIndex("thread_message_mid"));
                                                                String string12 = cursorG2.getString(cursorG2.getColumnIndex("thread_biz_extension"));
                                                                str23 = str5822;
                                                                int i51 = cursorG2.getInt(cursorG2.getColumnIndex(str23));
                                                                j2 = j9;
                                                                StringBuilder sb3 = new StringBuilder();
                                                                sb3.append("updateThreadOnNewMsg preBizType");
                                                                sb3.append(i51);
                                                                sb3.append(" bizType=");
                                                                int i52 = i44222;
                                                                sb3.append(i52);
                                                                LogUtil.i("logaddfriend", sb3.toString());
                                                                if (i52 == 13) {
                                                                    i52 = i51;
                                                                }
                                                                if (fu5.t(i52) && fu5.t(i51)) {
                                                                    i52 = i51;
                                                                }
                                                                if (!z6 || TextUtils.isEmpty(string11)) {
                                                                    str24 = str5622;
                                                                } else {
                                                                    String str70 = str5622;
                                                                    boolean zEquals = string11.equals(str70);
                                                                    str24 = str70;
                                                                    if (!zEquals) {
                                                                        z8 = false;
                                                                        str25 = str70;
                                                                    }
                                                                    int i53 = cursorG2.getInt(cursorG2.getColumnIndex("thread_has_remind"));
                                                                    z9 = z8;
                                                                    str26 = str62222;
                                                                    circleThreadHasNoticeStatus = CircleNoticeItem.getCircleThreadHasNoticeStatus(strJ222);
                                                                    circleThreadHasVoucherStatus = VoucherRedPacketVo.getCircleThreadHasVoucherStatus(strJ222);
                                                                    z10 = false;
                                                                    str27 = string12;
                                                                    i20 = cursorG2.getInt(cursorG2.getColumnIndex("thread_message_status"));
                                                                    str28 = string11;
                                                                    i21 = i52;
                                                                    i22 = i53;
                                                                    str29 = str25;
                                                                }
                                                                z8 = true;
                                                                str25 = str24;
                                                                int i532 = cursorG2.getInt(cursorG2.getColumnIndex("thread_has_remind"));
                                                                z9 = z8;
                                                                str26 = str62222;
                                                                circleThreadHasNoticeStatus = CircleNoticeItem.getCircleThreadHasNoticeStatus(strJ222);
                                                                circleThreadHasVoucherStatus = VoucherRedPacketVo.getCircleThreadHasVoucherStatus(strJ222);
                                                                z10 = false;
                                                                str27 = string12;
                                                                i20 = cursorG2.getInt(cursorG2.getColumnIndex("thread_message_status"));
                                                                str28 = string11;
                                                                i21 = i52;
                                                                i22 = i532;
                                                                str29 = str25;
                                                            } else {
                                                                str29 = str5622;
                                                                str23 = str5822;
                                                                i21 = i44222;
                                                                str26 = str62222;
                                                                j2 = 0;
                                                                str28 = null;
                                                                i22 = 0;
                                                                i20 = 0;
                                                                str27 = null;
                                                                z10 = true;
                                                                z9 = true;
                                                                circleThreadHasNoticeStatus = 0;
                                                                circleThreadHasVoucherStatus = 0;
                                                            }
                                                            ContentValues contentValues6 = new ContentValues();
                                                            int i54 = i22;
                                                            String str71 = str11;
                                                            Cursor cursor3 = cursorG2;
                                                            contentValues6.put(str71, str59222);
                                                            int i55 = i20;
                                                            contentValues6.put(str8, str60222);
                                                            if (TextUtils.isEmpty(str61222)) {
                                                                str30 = str61222;
                                                            } else {
                                                                str30 = str61222;
                                                                contentValues6.put("title", str30);
                                                            }
                                                            contentValues6.put("thread_priority", Integer.valueOf(i13));
                                                            contentValues6.put("thread_nodisturb", Integer.valueOf(i15));
                                                            contentValues6.put("thread_blacklist", Integer.valueOf(i12));
                                                            contentValues6.put("thread_show_members_nick_name", Integer.valueOf(i14));
                                                            contentValues6.put(str23, Integer.valueOf(i21));
                                                            String str72 = str19;
                                                            int i56 = i8;
                                                            try {
                                                                if (i56 != 9) {
                                                                    i23 = i21;
                                                                    str31 = str23;
                                                                    i24 = i54;
                                                                    i25 = i55;
                                                                    contentValues2 = contentValues6;
                                                                    i26 = i9;
                                                                    if (i56 == 6) {
                                                                        if (z9) {
                                                                            String str73 = (String) contentValues.get("data3");
                                                                            String strE = m40.e(contentValues.getAsString("src"));
                                                                            if (i26 != 1 || strE == null || strE.equals(a())) {
                                                                                i29 = i26;
                                                                                contentValues3 = contentValues2;
                                                                                i27 = i24;
                                                                                str32 = str30;
                                                                                contentValues3.put("latest_message", str16 + str73);
                                                                            } else {
                                                                                str32 = str30;
                                                                                contentValues3 = contentValues2;
                                                                                i29 = i26;
                                                                                i27 = i24;
                                                                                contentValues3.put("latest_message", x(sQLiteDatabase, str59222, strE, uri, str14) + ": " + str16 + str73);
                                                                            }
                                                                        }
                                                                        contentValues3 = contentValues2;
                                                                        str32 = str30;
                                                                        str34 = strJ222;
                                                                        r774 = " ";
                                                                        str36 = "msg_extend";
                                                                        str35 = str17;
                                                                        i29 = i26;
                                                                        i28 = i24;
                                                                        if (j > j2) {
                                                                        }
                                                                        if (z9) {
                                                                        }
                                                                        contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                        contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                        contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                    } else {
                                                                        contentValues3 = contentValues2;
                                                                        i27 = i24;
                                                                        str32 = str30;
                                                                        String str74 = str16;
                                                                        if (i56 == 7) {
                                                                            if (z9) {
                                                                                contentValues3.put("latest_message", str74);
                                                                            }
                                                                        } else if (i56 == 52) {
                                                                            if (z9) {
                                                                                contentValues3.put("latest_message", str74);
                                                                            }
                                                                        } else if (i56 != 33) {
                                                                            if (i56 != 34) {
                                                                                str33 = str17;
                                                                                ?? r5 = 37;
                                                                                if (i56 == 37) {
                                                                                    if (z9) {
                                                                                        try {
                                                                                            asString3 = contentValues.getAsString(str33);
                                                                                        } catch (Exception e18) {
                                                                                            e = e18;
                                                                                            r5 = " ";
                                                                                        }
                                                                                        try {
                                                                                            if (asString3 != null && asString3.equals(String.valueOf(1))) {
                                                                                                VenusRoomShareCard venusRoomShareCardI = p96.i(str14);
                                                                                                String str75 = venusRoomShareCardI != null ? venusRoomShareCardI.content : str74;
                                                                                                StringBuilder sb4 = new StringBuilder();
                                                                                                String str76 = " ";
                                                                                                sb4.append(str76);
                                                                                                sb4.append(str75);
                                                                                                contentValues3.put("latest_message", sb4.toString());
                                                                                                r5 = str76;
                                                                                            } else {
                                                                                                r5 = " ";
                                                                                                contentValues3.put("latest_message", str74);
                                                                                            }
                                                                                            r777 = r5;
                                                                                            i29 = i26;
                                                                                            i28 = i27;
                                                                                            str34 = strJ222;
                                                                                            str36 = "msg_extend";
                                                                                        } catch (Exception e19) {
                                                                                            e = e19;
                                                                                            exc = e;
                                                                                            r776 = r5;
                                                                                            jB = jB5;
                                                                                            jB2 = jB;
                                                                                            r773 = r776;
                                                                                            obj4 = jv0Var2;
                                                                                            r772 = r773;
                                                                                            exc.printStackTrace();
                                                                                            LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                                            r13 = obj4;
                                                                                            r77 = r772;
                                                                                            long jB6222 = ir5.b();
                                                                                            ?? sb2222 = new StringBuilder();
                                                                                            sb2222.append("inserttimecost  ");
                                                                                            sb2222.append(jB3 - jB5);
                                                                                            ?? r4222 = r77;
                                                                                            sb2222.append(r4222);
                                                                                            sb2222.append(jB4 - jB3);
                                                                                            sb2222.append(r4222);
                                                                                            sb2222.append(jB - jB4);
                                                                                            sb2222.append(r4222);
                                                                                            sb2222.append(jB2 - jB);
                                                                                            sb2222.append(r4222);
                                                                                            sb2222.append(jB6222 - jB2);
                                                                                            LogUtil.i("SocialContentProvider", sb2222.toString());
                                                                                            return r13;
                                                                                        }
                                                                                    }
                                                                                    str35 = str33;
                                                                                    r774 = r777;
                                                                                    if (j > j2) {
                                                                                    }
                                                                                    if (z9) {
                                                                                    }
                                                                                    contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                                    contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                                    contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                                } else {
                                                                                    if (i56 != 53) {
                                                                                        str34 = strJ222;
                                                                                        Object obj15 = " ";
                                                                                        i28 = i27;
                                                                                        str35 = str33;
                                                                                        obj10 = obj15;
                                                                                        if (i56 != 10001) {
                                                                                            if (z9) {
                                                                                                str36 = "msg_extend";
                                                                                                String strI = i56 == 28 ? g.i(contentValues.getAsString(str36), contentValues.getAsString(str35), str74, contentValues.getAsString("src")) : str74;
                                                                                                String strE2 = m40.e(contentValues.getAsString("src"));
                                                                                                if (i26 != 1 || strE2 == null || strE2.equals(a())) {
                                                                                                    i29 = i26;
                                                                                                    contentValues3.put("latest_message", strI);
                                                                                                    r774 = obj15;
                                                                                                } else {
                                                                                                    i29 = i26;
                                                                                                    contentValues3.put("latest_message", x(sQLiteDatabase, str59222, strE2, uri, str14) + ": " + strI);
                                                                                                    r774 = obj15;
                                                                                                }
                                                                                            }
                                                                                            if (j > j2) {
                                                                                            }
                                                                                            if (z9) {
                                                                                            }
                                                                                            contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                                            contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                                            contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                                        } else if (str29.equals(str28)) {
                                                                                            contentValues3.put("latest_message", str74);
                                                                                            obj10 = obj15;
                                                                                        } else {
                                                                                            i29 = i26;
                                                                                            str36 = "msg_extend";
                                                                                            z9 = false;
                                                                                            r774 = obj15;
                                                                                            if (j > j2) {
                                                                                            }
                                                                                            if (z9) {
                                                                                            }
                                                                                            contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                                            contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                                            contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                                        }
                                                                                    } else if (z9) {
                                                                                        try {
                                                                                            String content = (TextUtils.isEmpty(str14) || (circleNotice = (CircleNotice) az2.a(str14, CircleNotice.class)) == null || circleNotice.getNotice() == null || circleNotice.getNotice().getStatus() != 2) ? str74 : circleNotice.getNotice().getContent();
                                                                                            String strE3 = m40.e(contentValues.getAsString("src"));
                                                                                            if (i26 != 1 || strE3 == null) {
                                                                                                str34 = strJ222;
                                                                                                obj11 = " ";
                                                                                                str37 = content;
                                                                                                i28 = i27;
                                                                                                str35 = str33;
                                                                                                strX = str26;
                                                                                                StringBuilder sb5 = new StringBuilder();
                                                                                                sb5.append(strX);
                                                                                                sb5.append(TextUtils.isEmpty(strX) ? ":" : str26);
                                                                                                sb5.append(str37);
                                                                                                contentValues3.put("latest_message", sb5.toString());
                                                                                                obj10 = obj11;
                                                                                            } else {
                                                                                                if (!strE3.equals(a())) {
                                                                                                    str34 = strJ222;
                                                                                                    obj11 = " ";
                                                                                                    str37 = content;
                                                                                                    i28 = i27;
                                                                                                    str35 = str33;
                                                                                                    strX = x(sQLiteDatabase, str59222, strE3, uri, str14);
                                                                                                }
                                                                                                StringBuilder sb52 = new StringBuilder();
                                                                                                sb52.append(strX);
                                                                                                sb52.append(TextUtils.isEmpty(strX) ? ":" : str26);
                                                                                                sb52.append(str37);
                                                                                                contentValues3.put("latest_message", sb52.toString());
                                                                                                obj10 = obj11;
                                                                                            }
                                                                                        } catch (Exception e20) {
                                                                                            e = e20;
                                                                                            r774 = " ";
                                                                                            exc = e;
                                                                                            r776 = r774;
                                                                                            jB = jB5;
                                                                                            jB2 = jB;
                                                                                            r773 = r776;
                                                                                            obj4 = jv0Var2;
                                                                                            r772 = r773;
                                                                                            exc.printStackTrace();
                                                                                            LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                                            r13 = obj4;
                                                                                            r77 = r772;
                                                                                            long jB62222 = ir5.b();
                                                                                            ?? sb22222 = new StringBuilder();
                                                                                            sb22222.append("inserttimecost  ");
                                                                                            sb22222.append(jB3 - jB5);
                                                                                            ?? r42222 = r77;
                                                                                            sb22222.append(r42222);
                                                                                            sb22222.append(jB4 - jB3);
                                                                                            sb22222.append(r42222);
                                                                                            sb22222.append(jB - jB4);
                                                                                            sb22222.append(r42222);
                                                                                            sb22222.append(jB2 - jB);
                                                                                            sb22222.append(r42222);
                                                                                            sb22222.append(jB62222 - jB2);
                                                                                            LogUtil.i("SocialContentProvider", sb22222.toString());
                                                                                            return r13;
                                                                                        }
                                                                                    } else {
                                                                                        str34 = strJ222;
                                                                                        obj10 = " ";
                                                                                        i28 = i27;
                                                                                        str35 = str33;
                                                                                    }
                                                                                    i29 = i26;
                                                                                    str36 = "msg_extend";
                                                                                    r774 = obj10;
                                                                                    if (j > j2) {
                                                                                    }
                                                                                    if (z9) {
                                                                                    }
                                                                                    contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                                    contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                                    contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                                }
                                                                            } else if (z9) {
                                                                                str33 = str17;
                                                                                String asString7 = contentValues.getAsString(str33);
                                                                                if (asString7 != null && asString7.equals(String.valueOf(1))) {
                                                                                    contentValues3.put("latest_message", "[分享动态]");
                                                                                } else {
                                                                                    contentValues3.put("latest_message", str74);
                                                                                }
                                                                            }
                                                                            i29 = i26;
                                                                            str34 = strJ222;
                                                                            r777 = " ";
                                                                            str36 = "msg_extend";
                                                                            i28 = i27;
                                                                            str35 = str33;
                                                                            r774 = r777;
                                                                            if (j > j2) {
                                                                            }
                                                                            if (z9) {
                                                                            }
                                                                            contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                            contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                            contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                        } else if (z9) {
                                                                            contentValues3.put("latest_message", "[广场帖子]");
                                                                        }
                                                                        i29 = i26;
                                                                    }
                                                                    str34 = strJ222;
                                                                    r774 = " ";
                                                                    str36 = "msg_extend";
                                                                    i28 = i27;
                                                                    str35 = str17;
                                                                    if (j > j2) {
                                                                    }
                                                                    if (z9) {
                                                                    }
                                                                    contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                    contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                    contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                } else if (z9) {
                                                                    String asString8 = contentValues.getAsString("src");
                                                                    ChatItem chatItemFromNameCardString = MessageVo.parseChatItemFromNameCardString(str14);
                                                                    int i57 = i9;
                                                                    if (i57 == 1) {
                                                                        String strE4 = m40.e(asString8);
                                                                        i23 = i21;
                                                                        str31 = str23;
                                                                        i26 = i57;
                                                                        i25 = i55;
                                                                        nameForShow = x(sQLiteDatabase, str59222, strE4, uri, str14);
                                                                        i24 = i54;
                                                                        str50 = strE4;
                                                                    } else {
                                                                        i23 = i21;
                                                                        str31 = str23;
                                                                        i26 = i57;
                                                                        i24 = i54;
                                                                        i25 = i55;
                                                                        ContactInfoItem contactInfoItemR = socialContentProvider.R(sQLiteDatabase, asString8);
                                                                        str50 = asString8;
                                                                        nameForShow = contactInfoItemR != null ? contactInfoItemR.getNameForShow() : null;
                                                                    }
                                                                    contentValues2 = contentValues6;
                                                                    contentValues2.put("latest_message", tw5.a(chatItemFromNameCardString, str50, nameForShow, strJ222, str30, str16));
                                                                    contentValues3 = contentValues2;
                                                                    str32 = str30;
                                                                    str34 = strJ222;
                                                                    r774 = " ";
                                                                    str36 = "msg_extend";
                                                                    str35 = str17;
                                                                    i29 = i26;
                                                                    i28 = i24;
                                                                    long j10 = j > j2 ? j : j2;
                                                                    if (z9) {
                                                                        contentValues3.put("latest_message_time_stamp", Long.valueOf(j10));
                                                                        contentValues3.put("thread_draft_time", Long.valueOf(j10));
                                                                        if (!(i56 == 10000 || i56 == 10002) || i25 != 3) {
                                                                            contentValues3.put("thread_message_status", Integer.valueOf(((Integer) contentValues.get("msg_status")).intValue()));
                                                                        }
                                                                        contentValues3.put("thread_message_mid", (String) contentValues.get("packet_id"));
                                                                        contentValues3.put("latest_message_mime_type", Integer.valueOf(i56));
                                                                        str40 = str72;
                                                                        str39 = str10;
                                                                        str38 = "thread_biz_extension";
                                                                        contentValues3.put(str38, ThreadBizExtHelper.d(i23, contentValues.getAsString("src"), i56, contentValues.getAsString(str35), contentValues.getAsString(str40), contentValues.getAsString(str36), contentValues.getAsInteger(str39).intValue(), str27, z10));
                                                                    } else {
                                                                        str38 = "thread_biz_extension";
                                                                        str39 = str10;
                                                                        str40 = str72;
                                                                    }
                                                                    try {
                                                                        contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                        contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                        contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                        zArr[0] = i45222 == 0 || zArr[0];
                                                                        iIntValue2 = contentValues.getAsInteger(str39).intValue();
                                                                        asInteger = contentValues.getAsInteger("read");
                                                                        if (asInteger != null) {
                                                                            j3 = j10;
                                                                            i30 = i45222;
                                                                            i31 = 1;
                                                                        } else {
                                                                            i30 = i45222;
                                                                            i31 = 1;
                                                                            j3 = j10;
                                                                            z11 = asInteger.intValue() == 1;
                                                                            if (iIntValue2 != i31 || z11) {
                                                                                str41 = str40;
                                                                                str42 = str39;
                                                                                str43 = str38;
                                                                                z12 = z11;
                                                                                str44 = str14;
                                                                                str45 = str26;
                                                                                contentValues3.put("thread_draft_remind_uids", str45);
                                                                                i32 = 1;
                                                                                contentValues3.put("latest_message_read", (Integer) 1);
                                                                                z13 = false;
                                                                            } else if (cursor3 != null) {
                                                                                try {
                                                                                    if (cursor3.moveToFirst()) {
                                                                                        z12 = z11;
                                                                                        boolean z21 = cursor3.getInt(cursor3.getColumnIndex("thread_focus")) == 1;
                                                                                        i36 = cursor3.getInt(cursor3.getColumnIndex("unread_message_count"));
                                                                                        boolean z22 = z21;
                                                                                        i37 = cursor3.getInt(cursor3.getColumnIndex("latest_message_read"));
                                                                                        long j11 = cursor3.getLong(cursor3.getColumnIndex("thread_latest_unread_message_time"));
                                                                                        if (j11 != 0) {
                                                                                            j = j11;
                                                                                        }
                                                                                        long j12 = cursor3.getLong(cursor3.getColumnIndex("thread_latest_unread_message_primary_key_id"));
                                                                                        if (j12 == 0) {
                                                                                            str41 = str40;
                                                                                            str42 = str39;
                                                                                            cursor3 = cursor3;
                                                                                            jv0Var3 = jv0Var2;
                                                                                            try {
                                                                                                j6 = jv0Var3.f18513a;
                                                                                            } catch (Exception e21) {
                                                                                                e = e21;
                                                                                                exc = e;
                                                                                                obj9 = jv0Var3;
                                                                                                r775 = r774;
                                                                                                jB = jB5;
                                                                                                jB2 = jB;
                                                                                                obj4 = obj9;
                                                                                                r772 = r775;
                                                                                            }
                                                                                        } else {
                                                                                            str41 = str40;
                                                                                            str42 = str39;
                                                                                            cursor3 = cursor3;
                                                                                            jv0Var3 = jv0Var2;
                                                                                            j6 = j12;
                                                                                        }
                                                                                        if (i56 == 10001) {
                                                                                            long j13 = jv0Var3.f18513a;
                                                                                            if (j13 != 0 && j12 != 0 && j12 <= j13 && i36 > 0) {
                                                                                                i36--;
                                                                                            }
                                                                                        } else {
                                                                                            i36++;
                                                                                        }
                                                                                        jv0Var2 = jv0Var3;
                                                                                        z16 = z22;
                                                                                        j7 = j6;
                                                                                    } else {
                                                                                        str41 = str40;
                                                                                        str42 = str39;
                                                                                        z12 = z11;
                                                                                        jv0 jv0Var5 = jv0Var2;
                                                                                        int i58 = i56 == 10001 ? 0 : 1;
                                                                                        try {
                                                                                            j7 = jv0Var5.f18513a;
                                                                                            i36 = i58;
                                                                                            jv0Var2 = jv0Var5;
                                                                                            z16 = false;
                                                                                            i37 = 1;
                                                                                        } catch (Exception e22) {
                                                                                            e = e22;
                                                                                            jv0Var2 = jv0Var5;
                                                                                            exc = e;
                                                                                            r776 = r774;
                                                                                            jB = jB5;
                                                                                            jB2 = jB;
                                                                                            r773 = r776;
                                                                                            obj4 = jv0Var2;
                                                                                            r772 = r773;
                                                                                            exc.printStackTrace();
                                                                                            LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                                            r13 = obj4;
                                                                                            r77 = r772;
                                                                                            long jB622222 = ir5.b();
                                                                                            ?? sb222222 = new StringBuilder();
                                                                                            sb222222.append("inserttimecost  ");
                                                                                            sb222222.append(jB3 - jB5);
                                                                                            ?? r422222 = r77;
                                                                                            sb222222.append(r422222);
                                                                                            sb222222.append(jB4 - jB3);
                                                                                            sb222222.append(r422222);
                                                                                            sb222222.append(jB - jB4);
                                                                                            sb222222.append(r422222);
                                                                                            sb222222.append(jB2 - jB);
                                                                                            sb222222.append(r422222);
                                                                                            sb222222.append(jB622222 - jB2);
                                                                                            LogUtil.i("SocialContentProvider", sb222222.toString());
                                                                                            return r13;
                                                                                        }
                                                                                    }
                                                                                    if (i56 != 10000) {
                                                                                        str43 = str38;
                                                                                        str44 = str14;
                                                                                    } else {
                                                                                        Integer asInteger2 = contentValues.getAsInteger("data3");
                                                                                        if (asInteger2 != null) {
                                                                                            str44 = str14;
                                                                                            str43 = str38;
                                                                                            if (asInteger2.intValue() == 11 || asInteger2.intValue() == 12) {
                                                                                            }
                                                                                            zX = z17 && !z16 && (!z6 || i56 == 10001);
                                                                                            if (i56 == 28 && zX) {
                                                                                                zX &= g.x(contentValues.getAsString(str35), contentValues.getAsString("src"));
                                                                                            }
                                                                                            if (zX) {
                                                                                                contentValues3.put("unread_message_count", Integer.valueOf(i36));
                                                                                            }
                                                                                            contentValues3.put("thread_latest_unread_message_time", Long.valueOf(j));
                                                                                            contentValues3.put("thread_latest_unread_message_primary_key_id", Long.valueOf(j7));
                                                                                            if (i56 != 10001) {
                                                                                                contentValues3.put("latest_message_read", Integer.valueOf(i37));
                                                                                            } else {
                                                                                                contentValues3.put("latest_message_read", (Integer) 0);
                                                                                            }
                                                                                            z13 = z17;
                                                                                            str45 = str26;
                                                                                            i32 = 1;
                                                                                        } else {
                                                                                            str43 = str38;
                                                                                            str44 = str14;
                                                                                        }
                                                                                        z17 = false;
                                                                                        if (z17) {
                                                                                            if (i56 == 28) {
                                                                                                zX &= g.x(contentValues.getAsString(str35), contentValues.getAsString("src"));
                                                                                            }
                                                                                            if (zX) {
                                                                                            }
                                                                                            contentValues3.put("thread_latest_unread_message_time", Long.valueOf(j));
                                                                                            contentValues3.put("thread_latest_unread_message_primary_key_id", Long.valueOf(j7));
                                                                                            if (i56 != 10001) {
                                                                                            }
                                                                                            z13 = z17;
                                                                                            str45 = str26;
                                                                                            i32 = 1;
                                                                                        }
                                                                                    }
                                                                                    z17 = true;
                                                                                    if (z17) {
                                                                                    }
                                                                                } catch (Exception e23) {
                                                                                    e = e23;
                                                                                    jv0Var3 = jv0Var2;
                                                                                }
                                                                            }
                                                                            if (i56 == i32 || iIntValue2 != i32) {
                                                                                i33 = i29;
                                                                            } else {
                                                                                i33 = i29;
                                                                                if (i33 == i32) {
                                                                                    String asString9 = contentValues.getAsString(str35);
                                                                                    if (asString9 == null || Integer.valueOf(asString9).intValue() != 11 || (asString4 = contentValues.getAsString(str41)) == null || (jSONArray = new JSONObject(asString4).getJSONArray("remindUids")) == null) {
                                                                                        z15 = false;
                                                                                        if (!z15) {
                                                                                            contentValues3.put("thread_has_remind", (Integer) 2);
                                                                                        } else if (i28 == 2) {
                                                                                            contentValues3.put("thread_has_remind", (Integer) 1);
                                                                                        }
                                                                                    } else {
                                                                                        for (int i59 = 0; i59 < jSONArray.length(); i59++) {
                                                                                            String strValueOf = String.valueOf(jSONArray.getLong(i59));
                                                                                            if ((a() != null && a().equals(strValueOf)) || (a() != null && CircleConfig.VALUE_REMIND_ALL_OF_PERSON.equals(strValueOf))) {
                                                                                                z15 = true;
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        z15 = false;
                                                                                        if (!z15) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (i33 != 0) {
                                                                                i34 = i23;
                                                                                if (i34 == 22 && iIntValue2 == 1) {
                                                                                    str46 = str43;
                                                                                    contentValues3.put(str46, (String) contentValues.get(str36));
                                                                                } else {
                                                                                    str46 = str43;
                                                                                }
                                                                            } else {
                                                                                str46 = str43;
                                                                                i34 = i23;
                                                                            }
                                                                            if (10005 != com.zenmen.palmchat.conversations.threadgroup.a.c(i34)) {
                                                                                str47 = str42;
                                                                                if (1 == ((Integer) contentValues.get(str47)).intValue() && !TextUtils.isEmpty(str44) && (richMsgVo = (RichMsgVo) az2.a(str44, RichMsgVo.class)) != null && (superGreetingsVo = richMsgVo.superGreetingsVo) != null && superGreetingsVo.isSuperGreetings) {
                                                                                    contentValues3.put("is_super_greetings", (Integer) 1);
                                                                                    contentValues3.put("super_greetings_time_stamp", Long.valueOf(j3));
                                                                                }
                                                                            } else {
                                                                                str47 = str42;
                                                                                contentValues3.put("is_super_greetings", (Integer) 0);
                                                                            }
                                                                            if (z1822 && 1 == ((Integer) contentValues.get(str47)).intValue()) {
                                                                                if (i33 == 0) {
                                                                                    contentValues3.put("pin_gift_message", (Integer) 1);
                                                                                    contentValues3.put("pin_gift_message_last_time_stamp", Long.valueOf(j3));
                                                                                }
                                                                                contentValues3.put("has_unread_gift_message", (Integer) 1);
                                                                            }
                                                                            if (z4 && 1 == ((Integer) contentValues.get(str47)).intValue()) {
                                                                                contentValues3.put("has_unread_gift_message", (Integer) 1);
                                                                            }
                                                                            if (i56 != 53 && iIntValue2 == 1 && i33 == 1) {
                                                                                CircleNoticeItem.circleThreadHasNoticeStatus(DomainHelper.s(str34), 2);
                                                                            } else {
                                                                                if (circleThreadHasNoticeStatus != 2) {
                                                                                    i35 = 1;
                                                                                    CircleNoticeItem.circleThreadHasNoticeStatus(DomainHelper.s(str34), 1);
                                                                                }
                                                                                if (i56 != 22 || iIntValue2 != i35 || i33 != i35) {
                                                                                    String str77 = str34;
                                                                                    if (circleThreadHasVoucherStatus == 2) {
                                                                                        VoucherRedPacketVo.circleThreadHasVoucherStatus(str77, 1);
                                                                                    }
                                                                                } else if (!VoucherRedPacketVo.isSpecTypeForOthers(contentValues)) {
                                                                                    VoucherRedPacketVo.circleThreadHasVoucherStatus(str34, 2);
                                                                                }
                                                                                String asString10 = contentValues.getAsString("data3");
                                                                                if (CircleNoticeItem.isInvalidateCircleNotice(contentValues)) {
                                                                                    z14 = true;
                                                                                    jB = ir5.b();
                                                                                    if (cursor3 != null) {
                                                                                        try {
                                                                                            if (cursor3.getCount() <= 0) {
                                                                                                vh5Var = vh5Var2;
                                                                                                try {
                                                                                                    vh5Var.f("tb_threads", null, contentValues3);
                                                                                                } catch (Exception e24) {
                                                                                                    obj4 = jv0Var2;
                                                                                                    exc = e24;
                                                                                                    jB2 = jB5;
                                                                                                    r772 = r774;
                                                                                                }
                                                                                            } else if (z14) {
                                                                                                vh5Var = vh5Var2;
                                                                                            } else {
                                                                                                vh5Var = vh5Var2;
                                                                                                vh5Var.i("tb_threads", contentValues3, "contact_relate=?", strArr2222);
                                                                                            }
                                                                                            if (cursor3 == null || !cursor3.moveToFirst()) {
                                                                                                cursor2 = cursor3;
                                                                                                str48 = str31;
                                                                                            } else {
                                                                                                cursor2 = cursor3;
                                                                                                str48 = str31;
                                                                                                int i60 = cursor2.getInt(cursor2.getColumnIndex(str48));
                                                                                                if (com.zenmen.palmchat.conversations.threadgroup.a.e(i60) && (iC = com.zenmen.palmchat.conversations.threadgroup.a.c(i60)) != -1) {
                                                                                                    com.zenmen.palmchat.conversations.threadgroup.a.h(getContext(), vh5Var, iC);
                                                                                                }
                                                                                            }
                                                                                            cursor2.close();
                                                                                            jB2 = ir5.b();
                                                                                            try {
                                                                                                boolean zE = com.zenmen.palmchat.conversations.threadgroup.a.e(i34);
                                                                                                if (zE) {
                                                                                                    try {
                                                                                                        if (10005 == com.zenmen.palmchat.conversations.threadgroup.a.c(i34)) {
                                                                                                            j4 = j3;
                                                                                                            if (ir5.b() - j4 < mo5.d()) {
                                                                                                                zE = false;
                                                                                                            }
                                                                                                        } else {
                                                                                                            j4 = j3;
                                                                                                        }
                                                                                                        if (zE && i30 == 1 && !z2) {
                                                                                                            int iC2 = com.zenmen.palmchat.conversations.threadgroup.a.c(i34);
                                                                                                            ContentValues contentValues7 = new ContentValues();
                                                                                                            contentValues7.put(str48, Integer.valueOf(iC2));
                                                                                                            contentValues7.put(str71, Integer.valueOf(iC2));
                                                                                                            j5 = jB;
                                                                                                            try {
                                                                                                                contentValues7.put("thread_active", (Integer) 1);
                                                                                                                contentValues7.put("thread_contact_ready", (Integer) 1);
                                                                                                                if (z9) {
                                                                                                                    try {
                                                                                                                        contentValues7.put("latest_message", contentValues3.getAsString("latest_message"));
                                                                                                                        contentValues7.put("latest_message_mime_type", Integer.valueOf(i56));
                                                                                                                        contentValues7.put("thread_draft_time", Long.valueOf(j4));
                                                                                                                        contentValues7.put("latest_message_time_stamp", Long.valueOf(j4));
                                                                                                                    } catch (Exception e25) {
                                                                                                                        exc = e25;
                                                                                                                        jB = j5;
                                                                                                                        r773 = r774;
                                                                                                                        obj4 = jv0Var2;
                                                                                                                        r772 = r773;
                                                                                                                        exc.printStackTrace();
                                                                                                                        LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                                                                        r13 = obj4;
                                                                                                                        r77 = r772;
                                                                                                                    }
                                                                                                                }
                                                                                                                contentValues7.put("thread_nodisturb", (Integer) 1);
                                                                                                                contentValues7.put("thread_draft", str45);
                                                                                                                JSONObject jSONObject = new JSONObject();
                                                                                                                jSONObject.put(str48, i34);
                                                                                                                if (iIntValue2 == 1) {
                                                                                                                    str45 = str32;
                                                                                                                }
                                                                                                                jSONObject.put("nick_name", str45);
                                                                                                                contentValues7.put(str46, jSONObject.toString());
                                                                                                                str49 = "thread_biz_type=" + iC2;
                                                                                                                obj13 = jv0Var2;
                                                                                                            } catch (Exception e26) {
                                                                                                                e = e26;
                                                                                                                obj13 = jv0Var2;
                                                                                                            }
                                                                                                            try {
                                                                                                                Cursor cursorG5 = vh5Var.g("tb_threads", null, str49, null, null, null, null);
                                                                                                                if (cursorG5.getCount() > 0) {
                                                                                                                    int i61 = cursorG5.moveToNext() ? cursorG5.getInt(cursorG5.getColumnIndex("unread_message_count")) : 0;
                                                                                                                    if (z13 && !z6) {
                                                                                                                        i61++;
                                                                                                                    }
                                                                                                                    if (iIntValue2 == 1 && !z12) {
                                                                                                                        i = i61;
                                                                                                                    }
                                                                                                                    contentValues7.put("unread_message_count", Integer.valueOf(i));
                                                                                                                    vh5Var.i("tb_threads", contentValues7, str49, null);
                                                                                                                } else {
                                                                                                                    if (iIntValue2 == 1 && !z12) {
                                                                                                                        i = 1;
                                                                                                                    }
                                                                                                                    contentValues7.put("unread_message_count", Integer.valueOf(i));
                                                                                                                    vh5Var.f("tb_threads", null, contentValues7);
                                                                                                                }
                                                                                                                cursorG5.close();
                                                                                                                obj12 = obj13;
                                                                                                            } catch (Exception e27) {
                                                                                                                e = e27;
                                                                                                                exc = e;
                                                                                                                jB = j5;
                                                                                                                obj4 = obj13;
                                                                                                                r772 = r774;
                                                                                                                exc.printStackTrace();
                                                                                                                LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                                                                r13 = obj4;
                                                                                                                r77 = r772;
                                                                                                            }
                                                                                                        } else {
                                                                                                            j5 = jB;
                                                                                                            obj12 = jv0Var2;
                                                                                                        }
                                                                                                        jB = j5;
                                                                                                        r13 = obj12;
                                                                                                        r77 = r774;
                                                                                                    } catch (Exception e28) {
                                                                                                        exc = e28;
                                                                                                        r773 = r774;
                                                                                                        obj4 = jv0Var2;
                                                                                                        r772 = r773;
                                                                                                        exc.printStackTrace();
                                                                                                        LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                                                        r13 = obj4;
                                                                                                        r77 = r772;
                                                                                                        long jB6222222 = ir5.b();
                                                                                                        ?? sb2222222 = new StringBuilder();
                                                                                                        sb2222222.append("inserttimecost  ");
                                                                                                        sb2222222.append(jB3 - jB5);
                                                                                                        ?? r4222222 = r77;
                                                                                                        sb2222222.append(r4222222);
                                                                                                        sb2222222.append(jB4 - jB3);
                                                                                                        sb2222222.append(r4222222);
                                                                                                        sb2222222.append(jB - jB4);
                                                                                                        sb2222222.append(r4222222);
                                                                                                        sb2222222.append(jB2 - jB);
                                                                                                        sb2222222.append(r4222222);
                                                                                                        sb2222222.append(jB6222222 - jB2);
                                                                                                        LogUtil.i("SocialContentProvider", sb2222222.toString());
                                                                                                        return r13;
                                                                                                    }
                                                                                                }
                                                                                            } catch (Exception e29) {
                                                                                                obj4 = jv0Var2;
                                                                                                exc = e29;
                                                                                                r772 = r774;
                                                                                            }
                                                                                        } catch (Exception e30) {
                                                                                            exc = e30;
                                                                                            jB2 = jB5;
                                                                                            r773 = r774;
                                                                                            obj4 = jv0Var2;
                                                                                            r772 = r773;
                                                                                            exc.printStackTrace();
                                                                                            LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                                            r13 = obj4;
                                                                                            r77 = r772;
                                                                                            long jB62222222 = ir5.b();
                                                                                            ?? sb22222222 = new StringBuilder();
                                                                                            sb22222222.append("inserttimecost  ");
                                                                                            sb22222222.append(jB3 - jB5);
                                                                                            ?? r42222222 = r77;
                                                                                            sb22222222.append(r42222222);
                                                                                            sb22222222.append(jB4 - jB3);
                                                                                            sb22222222.append(r42222222);
                                                                                            sb22222222.append(jB - jB4);
                                                                                            sb22222222.append(r42222222);
                                                                                            sb22222222.append(jB2 - jB);
                                                                                            sb22222222.append(r42222222);
                                                                                            sb22222222.append(jB62222222 - jB2);
                                                                                            LogUtil.i("SocialContentProvider", sb22222222.toString());
                                                                                            return r13;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (i56 == 10000 && asString10 != null) {
                                                                                        if (asString10.equals(BaseWrapper.ENTER_ID_GAME_CENTER)) {
                                                                                        }
                                                                                        jB = ir5.b();
                                                                                        if (cursor3 != null) {
                                                                                        }
                                                                                    }
                                                                                    z14 = false;
                                                                                    jB = ir5.b();
                                                                                    if (cursor3 != null) {
                                                                                    }
                                                                                }
                                                                            }
                                                                            i35 = 1;
                                                                            if (i56 != 22) {
                                                                                String str772 = str34;
                                                                                if (circleThreadHasVoucherStatus == 2) {
                                                                                }
                                                                                String asString102 = contentValues.getAsString("data3");
                                                                                if (CircleNoticeItem.isInvalidateCircleNotice(contentValues)) {
                                                                                }
                                                                            }
                                                                        }
                                                                        if (iIntValue2 != i31) {
                                                                            str41 = str40;
                                                                            str42 = str39;
                                                                            str43 = str38;
                                                                            z12 = z11;
                                                                            str44 = str14;
                                                                            str45 = str26;
                                                                            contentValues3.put("thread_draft_remind_uids", str45);
                                                                            i32 = 1;
                                                                            contentValues3.put("latest_message_read", (Integer) 1);
                                                                            z13 = false;
                                                                            if (i56 == i32) {
                                                                                i33 = i29;
                                                                                if (i33 != 0) {
                                                                                }
                                                                                if (10005 != com.zenmen.palmchat.conversations.threadgroup.a.c(i34)) {
                                                                                }
                                                                                if (z1822) {
                                                                                    if (i33 == 0) {
                                                                                    }
                                                                                    contentValues3.put("has_unread_gift_message", (Integer) 1);
                                                                                }
                                                                                if (z4) {
                                                                                    contentValues3.put("has_unread_gift_message", (Integer) 1);
                                                                                }
                                                                                if (i56 != 53) {
                                                                                    if (circleThreadHasNoticeStatus != 2) {
                                                                                        i35 = 1;
                                                                                    }
                                                                                    if (i56 != 22) {
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } catch (Exception e31) {
                                                                        e = e31;
                                                                        obj9 = jv0Var2;
                                                                        exc = e;
                                                                        r775 = r774;
                                                                        jB = jB5;
                                                                        jB2 = jB;
                                                                        obj4 = obj9;
                                                                        r772 = r775;
                                                                        exc.printStackTrace();
                                                                        LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                                        r13 = obj4;
                                                                        r77 = r772;
                                                                        long jB622222222 = ir5.b();
                                                                        ?? sb222222222 = new StringBuilder();
                                                                        sb222222222.append("inserttimecost  ");
                                                                        sb222222222.append(jB3 - jB5);
                                                                        ?? r422222222 = r77;
                                                                        sb222222222.append(r422222222);
                                                                        sb222222222.append(jB4 - jB3);
                                                                        sb222222222.append(r422222222);
                                                                        sb222222222.append(jB - jB4);
                                                                        sb222222222.append(r422222222);
                                                                        sb222222222.append(jB2 - jB);
                                                                        sb222222222.append(r422222222);
                                                                        sb222222222.append(jB622222222 - jB2);
                                                                        LogUtil.i("SocialContentProvider", sb222222222.toString());
                                                                        return r13;
                                                                    }
                                                                } else {
                                                                    i23 = i21;
                                                                    str31 = str23;
                                                                    i25 = i55;
                                                                    str32 = str30;
                                                                    str34 = strJ222;
                                                                    r774 = " ";
                                                                    str36 = "msg_extend";
                                                                    contentValues3 = contentValues6;
                                                                    str35 = str17;
                                                                    i29 = i9;
                                                                    i28 = i54;
                                                                    if (j > j2) {
                                                                    }
                                                                    if (z9) {
                                                                    }
                                                                    contentValues3.put("chat_type", Integer.valueOf(i29));
                                                                    contentValues3.put("thread_active", Integer.valueOf(z7 ? 1 : 0));
                                                                    contentValues3.put("thread_contact_ready", Integer.valueOf(i45222));
                                                                    if (i45222 == 0) {
                                                                        zArr[0] = i45222 == 0 || zArr[0];
                                                                        iIntValue2 = contentValues.getAsInteger(str39).intValue();
                                                                        asInteger = contentValues.getAsInteger("read");
                                                                        if (asInteger != null) {
                                                                        }
                                                                        if (iIntValue2 != i31) {
                                                                        }
                                                                    }
                                                                }
                                                            } catch (Exception e32) {
                                                                e = e32;
                                                            }
                                                        } catch (Exception e33) {
                                                            exc = e33;
                                                            jB = jB5;
                                                            jB2 = jB;
                                                            r773 = " ";
                                                            obj4 = jv0Var2;
                                                            r772 = r773;
                                                            exc.printStackTrace();
                                                            LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
                                                            r13 = obj4;
                                                            r77 = r772;
                                                            long jB6222222222 = ir5.b();
                                                            ?? sb2222222222 = new StringBuilder();
                                                            sb2222222222.append("inserttimecost  ");
                                                            sb2222222222.append(jB3 - jB5);
                                                            ?? r4222222222 = r77;
                                                            sb2222222222.append(r4222222222);
                                                            sb2222222222.append(jB4 - jB3);
                                                            sb2222222222.append(r4222222222);
                                                            sb2222222222.append(jB - jB4);
                                                            sb2222222222.append(r4222222222);
                                                            sb2222222222.append(jB2 - jB);
                                                            sb2222222222.append(r4222222222);
                                                            sb2222222222.append(jB6222222222 - jB2);
                                                            LogUtil.i("SocialContentProvider", sb2222222222.toString());
                                                            return r13;
                                                        }
                                                    }
                                                } else {
                                                    i6 = i5;
                                                    socialContentProvider = this;
                                                }
                                            }
                                            str6 = strC;
                                            z7 = z19;
                                            str15 = strY22;
                                            iB = m40.b(str6);
                                            String strJ2222 = DomainHelper.j(str6);
                                            if (iB == 1) {
                                            }
                                            if (iB == 0) {
                                            }
                                            jB4 = ir5.b();
                                            String[] strArr22222 = {str18};
                                            int i442222 = i10;
                                            String str592222 = str18;
                                            String str602222 = str21;
                                            String str612222 = str22;
                                            int i452222 = i11;
                                            String str622222 = str20;
                                            cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr22222, null, null, null);
                                            if (cursorG2 != null) {
                                            }
                                        }
                                    } else {
                                        i6 = i5;
                                        i7 = i2;
                                    }
                                } else {
                                    i6 = i5;
                                    i7 = i2;
                                    str14 = str5522;
                                }
                                socialContentProvider = this;
                                str15 = strY22;
                                z7 = true;
                                iB = m40.b(str6);
                                String strJ22222 = DomainHelper.j(str6);
                                if (iB == 1) {
                                }
                                if (iB == 0) {
                                }
                                jB4 = ir5.b();
                                String[] strArr222222 = {str18};
                                int i4422222 = i10;
                                String str5922222 = str18;
                                String str6022222 = str21;
                                String str6122222 = str22;
                                int i4522222 = i11;
                                String str6222222 = str20;
                                cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr222222, null, null, null);
                                if (cursorG2 != null) {
                                }
                            }
                        }
                        z3 = false;
                        z4 = false;
                        String str55222 = (String) contentValues.get("msg_extend");
                        String str56222 = (String) contentValues.get("packet_id");
                        String[] strArr322 = {str56222};
                        String str57222 = str3;
                        String str58222 = str;
                        str6 = str4;
                        int i43222 = i3;
                        boolean z18222 = z3;
                        cursorG = vh5Var2.g(DBUriManager.h(uri), null, "packet_id=?", strArr322, null, null, null);
                        long jLongValue222 = ((Long) contentValues.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)).longValue();
                        if (cursorG.moveToFirst()) {
                        }
                        cursor.close();
                        jB3 = ir5.b();
                        if (i5 != 17) {
                        }
                        String strY222 = (String) contentValues.get("message");
                        if (i5 != i4) {
                        }
                        socialContentProvider = this;
                        str15 = strY222;
                        z7 = true;
                        iB = m40.b(str6);
                        String strJ222222 = DomainHelper.j(str6);
                        if (iB == 1) {
                        }
                        if (iB == 0) {
                        }
                        jB4 = ir5.b();
                        String[] strArr2222222 = {str18};
                        int i44222222 = i10;
                        String str59222222 = str18;
                        String str60222222 = str21;
                        String str61222222 = str22;
                        int i45222222 = i11;
                        String str62222222 = str20;
                        cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr2222222, null, null, null);
                        if (cursorG2 != null) {
                        }
                    }
                }
                i3 = iIntValue;
                z3 = true;
                z4 = false;
                String str552222 = (String) contentValues.get("msg_extend");
                String str562222 = (String) contentValues.get("packet_id");
                String[] strArr3222 = {str562222};
                String str572222 = str3;
                String str582222 = str;
                str6 = str4;
                int i432222 = i3;
                boolean z182222 = z3;
                cursorG = vh5Var2.g(DBUriManager.h(uri), null, "packet_id=?", strArr3222, null, null, null);
                long jLongValue2222 = ((Long) contentValues.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)).longValue();
                if (cursorG.moveToFirst()) {
                }
                cursor.close();
                jB3 = ir5.b();
                if (i5 != 17) {
                }
                String strY2222 = (String) contentValues.get("message");
                if (i5 != i4) {
                }
                socialContentProvider = this;
                str15 = strY2222;
                z7 = true;
                iB = m40.b(str6);
                String strJ2222222 = DomainHelper.j(str6);
                if (iB == 1) {
                }
                if (iB == 0) {
                }
                jB4 = ir5.b();
                String[] strArr22222222 = {str18};
                int i442222222 = i10;
                String str592222222 = str18;
                String str602222222 = str21;
                String str612222222 = str22;
                int i452222222 = i11;
                String str622222222 = str20;
                cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr22222222, null, null, null);
                if (cursorG2 != null) {
                }
            } else {
                str3 = "data2";
                str4 = str52;
                i3 = iIntValue;
            }
            z3 = false;
            z4 = false;
            String str5522222 = (String) contentValues.get("msg_extend");
            String str5622222 = (String) contentValues.get("packet_id");
            String[] strArr32222 = {str5622222};
            String str5722222 = str3;
            String str5822222 = str;
            str6 = str4;
            int i4322222 = i3;
            boolean z1822222 = z3;
            cursorG = vh5Var2.g(DBUriManager.h(uri), null, "packet_id=?", strArr32222, null, null, null);
            long jLongValue22222 = ((Long) contentValues.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE)).longValue();
            if (cursorG.moveToFirst()) {
            }
            cursor.close();
            jB3 = ir5.b();
            if (i5 != 17) {
            }
            String strY22222 = (String) contentValues.get("message");
            if (i5 != i4) {
            }
            socialContentProvider = this;
            str15 = strY22222;
            z7 = true;
            iB = m40.b(str6);
            String strJ22222222 = DomainHelper.j(str6);
            if (iB == 1) {
            }
            if (iB == 0) {
            }
            jB4 = ir5.b();
            String[] strArr222222222 = {str18};
            int i4422222222 = i10;
            String str5922222222 = str18;
            String str6022222222 = str21;
            String str6122222222 = str22;
            int i4522222222 = i11;
            String str6222222222 = str20;
            cursorG2 = vh5Var2.g("tb_threads", null, "contact_relate=?", strArr222222222, null, null, null);
            if (cursorG2 != null) {
            }
            exc = e;
            obj3 = obj14;
            obj2 = obj;
            jB = jB5;
            jB2 = jB;
            jB3 = jB2;
            jB4 = jB3;
            obj4 = obj3;
            r772 = obj2;
            exc.printStackTrace();
            LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
            r13 = obj4;
            r77 = r772;
        } else {
            try {
                if (!TextUtils.isEmpty((String) obj6) && M(sQLiteDatabase, (String) obj6, ((Long) obj5).longValue()) <= 0) {
                    z = false;
                }
                contentValues.remove("resource_version");
                contentValues.remove("resource_type");
                if (z) {
                    return jv0Var4;
                }
                iIntValue = ((Integer) contentValues.get("msg_type")).intValue();
                if (iIntValue != 42) {
                }
            } catch (Exception e34) {
                exc = e34;
                obj3 = jv0Var4;
                obj2 = " ";
                jB = jB5;
                jB2 = jB;
                jB3 = jB2;
                jB4 = jB3;
                obj4 = obj3;
                r772 = obj2;
            }
            exc = e;
            obj3 = obj14;
            obj2 = obj;
            jB = jB5;
            jB2 = jB;
            jB3 = jB2;
            jB4 = jB3;
            obj4 = obj3;
            r772 = obj2;
            exc.printStackTrace();
            LogUtil.log4ClientError("insertOrUpdateNewMessage", exc);
            r13 = obj4;
            r77 = r772;
        }
        long jB62222222222 = ir5.b();
        ?? sb22222222222 = new StringBuilder();
        sb22222222222.append("inserttimecost  ");
        sb22222222222.append(jB3 - jB5);
        ?? r42222222222 = r77;
        sb22222222222.append(r42222222222);
        sb22222222222.append(jB4 - jB3);
        sb22222222222.append(r42222222222);
        sb22222222222.append(jB - jB4);
        sb22222222222.append(r42222222222);
        sb22222222222.append(jB2 - jB);
        sb22222222222.append(r42222222222);
        sb22222222222.append(jB62222222222 - jB2);
        LogUtil.i("SocialContentProvider", sb22222222222.toString());
        return r13;
    }

    public final long F(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, boolean[] zArr) throws Throwable {
        long jF;
        String string;
        boolean z;
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        Object obj = contentValues.get("resource_version");
        Object obj2 = contentValues.get("resource_type");
        Object obj3 = contentValues.get("local_update");
        if (obj3 == null) {
            if (obj != null && obj2 != null) {
                long jLongValue = ((Long) obj).longValue();
                contentValues.remove("resource_version");
                contentValues.remove("resource_type");
                M(sQLiteDatabase, (String) obj2, jLongValue);
            }
            if (contentValues.get(CommonCode.MapKey.UPDATE_VERSION) != null) {
                return 0L;
            }
        } else {
            contentValues.remove("local_update");
        }
        String asString = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
        String[] strArr = {asString};
        Cursor cursorG = vh5Var.g("tb_contacts", null, "uid=?", strArr, null, null, null);
        if (cursorG.moveToFirst()) {
            string = cursorG.getString(cursorG.getColumnIndex("remark_name"));
            z = cursorG.getInt(cursorG.getColumnIndex("data2")) == 0;
            if (contentValues.containsKey("data2")) {
                z = contentValues.getAsInteger("data2").intValue() == 0;
            }
            jF = vh5Var.i("tb_contacts", contentValues, "uid=?", strArr);
        } else {
            jF = vh5Var.f("tb_contacts", null, contentValues);
            if (contentValues.containsKey("data2")) {
                z = contentValues.getAsInteger("data2").intValue() == 0;
                string = "";
            } else {
                string = "";
                z = true;
            }
        }
        cursorG.close();
        if (obj3 != null) {
            return jF;
        }
        b0(sQLiteDatabase, contentValues, (String) contentValues.get(DeviceInfoUtil.UID_TAG), string);
        zArr[0] = X(sQLiteDatabase, contentValues, (String) contentValues.get(DeviceInfoUtil.UID_TAG)) || zArr[0];
        String asString2 = contentValues.getAsString("remark_name");
        if (!TextUtils.isEmpty(asString2) && !asString2.equals(string)) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("remark_name", asString2);
            contentValues2.put("remark_name_all_pinyin", contentValues.getAsString("remark_all_pinyin"));
            contentValues2.put("remark_name_first_pinyin", contentValues.getAsString("remark_first_pinyin"));
            vh5Var.i("tb_group_members", contentValues2, "name=?", new String[]{asString});
        }
        if (z) {
            zArr[1] = W(sQLiteDatabase, asString) || zArr[1];
        }
        return jF;
    }

    public final long G(ContentValues contentValues, SQLiteDatabase sQLiteDatabase) {
        boolean z;
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        long jI = 0;
        try {
            Object obj = contentValues.get("resource_version");
            Object obj2 = contentValues.get("resource_type");
            if (obj != null && obj2 != null) {
                long jLongValue = ((Long) obj).longValue();
                contentValues.remove("resource_version");
                contentValues.remove("resource_type");
                z = M(sQLiteDatabase, (String) obj2, jLongValue) > 0;
            }
            if (!z) {
                return 0L;
            }
            Cursor cursorG = vh5Var.g("tb_contact_requests", null, "mid=?", new String[]{(String) contentValues.get("mid")}, null, null, null);
            jI = cursorG.moveToFirst() ? vh5Var.i("tb_contact_requests", contentValues, "mid=?", r0) : vh5Var.f("tb_contact_requests", null, contentValues);
            cursorG.close();
            return jI;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.log4ClientError("insertOrUpdateOneContactRequestMessage", e);
            return jI;
        }
    }

    public final long H(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        vh5Var.a();
        boolean[] zArr = {false, false};
        try {
            try {
                int iIntValue = contentValues.getAsInteger("contact_operation").intValue();
                contentValues.remove("contact_operation");
                jF = iIntValue == 1 ? F(sQLiteDatabase, contentValues, zArr) : 0L;
                vh5Var.h();
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.log4ClientError("provider_insertOrUpdateOneContactTransaction", e);
            }
            vh5Var.d();
            getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            if (zArr[0]) {
                getContext().getContentResolver().notifyChange(je2.f18392a, (ContentObserver) null, false);
            }
            if (zArr[1]) {
                getContext().getContentResolver().notifyChange(vn0.f21483a, (ContentObserver) null, false);
            }
            return jF;
        } catch (Throwable th) {
            vh5Var.d();
            throw th;
        }
    }

    public final void I(ContentValues contentValues, Uri uri) throws Throwable {
        String asString = contentValues.getAsString("group_member");
        String asString2 = contentValues.getAsString("group_member_del");
        contentValues.remove("group_member");
        contentValues.remove("group_member_change_count");
        contentValues.remove("group_member_del");
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        Object obj = contentValues.get("resource_version");
        Object obj2 = contentValues.get("resource_type");
        if (obj != null && obj2 != null) {
            long jLongValue = ((Long) obj).longValue();
            contentValues.remove("resource_version");
            contentValues.remove("resource_type");
            M(writableDatabase, (String) obj2, jLongValue);
        }
        if (contentValues.get(CommonCode.MapKey.UPDATE_VERSION) != null) {
            return;
        }
        String[] strArr = {(String) contentValues.get("group_id")};
        contentValues.put("group_state", (Integer) 0);
        Cursor cursorG = vh5Var.g(DBUriManager.e(uri), null, "group_id=?", strArr, null, null, null);
        if (cursorG.moveToFirst()) {
            String string = cursorG.getString(cursorG.getColumnIndex("group_extra_info"));
            String asString3 = contentValues.getAsString("group_extra_info");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(asString3)) {
                JSONObject jSONObject = new JSONObject(asString3);
                JSONObject jSONObject2 = new JSONObject(string);
                if (!jSONObject.has("roleType") && jSONObject2.has("roleType")) {
                    jSONObject.put("roleType", jSONObject2.opt("roleType"));
                    contentValues.put("group_extra_info", jSONObject.toString());
                }
            }
            vh5Var.i(DBUriManager.e(uri), contentValues, "group_id=?", strArr);
        } else {
            vh5Var.f(DBUriManager.e(uri), null, contentValues);
        }
        cursorG.close();
        c0(writableDatabase, contentValues, (String) contentValues.get("group_id"));
        if (!TextUtils.isEmpty(asString)) {
            j(ae2.f((String) contentValues.get("group_id"), (String) contentValues.get("owner"), asString), uri);
        }
        if (TextUtils.isEmpty(asString2)) {
            return;
        }
        j(ae2.d((String) contentValues.get("group_id"), asString2), uri);
    }

    public final void J(ContentValues contentValues) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        ContactInfoItem contactInfoItemR = R(writableDatabase, contentValues.getAsString("name"));
        if (contactInfoItemR != null) {
            String remarkName = contactInfoItemR.getRemarkName();
            if (!TextUtils.isEmpty(remarkName)) {
                contentValues.put("remark_name", remarkName);
                contentValues.put("remark_name_all_pinyin", contactInfoItemR.getRemarkAllPinyin());
                contentValues.put("remark_name_first_pinyin", contactInfoItemR.getRemarkFirstPinyin());
            }
        }
        String[] strArr = {(String) contentValues.get("group_id"), (String) contentValues.get("name")};
        Cursor cursorG = vh5Var.g("tb_group_members", null, "group_id=? and name=?", strArr, null, null, null);
        contentValues.put("group_member_state", (Integer) 0);
        if (!cursorG.moveToFirst()) {
            vh5Var.f("tb_group_members", null, contentValues);
        } else if (cursorG.getInt(cursorG.getColumnIndex("group_member_state")) == 0) {
            vh5Var.i("tb_group_members", contentValues, "group_id=? and name=?", strArr);
        } else {
            vh5Var.c("tb_group_members", "group_id=? and name=?", strArr);
            vh5Var.f("tb_group_members", null, contentValues);
        }
        cursorG.close();
    }

    public final boolean K(ContentValues contentValues, SQLiteDatabase sQLiteDatabase, GroupMemberInfoItem groupMemberInfoItem) {
        ContactInfoItem contactInfoItemR = R(sQLiteDatabase, contentValues.getAsString("name"));
        if (contactInfoItemR != null) {
            String remarkName = contactInfoItemR.getRemarkName();
            if (!TextUtils.isEmpty(remarkName)) {
                contentValues.put("remark_name", remarkName);
                contentValues.put("remark_name_all_pinyin", contactInfoItemR.getRemarkAllPinyin());
                contentValues.put("remark_name_first_pinyin", contactInfoItemR.getRemarkFirstPinyin());
            }
        }
        String str = (String) contentValues.get("group_id");
        contentValues.put("group_member_state", (Integer) 0);
        String[] strArr = {str, (String) contentValues.get("name")};
        if (groupMemberInfoItem == null) {
            sQLiteDatabase.insert("tb_group_members", null, contentValues);
        } else {
            int iCheckUpdateGroupMemberOnReset = GroupMemberInfoItem.checkUpdateGroupMemberOnReset(groupMemberInfoItem, contentValues);
            if (iCheckUpdateGroupMemberOnReset == 1) {
                sQLiteDatabase.update("tb_group_members", contentValues, "group_id=? and name=?", strArr);
            } else {
                if (iCheckUpdateGroupMemberOnReset != 2) {
                    return false;
                }
                sQLiteDatabase.delete("tb_group_members", "group_id=? and name=?", strArr);
                sQLiteDatabase.insert("tb_group_members", null, contentValues);
            }
        }
        return true;
    }

    public final long L(ContentValues contentValues, Uri uri) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return 0L;
        }
        boolean[] zArr = {false};
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        vh5Var.a();
        try {
            ((Integer) contentValues.get("msg_type")).intValue();
            jv0 jv0VarE = E(contentValues, writableDatabase, u(contentValues, uri), zArr);
            long j = jv0VarE.f18513a;
            boolean z = jv0VarE.b;
            vh5Var.h();
            vh5Var.d();
            getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            if (z) {
                getContext().getContentResolver().notifyChange(vn0.f21483a, (ContentObserver) null, false);
            }
            if (zArr[0]) {
                iq5.j(false, new String[0]);
            }
            return j;
        } catch (Throwable th) {
            vh5Var.d();
            throw th;
        }
    }

    public final long M(SQLiteDatabase sQLiteDatabase, String str, long j) {
        return N(sQLiteDatabase, str, j, Boolean.FALSE);
    }

    public final long N(SQLiteDatabase sQLiteDatabase, String str, long j, Boolean bool) {
        ContentValues contentValues = new ContentValues();
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        String[] strArr = {str};
        Cursor cursorG = vh5Var.g("tb_synckey", null, "resource_type=?", strArr, null, null, null);
        long jF = 0;
        if (cursorG != null) {
            if (cursorG.moveToFirst()) {
                long j2 = cursorG.getLong(cursorG.getColumnIndex("resource_version"));
                if ((bool != null && bool.booleanValue()) || j2 < j) {
                    contentValues.put("resource_version", Long.valueOf(j));
                    jF = vh5Var.i("tb_synckey", contentValues, "resource_type=?", strArr);
                }
            } else {
                contentValues.put("resource_version", Long.valueOf(j));
                contentValues.put("resource_type", str);
                jF = vh5Var.f("tb_synckey", null, contentValues);
            }
            cursorG.close();
        }
        return jF;
    }

    public final long O(ContentValues contentValues) {
        boolean z;
        wf5 wf5VarA = xf5.a(a());
        long jF = 0;
        if (wf5VarA == null) {
            return 0L;
        }
        vh5 vh5Var = new vh5(wf5VarA.getWritableDatabase(), a());
        vh5Var.a();
        try {
            try {
                String asString = contentValues.getAsString("contact_relate");
                String asString2 = contentValues.getAsString("thread_action_type");
                if (asString2 != null) {
                    boolean zEquals = asString2.equals("ACTION_TYPE_REQUEST_FOCUS");
                    contentValues.remove("thread_action_type");
                    z = zEquals;
                } else {
                    z = false;
                }
                if (!TextUtils.isEmpty(asString)) {
                    String[] strArr = {asString};
                    Cursor cursorG = vh5Var.g("tb_threads", null, "contact_relate=?", strArr, null, null, null);
                    if (cursorG.moveToFirst()) {
                        jF = cursorG.getInt(cursorG.getColumnIndex("_id"));
                        if (z) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("thread_focus", (Integer) 1);
                            vh5Var.i("tb_threads", contentValues2, "contact_relate=?", strArr);
                        }
                    } else {
                        jF = vh5Var.f("tb_threads", null, contentValues);
                    }
                    cursorG.close();
                }
                vh5Var.h();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jF;
        } finally {
            vh5Var.d();
        }
    }

    public final boolean P() {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA != null) {
            return wf5VarA.g();
        }
        return false;
    }

    public final boolean Q(ContentValues[] contentValuesArr) {
        ContentValues contentValues;
        if (contentValuesArr == null) {
            return false;
        }
        if (contentValuesArr.length <= 1) {
            if (contentValuesArr.length != 1 || (contentValues = contentValuesArr[0]) == null) {
                return false;
            }
            if (contentValues.containsKey(CommonCode.MapKey.UPDATE_VERSION) && contentValues.getAsBoolean(CommonCode.MapKey.UPDATE_VERSION).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final ContactInfoItem R(SQLiteDatabase sQLiteDatabase, String str) {
        return bo0.r().o(str);
    }

    public final void S(ContentValues contentValues, Uri uri) throws Throwable {
        String[] strArr;
        LogUtil.i("SocialContentProvider", "resetGroupAndMembers start");
        String asString = contentValues.getAsString("group_member");
        contentValues.get("group_member_del");
        contentValues.remove("group_member");
        contentValues.remove("group_member_change_count");
        contentValues.remove("group_member_del");
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        Object obj = contentValues.get("resource_version");
        Object obj2 = contentValues.get("resource_type");
        if (obj != null && obj2 != null) {
            long jLongValue = ((Long) obj).longValue();
            contentValues.remove("resource_version");
            contentValues.remove("resource_type");
            M(writableDatabase, (String) obj2, jLongValue);
        }
        if (contentValues.get(CommonCode.MapKey.UPDATE_VERSION) != null) {
            return;
        }
        String str = (String) contentValues.get("group_id");
        String[] strArr2 = {(String) contentValues.get("group_id")};
        contentValues.put("group_state", (Integer) 0);
        Cursor cursorG = vh5Var.g(DBUriManager.e(uri), null, "group_id=?", strArr2, null, null, null);
        if (cursorG.moveToFirst()) {
            String string = cursorG.getString(cursorG.getColumnIndex("group_extra_info"));
            String asString2 = contentValues.getAsString("group_extra_info");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(asString2)) {
                JSONObject jSONObject = new JSONObject(asString2);
                JSONObject jSONObject2 = new JSONObject(string);
                if (!jSONObject.has("roleType") && jSONObject2.has("roleType")) {
                    jSONObject.put("roleType", jSONObject2.opt("roleType"));
                    contentValues.put("group_extra_info", jSONObject.toString());
                }
            }
            strArr = strArr2;
            vh5Var.i(DBUriManager.e(uri), contentValues, "group_id=?", strArr);
        } else {
            strArr = strArr2;
            vh5Var.f(DBUriManager.e(uri), null, contentValues);
        }
        cursorG.close();
        c0(writableDatabase, contentValues, (String) contentValues.get("group_id"));
        LogUtil.i("SocialContentProvider", "resetGroupAndMembers groupInfoUpdated");
        Cursor cursorG2 = vh5Var.g("tb_group_members", null, "group_id=?", strArr, null, null, null);
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        while (cursorG2.moveToNext()) {
            GroupMemberInfoItem groupMemberInfoItemBuildFromCursor = GroupMemberInfoItem.buildFromCursor(cursorG2);
            if (groupMemberInfoItemBuildFromCursor != null && groupMemberInfoItemBuildFromCursor.getUid() != null) {
                map.put(groupMemberInfoItemBuildFromCursor.getUid(), groupMemberInfoItemBuildFromCursor);
                if (groupMemberInfoItemBuildFromCursor.getState() == 0) {
                    hashSet.add(groupMemberInfoItemBuildFromCursor.getUid());
                }
            }
        }
        cursorG2.close();
        HashSet hashSet2 = new HashSet();
        if (!TextUtils.isEmpty(asString)) {
            ContentValues[] contentValuesArrF = ae2.f((String) contentValues.get("group_id"), (String) contentValues.get("owner"), asString);
            int i = 0;
            for (ContentValues contentValues2 : contentValuesArrF) {
                if (contentValues2 != null) {
                    String asString3 = contentValues2.getAsString("name");
                    hashSet2.add(asString3);
                    GroupMemberInfoItem groupMemberInfoItem = (GroupMemberInfoItem) map.get(asString3);
                    contentValues2.remove("group_member_operation");
                    if (K(contentValues2, writableDatabase, groupMemberInfoItem)) {
                        i++;
                    }
                }
            }
            LogUtil.i("SocialContentProvider", "resetGroupAndMembers updateMember memberSize=" + contentValuesArrF.length + " updateCount=" + i);
            hashSet.removeAll(hashSet2);
            U(str, writableDatabase, new ArrayList<>(hashSet));
            Z(str, uri);
            getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            getContext().getContentResolver().notifyChange(je2.f18392a, (ContentObserver) null, false);
        }
        LogUtil.i("SocialContentProvider", "resetGroupAndMembers end");
    }

    public final boolean T(vh5 vh5Var, long j, int i, String str, String str2, int i2) {
        if (10001 == i && str != null && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("revokeMsg");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(f.aC);
                    String strOptString2 = jSONObjectOptJSONObject.optString("replaceMid");
                    if ("0@youni".equalsIgnoreCase(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        int iDelete = AppContext.getContext().getContentResolver().delete(DBUriManager.c(ho3.class, str2), "packet_id=? ", new String[]{strOptString2});
                        if (i2 == 1) {
                            String[] strArr = {m40.b(str2) == 0 ? str2 : m40.a(str2)};
                            Cursor cursorG = vh5Var.g("tb_threads", null, "contact_relate=?", strArr, null, null, null);
                            if (cursorG != null && cursorG.moveToFirst()) {
                                long j2 = cursorG.getLong(cursorG.getColumnIndex("thread_latest_unread_message_primary_key_id"));
                                int i3 = cursorG.getInt(cursorG.getColumnIndex("unread_message_count"));
                                if (j != 0 && j2 != 0 && j2 <= j && i3 > 0) {
                                    i3--;
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("unread_message_count", Integer.valueOf(i3));
                                vh5Var.i("tb_threads", contentValues, "contact_relate=?", strArr);
                            }
                            if (cursorG != null) {
                                cursorG.close();
                            }
                        }
                        com.zenmen.palmchat.utils.a.E().t(1);
                        return iDelete > 0;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final void U(String str, SQLiteDatabase sQLiteDatabase, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int size = (arrayList.size() / 50) + 1;
        int i = 0;
        while (i < size) {
            int i2 = i * 50;
            int i3 = i + 1;
            int i4 = i3 * 50;
            List<String> listSubList = i4 >= arrayList.size() ? arrayList.subList(i2, arrayList.size()) : arrayList.subList(i2, i4);
            if (listSubList.size() > 0) {
                String[] strArr = new String[listSubList.size()];
                listSubList.toArray(strArr);
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_member_state", (Integer) 1);
                StringBuilder sb = new StringBuilder();
                sb.append("group_id=" + str + " and (");
                for (int i5 = 0; i5 < listSubList.size(); i5++) {
                    if (i5 == listSubList.size() - 1) {
                        sb.append("name=?");
                    } else {
                        sb.append("name=? or ");
                    }
                }
                sb.append(")");
                LogUtil.i("SocialContentProvider", "resetGroupAndMembers setGroupMemberInactive  i=" + i + " updateCount=" + sQLiteDatabase.update("tb_group_members", contentValues, sb.toString(), strArr));
            }
            i = i3;
        }
    }

    public final void V(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        String[] strArr = {(String) contentValues.get(DeviceInfoUtil.UID_TAG), String.valueOf(0)};
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("account_type", (Integer) (-1));
        vh5Var.i("tb_contacts", contentValues2, "uid=? and account_type is ?", strArr);
    }

    public final boolean W(SQLiteDatabase sQLiteDatabase, String str) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        String[] strArr = {str, String.valueOf(1L)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(System.currentTimeMillis()));
        return vh5Var.i("tb_contact_requests", contentValues, "from_uid =? and read_status !=? ", strArr) > 0;
    }

    public final boolean X(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        String[] strArr = {str};
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("head_icon_url", contentValues.getAsString("head_img_url"));
        contentValues2.put("nick_name", contentValues.getAsString("nick_name"));
        contentValues2.put("remark_name", contentValues.getAsString("remark_name"));
        contentValues2.put("remark_name_all_pinyin", contentValues.getAsString("remark_all_pinyin"));
        contentValues2.put("remark_name_first_pinyin", contentValues.getAsString("remark_first_pinyin"));
        contentValues2.put("nick_name_all_pinyin", contentValues.getAsString("all_pinyin"));
        contentValues2.put("nick_name_first_pinyin", contentValues.getAsString("first_pinyin"));
        contentValues2.put("extra_data1", contentValues.getAsString("act"));
        return vh5Var.i("tb_group_members", contentValues2, "name=?", strArr) > 0;
    }

    public final int Y(wf5 wf5Var, vh5 vh5Var, ContentValues contentValues, String str, String[] strArr, Uri uri) {
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Integer num;
        String str7;
        String string;
        int i3;
        String str8;
        String str9;
        String string2;
        int i4;
        String str10 = "read";
        String str11 = "msg_status";
        String str12 = "packet_id";
        Object obj = contentValues.get("only_update_msg");
        Object obj2 = contentValues.get("params_msg_data_transfer");
        String str13 = "contact_relate";
        StringBuilder sb = new StringBuilder();
        String str14 = "message";
        sb.append("updateMessage start ");
        sb.append(str);
        sb.append(" onlyUpdateMsg=");
        sb.append(obj);
        sb.append(uri);
        LogUtil.i("sync_leg", sb.toString());
        if (obj2 != null) {
            vh5Var.a();
            try {
                i = com.zenmen.palmchat.database.a.h(vh5Var);
                wf5Var.h();
                vh5Var.h();
            } finally {
            }
        } else {
            if (obj == null) {
                vh5Var.a();
                try {
                    ArrayList<String> arrayListA = A(vh5Var, str, strArr, uri);
                    Object obj3 = null;
                    char c2 = 0;
                    if (arrayListA.size() > 0) {
                        i = vh5Var.i(DBUriManager.h(uri), contentValues, str, strArr);
                        Iterator<String> it = arrayListA.iterator();
                        i2 = 0;
                        while (it.hasNext()) {
                            String[] strArr2 = {it.next()};
                            String strH = DBUriManager.h(uri);
                            String[] strArr3 = new String[8];
                            strArr3[c2] = str12;
                            int i5 = 1;
                            strArr3[1] = str11;
                            strArr3[2] = str10;
                            strArr3[3] = "msg_extend";
                            strArr3[4] = "data1";
                            strArr3[5] = "msg_type";
                            strArr3[6] = str14;
                            strArr3[7] = str13;
                            String str15 = str12;
                            String str16 = str11;
                            int i6 = i;
                            String str17 = str10;
                            Cursor cursorG = vh5Var.g(strH, strArr3, "packet_id=?", strArr2, null, null, null);
                            if (cursorG != null) {
                                if (cursorG.moveToNext()) {
                                    String string3 = cursorG.getString(cursorG.getColumnIndex(str15));
                                    String string4 = cursorG.getString(cursorG.getColumnIndex("msg_extend"));
                                    str4 = str16;
                                    Integer numValueOf = Integer.valueOf(cursorG.getInt(cursorG.getColumnIndex(str4)));
                                    int i7 = cursorG.getInt(cursorG.getColumnIndex(str17));
                                    string2 = cursorG.getString(cursorG.getColumnIndex("data1"));
                                    int i8 = cursorG.getInt(cursorG.getColumnIndex("msg_type"));
                                    str2 = str17;
                                    String str18 = str14;
                                    String string5 = cursorG.getString(cursorG.getColumnIndex(str18));
                                    str14 = str18;
                                    str3 = str13;
                                    i5 = i7;
                                    i4 = i8;
                                    str8 = string5;
                                    string = cursorG.getString(cursorG.getColumnIndex(str3));
                                    str6 = string3;
                                    str9 = string4;
                                    num = numValueOf;
                                } else {
                                    str2 = str17;
                                    str3 = str13;
                                    str4 = str16;
                                    str6 = null;
                                    num = null;
                                    str9 = null;
                                    string = null;
                                    string2 = null;
                                    str8 = null;
                                    i4 = 0;
                                }
                                cursorG.close();
                                str5 = str9;
                                str7 = string2;
                                i3 = i4;
                            } else {
                                str2 = str17;
                                str3 = str13;
                                str4 = str16;
                                str5 = null;
                                str6 = null;
                                num = null;
                                str7 = null;
                                string = null;
                                i3 = 0;
                                str8 = null;
                            }
                            if (TextUtils.isEmpty(str7)) {
                                str13 = str3;
                            } else {
                                str13 = str3;
                                if (i3 != 28) {
                                }
                                g.i(str5, str7, null, null);
                                if (str6 == null && num != null) {
                                    String[] strArr4 = {str6};
                                    ContentValues contentValues2 = new ContentValues();
                                    m40.b(string);
                                    contentValues2.put("thread_message_status", num);
                                    contentValues2.put("latest_message_read", Integer.valueOf(i5));
                                    String str19 = (133 == i3 || 20000 == i3 || 20004 == i3) ? str8 : null;
                                    if (!TextUtils.isEmpty(str19)) {
                                        contentValues2.put("latest_message", str19);
                                    }
                                    i2 += vh5Var.i("tb_threads", contentValues2, "thread_message_mid=?", strArr4);
                                }
                                i = i6;
                                str11 = str4;
                                str12 = str15;
                                str10 = str2;
                                obj3 = null;
                                c2 = 0;
                            }
                            if (!TextUtils.isEmpty(str5) && str5.equals("message_type_link_illegal")) {
                                g.i(str5, str7, null, null);
                            }
                            if (str6 == null) {
                            }
                            i = i6;
                            str11 = str4;
                            str12 = str15;
                            str10 = str2;
                            obj3 = null;
                            c2 = 0;
                        }
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    vh5Var.h();
                    vh5Var.d();
                    if (i2 > 0) {
                        getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
                    }
                    LogUtil.i("sync_leg", "updateMessage end");
                    return i;
                } finally {
                }
            }
            contentValues.remove("only_update_msg");
            i = vh5Var.i(DBUriManager.h(uri), contentValues, str, strArr);
        }
        LogUtil.i("sync_leg", "updateMessage end");
        return i;
    }

    public final void Z(String str, Uri uri) throws Throwable {
        String string;
        SocialContentProvider socialContentProvider;
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        b bVarZ = z(str, writableDatabase);
        String str2 = bVarZ.f13884a;
        int i = bVarZ.b;
        String[] strArr = {str};
        Cursor cursorG = vh5Var.g(DBUriManager.e(uri), null, "group_id=? ", strArr, null, null, null);
        if (cursorG.moveToFirst()) {
            string = cursorG.getString(cursorG.getColumnIndex("name"));
            try {
                String strOptString = new JSONObject(cursorG.getString(cursorG.getColumnIndex("group_extra_info"))).optString("remarkName", "");
                if (!TextUtils.isEmpty(strOptString)) {
                    string = strOptString;
                }
            } catch (Exception unused) {
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("local_name", str2);
            contentValues.put("group_member_count", Integer.valueOf(i));
            vh5Var.i(DBUriManager.e(uri), contentValues, "group_id=? ", strArr);
        } else {
            string = null;
        }
        cursorG.close();
        String strG = DomainHelper.g(uri, str);
        if (TextUtils.isEmpty(string)) {
            socialContentProvider = this;
        } else {
            socialContentProvider = this;
            str2 = null;
        }
        socialContentProvider.a0(writableDatabase, strG, str2, uri);
    }

    public final String a() {
        if (c == null) {
            c = AccountUtils.p(getContext());
        }
        return c;
    }

    public final void a0(SQLiteDatabase sQLiteDatabase, String str, String str2, Uri uri) throws Throwable {
        String[] strArr;
        String str3;
        String strA;
        String str4;
        String str5;
        String str6;
        String str7;
        String strI;
        String str8;
        String str9;
        String str10;
        int i;
        int i2;
        int i3;
        long j;
        int i4;
        vh5 vh5Var;
        ContentValues contentValues;
        long j2;
        boolean z;
        String[] strArr2;
        int i5;
        String str11;
        String nameForShow;
        String strE;
        String str12;
        String str13;
        String str14;
        String string;
        String string2;
        String string3;
        String string4;
        int i6;
        int i7;
        long j3;
        int i8;
        vh5 vh5Var2 = new vh5(sQLiteDatabase, a());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iB = m40.b(str);
        if (iB == 0) {
            strA = str;
            strArr = new String[]{str};
            str3 = "contact_relate=?";
        } else {
            boolean zP = P();
            String str15 = "contact_relate" + com.zenmen.palmchat.database.a.b(zP);
            strArr = new String[]{DomainHelper.g(uri, m40.a(str)) + com.zenmen.palmchat.database.a.a(zP)};
            str3 = str15;
            strA = m40.a(str);
        }
        Cursor cursorG = vh5Var2.g(DBUriManager.h(uri), null, str3, strArr, null, null, "_id DESC limit 1");
        String str16 = "";
        String string5 = null;
        if (cursorG != null) {
            if (cursorG.moveToFirst()) {
                String string6 = cursorG.getString(cursorG.getColumnIndex("packet_id"));
                String string7 = cursorG.getString(cursorG.getColumnIndex("message"));
                int i9 = cursorG.getInt(cursorG.getColumnIndex("msg_status"));
                j3 = cursorG.getLong(cursorG.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
                int i10 = cursorG.getInt(cursorG.getColumnIndex("msg_type"));
                i8 = cursorG.getInt(cursorG.getColumnIndex("type"));
                string2 = cursorG.getString(cursorG.getColumnIndex("attach_status"));
                i2 = cursorG.getInt(cursorG.getColumnIndex("read"));
                String string8 = cursorG.getString(cursorG.getColumnIndex("msg_extend"));
                str12 = string6;
                string3 = cursorG.getString(cursorG.getColumnIndex("data3"));
                string4 = cursorG.getString(cursorG.getColumnIndex("data1"));
                String string9 = cursorG.getString(cursorG.getColumnIndex("data2"));
                string = cursorG.getString(cursorG.getColumnIndex("msg_extend"));
                str13 = string9;
                str16 = string8;
                i7 = i10;
                i6 = i9;
                str14 = string7;
            } else {
                str12 = "";
                str13 = null;
                str14 = null;
                string = null;
                string2 = null;
                string3 = null;
                string4 = null;
                i6 = 2;
                i7 = 1;
                i2 = 1;
                j3 = 0;
                i8 = 0;
            }
            cursorG.close();
            str9 = str13;
            str10 = string;
            i4 = i8;
            str6 = string2;
            str8 = string4;
            strI = str14;
            i3 = i7;
            str4 = str16;
            i = i6;
            str5 = str12;
            long j4 = j3;
            str7 = string3;
            j = j4;
        } else {
            str4 = "";
            str5 = str4;
            str6 = null;
            str7 = null;
            strI = null;
            str8 = null;
            str9 = null;
            str10 = null;
            i = 2;
            i2 = 1;
            i3 = 1;
            j = 0;
            i4 = 0;
        }
        DomainHelper.n(str);
        ContentValues contentValues2 = new ContentValues();
        if (i3 == 9) {
            ChatItem chatItemFromNameCardString = MessageVo.parseChatItemFromNameCardString(str4);
            if (iB == 1) {
                strE = m40.e(str6);
                str11 = "latest_message";
                nameForShow = x(sQLiteDatabase, strA, strE, uri, str4);
            } else {
                str11 = "latest_message";
                ContactInfoItem contactInfoItemR = R(sQLiteDatabase, str6);
                nameForShow = contactInfoItemR != null ? contactInfoItemR.getNameForShow() : null;
                strE = str6;
            }
            contentValues2.put(str11, tw5.a(chatItemFromNameCardString, strE, nameForShow, strA, null, strI));
            str8 = str8;
            vh5Var = vh5Var2;
            contentValues = contentValues2;
        } else if (i3 == 6) {
            String strE2 = m40.e(str6);
            if (iB != 1 || strE2 == null || strE2.equals(a())) {
                vh5Var = vh5Var2;
                contentValues = contentValues2;
                contentValues.put("latest_message", strI + str7);
            } else {
                vh5Var = vh5Var2;
                contentValues = contentValues2;
                contentValues.put("latest_message", x(sQLiteDatabase, strA, strE2, uri, str4) + ": " + strI + str7);
            }
        } else {
            vh5Var = vh5Var2;
            contentValues = contentValues2;
            if (i3 == 7) {
                contentValues.put("latest_message", strI);
            } else if (i3 == 33) {
                contentValues.put("latest_message", "[广场帖子]");
            } else if (i3 == 37) {
                if (str8 != null && str8.equals(String.valueOf(1))) {
                    VenusRoomShareCard venusRoomShareCardI = p96.i(str4);
                    if (venusRoomShareCardI != null) {
                        strI = venusRoomShareCardI.content;
                    }
                    contentValues.put("latest_message", " " + strI);
                } else {
                    contentValues.put("latest_message", strI);
                }
            } else if (i3 == 52) {
                contentValues.put("latest_message", strI);
            } else {
                if (i3 == 28) {
                    strI = g.i(str4, str8, strI, str6);
                }
                String strE3 = m40.e(str6);
                if (iB != 1 || strE3 == null || strE3.equals(a()) || i3 == 10001) {
                    contentValues.put("latest_message", strI);
                } else {
                    contentValues.put("latest_message", x(sQLiteDatabase, strA, strE3, uri, str4) + ": " + strI);
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("title", str2);
        }
        contentValues.put("thread_message_mid", str5);
        contentValues.put("thread_message_status", Integer.valueOf(i));
        contentValues.put("latest_message_mime_type", Integer.valueOf(i3));
        contentValues.put("latest_message_read", Integer.valueOf(i2));
        String[] strArr3 = {strA};
        Cursor cursorG2 = vh5Var.g("tb_threads", null, "contact_relate=?", strArr3, null, null, null);
        if (cursorG2 == null || !cursorG2.moveToFirst()) {
            j2 = 0;
            z = true;
        } else {
            j2 = cursorG2.getLong(cursorG2.getColumnIndex("latest_message_time_stamp"));
            string5 = cursorG2.getString(cursorG2.getColumnIndex("thread_biz_extension"));
            z = false;
        }
        if (j != 0) {
            if (j >= j2) {
                j = j2;
            }
            contentValues.put("latest_message_time_stamp", Long.valueOf(j));
        }
        if (cursorG2 == null || !cursorG2.moveToFirst()) {
            strArr2 = strArr3;
            i5 = 0;
        } else {
            i5 = cursorG2.getInt(cursorG2.getColumnIndex("thread_biz_type"));
            strArr2 = strArr3;
            contentValues.put("thread_biz_extension", ThreadBizExtHelper.d(i5, strA, i3, str8, str9, str10, i4, string5, z));
        }
        vh5 vh5Var3 = vh5Var;
        vh5Var3.i("tb_threads", contentValues, "contact_relate=?", strArr2);
        com.zenmen.palmchat.conversations.threadgroup.a.g(getContext(), i5, vh5Var3);
        cursorG2.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b(String[] strArr, Uri uri) {
        int iC;
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return -1;
        }
        vh5 vh5Var = new vh5(wf5VarA.getWritableDatabase(), a());
        if (strArr != null) {
            vh5Var.a();
            try {
                iC = 0;
                for (String str : strArr) {
                    iC += vh5Var.c(DBUriManager.h(uri), "packet_id=?", new String[]{str});
                }
                vh5Var.h();
            } catch (Exception e) {
                e.printStackTrace();
                iC = 0;
                if (iC > 0) {
                }
                return iC;
            } finally {
                vh5Var.d();
            }
        } else {
            iC = 0;
        }
        if (iC > 0) {
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        }
        return iC;
    }

    public final void b0(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String str2) throws Throwable {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("contact_relate=?");
        arrayList.add(str);
        fu5.c(sb, arrayList, str);
        String string = sb.toString();
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("icon_url", contentValues.getAsString("head_img_url"));
        contentValues2.put("thread_contact_ready", (Integer) 1);
        contentValues2.put("title", !TextUtils.isEmpty(contentValues.getAsString("remark_name")) ? contentValues.getAsString("remark_name") : !TextUtils.isEmpty(str2) ? str2 : contentValues.getAsString("nick_name"));
        String asString = contentValues.getAsString("chat_config");
        if (asString != null) {
            int iIntValue = TextUtils.isEmpty(asString) ? 0 : Integer.valueOf(asString).intValue();
            contentValues2.put("thread_nodisturb", Integer.valueOf(jw5.g(iIntValue) ? 1 : 0));
            contentValues2.put("thread_priority", Integer.valueOf(jw5.j(iIntValue) ? 100 : 0));
            contentValues2.put("thread_blacklist", Integer.valueOf(jw5.e(iIntValue) ? 1 : 0));
        }
        Cursor cursorG = vh5Var.g("tb_threads", null, string, strArr, null, null, null);
        if (cursorG != null) {
            while (cursorG.moveToNext()) {
                int i = cursorG.getInt(cursorG.getColumnIndex("thread_biz_type"));
                if (fu5.t(i)) {
                    if (!fu5.k(i).saveInTempTable && (!contentValues.containsKey("data2") || contentValues.getAsInteger("data2").intValue() == 0)) {
                        contentValues2.put("thread_biz_type", (Integer) 0);
                        contentValues2.put("is_super_greetings", (Integer) 0);
                    }
                } else if (!contentValues.containsKey("data2") || contentValues.getAsInteger("data2").intValue() == 0) {
                    contentValues2.put("thread_biz_type", (Integer) 0);
                }
                vh5Var.i("tb_threads", contentValues2, "contact_relate=?", new String[]{cursorG.getString(cursorG.getColumnIndex("contact_relate"))});
                if (!(cursorG.getInt(cursorG.getColumnIndex("thread_contact_ready")) == 1)) {
                    com.zenmen.palmchat.utils.a.E().p0(str, i);
                }
                com.zenmen.palmchat.conversations.threadgroup.a.g(getContext(), i, vh5Var);
            }
            cursorG.close();
        }
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        long jCurrentTimeMillis;
        StringBuilder sb = new StringBuilder();
        sb.append("action bulkInsert ");
        sb.append(uri);
        sb.append(contentValuesArr != null ? contentValuesArr.length : 0);
        LogUtil.i("SocialContentProvider_lag", sb.toString());
        int length = contentValuesArr.length;
        int iMatch = b.match(uri);
        if (iMatch == 3000) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            d(contentValuesArr, uri);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkInsertOrUpdateOneNewMessage timestamp stop:" + jCurrentTimeMillis);
        } else if (iMatch == 4000) {
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            e(contentValuesArr);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis3;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkInsertOrUpdateSyncKey timestamp stop:" + jCurrentTimeMillis);
        } else if (iMatch == 9000) {
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            h(contentValuesArr);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis4;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkOperateContactModifications timestamp stop:" + jCurrentTimeMillis);
        } else if (iMatch == 11000) {
            long jCurrentTimeMillis5 = System.currentTimeMillis();
            f(contentValuesArr, uri);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis5;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkInsertPhoneContacts timestamp:" + jCurrentTimeMillis);
        } else if (iMatch == 12000) {
            long jCurrentTimeMillis6 = System.currentTimeMillis();
            if (!g(contentValuesArr, uri)) {
                length = -1;
            }
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis6;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkModGroups timestamp stop:" + jCurrentTimeMillis);
        } else if (iMatch == 13000) {
            long jCurrentTimeMillis7 = System.currentTimeMillis();
            i(contentValuesArr, uri);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis7;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkOperateGroupMembersModifications timestamp:" + jCurrentTimeMillis);
        } else if (iMatch == 20000) {
            long jCurrentTimeMillis8 = System.currentTimeMillis();
            k(contentValuesArr, uri);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis8;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkOperateUploadContacts timestamp:" + jCurrentTimeMillis);
        } else {
            if (iMatch != 21000) {
                throw new UnsupportedOperationException("unkown uri:" + uri.toString());
            }
            long jCurrentTimeMillis9 = System.currentTimeMillis();
            c(contentValuesArr, uri);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis9;
            LogUtil.i("SocialContentProvider", "action bulkInsert bulkInsertDialogMessage timestamp:" + jCurrentTimeMillis);
        }
        if (Q(contentValuesArr)) {
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        }
        LogUtil.i("SocialContentProvider_lag", "action bulkinsert end " + uri + "  time=" + jCurrentTimeMillis);
        return length;
    }

    public final void c0(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        String[] strArr = {str};
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("icon_url", contentValues.getAsString("headImgUrl"));
        contentValues2.put("thread_contact_ready", (Integer) 1);
        String asString = contentValues.getAsString("group_extra_info");
        String strOptString = "";
        if (!TextUtils.isEmpty(asString)) {
            try {
                strOptString = new JSONObject(asString).optString("remarkName", "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(strOptString)) {
            contentValues2.put("title", strOptString);
        } else if (!TextUtils.isEmpty(contentValues.getAsString("name"))) {
            contentValues2.put("title", contentValues.getAsString("name"));
        }
        Integer asInteger = contentValues.getAsInteger("group_config");
        if (asInteger != null) {
            contentValues2.put("thread_nodisturb", Integer.valueOf(jw5.g(asInteger.intValue()) ? 1 : 0));
            contentValues2.put("thread_priority", Integer.valueOf(jw5.j(asInteger.intValue()) ? 100 : 0));
            contentValues2.put("thread_show_members_nick_name", Integer.valueOf(jw5.k(asInteger.intValue()) ? 1 : 0));
        }
        contentValues2.put("thread_blacklist", (Integer) 0);
        Cursor cursorG = vh5Var.g("tb_threads", null, "contact_relate=?", strArr, null, null, null);
        if (cursorG != null) {
            if (cursorG.moveToNext()) {
                vh5Var.i("tb_threads", contentValues2, "contact_relate=?", strArr);
                if (!(cursorG.getInt(cursorG.getColumnIndex("thread_contact_ready")) == 1)) {
                    com.zenmen.palmchat.utils.a.E().p0(str, cursorG.getInt(cursorG.getColumnIndex("thread_biz_type")));
                }
            }
            cursorG.close();
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Uri uri = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
        if (str.equals("bulkDeleteMessages")) {
            bundle2.putInt("count", b(bundle.getStringArray("package_id_array"), uri));
        } else if (str.equals("insertRawMessage")) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("message_values");
            wf5 wf5VarA = xf5.a(a());
            if (wf5VarA == null) {
                return bundle2;
            }
            bundle2.putLong("id", wf5VarA.getReadableDatabase().insert(DBUriManager.h(uri), null, contentValues));
        }
        return bundle2;
    }

    public final void d(ContentValues[] contentValuesArr, Uri uri) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        vh5Var.a();
        try {
            int length = contentValuesArr.length;
            boolean[] zArr = {false};
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                int iIntValue = ((Integer) contentValuesArr[i].get("msg_type")).intValue();
                if (iIntValue == 10 || iIntValue == 12 || iIntValue == 101 || iIntValue == 20 || iIntValue == 13 || iIntValue == 21) {
                    contentValuesArr[i].remove("msg_type");
                    G(contentValuesArr[i], writableDatabase);
                    z = true;
                } else {
                    ContentValues contentValues = contentValuesArr[i];
                    if (E(contentValues, writableDatabase, u(contentValues, uri), zArr).b) {
                        z = true;
                    }
                    z2 = true;
                }
            }
            vh5Var.h();
            if (z) {
                getContext().getContentResolver().notifyChange(vn0.f21483a, (ContentObserver) null, false);
            }
            if (z2) {
                getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            }
            if (zArr[0]) {
                iq5.j(false, new String[0]);
            }
        } finally {
            vh5Var.d();
        }
    }

    public final int d0(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        int i = 0;
        Cursor cursorG = null;
        try {
            try {
                cursorG = vh5Var.g("tb_threads", new String[]{"latest_message_time_stamp", "thread_biz_type"}, str, strArr, null, null, null);
                if (cursorG != null && cursorG.getCount() > 0 && cursorG.moveToFirst()) {
                    if (contentValues.containsKey("thread_draft_time") && contentValues.getAsLong("thread_draft_time").longValue() == 0) {
                        contentValues.put("thread_draft_time", Long.valueOf(cursorG.getLong(0)));
                    }
                    int i2 = cursorG.getInt(cursorG.getColumnIndex("thread_biz_type"));
                    i = vh5Var.i("tb_threads", contentValues, str, strArr);
                    com.zenmen.palmchat.conversations.threadgroup.a.g(getContext(), i2, vh5Var);
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.log4ClientError("provider_updateThreads", e);
                if (cursorG != null) {
                }
            }
            return i;
        } finally {
            if (cursorG != null) {
                cursorG.close();
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iR;
        LogUtil.i("SocialContentProvider_lag", "action delete " + uri + " " + str);
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return -1;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        int iMatch = b.match(uri);
        switch (iMatch) {
            case 3000:
                iR = r(writableDatabase, str, strArr, uri);
                break;
            case 4000:
                iR = vh5Var.c("tb_synckey", str, strArr);
                break;
            case 8000:
                iR = vh5Var.c("tb_download", str, strArr);
                break;
            case 9000:
                iR = vh5Var.c("tb_contacts", str, strArr);
                break;
            case 10000:
                iR = t(writableDatabase, str, strArr);
                break;
            case 11000:
                try {
                    iR = vh5Var.c("tb_contact_requests", str, strArr);
                } catch (SQLiteBlobTooBigException unused) {
                    iR = 0;
                }
                break;
            case ErrorCode.REASON_TEE /* 12000 */:
                iR = o(writableDatabase, str, strArr, uri);
                break;
            case 15000:
                iR = vh5Var.c("tb_favorite_expression", str, strArr);
                break;
            case ErrorCode.REASON_DS_OUT_OF_RANGE /* 17000 */:
                iR = vh5Var.c("tb_account", str, strArr);
                break;
            case ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW /* 18000 */:
                iR = vh5Var.c("tb_video", str, strArr);
                break;
            case 20000:
                iR = vh5Var.c("tb_uploaded_contact", str, strArr);
                break;
            case ErrorCode.REASON_EXTRACTOR_UNSUPPORT /* 21000 */:
                iR = vh5Var.c("tb_dialog_message", str, strArr);
                break;
            default:
                throw new UnsupportedOperationException("unkown uri:" + uri.toString());
        }
        if (iR > 0) {
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
            if (iMatch == 12000 && iR > 0) {
                getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            }
        }
        LogUtil.i("SocialContentProvider_lag", "action delete end" + uri);
        return iR;
    }

    public final void e(ContentValues[] contentValuesArr) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        vh5Var.a();
        try {
            int length = contentValuesArr.length;
            for (int i = 0; i < length; i++) {
                N(writableDatabase, contentValuesArr[i].getAsString("resource_type"), contentValuesArr[i].getAsLong("resource_version").longValue(), contentValuesArr[i].getAsBoolean(CommonCode.MapKey.UPDATE_VERSION));
            }
            vh5Var.h();
        } finally {
            vh5Var.d();
        }
    }

    public final void f(ContentValues[] contentValuesArr, Uri uri) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (ContentValues contentValues : contentValuesArr) {
                if (contentValues != null) {
                    writableDatabase.insert("tb_contact_requests", null, contentValues);
                }
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            try {
                writableDatabase.endTransaction();
            } catch (SQLiteException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g(ContentValues[] contentValuesArr, Uri uri) {
        boolean z;
        ArrayList arrayList;
        int length;
        int i;
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return false;
        }
        vh5 vh5Var = new vh5(wf5VarA.getWritableDatabase(), a());
        vh5Var.a();
        try {
            try {
                arrayList = new ArrayList();
                length = contentValuesArr.length;
                i = 0;
                z = false;
            } finally {
                vh5Var.d();
            }
        } catch (Exception e) {
            e = e;
            z = false;
        }
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                break;
            }
            try {
                ContentValues contentValues = contentValuesArr[i];
                if (contentValues != null) {
                    int iIntValue = contentValues.getAsInteger("group_operation").intValue();
                    contentValues.remove("group_operation");
                    if (iIntValue == 1) {
                        I(contentValues, uri);
                    } else {
                        if (iIntValue == 2) {
                            try {
                                p(contentValues, uri);
                            } catch (Exception e2) {
                                e = e2;
                                z = true;
                            }
                        } else if (iIntValue == 3) {
                            B(contentValues, uri);
                            arrayList.add((String) contentValues.get("group_id"));
                        } else if (iIntValue == 4) {
                            S(contentValues, uri);
                        }
                        z = true;
                    }
                }
                i++;
            } catch (Exception e3) {
                e = e3;
            }
            e = e3;
            LogUtil.log4ClientError("provider_bulkModGroups", e);
            e.printStackTrace();
            vh5Var.d();
            z2 = false;
            if (z) {
                getContext().getContentResolver().notifyChange(je2.f18392a, (ContentObserver) null, false);
            }
            getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            return z2;
        }
        j(ae2.e(arrayList), uri);
        vh5Var.h();
        if (z) {
        }
        getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
        return z2;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    public final void h(ContentValues[] contentValuesArr) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        writableDatabase.beginTransaction();
        boolean[] zArr = {false, false};
        try {
            try {
                for (ContentValues contentValues : contentValuesArr) {
                    int iIntValue = contentValues.getAsInteger("contact_operation").intValue();
                    contentValues.remove("contact_operation");
                    if (iIntValue == 2) {
                        try {
                            s(writableDatabase, contentValues);
                        } catch (Exception e) {
                            e.printStackTrace();
                            LogUtil.log4ClientError("bulkOperateContactModificationsEach", e);
                            if (!yn0.b()) {
                                throw e;
                            }
                        }
                    } else if (iIntValue == 1) {
                        F(writableDatabase, contentValues, zArr);
                    } else if (iIntValue == 3) {
                        V(writableDatabase, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.log4ClientError("bulkOperateContactModifications", e2);
            }
            getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            if (zArr[0]) {
                getContext().getContentResolver().notifyChange(je2.f18392a, (ContentObserver) null, false);
            }
            if (zArr[1]) {
                getContext().getContentResolver().notifyChange(vn0.f21483a, (ContentObserver) null, false);
            }
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void i(ContentValues[] contentValuesArr, Uri uri) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            HashSet hashSet = new HashSet();
            for (ContentValues contentValues : contentValuesArr) {
                if (contentValues != null) {
                    int iIntValue = contentValues.getAsInteger("group_member_operation").intValue();
                    contentValues.remove("group_member_operation");
                    if (iIntValue == 2) {
                        q(contentValues);
                    } else if (iIntValue == 1) {
                        J(contentValues);
                    }
                    String str = (String) contentValues.get("group_id");
                    if (!TextUtils.isEmpty(str)) {
                        hashSet.add(str);
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Z((String) it.next(), uri);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            getContext().getContentResolver().notifyChange(je2.f18392a, (ContentObserver) null, false);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        long jL;
        LogUtil.i("SocialContentProvider_lag", "action insert " + uri);
        int iMatch = b.match(uri);
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return null;
        }
        switch (iMatch) {
            case 3000:
                jL = L(contentValues, uri);
                break;
            case 4000:
                jL = wf5VarA.getWritableDatabase().insert("tb_synckey", null, contentValues);
                break;
            case 8000:
                jL = wf5VarA.getWritableDatabase().insert("tb_download", null, contentValues);
                break;
            case 9000:
                jL = H(wf5VarA.getWritableDatabase(), contentValues);
                break;
            case 10000:
                jL = O(contentValues);
                break;
            case 11000:
                jL = D(contentValues);
                break;
            case 15000:
                jL = wf5VarA.getWritableDatabase().insert("tb_favorite_expression", null, contentValues);
                break;
            case ErrorCode.REASON_DS_OUT_OF_RANGE /* 17000 */:
                jL = C(wf5VarA.getWritableDatabase(), contentValues);
                break;
            case ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW /* 18000 */:
                jL = wf5VarA.getWritableDatabase().insert("tb_video", null, contentValues);
                break;
            case 20000:
                jL = wf5VarA.getWritableDatabase().insert("tb_uploaded_contact", null, contentValues);
                break;
            case ErrorCode.REASON_EXTRACTOR_UNSUPPORT /* 21000 */:
                jL = wf5VarA.getWritableDatabase().insert("tb_dialog_message", null, contentValues);
                break;
            default:
                throw new UnsupportedOperationException("unkown uri:" + uri.toString());
        }
        if (jL <= 0) {
            return null;
        }
        getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        if (iMatch == 3000) {
            int iIntValue = contentValues.getAsInteger("msg_status").intValue();
            String asString = contentValues.getAsString("packet_id");
            if (iIntValue == 4 && !TextUtils.isEmpty(asString)) {
                this.f13882a.postDelayed(new a(uri, asString), 2000L);
            }
        }
        LogUtil.i("SocialContentProvider_lag", "action insert end" + uri);
        return ContentUris.withAppendedId(uri, jL);
    }

    public final void j(ContentValues[] contentValuesArr, Uri uri) throws Throwable {
        HashSet hashSet = new HashSet();
        for (ContentValues contentValues : contentValuesArr) {
            if (contentValues != null) {
                int iIntValue = contentValues.getAsInteger("group_member_operation").intValue();
                contentValues.remove("group_member_operation");
                if (iIntValue == 2) {
                    q(contentValues);
                } else if (iIntValue == 1) {
                    J(contentValues);
                }
                String str = (String) contentValues.get("group_id");
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Z((String) it.next(), uri);
        }
        getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
        getContext().getContentResolver().notifyChange(je2.f18392a, (ContentObserver) null, false);
    }

    public final void k(ContentValues[] contentValuesArr, Uri uri) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (ContentValues contentValues : contentValuesArr) {
                if (contentValues != null) {
                    writableDatabase.insert("tb_uploaded_contact", null, contentValues);
                }
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void m(Cursor cursor) {
        MessageVo messageVoBuildFromCursor;
        if (cursor == null || (messageVoBuildFromCursor = MessageVo.buildFromCursor(cursor)) == null || messageVoBuildFromCursor.isSend) {
            return;
        }
        int i = messageVoBuildFromCursor.mimeType;
        String str = i != 2 ? i != 3 ? (i == 4 || i == 6) ? messageVoBuildFromCursor.data1 : null : messageVoBuildFromCursor.data2 : messageVoBuildFromCursor.data1;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str);
            LogUtil.i("deleteDownloadedFileOnMsgRecalled", "file=" + str + " result=" + (file.exists() ? file.delete() : false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int n(SQLiteDatabase sQLiteDatabase, String str, Uri uri) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        int iC = vh5Var.c(DBUriManager.e(uri), "group_id=?", new String[]{str});
        String strG = DomainHelper.g(uri, str);
        boolean zP = P();
        LogUtil.i("SocialContentProvider", "processHotChatCmdMessage deleteGroup hocId=" + str + "count=" + iC + " " + vh5Var.c(DBUriManager.h(uri), "contact_relate" + com.zenmen.palmchat.database.a.b(zP), new String[]{strG + com.zenmen.palmchat.database.a.a(zP)}) + " " + vh5Var.c("tb_threads", "contact_relate=?", new String[]{str}) + "uri=" + uri);
        return iC;
    }

    public final int o(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, Uri uri) {
        Cursor cursorG = new vh5(sQLiteDatabase, a()).g(DBUriManager.e(uri), null, str, strArr, null, null, null);
        if (cursorG != null) {
            iN = cursorG.moveToFirst() ? n(sQLiteDatabase, cursorG.getString(cursorG.getColumnIndex("group_id")), uri) : 0;
            cursorG.close();
        }
        return iN;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        HandlerThread handlerThreadA = lg2.a("contentprovider_work_thread");
        handlerThreadA.start();
        this.f13882a = new Handler(handlerThreadA.getLooper());
        return true;
    }

    public final long p(ContentValues contentValues, Uri uri) {
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return 0L;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        Object obj = contentValues.get("resource_version");
        Object obj2 = contentValues.get("resource_type");
        if (obj != null && obj2 != null) {
            long jLongValue = ((Long) obj).longValue();
            contentValues.remove("resource_version");
            contentValues.remove("resource_type");
            M(writableDatabase, (String) obj2, jLongValue);
        }
        String str = (String) contentValues.get("group_id");
        vh5Var.c(DBUriManager.e(uri), "group_id=?", new String[]{str});
        vh5Var.c("tb_threads", "contact_relate=?", new String[]{str});
        boolean zP = P();
        vh5Var.c(DBUriManager.h(uri), "contact_relate" + com.zenmen.palmchat.database.a.b(zP), new String[]{DomainHelper.g(uri, str) + com.zenmen.palmchat.database.a.a(zP)});
        return vh5Var.c("tb_group_members", "group_id=? ", new String[]{str});
    }

    public final long q(ContentValues contentValues) {
        wf5 wf5VarA = xf5.a(a());
        long jI = 0;
        if (wf5VarA == null) {
            return 0L;
        }
        vh5 vh5Var = new vh5(wf5VarA.getWritableDatabase(), a());
        String[] strArr = {(String) contentValues.get("group_id"), (String) contentValues.get("name")};
        Cursor cursorG = vh5Var.g("tb_group_members", null, "group_id=? and name=?", strArr, null, null, null);
        if (cursorG.moveToFirst()) {
            contentValues.put("group_member_state", (Integer) 1);
            jI = vh5Var.i("tb_group_members", contentValues, "group_id=? and name=?", strArr);
        }
        cursorG.close();
        return jI;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery;
        LogUtil.i("SocialContentProvider_lag", "action query start " + uri + " " + str);
        wf5 wf5VarA = xf5.a(a());
        Cursor cursor = null;
        if (wf5VarA == null) {
            return null;
        }
        SQLiteDatabase readableDatabase = wf5VarA.getReadableDatabase();
        new vh5(readableDatabase, a());
        int iMatch = b.match(uri);
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (iMatch) {
            case 3000:
                sQLiteQueryBuilder.setTables(DBUriManager.h(uri));
                break;
            case MspSdkCode.CODE_METHOD_CALL_EXCEPTION /* 3011 */:
                sQLiteQueryBuilder.setTables(DBUriManager.h(uri));
                sQLiteQueryBuilder.appendWhere("contact_relate=" + uri.getPathSegments().get(1));
                break;
            case 4000:
                sQLiteQueryBuilder.setTables("tb_synckey");
                break;
            case 8000:
                sQLiteQueryBuilder.setTables("tb_download");
                break;
            case 9000:
                sQLiteQueryBuilder.setTables("tb_contacts");
                break;
            case 10000:
                sQLiteQueryBuilder.setTables("tb_threads");
                break;
            case 11000:
                sQLiteQueryBuilder.setTables("tb_contact_requests");
                break;
            case ErrorCode.REASON_TEE /* 12000 */:
                sQLiteQueryBuilder.setTables(DBUriManager.e(uri));
                break;
            case ErrorCode.REASON_DS_SCHEME /* 13000 */:
                sQLiteQueryBuilder.setTables("tb_group_members");
                break;
            case 15000:
                sQLiteQueryBuilder.setTables("tb_favorite_expression");
                break;
            case ErrorCode.REASON_DS_OUT_OF_RANGE /* 17000 */:
                sQLiteQueryBuilder.setTables("tb_account");
                break;
            case ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW /* 18000 */:
                sQLiteQueryBuilder.setTables("tb_video");
                break;
            case 20000:
                sQLiteQueryBuilder.setTables("tb_uploaded_contact");
                break;
            case ErrorCode.REASON_EXTRACTOR_UNSUPPORT /* 21000 */:
                sQLiteQueryBuilder.setTables("tb_dialog_message");
                break;
            default:
                throw new UnsupportedOperationException("unkown uri:" + uri.toString());
        }
        try {
            cursorQuery = sQLiteQueryBuilder.query(readableDatabase, strArr, str, strArr2, null, null, str2);
            if (cursorQuery != null) {
                try {
                    cursorQuery.getCount();
                } catch (Exception e) {
                    e = e;
                    LogUtil.log4ClientError("provider_Query", e);
                    Log.i("SocialContentProvider", "get IllegalStateException ");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            cursor = cursorQuery;
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        }
        if (cursor != null) {
            try {
                cursor.setNotificationUri(getContext().getContentResolver(), uri);
            } catch (SecurityException e3) {
                e3.printStackTrace();
            }
        }
        LogUtil.i("SocialContentProvider_lag", "action query end" + uri);
        return cursor;
    }

    public final int r(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, Uri uri) {
        int iDelete;
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        vh5Var.a();
        try {
            try {
                Cursor cursorG = vh5Var.g(DBUriManager.h(uri), null, str, strArr, null, null, null);
                if (cursorG != null) {
                    if (cursorG.moveToFirst()) {
                        String string = cursorG.getString(cursorG.getColumnIndex("contact_relate"));
                        iDelete = sQLiteDatabase.delete(DBUriManager.h(uri), str, strArr);
                        if (iDelete > 0) {
                            try {
                                a0(sQLiteDatabase, string, null, uri);
                            } catch (Exception e) {
                                e = e;
                                LogUtil.e("SocialContentProvider", e);
                                LogUtil.log4ClientError("provider_deleteMessage", e);
                            }
                        }
                    } else {
                        iDelete = 0;
                    }
                    cursorG.close();
                } else {
                    iDelete = 0;
                }
                vh5Var.h();
            } catch (Exception e2) {
                e = e2;
                iDelete = 0;
            }
            getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            return iDelete;
        } finally {
            vh5Var.d();
        }
    }

    public final long s(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        Object obj = contentValues.get("resource_version");
        Object obj2 = contentValues.get("resource_type");
        if (obj != null && obj2 != null) {
            long jLongValue = ((Long) obj).longValue();
            contentValues.remove("resource_version");
            contentValues.remove("resource_type");
            M(sQLiteDatabase, (String) obj2, jLongValue);
        }
        String str = (String) contentValues.get(DeviceInfoUtil.UID_TAG);
        long jC = vh5Var.c("tb_contacts", "uid=? and data2 is ?", new String[]{str, String.valueOf(0)});
        if (jC > 0) {
            LogUtil.i("SocialContentProvider", "rowId=" + jC + "messageCoun=" + vh5Var.c("tb_messages", "contact_relate=? ", new String[]{str}) + "threadCount=" + vh5Var.c("tb_threads", "contact_relate=? ", new String[]{str}));
        }
        return jC;
    }

    public final int t(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        vh5Var.a();
        int iC = 0;
        try {
            try {
                Cursor cursorG = vh5Var.g("tb_threads", null, str, strArr, null, null, null);
                if (cursorG != null) {
                    if (cursorG.moveToFirst()) {
                        int i = cursorG.getInt(cursorG.getColumnIndex("thread_biz_type"));
                        iC = vh5Var.c("tb_threads", str, strArr);
                        com.zenmen.palmchat.conversations.threadgroup.a.g(getContext(), i, vh5Var);
                    }
                    cursorG.close();
                }
                vh5Var.h();
            } catch (Exception e) {
                LogUtil.e("SocialContentProvider", e);
            }
            return iC;
        } finally {
            vh5Var.d();
        }
    }

    public final Uri u(ContentValues contentValues, Uri uri) {
        Uri uriA;
        if (contentValues != null) {
            uriA = DBUriManager.a(ho3.class, contentValues.containsKey("thread_biz_type") ? ((Integer) contentValues.get("thread_biz_type")).intValue() : 0);
        } else {
            uriA = uri;
        }
        LogUtil.i("SocialContentProvider", "fixUriOnNewMessage ori=" + uri + " fix =" + uriA);
        LogUtil.d("logmsg", "fixUriOnNewMessage: ori = " + uri + ", fix = " + uriA);
        return uriA;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iY;
        LogUtil.i("SocialContentProvider_lag", "action update " + uri + " " + str);
        wf5 wf5VarA = xf5.a(a());
        if (wf5VarA == null) {
            return -1;
        }
        SQLiteDatabase writableDatabase = wf5VarA.getWritableDatabase();
        vh5 vh5Var = new vh5(writableDatabase, a());
        switch (b.match(uri)) {
            case 3000:
                iY = Y(wf5VarA, vh5Var, contentValues, str, strArr, uri);
                break;
            case 4000:
                iY = vh5Var.i("tb_synckey", contentValues, str, strArr);
                break;
            case 8000:
                iY = vh5Var.i("tb_download", contentValues, str, strArr);
                break;
            case 9000:
                iY = vh5Var.i("tb_contacts", contentValues, str, strArr);
                break;
            case 10000:
                iY = d0(writableDatabase, contentValues, str, strArr);
                break;
            case 11000:
                iY = vh5Var.i("tb_contact_requests", contentValues, str, strArr);
                break;
            case ErrorCode.REASON_TEE /* 12000 */:
                iY = vh5Var.i(DBUriManager.e(uri), contentValues, str, strArr);
                break;
            case ErrorCode.REASON_DS_SCHEME /* 13000 */:
                iY = vh5Var.i("tb_group_members", contentValues, str, strArr);
                break;
            case 15000:
                iY = vh5Var.i("tb_favorite_expression", contentValues, str, strArr);
                break;
            case ErrorCode.REASON_DS_OUT_OF_RANGE /* 17000 */:
                iY = vh5Var.i("tb_account", contentValues, str, strArr);
                break;
            case ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW /* 18000 */:
                iY = vh5Var.i("tb_video", contentValues, str, strArr);
                break;
            case 20000:
                iY = vh5Var.i("tb_uploaded_contact", contentValues, str, strArr);
                break;
            case ErrorCode.REASON_EXTRACTOR_UNSUPPORT /* 21000 */:
                iY = vh5Var.i("tb_dialog_message", contentValues, str, strArr);
                break;
            default:
                throw new UnsupportedOperationException("unkown uri:" + uri.toString());
        }
        if (iY > 0) {
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        }
        LogUtil.i("SocialContentProvider_lag", "action update end" + uri);
        return iY;
    }

    public final String w(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        String str3 = str + "/" + str2;
        if (str == null || str2 == null) {
            return str3;
        }
        Cursor cursorG = vh5Var.g("tb_group_members", null, "group_id=? and name=?", new String[]{str, str2}, null, null, null);
        if (cursorG.moveToFirst()) {
            String string = cursorG.getString(cursorG.getColumnIndex("nick_name"));
            str2 = cursorG.getString(cursorG.getColumnIndex(bt.s));
            String string2 = cursorG.getString(cursorG.getColumnIndex("remark_name"));
            if (!TextUtils.isEmpty(string2)) {
                str2 = string2;
            } else if (TextUtils.isEmpty(str2)) {
                str2 = string;
            }
        }
        cursorG.close();
        return str2;
    }

    public final String x(SQLiteDatabase sQLiteDatabase, String str, String str2, Uri uri, String str3) {
        return w(sQLiteDatabase, str, str2);
    }

    public final String y(SQLiteDatabase sQLiteDatabase, String str, Uri uri) {
        String[] strArr;
        String str2;
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            vh5 vh5Var = new vh5(sQLiteDatabase, a());
            if (m40.b(str) == 0) {
                strArr = new String[]{str};
                str2 = "contact_relate=?";
            } else {
                boolean zP = P();
                String str4 = "contact_relate" + com.zenmen.palmchat.database.a.b(zP);
                strArr = new String[]{DomainHelper.g(uri, m40.a(str)) + com.zenmen.palmchat.database.a.a(zP)};
                str2 = str4;
            }
            Cursor cursorG = vh5Var.g(DBUriManager.h(uri), null, str2, strArr, null, null, "_id DESC limit 1");
            if (cursorG != null) {
                if (cursorG.moveToFirst()) {
                    String string = cursorG.getString(cursorG.getColumnIndex("message"));
                    int i = cursorG.getInt(cursorG.getColumnIndex("msg_type"));
                    String string2 = cursorG.getString(cursorG.getColumnIndex("msg_extend"));
                    String string3 = cursorG.getString(cursorG.getColumnIndex("data1"));
                    String string4 = cursorG.getString(cursorG.getColumnIndex("src"));
                    if (i == 28) {
                        string = g.i(string2, string3, string, string4);
                    }
                    str3 = string;
                }
                cursorG.close();
            }
        }
        return str3;
    }

    public final b z(String str, SQLiteDatabase sQLiteDatabase) {
        vh5 vh5Var = new vh5(sQLiteDatabase, a());
        b bVar = new b();
        Cursor cursorG = vh5Var.g("tb_group_members", null, "group_id=? and group_member_state=?", new String[]{str, Integer.toString(0)}, null, null, null);
        StringBuilder sb = new StringBuilder();
        String string = AppContext.getContext().getResources().getString(R.string.comma);
        int count = cursorG.getCount();
        while (cursorG.moveToNext()) {
            ContactInfoItem contactInfoItemR = R(sQLiteDatabase, cursorG.getString(cursorG.getColumnIndex("name")));
            String nameForShow = contactInfoItemR != null ? contactInfoItemR.getNameForShow() : "";
            if (TextUtils.isEmpty(nameForShow)) {
                nameForShow = cursorG.getString(cursorG.getColumnIndex("nick_name"));
            }
            sb.append(nameForShow);
            sb.append(string);
        }
        sb.setLength(Math.max(sb.length() - 1, 0));
        String string2 = sb.toString();
        cursorG.close();
        bVar.f13884a = string2;
        bVar.b = count;
        return bVar;
    }

    public final void c(ContentValues[] contentValuesArr, Uri uri) {
    }
}
