package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;



import com.example.raindrop.FtActivity;

public class FtAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mCountries;


    public FtAdapter(Context mContext, int simple_list_item_1, String[] countries) {
        this.mContext = mContext;
        this.mCountries = mCountries;
    }

    @Override
    public int getCount() {
        return mCountries.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
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
