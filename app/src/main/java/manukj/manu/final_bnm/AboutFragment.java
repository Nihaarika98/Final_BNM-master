package manukj.manu.final_bnm;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {
    Activity context;
    TextView about_aarohan;
    public AboutFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        return rootView;
    }

    public void onStart() {

        super.onStart();
        about_aarohan = context.findViewById(R.id.Arohan_About);
        about_aarohan.setText("AAROHAN Signifies the journey of an individual from ignorance towards knowledge thus " +
                "leading to his rise. We deem it a pleasant privilege to present a two day management fest - AAROHAN," +
                "scheduled in the month of April 2018. AAROHAN aims to provide and arena for the battle of Excellence in the field of Management," +
                "the fest includes various events to nurture and challenge the talents of the participants. ");
    }
}
