package dadm.scaffold.counter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import dadm.scaffold.R;
import dadm.scaffold.ScaffoldActivity;

public class EndFragment extends Fragment {

    private static final String ARG_SCORE = "param1";

    private int mScore;
    private View v;

    public EndFragment() {
        // Required empty public constructor
    }

    public static EndFragment newInstance(int param2) {
        EndFragment fragment = new EndFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SCORE, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mScore = getArguments().getInt(ARG_SCORE);
        }
        TextView tcScore = v.findViewById(R.id.Score_int);
        tcScore.setText(mScore);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return v = inflater.inflate(R.layout.fragment_end, container, false);

    }

    public void restart(View view) {
        ((ScaffoldActivity)getActivity()).startGame();
    }

    public void exit() {
        //finish();
    }
}