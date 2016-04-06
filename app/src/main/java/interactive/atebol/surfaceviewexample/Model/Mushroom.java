package interactive.atebol.surfaceviewexample.Model;

import android.graphics.Bitmap;

import interactive.atebol.surfaceviewexample.helpers.Helper;

public class Mushroom {

    Bitmap bitmap;
    float x,y, dx,dy;

    public Mushroom(Bitmap bitmap, float x, float y, float dx, float dy) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }
}
