package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.raindrop.FtActivity;

public class FtAdapter extends ArrayAdapter {


    public FtAdapter(@NonNull Context context, int resource, Object countries) {
        super(context, resource);
    }
}
