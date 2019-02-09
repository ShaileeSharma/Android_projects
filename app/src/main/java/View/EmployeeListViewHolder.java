package View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sharma.communicatewithserver.R;

public class EmployeeListViewHolder extends RecyclerView.ViewHolder {
    TextView tv_name,tv_address,tv_phone,tv_salary,tv_designation;
    public EmployeeListViewHolder(@NonNull View itemView) {
        super(itemView);
       tv_name=itemView.findViewById(R.id.tv_emp_name);
        tv_address=itemView.findViewById(R.id.tv_emp_address);
        tv_phone=itemView.findViewById(R.id.tv_emp_phone_num);
        tv_salary=itemView.findViewById(R.id.tv_emp_salary);
        tv_designation=itemView.findViewById(R.id.tv_emp_designation);
    }


}
