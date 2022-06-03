package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;



import com.example.raindrop.FtActivity;

public class FtAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mCountries;
    private String[] mLeagues;


    public FtAdapter(Context mContext, int simple_list_item_1, String[] countries) {
        super(mContext, simple_list_item_1, countries);
        this.mContext = mContext;
        this.mCountries = mCountries;
        this.mLeagues = mLeagues;
    }



    @Override
    public Object getItem(int position) {
        String country = mCountries[position];
        String league = mLeagues[position];
        return String.format("%s \nGreat football leagues: %s", country, league);
    }

    @Override
    public int getCount() {
        return mCountries.length;
    }
}
