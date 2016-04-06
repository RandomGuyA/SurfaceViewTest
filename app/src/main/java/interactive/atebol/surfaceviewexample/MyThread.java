package interactive.atebol.surfaceviewexample;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;


public class MyThread extends Thread{

        boolean mRun;
        Canvas mcanvas;
        SurfaceHolder surfaceHolder;
        Context context;
        SurfacePanel msurfacePanel;

    public MyThread(SurfaceHolder sholder, Context ctx, SurfacePanel spanel) {

        surfaceHolder = sholder;
        context = ctx;
        mRun = false;
        msurfacePanel = spanel;

    }

    @Override
    public void run(){
        super.run();
        while(mRun){

            mcanvas = surfaceHolder.lockCanvas();

            if(mcanvas != null){

                msurfacePanel.doDraw(mcanvas);
                surfaceHolder.unlockCanvasAndPost(mcanvas);
                msurfacePanel.update();
            }

        }
    }

   void setRunning(boolean bRun) {
        mRun = bRun;
   }
}