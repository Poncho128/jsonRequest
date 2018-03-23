package mx.itesm.jsonrequest;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;

/**
 * Created by ASUS on 22/03/2018.
 */

public class JsonAdapter extends BaseAdapter{

    private JSONArray json;
    private Activity activity;

    public JsonAdapter(JSONArray json, Activity activity){
        this.json=json;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return this.json.length();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = activity.getLayoutInflater().inflate(R.layout.frends_no_details, null);
        }

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView hobby = (TextView) view.findViewById(R.id.hobby);

        try {
            name.setText(this.json.getJSONObject(i).getString("name"));
            hobby.setText(this.json.getJSONObject(i).getString("hobby"));
        } catch(Exception e) {
            name.setText("Name");
            hobby.setText("Hobby");
        }

        return view;
    }
}
