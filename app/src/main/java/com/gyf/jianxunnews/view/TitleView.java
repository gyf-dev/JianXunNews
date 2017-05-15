package com.gyf.jianxunnews.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.jianxunnews.R;


/**
 * Created by geyifeng on 2017/4/11.
 */

public class TitleView extends LinearLayout {
    private Context context;
    private ImageView mIconLeft;
    private ImageView mIconRight;
    private TextView mText;

    private final static int DEF_COLOR = 0xFFFFFFFF;
    private final static int DEF_DIMEN = 20;

    public TitleView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleView);
        BitmapDrawable bd_left = (BitmapDrawable) a.getDrawable(R.styleable.TitleView_left_src);
        if (bd_left != null)
            setIconLeft(bd_left.getBitmap());
        BitmapDrawable bd_right = (BitmapDrawable) a.getDrawable(R.styleable.TitleView_right_src);
        if (bd_right != null)
            setIconRight(bd_right.getBitmap());
        String text = a.getString(R.styleable.TitleView_text);
        int color = a.getColor(R.styleable.TitleView_text_color, DEF_COLOR);
        float size = a.getDimension(R.styleable.TitleView_text_size, DEF_DIMEN);
        setText(text);
        setTextColor(color);
        setTextSize(size);
        a.recycle();
    }

    public TitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar_common, null);
        mIconLeft = (ImageView) view.findViewById(R.id.iv_left);
        mIconRight = (ImageView) view.findViewById(R.id.iv_right);
        mText = (TextView) view.findViewById(R.id.tv_middle);
        addView(view);
    }

    public void setIconLeft(Bitmap b) {
        mIconLeft.setImageBitmap(b);
    }

    public void setIconRight(Bitmap b) {
        mIconRight.setImageBitmap(b);
    }

    public void setText(String text) {
        mText.setText(text);
    }

    public void setTextColor(@ColorInt int color) {
        mText.setTextColor(color);
    }

    public void setTextSize(float size) {
        mText.setTextSize(size);
    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        mIconLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLeftClick();
            }
        });
        mIconRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRightClick();
            }
        });
        mText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMiddleClick();
            }
        });
    }


    public interface OnItemClickListener {
        void onLeftClick();

        void onRightClick();

        void onMiddleClick();
    }

}
