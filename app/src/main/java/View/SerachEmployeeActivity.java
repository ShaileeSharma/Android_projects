package View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sharma.communicatewithserver.R;

import Pojo.EmployeePojo;
import Services.ApiClient;
import Services.ApiInterface;
import retrofit2.Callback;
import retrofit2.Response;

public class SerachEmployeeActivity extends BasicActivity {
    EditText edt_empId;
    TextView tv_name,tv_address,tv_phone,tv_salary,tv_designation;
    Button btn_find,btn_clear;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
iitialization();
    }

    private void iitialization() {
        edt_empId=findViewById(R.id.edt_emp_id);
        btn_find=findViewById(R.id.btn_find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String empId=edt_empId.getText().toString();
                searchEmployee(empId);
            }
        });
        tv_name =findViewById(R.id.tv_emp_name);
        tv_address=findViewById(R.id.tv_emp_address);
        tv_phone=findViewById(R.id.tv_emp_phone_num);
        tv_salary=findViewById(R.id.tv_emp_salary);
        tv_designation=findViewById(R.id.tv_emp_designation);
        btn_clear=findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            tv_name.setText("");
            tv_address.setText("");

            }
        });

    }

    public void searchEmployee(final String empId){
         retrofit2.Call<EmployeePojo> call =apiInterface.findEmployee(empId);
         call.enqueue(new Callback<EmployeePojo>() {
             @Override
             public void onResponse(retrofit2.Call<EmployeePojo> call, Response<EmployeePojo> response) {
                 EmployeePojo employee=response.body();
                 toast("Record found");
                 showDataOnScreen(employee);
             }

             @Override
             public void onFailure(retrofit2.Call<EmployeePojo> call, Throwable t) {
toast(t.getMessage());
             }
         });
     }

    private void showDataOnScreen(EmployeePojo employee) {
        if (employee !=null){
            tv_name.setText(employee.getName());
            tv_address.setText(employee.getAddress());
        } else
        {
            toast(" no data available here");
        }

    }
}
