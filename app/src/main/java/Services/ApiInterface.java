package Services;

import java.util.List;

import Pojo.EmployeePojo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    //call get api
    @GET("myapp/api/employees")
    //get employee list
    public Call<List<EmployeePojo>> getAllEmployee();
    @GET("myapp/api/employees/{employeeId}")
    //get perticular employee from list
    public Call<EmployeePojo> findEmployee(@Path("employeeId") String employeeId);
}
