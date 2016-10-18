package com.soar.renderscript;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------------------------------------------
        // 0-2 大小 ,如果这里要是1 -3 当seekbar 滑到 1 获取到的值其实是 1  这时候就要 + 1
        final SettingSeekBar settingSeekBar1 = (SettingSeekBar)findViewById(R.id.settingbar1);
        settingSeekBar1.setOnSettingSeekBarLisenter(new SettingSeekBar.SettingSeekbarLisenter() {
            @Override
            public void onChangeValue(int value) {
            settingSeekBar1.getTextView().setText((value+1)+"");
            }
        });
        settingSeekBar1.setMaxProcess(2);
        settingSeekBar1.setDefaultProcess(1);
        settingSeekBar1.setDefaultValue("2");

        //------------------------------------------------------------------------------
        final SettingSeekBar settingSeekBar2 = (SettingSeekBar)findViewById(R.id.settingbar2);
        settingSeekBar2.setOnSettingSeekBarLisenter(new SettingSeekBar.SettingSeekbarLisenter() {
            @Override
            public void onChangeValue(int value) {
                if(value == 0){
                    settingSeekBar2.getTextView().setText("自动");
                }else{
                    settingSeekBar2.getTextView().setText(value+"");
                }

            }
        });
        settingSeekBar2.setMaxProcess(10);
        settingSeekBar2.setDefaultProcess(0); // 0 对应自动
        settingSeekBar2.setDefaultValue("自动");

        //------------------------------------------------------------------------------
        final SettingSeekBar settingSeekBar3 = (SettingSeekBar)findViewById(R.id.settingbar3);
        settingSeekBar3.setOnSettingSeekBarLisenter(new SettingSeekBar.SettingSeekbarLisenter() {
            @Override
            public void onChangeValue(int value) {
                // -2 到 +2  对应 0-4 -2对应 0   ,  -1  对应1
                settingSeekBar3.getTextView().setText((value - 2)+"");
            }
        });
        settingSeekBar3.setMaxProcess(4);
        settingSeekBar3.setDefaultProcess(2);
        settingSeekBar3.setDefaultValue("0");

        //------------------------------------------------------------------------------
        final SettingSeekBar settingSeekBar4 = (SettingSeekBar)findViewById(R.id.settingbar4);
        settingSeekBar4.setOnSettingSeekBarLisenter(new SettingSeekBar.SettingSeekbarLisenter() {
            @Override
            public void onChangeValue(int value) {
                // 0-2  对应 0 - 4分钟
                settingSeekBar4.getTextView().setText(value*2+"分钟");

            }
        });
        settingSeekBar4.setMaxProcess(2);
        settingSeekBar4.setDefaultProcess(1);
        settingSeekBar4.setDefaultValue("2分钟");

        //------------------------------------------------------------------------------
        final SettingSeekBar settingSeekBar5 = (SettingSeekBar)findViewById(R.id.settingbar5);
        settingSeekBar5.setOnSettingSeekBarLisenter(new SettingSeekBar.SettingSeekbarLisenter() {
            @Override
            public void onChangeValue(int value) {
                // 0- 2 对应 中 低 高
                switch (value){
                    case 0:
                        settingSeekBar5.getTextView().setText("低");
                        break;
                    case 1:
                        settingSeekBar5.getTextView().setText("中");
                        break;
                    case 2:
                        settingSeekBar5.getTextView().setText("高");
                        break;
                }

            }
        });
        settingSeekBar5.setMaxProcess(2);
        settingSeekBar5.setDefaultProcess(1);
        settingSeekBar5.setDefaultValue("中");

        //------------------------------------------------------------------------------


    }
}
