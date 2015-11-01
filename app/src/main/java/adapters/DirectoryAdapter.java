package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nasuapps.nzschools_android_.R;

import java.util.List;

import models.Directory;

/**
 * Created by xzbla on 1/11/2015.
 */
public class DirectoryAdapter extends ArrayAdapter<Directory> {
    public DirectoryAdapter(Context context, int resource, List<Directory> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listview_directory_item, null);

            viewHolder = new ViewHolder();
            viewHolder.SchoolId = (TextView) v.findViewById(R.id.schoolId);
            viewHolder.Name = (TextView) v.findViewById(R.id.schoolName);
            viewHolder.Address = (TextView) v.findViewById(R.id.address);

            v.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Directory p = getItem(position);

        if (p != null) {
            TextView id = viewHolder.SchoolId;
            TextView name = viewHolder.Name;
            TextView address = viewHolder.Address;

            if (id != null) {
                id.setText("" + p.getSchoolId());
            }

            if (name != null) {
                name.setText(p.getName());
            }

            if (address != null)
                address.setText(p.getAddress());
        }

        return v;
    }

    static class ViewHolder
    {
        public TextView SchoolId;
        public TextView Name;
        public TextView Address;
    }
}
