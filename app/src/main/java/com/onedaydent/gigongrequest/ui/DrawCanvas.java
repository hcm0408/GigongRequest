package com.onedaydent.gigongrequest.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.onedaydent.gigongrequest.databinding.DrawlayoutBinding;
import com.onedaydent.gigongrequest.databinding.OptionLayoutBinding;

import java.util.ArrayList;

public class DrawCanvas extends View {

    private static String TAG = DrawCanvas.class.getSimpleName();
    public static final int MODE_PEN = 1;                     //모드 (펜)
    public static final int MODE_ERASER = 0;                  //모드 (지우개)
    final int PEN_SIZE = 3;                                   //펜 사이즈
    final int ERASER_SIZE = 50;                               //지우개 사이즈
    DrawlayoutBinding binding;

    ArrayList<Pen> drawCommandList;                           //그리기 경로가 기록된 리스트
    Paint paint;                                              //펜
    Bitmap loadDrawImage;                                     //호출된 이전 그림
    int color;                                                //현재 펜 색상
    int size;                                                 //현재 펜 크기
    int defaultColor = Color.BLACK;

    public DrawCanvas(Context context) {
        super(context);
        init();
    }

    public DrawCanvas(Context context, Bitmap bitmap) {
        super(context);
        init();
        this.binding = DrawlayoutBinding.inflate(LayoutInflater.from(context));
        loadDrawImage = bitmap;
    }

    public DrawCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * jhChoi - 201124
     * 그리기에 필요한 요소를 초기화 합니다.
     */
    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        drawCommandList = new ArrayList<>();
        loadDrawImage = null;
        color = Color.BLACK;
        size = PEN_SIZE;
    }

    /**
     * jhChoi - 201124
     * 현재까지 그린 그림을 Bitmap으로 반환합니다.
     */
    public Bitmap getCurrentCanvas() {
        Bitmap bitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.draw(canvas);
        return bitmap;
    }

    public void changeColor(int color, int penSize) {
        this.color = color;
        this.size = penSize;
    }

    /**
     * jhChoi - 201124
     * Tool type을 (펜 or 지우개)로 변경합니다.
     * */
    public void changeTool(int toolMode) {
        if (toolMode == MODE_PEN) {
            this.color = this.defaultColor;
            size = PEN_SIZE;
        } else {
            this.defaultColor = this.color;
            this.color = Color.WHITE;
            size = ERASER_SIZE;
        }
        paint.setColor(color);
    }

    public void resetDraw() {
        drawCommandList = new ArrayList<>();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        if (loadDrawImage != null) canvas.drawBitmap(loadDrawImage, 0, 0, null);
        for (int i = 0; i < drawCommandList.size(); i++) {
            Pen p = drawCommandList.get(i);
            paint.setColor(p.color);
            paint.setStrokeWidth(p.size);

            if (p.isMove()) {
                Pen prevP = drawCommandList.get(i - 1);
                canvas.drawLine(prevP.x, prevP.y, p.x, p.y, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(e.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS) {
            int action = e.getAction();
            int state = action == MotionEvent.ACTION_DOWN ? Pen.STATE_START : Pen.STATE_MOVE;
            drawCommandList.add(new Pen(e.getX(), e.getY(), state, color, size));
            invalidate();
        }
        return true;
    }
}
