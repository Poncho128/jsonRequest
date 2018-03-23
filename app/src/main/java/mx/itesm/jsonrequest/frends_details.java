package mx.itesm.jsonrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

public class frends_details extends AppCompatActivity {

    private JSONObject my_json;
    private TextView name, hobby, age, phone, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frends_details);

        this.name = (TextView) findViewById(R.id.name);
        this.hobby = (TextView) findViewById(R.id.hobby);
        this.age = (TextView) findViewById(R.id.age);
        this.phone = (TextView) findViewById(R.id.phone);
        this.address = (TextView) findViewById(R.id.address);


        Intent intent = getIntent();
        try {
            this.my_json = new JSONObject(intent.getStringExtra("json_details"));
            this.name.setText(this.my_json.getString("name"));
            this.hobby.setText(this.my_json.getString("hobby"));
            this.age.setText(this.my_json.getString("age"));
            this.phone.setText(this.my_json.getString("phone"));
            this.address.setText(this.my_json.getString("address"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
