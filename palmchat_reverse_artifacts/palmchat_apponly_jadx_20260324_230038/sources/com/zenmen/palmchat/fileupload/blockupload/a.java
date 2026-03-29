package com.zenmen.palmchat.fileupload.blockupload;

import com.zenmen.palmchat.fileupload.blockupload.CancellationHandler;
import com.zenmen.palmchat.fileupload.dao.BlockVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.lu1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.entity.mime.content.FileBody;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends FileBody {
    public static final String h = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13952a;
    public final int b;
    public final int c;
    public final int d;
    public BlockVo e;
    public final lu1 f;
    public final CancellationHandler g;

    public a(File file, BlockVo blockVo, lu1 lu1Var, CancellationHandler cancellationHandler) {
        super(file);
        this.e = blockVo;
        this.f13952a = blockVo.index;
        this.b = blockVo.paramSize;
        this.c = blockVo.offset;
        this.d = a();
        this.f = lu1Var;
        this.g = cancellationHandler;
    }

    public final int a() {
        BlockVo blockVo = this.e;
        int i = blockVo.size - blockVo.offset;
        int i2 = blockVo.chunkSize;
        return i < i2 ? i : i2;
    }

    public final void b(int i) {
        int i2 = this.c + i;
        BlockVo blockVo = this.e;
        if (blockVo.offset < i2) {
            blockVo.offset = i2;
            lu1 lu1Var = this.f;
            if (lu1Var != null) {
                lu1Var.b(this.f13952a, i, this.d);
            }
        }
    }

    @Override // org.apache.http.entity.mime.content.FileBody, org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = (FileInputStream) getInputStream();
        String str = h;
        LogUtil.i(str, "writeTo blockIndex " + this.f13952a + " blockSize" + this.b + " offset" + this.c + "length" + this.d + " position" + ((this.f13952a * this.b) + this.c));
        fileInputStream.getChannel().position((long) ((this.f13952a * this.b) + this.c));
        try {
            byte[] bArr = new byte[8192];
            int i = ((this.d + 8192) - 1) / 8192;
            LogUtil.i(str, "count = " + i);
            int i2 = 0;
            while (i > 0) {
                CancellationHandler cancellationHandler = this.g;
                if (cancellationHandler != null && cancellationHandler.isCancelled()) {
                    try {
                        outputStream.close();
                    } catch (Exception unused) {
                    }
                    throw new CancellationHandler.CancellationException();
                }
                int i3 = fileInputStream.read(bArr, 0, Math.min(this.d - i2, 8192));
                outputStream.write(bArr, 0, i3);
                i--;
                i2 += i3;
                b(i2);
            }
            LogUtil.i(h, "writhlength = " + i2);
            outputStream.flush();
        } finally {
            fileInputStream.close();
        }
    }
}
