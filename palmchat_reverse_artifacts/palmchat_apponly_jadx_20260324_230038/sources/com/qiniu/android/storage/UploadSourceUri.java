package com.qiniu.android.storage;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.qiniu.android.utils.ContextGetter;
import com.qiniu.android.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(19)
class UploadSourceUri extends UploadSourceStream {
    private String modifyDate;
    private Exception readException;
    private ContentResolver resolver;
    private final Uri uri;

    public UploadSourceUri(Uri uri, ContentResolver contentResolver) {
        super(null);
        this.readException = null;
        this.modifyDate = "";
        this.uri = uri;
        this.resolver = contentResolver;
        reloadSource();
        loadFileInfo();
    }

    private InputStream createInputStream() throws Exception {
        ContentResolver contextResolver;
        if (this.uri == null || (contextResolver = getContextResolver()) == null) {
            return null;
        }
        return contextResolver.openInputStream(this.uri);
    }

    private ContentResolver getContextResolver() {
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            return contentResolver;
        }
        Context contextApplicationContext = ContextGetter.applicationContext();
        if (contextApplicationContext != null) {
            this.resolver = contextApplicationContext.getContentResolver();
        }
        return this.resolver;
    }

    private void loadFileInfo() {
        Uri uri = this.uri;
        if (uri == null) {
            return;
        }
        if ("file".equals(uri.getScheme())) {
            tryLoadFileInfoByPath();
        } else {
            tryLoadFileInfoByCursor();
        }
    }

    private void tryLoadFileInfoByCursor() {
        Cursor cursorQuery;
        String string;
        ContentResolver contextResolver = getContextResolver();
        if (contextResolver == null) {
            return;
        }
        try {
            cursorQuery = contextResolver.query(this.uri, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            return;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                int columnIndex = cursorQuery.getColumnIndex("_data");
                if (!cursorQuery.isNull(columnIndex) && (string = cursorQuery.getString(columnIndex)) != null) {
                    File file = new File(string);
                    setSize(file.length());
                    setFileName(file.getName());
                    this.modifyDate = (file.lastModified() / 1000) + "";
                    return;
                }
                int columnIndex2 = cursorQuery.getColumnIndex("_size");
                if (!cursorQuery.isNull(columnIndex2)) {
                    setSize(cursorQuery.getLong(columnIndex2));
                }
                int columnIndex3 = cursorQuery.getColumnIndex("_display_name");
                if (!cursorQuery.isNull(columnIndex3)) {
                    setFileName(cursorQuery.getString(columnIndex3));
                }
                int columnIndex4 = cursorQuery.getColumnIndex("date_modified");
                if (!cursorQuery.isNull(columnIndex4)) {
                    this.modifyDate = cursorQuery.getString(columnIndex4);
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    private void tryLoadFileInfoByPath() {
        if (this.uri.getPath() != null) {
            File file = new File(this.uri.getPath());
            if (file.exists() && file.isFile()) {
                setFileName(file.getName());
                setSize(file.length());
                this.modifyDate = file.lastModified() + "";
            }
        }
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public void close() {
        InputStream inputStream = getInputStream();
        if (inputStream != null) {
            try {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    inputStream.close();
                }
            } catch (IOException unused2) {
            }
        }
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public boolean couldReloadSource() {
        Uri uri = this.uri;
        return (uri == null || StringUtils.isNullOrEmpty(uri.getScheme())) ? false : true;
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public String getId() {
        return getFileName() + "_" + this.modifyDate;
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public String getSourceType() {
        return "Uri";
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public byte[] readData(int i, long j) throws IOException {
        if (this.readException == null) {
            return super.readData(i, j);
        }
        throw new IOException("Uri read data exception: " + this.readException, this.readException);
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public boolean reloadSource() {
        super.reloadSource();
        close();
        InputStream inputStreamCreateInputStream = null;
        this.readException = null;
        try {
            inputStreamCreateInputStream = createInputStream();
            setInputStream(inputStreamCreateInputStream);
        } catch (Exception e) {
            this.readException = e;
        }
        return inputStreamCreateInputStream != null;
    }
}
