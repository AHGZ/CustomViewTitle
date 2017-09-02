package com.hgz.test.customviewtitle.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hgz.test.customviewtitle.R;

/**
 * Created by Administrator on 2017/9/2.
 */

public class Title extends LinearLayout {

    private Button btnLeft;
    private TextView tvTitle;
    private Button btnRight;

    private OnLeftClickListener onLeftClickListener;
    private OnRightClickListener onRightClickListener;

    //设置左边按钮接口
    public interface OnLeftClickListener {
        void OnLeftClick(View view);
    }

    //设置右边按钮接口
    public interface OnRightClickListener {
        void OnRightClick(View view);
    }

    public void setOnLeftClickListener(OnLeftClickListener onLeftClickListener) {
        this.onLeftClickListener = onLeftClickListener;
    }

    public void setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.onRightClickListener = onRightClickListener;
    }

    public Title(Context context) {
        super(context);
        initView(context, null);
    }

    public Title(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);

    }

    private void initView(Context context, @Nullable AttributeSet attrs) {
        View view = inflate(context, R.layout.title_layout, this);
        btnLeft = (Button) view.findViewById(R.id.btnLeft);
        btnRight = (Button) view.findViewById(R.id.btnRight);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        if (attrs == null) {
            return;
        }
        initAttrs(context, attrs);
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onLeftClickListener.OnLeftClick(v);
            }
        });
        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightClickListener.OnRightClick(v);

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                btnRight.setBackgroundColor(0xffff0000);
                btnLeft.setBackgroundColor(0xffff0000);
                break;
            case MotionEvent.ACTION_UP:
                btnRight.setBackgroundColor(0xff3EC5FF);
                btnLeft.setBackgroundColor(0xff3EC5FF);
                break;
        }
        return true;
    }

    private void initAttrs(Context context, @Nullable AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Title);
        String textContent = typedArray.getString(R.styleable.Title_textContent);
        String buttonLeftText = typedArray.getString(R.styleable.Title_buttonLeftText);
        String buttonRightText = typedArray.getString(R.styleable.Title_buttonRightText);
        float textSize = typedArray.getDimension(R.styleable.Title_textSize, 25);
        float buttonLeftTextSize = typedArray.getDimension(R.styleable.Title_buttonLeftTextSize, 25);
        float buttonRightTextSize = typedArray.getDimension(R.styleable.Title_buttonRightTextSize, 25);
        int textColor = typedArray.getColor(R.styleable.Title_textColor, 000000);
        int textBackGround = typedArray.getColor(R.styleable.Title_textBackGround, 000000);
        int buttonLeftTextColor = typedArray.getColor(R.styleable.Title_buttonLeftTextColor, 000000);
        int buttonRightTextColor = typedArray.getColor(R.styleable.Title_buttonRightTextColor, 000000);
        Drawable buttonLeftBackGround = typedArray.getDrawable(R.styleable.Title_buttonLeftBackGround);
        Drawable buttonRightBackGround = typedArray.getDrawable(R.styleable.Title_buttonRightBackGround);
        btnLeft.setText(buttonLeftText);
        btnLeft.setTextColor(buttonLeftTextColor);

        btnLeft.setTextSize(buttonLeftTextSize);
        tvTitle.setText(textContent);
        tvTitle.setTextSize(textSize);
        tvTitle.setTextColor(textColor);
        tvTitle.setBackgroundColor(textBackGround);
        btnRight.setText(buttonRightText);
        btnRight.setTextSize(buttonRightTextSize);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            btnLeft.setBackground(buttonLeftBackGround);
            btnRight.setBackground(buttonRightBackGround);
        }
        btnRight.setTextColor(buttonRightTextColor);
    }
}
