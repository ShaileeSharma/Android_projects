package View;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class BasicActivity extends AppCompatActivity {

    protected void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
