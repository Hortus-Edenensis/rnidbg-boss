package io.togoto.imagezoomcrop.cropoverlay.edge;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public enum Edge {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM;

    private float mCoordinate;

    public static float getHeight() {
        return BOTTOM.getCoordinate() - TOP.getCoordinate();
    }

    public static float getWidth() {
        return RIGHT.getCoordinate() - LEFT.getCoordinate();
    }

    public float getCoordinate() {
        return this.mCoordinate;
    }

    public void setCoordinate(float f) {
        this.mCoordinate = f;
    }
}
