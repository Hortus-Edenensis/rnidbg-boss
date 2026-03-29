package defpackage;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zenmen.palmchat.fileupload.blockupload.CancellationHandler;
import com.zenmen.palmchat.fileupload.dao.BlockVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.util.HashMap;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cu implements Runnable {
    public static final String k = "cu";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f16912a;
    public String b;
    public BlockVo c;
    public String d;
    public String e;
    public lu1 f;
    public CancellationHandler g;
    public int h;
    public String i;
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "start_upload_block");
            put("detail", cu.this.c.toString());
            put("md5", cu.this.b);
            put("fileName", cu.this.f16912a.getName());
            put("fileSize", Long.valueOf(cu.this.f16912a.length()));
            put("mid", cu.this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "finish_upload_block");
            put("detail", cu.this.c.toString());
            put("md5", cu.this.b);
            put("fileName", cu.this.f16912a.getName());
            put("fileSize", Long.valueOf(cu.this.f16912a.length()));
            put("mid", cu.this.d);
        }
    }

    public cu(File file, String str, lu1 lu1Var, CancellationHandler cancellationHandler, BlockVo blockVo, String str2, int i, String str3, boolean z, String str4) {
        this.f16912a = file;
        this.b = str;
        this.f = lu1Var;
        this.g = cancellationHandler;
        this.c = blockVo;
        this.d = str2;
        this.h = i;
        this.i = str3;
        this.j = z;
        this.e = str4;
    }

    public void e() {
        LogUtil.i(k, 3, new a(), (Throwable) null);
        BlockVo blockVo = this.c;
        int i = (blockVo.size / blockVo.chunkSize) + 1;
        for (int i2 = 0; i2 <= i; i2++) {
            BlockVo blockVo2 = this.c;
            if (blockVo2.offset == blockVo2.size) {
                LogUtil.i(k, 3, new b(), (Throwable) null);
                this.f.a(3, null, null, null);
                return;
            }
            String strF = f(this.h);
            if (TextUtils.isEmpty(strF)) {
                this.f.a(1, null, null, new Exception("SegmentUploader upload result is empty"));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(strF);
                if (jSONObject.getInt("resultCode") != 0) {
                    this.f.a(1, null, null, new Exception("resultcode != 0" + strF));
                    return;
                }
                String string = jSONObject.getJSONObject("data").getString("blockId");
                int i3 = jSONObject.getJSONObject("data").getInt("offset");
                BlockVo blockVo3 = this.c;
                blockVo3.offset = i3;
                blockVo3.blockId = string;
                this.f.a(2, null, strF, null);
            } catch (JSONException e) {
                e.printStackTrace();
                this.f.a(1, null, null, e);
                return;
            }
        }
        this.f.a(1, null, null, new Exception("upload_count_exception"));
    }

    public final String f(int i) {
        StringBuilder sb;
        String str;
        String string;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        MultipartEntityBuilder multipartEntityBuilderCreate = MultipartEntityBuilder.create();
        multipartEntityBuilderCreate.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntityBuilderCreate.addPart("file", new com.zenmen.palmchat.fileupload.blockupload.a(this.f16912a, this.c, this.f, this.g));
        if (TextUtils.isEmpty(this.c.blockId)) {
            multipartEntityBuilderCreate.addTextBody(RemoteMessageConst.TO, this.e);
            multipartEntityBuilderCreate.addTextBody("fhash", this.b);
            multipartEntityBuilderCreate.addTextBody("blockSize", Integer.toString(this.c.size));
            multipartEntityBuilderCreate.addTextBody("blockIndex", Integer.toString(this.c.index));
        } else {
            multipartEntityBuilderCreate.addTextBody(RemoteMessageConst.TO, this.e);
            multipartEntityBuilderCreate.addTextBody("blockId", this.c.blockId);
            multipartEntityBuilderCreate.addTextBody("offset", Integer.toString(this.c.offset));
        }
        String str4 = k;
        LogUtil.i(str4, "mkBlockorUploadSegment start" + this.c.blockId + "   " + this.c.size + "   " + this.c.index + "   " + this.c.offset);
        if (i == 1) {
            BlockVo blockVo = this.c;
            if (TextUtils.isEmpty(blockVo.blockId)) {
                sb3 = new StringBuilder();
                sb3.append(nl0.f);
                str3 = "/feed-media/v4/mkblk.json";
            } else {
                sb3 = new StringBuilder();
                sb3.append(nl0.f);
                str3 = "/feed-media/v4/chunk.json";
            }
            sb3.append(str3);
            com.zenmen.palmchat.fileupload.blockupload.b bVar = new com.zenmen.palmchat.fileupload.blockupload.b(multipartEntityBuilderCreate, blockVo, sb3.toString(), com.zenmen.palmchat.fileupload.blockupload.b.f(), 3, this.d, this.i);
            LogUtil.i(str4, "mkBlockorUploadSegment uploader.upload()");
            return bVar.h();
        }
        if (TextUtils.isEmpty(this.c.blockId)) {
            if (this.j) {
                sb = new StringBuilder();
                sb.append(nl0.w);
                str = "/upstream/v6/mkblk";
            } else {
                sb = new StringBuilder();
                sb.append(nl0.f);
                str = "/media/v4/mkblk.json";
            }
            sb.append(str);
            string = sb.toString();
        } else {
            if (this.j) {
                sb2 = new StringBuilder();
                sb2.append(nl0.w);
                str2 = "/upstream/v6/chunk";
            } else {
                sb2 = new StringBuilder();
                sb2.append(nl0.f);
                str2 = "/media/v4/chunk.json";
            }
            sb2.append(str2);
            string = sb2.toString();
        }
        com.zenmen.palmchat.fileupload.blockupload.b bVar2 = new com.zenmen.palmchat.fileupload.blockupload.b(multipartEntityBuilderCreate, this.c, string, com.zenmen.palmchat.fileupload.blockupload.b.f(), 3, this.d, this.i);
        LogUtil.i(str4, "mkBlockorUploadSegment uploader.upload()");
        return bVar2.h();
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }
}
