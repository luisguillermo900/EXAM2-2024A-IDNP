package com.example.exam22024aidnp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ShapeDrawerView extends View {

    private int currentShapeSides = 0;
    private Paint paint;

    public ShapeDrawerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentShapeSides > 2) {
            drawPolygon(canvas, getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 3, currentShapeSides);
        }
    }

    public void drawNextShape() {
        currentShapeSides++;
        invalidate();
    }

    public void resetDrawing() {
        currentShapeSides = 0;
        invalidate();
    }

    private void drawPolygon(Canvas canvas, float cx, float cy, float radius, int sides) {
        if (sides < 3) return;

        Path path = new Path();
        double angleStep = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            float x = (float) (cx + radius * Math.cos(i * angleStep));
            float y = (float) (cy + radius * Math.sin(i * angleStep));
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        path.close();
        canvas.drawPath(path, paint);
    }
}
