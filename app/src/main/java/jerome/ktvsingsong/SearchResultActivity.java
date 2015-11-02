package jerome.ktvsingsong;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.EnumSet;
import java.util.List;

public class SearchResultActivity extends Activity {

    private SearchResultListviewAdapter mListViewAdapter = null;
    private ListView mListView = null;
    private View mMainView = null;
//    private EnumSet<SONGClass.ManufactureEnum> mManufactureEnum = EnumSet.of(SONGClass.ManufactureEnum.NONE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMainView = inflater.inflate(R.layout.search_result_activity, null);


        Bundle bundle = getIntent().getExtras();
        SONGClass searchCondition = (SONGClass)bundle.getSerializable("searchCondition");
        List<SONGClass> result = SONGList.searchSong(searchCondition);
        mListViewAdapter = new SearchResultListviewAdapter(this, result);
        mListView = (ListView)mMainView.findViewById(R.id.listView);
        mListView.setAdapter(mListViewAdapter);

        setContentView(mMainView);
    }


}
