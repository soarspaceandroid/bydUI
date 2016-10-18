package com.soar.renderscript;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingSeekBar extends LinearLayout {

    private SeekBar mSeekbar;
    private TextView textValue;
    private LinearLayout backgroud;


    public SettingSeekBar(Context context) {
        super(context);
        initView(context);
    }

    public SettingSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SettingSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.setting_seekbar , null);
        mSeekbar = (SeekBar)view.findViewById(R.id.seekbar);
        textValue = (TextView)view.findViewById(R.id.value);
        backgroud = (LinearLayout)view.findViewById(R.id.backgroud);
        addView(view);
    }

    public void setOnSettingSeekBarLisenter(final SettingSeekbarLisenter  settingSeekBarLisenter){
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                settingSeekBarLisenter.onChangeValue(seekBar.getProgress());
                textValue.setTranslationX(getTextViewPosition());
            }
        });
    }


    /**
     * set default process
     * @param defaultProcess
     */
    public void setDefaultProcess(int defaultProcess){
        if(mSeekbar != null){
            mSeekbar.setProgress(defaultProcess);
        }
        backgroud.post(new Runnable() {
            @Override
            public void run() {
                textValue.setTranslationX(getTextViewPosition());
            }
        });

    }


    /**
     * set default value textview display
     * @param value
     */
    public void setDefaultValue(String value){
        textValue.setText(value);
    }


    /**
     * set max process
     * @param maxProcess
     */
    public void setMaxProcess(int maxProcess){
        if(mSeekbar != null){
            mSeekbar.setMax(maxProcess);
        }
    }



    public TextView getTextView(){
        return textValue;
    }


    /**
     * get proceess
     * @return
     */
    public int getProcess(){
        if(mSeekbar != null){
            return mSeekbar.getProgress();
        }
        return 0;
    }


    /**
     *
     */
    private float getTextViewPosition(){
        if(textValue.getText().length() > 2){
            return (float)mSeekbar.getProgress()*backgroud.getWidth()/mSeekbar.getMax()+getResources().getDimension(R.dimen.distance2);
        }else{
            return (float)mSeekbar.getProgress()*backgroud.getWidth()/mSeekbar.getMax()+getResources().getDimension(R.dimen.distance);
        }

    }

    /**
     * interface
     */
    public interface SettingSeekbarLisenter{
        public void onChangeValue(int value);
    }
}
