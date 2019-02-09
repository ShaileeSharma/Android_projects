package View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sharma.communicatewithserver.R;

public class HomeAcivity extends AppCompatActivity {
    Button btn_all,btn_serach;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_all=findViewById(R.id.btn_all_emp);
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });
        btn_serach=findViewById(R.id.btn_search_emp);
        btn_serach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),SerachEmployeeActivity.class);
                startActivity(i);
            }
        });
    }
}
