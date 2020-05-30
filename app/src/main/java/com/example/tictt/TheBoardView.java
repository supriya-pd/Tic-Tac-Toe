package com.example.tictt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class TheBoardView extends View {

    private static final int LINE_THICK=5;
    private static final int ELT_MARGIN=20;
    private static final int ELT_STROKE_WIDTH=15;
    private int width,height,eltW,eltH;
    private Paint gridPaint,oPaint,xPaint;
    private Games object;
    private MainActivity activity;

    public TheBoardView(Context context) {
        super(context);
    }

    public TheBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        gridPaint=new Paint();
        oPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        oPaint.setColor(Color.RED);
        oPaint.setStyle(Paint.Style.STROKE);
        oPaint.setStrokeWidth(ELT_STROKE_WIDTH);
        xPaint=new Paint(oPaint);
        xPaint.setColor(Color.BLUE);

    }
    public void setMainActivity(MainActivity a)
    {
        activity=a;
    }
    public void setGameEngine(Games g){
        object=g;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height=View.MeasureSpec.getSize(heightMeasureSpec);
        width=View.MeasureSpec.getSize(widthMeasureSpec);
        eltW=(width-LINE_THICK)/3;
        eltH=(height-LINE_THICK)/3;
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawGrid(canvas);
        drawBoard(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!object.isGameEnded() && event.getAction()==MotionEvent.ACTION_DOWN){

            int x=(int)(event.getX()/eltW);
            int y=(int)(event.getY()/eltH);
            char win=object.play(x,y);
            invalidate();
            if(win!='\u0000'){
                activity.gameEnded(win);
            }

        }
        return super.onTouchEvent(event);
    }
    public void drawBoard(Canvas canvas)
    {

        for(int i=0;i<3;i++)
        {

            for(int j=0;j<3;j++){

                DrawElit(canvas,object.elements(i,j),i,j);
            }
        }
    }
    private void drawGrid(Canvas canvas){
        for(int i=0;i<2;i++){
            //verticalLines
            float left=eltW*(i+1);
            float right=left+LINE_THICK;
            float top=0;
            float bottom=height;
            canvas.drawRect(left,top,right,bottom,gridPaint);
            //horizontal lines
            float left2=0;
            float right2=width;
            float top2=eltH*(i+1);
            float bottom2=top2+LINE_THICK;
            canvas.drawRect(left2,top2,right2,bottom2,gridPaint);
        }
    }
    private void DrawElit(Canvas canvas,char c,int x,int y){
        if(c=='O')
        {
            float cx=(eltW*x)+eltW/2;
            float cy=(eltH*y)+eltH/2;
            canvas.drawCircle(cx,cy,Math.min(eltW,eltH)/2-ELT_MARGIN*2,oPaint);
        }
        else if(c=='X'){
            float startx = (eltW*x)+ELT_MARGIN;
            float starty=(eltH*y)+ELT_MARGIN;
            float endx=startx+eltW-ELT_MARGIN*2;
            float endy=starty+eltW-ELT_MARGIN;
            canvas.drawLine(startx,starty,endx,endy,xPaint);

            float startx2 = (eltW*(x+1))+ELT_MARGIN;
            float starty2=(eltH*y)+ELT_MARGIN;
            float endx2=startx2-eltW-ELT_MARGIN*2;
            float endy2=starty2+eltW-ELT_MARGIN;
            canvas.drawLine(startx2,starty2,endx2,endy2,xPaint);

        }
    }
}
