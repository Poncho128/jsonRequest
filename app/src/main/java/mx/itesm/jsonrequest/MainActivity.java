package mx.itesm.jsonrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity implements AsyncJsonHandler.JSONListener, AdapterView.OnItemClickListener {

    public ListView list_hobbies;
    private JSONArray my_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.list_hobbies = (ListView) findViewById(R.id.friend_list);
        this.list_hobbies.setOnItemClickListener(this);
    }

    public void loadMyAmazingJSON(View view){
        AsyncJsonHandler asyncJsonHandler = new AsyncJsonHandler(this);
        asyncJsonHandler.execute("https://raw.githubusercontent.com/Poncho128/Poncho128.github.io/master/friends.json");
    }


    @Override
    public void requestDone(JSONArray jsonArray) {
        try {
            this.my_json = jsonArray;
            JsonAdapter adapter = new JsonAdapter(jsonArray, this);
            this.list_hobbies.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, i+" CLICKED", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, frends_details.class);

        try {
            intent.putExtra("json_details", this.my_json.getJSONObject(i).toString());
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
