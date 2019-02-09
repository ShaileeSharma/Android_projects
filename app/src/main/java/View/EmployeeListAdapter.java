package View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sharma.communicatewithserver.R;

import java.util.List;

import Pojo.EmployeePojo;
import retrofit2.Callback;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListViewHolder> {
    List<EmployeePojo> employeeList;
    Context context;
//    public EmployeeListAdapter(Callback<List<EmployeePojo>> context, List<EmployeePojo> employeeList) {
//        this.employeeList = employeeList;
//        this.context= context;
//    }

    public EmployeeListAdapter(List<EmployeePojo> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull

    @Override
    public EmployeeListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View emp_view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_adapter_layout, null);
        return new EmployeeListViewHolder(emp_view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeListViewHolder holder, int i) {
        EmployeePojo employee = employeeList.get(i);

        holder.tv_name.setText("Name : " + employee.getName());
        holder.tv_address.setText("Address : " + employee.getAddress());
        holder.tv_phone.setText("Phone No : " + employee.getPhoneNumber());
        holder.tv_salary.setText("Salary : " + employee.getSalary());
        holder.tv_designation.setText("Designation : " + employee.getDesignation());

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
