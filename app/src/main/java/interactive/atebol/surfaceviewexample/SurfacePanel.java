package interactive.atebol.surfaceviewexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import interactive.atebol.surfaceviewexample.Model.Mushroom;
import interactive.atebol.surfaceviewexample.helpers.Helper;

public class SurfacePanel extends SurfaceView implements SurfaceHolder.Callback{

    MyThread mythread;
    Context context;
    Mushroom mushroom;

    public SurfacePanel(Context context, AttributeSet attrSet) {
        super(context, attrSet);

        float x= 100, y=100;

        Bitmap mbitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.mushroom);

        float dx = Helper.getInstance().dpFromPx(context, x);
        float dy = Helper.getInstance().dpFromPx(context, y);
        mushroom = new Mushroom(mbitmap, x, y, dx, dy);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

    }

    @Override

    public void surfaceCreated(SurfaceHolder holder){
        mythread = new MyThread(holder, context,this);
        mythread.setRunning(true);
        mythread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    public void update(){
        mushroom.setDx(mushroom.getDx()+10);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        mythread.setRunning(false);
        boolean retry = true;
        while(retry){
            try{
                mythread.join();
                retry = false;
            }
            catch(Exception e){
                Log.v("Exception Occured", e.getMessage());
            }
        }
    }

    void doDraw(Canvas canvas){
        canvas.drawColor(Color.GREEN);
        canvas.drawBitmap(mushroom.getBitmap(), mushroom.getDx(),mushroom.getDy(),null);
    }
}
