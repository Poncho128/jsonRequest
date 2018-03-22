package mx.itesm.jsonrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity implements AsyncJsonHandler.JSONListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadMyAmazingJSON(View view){
        AsyncJsonHandler asyncJsonHandler = new AsyncJsonHandler(this);
        asyncJsonHandler.execute("https://raw.githubusercontent.com/Poncho128/Poncho128.github.io/master/friends.json");
    }


    @Override
    public void requestDone(JSONArray jsonArray) {

    }
}
