package com.qiniu.android.collect;

import com.kuaishou.weapon.p0.t;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.transaction.TransactionManager;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UploadInfoReporter {
    private static final String DelayReportTransactionName = "com.qiniu.uplog";
    private static UploadInfoReporter instance = new UploadInfoReporter();
    private String X_Log_Client_Id;
    private RequestTransaction transaction;
    private ReportConfig config = ReportConfig.getInstance();
    private long lastReportTime = 0;
    private File recordDirectory = new File(this.config.recordDirectory);
    private File recorderFile = new File(this.config.recordDirectory + "/qiniu.log");
    private File recorderTempFile = new File(this.config.recordDirectory + "/qiniuTemp.log");
    private final ExecutorService executorService = new ThreadPoolExecutor(1, 2, 120, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private boolean isReporting = false;

    private UploadInfoReporter() {
    }

    private boolean checkReportAvailable() {
        ReportConfig reportConfig = this.config;
        if (!reportConfig.isReportEnable) {
            return false;
        }
        if (reportConfig.maxRecordFileSize > reportConfig.uploadThreshold) {
            return true;
        }
        LogUtil.e("maxRecordFileSize must be larger than uploadThreshold");
        return false;
    }

    private void cleanRecorderFile() {
        if (this.recorderFile.exists()) {
            this.recorderFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanTempLogFile() {
        if (this.recorderTempFile.exists()) {
            this.recorderTempFile.delete();
        }
    }

    private synchronized RequestTransaction createUploadRequestTransaction(String str) {
        if (this.transaction != null) {
            return null;
        }
        if (this.config == null) {
            return null;
        }
        UpToken upToken = UpToken.parse(str);
        if (upToken == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.config.serverURL);
        RequestTransaction requestTransaction = new RequestTransaction(arrayList, "unknown", upToken);
        this.transaction = requestTransaction;
        return requestTransaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyTransactionResource() {
        this.transaction = null;
    }

    public static UploadInfoReporter getInstance() {
        return instance;
    }

    private byte[] getLogData() throws Throwable {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        File file = this.recorderTempFile;
        byte[] byteArray = null;
        byteArray = null;
        byteArray = null;
        byteArray = null;
        byteArray = null;
        RandomAccessFile randomAccessFile2 = null;
        byteArray = null;
        if (file != null && file.length() != 0) {
            int length = (int) this.recorderTempFile.length();
            try {
                randomAccessFile = new RandomAccessFile(this.recorderTempFile, t.k);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(length);
                    bArr = new byte[length];
                } catch (FileNotFoundException unused) {
                    if (randomAccessFile != null) {
                    }
                    return byteArray;
                } catch (IOException unused2) {
                    if (randomAccessFile != null) {
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused4) {
                randomAccessFile = null;
            } catch (IOException unused5) {
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                while (true) {
                    int i = randomAccessFile.read(bArr);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                    randomAccessFile.close();
                }
                randomAccessFile.close();
            } catch (IOException unused6) {
            }
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    private void reportToServer(String str) {
        byte[] logData;
        RequestTransaction requestTransactionCreateUploadRequestTransaction = createUploadRequestTransaction(str);
        if (requestTransactionCreateUploadRequestTransaction == null || (logData = getLogData()) == null || logData.length == 0) {
            return;
        }
        this.isReporting = true;
        requestTransactionCreateUploadRequestTransaction.reportLog(logData, this.X_Log_Client_Id, true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.collect.UploadInfoReporter.3
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                Map<String, String> map;
                if (responseInfo.isOK()) {
                    UploadInfoReporter.this.lastReportTime = new Date().getTime();
                    if (UploadInfoReporter.this.X_Log_Client_Id == null && (map = responseInfo.responseHeader) != null && map.get("x-log-client-id") != null) {
                        UploadInfoReporter.this.X_Log_Client_Id = responseInfo.responseHeader.get("x-log-client-id");
                    }
                    UploadInfoReporter.this.cleanTempLogFile();
                }
                UploadInfoReporter.this.isReporting = false;
                UploadInfoReporter.this.destroyTransactionResource();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportToServerIfNeeded(final String str) {
        boolean z;
        TransactionManager.Transaction transaction;
        long jCurrentSecondTimestamp = Utils.currentSecondTimestamp();
        long j = (long) (this.config.interval * 60.0d);
        if (this.recorderTempFile.exists()) {
            z = true;
        } else {
            long j2 = this.lastReportTime;
            if ((j2 != 0 && jCurrentSecondTimestamp - j2 < j && this.recorderFile.length() <= this.config.uploadThreshold) || !this.recorderFile.renameTo(this.recorderTempFile)) {
                z = false;
            }
        }
        if (z && !this.isReporting) {
            reportToServer(str);
            return;
        }
        if (!this.recorderFile.exists() || this.recorderFile.length() == 0) {
            return;
        }
        ArrayList<TransactionManager.Transaction> arrayListTransactionsForName = TransactionManager.getInstance().transactionsForName(DelayReportTransactionName);
        if (arrayListTransactionsForName == null || arrayListTransactionsForName.size() <= 1) {
            if (arrayListTransactionsForName == null || arrayListTransactionsForName.size() != 1 || (transaction = arrayListTransactionsForName.get(0)) == null || transaction.isExecuting()) {
                TransactionManager.getInstance().addTransaction(new TransactionManager.Transaction(DelayReportTransactionName, (int) j, new Runnable() { // from class: com.qiniu.android.collect.UploadInfoReporter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        UploadInfoReporter.this.reportToServerIfNeeded(str);
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveReportJsonString(String str) throws Throwable {
        if (this.recordDirectory.exists() || this.recordDirectory.mkdirs()) {
            if (!this.recordDirectory.isDirectory()) {
                LogUtil.e("recordDirectory is not a directory");
                return;
            }
            if (!this.recorderFile.exists()) {
                try {
                    if (!this.recorderFile.createNewFile()) {
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (this.recorderFile.length() > this.config.maxRecordFileSize) {
                return;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.recorderFile, true);
                    try {
                        fileOutputStream2.write((str + "\n").getBytes());
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void clean() {
        cleanRecorderFile();
        cleanTempLogFile();
    }

    public synchronized void report(ReportItem reportItem, final String str) {
        if (checkReportAvailable() && reportItem != null && str != null && str.length() != 0) {
            final String json = reportItem.toJson();
            if (json == null) {
                return;
            }
            this.executorService.submit(new Runnable() { // from class: com.qiniu.android.collect.UploadInfoReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.i("up log:" + StringUtils.toNonnullString(json));
                    synchronized (this) {
                        UploadInfoReporter.this.saveReportJsonString(json);
                        UploadInfoReporter.this.reportToServerIfNeeded(str);
                    }
                }
            });
        }
    }
}
