package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.nasuapps.nzschools_android_.R;

import java.util.ArrayList;

/**
 * Created by xzbla on 25/10/2015.
 */
public class CustomSpinnerAdapter<T> extends BaseAdapter implements SpinnerAdapter {
    ArrayList<T> values;
    Context context;

    public CustomSpinnerAdapter(Context context, ArrayList<T> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) View.inflate(context, R.layout.spinner_row, null);
        textView.setText(values.get(position).toString());
        convertView = textView;

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) View.inflate(context, R.layout.spinner_row_item, null);
        textView.setText(values.get(position).toString());
        convertView = textView;

        return convertView;
    }
}