package com.sample.arch.forbidden.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.sample.arch.forbidden.CanvasActivity;
import com.sample.arch.forbidden.fifteenth.Board;

public class CanvasView extends View {

    private Paint mPaint;
    private Board mBoard;

    public CanvasView(Context context, Board board) {
        super(context);
        init();
        mBoard = board;
    }

    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(0xffff0000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(255,0,255,255);
        //canvas.drawCircle(getWidth()/2,getHeight()/2, 32,mPaint);
        if(mBoard!=null){
            int cellWidth = getWidth() / mBoard.getWidth();
            int cellHeight = getHeight() / mBoard.getHeight();
            for(int i=0;i<mBoard.getWidth();i++){
                canvas.drawCircle(i * cellWidth,0, 32,mPaint);
            }
        }
    }

    public Board getBoard() {
        return mBoard;
    }

    public void setBoard(Board board) {
        mBoard = board;
    }
}
