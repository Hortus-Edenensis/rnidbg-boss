package com.oplus.tblplayer.logger;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.Constants;
import com.ss.bytertc.engine.utils.LogUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DiskLoggerAdapter implements ILoggerAdapter {
    private static final int LOGGER_PER_FILE_MAX_BYTES = 512000;
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String SLASH_SEPARATOR = "/";
    private static final String SPACE_SEPARATOR = " ";
    private final SimpleDateFormat dateFormat;
    private WriteHandler handler;
    private boolean hasWriteError;
    private String loggerDirPath;
    private int maxFileSize;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private String loggerDirPath;
        private int maxFileSize = 512000;

        public DiskLoggerAdapter build() {
            if (Utils.isEmpty(this.loggerDirPath)) {
                this.loggerDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "logger";
            }
            return new DiskLoggerAdapter(this.loggerDirPath, this.maxFileSize);
        }

        public Builder setLoggerDirPath(String str) {
            this.loggerDirPath = str;
            return this;
        }

        public Builder setMaxFileSize(int i) {
            this.maxFileSize = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class WriteHandler extends Handler {
        public WriteHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            FileWriter fileWriter;
            String str = (String) message.obj;
            DiskLoggerAdapter diskLoggerAdapter = DiskLoggerAdapter.this;
            FileWriter fileWriter2 = null;
            try {
                fileWriter = new FileWriter(diskLoggerAdapter.getLogFile(diskLoggerAdapter.loggerDirPath, LogUtil.DIR_TAIL), true);
            } catch (IOException unused) {
            }
            try {
                DiskLoggerAdapter.this.writeLog(fileWriter, str);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException unused2) {
                fileWriter2 = fileWriter;
                DiskLoggerAdapter.this.hasWriteError = true;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.flush();
                        fileWriter2.close();
                    } catch (IOException unused3) {
                    }
                }
            }
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    private DiskLoggerAdapter(String str, int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        this.dateFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
        this.loggerDirPath = str;
        this.maxFileSize = i;
        HandlerThread handlerThread = new HandlerThread("DiskLogger:" + str);
        handlerThread.start();
        this.handler = new WriteHandler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getLogFile(@NonNull String str, @NonNull String str2) {
        Utils.checkNotNull(str);
        Utils.checkNotNull(str2);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, String.format("%s_%s.log", str2, 0));
        File file3 = null;
        int i = 0;
        while (file2.exists()) {
            i++;
            file3 = file2;
            file2 = new File(file, String.format("%s_%s.log", str2, Integer.valueOf(i)));
        }
        return (file3 == null || file3.length() >= ((long) this.maxFileSize)) ? file2 : file3;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeLog(@NonNull FileWriter fileWriter, @NonNull String str) throws IOException {
        Utils.checkNotNull(fileWriter);
        Utils.checkNotNull(str);
        fileWriter.append((CharSequence) str);
    }

    @Override // com.oplus.tblplayer.logger.ILoggerAdapter
    public boolean isLoggable(int i) {
        return !this.hasWriteError;
    }

    @Override // com.oplus.tblplayer.logger.ILoggerAdapter
    @SuppressLint({"DefaultLocale"})
    public int println(int i, @Nullable String str, @NonNull String str2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append(this.dateFormat.format(Long.valueOf(jElapsedRealtime)));
        sb.append(" ");
        sb.append(String.format("%d-%d", Integer.valueOf(Utils.getProcessPid()), Integer.valueOf(Utils.getProcessTid())));
        sb.append(" ");
        sb.append(Utils.priorityChar(i));
        sb.append(SLASH_SEPARATOR);
        if (Utils.isEmpty(str)) {
            str = Constants.STRING_VALUE_UNSET;
        }
        sb.append(str);
        sb.append(":");
        sb.append(" ");
        sb.append(str2);
        if (!str2.endsWith("\n")) {
            sb.append("\n");
        }
        WriteHandler writeHandler = this.handler;
        writeHandler.sendMessage(writeHandler.obtainMessage(i, sb.toString()));
        return sb.length();
    }
}
