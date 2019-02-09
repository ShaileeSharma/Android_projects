package View;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;


import com.example.sharma.communicatewithserver.R;
import com.google.gson.Gson;

import java.util.List;

import Pojo.EmployeePojo;
import Services.ApiClient;
import Services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BasicActivity {
ApiInterface apiInterface;
ProgressBar progressBar;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        getListFromServer();
    }
    private void initializeView() {
        progressBar =findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recyView_EmpList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getListFromServer() {
        progressBar.setVisibility(View.VISIBLE);
   Call<List<EmployeePojo>> employeesCall = apiInterface.getAllEmployee();
   employeesCall.enqueue(new Callback<List<EmployeePojo>>() {
       @Override
       public void onResponse(Call<List<EmployeePojo>> call, Response<List<EmployeePojo>> response) {
           progressBar.setVisibility(View.GONE);
           // to get body from response which get from server end
           List<EmployeePojo> employees = response.body();
           // to retrive data from response body
           // convert data into Gson to Json string formate
           // Gson is library and Json is a way to send and recieve data from server
           String responseJson =new Gson().toJson(employees);
           //toast(responseJson);
         //  showDataOnRecyclerView(employees);
           EmployeeListAdapter emp_adapter=new EmployeeListAdapter(employees);

           //set adapter on recycler view
           recyclerView.setAdapter(emp_adapter);
       }

       @Override
       public void onFailure(Call<List<EmployeePojo>> call, Throwable t) {
           progressBar.setVisibility(View.GONE);
           toast(t.getMessage());
       }
   });

    }

    private void showDataOnRecyclerView(List<EmployeePojo> employees) {


        //createobject of adapter
      //  EmployeeListAdapter emp_adapter=new EmployeeListAdapter(employees);
        //layout manager for orientation
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //set adapter on recycler view
      //  recyclerView.setAdapter(emp_adapter);
    }


}
