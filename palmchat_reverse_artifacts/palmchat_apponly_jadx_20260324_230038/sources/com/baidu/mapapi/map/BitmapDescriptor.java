package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class BitmapDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bitmap f3610a;
    private Bundle b;

    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f3610a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    private Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public byte[] b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f3610a.getWidth() * this.f3610a.getHeight() * 4);
        this.f3610a.copyPixelsToBuffer(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    public void clearCache() {
        Bundle bundle = this.b;
        if (bundle != null) {
            bundle.clear();
            this.b = null;
        }
    }

    public Bitmap getBitmap() {
        return this.f3610a;
    }

    public void recycle() {
        Bitmap bitmap = this.f3610a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f3610a.recycle();
        this.f3610a = null;
    }

    public Bundle a() {
        MessageDigest messageDigest;
        if (this.f3610a != null) {
            if (this.b == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(WfConstant.EXTRA_KEY_IMAGE_WIDTH, this.f3610a.getWidth());
                bundle.putInt(WfConstant.EXTRA_KEY_IMAGE_HEIGHT, this.f3610a.getHeight());
                byte[] bArrB = b();
                bundle.putByteArray("image_data", bArrB);
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    messageDigest = null;
                }
                if (messageDigest != null) {
                    messageDigest.update(bArrB, 0, bArrB.length);
                    byte[] bArrDigest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder("");
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toString((b & UByte.MAX_VALUE) + 256, 16).substring(1));
                    }
                    bundle.putString("image_hashcode", sb.toString());
                }
                this.b = bundle;
            }
            return this.b;
        }
        throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
    }
}
