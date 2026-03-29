package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.protobuf.GeneratedMessageLite;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.MomentsConfig;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.ShareLinkBean;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bn2;
import defpackage.f33;
import defpackage.me3;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class ko3 {
    public static final String g = "ko3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18730a;
    public ExecutorService b;
    public ExecutorService c;
    public HandlerThread d;
    public Handler e;
    public ConcurrentHashMap<String, Integer> f = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends eo3 {
        public final /* synthetic */ MessageVo f;
        public final /* synthetic */ int g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        /* JADX INFO: renamed from: ko3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1225a extends HashMap<String, Object> {
            public C1225a() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("type", Integer.valueOf(a.this.f.mimeType));
                put("flag", Integer.valueOf(a.this.g));
                put("mid", a.this.f.mid);
                put(RemoteMessageConst.TO, a.this.h);
                put("redpacket", a.this.f.data1);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends jo3 {
            public b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(a.this.f20636a, null, null, null, null);
                a.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(a.this.f20636a, generatedMessageLite, null, null, null);
                a.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MessageVo messageVo, MessageVo messageVo2, int i, String str, String str2) {
            super(messageVo);
            this.f = messageVo2;
            this.g = i;
            this.h = str;
            this.i = str2;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            LogUtil.i(s0.e, 3, new C1225a(), (Throwable) null);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(this.i).setTo(this.h).setMid(this.f20636a.mid).setType(this.f20636a.mimeType).setExType(Integer.parseInt(this.f20636a.data3)).setBody(TextUtils.isEmpty(this.f20636a.text) ? AppContext.getContext().getString(R.string.text_redpacket_des) : this.f20636a.text).setFlag(this.g);
            flag.setSubType(this.f.getSubTypeForSend());
            String str = this.f20636a.extention;
            if (TextUtils.isEmpty(this.f.bizExtension)) {
                flag.setExtension(str);
            } else {
                flag.setExtension(MessageVo.mergeJsonStrings(this.f.bizExtension, str));
            }
            b bVar = new b(flag.build(), ko3.this.f18730a, this.g, "sendRedPacketMessage");
            f(bVar);
            bVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends eo3 {
        public final /* synthetic */ int f;
        public final /* synthetic */ MessageVo g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("type", 7);
                put("flag", Integer.valueOf(b.this.f));
                put("mid", b.this.g.mid);
                put(RemoteMessageConst.TO, b.this.h);
                put("location", b.this.g.data1);
            }
        }

        /* JADX INFO: renamed from: ko3$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1226b extends jo3 {
            public C1226b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(b.this.f20636a, null, null, null, null);
                b.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(b.this.f20636a, generatedMessageLite, null, null, null);
                b.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MessageVo messageVo, int i, MessageVo messageVo2, String str, String str2) {
            super(messageVo);
            this.f = i;
            this.g = messageVo2;
            this.h = str;
            this.i = str2;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            LogUtil.i(s0.e, 3, new a(), (Throwable) null);
            try {
                if (SAppUtil.b.b() && !TextUtils.isEmpty(this.g.data1)) {
                    new JSONObject(this.g.data1).getString("name");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(this.i).setTo(this.h).setMid(this.f20636a.mid).setType(this.f20636a.mimeType).setBody(AppContext.getContext().getString(R.string.message_type_location)).setFlag(this.f);
            flag.setSubType(this.g.getSubTypeForSend());
            if (TextUtils.isEmpty(this.g.bizExtension)) {
                flag.setExtension(this.f20636a.data1);
            } else {
                flag.setExtension(MessageVo.mergeJsonStrings(this.g.bizExtension, this.f20636a.data1));
            }
            C1226b c1226b = new C1226b(flag.build(), ko3.this.f18730a, this.f, "sendLocationMessage");
            f(c1226b);
            c1226b.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends eo3 {
        public final /* synthetic */ MessageVo f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ me3.a f18733a;

            /* JADX INFO: renamed from: ko3$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1227a extends JSONArray {
                public C1227a() {
                    put(a.this.f18733a.f19200a);
                }
            }

            public a(me3.a aVar) {
                this.f18733a = aVar;
                put("md5", c.this.f.data4);
                if (TextUtils.isEmpty(aVar.f19200a)) {
                    return;
                }
                put("acode", new C1227a());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends jo3 {
            public b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(c.this.f20636a, null, null, null, null);
                c.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                c cVar = c.this;
                MessageVo messageVo = cVar.f20636a;
                String str = cVar.f.data3;
                mb4.f(messageVo, generatedMessageLite, str, str, null);
                c.this.c();
            }
        }

        /* JADX INFO: renamed from: ko3$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1228c extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ File f18735a;

            public C1228c(File file) {
                this.f18735a = file;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadStart");
                put("mid", c.this.f.mid);
                put("type", Integer.valueOf(c.this.f.mimeType));
                put(RemoteMessageConst.TO, c.this.g);
                put("filePath", c.this.f.data2);
                put("fileSize", Long.valueOf(file.length()));
                put("flag", Integer.valueOf(c.this.h));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements a56 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18736a;
            public final /* synthetic */ File b;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UploadResultVo f18737a;

                public a(UploadResultVo uploadResultVo) {
                    this.f18737a = uploadResultVo;
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "success");
                    put("response", uploadResultVo.toString());
                    put("duration", Long.valueOf(ir5.e(d.this.f18736a)));
                    put("mid", c.this.f.mid);
                    put("type", 3);
                    put(RemoteMessageConst.TO, c.this.g);
                    put("filePath", c.this.f.data2);
                    put("fileSize", Long.valueOf(d.this.b.length()));
                    put("flag", Integer.valueOf(c.this.h));
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class b extends HashMap<String, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UploadResultVo f18738a;

                /* JADX INFO: compiled from: SearchBox */
                public class a extends JSONArray {
                    public a() {
                        put(b.this.f18738a.acode);
                    }
                }

                public b(UploadResultVo uploadResultVo) {
                    this.f18738a = uploadResultVo;
                    put("md5", c.this.f.data4);
                    if (TextUtils.isEmpty(uploadResultVo.acode)) {
                        return;
                    }
                    put("acode", new a());
                }
            }

            /* JADX INFO: renamed from: ko3$c$d$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1229c extends jo3 {
                public final /* synthetic */ UploadResultVo h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C1229c(MessageProto.Message message, Context context, int i, String str, UploadResultVo uploadResultVo) {
                    super(message, context, i, str);
                    this.h = uploadResultVo;
                }

                @Override // defpackage.jo3
                public void d() {
                    mb4.f(c.this.f20636a, null, null, null, null);
                    c.this.c();
                }

                @Override // defpackage.jo3
                public void e(GeneratedMessageLite generatedMessageLite) {
                    MessageVo messageVo = c.this.f20636a;
                    UploadResultVo uploadResultVo = this.h;
                    String strA = me3.a(uploadResultVo.url, uploadResultVo.acode);
                    UploadResultVo uploadResultVo2 = this.h;
                    mb4.f(messageVo, generatedMessageLite, strA, me3.a(uploadResultVo2.url, uploadResultVo2.acode), null);
                    c.this.c();
                }
            }

            /* JADX INFO: renamed from: ko3$c$d$d, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1230d extends HashMap<String, Object> {
                public C1230d() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "fail");
                    put("fileSize", Long.valueOf(d.this.b.length()));
                    put("mid", c.this.f20636a.mid);
                    put("type", 3);
                    put(RemoteMessageConst.TO, c.this.g);
                    put("audioPath", c.this.f20636a.data2);
                    put("flag", Integer.valueOf(c.this.h));
                    put("response", "uploadResultVo is null");
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class e extends HashMap<String, Object> {
                public e() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "fail");
                    put("fileSize", Long.valueOf(d.this.b.length()));
                    put("mid", c.this.f20636a.mid);
                    put("type", 3);
                    put(RemoteMessageConst.TO, c.this.g);
                    put("audioPath", c.this.f20636a.data2);
                    put("flag", Integer.valueOf(c.this.h));
                }
            }

            public d(long j, File file) {
                this.f18736a = j;
                this.b = file;
            }

            @Override // defpackage.a56
            public void a(Exception exc) {
                LogUtil.i(s0.e, 3, new e(), exc);
                mb4.f(c.this.f20636a, null, null, null, null);
                c.this.c();
            }

            @Override // defpackage.a56
            public void b(UploadResultVo uploadResultVo) {
                if (uploadResultVo == null) {
                    LogUtil.i(s0.e, 3, new C1230d(), (Throwable) null);
                    mb4.f(c.this.f20636a, null, null, null, null);
                    c.this.c();
                    return;
                }
                String str = s0.e;
                LogUtil.i(str, 3, new a(uploadResultVo), (Throwable) null);
                MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setThumbUrl(uploadResultVo.url).setSize((int) this.b.length()).setName(this.b.getName()).setUrl(uploadResultVo.url).setPlayLength(Integer.valueOf(c.this.f20636a.data1).intValue()).setExtension(k86.c(new b(uploadResultVo))).build();
                LogUtil.i(str, "mediaPart =" + mediaBuild);
                MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(c.this.f20636a.mid).setTo(c.this.g).setBody(AppContext.getContext().getResources().getString(R.string.message_type_audio)).setType(3).setMedia(mediaBuild).setFlag(c.this.h);
                flag.setSubType(c.this.f.getSubTypeForSend());
                if (!TextUtils.isEmpty(c.this.f.extention)) {
                    flag.setExtension(c.this.f.extention);
                }
                if (!TextUtils.isEmpty(c.this.f.bizExtension)) {
                    MessageVo messageVo = c.this.f;
                    flag.setExtension(MessageVo.mergeJsonStrings(messageVo.bizExtension, messageVo.extention));
                }
                C1229c c1229c = new C1229c(flag.build(), ko3.this.f18730a, c.this.h, "sendVoiceMessage", uploadResultVo);
                c.this.f(c1229c);
                c1229c.i();
            }

            @Override // defpackage.a56
            public void onProgress(int i, int i2) {
                LogUtil.d(s0.e, "multi segment percent" + i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MessageVo messageVo, MessageVo messageVo2, String str, int i) {
            super(messageVo);
            this.f = messageVo2;
            this.g = str;
            this.h = i;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            if (TextUtils.isEmpty(this.f.data3) || TextUtils.isEmpty(this.f.data1)) {
                if (TextUtils.isEmpty(this.f.data2)) {
                    return;
                }
                File file = new File(this.f.data2);
                if (file.exists()) {
                    LogUtil.i(s0.e, 3, new C1228c(file), (Throwable) null);
                    nu1 nu1Var = new nu1(file, 1, file.getName(), new d(ir5.b(), file), ko3.this.c, this.f20636a.mid, ko3.this.f18730a, this.g);
                    e(nu1Var);
                    nu1Var.a(true);
                    return;
                }
                return;
            }
            me3.a aVarD = me3.d(this.f.data3);
            MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setUrl(aVarD.b).setPlayLength(Integer.valueOf(this.f20636a.data1).intValue()).setExtension(k86.c(new a(aVarD))).build();
            LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(this.f20636a.mid).setTo(this.g).setBody(AppContext.getContext().getResources().getString(R.string.message_type_audio)).setType(3).setMedia(mediaBuild).setFlag(this.h);
            flag.setSubType(this.f.getSubTypeForSend());
            if (!TextUtils.isEmpty(this.f.extention)) {
                flag.setExtension(this.f.extention);
            }
            if (!TextUtils.isEmpty(this.f.bizExtension)) {
                MessageVo messageVo = this.f;
                flag.setExtension(MessageVo.mergeJsonStrings(messageVo.bizExtension, messageVo.extention));
            }
            jo3 bVar = new b(flag.build(), ko3.this.f18730a, this.h, "sendVoiceMessage");
            f(bVar);
            bVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends eo3 {
        public final /* synthetic */ MessageVo f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ String j;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(d.this.f20636a, null, null, null, null);
                d.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                MessageVo messageVo = d.this.f20636a;
                mb4.f(messageVo, generatedMessageLite, messageVo.data2, messageVo.data3, messageVo.data4);
                d.this.c();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "compressStart");
                put("mid", d.this.f20636a.mid);
                put("type", 2);
                put(RemoteMessageConst.TO, d.this.g);
                put("fileName", d.this.f20636a.data1);
                put("flag", Integer.valueOf(d.this.h));
                put("isSendOriginImage", Boolean.valueOf(d.this.i));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadEnd");
                put("detail", "fail");
                put("error", "compressBitmap imagefile is null");
                put("mid", d.this.f20636a.mid);
                put("type", 2);
                put(RemoteMessageConst.TO, d.this.g);
                put("flag", Integer.valueOf(d.this.h));
                put("isSendOriginImage", Boolean.valueOf(d.this.i));
            }
        }

        /* JADX INFO: renamed from: ko3$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1231d extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f18744a;

            public C1231d(String str) {
                this.f18744a = str;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadStart");
                put("mid", d.this.j);
                put("type", 2);
                put(RemoteMessageConst.TO, d.this.g);
                put("filePath", str);
                put("flag", Integer.valueOf(d.this.h));
                put("isSendOriginImage", Boolean.valueOf(d.this.i));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e implements a56 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18745a;
            public final /* synthetic */ String b;
            public final /* synthetic */ File c;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UploadResultVo f18746a;

                public a(UploadResultVo uploadResultVo) {
                    this.f18746a = uploadResultVo;
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("duration", Long.valueOf(ir5.e(e.this.f18745a)));
                    put("status", "uploadEnd");
                    put("detail", "success");
                    put("response", uploadResultVo.toString());
                    put("mid", d.this.j);
                    put("type", 2);
                    put(RemoteMessageConst.TO, d.this.g);
                    put("filePath", e.this.b);
                    put("flag", Integer.valueOf(d.this.h));
                    put("isSendOriginImage", Boolean.valueOf(d.this.i));
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class b extends jo3 {
                public final /* synthetic */ UploadResultVo h;
                public final /* synthetic */ String i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(MessageProto.Message message, Context context, int i, String str, UploadResultVo uploadResultVo, String str2) {
                    super(message, context, i, str);
                    this.h = uploadResultVo;
                    this.i = str2;
                }

                @Override // defpackage.jo3
                public void d() {
                    mb4.f(d.this.f, null, null, null, null);
                    d.this.c();
                }

                @Override // defpackage.jo3
                public void e(GeneratedMessageLite generatedMessageLite) {
                    MessageVo messageVo = d.this.f;
                    UploadResultVo uploadResultVo = this.h;
                    String strA = me3.a(uploadResultVo.thumbUrl, uploadResultVo.acode);
                    UploadResultVo uploadResultVo2 = this.h;
                    mb4.f(messageVo, generatedMessageLite, strA, me3.a(uploadResultVo2.url, uploadResultVo2.acode), me3.b(this.i));
                    d.this.c();
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class c extends HashMap<String, Object> {
                public c() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "processFileResponseFail");
                    put("error", "UploadResultVo is null");
                    put("mid", d.this.j);
                    put("type", 2);
                    put(RemoteMessageConst.TO, d.this.g);
                }
            }

            /* JADX INFO: renamed from: ko3$d$e$d, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1232d extends HashMap<String, Object> {
                public C1232d() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "fail");
                    put("mid", d.this.j);
                    put("type", 2);
                    put(RemoteMessageConst.TO, d.this.g);
                    put("filePath", e.this.b);
                    put("flag", Integer.valueOf(d.this.h));
                    put("isSendOriginImage", Boolean.valueOf(d.this.i));
                }
            }

            public e(long j, String str, File file) {
                this.f18745a = j;
                this.b = str;
                this.c = file;
            }

            @Override // defpackage.a56
            public void a(Exception exc) {
                LogUtil.i(s0.e, 3, new C1232d(), exc);
                mb4.f(d.this.f, null, null, null, null);
                d.this.c();
            }

            @Override // defpackage.a56
            public void b(UploadResultVo uploadResultVo) {
                String str = s0.e;
                LogUtil.i(str, 3, new a(uploadResultVo), (Throwable) null);
                if (uploadResultVo == null || d.this.b()) {
                    LogUtil.i(str, 3, new c(), (Throwable) null);
                    mb4.f(d.this.f, null, null, null, null);
                    d.this.c();
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("midUrl", uploadResultVo.midUrl);
                    jSONObject.put("width", uploadResultVo.width);
                    jSONObject.put("height", uploadResultVo.height);
                    jSONObject.put("hdFlag", uploadResultVo.hdFlag);
                    if (d.this.i) {
                        File file = this.c;
                        jSONObject.put("hdSize", file == null ? 0L : file.length());
                        jSONObject.put("md5", rb3.b(this.c));
                        jSONObject.put("hdUrl", uploadResultVo.hdUrl);
                    } else {
                        jSONObject.put("hdFlag", 0);
                        try {
                            jSONObject.put("md5", rb3.b(this.c));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!TextUtils.isEmpty(uploadResultVo.acode)) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(uploadResultVo.acode);
                        jSONObject.put("acode", jSONArray);
                    }
                    if (d.this.f.data4 != null) {
                        String strOptString = new JSONObject(d.this.f.data4).optString(az.at);
                        JSONObject jSONObject2 = new JSONObject(strOptString);
                        if (!TextUtils.isEmpty(strOptString)) {
                            jSONObject.put(az.at, jSONObject2);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                String string = jSONObject.toString();
                MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setThumbUrl(uploadResultVo.thumbUrl).setUrl(uploadResultVo.url).setExtension(string).build();
                LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
                d dVar = d.this;
                b bVar = new b(ko3.this.q(mediaBuild, dVar.f, dVar.g, dVar.h).build(), ko3.this.f18730a, d.this.h, "sendImageIMMessage", uploadResultVo, string);
                d.this.f(bVar);
                bVar.i();
            }

            @Override // defpackage.a56
            public void onProgress(int i, int i2) {
                com.zenmen.palmchat.database.b.S(d.this.f, i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MessageVo messageVo, MessageVo messageVo2, String str, int i, boolean z, String str2) {
            super(messageVo);
            this.f = messageVo2;
            this.g = str;
            this.h = i;
            this.i = z;
            this.j = str2;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            if (!TextUtils.isEmpty(this.f.data2) && !TextUtils.isEmpty(this.f.data3) && !TextUtils.isEmpty(this.f.data4)) {
                MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setThumbUrl(me3.d(this.f.data2).b).setUrl(me3.d(this.f.data3).b).setExtension(me3.c(this.f.data4)).build();
                LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
                jo3 aVar = new a(ko3.this.q(mediaBuild, this.f, this.g, this.h).build(), ko3.this.f18730a, this.h, "sendImageIMMessage");
                f(aVar);
                aVar.i();
                return;
            }
            String str = s0.e;
            LogUtil.i(str, 3, new b(), (Throwable) null);
            File fileC = xt.c(this.f20636a.data1, this.i);
            if (fileC == null || !fileC.exists()) {
                LogUtil.i(str, 3, new c(), (Throwable) null);
                mb4.f(this.f, null, null, null, null);
                c();
                return;
            }
            String absolutePath = fileC.getAbsolutePath();
            long jB = ir5.b();
            LogUtil.i(str, 3, new C1231d(absolutePath), (Throwable) null);
            nu1 nu1Var = new nu1(fileC, 0, this.i, xt.o(fileC.getName()), new e(jB, absolutePath, fileC), ko3.this.c, this.j, ko3.this.f18730a, this.g);
            e(nu1Var);
            nu1Var.a(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends eo3 {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ String i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("mid", e.this.f);
                put("type", 1);
                put(RemoteMessageConst.TO, e.this.g);
                put("flag", Integer.valueOf(e.this.h));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends jo3 {
            public b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(e.this.f20636a, null, null, null, null);
                e.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(e.this.f20636a, generatedMessageLite, null, null, null);
                e.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MessageVo messageVo, String str, String str2, int i, String str3) {
            super(messageVo);
            this.f = str;
            this.g = str2;
            this.h = i;
            this.i = str3;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            LogUtil.i(s0.e, 3, new a(), (Throwable) null);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(this.f).setType(1).setTo(this.g).setBody(this.i).setFlag(this.h);
            MessageVo messageVo = this.f20636a;
            String str = messageVo.data1;
            if (str == null || messageVo.data2 == null) {
                flag.setSubType(messageVo.getSubTypeForSend());
                String strMergeJsonStrings = !TextUtils.isEmpty(this.f20636a.bizExtension) ? this.f20636a.bizExtension : "";
                if (!TextUtils.isEmpty(this.f20636a.extention)) {
                    strMergeJsonStrings = MessageVo.mergeJsonStrings(this.f20636a.extention, strMergeJsonStrings);
                }
                if (!TextUtils.isEmpty(strMergeJsonStrings)) {
                    flag.setExtension(strMergeJsonStrings);
                }
            } else {
                flag.setSubType(Integer.valueOf(str).intValue());
                if (TextUtils.isEmpty(this.f20636a.bizExtension)) {
                    flag.setExtension(this.f20636a.data2);
                } else {
                    MessageVo messageVo2 = this.f20636a;
                    flag.setExtension(MessageVo.mergeJsonStrings(messageVo2.data2, messageVo2.bizExtension));
                }
            }
            b bVar = new b(flag.build(), ko3.this.f18730a, this.h, "sendTextMessage");
            f(bVar);
            bVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends eo3 {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ int i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(f.this.f20636a, null, null, null, null);
                f.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(f.this.f20636a, generatedMessageLite, null, null, null);
                f.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MessageVo messageVo, String str, String str2, String str3, int i) {
            super(messageVo);
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = i;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(this.f).setTo(this.g).setBody(this.h).setType(9).setFlag(this.i);
            flag.setSubType(this.f20636a.getSubTypeForSend());
            if (TextUtils.isEmpty(this.f20636a.bizExtension)) {
                flag.setExtension(this.f20636a.extention);
            } else {
                MessageVo messageVo = this.f20636a;
                flag.setExtension(MessageVo.mergeJsonStrings(messageVo.bizExtension, messageVo.extention));
            }
            a aVar = new a(flag.build(), ko3.this.f18730a, this.i, "sendVCardIMMessage");
            f(aVar);
            aVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends eo3 {
        public final /* synthetic */ MessageVo f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ int i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(g.this.f, null, null, null, null);
                g.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                MessageVo messageVo = g.this.f;
                mb4.f(messageVo, generatedMessageLite, messageVo.data2, messageVo.data3, messageVo.data4);
                g.this.c();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: compiled from: SearchBox */
            public class a extends jo3 {
                public a(MessageProto.Message message, Context context, int i, String str) {
                    super(message, context, i, str);
                }

                @Override // defpackage.jo3
                public void d() {
                    mb4.f(g.this.f, null, null, null, null);
                    g.this.c();
                }

                @Override // defpackage.jo3
                public void e(GeneratedMessageLite generatedMessageLite) {
                    LogUtil.i(jo3.g, "onSendMessageReceivedReply " + generatedMessageLite);
                    g gVar = g.this;
                    MessageVo messageVo = gVar.f;
                    MessageVo messageVo2 = gVar.f20636a;
                    mb4.f(messageVo, generatedMessageLite, messageVo2.data2, messageVo2.data3, messageVo2.data4);
                    g.this.c();
                }
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(g.this.g).setTo(g.this.h).setBody(AppContext.getContext().getResources().getString(R.string.string_message_type_expression)).setType(14).setFlag(g.this.i);
                if (!TextUtils.isEmpty(g.this.f.data6)) {
                    flag.setExType(Integer.parseInt(g.this.f.data6));
                }
                flag.setSubType(g.this.f.getSubTypeForSend());
                if (TextUtils.isEmpty(g.this.f.bizExtension)) {
                    flag.setExtension(g.this.f20636a.data5);
                } else {
                    g gVar = g.this;
                    flag.setExtension(MessageVo.mergeJsonStrings(gVar.f.bizExtension, gVar.f20636a.data5));
                }
                a aVar = new a(flag.build(), ko3.this.f18730a, g.this.i, "sendExpressionIMMessage");
                g.this.f(aVar);
                aVar.i();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f18751a;

            public c(String str) {
                this.f18751a = str;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("mid", g.this.g);
                put("type", 14);
                put(RemoteMessageConst.TO, g.this.h);
                put("fileName", str);
                put("flag", Integer.valueOf(g.this.i));
                put("isSendOriginImage", Boolean.TRUE);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {
            public d() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadEnd");
                put("detail", "fail");
                put("error", "compressBitmap imagefile is null");
                put("mid", g.this.g);
                put("type", 14);
                put(RemoteMessageConst.TO, g.this.h);
                put("flag", Integer.valueOf(g.this.i));
                put("isSendOriginImage", Boolean.TRUE);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18753a;
            public final /* synthetic */ String b;
            public final /* synthetic */ File c;

            public e(long j, String str, File file) {
                this.f18753a = j;
                this.b = str;
                this.c = file;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "compressFinish");
                put("duration", Long.valueOf(ir5.e(j)));
                put("mid", g.this.g);
                put("type", 14);
                put(RemoteMessageConst.TO, g.this.h);
                put("fileName", str);
                put("flag", Integer.valueOf(g.this.i));
                put("isSendOriginImage", Boolean.TRUE);
                put("fileSize", Long.valueOf(file != null ? file.length() : 0L));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class f extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f18754a;

            public f(String str) {
                this.f18754a = str;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadStart");
                put("mid", g.this.g);
                put("type", 14);
                put(RemoteMessageConst.TO, g.this.h);
                put("filePath", str);
                put("flag", Integer.valueOf(g.this.i));
                put("isSendOriginImage", Boolean.TRUE);
            }
        }

        /* JADX INFO: renamed from: ko3$g$g, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1233g implements a56 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18755a;
            public final /* synthetic */ String b;
            public final /* synthetic */ File c;

            /* JADX INFO: renamed from: ko3$g$g$a */
            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UploadResultVo f18756a;

                public a(UploadResultVo uploadResultVo) {
                    this.f18756a = uploadResultVo;
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("duration", Long.valueOf(ir5.e(C1233g.this.f18755a)));
                    put("status", "uploadEnd");
                    put("detail", "success");
                    put("response", uploadResultVo.toString());
                    put("mid", g.this.g);
                    put("type", 14);
                    put(RemoteMessageConst.TO, g.this.h);
                    put("filePath", C1233g.this.b);
                    put("flag", Integer.valueOf(g.this.i));
                    put("isSendOriginImage", Boolean.TRUE);
                }
            }

            /* JADX INFO: renamed from: ko3$g$g$b */
            /* JADX INFO: compiled from: SearchBox */
            public class b extends jo3 {
                public final /* synthetic */ UploadResultVo h;
                public final /* synthetic */ String i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(MessageProto.Message message, Context context, int i, String str, UploadResultVo uploadResultVo, String str2) {
                    super(message, context, i, str);
                    this.h = uploadResultVo;
                    this.i = str2;
                }

                @Override // defpackage.jo3
                public void d() {
                    mb4.f(g.this.f, null, null, null, null);
                    g.this.c();
                }

                @Override // defpackage.jo3
                public void e(GeneratedMessageLite generatedMessageLite) {
                    MessageVo messageVo = g.this.f;
                    UploadResultVo uploadResultVo = this.h;
                    String strA = me3.a(uploadResultVo.thumbUrl, uploadResultVo.acode);
                    UploadResultVo uploadResultVo2 = this.h;
                    mb4.f(messageVo, generatedMessageLite, strA, me3.a(uploadResultVo2.url, uploadResultVo2.acode), me3.b(this.i));
                    g.this.c();
                }
            }

            /* JADX INFO: renamed from: ko3$g$g$c */
            /* JADX INFO: compiled from: SearchBox */
            public class c extends HashMap<String, Object> {
                public c() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "processFileResponseFail");
                    put("error", "UploadResultVo is null");
                    put("mid", g.this.g);
                    put("type", 14);
                    put(RemoteMessageConst.TO, g.this.h);
                }
            }

            /* JADX INFO: renamed from: ko3$g$g$d */
            /* JADX INFO: compiled from: SearchBox */
            public class d extends HashMap<String, Object> {
                public d() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "fail");
                    put("mid", g.this.g);
                    put("type", 14);
                    put(RemoteMessageConst.TO, g.this.h);
                    put("filePath", C1233g.this.b);
                    put("flag", Integer.valueOf(g.this.i));
                    put("isSendOriginImage", Boolean.TRUE);
                }
            }

            public C1233g(long j, String str, File file) {
                this.f18755a = j;
                this.b = str;
                this.c = file;
            }

            @Override // defpackage.a56
            public void a(Exception exc) {
                LogUtil.i(s0.e, 3, new d(), exc);
                mb4.f(g.this.f, null, null, null, null);
                g.this.c();
            }

            @Override // defpackage.a56
            public void b(UploadResultVo uploadResultVo) {
                String str = s0.e;
                LogUtil.i(str, 3, new a(uploadResultVo), (Throwable) null);
                if (uploadResultVo == null) {
                    LogUtil.i(str, 3, new c(), (Throwable) null);
                    mb4.f(g.this.f, null, null, null, null);
                    g.this.c();
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("midUrl", uploadResultVo.midUrl);
                    jSONObject.put("width", uploadResultVo.width);
                    jSONObject.put("height", uploadResultVo.height);
                    jSONObject.put("hdFlag", uploadResultVo.hdFlag);
                    jSONObject.put("hdUrl", uploadResultVo.hdUrl);
                    jSONObject.put("md5", rb3.b(this.c));
                    File file = this.c;
                    jSONObject.put("hdSize", file == null ? 0L : file.length());
                    if (!TextUtils.isEmpty(uploadResultVo.acode)) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(uploadResultVo.acode);
                        jSONObject.put("acode", jSONArray);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String string = jSONObject.toString();
                MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setThumbUrl(uploadResultVo.thumbUrl).setUrl(uploadResultVo.url).setExtension(string).build();
                LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
                MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(g.this.g).setTo(g.this.h).setBody(AppContext.getContext().getResources().getString(R.string.string_message_type_expression)).setType(14).setMedia(mediaBuild).setFlag(g.this.i);
                flag.setSubType(g.this.f.getSubTypeForSend());
                if (!TextUtils.isEmpty(g.this.f.bizExtension)) {
                    g gVar = g.this;
                    flag.setExtension(MessageVo.mergeJsonStrings(gVar.f.bizExtension, gVar.f20636a.data5));
                }
                if (!TextUtils.isEmpty(g.this.f.data6)) {
                    flag.setExType(Integer.parseInt(g.this.f.data6));
                }
                b bVar = new b(flag.build(), ko3.this.f18730a, g.this.i, "sendImageIMMessage", uploadResultVo, string);
                g.this.f(bVar);
                bVar.i();
            }

            @Override // defpackage.a56
            public void onProgress(int i, int i2) {
                com.zenmen.palmchat.database.b.S(g.this.f, i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MessageVo messageVo, MessageVo messageVo2, String str, String str2, int i) {
            super(messageVo);
            this.f = messageVo2;
            this.g = str;
            this.h = str2;
            this.i = i;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            if (!TextUtils.isEmpty(this.f.data2) && !TextUtils.isEmpty(this.f.data3) && !TextUtils.isEmpty(this.f.data4)) {
                MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setThumbUrl(me3.d(this.f.data2).b).setUrl(me3.d(this.f.data3).b).setExtension(me3.c(this.f.data4)).build();
                LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
                MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(this.g).setTo(this.h).setBody(AppContext.getContext().getResources().getString(R.string.string_message_type_expression)).setType(14).setMedia(mediaBuild).setFlag(this.i);
                flag.setSubType(this.f.getSubTypeForSend());
                if (!TextUtils.isEmpty(this.f.data6)) {
                    flag.setExType(Integer.parseInt(this.f.data6));
                }
                if (!TextUtils.isEmpty(this.f.bizExtension)) {
                    flag.setExtension(this.f.bizExtension);
                }
                jo3 aVar = new a(flag.build(), ko3.this.f18730a, this.i, "sendExpressionIMMessage");
                f(aVar);
                aVar.i();
                return;
            }
            if (!TextUtils.isEmpty(this.f20636a.data5)) {
                ko3.this.b.submit(new b());
                return;
            }
            String str = this.f20636a.data1;
            String str2 = s0.e;
            LogUtil.i(str2, 3, new c(str), (Throwable) null);
            long jB = ir5.b();
            File fileC = xt.c(str, true);
            if (fileC == null || !fileC.exists()) {
                LogUtil.i(str2, 3, new d(), (Throwable) null);
                mb4.f(this.f20636a, null, null, null, null);
                c();
                return;
            }
            String absolutePath = fileC.getAbsolutePath();
            LogUtil.i(str2, 3, new e(jB, str, fileC), (Throwable) null);
            long jB2 = ir5.b();
            LogUtil.i(str2, 3, new f(absolutePath), (Throwable) null);
            nu1 nu1Var = new nu1(fileC, 4, true, xt.o(fileC.getName()), new C1233g(jB2, absolutePath, fileC), ko3.this.c, this.g, ko3.this.f18730a, this.h);
            e(nu1Var);
            nu1Var.a(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends eo3 {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ me3.a f18759a;

            /* JADX INFO: renamed from: ko3$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1234a extends JSONArray {
                public C1234a() {
                    put(a.this.f18759a.f19200a);
                }
            }

            public a(me3.a aVar) {
                this.f18759a = aVar;
                put("md5", h.this.f20636a.data5);
                if (TextUtils.isEmpty(aVar.f19200a)) {
                    return;
                }
                put("acode", new C1234a());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends jo3 {
            public b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(h.this.f20636a, null, null, null, null);
                h.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(h.this.f20636a, generatedMessageLite, null, null, null);
                h.this.c();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f18761a;
            public final /* synthetic */ File b;

            public c(String str, File file) {
                this.f18761a = str;
                this.b = file;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("mid", h.this.f);
                put("type", 6);
                put(RemoteMessageConst.TO, h.this.g);
                put("filePath", str);
                put("fileSize", Long.valueOf(file.length()));
                put("flag", Integer.valueOf(h.this.h));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f18762a;
            public final /* synthetic */ File b;

            public d(String str, File file) {
                this.f18762a = str;
                this.b = file;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadStart");
                put("mid", h.this.f);
                put("type", 6);
                put(RemoteMessageConst.TO, h.this.g);
                put("filePath", str);
                put("fileSize", Long.valueOf(file.length()));
                put("flag", Integer.valueOf(h.this.h));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e implements a56 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18763a;
            public final /* synthetic */ String b;
            public final /* synthetic */ File c;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UploadResultVo f18764a;

                public a(UploadResultVo uploadResultVo) {
                    this.f18764a = uploadResultVo;
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "success");
                    put("response", uploadResultVo.toString());
                    put("duration", Long.valueOf(ir5.e(e.this.f18763a)));
                    put("mid", h.this.f);
                    put("type", 6);
                    put(RemoteMessageConst.TO, h.this.g);
                    put("filePath", e.this.b);
                    put("fileSize", Long.valueOf(e.this.c.length()));
                    put("flag", Integer.valueOf(h.this.h));
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class b extends HashMap<String, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f18765a;
                public final /* synthetic */ UploadResultVo b;

                /* JADX INFO: compiled from: SearchBox */
                public class a extends JSONArray {
                    public a() {
                        put(b.this.b.acode);
                    }
                }

                public b(String str, UploadResultVo uploadResultVo) {
                    this.f18765a = str;
                    this.b = uploadResultVo;
                    put("md5", str);
                    if (TextUtils.isEmpty(uploadResultVo.acode)) {
                        return;
                    }
                    put("acode", new a());
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class c extends jo3 {
                public final /* synthetic */ String h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(MessageProto.Message message, Context context, int i, String str, String str2) {
                    super(message, context, i, str);
                    this.h = str2;
                }

                @Override // defpackage.jo3
                public void d() {
                    mb4.f(h.this.f20636a, null, null, null, null);
                    h.this.c();
                }

                @Override // defpackage.jo3
                public void e(GeneratedMessageLite generatedMessageLite) {
                    mb4.f(h.this.f20636a, generatedMessageLite, null, null, null);
                    com.zenmen.palmchat.database.b.R(h.this.f20636a, this.h);
                    h.this.c();
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class d extends HashMap<String, Object> {
                public d() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "fail");
                    put("response", "uploadResultVo is null");
                    put("duration", Long.valueOf(ir5.e(e.this.f18763a)));
                    put("mid", h.this.f);
                    put("type", 6);
                    put(RemoteMessageConst.TO, h.this.g);
                    put("filePath", e.this.b);
                    put("fileSize", Long.valueOf(e.this.c.length()));
                    put("flag", Integer.valueOf(h.this.h));
                }
            }

            /* JADX INFO: renamed from: ko3$h$e$e, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1235e extends HashMap<String, Object> {
                public C1235e() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "uploadEnd");
                    put("detail", "fail");
                    put("duration", Long.valueOf(ir5.e(e.this.f18763a)));
                    put("mid", h.this.f);
                    put("type", 6);
                    put(RemoteMessageConst.TO, h.this.g);
                    put("filePath", e.this.b);
                    put("fileSize", Long.valueOf(e.this.c.length()));
                    put("flag", Integer.valueOf(h.this.h));
                }
            }

            public e(long j, String str, File file) {
                this.f18763a = j;
                this.b = str;
                this.c = file;
            }

            @Override // defpackage.a56
            public void a(Exception exc) {
                LogUtil.i(s0.e, 3, new C1235e(), exc);
                mb4.f(h.this.f20636a, null, null, null, null);
                h.this.c();
            }

            @Override // defpackage.a56
            public void b(UploadResultVo uploadResultVo) {
                if (uploadResultVo == null) {
                    LogUtil.i(s0.e, 3, new d(), (Throwable) null);
                    mb4.f(h.this.f20636a, null, null, null, null);
                    h.this.c();
                    return;
                }
                String str = s0.e;
                LogUtil.i(str, 3, new a(uploadResultVo), (Throwable) null);
                String md5 = uploadResultVo.getMd5();
                MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setSize((int) this.c.length()).setName(this.c.getName()).setUrl(uploadResultVo.url).setExtension(k86.c(new b(md5, uploadResultVo))).build();
                LogUtil.i(str, "mediaPart =" + mediaBuild);
                MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(h.this.f).setTo(h.this.g).setBody(AppContext.getContext().getResources().getString(R.string.message_type_file)).setType(6).setMedia(mediaBuild).setFlag(h.this.h);
                flag.setSubType(h.this.f20636a.getSubTypeForSend());
                if (!TextUtils.isEmpty(h.this.f20636a.bizExtension)) {
                    flag.setExtension(h.this.f20636a.bizExtension);
                }
                c cVar = new c(flag.build(), ko3.this.f18730a, h.this.h, "sendFileIMMessage", md5);
                h.this.f(cVar);
                cVar.i();
            }

            @Override // defpackage.a56
            public void onProgress(int i, int i2) {
                LogUtil.d(s0.e, "multi segment percent" + i);
                com.zenmen.palmchat.database.b.S(h.this.f20636a, i2);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class f extends HashMap<String, Object> {
            public f() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadEnd");
                put("detail", "fail");
                put("error", "local file is not exist");
                put("mid", h.this.f);
                put("type", 6);
                put(RemoteMessageConst.TO, h.this.g);
                put("flag", Integer.valueOf(h.this.h));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(MessageVo messageVo, String str, String str2, int i) {
            super(messageVo);
            this.f = str;
            this.g = str2;
            this.h = i;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            File file = new File(this.f20636a.data1);
            if (!file.exists()) {
                LogUtil.i(s0.e, 3, new f(), (Throwable) null);
                mb4.f(this.f20636a, null, null, null, null);
                c();
                return;
            }
            if (TextUtils.isEmpty(this.f20636a.data2)) {
                String str = this.f20636a.data1;
                String str2 = s0.e;
                LogUtil.i(str2, 3, new c(str, file), (Throwable) null);
                long jB = ir5.b();
                LogUtil.i(str2, 3, new d(str, file), (Throwable) null);
                nu1 nu1Var = new nu1(file, 3, file.getName(), new e(jB, str, file), ko3.this.c, this.f, ko3.this.f18730a, this.g);
                e(nu1Var);
                nu1Var.a(false);
                return;
            }
            if (!file.exists()) {
                mb4.f(this.f20636a, null, null, null, null);
                c();
                return;
            }
            me3.a aVarD = me3.d(this.f20636a.data2);
            int length = (int) file.length();
            try {
                if (!il5.l(this.f20636a.data4)) {
                    length = Integer.parseInt(this.f20636a.data4);
                }
            } catch (Exception e2) {
                length = (int) file.length();
                e2.printStackTrace();
            }
            MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setSize(length).setName(il5.l(this.f20636a.data3) ? file.getName() : this.f20636a.data3).setExtension(k86.c(new a(aVarD))).setUrl(aVarD.b).build();
            LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(this.f).setTo(this.g).setBody(AppContext.getContext().getResources().getString(R.string.message_type_file)).setType(6).setMedia(mediaBuild).setFlag(this.h);
            flag.setSubType(this.f20636a.getSubTypeForSend());
            if (!TextUtils.isEmpty(this.f20636a.bizExtension)) {
                flag.setExtension(this.f20636a.bizExtension);
            }
            jo3 bVar = new b(flag.build(), ko3.this.f18730a, this.h, "fowardFileIMMessage");
            f(bVar);
            bVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends eo3 {
        public final /* synthetic */ MessageVo f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                LogUtil.onEvent("71", null, "2", i.this.f20636a.logExtension);
                mb4.f(i.this.f20636a, null, null, null, null);
                i.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                LogUtil.onEvent("71", null, "1", i.this.f20636a.logExtension);
                i iVar = i.this;
                MessageVo messageVo = iVar.f20636a;
                MessageVo messageVo2 = iVar.f;
                mb4.f(messageVo, generatedMessageLite, messageVo2.data4, messageVo2.data3, null);
                i.this.c();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ File f18770a;
            public final /* synthetic */ File b;

            public b(File file, File file2) {
                this.f18770a = file;
                this.b = file2;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "uploadStart");
                put("mid", i.this.f.mid);
                put("type", Integer.valueOf(i.this.f.mimeType));
                put(RemoteMessageConst.TO, i.this.g);
                put("videoFilePath", i.this.f.data1);
                put("videoFileSize", Long.valueOf(file.length()));
                put("thumbnailFilePath", i.this.f.data2);
                put("thumbFileSize", Long.valueOf(file2.length()));
                put("flag", Integer.valueOf(i.this.h));
                put("md5", i.this.f.data5);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements bn2.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ File f18771a;

            /* JADX INFO: compiled from: SearchBox */
            public class a implements ye6 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ long f18772a;
                public final /* synthetic */ File b;

                /* JADX INFO: renamed from: ko3$i$c$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: SearchBox */
                public class C1236a extends HashMap<String, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ Pair f18773a;

                    public C1236a(Pair pair) {
                        this.f18773a = pair;
                        put("action", LogUtil.VALUE_MSG_SEND);
                        put("status", "uploadEnd");
                        put("detail", "success");
                        put("response", ((UploadResultVo) pair.first).toString() + "\n" + ((UploadResultVo) pair.second).toString());
                        put("duration", Long.valueOf(ir5.e(a.this.f18772a)));
                        put("mid", i.this.f.mid);
                        put("type", 4);
                        put(RemoteMessageConst.TO, i.this.g);
                        put("videoFilePath", i.this.f.data1);
                        put("videoFileSize", Long.valueOf(a.this.b.length()));
                        put("thumbnailFilePath", i.this.f.data2);
                        put("thumbFileSize", Long.valueOf(c.this.f18771a.length()));
                        put("flag", Integer.valueOf(i.this.h));
                    }
                }

                /* JADX INFO: compiled from: SearchBox */
                public class b extends jo3 {
                    public final /* synthetic */ Pair h;
                    public final /* synthetic */ String i;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public b(MessageProto.Message message, Context context, int i, String str, Pair pair, String str2) {
                        super(message, context, i, str);
                        this.h = pair;
                        this.i = str2;
                    }

                    @Override // defpackage.jo3
                    public void d() {
                        LogUtil.onClickEvent("V33", "2", null);
                        mb4.f(i.this.f20636a, null, null, null, null);
                        i.this.c();
                    }

                    @Override // defpackage.jo3
                    public void e(GeneratedMessageLite generatedMessageLite) {
                        LogUtil.onClickEvent("V33", "1", null);
                        MessageVo messageVo = i.this.f20636a;
                        Object obj = this.h.first;
                        String strA = me3.a(((UploadResultVo) obj).url, ((UploadResultVo) obj).acode);
                        Object obj2 = this.h.second;
                        mb4.f(messageVo, generatedMessageLite, strA, me3.a(((UploadResultVo) obj2).url, ((UploadResultVo) obj2).acode), this.i);
                        i.this.c();
                    }
                }

                /* JADX INFO: renamed from: ko3$i$c$a$c, reason: collision with other inner class name */
                /* JADX INFO: compiled from: SearchBox */
                public class C1237c extends HashMap<String, Object> {
                    public C1237c() {
                        put("action", LogUtil.VALUE_MSG_SEND);
                        put("status", "uploadEnd");
                        put("detail", "fail");
                        put("mid", i.this.f20636a.mid);
                        put("type", 4);
                        put(RemoteMessageConst.TO, i.this.g);
                        put("videoPath", i.this.f20636a.data1);
                        put("flag", Integer.valueOf(i.this.h));
                        put("response", "uploadResultVo is null");
                    }
                }

                /* JADX INFO: compiled from: SearchBox */
                public class d extends HashMap<String, Object> {
                    public d() {
                        put("action", LogUtil.VALUE_MSG_SEND);
                        put("status", "uploadEnd");
                        put("detail", "fail");
                        put("mid", i.this.f20636a.mid);
                        put("type", 4);
                        put(RemoteMessageConst.TO, i.this.g);
                        put("videoPath", i.this.f20636a.data1);
                        put("flag", Integer.valueOf(i.this.h));
                    }
                }

                public a(long j, File file) {
                    this.f18772a = j;
                    this.b = file;
                }

                @Override // defpackage.ye6
                public void a(Exception exc) {
                    LogUtil.onClickEvent("V36", "2", null);
                    LogUtil.i(s0.e, 3, new d(), exc);
                    LogUtil.onClickEvent("V33", "2", null);
                    mb4.f(i.this.f20636a, null, null, null, null);
                    i.this.c();
                }

                @Override // defpackage.ye6
                public void b(Pair<UploadResultVo, UploadResultVo> pair) {
                    if (pair == null) {
                        LogUtil.onClickEvent("V36", "2", null);
                        LogUtil.i(s0.e, 3, new C1237c(), (Throwable) null);
                        LogUtil.onClickEvent("V33", "2", null);
                        mb4.f(i.this.f20636a, null, null, null, null);
                        i.this.c();
                        return;
                    }
                    LogUtil.onClickEvent("V36", "1", null);
                    LogUtil.i(s0.e, 3, new C1236a(pair), (Throwable) null);
                    i.this.f20636a.data5 = ((UploadResultVo) pair.second).fhash;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", ((UploadResultVo) pair.first).width);
                        jSONObject.put("height", ((UploadResultVo) pair.first).height);
                        jSONObject.put("md5", i.this.f20636a.data5);
                        if (!TextUtils.isEmpty(((UploadResultVo) pair.first).acode) && !TextUtils.isEmpty(((UploadResultVo) pair.second).acode)) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(((UploadResultVo) pair.first).acode);
                            jSONArray.put(((UploadResultVo) pair.second).acode);
                            jSONObject.put("acode", jSONArray);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String string = jSONObject.toString();
                    MessageProto.Message.Media.Builder builderNewBuilder = MessageProto.Message.Media.newBuilder();
                    Object obj = pair.first;
                    int i = ((UploadResultVo) obj).hdFlag;
                    UploadResultVo uploadResultVo = (UploadResultVo) obj;
                    MessageProto.Message.Media mediaBuild = builderNewBuilder.setThumbUrl(i == 1 ? uploadResultVo.hdUrl : uploadResultVo.thumbUrl).setUrl(((UploadResultVo) pair.second).url).setPlayLength(Integer.valueOf(i.this.f.data6).intValue()).setSize((int) this.b.length()).setName(this.b.getName()).setMimeType("mp4").setExtension(string).build();
                    LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
                    MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(i.this.f20636a.mid).setTo(i.this.g).setBody(AppContext.getContext().getResources().getString(R.string.message_type_sight)).setType(4).setExType(1).setMedia(mediaBuild).setFlag(i.this.h);
                    flag.setSubType(i.this.f.getSubTypeForSend());
                    if (!TextUtils.isEmpty(i.this.f.bizExtension)) {
                        flag.setExtension(i.this.f.bizExtension);
                    }
                    b bVar = new b(flag.build(), ko3.this.f18730a, i.this.h, "sendVideoMessage", pair, string);
                    i.this.f(bVar);
                    bVar.i();
                }

                @Override // defpackage.ye6
                public void onProgress(int i) {
                    com.zenmen.palmchat.database.b.S(i.this.f20636a, i);
                }
            }

            public c(File file) {
                this.f18771a = file;
            }

            @Override // bn2.d
            public void a(int i) {
                LogUtil.i(s0.e, "onCompressPercentChanged" + i);
            }

            @Override // bn2.d
            public void b(boolean z, int i, String str) {
                LogUtil.i(s0.e, "onCompressFinished" + z + "desPath=" + str);
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errorCode", i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LogUtil.onClickEvent("V33", "2", jSONObject.toString());
                    mb4.f(i.this.f20636a, null, null, null, null);
                    i.this.c();
                    return;
                }
                String str2 = i.this.f.data1;
                File file = new File(str);
                MessageVo messageVo = i.this.f20636a;
                messageVo.data1 = str;
                messageVo.data5 = rb3.b(file);
                long jB = ir5.b();
                LogUtil.onClickEvent("V35", null, null);
                a aVar = new a(jB, file);
                File file2 = this.f18771a;
                ExecutorService executorService = ko3.this.c;
                i iVar = i.this;
                xe6 xe6Var = new xe6(str2, file, file2, aVar, executorService, iVar.f20636a.mid, ko3.this.f18730a, i.this.g, i == 100);
                i.this.e(xe6Var);
                xe6Var.j();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(MessageVo messageVo, MessageVo messageVo2, String str, int i) {
            super(messageVo);
            this.f = messageVo2;
            this.g = str;
            this.h = i;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            if (TextUtils.isEmpty(this.f.data3) || TextUtils.isEmpty(this.f.data4)) {
                if (TextUtils.isEmpty(this.f.data1) || TextUtils.isEmpty(this.f.data2)) {
                    return;
                }
                File file = new File(this.f.data1);
                File file2 = new File(this.f.data2);
                if (!file.exists() || !file2.exists()) {
                    LogUtil.onClickEvent("V33", "2", null);
                    mb4.f(this.f20636a, null, null, null, null);
                    c();
                    return;
                } else {
                    LogUtil.i(s0.e, 3, new b(file, file2), (Throwable) null);
                    com.zenmen.palmchat.chat.h hVarD = com.zenmen.palmchat.chat.h.d();
                    MessageVo messageVo = this.f;
                    hVarD.a(new h.e(messageVo.data1, true, messageVo.mid, this.g), new c(file2), true);
                    return;
                }
            }
            MessageProto.Message.Media mediaBuild = MessageProto.Message.Media.newBuilder().setUrl(me3.d(this.f.data3).b).setThumbUrl(me3.d(this.f.data4).b).setMimeType("mp4").setPlayLength(Integer.valueOf(this.f.data6).intValue()).setSize(Integer.valueOf(this.f.data10).intValue()).setExtension(this.f.hdFlag).build();
            LogUtil.i(s0.e, "mediaPart =" + mediaBuild);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(this.f20636a.mid).setTo(this.g).setBody(AppContext.getContext().getResources().getString(R.string.message_type_sight)).setType(4).setExType(1).setMedia(mediaBuild).setFlag(this.h);
            flag.setSubType(this.f.getSubTypeForSend());
            if (!TextUtils.isEmpty(this.f.bizExtension)) {
                flag.setExtension(this.f.bizExtension);
            }
            a aVar = new a(flag.build(), ko3.this.f18730a, this.h, "sendVideoMessage");
            f(aVar);
            aVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18780a;

        public k(Context context) {
            this.f18780a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AccountUtils.r(this.f18780a.getApplicationContext())) {
                nw5.i();
                ko3.this.M();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18781a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MessageVo f18782a;

            public a(MessageVo messageVo) {
                this.f18782a = messageVo;
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", LogUtil.VALUE_INSERTDB);
                put("type", Integer.valueOf(messageVo.mimeType));
                put("flag", messageVo.sendFlag);
                put("mid", messageVo.mid);
                put(RemoteMessageConst.TO, messageVo.to);
            }
        }

        public l(MessageVo messageVo) {
            this.f18781a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageVo messageVo = this.f18781a;
            if (messageVo != null) {
                MessageVo messageVoG = ko3.this.G(messageVo);
                ko3.this.m(messageVoG);
                LogUtil.i(ko3.g, 3, new a(messageVoG), (Throwable) null);
                com.zenmen.palmchat.database.b.t(messageVoG);
                ko3 ko3Var = ko3.this;
                ko3Var.l(messageVoG.mid, ko3Var.t(messageVoG));
                ko3.this.L(messageVoG);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends eo3 {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ String i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("mid", m.this.f);
                put("type", 30);
                put(RemoteMessageConst.TO, m.this.g);
                put("flag", Integer.valueOf(m.this.h));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends jo3 {
            public b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                m.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                m.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(MessageVo messageVo, String str, String str2, int i, String str3) {
            super(messageVo);
            this.f = str;
            this.g = str2;
            this.h = i;
            this.i = str3;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            LogUtil.i(s0.e, 3, new a(), (Throwable) null);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(AccountUtils.p(AppContext.getContext()) + "@youni").setMid(this.f).setType(30).setSubType(0).setTo(this.g).setBody(this.i).setFlag(this.h);
            if (TextUtils.isEmpty(this.f20636a.bizExtension)) {
                flag.setExtension(this.f20636a.extention);
            } else {
                flag.setSubType(this.f20636a.bizType);
                MessageVo messageVo = this.f20636a;
                flag.setExtension(MessageVo.mergeJsonStrings(messageVo.bizExtension, messageVo.extention));
            }
            b bVar = new b(flag.build(), ko3.this.f18730a, this.h, "sendVideoCallMessage");
            f(bVar);
            bVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18788a;

        public r(MessageVo messageVo) {
            this.f18788a = messageVo;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", LogUtil.VALUE_INSERTDB);
            put("type", Integer.valueOf(messageVo.mimeType));
            put("flag", messageVo.sendFlag);
            put("mid", messageVo.mid);
            put(RemoteMessageConst.TO, messageVo.to);
            put("auto_send", Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s extends eo3 {
        public final /* synthetic */ MessageVo f;
        public final /* synthetic */ int g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("type", Integer.valueOf(s.this.f.mimeType));
                put("flag", Integer.valueOf(s.this.g));
                put("mid", s.this.f.mid);
                put(RemoteMessageConst.TO, s.this.h);
                put("redpacket", s.this.f.data1);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends jo3 {
            public b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(s.this.f20636a, null, null, null, null);
                s.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(s.this.f20636a, generatedMessageLite, null, null, null);
                s.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(MessageVo messageVo, MessageVo messageVo2, int i, String str, String str2) {
            super(messageVo);
            this.f = messageVo2;
            this.g = i;
            this.h = str;
            this.i = str2;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            LogUtil.i(s0.e, 3, new a(), (Throwable) null);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(this.i).setTo(this.h).setMid(this.f20636a.mid).setType(this.f20636a.mimeType).setBody(TextUtils.isEmpty(this.f20636a.text) ? AppContext.getContext().getString(R.string.text_redpacket_des) : this.f20636a.text).setFlag(this.g);
            flag.setSubType(this.f.getSubTypeForSend());
            String str = this.f20636a.extention;
            if (TextUtils.isEmpty(this.f.bizExtension)) {
                flag.setExtension(str);
            } else {
                flag.setExtension(MessageVo.mergeJsonStrings(this.f.bizExtension, str));
            }
            b bVar = new b(flag.build(), ko3.this.f18730a, this.g, "sendRedPacketMessage");
            f(bVar);
            bVar.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t extends eo3 {
        public final /* synthetic */ MessageVo f;
        public final /* synthetic */ int g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("type", Integer.valueOf(t.this.f.mimeType));
                put("flag", Integer.valueOf(t.this.g));
                put("mid", t.this.f.mid);
                put(RemoteMessageConst.TO, t.this.h);
                put("redpacket", t.this.f.data1);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends jo3 {
            public b(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(t.this.f20636a, null, null, null, null);
                t.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(t.this.f20636a, generatedMessageLite, null, null, null);
                t.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(MessageVo messageVo, MessageVo messageVo2, int i, String str, String str2) {
            super(messageVo);
            this.f = messageVo2;
            this.g = i;
            this.h = str;
            this.i = str2;
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            LogUtil.i(s0.e, 3, new a(), (Throwable) null);
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(this.i).setTo(this.h).setMid(this.f20636a.mid).setType(this.f20636a.mimeType).setBody(TextUtils.isEmpty(this.f20636a.text) ? AppContext.getContext().getString(R.string.circle_coupon_info_title) : this.f20636a.text).setFlag(this.g);
            flag.setSubType(this.f.getSubTypeForSend());
            String str = this.f20636a.extention;
            if (TextUtils.isEmpty(this.f.bizExtension)) {
                flag.setExtension(str);
            } else {
                flag.setExtension(MessageVo.mergeJsonStrings(this.f.bizExtension, str));
            }
            b bVar = new b(flag.build(), ko3.this.f18730a, this.g, "sendRedPacketMessage");
            f(bVar);
            bVar.i();
        }
    }

    public ko3(Context context) {
        this.f18730a = context;
        String str = g;
        this.b = vw5.d(str);
        this.c = vw5.c(1, str);
        HandlerThread handlerThreadA = lg2.a("MessagingSendHelper");
        this.d = handlerThreadA;
        handlerThreadA.start();
        this.e = new Handler(this.d.getLooper());
        go3.b().d();
        fs0.d().g(context, this.c);
        this.e.post(new k(context));
    }

    public final eo3 A(MessageVo messageVo) {
        return new c(messageVo, messageVo, DomainHelper.f(messageVo), E(messageVo));
    }

    public final eo3 B(MessageVo messageVo) {
        return new t(messageVo, messageVo, E(messageVo), DomainHelper.f(messageVo), DomainHelper.b());
    }

    public void C(String str) {
        eo3 eo3VarC = go3.b().c(str);
        LogUtil.i(g, "cancelSendMessage " + eo3VarC);
        if (eo3VarC != null) {
            eo3VarC.a();
        }
    }

    public final int D(DBUriManager.MsgSaveType msgSaveType) {
        return Math.max(0, F(msgSaveType) - 50000);
    }

    public final int E(MessageVo messageVo) {
        if (messageVo == null) {
            return 0;
        }
        String str = messageVo.sendFlag;
        int iIntValue = str != null ? Integer.valueOf(str).intValue() : 0;
        if (iIntValue == 1 && messageVo.isNetworkError()) {
            return 3;
        }
        return iIntValue;
    }

    public final int F(DBUriManager.MsgSaveType msgSaveType) {
        Integer num = this.f.get(msgSaveType.name());
        if (num != null) {
            return num.intValue();
        }
        int iR = com.zenmen.palmchat.database.b.r(msgSaveType);
        this.f.put(msgSaveType.name(), Integer.valueOf(iR));
        return iR;
    }

    public final MessageVo G(MessageVo messageVo) {
        if (!f33.i() || messageVo.mimeType != 1 || !a66.a(messageVo.text) || !messageVo.text.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return messageVo;
        }
        String str = messageVo.text;
        if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            str = "http://" + messageVo.text;
        }
        Uri uri = Uri.parse(str);
        if (uri == null) {
            return messageVo;
        }
        MessageVo threadBizType = MessageVo.buildLinkMessage(messageVo.mid, messageVo.contactRelate, uri.getHost(), messageVo.text, uri.toString(), null, null, 0).setThreadBizType(AppContext.getContext(), messageVo.bizType);
        threadBizType.data3 = String.valueOf(-1);
        return threadBizType;
    }

    public final void H(MessageVo messageVo) {
        k(new p(DomainHelper.b(), DomainHelper.f(messageVo), messageVo));
    }

    public final void I(MessageVo messageVo) {
        k(new o(messageVo));
    }

    public final void J(MessageVo messageVo) {
        k(new n(messageVo));
    }

    public void K() {
        k(new q(Locale.getDefault().toString()));
    }

    public final void L(MessageVo messageVo) {
        if (messageVo != null) {
            SmidHelper.SMScene sMScene = SmidHelper.SMScene.CHAT_PRIVATE;
            String str = messageVo.to;
            if (str != null && str.contains(DomainHelper.Domains.DOMAIN_GROUPCHAT.domain)) {
                sMScene = SmidHelper.SMScene.CHAT_GROUP;
            } else if (messageVo.bizType == 0) {
                sMScene = SmidHelper.SMScene.CHAT_FRIEND;
            }
            SmidHelper.x(sMScene);
        }
    }

    public final void M() {
        try {
            DBUriManager.MsgSaveType msgSaveType = DBUriManager.MsgSaveType.COMMON;
            AudioController.v0(msgSaveType, D(msgSaveType));
            com.zenmen.palmchat.database.b.F(msgSaveType, D(msgSaveType));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void N(MessageVo messageVo) throws RemoteException {
        if (messageVo != null) {
            int i2 = messageVo.mimeType;
            if (i2 == 19) {
                H(messageVo);
                return;
            }
            if (i2 == 15000) {
                I(messageVo);
            } else if (i2 == 42) {
                J(messageVo);
            } else {
                this.e.post(new l(messageVo));
            }
        }
    }

    public void O() {
        Cursor cursorQuery;
        DBUriManager.MsgSaveType msgSaveType = DBUriManager.MsgSaveType.COMMON;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.d(ho3.class, msgSaveType), null, "_id >=" + D(msgSaveType) + " AND (msg_status=? or msg_status=?)", new String[]{String.valueOf(1), String.valueOf(4)}, "_id ASC");
        } catch (Exception e2) {
            e2.printStackTrace();
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                MessageVo messageVoBuildFromCursor = MessageVo.buildFromCursor(cursorQuery);
                if (messageVoBuildFromCursor != null) {
                    LogUtil.i(g, 3, new r(messageVoBuildFromCursor), (Throwable) null);
                    String str = messageVoBuildFromCursor.sendFlag;
                    int iIntValue = str != null ? Integer.valueOf(str).intValue() : 0;
                    if (iIntValue == 0) {
                        iIntValue = 2;
                    }
                    messageVoBuildFromCursor.sendFlag = String.valueOf(iIntValue);
                    l(messageVoBuildFromCursor.mid, t(messageVoBuildFromCursor));
                }
            }
            cursorQuery.close();
        }
    }

    public void k(Runnable runnable) {
        if (this.b.isTerminated() || this.b.isShutdown()) {
            return;
        }
        this.b.submit(runnable);
    }

    public final void l(String str, eo3 eo3Var) {
        if (this.b.isTerminated() || this.b.isShutdown()) {
            return;
        }
        go3.b().a(str, eo3Var);
        this.b.submit(eo3Var);
    }

    public final void m(MessageVo messageVo) {
        if (MomentsConfig.j() && rl0.h().i().g() && messageVo != null && messageVo.isSend && messageVo.mimeType == 2 && messageVo.bizType == 0 && !TextUtils.isEmpty(messageVo.contactRelate)) {
            String strP = AccountUtils.p(AppContext.getContext());
            if (TextUtils.isEmpty(strP)) {
                return;
            }
            if (r75.d(AppContext.getContext(), strP + "sp_image_notice_enable", true)) {
                if (System.currentTimeMillis() - r75.h(AppContext.getContext(), strP + messageVo.contactRelate + "sp_image_notice_last_time") >= rl0.h().i().b() && MessageVo.appendImageNoticeMessage(messageVo, rl0.h().i().a())) {
                    r75.q(AppContext.getContext(), strP + messageVo.contactRelate + "sp_image_notice_last_time", System.currentTimeMillis());
                    LogUtil.uploadInfoImmediate("M182", null, null, null);
                }
            }
        }
    }

    public final eo3 n(MessageVo messageVo) {
        return new g(messageVo, messageVo, messageVo.mid, DomainHelper.f(messageVo), E(messageVo));
    }

    public eo3 o(MessageVo messageVo) {
        return new h(messageVo, messageVo.mid, DomainHelper.f(messageVo), E(messageVo));
    }

    public final eo3 p(MessageVo messageVo) {
        return new d(messageVo, messageVo, DomainHelper.f(messageVo), E(messageVo), Boolean.valueOf(messageVo.hdFlag).booleanValue(), messageVo.mid);
    }

    public final MessageProto.Message.Builder q(MessageProto.Message.Media media, MessageVo messageVo, String str, int i2) {
        MessageProto.Message.Builder flag;
        String str2 = messageVo.data5;
        if (str2 == null || !str2.equals(String.valueOf(1))) {
            flag = MessageProto.Message.newBuilder().setFrom(AccountUtils.p(AppContext.getContext()) + "@youni").setMid(messageVo.mid).setTo(str).setBody(messageVo.text).setType(2).setMedia(media).setFlag(i2);
        } else {
            flag = MessageProto.Message.newBuilder().setFrom(AccountUtils.p(AppContext.getContext()) + "@youni").setMid(messageVo.mid).setTo(str).setBody(messageVo.text).setType(2).setMedia(media).setFlag(i2).setExType(1);
        }
        if (!TextUtils.isEmpty(messageVo.bizExtension)) {
            flag.setSubType(messageVo.bizType);
            flag.setExtension(messageVo.bizExtension);
        }
        return flag;
    }

    public final eo3 r(MessageVo messageVo) {
        String str = messageVo.mid;
        String str2 = messageVo.text;
        return new j(messageVo, str, DomainHelper.f(messageVo), E(messageVo), str2);
    }

    public final eo3 s(MessageVo messageVo) {
        return new b(messageVo, E(messageVo), messageVo, DomainHelper.f(messageVo), DomainHelper.b());
    }

    public final eo3 t(MessageVo messageVo) {
        int i2 = messageVo.mimeType;
        return i2 == 3 ? A(messageVo) : i2 == 7 ? s(messageVo) : i2 == 2 ? p(messageVo) : i2 == 1 ? w(messageVo) : i2 == 9 ? u(messageVo) : i2 == 6 ? o(messageVo) : i2 == 14 ? n(messageVo) : i2 == 4 ? z(messageVo) : i2 == 28 ? r(messageVo) : i2 == 30 ? y(messageVo) : i2 == 16 ? v(messageVo) : i2 == 22 ? B(messageVo) : i2 == 17 ? x(messageVo) : fs0.d().b(messageVo) ? fs0.d().a(messageVo) : w(messageVo);
    }

    public eo3 u(MessageVo messageVo) {
        return new f(messageVo, messageVo.mid, DomainHelper.f(messageVo), TextUtils.isEmpty(messageVo.text) ? AppContext.getContext().getResources().getString(R.string.message_type_name_card) : messageVo.text, E(messageVo));
    }

    public final eo3 v(MessageVo messageVo) {
        return new s(messageVo, messageVo, E(messageVo), DomainHelper.f(messageVo), DomainHelper.b());
    }

    public eo3 w(MessageVo messageVo) {
        String str = messageVo.mid;
        String str2 = messageVo.text;
        return new e(messageVo, str, DomainHelper.f(messageVo), E(messageVo), str2);
    }

    public final eo3 x(MessageVo messageVo) {
        return new a(messageVo, messageVo, E(messageVo), DomainHelper.f(messageVo), DomainHelper.b());
    }

    public final eo3 y(MessageVo messageVo) {
        return new m(messageVo, messageVo.mid, messageVo.to, E(messageVo), messageVo.text);
    }

    public final eo3 z(MessageVo messageVo) {
        return new i(messageVo, messageVo, DomainHelper.f(messageVo), Integer.valueOf(messageVo.sendFlag).intValue());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18784a;

        public n(MessageVo messageVo) {
            this.f18784a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            new a(MessageProto.Message.newBuilder().setMid(xn3.a()).setFrom(this.f18784a.from).setTo(this.f18784a.to).setBody("").setSubType(Integer.parseInt(this.f18784a.data1)).setExType(Integer.parseInt(this.f18784a.data2)).setType(42).setFlag(0).setExtension(this.f18784a.extention).build(), ko3.this.f18730a, 0, "notifyReadStatusChange").k();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                LogUtil.i("UnReadStatusSyncManager", "onSendMessageReceivedReply =" + generatedMessageLite);
                if (generatedMessageLite != null) {
                    mb4.f(n.this.f18784a, generatedMessageLite, null, null, null);
                }
            }

            @Override // defpackage.jo3
            public void d() {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18785a;

        public o(MessageVo messageVo) {
            this.f18785a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RichMsgVo richMsgVo;
            int i = 1;
            try {
                String str = this.f18785a.extention;
                if (str != null && (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) != null) {
                    if (richMsgVo.configInfo != null) {
                        i = 2;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            new a(MessageProto.Message.newBuilder().setMid(this.f18785a.mid).setFrom(this.f18785a.from).setTo(this.f18785a.to).setBody("").setSubType(i).setType(15000).setFlag(0).setExtension(this.f18785a.extention).build(), ko3.this.f18730a, 0, "notifyReadStatus").k();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                LogUtil.i(jo3.g, "notifyReadStatusReceivedReply =" + generatedMessageLite);
                if (generatedMessageLite != null) {
                    mb4.f(o.this.f18785a, generatedMessageLite, null, null, null);
                }
            }

            @Override // defpackage.jo3
            public void d() {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18786a;
        public final /* synthetic */ String b;
        public final /* synthetic */ MessageVo c;

        public p(String str, String str2, MessageVo messageVo) {
            this.f18786a = str;
            this.b = str2;
            this.c = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            new a(MessageProto.Message.newBuilder().setMid(xn3.a()).setFrom(this.f18786a).setTo(this.b).setBody("").setType(19).setSubType(this.c.status).setFlag(0).build(), ko3.this.f18730a, 0, "notifyInputStatusChange").j();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18787a;

        public q(String str) {
            this.f18787a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(ko3.g, "notifyServerLocalChanged" + this.f18787a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("locale", this.f18787a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new a(MessageProto.Message.newBuilder().setMid(xn3.a()).setFrom(DomainHelper.b()).setTo("youni").setBody("").setType(11).setSubType(0).setFlag(0).setExtension(jSONObject.toString()).build(), ko3.this.f18730a, 0, "notifyServerLocalChanged").j();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends jo3 {
            public a(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                LogUtil.i(jo3.g, " notifyServerLocalChanged onSendMessageReceivedReply" + q.this.f18787a);
            }

            @Override // defpackage.jo3
            public void d() {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends eo3 {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ String i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", LogUtil.VALUE_MSG_SEND);
                put("status", "start");
                put("mid", j.this.f);
                put("type", 28);
                put(RemoteMessageConst.TO, j.this.g);
                put("flag", Integer.valueOf(j.this.h));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements f33.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RichMsgExItemVo f18777a;
            public final /* synthetic */ RichMsgExVo b;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends jo3 {
                public a(MessageProto.Message message, Context context, int i, String str) {
                    super(message, context, i, str);
                }

                @Override // defpackage.jo3
                public void d() {
                    mb4.f(j.this.f20636a, null, null, null, null);
                    j.this.c();
                }

                @Override // defpackage.jo3
                public void e(GeneratedMessageLite generatedMessageLite) {
                    mb4.f(j.this.f20636a, generatedMessageLite, null, null, null);
                    j.this.c();
                }
            }

            public b(RichMsgExItemVo richMsgExItemVo, RichMsgExVo richMsgExVo) {
                this.f18777a = richMsgExItemVo;
                this.b = richMsgExVo;
            }

            @Override // f33.c
            public void a(boolean z, ShareLinkBean shareLinkBean) {
                if (z) {
                    this.f18777a.cover = shareLinkBean.getIcon();
                    if (!TextUtils.isEmpty(shareLinkBean.getTitle())) {
                        this.f18777a.title = shareLinkBean.getTitle();
                    }
                    RichMsgVo richMsgVo = new RichMsgVo();
                    richMsgVo.appMsg = this.b;
                    j.this.f20636a.data1 = az2.c(richMsgVo);
                }
                MessageVo messageVo = j.this.f20636a;
                com.zenmen.palmchat.database.b.J(messageVo, z ? 0 : -2, z ? messageVo.data1 : null);
                MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(j.this.f).setType(28).setTo(j.this.g).setBody(j.this.i).setFlag(j.this.h);
                flag.setSubType(j.this.f20636a.getSubTypeForSend());
                if (TextUtils.isEmpty(j.this.f20636a.bizExtension)) {
                    flag.setExtension(j.this.f20636a.data1);
                } else {
                    MessageVo messageVo2 = j.this.f20636a;
                    flag.setExtension(MessageVo.mergeJsonStrings(messageVo2.bizExtension, messageVo2.data1));
                }
                flag.setExType(com.zenmen.palmchat.chat.g.l(j.this.f20636a));
                a aVar = new a(flag.build(), ko3.this.f18730a, j.this.h, "sendLinkMessage");
                j.this.f(aVar);
                aVar.i();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends jo3 {
            public c(MessageProto.Message message, Context context, int i, String str) {
                super(message, context, i, str);
            }

            @Override // defpackage.jo3
            public void d() {
                mb4.f(j.this.f20636a, null, null, null, null);
                j.this.c();
            }

            @Override // defpackage.jo3
            public void e(GeneratedMessageLite generatedMessageLite) {
                mb4.f(j.this.f20636a, generatedMessageLite, null, null, null);
                j.this.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MessageVo messageVo, String str, String str2, int i, String str3) {
            super(messageVo);
            this.f = str;
            this.g = str2;
            this.h = i;
            this.i = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
        @Override // defpackage.eo3, defpackage.s0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void d() {
            String str;
            ArrayList<RichMsgExItemVo> arrayList;
            RichMsgExVo richMsgExVoH = com.zenmen.palmchat.chat.g.h(this.f20636a);
            if (richMsgExVoH == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= 0 || richMsgExVoH.items.get(0).showType != 6) {
                str = null;
            } else {
                str = richMsgExVoH.items.get(0).cover;
                if (TextUtils.isEmpty(str) || str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                }
            }
            if (!TextUtils.isEmpty(str)) {
                File fileC = xt.c(str, false);
                if (fileC == null || !fileC.exists()) {
                    mb4.f(this.f20636a, null, null, null, null);
                    c();
                    return;
                } else {
                    fileC.getAbsolutePath();
                    nu1 nu1Var = new nu1(fileC, 4, true, xt.o(fileC.getName()), new d(richMsgExVoH), ko3.this.c, this.f20636a.mid, ko3.this.f18730a, this.g);
                    e(nu1Var);
                    nu1Var.a(false);
                    return;
                }
            }
            LogUtil.i(s0.e, 3, new a(), (Throwable) null);
            int iH = f33.f().h(this.f20636a.data3);
            if (iH != 0) {
                if (iH == -2) {
                    com.zenmen.palmchat.database.b.I(this.f20636a, -1);
                }
                RichMsgExVo richMsgExVoH2 = com.zenmen.palmchat.chat.g.h(this.f20636a);
                RichMsgExItemVo richMsgExItemVo = richMsgExVoH2.items.get(0);
                ShareLinkBean shareLinkBean = new ShareLinkBean();
                shareLinkBean.setOriginUrl(richMsgExItemVo.url);
                shareLinkBean.setUrl(richMsgExItemVo.url);
                f33.f().j(ko3.this.b, shareLinkBean, new b(richMsgExItemVo, richMsgExVoH2));
                return;
            }
            MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(this.f).setType(28).setTo(this.g).setBody(this.i).setFlag(this.h);
            flag.setSubType(this.f20636a.getSubTypeForSend());
            if (TextUtils.isEmpty(this.f20636a.bizExtension)) {
                flag.setExtension(this.f20636a.data1);
            } else {
                MessageVo messageVo = this.f20636a;
                flag.setExtension(MessageVo.mergeJsonStrings(messageVo.bizExtension, messageVo.data1));
            }
            flag.setExType(com.zenmen.palmchat.chat.g.l(this.f20636a));
            jo3 cVar = new c(flag.build(), ko3.this.f18730a, this.h, "sendLinkMessage");
            f(cVar);
            cVar.i();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements a56 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RichMsgExVo f18778a;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {
                public a() {
                    put("action", LogUtil.VALUE_MSG_SEND);
                    put("status", "start");
                    put("mid", j.this.f);
                    put("type", 28);
                    put(RemoteMessageConst.TO, j.this.g);
                    put("flag", Integer.valueOf(j.this.h));
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class b extends jo3 {
                public b(MessageProto.Message message, Context context, int i, String str) {
                    super(message, context, i, str);
                }

                @Override // defpackage.jo3
                public void d() {
                    mb4.f(j.this.f20636a, null, null, null, null);
                    j.this.c();
                }

                @Override // defpackage.jo3
                public void e(GeneratedMessageLite generatedMessageLite) {
                    mb4.f(j.this.f20636a, generatedMessageLite, null, null, null);
                    j.this.c();
                }
            }

            public d(RichMsgExVo richMsgExVo) {
                this.f18778a = richMsgExVo;
            }

            @Override // defpackage.a56
            public void a(Exception exc) {
                mb4.f(j.this.f20636a, null, null, null, null);
                j.this.c();
            }

            @Override // defpackage.a56
            public void b(UploadResultVo uploadResultVo) {
                if (uploadResultVo == null || uploadResultVo.url == null) {
                    mb4.f(j.this.f20636a, null, null, null, null);
                    j.this.c();
                    return;
                }
                LogUtil.i(s0.e, 3, new a(), (Throwable) null);
                MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(DomainHelper.b()).setMid(j.this.f).setType(28).setTo(j.this.g).setBody(j.this.i).setFlag(j.this.h);
                flag.setSubType(j.this.f20636a.getSubTypeForSend());
                this.f18778a.items.get(0).cover = uploadResultVo.url;
                this.f18778a.items.get(0).acode = uploadResultVo.acode;
                RichMsgVo richMsgVo = new RichMsgVo();
                richMsgVo.appMsg = this.f18778a;
                j.this.f20636a.data1 = az2.c(richMsgVo);
                if (TextUtils.isEmpty(j.this.f20636a.bizExtension)) {
                    flag.setExtension(j.this.f20636a.data1);
                } else {
                    MessageVo messageVo = j.this.f20636a;
                    flag.setExtension(MessageVo.mergeJsonStrings(messageVo.bizExtension, messageVo.data1));
                }
                flag.setExType(com.zenmen.palmchat.chat.g.l(j.this.f20636a));
                b bVar = new b(flag.build(), ko3.this.f18730a, j.this.h, "sendLinkMessage");
                j.this.f(bVar);
                bVar.i();
            }

            @Override // defpackage.a56
            public void onProgress(int i, int i2) {
            }
        }
    }
}
