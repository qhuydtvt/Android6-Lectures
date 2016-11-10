package techkids.vn.listviewintro.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import techkids.vn.listviewintro.R;
import techkids.vn.listviewintro.models.Student;

import static techkids.vn.listviewintro.models.Student.OP_UPDATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private Student student;
    private int operation;

    private EditText etName;
    private EditText etGender;
    private EditText etAge;
    private Button btSave;

    private OnStudentUpdateListener onStudentUpdateListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public void setOnStudentUpdateListener(OnStudentUpdateListener onStudentUpdateListener) {
        this.onStudentUpdateListener = onStudentUpdateListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        getReferences(view);
        setupUI();
        addListeners();

        return view;

    }

    public static DetailFragment create(Student student, int operation) {
        // 1: Create fragment
        DetailFragment detailFragment = new DetailFragment();

        // 2: (Optional) pass arguments
        detailFragment.setStudent(student);
        detailFragment.setOperation(operation);

        return detailFragment;
    }

    private void addListeners() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation == OP_UPDATE) {
                    student.setName(etName.getText().toString());
                    student.setGender(etGender.getText().toString());
                    String ageString = etAge.getText().toString();
                    student.setAge(Integer.parseInt(ageString));

                    if(onStudentUpdateListener != null) {
                        onStudentUpdateListener.onUpdate();
                    }
//                    getActivity().finish();
                }
            }
        });
    }

    private void setupUI() {
        etName.setText(student.getName());
        etGender.setText(student.getGender());
        etAge.setText(String.format("%s", student.getAge()));
    }

    private void getReferences(View view) {
        etName = (EditText) view.findViewById(R.id.tv_name);
        etGender = (EditText) view.findViewById(R.id.tv_gender);
        etAge = (EditText) view.findViewById(R.id.tv_age);
        btSave = (Button) view.findViewById(R.id.bt_save);
    }


}
