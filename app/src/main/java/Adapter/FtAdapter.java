package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;



import com.example.raindrop.FtActivity;

public class FtAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mCountries;
    private String[] mLeagues;


    public FtAdapter(Context mContext, int simple_list_item_1, String[] countries) {
        this.mContext = mContext;
        this.mCountries = mCountries;
        this.mLeagues = mLeagues;
    }



    @Override
    public int getCount() {
        return mCountries.length;
    }

    @Override
    public Object getItem(int position) {
        String country = mCountries[position];
        String league = mLeagues[position];
        return String.format("%s \nGreat football leagues: %s", country, league);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return convertView;
    }
}
