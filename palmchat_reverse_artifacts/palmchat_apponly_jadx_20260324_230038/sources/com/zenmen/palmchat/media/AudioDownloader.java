package com.zenmen.palmchat.media;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.SqliteRecover;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ho3;
import defpackage.it0;
import defpackage.nl0;
import defpackage.pu1;
import defpackage.rb3;
import defpackage.te1;
import defpackage.zf1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AudioDownloader {
    public static final int CONNECTION_TIME_OUT = 10000;
    public static final int MAX_REDIRECT_COUNT = 3;
    public static final int READ_TIME_OUT = 60000;
    public static final int RETRY_COUNT = 3;
    private static final String TAG = "AudioDownloader";
    public static final String TAG_LAG = "AudioDownloader_lag";
    private static AudioDownloader audioDownloader;
    private ExecutorService downloadExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
    private long downloadIndex;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14642a;
        public final /* synthetic */ MessageVo b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.media.AudioDownloader$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1075a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14643a;
            public final /* synthetic */ String b;

            public C1075a(String str, String str2) {
                this.f14643a = str;
                this.b = str2;
                put("action", "msg_file_download");
                put("status", "start");
                put("type", String.valueOf(3));
                put("mid", str);
                put("md5", str2);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f14644a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ File d;

            public b(boolean z, String str, String str2, File file) {
                this.f14644a = z;
                this.b = str;
                this.c = str2;
                this.d = file;
                put("action", "msg_file_download");
                put("status", z ? "success" : "fail");
                put("type", String.valueOf(3));
                put("mid", str);
                put("md5", str2);
                put("fileSize", Long.valueOf(file.exists() ? file.length() : 0L));
            }
        }

        public a(String str, MessageVo messageVo) {
            this.f14642a = str;
            this.b = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.c(ho3.class, this.b.contactRelate), null, "packet_id=?", new String[]{this.f14642a}, null);
            if (cursorQuery == null) {
                return;
            }
            if (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                boolean z = !TextUtils.isEmpty(string) && new File(string).exists();
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("data3"));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("data4"));
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("attach_status"));
                if ((i == 0 || i == 3 || !z) && !TextUtils.isEmpty(string2)) {
                    AudioDownloader.this.updateAudioFileDownloadStatus(this.b, 1, null);
                    pu1.s();
                    String str = pu1.g + File.separator + AudioController.Y();
                    String string4 = UUID.randomUUID().toString();
                    String str2 = AudioDownloader.TAG;
                    LogUtil.LogType logType = LogUtil.LogType.LOG_TYPE_QA_NORMAL;
                    LogUtil.i(str2, logType, 3, new C1075a(string4, string3), (Throwable) null);
                    boolean zDownloadAudioFile = AudioDownloader.this.downloadAudioFile(this.f14642a, string2, str, string3);
                    File file = new File(str);
                    boolean z2 = (!zDownloadAudioFile || (file.exists() && file.length() != 0)) ? zDownloadAudioFile : false;
                    LogUtil.i(AudioDownloader.TAG, logType, 3, new b(z2, string4, string3, file), (Throwable) null);
                    if (z2) {
                        String strP = AccountUtils.p(AppContext.getContext());
                        AudioDownloader audioDownloader = AudioDownloader.this;
                        MessageVo messageVo = this.b;
                        audioDownloader.processAudioFile(str, messageVo.mid, strP, messageVo.contactRelate);
                        LogUtil.i(AudioDownloader.TAG, "filepath=" + str + "mid=" + this.b.mid + "uid=" + strP);
                    }
                    AudioDownloader.this.updateAudioFileDownloadStatus(this.b, z2 ? 2 : 0, z2 ? str : null);
                }
            }
            cursorQuery.close();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14645a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.f14645a = str;
            this.b = str2;
            put("action", "audio_download");
            put("status", "fail");
            put("detail", "mid=" + str + "urlString=" + str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable, Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f14646a;
        public Runnable b;

        public c(Runnable runnable, long j) {
            this.f14646a = j;
            this.b = runnable;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull c cVar) {
            long j = this.f14646a;
            long j2 = cVar.f14646a;
            if (j < j2) {
                return 1;
            }
            return j > j2 ? -1 : 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.run();
        }
    }

    private AudioDownloader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        downloadAudioFileImp(r18, r19, null, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
    
        defpackage.it0.k().s("all ip failed");
        com.zenmen.palmchat.utils.log.LogUtil.i(com.zenmen.palmchat.media.AudioDownloader.TAG, 3, new com.zenmen.palmchat.media.AudioDownloader.b(r16, r17, r18), r0);
        r6 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean downloadAudioFile(String str, String str2, String str3, String str4) {
        int i = 0;
        while (i < 3) {
            Iterator<te1> it = it0.k().g().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                te1 next = it.next();
                if (next.a(str2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 2) {
                            break;
                        }
                        DNSNode[] dNSNodeArrI = it0.k().i(next.f20971a);
                        if (dNSNodeArrI != null) {
                            for (DNSNode dNSNode : dNSNodeArrI) {
                                String strQ = it0.q(str2, next, dNSNode);
                                HashMap map = new HashMap();
                                map.put("Host", next.f20971a);
                                try {
                                    downloadAudioFileImp(strQ, str3, map, str4);
                                    return true;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            if (!it0.k().n() || i2 != 0) {
                                break;
                            }
                            it0.k().t("dns cache is empty when doing HTTP request");
                            i2++;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadAudioFileImp(String str, String str2, Map<String, String> map, String str3) throws Exception {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        byte[] bArr;
        HttpURLConnection httpURLConnectionA = zf1.a(str, map, 10000, 60000);
        int i = 0;
        while (true) {
            BufferedInputStream bufferedInputStream2 = null;
            if (httpURLConnectionA.getResponseCode() / 100 != 3 || i >= 3) {
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnectionA.getInputStream(), 4096);
                    try {
                        fileOutputStream = new FileOutputStream(str2);
                        try {
                            bArr = new byte[1024];
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream2 = bufferedInputStream;
                            try {
                                e.printStackTrace();
                                pu1.u(bufferedInputStream2);
                            } catch (Throwable th) {
                                th = th;
                                pu1.u(bufferedInputStream2);
                                pu1.u(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream2 = bufferedInputStream;
                            pu1.u(bufferedInputStream2);
                            pu1.u(fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                while (true) {
                    int i2 = bufferedInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i2);
                    }
                    pu1.u(fileOutputStream);
                    httpURLConnectionA.disconnect();
                    if (!isAudioMd5Wrong(new File(str2), str3, false)) {
                        throw new IOException("audio md5 mismatch");
                    }
                    return;
                }
                fileOutputStream.flush();
                pu1.u(bufferedInputStream);
                pu1.u(fileOutputStream);
                httpURLConnectionA.disconnect();
                if (!isAudioMd5Wrong(new File(str2), str3, false)) {
                }
            } else {
                String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
                httpURLConnectionA.disconnect();
                httpURLConnectionA = zf1.a(headerField, null, 10000, 60000);
                i++;
            }
        }
    }

    public static AudioDownloader getInstance() {
        if (audioDownloader == null) {
            audioDownloader = new AudioDownloader();
        }
        return audioDownloader;
    }

    public static boolean isAudioMd5Wrong(File file, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("_")) {
            str = z ? str.split("_")[1] : str.split("_")[0];
        }
        return !str.equals(rb3.b(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAudioFile(String str, String str2, String str3, String str4) {
        if (nl0.g()) {
            return;
        }
        SqliteRecover.dump(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAudioFileDownloadStatus(MessageVo messageVo, int i, String str) {
        String[] strArr = {messageVo.mid};
        ContentValues contentValues = new ContentValues();
        contentValues.put("only_update_msg", Boolean.TRUE);
        contentValues.put("attach_status", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            contentValues.put("data2", str);
        }
        LogUtil.i(TAG_LAG, "updateAudioFileDownloadStatus start-------");
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", strArr);
        LogUtil.i(TAG_LAG, "updateAudioFileDownloadStatus end-------");
    }

    public static void updateAudioFileMd5(String str, String str2, String str3) {
        String[] strArr = {str};
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.c(ho3.class, str2), null, "packet_id=?", strArr, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("data4")) : null;
            cursorQuery.close();
        }
        if (string == null || str3 == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("data4", string + "_" + str3);
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, str2), contentValues, "packet_id=?", strArr);
    }

    public void downloadAudioFileByMessageId(MessageVo messageVo, boolean z) {
        String str = messageVo.mid;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = new a(str, messageVo);
        if (z) {
            updateAudioFileDownloadStatus(messageVo, 3, null);
        }
        long j = this.downloadIndex;
        this.downloadIndex = j - 1;
        if (z) {
            j = 100;
        }
        this.downloadExecutor.execute(new c(aVar, j));
    }
}
