package jerome.ktvsingsong;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Jerome on 2015/9/3.
 */

public class SearchResultListviewAdapter extends BaseAdapter
{
    private LayoutInflater myInflater;
    private Context mContext;
    private List<SONGClass> mSongClassList;
    public SearchResultListviewAdapter(Context context, List<SONGClass> songClassesList)
    {
        mContext = context;
        mSongClassList = songClassesList;
        myInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
//        return mDatas.getChildSize()+1;
        return mSongClassList.size();
    }

    @Override
    public Object getItem(int position)
    {
//        return mDatas.getChild(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View containView, ViewGroup parent)
    {
        if(containView == null)
        {
            containView = myInflater.inflate(R.layout.search_result_list_view_item, null);
        }
        SONGClass songClass = mSongClassList.get(position);
        TextView info = (TextView)containView.findViewById(R.id.search_result_listview_item_song_info);
        info.setText(songClass.getSongName());
//        MDS, // 弘音
//                GOLD_ENVOICE, //金嗓
//                INYUAN; //音圓
        TextView numberTextView = (TextView)containView.findViewById(R.id.search_result_listview_item_song_number);
        String number = "";
        if (songClass.getGoldEnvoiceNumber() != null && songClass.getGoldEnvoiceNumber().length() > 0)
            number = "金嗓"+songClass.getGoldEnvoiceNumber();
        if (songClass.getMDSNumber() != null && songClass.getMDSNumber().length() > 0)
        {
            if (number.length() > 0)
                number = number + "\n";
            number = number + "弘音" + songClass.getMDSNumber();
        }
        if (songClass.getInyuanNumber() != null && songClass.getInyuanNumber().length() > 0)
        {
            if (number.length() > 0)
                number = number + "\n";
            number = number + "音圓"+songClass.getInyuanNumber();
        }
        numberTextView.setText(number);
//        number.setText(mSongClassList.get(position).get());
        return containView;
    }
}
