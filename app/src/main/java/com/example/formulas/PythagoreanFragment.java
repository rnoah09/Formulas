package com.example.formulas;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class PythagoreanFragment extends Fragment {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private TextView textViewAnswer;
    private Button buttonSolve;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pythagorean, container, false);

        setListeners();
        wireWidgets(rootView);

        return rootView;
    }

    public void wireWidgets(View rootView){

        editTextA = rootView.findViewById(R.id.edittext_pythag_a);
        editTextC = rootView.findViewById(R.id.edittext_pythag_b);
        editTextC = rootView.findViewById(R.id.edittext_pythag_c);
        textViewAnswer = rootView.findViewById(R.id.textview_pythag_answer);
        buttonSolve = rootView.findViewById(R.id.button_pythag_solve);

    }

    public void setListeners(){
        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!TextUtils.isEmpty(editTextA.getText()) && !TextUtils.isEmpty(editTextB.getText())){
                    double a = Integer.parseInt(editTextA.getText().toString());
                    double b = Integer.parseInt(editTextB.getText().toString());
                    double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
                    textViewAnswer.setText("A = " + a + "\nB = " + b + "\nC = " + c);
                }
                else if (!TextUtils.isEmpty(editTextA.getText()) && !TextUtils.isEmpty(editTextC.getText())){
                    double a = Integer.parseInt(editTextA.getText().toString());
                    double c = Integer.parseInt(editTextC.getText().toString());
                    double b = Math.sqrt(Math.pow(c,2) - Math.pow(a,2));
                    textViewAnswer.setText("A = " + a + "\nB = " + b + "\nC = " + c);
                }
                else if (!TextUtils.isEmpty(editTextB.getText()) && !TextUtils.isEmpty(editTextC.getText())){
                    double b = Integer.parseInt(editTextB.getText().toString());
                    double c = Integer.parseInt(editTextC.getText().toString());
                    double a = Math.sqrt(Math.pow(c,2) - Math.pow(b,2));
                    textViewAnswer.setText("A = " + a + "\nB = " + b + "\nC = " + c);
                }
                else{
                    Toast.makeText(getContext(), "Please enter 2 values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
