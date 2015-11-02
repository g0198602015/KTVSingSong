package jerome.ktvsingsong;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.EnumSet;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private View mMainView = null;
    private Context mContext = null;

    private EnumSet<SONGClass.SexEnum> mSexEnum = EnumSet.of(SONGClass.SexEnum.NONE);
    private EnumSet<SONGClass.LanguageEnum> mLanguageEnum = EnumSet.of(SONGClass.LanguageEnum.NONE);
    private EnumSet<SONGClass.WordCountEnum> mWordCountEnum = EnumSet.of(SONGClass.WordCountEnum.NONE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EnumSet<SONGClass.LanguageEnum> templanguage = EnumSet.of(SONGClass.LanguageEnum.JAPANESE);
//        templanguage.add(SONGClass.LanguageEnum.CHINESE);
        EnumSet<SONGClass.LanguageEnum> searchLanguage =  EnumSet.of(SONGClass.LanguageEnum.NONE);
        searchLanguage.add(SONGClass.LanguageEnum.CHINESE);
        searchLanguage.add(SONGClass.LanguageEnum.ENGLISH);
       boolean falg  = searchLanguage.contains(templanguage);
        boolean falg2  = searchLanguage.containsAll(templanguage);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMainView = inflater.inflate(R.layout.search_view, null);
        mContext = this;
        final EditText songNameEditText = (EditText)mMainView.findViewById(R.id.searchview_search_songname_EditText);
        Button searchButton = (Button) mMainView.findViewById(R.id.search_view_search_button);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                SONGClass searchCondition = new SONGClass();
                searchCondition.setSex(mSexEnum);
                searchCondition.setLanguage(mLanguageEnum);
                searchCondition.setSongWordCountLimit(mWordCountEnum);
                searchCondition.setSongName(songNameEditText.getText().toString());

                intent.setClass(mContext, SearchResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("searchCondition",searchCondition);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
        final AssetManager assetManager = getAssets();
        new Thread() {
            @Override
            public void run()
            {
                try
                {
                    InputStreamReader csvStreamReader = new InputStreamReader(assetManager.open("song.csv"));
                    jerome.ktvsingsong.util.ParseCSV.parse(csvStreamReader);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start(); //開始執行執行緒
        CheckBox boyCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_boy_checkbox);
        CheckBox girlCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_girl_checkbox);
        boyCheckBox.setOnTouchListener(this);
        girlCheckBox.setOnTouchListener(this);
        //
        CheckBox one2fourCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_one2four_checkbox);
        CheckBox five2eightCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_five2eight_checkbox);
        CheckBox nineupeightCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_nineUP_checkbox);
        one2fourCheckBox.setOnTouchListener(this);
        five2eightCheckBox.setOnTouchListener(this);
        nineupeightCheckBox.setOnTouchListener(this);
        //
        CheckBox chineserCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_chinese_checkbox);
        CheckBox taiwaneseCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_taiwanese_checkbox);
        CheckBox englishCheckBox = (CheckBox)mMainView.findViewById(R.id.searchview_english_checkbox);
        chineserCheckBox.setOnTouchListener(this);
        taiwaneseCheckBox.setOnTouchListener(this);
        englishCheckBox.setOnTouchListener(this);
        //
        setContentView(mMainView);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_UP)
            return false;
        if (v.getId() == R.id.searchview_boy_checkbox)
        {
            if (mSexEnum.contains(SONGClass.SexEnum.FEMALE) )
                mSexEnum.remove(SONGClass.SexEnum.FEMALE);
            else
                mSexEnum.add(SONGClass.SexEnum.FEMALE);
        }
        else if (v.getId() == R.id.searchview_girl_checkbox)
        {
            if (mSexEnum.contains(SONGClass.SexEnum.MALE) )
                mSexEnum.remove(SONGClass.SexEnum.MALE);
            else
                mSexEnum.add(SONGClass.SexEnum.MALE);
        }
        else if (v.getId() == R.id.searchview_one2four_checkbox)
        {
            if (mWordCountEnum.contains(SONGClass.WordCountEnum.ONE2FOUR) )
                mWordCountEnum.remove(SONGClass.WordCountEnum.ONE2FOUR);
            else
                mWordCountEnum.add(SONGClass.WordCountEnum.ONE2FOUR);
        }
        else if (v.getId() == R.id.searchview_five2eight_checkbox)
        {
            if (mWordCountEnum.contains(SONGClass.WordCountEnum.FIVE2EIGHT) )
                mWordCountEnum.remove(SONGClass.WordCountEnum.FIVE2EIGHT);
            else
                mWordCountEnum.add(SONGClass.WordCountEnum.FIVE2EIGHT);
        }
        else if (v.getId() == R.id.searchview_nineUP_checkbox)
        {
            if (mWordCountEnum.contains(SONGClass.WordCountEnum.NINEUP) )
                mWordCountEnum.remove(SONGClass.WordCountEnum.NINEUP);
            else
                mWordCountEnum.add(SONGClass.WordCountEnum.NINEUP);
        }
        else if (v.getId() == R.id.searchview_chinese_checkbox)
        {
            if (mLanguageEnum.contains(SONGClass.LanguageEnum.CHINESE) )
                mLanguageEnum.remove(SONGClass.LanguageEnum.CHINESE);
            else
                mLanguageEnum.add(SONGClass.LanguageEnum.CHINESE);
        }
        else if (v.getId() == R.id.searchview_taiwanese_checkbox)
        {
            if (mLanguageEnum.contains(SONGClass.LanguageEnum.TAIWANESE) )
                mLanguageEnum.remove(SONGClass.LanguageEnum.TAIWANESE);
            else
                mLanguageEnum.add(SONGClass.LanguageEnum.TAIWANESE);
        }
        else if (v.getId() == R.id.searchview_english_checkbox)
        {
            if (mLanguageEnum.contains(SONGClass.LanguageEnum.ENGLISH) )
                mLanguageEnum.remove(SONGClass.LanguageEnum.ENGLISH);
            else
                mLanguageEnum.add(SONGClass.LanguageEnum.ENGLISH);
        }
        return false;
    }
}
